package org.apache.http.conn.ssl;

import org.apache.http.annotation.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class AllowAllHostnameVerifierHC4 extends AbstractVerifierHC4 {
    public final String toString() {
        return "ALLOW_ALL";
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String str, String[] strArr, String[] strArr2) {
    }
}
