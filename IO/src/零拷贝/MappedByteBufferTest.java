package 零拷贝;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/07/19
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\certs\\证书使用说明.txt");
        long len = file.length();
        byte[] ds = new byte[(int) len];
        // 映射到内存
        MappedByteBuffer mappedByteBuffer = new FileInputStream(file).getChannel().map(FileChannel.MapMode.READ_ONLY, 0,
                len);
        for (int offset = 0; offset < len; offset++) {
            byte b = mappedByteBuffer.get();
            ds[offset] = b;
        }
        Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(",");
        while (scan.hasNext()) {
            System.out.print(scan.next() + " ");
        }
    }
}
