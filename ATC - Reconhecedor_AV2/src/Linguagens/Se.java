package Linguagens;

import static Linguagens.For.cria;
import static Linguagens.For.q0;
import Principal.State;
import Principal.Util;
import java.util.Arrays;
import java.util.List;
import pda.automata.IPDA;
import pda.automata.IState;
import pda.automata.lib.PDA;

public class Se {

    public static IState q0 = new State("q0");
    public static IState q1 = new State("q1");
    public static IState q2 = new State("q2");
    public static IState q3 = new State("q3");
    public static IState q4 = new State("q4");
    public static IState q5 = new State("q5");
    public static IState q6 = new State("q6");
    public static IState q7 = new State("q7");
    public static IState q8 = new State("q8");
    public static IState q9 = new State("q9");
    public static IState q10 = new State("q10");
    public static IState q11 = new State("q11");
    public static IState q12 = new State("q12");
    public static IState q13 = new State("q13");

    public static void cria() {
        char[] sigma = "abcdefghijklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] num = "0123456789".toCharArray();
        char space = ' ';

        List<IState> qs = Arrays.asList(q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13);
        q13.setFinal();

        q0.addTransition(q1, null, null, '$');
        q1.addTransition(q2, 'i', null, null);
        q2.addTransition(q3, 'f', null, null);
        q3.addTransition(q4, '(', null, null);
        q4.addTransition(q5, 'a', null, null);
        q5.addTransition(q5, 'a', null, null);
        q5.addTransition(q6, ')', null, null);
        q5.addTransition(q7, '!', null, null);
        q5.addTransition(q7, '=', null, null);
        q5.addTransition(q8, '<', null, null);
        q5.addTransition(q8, '>', null, null);
        q7.addTransition(q9, '=', null, null);
        q8.addTransition(q9, '=', null, null);
        q8.addTransition(q10, 'b', null, null);
        q9.addTransition(q10, 'b', null, null);
        q10.addTransition(q6, ')', null, null);
        q10.addTransition(q10, 'b', null, null);
        q6.addTransition(q11, '{', null, '{');
        q11.addTransition(q2, 'i', null, null);
        q11.addTransition(q12, '}', '{', null);
        q12.addTransition(q12, '}', '{', null);
        q12.addTransition(q13, null, '$', null);

        for (char c : sigma) {
            q4.addTransition(q5, c, null, null);
            q5.addTransition(q5, c, null, null);
            q8.addTransition(q10, c, null, null);
            q9.addTransition(q10, c, null, null);
            q10.addTransition(q10, c, null, null);
        }

        for (char c : num) {
            q4.addTransition(q5, c, null, null);
            q5.addTransition(q5, c, null, null);
            q8.addTransition(q10, c, null, null);
            q9.addTransition(q10, c, null, null);
            q10.addTransition(q10, c, null, null);
        }

        // ESPAÇOS
        q0.addTransition(q0, space, null, null);
        q3.addTransition(q3, space, null, null);
        q6.addTransition(q6, space, null, null);
        q11.addTransition(q11, space, null, null);
        q12.addTransition(q12, space, null, null);


        // PULAR LINHA
        q11.addTransition(q11, '\n', null, null);
        q12.addTransition(q12, '\n', null, null);
        q11.addTransition(q11, '\r', null, null);
        q12.addTransition(q12, '\r', null, null);
    }

    public static void process(String w) throws Exception {
        cria();
        IPDA pda = new PDA(q0);
        pda.makeLog();
        Util.checkout(pda.run(w), w);
        System.out.println("*****************************");
    }
}
