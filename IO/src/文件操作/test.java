package 文件操作;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws Exception {
//		File file=new File("e:/file.txt");//逻辑文件路径
//		file.createNewFile();//创建一个新文件

        File file11=new File("C:\\Users\\LinQin\\Desktop\\12\\1\\2");
        file11.mkdirs();
        String absolutePath = file11.getAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(File.separator);//自动适应windows \或者linux /


        File file1=new File("e:");
        String[] list = file1.list();
        for(String s:list){
            System.out.println(s);
        }

        File file=new File("e:");
        File[] listFiles = file.listFiles();

        for(File f:listFiles){
            if(f.isDirectory() && !f.isHidden()){
                System.err.println("------"+f.getName());
            }
        }

    }

}