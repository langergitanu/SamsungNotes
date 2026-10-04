package org.apache.commons.collections4.set;

import java.util.Iterator;
import java.util.NavigableSet;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedNavigableSet<E> extends TransformedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 20150528;

    public TransformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        super(navigableSet, transformer);
    }

    public static <E> TransformedNavigableSet<E> transformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        TransformedNavigableSet<E> transformedNavigableSet = new TransformedNavigableSet<>(navigableSet, transformer);
        if (!navigableSet.isEmpty()) {
            Object[] array = navigableSet.toArray();
            navigableSet.clear();
            for (Object obj : array) {
                transformedNavigableSet.decorated().add(transformer.apply(obj));
            }
        }
        return transformedNavigableSet;
    }

    public static <E> TransformedNavigableSet<E> transformingNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        return new TransformedNavigableSet<>(navigableSet, transformer);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return decorated().ceiling(e);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return decorated().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return transformingNavigableSet(decorated().descendingSet(), this.transformer);
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return decorated().floor(e);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E e, boolean z) {
        return transformingNavigableSet(decorated().headSet(e, z), this.transformer);
    }

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return decorated().higher(e);
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return decorated().lower(e);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        return decorated().pollFirst();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        return decorated().pollLast();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        return transformingNavigableSet(decorated().subSet(e, z, e2, z2), this.transformer);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E e, boolean z) {
        return transformingNavigableSet(decorated().tailSet(e, z), this.transformer);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public NavigableSet<E> decorated() {
        return (NavigableSet) super.decorated();
    }
}
