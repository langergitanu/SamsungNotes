package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.ContinuationWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class PerMessageDeflateDecoder extends DeflateDecoder {
    private boolean compressing;

    public PerMessageDeflateDecoder(boolean z) {
        super(z, WebSocketExtensionFilter.NEVER_SKIP);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) {
        if (!super.acceptInboundMessage(obj)) {
            return false;
        }
        WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
        if (extensionDecoderFilter().mustSkip(webSocketFrame)) {
            if (this.compressing) {
                throw new IllegalStateException("Cannot skip per message deflate decoder, compression in progress");
            }
            return false;
        }
        if (((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) && (webSocketFrame.rsv() & 4) > 0) {
            return true;
        }
        return (webSocketFrame instanceof ContinuationWebSocketFrame) && this.compressing;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    public boolean appendFrameTail(WebSocketFrame webSocketFrame) {
        return webSocketFrame.isFinalFragment();
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder, io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    public int newRsv(WebSocketFrame webSocketFrame) {
        return (webSocketFrame.rsv() & 4) > 0 ? webSocketFrame.rsv() ^ 4 : webSocketFrame.rsv();
    }

    public PerMessageDeflateDecoder(boolean z, WebSocketExtensionFilter webSocketExtensionFilter) {
        super(z, webSocketExtensionFilter);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) {
        super.decode2(channelHandlerContext, webSocketFrame, list);
        if (webSocketFrame.isFinalFragment()) {
            this.compressing = false;
        } else if ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) {
            this.compressing = true;
        }
    }
}
