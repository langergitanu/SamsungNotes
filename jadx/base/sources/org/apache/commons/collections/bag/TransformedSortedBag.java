package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedSortedBag extends TransformedBag implements SortedBag {
    private static final long serialVersionUID = -251737742649401930L;

    public TransformedSortedBag(SortedBag sortedBag, Transformer transformer) {
        super(sortedBag, transformer);
    }

    public static SortedBag decorate(SortedBag sortedBag, Transformer transformer) {
        return new TransformedSortedBag(sortedBag, transformer);
    }

    @Override // org.apache.commons.collections.SortedBag
    public Comparator comparator() {
        return getSortedBag().comparator();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object first() {
        return getSortedBag().first();
    }

    public SortedBag getSortedBag() {
        return (SortedBag) this.collection;
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object last() {
        return getSortedBag().last();
    }
}
