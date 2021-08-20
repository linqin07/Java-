package 面试程序题;

import jackson.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/02/28
 */
public class 集合比较 {
    public static void main(String[] args) {
        User user = new User(1, "lin");

        ArrayList<Integer> one = new ArrayList<>();
        one.add(new Integer(1));

        Vector<Integer> two = new Vector<>();
        two.add(new Integer(1));

        System.out.println(one.equals(two)); //true


        // 基本数据类型整个作为一个对象转换为集合。包装类不同。
        int[] test = new int[]{1, 2, 3, 4};
        long[] longs = new long[]{1L, 2L, 3L, 4L};

        String[] strings = new String[]{"1", "2", "3"};

        List ints = Arrays.asList(longs);
        System.out.println(ints.size());

        Integer[] test1 = new Integer[]{1, 2, 3, 4};
        List<Integer> list = Arrays.asList(test1);
        // list.add(5);

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(test1));
        list1.add(5);

        // j++其实还没有数字变化。但是++j就有变化了。++j 100
        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j); // 0
    }
}
