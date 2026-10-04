package com.google.api.client.auth.oauth;

import com.google.api.client.util.Beta;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Beta
public class OAuthGetAccessToken extends AbstractOAuthGetToken {
    public String temporaryToken;
    public String verifier;

    public OAuthGetAccessToken(String str) {
        super(str);
    }

    @Override // com.google.api.client.auth.oauth.AbstractOAuthGetToken
    public OAuthParameters createParameters() {
        OAuthParameters oAuthParametersCreateParameters = super.createParameters();
        oAuthParametersCreateParameters.token = this.temporaryToken;
        oAuthParametersCreateParameters.verifier = this.verifier;
        return oAuthParametersCreateParameters;
    }
}
