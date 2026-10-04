package com.microsoft.identity.common.java.eststelemetry;

import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.eststelemetry.SchemaConstants;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class RequestTelemetry implements IRequestTelemetry {
    private static final String TAG = "RequestTelemetry";

    @SerializedName("platform_telemetry")
    private final ConcurrentMap<String, String> mPlatformTelemetry;

    @SerializedName(SchemaConstants.SCHEMA_VERSION_KEY)
    private final String mSchemaVersion;

    public RequestTelemetry(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("schemaVersion is marked non-null but is null");
        }
        this.mSchemaVersion = str;
        this.mPlatformTelemetry = new ConcurrentHashMap();
    }

    @NonNull
    private String getHeaderStringForFields(List<String> list, Map<String, String> map) {
        if (list == null || map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(TelemetryUtils.getSchemaCompliantString(map.get(list.get(i))));
            if (i != list.size() - 1) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    private String getPlatformTelemetryHeaderString() {
        this.mPlatformTelemetry.putIfAbsent(SchemaConstants.Key.PLATFORM_SCHEMA_VERSION, "2");
        return getHeaderStringForFields(this instanceof CurrentRequestTelemetry ? SchemaConstants.getCurrentRequestPlatformFields(TelemetryUtils.getBooleanFromString(this.mPlatformTelemetry.get(SchemaConstants.Key.IS_SHARED_DEVICE))) : SchemaConstants.getLastRequestPlatformFields(), this.mPlatformTelemetry);
    }

    private boolean isPlatformTelemetryField(String str) {
        if (this instanceof CurrentRequestTelemetry) {
            return SchemaConstants.isCurrentPlatformField(str);
        }
        if (this instanceof LastRequestTelemetry) {
            return SchemaConstants.isLastPlatformField(str);
        }
        return false;
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetry
    public IRequestTelemetry copySharedValues(@NonNull IRequestTelemetry iRequestTelemetry) {
        if (iRequestTelemetry == null) {
            throw new NullPointerException("requestTelemetry is marked non-null but is null");
        }
        for (Map.Entry<String, String> entry : this.mPlatformTelemetry.entrySet()) {
            putInPlatformTelemetry(entry.getKey(), entry.getValue());
        }
        return this;
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetry
    public String getCompleteHeaderString() {
        if (StringUtil.isNullOrEmpty(this.mSchemaVersion)) {
            AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getCompleteHeaderString", "SCHEMA_VERSION is null or empty. Telemetry Header String cannot be formed.");
            return null;
        }
        return this.mSchemaVersion + "|" + getHeaderStringForFields() + "|" + getPlatformTelemetryHeaderString();
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetry
    public String getSchemaVersion() {
        return this.mSchemaVersion;
    }

    public final void putInPlatformTelemetry(String str, String str2) {
        if (isPlatformTelemetryField(str)) {
            this.mPlatformTelemetry.putIfAbsent(str, str2);
        }
    }
}
