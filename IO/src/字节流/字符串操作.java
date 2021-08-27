package 字节流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class 字符串操作 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos=new FileOutputStream("e:/xxx/bak.txt",true);
        String str="中华人民共和国万岁！+！@@#@#￥%%……&*。，【】、'\323246ddsxg~`!@#$%^&*()-=——+";
        byte[] bytes = str.getBytes();
        fos.write(bytes);
        fos.close();
    }

}
