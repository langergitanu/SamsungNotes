package com.microsoft.identity.common.java.providers;

import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class IdentityProvider<T extends OAuth2Strategy, U extends OAuth2Configuration> {
    public abstract T createOAuth2Strategy(@NonNull U u, @NonNull IPlatformComponents iPlatformComponents);
}
