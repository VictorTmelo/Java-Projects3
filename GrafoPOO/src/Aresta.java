public class Aresta {

    private Vertice vertice;
    private Peso peso;

    public Aresta(final Vertice v, final Peso p){
        this.vertice = v;
        this.peso = p;
    }

    public Aresta(final Vertice v){
        this.vertice = v;
    }

    public Peso getPeso() {
        return peso;
    }

    public Vertice getVertice() {

        return vertice;
    }

}
