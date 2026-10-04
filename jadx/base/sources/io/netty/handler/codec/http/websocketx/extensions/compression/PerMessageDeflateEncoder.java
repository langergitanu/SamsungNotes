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
class PerMessageDeflateEncoder extends DeflateEncoder {
    private boolean compressing;

    public PerMessageDeflateEncoder(int i, int i2, boolean z) {
        super(i, i2, z, WebSocketExtensionFilter.NEVER_SKIP);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) {
        if (!super.acceptOutboundMessage(obj)) {
            return false;
        }
        WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
        if (extensionEncoderFilter().mustSkip(webSocketFrame)) {
            if (this.compressing) {
                throw new IllegalStateException("Cannot skip per message deflate encoder, compression in progress");
            }
            return false;
        }
        if (((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) && (webSocketFrame.rsv() & 4) == 0) {
            return true;
        }
        return (webSocketFrame instanceof ContinuationWebSocketFrame) && this.compressing;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder, io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) {
        encode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder
    public boolean removeFrameTail(WebSocketFrame webSocketFrame) {
        return webSocketFrame.isFinalFragment();
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder
    public int rsv(WebSocketFrame webSocketFrame) {
        return ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) ? webSocketFrame.rsv() | 4 : webSocketFrame.rsv();
    }

    public PerMessageDeflateEncoder(int i, int i2, boolean z, WebSocketExtensionFilter webSocketExtensionFilter) {
        super(i, i2, z, webSocketExtensionFilter);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.extensions.compression.DeflateEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) {
        super.encode2(channelHandlerContext, webSocketFrame, list);
        if (webSocketFrame.isFinalFragment()) {
            this.compressing = false;
        } else if ((webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame)) {
            this.compressing = true;
        }
    }
}
