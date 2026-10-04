package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryAuthorizationResult extends MicrosoftAuthorizationResult<AzureActiveDirectoryAuthorizationResponse, AzureActiveDirectoryAuthorizationErrorResponse> {
    public AzureActiveDirectoryAuthorizationResult(AuthorizationStatus authorizationStatus, AzureActiveDirectoryAuthorizationResponse azureActiveDirectoryAuthorizationResponse) {
        super(authorizationStatus, azureActiveDirectoryAuthorizationResponse);
    }

    public AzureActiveDirectoryAuthorizationResult(AuthorizationStatus authorizationStatus, AzureActiveDirectoryAuthorizationErrorResponse azureActiveDirectoryAuthorizationErrorResponse) {
        super(authorizationStatus, azureActiveDirectoryAuthorizationErrorResponse);
    }
}
