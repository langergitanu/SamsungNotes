package com.nimbusds.jose.jwk.source;

import com.nimbusds.jose.jwk.JWKSet;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import net.jcip.annotations.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
@ThreadSafe
public class DefaultJWKSetCache implements JWKSetCache {
    public static final long DEFAULT_LIFESPAN_MINUTES = 15;
    public static final long DEFAULT_REFRESH_TIME_MINUTES = 5;
    private volatile JWKSetWithTimestamp jwkSetWithTimestamp;
    private final long lifespan;
    private final long refreshTime;
    private final TimeUnit timeUnit;

    public DefaultJWKSetCache() {
        this(15L, 5L, TimeUnit.MINUTES);
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetCache
    public JWKSet get() {
        if (this.jwkSetWithTimestamp == null || isExpired()) {
            return null;
        }
        return this.jwkSetWithTimestamp.getJWKSet();
    }

    public long getLifespan(TimeUnit timeUnit) {
        long j = this.lifespan;
        return j < 0 ? j : timeUnit.convert(j, this.timeUnit);
    }

    public long getPutTimestamp() {
        if (this.jwkSetWithTimestamp != null) {
            return this.jwkSetWithTimestamp.getDate().getTime();
        }
        return -1L;
    }

    public long getRefreshTime(TimeUnit timeUnit) {
        long j = this.refreshTime;
        return j < 0 ? j : timeUnit.convert(j, this.timeUnit);
    }

    public boolean isExpired() {
        if (this.jwkSetWithTimestamp == null || this.lifespan <= -1) {
            return false;
        }
        return new Date().getTime() > TimeUnit.MILLISECONDS.convert(this.lifespan, this.timeUnit) + this.jwkSetWithTimestamp.getDate().getTime();
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetCache
    public void put(JWKSet jWKSet) {
        this.jwkSetWithTimestamp = jWKSet != null ? new JWKSetWithTimestamp(jWKSet) : null;
    }

    @Override // com.nimbusds.jose.jwk.source.JWKSetCache
    public boolean requiresRefresh() {
        if (this.jwkSetWithTimestamp == null || this.refreshTime <= -1) {
            return false;
        }
        return new Date().getTime() > TimeUnit.MILLISECONDS.convert(this.refreshTime, this.timeUnit) + this.jwkSetWithTimestamp.getDate().getTime();
    }

    public DefaultJWKSetCache(long j, long j2, TimeUnit timeUnit) {
        this.lifespan = j;
        this.refreshTime = j2;
        if ((j > -1 || j2 > -1) && timeUnit == null) {
            throw new IllegalArgumentException("A time unit must be specified for non-negative lifespans or refresh times");
        }
        this.timeUnit = timeUnit;
    }
}
