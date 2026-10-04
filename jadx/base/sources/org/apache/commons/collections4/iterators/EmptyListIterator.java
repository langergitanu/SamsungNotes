package org.apache.commons.collections4.iterators;

import java.util.ListIterator;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EmptyListIterator<E> extends AbstractEmptyIterator<E> implements ResettableListIterator<E> {
    public static final ListIterator INSTANCE;
    public static final ResettableListIterator RESETTABLE_INSTANCE;

    static {
        EmptyListIterator emptyListIterator = new EmptyListIterator();
        RESETTABLE_INSTANCE = emptyListIterator;
        INSTANCE = emptyListIterator;
    }

    public static <E> ListIterator<E> emptyListIterator() {
        return INSTANCE;
    }

    public static <E> ResettableListIterator<E> resettableEmptyListIterator() {
        return RESETTABLE_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator
    @Deprecated
    public /* bridge */ /* synthetic */ void add(Object obj) {
        super.add(obj);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.iterators.AbstractEmptyIterator
    public /* bridge */ /* synthetic */ void set(Object obj) {
        super.set(obj);
    }
}
