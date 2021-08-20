package ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo1 {
    /**
     * 默认和synchronize一样是非公平锁。
     * 默认不是公平锁🔒，非公平是一种抢占机制，是随机获得锁，并不是先来的一定能先得到锁，结果就是不公平的。
     * 公平锁就是跟上锁的顺序无关，随机获得锁对象。非公平就是按照加锁的顺序进行分配。
     */
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();

    public static void main(String[] args) throws Exception {
        ConditionDemo1 demo = new ConditionDemo1();

        new Thread(() -> demo.await(demo.conditionA), "thread-1").start();
        new Thread(() -> demo.await(demo.conditionB), "thread-2").start();

        new Thread(() -> demo.signal(demo.conditionA), "thread-3").start();
        System.out.println("....");
        Thread.sleep(5000);


        new Thread(() -> demo.signal(demo.conditionB), "thread-4").start();
    }

    private void await(Condition condition) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "开始await");
            condition.await();
            System.out.println(Thread.currentThread().getName() + " await结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void signal(Condition condition) {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "开始signal");
        condition.signal();
        lock.unlock();
    }
}
