package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class WebSocketClientHandshakeException extends WebSocketHandshakeException {
    private static final long serialVersionUID = 1;
    private final HttpResponse response;

    public WebSocketClientHandshakeException(String str) {
        this(str, null);
    }

    public HttpResponse response() {
        return this.response;
    }

    public WebSocketClientHandshakeException(String str, HttpResponse httpResponse) {
        super(str);
        if (httpResponse != null) {
            this.response = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status(), httpResponse.headers());
        } else {
            this.response = null;
        }
    }
}
