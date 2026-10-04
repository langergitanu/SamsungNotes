package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2FrameListener {
    int onDataRead(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z);

    void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf);

    void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i4, boolean z2);

    void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z);

    void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j);

    void onPingRead(ChannelHandlerContext channelHandlerContext, long j);

    void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z);

    void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i4);

    void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i, long j);

    void onSettingsAckRead(ChannelHandlerContext channelHandlerContext);

    void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings);

    void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf);

    void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i, int i2);
}
