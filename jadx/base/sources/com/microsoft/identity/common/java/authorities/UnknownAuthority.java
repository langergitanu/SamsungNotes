package com.microsoft.identity.common.java.authorities;

import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import java.net.URI;
import java.net.URL;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class UnknownAuthority extends Authority {
    @Override // com.microsoft.identity.common.java.authorities.Authority
    public OAuth2Strategy createOAuth2Strategy(@NonNull OAuth2StrategyParameters oAuth2StrategyParameters) {
        if (oAuth2StrategyParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.java.authorities.Authority
    public URL getAuthorityURL() {
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.java.authorities.Authority
    public URI getAuthorityUri() {
        throw new UnsupportedOperationException();
    }
}
