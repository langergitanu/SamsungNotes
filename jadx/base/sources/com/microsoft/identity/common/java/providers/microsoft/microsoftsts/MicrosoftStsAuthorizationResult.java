package com.microsoft.identity.common.java.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftStsAuthorizationResult extends MicrosoftAuthorizationResult<MicrosoftStsAuthorizationResponse, MicrosoftStsAuthorizationErrorResponse> {
    public MicrosoftStsAuthorizationResult(AuthorizationStatus authorizationStatus, MicrosoftStsAuthorizationResponse microsoftStsAuthorizationResponse) {
        super(authorizationStatus, microsoftStsAuthorizationResponse);
    }

    public MicrosoftStsAuthorizationResult(AuthorizationStatus authorizationStatus, MicrosoftStsAuthorizationErrorResponse microsoftStsAuthorizationErrorResponse) {
        super(authorizationStatus, microsoftStsAuthorizationErrorResponse);
    }
}
