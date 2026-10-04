package com.microsoft.identity.common.java.providers.microsoft;

import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.util.CopyUtil;
import com.microsoft.identity.common.java.util.SchemaUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import cz.msebera.android.httpclient.extras.Base64;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class MicrosoftAccount extends BaseAccount {
    public static final String AUTHORITY_TYPE_MS_STS = "MSSTS";
    private static final String TAG = "MicrosoftAccount";
    private String mDisplayableId;
    private String mEnvironment;
    private String mFamilyName;
    private String mGivenName;
    private IDToken mIDToken;
    private String mMiddleName;
    private String mName;
    private URL mPasswordChangeUrl;
    private Date mPasswordExpiresOn;
    private String mRawClientInfo;
    private String mTenantId;
    private String mUid;
    private String mUserId;
    private String mUtid;

    public MicrosoftAccount() {
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
    }

    private String getUserId(Map<String, ?> map) {
        if (!StringUtil.isNullOrEmpty((String) map.get("oid"))) {
            Logger.info(TAG + ":getUniqueId", "Using ObjectId as uniqueId");
            return (String) map.get("oid");
        }
        if (StringUtil.isNullOrEmpty((String) map.get("sub"))) {
            return null;
        }
        Logger.info(TAG + ":getUniqueId", "Using Subject as uniqueId");
        return (String) map.get("sub");
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MicrosoftAccount;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MicrosoftAccount)) {
            return false;
        }
        MicrosoftAccount microsoftAccount = (MicrosoftAccount) obj;
        if (!microsoftAccount.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String displayableId = getDisplayableId();
        String displayableId2 = microsoftAccount.getDisplayableId();
        if (displayableId != null ? !displayableId.equals(displayableId2) : displayableId2 != null) {
            return false;
        }
        String userId = getUserId();
        String userId2 = microsoftAccount.getUserId();
        if (userId != null ? !userId.equals(userId2) : userId2 != null) {
            return false;
        }
        String name = getName();
        String name2 = microsoftAccount.getName();
        if (name != null ? !name.equals(name2) : name2 != null) {
            return false;
        }
        String uid = getUid();
        String uid2 = microsoftAccount.getUid();
        if (uid != null ? !uid.equals(uid2) : uid2 != null) {
            return false;
        }
        String utid = getUtid();
        String utid2 = microsoftAccount.getUtid();
        if (utid != null ? !utid.equals(utid2) : utid2 != null) {
            return false;
        }
        IDToken iDToken = getIDToken();
        IDToken iDToken2 = microsoftAccount.getIDToken();
        if (iDToken != null ? !iDToken.equals(iDToken2) : iDToken2 != null) {
            return false;
        }
        URL passwordChangeUrl = getPasswordChangeUrl();
        URL passwordChangeUrl2 = microsoftAccount.getPasswordChangeUrl();
        if (passwordChangeUrl != null ? !passwordChangeUrl.equals(passwordChangeUrl2) : passwordChangeUrl2 != null) {
            return false;
        }
        Date passwordExpiresOn = getPasswordExpiresOn();
        Date passwordExpiresOn2 = microsoftAccount.getPasswordExpiresOn();
        if (passwordExpiresOn != null ? !passwordExpiresOn.equals(passwordExpiresOn2) : passwordExpiresOn2 != null) {
            return false;
        }
        String str = this.mTenantId;
        String str2 = microsoftAccount.mTenantId;
        if (str != null ? !str.equals(str2) : str2 != null) {
            return false;
        }
        String str3 = this.mGivenName;
        String str4 = microsoftAccount.mGivenName;
        if (str3 != null ? !str3.equals(str4) : str4 != null) {
            return false;
        }
        String familyName = getFamilyName();
        String familyName2 = microsoftAccount.getFamilyName();
        if (familyName != null ? !familyName.equals(familyName2) : familyName2 != null) {
            return false;
        }
        String middleName = getMiddleName();
        String middleName2 = microsoftAccount.getMiddleName();
        if (middleName != null ? !middleName.equals(middleName2) : middleName2 != null) {
            return false;
        }
        String environment = getEnvironment();
        String environment2 = microsoftAccount.getEnvironment();
        if (environment != null ? !environment.equals(environment2) : environment2 != null) {
            return false;
        }
        String str5 = this.mRawClientInfo;
        String str6 = microsoftAccount.mRawClientInfo;
        return str5 != null ? str5.equals(str6) : str6 == null;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getAlternativeAccountId() {
        return SchemaUtil.getAlternativeAccountId(this.mIDToken);
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getAvatarUrl() {
        return SchemaUtil.getAvatarUrl(this.mIDToken);
    }

    @Override // com.microsoft.identity.common.java.BaseAccount
    public synchronized List<String> getCacheIdentifiers() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String str = this.mDisplayableId;
            if (str != null) {
                arrayList.add(str);
            }
            String str2 = this.mUserId;
            if (str2 != null) {
                arrayList.add(str2);
            }
            if (getUniqueIdentifier() != null) {
                arrayList.add(getUniqueIdentifier());
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getClientInfo() {
        return this.mRawClientInfo;
    }

    public synchronized String getDisplayableId() {
        return this.mDisplayableId;
    }

    public abstract String getDisplayableIdFromClaims(Map<String, ?> map);

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getEnvironment() {
        return this.mEnvironment;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getFamilyName() {
        return this.mFamilyName;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getFirstName() {
        return this.mGivenName;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getHomeAccountId() {
        return getUid() + Extension.DOT + getUtid();
    }

    public synchronized IDToken getIDToken() {
        return this.mIDToken;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getLocalAccountId() {
        return getUserId();
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getMiddleName() {
        return this.mMiddleName;
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getName() {
        return this.mName;
    }

    public synchronized URL getPasswordChangeUrl() {
        return this.mPasswordChangeUrl;
    }

    @Nullable
    public synchronized Date getPasswordExpiresOn() {
        return CopyUtil.copyIfNotNull(this.mPasswordExpiresOn);
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getRealm() {
        return this.mTenantId;
    }

    public synchronized String getUid() {
        return this.mUid;
    }

    @Override // com.microsoft.identity.common.java.BaseAccount
    public synchronized String getUniqueIdentifier() {
        return Base64.encodeToString(StringUtil.toByteArray(this.mUid), 10) + Extension.DOT + Base64.encodeToString(StringUtil.toByteArray(this.mUtid), 10);
    }

    @Override // com.microsoft.identity.common.java.dto.IAccountRecord
    public synchronized String getUsername() {
        return getDisplayableId();
    }

    public synchronized String getUtid() {
        return this.mUtid;
    }

    public int hashCode() {
        int iHashCode = super.hashCode();
        String displayableId = getDisplayableId();
        int iHashCode2 = (iHashCode * 59) + (displayableId == null ? 43 : displayableId.hashCode());
        String userId = getUserId();
        int iHashCode3 = (iHashCode2 * 59) + (userId == null ? 43 : userId.hashCode());
        String name = getName();
        int iHashCode4 = (iHashCode3 * 59) + (name == null ? 43 : name.hashCode());
        String uid = getUid();
        int iHashCode5 = (iHashCode4 * 59) + (uid == null ? 43 : uid.hashCode());
        String utid = getUtid();
        int iHashCode6 = (iHashCode5 * 59) + (utid == null ? 43 : utid.hashCode());
        IDToken iDToken = getIDToken();
        int iHashCode7 = (iHashCode6 * 59) + (iDToken == null ? 43 : iDToken.hashCode());
        URL passwordChangeUrl = getPasswordChangeUrl();
        int iHashCode8 = (iHashCode7 * 59) + (passwordChangeUrl == null ? 43 : passwordChangeUrl.hashCode());
        Date passwordExpiresOn = getPasswordExpiresOn();
        int iHashCode9 = (iHashCode8 * 59) + (passwordExpiresOn == null ? 43 : passwordExpiresOn.hashCode());
        String str = this.mTenantId;
        int iHashCode10 = (iHashCode9 * 59) + (str == null ? 43 : str.hashCode());
        String str2 = this.mGivenName;
        int iHashCode11 = (iHashCode10 * 59) + (str2 == null ? 43 : str2.hashCode());
        String familyName = getFamilyName();
        int iHashCode12 = (iHashCode11 * 59) + (familyName == null ? 43 : familyName.hashCode());
        String middleName = getMiddleName();
        int iHashCode13 = (iHashCode12 * 59) + (middleName == null ? 43 : middleName.hashCode());
        String environment = getEnvironment();
        int iHashCode14 = (iHashCode13 * 59) + (environment == null ? 43 : environment.hashCode());
        String str3 = this.mRawClientInfo;
        return (iHashCode14 * 59) + (str3 != null ? str3.hashCode() : 43);
    }

    public synchronized void setDisplayableId(String str) {
        this.mDisplayableId = str;
    }

    public synchronized void setEnvironment(String str) {
        this.mEnvironment = str;
    }

    public synchronized void setFamilyName(String str) {
        this.mFamilyName = str;
    }

    public synchronized void setFirstName(String str) {
        this.mGivenName = str;
    }

    public synchronized void setName(String str) {
        this.mName = str;
    }

    public synchronized void setUid(String str) {
        this.mUid = str;
    }

    public synchronized void setUserId(String str) {
        this.mUserId = str;
    }

    public synchronized void setUtid(String str) {
        this.mUtid = str;
    }

    public synchronized String toString() {
        return "MicrosoftAccount{mDisplayableId='" + this.mDisplayableId + "', mUserId='" + this.mUserId + "', mName='" + this.mName + "', mUid='" + this.mUid + "', mUtid='" + this.mUtid + "', mIDToken=" + this.mIDToken + ", mPasswordChangeUrl=" + this.mPasswordChangeUrl + ", mPasswordExpiresOn=" + this.mPasswordExpiresOn + ", mTenantId='" + this.mTenantId + "', mGivenName='" + this.mGivenName + "', mFamilyName='" + this.mFamilyName + "'} " + super.toString();
    }

    public MicrosoftAccount(@NonNull IDToken iDToken, @NonNull ClientInfo clientInfo) {
        if (iDToken == null) {
            throw new NullPointerException("idToken is marked non-null but is null");
        }
        if (clientInfo != null) {
            String str = TAG;
            Logger.verbose(str, "Init: " + str);
            this.mIDToken = iDToken;
            this.mRawClientInfo = clientInfo.getRawClientInfo();
            Map<String, ?> tokenClaims = iDToken.getTokenClaims();
            this.mUserId = getUserId(tokenClaims);
            this.mDisplayableId = getDisplayableIdFromClaims(tokenClaims);
            this.mName = (String) tokenClaims.get("name");
            this.mGivenName = (String) tokenClaims.get("given_name");
            this.mFamilyName = (String) tokenClaims.get("family_name");
            this.mMiddleName = (String) tokenClaims.get("middle_name");
            if (!StringUtil.isNullOrEmpty((String) tokenClaims.get("tid"))) {
                this.mTenantId = (String) tokenClaims.get("tid");
            } else if (!StringUtil.isNullOrEmpty(clientInfo.getUtid())) {
                Logger.warnPII(str, "realm is not returned from server. Use utid as realm.");
                this.mTenantId = clientInfo.getUtid();
            } else {
                Logger.warnPII(str, "realm and utid is not returned from server. Use empty string as default tid.");
                this.mTenantId = "";
            }
            this.mUid = clientInfo.getUid();
            this.mUtid = clientInfo.getUtid();
            Object obj = tokenClaims.get("pwd_exp");
            long j = obj != null ? Long.parseLong(obj.toString()) : 0L;
            if (j > 0) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.add(13, (int) j);
                this.mPasswordExpiresOn = gregorianCalendar.getTime();
            }
            this.mPasswordChangeUrl = null;
            String str2 = (String) tokenClaims.get("pwd_url");
            if (StringUtil.isNullOrEmpty(str2)) {
                return;
            }
            try {
                this.mPasswordChangeUrl = new URL(str2);
                return;
            } catch (MalformedURLException e) {
                Logger.error(TAG, "Failed to parse passwordChangeUrl.", e);
                return;
            }
        }
        throw new NullPointerException("clientInfo is marked non-null but is null");
    }

    public synchronized String getUserId() {
        return this.mUserId;
    }
}
