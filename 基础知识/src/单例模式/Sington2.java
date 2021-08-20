package 单例模式;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/02/27
 */
public class Sington2 {
    private static Sington2 sington2 = null;

    private Sington2() {
    }

    public Sington2 getInstance() {
        if (sington2 == null) {
            sington2 = new Sington2();
        }
        return sington2;
    }
}
