import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class State {

    private static int ID = 0;
    private int id;
    private final String name;
    private boolean isFinal = false;
    private final List<Transition> transitions = new ArrayList<>();

    public State(Boolean isFinal){

        this.id = ID++;
        this.name = "q" + id;
        this.isFinal = isFinal;

    }

    public State(String name){

        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public void setFinal() {

        this.isFinal = true;
    }

    public boolean getFinal() {

        return this.isFinal;
    }

    public State addTransition(State target, Character c) {

        return addTransition(target, Edge.instance(c));
    }

    private State addTransition(State target, Edge ...edges){

        for (Edge e : edges){
            Transition transition = new Transition(target, e);

            //CHECA SE JA EXISTE ESSA TRANSIÇÃO.
            if(transitions.contains(transition)){
                continue;
            }
            transitions.add(transition);
        }
        return this;
    }

    public Set<State> states(Character _c){

        Set<State> r = new HashSet<State>();

        for (Transition t : transitions) {

            Edge e = t.getEdge();

            boolean a = (_c == null && e.getC() == null);
            boolean b = (e.getC() != null && e.getC().equals(_c));

            if (a || b)
                r.add(t.getState());


        }
        return r;
    }

    public static Set<State> merge(Set<State> a, Set<State> b) {

        Set<State>r = new HashSet<State>();

        for (State s : a)
            if(!r.contains(s))
                r.add(s);

        for (State s : b)
            if(!r.contains(s))
                r.add(s);

        return r;

    }

    public static Set<State> eclose(Set<State> estados) {

        Set<State> r = merge(new HashSet<State>(), estados);
        for(State i: estados){
            Set<State> aux1 = i.states(null);
            Set<State> aux2 = eclose(aux1);
            r = merge(r, aux1);
            r = merge(r, aux2);
        }
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof State) {
            State s = (State) o;
            return s.getName().equals(this.getName());
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}
