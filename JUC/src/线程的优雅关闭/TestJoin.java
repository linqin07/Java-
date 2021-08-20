package 线程的优雅关闭;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/10/13
 */
public class TestJoin {
    public static void main(String[] args) {
        try {
            Thread.currentThread().setName("main");

            Thread t1 = new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + " ");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "t1");
            t1.start();
            t1.join(10);

            Thread t2= new Thread(() -> {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        // 里面不能放sleep或者wait之类的东西， sleep之类会相应中断并重置标记
                        System.out.println(Thread.currentThread().getName() + " ");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "t2");
            t2.start();
            t2.join(100);

            t1.interrupt();
            System.out.println("t1是否中断" + t1.isInterrupted()); //ture 获取完后会清除状态，针对这个主线程获取
            System.out.println("t1是否中断" + t1.isInterrupted()); //false
            t2.interrupt();
            System.out.println("t2是否中断" + t2.isInterrupted());

            System.out.println("主线程" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


    }
}
