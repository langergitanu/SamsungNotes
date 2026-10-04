package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.errorprone.annotations.DoNotCall;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
abstract class ImmutableSortedMultisetFauxverideShim<E> extends ImmutableMultiset<E> {
    @DoNotCall("Use naturalOrder.")
    @Deprecated
    public static <E> ImmutableSortedMultiset.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    public static <E> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4392of(E e) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4393of(E e, E e2) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4394of(E e, E e2, E e3) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4395of(E e, E e2, E e3, E e5) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4396of(E e, E e2, E e3, E e5, E e6) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Elements must be Comparable. (Or, pass a Comparator to orderedBy or copyOf.)")
    @Deprecated
    /* JADX INFO: renamed from: of */
    public static <E> ImmutableSortedMultiset<E> m4397of(E e, E e2, E e3, E e5, E e6, E e7, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
