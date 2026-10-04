package io.netty.channel.unix;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface DomainSocketChannelConfig extends ChannelConfig {
    DomainSocketReadMode getReadMode();

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAutoClose(boolean z);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAutoRead(boolean z);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setConnectTimeoutMillis(int i);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setMaxMessagesPerRead(int i);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    DomainSocketChannelConfig setReadMode(DomainSocketReadMode domainSocketReadMode);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setWriteBufferHighWaterMark(int i);

    @Override // io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setWriteBufferLowWaterMark(int i);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setWriteSpinCount(int i);
}
