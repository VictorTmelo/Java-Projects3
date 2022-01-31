package Linguagens;

import static Linguagens.While.cria;
import static Linguagens.While.q0;
import Principal.State;
import Principal.Util;
import java.util.Arrays;
import java.util.List;
import pda.automata.IPDA;
import pda.automata.IState;
import pda.automata.lib.PDA;

public class Main {

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
    //public static IState q10 = new State("q10");
    public static IState q11 = new State("q11");

    public static void cria() {
        q11.setFinal();

        List<IState> qs = Arrays.asList(q0, q5, q7, q8, q9);

        for (IState s : qs) {
            s.addTransition(s, ' ', null, null);
            s.addTransition(s, '\n', null, null);
            s.addTransition(s, '\r', null, null);
        }

        q0.addTransition(q1, null, null, '$');
        q1.addTransition(q2, 'm', null, null);
        q2.addTransition(q3, 'a', null, null);
        q3.addTransition(q4, 'i', null, null);
        q4.addTransition(q5, 'n', null, null);
        q5.addTransition(q6, '(', null, null);
        q6.addTransition(q7, ')', null, null);
        q7.addTransition(q8, '{', null, '{');
        q8.addTransition(q9, '}', '{', null);
        //q8.addTransition(q10, 'i', null, null);
        q9.addTransition(q9, '}', '{', null);
        q9.addTransition(q11, null, '$', null);
    }

    public static void process(String w) throws Exception {
        cria();
        IPDA pda = new PDA(q0);
        pda.makeLog();
        Util.checkout(pda.run(w), w);
        System.out.println("*****************************");
    }
}
