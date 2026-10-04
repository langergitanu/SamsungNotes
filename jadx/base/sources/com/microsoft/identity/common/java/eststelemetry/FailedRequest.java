package com.microsoft.identity.common.java.eststelemetry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class FailedRequest {
    private final String mApiId;
    private final String mCorrelationId;
    private final String mError;

    public FailedRequest(String str, String str2, String str3) {
        this.mApiId = str;
        this.mCorrelationId = str2;
        this.mError = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mCorrelationId.equals(((FailedRequest) obj).mCorrelationId);
    }

    public int hashCode() {
        return this.mCorrelationId.hashCode();
    }

    public String toApiIdCorrelationString() {
        return this.mApiId + ',' + this.mCorrelationId;
    }

    public String toErrorCodeString() {
        return this.mError;
    }
}
