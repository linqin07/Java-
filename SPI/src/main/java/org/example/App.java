package org.example;

import org.example.clazzload.FileSystemClassLoader;
import org.example.clazzload.MyClassLoader;
import org.example.service.MyServiceLoader;
import org.example.service.Search;
import org.omg.CORBA.StringValueHelper;

import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // ServiceLoader<Search> loader = MyServiceLoader.loadAll(Search.class);
        // StreamSupport.stream(loader.spliterator(), false).forEach(i -> i.doSomeThing("sss"));
        // for (Search search : loader) {
        //     search.doSomeThing("ddd");
        // }
        // Iterator<Search> iterator = loader.iterator();
        // while (iterator.hasNext()) {
        //     Search next = iterator.next();
        //     String ddd = next.doSomeThing("ddd");
        //     System.out.println(ddd);
        // }

        ServiceLoader<Search> searches = ServiceLoader.load(Search.class);
        for (Search search : searches) {
            search.doSomeThing("");
        }

        // System.out.println(Thread.currentThread().getContextClassLoader());
        // Thread.currentThread().setContextClassLoader(new MyClassLoader());

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = Class.forName("org.example.bean.Person", true, myClassLoader);
        Object o = aClass.newInstance();
        System.out.println(o);
        // 删除classpath的Person.class  org.example.clazzload.MyClassLoader@74a14482
        // 没删除classpath的Person.class  sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(o.getClass().getClassLoader());

        // 双亲委派，加载类的顺序肯定是按照 bootstrap(<JRE_HOME>\lib) > extend(<JAVA_HOME>/lib/ext) > application(ClassPath)
        // 如果都找不到类，才会使用自定义的类加载器去加载

        FileSystemClassLoader fileSystemClassLoader = new FileSystemClassLoader("D:\\IDEAWorkspace\\Java基础知识\\SPI\\src\\main\\java");
        Class<?> person = fileSystemClassLoader.loadClass("org.example.bean.Person");
        Object o1 = person.newInstance();
        System.out.println(o1);
        System.out.println(o1.getClass().getClassLoader());

        // 自定义的同名类其实加载的是jdk默认类。
        String  str = new String("sdfds");
        System.out.println(str);



    }
}
