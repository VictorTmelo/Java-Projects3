
package AFD;


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

    public State addTransition(State target, Character r, Character w, Character direction) {

        return addTransition(target, Edge.instance(r,w, direction));
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

    public Transition transition(Character r){

        for (Transition t : transitions) {

            Edge e = t.getEdge();

            if (e.getR() != null && e.getR().equals(r))
                return t;
        }
        return null;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}

