package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.net.HttpResponse;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenErrorResponse;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.ObjectMapper;
import java.net.URISyntaxException;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AzureActiveDirectoryOAuth2Strategy extends OAuth2Strategy<AzureActiveDirectoryAccessToken, AzureActiveDirectoryAccount, AzureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryAuthorizationRequest.Builder, IAuthorizationStrategy, AzureActiveDirectoryOAuth2Configuration, OAuth2StrategyParameters, AzureActiveDirectoryAuthorizationResponse, AzureActiveDirectoryRefreshToken, AzureActiveDirectoryTokenRequest, AzureActiveDirectoryTokenResponse, TokenResult, AuthorizationResult> {
    private static final String TAG = "AzureActiveDirectoryOAuth2Strategy";

    public AzureActiveDirectoryOAuth2Strategy(AzureActiveDirectoryOAuth2Configuration azureActiveDirectoryOAuth2Configuration, OAuth2StrategyParameters oAuth2StrategyParameters) throws ClientException {
        super(azureActiveDirectoryOAuth2Configuration, oAuth2StrategyParameters);
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        if (azureActiveDirectoryOAuth2Configuration.getAuthorityUrl() == null) {
            setTokenEndpoint("https://login.microsoftonline.com/microsoft.com/oauth2/token");
            return;
        }
        setTokenEndpoint(azureActiveDirectoryOAuth2Configuration.getAuthorityUrl().toString() + "/oauth2/token");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AzureActiveDirectoryTokenRequest createRefreshTokenRequest(AbstractAuthenticationScheme abstractAuthenticationScheme) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AzureActiveDirectoryTokenRequest createRopcTokenRequest(RopcTokenCommandParameters ropcTokenCommandParameters) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AzureActiveDirectoryTokenRequest createTokenRequest(AzureActiveDirectoryAuthorizationRequest azureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryAuthorizationResponse azureActiveDirectoryAuthorizationResponse, AbstractAuthenticationScheme abstractAuthenticationScheme) {
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AuthorizationResultFactory getAuthorizationResultFactory() {
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public TokenResult getTokenResultFromHttpResponse(HttpResponse httpResponse) {
        TokenErrorResponse tokenErrorResponse;
        TokenResponse tokenResponse = null;
        if (httpResponse.getStatusCode() >= 400) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":getTokenResultFromHttpResponse", new StringBuilder()), "Status code was: " + httpResponse.getStatusCode());
            tokenErrorResponse = (TokenErrorResponse) ObjectMapper.deserializeJsonStringToObject(httpResponse.getBody(), MicrosoftTokenErrorResponse.class);
        } else {
            tokenResponse = (TokenResponse) ObjectMapper.deserializeJsonStringToObject(httpResponse.getBody(), AzureActiveDirectoryTokenResponse.class);
            tokenErrorResponse = null;
        }
        return new TokenResult(tokenResponse, tokenErrorResponse);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public void validateAuthorizationRequest(AzureActiveDirectoryAuthorizationRequest azureActiveDirectoryAuthorizationRequest) {
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public void validateTokenRequest(AzureActiveDirectoryTokenRequest azureActiveDirectoryTokenRequest) {
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public void validateTokenResponse(AzureActiveDirectoryTokenRequest azureActiveDirectoryTokenRequest, AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) {
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AzureActiveDirectoryAccount createAccount(@NonNull AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) {
        if (azureActiveDirectoryTokenResponse == null) {
            throw new NullPointerException("response is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":createAccount", new StringBuilder());
        try {
            Logger.info(strM1170p, "Constructing IDToken from response");
            IDToken iDToken = new IDToken(azureActiveDirectoryTokenResponse.getIdToken());
            Logger.info(strM1170p, "Constructing ClientInfo from response");
            AzureActiveDirectoryAccount azureActiveDirectoryAccount = new AzureActiveDirectoryAccount(iDToken, new ClientInfo(azureActiveDirectoryTokenResponse.getClientInfo()));
            Logger.info(strM1170p, "Account created");
            Logger.infoPII(strM1170p, azureActiveDirectoryAccount.toString());
            return azureActiveDirectoryAccount;
        } catch (ServiceException e) {
            Logger.error(strM1170p, "Failed to construct IDToken or ClientInfo", null);
            Logger.errorPII(strM1170p, "Failed with Exception", e);
            throw new RuntimeException();
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AzureActiveDirectoryAccessToken getAccessTokenFromResponse(@NonNull AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) {
        if (azureActiveDirectoryTokenResponse != null) {
            return new AzureActiveDirectoryAccessToken(azureActiveDirectoryTokenResponse);
        }
        throw new NullPointerException("response is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public String getIssuerCacheIdentifier(AzureActiveDirectoryAuthorizationRequest azureActiveDirectoryAuthorizationRequest) throws ClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getIssuerCacheIdentifier", new StringBuilder());
        AzureActiveDirectoryCloud azureActiveDirectoryCloud = AzureActiveDirectory.getAzureActiveDirectoryCloud(azureActiveDirectoryAuthorizationRequest.getAuthority());
        if (azureActiveDirectoryCloud == null) {
            if (getOAuth2Configuration().isAuthorityHostValidationEnabled()) {
                throw new ClientException(ErrorStrings.AUTHORITY_URL_NOT_VALID, "Discovery data does not include cloud authority and validation is on.");
            }
            Logger.warn(strM1170p, "Discovery data does not include cloud authority and validation is off. Returning passed in Authority: " + azureActiveDirectoryAuthorizationRequest.getAuthority().toString());
            return azureActiveDirectoryAuthorizationRequest.getAuthority().toString();
        }
        if (!azureActiveDirectoryCloud.isValidated() && getOAuth2Configuration().isAuthorityHostValidationEnabled()) {
            Logger.warn(strM1170p, "Authority host validation has been enabled. This data hasn't been validated, though.");
        }
        if (!azureActiveDirectoryCloud.isValidated() && !getOAuth2Configuration().isAuthorityHostValidationEnabled()) {
            Logger.warn(strM1170p, "Authority host validation not specified...but there is no cloud...Hence just return the passed in Authority");
            return azureActiveDirectoryAuthorizationRequest.getAuthority().toString();
        }
        Logger.info(strM1170p, "Building authority URI");
        try {
            String string = new CommonURIBuilder(azureActiveDirectoryAuthorizationRequest.getAuthority().toString()).setHost(azureActiveDirectoryCloud.getPreferredCacheHostName()).build().toString();
            Logger.infoPII(strM1170p, "Issuer cache identifier created: " + string);
            return string;
        } catch (URISyntaxException e) {
            throw new ClientException("malformed_url", e.getMessage(), e);
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AzureActiveDirectoryRefreshToken getRefreshTokenFromResponse(@NonNull AzureActiveDirectoryTokenResponse azureActiveDirectoryTokenResponse) {
        if (azureActiveDirectoryTokenResponse != null) {
            return new AzureActiveDirectoryRefreshToken(azureActiveDirectoryTokenResponse);
        }
        throw new NullPointerException("response is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AzureActiveDirectoryAuthorizationRequest.Builder createAuthorizationRequestBuilder() {
        return new AzureActiveDirectoryAuthorizationRequest.Builder();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy
    public AzureActiveDirectoryAuthorizationRequest.Builder createAuthorizationRequestBuilder(IAccountRecord iAccountRecord) {
        return createAuthorizationRequestBuilder();
    }
}
