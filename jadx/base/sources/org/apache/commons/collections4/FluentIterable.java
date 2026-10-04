package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.iterators.SingletonIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FluentIterable<E> implements Iterable<E> {
    private final Iterable<E> iterable;

    public FluentIterable() {
        this.iterable = this;
    }

    public static <T> FluentIterable<T> empty() {
        return IterableUtils.EMPTY_ITERABLE;
    }

    /* JADX INFO: renamed from: of */
    public static <T> FluentIterable<T> m14531of(Iterable<T> iterable) {
        Objects.requireNonNull(iterable, "iterable");
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new FluentIterable<>(iterable);
    }

    public boolean allMatch(Predicate<? super E> predicate) {
        return IterableUtils.matchesAll(this.iterable, predicate);
    }

    public boolean anyMatch(Predicate<? super E> predicate) {
        return IterableUtils.matchesAny(this.iterable, predicate);
    }

    public FluentIterable<E> append(E... eArr) {
        return append(Arrays.asList(eArr));
    }

    public Enumeration<E> asEnumeration() {
        return IteratorUtils.asEnumeration(iterator());
    }

    public FluentIterable<E> collate(Iterable<? extends E> iterable) {
        return m14531of(IterableUtils.collatedIterable(this.iterable, iterable));
    }

    public boolean contains(Object obj) {
        return IterableUtils.contains(this.iterable, obj);
    }

    public void copyInto(Collection<? super E> collection) {
        Objects.requireNonNull(collection, "collection");
        CollectionUtils.addAll(collection, this.iterable);
    }

    public FluentIterable<E> eval() {
        return m14531of((Iterable) toList());
    }

    public FluentIterable<E> filter(Predicate<? super E> predicate) {
        return m14531of(IterableUtils.filteredIterable(this.iterable, predicate));
    }

    public void forEach(Closure<? super E> closure) {
        IterableUtils.forEach(this.iterable, closure);
    }

    public E get(int i) {
        return (E) IterableUtils.get(this.iterable, i);
    }

    public boolean isEmpty() {
        return IterableUtils.isEmpty(this.iterable);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return this.iterable.iterator();
    }

    public FluentIterable<E> limit(long j) {
        return m14531of(IterableUtils.boundedIterable(this.iterable, j));
    }

    public FluentIterable<E> loop() {
        return m14531of(IterableUtils.loopingIterable(this.iterable));
    }

    public FluentIterable<E> reverse() {
        return m14531of(IterableUtils.reversedIterable(this.iterable));
    }

    public int size() {
        return IterableUtils.size(this.iterable);
    }

    public FluentIterable<E> skip(long j) {
        return m14531of(IterableUtils.skippingIterable(this.iterable, j));
    }

    public E[] toArray(Class<E> cls) {
        return (E[]) IteratorUtils.toArray(iterator(), cls);
    }

    public List<E> toList() {
        return IterableUtils.toList(this.iterable);
    }

    public String toString() {
        return IterableUtils.toString(this.iterable);
    }

    public <O> FluentIterable<O> transform(Transformer<? super E, ? extends O> transformer) {
        return m14531of(IterableUtils.transformedIterable(this.iterable, transformer));
    }

    public FluentIterable<E> unique() {
        return m14531of(IterableUtils.uniqueIterable(this.iterable));
    }

    public FluentIterable<E> unmodifiable() {
        return m14531of(IterableUtils.unmodifiableIterable(this.iterable));
    }

    public FluentIterable<E> zip(Iterable<? extends E> iterable) {
        return m14531of(IterableUtils.zippingIterable(this.iterable, iterable));
    }

    public FluentIterable<E> append(Iterable<? extends E> iterable) {
        return m14531of(IterableUtils.chainedIterable(this.iterable, iterable));
    }

    public FluentIterable<E> collate(Iterable<? extends E> iterable, Comparator<? super E> comparator) {
        return m14531of(IterableUtils.collatedIterable(comparator, this.iterable, iterable));
    }

    public FluentIterable<E> zip(Iterable<? extends E>... iterableArr) {
        return m14531of(IterableUtils.zippingIterable(this.iterable, iterableArr));
    }

    private FluentIterable(Iterable<E> iterable) {
        this.iterable = iterable;
    }

    /* JADX INFO: renamed from: of */
    public static <T> FluentIterable<T> m14532of(T t) {
        return m14531of(IteratorUtils.asIterable(new SingletonIterator(t, false)));
    }

    /* JADX INFO: renamed from: of */
    public static <T> FluentIterable<T> m14533of(T... tArr) {
        return m14531of((Iterable) Arrays.asList(tArr));
    }
}
