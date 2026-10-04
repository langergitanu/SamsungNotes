package org.apache.commons.collections4.iterators;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractEmptyMapIterator<K, V> extends AbstractEmptyIterator<K> {
    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator
    @Deprecated
    public /* bridge */ /* synthetic */ void add(Object obj) {
        super.add(obj);
    }

    public K getKey() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public V getValue() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ boolean hasNext() {
        return super.hasNext();
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator
    public /* bridge */ /* synthetic */ boolean hasPrevious() {
        return super.hasPrevious();
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return super.next();
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator
    public /* bridge */ /* synthetic */ int nextIndex() {
        return super.nextIndex();
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator
    public /* bridge */ /* synthetic */ Object previous() {
        return super.previous();
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator
    public /* bridge */ /* synthetic */ int previousIndex() {
        return super.previousIndex();
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator, org.apache.commons.collections4.ResettableIterator
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator
    public /* bridge */ /* synthetic */ void set(Object obj) {
        super.set(obj);
    }

    public V setValue(V v) {
        throw new IllegalStateException("Iterator contains no elements");
    }
}
