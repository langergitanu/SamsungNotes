package com.microsoft.identity.common.java.result;

import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AcquireTokenResult {
    private AuthorizationResult mAuthorizationResult;
    private ILocalAuthenticationResult mLocalAuthenticationResult;
    private Boolean mSucceeded = Boolean.FALSE;
    private TokenResult mTokenResult;

    public AuthorizationResult getAuthorizationResult() {
        return this.mAuthorizationResult;
    }

    public ILocalAuthenticationResult getLocalAuthenticationResult() {
        return this.mLocalAuthenticationResult;
    }

    public Boolean getSucceeded() {
        return this.mSucceeded;
    }

    public TokenResult getTokenResult() {
        return this.mTokenResult;
    }

    public void setAuthorizationResult(AuthorizationResult authorizationResult) {
        this.mAuthorizationResult = authorizationResult;
    }

    public void setLocalAuthenticationResult(ILocalAuthenticationResult iLocalAuthenticationResult) {
        this.mLocalAuthenticationResult = iLocalAuthenticationResult;
        this.mSucceeded = Boolean.TRUE;
    }

    public void setTokenResult(TokenResult tokenResult) {
        this.mTokenResult = tokenResult;
    }
}
