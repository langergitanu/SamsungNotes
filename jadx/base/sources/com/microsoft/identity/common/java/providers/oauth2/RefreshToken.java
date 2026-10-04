package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.dto.IRefreshTokenRecord;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class RefreshToken implements IRefreshTokenRecord {
    private String mRawRefreshToken;
    private long mTokenReceivedTime;

    public RefreshToken(String str) {
        this.mRawRefreshToken = str;
    }

    public String getRefreshToken() {
        return this.mRawRefreshToken;
    }

    public long getTokenReceivedTime() {
        return this.mTokenReceivedTime;
    }

    public void setRawRefreshToken(String str) {
        this.mRawRefreshToken = str;
    }

    public void setTokenReceivedTime(long j) {
        this.mTokenReceivedTime = j;
    }

    public RefreshToken(TokenResponse tokenResponse) {
        this.mTokenReceivedTime = tokenResponse.getResponseReceivedTime();
        this.mRawRefreshToken = tokenResponse.getRefreshToken();
    }
}
