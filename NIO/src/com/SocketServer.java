package com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketServer {
    private ByteBuffer buff = ByteBuffer.allocate(1024);
    private IntBuffer intbuff = buff.asIntBuffer();
    private SocketChannel socketChannel = null;
    private ServerSocketChannel serverChannel = null;

    public static void main(String[] args) {
        new SocketServer().start();
    }

    /**
     * 打开服务端通道
     *
     * @throws IOException
     */
    public void openChannel() throws IOException {
        //建立一个新的连接通道
        serverChannel = ServerSocketChannel.open();
        //绑定端口
        serverChannel.socket().bind(new InetSocketAddress(8888));
        System.out.println("服务器通道已经打开了");
    }

    public void waitRConn() throws IOException {
        while (true) {
            socketChannel = serverChannel.accept();
            if (null != socketChannel) {
                System.out.println("新的连接加入");
            }
            processReq();
            socketChannel.close();
        }
    }

    public void processReq() throws IOException {
        System.out.println("开始处理客户端数据");
        buff.clear();
        socketChannel.read(buff);
        int result = intbuff.get(0) + intbuff.get(1);
        buff.flip();
        buff.clear();
        intbuff.put(0, result);
        socketChannel.write(buff);
        System.out.println("读取和处理客户端数据完成");
    }

    public void start() {
        try {
            openChannel();
            waitRConn();
            socketChannel.close();
            System.out.println("服务端出来完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
