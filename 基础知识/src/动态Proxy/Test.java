package 动态Proxy;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {

        Duck duck = (Duck) Proxy.newProxyInstance(Duck.class.getClassLoader(),
                new Class[]{Duck.class}, new DuckProxy(new BeijingDuck()));

        duck.create(5);

    }

}
