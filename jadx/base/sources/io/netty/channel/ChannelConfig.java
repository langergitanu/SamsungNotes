package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ChannelConfig {
    ByteBufAllocator getAllocator();

    int getConnectTimeoutMillis();

    @Deprecated
    int getMaxMessagesPerRead();

    MessageSizeEstimator getMessageSizeEstimator();

    <T> T getOption(ChannelOption<T> channelOption);

    Map<ChannelOption<?>, Object> getOptions();

    <T extends RecvByteBufAllocator> T getRecvByteBufAllocator();

    int getWriteBufferHighWaterMark();

    int getWriteBufferLowWaterMark();

    WriteBufferWaterMark getWriteBufferWaterMark();

    int getWriteSpinCount();

    boolean isAutoClose();

    boolean isAutoRead();

    ChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    ChannelConfig setAutoClose(boolean z);

    ChannelConfig setAutoRead(boolean z);

    ChannelConfig setConnectTimeoutMillis(int i);

    @Deprecated
    ChannelConfig setMaxMessagesPerRead(int i);

    ChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    <T> boolean setOption(ChannelOption<T> channelOption, T t);

    boolean setOptions(Map<ChannelOption<?>, ?> map);

    ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    ChannelConfig setWriteBufferHighWaterMark(int i);

    ChannelConfig setWriteBufferLowWaterMark(int i);

    ChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    ChannelConfig setWriteSpinCount(int i);
}
