package io.netty.channel;

import io.netty.channel.ChannelHandlerMask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler {
    @ChannelHandlerMask.Skip
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelActive();
    }

    @ChannelHandlerMask.Skip
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelInactive();
    }

    @ChannelHandlerMask.Skip
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelReadComplete();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelRegistered();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelUnregistered();
    }

    @Override // io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    @ChannelHandlerMask.Skip
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.fireExceptionCaught(th);
    }

    @ChannelHandlerMask.Skip
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        channelHandlerContext.fireUserEventTriggered(obj);
    }
}
