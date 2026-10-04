package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryTokenRequest extends TokenRequest {

    @SerializedName("resource")
    private String mResourceId;

    public String getResourceId() {
        return this.mResourceId;
    }

    public void setResourceId(String str) {
        this.mResourceId = str;
    }
}
