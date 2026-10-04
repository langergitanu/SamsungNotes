package com.microsoft.identity.client;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class AuthenticationResult implements IAuthenticationResult {
    private static final String TAG = "AuthenticationResult";
    private final AccessTokenRecord mAccessToken;
    private final IAccount mAccount;
    private final UUID mCorrelationId;
    private final String mTenantId;

    public AuthenticationResult(@NonNull List<ICacheRecord> list, @Nullable String str) {
        ICacheRecord iCacheRecord = list.get(0);
        this.mAccessToken = iCacheRecord.getAccessToken();
        this.mTenantId = iCacheRecord.getAccount().getRealm();
        this.mAccount = AccountAdapter.adapt(list).get(0);
        this.mCorrelationId = sanitizeCorrelationId(str);
    }

    @Nullable
    private UUID sanitizeCorrelationId(@Nullable String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":sanitizeCorrelationId", new StringBuilder());
        if (TextUtils.isEmpty(str)) {
            com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Correlation id was empty, returning null.");
            return null;
        }
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            com.microsoft.identity.common.logging.Logger.error(strM1170p, "Correlation id is not a valid UUID.", e);
            return null;
        }
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    @NonNull
    public String getAccessToken() {
        return this.mAccessToken.getSecret();
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    @NonNull
    public IAccount getAccount() {
        return this.mAccount;
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    @NonNull
    public String getAuthenticationScheme() {
        return this.mAccessToken.getAccessTokenType();
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    @NonNull
    public String getAuthorizationHeader() {
        StringBuilder sbM781w = AbstractC0541b.m781w(this.mAccessToken.getAccessTokenType(), " ");
        sbM781w.append(this.mAccessToken.getSecret());
        return sbM781w.toString();
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    @Nullable
    public UUID getCorrelationId() {
        return this.mCorrelationId;
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    @NonNull
    public Date getExpiresOn() {
        return new Date(TimeUnit.SECONDS.toMillis(Long.parseLong(this.mAccessToken.getExpiresOn())));
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    @NonNull
    public String[] getScope() {
        return this.mAccessToken.getTarget().split("\\s");
    }

    @Override // com.microsoft.identity.client.IAuthenticationResult
    @Nullable
    public String getTenantId() {
        return this.mTenantId;
    }
}
