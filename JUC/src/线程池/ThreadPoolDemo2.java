package 线程池;

import java.util.concurrent.*;

public class ThreadPoolDemo2 {
	/**
	 *  corePoolSize 核心线程池大小
	 *  maximumPoolSize 线程池最大容量大小；
	 *  keepAliveTime线程池空闲时，线程存活的时间；
	 *  TimeUnit 时间单位；
	 *  workQueue 任务队列；
	 *  handler线程拒绝策略；
	 * @param args
	 */
	public static void main(String[] args) {
	    ExecutorService executorService = new ThreadPoolExecutor(20, 40, 0L, 
                TimeUnit.MILLISECONDS, 
                new LinkedBlockingQueue<>(10), 
                Executors.defaultThreadFactory(), 
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.submit(() -> {
            	System.out.println("i:" + index + " executorService");
            	try {
					Thread.sleep(20000);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
           );
        }
        executorService.shutdown();

	}

}
