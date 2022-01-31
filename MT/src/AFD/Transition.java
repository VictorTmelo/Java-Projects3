
package AFD;

import java.util.Objects;

public class Transition {

    private final State state;
    private final Edge edge;

    public Transition(final State s, final Edge e){
        this.state = s;
        this.edge = e;
    }

    public Edge getEdge() {
        return edge;
    }

    public State getState() {

        return state;
    }

    @Override
    public String toString() {
        return edge + "-->" + state.getName();
    }
}

