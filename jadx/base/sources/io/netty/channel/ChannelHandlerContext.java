package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.AttributeMap;
import io.netty.util.concurrent.EventExecutor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelHandlerContext extends AttributeMap, ChannelInboundInvoker, ChannelOutboundInvoker {
    ByteBufAllocator alloc();

    @Override // io.netty.util.AttributeMap
    @Deprecated
    <T> Attribute<T> attr(AttributeKey<T> attributeKey);

    Channel channel();

    EventExecutor executor();

    ChannelHandlerContext fireChannelActive();

    ChannelHandlerContext fireChannelInactive();

    ChannelHandlerContext fireChannelRead(Object obj);

    ChannelHandlerContext fireChannelReadComplete();

    ChannelHandlerContext fireChannelRegistered();

    ChannelHandlerContext fireChannelUnregistered();

    ChannelHandlerContext fireChannelWritabilityChanged();

    ChannelHandlerContext fireExceptionCaught(Throwable th);

    ChannelHandlerContext fireUserEventTriggered(Object obj);

    ChannelHandlerContext flush();

    ChannelHandler handler();

    @Override // io.netty.util.AttributeMap
    @Deprecated
    <T> boolean hasAttr(AttributeKey<T> attributeKey);

    boolean isRemoved();

    String name();

    ChannelPipeline pipeline();

    ChannelHandlerContext read();
}
