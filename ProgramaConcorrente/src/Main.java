
public class Main {

    public static void main(String[] args) {

        Count p = new Count();
        Count q  = new Count();

        p.start();
        q.start();

        try{
            p.join();
            q.join();
        }
        catch (InterruptedException e){

            System.out.println ("The value of n is " + n);

        }
    }

}
