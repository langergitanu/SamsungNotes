package com.microsoft.identity.common.java.cache;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.BaseAccount;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.authscheme.AuthenticationSchemeFactory;
import com.microsoft.identity.common.java.cache.CacheRecord;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.java.providers.oauth2.TokenResponse;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MicrosoftFamilyOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends TokenResponse, GenericAccount extends BaseAccount, GenericRefreshToken extends RefreshToken> extends MsalOAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> {
    private static final String TAG = "MicrosoftFamilyOAuth2TokenCache";

    public MicrosoftFamilyOAuth2TokenCache(IPlatformComponents iPlatformComponents, IAccountCredentialCache iAccountCredentialCache, IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> iAccountCredentialAdapter) {
        super(iPlatformComponents, iAccountCredentialCache, iAccountCredentialAdapter);
    }

    public ICacheRecord loadByFamilyId(@Nullable String str, @Nullable String str2, @NonNull AccountRecord accountRecord, @Nullable AbstractAuthenticationScheme abstractAuthenticationScheme) {
        AccessTokenRecord accessTokenRecord;
        RefreshTokenRecord refreshTokenRecord;
        if (accountRecord == null) {
            throw new NullPointerException("accountRecord is marked non-null but is null");
        }
        Logger.verbose(AbstractC0622a.m1170p(TAG, ":loadByFamilyId", new StringBuilder()), "ClientId[" + str + ", 1]");
        List<Credential> credentials = getAccountCredentialCache().getCredentials();
        Iterator<Credential> it = credentials.iterator();
        while (true) {
            accessTokenRecord = null;
            if (!it.hasNext()) {
                refreshTokenRecord = null;
                break;
            }
            Credential next = it.next();
            if (next instanceof RefreshTokenRecord) {
                refreshTokenRecord = (RefreshTokenRecord) next;
                if ("1".equals(refreshTokenRecord.getFamilyId()) && accountRecord.getEnvironment().equals(refreshTokenRecord.getEnvironment()) && accountRecord.getHomeAccountId().equals(refreshTokenRecord.getHomeAccountId())) {
                    break;
                }
            }
        }
        IdTokenRecord idTokenRecord = null;
        IdTokenRecord idTokenRecord2 = null;
        for (Credential credential : credentials) {
            if (credential instanceof IdTokenRecord) {
                IdTokenRecord idTokenRecord3 = (IdTokenRecord) credential;
                if (str != null && str.equals(idTokenRecord3.getClientId()) && accountRecord.getEnvironment().equals(idTokenRecord3.getEnvironment()) && accountRecord.getHomeAccountId().equals(idTokenRecord3.getHomeAccountId()) && accountRecord.getRealm().equals(idTokenRecord3.getRealm())) {
                    if (CredentialType.V1IdToken.name().equalsIgnoreCase(idTokenRecord3.getCredentialType())) {
                        idTokenRecord2 = idTokenRecord3;
                    } else {
                        idTokenRecord = idTokenRecord3;
                    }
                }
            }
        }
        if (str2 != null && abstractAuthenticationScheme != null) {
            for (Credential credential2 : credentials) {
                if (credential2 instanceof AccessTokenRecord) {
                    AccessTokenRecord accessTokenRecord2 = (AccessTokenRecord) credential2;
                    if (str != null && str.equals(accessTokenRecord2.getClientId()) && accountRecord.getEnvironment().equals(accessTokenRecord2.getEnvironment()) && accountRecord.getHomeAccountId().equals(accessTokenRecord2.getHomeAccountId()) && accountRecord.getRealm().equals(accessTokenRecord2.getRealm()) && AbstractAccountCredentialCache.targetsIntersect(str2, accessTokenRecord2.getTarget(), true) && ((CredentialType.AccessToken.name().equalsIgnoreCase(accessTokenRecord2.getCredentialType()) && "Bearer".equalsIgnoreCase(abstractAuthenticationScheme.getName())) || (CredentialType.AccessToken_With_AuthScheme.name().equalsIgnoreCase(accessTokenRecord2.getCredentialType()) && AuthenticationSchemeFactory.isPopAuthenticationScheme(abstractAuthenticationScheme)))) {
                        accessTokenRecord = accessTokenRecord2;
                        break;
                    }
                }
            }
        }
        CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
        cacheRecordBuilderBuilder.account(accountRecord);
        cacheRecordBuilderBuilder.refreshToken(refreshTokenRecord);
        cacheRecordBuilderBuilder.accessToken(accessTokenRecord);
        cacheRecordBuilderBuilder.v1IdToken(idTokenRecord2);
        cacheRecordBuilderBuilder.idToken(idTokenRecord);
        return cacheRecordBuilderBuilder.build();
    }

    public List<ICacheRecord> loadByFamilyIdWithAggregatedAccountData(@NonNull String str, @Nullable String str2, @NonNull AccountRecord accountRecord, @Nullable AbstractAuthenticationScheme abstractAuthenticationScheme) {
        if (str == null) {
            throw new NullPointerException("clientId is marked non-null but is null");
        }
        if (accountRecord == null) {
            throw new NullPointerException("account is marked non-null but is null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(loadByFamilyId(str, str2, accountRecord, abstractAuthenticationScheme));
        ArrayList<AccountRecord> arrayList2 = new ArrayList(getAllTenantAccountsForAccountByClientId(str, accountRecord));
        String strM1170p = AbstractC0622a.m1170p(TAG, ":loadByFamilyIdWithAggregatedAccountData", new StringBuilder());
        StringBuilder sb = new StringBuilder("Found ");
        sb.append(arrayList2.size() - 1);
        sb.append(" profiles for this account");
        Logger.info(strM1170p, sb.toString());
        arrayList2.remove(0);
        if (!arrayList2.isEmpty()) {
            for (AccountRecord accountRecord2 : arrayList2) {
                CacheRecord.CacheRecordBuilder cacheRecordBuilderBuilder = CacheRecord.builder();
                cacheRecordBuilderBuilder.account(accountRecord2);
                cacheRecordBuilderBuilder.refreshToken(((ICacheRecord) arrayList.get(0)).getRefreshToken());
                for (IdTokenRecord idTokenRecord : getIdTokensForAccountRecord(str, accountRecord2)) {
                    if (CredentialType.V1IdToken.name().equalsIgnoreCase(idTokenRecord.getCredentialType())) {
                        cacheRecordBuilderBuilder.v1IdToken(idTokenRecord);
                    } else {
                        cacheRecordBuilderBuilder.idToken(idTokenRecord);
                    }
                }
                arrayList.add(cacheRecordBuilderBuilder.build());
            }
        }
        return arrayList;
    }
}
