package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2LifecycleManager {
    void closeStream(Http2Stream http2Stream, ChannelFuture channelFuture);

    void closeStreamLocal(Http2Stream http2Stream, ChannelFuture channelFuture);

    void closeStreamRemote(Http2Stream http2Stream, ChannelFuture channelFuture);

    ChannelFuture goAway(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelPromise channelPromise);

    void onError(ChannelHandlerContext channelHandlerContext, boolean z, Throwable th);

    ChannelFuture resetStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise);
}
