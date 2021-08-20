package 多线程共享资源例子;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/20
 */
class SyncThreads implements Runnable {
    private int count;

    AtomicInteger count1 = new AtomicInteger(0);

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + (count1.getAndIncrement()));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class AtomDemo {
    public static void main(String args[]) {
        SyncThreads s = new SyncThreads();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);

        t1.start();
        t2.start();
    }
}
