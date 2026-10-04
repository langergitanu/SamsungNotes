package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.providers.oauth2.AccessToken;
import com.microsoft.identity.common.java.util.CopyUtil;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Date;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryAccessToken extends AccessToken {
    private final Date mExpiresOn;
    private final Date mExtendedExpiresOn;

    @SuppressFBWarnings({SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
    public AzureActiveDirectoryAccessToken(@NonNull AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) {
        super(azureActiveDirectoryTokenResponse);
        if (azureActiveDirectoryTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        this.mExpiresOn = CopyUtil.copyIfNotNull(azureActiveDirectoryTokenResponse.getExpiresOn());
        this.mExtendedExpiresOn = CopyUtil.copyIfNotNull(azureActiveDirectoryTokenResponse.getExtExpiresOn());
    }

    public Date getExpiresOn() {
        return CopyUtil.copyIfNotNull(this.mExpiresOn);
    }

    public Date getExtendedExpiresOn() {
        return CopyUtil.copyIfNotNull(this.mExtendedExpiresOn);
    }
}
