package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.telemetry.Properties;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BaseEvent extends Properties {
    public BaseEvent() {
        occurs(Long.valueOf(System.currentTimeMillis()));
        correlationId(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
    }

    public BaseEvent correlationId(String str) {
        if (!StringUtil.isNullOrEmpty(str)) {
            put("Microsoft.MSAL.correlation_id", str);
        }
        return this;
    }

    public BaseEvent names(String str) {
        put(TelemetryEventStrings.Key.EVENT_NAME, str);
        return this;
    }

    public BaseEvent occurs(Long l) {
        if (l == null) {
            put(TelemetryEventStrings.Key.OCCUR_TIME, String.valueOf(System.currentTimeMillis()));
            return this;
        }
        put(TelemetryEventStrings.Key.OCCUR_TIME, l.toString());
        return this;
    }

    @Override // com.microsoft.identity.common.java.telemetry.Properties
    public Properties put(@NonNull String str, String str2) {
        if (str != null) {
            return !StringUtil.isNullOrEmpty(str2) ? super.put(str, str2) : this;
        }
        throw new NullPointerException("key is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.telemetry.Properties
    public Properties remove(String str) {
        return super.remove(str);
    }

    public BaseEvent types(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("eventType is marked non-null but is null");
        }
        put(TelemetryEventStrings.Key.EVENT_TYPE, str);
        return this;
    }

    @Override // com.microsoft.identity.common.java.telemetry.Properties
    public Properties remove(String str, String str2) {
        return super.remove(str, str2);
    }

    @Override // com.microsoft.identity.common.java.telemetry.Properties
    public Properties put(Properties properties) {
        return super.put(properties);
    }
}
