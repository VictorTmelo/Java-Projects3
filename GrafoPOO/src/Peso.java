public class Peso {

    private Character c;

    public Peso(Character c) {

        this.c = c;
    }

    public Character getC() {
        return c;
    }

    public static Peso instance(Character _c){
        return new Peso(_c);
    }

}
