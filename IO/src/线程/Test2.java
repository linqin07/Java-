package 线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/02/27
 */
public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new callDemo());
        new Thread(futureTask).start();
        System.out.println(futureTask.get().toString());
    }
}

class callDemo implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return "call返回";
    }
}
