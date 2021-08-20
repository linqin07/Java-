package 多线程共享资源例子;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/20
 */
class SyncThreaed implements Runnable {
    private int count;

    ReentrantLock lock = new ReentrantLock();

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(100);
//				}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}

public class LockDemo {
    public static void main(String args[]) {
        SyncThreaed s = new SyncThreaed();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);

        t1.start();
        t2.start();
    }
}
