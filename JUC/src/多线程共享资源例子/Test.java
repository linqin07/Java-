package 多线程共享资源例子;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/20
 */
class SyncThread implements Runnable {
    ReentrantLock lock = new ReentrantLock();
    private int count;

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                lock.lock();
				// synchronized (this) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
				// }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

public class Test {
    public static void main(String args[]) {
        SyncThread s = new SyncThread();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);

        t1.start();
        t2.start();
    }
}