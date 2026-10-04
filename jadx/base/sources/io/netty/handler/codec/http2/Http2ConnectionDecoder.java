package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2ConnectionDecoder extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Http2Connection connection();

    void decodeFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list);

    Http2LocalFlowController flowController();

    Http2FrameListener frameListener();

    void frameListener(Http2FrameListener http2FrameListener);

    void lifecycleManager(Http2LifecycleManager http2LifecycleManager);

    Http2Settings localSettings();

    boolean prefaceReceived();
}
