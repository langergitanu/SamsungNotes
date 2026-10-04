package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedMap;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
abstract class ImmutableSortedMapFauxverideShim<K, V> extends ImmutableMap<K, V> {
    @DoNotCall("Use naturalOrder")
    @Deprecated
    public static <K, V> ImmutableSortedMap.Builder<K, V> builder() {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Use naturalOrder (which does not accept an expected size)")
    @Deprecated
    public static <K, V> ImmutableSortedMap.Builder<K, V> builderWithExpectedSize(int i) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass a key of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4375of(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("ImmutableSortedMap.ofEntries not currently available; use ImmutableSortedMap.copyOf")
    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4376of(K k, V v, K k2, V v4) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4377of(K k, V v, K k2, V v4, K k3, V v5) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4378of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4379of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4380of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4381of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8, K k7, V v9) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4382of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8, K k7, V v9, K k8, V v10) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4383of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8, K k7, V v9, K k8, V v10, K k9, V v11) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass keys of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <K, V> ImmutableSortedMap<K, V> m4384of(K k, V v, K k2, V v4, K k3, V v5, K k4, V v6, K k5, V v7, K k6, V v8, K k7, V v9, K k8, V v10, K k9, V v11, K k10, V v12) {
        throw new UnsupportedOperationException();
    }
}
