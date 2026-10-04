package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public interface SortedMultiset<E> extends SortedMultisetBridge<E>, SortedIterable<E> {
    Comparator<? super E> comparator();

    SortedMultiset<E> descendingMultiset();

    @Override // com.google.common.collect.SortedMultisetBridge, com.google.common.collect.Multiset
    NavigableSet<E> elementSet();

    @Override // com.google.common.collect.Multiset
    Set<Multiset.Entry<E>> entrySet();

    @CheckForNull
    Multiset.Entry<E> firstEntry();

    SortedMultiset<E> headMultiset(@ParametricNullness E e, BoundType boundType);

    @Override // com.google.common.collect.Multiset, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @CheckForNull
    Multiset.Entry<E> lastEntry();

    @CheckForNull
    Multiset.Entry<E> pollFirstEntry();

    @CheckForNull
    Multiset.Entry<E> pollLastEntry();

    SortedMultiset<E> subMultiset(@ParametricNullness E e, BoundType boundType, @ParametricNullness E e2, BoundType boundType2);

    SortedMultiset<E> tailMultiset(@ParametricNullness E e, BoundType boundType);
}
