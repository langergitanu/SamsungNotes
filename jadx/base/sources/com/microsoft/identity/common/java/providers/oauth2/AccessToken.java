package com.microsoft.identity.common.java.providers.oauth2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AccessToken {
    private static final int SECONDS_MS = 1000;
    private static final long TOKEN_EXPIRED_BUFFER = 600000;
    private long mExpiresIn;
    private String mRawAccessToken;
    private long mTokenReceivedTime;
    private String mTokenType;

    public AccessToken(TokenResponse tokenResponse) {
        this.mExpiresIn = tokenResponse.getExpiresIn().longValue();
        this.mTokenReceivedTime = tokenResponse.getResponseReceivedTime();
        this.mTokenType = tokenResponse.getTokenType();
        this.mRawAccessToken = tokenResponse.getAccessToken();
    }

    public String getAccessToken() {
        return this.mRawAccessToken;
    }

    public long getExpiresIn() {
        return this.mExpiresIn;
    }

    public String getRawAccessToken() {
        return this.mRawAccessToken;
    }

    public long getTokenExpiredBuffer() {
        return 600000L;
    }

    public long getTokenReceivedTime() {
        return this.mTokenReceivedTime;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public boolean isExpired() {
        return (this.mExpiresIn * 1000) + this.mTokenReceivedTime > System.currentTimeMillis() + 600000;
    }

    public void setExpiresIn(long j) {
        this.mExpiresIn = j;
    }

    public void setRawAccessToken(String str) {
        this.mRawAccessToken = str;
    }

    public void setTokenReceivedTime(long j) {
        this.mTokenReceivedTime = j;
    }

    public void setTokenType(String str) {
        this.mTokenType = str;
    }
}
