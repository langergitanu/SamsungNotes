package com.samsung.android.kmxservice.sdk.e2ee;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.samsung.android.kmxservice.sdk.e2ee.common.DeviceInfoManagementImpl;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxCipherImpl;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.FabricKeyInfoPQC;
import com.samsung.android.kmxservice.sdk.e2ee.data.KmxDBAdapter;
import com.samsung.android.kmxservice.sdk.e2ee.data.MemberKeyInfo;
import com.samsung.android.kmxservice.sdk.e2ee.data.PackageVO;
import com.samsung.android.kmxservice.sdk.e2ee.data.RecoveryData;
import com.samsung.android.kmxservice.sdk.e2ee.kmx.KmxKmxE2EEManager;
import com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceInfoManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KmxCipher;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KmxManager;
import com.samsung.android.kmxservice.sdk.e2ee.sks.SksKmxE2EEManager;
import com.samsung.android.kmxservice.sdk.util.KmxFaultBarrier;
import com.samsung.android.kmxservice.sdk.util.SksAttestation;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Triple;
import p099Y2.C0347a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxE2EEManager {
    public static final int KMX_E2EE_TYPE_KMX = 1;
    public static final int KMX_E2EE_TYPE_NONE = 0;
    public static final int KMX_E2EE_TYPE_SKS = 2;
    public static final int KMX_INTEGRITY_NORMAL = 0;
    private final KmxDBAdapter dbAdapter;
    private final DeviceInfoManagement deviceInfoManagement;
    private final KmxCipher kmxCipher;

    @Nullable
    private final KmxManager kmxManager;

    @Nullable
    private final ServiceKeyCache serviceKeyCache;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface KMXE2EEDeviceType {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final KmxE2EEManager INSTANCE = new KmxE2EEManager(0);

        private LazyHolder() {
        }
    }

    public /* synthetic */ KmxE2EEManager(int i) {
        this();
    }

    public static KmxE2EEManager getInstance() {
        KmxSdk.checkIfInitialized();
        return LazyHolder.INSTANCE;
    }

    private void prepare() {
        KmxE2EEManager kmxE2EEManager = LazyHolder.INSTANCE;
        String guid = KmxSdk.getGuid();
        if (guid == null || guid.isEmpty()) {
            Log.e("KMX|getInstance", "KmxSdk is not initialized correctly. should set fabricIdSupplier.");
            return;
        }
        if (kmxE2EEManager.dbAdapter.compareGuid(guid)) {
            return;
        }
        Log.i("KMX|prepare", "User Guid  is different from the value stored in the existing DB.");
        ServiceKeyCache serviceKeyCache = kmxE2EEManager.serviceKeyCache;
        if (serviceKeyCache != null) {
            serviceKeyCache.initialize();
        }
        KmxManager kmxManager = kmxE2EEManager.kmxManager;
        if (kmxManager != null) {
            kmxManager.getServiceKeyManagement().initialize();
        }
    }

    public boolean containsKey(String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.containsKey(str);
    }

    public String createFabricKey() {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.createFabricKey();
    }

    public String createServiceKey(String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.createServiceKey(str);
    }

    public byte[] decryptData(String str, byte[] bArr) {
        prepare();
        ServiceKeyCache serviceKeyCache = this.serviceKeyCache;
        if (serviceKeyCache == null) {
            return null;
        }
        return this.kmxCipher.decryptData(serviceKeyCache.get(str), bArr);
    }

    public boolean decryptStream(String str, InputStream inputStream, OutputStream outputStream) {
        prepare();
        ServiceKeyCache serviceKeyCache = this.serviceKeyCache;
        if (serviceKeyCache == null) {
            return false;
        }
        return this.kmxCipher.decryptStream(serviceKeyCache.get(str), inputStream, outputStream);
    }

    public boolean deleteKeys() {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.deleteKeys();
    }

    public byte[] encryptData(@NonNull String str, byte[] bArr) {
        prepare();
        ServiceKeyCache serviceKeyCache = this.serviceKeyCache;
        if (serviceKeyCache == null) {
            return null;
        }
        return this.kmxCipher.encryptData(serviceKeyCache.get(str), bArr);
    }

    public boolean encryptStream(String str, InputStream inputStream, OutputStream outputStream) {
        prepare();
        ServiceKeyCache serviceKeyCache = this.serviceKeyCache;
        if (serviceKeyCache == null) {
            return false;
        }
        return this.kmxCipher.encryptStream(serviceKeyCache.get(str), inputStream, outputStream);
    }

    public byte[] exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.exportFabricKey(str, bArr, bArr2, x509CertificateArr);
    }

    public byte[] exportServiceKey(String str, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.exportServiceKey(str, x509CertificateArr, bArr);
    }

    public byte[] getChallenge() {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.getChallenge();
    }

    public int getDeviceIntegrity() {
        return this.deviceInfoManagement.getDeviceIntegrity();
    }

    public Triple<byte[], byte[], X509Certificate[]> getDeviceKey() {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.getDeviceKey();
    }

    public MemberKeyInfo getDeviceKeyPQC() {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.getDeviceKeyPQC();
    }

    public int getE2EEDeviceType() {
        return this.deviceInfoManagement.getE2EEDeviceType();
    }

    @Nullable
    public String getFabricKeyId() {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.getFabricKeyId();
    }

    public RecoveryData getRecoveryData() {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.getRecoveryData();
    }

    public String getSAKUid() {
        return this.deviceInfoManagement.getSakUid();
    }

    @Nullable
    @RequiresApi(api = 28)
    public String getServiceKeyId(String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.getServiceKeyId(str);
    }

    public X509Certificate[] getWrapKey(String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.getWrapKey(str);
    }

    public String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.importFabricKey(str, str2, bArr, bArr2, x509CertificateArr, bArr3);
    }

    @Nullable
    public String importServiceKey(String str, String str2, byte[] bArr) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.importServiceKey(str, str2, bArr);
    }

    public boolean isAllowPackage(String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.isAllowPackage(str);
    }

    public boolean removeDeviceKey(String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.removeDeviceKey(str);
    }

    public boolean removeFabricKey(String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.removeFabricKey(str);
    }

    public boolean removeServiceKey(String str) {
        ServiceKeyCache serviceKeyCache;
        prepare();
        if (this.kmxManager == null || (serviceKeyCache = this.serviceKeyCache) == null) {
            return false;
        }
        serviceKeyCache.remove(str);
        return this.kmxManager.removeServiceKey(str);
    }

    public void removeWrapKey(String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return;
        }
        kmxManager.removeWrapKey(str);
    }

    public boolean setRecoveryData(String str, byte[] bArr, String str2) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.setRecoveryData(str, bArr, str2);
    }

    public void updateAllowList(List<PackageVO> list) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return;
        }
        kmxManager.updateAllowList(list);
    }

    public boolean validateRecoveryData(String str, byte[] bArr, String str2) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.validateRecoveryData(str, bArr, str2);
    }

    private KmxE2EEManager() {
        KmxDBAdapter kmxDBAdapter = new KmxDBAdapter(KmxSdk.getContext());
        this.dbAdapter = kmxDBAdapter;
        SksAttestation sksAttestation = (SksAttestation) KmxFaultBarrier.get(new C0347a(25), null);
        DeviceInfoManagementImpl deviceInfoManagementImpl = new DeviceInfoManagementImpl(sksAttestation);
        this.deviceInfoManagement = deviceInfoManagementImpl;
        this.kmxCipher = new KmxCipherImpl();
        if (deviceInfoManagementImpl.getE2EEDeviceType() == 1) {
            this.kmxManager = new KmxKmxE2EEManager(sksAttestation, kmxDBAdapter, deviceInfoManagementImpl);
        } else if (deviceInfoManagementImpl.getE2EEDeviceType() == 2) {
            this.kmxManager = new SksKmxE2EEManager(sksAttestation, kmxDBAdapter);
        } else {
            this.kmxManager = null;
        }
        KmxManager kmxManager = this.kmxManager;
        this.serviceKeyCache = kmxManager != null ? new ServiceKeyCache(kmxManager.getServiceKeyManagement()) : null;
    }

    public int getDeviceIntegrity(boolean z) {
        return this.deviceInfoManagement.getDeviceIntegrity(z);
    }

    public boolean decryptStream(String str, InputStream inputStream, OutputStream outputStream, @Nullable CryptoProgressListener cryptoProgressListener) {
        prepare();
        ServiceKeyCache serviceKeyCache = this.serviceKeyCache;
        if (serviceKeyCache == null) {
            return false;
        }
        return this.kmxCipher.decryptStream(serviceKeyCache.get(str), inputStream, outputStream, cryptoProgressListener);
    }

    public boolean encryptStream(String str, InputStream inputStream, OutputStream outputStream, @Nullable CryptoProgressListener cryptoProgressListener) {
        prepare();
        ServiceKeyCache serviceKeyCache = this.serviceKeyCache;
        if (serviceKeyCache == null) {
            return false;
        }
        return this.kmxCipher.encryptStream(serviceKeyCache.get(str), inputStream, outputStream, cryptoProgressListener);
    }

    public FabricKeyInfoPQC exportFabricKey(String str, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.exportFabricKey(str, bArr, bArr2, x509CertificateArr, bArr3, bArr4);
    }

    public String importFabricKey(String str, String str2, byte[] bArr, byte[] bArr2, X509Certificate[] x509CertificateArr, byte[] bArr3, byte[] bArr4) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return null;
        }
        return kmxManager.importFabricKey(str, str2, bArr, bArr2, x509CertificateArr, bArr3, bArr4);
    }

    public boolean setRecoveryData(RecoveryData recoveryData, String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.setRecoveryData(recoveryData, str);
    }

    public void updateAllowList(String str, String str2) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return;
        }
        kmxManager.updateAllowList(str, str2);
    }

    public boolean validateRecoveryData(RecoveryData recoveryData, String str) {
        prepare();
        KmxManager kmxManager = this.kmxManager;
        if (kmxManager == null) {
            return false;
        }
        return kmxManager.validateRecoveryData(recoveryData, str);
    }
}
