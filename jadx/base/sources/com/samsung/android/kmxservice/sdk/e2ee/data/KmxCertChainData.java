package com.samsung.android.kmxservice.sdk.e2ee.data;

import java.io.Serializable;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxCertChainData implements Serializable {
    public X509Certificate[] mCertChain;

    public KmxCertChainData() {
    }

    public void setCertChain(X509Certificate[] x509CertificateArr) {
        this.mCertChain = x509CertificateArr;
    }

    public KmxCertChainData(X509Certificate[] x509CertificateArr) {
        this.mCertChain = x509CertificateArr;
    }
}
