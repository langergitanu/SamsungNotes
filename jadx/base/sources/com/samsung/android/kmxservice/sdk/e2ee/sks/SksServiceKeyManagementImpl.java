package com.samsung.android.kmxservice.sdk.e2ee.sks;

import android.os.Build;
import androidx.annotation.Nullable;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.KmxDBAdapter;
import com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement;
import com.samsung.android.kmxservice.sdk.util.AndroidKeystoreHelper;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;
import com.samsung.android.kmxservice.sdk.util.SksAttestation;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SksServiceKeyManagementImpl implements ServiceKeyManagement {
    private static final String TAG = "SksServiceKeyManagementImpl";
    private final KmxDBAdapter kmxDBAdapter;
    private final Object lock = new Object();
    private final SksAttestation sksAttestation;

    public SksServiceKeyManagementImpl(SksAttestation sksAttestation, KmxDBAdapter kmxDBAdapter) {
        this.sksAttestation = sksAttestation;
        this.kmxDBAdapter = kmxDBAdapter;
    }

    private Map<String, String> importServiceKeyInternal(Map<String, byte[]> map, Map<String, String> map2) throws KmxException {
        HashMap map3 = new HashMap();
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String str = map2.get(key);
            if (!AndroidKeystoreHelper.secureKeyImport(key, str, entry.getValue())) {
                KmxErrorHandler.throwIfNotSuccess("16-1|Fail to import ServiceKey in SKS", 101);
                return null;
            }
            KmxDBAdapter kmxDBAdapter = this.kmxDBAdapter;
            if (kmxDBAdapter != null) {
                kmxDBAdapter.insertServiceKeyId(KmxSdk.getGuid(), str, key);
            }
            map3.put(str, key);
        }
        return map3;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public String createServiceKey(String str) {
        KmxLogger.m5528e(TAG, "NotSupport, createServiceKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public byte[] exportServiceKey(String str, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr) {
        KmxLogger.m5528e(TAG, "NotSupport, exportServiceKey. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public byte[] getChallenge() {
        KmxLogger.m5529i(TAG, "[getChallenge]");
        KmxLogger.m5528e(TAG, "NotSupport, getChallenge. SKS");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public String getServiceKeyId(String str) {
        KmxLogger.m5529i(TAG, "[getServiceKeyId] : " + str);
        synchronized (this.lock) {
            try {
                KmxDBAdapter kmxDBAdapter = this.kmxDBAdapter;
                String serviceKeyId = kmxDBAdapter != null ? kmxDBAdapter.getServiceKeyId(str) : "";
                if (serviceKeyId == null || serviceKeyId.isEmpty() || AndroidKeystoreHelper.getKey(serviceKeyId) != null) {
                    return serviceKeyId;
                }
                KmxLogger.m5528e(TAG, "17-5|Fail to get serviceKeyId. Key does not exist in keystore");
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public X509Certificate[] getWrapKey(String str) throws KmxException {
        KmxLogger.m5529i(TAG, "[getWrapKey] : " + str);
        if (Build.VERSION.SDK_INT < 28) {
            KmxErrorHandler.throwIfNotSuccess("35-1|Fail to get wrap key. Unsupported device", 1);
            return null;
        }
        X509Certificate[] wrapKey = this.sksAttestation.getWrapKey(str, Long.toString(System.currentTimeMillis()).getBytes(StandardCharsets.UTF_8));
        if (wrapKey != null) {
            return wrapKey;
        }
        KmxErrorHandler.throwIfNotSuccess("35|Fail to get wrap key.", 103);
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public String importServiceKey(String str, String str2, byte[] bArr) throws KmxException {
        KmxLogger.m5529i(TAG, "[importServiceKey] : " + str);
        KmxErrorHandler.throwIfNull(bArr, "14|Input Error : serviceKeyList is empty", 4);
        HashMap map = new HashMap();
        map.put(str2, bArr);
        HashMap map2 = new HashMap();
        map2.put(str2, str);
        Map<String, String> mapImportServiceKeyInternal = importServiceKeyInternal(map, map2);
        KmxErrorHandler.throwIfNull(mapImportServiceKeyInternal, "14 | Fail to import ServiceKey", 101);
        if (mapImportServiceKeyInternal == null) {
            return null;
        }
        KmxErrorHandler.throwIfNull(mapImportServiceKeyInternal.get(str), "14-1 | Fail to import ServiceKey :" + str, 101);
        return str2;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public void initialize() {
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public boolean removeServiceKey(String str) throws KmxException {
        KmxLogger.m5529i(TAG, "[removeServiceKey] : " + str);
        KmxErrorHandler.throwIfNull(str, "28|Input Error : ServiceId cannot be null when remove key", 4);
        String serviceKeyId = getServiceKeyId(str);
        if (serviceKeyId == null) {
            KmxLogger.m5528e(TAG, "28-1|removeServiceKey is failed. Key does not exist");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            AndroidKeystoreHelper.removeKey(serviceKeyId);
            return true;
        }
        KmxLogger.m5528e(TAG, "28-2|removeServiceKey is failed. Unsupported device");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public void removeWrapKey(String str) throws KmxException {
        if (Build.VERSION.SDK_INT < 28) {
            KmxErrorHandler.throwIfNotSuccess("36|Fail to remove wrap key. Unsupported device", 1);
            return;
        }
        KmxLogger.m5529i(TAG, "[removeWrapKey] : " + str);
        this.sksAttestation.removeKey(str);
    }
}
