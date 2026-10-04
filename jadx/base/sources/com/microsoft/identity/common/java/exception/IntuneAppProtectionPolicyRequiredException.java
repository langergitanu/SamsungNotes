package com.microsoft.identity.common.java.exception;

import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.BrokerSilentTokenCommandParameters;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class IntuneAppProtectionPolicyRequiredException extends ServiceException {
    private static final String TAG = "IntuneAppProtectionPolicyRequiredException";
    public static final String sName = "com.microsoft.identity.common.exception.IntuneAppProtectionPolicyRequiredException";
    private static final long serialVersionUID = -620109887467926354L;
    private String mAccountUpn;
    private String mAccountUserId;
    private String mAuthorityUrl;
    private String mTenantId;

    public IntuneAppProtectionPolicyRequiredException(String str, String str2) {
        super(str, str2, null);
    }

    @Nullable
    private String getUIdFromHomeAccountId(@Nullable String str) {
        if (!StringUtil.isNullOrEmpty(str)) {
            String[] strArrSplit = str.split(Pattern.quote(Extension.DOT));
            if (strArrSplit.length == 2) {
                Logger.info(TAG + ":getUIdFromHomeAccountId", "Home account id is tenanted, returning uid ");
                return strArrSplit[0];
            }
            if (strArrSplit.length == 1) {
                Logger.info(TAG + ":getUIdFromHomeAccountId", "Home account id not tenanted, it's the uid added by v1 broker ");
                return strArrSplit[0];
            }
        }
        AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getUIdFromHomeAccountId", "Home Account id doesn't have uid or tenant id information, returning null ");
        return null;
    }

    public String getAccountUpn() {
        return this.mAccountUpn;
    }

    public String getAccountUserId() {
        return this.mAccountUserId;
    }

    public String getAuthorityUrl() {
        return this.mAuthorityUrl;
    }

    @Override // com.microsoft.identity.common.java.exception.ServiceException, com.microsoft.identity.common.java.exception.BaseException
    public String getExceptionName() {
        return sName;
    }

    public String getTenantId() {
        return this.mTenantId;
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException
    public boolean isCacheable() {
        return false;
    }

    public void setAccountUpn(String str) {
        this.mAccountUpn = str;
    }

    public void setAccountUserId(String str) {
        this.mAccountUserId = str;
    }

    public void setAuthorityUrl(String str) {
        this.mAuthorityUrl = str;
    }

    public void setTenantId(String str) {
        this.mTenantId = str;
    }

    public IntuneAppProtectionPolicyRequiredException(String str, String str2, Throwable th) {
        super(str, str2, th);
    }

    public IntuneAppProtectionPolicyRequiredException(String str, String str2, BrokerInteractiveTokenCommandParameters brokerInteractiveTokenCommandParameters) {
        String loginHint;
        super(str, str2, null);
        if (brokerInteractiveTokenCommandParameters.getBrokerAccount() != null) {
            loginHint = brokerInteractiveTokenCommandParameters.getBrokerAccount().getUsername();
        } else {
            loginHint = brokerInteractiveTokenCommandParameters.getLoginHint();
        }
        String localAccountId = brokerInteractiveTokenCommandParameters.getLocalAccountId();
        if (StringUtil.isNullOrEmpty(localAccountId)) {
            Logger.info(TAG, "Local account id is empty, attempting get user id from home account id");
            localAccountId = getUIdFromHomeAccountId(brokerInteractiveTokenCommandParameters.getHomeAccountId());
        }
        Authority authority = brokerInteractiveTokenCommandParameters.getAuthority();
        setAuthorityUrl(authority.getAuthorityURL().toString());
        String homeAccountId = brokerInteractiveTokenCommandParameters.getHomeAccountId();
        String value = homeAccountId != null ? StringUtil.getTenantInfo(homeAccountId).getValue() : null;
        if (StringUtil.isNullOrEmpty(value) && (authority instanceof AzureActiveDirectoryAuthority)) {
            value = ((AzureActiveDirectoryAuthority) authority).mAudience.getTenantId();
        }
        if (StringUtil.isNullOrEmpty(localAccountId)) {
            Logger.verbose(TAG, "IntuneAppProtectionPolicyException property user id was null or empty.");
        }
        if (StringUtil.isNullOrEmpty(loginHint)) {
            Logger.verbose(TAG, "IntuneAppProtectionPolicyException property upn was null or empty.");
        }
        if (StringUtil.isNullOrEmpty(value)) {
            Logger.verbose(TAG, "IntuneAppProtectionPolicyException property tenant id was null or empty.");
        }
        String str3 = TAG;
        Logger.verbose(str3, "Setting IntuneAppProtectionPolicyException properties");
        Logger.verbosePII(str3, "Setting IntuneAppProtectionPolicyException properties.  AccountId: " + localAccountId + ", UPN: " + loginHint + ", TenantId: " + value);
        setAccountUserId(localAccountId);
        setAccountUpn(loginHint);
        setTenantId(value);
    }

    public IntuneAppProtectionPolicyRequiredException(String str, String str2, BrokerSilentTokenCommandParameters brokerSilentTokenCommandParameters) {
        String loginHint;
        super(str, str2, null);
        if (brokerSilentTokenCommandParameters.getBrokerAccount() != null) {
            loginHint = brokerSilentTokenCommandParameters.getBrokerAccount().getUsername();
        } else {
            loginHint = brokerSilentTokenCommandParameters.getLoginHint();
        }
        setAccountUpn(loginHint);
        String localAccountId = brokerSilentTokenCommandParameters.getLocalAccountId();
        if (StringUtil.isNullOrEmpty(localAccountId)) {
            Logger.info(TAG, "Local account id is empty, attempting get user id from home account id");
            localAccountId = getUIdFromHomeAccountId(brokerSilentTokenCommandParameters.getHomeAccountId());
        }
        setAccountUserId(localAccountId);
        Authority authority = brokerSilentTokenCommandParameters.getAuthority();
        setAuthorityUrl(authority.getAuthorityURL().toString());
        String homeAccountId = brokerSilentTokenCommandParameters.getHomeAccountId();
        String value = homeAccountId != null ? StringUtil.getTenantInfo(homeAccountId).getValue() : null;
        if (StringUtil.isNullOrEmpty(value) && (authority instanceof AzureActiveDirectoryAuthority)) {
            value = ((AzureActiveDirectoryAuthority) authority).mAudience.getTenantId();
        }
        setTenantId(value);
    }
}
