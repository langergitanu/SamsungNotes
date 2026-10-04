package io.netty.handler.ipfilter;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractRemoteAddressFilter<T extends SocketAddress> extends ChannelInboundHandlerAdapter {
    private boolean handleNewChannel(ChannelHandlerContext channelHandlerContext) {
        SocketAddress socketAddressRemoteAddress = channelHandlerContext.channel().remoteAddress();
        if (socketAddressRemoteAddress == null) {
            return false;
        }
        channelHandlerContext.pipeline().remove(this);
        if (accept(channelHandlerContext, socketAddressRemoteAddress)) {
            channelAccepted(channelHandlerContext, socketAddressRemoteAddress);
            return true;
        }
        ChannelFuture channelFutureChannelRejected = channelRejected(channelHandlerContext, socketAddressRemoteAddress);
        if (channelFutureChannelRejected != null) {
            channelFutureChannelRejected.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            return true;
        }
        channelHandlerContext.close();
        return true;
    }

    public abstract boolean accept(ChannelHandlerContext channelHandlerContext, T t);

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        if (handleNewChannel(channelHandlerContext)) {
            channelHandlerContext.fireChannelActive();
        } else {
            throw new IllegalStateException("cannot determine to accept or reject a channel: " + channelHandlerContext.channel());
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        handleNewChannel(channelHandlerContext);
        channelHandlerContext.fireChannelRegistered();
    }

    public ChannelFuture channelRejected(ChannelHandlerContext channelHandlerContext, T t) {
        return null;
    }

    public void channelAccepted(ChannelHandlerContext channelHandlerContext, T t) {
    }
}
