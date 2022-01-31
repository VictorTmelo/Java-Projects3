package Linguagens;

import Principal.State;
import Principal.Util;
import java.util.Arrays;
import java.util.List;
import pda.automata.IPDA;
import pda.automata.IState;
import pda.automata.lib.PDA;

public class Identificadores {

    public static IState q0 = new State("q0");
    public static IState q1 = new State("q1");
    public static IState q2 = new State("q2");
    public static IState q3 = new State("q3");
    public static IState q4 = new State("q4");
    public static IState q5 = new State("q5");
    public static IState q6 = new State("q6");
    public static IState q7 = new State("q7");
    public static IState q8 = new State("q8");
    public static IState q12 = new State("q12");
    public static IState q13 = new State("q13");
    public static IState q14 = new State("q14");
    public static IState q15 = new State("q15");
    public static IState q16 = new State("q16");
    public static IState q17 = new State("q17");
    public static IState q17s = new State("q17s");
    public static IState q18 = new State("q18");
    public static IState q18s = new State("q18s");
    public static IState q19 = new State("q19");
    public static IState q20 = new State("q20");
    public static IState q20s = new State("q20s");
    public static IState q21 = new State("q21");
    public static IState q22 = new State("q22");
    public static IState q23 = new State("q23");
    public static IState q24 = new State("q24");
    public static IState q25 = new State("q25");
    public static IState q26 = new State("q26");
    public static IState q27 = new State("q27");
    public static IState q28 = new State("q28");
    public static IState q29 = new State("q29");
    public static IState q29s = new State("q29s");

    public static void cria() {
        char[] sigma = "abcdefghijklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] num = "0123456789".toCharArray();
        char space = ' ';

        q14.setFinal();

        List<IState> qs = Arrays.asList(q0, q1, q2, q3, q4, q5, q6, q7, q8, q12, q13, q14, q15, q16, q17, q18, q19, q20, q21, q22, q23, q24, q25, q26, q27, q28, q29);

        // CAMINHO BOOLEANO
        q0.addTransition(q1, null, null, '$');
        q1.addTransition(q3, 'b', null, null);
        q3.addTransition(q4, 'o', null, null);
        q4.addTransition(q7, 'o', null, null);
        q7.addTransition(q8, 'l', null, null);
        q8.addTransition(q15, space, null, null);

        for (char c : sigma) {
            q15.addTransition(q18, c, null, null);
            q18.addTransition(q18, c, null, null);
        }

        q18.addTransition(q19, ';', null, null);

        q18.addTransition(q20, '=', null, null);
        q18.addTransition(q18s, space, null, null);
        q18s.addTransition(q18s, space, null, null);

        q18s.addTransition(q20, '=', null, null);
        q20.addTransition(q20s, space, null, null);
        q20s.addTransition(q20s, space, null, null);

        // FALSE
        q20s.addTransition(q22, 'f', null, null);
        q20.addTransition(q22, 'f', null, null);
        q22.addTransition(q25, 'a', null, null);
        q25.addTransition(q26, 'l', null, null);
        q26.addTransition(q27, 's', null, null);
        q27.addTransition(q28, 'e', null, null);

        // TRUE
        q20s.addTransition(q21, 't', null, null);
        q20.addTransition(q21, 't', null, null);
        q21.addTransition(q23, 'r', null, null);
        q23.addTransition(q24, 'u', null, null);
        q24.addTransition(q28, 'e', null, null);

        q28.addTransition(q19, ';', null, null);
        q19.addTransition(q3, 'b', null, null);

        // CAMINHO INTEIRO
        q19.addTransition(q2, 'i', null, null);
        q1.addTransition(q2, 'i', null, null);
        q2.addTransition(q5, 'n', null, null);
        q5.addTransition(q6, 't', null, null);
        q6.addTransition(q13, space, null, null);

        for (char c : sigma) {
            q13.addTransition(q29, c, null, null);
            q29.addTransition(q29, c, null, null);
        }

        //q29.addTransition(q29, space, null, null);
        q29.addTransition(q29s, space, null, null);

        q29.addTransition(q12, ';', null, null);

        q29.addTransition(q17, '=', null, null);
        q29s.addTransition(q17, '=', null, null);

        for (char n : num) {
            q17.addTransition(q16, n, null, null);
            q16.addTransition(q16, n, null, null);
            q18.addTransition(q18, n, null, null);
            q29.addTransition(q29, n, null, null);
            q17s.addTransition(q16, n, null, null);
        }

        q17.addTransition(q17s, space, null, null);
        q17s.addTransition(q17s, space, null, null);

        q16.addTransition(q12, ';', null, null);

        q12.addTransition(q2, 'i', null, null);

        q12.addTransition(q3, 'b', null, null);

        // FINALIZA TIRANDO O $
        q12.addTransition(q14, null, '$', null);

        q19.addTransition(q14, null, '$', null);

        // ESPAÇOS
        q12.addTransition(q12, space, null, null);
        q19.addTransition(q19, space, null, null);
        q12.addTransition(q12, space, null, null);
        q19.addTransition(q19, space, null, null);

        // PULAR LINHA
        q12.addTransition(q12, '\n', null, null);
        q19.addTransition(q19, '\n', null, null);
        q12.addTransition(q12, '\r', null, null);
        q19.addTransition(q19, '\r', null, null);

        /*for (IState s : qs) {
            s.addTransition(s, '\n', null, null);
            s.addTransition(s, '\r', null, null);
        }*/
    }

    public static void process(String w) throws Exception {
        cria();
        IPDA pda = new PDA(q0);
        pda.makeLog();
        Util.checkout(pda.run(w), w);
        System.out.println("*****************************");
    }

}
