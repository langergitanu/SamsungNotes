package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedSet;
import com.google.errorprone.annotations.DoNotCall;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
abstract class ImmutableSortedSetFauxverideShim<E> extends ImmutableSet<E> {
    @DoNotCall("Use naturalOrder")
    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Use naturalOrder (which does not accept an expected size)")
    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builderWithExpectedSize(int i) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    public static <E> ImmutableSortedSet<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass a parameter of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedSet<E> m4405of(E e) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedSet<E> m4406of(E e, E e2) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedSet<E> m4407of(E e, E e2, E e3) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedSet<E> m4408of(E e, E e2, E e3, E e5) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedSet<E> m4409of(E e, E e2, E e3, E e5, E e6) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Pass parameters of type Comparable")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedSet<E> m4410of(E e, E e2, E e3, E e5, E e6, E e7, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
