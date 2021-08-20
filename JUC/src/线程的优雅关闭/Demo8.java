package 线程的优雅关闭;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/09/11
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 通过生产者消费者模式演示volatile的局限性，volatile不能唤醒已经阻塞的线程
 * 生产者生产速度很快，消费者消费速度很慢，通过阻塞队列存储商品
 */
public class Demo8 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);//1s足够让生产者把阻塞队列塞满

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(storage.take() + "被消费");
            Thread.sleep(100);//让消费者消费慢一点，给生产者生产的时间
        }

        System.out.println("消费者消费完毕");
        // producer.canceled = true;//让生产者停止生产（实际情况是不行的，因为此时生产者处于阻塞状态，volatile不能唤醒阻塞状态的线程）
        producerThread.interrupt();
    }
}

class Producer implements Runnable {

    public volatile boolean canceled = false;

    private BlockingQueue storage;

    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num < Integer.MAX_VALUE / 2 && !Thread.currentThread().isInterrupted()) {
                if (num % 100 == 0) {
                    this.storage.put(num);
                    System.out.println(num + "是100的倍数，已经被放入仓库");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者停止生产");
        }
    }
}

class Consumer {
    private BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean needMoreNums() {
        return Math.random() < 0.95 ? true : false;
    }
}