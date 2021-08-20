package com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorServerTest {
    private Selector selector;
    private ServerSocketChannel socketChannel;
    private int keys = 0;

    public static void main(String[] args) {
        new SelectorServerTest().start();
    }

    public void initServer() throws IOException {
        this.selector = Selector.open();
        socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("127.0.0.1", 8888));
        // 一定要配置为非堵塞
        socketChannel.configureBlocking(false);
        SelectionKey key = socketChannel.register(selector,
                SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        System.out.println("服务已经启动成功");
        while (true) {
            // 阻塞到至少有一个通道在你注册的事件上就绪了。
            keys = this.selector.select();
            Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
            System.out.println(selector.selectedKeys().size());
            if (keys > 0) {
                // 进行轮询
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    // 客户端处理请求连接事件
                    if (key.isAcceptable()) {
                        socketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel channel = socketChannel.accept();
                        channel.configureBlocking(false);

                        channel.write(ByteBuffer.wrap(new String("hello")
                                .getBytes()));
                        channel.register(this.selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        read(key);
                    }

                }
            } else {
                System.out.println("select finish whitout any keys.");
            }
        }
    }

    public void read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int lenth = channel.read(buffer);
        System.out.println("服务端接收到的信息为" + new String(buffer.array(), 0, lenth));
        System.out.println();
    }

    public void start() {
        try {
            SelectorServerTest ns = new SelectorServerTest();
            ns.initServer();
            ns.listen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
