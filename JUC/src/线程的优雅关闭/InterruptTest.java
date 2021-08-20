package 线程的优雅关闭;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/10/13
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {

                while (!isInterrupted()) {
                    try {
                        Thread.sleep(202);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程启动了");
                }
            }
        };
        thread.start();
        Thread.sleep(200);
        thread.interrupt();//注意，此方法不会中断一个正在运行的线程，它的作用是：在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态

    }
}
