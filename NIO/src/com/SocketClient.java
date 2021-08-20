package com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;

public class SocketClient {
    private SocketChannel channel = null;
    private ByteBuffer buff = ByteBuffer.allocate(1024);
    private IntBuffer intbuff = buff.asIntBuffer();

    public static void main(String[] args) {
        int result = new SocketClient().getSum(1, 2);
        System.out.println("加法运算的结果" + result);
    }

    /**
     * 连接服务器端指定端口年
     *
     * @return
     * @throws IOException
     */
    public SocketChannel connet() throws IOException {
        return SocketChannel.open(new InetSocketAddress(8888));
    }

    /**
     * 发送加法请求到服务器
     *
     * @param a
     * @param b
     * @throws IOException
     */
    public void sendRequest(int a, int b) throws IOException {
        buff.clear();
        intbuff.put(0, a);
        intbuff.put(1, b);
        channel.write(buff);
        System.out.println("发送加法请求");

    }

    /**
     * 接收服务器运算结果
     *
     * @return
     * @throws IOException
     */
    public int receiveResult() throws IOException {
        buff.clear();
        channel.read(buff);
        return intbuff.get(0);
    }

    /**
     * 获取加法的结果
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        int result = 0;
        try {
            channel = connet();
            sendRequest(a, b);
            result = receiveResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
