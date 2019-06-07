package JosephusPermutation;

import java.util.*;

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> l = new LinkedList<>(items);
        ListIterator<T> it = l.listIterator();
        //int startFrom = 0;

        ArrayList<T> res = new ArrayList<>();

        while (!l.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                if (!it.hasNext())
                    it = l.listIterator();
                it.next();
            }
            if (!it.hasNext())
                it = l.listIterator();
            res.add(it.next());
            it.remove();
        }
        return res;
    }
}
