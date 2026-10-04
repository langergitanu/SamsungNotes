package com.microsoft.identity.common.java.providers.oauth2;

import androidx.collection.AbstractC0622a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenErrorResponse implements IErrorResponse {

    @SerializedName("error")
    @Expose
    private String mError;

    @SerializedName("error_description")
    @Expose
    private String mErrorDescription;

    @SerializedName("error_uri")
    @Expose
    private String mErrorUri;
    private String mResponseBody;

    @Expose
    private String mResponseHeadersJson;

    @Expose
    private int mStatusCode;

    @SerializedName("suberror")
    @Expose
    private String mSubError;

    @Override // com.microsoft.identity.common.java.providers.oauth2.IErrorResponse
    public String getError() {
        return this.mError;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IErrorResponse
    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public String getErrorUri() {
        return this.mErrorUri;
    }

    public String getResponseBody() {
        return this.mResponseBody;
    }

    public String getResponseHeadersJson() {
        return this.mResponseHeadersJson;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getSubError() {
        return this.mSubError;
    }

    public void setError(String str) {
        this.mError = str;
    }

    public void setErrorDescription(String str) {
        this.mErrorDescription = str;
    }

    public void setErrorUri(String str) {
        this.mErrorUri = str;
    }

    public void setResponseBody(String str) {
        this.mResponseBody = str;
    }

    public void setResponseHeadersJson(String str) {
        this.mResponseHeadersJson = str;
    }

    public void setStatusCode(int i) {
        this.mStatusCode = i;
    }

    public void setSubError(String str) {
        this.mSubError = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TokenErrorResponse{mStatusCode=");
        sb.append(this.mStatusCode);
        sb.append(", mResponseBody='");
        sb.append(this.mResponseBody);
        sb.append("', mResponseHeadersJson=");
        sb.append(this.mResponseHeadersJson);
        sb.append(", mError='");
        sb.append(this.mError);
        sb.append("', mSubError='");
        sb.append(this.mSubError);
        sb.append("', mErrorDescription='");
        sb.append(this.mErrorDescription);
        sb.append("', mErrorUri='");
        return AbstractC0622a.m1170p(this.mErrorUri, "'}", sb);
    }
}
