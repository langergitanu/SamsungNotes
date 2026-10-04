package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.SortedBag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractSortedBagDecorator extends AbstractBagDecorator implements SortedBag {
    public AbstractSortedBagDecorator() {
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
        return (SortedBag) getCollection();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object last() {
        return getSortedBag().last();
    }

    public AbstractSortedBagDecorator(SortedBag sortedBag) {
        super(sortedBag);
    }
}
