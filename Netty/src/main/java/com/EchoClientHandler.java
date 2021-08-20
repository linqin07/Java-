package com;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/06
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
// ⇽---  标记该类的实例可以被多个Channel共享
public class EchoClientHandler extends
        SimpleChannelInboundHandler<ByteBuf> {
    @Override
    // 在一个连接建立时被调用
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",/*     ⇽---  当被通知Channel是活跃的时候，发送一条消息*/
                CharsetUtil.UTF_8));
    }

    @Override
    //每当接收数据时，都会调用这个方法
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        System.out.println(    /*⇽---  记录已接收消息的转储*/
        "Client received: " + in.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,    /* ⇽---  在发生异常时，记录错误并关闭Channel*/
            Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}