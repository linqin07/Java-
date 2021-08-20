package 红包算法;

import java.util.Arrays;
import java.util.Random;

public class Test1 {
    /**
     * 越后面的随机数越少，非常不平衡。抢红包抢到心态爆炸。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = divide(100, 20);
        int max = 0;
        int second = 0;
        for (int item : a) {
            if (item > max)
                max = item;
            if (item < max && item > second)
                second = item;
            System.out.println(item);
        }
        System.out.println(max);
        System.out.println(second);


    }

    private static int[] divide(double money, int n) {
        //验证参数合理校验
        int fen = (int) (money * 100);
        if (fen < n || n < 1) {
            System.out.println("红包个数必须大于0，并且最小红包不少于1分");

        }
        int[] a = new int[n];
        //先给每个红包中塞入1分
        Arrays.fill(a, 1);
        fen -= n;
        Random r = new Random();
        while (fen > 1) {
            //最后一次剩余fen=1，fen===0
            int f = r.nextInt(fen);
            int index = r.nextInt(a.length);
            a[index] += f;
            fen -= f;
        }
        if (fen > 0) {
            a[0] += fen;
        }
        return a;
    }
}