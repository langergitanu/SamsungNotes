package com.samsung.android.sdk.mobileservice.auth;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TokenInfo {
    public static final String TOKEN_TYPE_ACCESS = "accessToken";
    public static final String TOKEN_TYPE_AUTH_CODE = "authCode";
    public static final String TOKEN_TYPE_REFRESH = "refreshToken";
    private String mApiServerUrl;
    private String mAuthServerUrl;
    private String mToken;
    private long mTokenIssuedTime;
    private String mTokenType;
    private long mTokenValidityPeriod;

    public String getApiServerUrl() {
        return this.mApiServerUrl;
    }

    public String getAuthServerUrl() {
        return this.mAuthServerUrl;
    }

    public String getToken() {
        return this.mToken;
    }

    public long getTokenIssuedTime() {
        return this.mTokenIssuedTime;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public long getTokenValidityPeriod() {
        return this.mTokenValidityPeriod;
    }

    public void setApiServerUrl(String str) {
        this.mApiServerUrl = str;
    }

    public void setAuthServerUrl(String str) {
        this.mAuthServerUrl = str;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setTokenIssuedTime(long j) {
        this.mTokenIssuedTime = j;
    }

    public void setTokenType(String str) {
        this.mTokenType = str;
    }

    public void setTokenValidityPeriod(long j) {
        this.mTokenValidityPeriod = j;
    }
}
