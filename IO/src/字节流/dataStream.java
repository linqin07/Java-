package 字节流;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.imageio.stream.FileImageInputStream;

public class dataStream {
    public static void main(String[] args) throws Exception {
        DataInputStream dis=new DataInputStream(new FileInputStream("e:/bak.txt"));
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("e:\\gg.txt"));
        int length=0;
        while((length=dis.read())!=-1){
            dos.write(length);
        }
        dos.close();
        dis.close();
    }
}
