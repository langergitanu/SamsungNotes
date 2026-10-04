package com.samsung.android.kmxservice.sdk.e2ee.manager;

import androidx.annotation.Nullable;
import com.samsung.android.kmxservice.sdk.e2ee.data.FabricKeyInfoPQC;
import com.samsung.android.kmxservice.sdk.e2ee.data.MemberKeyInfo;
import com.samsung.android.kmxservice.sdk.e2ee.data.PackageVO;
import com.samsung.android.kmxservice.sdk.e2ee.data.RecoveryData;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Triple;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface KmxManager {
    boolean containsKey(String str);

    String createFabricKey();

    String createServiceKey(String str);

    boolean deleteKeys();

    FabricKeyInfoPQC exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4);

    byte[] exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr);

    byte[] exportServiceKey(String str, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr);

    byte[] getChallenge();

    Triple<byte[], byte[], X509Certificate[]> getDeviceKey();

    MemberKeyInfo getDeviceKeyPQC();

    @Nullable
    String getFabricKeyId();

    RecoveryData getRecoveryData();

    @Nullable
    String getServiceKeyId(String str);

    ServiceKeyManagement getServiceKeyManagement();

    X509Certificate[] getWrapKey(String str);

    String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3);

    String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4);

    @Nullable
    String importServiceKey(String str, String str2, byte[] bArr);

    boolean isAllowPackage(String str);

    boolean removeDeviceKey(String str);

    boolean removeFabricKey(String str);

    boolean removeServiceKey(String str);

    void removeWrapKey(String str);

    boolean setRecoveryData(RecoveryData recoveryData, String str);

    boolean setRecoveryData(String str, byte[] bArr, String str2);

    void updateAllowList(String str, String str2);

    void updateAllowList(List<PackageVO> list);

    boolean validateRecoveryData(RecoveryData recoveryData, String str);

    boolean validateRecoveryData(String str, byte[] bArr, String str2);
}
