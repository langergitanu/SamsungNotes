package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenRequest implements IHasExtraParameters {

    @SerializedName(AbstractJwtRequest.ClaimNames.BRK_CLIENT_ID)
    @Expose
    private String mBrkClientId;

    @SerializedName(AbstractJwtRequest.ClaimNames.BRK_REDIRECT_URI)
    @Expose
    private String mBrkRedirectUri;

    @SerializedName("client_assertion")
    private String mClientAssertion;

    @SerializedName("client_assertion_type")
    @Expose
    private String mClientAssertionType;

    @SerializedName("client_id")
    @Expose
    private String mClientId;

    @SerializedName("client_secret")
    private String mClientSecret;

    @SerializedName("code")
    private String mCode;
    private transient Iterable<Map.Entry<String, String>> mExtendedParameters;

    @SerializedName("grant_type")
    @Expose
    private String mGrantType;

    @SerializedName("redirect_uri")
    @Expose
    private String mRedirectUri;

    @SerializedName("refresh_token")
    private String mRefreshToken;

    @SerializedName("req_cnf")
    private String mRequestConfirmation;

    @SerializedName("scope")
    @Expose
    private String mScope;

    @SerializedName("token_type")
    @Expose
    private String mTokenType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GrantTypes {
        public static final String AUTHORIZATION_CODE = "authorization_code";
        public static final String CLIENT_CREDENTIALS = "client_credentials";
        public static final String DEVICE_CODE = "urn:ietf:params:oauth:grant-type:device_code";
        public static final String JWT_BEARER = "urn:ietf:params:oauth:grant-type:jwt-bearer";
        public static final String PASSWORD = "password";
        public static final String REFRESH_TOKEN = "refresh_token";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TokenType {
        public static final String POP = "pop";
    }

    public String getBrkClientId() {
        return this.mBrkClientId;
    }

    public String getBrkRedirectUri() {
        return this.mBrkRedirectUri;
    }

    public String getClientAssertion() {
        return this.mClientAssertion;
    }

    public String getClientAssertionType() {
        return this.mClientAssertionType;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getClientSecret() {
        return this.mClientSecret;
    }

    public String getCode() {
        return this.mCode;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public synchronized Iterable<Map.Entry<String, String>> getExtraParameters() {
        return this.mExtendedParameters;
    }

    public String getGrantType() {
        return this.mGrantType;
    }

    public String getRedirectUri() {
        return this.mRedirectUri;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getRequestConfirmation() {
        return this.mRequestConfirmation;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public void setBrkClientId(String str) {
        this.mBrkClientId = str;
    }

    public void setBrkRedirectUri(String str) {
        this.mBrkRedirectUri = str;
    }

    public void setClientAssertion(String str) {
        this.mClientAssertion = str;
    }

    public void setClientAssertionType(String str) {
        this.mClientAssertionType = str;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public void setClientSecret(String str) {
        this.mClientSecret = str;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public synchronized void setExtraParameters(Iterable<Map.Entry<String, String>> iterable) {
        this.mExtendedParameters = iterable;
    }

    public void setGrantType(String str) {
        this.mGrantType = str;
    }

    public void setRedirectUri(String str) {
        this.mRedirectUri = str;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setRequestConfirmation(@Nullable String str) {
        this.mRequestConfirmation = str;
    }

    public void setScope(String str) {
        this.mScope = str;
    }

    public void setTokenType(@Nullable String str) {
        this.mTokenType = str;
    }
}
