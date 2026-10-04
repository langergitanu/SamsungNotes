package com.microsoft.identity.common.java.telemetry;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.UUID;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class TelemetryPropertiesCache {
    private static final String DEVICE_ID_GUID = "device_id_guid";
    private final INameValueStorage<String> mStorage;

    public TelemetryPropertiesCache(@NonNull INameValueStorage<String> iNameValueStorage) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("storage is marked non-null but is null");
        }
        this.mStorage = iNameValueStorage;
    }

    public synchronized String getOrCreateRandomStableDeviceId() {
        String string;
        string = this.mStorage.get(DEVICE_ID_GUID);
        if (StringUtil.isNullOrEmpty(string)) {
            string = UUID.randomUUID().toString();
            this.mStorage.put(DEVICE_ID_GUID, string);
        }
        return string;
    }
}
