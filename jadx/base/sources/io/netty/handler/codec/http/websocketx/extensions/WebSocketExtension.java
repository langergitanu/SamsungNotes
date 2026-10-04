package io.netty.handler.codec.http.websocketx.extensions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface WebSocketExtension {
    public static final int RSV1 = 4;
    public static final int RSV2 = 2;
    public static final int RSV3 = 1;

    WebSocketExtensionDecoder newExtensionDecoder();

    WebSocketExtensionEncoder newExtensionEncoder();

    int rsv();
}
