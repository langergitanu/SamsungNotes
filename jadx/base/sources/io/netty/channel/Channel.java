package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.AttributeMap;
import java.net.SocketAddress;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Channel extends AttributeMap, ChannelOutboundInvoker, Comparable<Channel> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Unsafe {
        void beginRead();

        void bind(SocketAddress socketAddress, ChannelPromise channelPromise);

        void close(ChannelPromise channelPromise);

        void closeForcibly();

        void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise);

        void deregister(ChannelPromise channelPromise);

        void disconnect(ChannelPromise channelPromise);

        void flush();

        SocketAddress localAddress();

        ChannelOutboundBuffer outboundBuffer();

        RecvByteBufAllocator.Handle recvBufAllocHandle();

        void register(EventLoop eventLoop, ChannelPromise channelPromise);

        SocketAddress remoteAddress();

        ChannelPromise voidPromise();

        void write(Object obj, ChannelPromise channelPromise);
    }

    ByteBufAllocator alloc();

    long bytesBeforeUnwritable();

    long bytesBeforeWritable();

    ChannelFuture closeFuture();

    ChannelConfig config();

    EventLoop eventLoop();

    @Override // io.netty.channel.ChannelOutboundInvoker
    Channel flush();

    /* JADX INFO: renamed from: id */
    ChannelId mo13765id();

    boolean isActive();

    boolean isOpen();

    boolean isRegistered();

    boolean isWritable();

    SocketAddress localAddress();

    ChannelMetadata metadata();

    Channel parent();

    ChannelPipeline pipeline();

    @Override // io.netty.channel.ChannelOutboundInvoker
    Channel read();

    SocketAddress remoteAddress();

    Unsafe unsafe();
}
