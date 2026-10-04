package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AuthorizationErrorResponse implements IErrorResponse {

    @Expose
    private String mError;

    @Expose
    private String mErrorDescription;
    private String mUpnToWpj;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Fields {
        public static final String ERROR = "error";
        public static final String ERROR_DESCRIPTION = "error_description";
    }

    public AuthorizationErrorResponse(String str, String str2) {
        this.mError = str;
        this.mErrorDescription = str2;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IErrorResponse
    public String getError() {
        return this.mError;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IErrorResponse
    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public String getUpnToWpj() {
        return this.mUpnToWpj;
    }

    public void setError(String str) {
        this.mError = str;
    }

    public void setErrorDescription(String str) {
        this.mErrorDescription = str;
    }

    public void setUpnToWpj(String str) {
        this.mUpnToWpj = str;
    }
}
