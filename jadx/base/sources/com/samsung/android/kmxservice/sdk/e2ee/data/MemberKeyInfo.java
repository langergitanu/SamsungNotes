package com.samsung.android.kmxservice.sdk.e2ee.data;

import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MemberKeyInfo {
    private final X509Certificate[] mCertificateChain;
    private final byte[] mEncapKey;
    private final byte[] mEncapKeySignature;
    private final byte[] mMemberKey;
    private final byte[] mSignature;

    public MemberKeyInfo(byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4) {
        this.mMemberKey = bArr;
        this.mSignature = bArr2;
        this.mCertificateChain = x509CertificateArr;
        this.mEncapKey = bArr3;
        this.mEncapKeySignature = bArr4;
    }

    public X509Certificate[] getCertificateChain() {
        return this.mCertificateChain;
    }

    public byte[] getEncapKey() {
        return this.mEncapKey;
    }

    public byte[] getEncapKeySignature() {
        return this.mEncapKeySignature;
    }

    public byte[] getMemberKey() {
        return this.mMemberKey;
    }

    public byte[] getSignature() {
        return this.mSignature;
    }
}
