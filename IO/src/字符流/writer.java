package 字符流;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class writer {

    public static void main(String[] args) throws Exception {
        FileWriter fw=new FileWriter("e:/bak1.txt");
        FileReader fr=new FileReader("e:/bak.txt");
        BufferedReader br=new BufferedReader(fr);
        BufferedWriter bw=new BufferedWriter(fw);
        String data="";
        while((data=br.readLine())!=null){
            bw.write(data+"\r");
            System.out.println(data);
            bw.flush();
        }
        br.close();
        fw.close();
    }

}
