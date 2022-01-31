package Fatorial;

public class Fatorial {

    private int x;

    public Fatorial(int p) {

        this.x = p;
    }


    public int fatorial_recursivo(int x) {


        if (x == 1) return 1;
        if (x == 0) return 1;

        return (x * fatorial_recursivo(x - 1));

    }



    public int fatorial_iterativo() {

        int fat = x;
        int i = x - 1;

        while (i >= 1) {

            fat *= i;
            i -= 1;

        }

        return fat;

    }

}
