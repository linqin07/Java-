package 代码优化专栏;

import java.io.IOException;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/03/26
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        // 推荐这个写法，两个都是堆创建了10000个对象，后者只是栈的空间减少点，一个obj执行
        for (int i = 0; i < 10000; i++) {
            Object object = new Object();
        }


        Object obj = null;
        for (int i = 0; i < 10000; ++i) {
            obj = new Object();
        }
    }
}
