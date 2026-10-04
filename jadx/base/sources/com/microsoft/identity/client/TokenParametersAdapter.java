package com.microsoft.identity.client;

import androidx.annotation.NonNull;
import com.microsoft.identity.client.AcquireTokenSilentParameters;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenParametersAdapter {
    public static AcquireTokenSilentParameters silentParametersFromInteractive(@NonNull AcquireTokenParameters acquireTokenParameters, @NonNull ILocalAuthenticationResult iLocalAuthenticationResult) {
        return new AcquireTokenSilentParameters.Builder().withCallback(acquireTokenParameters.getCallback()).fromAuthority(acquireTokenParameters.getAuthority()).withClaims(acquireTokenParameters.getClaimsRequest()).withScopes(acquireTokenParameters.getScopes()).forAccount(AccountAdapter.adapt(iLocalAuthenticationResult.getCacheRecordWithTenantProfileData()).get(0)).build();
    }
}
