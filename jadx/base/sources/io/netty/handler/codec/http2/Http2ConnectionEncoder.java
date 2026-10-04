package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2ConnectionEncoder extends Http2FrameWriter {
    Http2Connection connection();

    Http2RemoteFlowController flowController();

    Http2FrameWriter frameWriter();

    void lifecycleManager(Http2LifecycleManager http2LifecycleManager);

    Http2Settings pollSentSettings();

    void remoteSettings(Http2Settings http2Settings);

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise);
}
