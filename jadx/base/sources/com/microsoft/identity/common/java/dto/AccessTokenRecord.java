package com.microsoft.identity.common.java.dto;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.dto.Credential;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AccessTokenRecord extends Credential {

    @SerializedName(alternate = {SerializedNames.ACCESS_TOKEN_TYPE}, value = "token_type")
    private String mAccessTokenType;

    @SerializedName(SerializedNames.APPLICATION_IDENTIFIER)
    private String mApplicationIdentifier;

    @SerializedName("authority")
    private String mAuthority;

    @SerializedName(Credential.SerializedNames.EXPIRES_ON)
    private String mExpiresOn;

    @SerializedName(SerializedNames.EXTENDED_EXPIRES_ON)
    private String mExtendedExpiresOn;

    @SerializedName("kid")
    private String mKid;

    @SerializedName(SerializedNames.MAM_ENROLLMENT_IDENTIFIER)
    private String mMamEnrollmentIdentifier;

    @SerializedName("realm")
    private String mRealm;

    @SerializedName(SerializedNames.REFRESH_ON)
    private String mRefreshOn;

    @SerializedName(SerializedNames.REQUESTED_CLAIMS)
    private String mRequestedClaims;

    @SerializedName("target")
    private String mTarget;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SerializedNames extends Credential.SerializedNames {

        @Deprecated
        public static final String ACCESS_TOKEN_TYPE = "access_token_type";
        public static final String APPLICATION_IDENTIFIER = "application_identifier";
        public static final String AUTHORITY = "authority";
        public static final String EXTENDED_EXPIRES_ON = "extended_expires_on";
        public static final String KID = "kid";
        public static final String MAM_ENROLLMENT_IDENTIFIER = "mam_enrollment_identifier";
        public static final String REALM = "realm";
        public static final String REFRESH_ON = "refresh_on";
        public static final String REQUESTED_CLAIMS = "requested_claims";
        public static final String TARGET = "target";
        public static final String TOKEN_TYPE = "token_type";
    }

    private boolean isExpired(String str) {
        return new Date(TimeUnit.SECONDS.toMillis(Long.parseLong(str))).before(Calendar.getInstance().getTime());
    }

    public boolean canEqual(Object obj) {
        return obj instanceof AccessTokenRecord;
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccessTokenRecord)) {
            return false;
        }
        AccessTokenRecord accessTokenRecord = (AccessTokenRecord) obj;
        if (!accessTokenRecord.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String str = this.mRequestedClaims;
        String str2 = accessTokenRecord.mRequestedClaims;
        if (str != null ? !str.equals(str2) : str2 != null) {
            return false;
        }
        String str3 = this.mKid;
        String str4 = accessTokenRecord.mKid;
        if (str3 != null ? !str3.equals(str4) : str4 != null) {
            return false;
        }
        String str5 = this.mAccessTokenType;
        String str6 = accessTokenRecord.mAccessTokenType;
        if (str5 != null ? !str5.equals(str6) : str6 != null) {
            return false;
        }
        String str7 = this.mAuthority;
        String str8 = accessTokenRecord.mAuthority;
        if (str7 != null ? !str7.equals(str8) : str8 != null) {
            return false;
        }
        String str9 = this.mExtendedExpiresOn;
        String str10 = accessTokenRecord.mExtendedExpiresOn;
        if (str9 != null ? !str9.equals(str10) : str10 != null) {
            return false;
        }
        String str11 = this.mRealm;
        String str12 = accessTokenRecord.mRealm;
        if (str11 != null ? !str11.equals(str12) : str12 != null) {
            return false;
        }
        String str13 = this.mTarget;
        String str14 = accessTokenRecord.mTarget;
        if (str13 != null ? !str13.equals(str14) : str14 != null) {
            return false;
        }
        String str15 = this.mExpiresOn;
        String str16 = accessTokenRecord.mExpiresOn;
        if (str15 != null ? !str15.equals(str16) : str16 != null) {
            return false;
        }
        String str17 = this.mRefreshOn;
        String str18 = accessTokenRecord.mRefreshOn;
        if (str17 != null ? !str17.equals(str18) : str18 != null) {
            return false;
        }
        String str19 = this.mApplicationIdentifier;
        String str20 = accessTokenRecord.mApplicationIdentifier;
        if (str19 != null ? !str19.equals(str20) : str20 != null) {
            return false;
        }
        String str21 = this.mMamEnrollmentIdentifier;
        String str22 = accessTokenRecord.mMamEnrollmentIdentifier;
        return str21 != null ? str21.equals(str22) : str22 == null;
    }

    public String getAccessTokenType() {
        return this.mAccessTokenType;
    }

    public String getApplicationIdentifier() {
        return this.mApplicationIdentifier;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public String getExpiresOn() {
        return this.mExpiresOn;
    }

    public String getExtendedExpiresOn() {
        return this.mExtendedExpiresOn;
    }

    @Nullable
    public String getKid() {
        return this.mKid;
    }

    public String getMamEnrollmentIdentifier() {
        return this.mMamEnrollmentIdentifier;
    }

    public String getRealm() {
        return this.mRealm;
    }

    public String getRefreshOn() {
        return this.mRefreshOn;
    }

    public String getRequestedClaims() {
        return this.mRequestedClaims;
    }

    public String getTarget() {
        return this.mTarget;
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public int hashCode() {
        int iHashCode = super.hashCode();
        String str = this.mRequestedClaims;
        int iHashCode2 = (iHashCode * 59) + (str == null ? 43 : str.hashCode());
        String str2 = this.mKid;
        int iHashCode3 = (iHashCode2 * 59) + (str2 == null ? 43 : str2.hashCode());
        String str3 = this.mAccessTokenType;
        int iHashCode4 = (iHashCode3 * 59) + (str3 == null ? 43 : str3.hashCode());
        String str4 = this.mAuthority;
        int iHashCode5 = (iHashCode4 * 59) + (str4 == null ? 43 : str4.hashCode());
        String str5 = this.mExtendedExpiresOn;
        int iHashCode6 = (iHashCode5 * 59) + (str5 == null ? 43 : str5.hashCode());
        String str6 = this.mRealm;
        int iHashCode7 = (iHashCode6 * 59) + (str6 == null ? 43 : str6.hashCode());
        String str7 = this.mTarget;
        int iHashCode8 = (iHashCode7 * 59) + (str7 == null ? 43 : str7.hashCode());
        String str8 = this.mExpiresOn;
        int iHashCode9 = (iHashCode8 * 59) + (str8 == null ? 43 : str8.hashCode());
        String str9 = this.mRefreshOn;
        int iHashCode10 = (iHashCode9 * 59) + (str9 == null ? 43 : str9.hashCode());
        String str10 = this.mApplicationIdentifier;
        int iHashCode11 = (iHashCode10 * 59) + (str10 == null ? 43 : str10.hashCode());
        String str11 = this.mMamEnrollmentIdentifier;
        return (iHashCode11 * 59) + (str11 != null ? str11.hashCode() : 43);
    }

    public boolean refreshOnIsActive() {
        return !getExpiresOn().equals(getRefreshOn());
    }

    public void setAccessTokenType(String str) {
        this.mAccessTokenType = str;
    }

    public void setApplicationIdentifier(String str) {
        this.mApplicationIdentifier = str;
    }

    public void setAuthority(String str) {
        this.mAuthority = str;
    }

    public void setExpiresOn(String str) {
        this.mExpiresOn = str;
    }

    public void setExtendedExpiresOn(String str) {
        this.mExtendedExpiresOn = str;
    }

    public void setKid(@Nullable String str) {
        this.mKid = str;
    }

    public void setMamEnrollmentIdentifier(String str) {
        this.mMamEnrollmentIdentifier = str;
    }

    public void setRealm(String str) {
        this.mRealm = str;
    }

    public void setRefreshOn(String str) {
        this.mRefreshOn = str;
    }

    public void setRequestedClaims(String str) {
        this.mRequestedClaims = str;
    }

    public void setTarget(String str) {
        this.mTarget = str;
    }

    public boolean shouldRefresh() {
        String refreshOn = getRefreshOn();
        return (refreshOn == null || refreshOn.isEmpty()) ? isExpired() : isExpired(refreshOn);
    }

    @Override // com.microsoft.identity.common.java.dto.Credential
    public boolean isExpired() {
        return isExpired(getExpiresOn());
    }
}
