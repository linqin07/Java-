package 毫秒转化;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: LinQin
 * @date: 2018/09/26
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        long time1 = System.currentTimeMillis();
        Thread.sleep(2000);
        long time2 = System.currentTimeMillis();
        System.err.println(TimeUnit.MILLISECONDS.toSeconds(time2 - time1));


        long time11 = System.nanoTime();
        Thread.sleep(2000);
        long time22 = System.nanoTime();
        System.err.println(TimeUnit.NANOSECONDS.toSeconds(time22 - time11));

    }
}
