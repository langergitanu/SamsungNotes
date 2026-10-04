package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.set.TransformedSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedBag<E> extends TransformedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 5421170911299074185L;

    public TransformedBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        super(bag, transformer);
    }

    public static <E> Bag<E> transformedBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        TransformedBag transformedBag = new TransformedBag(bag, transformer);
        if (!bag.isEmpty()) {
            Object[] array = bag.toArray();
            bag.clear();
            for (Object obj : array) {
                transformedBag.decorated().add(transformer.apply(obj));
            }
        }
        return transformedBag;
    }

    public static <E> Bag<E> transformingBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        return new TransformedBag(bag, transformer);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        return getBag().add(transform(e), i);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    public Bag<E> getBag() {
        return (Bag) decorated();
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        return getBag().getCount(obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i) {
        return getBag().remove(obj, i);
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        return TransformedSet.transformingSet(getBag().uniqueSet(), this.transformer);
    }
}
