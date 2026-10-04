package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        public Builder(int i) {
            super(i);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @DoNotCall
        @Deprecated
        public ImmutableBiMap<K, V> buildKeepingLast() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> buildOrThrow() {
            int i = this.size;
            if (i == 0) {
                return ImmutableBiMap.m4289of();
            }
            if (this.valueComparator != null) {
                if (this.entriesUsed) {
                    this.alternatingKeysAndValues = Arrays.copyOf(this.alternatingKeysAndValues, i * 2);
                }
                ImmutableMap.Builder.sortEntries(this.alternatingKeysAndValues, this.size, this.valueComparator);
            }
            this.entriesUsed = true;
            return new RegularImmutableBiMap(this.alternatingKeysAndValues, this.size);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> combine(ImmutableMap.Builder<K, V> builder) {
            super.combine((ImmutableMap.Builder) builder);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            super.orderEntriesByValue((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            super.put((Object) k, (Object) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @J2ktIncompatible
    public static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Builder<K, V> makeBuilder(int i) {
            return new Builder<>(i);
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> Builder<K, V> builderWithExpectedSize(int i) {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        return new Builder<>(i);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4289of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf((Iterable) Arrays.asList(entryArr));
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.BiMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    @J2ktIncompatible
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4290of(K k, V v) {
        CollectPreconditions.checkEntryNotNull(k, v);
        return new RegularImmutableBiMap(new Object[]{k, v}, 1);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4291of(K k, V v, K k2, V v4) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4).putAll((Iterable) iterable).build();
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4292of(K k, V v, K k2, V v4, K k3, V v5) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        CollectPreconditions.checkEntryNotNull(k3, v5);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4, k3, v5}, 3);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4293of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        CollectPreconditions.checkEntryNotNull(k3, v5);
        CollectPreconditions.checkEntryNotNull(k4, v6);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4, k3, v5, k4, v6}, 4);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4294of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        CollectPreconditions.checkEntryNotNull(k3, v5);
        CollectPreconditions.checkEntryNotNull(k4, v6);
        CollectPreconditions.checkEntryNotNull(k5, v7);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4, k3, v5, k4, v6, k5, v7}, 5);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4295of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        CollectPreconditions.checkEntryNotNull(k3, v5);
        CollectPreconditions.checkEntryNotNull(k4, v6);
        CollectPreconditions.checkEntryNotNull(k5, v7);
        CollectPreconditions.checkEntryNotNull(k6, v8);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4, k3, v5, k4, v6, k5, v7, k6, v8}, 6);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4296of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8, K k7, V v9) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        CollectPreconditions.checkEntryNotNull(k3, v5);
        CollectPreconditions.checkEntryNotNull(k4, v6);
        CollectPreconditions.checkEntryNotNull(k5, v7);
        CollectPreconditions.checkEntryNotNull(k6, v8);
        CollectPreconditions.checkEntryNotNull(k7, v9);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4, k3, v5, k4, v6, k5, v7, k6, v8, k7, v9}, 7);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4297of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8, K k7, V v9, K k8, V v10) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        CollectPreconditions.checkEntryNotNull(k3, v5);
        CollectPreconditions.checkEntryNotNull(k4, v6);
        CollectPreconditions.checkEntryNotNull(k5, v7);
        CollectPreconditions.checkEntryNotNull(k6, v8);
        CollectPreconditions.checkEntryNotNull(k7, v9);
        CollectPreconditions.checkEntryNotNull(k8, v10);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4, k3, v5, k4, v6, k5, v7, k6, v8, k7, v9, k8, v10}, 8);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4298of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8, K k7, V v9, K k8, V v10, K k9, V v11) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        CollectPreconditions.checkEntryNotNull(k3, v5);
        CollectPreconditions.checkEntryNotNull(k4, v6);
        CollectPreconditions.checkEntryNotNull(k5, v7);
        CollectPreconditions.checkEntryNotNull(k6, v8);
        CollectPreconditions.checkEntryNotNull(k7, v9);
        CollectPreconditions.checkEntryNotNull(k8, v10);
        CollectPreconditions.checkEntryNotNull(k9, v11);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4, k3, v5, k4, v6, k5, v7, k6, v8, k7, v9, k8, v10, k9, v11}, 9);
    }

    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableBiMap<K, V> m4299of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8, K k7, V v9, K k8, V v10, K k9, V v11, K k10, V v12) {
        CollectPreconditions.checkEntryNotNull(k, v);
        CollectPreconditions.checkEntryNotNull(k2, v4);
        CollectPreconditions.checkEntryNotNull(k3, v5);
        CollectPreconditions.checkEntryNotNull(k4, v6);
        CollectPreconditions.checkEntryNotNull(k5, v7);
        CollectPreconditions.checkEntryNotNull(k6, v8);
        CollectPreconditions.checkEntryNotNull(k7, v9);
        CollectPreconditions.checkEntryNotNull(k8, v10);
        CollectPreconditions.checkEntryNotNull(k9, v11);
        CollectPreconditions.checkEntryNotNull(k10, v12);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v4, k3, v5, k4, v6, k5, v7, k6, v8, k7, v9, k8, v10, k9, v11, k10, v12}, 10);
    }
}
