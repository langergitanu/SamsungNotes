package com.microsoft.identity.client.internal.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class BrokerClientIdRefreshTokenAccessor {
    private static final String TAG = "BrokerClientIdRefreshTokenAccessor";

    @Nullable
    public static String get(@NonNull Context context, @NonNull String str) throws MsalClientException {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":get", new StringBuilder());
        throwIfNotValidBroker(context);
        MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> msalOAuth2TokenCacheCreate = MsalOAuth2TokenCache.create(AndroidPlatformComponentsFactory.createFromContext(context));
        ICacheRecord cacheRecordForIdentifier = getCacheRecordForIdentifier(msalOAuth2TokenCacheCreate, str, "null/null");
        if (cacheRecordForIdentifier == null) {
            Logger.verbose(strM1170p, "No cache record found.");
            return null;
        }
        msalOAuth2TokenCacheCreate.removeCredential(cacheRecordForIdentifier.getRefreshToken());
        msalOAuth2TokenCacheCreate.removeCredential(cacheRecordForIdentifier.getAccessToken());
        if (cacheRecordForIdentifier.getRefreshToken() != null) {
            return cacheRecordForIdentifier.getRefreshToken().getSecret();
        }
        Logger.verbose(strM1170p, "Refresh token record is empty.");
        return null;
    }

    private static ICacheRecord getCacheRecordForIdentifier(@NonNull MsalOAuth2TokenCache msalOAuth2TokenCache, @NonNull String str, @NonNull String str2) throws MsalClientException {
        AccountRecord accountByLocalAccountId = msalOAuth2TokenCache.getAccountByLocalAccountId(null, AuthenticationConstants.Broker.BROKER_CLIENT_ID, str);
        if (accountByLocalAccountId != null) {
            return msalOAuth2TokenCache.load(AuthenticationConstants.Broker.BROKER_CLIENT_ID, str2, null, null, accountByLocalAccountId, new BearerAuthenticationSchemeInternal());
        }
        throw new MsalClientException(ClientException.TOKEN_CACHE_ITEM_NOT_FOUND);
    }

    private static void throwIfNotValidBroker(Context context) throws MsalClientException {
        if (!new BrokerValidator(context).isValidBrokerPackage(context.getPackageName())) {
            throw new MsalClientException(MsalClientException.NOT_ELIGIBLE_TO_USE_BROKER, "This can only be invoked by Broker apps.");
        }
    }
}
