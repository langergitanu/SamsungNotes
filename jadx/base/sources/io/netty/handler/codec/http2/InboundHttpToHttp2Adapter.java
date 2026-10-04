package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http2.HttpConversionUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class InboundHttpToHttp2Adapter extends ChannelInboundHandlerAdapter {
    private final Http2Connection connection;
    private final Http2FrameListener listener;

    public InboundHttpToHttp2Adapter(Http2Connection http2Connection, Http2FrameListener http2FrameListener) {
        this.connection = http2Connection;
        this.listener = http2FrameListener;
    }

    private static int getStreamId(Http2Connection http2Connection, HttpHeaders httpHeaders) {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), http2Connection.remote().incrementAndGetNextStreamId());
    }

    public static void handle(ChannelHandlerContext channelHandlerContext, Http2Connection http2Connection, Http2FrameListener http2FrameListener, FullHttpMessage fullHttpMessage) {
        boolean z;
        try {
            int streamId = getStreamId(http2Connection, fullHttpMessage.headers());
            Http2Stream http2StreamStream = http2Connection.stream(streamId);
            if (http2StreamStream == null) {
                http2StreamStream = http2Connection.remote().createStream(streamId, false);
            }
            fullHttpMessage.headers().set(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), HttpScheme.HTTP.name());
            Http2Headers http2Headers = HttpConversionUtil.toHttp2Headers((HttpMessage) fullHttpMessage, true);
            boolean zIsReadable = fullHttpMessage.content().isReadable();
            boolean zIsEmpty = fullHttpMessage.trailingHeaders().isEmpty();
            http2FrameListener.onHeadersRead(channelHandlerContext, streamId, http2Headers, 0, !zIsReadable && zIsEmpty);
            if (zIsReadable) {
                z = zIsEmpty;
                http2FrameListener.onDataRead(channelHandlerContext, streamId, fullHttpMessage.content(), 0, z);
            } else {
                z = zIsEmpty;
            }
            if (!z) {
                http2FrameListener.onHeadersRead(channelHandlerContext, streamId, HttpConversionUtil.toHttp2Headers(fullHttpMessage.trailingHeaders(), true), 0, true);
            }
            http2StreamStream.closeRemoteSide();
            fullHttpMessage.release();
        } catch (Throwable th) {
            fullHttpMessage.release();
            throw th;
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof FullHttpMessage) {
            handle(channelHandlerContext, this.connection, this.listener, (FullHttpMessage) obj);
        } else {
            super.channelRead(channelHandlerContext, obj);
        }
    }
}
