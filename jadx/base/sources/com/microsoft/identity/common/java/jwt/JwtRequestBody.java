package com.microsoft.identity.common.java.jwt;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class JwtRequestBody extends AbstractJwtRequest {

    @SerializedName(AbstractJwtRequest.ClaimNames.ASSERTION)
    private String mAssertion;

    @SerializedName("aud")
    private String mAudience;

    @SerializedName(AbstractJwtRequest.ClaimNames.BRK_REDIRECT_URI)
    private String mBrkRedirectUri;

    @SerializedName("exp")
    private String mExp;

    @SerializedName("grant_type")
    private String mGrantType;

    @SerializedName("iat")
    private String mIat;

    @SerializedName("iss")
    private String mIssuer;

    @SerializedName(AbstractJwtRequest.ClaimNames.JWE_CRYPTO)
    private JsonObject mJweCrypto;

    @SerializedName("scope")
    private String mJwtScope;

    @SerializedName("nbf")
    private String mNbf;

    @SerializedName(AbstractJwtRequest.ClaimNames.NONCE)
    private String mNonce;

    @SerializedName("redirect_uri")
    private String mRedirectUri;

    @SerializedName(AbstractJwtRequest.ClaimNames.SESSION_KEY_CRYPTO)
    private JsonObject mSessionKeyCrypto;

    public String getAssertion() {
        return this.mAssertion;
    }

    public String getAudience() {
        return this.mAudience;
    }

    public String getBrkRedirectUri() {
        return this.mBrkRedirectUri;
    }

    public String getExp() {
        return this.mExp;
    }

    public String getGrantType() {
        return this.mGrantType;
    }

    public String getIat() {
        return this.mIat;
    }

    public String getIssuer() {
        return this.mIssuer;
    }

    public JsonObject getJweCrypto() {
        return this.mJweCrypto;
    }

    public String getJwtScope() {
        return this.mJwtScope;
    }

    public String getNbf() {
        return this.mNbf;
    }

    public String getNonce() {
        return this.mNonce;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public JsonObject getSessionKeyCrypto() {
        return this.mSessionKeyCrypto;
    }

    public void setAssertion(String str) {
        this.mAssertion = str;
    }

    public void setAudience(String str) {
        this.mAudience = str;
    }

    public void setBrkRedirectUri(String str) {
        this.mBrkRedirectUri = str;
    }

    public void setExp(long j, long j2) {
        this.mExp = String.valueOf(j + j2);
    }

    public void setGrantType(String str) {
        this.mGrantType = str;
    }

    public void setIat(long j) {
        this.mIat = String.valueOf(j);
    }

    public void setIssuer(String str) {
        this.mIssuer = str;
    }

    public void setJweCrypto(JsonObject jsonObject) {
        this.mJweCrypto = jsonObject;
    }

    public void setJwtScope(String str) {
        this.mJwtScope = str;
    }

    public void setNBF(long j) {
        this.mNbf = String.valueOf(j);
    }

    public void setNonce(String str) {
        this.mNonce = str;
    }

    public void setRedirectUri(String str) {
        this.mRedirectUri = str;
    }

    public void setSessionKeyCrypto(JsonObject jsonObject) {
        this.mSessionKeyCrypto = jsonObject;
    }
}
