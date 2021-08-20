package org.example.clazzload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Description:  双亲委派，加载类的顺序肯定是按照 bootstrap(<JRE_HOME>\lib) > extend(<JAVA_HOME>/lib/ext) > application(ClassPath)
 *                如果都找不到类，才会使用自定义的类加载器去加载
 *
 *                场景：比如同时要加载两个es版本，同时引入会报错。只能先引入一个，另一个换个lib文件夹放jar包并使用自定义类加载器加载使用。
 * @author: LinQin
 * @date: 2020/11/30
 */
public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        // 打破双亲委派模型，那么就重写整个loadClass方法

        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //不想打破双亲委派模型，那么只需要重写findClass方法即可, name=org.example.bean.Person
        File file = getClassFile(name);
        try {
            byte[] bytes = getClassBytes(file);
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private File getClassFile(String name) {
        File file = new File("D:/Person.class");
        return file;
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }

        fis.close();

        return baos.toByteArray();
    }

}
