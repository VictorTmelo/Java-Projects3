
public class Main {

    /* L = {w in Σ^* | w.len ou |w| é par ou vazio}
     * Σ = {a,b}
     * F = {0}
     * q0 = 0
     * δ  = δ(0, a)=1, δ(0, b)=1,
     *      δ(1, a)=0, δ(1, b)=0
     * Q = {0,1}
     * A = (Q, Σ, δ, q0, F)
     */

    public static void main(String[] args) throws Exception {

        System.out.println("Processando linguagem L");

        int[][] M = {
                //   0  1
                //   a  b
                {1, 1}, // q0
                {0, 0}  // q1
        };

        int[] F = {0};

        String w = "bbab";

        AFD afd = new AFD(2, "ab", F, M);

        valid(afd.run(w), w);

    }

    public static void valid(boolean b, String w) {

        if(b) {

            System.out.println("Reconheceu: " + w);
            return;
        }
        System.out.println("Não reconheceu: " + w);
    }
}
