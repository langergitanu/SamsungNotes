package io.netty.channel;

import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelOutboundHandler extends ChannelHandler {
    void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise);

    void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise);

    void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void flush(ChannelHandlerContext channelHandlerContext);

    void read(ChannelHandlerContext channelHandlerContext);

    void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise);
}
