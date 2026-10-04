package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@DoNotMock("Use CacheBuilder.newBuilder().build()")
@ElementTypesAreNonnullByDefault
@GwtCompatible
public interface Cache<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    @CanIgnoreReturnValue
    V get(K k, Callable<? extends V> callable);

    ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable);

    @CanIgnoreReturnValue
    @CheckForNull
    V getIfPresent(@CompatibleWith("K") Object obj);

    void invalidate(@CompatibleWith("K") Object obj);

    void invalidateAll();

    void invalidateAll(Iterable<? extends Object> iterable);

    void put(K k, V v);

    void putAll(Map<? extends K, ? extends V> map);

    long size();

    CacheStats stats();
}
