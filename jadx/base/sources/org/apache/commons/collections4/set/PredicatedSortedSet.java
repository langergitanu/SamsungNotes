package org.apache.commons.collections4.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicatedSortedSet<E> extends PredicatedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -9110948148132275052L;

    public PredicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        super(sortedSet, predicate);
    }

    public static <E> PredicatedSortedSet<E> predicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return new PredicatedSortedSet<>(sortedSet, predicate);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return decorated().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return decorated().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e) {
        return new PredicatedSortedSet(decorated().headSet(e), this.predicate);
    }

    @Override // java.util.SortedSet
    public E last() {
        return decorated().last();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e, E e2) {
        return new PredicatedSortedSet(decorated().subSet(e, e2), this.predicate);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e) {
        return new PredicatedSortedSet(decorated().tailSet(e), this.predicate);
    }

    @Override // org.apache.commons.collections4.set.PredicatedSet, org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public SortedSet<E> decorated() {
        return (SortedSet) super.decorated();
    }
}
