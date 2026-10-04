package io.netty.handler.codec.http.websocketx;

import io.grpc.internal.GrpcUtil;
import io.netty.util.AsciiString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class WebSocketScheme {

    /* JADX INFO: renamed from: WS */
    public static final WebSocketScheme f8899WS = new WebSocketScheme(80, "ws");
    public static final WebSocketScheme WSS = new WebSocketScheme(GrpcUtil.DEFAULT_PORT_SSL, "wss");
    private final AsciiString name;
    private final int port;

    private WebSocketScheme(int i, String str) {
        this.port = i;
        this.name = AsciiString.cached(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WebSocketScheme)) {
            return false;
        }
        WebSocketScheme webSocketScheme = (WebSocketScheme) obj;
        return webSocketScheme.port() == this.port && webSocketScheme.name().equals(this.name);
    }

    public int hashCode() {
        return this.name.hashCode() + (this.port * 31);
    }

    public AsciiString name() {
        return this.name;
    }

    public int port() {
        return this.port;
    }

    public String toString() {
        return this.name.toString();
    }
}
