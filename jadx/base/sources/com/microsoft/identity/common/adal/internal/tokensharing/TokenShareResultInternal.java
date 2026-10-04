package com.microsoft.identity.common.adal.internal.tokensharing;

import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.cache.ICacheRecord;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TokenShareResultInternal implements ITokenShareResultInternal {
    private final ICacheRecord mCacheRecord;
    private final String mFormat;
    private final String mRefreshToken;

    public TokenShareResultInternal(@NonNull ICacheRecord iCacheRecord, @NonNull String str, @NonNull String str2) {
        this.mCacheRecord = iCacheRecord;
        this.mRefreshToken = str;
        this.mFormat = str2;
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareResultInternal
    public ICacheRecord getCacheRecord() {
        return this.mCacheRecord;
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareResultInternal
    public String getFormat() {
        return this.mFormat;
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareResultInternal
    public String getRefreshToken() {
        return this.mRefreshToken;
    }
}
