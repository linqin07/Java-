package Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/08
 */
public class AtomicIntegerDemo {
    private static volatile AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread((() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " +1   " + count.incrementAndGet());
        })).start();

        new Thread((() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " +1   " + count.incrementAndGet());

        })).start();

        new Thread((() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " -1   " + count.decrementAndGet());
        })).start();

        new Thread((() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " -1   " + count.decrementAndGet());
        })).start();

    }
}
