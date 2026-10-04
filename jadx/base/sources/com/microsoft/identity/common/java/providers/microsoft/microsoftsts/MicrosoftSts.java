package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.IdentityProvider;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftSts extends IdentityProvider<MicrosoftStsOAuth2Strategy, MicrosoftStsOAuth2Configuration> {
    @Override // com.microsoft.identity.common.java.providers.IdentityProvider
    public MicrosoftStsOAuth2Strategy createOAuth2Strategy(@NonNull MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration, @NonNull IPlatformComponents iPlatformComponents) {
        if (microsoftStsOAuth2Configuration == null) {
            throw new NullPointerException("config is marked non-null but is null");
        }
        if (iPlatformComponents != null) {
            return new MicrosoftStsOAuth2Strategy(microsoftStsOAuth2Configuration, OAuth2StrategyParameters.builder().platformComponents(iPlatformComponents).build());
        }
        throw new NullPointerException("commonComponents is marked non-null but is null");
    }
}
