package io.netty.channel.socket.oio;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;
import io.netty.channel.socket.SocketChannelConfig;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public interface OioSocketChannelConfig extends SocketChannelConfig {
    int getSoTimeout();

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig
    OioSocketChannelConfig setAllowHalfClosure(boolean z);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAutoClose(boolean z);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setAutoRead(boolean z);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setConnectTimeoutMillis(int i);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setKeepAlive(boolean z);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    OioSocketChannelConfig setMaxMessagesPerRead(int i);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setPerformancePreferences(int i, int i2, int i4);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setReceiveBufferSize(int i);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setReuseAddress(boolean z);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setSendBufferSize(int i);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setSoLinger(int i);

    OioSocketChannelConfig setSoTimeout(int i);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setTcpNoDelay(boolean z);

    @Override // io.netty.channel.socket.SocketChannelConfig
    OioSocketChannelConfig setTrafficClass(int i);

    @Override // io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferHighWaterMark(int i);

    @Override // io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferLowWaterMark(int i);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.socket.SocketChannelConfig, io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    OioSocketChannelConfig setWriteSpinCount(int i);
}
