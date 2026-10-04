package com.microsoft.identity.common.java.result;

import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.telemetry.ITelemetryAccessor;
import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class LocalAuthenticationResult implements ILocalAuthenticationResult, ITelemetryAccessor {
    private static final String TAG = "LocalAuthenticationResult";
    private final AccessTokenRecord mAccessTokenRecord;
    private final IAccountRecord mAccountRecord;
    private List<ICacheRecord> mCompleteResultFromCache;
    private String mCorrelationId;
    private String mFamilyId;
    private String mRawIdToken;
    private String mRefreshToken;
    private String mRefreshTokenAge;
    private boolean mServicedFromCache;
    private String mSpeRing;
    private final List<Map<String, String>> mTelemetry;

    public LocalAuthenticationResult(@NonNull ICacheRecord iCacheRecord, @NonNull List<ICacheRecord> list, @NonNull SdkType sdkType, boolean z) {
        this(iCacheRecord, sdkType);
        if (iCacheRecord == null) {
            throw new NullPointerException("lastAuthorized is marked non-null but is null");
        }
        if (list == null) {
            throw new NullPointerException("completeResultFromCache is marked non-null but is null");
        }
        if (sdkType == null) {
            throw new NullPointerException("sdkType is marked non-null but is null");
        }
        this.mCompleteResultFromCache = list;
        this.mServicedFromCache = z;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @NonNull
    public String getAccessToken() {
        return this.mAccessTokenRecord.getSecret();
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @NonNull
    public AccessTokenRecord getAccessTokenRecord() {
        return this.mAccessTokenRecord;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @NonNull
    public IAccountRecord getAccountRecord() {
        return this.mAccountRecord;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    public List<ICacheRecord> getCacheRecordWithTenantProfileData() {
        return this.mCompleteResultFromCache;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @Nullable
    public String getCorrelationId() {
        return this.mCorrelationId;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @NonNull
    public Date getExpiresOn() {
        return new Date(TimeUnit.SECONDS.toMillis(Long.parseLong(this.mAccessTokenRecord.getExpiresOn())));
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @Nullable
    public String getFamilyId() {
        return this.mFamilyId;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @Nullable
    public String getIdToken() {
        return this.mRawIdToken;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @NonNull
    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @Nullable
    public String getRefreshTokenAge() {
        return this.mRefreshTokenAge;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @NonNull
    public String[] getScope() {
        return this.mAccessTokenRecord.getTarget().split("\\s");
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @Nullable
    public String getSpeRing() {
        return this.mSpeRing;
    }

    @Override // com.microsoft.identity.common.java.telemetry.ITelemetryAccessor
    public List<Map<String, String>> getTelemetry() {
        return this.mTelemetry;
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @Nullable
    public String getTenantId() {
        return this.mAccessTokenRecord.getRealm();
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    @NonNull
    public String getUniqueId() {
        return this.mAccessTokenRecord.getHomeAccountId();
    }

    @Override // com.microsoft.identity.common.java.result.ILocalAuthenticationResult
    public boolean isServicedFromCache() {
        return this.mServicedFromCache;
    }

    public void setCorrelationId(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        this.mCorrelationId = str;
    }

    public void setRefreshTokenAge(String str) {
        this.mRefreshTokenAge = str;
    }

    public void setSpeRing(String str) {
        this.mSpeRing = str;
    }

    public void setTelemetry(@NonNull List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("telemetry is marked non-null but is null");
        }
        this.mTelemetry.addAll(list);
    }

    private LocalAuthenticationResult(@NonNull ICacheRecord iCacheRecord, @NonNull SdkType sdkType) {
        IdTokenRecord idToken;
        this.mTelemetry = new ArrayList();
        if (iCacheRecord == null) {
            throw new NullPointerException("cacheRecord is marked non-null but is null");
        }
        if (sdkType != null) {
            AccessTokenRecord accessToken = iCacheRecord.getAccessToken();
            this.mAccessTokenRecord = accessToken;
            AccountRecord account = iCacheRecord.getAccount();
            this.mAccountRecord = account;
            if (iCacheRecord.getRefreshToken() != null) {
                this.mRefreshToken = iCacheRecord.getRefreshToken().getSecret();
            }
            if (sdkType == SdkType.ADAL) {
                idToken = iCacheRecord.getV1IdToken();
            } else {
                idToken = iCacheRecord.getIdToken();
            }
            if (idToken != null) {
                this.mRawIdToken = idToken.getSecret();
                Logger.info(TAG, "Id Token type: " + idToken.getCredentialType());
            } else if (iCacheRecord.getV1IdToken() != null) {
                Logger.info(TAG, "V1 Id Token returned here, ");
                this.mRawIdToken = iCacheRecord.getV1IdToken().getSecret();
            }
            String str = TAG;
            StringBuilder sb = new StringBuilder("Constructing LocalAuthentication result, AccessTokenRecord null: ");
            sb.append(accessToken == null);
            sb.append(", AccountRecord null: ");
            sb.append(account == null);
            sb.append(", RefreshTokenRecord null or empty: ");
            sb.append(StringUtil.isNullOrEmpty(this.mRefreshToken));
            sb.append(", IdTokenRecord null: ");
            sb.append(idToken == null);
            Logger.info(str, sb.toString());
            return;
        }
        throw new NullPointerException("sdkType is marked non-null but is null");
    }
}
