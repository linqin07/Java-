package 面试程序题;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/20
 */
public class SysoNum {
    public static void main(String[] args) {
        Shuzi shuzi = new Shuzi();
        for (int i = 0; i < 100; i++) {
            new Thread(shuzi).start();
        }

    }
}

class Shuzi implements Runnable {

    int i = 0;

    @Override
    public void run() {
        try {
            synchronized (this) {
                Thread.sleep(10);
                System.out.println(i++);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
