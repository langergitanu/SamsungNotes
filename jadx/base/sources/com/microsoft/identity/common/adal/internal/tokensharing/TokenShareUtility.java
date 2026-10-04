package com.microsoft.identity.common.adal.internal.tokensharing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.adal.tokensharing.SSOStateSerializer;
import com.microsoft.identity.common.internal.migration.AdalMigrationAdapter;
import com.microsoft.identity.common.internal.migration.TokenCacheItemMigrationAdapter;
import com.microsoft.identity.common.java.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.logging.Logger;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.PlainHeader;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.PlainJWT;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenShareUtility implements ITokenShareInternal {
    private static final String CONSUMERS_ENDPOINT = "https://login.microsoftonline.com/consumers";
    private static final String TAG = "TokenShareUtility";
    private static final Map<String, String> sClaimRemapper = new HashMap();
    private final String mClientId;
    private final String mRedirectUri;
    private final MsalOAuth2TokenCache mTokenCache;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Environment {
        WORLDWIDE("https://login.windows.net/common"),
        GALLATIN("https://login.partner.microsoftonline.cn/common"),
        BLACKFOREST("https://login.microsoftonline.de/common"),
        ITAR("https://login.microsoftonline.us/common");

        private String mCommonEndpoint;

        Environment(String str) {
            this.mCommonEndpoint = str;
        }

        @NonNull
        public static Environment toEnvironment(@NonNull String str) throws ClientException {
            String str2;
            str2 = TokenShareUtility.TAG + ":toEnvironment";
            str.getClass();
            switch (str) {
                case "login.partner.microsoftonline.cn":
                case "login.chinacloudapi.cn":
                    return GALLATIN;
                case "login.microsoftonline.de":
                    return BLACKFOREST;
                case "login.microsoftonline.us":
                case "login.usgovcloudapi.net":
                    return ITAR;
                case "sts.windows.net":
                case "login.microsoft.com":
                case "login.windows.net":
                case "login.microsoftonline.com":
                    return WORLDWIDE;
                default:
                    Logger.warn(str2, "Unable to map provided env to enum: ".concat(str));
                    throw new ClientException("Unrecognized environment");
            }
        }

        public String getCommonEndpoint() {
            return this.mCommonEndpoint;
        }
    }

    static {
        applyV1ToV2Mappings();
    }

    public TokenShareUtility(@NonNull String str, @NonNull String str2, @NonNull MsalOAuth2TokenCache msalOAuth2TokenCache) {
        this.mClientId = str;
        this.mRedirectUri = str2;
        this.mTokenCache = msalOAuth2TokenCache;
    }

    @NonNull
    private static ADALTokenCacheItem adapt(@NonNull IdTokenRecord idTokenRecord, @NonNull RefreshTokenRecord refreshTokenRecord) {
        ADALTokenCacheItem aDALTokenCacheItem = new ADALTokenCacheItem();
        aDALTokenCacheItem.setClientId(refreshTokenRecord.getClientId());
        aDALTokenCacheItem.setRefreshToken(refreshTokenRecord.getSecret());
        aDALTokenCacheItem.setRawIdToken(mintV1IdTokenFromRawV2IdToken(idTokenRecord.getSecret()));
        aDALTokenCacheItem.setFamilyClientId(refreshTokenRecord.getFamilyId());
        aDALTokenCacheItem.setAuthority(isFromHomeTenant(idTokenRecord) ? Environment.toEnvironment(refreshTokenRecord.getEnvironment()).getCommonEndpoint() : idTokenRecord.getAuthority());
        return aDALTokenCacheItem;
    }

    private static void applyV1ToV2Mappings() {
        sClaimRemapper.put("preferred_username", "upn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ADALTokenCacheItem createTokenCacheItem(@NonNull String str, @NonNull String str2) {
        ADALTokenCacheItem aDALTokenCacheItem = new ADALTokenCacheItem();
        aDALTokenCacheItem.setAuthority(str2);
        aDALTokenCacheItem.setClientId(this.mClientId);
        aDALTokenCacheItem.setRefreshToken(str);
        return aDALTokenCacheItem;
    }

    private AccountRecord getAccountRecordForIdentifier(@NonNull String str) throws ClientException {
        AccountRecord accountByLocalAccountId = this.mTokenCache.getAccountByLocalAccountId(null, this.mClientId, str);
        if (accountByLocalAccountId == null) {
            List<AccountRecord> accountsByUsername = this.mTokenCache.getAccountsByUsername(null, this.mClientId, str);
            if (!accountsByUsername.isEmpty()) {
                accountByLocalAccountId = accountsByUsername.get(0);
            }
        }
        if (accountByLocalAccountId != null) {
            return accountByLocalAccountId;
        }
        throw new ClientException(ClientException.TOKEN_CACHE_ITEM_NOT_FOUND);
    }

    private ICacheRecord getCacheRecordForIdentifier(@NonNull String str) throws ClientException {
        return this.mTokenCache.load(this.mClientId, null, null, null, getAccountRecordForIdentifier(str), new BearerAuthenticationSchemeInternal());
    }

    private static boolean isFromHomeTenant(@NonNull IdTokenRecord idTokenRecord) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isFromHomeTenant", new StringBuilder());
        String homeAccountId = idTokenRecord.getHomeAccountId();
        try {
            String str = (String) IDToken.parseJWT(idTokenRecord.getSecret()).get("oid");
            if (str != null) {
                return homeAccountId.contains(str);
            }
            Logger.warn(strM1170p, "OID claims was missing from token.");
            return false;
        } catch (ServiceException unused) {
            Logger.warn(strM1170p, "Failed to parse IdToken.");
            return false;
        }
    }

    @NonNull
    private static String mintV1IdTokenFromRawV2IdToken(@NonNull String str) throws ServiceException {
        Map<String, ?> jwt = IDToken.parseJWT(str);
        JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
        for (Map.Entry<String, ?> entry : jwt.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if ("ver".equals(key)) {
                value = "1";
            }
            builder.claim(remap(key), value);
        }
        return new PlainJWT(new PlainHeader(JOSEObjectType.JWT, null, null, null, null), builder.build()).serialize();
    }

    @NonNull
    private static String remap(@NonNull String str) {
        String str2 = sClaimRemapper.get(str);
        return str2 == null ? str : str2;
    }

    private void saveResult(@Nullable Map.Entry<MicrosoftAccount, MicrosoftRefreshToken> entry) throws ClientException {
        if (entry != null) {
            this.mTokenCache.setSingleSignOnState(entry.getKey(), entry.getValue());
        }
    }

    private void throwIfCacheRecordIncomplete(@NonNull String str, @NonNull ICacheRecord iCacheRecord) throws ClientException {
        if (iCacheRecord.getRefreshToken() == null || iCacheRecord.getIdToken() == null) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":throwIfCacheRecordIncomplete", new StringBuilder()), "That's strange, we had an AccountRecord for identifier: " + str + " but couldn't find tokens for them.");
            throw new ClientException(ClientException.TOKEN_CACHE_ITEM_NOT_FOUND);
        }
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public String getMsaFamilyRefreshToken(@NonNull String str) {
        return getMsaFamilyRefreshTokenWithMetadata(str).getRefreshToken();
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public ITokenShareResultInternal getMsaFamilyRefreshTokenWithMetadata(@NonNull String str) throws ClientException {
        ICacheRecord cacheRecordForIdentifier = getCacheRecordForIdentifier(str);
        throwIfCacheRecordIncomplete(str, cacheRecordForIdentifier);
        return new TokenShareResultInternal(cacheRecordForIdentifier, cacheRecordForIdentifier.getRefreshToken().getSecret(), "RAW");
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    @NonNull
    public String getOrgIdFamilyRefreshToken(@NonNull String str) {
        return getOrgIdFamilyRefreshTokenWithMetadata(str).getRefreshToken();
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public ITokenShareResultInternal getOrgIdFamilyRefreshTokenWithMetadata(@NonNull String str) throws ClientException {
        ICacheRecord cacheRecordForIdentifier = getCacheRecordForIdentifier(str);
        throwIfCacheRecordIncomplete(str, cacheRecordForIdentifier);
        return new TokenShareResultInternal(cacheRecordForIdentifier, SSOStateSerializer.serialize(adapt(cacheRecordForIdentifier.getIdToken(), cacheRecordForIdentifier.getRefreshToken())), "SSO_STATE_SERIALIZER_BLOB");
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public void saveMsaFamilyRefreshToken(@NonNull final String str) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":saveMsaFamilyRefreshToken", new StringBuilder());
        saveResult((Map.Entry) TokenCacheItemMigrationAdapter.sBackgroundExecutor.submit(new Callable<Map.Entry<MicrosoftAccount, MicrosoftRefreshToken>>() { // from class: com.microsoft.identity.common.adal.internal.tokensharing.TokenShareUtility.2
            @Override // java.util.concurrent.Callable
            public Map.Entry<MicrosoftAccount, MicrosoftRefreshToken> call() {
                ADALTokenCacheItem aDALTokenCacheItemCreateTokenCacheItem = TokenShareUtility.this.createTokenCacheItem(str, TokenShareUtility.CONSUMERS_ENDPOINT);
                if (AdalMigrationAdapter.loadCloudDiscoveryMetadata()) {
                    return TokenCacheItemMigrationAdapter.renewToken(TokenShareUtility.this.mRedirectUri, aDALTokenCacheItemCreateTokenCacheItem);
                }
                Logger.warn(strM1170p, "Failed to load cloud metadata, aborting.");
                return null;
            }
        }).get());
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareInternal
    public void saveOrgIdFamilyRefreshToken(@NonNull final String str) {
        final String strM1170p = AbstractC0622a.m1170p(TAG, ":saveOrgIdFamilyRefreshToken", new StringBuilder());
        saveResult((Map.Entry) TokenCacheItemMigrationAdapter.sBackgroundExecutor.submit(new Callable<Map.Entry<MicrosoftAccount, MicrosoftRefreshToken>>() { // from class: com.microsoft.identity.common.adal.internal.tokensharing.TokenShareUtility.1
            @Override // java.util.concurrent.Callable
            public Map.Entry<MicrosoftAccount, MicrosoftRefreshToken> call() {
                ADALTokenCacheItem aDALTokenCacheItemDeserialize = SSOStateSerializer.deserialize(str);
                aDALTokenCacheItemDeserialize.setClientId(TokenShareUtility.this.mClientId);
                aDALTokenCacheItemDeserialize.setResource(null);
                if (AdalMigrationAdapter.loadCloudDiscoveryMetadata()) {
                    return TokenCacheItemMigrationAdapter.renewToken(TokenShareUtility.this.mRedirectUri, aDALTokenCacheItemDeserialize);
                }
                Logger.warn(strM1170p, "Failed to load cloud metadata, aborting.");
                return null;
            }
        }).get());
    }
}
