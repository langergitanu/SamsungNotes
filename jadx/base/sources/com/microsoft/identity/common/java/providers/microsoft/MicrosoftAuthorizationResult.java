package com.microsoft.identity.common.java.providers.microsoft;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class MicrosoftAuthorizationResult<GenericMicrosoftAuthorizationResponse extends MicrosoftAuthorizationResponse, GenericMicrosoftAuthorizationErrorResponse extends MicrosoftAuthorizationErrorResponse> extends AuthorizationResult<GenericMicrosoftAuthorizationResponse, GenericMicrosoftAuthorizationErrorResponse> {
    public MicrosoftAuthorizationResult(AuthorizationStatus authorizationStatus, GenericMicrosoftAuthorizationResponse genericmicrosoftauthorizationresponse) {
        super(genericmicrosoftauthorizationresponse, null);
        setAuthorizationStatus(authorizationStatus);
        setAuthorizationResponse(genericmicrosoftauthorizationresponse);
    }

    public MicrosoftAuthorizationResult(AuthorizationStatus authorizationStatus, GenericMicrosoftAuthorizationErrorResponse genericmicrosoftauthorizationerrorresponse) {
        super(null, genericmicrosoftauthorizationerrorresponse);
        setAuthorizationStatus(authorizationStatus);
        setAuthorizationErrorResponse(genericmicrosoftauthorizationerrorresponse);
    }
}
