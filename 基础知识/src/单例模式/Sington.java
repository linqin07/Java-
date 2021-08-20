package 单例模式;

/**
 * 双重校验锁，多线程安全
 *
 * @author 林钦
 */
public class Sington {
    private static volatile Sington sington = null;

    private Sington() {
    }

    public static Sington getSingtonInstance() {
        if (sington == null) {
            synchronized (Sington.class) {
                if (sington == null) {
                    sington = new Sington();
                }
            }
        }
        return sington;
    }
}
