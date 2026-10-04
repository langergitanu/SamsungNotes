package io.netty.handler.address;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DynamicAddressConnectHandler extends ChannelOutboundHandlerAdapter {
    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public final void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        try {
            channelHandlerContext.connect(remoteAddress(socketAddress, socketAddress2), localAddress(socketAddress, socketAddress2), channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.address.DynamicAddressConnectHandler.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        channelFuture.channel().pipeline().remove(DynamicAddressConnectHandler.this);
                    }
                }
            });
        } catch (Exception e) {
            channelPromise.setFailure((Throwable) e);
        }
    }

    public SocketAddress localAddress(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return socketAddress2;
    }

    public SocketAddress remoteAddress(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return socketAddress;
    }
}
