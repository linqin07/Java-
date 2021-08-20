package com;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/06
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println(
                    "Usage: " + EchoServer.class.getSimpleName() +
                            " ");
        }
        // 　　⇽---　设置端口值（如果端口参数的格式不正确，则抛出一个NumberFormatException）
        // int port = Integer.parseInt(args[0]);
        // ⇽---  调用服务器的start()方法
        new EchoServer(8080).start();
    }

    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        // ⇽---  ➊ 创建Event-LoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //
            ServerBootstrap b = new ServerBootstrap();
            // 设置参数
            // b.option(ChannelOption.SO_BACKLOG, 2048); //取出链接缓存大小为2048的channel
            // b.childOption(ChannelOption.SO_KEEPALIVE, true);//sokcet链接的设置，维持链接的活跃
            // b.childOption(ChannelOption.TCP_NODELAY, true);//socket关闭延迟发送


            b.group(group)
                    .channel(NioServerSocketChannel.class)    /*⇽---　 ❸ 指定所使用的NIO传输Channel*/
                    .localAddress(new InetSocketAddress(port)) /*　　⇽---　 ❹ 使用指定的端口设置套接字地址*/
                    .childHandler(new ChannelInitializer() {
                        @Override
                        // ❺添加一个EchoServer-Handler到子Channel的ChannelPipeline
                        protected void initChannel(Channel ch) throws Exception {
                            ch.pipeline().addLast(serverHandler); /*　　⇽---　 EchoServerHandler被标注为@Shareable，所以我们可以总是使用同样的实例*/
                        }
                    });

                      // .childHandler(new IdleStateHandlerInitializer()); 心跳检测
            ChannelFuture f = b.bind().sync();   /* ⇽---   ❻ 异步地绑定服务器；调用sync()方法阻塞等待直到绑定完成*/
            f.channel().closeFuture().sync();/*　　⇽---　 ❼ 获取Channel的CloseFuture，并且阻塞当前线程直到它完成*/
        } finally {
            group.shutdownGracefully().sync();    /*⇽---   ❽ 关闭EventLoopGroup，释放所有的资源*/
        }
    }
}