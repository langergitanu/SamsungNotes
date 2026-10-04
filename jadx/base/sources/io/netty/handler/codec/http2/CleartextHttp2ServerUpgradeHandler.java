package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class CleartextHttp2ServerUpgradeHandler extends ByteToMessageDecoder {
    private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Http2CodecUtil.connectionPrefaceBuf()).asReadOnly();
    private final ChannelHandler http2ServerHandler;
    private final HttpServerCodec httpServerCodec;
    private final HttpServerUpgradeHandler httpServerUpgradeHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PriorKnowledgeUpgradeEvent {
        private static final PriorKnowledgeUpgradeEvent INSTANCE = new PriorKnowledgeUpgradeEvent();

        private PriorKnowledgeUpgradeEvent() {
        }
    }

    public CleartextHttp2ServerUpgradeHandler(HttpServerCodec httpServerCodec, HttpServerUpgradeHandler httpServerUpgradeHandler, ChannelHandler channelHandler) {
        this.httpServerCodec = (HttpServerCodec) ObjectUtil.checkNotNull(httpServerCodec, "httpServerCodec");
        this.httpServerUpgradeHandler = (HttpServerUpgradeHandler) ObjectUtil.checkNotNull(httpServerUpgradeHandler, "httpServerUpgradeHandler");
        this.http2ServerHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "http2ServerHandler");
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        ByteBuf byteBuf2 = CONNECTION_PREFACE;
        int i = byteBuf2.readableBytes();
        int iMin = Math.min(byteBuf.readableBytes(), i);
        if (!ByteBufUtil.equals(byteBuf2, byteBuf2.readerIndex(), byteBuf, byteBuf.readerIndex(), iMin)) {
            channelHandlerContext.pipeline().remove(this);
        } else if (iMin == i) {
            channelHandlerContext.pipeline().remove(this.httpServerCodec).remove(this.httpServerUpgradeHandler);
            channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), null, this.http2ServerHandler);
            channelHandlerContext.pipeline().remove(this);
            channelHandlerContext.fireUserEventTriggered((Object) PriorKnowledgeUpgradeEvent.INSTANCE);
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), null, this.httpServerUpgradeHandler).addAfter(channelHandlerContext.name(), null, this.httpServerCodec);
    }
}
