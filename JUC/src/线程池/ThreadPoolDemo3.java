package 线程池;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo3 {
	/**
	 *  corePoolSize 核心线程池大小
	 *  maximumPoolSize 线程池最大容量大小；
	 *  keepAliveTime线程池空闲时，线程存活的时间；
	 *  TimeUnit 时间单位；
	 *  workQueue 任务队列；
	 *  handler线程拒绝策略；
	 */
	public static void main(String[] args) {
		ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(10), new ThreadFactory() { // 自定义ThreadFactory
					@Override
					public Thread newThread(Runnable r) {
						Thread thread = new Thread(r);
						thread.setName(r.getClass().getName());
						return thread;
					}
				}, new ThreadPoolExecutor.CallerRunsPolicy());// 自定义线程拒绝策略

		for (int i = 0; i < 10; i++) {
			int index = i;
			/**
			 * 发现没报异常，少了0；或者使用get()接收。阻塞当前线程直到任务完成。
			 * 而使用get（long timeout，TimeUnit unit）方法则会阻塞当前线程一段时间后立即返回，这时候有可能任务没有执行完
			 */
			Future<?> future = executorService.submit(() -> System.out.println(1/index + " index:" + index));
			try {
				future.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//使用execute代替。
//			executorService.execute(() -> System.out.println(1/index + " index:" + index));
		}

		executorService.shutdown();
	}

}
