package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IAcquireMicrosoftStsTokenStrategy<T extends TokenCommandParameters> {
    @NonNull
    TokenResult acquireToken(@NonNull MicrosoftStsTokenRequest microsoftStsTokenRequest);

    @NonNull
    MicrosoftStsTokenRequest createTokenRequest(@NonNull T t);
}
