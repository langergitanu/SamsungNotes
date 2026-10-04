package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryAuthorizationErrorResponse extends MicrosoftAuthorizationErrorResponse {
    private String mErrorCodes;

    public AzureActiveDirectoryAuthorizationErrorResponse(String str, String str2) {
        super(str, str2);
    }

    public String getErrorCodes() {
        return this.mErrorCodes;
    }

    public void setErrorCodes(String str) {
        this.mErrorCodes = str;
    }
}
