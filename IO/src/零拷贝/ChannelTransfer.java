package 零拷贝;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;

/**
 * @Description:
 * @author: LinQin
 * @date: 2021/07/19
 */
public class ChannelTransfer {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\certs\\证书使用说明.txt");
        FileChannel channel = fis.getChannel();
        //transferTo()允许将一个通道交叉连接到另一个通道，而不需要一个中间缓冲区来传递数据
        channel.transferTo(0, channel.size(), Channels.newChannel(System.out));
        channel.close();
        fis.close();
    }
}
