package ReentrantLock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	private static final int THREAD_COUNT_NUM = 7;

	public static void main(String[] args) throws Exception {
		CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);
		for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
			int index = i;
			new Thread(() -> {
				try {
					Thread.sleep(Math.abs(new Random().nextInt(5000)));
					System.out.println("第" + index + "颗龙珠已经找到");
				} catch (Exception e) {
					e.printStackTrace();
				}
				 //每收集到一颗龙珠,需要等待的颗数减1
				countDownLatch.countDown();
			}).start();
		}
		 //等待检查，即上述7个线程执行完毕之后，执行await后边的代码
		countDownLatch.await();
		System.out.println("召唤神龙");

        System.out.println("我是主线程，我被阻塞了");
    }
	

}
