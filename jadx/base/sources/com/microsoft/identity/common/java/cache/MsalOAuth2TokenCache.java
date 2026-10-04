package com.microsoft.identity.common.java.cache;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.java.cache.CacheRecord;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.telemetry.events.CacheEndEvent;
import com.microsoft.identity.common.java.telemetry.events.CacheStartEvent;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import lombok.NonNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MsalOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends TokenResponse, GenericAccount extends BaseAccount, GenericRefreshToken extends RefreshToken> extends OAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse> implements IShareSingleSignOnState<GenericAccount, GenericRefreshToken> {
    private static final String TAG = "MsalOAuth2TokenCache";
    private static final Object sCacheLock = new Object();
    private final IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> mAccountCredentialAdapter;
    private IAccountCredentialCache mAccountCredentialCache;

    public MsalOAuth2TokenCache(IPlatformComponents iPlatformComponents, IAccountCredentialCache iAccountCredentialCache, IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> iAccountCredentialAdapter) {
        super(iPlatformComponents);
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        this.mAccountCredentialCache = iAccountCredentialCache;
        this.mAccountCredentialAdapter = iAccountCredentialAdapter;
    }

    private boolean accountHasCredential(@NonNull AccountRecord accountRecord, @NonNull List<Credential> list) {
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("appCredentials is marked non-null but is null");
        }
        String homeAccountId = accountRecord.getHomeAccountId();
        String environment = accountRecord.getEnvironment();
        Logger.verbosePII(AbstractC0622a.m1170p(TAG, ":accountHasCredential", new StringBuilder()), AbstractC0541b.m775q("HomeAccountId: [", homeAccountId, "]\nEnvironment: [", environment, "]"));
        for (Credential credential : list) {
            if (homeAccountId.equals(credential.getHomeAccountId()) && environment.equals(credential.getEnvironment())) {
                AbstractC4539a.m3216z(new StringBuilder(), TAG, ":accountHasCredential", "Credentials located for account.");
                return true;
            }
        }
        return false;
    }

    public static MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> create(@NonNull IPlatformComponents iPlatformComponents) {
        if (iPlatformComponents != null) {
            return create(iPlatformComponents, false);
        }
        throw new NullPointerException("components is marked non-null but is null");
    }

    private void deleteAccessTokensWithIntersectingScopes(AccessTokenRecord accessTokenRecord) {
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy(accessTokenRecord.getHomeAccountId(), accessTokenRecord.getEnvironment(), CredentialType.fromString(accessTokenRecord.getCredentialType()), accessTokenRecord.getClientId(), accessTokenRecord.getApplicationIdentifier(), accessTokenRecord.getMamEnrollmentIdentifier(), accessTokenRecord.getRealm(), null, accessTokenRecord.getAccessTokenType(), accessTokenRecord.getRequestedClaims(), this.mAccountCredentialCache.getCredentials());
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":deleteAccessTokensWithIntersectingScopes", new StringBuilder()), "Inspecting " + credentialsFilteredBy.size() + " accessToken[s].");
        for (Credential credential : credentialsFilteredBy) {
            if (scopesIntersect(accessTokenRecord, (AccessTokenRecord) credential, true)) {
                Logger.infoPII(AbstractC0622a.m1170p(TAG, ":deleteAccessTokensWithIntersectingScopes", new StringBuilder()), "Removing credential: " + credential);
                this.mAccountCredentialCache.removeCredential(credential);
            }
        }
    }

    private CredentialType getAccessTokenCredentialTypeForAuthenticationScheme(@NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) {
        if (abstractAuthenticationScheme != null) {
            return "Bearer".equalsIgnoreCase(abstractAuthenticationScheme.getName()) ? CredentialType.AccessToken : CredentialType.AccessToken_With_AuthScheme;
        }
        throw new NullPointerException("authScheme is marked non-null but is null");
    }

    @Nullable
    private RefreshTokenRecord getFamilyRefreshTokenForAccount(@NonNull AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.RefreshToken, null, null, null, null, null, null);
        if (credentialsFilteredBy.isEmpty()) {
            return null;
        }
        Logger.verbose(TAG + ":getFamilyRefreshTokensForAccount", "Inspecting fallback RTs for a FoCI match.");
        for (Credential credential : credentialsFilteredBy) {
            if (credential instanceof RefreshTokenRecord) {
                RefreshTokenRecord refreshTokenRecord = (RefreshTokenRecord) credential;
                if (!StringUtil.isNullOrEmpty(refreshTokenRecord.getFamilyId())) {
                    AbstractC4539a.m3216z(new StringBuilder(), TAG, ":getFamilyRefreshTokensForAccount", "Fallback RT found.");
                    return refreshTokenRecord;
                }
            }
        }
        return null;
    }

    private boolean isAccountSchemaCompliant(@NonNull AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        return isSchemaCompliant(accountRecord.getClass(), new String[][]{new String[]{"home_account_id", accountRecord.getHomeAccountId()}, new String[]{"environment", accountRecord.getEnvironment()}, new String[]{AccountRecord.SerializedNames.LOCAL_ACCOUNT_ID, accountRecord.getLocalAccountId()}, new String[]{"username", accountRecord.getUsername()}, new String[]{AccountRecord.SerializedNames.AUTHORITY_TYPE, accountRecord.getAuthorityType()}});
    }

    private boolean isIdTokenSchemaCompliant(@NonNull IdTokenRecord idTokenRecord) {
        if (idTokenRecord == null) {
            throw new NullPointerException("idToken is marked non-null but is null");
        }
        return isSchemaCompliant(idTokenRecord.getClass(), new String[][]{new String[]{"home_account_id", idTokenRecord.getHomeAccountId()}, new String[]{"environment", idTokenRecord.getEnvironment()}, new String[]{Credential.SerializedNames.CREDENTIAL_TYPE, idTokenRecord.getCredentialType()}, new String[]{"client_id", idTokenRecord.getClientId()}, new String[]{Credential.SerializedNames.SECRET, idTokenRecord.getSecret()}});
    }

    private boolean isRefreshTokenSchemaCompliant(@NonNull RefreshTokenRecord refreshTokenRecord) {
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshToken is marked non-null but is null");
        }
        return isSchemaCompliant(refreshTokenRecord.getClass(), new String[][]{new String[]{Credential.SerializedNames.CREDENTIAL_TYPE, refreshTokenRecord.getCredentialType()}, new String[]{"environment", refreshTokenRecord.getEnvironment()}, new String[]{"home_account_id", refreshTokenRecord.getHomeAccountId()}, new String[]{"client_id", refreshTokenRecord.getClientId()}, new String[]{Credential.SerializedNames.SECRET, refreshTokenRecord.getSecret()}});
    }

    private static boolean isSchemaCompliant(Class<?> cls, String[][] strArr) {
        boolean z = true;
        for (String[] strArr2 : strArr) {
            z = z && !StringUtil.isNullOrEmpty(strArr2[1]);
        }
        if (!z) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":isSchemaCompliant", new StringBuilder()), cls.getSimpleName().concat(" does not contain all required fields."));
            for (String[] strArr3 : strArr) {
                Logger.warn(AbstractC0622a.m1170p(TAG, ":isSchemaCompliant", new StringBuilder()), strArr3[0] + " is null? [" + StringUtil.isNullOrEmpty(strArr3[1]) + "]");
            }
        }
        return z;
    }

    @NonNull
    private List<ICacheRecord> mergeCacheRecordWithOtherTenantCacheRecords(@NonNull ICacheRecord iCacheRecord) {
        if (iCacheRecord == null) {
            throw new NullPointerException("savedCacheRecord is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(iCacheRecord);
        ArrayList arrayList2 = new ArrayList(getAllTenantAccountsForAccountByClientId(iCacheRecord.getRefreshToken().getClientId(), iCacheRecord.getAccount()));
        if (!arrayList2.isEmpty()) {
            arrayList2.remove(0);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(getSparseCacheRecordForAccount(iCacheRecord.getRefreshToken().getClientId(), (AccountRecord) it.next()));
            }
        }
        return arrayList;
    }

    private void removeAllRefreshTokensExcept(@NonNull AccountRecord accountRecord, @NonNull RefreshTokenRecord refreshTokenRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("deletionExemptRefreshToken is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(refreshTokenRecord.getFamilyId());
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        String strM1170p = AbstractC0622a.m1170p(str, ":removeAllRefreshTokensExcept", sb);
        StringBuilder sb2 = new StringBuilder("isFamilyRefreshToken? [");
        sb2.append(!zIsNullOrEmpty);
        sb2.append("]");
        Logger.info(strM1170p, sb2.toString());
        boolean zEquals = MicrosoftAccount.AUTHORITY_TYPE_MS_STS.equals(accountRecord.getAuthorityType());
        Logger.info(AbstractC0541b.m756B(str, ":removeAllRefreshTokensExcept"), "isMultiResourceCapable? [" + zEquals + "]");
        if (!zIsNullOrEmpty || zEquals) {
            String environment = accountRecord.getEnvironment();
            String clientId = refreshTokenRecord.getClientId();
            if (!zIsNullOrEmpty) {
                clientId = null;
            }
            int iRemoveCredentialsOfTypeForAccountExcept = removeCredentialsOfTypeForAccountExcept(environment, clientId, CredentialType.RefreshToken, accountRecord, true, refreshTokenRecord);
            Logger.info(AbstractC0541b.m756B(str, ":removeAllRefreshTokensExcept"), "Refresh tokens removed: [" + iRemoveCredentialsOfTypeForAccountExcept + "]");
            if (iRemoveCredentialsOfTypeForAccountExcept > 1) {
                Logger.warn(str + ":removeAllRefreshTokensExcept", "Multiple refresh tokens found for Account.");
            }
        }
    }

    private int removeCredentialsOfTypeForAccount(@Nullable String str, @Nullable String str2, @NonNull CredentialType credentialType, @NonNull AccountRecord accountRecord, boolean z) {
        if (credentialType == null) {
            throw new NullPointerException("credentialType is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("targetAccount is marked non-null but is null");
        }
        Iterator<Credential> it = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), str, credentialType, str2, null, null, z ? null : accountRecord.getRealm(), null, null).iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.mAccountCredentialCache.removeCredential(it.next())) {
                i++;
            }
        }
        return i;
    }

    private int removeCredentialsOfTypeForAccountExcept(@NonNull String str, @Nullable String str2, @NonNull CredentialType credentialType, @NonNull AccountRecord accountRecord, boolean z, @NonNull Credential credential) {
        if (str == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        if (credentialType == null) {
            throw new NullPointerException("credentialType is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("targetAccount is marked non-null but is null");
        }
        if (credential == null) {
            throw new NullPointerException("deletionExemptRecord is marked non-null but is null");
        }
        int i = 0;
        for (Credential credential2 : this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), str, credentialType, str2, null, null, z ? null : accountRecord.getRealm(), null, null)) {
            if (!credential.equals(credential2) && this.mAccountCredentialCache.removeCredential(credential2)) {
                i++;
            }
        }
        return i;
    }

    private int removeRefreshTokensForAccount(@NonNull AccountRecord accountRecord, boolean z, @NonNull String str, @Nullable String str2) {
        if (accountRecord == null) {
            throw new NullPointerException("accountToSave is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        if (z) {
            str2 = null;
        }
        return removeCredentialsOfTypeForAccount(str, str2, CredentialType.RefreshToken, accountRecord, true);
    }

    private void saveAccounts(AccountRecord... accountRecordArr) {
        for (AccountRecord accountRecord : accountRecordArr) {
            this.mAccountCredentialCache.saveAccount(accountRecord);
        }
    }

    private Set<String> scopesAsSet(AccessTokenRecord accessTokenRecord) {
        String target = accessTokenRecord.getTarget();
        if (StringUtil.isNullOrEmpty(target)) {
            return new HashSet();
        }
        String[] strArrSplit = target.split("\\s+");
        HashSet hashSet = new HashSet();
        for (String str : strArrSplit) {
            hashSet.add(str.toLowerCase(Locale.US));
        }
        return hashSet;
    }

    private boolean scopesIntersect(AccessTokenRecord accessTokenRecord, AccessTokenRecord accessTokenRecord2, boolean z) {
        Set<String> setScopesAsSet = scopesAsSet(accessTokenRecord);
        Set<String> setScopesAsSet2 = scopesAsSet(accessTokenRecord2);
        if (z) {
            Set<String> set = AuthenticationConstants.DEFAULT_SCOPES;
            setScopesAsSet.removeAll(set);
            setScopesAsSet2.removeAll(set);
        }
        for (String str : setScopesAsSet2) {
            if (setScopesAsSet.contains(str)) {
                StringBuilder sb = new StringBuilder();
                String str2 = TAG;
                sb.append(str2);
                sb.append(":scopesIntersect");
                Logger.info(sb.toString(), "Scopes intersect.");
                Logger.infoPII(str2 + ":scopesIntersect", setScopesAsSet.toString() + " contains [" + str + "]");
                return true;
            }
        }
        return false;
    }

    private void setToCacheRecord(@NonNull CacheRecord.CacheRecordBuilder cacheRecordBuilder, @NonNull IdTokenRecord idTokenRecord) {
        if (cacheRecordBuilder == null) {
            throw new NullPointerException("target is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        CredentialType credentialTypeFromString = CredentialType.fromString(idTokenRecord.getCredentialType());
        if (credentialTypeFromString != null) {
            if (CredentialType.V1IdToken == credentialTypeFromString) {
                cacheRecordBuilder.v1IdToken(idTokenRecord);
                return;
            }
            if (CredentialType.IdToken == credentialTypeFromString) {
                cacheRecordBuilder.idToken(idTokenRecord);
                return;
            }
            Logger.warn(AbstractC0622a.m1170p(TAG, ":setToCacheRecord", new StringBuilder()), "Unrecognized IdToken type: " + idTokenRecord.getCredentialType());
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public void clearAll() {
        AbstractC4539a.m3189C(new StringBuilder(), TAG, ":clearAll", "Clearing cache.");
        this.mAccountCredentialCache.clearAll();
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
        StringBuilder sb = new StringBuilder();
        String str5 = TAG;
        Logger.verbosePII(AbstractC0622a.m1170p(str5, ":getAccount", sb), AbstractC0541b.m776r(AbstractC0000a.m16m("Environment: [", str, "]\nClientId: [", str2, "]\nHomeAccountId: ["), str3, "]\nRealm: [", str4, "]"));
        List<AccountRecord> accounts = getAccounts(str, str2);
        Logger.info(AbstractC0541b.m756B(str5, ":getAccount"), "Found " + accounts.size() + " accounts");
        for (AccountRecord accountRecord : accounts) {
            if (str3.equals(accountRecord.getHomeAccountId()) && (str4 == null || str4.equals(accountRecord.getRealm()))) {
                return accountRecord;
            }
        }
        AbstractC4539a.m3189C(new StringBuilder(), TAG, ":getAccount", "No matching account found.");
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    @Nullable
    public AccountRecord getAccountByHomeAccountId(@Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        List<AccountRecord> accounts = getAccounts(str, str2);
        Logger.verbosePII(AbstractC0622a.m1170p(TAG, ":getAccountByHomeAccountId", new StringBuilder()), "homeAccountId: [" + str3 + "]");
        for (AccountRecord accountRecord : accounts) {
            if (str3.equals(accountRecord.getHomeAccountId())) {
                return accountRecord;
            }
        }
        return null;
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
        List<AccountRecord> accounts = getAccounts(str, str2);
        Logger.verbosePII(AbstractC0622a.m1170p(TAG, ":getAccountByLocalAccountId", new StringBuilder()), "LocalAccountId: [" + str3 + "]");
        for (AccountRecord accountRecord : accounts) {
            if (str3.equals(accountRecord.getLocalAccountId())) {
                return accountRecord;
            }
        }
        return null;
    }

    public IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> getAccountCredentialAdapter() {
        return this.mAccountCredentialAdapter;
    }

    public IAccountCredentialCache getAccountCredentialCache() {
        return this.mAccountCredentialCache;
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
        AccountRecord accountByLocalAccountId = getAccountByLocalAccountId(str, str2, str3);
        if (accountByLocalAccountId == null) {
            return null;
        }
        List<IdTokenRecord> idTokensForAccountRecord = getIdTokensForAccountRecord(str2, accountByLocalAccountId);
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountByLocalAccountId);
        Iterator<IdTokenRecord> it = idTokensForAccountRecord.iterator();
        while (it.hasNext()) {
            setToCacheRecord(cacheRecordBuilderBuilder, it.next());
        }
        return cacheRecordBuilderBuilder.build();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAccounts(@Nullable String str, @NonNull String str2) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str3 = TAG;
        Logger.verbosePII(AbstractC0622a.m1170p(str3, ":getAccounts", sb), AbstractC0541b.m775q("Environment: [", str, "]\nClientId: [", str2, "]"));
        ArrayList arrayList = new ArrayList();
        List<AccountRecord> accountsFilteredBy = this.mAccountCredentialCache.getAccountsFilteredBy(null, str, null);
        Logger.verbose(AbstractC0541b.m756B(str3, ":getAccounts"), "Found " + accountsFilteredBy.size() + " accounts for this environment");
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy((String) null, str, new HashSet(Arrays.asList(CredentialType.IdToken, CredentialType.V1IdToken, CredentialType.RefreshToken)), str2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null);
        for (AccountRecord accountRecord : accountsFilteredBy) {
            if (accountHasCredential(accountRecord, credentialsFilteredBy)) {
                arrayList.add(accountRecord);
            }
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getAccounts", new StringBuilder()), "Found " + arrayList.size() + " accounts for this clientId");
        return Collections.unmodifiableList(arrayList);
    }

    public List<AccountRecord> getAccountsByUsername(@Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (str2 == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("username is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        List<AccountRecord> accounts = getAccounts(str, str2);
        for (AccountRecord accountRecord : accounts) {
            if (StringUtil.equalsIgnoreCase(accountRecord.getUsername(), str3)) {
                arrayList.add(accountRecord);
            }
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getAccountsByUsername", new StringBuilder()), "Found " + accounts.size() + " accounts matching username.");
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
        ArrayList arrayList = new ArrayList();
        AccountRecord account = getAccount(str, str2, str3, null);
        if (account != null) {
            Iterator<AccountRecord> it = getAllTenantAccountsForAccountByClientId(str2, account).iterator();
            while (it.hasNext()) {
                arrayList.add(getSparseCacheRecordForAccount(str2, it.next()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public Set<String> getAllClientIds() {
        HashSet hashSet = new HashSet();
        Iterator<Credential> it = this.mAccountCredentialCache.getCredentials().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getClientId());
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":getAllClientIds", new StringBuilder()), "Found [" + hashSet.size() + "] clientIds/");
        return hashSet;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<AccountRecord> getAllTenantAccountsForAccountByClientId(@NonNull String str, @NonNull AccountRecord accountRecord) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(accountRecord);
        List<AccountRecord> accountsFilteredBy = this.mAccountCredentialCache.getAccountsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), null);
        for (AccountRecord accountRecord2 : getAccounts(accountRecord.getEnvironment(), str)) {
            if (accountsFilteredBy.contains(accountRecord2) && !accountRecord.equals(accountRecord2)) {
                arrayList.add(accountRecord2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Nullable
    public RefreshTokenRecord getFamilyRefreshTokenForHomeAccountId(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        for (AccountRecord accountRecord : this.mAccountCredentialCache.getAccounts()) {
            if (accountRecord.getHomeAccountId().equals(str)) {
                return getFamilyRefreshTokenForAccount(accountRecord);
            }
        }
        return null;
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<IdTokenRecord> getIdTokensForAccountRecord(@Nullable String str, @NonNull AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        List<Credential> credentials = this.mAccountCredentialCache.getCredentials();
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.IdToken, str, (String) null, (String) null, accountRecord.getRealm(), (String) null, (String) null, credentials);
        credentialsFilteredBy.addAll(this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.V1IdToken, str, (String) null, (String) null, accountRecord.getRealm(), (String) null, (String) null, credentials));
        for (Credential credential : credentialsFilteredBy) {
            if (credential instanceof IdTokenRecord) {
                arrayList.add((IdTokenRecord) credential);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.microsoft.identity.common.java.cache.IShareSingleSignOnState
    public GenericRefreshToken getSingleSignOnState(GenericAccount genericaccount) {
        throw new UnsupportedOperationException("Unimplemented!");
    }

    public ICacheRecord getSparseCacheRecordForAccount(@NonNull String str, @NonNull AccountRecord accountRecord) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("acct is marked non-null but is null");
        }
        List<IdTokenRecord> idTokensForAccountRecord = getIdTokensForAccountRecord(str, accountRecord);
        if (idTokensForAccountRecord.size() > CredentialType.ID_TOKEN_TYPES.size()) {
            Logger.warn(AbstractC0622a.m1170p(TAG, ":getSparseCacheRecordForAccount", new StringBuilder()), "Found more IdTokens than expected.\nFound: [" + idTokensForAccountRecord.size() + "]");
        }
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecord);
        Iterator<IdTokenRecord> it = idTokensForAccountRecord.iterator();
        while (it.hasNext()) {
            setToCacheRecord(cacheRecordBuilderBuilder, it.next());
        }
        return cacheRecordBuilderBuilder.build();
    }

    public boolean isAccessTokenSchemaCompliant(@NonNull AccessTokenRecord accessTokenRecord) {
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessToken is marked non-null but is null");
        }
        return isSchemaCompliant(accessTokenRecord.getClass(), new String[][]{new String[]{Credential.SerializedNames.CREDENTIAL_TYPE, accessTokenRecord.getCredentialType()}, new String[]{"home_account_id", accessTokenRecord.getHomeAccountId()}, new String[]{"environment", accessTokenRecord.getEnvironment()}, new String[]{"client_id", accessTokenRecord.getClientId()}, new String[]{"target", accessTokenRecord.getTarget()}, new String[]{Credential.SerializedNames.CACHED_AT, accessTokenRecord.getCachedAt()}, new String[]{Credential.SerializedNames.EXPIRES_ON, accessTokenRecord.getExpiresOn()}, new String[]{Credential.SerializedNames.SECRET, accessTokenRecord.getSecret()}});
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord load(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull AccountRecord accountRecord, @NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        if (abstractAuthenticationScheme == null) {
            throw new NullPointerException("authScheme is marked non-null but is null");
        }
        Telemetry.emit(new CacheStartEvent());
        boolean zEquals = MicrosoftAccount.AUTHORITY_TYPE_MS_STS.equals(accountRecord.getAuthorityType());
        List<Credential> credentials = this.mAccountCredentialCache.getCredentials();
        List<Credential> credentialsFilteredBy = this.mAccountCredentialCache.getCredentialsFilteredBy(credentials, accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), getAccessTokenCredentialTypeForAuthenticationScheme(abstractAuthenticationScheme), str, str2, str3, accountRecord.getRealm(), str4, abstractAuthenticationScheme.getName(), null, abstractAuthenticationScheme instanceof PopAuthenticationSchemeWithClientKeyInternal ? ((PopAuthenticationSchemeWithClientKeyInternal) abstractAuthenticationScheme).getKid() : null);
        List<Credential> credentialsFilteredBy2 = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.RefreshToken, str, (String) null, (String) null, zEquals ? null : accountRecord.getRealm(), zEquals ? null : str4, (String) null, credentials);
        boolean zIsEmpty = credentialsFilteredBy2.isEmpty();
        List list = credentialsFilteredBy2;
        if (zIsEmpty) {
            RefreshTokenRecord familyRefreshTokenForAccount = getFamilyRefreshTokenForAccount(accountRecord);
            list = credentialsFilteredBy2;
            if (familyRefreshTokenForAccount != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(familyRefreshTokenForAccount);
                list = arrayList;
            }
        }
        List<Credential> credentialsFilteredBy3 = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.IdToken, str, (String) null, (String) null, accountRecord.getRealm(), (String) null, (String) null, credentials);
        List<Credential> credentialsFilteredBy4 = this.mAccountCredentialCache.getCredentialsFilteredBy(accountRecord.getHomeAccountId(), accountRecord.getEnvironment(), CredentialType.V1IdToken, str, (String) null, (String) null, accountRecord.getRealm(), (String) null, (String) null, credentials);
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecord);
        cacheRecordBuilderBuilder.accessToken(credentialsFilteredBy.isEmpty() ? null : (AccessTokenRecord) credentialsFilteredBy.get(0));
        cacheRecordBuilderBuilder.refreshToken(list.isEmpty() ? null : (RefreshTokenRecord) list.get(0));
        cacheRecordBuilderBuilder.idToken(credentialsFilteredBy3.isEmpty() ? null : (IdTokenRecord) credentialsFilteredBy3.get(0));
        cacheRecordBuilderBuilder.v1IdToken(credentialsFilteredBy4.isEmpty() ? null : (IdTokenRecord) credentialsFilteredBy4.get(0));
        Telemetry.emit(new CacheEndEvent().putCacheRecordStatus(cacheRecordBuilderBuilder.build()));
        return cacheRecordBuilderBuilder.build();
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> loadWithAggregatedAccountData(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @NonNull AccountRecord accountRecord, @NonNull AbstractAuthenticationScheme abstractAuthenticationScheme) throws Throwable {
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
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(load(str, str2, str3, str4, accountRecord, abstractAuthenticationScheme));
                    for (ICacheRecord iCacheRecord : getAccountsWithAggregatedAccountData(accountRecord.getEnvironment(), str, accountRecord.getHomeAccountId())) {
                        if (!accountRecord.equals(iCacheRecord.getAccount())) {
                            arrayList.add(iCacheRecord);
                        }
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return removeAccount(str, str2, str3, str4, CredentialType.AccessToken, CredentialType.AccessToken_With_AuthScheme, CredentialType.RefreshToken, CredentialType.IdToken, CredentialType.V1IdToken);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public boolean removeCredential(Credential credential) {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        sb.append(str);
        sb.append(":removeCredential");
        Logger.info(sb.toString(), "Removing credential...");
        Logger.verbosePII(str + ":removeCredential", "ClientId: [" + credential.getClientId() + "]\nCredentialType: [" + credential.getCredentialType() + "]\nCachedAt: [" + credential.getCachedAt() + "]\nEnvironment: [" + credential.getEnvironment() + "]\nHomeAccountId: [" + credential.getHomeAccountId() + "]\nIsExpired?: [" + credential.isExpired() + "]");
        return this.mAccountCredentialCache.removeCredential(credential);
    }

    public void removeRefreshTokenIfNeeded(@NonNull AccountRecord accountRecord, @NonNull RefreshTokenRecord refreshTokenRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshTokenRecord is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(refreshTokenRecord.getFamilyId());
        boolean z = !zIsNullOrEmpty;
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        Logger.info(AbstractC0622a.m1170p(str, ":removeRefreshTokenIfNeeded", sb), "isFamilyRefreshToken? [" + z + "]");
        boolean zEquals = MicrosoftAccount.AUTHORITY_TYPE_MS_STS.equals(accountRecord.getAuthorityType());
        Logger.info(AbstractC0541b.m756B(str, ":removeRefreshTokenIfNeeded"), "isMultiResourceCapable? [" + zEquals + "]");
        if (!zIsNullOrEmpty || zEquals) {
            int iRemoveRefreshTokensForAccount = removeRefreshTokensForAccount(accountRecord, z, accountRecord.getEnvironment(), refreshTokenRecord.getClientId());
            Logger.info(AbstractC0541b.m756B(str, ":removeRefreshTokenIfNeeded"), "Refresh tokens removed: [" + iRemoveRefreshTokensForAccount + "]");
            if (iRemoveRefreshTokensForAccount > 1) {
                Logger.warn(str + ":removeRefreshTokenIfNeeded", "Multiple refresh tokens found for Account.");
            }
        }
    }

    @Deprecated
    public ICacheRecord save(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord, @NonNull AccessTokenRecord accessTokenRecord) throws ClientException {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord == null) {
            throw new NullPointerException("accessTokenRecord is marked non-null but is null");
        }
        boolean zIsAccountSchemaCompliant = isAccountSchemaCompliant(accountRecord);
        boolean zIsIdTokenSchemaCompliant = isIdTokenSchemaCompliant(idTokenRecord);
        boolean zIsAccessTokenSchemaCompliant = isAccessTokenSchemaCompliant(accessTokenRecord);
        if (!zIsAccountSchemaCompliant) {
            throw new ClientException(ErrorStrings.ACCOUNT_IS_SCHEMA_NONCOMPLIANT);
        }
        if (!zIsIdTokenSchemaCompliant) {
            throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(ID)]");
        }
        if (!zIsAccessTokenSchemaCompliant) {
            throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(AT)]");
        }
        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":save (3 arg)", "Accounts/Credentials are valid.... proceeding");
        saveAccounts(accountRecord);
        saveCredentialsInternal(idTokenRecord, accessTokenRecord);
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecord);
        cacheRecordBuilderBuilder.accessToken(accessTokenRecord);
        if (CredentialType.V1IdToken.name().equalsIgnoreCase(idTokenRecord.getCredentialType())) {
            cacheRecordBuilderBuilder.v1IdToken(idTokenRecord);
        } else {
            cacheRecordBuilderBuilder.idToken(idTokenRecord);
        }
        return cacheRecordBuilderBuilder.build();
    }

    @NonNull
    public List<ICacheRecord> saveAndLoadAggregatedAccountData(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord, @NonNull AccessTokenRecord accessTokenRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord != null) {
            return mergeCacheRecordWithOtherTenantCacheRecords(save(accountRecord, idTokenRecord, accessTokenRecord));
        }
        throw new NullPointerException("accessTokenRecord is marked non-null but is null");
    }

    public void saveCredentialsInternal(Credential... credentialArr) {
        for (Credential credential : credentialArr) {
            if (credential != null) {
                if (credential instanceof AccessTokenRecord) {
                    deleteAccessTokensWithIntersectingScopes((AccessTokenRecord) credential);
                }
                this.mAccountCredentialCache.saveCredential(credential);
            }
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IShareSingleSignOnState
    public void setSingleSignOnState(GenericAccount genericaccount, GenericRefreshToken genericrefreshtoken) throws ClientException {
        Logger.info(TAG + ":setSingleSignOnState", "Set SSO state called.");
        AccountRecord accountRecordAsAccount = this.mAccountCredentialAdapter.asAccount(genericaccount);
        RefreshTokenRecord refreshTokenRecordAsRefreshToken = this.mAccountCredentialAdapter.asRefreshToken(genericrefreshtoken);
        IdTokenRecord idTokenRecordAsIdToken = this.mAccountCredentialAdapter.asIdToken(genericaccount, genericrefreshtoken);
        validateCacheArtifacts(accountRecordAsAccount, null, refreshTokenRecordAsRefreshToken, idTokenRecordAsIdToken);
        saveAccounts(accountRecordAsAccount);
        synchronized (sCacheLock) {
            saveCredentialsInternal(idTokenRecordAsIdToken, refreshTokenRecordAsRefreshToken);
            removeAllRefreshTokensExcept(accountRecordAsAccount, refreshTokenRecordAsRefreshToken);
        }
    }

    public void validateCacheArtifacts(@NonNull AccountRecord accountRecord, AccessTokenRecord accessTokenRecord, @NonNull RefreshTokenRecord refreshTokenRecord, @NonNull IdTokenRecord idTokenRecord) throws ClientException {
        if (accountRecord == null) {
            throw new NullPointerException("accountToSave is marked non-null but is null");
        }
        if (refreshTokenRecord == null) {
            throw new NullPointerException("refreshTokenToSave is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenToSave is marked non-null but is null");
        }
        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":validateCacheArtifacts", "Validating cache artifacts...");
        boolean zIsAccountSchemaCompliant = isAccountSchemaCompliant(accountRecord);
        boolean z = accessTokenRecord == null || isAccessTokenSchemaCompliant(accessTokenRecord);
        boolean zIsRefreshTokenSchemaCompliant = isRefreshTokenSchemaCompliant(refreshTokenRecord);
        boolean zIsIdTokenSchemaCompliant = isIdTokenSchemaCompliant(idTokenRecord);
        if (!zIsAccountSchemaCompliant) {
            throw new ClientException(ErrorStrings.ACCOUNT_IS_SCHEMA_NONCOMPLIANT);
        }
        if (z && zIsRefreshTokenSchemaCompliant && zIsIdTokenSchemaCompliant) {
            return;
        }
        String strM756B = !z ? "[(AT)" : "[";
        if (!zIsRefreshTokenSchemaCompliant) {
            strM756B = AbstractC0541b.m756B(strM756B, "(RT)");
        }
        if (!zIsIdTokenSchemaCompliant) {
            strM756B = AbstractC0541b.m756B(strM756B, "(ID)");
        }
        throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, AbstractC0541b.m756B(strM756B, "]"));
    }

    public void validateNonNull(@Nullable Object obj, @NonNull String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("type is marked non-null but is null");
        }
        String strConcat = str.concat(" passed in is Null");
        if (obj != null) {
            return;
        }
        Logger.warn(TAG, strConcat);
        throw new ClientException(strConcat);
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public AccountDeletionRecord removeAccount(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable CredentialType... credentialTypeArr) {
        AccountRecord account;
        boolean z;
        AccountRecord accountRecord;
        String str5 = str2;
        StringBuilder sb = new StringBuilder();
        String str6 = TAG;
        String strM1170p = AbstractC0622a.m1170p(str6, ":removeAccount", sb);
        StringBuilder sbM16m = AbstractC0000a.m16m("Environment: [", str, "]\nClientId: [", str5, "]\nHomeAccountId: [");
        AbstractC2821a.m2207B(sbM16m, str3, "]\nRealm: [", str4, "]\nCredentialTypes to delete: [");
        sbM16m.append(Arrays.toString(credentialTypeArr));
        sbM16m.append("]");
        Logger.verbosePII(strM1170p, sbM16m.toString());
        if (str5 == null || str3 == null || (account = getAccount(str, str2, str3, str4)) == null) {
            Logger.warn(str6 + ":removeAccount", "Insufficient filtering provided for account removal - preserving Account.");
            return new AccountDeletionRecord(null);
        }
        boolean z2 = str4 == null;
        Logger.verbose(AbstractC0541b.m756B(str6, ":removeAccount"), "IsRealmAgnostic? " + z2);
        if (credentialTypeArr == null || credentialTypeArr.length <= 0) {
            z = z2;
            accountRecord = account;
            Logger.warn(str6 + ":removeAccount", "removeAccount called, but no CredentialTypes to remove specified");
        } else {
            int length = credentialTypeArr.length;
            int i = 0;
            while (i < length) {
                AccountRecord accountRecord2 = account;
                CredentialType credentialType = credentialTypeArr[i];
                boolean z3 = z2;
                int iRemoveCredentialsOfTypeForAccount = removeCredentialsOfTypeForAccount(str, str5, credentialType, accountRecord2, z3);
                Logger.info(AbstractC0622a.m1170p(TAG, ":removeAccount", new StringBuilder()), "Removed " + iRemoveCredentialsOfTypeForAccount + " credentials of type: " + credentialType);
                i++;
                account = accountRecord2;
                z2 = z3;
                str5 = str2;
            }
            z = z2;
            accountRecord = account;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (AccountRecord accountRecord3 : this.mAccountCredentialCache.getAccountsFilteredBy(str3, str, null)) {
                if (this.mAccountCredentialCache.removeAccount(accountRecord3)) {
                    arrayList.add(accountRecord3);
                }
            }
        } else if (this.mAccountCredentialCache.removeAccount(accountRecord)) {
            arrayList.add(accountRecord);
        }
        return new AccountDeletionRecord(arrayList);
    }

    public static MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> create(@NonNull IPlatformComponents iPlatformComponents, boolean z) {
        IAccountCredentialCache sharedPreferencesAccountCredentialCache;
        if (iPlatformComponents != null) {
            Logger.verbose(TAG + ":create", "Creating MsalOAuth2TokenCache");
            CacheKeyValueDelegate cacheKeyValueDelegate = new CacheKeyValueDelegate();
            INameValueStorage encryptedNameValueStore = iPlatformComponents.getStorageSupplier().getEncryptedNameValueStore(SharedPreferencesAccountCredentialCache.DEFAULT_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES, String.class);
            if (z) {
                sharedPreferencesAccountCredentialCache = new SharedPreferencesAccountCredentialCacheWithMemoryCache(cacheKeyValueDelegate, encryptedNameValueStore);
            } else {
                sharedPreferencesAccountCredentialCache = new SharedPreferencesAccountCredentialCache(cacheKeyValueDelegate, encryptedNameValueStore);
            }
            return new MsalOAuth2TokenCache<>(iPlatformComponents, sharedPreferencesAccountCredentialCache, new MicrosoftStsAccountCredentialAdapter());
        }
        throw new NullPointerException("components is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    @NonNull
    public List<ICacheRecord> saveAndLoadAggregatedAccountData(@NonNull GenericOAuth2Strategy genericoauth2strategy, @NonNull GenericAuthorizationRequest genericauthorizationrequest, @NonNull GenericTokenResponse generictokenresponse) {
        List<ICacheRecord> listMergeCacheRecordWithOtherTenantCacheRecords;
        if (genericoauth2strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (generictokenresponse != null) {
            synchronized (this) {
                listMergeCacheRecordWithOtherTenantCacheRecords = mergeCacheRecordWithOtherTenantCacheRecords(save(genericoauth2strategy, genericauthorizationrequest, generictokenresponse));
            }
            return listMergeCacheRecordWithOtherTenantCacheRecords;
        }
        throw new NullPointerException("response is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public List<ICacheRecord> getAccountsWithAggregatedAccountData(@Nullable String str, @NonNull String str2) {
        if (str2 != null) {
            ArrayList arrayList = new ArrayList();
            for (AccountRecord accountRecord : getAccounts(str, str2)) {
                List<IdTokenRecord> idTokensForAccountRecord = getIdTokensForAccountRecord(str2, accountRecord);
                if (idTokensForAccountRecord != null && idTokensForAccountRecord.size() != 0) {
                    CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
                    cacheRecordBuilderBuilder.account(accountRecord);
                    Iterator<IdTokenRecord> it = idTokensForAccountRecord.iterator();
                    while (it.hasNext()) {
                        setToCacheRecord(cacheRecordBuilderBuilder, it.next());
                    }
                    arrayList.add(cacheRecordBuilderBuilder.build());
                }
            }
            Logger.verbose(AbstractC0622a.m1170p(TAG, ":getAccountsWithAggregatedAccountData", new StringBuilder()), "Found " + arrayList.size() + " accounts with IdTokens");
            return Collections.unmodifiableList(arrayList);
        }
        throw new NullPointerException("clientId is marked non-null but is null");
    }

    public ICacheRecord save(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord, @NonNull AccessTokenRecord accessTokenRecord, @Nullable RefreshTokenRecord refreshTokenRecord) throws ClientException {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        if (idTokenRecord == null) {
            throw new NullPointerException("idTokenRecord is marked non-null but is null");
        }
        if (accessTokenRecord != null) {
            if (isAccountSchemaCompliant(accountRecord)) {
                if (isIdTokenSchemaCompliant(idTokenRecord)) {
                    if (isAccessTokenSchemaCompliant(accessTokenRecord)) {
                        if (refreshTokenRecord != null && !isRefreshTokenSchemaCompliant(refreshTokenRecord)) {
                            throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(RT)]");
                        }
                        AbstractC4539a.m3216z(new StringBuilder(), TAG, ":save (4 arg)", "Accounts/Credentials are valid.... proceeding");
                        saveAccounts(accountRecord);
                        saveCredentialsInternal(idTokenRecord, accessTokenRecord, refreshTokenRecord);
                        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
                        cacheRecordBuilderBuilder.account(accountRecord);
                        cacheRecordBuilderBuilder.accessToken(accessTokenRecord);
                        cacheRecordBuilderBuilder.refreshToken(refreshTokenRecord);
                        if (CredentialType.V1IdToken.name().equalsIgnoreCase(idTokenRecord.getCredentialType())) {
                            cacheRecordBuilderBuilder.v1IdToken(idTokenRecord);
                        } else {
                            cacheRecordBuilderBuilder.idToken(idTokenRecord);
                        }
                        return cacheRecordBuilderBuilder.build();
                    }
                    throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(AT)]");
                }
                throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "[(ID)]");
            }
            throw new ClientException(ErrorStrings.ACCOUNT_IS_SCHEMA_NONCOMPLIANT);
        }
        throw new NullPointerException("accessTokenRecord is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(@NonNull GenericOAuth2Strategy genericoauth2strategy, @NonNull GenericAuthorizationRequest genericauthorizationrequest, @NonNull GenericTokenResponse generictokenresponse) throws ClientException {
        if (genericoauth2strategy == null) {
            throw new NullPointerException("oAuth2Strategy is marked non-null but is null");
        }
        if (genericauthorizationrequest == null) {
            throw new NullPointerException("request is marked non-null but is null");
        }
        if (generictokenresponse != null) {
            AccountRecord accountRecordCreateAccount = this.mAccountCredentialAdapter.createAccount(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
            AccessTokenRecord accessTokenRecordCreateAccessToken = this.mAccountCredentialAdapter.createAccessToken(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
            RefreshTokenRecord refreshTokenRecordCreateRefreshToken = this.mAccountCredentialAdapter.createRefreshToken(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
            IdTokenRecord idTokenRecordCreateIdToken = this.mAccountCredentialAdapter.createIdToken(genericoauth2strategy, genericauthorizationrequest, generictokenresponse);
            validateCacheArtifacts(accountRecordCreateAccount, accessTokenRecordCreateAccessToken, refreshTokenRecordCreateRefreshToken, idTokenRecordCreateIdToken);
            saveAccounts(accountRecordCreateAccount);
            synchronized (sCacheLock) {
                saveCredentialsInternal(accessTokenRecordCreateAccessToken, refreshTokenRecordCreateRefreshToken, idTokenRecordCreateIdToken);
                removeAllRefreshTokensExcept(accountRecordCreateAccount, refreshTokenRecordCreateRefreshToken);
            }
            CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
            cacheRecordBuilderBuilder.account(accountRecordCreateAccount);
            cacheRecordBuilderBuilder.accessToken(accessTokenRecordCreateAccessToken);
            cacheRecordBuilderBuilder.refreshToken(refreshTokenRecordCreateRefreshToken);
            setToCacheRecord(cacheRecordBuilderBuilder, idTokenRecordCreateIdToken);
            return cacheRecordBuilderBuilder.build();
        }
        throw new NullPointerException("response is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache
    public ICacheRecord save(@NonNull AccountRecord accountRecord, @NonNull IdTokenRecord idTokenRecord) {
        String strM756B;
        if (accountRecord == null) {
            throw new NullPointerException("accountToSave is marked non-null but is null");
        }
        if (idTokenRecord != null) {
            StringBuilder sb = new StringBuilder();
            String str = TAG;
            AbstractC4539a.m3216z(sb, str, ":save", "Importing AccountRecord, IdTokenRecord (direct)");
            boolean zIsAccountSchemaCompliant = isAccountSchemaCompliant(accountRecord);
            boolean zIsIdTokenSchemaCompliant = isIdTokenSchemaCompliant(idTokenRecord);
            CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
            if (zIsAccountSchemaCompliant && zIsIdTokenSchemaCompliant) {
                saveAccounts(accountRecord);
                saveCredentialsInternal(idTokenRecord);
                cacheRecordBuilderBuilder.account(accountRecord);
                if (CredentialType.V1IdToken.name().equalsIgnoreCase(idTokenRecord.getCredentialType())) {
                    cacheRecordBuilderBuilder.v1IdToken(idTokenRecord);
                } else {
                    cacheRecordBuilderBuilder.idToken(idTokenRecord);
                }
            } else {
                if (!zIsAccountSchemaCompliant) {
                    strM756B = "[(Account)";
                } else {
                    strM756B = "[";
                }
                if (!zIsIdTokenSchemaCompliant) {
                    strM756B = AbstractC0541b.m756B(strM756B, "(ID)");
                }
                String strM756B2 = AbstractC0541b.m756B(strM756B, "]");
                Logger.warn(AbstractC0541b.m756B(str, ":save"), "Skipping persistence of non-compliant credentials: " + strM756B2);
            }
            return cacheRecordBuilderBuilder.build();
        }
        throw new NullPointerException("idTokenToSave is marked non-null but is null");
    }
}
