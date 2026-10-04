package com.google.android.play.core.internal;

import java.security.cert.X509Certificate;

/* JADX INFO: renamed from: com.google.android.play.core.internal.f */
/* JADX INFO: loaded from: classes5.dex */
final class C5222f extends C5223g {

    /* JADX INFO: renamed from: a */
    private final byte[] f2991a;

    public C5222f(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f2991a = bArr;
    }

    @Override // com.google.android.play.core.internal.C5223g, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f2991a;
    }
}
