package okhttp3;

import io.netty.handler.ssl.SslProtocols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
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
        str.getClass();
        switch (str) {
            case "TLSv1.1":
                return TLS_1_1;
            case "TLSv1.2":
                return TLS_1_2;
            case "TLSv1.3":
                return TLS_1_3;
            case "SSLv3":
                return SSL_3_0;
            case "TLSv1":
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
        }
    }

    public static List<TlsVersion> forJavaNames(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(forJavaName(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String javaName() {
        return this.javaName;
    }
}
