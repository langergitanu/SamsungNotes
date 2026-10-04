package com.microsoft.identity.common.java.dto;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Credential extends AccountCredentialBase {

    @SerializedName(SerializedNames.CACHED_AT)
    private String mCachedAt;

    @SerializedName("client_id")
    private String mClientId;

    @SerializedName(SerializedNames.CREDENTIAL_TYPE)
    private String mCredentialType;

    @SerializedName("environment")
    private String mEnvironment;

    @SerializedName("home_account_id")
    private String mHomeAccountId;

    @SerializedName(SerializedNames.SECRET)
    private String mSecret;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializedNames {
        public static final String CACHED_AT = "cached_at";
        public static final String CLIENT_ID = "client_id";
        public static final String CREDENTIAL_TYPE = "credential_type";
        public static final String ENVIRONMENT = "environment";
        public static final String EXPIRES_ON = "expires_on";
        public static final String HOME_ACCOUNT_ID = "home_account_id";
        public static final String SECRET = "secret";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Credential credential = (Credential) obj;
            String str = this.mClientId;
            if (str == null ? credential.mClientId != null : !str.equals(credential.mClientId)) {
                return false;
            }
            String str2 = this.mCredentialType;
            if (str2 == null ? credential.mCredentialType != null : !str2.equals(credential.mCredentialType)) {
                return false;
            }
            String str3 = this.mEnvironment;
            if (str3 == null ? credential.mEnvironment != null : !str3.equals(credential.mEnvironment)) {
                return false;
            }
            String str4 = this.mSecret;
            if (str4 == null ? credential.mSecret != null : !str4.equals(credential.mSecret)) {
                return false;
            }
            String str5 = this.mHomeAccountId;
            if (str5 == null ? credential.mHomeAccountId != null : !str5.equals(credential.mHomeAccountId)) {
                return false;
            }
            String str6 = this.mCachedAt;
            String str7 = credential.mCachedAt;
            if (str6 != null) {
                return str6.equals(str7);
            }
            if (str7 == null) {
                return true;
            }
        }
        return false;
    }

    public String getCachedAt() {
        return this.mCachedAt;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getCredentialType() {
        return this.mCredentialType;
    }

    public String getEnvironment() {
        return this.mEnvironment;
    }

    public String getHomeAccountId() {
        return this.mHomeAccountId;
    }

    public String getSecret() {
        return this.mSecret;
    }

    public int hashCode() {
        String str = this.mClientId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mCredentialType;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mEnvironment;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mSecret;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mHomeAccountId;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mCachedAt;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public abstract boolean isExpired();

    public void setCachedAt(String str) {
        this.mCachedAt = str;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public void setCredentialType(String str) {
        this.mCredentialType = str;
    }

    public void setEnvironment(String str) {
        this.mEnvironment = str;
    }

    public void setHomeAccountId(String str) {
        this.mHomeAccountId = str;
    }

    public void setSecret(String str) {
        this.mSecret = str;
    }
}
