package 线程的优雅关闭;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/25
 * 直接stop太暴力
 */
public class Tasks implements Runnable {
    //增加关闭标记，注意内存可见性
    private static volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("执行线程中");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //测试
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Tasks());
        thread.start();

        Thread.sleep(1000);
        stop = true;
    }
}
