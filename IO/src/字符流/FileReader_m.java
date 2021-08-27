package 字符流;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReader_m {

    public static void main(String[] args) throws Exception {
        FileReader fr=new FileReader("e:/bak.txt");
        FileWriter fw=new FileWriter("e:/bak1.txt");
        int data=0;
        char[] c=new char[10];
        while((data=fr.read(c))!=-1){
            fw.write(c, 0, data);;
        }
        fr.close();
        fw.close();

    }

}
