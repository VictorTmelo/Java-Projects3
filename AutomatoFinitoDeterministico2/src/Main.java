public class Main {

    public static void main(String[] args) { // AFD = (Q, Σ, δ, q0, F)

        /*
         * L1 = {w in Σ* | w é par ou vazio}
         * L2 = {w in Σ* | w comeca com y e termina com x}
         * L3 = {w in Σ* | w é float ou for}
         */

        L2();

    }

    public static void L1() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        q0.setFinal();

        /* OU

        State q0 = new State(true);
        State q1 = new State(false);

         */

        q0.addTransition(q1, 'a');
        q0.addTransition(q1, 'b');

        q1.addTransition(q0, 'a');
        q1.addTransition(q0, 'b');

        String w = "abbabbba";
        AFD afd = new AFD(q0, w);
        verify(afd.run(), w);
    }

    public static void L2() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State qf = new State("qf");
        qf.setFinal();

        q0.addTransition(q1, 'y');
        q0.addTransition(q2, 'x');

        q1.addTransition(q1, 'y');
        q1.addTransition(qf, 'x');

        q2.addTransition(q2, 'y');
        q2.addTransition(q2, 'x');

        qf.addTransition(qf, 'x');
        qf.addTransition(q1, 'y');

        String w = "yyyyyyxxxyx";
        AFD afd = new AFD(q0, w);
        verify(afd.run(), w);

    }

    public static void arroba(State q, State qn, String w) {
        for(char c : w.toCharArray())
            q.addTransition(qn, c);
    }

    public static void L3() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        State q4 = new State("q4");
        State q5 = new State("q5");
        State qn = new State("qn");
        State qfor = new State("qfor");
        State qfloat = new State("qfloat");
        qfor.setFinal();
        qfloat.setFinal();

        q0.addTransition(q1, 'f');
        arroba(q0, qn, "loatr");

        q1.addTransition(q2, 'l');
        q1.addTransition(q5, 'o');
        arroba(q1, qn, "fatr");

        q2.addTransition(q3, 'o');
        arroba(q2, qn, "flatr");

        q3.addTransition(q4, 'a');
        arroba(q3, qn, "flotr");

        q4.addTransition(qfloat, 't');
        arroba(q4, qn, "floar");

        q5.addTransition(qfor, 'r');
        arroba(q5, qn, "float");

        arroba(qfor, qn, "floatr");
        arroba(qfloat, qn, "floatr");
        arroba(qn, qn, "floatr");

        String w = "fora";
        AFD afd = new AFD(q0, w);
        verify(afd.run(), w);

    }

    public static void verify(boolean b, String w) {
        if(b) {
            System.out.println("Reconheceu: " + w);
            return;
        }
        System.out.println("Nao reconheceu: " + w);
    }
}
