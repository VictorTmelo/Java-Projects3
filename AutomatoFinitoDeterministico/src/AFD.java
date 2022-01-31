import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AFD { // A = (Q, Σ, δ, q0, F)

    protected int q = 0;
    protected Set<Integer> Q = new HashSet<Integer>();
    protected Set<Integer> F = new HashSet<Integer>();
    protected Map<Character, Integer> sigma = new HashMap<Character, Integer>();
    protected int[][] table = null;


    public AFD(int nStates, String simbolos, int[] F, int[][] M) throws Exception {
        setQ(nStates);
        setSigma(simbolos);
        setF(F);
        table = new int[Q.size()][sigma.size()];
        setTable(M);
    }
    public boolean run(String w) {

        //char simbolos[] = w.toCharArray();

        for (char c : w.toCharArray()) {

           q = table[q][sigma.get(c)];

        }

        return F.contains(q);

    }

    private void setTable(int[][] M) throws Exception {
        if(M.length!=Q.size() || M[0].length!=sigma.size())
            throw new Exception("Configuracao de tabela inadequada!!");
        for(int i = 0; i < M.length; i++)
            for(int j = 0; j < M[0].length; j++)
                table[i][j] = M[i][j];
    }
    private void setF(int ..._F) throws Exception {
        for(int i = 0; i < _F.length; i++) {
            if(!this.F.contains(_F[i])) {
                this.F.add(_F[i]); // _F[i] se nao pertence a Q, lancar exception
                if(!Q.contains(_F[i]))
                    throw new Exception("Algum estado em F nao esta em Q");
            }
        }
    }
    private void setSigma(String simbolos) {
        char[] chs = simbolos.toCharArray();
        int i = 0;
        for (char c : chs) {
            sigma.put(c, i++);
        }
    }
    private void setQ(int nStates) {
        for(int i = 0; i < nStates; i++)
            if(!Q.contains(i))
                Q.add(i);
    }

}
