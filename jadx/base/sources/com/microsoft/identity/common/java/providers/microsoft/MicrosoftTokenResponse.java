package com.microsoft.identity.common.java.providers.microsoft;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.util.CopyUtil;
import com.microsoft.identity.common.java.util.SchemaUtil;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftTokenResponse extends TokenResponse {
    private static final String CLIENT_INFO = "client_info";
    private static final String EXT_EXPIRES_IN = "ext_expires_in";
    private static final String FAMILY_ID = "foci";
    private static final String REFRESH_TOKEN_EXPIRES_IN = "refresh_token_expires_in";
    private static final String SESSION_KEY_JWE = "session_key_jwe";
    private String mAuthority;
    private String mCliTelemErrorCode;
    private String mCliTelemSubErrorCode;
    private transient String mClientId;

    @SerializedName("client_info")
    private String mClientInfo;

    @SerializedName("cloud_instance_host_name")
    @Expose
    private String mCloudInstanceHostName;
    private Date mExtExpiresOn;

    @SerializedName("ext_expires_in")
    @Expose
    private Long mExtendedExpiresIn;

    @SerializedName("foci")
    @Expose
    private String mFamilyId;

    @Expose
    private String mRefreshTokenAge;

    @SerializedName(REFRESH_TOKEN_EXPIRES_IN)
    private String mRefreshTokenExpiresIn;

    @SerializedName("session_key_jwe")
    private String mSessionKeyJwe;

    @Expose
    private String mSpeRing;

    @Override // com.microsoft.identity.common.java.providers.oauth2.TokenResponse
    public String getAuthority() {
        return this.mAuthority;
    }

    public String getCliTelemErrorCode() {
        return this.mCliTelemErrorCode;
    }

    public String getCliTelemSubErrorCode() {
        return this.mCliTelemSubErrorCode;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getClientInfo() {
        return this.mClientInfo;
    }

    public String getCloudInstanceHostName() {
        return this.mCloudInstanceHostName;
    }

    public Long getExtExpiresIn() {
        return this.mExtendedExpiresIn;
    }

    public Date getExtExpiresOn() {
        return CopyUtil.copyIfNotNull(this.mExtExpiresOn);
    }

    public String getFamilyId() {
        return this.mFamilyId;
    }

    public String getRefreshTokenAge() {
        return this.mRefreshTokenAge;
    }

    public String getRefreshTokenExpiresIn() {
        return this.mRefreshTokenExpiresIn;
    }

    public String getSessionKeyJwe() {
        return this.mSessionKeyJwe;
    }

    public String getSpeRing() {
        return this.mSpeRing;
    }

    public String getTenantId() {
        return SchemaUtil.getTenantId(getClientInfo(), getIdToken());
    }

    public boolean isMsaAccount() {
        return AzureActiveDirectoryAudience.MSA_MEGA_TENANT_ID.equalsIgnoreCase(getTenantId());
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.TokenResponse
    public void setAuthority(String str) {
        this.mAuthority = str;
    }

    public void setCliTelemErrorCode(String str) {
        this.mCliTelemErrorCode = str;
    }

    public void setCliTelemSubErrorCode(String str) {
        this.mCliTelemSubErrorCode = str;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public void setClientInfo(String str) {
        this.mClientInfo = str;
    }

    public void setCloudInstanceHostName(String str) {
        this.mCloudInstanceHostName = str;
    }

    public void setExtExpiresIn(Long l) {
        this.mExtendedExpiresIn = l;
    }

    public void setExtExpiresOn(Date date) {
        this.mExtExpiresOn = CopyUtil.copyIfNotNull(date);
    }

    public void setFamilyId(String str) {
        this.mFamilyId = str;
    }

    public void setRefreshTokenAge(String str) {
        this.mRefreshTokenAge = str;
    }

    public void setRefreshTokenExpiresIn(String str) {
        this.mRefreshTokenExpiresIn = str;
    }

    public void setSessionKeyJwe(String str) {
        this.mSessionKeyJwe = str;
    }

    public void setSpeRing(String str) {
        this.mSpeRing = str;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.TokenResponse
    public String toString() {
        return "MicrosoftTokenResponse{mExtExpiresOn=" + this.mExtExpiresOn + ", mClientInfo='" + this.mClientInfo + "', mClientId='" + this.mClientId + "', mExtendedExpiresIn=" + this.mExtendedExpiresIn + ", mFamilyId='" + this.mFamilyId + "'} " + super.toString();
    }
}
