package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryRefreshToken extends MicrosoftRefreshToken {
    @SuppressFBWarnings({SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
    public AzureActiveDirectoryRefreshToken(@NonNull AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) {
        super(azureActiveDirectoryTokenResponse);
        if (azureActiveDirectoryTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
    }
}
