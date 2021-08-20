package 线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/06/11
 */
public class 信号量 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 信号量,注意关闭必须在finally里面关闭。
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire(); // 获取一个许可
                    Thread.sleep(500);
                    System.out.println("线程：" + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // 释放一个许可
                }
            });
        }
    }
}
