package 数组中获取检查是否包含某元素;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Test {
    /**
     * 1.转化为list使用contain方法
     * 2.转化为set使用contain方法
     * 3.Arrays.binarySearch()，只能用于无序数组
     * 4.使用commons包下的工具类，使用ArrayUtils.contains(array, "E");
     * 总结：数据少List.contain:4ms
     * set.contain:25ms
     * Loop:8ms
     * ArrayUtils:6ms
     * 数据量大的话就：循环最快》工具类》List》Set
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] array = new String[]{"A", "B", "C", "D", "E"};

        /** 使用Arrays转化为list */
        long BeginListTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            boolean contains = Arrays.asList(array).contains("A");
        }
        long EndListTime = System.currentTimeMillis();
        System.out.println("List.contain:" + (EndListTime - BeginListTime) + "ms");

        /** 使用Set */
        long BeginSetTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Set<String> set = new HashSet<String>(Arrays.asList(array));
        }
        long EndSetTime = System.currentTimeMillis();
        System.out.println("set.contain:" + (EndSetTime - BeginSetTime) + "ms");

        /** 使用循环 */
        long BeginLoopTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            for (String s : array) {
                if ("E".equals(s)) {
//					System.out.println("E");
                }
            }
        }
        long EndLoopTime = System.currentTimeMillis();
        System.out.println("Loop:" + (EndLoopTime - BeginLoopTime) + "ms");

        /** 使用 ArrayUtils*/
        long Time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            // ArrayUtils.contains(array, "E");
//			Arrays.binarySearch(array,"E");
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayUtils:" + (end - Time) + "ms");

    }
}
