import java.util.ArrayList;
import java.util.List;

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

    public State addTransition(State target, Edge ...edges){

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

    public Transition transition(Character _c){

        for (Transition t : transitions) {

            Edge e = t.getEdge();

            if (e.getC() != null && e.getC().equals(_c))
                return t;
        }
        return null;
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
