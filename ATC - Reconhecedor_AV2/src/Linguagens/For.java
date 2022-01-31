package Linguagens;

import Principal.Util;
import Principal.State;
import pda.automata.IPDA;
import pda.automata.IState;
import pda.automata.lib.PDA;

import java.util.Arrays;
import java.util.List;

public class For {

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
    public static IState q14 = new State("q14");
    public static IState q15 = new State("q15");
    public static IState q16 = new State("q16");
    public static IState q17 = new State("q17");
    public static IState q18 = new State("q18");
    public static IState q19 = new State("q19");
    public static IState q20 = new State("q20");
    public static IState q21 = new State("q21");
    public static IState q22 = new State("q22");

    public static void cria() {

        char[] sigma = "abcdefghijklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] num = "0123456789".toCharArray();
        char space = ' ';

        q22.setFinal();

        List<IState> qs = Arrays.asList(q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20, q21, q22);

        q0.addTransition(q1, null, null, '$');
        q1.addTransition(q2, 'f', null, null);
        q2.addTransition(q3, 'o', null, null);
        q3.addTransition(q4, 'r', null, null);
        q4.addTransition(q5, '(', null, null);

        for (char c : sigma) {
            q5.addTransition(q6, c, null, null);
            q6.addTransition(q6, c, null, null);
        }

        q6.addTransition(q7, '=', null, null);

        for (char n : num) {
            q7.addTransition(q8, n, null, null);
            q8.addTransition(q8, n, null, null);
        }

        q8.addTransition(q9, ';', null, null);

        for (char c : sigma) {
            q9.addTransition(q10, c, null, null);
            q10.addTransition(q10, c, null, null);
        }

        q10.addTransition(q11, '!', null, null);
        q10.addTransition(q11, '=', null, null);

        q10.addTransition(q12, '>', null, null);
        q10.addTransition(q12, '<', null, null);

        q11.addTransition(q13, '=', null, null);

        q12.addTransition(q13, '=', null, null);

        for (char n : num) {

            q12.addTransition(q14, n, null, null);

            q13.addTransition(q14, n, null, null);

            q14.addTransition(q14, n, null, null);
        }

        for (char c : sigma) {

            q12.addTransition(q14, c, null, null);

            q13.addTransition(q14, c, null, null);

            q14.addTransition(q14, c, null, null);
        }

        q14.addTransition(q15, ';', null, null);

        for (char c : sigma) {
            q15.addTransition(q16, c, null, null);
            q16.addTransition(q16, c, null, null);
        }

        q16.addTransition(q17, '+', null, '+');
        q17.addTransition(q18, '+', '+', null);

        q18.addTransition(q19, ')', null, null);

        q19.addTransition(q20, '{', null, '{');

        q20.addTransition(q2, 'f', null, null);

        q20.addTransition(q21, '}', '{', null);

        q21.addTransition(q21, '}', '{', null);

        q21.addTransition(q22, null, '$', null);

        // ESPAÇOS
        q0.addTransition(q0, space, null, null);
        q4.addTransition(q4, space, null, null);
        q9.addTransition(q9, space, null, null);
        q15.addTransition(q15, space, null, null);
        q19.addTransition(q19, space, null, null);
        q20.addTransition(q20, space, null, null);
        q21.addTransition(q21, space, null, null);

        // PULAR LINHA
        q20.addTransition(q20, '\n', null, null);
        q21.addTransition(q21, '\n', null, null);
        q20.addTransition(q20, '\r', null, null);
        q21.addTransition(q21, '\r', null, null);

        for (IState c : qs) {
            c.addTransition(c, space, null, null);
            c.addTransition(c, space, null, null);
            c.addTransition(c, '\n', null, null);
            c.addTransition(c, '\r', null, null);
        }
    }

    public static void process(String w) throws Exception {
        cria();
        IPDA pda = new PDA(q0);
        pda.makeLog();
        Util.checkout(pda.run(w), w);
        System.out.println("*****************************");
    }
}
