
package AFD;

import java.util.Objects;

public class Edge {

    private Character r;
    private Character w;
    private Character direction;

    public Edge(Character r, Character w, Character direction) {

        this.r = r;
        this.w = w;
        this.direction = direction;
    }

    public Character getR() {
        return r;
    }

    public Character getW() {
        return w;
    }

    public Character getDirection() {
        return direction;
    }

    public static Edge instance(Character _c, Character w, Character direction){
        return new Edge(_c, w, direction);
    }

    @Override
    public String toString() {
        return "Edge{r = "+ this.r + " w = " + this.w + " direction = " + this.direction;
    }
    
}

