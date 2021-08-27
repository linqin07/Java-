package 字符流;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class line {

	public static void main(String[] args) throws Exception {
		PrintWriter pw=new PrintWriter(new BufferedOutputStream(new FileOutputStream("e:/printWiter.txt", true), 10),true);
		pw.print("gg");
		pw.print("gg");
		pw.print("gg");
		pw.println();
		pw.close();
	}

}
