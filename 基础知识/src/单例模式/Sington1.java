package 单例模式;

/**
 * 饿汉式，线程安全，类加载就初始化好了
 *
 * @author 林钦
 */
public class Sington1 {
    private final static Sington1 SINGTON1 = new Sington1();

    private Sington1() {
    }

    public static Sington1 getInstance() {
        return SINGTON1;
    }
}
