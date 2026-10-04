package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;
import org.apache.commons.collections.set.TransformedSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedBag extends TransformedCollection implements Bag {
    private static final long serialVersionUID = 5421170911299074185L;

    public TransformedBag(Bag bag, Transformer transformer) {
        super(bag, transformer);
    }

    public static Bag decorate(Bag bag, Transformer transformer) {
        return new TransformedBag(bag, transformer);
    }

    @Override // org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        return getBag().add(transform(obj), i);
    }

    public Bag getBag() {
        return (Bag) this.collection;
    }

    @Override // org.apache.commons.collections.Bag
    public int getCount(Object obj) {
        return getBag().getCount(obj);
    }

    @Override // org.apache.commons.collections.Bag
    public boolean remove(Object obj, int i) {
        return getBag().remove(obj, i);
    }

    @Override // org.apache.commons.collections.Bag
    public Set uniqueSet() {
        return TransformedSet.decorate(getBag().uniqueSet(), this.transformer);
    }
}
