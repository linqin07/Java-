package 字节流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferedInputStream_My {

    public static void main(String[] args) throws Exception {
        FileInputStream fis=new FileInputStream("e:/bak.txt");
        FileOutputStream fos=new FileOutputStream("e:/bak1.txt");
        //包装一重，等于可以在buffered中设置缓冲区大小。
        BufferedInputStream bis=new BufferedInputStream(fis,8);
        BufferedOutputStream bos=new BufferedOutputStream(fos,8);
        int length=0;
        while((length=bis.read()) != -1){
            System.out.println(length);
            bos.write(length);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

}
