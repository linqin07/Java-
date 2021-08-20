package ReentrantLock;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	private static final int THREAD_COUNT_NUM = 7;

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
			@Override
			public void run() {
				System.out.println("7个法师召集完毕，同时出发，去往不同地方寻找龙珠！");
				// summonDragon();
			}
		});

		for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
			int index = i;
			new Thread(() -> {
				try {
					Thread.sleep(Math.abs(new Random().nextInt(3000)));
					System.out.println("召集第" + index + "个法师");
					barrier.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();

		}
        System.out.println("我是主线程，我没有被堵塞");
    }

	// /**
	//  * 召唤神龙：1、收集龙珠；2、召唤神龙
	//  */
	// private static void summonDragon() {
	// 	// 设置第二个屏障点，等待7位法师收集完7颗龙珠，召唤神龙
	// 	CyclicBarrier summonDragonBarrier = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
	// 		@Override
	// 		public void run() {
	// 			System.out.println("集齐七颗龙珠！召唤神龙！");
	// 		}
	// 	});
	// 	// 收集7颗龙珠
	// 	for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
	// 		int index = i;
	// 		new Thread(() -> {
	// 			try {
	// 				Thread.sleep(Math.abs(new Random().nextInt(3000)));
	// 				System.out.println("第" + index + "颗龙珠已收集到！");
	// 				summonDragonBarrier.await();
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}).start();
    //
	// 	}
	// }

}
