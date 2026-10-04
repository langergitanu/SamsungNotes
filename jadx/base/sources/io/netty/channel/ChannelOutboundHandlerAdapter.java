package io.netty.channel;

import io.netty.channel.ChannelHandlerMask;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ChannelOutboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelOutboundHandler {
    @Override // io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
        channelHandlerContext.bind(socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        channelHandlerContext.close(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        channelHandlerContext.deregister(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        channelHandlerContext.disconnect(channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void flush(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void read(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.read();
    }

    @Override // io.netty.channel.ChannelOutboundHandler
    @ChannelHandlerMask.Skip
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        channelHandlerContext.write(obj, channelPromise);
    }
}
