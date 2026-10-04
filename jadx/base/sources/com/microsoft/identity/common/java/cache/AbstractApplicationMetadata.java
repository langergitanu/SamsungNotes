package com.microsoft.identity.common.java.cache;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractApplicationMetadata {

    @SerializedName("client_id")
    private String mClientId;

    @SerializedName("environment")
    private String mEnvironment;

    @SerializedName("application_uid")
    private int mUid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializedNames {
        static final String APPLICATION_UID = "application_uid";
        public static final String CLIENT_ID = "client_id";
        static final String ENVIRONMENT = "environment";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractApplicationMetadata abstractApplicationMetadata = (AbstractApplicationMetadata) obj;
            if (this.mUid != abstractApplicationMetadata.mUid) {
                return false;
            }
            String str = this.mClientId;
            if (str == null ? abstractApplicationMetadata.mClientId != null : !str.equals(abstractApplicationMetadata.mClientId)) {
                return false;
            }
            String str2 = this.mEnvironment;
            String str3 = abstractApplicationMetadata.mEnvironment;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public String getEnvironment() {
        return this.mEnvironment;
    }

    public int getUid() {
        return this.mUid;
    }

    public int hashCode() {
        String str = this.mClientId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mEnvironment;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mUid;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public void setEnvironment(String str) {
        this.mEnvironment = str;
    }

    public void setUid(int i) {
        this.mUid = i;
    }
}
