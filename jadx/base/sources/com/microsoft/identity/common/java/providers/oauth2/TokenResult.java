package com.microsoft.identity.common.java.providers.oauth2;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.telemetry.CliTelemInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenResult implements IResult {
    private CliTelemInfo mCliTelemInfo;
    private boolean mSuccess;
    private TokenErrorResponse mTokenErrorResponse;
    private TokenResponse mTokenResponse;

    public TokenResult() {
        this.mSuccess = false;
    }

    public CliTelemInfo getCliTelemInfo() {
        return this.mCliTelemInfo;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IResult
    public boolean getSuccess() {
        return this.mSuccess;
    }

    public TokenResponse getTokenResponse() {
        return this.mTokenResponse;
    }

    public void setCliTelemInfo(CliTelemInfo cliTelemInfo) {
        this.mCliTelemInfo = cliTelemInfo;
    }

    public void setSuccess(boolean z) {
        this.mSuccess = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{mTokenResponse=");
        sb.append(this.mTokenResponse);
        sb.append(", mTokenErrorResponse=");
        sb.append(this.mTokenErrorResponse);
        sb.append(", mSuccess=");
        return AbstractC0622a.m1172r(sb, this.mSuccess, '}');
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IResult
    public TokenErrorResponse getErrorResponse() {
        return this.mTokenErrorResponse;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.IResult
    public TokenResponse getSuccessResponse() {
        return this.mTokenResponse;
    }

    public TokenResult(TokenResponse tokenResponse) {
        this(tokenResponse, null);
    }

    public TokenResult(TokenErrorResponse tokenErrorResponse) {
        this(null, tokenErrorResponse);
    }

    public TokenResult(TokenResponse tokenResponse, TokenErrorResponse tokenErrorResponse) {
        this.mSuccess = false;
        this.mTokenResponse = tokenResponse;
        this.mTokenErrorResponse = tokenErrorResponse;
        if (tokenResponse != null) {
            this.mSuccess = true;
        }
    }
}
