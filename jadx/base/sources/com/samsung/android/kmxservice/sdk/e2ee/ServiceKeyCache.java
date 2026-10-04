package com.samsung.android.kmxservice.sdk.e2ee;

import com.samsung.android.kmxservice.sdk.e2ee.common.KmxErrorHandler;
import com.samsung.android.kmxservice.sdk.e2ee.manager.ServiceKeyManagement;
import com.samsung.android.kmxservice.sdk.util.AndroidKeystoreHelper;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class ServiceKeyCache {
    private final Map<String, Key> SERVICE_KEYS = new HashMap();
    private final ServiceKeyManagement serviceKeyManagement;

    public ServiceKeyCache(ServiceKeyManagement serviceKeyManagement) {
        this.serviceKeyManagement = serviceKeyManagement;
    }

    public Key get(String str) throws KmxException {
        Key key = this.SERVICE_KEYS.get(str);
        if (key == null) {
            String serviceKeyId = this.serviceKeyManagement.getServiceKeyId(str);
            KmxErrorHandler.throwIfNull(serviceKeyId, "ServiceKeyCache: getServiceKeyId returns null. " + str, 305);
            Key key2 = AndroidKeystoreHelper.getKey(serviceKeyId);
            KmxErrorHandler.throwIfNull(key2, "ServiceKeyCache: getKey returns null. " + serviceKeyId, 305);
            key = key2;
        }
        synchronized (this.SERVICE_KEYS) {
            this.SERVICE_KEYS.put(str, key);
        }
        return key;
    }

    public void initialize() {
        synchronized (this.SERVICE_KEYS) {
            this.SERVICE_KEYS.clear();
        }
    }

    public void remove(String str) {
        synchronized (this.SERVICE_KEYS) {
            this.SERVICE_KEYS.remove(str);
        }
    }
}
