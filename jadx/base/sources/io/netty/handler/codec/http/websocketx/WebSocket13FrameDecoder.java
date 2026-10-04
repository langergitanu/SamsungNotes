package io.netty.handler.codec.http.websocketx;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WebSocket13FrameDecoder extends WebSocket08FrameDecoder {
    public WebSocket13FrameDecoder(boolean z, boolean z2, int i) {
        this(z, z2, i, false);
    }

    public WebSocket13FrameDecoder(boolean z, boolean z2, int i, boolean z3) {
        this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(z).allowExtensions(z2).maxFramePayloadLength(i).allowMaskMismatch(z3).build());
    }

    public WebSocket13FrameDecoder(WebSocketDecoderConfig webSocketDecoderConfig) {
        super(webSocketDecoderConfig);
    }
}
