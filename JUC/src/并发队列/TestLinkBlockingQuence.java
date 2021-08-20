package 并发队列;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/10/27
 */
public class TestLinkBlockingQuence {
    // 并发阻塞队列
    private static LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                blockingQueue.add(i + "");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                blockingQueue.add(i + "o");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(blockingQueue.peek());
                System.out.println("处理:" + blockingQueue.poll());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
}
