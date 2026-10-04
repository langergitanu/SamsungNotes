package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractCollectionDecorator<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 6249888059822088500L;
    private Collection<E> collection;

    public AbstractCollectionDecorator() {
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        return decorated().add(e);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return decorated().addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        decorated().clear();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return decorated().contains(obj);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean containsAll(Collection<?> collection) {
        return decorated().containsAll(collection);
    }

    public Collection<E> decorated() {
        return this.collection;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable, org.apache.commons.collections4.Bag
    public Iterator<E> iterator() {
        return decorated().iterator();
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        return decorated().remove(obj);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        return decorated().removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        return decorated().removeIf(predicate);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        return decorated().retainAll(collection);
    }

    public void setCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override // java.util.Collection
    public int size() {
        return decorated().size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return decorated().toArray();
    }

    public String toString() {
        return decorated().toString();
    }

    public AbstractCollectionDecorator(Collection<E> collection) {
        Objects.requireNonNull(collection, "collection");
        this.collection = collection;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) decorated().toArray(tArr);
    }
}
