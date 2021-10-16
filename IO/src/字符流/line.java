package 字符流;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class line {

	public static void main(String[] args) throws Exception {
		// PrintWriter pw=new PrintWriter(new BufferedOutputStream(new FileOutputStream("e:/printWiter.txt", true), 10),true);
		// pw.print("gg");
		// pw.print("gg");
		// pw.print("gg");
		// pw.println();
		// pw.close();

        Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = Arrays.asList(ints);
        System.out.println(list.toString());

        List<Integer> integers = list.subList(0, 5);
        System.out.println(integers.toString());
        System.out.println(list.subList(6, ints.length));
    }

}
