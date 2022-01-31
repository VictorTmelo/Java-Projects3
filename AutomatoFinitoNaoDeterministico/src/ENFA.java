/*
 * L = {w in Σ^* | w vazio ou começa e possui intercalação de zeros}
 */
public class ENFA {
    private static int[] F = {0};
    private static int q0 = 0;
    private static int[][][] table = {  //0    1    2
            {{1}, {},  {}},  // q0
            {{} , {2}, {2}},  // q1
            {{} , {},  {}}   // q2
    };
    // q0  q1   q2
    private static int[][] eTransitions = {{}, {0}, {0}};

    public static void run() {
        String w = "010200102";
        enfa(w);
    }

    private static void enfa(String w) {
        int k = 0;
        int[] states = eclose(new int[] {q0});
        while(k < w.length()) {
            Util.log(w,  states, k);
            int e = Integer.parseInt(w.substring(k, k+1));

            int[] newStates = new int[] {};
            for(int i: states) {
                int[] targets = table[i][e];
                newStates = Util.merge(newStates, targets);
                newStates = eclose(newStates);
            }
            states = newStates;
            if(states.length == 0) break;
            k++;
        }
        Util.log(w, states, k);
        if(Util.valid(states, F))
            System.out.println("Aceitou");
        else
            System.out.println("Rejeitou");
    }

    private static int[] eclose(int[] states) {
        int[] r = states;
        for(int i: states) {
            int[] aux1 = eTransitions[i];
            int[] aux2 = eclose(aux1);
            r = Util.merge(r, aux1);
            r = Util.merge(r, aux2);
        }
        return r;
    }
}