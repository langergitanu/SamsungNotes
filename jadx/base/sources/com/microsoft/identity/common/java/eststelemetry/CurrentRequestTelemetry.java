package com.microsoft.identity.common.java.eststelemetry;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class CurrentRequestTelemetry extends RequestTelemetry implements ICurrentTelemetry {
    private String mApiId;
    private boolean mForceRefresh;

    public CurrentRequestTelemetry() {
        super("2");
    }

    public String getApiId() {
        return this.mApiId;
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetry
    public String getHeaderStringForFields() {
        return TelemetryUtils.getSchemaCompliantString(this.mApiId) + "," + TelemetryUtils.getSchemaCompliantStringFromBoolean(this.mForceRefresh);
    }

    public boolean isForceRefresh() {
        return this.mForceRefresh;
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.ICurrentTelemetry
    public void put(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("value is marked non-null but is null");
        }
        if (str.equals("Microsoft.MSAL.force_refresh")) {
            this.mForceRefresh = TelemetryUtils.getBooleanFromString(str2);
        } else if (str.equals("Microsoft.MSAL.api_id")) {
            this.mApiId = str2;
        } else {
            putInPlatformTelemetry(str, str2);
        }
    }
}
