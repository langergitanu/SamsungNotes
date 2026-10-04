package io.netty.handler.codec.http.websocketx.extensions;

import androidx.compose.runtime.AbstractC1974b;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WebSocketClientExtensionHandler extends ChannelDuplexHandler {
    private final List<WebSocketClientExtensionHandshaker> extensionHandshakers;

    public WebSocketClientExtensionHandler(WebSocketClientExtensionHandshaker... webSocketClientExtensionHandshakerArr) {
        this.extensionHandshakers = Arrays.asList(ObjectUtil.checkNonEmpty(webSocketClientExtensionHandshakerArr, "extensionHandshakers"));
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpResponse.headers())) {
                String asString = httpResponse.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                if (asString != null) {
                    List<WebSocketExtensionData> listExtractExtensions = WebSocketExtensionUtil.extractExtensions(asString);
                    ArrayList<WebSocketClientExtension> arrayList = new ArrayList(listExtractExtensions.size());
                    int iRsv = 0;
                    for (WebSocketExtensionData webSocketExtensionData : listExtractExtensions) {
                        Iterator<WebSocketClientExtensionHandshaker> it = this.extensionHandshakers.iterator();
                        WebSocketClientExtension webSocketClientExtensionHandshakeExtension = null;
                        while (webSocketClientExtensionHandshakeExtension == null && it.hasNext()) {
                            webSocketClientExtensionHandshakeExtension = it.next().handshakeExtension(webSocketExtensionData);
                        }
                        if (webSocketClientExtensionHandshakeExtension == null || (webSocketClientExtensionHandshakeExtension.rsv() & iRsv) != 0) {
                            throw new CodecException(AbstractC1974b.m1315h('\"', "invalid WebSocket Extension handshake for \"", asString));
                        }
                        iRsv |= webSocketClientExtensionHandshakeExtension.rsv();
                        arrayList.add(webSocketClientExtensionHandshakeExtension);
                    }
                    for (WebSocketClientExtension webSocketClientExtension : arrayList) {
                        WebSocketExtensionDecoder webSocketExtensionDecoderNewExtensionDecoder = webSocketClientExtension.newExtensionDecoder();
                        WebSocketExtensionEncoder webSocketExtensionEncoderNewExtensionEncoder = webSocketClientExtension.newExtensionEncoder();
                        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), webSocketExtensionDecoderNewExtensionDecoder.getClass().getName(), webSocketExtensionDecoderNewExtensionDecoder);
                        channelHandlerContext.pipeline().addAfter(channelHandlerContext.name(), webSocketExtensionEncoderNewExtensionEncoder.getClass().getName(), webSocketExtensionEncoderNewExtensionEncoder);
                    }
                }
                channelHandlerContext.pipeline().remove(channelHandlerContext.name());
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (obj instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) obj;
            if (WebSocketExtensionUtil.isWebsocketUpgrade(httpRequest.headers())) {
                String asString = httpRequest.headers().getAsString(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS);
                ArrayList arrayList = new ArrayList(this.extensionHandshakers.size());
                Iterator<WebSocketClientExtensionHandshaker> it = this.extensionHandshakers.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().newRequestData());
                }
                httpRequest.headers().set(HttpHeaderNames.SEC_WEBSOCKET_EXTENSIONS, WebSocketExtensionUtil.computeMergeExtensionsHeaderValue(asString, arrayList));
            }
        }
        super.write(channelHandlerContext, obj, channelPromise);
    }
}
