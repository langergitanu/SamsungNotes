package com.microsoft.identity.common.java.telemetry;

import com.microsoft.identity.common.java.util.StringUtil;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class Properties {
    private ConcurrentHashMap<String, String> mProperties;

    public Properties(@NonNull ConcurrentHashMap<String, String> concurrentHashMap) {
        if (concurrentHashMap == null) {
            throw new NullPointerException("properties is marked non-null but is null");
        }
        this.mProperties = concurrentHashMap;
    }

    public ConcurrentHashMap<String, String> getProperties() {
        return this.mProperties;
    }

    public Properties put(String str, String str2) {
        if (this.mProperties == null) {
            this.mProperties = new ConcurrentHashMap<>();
        }
        if (!StringUtil.isNullOrEmpty(str) && !StringUtil.isNullOrEmpty(str2)) {
            this.mProperties.put(str, str2);
        }
        return this;
    }

    public Properties remove(String str) {
        this.mProperties.remove(str);
        return this;
    }

    public Properties remove(String str, String str2) {
        this.mProperties.remove(str, str2);
        return this;
    }

    public Properties() {
        this.mProperties = new ConcurrentHashMap<>(16, 0.75f, 1);
    }

    public Properties put(Properties properties) {
        ConcurrentHashMap<String, String> concurrentHashMap = this.mProperties;
        if (concurrentHashMap == null) {
            this.mProperties = properties.getProperties();
            return this;
        }
        concurrentHashMap.putAll(properties.getProperties());
        return this;
    }
}
