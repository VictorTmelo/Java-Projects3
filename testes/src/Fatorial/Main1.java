package Fatorial;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String x = "Falatu fdp";

        System.out.println(x + x.isEmpty());

        System.out.println("Meu nome é ${x}");

        System.out.println("digite um numero: ");
        int y = sc.nextInt();

        System.out.println("Antecessor " + y--);

        System.out.println("Sucessor " + y++);

        System.out.println("Digite um numero:");
        int n = sc.nextInt();

        Fatorial fat = new Fatorial(n);

        System.out.println("Fatorial Recursivo: " + fat.fatorial_recursivo(n));
        System.out.println("Fatorial Iterativo: " + fat.fatorial_iterativo());

    }

}
