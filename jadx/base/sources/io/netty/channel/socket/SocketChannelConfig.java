package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SocketChannelConfig extends DuplexChannelConfig {
    int getReceiveBufferSize();

    int getSendBufferSize();

    int getSoLinger();

    int getTrafficClass();

    boolean isKeepAlive();

    boolean isReuseAddress();

    boolean isTcpNoDelay();

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.socket.DuplexChannelConfig
    SocketChannelConfig setAllowHalfClosure(boolean z);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoClose(boolean z);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoRead(boolean z);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setConnectTimeoutMillis(int i);

    SocketChannelConfig setKeepAlive(boolean z);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    SocketChannelConfig setMaxMessagesPerRead(int i);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    SocketChannelConfig setPerformancePreferences(int i, int i2, int i4);

    SocketChannelConfig setReceiveBufferSize(int i);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    SocketChannelConfig setReuseAddress(boolean z);

    SocketChannelConfig setSendBufferSize(int i);

    SocketChannelConfig setSoLinger(int i);

    SocketChannelConfig setTcpNoDelay(boolean z);

    SocketChannelConfig setTrafficClass(int i);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteSpinCount(int i);
}
