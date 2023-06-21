import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> doThis = new ArrayList<>(intList);
        for (Iterator<Integer> it = doThis.iterator(); it.hasNext();) {
            int tmp = it.next();
            if (tmp <= 0 || tmp % 2 != 0) {
                it.remove();
            }
        }
        Collections.sort(doThis);
        System.out.println(doThis);
    }
}
