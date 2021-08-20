package 线程的优雅关闭;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/10/13
 */
public class StopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int num = 0;
            while (!Thread.currentThread().isInterrupted() && num <= 300) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的整数倍");
                }
                ++num;
            }


            try {
                //sleep()方法会响应中断，且响应中断的方式为抛出InterruptException异常--- sleep interrupted
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行完毕");
        });
        //启动线程
        thread.start();
        //等待while循环执行完毕
        Thread.sleep(200L);
        //当线程处于sleep()状态时进行中断
        thread.interrupt();
    }
}