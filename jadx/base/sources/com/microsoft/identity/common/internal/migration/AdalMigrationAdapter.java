package com.microsoft.identity.common.internal.migration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.logging.Logger;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AdalMigrationAdapter implements IMigrationAdapter<MicrosoftAccount, MicrosoftRefreshToken> {
    private static final String KEY_MIGRATION_STATUS = "adal-migration-complete";
    private static final String MIGRATION_STATUS_SHARED_PREFERENCES = "com.microsoft.identity.client.migration_status";
    private static final String TAG = "AdalMigrationAdapter";
    private static final Object sLock = new Object();
    private final boolean mForceMigration;
    private final Map<String, String> mRedirectsMap;
    private final SharedPreferences mSharedPrefs;

    public AdalMigrationAdapter(Context context, Map<String, String> map, boolean z) {
        this.mSharedPrefs = context.getSharedPreferences(MIGRATION_STATUS_SHARED_PREFERENCES, 0);
        this.mRedirectsMap = map;
        this.mForceMigration = z;
    }

    @Nullable
    public static MicrosoftAccount createAccount(@NonNull ADALTokenCacheItem aDALTokenCacheItem) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":createAccount", new StringBuilder());
        try {
            String rawIdToken = aDALTokenCacheItem.getRawIdToken();
            String userId = aDALTokenCacheItem.getUserInfo().getUserId();
            String tenantId = aDALTokenCacheItem.getTenantId();
            String host = new URL(aDALTokenCacheItem.getAuthority()).getHost();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("uid", userId);
            jsonObject.addProperty("utid", tenantId);
            String string = jsonObject.toString();
            Charset charset = AuthenticationConstants.CHARSET_UTF8;
            AzureActiveDirectoryAccount azureActiveDirectoryAccount = new AzureActiveDirectoryAccount(new IDToken(rawIdToken), new ClientInfo(new String(Base64.encode(string.getBytes(charset), 0), charset)));
            azureActiveDirectoryAccount.setEnvironment(host);
            return azureActiveDirectoryAccount;
        } catch (ServiceException | MalformedURLException e) {
            Logger.error(strM1170p, "Failed to create Account", null);
            Logger.errorPII(strM1170p, "Failed to create Account", e);
            return null;
        }
    }

    public static boolean loadCloudDiscoveryMetadata() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":loadCloudDiscoveryMetadata", new StringBuilder());
        if (!AzureActiveDirectory.isInitialized()) {
            try {
                AzureActiveDirectory.performCloudDiscovery();
            } catch (IOException | URISyntaxException e) {
                Logger.error(strM1170p, "Failed to load instance discovery metadata", e);
            }
        }
        return AzureActiveDirectory.isInitialized();
    }

    @Override // com.microsoft.identity.common.internal.migration.IMigrationAdapter
    public List<Map.Entry<MicrosoftAccount, MicrosoftRefreshToken>> adapt(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        synchronized (sLock) {
            try {
                if (!getMigrationStatus() && !this.mForceMigration && loadCloudDiscoveryMetadata()) {
                    arrayList.addAll(TokenCacheItemMigrationAdapter.migrateTokens(this.mRedirectsMap, deserialize(map).values()));
                    setMigrationStatus(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public Map<String, ADALTokenCacheItem> deserialize(Map<String, String> map) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":deserialize", new StringBuilder());
        HashMap map2 = new HashMap();
        Gson gson = new Gson();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                map2.put(entry.getKey(), (ADALTokenCacheItem) gson.fromJson(entry.getValue(), ADALTokenCacheItem.class));
            } catch (JsonSyntaxException unused) {
                Logger.warn(strM1170p, "Failed to deserialize ADAL cache entry. Skipping.");
            }
        }
        return map2;
    }

    public boolean getMigrationStatus() {
        return this.mSharedPrefs.getBoolean(KEY_MIGRATION_STATUS, false);
    }

    @SuppressLint({"ApplySharedPref"})
    public void setMigrationStatus(boolean z) {
        this.mSharedPrefs.edit().putBoolean(KEY_MIGRATION_STATUS, z).commit();
    }
}
