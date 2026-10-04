package com.microsoft.identity.common.java.dto;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.dto.Credential;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class IdTokenRecord extends Credential {

    @SerializedName("authority")
    private String mAuthority;

    @SerializedName("realm")
    private String mRealm;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializedNames extends Credential.SerializedNames {
        public static final String AUTHORITY = "authority";
        public static final String REALM = "realm";
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        IdTokenRecord idTokenRecord = (IdTokenRecord) obj;
        String str = this.mRealm;
        if (str == null ? idTokenRecord.mRealm != null : !str.equals(idTokenRecord.mRealm)) {
            return false;
        }
        String str2 = this.mAuthority;
        String str3 = idTokenRecord.mAuthority;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public String getRealm() {
        return this.mRealm;
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.mRealm;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mAuthority;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public boolean isExpired() {
        return false;
    }

    public void setAuthority(String str) {
        this.mAuthority = str;
    }

    public void setRealm(String str) {
        this.mRealm = str;
    }
}
