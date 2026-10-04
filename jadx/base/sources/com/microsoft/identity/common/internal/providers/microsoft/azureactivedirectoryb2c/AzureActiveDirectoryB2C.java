package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.IdentityProvider;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryB2C extends IdentityProvider<AzureActiveDirectoryB2COAuth2Strategy, OAuth2Configuration> {
    @Override // com.microsoft.identity.common.java.providers.IdentityProvider
    public AzureActiveDirectoryB2COAuth2Strategy createOAuth2Strategy(@NonNull OAuth2Configuration oAuth2Configuration, @NonNull IPlatformComponents iPlatformComponents) {
        return new AzureActiveDirectoryB2COAuth2Strategy(oAuth2Configuration, OAuth2StrategyParameters.builder().platformComponents(iPlatformComponents).build());
    }
}
