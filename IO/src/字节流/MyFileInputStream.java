package 字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 字节流可以处理所有的文件类型
 * @author Administrator
 *	复制一个文本
 */

public class MyFileInputStream {
    public static void main(String[] args) throws Exception {
        //创建一个输入、输出流，其中的路径斜杠可以使用/或者\\
        FileInputStream fis=new FileInputStream("e:/电脑优化及公司ftp地址.txt");
        FileOutputStream fos=new FileOutputStream("e:/bak.txt",false);
        byte[] data5=new byte[5];
        int i=0;
        while((i=fis.read(data5))!=-1){ //从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中b - 存储读入数据的缓冲区。
            //返回：读入缓冲区的总字节数；如果因为已经到达流末尾而不再有数据可用，则返回 -1。
            fos.write(data5,0,i);       //直接写会碰到一种情况，当最后读取的不够5个时，写却写了5个，导致数据不正确，
            //使用write(byte[] b,int off, int len)
            //将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
        }
        //关闭流
        fis.close();
        fos.close();
    }

}
