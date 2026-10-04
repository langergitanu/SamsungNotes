package org.apache.commons.collections4.multiset;

import java.util.Set;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicatedMultiSet<E> extends PredicatedCollection<E> implements MultiSet<E> {
    private static final long serialVersionUID = 20150629;

    public PredicatedMultiSet(MultiSet<E> multiSet, Predicate<? super E> predicate) {
        super(multiSet, predicate);
    }

    public static <E> PredicatedMultiSet<E> predicatedMultiSet(MultiSet<E> multiSet, Predicate<? super E> predicate) {
        return new PredicatedMultiSet<>(multiSet, predicate);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int add(E e, int i) {
        validate(e);
        return decorated().add(e, i);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        return decorated().entrySet();
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int getCount(Object obj) {
        return decorated().getCount(obj);
    }

    @Override // java.util.Collection, org.apache.commons.collections4.MultiSet
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int remove(Object obj, int i) {
        return decorated().remove(obj, i);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E e, int i) {
        validate(e);
        return decorated().setCount(e, i);
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        return decorated().uniqueSet();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public MultiSet<E> decorated() {
        return (MultiSet) super.decorated();
    }
}
