package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WebSocketFrameAggregator extends MessageAggregator<WebSocketFrame, WebSocketFrame, ContinuationWebSocketFrame, WebSocketFrame> {
    public WebSocketFrameAggregator(int i) {
        super(i);
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public boolean closeAfterContinueResponse(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public boolean ignoreContentAfterContinueResponse(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentLengthInvalid(WebSocketFrame webSocketFrame, int i) {
        return false;
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public Object newContinueResponse(WebSocketFrame webSocketFrame, int i, ChannelPipeline channelPipeline) {
        return null;
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public WebSocketFrame beginAggregation(WebSocketFrame webSocketFrame, ByteBuf byteBuf) {
        if (webSocketFrame instanceof TextWebSocketFrame) {
            return new TextWebSocketFrame(true, webSocketFrame.rsv(), byteBuf);
        }
        if (webSocketFrame instanceof BinaryWebSocketFrame) {
            return new BinaryWebSocketFrame(true, webSocketFrame.rsv(), byteBuf);
        }
        throw new Error();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isAggregated(WebSocketFrame webSocketFrame) {
        return webSocketFrame.isFinalFragment() ? !isContentMessage(webSocketFrame) : (isStartMessage(webSocketFrame) || isContentMessage(webSocketFrame)) ? false : true;
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isContentMessage(WebSocketFrame webSocketFrame) {
        return webSocketFrame instanceof ContinuationWebSocketFrame;
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isLastContentMessage(ContinuationWebSocketFrame continuationWebSocketFrame) {
        return isContentMessage((WebSocketFrame) continuationWebSocketFrame) && continuationWebSocketFrame.isFinalFragment();
    }

    @Override // io.netty.handler.codec.MessageAggregator
    public boolean isStartMessage(WebSocketFrame webSocketFrame) {
        return (webSocketFrame instanceof TextWebSocketFrame) || (webSocketFrame instanceof BinaryWebSocketFrame);
    }
}
