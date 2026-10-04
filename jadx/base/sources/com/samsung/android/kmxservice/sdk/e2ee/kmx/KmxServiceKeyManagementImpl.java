package com.samsung.android.kmxservice.sdk.e2ee.kmx;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.common.KmxSdk;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CMD;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CONSTANT;
import com.samsung.android.kmxservice.sdk.e2ee.data.KmxCertChainData;
import com.samsung.android.kmxservice.sdk.e2ee.data.KmxDBAdapter;
import com.samsung.android.kmxservice.sdk.e2ee.manager.AccessManagement;
import com.samsung.android.kmxservice.sdk.e2ee.manager.KeyHandler;
import com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement;
import com.samsung.android.kmxservice.sdk.util.AndroidKeystoreHelper;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;
import com.samsung.android.kmxservice.sdk.util.SksAttestation;
import java.io.Serializable;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class KmxServiceKeyManagementImpl implements ServiceKeyManagement {
    private static final String TAG = "ServiceKeyManagementImpl";
    private final AccessManagement accessManagement;
    private final KeyHandler keyHandler;
    private final KmxDBAdapter kmxDBAdapter;
    private final SksAttestation sksAttestation;
    private String mCurServiceId = null;
    private boolean misAllowed = false;
    private final Object lock = new Object();

    public KmxServiceKeyManagementImpl(SksAttestation sksAttestation, KmxDBAdapter kmxDBAdapter, AccessManagement accessManagement, KeyHandler keyHandler) {
        this.sksAttestation = sksAttestation;
        this.kmxDBAdapter = kmxDBAdapter;
        this.accessManagement = accessManagement;
        this.keyHandler = keyHandler;
    }

    private Map<String, byte[]> exportServiceKeyInternal(ArrayList<String> arrayList, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr) throws KmxException {
        if (arrayList == null || arrayList.size() == 0) {
            KmxErrorHandler.throwIfNotSuccess("20|exportServiceKey input is null or empty :" + arrayList, 4);
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(KMX_CONSTANT.KMX_SERVICE_KEY_ID_LIST, arrayList);
        if (x509CertificateArr != null) {
            bundle.putSerializable(KMX_CONSTANT.KMX_CERT_CHAIN, new KmxCertChainData(x509CertificateArr));
            if (bArr != null) {
                KmxLogger.m5529i(TAG, "exportServiceKey challenge is used");
                bundle.putByteArray(KMX_CONSTANT.KMX_CHALLENGE, bArr);
            }
        }
        KmxLogger.m5529i(TAG, "[ExportServiceKey] : " + arrayList.size());
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_EXPORT_SERVICE_KEY, (String) null, bundle);
        if (bundleCall == null) {
            KmxErrorHandler.throwIfNotSuccess("20-0|Fail to export serviceKey", 1);
            return null;
        }
        int i = bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE);
        if (i != 0) {
            KmxErrorHandler.throwIfNotSuccess("20-1|Fail to export serviceKey", i);
            return null;
        }
        Serializable serializable = bundleCall.getSerializable(KMX_CONSTANT.KMX_SERVICE_KEY_LIST);
        if (serializable instanceof Map) {
            return (Map) serializable;
        }
        return null;
    }

    private Map<String, String> importServiceKeyInternal(Map<String, byte[]> map, Map<String, String> map2) throws KmxException {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KMX_CONSTANT.KMX_SERVICE_KEY_LIST, new HashMap(map));
        bundle.putSerializable(KMX_CONSTANT.KMX_SERVICE_ID_LIST, new HashMap(map2));
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_IMPORT_SERVICE_KEY, (String) null, bundle);
        if (bundleCall == null) {
            KmxLogger.m5528e(TAG, "[importServiceKeyInternal] Fail import service key");
            return null;
        }
        Serializable serializable = bundleCall.getSerializable(KMX_CONSTANT.KMX_SERVICE_KEY_ID_LIST);
        if (serializable instanceof HashMap) {
            for (Map.Entry entry : ((HashMap) serializable).entrySet()) {
                KmxDBAdapter kmxDBAdapter = this.kmxDBAdapter;
                if (kmxDBAdapter != null) {
                    kmxDBAdapter.insertServiceKeyId(KmxSdk.getGuid(), (String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        if (serializable instanceof Map) {
            return (Map) serializable;
        }
        KmxErrorHandler.throwIfNotSuccess("16|Fail to import ServiceKey", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public String createServiceKey(String str) throws KmxException {
        KmxLogger.m5529i(TAG, "[createServiceKey] : " + str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        Map<String, String> mapCreateServiceKey = createServiceKey(arrayList);
        if (mapCreateServiceKey == null) {
            KmxErrorHandler.throwIfNotSuccess("21|Fail to create service Key :" + str, 103);
            return null;
        }
        String str2 = mapCreateServiceKey.get(str);
        KmxDBAdapter kmxDBAdapter = this.kmxDBAdapter;
        if (kmxDBAdapter != null) {
            kmxDBAdapter.insertServiceKeyId(KmxSdk.getGuid(), str, str2);
        }
        return str2;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public byte[] exportServiceKey(String str, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr) {
        KmxLogger.m5529i(TAG, "[exportServiceKey] : " + str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        Map<String, byte[]> mapExportServiceKey = exportServiceKey(arrayList, x509CertificateArr, bArr);
        if (mapExportServiceKey != null) {
            return mapExportServiceKey.get(str);
        }
        KmxLogger.m5528e(TAG, "exportServiceKey Fail. ServiceKey is NULL");
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public byte[] getChallenge() throws KmxException {
        KmxLogger.m5529i(TAG, "[getChallenge]");
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_CHALLENGE, (String) null, (Bundle) null);
        if (bundleCall == null) {
            KmxLogger.m5528e(TAG, "[getChallenge] Fail to get challenge.");
            return null;
        }
        byte[] byteArray = bundleCall.getByteArray(KMX_CONSTANT.KMX_CHALLENGE);
        if (byteArray != null) {
            return byteArray;
        }
        KmxErrorHandler.throwIfNotSuccess("34|Fail to get challenge.", 203);
        return null;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public String getServiceKeyId(String str) {
        KmxLogger.m5529i(TAG, "[getServiceKeyId] : " + str);
        synchronized (this.lock) {
            try {
                String str2 = null;
                if (!str.equals(this.mCurServiceId) || !this.misAllowed) {
                    boolean zIsAllowPackage = this.accessManagement.isAllowPackage(str);
                    this.misAllowed = zIsAllowPackage;
                    if (!zIsAllowPackage) {
                        KmxErrorHandler.throwIfNotSuccess("17-1|Fail to get serviceKeyId. Invalid package", 404);
                        return null;
                    }
                    this.mCurServiceId = str;
                }
                Bundle bundle = new Bundle();
                bundle.putString(KMX_CONSTANT.KMX_SERVICE_ID, str);
                bundle.putString(KMX_CONSTANT.KMX_FABRIC_ID, KmxSdk.getGuid());
                Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_SERVICE_KEY_ID, (String) null, bundle);
                if (bundleCall == null) {
                    KmxLogger.m5528e(TAG, "[getServiceKeyId] Fail get service key id");
                    return null;
                }
                String string = bundleCall.getString(KMX_CONSTANT.KMX_SERVICE_KEY_ID);
                KmxDBAdapter kmxDBAdapter = this.kmxDBAdapter;
                if (kmxDBAdapter != null) {
                    kmxDBAdapter.insertServiceKeyId(KmxSdk.getGuid(), str, string);
                }
                if (string == null || string.isEmpty()) {
                    KmxLogger.m5528e(TAG, "getServiceKeyId failed. The service key doesn't seem to exist.");
                } else if (AndroidKeystoreHelper.getKey(string) == null) {
                    byte[] byteArray = bundleCall.getByteArray(KMX_CONSTANT.KMX_CHALLENGE);
                    if (byteArray == null) {
                        KmxLogger.m5528e(TAG, "getServiceKeyId failed. challenge is null");
                        KmxErrorHandler.throwIfNotSuccess("17-2|Fail to get serviceKeyId. challenge is null", 406);
                        return null;
                    }
                    byte[] bArrExportServiceKey = exportServiceKey(str, this.sksAttestation.getWrapKey(SksAttestation.WRAPPING_KEY, byteArray), byteArray);
                    if (bArrExportServiceKey == null) {
                        KmxLogger.m5528e(TAG, "getServiceKeyId failed. wrappedServiceKey is null");
                        KmxErrorHandler.throwIfNotSuccess("17-2-1|Fail to get serviceKeyId. wrappedServiceKey is null", 102);
                    } else if (AndroidKeystoreHelper.secureKeyImport(string, SksAttestation.WRAPPING_KEY, bArrExportServiceKey)) {
                        str2 = string;
                    } else {
                        KmxLogger.m5528e(TAG, "17-3|Fail secure key import for ".concat(str));
                        KmxErrorHandler.throwIfNotSuccess("17-3|Fail to get serviceKeyId. Fail secure key import", 101);
                    }
                    this.sksAttestation.removeKey(SksAttestation.WRAPPING_KEY);
                } else {
                    KmxLogger.m5529i(TAG, "Found service key in aks for ".concat(str));
                    str2 = string;
                }
                return str2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public X509Certificate[] getWrapKey(String str) {
        KmxLogger.m5528e(TAG, "NotSupport, getWrapKey. KMX");
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
        this.mCurServiceId = null;
        this.misAllowed = false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public boolean removeServiceKey(String str) throws KmxException {
        KmxLogger.m5529i(TAG, "[removeServiceKey] : " + str);
        if (str == null) {
            KmxErrorHandler.throwIfNotSuccess("28|Input Error : ServiceId cannot be null when remove key", 4);
            return false;
        }
        String serviceKeyId = getServiceKeyId(str);
        if (serviceKeyId == null) {
            KmxLogger.m5528e(TAG, "28-1|removeServiceKey is failed. Key does not exist");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            AndroidKeystoreHelper.removeKey(serviceKeyId);
            return this.keyHandler.removeKey(str, 1);
        }
        KmxLogger.m5528e(TAG, "28-2|removeServiceKey is failed. Unsupported device");
        return false;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement
    public void removeWrapKey(String str) {
        KmxLogger.m5528e(TAG, "NotSupport, removeWrapKey. KMX");
    }

    private Map<String, byte[]> exportServiceKey(List<String> list, @Nullable X509Certificate[] x509CertificateArr, @Nullable byte[] bArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : list) {
            Bundle bundle = new Bundle();
            bundle.putString(KMX_CONSTANT.KMX_FABRIC_ID, KmxSdk.getGuid());
            bundle.putString(KMX_CONSTANT.KMX_SERVICE_ID, str);
            Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_GET_SERVICE_KEY_ID, (String) null, bundle);
            if (bundleCall == null) {
                KmxLogger.m5528e(TAG, "[exportServiceKey] Fail to get service key id");
                return null;
            }
            String string = bundleCall.getString(KMX_CONSTANT.KMX_SERVICE_KEY_ID);
            if (string != null) {
                arrayList.add(string);
            }
        }
        return exportServiceKeyInternal(arrayList, x509CertificateArr, bArr);
    }

    private Map<String, String> createServiceKey(List<String> list) throws KmxException {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(KMX_CONSTANT.KMX_SERVICE_ID_LIST, new ArrayList<>(list));
        Bundle bundleCall = KmxSdk.getContext().getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_CREATE_SERVICE_KEY, (String) null, bundle);
        if (bundleCall != null) {
            KmxErrorHandler.throwIfNotSuccess("22|Service Key generation failure :", bundleCall.getInt(KMX_CONSTANT.KMX_ERROR_CODE));
            Serializable serializable = bundleCall.getSerializable(KMX_CONSTANT.KMX_SERVICE_KEY_ID_LIST);
            if (serializable instanceof Map) {
                Map<String, String> map = (Map) serializable;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    KmxDBAdapter kmxDBAdapter = this.kmxDBAdapter;
                    if (kmxDBAdapter != null) {
                        kmxDBAdapter.insertServiceKeyId(KmxSdk.getGuid(), entry.getKey(), entry.getValue());
                    }
                }
                return map;
            }
        }
        KmxLogger.m5528e(TAG, "[createServiceKey] Fail to create service key");
        return null;
    }
}
