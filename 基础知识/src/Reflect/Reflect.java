package Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflect {
    public static void main(String[] args) throws Exception {
        //1.在一个对象被创建的情况下，获取Class方法
        Dog dog = new Dog(1, "dog");
        Class clazz1 = dog.getClass();
        //2.在一个类被加载到内存中，但是还没有创建对象的情况下,获取Class方法
        Class clazz2 = Dog.class;
        //3.在一个类还没有被加载情况下，获取Class的方法
        Class clazz3 = Class.forName("Reflect.Dog");

        //获取本类或者继承类的公有变量
        Field[] fields = clazz3.getFields();
        //获取本类或者继承类的 某个 公有变量
//		Field field = clazz1.getField("xxx");
        //获取本类的全部公有私有变量
        Field[] declaredFields = clazz1.getDeclaredFields();
        //获取本类的 某个 公有私有变量
        Field declaredField = clazz1.getDeclaredField("num");
        //设置值
        declaredField.setAccessible(true);
        declaredField.setInt(dog, 25);
        //获取值
        System.out.println(declaredField.get(dog));

        // 反射获取私有属性值，有些时候，再一些开源项目中定义好的类，里面有我们需要的属性，但是没有直接的获取的方式，并且是私有的，可以通过反射进行获取
        Field field = clazz2.getDeclaredField("name");
        field.setAccessible(true);
        String dogName = (String) field.get(dog);
        System.out.println(dogName);

        Field[] declaredFields1 = clazz2.getDeclaredFields();
        for (Field field1 : declaredFields1) {
            field1.setAccessible(true);
            Class<?> type = field1.getType();
            // Class 类型比较,包装类和基本数据类型
            if (int.class == type || String.class == type) {

            } else if (Number.class.isAssignableFrom(type)) {
                // isAssignableFrom 前者类型和后者是否相同，或者是它的超类
            }
        }

    }


}
