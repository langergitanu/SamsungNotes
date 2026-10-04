package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.UUID;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultStateGenerator implements IStateGenerator {
    @Override // com.microsoft.identity.common.java.providers.oauth2.IStateGenerator
    @NonNull
    public String generate() {
        return UUID.randomUUID().toString() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + UUID.randomUUID().toString();
    }
}
