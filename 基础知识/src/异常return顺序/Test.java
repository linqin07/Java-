package 异常return;

public class Test {
    /**
     * 在trycatch中使用return
     * return的基本数据类型是类似栈，先返回后面入栈return的值。注意其中的变量值是会更新的。继续操作该变量。复杂对象引用修改也会更新对象值。
     * 如果是返回List这些堆里面的数据，则没有任何影响。
     * 尽量不要在finally中返回值，一般都是关闭流的操作。
     *
     * @param args 2018年5月15日
     */
    public static void main(String[] args) {
        int ee = testBasic();
        System.out.println(ee);
    }

    @SuppressWarnings("finally")
    public static int testBasic() {
        int i = 1;
        try {
            i++;
            int m = i / 0;
            System.out.println("try block, i = " + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch block i = " + i);
            return i;
        } finally {
            i = 10;
            // i++;
            System.out.println("finally block i = " + i);
            return i;
        }
    }

}
