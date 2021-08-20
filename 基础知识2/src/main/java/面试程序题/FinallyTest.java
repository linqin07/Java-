package 面试程序题;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/16
 * 返回：原因，栈，值会继续操作。
 * try block
 * finally block
 * 100
 *
 */
public class FinallyTest {
    public static void main(String[] args) {
        int res = testFinally();
        System.out.println(res);
    }

    private static int testFinally() {
        int b = 0;
        try {
            System.out.println("try block");
            throw new RuntimeException();
        } finally {
            System.out.println("finally block");
            return b += 20;
        }
    }
}
