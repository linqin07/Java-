package 线程的优雅关闭;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/25
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                while (true && (!Thread.currentThread().isInterrupted())) {

                    System.out.println("线程运行中");
                    //当sleep方法抛出InterruptedException  中断状态也会被清掉
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                //如果抛出异常则再次设置中断请求
                Thread.currentThread().interrupt();
            }

        });

        thread.start();

        Thread.sleep(3000);
        thread.interrupt();
        // thread.stop();

    }
}
