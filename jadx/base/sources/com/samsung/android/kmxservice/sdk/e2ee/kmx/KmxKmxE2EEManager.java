package com.samsung.android.kmxservice.sdk.e2ee.kmx;

import androidx.annotation.Nullable;
import com.samsung.android.kmxservice.sdk.e2ee.data.FabricKeyInfoPQC;
import com.samsung.android.kmxservice.sdk.e2ee.data.KmxDBAdapter;
import com.samsung.android.kmxservice.sdk.e2ee.data.MemberKeyInfo;
import com.samsung.android.kmxservice.sdk.e2ee.data.PackageVO;
import com.samsung.android.kmxservice.sdk.e2ee.data.RecoveryData;
import com.samsung.android.kmxservice.sdk.e2ee.manager.AccessManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceInfoManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceKeyManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.FabricKeyManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager;
import com.samsung.android.kmxservice.sdk.e2ee.manager.RecoveryDataManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;
import com.samsung.android.kmxservice.sdk.util.SksAttestation;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Triple;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxKmxE2EEManager implements KmxManager {
    private static final String TAG = "KmxKmxE2EEManager";
    private final AccessManagement accessManagement;
    private final DeviceKeyManagement deviceKeyManagement;
    private final FabricKeyManagement fabricKeyManagement;
    private final KeyHandler keyHandler;
    private final RecoveryDataManagement recoveryDataManagement;
    private final ServiceKeyManagement serviceKeyManagement;

    public KmxKmxE2EEManager(SksAttestation sksAttestation, KmxDBAdapter kmxDBAdapter, DeviceInfoManagement deviceInfoManagement) {
        KmxFabricIdHandlerImpl kmxFabricIdHandlerImpl = new KmxFabricIdHandlerImpl();
        KmxKeyHandlerImpl kmxKeyHandlerImpl = new KmxKeyHandlerImpl();
        this.keyHandler = kmxKeyHandlerImpl;
        AccessManagementImpl accessManagementImpl = new AccessManagementImpl();
        this.accessManagement = accessManagementImpl;
        DeviceKeyManagementImpl deviceKeyManagementImpl = new DeviceKeyManagementImpl(deviceInfoManagement, kmxFabricIdHandlerImpl, kmxKeyHandlerImpl);
        this.deviceKeyManagement = deviceKeyManagementImpl;
        this.fabricKeyManagement = new FabricKeyManagementImpl(deviceInfoManagement, deviceKeyManagementImpl, kmxFabricIdHandlerImpl, kmxKeyHandlerImpl);
        this.recoveryDataManagement = new RecoveryDataManagementImpl(kmxFabricIdHandlerImpl);
        this.serviceKeyManagement = new KmxServiceKeyManagementImpl(sksAttestation, kmxDBAdapter, accessManagementImpl, kmxKeyHandlerImpl);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean containsKey(String str) {
        return this.keyHandler.containsKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public String createFabricKey() {
        return this.fabricKeyManagement.createFabricKey();
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public String createServiceKey(String str) {
        return this.serviceKeyManagement.createServiceKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean deleteKeys() {
        return this.keyHandler.deleteKeys();
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public byte[] exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr) {
        return this.fabricKeyManagement.exportFabricKey(str, bArr, bArr2, x509CertificateArr);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public byte[] exportServiceKey(String str, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr) {
        return this.serviceKeyManagement.exportServiceKey(str, x509CertificateArr, bArr);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public byte[] getChallenge() {
        return this.serviceKeyManagement.getChallenge();
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public Triple<byte[], byte[], X509Certificate[]> getDeviceKey() {
        return this.deviceKeyManagement.getDeviceKey();
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public MemberKeyInfo getDeviceKeyPQC() {
        return this.deviceKeyManagement.getDeviceKeyPQC();
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    @Nullable
    public String getFabricKeyId() {
        return this.fabricKeyManagement.getFabricKeyId();
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public RecoveryData getRecoveryData() {
        return this.recoveryDataManagement.getRecoveryData();
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
        KmxLogger.m5529i(TAG, "NotSupport, getWrapKey. KMX");
        return this.serviceKeyManagement.getWrapKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3) {
        return this.fabricKeyManagement.importFabricKey(str, str2, bArr, bArr2, x509CertificateArr, bArr3);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    @Nullable
    public String importServiceKey(String str, String str2, byte[] bArr) {
        return this.serviceKeyManagement.importServiceKey(str, str2, bArr);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean isAllowPackage(String str) {
        return this.accessManagement.isAllowPackage(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean removeDeviceKey(String str) {
        return this.deviceKeyManagement.removeDeviceKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean removeFabricKey(String str) {
        return this.fabricKeyManagement.removeFabricKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean removeServiceKey(String str) {
        return this.serviceKeyManagement.removeServiceKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public void removeWrapKey(String str) {
        KmxLogger.m5529i(TAG, "NotSupport, getWrapKey. KMX");
        this.serviceKeyManagement.removeWrapKey(str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean setRecoveryData(String str, byte[] bArr, String str2) {
        return this.recoveryDataManagement.setRecoveryData(str, bArr, str2);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public void updateAllowList(List<PackageVO> list) {
        this.accessManagement.updateAllowList(list);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean validateRecoveryData(String str, byte[] bArr, String str2) {
        return this.recoveryDataManagement.validateRecoveryData(str, bArr, str2);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public FabricKeyInfoPQC exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4) {
        return this.fabricKeyManagement.exportFabricKey(str, bArr, bArr2, x509CertificateArr, bArr3, bArr4);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4) {
        return this.fabricKeyManagement.importFabricKey(str, str2, bArr, bArr2, x509CertificateArr, bArr3, bArr4);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean setRecoveryData(RecoveryData recoveryData, String str) {
        return this.recoveryDataManagement.setRecoveryData(recoveryData, str);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public void updateAllowList(String str, String str2) {
        this.accessManagement.updateAllowList(str, str2);
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager
    public boolean validateRecoveryData(RecoveryData recoveryData, String str) {
        return this.recoveryDataManagement.validateRecoveryData(recoveryData, str);
    }
}
