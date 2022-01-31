import java.util.ArrayList;

public class Vertice {

    private String nome;
    private ArrayList<Aresta> vizinhos = new ArrayList<>();

    public Vertice(String nome){
        this.nome = nome;
    }

    public void addVizinhos(Vertice ...destino) {

        for (Vertice v : destino) {

            Aresta aresta = new Aresta(v);

            boolean x = true;

            for (int i = 0; i < vizinhos.size(); i++){
                if(vizinhos.get(i).getVertice().nome == v.nome)
                    x = false;
            }

            if(vizinhos.contains(aresta)){
                x = false;
            }

            if(x){
                vizinhos.add(aresta);
            }

        }

    }

    public void addVizinhos(String ...s) {

        for (String nome : s) {

            Vertice v = new Vertice(nome);

            Aresta aresta = new Aresta(v);

            boolean x = true;

            for (int i = 0; i < vizinhos.size(); i++){
                if(vizinhos.get(i).getVertice().nome == nome)
                    x = false;
            }

            if(vizinhos.contains(aresta)){
                x = false;
            }

            if(x){
                vizinhos.add(aresta);
            }

        }

    }

    public void getVizinhos(){

        for(Aresta a : vizinhos){
            System.out.print(a.getVertice().nome + " ");
        }
    }

}
