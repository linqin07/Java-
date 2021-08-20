package 代码优化专栏;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(1000000);
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }


        long t0 = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long t1 = System.nanoTime();
        System.out.println(t1 - t0);

        long t3 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list.get(i);
        }
        long t4 = System.nanoTime();
        System.out.println(t4 - t3);

    }

}
