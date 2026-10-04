package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jose.util.cache.CachedObject;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ThreadSafe
abstract class AbstractCachingJWKSetSource<C extends SecurityContext> extends JWKSetSourceWrapper<C> {
    private volatile CachedObject<JWKSet> cachedJWKSet;
    private final long timeToLive;

    public AbstractCachingJWKSetSource(JWKSetSource<C> jWKSetSource, long j) {
        super(jWKSetSource);
        this.timeToLive = j;
    }

    public CachedObject<JWKSet> cacheJWKSet(JWKSet jWKSet, long j) {
        CachedObject<JWKSet> cachedObject = new CachedObject<>(jWKSet, currentTimeMillis(), CachedObject.computeExpirationTime(j, getTimeToLive()));
        setCachedJWKSet(cachedObject);
        return cachedObject;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public CachedObject<JWKSet> getCachedJWKSet() {
        return this.cachedJWKSet;
    }

    public CachedObject<JWKSet> getCachedJWKSetIfValid(long j) {
        CachedObject<JWKSet> cachedJWKSet = getCachedJWKSet();
        if (cachedJWKSet == null || !cachedJWKSet.isValid(j)) {
            return null;
        }
        return cachedJWKSet;
    }

    public long getTimeToLive() {
        return this.timeToLive;
    }

    public void setCachedJWKSet(CachedObject<JWKSet> cachedObject) {
        this.cachedJWKSet = cachedObject;
    }
}
