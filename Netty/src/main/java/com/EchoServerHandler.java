package com;

/**
 * Hello world!
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
// ⇽---　标示一个Channel- Handler可以被多个Channel安全地共享
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    //对于每个传入的消息都要调用；
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf in = (ByteBuf) msg;
        /*将消息记录到控制台*/
        System.out.println(
                "Server received: " + in.toString(CharsetUtil.UTF_8));

        /*⇽---　将接收到的消息写给发送者，而不冲刷出站消息*/
        ctx.write(in);
        // ctx.flush();

        // ctx.fireChannelxxxx , 这里有多个方法进行控制，多个处理的时候把这个处理交个下个处理。默认是第一个Handler处理了

    }

    @Override
    // 最后一条消息；
    public void channelReadComplete(ChannelHandlerContext ctx) {
        /*　　⇽---　将未决消息冲刷到远程节点，并且关闭该Channel*/
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    // 异常抛出
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();     /*⇽---  打印异常栈跟踪*/
        ctx.close();/*　　⇽---　关闭该Channel*/
    }
}