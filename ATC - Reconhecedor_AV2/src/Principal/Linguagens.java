package Principal;

import Linguagens.For;
import Linguagens.Identificadores;
import Linguagens.Linguagem;
import Linguagens.Main;
import Linguagens.Se;
import Linguagens.While;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pda.automata.IState;

public class Linguagens {// PDA = (Q, Σ, δ, {qi}, F)

    public static void main() throws Exception {
        System.out.println("*****************************\nProcessamento de linguagem");

        String w = "\n  main () {\n\n\n  }";

        Main.process(w);
    }

    public static void identificadores() throws Exception {
        System.out.println("*****************************\nProcessamento de linguagem");

        String w = "int xy=8;\n"
                + "int x;\n"
                + "bool p=false;\n"
                + "bool n=true;\n"
                + "bool h;\n";

        Identificadores.process(w);
    }

    public static void se() throws Exception {

        System.out.println("*****************************\nProcessamento de linguagem");

        /*for(IState s: qs) {
			s.addTransition(s, '\n', null, null);
		}*/

 /*String w = "if(teste){"
                            + "if(a==b{if(x){ if(joao){ faco algo }}"
                            + "}"
                            + "}";*/
        String w = "if (a>b) { if (a==b){ } }";

        String y = "if (a>b) {\n"
                + " if (a==b) {\n"
                + " }\n"
                + " }\n";

        Se.process(w);
    }

    public static void For() throws Exception {
        System.out.println("*****************************\nProcessamento de linguagem");

        String w = "for (a=0; a>=b; a++) {\n"
                + "for (a=0; a<=b; a++) {\n"
                + "}\n"
                + "}\n";

        For.process(w);
    }

    public static void enquanto() throws Exception {
        System.out.println("*****************************\nProcessamento de linguagem");

        String w = " \nwhile ( 1 <= 12 ) {\n  while( 23 != 15 ){\n   }\n}";

        While.process(w);
    }

    public static void linguagem() throws Exception {
        System.out.println("*****************************\nProcessamento de linguagem");

        //String w = "main(){int xy=8;}";
        //String w = "main(){bool p = false;}";
        //String w = "main(){bool p=true;}";
        //String w = "main(){if(a>b){}}";
        //String w = "main(){for (a=0; a>=b; a++) {}}";
        //String w = "main(){while( 23 != 15 ){\n   }}";
        //String w = "main(){int xy=8;if(a>b){}}";
        //String w = "main(){if(a>b){int xy=8;}}";
        //String w = "main(){if(a>b){for (a=0; a>=b; a++) {}}}";
        //String w = "main(){if(a>b){while( 23 != 15 ){\n   }}}";
        //String w = "main(){for (a=0; a>=b; a++) {int xy=8;}}";
        //String w = "main(){for (a=0; a>=b; a++) {if(a>b){}}}";
        //String w = "main(){for (a=0; a>=b; a++) {while( 23 != 15 ){\n   }}}";
        //String w = "main(){while( 23 != 15 ){\n   int xy=8;}}";
        //String w = "main(){while( 23 != 15 ){\n   if(a>b){}}}";
        //String w = "main(){while( 23 != 15 ){\n   for (a=0; a>=b; a++) {}}}";
        //String w = "main(){int xy=8;if(a>b){for (a=0; a>=b; a++) {while( 23 != 15 ){\n   }}}}";
        //String w = "main(){int xy=8;int xy=8;}";
        //String w = "main(){if(a>b){}if(a>b){}}";
        //String w = "main(){if(a>b){}for (a=0; a>=b; a++) {}}";
        //String w = "main(){if(a>b){}while( 23 != 15 ){\n   }}";
        //String w = "main(){for (a=0; a>=b; a++) {}if(a>b){}}";
        //String w = "main(){for (a=0; a>=b; a++) {}for (a=0; a>=b; a++) {}}";
        //String w = "main(){for (a=0; a>=b; a++) {}while( 23 != 15 ){\n   }}";
        //String w = "main(){while( 23 != 15 ){\n   }while( 23 != 15 ){\n   }}";
        //String w = "main(){while( 23 != 15 ){\n   if(a>b){}}}";
        //String w = "main(){while( 23 != 15 ){\n   for (a=0; a>=b; a++) {}}}";
        //String w = "main(){int xy=8;if(a>b){}for (a=0; a>=b; a++) {}while( 23 != 15 ){\n   }}";
        //String w = "main(){if(a>b){}int xy=8;if(a>b){for (a=0; a>=b; a++) {}}if(a>b){if(a>b){for (a=0; a>=b; a++) {}while( 23 != 15 ){\n   }}int xy=8;}if(a>b){}int xy=8;for (a=0; a>=b; a++) {int xy=8;}while( 23 != 15 ){\n   while( 23 != 15 ){\n   }}}";
        String w = "main(){\n"
                + " int identificador;\n"
                + " int identificador=0;\n"
                + " bool teste;\n"
                + " bool teste=true;\n"
                + "     if(a==b){\n"
                + "         if(teste==true){\n"
                + "         }\n"
                + "     }\n"

                + "     while(a==b){\n"
                + "         if(a==b){\n"
                + "         }\n"
                + "     }\n"

                + "     for(identificador=0;a==b;identificador++){\n"
                + "     }\n"
                + "}";
        //String w = "main(){int identificador1=3; bool test3; int algumaCoisaNumero4; bool algumaCoisaNumero3=true;}";
        FileInputStream ir = new FileInputStream("src/linguagem.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(ir));

        String linguagem = ""/*readFile("src/linguagem.txt")*/;

        while (in.ready()) {
            String aux = in.readLine() + "\n";


            linguagem += aux;
        }

        Linguagem.process(w);
    }

    public static String readFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return content;
    }

    public static void writeFile(String fileName, String content) {
        try {
            Files.deleteIfExists(Paths.get(fileName));
            Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
