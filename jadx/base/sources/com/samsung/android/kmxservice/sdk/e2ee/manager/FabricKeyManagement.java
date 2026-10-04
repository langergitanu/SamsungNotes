package com.samsung.android.kmxservice.sdk.e2ee.manager;

import com.samsung.android.kmxservice.sdk.e2ee.data.FabricKeyInfoPQC;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface FabricKeyManagement {
    String createFabricKey();

    FabricKeyInfoPQC exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4);

    byte[] exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr);

    String getFabricKeyId();

    String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3);

    String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4);

    boolean removeFabricKey(String str);
}
