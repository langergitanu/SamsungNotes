package io.netty.handler.address;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class ResolveAddressHandler extends ChannelOutboundHandlerAdapter {
    private final AddressResolverGroup<? extends SocketAddress> resolverGroup;

    public ResolveAddressHandler(AddressResolverGroup<? extends SocketAddress> addressResolverGroup) {
        this.resolverGroup = (AddressResolverGroup) ObjectUtil.checkNotNull(addressResolverGroup, "resolverGroup");
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void connect(final ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        AddressResolver<T> resolver = this.resolverGroup.getResolver(channelHandlerContext.executor());
        if (resolver.isSupported(socketAddress) && !resolver.isResolved(socketAddress)) {
            resolver.resolve(socketAddress).addListener(new FutureListener<SocketAddress>() { // from class: io.netty.handler.address.ResolveAddressHandler.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<SocketAddress> future) {
                    Throwable thCause = future.cause();
                    if (thCause != null) {
                        channelPromise.setFailure(thCause);
                    } else {
                        channelHandlerContext.connect(future.getNow(), socketAddress2, channelPromise);
                    }
                    channelHandlerContext.pipeline().remove(ResolveAddressHandler.this);
                }
            });
        } else {
            channelHandlerContext.connect(socketAddress, socketAddress2, channelPromise);
            channelHandlerContext.pipeline().remove(this);
        }
    }
}
