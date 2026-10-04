package com.samsung.android.kmxservice.sdk.e2ee.manager;

import androidx.annotation.Nullable;
import java.security.cert.X509Certificate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ServiceKeyManagement {
    String createServiceKey(String str);

    byte[] exportServiceKey(String str, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr);

    byte[] getChallenge();

    String getServiceKeyId(String str);

    X509Certificate[] getWrapKey(String str);

    String importServiceKey(String str, String str2, byte[] bArr);

    void initialize();

    boolean removeServiceKey(String str);

    void removeWrapKey(String str);
}
