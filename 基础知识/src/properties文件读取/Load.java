package properties文件读取;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.ResourceBundle;

public class Load {

    public static void main(String[] args) throws Exception {
        /** 静态读取到内存，gg.properties发生改变时，还是读取内存缓存，无法更新，web需要重启 */
        Properties properties = new Properties();
        InputStream is = Load.class.getClassLoader().getResourceAsStream("gg.properties");
        properties.load(is);
        System.out.println(properties.get("test"));


        /**
         * getClassLoader()相当于 /
         * getResource 如果什么都不加就返回当前的路径。
         * 使用 ../返回上一级
         *      /表示根目录。
         */
        String path = Load.class.getResource("../gg.properties").getPath();
        String path2 = Load.class.getClassLoader().getResource("gg.properties").getPath();
        String path3 = Load.class.getClassLoader().getResource("gg.properties").toURI().getPath();//toURI()就不会中文url	转码了

        /** 进行存储，请查看编译后的gg.properties，流的形式可以不用重启web服务器 */
        FileOutputStream fos = new FileOutputStream(URLDecoder.decode(path, "UTF-8"));
        properties.setProperty("add", "我是新增的dd");
        properties.store(fos, "comments");

        System.out.println(properties.get("add"));


        //读取src根目录下的properties文件,或者web项目的classpath下，不用写后缀。有文件夹就直接xxx/xxx即可
        ResourceBundle bundle = ResourceBundle.getBundle("gg");
        String string = bundle.getString("test");
        System.err.println(string);
    }
}
