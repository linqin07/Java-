package 面试程序题;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/16
 * 输出2
 * for循环里面的值操作会一个个执行，有先后，所以为2
 */
public class ForTest {
    public static void main(String[] args) {
        int i = 0;
        if (i++ >= 0 && i++ > 1 && (++i) < 3) {
            System.out.println("条件成立");
        }
        System.out.println(i);
    }
}
