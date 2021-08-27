package 字符流;
import java.io.RandomAccessFile;
public class random {
    public static void main(String[] args) throws Exception {
        //可读写的文件流
        RandomAccessFile ra=new RandomAccessFile("e:/640.jpg", "rw"); //mode可以为"r","rw","rws","rwd"/read,write,读写同步，读写同步（减少执行的 I/O 操作数量）
        RandomAccessFile ras=new RandomAccessFile("e:/gg.jpg", "rw");
        ra.seek(0); //设置起始位置
        int length=0;
        byte[] data=new byte[10000];
        while((length=ra.read(data))!=-1){
            ras.write(data, 0, length);
            System.out.println(ra.getFilePointer());//获得末尾位置
        }
        /** 写入  */
        ra.close();
        ras.close();
    }
}
