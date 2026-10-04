package io.netty.handler.codec.http.websocketx;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class WebSocketHandshakeException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public WebSocketHandshakeException(String str) {
        super(str);
    }

    public WebSocketHandshakeException(String str, Throwable th) {
        super(str, th);
    }
}
