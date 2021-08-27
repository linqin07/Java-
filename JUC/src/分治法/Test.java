package 分治法;

import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/08/27
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ForkJoinPool forkjoinPool = new ForkJoinPool();

        //生成一个计算任务，计算1+2+3+4
        ForkJoinTaskExample task = new ForkJoinTaskExample(1, 40000);
        //执行一个任务
        ForkJoinTask<Integer> submit = forkjoinPool.submit(task);
        Future<Integer> result       = forkjoinPool.submit(task);
        System.out.println(result.get(100, TimeUnit.SECONDS));
        submit.join();

    }
}
