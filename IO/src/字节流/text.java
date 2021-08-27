package 字节流;

import java.io.FileInputStream;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class text {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("e:/bak1.txt");
		InputStreamReader isr=new InputStreamReader(fis, "gb2312");
		char[] c=new char[1024];
		while(isr.read(c)!=-1){
			System.out.println(c);
		}

	}

}
