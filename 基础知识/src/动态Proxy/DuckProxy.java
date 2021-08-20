package 动态Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DuckProxy implements InvocationHandler {

    Duck duck = null;

    public DuckProxy(Duck duck) {
        this.duck = duck;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object object = null;
        System.out.println(method.getName());
        // 验证调用方法一致
        if ("create".equals(method.getName())) {
            System.out.println("杀鸭脱毛");
            object = method.invoke(duck, args);
            System.out.println("愉快的吃鸭子");
        }

        return object;
    }
}
