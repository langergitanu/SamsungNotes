package io.netty.handler.codec.http;

import com.microsoft.identity.common.java.AuthenticationConstants;
import io.grpc.internal.GrpcUtil;
import io.netty.util.AsciiString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HttpScheme {
    public static final HttpScheme HTTP = new HttpScheme(80, "http");
    public static final HttpScheme HTTPS = new HttpScheme(GrpcUtil.DEFAULT_PORT_SSL, AuthenticationConstants.HTTPS_PROTOCOL_STRING);
    private final AsciiString name;
    private final int port;

    private HttpScheme(int i, String str) {
        this.port = i;
        this.name = AsciiString.cached(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpScheme)) {
            return false;
        }
        HttpScheme httpScheme = (HttpScheme) obj;
        return httpScheme.port() == this.port && httpScheme.name().equals(this.name);
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
