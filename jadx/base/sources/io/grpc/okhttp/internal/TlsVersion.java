package io.grpc.okhttp.internal;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.handler.ssl.SslProtocols;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public enum TlsVersion {
    TLS_1_3(SslProtocols.TLS_v1_3),
    TLS_1_2(SslProtocols.TLS_v1_2),
    TLS_1_1(SslProtocols.TLS_v1_1),
    TLS_1_0(SslProtocols.TLS_v1),
    SSL_3_0(SslProtocols.SSL_v3);

    final String javaName;

    TlsVersion(String str) {
        this.javaName = str;
    }

    public static TlsVersion forJavaName(String str) {
        if (SslProtocols.TLS_v1_3.equals(str)) {
            return TLS_1_3;
        }
        if (SslProtocols.TLS_v1_2.equals(str)) {
            return TLS_1_2;
        }
        if (SslProtocols.TLS_v1_1.equals(str)) {
            return TLS_1_1;
        }
        if (SslProtocols.TLS_v1.equals(str)) {
            return TLS_1_0;
        }
        if (SslProtocols.SSL_v3.equals(str)) {
            return SSL_3_0;
        }
        throw new IllegalArgumentException(AbstractC0541b.m772n("Unexpected TLS version: ", str));
    }

    public String javaName() {
        return this.javaName;
    }
}
