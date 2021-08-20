package 文件复制Files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @Description:
 * @author: LinQin
 * @date: 2019/03/15
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        File file1 = new File("F:\\gradle-4.10.2-bin.zip");
        File file2 = new File("C:\\Users\\LinQin\\Desktop\\gradle-4.10.2-bin.zip");

        Files.copy(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.write(file2.toPath(), File2byte(file1.getPath()));


        //删除
        // if (Files.exists(file2.toPath())) {
        //     Files.delete(file2.toPath());
        // }
        // Files.deleteIfExists(file2.toPath());
        File file3 = new File("C:\\Users\\LinQin\\Desktop\\gradle-4.10.2-bin.zip");
        if (file3.exists()) {
            System.out.println("测试存在");
        }


        // SeekableByteChannel destFileChannel = Files.newByteChannel(destFile);

        // System.in.read();
    }

    public static byte[] File2byte(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }
}
