package com.microsoft.identity.common.java.result;

import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import java.util.Date;
import java.util.List;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ILocalAuthenticationResult {
    @NonNull
    String getAccessToken();

    @NonNull
    AccessTokenRecord getAccessTokenRecord();

    @NonNull
    IAccountRecord getAccountRecord();

    List<ICacheRecord> getCacheRecordWithTenantProfileData();

    String getCorrelationId();

    @NonNull
    Date getExpiresOn();

    String getFamilyId();

    String getIdToken();

    @NonNull
    String getRefreshToken();

    String getRefreshTokenAge();

    @NonNull
    String[] getScope();

    String getSpeRing();

    String getTenantId();

    @NonNull
    String getUniqueId();

    boolean isServicedFromCache();
}
