package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICacheRecord {
    AccessTokenRecord getAccessToken();

    AccountRecord getAccount();

    IdTokenRecord getIdToken();

    RefreshTokenRecord getRefreshToken();

    IdTokenRecord getV1IdToken();
}
