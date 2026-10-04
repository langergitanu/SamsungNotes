package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftStsRopcTokenRequest extends MicrosoftStsTokenRequest {

    @SerializedName("password")
    private String mPassword;

    @SerializedName("username")
    private String mUsername;

    public String getPassword() {
        return this.mPassword;
    }

    public String getUsername() {
        return this.mUsername;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public void setUsername(String str) {
        this.mUsername = str;
    }
}
