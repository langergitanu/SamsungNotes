package com.microsoft.identity.client.exception;

import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.exception.IntuneAppProtectionPolicyRequiredException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MsalIntuneAppProtectionPolicyRequiredException extends MsalServiceException {
    private String mAccountUpn;
    private String mAccountUserId;
    private String mAuthorityUrl;
    private String mTenantId;

    public MsalIntuneAppProtectionPolicyRequiredException(@NonNull IntuneAppProtectionPolicyRequiredException intuneAppProtectionPolicyRequiredException) {
        super(intuneAppProtectionPolicyRequiredException.getErrorCode(), intuneAppProtectionPolicyRequiredException.getMessage(), intuneAppProtectionPolicyRequiredException);
        this.mAccountUpn = intuneAppProtectionPolicyRequiredException.getAccountUpn();
        this.mAccountUserId = intuneAppProtectionPolicyRequiredException.getAccountUserId();
        this.mAuthorityUrl = intuneAppProtectionPolicyRequiredException.getAuthorityUrl();
        this.mTenantId = intuneAppProtectionPolicyRequiredException.getTenantId();
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

    public String getTenantId() {
        return this.mTenantId;
    }
}
