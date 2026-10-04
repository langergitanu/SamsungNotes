package com.microsoft.identity.common.java.providers.oauth2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenResponse implements ISuccessResponse {

    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("expires_in")
    @Expose
    private Long mExpiresIn;
    private transient Iterable<Map.Entry<String, String>> mExtraParameters;

    @SerializedName("id_token")
    private String mIdToken;

    @SerializedName("refresh_in")
    @Expose
    private Long mRefreshIn;

    @SerializedName("refresh_token")
    private String mRefreshToken;

    @Expose
    private long mResponseReceivedTime;

    @SerializedName("scope")
    @Expose
    private String mScope;

    @SerializedName("state")
    @Expose
    private String mState;
    private transient String mTokenAuthority;

    @SerializedName("token_type")
    @Expose
    private String mTokenType;

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public String getAuthority() {
        return this.mTokenAuthority;
    }

    public Long getExpiresIn() {
        return this.mExpiresIn;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    @Nullable
    public synchronized Iterable<Map.Entry<String, String>> getExtraParameters() {
        return this.mExtraParameters;
    }

    public String getIdToken() {
        return this.mIdToken;
    }

    public Long getRefreshIn() {
        return this.mRefreshIn;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public long getResponseReceivedTime() {
        return this.mResponseReceivedTime;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getState() {
        return this.mState;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    public void setAuthority(String str) {
        this.mTokenAuthority = str;
    }

    public void setExpiresIn(Long l) {
        this.mExpiresIn = l;
    }

    @Override // com.microsoft.identity.common.java.commands.parameters.IHasExtraParameters
    public synchronized void setExtraParameters(Iterable<Map.Entry<String, String>> iterable) {
        this.mExtraParameters = iterable;
    }

    public void setIdToken(String str) {
        this.mIdToken = str;
    }

    public void setRefreshIn(Long l) {
        this.mRefreshIn = l;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setResponseReceivedTime(Long l) {
        this.mResponseReceivedTime = l.longValue();
    }

    public void setScope(String str) {
        this.mScope = str;
    }

    public void setState(String str) {
        this.mState = str;
    }

    public void setTokenType(String str) {
        this.mTokenType = str;
    }

    public String toString() {
        return "TokenResponse{mExpiresIn=" + this.mExpiresIn + ", mRefreshIn=" + this.mRefreshIn + ", mAccessToken='" + this.mAccessToken + "', mTokenType='" + this.mTokenType + "', mRefreshToken='" + this.mRefreshToken + "', mScope='" + this.mScope + "', mState='" + this.mState + "', mIdToken='" + this.mIdToken + "', mResponseReceivedTime=" + this.mResponseReceivedTime + '}';
    }
}
