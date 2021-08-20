package 静态代码块执行顺序;

/**
 * 父静态代码块
 * 子静态代码块
 * 父非静态代码块
 * 父构造函数
 * 子非静态代码块
 * 子构造函数
 * ------------------------
 * 父非静态代码块
 * 父构造函数
 * 子非静态代码块
 * 子构造函数
 *
 * @author 林钦
 * 静态代码块只会构造一次，并且优先，其他的就父类优先。
 * 静态代码块>代码块>构造函数
 */
class staticCode {
    static {
        System.out.println("父静态代码块");
    }

    {
        System.out.println("父非静态代码块");
    }

    public staticCode() {
        System.out.println("父构造函数");
    }

}

public class staticCode_1 extends staticCode {
    static {
        System.out.println("子静态代码块");
    }

    {
        System.out.println("子非静态代码块");
    }

    public staticCode_1() {
        System.out.println("子构造函数");
    }

    public static void main(String[] args) {
        new staticCode_1();
        System.out.println("------------------------");
        new staticCode_1();
    }
}
