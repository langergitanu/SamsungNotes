package org.apache.http.conn.ssl;

import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TrustSelfSignedStrategy implements TrustStrategy {
    @Override // org.apache.http.conn.ssl.TrustStrategy
    public boolean isTrusted(X509Certificate[] x509CertificateArr, String str) {
        return x509CertificateArr.length == 1;
    }
}
