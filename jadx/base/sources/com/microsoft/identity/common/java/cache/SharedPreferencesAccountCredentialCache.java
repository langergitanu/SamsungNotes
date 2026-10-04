package com.microsoft.identity.common.java.cache;

import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
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
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SharedPreferencesAccountCredentialCache extends AbstractAccountCredentialCache {
    public static final String BROKER_FOCI_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES = "com.microsoft.identity.client.account_credential_cache.foci-1";
    public static final String DEFAULT_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES = "com.microsoft.identity.client.account_credential_cache";
    public static final String DESERIALIZATION_FAILED = "Deserialization failed. Skipping ";
    private static final String TAG = "SharedPreferencesAccountCredentialCache";
    private final ICacheKeyValueDelegate mCacheValueDelegate;
    public static final AccountRecord EMPTY_ACCOUNT = new AccountRecord();
    public static final AccessTokenRecord EMPTY_AT = new AccessTokenRecord();
    public static final RefreshTokenRecord EMPTY_RT = new RefreshTokenRecord();
    public static final IdTokenRecord EMPTY_ID = new IdTokenRecord();
    public static final String ACCOUNT_RECORD_DESERIALIZATION_FAILED = "Deserialization failed. Skipping AccountRecord";
    public static final String CREDENTIAL_DESERIALIZATION_FAILED = "Deserialization failed. Skipping Credential";

    public SharedPreferencesAccountCredentialCache(@NonNull ICacheKeyValueDelegate iCacheKeyValueDelegate, @NonNull INameValueStorage<String> iNameValueStorage) {
        super(iNameValueStorage);
        if (iCacheKeyValueDelegate == null) {
            throw new NullPointerException("accountCacheValueDelegate is marked non-null but is null");
        }
        if (iNameValueStorage == null) {
            throw new NullPointerException("sharedPreferencesFileManager is marked non-null but is null");
        }
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        this.mCacheValueDelegate = iCacheKeyValueDelegate;
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

    @NonNull
    private Map<String, AccountRecord> getAccountsWithKeys() {
        Logger.verbose(TAG, "Loading Accounts + keys...");
        Iterator<Map.Entry<String, String>> allFilteredByKey = this.mSharedPreferencesFileManager.getAllFilteredByKey(new Predicate<String>() { // from class: com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCache.1
            @Override // com.microsoft.identity.common.java.util.ported.Predicate
            public boolean test(String str) {
                return SharedPreferencesAccountCredentialCache.isAccount(str);
            }
        });
        HashMap map = new HashMap();
        if (allFilteredByKey != null) {
            while (allFilteredByKey.hasNext()) {
                Map.Entry<String, String> next = allFilteredByKey.next();
                String key = next.getKey();
                AccountRecord accountRecord = (AccountRecord) this.mCacheValueDelegate.fromCacheValue(next.getValue().toString(), AccountRecord.class);
                if (accountRecord == null) {
                    Logger.warn(TAG, ACCOUNT_RECORD_DESERIALIZATION_FAILED);
                } else {
                    map.put(key, accountRecord);
                }
            }
        }
        Logger.verbose(TAG, "Returning [" + map.size() + "] Accounts w/ keys...");
        return map;
    }

    public static String getBrokerUidSequesteredFilename(int i) {
        return AbstractC0000a.m11h(i, "com.microsoft.identity.client.account_credential_cache.uid-");
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

    @NonNull
    private Map<String, Credential> getCredentialsWithKeys() {
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getCredentialsWithKeys", "Loading Credentials with keys...");
        HashMap map = new HashMap();
        Iterator<Map.Entry<String, String>> allFilteredByKey = this.mSharedPreferencesFileManager.getAllFilteredByKey(new Predicate<String>() { // from class: com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCache.2
            @Override // com.microsoft.identity.common.java.util.ported.Predicate
            public boolean test(String str) {
                return SharedPreferencesAccountCredentialCache.isCredential(str);
            }
        });
        while (allFilteredByKey.hasNext()) {
            Map.Entry<String, String> next = allFilteredByKey.next();
            String key = next.getKey();
            Credential credential = (Credential) this.mCacheValueDelegate.fromCacheValue(next.getValue().toString(), credentialClassForType(key));
            if (credential == null) {
                Logger.warn(strM3199i, CREDENTIAL_DESERIALIZATION_FAILED);
            } else {
                map.put(key, credential);
            }
        }
        Logger.verbose(strM3199i, "Loaded [" + map.size() + "] Credentials...");
        return map;
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

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public void clearAll() {
        String str = TAG + ":clearAll";
        Logger.info(str, "Clearing all SharedPreferences entries...");
        this.mSharedPreferencesFileManager.clear();
        Logger.info(str, "SharedPreferences cleared.");
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public AccountRecord getAccount(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String str2 = TAG;
        Logger.verbose(str2, "Loading Account by key...");
        AccountRecord accountRecord = (AccountRecord) this.mCacheValueDelegate.fromCacheValue(this.mSharedPreferencesFileManager.get(str), AccountRecord.class);
        if (accountRecord == null) {
            Logger.warn(str2, ACCOUNT_RECORD_DESERIALIZATION_FAILED);
            return accountRecord;
        }
        if (!EMPTY_ACCOUNT.equals(accountRecord)) {
            return accountRecord;
        }
        Logger.warn(str2, "The returned Account was uninitialized. Removing...");
        this.mSharedPreferencesFileManager.remove(str);
        return null;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @NonNull
    public List<AccountRecord> getAccounts() {
        String strM3199i = AbstractC4539a.m3199i(new StringBuilder(), TAG, ":getAccounts", "Loading Accounts...(no arg)");
        ArrayList arrayList = new ArrayList(getAccountsWithKeys().values());
        Logger.info(strM3199i, "Found [" + arrayList.size() + "] Accounts...");
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
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        String str2 = TAG;
        Logger.verbose(str2, "getCredential()");
        Logger.verbosePII(str2, "Using cache key: [" + str + "]");
        CredentialType credentialTypeForCredentialCacheKey = getCredentialTypeForCredentialCacheKey(str);
        Class<? extends Credential> targetClassForCredentialType = credentialTypeForCredentialCacheKey != null ? getTargetClassForCredentialType(str, credentialTypeForCredentialCacheKey) : null;
        Credential credential = targetClassForCredentialType != null ? (Credential) this.mCacheValueDelegate.fromCacheValue(this.mSharedPreferencesFileManager.get(str), targetClassForCredentialType) : null;
        if (credential == null) {
            Logger.warn(str2, CREDENTIAL_DESERIALIZATION_FAILED);
            return credential;
        }
        if ((AccessTokenRecord.class != targetClassForCredentialType || !EMPTY_AT.equals(credential)) && ((RefreshTokenRecord.class != targetClassForCredentialType || !EMPTY_RT.equals(credential)) && (IdTokenRecord.class != targetClassForCredentialType || !EMPTY_ID.equals(credential)))) {
            return credential;
        }
        Logger.warn(str2, "The returned Credential was uninitialized. Removing...");
        this.mSharedPreferencesFileManager.remove(str);
        return null;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    @NonNull
    public List<Credential> getCredentials() {
        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getCredentials", "Loading Credentials...");
        return new ArrayList(getCredentialsWithKeys().values());
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
        if (this.mSharedPreferencesFileManager.keySet().contains(strGenerateCacheKey)) {
            this.mSharedPreferencesFileManager.remove(strGenerateCacheKey);
            z = true;
        } else {
            z = false;
        }
        Logger.info(str, "Account was removed? [" + z + "]");
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
        if (this.mSharedPreferencesFileManager.keySet().contains(strGenerateCacheKey)) {
            this.mSharedPreferencesFileManager.remove(strGenerateCacheKey);
            z = true;
        } else {
            z = false;
        }
        Logger.info(str, "Credential was removed? [" + z + "]");
        return z;
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public synchronized void saveAccount(@NonNull AccountRecord accountRecord) {
        try {
            if (accountRecord == null) {
                throw new NullPointerException("accountToSave is marked non-null but is null");
            }
            String str = TAG;
            Logger.verbose(str, "Saving Account...");
            Logger.verbose(str, "Account type: [" + accountRecord.getClass().getSimpleName() + "]");
            String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(accountRecord);
            Logger.verbosePII(str, "Generated cache key: [" + strGenerateCacheKey + "]");
            AccountRecord account = getAccount(strGenerateCacheKey);
            if (account != null) {
                accountRecord.mergeAdditionalFields(account);
            }
            this.mSharedPreferencesFileManager.put(strGenerateCacheKey, this.mCacheValueDelegate.generateCacheValue(accountRecord));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IAccountCredentialCache
    public synchronized void saveCredential(@NonNull Credential credential) {
        try {
            if (credential == null) {
                throw new NullPointerException("credentialToSave is marked non-null but is null");
            }
            String str = TAG;
            Logger.verbose(str, "Saving credential...");
            String strGenerateCacheKey = this.mCacheValueDelegate.generateCacheKey(credential);
            Logger.verbosePII(str, "Generated cache key: [" + strGenerateCacheKey + "]");
            Credential credential2 = getCredential(strGenerateCacheKey);
            if (credential2 != null) {
                credential.mergeAdditionalFields(credential2);
            }
            this.mSharedPreferencesFileManager.put(strGenerateCacheKey, this.mCacheValueDelegate.generateCacheValue(credential));
        } catch (Throwable th) {
            throw th;
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
