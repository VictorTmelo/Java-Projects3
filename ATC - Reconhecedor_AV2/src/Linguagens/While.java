package Linguagens;

import Principal.State;
import Principal.Util;
import pda.automata.IPDA;
import pda.automata.IState;
import pda.automata.lib.PDA;

import java.util.Arrays;
import java.util.List;

public class While {

    public static IState q0 = new State("q0");
    public static IState q1 = new State("q1");
    public static IState q2 = new State("q2");
    public static IState q3 = new State("q3");
    public static IState q4 = new State("q4");
    public static IState q5 = new State("q5");
    public static IState q6 = new State("q6");
    public static IState q7 = new State("q7");
    public static IState q8 = new State("q8");
    public static IState q8s = new State("q8s");
    public static IState q9 = new State("q9");
    public static IState q9s = new State("q9s");
    public static IState q10 = new State("q10");
    public static IState q10s = new State("q10s");
    public static IState q11 = new State("q11");
    public static IState q12 = new State("q12");
    public static IState q13 = new State("q13");
    public static IState q14 = new State("q14");
    public static IState q15 = new State("q15");
    public static IState q15s = new State("q15s");

    public static void cria() {

        char[] sigma = "abcdefghijklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] num = "0123456789".toCharArray();

        q11.setFinal();

        List<IState> qs = Arrays.asList(q0, q6, q7, q8s, q9s, q10s, q12, q13, q14, q15s);

        for (IState s : qs) {
            s.addTransition(s, ' ', null, null);
            s.addTransition(s, '\n', null, null);
            s.addTransition(s, '\r', null, null);
        }

        q0.addTransition(q1, null, null, '$');
        q1.addTransition(q2, 'w', null, null);
        q2.addTransition(q3, 'h', null, null);
        q3.addTransition(q4, 'i', null, null);
        q4.addTransition(q5, 'l', null, null);
        q5.addTransition(q6, 'e', null, null);

        q6.addTransition(q7, '(', null, null);

        for (char c : sigma) {
            q7.addTransition(q8, c, null, null);
        }

        for (char c : num) {
            q7.addTransition(q8, c, null, null);
        }

        for (char c : sigma) {
            q8.addTransition(q8, c, null, null);
        }

        for (char c : num) {
            q8.addTransition(q8, c, null, null);
        }

        q8.addTransition(q8s, ' ', null, null);

        q8.addTransition(q9, '=', null, null);
        q8.addTransition(q9, '!', null, null);
        q8.addTransition(q12, ')', null, null);
        q8.addTransition(q15, '>', null, null);
        q8.addTransition(q15, '<', null, null);

        q8s.addTransition(q9, '=', null, null);
        q8s.addTransition(q9, '!', null, null);
        q8s.addTransition(q12, ')', null, null);
        q8s.addTransition(q15, '>', null, null);
        q8s.addTransition(q15, '<', null, null);

        q9.addTransition(q9s, '=', null, null);

        for (char c : sigma) {
            q9s.addTransition(q10, c, null, null);
        }

        for (char c : num) {
            q9s.addTransition(q10, c, null, null);
        }

        for (char c : sigma) {
            q10.addTransition(q10, c, null, null);
        }

        for (char c : num) {
            q10.addTransition(q10, c, null, null);
        }

        q10.addTransition(q12, ')', null, null);
        q10.addTransition(q10s, ' ', null, null);
        q10s.addTransition(q12, ')', null, null);

        q12.addTransition(q13, '{', null, '{');

        q13.addTransition(q14, '}', '{', null);
        q13.addTransition(q2, 'w', null, null);

        q14.addTransition(q14, '}', '{', null);
        q14.addTransition(q2, 'w', null, null);
        q14.addTransition(q11, null, '$', null);

        q15.addTransition(q15s, ' ', null, null);
        q15.addTransition(q15s, '=', null, null);

        for (char c : sigma) {
            q15.addTransition(q10, c, null, null);
            q15s.addTransition(q10, c, null, null);
        }

        for (char c : num) {
            q15.addTransition(q10, c, null, null);
            q15s.addTransition(q10, c, null, null);
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
