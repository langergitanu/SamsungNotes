package com.samsung.android.kmxservice.sdk.e2ee.sks;

import androidx.annotation.Nullable;
import com.samsung.android.kmxservice.sdk.e2ee.data.FabricKeyInfoPQC;
import com.samsung.android.kmxservice.sdk.e2ee.data.KmxDBAdapter;
import com.samsung.android.kmxservice.sdk.e2ee.data.MemberKeyInfo;
import com.samsung.android.kmxservice.sdk.e2ee.data.PackageVO;
import com.samsung.android.kmxservice.sdk.e2ee.data.RecoveryData;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager;
import com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;
import com.samsung.android.kmxservice.sdk.util.SksAttestation;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Triple;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SksKmxE2EEManager implements KmxManager {
    private static final String TAG = "SksKmxE2EEManager";
    private final KeyHandler keyHandler = new SksKeyHandlerImpl();
    private final ServiceKeyManagement serviceKeyManagement;

    public SksKmxE2EEManager(SksAttestation sksAttestation, KmxDBAdapter kmxDBAdapter) {
        this.serviceKeyManagement = new SksServiceKeyManagementImpl(sksAttestation, kmxDBAdapter);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean containsKey(String str) {
        return this.keyHandler.containsKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public String createFabricKey() {
        KmxLogger.m5529i(TAG, "NotSupport, createFabricKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public String createServiceKey(String str) {
        KmxLogger.m5529i(TAG, "NotSupport, createServiceKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean deleteKeys() {
        return this.keyHandler.deleteKeys();
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public byte[] exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr) {
        KmxLogger.m5529i(TAG, "NotSupport, exportFabricKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public byte[] exportServiceKey(String str, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr) {
        KmxLogger.m5529i(TAG, "NotSupport, exportServiceKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public byte[] getChallenge() {
        KmxLogger.m5529i(TAG, "NotSupport, getChallenge. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public Triple<byte[], byte[], X509Certificate[]> getDeviceKey() {
        KmxLogger.m5529i(TAG, "NotSupport, getDeviceKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public MemberKeyInfo getDeviceKeyPQC() {
        KmxLogger.m5529i(TAG, "NotSupport, getDeviceKeyPQC. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    @Nullable
    public String getFabricKeyId() {
        KmxLogger.m5529i(TAG, "NotSupport, getFabricKeyId. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public RecoveryData getRecoveryData() {
        KmxLogger.m5529i(TAG, "NotSupport, getRecoveryData. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    @Nullable
    public String getServiceKeyId(String str) {
        return this.serviceKeyManagement.getServiceKeyId(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public ServiceKeyManagement getServiceKeyManagement() {
        return this.serviceKeyManagement;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public X509Certificate[] getWrapKey(String str) {
        return this.serviceKeyManagement.getWrapKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3) {
        KmxLogger.m5529i(TAG, "NotSupport, importFabricKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    @Nullable
    public String importServiceKey(String str, String str2, byte[] bArr) {
        return this.serviceKeyManagement.importServiceKey(str, str2, bArr);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean isAllowPackage(String str) {
        KmxLogger.m5529i(TAG, "NotSupport, isAllowPackage. SKS");
        return true;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean removeDeviceKey(String str) {
        KmxLogger.m5529i(TAG, "NotSupport, removeDeviceKey. SKS");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean removeFabricKey(String str) {
        KmxLogger.m5529i(TAG, "NotSupport, removeFabricKey. SKS");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean removeServiceKey(String str) {
        return this.serviceKeyManagement.removeServiceKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public void removeWrapKey(String str) {
        this.serviceKeyManagement.removeWrapKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean setRecoveryData(String str, byte[] bArr, String str2) {
        KmxLogger.m5529i(TAG, "NotSupport, setRecoveryData. SKS");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public void updateAllowList(List<PackageVO> list) {
        KmxLogger.m5529i(TAG, "NotSupport, updateAllowList. SKS");
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean validateRecoveryData(String str, byte[] bArr, String str2) {
        KmxLogger.m5529i(TAG, "NotSupport, validateRecoveryData. SKS");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public FabricKeyInfoPQC exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4) {
        KmxLogger.m5529i(TAG, "NotSupport, exportFabricKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4) {
        KmxLogger.m5529i(TAG, "NotSupport, importFabricKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean setRecoveryData(RecoveryData recoveryData, String str) {
        KmxLogger.m5529i(TAG, "NotSupport, setRecoveryData. SKS");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public void updateAllowList(String str, String str2) {
        KmxLogger.m5529i(TAG, "NotSupport, updateAllowList. SKS");
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean validateRecoveryData(RecoveryData recoveryData, String str) {
        KmxLogger.m5529i(TAG, "NotSupport, validateRecoveryData. SKS");
        return false;
    }
}
