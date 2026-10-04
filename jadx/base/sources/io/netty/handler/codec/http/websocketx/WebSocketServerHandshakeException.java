package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class WebSocketServerHandshakeException extends WebSocketHandshakeException {
    private static final long serialVersionUID = 1;
    private final HttpRequest request;

    public WebSocketServerHandshakeException(String str) {
        this(str, null);
    }

    public HttpRequest request() {
        return this.request;
    }

    public WebSocketServerHandshakeException(String str, HttpRequest httpRequest) {
        super(str);
        if (httpRequest != null) {
            this.request = new DefaultHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri(), httpRequest.headers());
        } else {
            this.request = null;
        }
    }
}
