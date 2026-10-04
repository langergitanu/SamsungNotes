package com.microsoft.identity.common.java.cache;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.carousel.RunnableC4617a;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Predicate;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SharedPreferencesAccountCredentialCacheWithMemoryCache extends AbstractAccountCredentialCache {
    private static final String TAG = "SharedPreferencesAccountCredentialCacheWithMemoryCache";
    private final Object mCacheLock;
    private final ICacheKeyValueDelegate mCacheValueDelegate;
    private Map<String, AccountRecord> mCachedAccountRecordsWithKeys;
    private Map<String, Credential> mCachedCredentialsWithKeys;
    private boolean mLoaded;

    public SharedPreferencesAccountCredentialCacheWithMemoryCache(@NonNull ICacheKeyValueDelegate iCacheKeyValueDelegate, @NonNull INameValueStorage<String> iNameValueStorage) {
        super(iNameValueStorage);
        this.mCacheLock = new Object();
        this.mLoaded = false;
        this.mCachedAccountRecordsWithKeys = new HashMap();
        this.mCachedCredentialsWithKeys = new HashMap();
        if (iCacheKeyValueDelegate == null) {
            throw new NullPointerException("accountCacheValueDelegate is marked non-null but is null");
        }
        if (iNameValueStorage == null) {
            throw new NullPointerException("sharedPreferencesFileManager is marked non-null but is null");
        }
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        this.mCacheValueDelegate = iCacheKeyValueDelegate;
        new Thread(new RunnableC4617a(this, 5)).start();
    }

    @Nullable
    private Class<? extends Credential> credentialClassForType(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":credentialClassForType", "Resolving class for key/CredentialType...");
        Logger.verbosePII(strM3199i, "Supplied key: [" + str + "]");
        CredentialType credentialTypeForCredentialCacheKey = getCredentialTypeForCredentialCacheKey(str);
        if (credentialTypeForCredentialCacheKey == null) {
            return null;
        }
        Logger.verbose(strM3199i, "CredentialType matched: [" + credentialTypeForCredentialCacheKey + "]");
        return getTargetClassForCredentialType(str, credentialTypeForCredentialCacheKey);
    }

    @Nullable
    public static CredentialType getCredentialTypeForCredentialCacheKey(@NonNull String str) {
        CredentialType credentialType;
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getCredentialTypeForCredentialCacheKey", new StringBuilder());
        if (StringUtil.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Param [cacheKey] cannot be null.");
        }
        Logger.verbosePII(strM1170p, "Evaluating cache key for CredentialType [" + str + "]");
        HashSet hashSet = new HashSet();
        Iterator<String> it = CredentialType.valueSet().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toLowerCase(Locale.US));
        }
        Iterator it2 = hashSet.iterator();
        while (true) {
            if (!it2.hasNext()) {
                credentialType = null;
                break;
            }
            String str2 = (String) it2.next();
            if (str.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + str2 + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                Logger.verbose(strM1170p, "Cache key is a Credential type...");
                credentialType = CredentialType.AccessToken;
                if (credentialType.name().equalsIgnoreCase(str2)) {
                    break;
                }
                credentialType = CredentialType.AccessToken_With_AuthScheme;
                if (credentialType.name().equalsIgnoreCase(str2)) {
                    break;
                }
                credentialType = CredentialType.RefreshToken;
                if (credentialType.name().equalsIgnoreCase(str2)) {
                    break;
                }
                credentialType = CredentialType.IdToken;
                if (credentialType.name().equalsIgnoreCase(str2)) {
                    break;
                }
                credentialType = CredentialType.V1IdToken;
                if (credentialType.name().equalsIgnoreCase(str2)) {
                    break;
                }
                credentialType = CredentialType.PrimaryRefreshToken;
                if (credentialType.name().equalsIgnoreCase(str2)) {
                    break;
                }
                Logger.warn(strM1170p, "Unexpected credential type.");
            }
        }
        Logger.verbose(strM1170p, "Cache key was type: [" + credentialType + "]");
        return credentialType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAccount(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isAccount", new StringBuilder());
        Logger.verbosePII(strM1170p, "Evaluating cache key: [" + str + "]");
        boolean z = getCredentialTypeForCredentialCacheKey(str) == null;
        Logger.verbose(strM1170p, "isAccount? [" + z + "]");
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isCredential(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":isCredential", new StringBuilder());
        Logger.verbosePII(strM1170p, "Evaluating cache key: [" + str + "]");
        boolean z = getCredentialTypeForCredentialCacheKey(str) != null;
        Logger.verbose(strM1170p, "isCredential? [" + z + "]");
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public void lambda$new$0() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":load", new StringBuilder());
        synchronized (this.mCacheLock) {
            try {
                this.mCachedAccountRecordsWithKeys = loadAccountsWithKeys();
                Logger.info(strM1170p, "Loaded " + this.mCachedAccountRecordsWithKeys.size() + " AccountRecords");
                this.mCachedCredentialsWithKeys = loadCredentialsWithKeys();
                Logger.info(strM1170p, "Loaded " + this.mCachedCredentialsWithKeys.size() + " Credentials");
                this.mLoaded = true;
            } catch (Throwable th) {
                try {
                    Logger.error(strM1170p, "Failed to load initial accounts or credentials from SharedPreferences", th);
                    this.mLoaded = true;
                } catch (Throwable th2) {
                    this.mLoaded = true;
                    this.mCacheLock.notifyAll();
                    throw th2;
                }
            }
            this.mCacheLock.notifyAll();
        }
    }

    @NonNull
    private Map<String, AccountRecord> loadAccountsWithKeys() {
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":loadAccountsWithKeys", "Loading Accounts + keys...");
        Iterator<Map.Entry<String, String>> allFilteredByKey = this.mSharedPreferencesFileManager.getAllFilteredByKey(new Predicate<String>() { // from class: com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCacheWithMemoryCache.1
            @Override // com.microsoft.identity.common.java.util.ported.Predicate
            public boolean test(String str) {
                return SharedPreferencesAccountCredentialCacheWithMemoryCache.isAccount(str);
            }
        });
        HashMap map = new HashMap();
        if (allFilteredByKey != null) {
            while (allFilteredByKey.hasNext()) {
                Map.Entry<String, String> next = allFilteredByKey.next();
                String key = next.getKey();
                AccountRecord accountRecord = (AccountRecord) this.mCacheValueDelegate.fromCacheValue(next.getValue().toString(), AccountRecord.class);
                if (accountRecord == null) {
                    Logger.warn(strM3199i, SharedPreferencesAccountCredentialCache.ACCOUNT_RECORD_DESERIALIZATION_FAILED);
                } else if (SharedPreferencesAccountCredentialCache.EMPTY_ACCOUNT.equals(accountRecord)) {
                    Logger.warn(strM3199i, "The returned Account was uninitialized. Removing...");
                    this.mSharedPreferencesFileManager.remove(key);
                } else {
                    map.put(key, accountRecord);
                }
            }
        }
        Logger.verbose(strM3199i, "Returning [" + map.size() + "] Accounts w/ keys...");
        return map;
    }

    @NonNull
    private Map<String, Credential> loadCredentialsWithKeys() {
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getCredentialsWithKeys", "Loading Credentials with keys...");
        HashMap map = new HashMap();
        Iterator<Map.Entry<String, String>> allFilteredByKey = this.mSharedPreferencesFileManager.getAllFilteredByKey(new Predicate<String>() { // from class: com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCacheWithMemoryCache.2
            @Override // com.microsoft.identity.common.java.util.ported.Predicate
            public boolean test(String str) {
                return SharedPreferencesAccountCredentialCacheWithMemoryCache.isCredential(str);
            }
        });
        while (allFilteredByKey.hasNext()) {
            Map.Entry<String, String> next = allFilteredByKey.next();
            String key = next.getKey();
            Class<? extends Credential> clsCredentialClassForType = credentialClassForType(key);
            Credential credential = (Credential) this.mCacheValueDelegate.fromCacheValue(next.getValue().toString(), clsCredentialClassForType);
            if (credential == null) {
                Logger.warn(strM3199i, SharedPreferencesAccountCredentialCache.CREDENTIAL_DESERIALIZATION_FAILED);
            } else if ((AccessTokenRecord.class == clsCredentialClassForType && SharedPreferencesAccountCredentialCache.EMPTY_AT.equals(credential)) || ((RefreshTokenRecord.class == clsCredentialClassForType && SharedPreferencesAccountCredentialCache.EMPTY_RT.equals(credential)) || (IdTokenRecord.class == clsCredentialClassForType && SharedPreferencesAccountCredentialCache.EMPTY_ID.equals(credential)))) {
                Logger.warn(strM3199i, "The returned Credential was uninitialized. Removing...");
                this.mSharedPreferencesFileManager.remove(key);
            } else {
                map.put(key, credential);
            }
        }
        Logger.verbose(strM3199i, "Loaded [" + map.size() + "] Credentials...");
        return map;
    }

    private void waitForInitialLoad() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":waitForInitialLoad", new StringBuilder());
        while (!this.mLoaded) {
            try {
                this.mCacheLock.wait();
            } catch (InterruptedException e) {
                Logger.error(strM1170p, "Caught InterruptedException while waiting", e);
            }
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public void clearAll() {
        String str = TAG + ":clearAll";
        Logger.info(str, "Clearing all SharedPreferences entries...");
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            this.mSharedPreferencesFileManager.clear();
            this.mCachedCredentialsWithKeys.clear();
            this.mCachedAccountRecordsWithKeys.clear();
        }
        Logger.info(str, "SharedPreferences cleared.");
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public AccountRecord getAccount(@NonNull String str) {
        AccountRecord accountRecord;
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAccount", new StringBuilder());
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            accountRecord = this.mCachedAccountRecordsWithKeys.get(str);
        }
        if (accountRecord != null) {
            try {
                return (AccountRecord) accountRecord.m22118clone();
            } catch (CloneNotSupportedException e) {
                Logger.error(strM1170p, "Failed to clone AccountRecord", e);
            }
        }
        return accountRecord;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @NonNull
    public List<AccountRecord> getAccounts() {
        ArrayList arrayList;
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getAccounts", "Loading Accounts...(no arg)");
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            arrayList = new ArrayList();
            Iterator<AccountRecord> it = this.mCachedAccountRecordsWithKeys.values().iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((AccountRecord) it.next().m22118clone());
                } catch (CloneNotSupportedException e) {
                    Logger.error(strM3199i, "Failed to clone AccountRecord", e);
                }
            }
            Logger.info(strM3199i, "Found [" + arrayList.size() + "] Accounts...");
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @NonNull
    public List<AccountRecord> getAccountsFilteredBy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getAccountsFilteredBy", "Loading Accounts...");
        List<AccountRecord> accountsFilteredByInternal = getAccountsFilteredByInternal(str, str2, str3, getAccounts());
        Logger.verbose(strM3199i, "Found [" + accountsFilteredByInternal.size() + "] matching Accounts...");
        return accountsFilteredByInternal;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @Nullable
    public Credential getCredential(@NonNull String str) {
        Credential credential;
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getCredential", new StringBuilder());
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            credential = this.mCachedCredentialsWithKeys.get(str);
        }
        if (credential != null) {
            try {
                return (Credential) credential.m22118clone();
            } catch (CloneNotSupportedException e) {
                Logger.error(strM1170p, "Failed to clone Credential", e);
            }
        }
        return credential;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @NonNull
    public List<Credential> getCredentials() {
        ArrayList arrayList;
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getCredentials", "Loading Credentials...");
        synchronized (this.mCacheLock) {
            waitForInitialLoad();
            arrayList = new ArrayList();
            Iterator<Credential> it = this.mCachedCredentialsWithKeys.values().iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((Credential) it.next().m22118clone());
                } catch (CloneNotSupportedException e) {
                    Logger.error(strM3199i, "Failed to clone Credential", e);
                }
            }
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @NonNull
    public List<Credential> getCredentialsFilteredBy(@Nullable String str, @Nullable String str2, @Nullable CredentialType credentialType, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getCredentialsFilteredBy", "getCredentialsFilteredBy()");
        List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(getCredentials(), str, str2, credentialType, str3, str4, str5, str6, str7, str8, null, null);
        Logger.verbose(strM3199i, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
        return credentialsFilteredByInternal;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public boolean removeAccount(@NonNull AccountRecord accountRecord) {
        boolean z;
        if (accountRecord == null) {
            throw new NullPointerException("accountToRemove is marked non-null but is null");
        }
        String str = TAG + ":removeAccount";
        Logger.info(str, "Removing Account...");
        String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(accountRecord);
        synchronized (this.mCacheLock) {
            try {
                waitForInitialLoad();
                if (this.mSharedPreferencesFileManager.keySet().contains(strGenerateCacheKey)) {
                    this.mSharedPreferencesFileManager.remove(strGenerateCacheKey);
                    z = true;
                } else {
                    z = false;
                }
                Logger.info(str, "Account was removed? [" + z + "]");
                this.mCachedAccountRecordsWithKeys.remove(strGenerateCacheKey);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public boolean removeCredential(@NonNull Credential credential) {
        boolean z;
        if (credential == null) {
            throw new NullPointerException("credentialToRemove is marked non-null but is null");
        }
        String str = TAG + ":removeCredential";
        Logger.info(str, "Removing Credential...");
        String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(credential);
        synchronized (this.mCacheLock) {
            try {
                waitForInitialLoad();
                if (this.mSharedPreferencesFileManager.keySet().contains(strGenerateCacheKey)) {
                    this.mSharedPreferencesFileManager.remove(strGenerateCacheKey);
                    z = true;
                } else {
                    z = false;
                }
                Logger.info(str, "Credential was removed? [" + z + "]");
                this.mCachedCredentialsWithKeys.remove(strGenerateCacheKey);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public void saveAccount(@NonNull AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountInput is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":saveAccount", new StringBuilder());
        try {
            AccountRecord accountRecord2 = (AccountRecord) accountRecord.m22118clone();
            Logger.verbose(strM1170p, "Saving Account...");
            Logger.verbose(strM1170p, "Account type: [" + accountRecord2.getClass().getSimpleName() + "]");
            String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(accountRecord2);
            Logger.verbosePII(strM1170p, "Generated cache key: [" + strGenerateCacheKey + "]");
            synchronized (this.mCacheLock) {
                try {
                    waitForInitialLoad();
                    AccountRecord account = getAccount(strGenerateCacheKey);
                    if (account != null) {
                        accountRecord2.mergeAdditionalFields(account);
                    }
                    this.mSharedPreferencesFileManager.put(strGenerateCacheKey, this.mCacheValueDelegate.generateCacheValue(accountRecord2));
                    this.mCachedAccountRecordsWithKeys.put(strGenerateCacheKey, accountRecord2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (CloneNotSupportedException e) {
            Logger.error(strM1170p, "Failed to clone AccountRecord", e);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public void saveCredential(@NonNull Credential credential) {
        if (credential == null) {
            throw new NullPointerException("credentialInput is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":saveCredential", new StringBuilder());
        try {
            Credential credential2 = (Credential) credential.m22118clone();
            Logger.verbose(strM1170p, "Saving credential...");
            String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(credential2);
            Logger.verbosePII(strM1170p, "Generated cache key: [" + strGenerateCacheKey + "]");
            synchronized (this.mCacheLock) {
                try {
                    waitForInitialLoad();
                    Credential credential3 = getCredential(strGenerateCacheKey);
                    if (credential3 != null) {
                        credential2.mergeAdditionalFields(credential3);
                    }
                    this.mSharedPreferencesFileManager.put(strGenerateCacheKey, this.mCacheValueDelegate.generateCacheValue(credential2));
                    this.mCachedCredentialsWithKeys.put(strGenerateCacheKey, credential2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (CloneNotSupportedException e) {
            Logger.error(strM1170p, "Failed to clone Credential", e);
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(@Nullable String str, @Nullable String str2, @Nullable CredentialType credentialType, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @NonNull List<Credential> list) {
        if (list != null) {
            String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getCredentialsFilteredBy", "getCredentialsFilteredBy() -- with input list");
            List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(list, str, str2, credentialType, str3, str4, str5, str6, str7, str8, null, null);
            Logger.verbose(strM3199i, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
            return credentialsFilteredByInternal;
        }
        throw new NullPointerException("inputCredentials is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @NonNull
    public List<Credential> getCredentialsFilteredBy(@Nullable String str, @Nullable String str2, @Nullable CredentialType credentialType, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getCredentialsFilteredBy", "getCredentialsFilteredBy()");
        List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(getCredentials(), str, str2, credentialType, str3, str4, str5, str6, str7, str8, str9, null);
        Logger.verbose(strM3199i, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
        return credentialsFilteredByInternal;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @NonNull
    public List<Credential> getCredentialsFilteredBy(@Nullable String str, @Nullable String str2, @Nullable CredentialType credentialType, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @NonNull List<Credential> list) {
        if (list != null) {
            String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getCredentialsFilteredBy", "getCredentialsFilteredBy()");
            List<Credential> credentialsFilteredByInternal = getCredentialsFilteredByInternal(list, str, str2, credentialType, str3, str4, str5, str6, str7, str8, str9, null);
            Logger.verbose(strM3199i, "Found [" + credentialsFilteredByInternal.size() + "] matching Credentials...");
            return credentialsFilteredByInternal;
        }
        throw new NullPointerException("inputCredentials is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(@Nullable String str, @Nullable String str2, @NonNull Set<CredentialType> set, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9) {
        if (set != null) {
            List<Credential> credentials = getCredentials();
            ArrayList arrayList = new ArrayList();
            Iterator<CredentialType> it = set.iterator();
            while (it.hasNext()) {
                arrayList.addAll(getCredentialsFilteredByInternal(credentials, str, str2, it.next(), str3, str4, str5, str6, str7, str8, str9, null));
            }
            return arrayList;
        }
        throw new NullPointerException("credentialTypes is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public List<Credential> getCredentialsFilteredBy(@NonNull List<Credential> list, @Nullable String str, @Nullable String str2, @Nullable CredentialType credentialType, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getCredentialsFilteredByInternal(list, str, str2, credentialType, str3, str4, str5, str6, str7, str8, str9, str10));
            return arrayList;
        }
        throw new NullPointerException("inputCredentials is marked non-null but is null");
    }
}
