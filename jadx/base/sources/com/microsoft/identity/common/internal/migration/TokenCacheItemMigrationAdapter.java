package com.microsoft.identity.common.internal.migration;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.java.cache.ITokenCacheItem;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.foci.FociQueryUtilities;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAccount;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.net.URL;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenCacheItemMigrationAdapter {
    private static final String COMMON = "/common";
    private static final String TAG = "TokenCacheItemMigrationAdapter";
    public static final ExecutorService sBackgroundExecutor = Executors.newCachedThreadPool();

    @NonNull
    public static List<ADALTokenCacheItem> filterDuplicateTokens(@NonNull Collection<ADALTokenCacheItem> collection) {
        if (collection == null) {
            throw new NullPointerException("cacheItems is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (ADALTokenCacheItem aDALTokenCacheItem : collection) {
            if (aDALTokenCacheItem.getResource() == null) {
                Logger.warn(TAG, "Skipping resourceless token.");
            } else {
                if (map.get(aDALTokenCacheItem.getRefreshToken()) == null) {
                    map.put(aDALTokenCacheItem.getRefreshToken(), aDALTokenCacheItem);
                }
                if (map.get(aDALTokenCacheItem.getRefreshToken()) != null && aDALTokenCacheItem.getAuthority().contains(COMMON)) {
                    map.put(aDALTokenCacheItem.getRefreshToken(), aDALTokenCacheItem);
                }
            }
        }
        arrayList.addAll(map.values());
        return arrayList;
    }

    @Nullable
    public static ADALTokenCacheItem findFrt(@NonNull List<ADALTokenCacheItem> list) {
        if (list == null) {
            throw new NullPointerException("cacheItems is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":findFrt", new StringBuilder());
        for (ADALTokenCacheItem aDALTokenCacheItem : list) {
            if (!StringUtil.isNullOrEmpty(aDALTokenCacheItem.getRefreshToken()) && !StringUtil.isNullOrEmpty(aDALTokenCacheItem.getFamilyClientId())) {
                Logger.verbose(strM1170p, "Frt found.");
                return aDALTokenCacheItem;
            }
        }
        return null;
    }

    @Nullable
    public static ADALTokenCacheItem findMrrt(@NonNull List<ADALTokenCacheItem> list) {
        if (list == null) {
            throw new NullPointerException("cacheItems is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":findMrrt", new StringBuilder());
        for (ADALTokenCacheItem aDALTokenCacheItem : list) {
            if (!StringUtil.isNullOrEmpty(aDALTokenCacheItem.getRefreshToken()) && aDALTokenCacheItem.getIsMultiResourceRefreshToken()) {
                Logger.verbose(strM1170p, "Mrrt found.");
                return aDALTokenCacheItem;
            }
        }
        return null;
    }

    @Nullable
    public static ADALTokenCacheItem findRt(@NonNull List<ADALTokenCacheItem> list) {
        if (list == null) {
            throw new NullPointerException("cacheItems is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":findRt", new StringBuilder());
        for (ADALTokenCacheItem aDALTokenCacheItem : list) {
            if (!StringUtil.isNullOrEmpty(aDALTokenCacheItem.getRefreshToken())) {
                Logger.verbose(strM1170p, "RT found.");
                return aDALTokenCacheItem;
            }
        }
        return null;
    }

    @NonNull
    public static String getScopesForTokenRequest(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("v1Resource is marked non-null but is null");
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(MicrosoftStsOAuth2Strategy.getScopeFromResource(str), " ");
        sbM781w.append(BaseController.getDelimitedDefaultScopeString());
        return sbM781w.toString();
    }

    public static void logTokenResultError(@NonNull UUID uuid, @NonNull TokenResult tokenResult) {
        if (uuid == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (tokenResult == null) {
            throw new NullPointerException("tokenResult is marked non-null but is null");
        }
        TokenErrorResponse errorResponse = tokenResult.getErrorResponse();
        String str = TAG;
        Logger.warn(str, uuid.toString(), "Status code: [" + errorResponse.getStatusCode() + "]");
        Logger.warn(str, uuid.toString(), "Error description: [" + errorResponse.getErrorDescription() + "]");
    }

    public static List<Map.Entry<MicrosoftAccount, MicrosoftRefreshToken>> migrateTokens(@NonNull Map<String, String> map, @NonNull Collection<ADALTokenCacheItem> collection) {
        if (map == null) {
            throw new NullPointerException("redirects is marked non-null but is null");
        }
        if (collection == null) {
            throw new NullPointerException("cacheItems is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        if (AdalMigrationAdapter.loadCloudDiscoveryMetadata()) {
            Map<String, List<ADALTokenCacheItem>> mapPreferentiallySelectTokens = preferentiallySelectTokens(splitTokensByClientId(filterDuplicateTokens(collection)));
            ArrayList arrayList2 = new ArrayList();
            Iterator<List<ADALTokenCacheItem>> it = mapPreferentiallySelectTokens.values().iterator();
            while (it.hasNext()) {
                arrayList2.addAll(it.next());
            }
            arrayList.addAll(renewTokens(map, arrayList2));
        }
        return arrayList;
    }

    public static Map<String, List<ADALTokenCacheItem>> preferentiallySelectTokens(@NonNull Map<String, List<ADALTokenCacheItem>> map) {
        if (map == null) {
            throw new NullPointerException("tokensByClientId is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":preferentiallySelectTokens", new StringBuilder());
        HashMap map2 = new HashMap();
        for (Map.Entry<String, List<ADALTokenCacheItem>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<ADALTokenCacheItem> value = entry.getValue();
            ADALTokenCacheItem aDALTokenCacheItemFindFrt = findFrt(value);
            if (aDALTokenCacheItemFindFrt == null) {
                Logger.verbose(strM1170p, "FRT was null. Try MRRT.");
                aDALTokenCacheItemFindFrt = findMrrt(value);
            }
            if (aDALTokenCacheItemFindFrt == null) {
                Logger.verbose(strM1170p, "MRRT was null. Try RT.");
                aDALTokenCacheItemFindFrt = findRt(value);
            }
            if (aDALTokenCacheItemFindFrt != null) {
                if (map2.get(key) == null) {
                    map2.put(key, new ArrayList());
                }
                ((List) map2.get(key)).add(aDALTokenCacheItemFindFrt);
            } else {
                Logger.warn(strM1170p, "Refresh token could not be located.");
            }
        }
        return map2;
    }

    @Nullable
    public static Map.Entry<MicrosoftAccount, MicrosoftRefreshToken> renewToken(@Nullable String str, @NonNull ITokenCacheItem iTokenCacheItem) {
        if (iTokenCacheItem == null) {
            throw new NullPointerException("targetCacheItemToRenew is marked non-null but is null");
        }
        if (!StringUtil.isNullOrEmpty(str)) {
            try {
                String authority = iTokenCacheItem.getAuthority();
                String clientId = iTokenCacheItem.getClientId();
                String refreshToken = iTokenCacheItem.getRefreshToken();
                MicrosoftStsOAuth2Configuration microsoftStsOAuth2Configuration = new MicrosoftStsOAuth2Configuration();
                microsoftStsOAuth2Configuration.setAuthorityUrl(new URL(authority));
                UUID uuidRandomUUID = UUID.randomUUID();
                String delimitedDefaultScopeString = StringUtil.isNullOrEmpty(iTokenCacheItem.getResource()) ? BaseController.getDelimitedDefaultScopeString() : getScopesForTokenRequest(iTokenCacheItem.getResource());
                MicrosoftStsOAuth2Strategy microsoftStsOAuth2Strategy = new MicrosoftStsOAuth2Strategy(microsoftStsOAuth2Configuration, OAuth2StrategyParameters.builder().build());
                TokenResult tokenResultRequestToken = microsoftStsOAuth2Strategy.requestToken(FociQueryUtilities.createTokenRequest(clientId, delimitedDefaultScopeString, refreshToken, str, microsoftStsOAuth2Strategy, uuidRandomUUID, "2"));
                if (tokenResultRequestToken.getSuccess()) {
                    MicrosoftStsTokenResponse microsoftStsTokenResponse = (MicrosoftStsTokenResponse) tokenResultRequestToken.getTokenResponse();
                    microsoftStsTokenResponse.setClientId(clientId);
                    MicrosoftStsAccount microsoftStsAccountCreateAccount = microsoftStsOAuth2Strategy.createAccount(microsoftStsTokenResponse);
                    MicrosoftStsRefreshToken microsoftStsRefreshToken = new MicrosoftStsRefreshToken(microsoftStsTokenResponse);
                    microsoftStsRefreshToken.setEnvironment(AzureActiveDirectory.getAzureActiveDirectoryCloud(new URL(authority)).getPreferredCacheHostName());
                    return new AbstractMap.SimpleEntry(microsoftStsAccountCreateAccount, microsoftStsRefreshToken);
                }
                Logger.warn(TAG, uuidRandomUUID.toString(), "TokenRequest was unsuccessful.");
                if (tokenResultRequestToken.getErrorResponse() != null) {
                    logTokenResultError(uuidRandomUUID, tokenResultRequestToken);
                    return null;
                }
            } catch (Exception e) {
                Logger.errorPII(TAG, "Failed to request new refresh token...", e);
            }
        }
        return null;
    }

    private static List<Map.Entry<MicrosoftAccount, MicrosoftRefreshToken>> renewTokens(@NonNull final Map<String, String> map, @NonNull final List<ADALTokenCacheItem> list) {
        if (map == null) {
            throw new NullPointerException("redirects is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("filteredTokens is marked non-null but is null");
        }
        final ArrayList arrayList = new ArrayList();
        int size = list.size();
        final CountDownLatch countDownLatch = new CountDownLatch(size);
        for (final int i = 0; i < size; i++) {
            sBackgroundExecutor.submit(new Runnable() { // from class: com.microsoft.identity.common.internal.migration.TokenCacheItemMigrationAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    ADALTokenCacheItem aDALTokenCacheItem = (ADALTokenCacheItem) list.get(i);
                    Map.Entry<MicrosoftAccount, MicrosoftRefreshToken> entryRenewToken = TokenCacheItemMigrationAdapter.renewToken((String) map.get(aDALTokenCacheItem.getClientId()), aDALTokenCacheItem);
                    if (entryRenewToken != null) {
                        arrayList.add(entryRenewToken);
                    }
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
            return arrayList;
        } catch (InterruptedException e) {
            Logger.error(TAG, "Interrupted while requesting tokens...", e);
            Thread.currentThread().interrupt();
            return arrayList;
        }
    }

    @NonNull
    public static Map<String, List<ADALTokenCacheItem>> splitTokensByClientId(@NonNull List<ADALTokenCacheItem> list) {
        if (list == null) {
            throw new NullPointerException("cacheItemsIn is marked non-null but is null");
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":splitTokensByClientId", new StringBuilder()), "Splitting [" + list.size() + "] cache items.");
        HashMap map = new HashMap();
        for (ADALTokenCacheItem aDALTokenCacheItem : list) {
            if (map.get(aDALTokenCacheItem.getClientId()) == null) {
                map.put(aDALTokenCacheItem.getClientId(), new ArrayList());
            }
            ((List) map.get(aDALTokenCacheItem.getClientId())).add(aDALTokenCacheItem);
        }
        return map;
    }
}
