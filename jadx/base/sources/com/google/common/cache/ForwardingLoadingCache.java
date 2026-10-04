package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public V apply(K k) {
        return delegate().apply(k);
    }

    @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
    public abstract LoadingCache<K, V> delegate();

    @Override // com.google.common.cache.LoadingCache
    @CanIgnoreReturnValue
    public V get(K k) {
        return delegate().get(k);
    }

    @Override // com.google.common.cache.LoadingCache
    @CanIgnoreReturnValue
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) {
        return delegate().getAll(iterable);
    }

    @Override // com.google.common.cache.LoadingCache
    @CanIgnoreReturnValue
    public V getUnchecked(K k) {
        return delegate().getUnchecked(k);
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k) {
        delegate().refresh(k);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        private final LoadingCache<K, V> delegate;

        public SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.delegate = (LoadingCache) Preconditions.checkNotNull(loadingCache);
        }

        @Override // com.google.common.cache.ForwardingLoadingCache, com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public final LoadingCache<K, V> delegate() {
            return this.delegate;
        }
    }
}
