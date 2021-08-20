package guava;

import com.google.common.base.Optional;


// import java.util.Optional;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/05/14
 */
public class GuavaOptional {
    public static void main(String[] args) {
        // 创建指定引用的Optional实例，若引用为null则快速失败
        Optional<String> of = Optional.of("");
        System.out.println(of.isPresent()); // true

        Object or = Optional.fromNullable(null).or("3");
        System.out.println(or);


    }
}
