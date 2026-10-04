package com.microsoft.identity.common.java.foci;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.cache.BrokerOAuth2TokenCache;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.ObjectUtils;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.context.Scope;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FociQueryUtilities {
    private static final String TAG = "FociQueryUtilities";

    private static void brokerOAuth2TokenCacheSave(@NonNull OAuth2TokenCache oAuth2TokenCache, MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, TokenResult tokenResult, MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequest) {
        if (oAuth2TokenCache == null) {
            throw new NullPointerException("brokerOAuth2TokenCache is marked non-null but is null");
        }
        oAuth2TokenCache.save(microsoftStsOAuth2Strategy, microsoftStsAuthorizationRequest, (MicrosoftTokenResponse) tokenResult.getTokenResponse());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static MicrosoftStsAuthorizationRequest createAuthRequest(@NonNull MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull IAccountRecord iAccountRecord, @Nullable UUID uuid) {
        if (microsoftStsOAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("scope is marked non-null but is null");
        }
        if (iAccountRecord != null) {
            return ((MicrosoftStsAuthorizationRequest.Builder) ((MicrosoftStsAuthorizationRequest.Builder) ((MicrosoftStsAuthorizationRequest.Builder) microsoftStsOAuth2Strategy.createAuthorizationRequestBuilder(iAccountRecord).setClientId(str)).setRedirectUri(str2)).setCorrelationId(uuid).setScope(str3)).build();
        }
        throw new NullPointerException("accountRecord is marked non-null but is null");
    }

    @NonNull
    public static MicrosoftStsTokenRequest createTokenRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy, @Nullable UUID uuid, @NonNull String str5) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("scopes is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        if (str4 == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (microsoftStsOAuth2Strategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (str5 == null) {
            throw new NullPointerException("idTokenVersion is marked non-null but is null");
        }
        MicrosoftStsTokenRequest microsoftStsTokenRequestCreateRefreshTokenRequest = microsoftStsOAuth2Strategy.createRefreshTokenRequest((AbstractAuthenticationScheme) new BearerAuthenticationSchemeInternal());
        microsoftStsTokenRequestCreateRefreshTokenRequest.setClientId(str);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setScope(str2);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setCorrelationId(uuid);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setRefreshToken(str3);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setRedirectUri(str4);
        microsoftStsTokenRequestCreateRefreshTokenRequest.setIdTokenVersion(str5);
        return microsoftStsTokenRequestCreateRefreshTokenRequest;
    }

    public static boolean tryFociTokenWithGivenClientId(@NonNull BrokerOAuth2TokenCache brokerOAuth2TokenCache, @NonNull String str, @NonNull String str2, @NonNull ICacheRecord iCacheRecord) {
        if (brokerOAuth2TokenCache == null) {
            throw new NullPointerException("brokerOAuth2TokenCache is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (iCacheRecord != null) {
            return tryFociTokenWithGivenClientId(brokerOAuth2TokenCache, str, str2, iCacheRecord.getRefreshToken(), iCacheRecord.getAccount());
        }
        throw new NullPointerException("cacheRecord is marked non-null but is null");
    }

    public static boolean tryFociTokenWithGivenClientId(@NonNull OAuth2TokenCache oAuth2TokenCache, @NonNull String str, @NonNull String str2, @NonNull RefreshTokenRecord refreshTokenRecord, @NonNull IAccountRecord iAccountRecord) {
        String delimitedDefaultScopeString;
        if (oAuth2TokenCache == null) {
            throw new NullPointerException("brokerOAuth2TokenCache is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshTokenRecord is marked non-null but is null");
        }
        if (iAccountRecord != null) {
            MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration = new MicrosoftStsOAuth2Configuration();
            CommonURIBuilder commonURIBuilder = new CommonURIBuilder();
            commonURIBuilder.setScheme(AuthenticationConstants.HTTPS_PROTOCOL_STRING).setHost(refreshTokenRecord.getEnvironment()).setPath(StringUtil.isNullOrEmpty(iAccountRecord.getRealm()) ? "common" : iAccountRecord.getRealm());
            try {
                microsoftStsOAuth2Configuration.setAuthorityUrl(new URL(commonURIBuilder.build().toString()));
                MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy = new MicrosoftStsOAuth2Strategy(microsoftStsOAuth2Configuration, OAuth2StrategyParameters.builder().build());
                String secret = refreshTokenRecord.getSecret();
                if (ObjectUtils.equals(str, "87749df4-7ccf-48f8-aa87-704bad0e0e16")) {
                    Span spanCreateSpan = OTelUtility.createSpan(SpanName.SetScopeForDMAgentForFoci.name());
                    try {
                        Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpan);
                        try {
                            delimitedDefaultScopeString = "https://devicemgmt.teams.microsoft.com/.default " + BaseController.getDelimitedDefaultScopeString();
                            Logger.info(TAG + ":tryFociTokenWithGivenClientId", "Teams agent client ID - making a test request with teams agent resource.");
                            if (scopeMakeCurrentSpan != null) {
                                scopeMakeCurrentSpan.close();
                            }
                            spanCreateSpan.end();
                        } finally {
                        }
                    } catch (Throwable th) {
                        spanCreateSpan.end();
                        throw th;
                    }
                } else {
                    delimitedDefaultScopeString = BaseController.getDelimitedDefaultScopeString();
                }
                String str3 = delimitedDefaultScopeString;
                UUID uuidRandomUUID = UUID.randomUUID();
                StringBuilder sb = new StringBuilder();
                String str4 = TAG;
                Logger.verbose(AbstractC0622a.m1170p(str4, ":tryFociTokenWithGivenClientId", sb), "Create the token request with correlationId [" + uuidRandomUUID + "]");
                MicrosoftStsTokenRequest microsoftStsTokenRequestCreateTokenRequest = createTokenRequest(str, str3, secret, str2, microsoftStsOAuth2Strategy, uuidRandomUUID, "2");
                Logger.verbose(AbstractC0541b.m756B(str4, ":tryFociTokenWithGivenClientId"), "Start refreshing token (to verify foci) with correlationId [" + uuidRandomUUID + "]");
                TokenResult tokenResultRequestToken = microsoftStsOAuth2Strategy.requestToken(microsoftStsTokenRequestCreateTokenRequest);
                Logger.verbose(AbstractC0541b.m756B(str4, ":tryFociTokenWithGivenClientId"), "Is the client ID able to use the foci? [" + tokenResultRequestToken.getSuccess() + "] with correlationId [" + uuidRandomUUID + "]");
                if (tokenResultRequestToken.getSuccess()) {
                    MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequestCreateAuthRequest = createAuthRequest(microsoftStsOAuth2Strategy, str, str2, str3, iAccountRecord, uuidRandomUUID);
                    Logger.verbose(AbstractC0541b.m756B(str4, ":tryFociTokenWithGivenClientId"), "Saving records to cache with client id".concat(str));
                    brokerOAuth2TokenCacheSave(oAuth2TokenCache, microsoftStsOAuth2Strategy, tokenResultRequestToken, microsoftStsAuthorizationRequestCreateAuthRequest);
                }
                return tokenResultRequestToken.getSuccess();
            } catch (URISyntaxException e) {
                throw new ClientException("malformed_url", e.getMessage(), e);
            }
        }
        throw new NullPointerException("accountRecord is marked non-null but is null");
    }
}
