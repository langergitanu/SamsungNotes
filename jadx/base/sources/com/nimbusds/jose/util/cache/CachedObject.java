package com.nimbusds.jose.util.cache;

import net.jcip.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class CachedObject<V> {
    private final long expirationTime;
    private final V object;
    private final long timestamp;

    public CachedObject(V v, long j, long j2) {
        if (v == null) {
            throw new IllegalArgumentException("The object must not be null");
        }
        this.object = v;
        this.timestamp = j;
        this.expirationTime = j2;
    }

    public static long computeExpirationTime(long j, long j2) {
        long j3 = j + j2;
        if (j3 < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    public V get() {
        return this.object;
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isExpired(long j) {
        return !isValid(j);
    }

    public boolean isValid(long j) {
        return j < this.expirationTime;
    }
}
