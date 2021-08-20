package 面试程序题;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/02/27
 */
public class Outter {
    static class Inner {
        static int One = 5;
        static final int Two = 5;
        static final int Three = new Integer(5);
    }

    public static void main(String[] args) {
        System.out.println(Outter.Inner.One);
        System.out.println(Outter.Inner.Two);
        System.out.println(Outter.Inner.Three);
    }
}
