package com.microsoft.identity.common.java.result;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class GenerateShrResult {

    @SerializedName("error_code")
    private String errorCode;

    @SerializedName("error_msg")
    private String errorMessage;

    @SerializedName("shr")
    private String shr;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Errors {
        public static final String CLIENT_EXCEPTION = "client_exception";
        public static final String NO_ACCOUNT_FOUND = "no_account_found";
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getShr() {
        return this.shr;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setShr(String str) {
        this.shr = str;
    }
}
