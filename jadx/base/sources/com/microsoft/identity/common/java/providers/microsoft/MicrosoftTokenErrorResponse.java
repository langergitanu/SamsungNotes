package com.microsoft.identity.common.java.providers.microsoft;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.java.providers.oauth2.TokenErrorResponse;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftTokenErrorResponse extends TokenErrorResponse {

    @SerializedName("correlation_id")
    private String mCorrelationId;

    @SerializedName("error_codes")
    private List<Long> mErrorCodes;

    @SerializedName("oAuth_metadata")
    private String mOAuthErrorMetadata;

    @SerializedName("timestamp")
    private String mTimeStamp;

    @SerializedName(SerializableSpanContext.SerializedNames.TRACE_ID)
    private String mTraceId;

    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    public List<Long> getErrorCodes() {
        return this.mErrorCodes;
    }

    public String getOAuthErrorMetadata() {
        return this.mOAuthErrorMetadata;
    }

    public String getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public void setCorrelationId(String str) {
        this.mCorrelationId = str;
    }

    public void setErrorCodes(List<Long> list) {
        this.mErrorCodes = list;
    }

    public void setOAuthErrorMetadata(String str) {
        this.mOAuthErrorMetadata = str;
    }

    public void setTimeStamp(String str) {
        this.mTimeStamp = str;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }
}
