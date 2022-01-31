package Linguagens;

import Principal.PDAImpl;
import Principal.Util;
import pda.automata.IPDA;
import pda.automata.lib.PDA;

public class Linguagem {

    public static void cria() {
        Main.cria();
        Identificadores.cria();
        Se.cria();
        For.cria();
        While.cria();

        //Abre chave da main com começo de todos
        Main.q8.addTransition(Identificadores.q2, 'i', null, null);
        Main.q8.addTransition(Identificadores.q3, 'b', null, null);
        Main.q8.addTransition(Se.q2, 'i', null, null);
        Main.q8.addTransition(For.q2, 'f', null, null);
        Main.q8.addTransition(While.q2, 'w', null, null);

        //Fecha chave de todos para main
        Identificadores.q12.addTransition(Main.q9, '}', '{', null);
        Identificadores.q19.addTransition(Main.q9, '}', '{', null);
        Se.q12.addTransition(Main.q9, '}', '{', null);
        For.q20.addTransition(Main.q9, '}', '{', null);
        While.q14.addTransition(Main.q9, '}', '{', null);

        //Ponto e virgula de identificadores para if, for e while
        Identificadores.q12.addTransition(Se.q2, 'i', null, null);
        Identificadores.q19.addTransition(Se.q2, 'i', null, null);

        Identificadores.q12.addTransition(For.q2, 'f', null, null);
        Identificadores.q19.addTransition(For.q2, 'f', null, null);

        Identificadores.q12.addTransition(While.q2, 'w', null, null);
        Identificadores.q19.addTransition(While.q2, 'w', null, null);

        //Indecisão entre if e int
        Identificadores.q2.addTransition(Se.q3, 'f', null, null);
        Se.q2.addTransition(Identificadores.q5, 'n', null, null);

        //Abre chave do if para identificador, for e while
        Se.q11.addTransition(Identificadores.q2, 'i', null, null);
        Se.q11.addTransition(Identificadores.q3, 'b', null, null);
        Se.q11.addTransition(For.q2, 'f', null, null);
        Se.q11.addTransition(While.q2, 'w', null, null);

        //Fecha chave de identificador, for e while para if
        Identificadores.q12.addTransition(Se.q12, '}', '{', null);
        Identificadores.q19.addTransition(Se.q12, '}', '{', null);
        For.q20.addTransition(Se.q12, '}', '{', null);
        While.q14.addTransition(Se.q12, '}', '{', null);

        //Abre chave de for para identificador, if e while
        For.q20.addTransition(Identificadores.q2, 'i', null, null);
        For.q20.addTransition(Identificadores.q3, 'b', null, null);
        For.q20.addTransition(Se.q2, 'i', null, null);
        For.q20.addTransition(While.q2, 'w', null, null);

        //Fecha chave de identificador, if e while para for
        Identificadores.q12.addTransition(For.q21, '}', '{', null);
        Identificadores.q19.addTransition(For.q21, '}', '{', null);
        Se.q12.addTransition(For.q21, '}', '{', null);
        While.q14.addTransition(For.q21, '}', '{', null);

        //Abre chave de while para identificador, if e for
        While.q13.addTransition(Identificadores.q2, 'i', null, null);
        While.q13.addTransition(Identificadores.q3, 'b', null, null);
        While.q13.addTransition(For.q2, 'f', null, null);
        While.q13.addTransition(Se.q2, 'i', null, null);

        //Fecha chave de identificador, if e for para while
        Identificadores.q12.addTransition(While.q14, '}', '{', null);
        Identificadores.q19.addTransition(While.q14, '}', '{', null);
        Se.q12.addTransition(While.q14, '}', '{', null);
        While.q14.addTransition(While.q14, '}', '{', null);

        //Fecha chave de if, for e while para if, for e while
        Se.q12.addTransition(Identificadores.q2, 'i', null, null);
        Se.q12.addTransition(Identificadores.q3, 'b', null, null);
        Se.q12.addTransition(For.q2, 'f', null, null);
        Se.q12.addTransition(While.q2, 'w', null, null);
    }

    public static void process(String w) throws Exception {
        cria();
        IPDA pda = new PDA(Main.q0);
        //PDAImpl pda = new PDAImpl(Main.q0);
        pda.makeLog();
        Util.checkout(pda.run(w), w);
        System.out.println("*****************************");


    }
}
