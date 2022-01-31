public class Main {

    public static void main(String[] args) {

        Vertice a = new Vertice("A");
        Vertice b = new Vertice("B");
        Vertice c = new Vertice("C");

        a.addVizinhos("B", "C");

        a.addVizinhos(b,c);

        a.getVizinhos();

    }
}
