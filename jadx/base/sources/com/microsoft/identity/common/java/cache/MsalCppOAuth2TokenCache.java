package com.microsoft.identity.common.java.cache;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MsalCppOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends TokenResponse, GenericAccount extends BaseAccount, GenericRefreshToken extends RefreshToken> extends MsalOAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> {
    private static final String TAG = "MsalCppOAuth2TokenCache";

    private MsalCppOAuth2TokenCache(IPlatformComponents iPlatformComponents, IAccountCredentialCache iAccountCredentialCache, IAccountCredentialAdapter iAccountCredentialAdapter) {
        super(iPlatformComponents, iAccountCredentialCache, iAccountCredentialAdapter);
    }

    public static MsalCppOAuth2TokenCache create(@NonNull IPlatformComponents iPlatformComponents) {
        if (iPlatformComponents != null) {
            return create(iPlatformComponents, false);
        }
        throw new NullPointerException("platformComponents is marked non-null but is null");
    }

    public void clearCache() {
        getAccountCredentialCache().clearAll();
    }

    public synchronized AccountDeletionRecord forceRemoveAccount(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        ArrayList arrayList;
        try {
            if (str == null) {
                throw new NullPointerException("homeAccountId is marked non-null but is null");
            }
            validateNonNull(str, "homeAccountId");
            boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(str2);
            boolean zIsNullOrEmpty2 = StringUtil.isNullOrEmpty(str3);
            arrayList = new ArrayList();
            for (AccountRecord accountRecord : getAllAccounts()) {
                boolean zEquals = accountRecord.getHomeAccountId().equals(str);
                boolean z = false;
                if (!zIsNullOrEmpty) {
                    zEquals = zEquals && accountRecord.getEnvironment().equals(str2);
                }
                if (!zIsNullOrEmpty2) {
                    if (zEquals && accountRecord.getRealm().equals(str3)) {
                        z = true;
                    }
                    zEquals = z;
                }
                if (zEquals && getAccountCredentialCache().removeAccount(accountRecord)) {
                    arrayList.add(accountRecord);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return new AccountDeletionRecord(arrayList);
    }

    @Nullable
    public AccountRecord getAccount(@NonNull String str, @NonNull String str2, @NonNull String str3) throws ClientException {
        if (str == null) {
            throw new NullPointerException("homeAccountId is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("environment is marked non-null but is null");
        }
        if (str3 == null) {
            throw new NullPointerException("realm is marked non-null but is null");
        }
        validateNonNull(str, "homeAccountId");
        validateNonNull(str2, "environment");
        validateNonNull(str3, "realm");
        List<AccountRecord> accountsFilteredBy = getAccountCredentialCache().getAccountsFilteredBy(str, str2, str3);
        if (accountsFilteredBy != null && !accountsFilteredBy.isEmpty()) {
            return accountsFilteredBy.get(0);
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAccount", new StringBuilder());
        StringBuilder sbM16m = AbstractC0000a.m16m("No account found for the passing in homeAccountId: ", str, " environment: ", str2, " realm: ");
        sbM16m.append(str3);
        Logger.info(strM1170p, sbM16m.toString());
        return null;
    }

    @Override // com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache
    public IAccountCredentialCache getAccountCredentialCache() {
        return super.getAccountCredentialCache();
    }

    public List<AccountRecord> getAllAccounts() {
        return Collections.unmodifiableList(getAccountCredentialCache().getAccounts());
    }

    public List<Credential> getCredentials() {
        return Collections.unmodifiableList(getAccountCredentialCache().getCredentials());
    }

    public synchronized AccountDeletionRecord removeAccount(@NonNull String str, @NonNull String str2, @NonNull String str3) throws Throwable {
        try {
            if (str == null) {
                throw new NullPointerException("homeAccountId is marked non-null but is null");
            }
            if (str2 == null) {
                throw new NullPointerException("environment is marked non-null but is null");
            }
            if (str3 == null) {
                throw new NullPointerException("realm is marked non-null but is null");
            }
            try {
                validateNonNull(str, "homeAccountId");
                validateNonNull(str2, "environment");
                validateNonNull(str3, "realm");
                String str4 = str2.equals("") ? null : str2;
                String str5 = str3.equals("") ? null : str3;
                String str6 = str4;
                List<Credential> credentialsFilteredBy = getAccountCredentialCache().getCredentialsFilteredBy(str, str6, CredentialType.RefreshToken, null, null, null, str5, null, "Bearer");
                if (credentialsFilteredBy == null || credentialsFilteredBy.isEmpty()) {
                    return forceRemoveAccount(str, str6, str5);
                }
                return removeAccount(str6, credentialsFilteredBy.get(0).getClientId(), str, str5, CredentialType.AccessToken, CredentialType.AccessToken_With_AuthScheme, CredentialType.IdToken, CredentialType.V1IdToken);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void saveAccountRecord(@NonNull AccountRecord accountRecord) {
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        getAccountCredentialCache().saveAccount(accountRecord);
    }

    public synchronized void saveCredentials(@NonNull Credential... credentialArr) {
        try {
            if (credentialArr == null) {
                throw new NullPointerException("credentials is marked non-null but is null");
            }
            if (credentialArr.length == 0) {
                throw new ClientException("Credential array passed in is null or empty");
            }
            for (Credential credential : credentialArr) {
                if ((credential instanceof AccessTokenRecord) && !isAccessTokenSchemaCompliant((AccessTokenRecord) credential)) {
                    throw new ClientException(ErrorStrings.CREDENTIAL_IS_SCHEMA_NONCOMPLIANT, "AT is missing a required property.");
                }
            }
            saveCredentialsInternal(credentialArr);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static MsalCppOAuth2TokenCache create(@NonNull IPlatformComponents iPlatformComponents, boolean z) {
        if (iPlatformComponents != null) {
            MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> msalOAuth2TokenCacheCreate = MsalOAuth2TokenCache.create(iPlatformComponents, z);
            return new MsalCppOAuth2TokenCache(iPlatformComponents, msalOAuth2TokenCacheCreate.getAccountCredentialCache(), msalOAuth2TokenCacheCreate.getAccountCredentialAdapter());
        }
        throw new NullPointerException("platformComponents is marked non-null but is null");
    }
}
