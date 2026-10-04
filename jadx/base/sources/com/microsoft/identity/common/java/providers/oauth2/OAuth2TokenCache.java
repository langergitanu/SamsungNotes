package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.cache.AccountDeletionRecord;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.List;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class OAuth2TokenCache<T extends OAuth2Strategy, U extends AuthorizationRequest, V extends TokenResponse> {
    public static final String ERR_UNSUPPORTED_OPERATION = "This method is unsupported.";

    @NonNull
    private final IPlatformComponents mPlatformComponents;

    public OAuth2TokenCache(@NonNull IPlatformComponents iPlatformComponents) {
        if (iPlatformComponents == null) {
            throw new NullPointerException("mPlatformComponents is marked non-null but is null");
        }
        this.mPlatformComponents = iPlatformComponents;
    }

    public abstract void clearAll();

    public abstract AccountRecord getAccount(String str, String str2, String str3, String str4);

    public abstract AccountRecord getAccountByHomeAccountId(@Nullable String str, @NonNull String str2, @NonNull String str3);

    public abstract AccountRecord getAccountByLocalAccountId(String str, String str2, String str3);

    public abstract ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String str, String str2, String str3);

    public abstract List<AccountRecord> getAccounts(String str, String str2);

    public abstract List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2);

    public abstract List<ICacheRecord> getAccountsWithAggregatedAccountData(String str, String str2, String str3);

    public abstract Set<String> getAllClientIds();

    public abstract List<AccountRecord> getAllTenantAccountsForAccountByClientId(String str, AccountRecord accountRecord);

    public final IPlatformComponents getComponents() {
        return this.mPlatformComponents;
    }

    public abstract List<IdTokenRecord> getIdTokensForAccountRecord(String str, AccountRecord accountRecord);

    public abstract ICacheRecord load(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme);

    public abstract List<ICacheRecord> loadWithAggregatedAccountData(String str, String str2, String str3, String str4, AccountRecord accountRecord, AbstractAuthenticationScheme abstractAuthenticationScheme);

    public abstract AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4);

    public abstract AccountDeletionRecord removeAccount(String str, String str2, String str3, String str4, CredentialType... credentialTypeArr);

    public abstract boolean removeCredential(Credential credential);

    public abstract ICacheRecord save(AccountRecord accountRecord, IdTokenRecord idTokenRecord);

    public abstract ICacheRecord save(T t, U u, V v);

    public abstract List<ICacheRecord> saveAndLoadAggregatedAccountData(T t, U u, V v);
}
