import java.util.Set;
import java.util.TreeSet;

public class Util {
    public static int[] merge(int[] states, int[] new_states) {
        Set<Integer> uniao = new TreeSet<Integer>();
        for(int i: states) uniao.add(i);
        for(int i: new_states) uniao.add(i);
        int[] r = new int[uniao.size()];
        int j = 0;
        for(int i: uniao) r[j++] = i;
        return r;
    }
    public static boolean valid(int[] qs, int[] F) {
        if(qs == null) return false;
        for(int i: qs)
            for(int j: F)
                if(i==j)
                    return true;
        return false;
    }
    public static void log(String w, int[] states, int k) {
        System.out.print(w.substring(0,  k) + "{");
        for(int i=0; i< states.length; i++) {
            System.out.format("q%d%s", states[i], i==states.length-1?"":", ");
        }
        System.out.println("}"+w.substring(k));
    }
}