package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.providers.oauth2.AccessToken;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftStsAccessToken extends AccessToken {
    private Long mExtExpiresIn;

    public MicrosoftStsAccessToken(MicrosoftStsTokenResponse microsoftStsTokenResponse) {
        super(microsoftStsTokenResponse);
        this.mExtExpiresIn = microsoftStsTokenResponse.getExtExpiresIn();
    }

    public Long getExtExpiresIn() {
        return this.mExtExpiresIn;
    }

    public void setExtExpiresIn(Long l) {
        this.mExtExpiresIn = l;
    }
}
