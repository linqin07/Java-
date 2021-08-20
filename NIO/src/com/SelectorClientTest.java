package com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorClientTest {
    private Selector selector;
    private ByteBuffer outBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer inBuffer = ByteBuffer.allocate(1024);
    private int keys = 0;
    private SocketChannel channel = null;

    public static void main(String[] args) {
        new SelectorClientTest().start();
    }

    private void initClient() throws IOException {
        channel = SocketChannel.open();
        selector = Selector.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("127.0.0.1", 8888));
        channel.register(selector, SelectionKey.OP_CONNECT);
    }

    public void listen() throws IOException {
        while (true) {
            keys = this.selector.select();
            if (keys > 0) {
                Iterator<SelectionKey> it = this.selector.selectedKeys()
                        .iterator();
                System.out.println(selector.selectedKeys().size());
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    if (key.isConnectable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        if (channel.isConnectionPending()) {
                            channel.finishConnect();
                            System.out.println("完成连接");
                        }
                        channel.register(selector, SelectionKey.OP_WRITE);

                    } else if (key.isWritable()) {// 在通道上进行写操作
                        SocketChannel channel = (SocketChannel) key.channel();
                        outBuffer.clear();
                        System.out.println("客户端正在写数据");
                        channel.write(ByteBuffer.wrap("我是ClientA".getBytes()));
                        channel.register(selector, SelectionKey.OP_READ);
                        System.out.println("客户端写数据完成");
                    } else if (key.isReadable()) {// 在通道上进行读操作
                        SocketChannel channel = (SocketChannel) key.channel();
                        inBuffer.clear();
                        System.out.println("客户端正在读数据");
                        channel.read(inBuffer);
                        System.out
                                .println("==>" + new String(inBuffer.array()));
                        System.out.println("client finish read data");
                    }

                }
            } else {
                System.out.println("没有找到感兴趣的事件");
            }
        }

    }

    public void start() {
        try {
            initClient();
            listen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
