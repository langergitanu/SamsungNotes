package com.microsoft.identity.client;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.util.SchemaUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Account implements IAccount {
    private static final String TAG = "Account";
    private String mClientInfo;
    private String mEnvironment;
    private String mHomeAccountId;
    private String mHomeOid;
    private String mHomeTenantId;
    private final Map<String, ?> mIdTokenClaims;
    private final String mRawIdToken;

    public Account(@Nullable String str, @Nullable IDToken iDToken) {
        this.mClientInfo = str;
        if (iDToken != null) {
            this.mIdTokenClaims = iDToken.getTokenClaims();
            this.mRawIdToken = iDToken.getRawIDToken();
        } else {
            this.mIdTokenClaims = null;
            this.mRawIdToken = null;
        }
    }

    @Override // com.microsoft.identity.client.IAccount
    @NonNull
    public String getAuthority() {
        if (getClaims() == null) {
            return SchemaUtil.MISSING_FROM_THE_TOKEN_RESPONSE;
        }
        String str = (String) getClaims().get("iss");
        return !StringUtil.isEmpty(str) ? (!str.contains(CIAMAuthority.CIAM_LOGIN_URL_SEGMENT) || StringUtil.isEmpty(getEnvironment()) || StringUtil.isEmpty(getTenantId())) ? str : CIAMAuthority.getTenantIdVariantUrlFromAuthorityWithoutPath(getEnvironment(), getTenantId()) : SchemaUtil.MISSING_FROM_THE_TOKEN_RESPONSE;
    }

    @Override // com.microsoft.identity.client.IClaimable
    @Nullable
    public Map<String, ?> getClaims() {
        return this.mIdTokenClaims;
    }

    @NonNull
    public String getEnvironment() {
        return this.mEnvironment;
    }

    @NonNull
    public String getHomeAccountId() {
        return getId() + Extension.DOT + this.mHomeTenantId;
    }

    @Override // com.microsoft.identity.client.IAccount
    @NonNull
    public String getId() {
        ClientInfo clientInfo;
        String uIdFromHomeAccountId;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getId", new StringBuilder());
        String str = this.mClientInfo;
        if (str != null) {
            try {
                clientInfo = new ClientInfo(str);
            } catch (MsalClientException e) {
                com.microsoft.identity.common.logging.Logger.error(strM1170p, "Failed to parse ClientInfo", e);
                clientInfo = null;
            }
        } else {
            clientInfo = null;
        }
        if (clientInfo != null) {
            uIdFromHomeAccountId = clientInfo.getUniqueIdentifier();
        } else {
            Map<String, ?> map = this.mIdTokenClaims;
            uIdFromHomeAccountId = map != null ? (String) map.get("oid") : this.mHomeOid;
        }
        if (StringUtil.isEmpty(uIdFromHomeAccountId)) {
            com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Unable to get account id from either ClientInfo or IdToken. Attempting to obtain from home account id.");
            uIdFromHomeAccountId = com.microsoft.identity.common.java.util.StringUtil.getUIdFromHomeAccountId(this.mHomeAccountId);
        }
        if (!StringUtil.isEmpty(uIdFromHomeAccountId)) {
            return uIdFromHomeAccountId;
        }
        com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Account ID is empty. Returning MISSING_FROM_THE_TOKEN_RESPONSE.");
        return SchemaUtil.MISSING_FROM_THE_TOKEN_RESPONSE;
    }

    @Override // com.microsoft.identity.client.IClaimable
    @Nullable
    public String getIdToken() {
        return this.mRawIdToken;
    }

    @Override // com.microsoft.identity.client.IClaimable
    @NonNull
    public String getTenantId() {
        return this.mHomeTenantId;
    }

    @Override // com.microsoft.identity.client.IClaimable
    @NonNull
    public String getUsername() {
        return getClaims() != null ? SchemaUtil.getDisplayableId(getClaims()) : SchemaUtil.MISSING_FROM_THE_TOKEN_RESPONSE;
    }

    public void setEnvironment(@NonNull String str) {
        this.mEnvironment = str;
    }

    public void setHomeAccountId(@NonNull String str) {
        this.mHomeAccountId = str;
    }

    public void setId(@Nullable String str) {
        this.mHomeOid = str;
    }

    public void setTenantId(@NonNull String str) {
        this.mHomeTenantId = str;
    }
}
