package io.netty.channel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelInboundHandler extends ChannelHandler {
    void channelActive(ChannelHandlerContext channelHandlerContext);

    void channelInactive(ChannelHandlerContext channelHandlerContext);

    void channelRead(ChannelHandlerContext channelHandlerContext, Object obj);

    void channelReadComplete(ChannelHandlerContext channelHandlerContext);

    void channelRegistered(ChannelHandlerContext channelHandlerContext);

    void channelUnregistered(ChannelHandlerContext channelHandlerContext);

    void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext);

    void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th);

    void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj);
}
