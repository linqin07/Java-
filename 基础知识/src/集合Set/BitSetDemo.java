package 集合Set;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class BitSetDemo {
    //为了方便，假设数据是以数组的形式给我们的
    public static Set<Integer> test(int[] arr) {
        //用来把重复的数返回，存在Set里，这样避免返回重复的数。
        Set<Integer> output = new HashSet<>();
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        int i = 0;
        while (i < arr.length) {
            int value = arr[i];
            //存在就添加到集合中
            if (bitSet.get(value)) {
                output.add(value);
            } else {
                bitSet.set(value, true);
            }
            i++;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] t = {1,2,3,4,5,6,7,8,3,4};
        Set<Integer> t2 = test(t);
        System.out.println(t2);

        BitSet bitSet1 = new BitSet(Integer.MAX_VALUE);//127M
        BitSet bitSet2 = new BitSet(Integer.MAX_VALUE);
        // 1亿个ulr判断是否存在
        String url = "http://baidu.com/a";
        int hashcode1 = url.hashCode() & 0x7FFFFFFF;
        bitSet1.set(hashcode1);

        int hashcode2 = (url + "-seed-").hashCode() & 0x7FFFFFFF;
        bitSet2.set(hashcode2);
        System.out.println(bitSet1.get(hashcode1) && bitSet1.get(hashcode2));
    }
}
