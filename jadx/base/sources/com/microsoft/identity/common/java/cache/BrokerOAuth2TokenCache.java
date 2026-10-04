package com.microsoft.identity.common.java.cache;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.cache.CacheRecord;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lombok.NonNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@SuppressFBWarnings({SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE, SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
public class BrokerOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends MicrosoftTokenResponse, GenericAccount extends MicrosoftAccount, GenericRefreshToken extends MicrosoftRefreshToken> extends OAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse> {
    private static final String TAG = "BrokerOAuth2TokenCache";
    private static final String UNCHECKED = "unchecked";
    private final IBrokerApplicationMetadataCache mApplicationMetadataCache;
    private ProcessUidCacheFactory mDelegate;
    private final MicrosoftFamilyOAuth2TokenCache mFociCache;
    private final int mUid;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ProcessUidCacheFactory {
        MsalOAuth2TokenCache getTokenCache(IPlatformComponents iPlatformComponents, int i);
    }

    public BrokerOAuth2TokenCache(@NonNull IPlatformComponents iPlatformComponents, int i, @NonNull IBrokerApplicationMetadataCache iBrokerApplicationMetadataCache) {
        super(iPlatformComponents);
        this.mDelegate = null;
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (iBrokerApplicationMetadataCache == null) {
            throw new NullPointerException("applicationMetadataCache is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.verbose(AbstractC0622a.m1170p(str, "ctor", sb), "Init::" + str);
        this.mUid = i;
        this.mFociCache = initializeFociCache(getComponents());
        this.mApplicationMetadataCache = iBrokerApplicationMetadataCache;
    }

    private static <T extends MsalOAuth2TokenCache> T getTokenCache(@NonNull IPlatformComponents iPlatformComponents, @NonNull INameValueStorage<String> iNameValueStorage, boolean z) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (iNameValueStorage == null) {
            throw new NullPointerException("spfm is marked non-null but is null");
        }
        SharedPreferencesAccountCredentialCache sharedPreferencesAccountCredentialCache = new SharedPreferencesAccountCredentialCache(new CacheKeyValueDelegate(), iNameValueStorage);
        MicrosoftStsAccountCredentialAdapter microsoftStsAccountCredentialAdapter = new MicrosoftStsAccountCredentialAdapter();
        return z ? new MicrosoftFamilyOAuth2TokenCache(iPlatformComponents, sharedPreferencesAccountCredentialCache, microsoftStsAccountCredentialAdapter) : (T) new MsalOAuth2TokenCache(iPlatformComponents, sharedPreferencesAccountCredentialCache, microsoftStsAccountCredentialAdapter);
    }

    @Nullable
    private MsalOAuth2TokenCache getTokenCacheForClient(@Nullable BrokerApplicationMetadata brokerApplicationMetadata) {
        MsalOAuth2TokenCache msalOAuth2TokenCacheInitializeProcessUidCache;
        if (brokerApplicationMetadata != null) {
            boolean z = brokerApplicationMetadata.getFoci() != null;
            Logger.verbose(AbstractC0622a.m1170p(TAG, ":getTokenCacheForClient(bam)", new StringBuilder()), "is Foci? [" + z + "]");
            msalOAuth2TokenCacheInitializeProcessUidCache = z ? this.mFociCache : initializeProcessUidCache(getComponents(), brokerApplicationMetadata.getUid());
        } else {
            msalOAuth2TokenCacheInitializeProcessUidCache = null;
        }
        if (msalOAuth2TokenCacheInitializeProcessUidCache == null) {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getTokenCacheForClient(bam)", "Could not locate a cache for this app.");
        }
        return msalOAuth2TokenCacheInitializeProcessUidCache;
    }

    private List<OAuth2TokenCache> getTokenCachesForClientId(@NonNull String str) {
        MsalOAuth2TokenCache msalOAuth2TokenCacheInitializeProcessUidCache;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        List<BrokerApplicationMetadata> all = this.mApplicationMetadataCache.getAll();
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        for (BrokerApplicationMetadata brokerApplicationMetadata : all) {
            if (str.equals(brokerApplicationMetadata.getClientId())) {
                if (brokerApplicationMetadata.getFoci() != null && !z) {
                    arrayList.add(this.mFociCache);
                    z = true;
                } else if (!z2 && (msalOAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), this.mUid)) != null) {
                    arrayList.add(msalOAuth2TokenCacheInitializeProcessUidCache);
                    z2 = true;
                }
            }
        }
        return arrayList;
    }

    private static MicrosoftFamilyOAuth2TokenCache initializeFociCache(@NonNull IPlatformComponents iPlatformComponents) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        Logger.verbose(TAG + ":initializeFociCache", "Initializing foci cache");
        return (MicrosoftFamilyOAuth2TokenCache) getTokenCache(iPlatformComponents, iPlatformComponents.getStorageSupplier().getEncryptedNameValueStore(SharedPreferencesAccountCredentialCache.BROKER_FOCI_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES, String.class), true);
    }

    private MsalOAuth2TokenCache initializeProcessUidCache(@NonNull IPlatformComponents iPlatformComponents, int i) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        AbstractC4539a.m3216z(sb, str, ":initializeProcessUidCache", "Initializing uid cache.");
        if (this.mDelegate == null) {
            return getTokenCache(iPlatformComponents, iPlatformComponents.getStorageSupplier().getEncryptedNameValueStore(SharedPreferencesAccountCredentialCache.getBrokerUidSequesteredFilename(i), String.class), false);
        }
        Logger.warn(str + ":initializeProcessUidCache", "Using swapped delegate cache.");
        return this.mDelegate.getTokenCache(iPlatformComponents, i);
    }

    private List<ICacheRecord> loadAggregatedAccountData(@NonNull AbstractAuthenticationScheme abstractAuthenticationScheme, @NonNull ICacheRecord iCacheRecord) {
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        if (iCacheRecord == null) {
            throw new NullPointerException("cacheRecord is marked non-null but is null");
        }
        String clientId = iCacheRecord.getAccessToken().getClientId();
        String target = iCacheRecord.getAccessToken().getTarget();
        String environment = iCacheRecord.getAccessToken().getEnvironment();
        String applicationIdentifier = iCacheRecord.getAccessToken().getApplicationIdentifier();
        String mamEnrollmentIdentifier = iCacheRecord.getAccessToken().getMamEnrollmentIdentifier();
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(clientId, environment, this.mUid);
        if (tokenCacheForClient != null) {
            return tokenCacheForClient.loadWithAggregatedAccountData(clientId, applicationIdentifier, mamEnrollmentIdentifier, target, iCacheRecord.getAccount(), abstractAuthenticationScheme);
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":loadAggregatedAccountData", new StringBuilder());
        StringBuilder sbM16m = AbstractC0000a.m16m("Cache not found for clientid: ", clientId, "environment:", environment, "processUid: ");
        sbM16m.append(this.mUid);
        Logger.warn(strM1170p, sbM16m.toString());
        return null;
    }

    private AccountDeletionRecord removeAccountInternal(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z) {
        List<BrokerApplicationMetadata> all = this.mApplicationMetadataCache.getAll();
        ArrayList arrayList = new ArrayList();
        for (BrokerApplicationMetadata brokerApplicationMetadata : all) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(brokerApplicationMetadata.getClientId(), brokerApplicationMetadata.getEnvironment(), z ? brokerApplicationMetadata.getUid() : this.mUid);
            if (tokenCacheForClient != null) {
                arrayList.add(tokenCacheForClient.removeAccount(str, str2, str3, str4));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll((AccountDeletionRecord) it.next());
        }
        Logger.info(AbstractC0622a.m1170p(TAG, ":removeAccountInternal", new StringBuilder()), "Deleted [" + arrayList2.size() + "] AccountRecords.");
        return new AccountDeletionRecord(arrayList2);
    }

    private void targetCacheSetSingleSignOnState(@NonNull GenericAccount genericaccount, @NonNull GenericRefreshToken genericrefreshtoken, MsalOAuth2TokenCache msalOAuth2TokenCache) throws ClientException {
        if (genericaccount == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (genericrefreshtoken == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        msalOAuth2TokenCache.setSingleSignOnState(genericaccount, genericrefreshtoken);
    }

    private void updateApplicationMetadataCache(@NonNull String str, @NonNull String str2, @Nullable String str3, int i) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        BrokerApplicationMetadata brokerApplicationMetadata = new BrokerApplicationMetadata();
        brokerApplicationMetadata.setClientId(str);
        brokerApplicationMetadata.setEnvironment(str2);
        brokerApplicationMetadata.setFoci(str3);
        brokerApplicationMetadata.setUid(i);
        StringBuilder sb = new StringBuilder();
        String str4 = TAG;
        Logger.verbose(AbstractC0622a.m1170p(str4, ":updateApplicationMetadataCache", sb), "Adding cache entry for clientId: [" + str + "]");
        boolean zInsert = this.mApplicationMetadataCache.insert(brokerApplicationMetadata);
        Logger.info(AbstractC0541b.m756B(str4, ":updateApplicationMetadataCache"), "Cache updated successfully? [" + zInsert + "]");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public void clearAll() {
        for (BrokerApplicationMetadata brokerApplicationMetadata : this.mApplicationMetadataCache.getAll()) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(brokerApplicationMetadata.getClientId(), brokerApplicationMetadata.getEnvironment(), brokerApplicationMetadata.getUid());
            if (tokenCacheForClient != null) {
                tokenCacheForClient.clearAll();
            }
        }
        this.mFociCache.clearAll();
        this.mApplicationMetadataCache.clear();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    @Nullable
    public AccountRecord getAccount(@Nullable String str, @NonNull String str2, @NonNull String str3, @Nullable String str4) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        if (str != null) {
            OAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            if (tokenCacheForClient == null) {
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getAccount", "Target cache was null. Using FOCI cache.");
                tokenCacheForClient = this.mFociCache;
            }
            return tokenCacheForClient.getAccount(str, str2, str3, str4);
        }
        Iterator<OAuth2TokenCache> it = getTokenCachesForClientId(str2).iterator();
        AccountRecord account = null;
        while (account == null && it.hasNext()) {
            account = it.next().getAccount(null, str2, str3, str4);
        }
        return account;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountRecord getAccountByHomeAccountId(@Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str4 = TAG;
        AbstractC4539a.m3216z(sb, str4, "getAccountByHomeAccountId", "Loading account by home account id.");
        if (str == null) {
            Iterator<OAuth2TokenCache> it = getTokenCachesForClientId(str2).iterator();
            AccountRecord accountByHomeAccountId = null;
            while (accountByHomeAccountId == null && it.hasNext()) {
                accountByHomeAccountId = it.next().getAccountByHomeAccountId(null, str2, str3);
            }
            return accountByHomeAccountId;
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
        String strM756B = AbstractC0541b.m756B(str4, "getAccountByHomeAccountId");
        StringBuilder sb2 = new StringBuilder("Loading from FOCI cache? [");
        sb2.append(tokenCacheForClient == null);
        sb2.append("]");
        Logger.info(strM756B, sb2.toString());
        return tokenCacheForClient != null ? tokenCacheForClient.getAccountByHomeAccountId(str, str2, str3) : this.mFociCache.getAccountByHomeAccountId(str, str2, str3);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    @Nullable
    public AccountRecord getAccountByLocalAccountId(@Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("localAccountId is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str4 = TAG;
        AbstractC4539a.m3216z(sb, str4, ":getAccountByLocalAccountId", "Loading account by local account id.");
        if (str == null) {
            Iterator<OAuth2TokenCache> it = getTokenCachesForClientId(str2).iterator();
            AccountRecord accountByLocalAccountId = null;
            while (accountByLocalAccountId == null && it.hasNext()) {
                accountByLocalAccountId = it.next().getAccountByLocalAccountId(null, str2, str3);
            }
            return accountByLocalAccountId;
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
        String strM756B = AbstractC0541b.m756B(str4, ":getAccountByLocalAccountId");
        StringBuilder sb2 = new StringBuilder("Loading from FOCI cache? [");
        sb2.append(tokenCacheForClient == null);
        sb2.append("]");
        Logger.info(strM756B, sb2.toString());
        return tokenCacheForClient != null ? tokenCacheForClient.getAccountByLocalAccountId(str, str2, str3) : this.mFociCache.getAccountByLocalAccountId(str, str2, str3);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    @Nullable
    public ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(@Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("localAccountId is marked non-null but is null");
        }
        if (str == null) {
            Iterator<OAuth2TokenCache> it = getTokenCachesForClientId(str2).iterator();
            ICacheRecord accountWithAggregatedAccountDataByLocalAccountId = null;
            while (accountWithAggregatedAccountDataByLocalAccountId == null && it.hasNext()) {
                accountWithAggregatedAccountDataByLocalAccountId = it.next().getAccountWithAggregatedAccountDataByLocalAccountId(null, str2, str3);
            }
            return accountWithAggregatedAccountDataByLocalAccountId;
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAccountWithAggregatedAccountDataByLocalAccountId", new StringBuilder());
        StringBuilder sb = new StringBuilder("Loading from FOCI cache? [");
        sb.append(tokenCacheForClient == null);
        sb.append("]");
        Logger.info(strM1170p, sb.toString());
        return tokenCacheForClient != null ? tokenCacheForClient.getAccountWithAggregatedAccountDataByLocalAccountId(str, str2, str3) : this.mFociCache.getAccountWithAggregatedAccountDataByLocalAccountId(str, str2, str3);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAccounts(@Nullable String str, @NonNull String str2) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            if (tokenCacheForClient != null) {
                arrayList.addAll(tokenCacheForClient.getAccounts(str, str2));
                return arrayList;
            }
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getAccounts (2 param)", "No caches to inspect.");
            return arrayList;
        }
        for (OAuth2TokenCache oAuth2TokenCache : getTokenCachesForClientId(str2)) {
            if (oAuth2TokenCache != null) {
                arrayList.addAll(oAuth2TokenCache.getAccounts(null, str2));
            }
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getAccounts (2 param)", new StringBuilder()), "Found [" + arrayList.size() + "] accounts.");
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(@Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        if (str != null) {
            OAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            if (tokenCacheForClient == null) {
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getAccountsWithAggregatedAccountData", "Falling back to FoCI cache...");
                tokenCacheForClient = this.mFociCache;
            }
            return tokenCacheForClient.getAccountsWithAggregatedAccountData(str, str2, str3);
        }
        List<OAuth2TokenCache> tokenCachesForClientId = getTokenCachesForClientId(str2);
        ArrayList arrayList = new ArrayList();
        Iterator<OAuth2TokenCache> it = tokenCachesForClientId.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getAccountsWithAggregatedAccountData(null, str2, str3));
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public Set<String> getAllClientIds() {
        return this.mApplicationMetadataCache.getAllClientIds();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAllTenantAccountsForAccountByClientId(@NonNull String str, @NonNull AccountRecord accountRecord) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str, accountRecord.getEnvironment(), this.mUid);
        if (tokenCacheForClient != null) {
            return tokenCacheForClient.getAllTenantAccountsForAccountByClientId(str, accountRecord);
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAllTenantAccountsForAccountByClientId", new StringBuilder());
        StringBuilder sbM15l = AbstractC0000a.m15l("Cache not found for clientid: ", str, "environment:");
        sbM15l.append(accountRecord.getEnvironment());
        sbM15l.append("processUid: ");
        sbM15l.append(this.mUid);
        Logger.warn(strM1170p, sbM15l.toString());
        return Collections.EMPTY_LIST;
    }

    public List<ICacheRecord> getFociCacheRecords() {
        ArrayList arrayList = new ArrayList();
        for (BrokerApplicationMetadata brokerApplicationMetadata : this.mApplicationMetadataCache.getAllFociApplicationMetadata()) {
            for (AccountRecord accountRecord : this.mFociCache.getAccounts(brokerApplicationMetadata.getEnvironment(), brokerApplicationMetadata.getClientId())) {
                String homeAccountId = accountRecord.getHomeAccountId();
                String environment = accountRecord.getEnvironment();
                String clientId = brokerApplicationMetadata.getClientId();
                String realm = accountRecord.getRealm();
                List<Credential> credentialsFilteredBy = this.mFociCache.getAccountCredentialCache().getCredentialsFilteredBy(homeAccountId, environment, CredentialType.RefreshToken, clientId, null, null, null, null, null);
                List<Credential> credentialsFilteredBy2 = this.mFociCache.getAccountCredentialCache().getCredentialsFilteredBy(homeAccountId, environment, CredentialType.V1IdToken, clientId, null, null, realm, null, null);
                List<Credential> credentialsFilteredBy3 = this.mFociCache.getAccountCredentialCache().getCredentialsFilteredBy(homeAccountId, environment, CredentialType.IdToken, clientId, null, null, realm, null, null);
                if (!credentialsFilteredBy.isEmpty()) {
                    CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
                    cacheRecordBuilderBuilder.account(accountRecord);
                    cacheRecordBuilderBuilder.refreshToken((RefreshTokenRecord) credentialsFilteredBy.get(0));
                    if (credentialsFilteredBy2.isEmpty()) {
                        AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getFociCacheRecords", "No V1IdTokens exist for this account.");
                    } else {
                        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getFociCacheRecords", new StringBuilder()), "Found [" + credentialsFilteredBy2.size() + "] V1IdTokens");
                        cacheRecordBuilderBuilder.v1IdToken((IdTokenRecord) credentialsFilteredBy2.get(0));
                    }
                    if (credentialsFilteredBy3.isEmpty()) {
                        AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getFociCacheRecords", "No IdTokens exist for this account.");
                    } else {
                        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getFociCacheRecords", new StringBuilder()), "Found [" + credentialsFilteredBy3.size() + "] IdTokens");
                        cacheRecordBuilderBuilder.idToken((IdTokenRecord) credentialsFilteredBy3.get(0));
                    }
                    arrayList.add(cacheRecordBuilderBuilder.build());
                }
            }
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<IdTokenRecord> getIdTokensForAccountRecord(@NonNull String str, @NonNull AccountRecord accountRecord) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str, accountRecord.getEnvironment(), this.mUid);
        if (tokenCacheForClient != null) {
            return tokenCacheForClient.getIdTokensForAccountRecord(str, accountRecord);
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getIdTokensForAccountRecord", new StringBuilder());
        StringBuilder sbM15l = AbstractC0000a.m15l("Cache not found for clientid: ", str, "environment:");
        sbM15l.append(accountRecord.getEnvironment());
        sbM15l.append("processUid: ");
        sbM15l.append(this.mUid);
        Logger.warn(strM1170p, sbM15l.toString());
        return Collections.EMPTY_LIST;
    }

    public boolean isClientIdKnownToCache(@NonNull String str) {
        if (str != null) {
            return getAllClientIds().contains(str);
        }
        throw new NullPointerException("clientId is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord load(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @NonNull AccountRecord accountRecord, @NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) {
        boolean z;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("applicationIdentifier is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str5 = TAG;
        AbstractC4539a.m3216z(sb, str5, ":load", "Performing lookup in app-specific cache.");
        BrokerApplicationMetadata metadata = this.mApplicationMetadataCache.getMetadata(str, accountRecord.getEnvironment(), this.mUid);
        if (metadata != null) {
            z = metadata.getFoci() != null;
            Logger.info(AbstractC0541b.m756B(str5, ":load"), "App is known foci? " + z);
        } else {
            z = false;
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str, accountRecord.getEnvironment(), this.mUid);
        boolean z2 = tokenCacheForClient == null || z;
        Logger.info(AbstractC0541b.m756B(str5, ":load"), "Loading from FOCI cache? [" + z2 + "]");
        ICacheRecord iCacheRecordLoadByFamilyId = z2 ? this.mFociCache.loadByFamilyId(str, str4, accountRecord, abstractAuthenticationScheme) : tokenCacheForClient.load(str, str2, str3, str4, accountRecord, abstractAuthenticationScheme);
        boolean z3 = iCacheRecordLoadByFamilyId.getRefreshToken() != null;
        Logger.verbose(AbstractC0541b.m756B(str5, ":load"), "Result found? [" + z3 + "]");
        return iCacheRecordLoadByFamilyId;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> loadWithAggregatedAccountData(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @NonNull AccountRecord accountRecord, @NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) {
        boolean z;
        List<ICacheRecord> listLoadByFamilyIdWithAggregatedAccountData;
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("applicationIdentifier is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        synchronized (this) {
            try {
                BrokerApplicationMetadata metadata = this.mApplicationMetadataCache.getMetadata(str, accountRecord.getEnvironment(), this.mUid);
                boolean z2 = true;
                if (metadata != null) {
                    z = metadata.getFoci() != null;
                    Logger.info(TAG + ":loadWithAggregatedAccountData", "App is known foci? " + z);
                } else {
                    z = false;
                }
                MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(metadata);
                boolean z3 = tokenCacheForClient == null;
                StringBuilder sb = new StringBuilder();
                String str5 = TAG;
                sb.append(str5);
                sb.append(":loadWithAggregatedAccountData");
                String string = sb.toString();
                StringBuilder sb2 = new StringBuilder("Loading from FOCI cache? [");
                sb2.append(z || z3);
                sb2.append("]");
                Logger.info(string, sb2.toString());
                if (z3) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.mFociCache.loadByFamilyId(str, str4, accountRecord, abstractAuthenticationScheme));
                    listLoadByFamilyIdWithAggregatedAccountData = arrayList;
                } else {
                    listLoadByFamilyIdWithAggregatedAccountData = z ? this.mFociCache.loadByFamilyIdWithAggregatedAccountData(str, str4, accountRecord, abstractAuthenticationScheme) : tokenCacheForClient.loadWithAggregatedAccountData(str, str2, str3, str4, accountRecord, abstractAuthenticationScheme);
                }
                if (listLoadByFamilyIdWithAggregatedAccountData.isEmpty() || listLoadByFamilyIdWithAggregatedAccountData.get(0).getRefreshToken() == null) {
                    z2 = false;
                }
                Logger.verbose(str5 + ":loadWithAggregatedAccountData", "Result found? [" + z2 + "]");
            } catch (Throwable th) {
                throw th;
            }
        }
        return listLoadByFamilyIdWithAggregatedAccountData;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return removeAccountInternal(str, str2, str3, str4, false);
    }

    @SuppressFBWarnings(justification = "Lombok inserts null checks that may be redundant", value = {"RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE"})
    public AccountDeletionRecord removeAccountFromDevice(@NonNull AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        Set<String> allClientIds = this.mApplicationMetadataCache.getAllClientIds();
        Logger.info(AbstractC0622a.m1170p(TAG, ":removeAccountFromDevice", new StringBuilder()), "Found [" + allClientIds.size() + "] client ids.");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = allClientIds.iterator();
        while (it.hasNext()) {
            arrayList.add(removeAccountInternal(accountRecord.getEnvironment(), it.next(), accountRecord.getHomeAccountId(), null, true));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.addAll((AccountDeletionRecord) it2.next());
        }
        Logger.info(AbstractC0622a.m1170p(TAG, ":removeAccountFromDevice", new StringBuilder()), "Deleted [" + arrayList2.size() + "] AccountRecords.");
        return new AccountDeletionRecord(arrayList2);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public boolean removeCredential(@NonNull Credential credential) {
        boolean zRemoveCredential;
        if (credential == null) {
            throw new NullPointerException("credential is marked non-null but is null");
        }
        MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(credential.getClientId(), credential.getEnvironment(), this.mUid);
        if (tokenCacheForClient != null) {
            zRemoveCredential = tokenCacheForClient.removeCredential(credential);
        } else {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":removeCredential", "Could not remove credential. Cache not found.");
            zRemoveCredential = false;
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":removeCredential", new StringBuilder()), "Credential removed? [" + zRemoveCredential + "]");
        return zRemoveCredential;
    }

    public void setSingleSignOnState(@NonNull String str, @NonNull GenericAccount genericaccount, @NonNull GenericRefreshToken genericrefreshtoken) {
        MsalOAuth2TokenCache msalOAuth2TokenCacheInitializeProcessUidCache;
        if (str == null) {
            throw new NullPointerException("uidStr is marked non-null but is null");
        }
        if (genericaccount == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (genericrefreshtoken == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        boolean isFamilyRefreshToken = genericrefreshtoken.getIsFamilyRefreshToken();
        int i = Integer.parseInt(str);
        if (isFamilyRefreshToken) {
            AbstractC4539a.m3216z(new StringBuilder(), TAG, ":setSingleSignOnState", "Saving tokens to foci cache.");
            msalOAuth2TokenCacheInitializeProcessUidCache = this.mFociCache;
        } else {
            msalOAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), i);
        }
        try {
            targetCacheSetSingleSignOnState(genericaccount, genericrefreshtoken, msalOAuth2TokenCacheInitializeProcessUidCache);
            updateApplicationMetadataCache(genericrefreshtoken.getClientId(), genericrefreshtoken.getEnvironment(), genericrefreshtoken.getFamilyId(), i);
        } catch (ClientException unused) {
            AbstractC4539a.m3189C(new StringBuilder(), TAG, ":setSingleSignOnState", "Failed to save account/refresh token. Skipping.");
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4, CredentialType... credentialTypeArr) {
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }

    @Deprecated
    public ICacheRecord save(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord, @NonNull AccessTokenRecord accessTokenRecord, @Nullable String str) throws ClientException {
        ICacheRecord iCacheRecordSave;
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessTokenRecord is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(str);
        StringBuilder sb = new StringBuilder();
        String str2 = TAG;
        String strM1170p = AbstractC0622a.m1170p(str2, ":save (4 args)", sb);
        StringBuilder sb2 = new StringBuilder("Saving to FOCI cache? [");
        sb2.append(!zIsNullOrEmpty);
        sb2.append("]");
        Logger.info(strM1170p, sb2.toString());
        if (zIsNullOrEmpty) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(idTokenRecord.getClientId(), idTokenRecord.getEnvironment(), this.mUid);
            if (tokenCacheForClient == null) {
                Logger.warn(str2 + ":save (4 args)", "Existing cache not found. A new one will be created.");
                tokenCacheForClient = initializeProcessUidCache(getComponents(), this.mUid);
            }
            iCacheRecordSave = tokenCacheForClient.save(accountRecord, idTokenRecord, accessTokenRecord);
        } else {
            iCacheRecordSave = this.mFociCache.save(accountRecord, idTokenRecord, accessTokenRecord);
        }
        updateApplicationMetadataCache(iCacheRecordSave.getAccessToken().getClientId(), iCacheRecordSave.getAccessToken().getEnvironment(), str, this.mUid);
        return iCacheRecordSave;
    }

    @Deprecated
    public synchronized List<ICacheRecord> saveAndLoadAggregatedAccountData(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord, @NonNull AccessTokenRecord accessTokenRecord, @Nullable String str, @NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) {
        List<ICacheRecord> listLoadAggregatedAccountData;
        try {
            if (accountRecord == null) {
                throw new NullPointerException("accountRecord is marked non-null but is null");
            }
            if (idTokenRecord == null) {
                throw new NullPointerException("idTokenRecord is marked non-null but is null");
            }
            if (accessTokenRecord == null) {
                throw new NullPointerException("accessTokenRecord is marked non-null but is null");
            }
            if (abstractAuthenticationScheme == null) {
                throw new NullPointerException("authScheme is marked non-null but is null");
            }
            synchronized (this) {
                listLoadAggregatedAccountData = loadAggregatedAccountData(abstractAuthenticationScheme, save(accountRecord, idTokenRecord, accessTokenRecord, str));
            }
            return listLoadAggregatedAccountData;
        } catch (Throwable th) {
            throw th;
        }
        return listLoadAggregatedAccountData;
    }

    public synchronized List<ICacheRecord> saveAndLoadAggregatedAccountData(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord, @NonNull AccessTokenRecord accessTokenRecord, @Nullable RefreshTokenRecord refreshTokenRecord, @Nullable String str, @NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) throws Throwable {
        List<ICacheRecord> listLoadAggregatedAccountData;
        try {
            if (accountRecord == null) {
                throw new NullPointerException("accountRecord is marked non-null but is null");
            }
            if (idTokenRecord == null) {
                throw new NullPointerException("idTokenRecord is marked non-null but is null");
            }
            if (accessTokenRecord == null) {
                throw new NullPointerException("accessTokenRecord is marked non-null but is null");
            }
            if (abstractAuthenticationScheme != null) {
                try {
                    try {
                        synchronized (this) {
                            try {
                                listLoadAggregatedAccountData = loadAggregatedAccountData(abstractAuthenticationScheme, save(accountRecord, idTokenRecord, accessTokenRecord, refreshTokenRecord, str));
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        return listLoadAggregatedAccountData;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                throw new NullPointerException("authScheme is marked non-null but is null");
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public BrokerOAuth2TokenCache(@NonNull IPlatformComponents iPlatformComponents, int i, @NonNull IBrokerApplicationMetadataCache iBrokerApplicationMetadataCache, @NonNull ProcessUidCacheFactory processUidCacheFactory, @NonNull MicrosoftFamilyOAuth2TokenCache microsoftFamilyOAuth2TokenCache) {
        super(iPlatformComponents);
        this.mDelegate = null;
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (iBrokerApplicationMetadataCache == null) {
            throw new NullPointerException("applicationMetadataCache is marked non-null but is null");
        }
        if (processUidCacheFactory == null) {
            throw new NullPointerException("delegate is marked non-null but is null");
        }
        if (microsoftFamilyOAuth2TokenCache != null) {
            StringBuilder sb = new StringBuilder();
            String str = TAG;
            Logger.verbose(AbstractC0622a.m1170p(str, "ctor", sb), "Init::" + str);
            this.mApplicationMetadataCache = iBrokerApplicationMetadataCache;
            this.mUid = i;
            this.mDelegate = processUidCacheFactory;
            this.mFociCache = microsoftFamilyOAuth2TokenCache;
            return;
        }
        throw new NullPointerException("fociCache is marked non-null but is null");
    }

    @Nullable
    private MsalOAuth2TokenCache getTokenCacheForClient(@NonNull String str, @NonNull String str2, int i) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str2 != null) {
            BrokerApplicationMetadata metadata = this.mApplicationMetadataCache.getMetadata(str, str2, i);
            String strM1170p = AbstractC0622a.m1170p(TAG, ":getTokenCacheForClient(id, env, uid)", new StringBuilder());
            StringBuilder sb = new StringBuilder("Found metadata? ");
            sb.append(metadata != null);
            Logger.info(strM1170p, sb.toString());
            return getTokenCacheForClient(metadata);
        }
        throw new NullPointerException("environment is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(@Nullable String str, @NonNull String str2) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str != null) {
            OAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(str2, str, this.mUid);
            if (tokenCacheForClient == null) {
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getAccountsWithAggregatedAccountData", "Falling back to FoCI cache...");
                tokenCacheForClient = this.mFociCache;
            }
            return tokenCacheForClient.getAccountsWithAggregatedAccountData(str, str2);
        }
        List<OAuth2TokenCache> tokenCachesForClientId = getTokenCachesForClientId(str2);
        ArrayList arrayList = new ArrayList();
        Iterator<OAuth2TokenCache> it = tokenCachesForClientId.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getAccountsWithAggregatedAccountData(null, str2));
        }
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> saveAndLoadAggregatedAccountData(@NonNull GenericOAuth2Strategy genericoauth2strategy, @NonNull GenericAuthorizationRequest genericauthorizationrequest, @NonNull GenericTokenResponse generictokenresponse) {
        OAuth2TokenCache oAuth2TokenCacheInitializeProcessUidCache;
        List<ICacheRecord> listSaveAndLoadAggregatedAccountData;
        if (genericoauth2strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (generictokenresponse != null) {
            synchronized (this) {
                try {
                    boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(generictokenresponse.getFamilyId());
                    String str = TAG + ":saveAndLoadAggregatedAccountData";
                    StringBuilder sb = new StringBuilder("Saving to FOCI cache? [");
                    sb.append(!zIsNullOrEmpty);
                    sb.append("]");
                    Logger.info(str, sb.toString());
                    if (!zIsNullOrEmpty) {
                        oAuth2TokenCacheInitializeProcessUidCache = this.mFociCache;
                    } else {
                        oAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), this.mUid);
                    }
                    listSaveAndLoadAggregatedAccountData = oAuth2TokenCacheInitializeProcessUidCache.saveAndLoadAggregatedAccountData(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
                    ICacheRecord iCacheRecord = listSaveAndLoadAggregatedAccountData.get(0);
                    updateApplicationMetadataCache(iCacheRecord.getRefreshToken().getClientId(), iCacheRecord.getRefreshToken().getEnvironment(), iCacheRecord.getRefreshToken().getFamilyId(), this.mUid);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return listSaveAndLoadAggregatedAccountData;
        }
        throw new NullPointerException("response is marked non-null but is null");
    }

    public ICacheRecord save(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord, @NonNull AccessTokenRecord accessTokenRecord, @Nullable RefreshTokenRecord refreshTokenRecord, @Nullable String str) throws ClientException {
        ICacheRecord iCacheRecordSave;
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord != null) {
            boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(str);
            String strM1170p = AbstractC0622a.m1170p(TAG, ":save (5 args)", new StringBuilder());
            StringBuilder sb = new StringBuilder("Saving to FOCI cache? [");
            sb.append(!zIsNullOrEmpty);
            sb.append("]");
            Logger.info(strM1170p, sb.toString());
            if (!zIsNullOrEmpty) {
                iCacheRecordSave = this.mFociCache.save(accountRecord, idTokenRecord, accessTokenRecord, refreshTokenRecord);
            } else {
                iCacheRecordSave = initializeProcessUidCache(getComponents(), this.mUid).save(accountRecord, idTokenRecord, accessTokenRecord, refreshTokenRecord);
            }
            updateApplicationMetadataCache(iCacheRecordSave.getAccessToken().getClientId(), iCacheRecordSave.getAccessToken().getEnvironment(), str, this.mUid);
            return iCacheRecordSave;
        }
        throw new NullPointerException("accessTokenRecord is marked non-null but is null");
    }

    public List<AccountRecord> getAccounts() {
        HashSet hashSet = new HashSet();
        Iterator<BrokerApplicationMetadata> it = this.mApplicationMetadataCache.getAll().iterator();
        while (it.hasNext()) {
            MsalOAuth2TokenCache tokenCacheForClient = getTokenCacheForClient(it.next());
            if (tokenCacheForClient != null) {
                hashSet.addAll(tokenCacheForClient.getAccountCredentialCache().getAccounts());
            }
        }
        hashSet.addAll(this.mFociCache.getAccountCredentialCache().getAccounts());
        ArrayList arrayList = new ArrayList(hashSet);
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getAccounts", new StringBuilder()), "Found [" + arrayList.size() + "] accounts.");
        return arrayList;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(@NonNull GenericOAuth2Strategy genericoauth2strategy, @NonNull GenericAuthorizationRequest genericauthorizationrequest, @NonNull GenericTokenResponse generictokenresponse) throws ClientException {
        OAuth2TokenCache oAuth2TokenCacheInitializeProcessUidCache;
        if (genericoauth2strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (generictokenresponse != null) {
            boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(generictokenresponse.getFamilyId());
            boolean z = !zIsNullOrEmpty;
            if (!zIsNullOrEmpty) {
                Logger.verbose(AbstractC0622a.m1170p(TAG, ":save", new StringBuilder()), "Received FOCI value: [" + generictokenresponse.getFamilyId() + "]");
            }
            Logger.info(AbstractC0622a.m1170p(TAG, ":save", new StringBuilder()), "Saving to FOCI cache? [" + z + "]");
            if (!zIsNullOrEmpty) {
                oAuth2TokenCacheInitializeProcessUidCache = this.mFociCache;
            } else {
                oAuth2TokenCacheInitializeProcessUidCache = initializeProcessUidCache(getComponents(), this.mUid);
            }
            ICacheRecord iCacheRecordSave = oAuth2TokenCacheInitializeProcessUidCache.save(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
            updateApplicationMetadataCache(iCacheRecordSave.getRefreshToken().getClientId(), iCacheRecordSave.getRefreshToken().getEnvironment(), iCacheRecordSave.getRefreshToken().getFamilyId(), this.mUid);
            return iCacheRecordSave;
        }
        throw new NullPointerException("response is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        throw new UnsupportedOperationException(OAuth2TokenCache.ERR_UNSUPPORTED_OPERATION);
    }
}
