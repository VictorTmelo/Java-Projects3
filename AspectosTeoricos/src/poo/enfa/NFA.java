package poo.enfa;

import java.util.HashSet;
import java.util.Set;

public class NFA {
    // NFA = (Q, Σ, δ, q0, F)
    protected State q;

    public NFA(State q) {
        this.q = q;
    }
    public boolean run(String w) {

        Set<State> qs = this.q.states(null);
        qs.add(q);

        return run(w, 0, qs);
    }

    private boolean run(String w, int k, Set<State> states) {

        while (k < w.length()){

            draw(w, k, states);

            char ch = w.charAt(k);

            Set<State> newStates = new HashSet<State>();

            for (State i : states){

                newStates = State.merge(newStates, i.states(ch));

                newStates = State.merge(newStates, i.states(null));

            }

            states =  newStates;

            if(states.size() == 0)
                break;

            k++;
        }

        draw(w ,k, states);
        return valid(states);
    }

    private void draw(String w, int k, Set<State> qs) {

        System.out.print(w.substring(0,  k) + "{");

        for(State s : qs)
            System.out.format(" %s ", s.getName());

        System.out.println("}"+w.substring(k));

    }

    private boolean valid(Set<State> qs) {

        if (qs == null || qs.size() == 0)
            return false;


        for (State i : qs){

            if (i.getFinal())
                return true;
        }

        return false;
    }
}
