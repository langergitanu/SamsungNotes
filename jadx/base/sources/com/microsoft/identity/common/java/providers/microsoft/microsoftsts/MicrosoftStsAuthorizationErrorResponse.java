package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftStsAuthorizationErrorResponse extends MicrosoftAuthorizationErrorResponse {
    private String mErrorSubcode;

    public MicrosoftStsAuthorizationErrorResponse(String str, String str2) {
        super(str, str2);
    }

    public String getErrorSubcode() {
        return this.mErrorSubcode;
    }

    public void setErrorSubcode(String str) {
        this.mErrorSubcode = str;
    }

    public MicrosoftStsAuthorizationErrorResponse(String str, String str2, String str3) {
        super(str, str3);
        this.mErrorSubcode = str2;
    }
}
