package nfa_enfa;

/*
 * L = { w in Σ^* | w termina com 01 }
 */
public class NFA {
    static int[] F = {2}; //ESTADOS FINAIS
    static int q = 0;
    static int[][][] table = {{{0,1},{0}, {}},
            {{   },{2}, {}},
            {{   },{ }, {}}};
    public static void run() {
        String w = "10010110101101"; //PALAVRA
        int k = 0;
        int[] states = {q};

        while(k < w.length()) {
            Util.log(w, states, k);
            int e = Integer.parseInt(w.substring(k, k+1));
            int[] new_states = new int[] {};
            for(int i: states) {
                int[] transitions = table[i][e];
                new_states = Util.merge(new_states, transitions);
            }
            states = new_states;
            if(states.length==0) break;
            k++;
        }
        Util.log(w, states, k);
        if(Util.valid(states, F))
            System.out.println("Aceitou");
        else
            System.out.println("Rejeitou");
    }
}
