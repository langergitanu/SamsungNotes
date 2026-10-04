package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractBagDecorator extends AbstractCollectionDecorator implements Bag {
    public AbstractBagDecorator() {
    }

    @Override // org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        return getBag().add(obj, i);
    }

    public Bag getBag() {
        return (Bag) getCollection();
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
        return getBag().uniqueSet();
    }

    public AbstractBagDecorator(Bag bag) {
        super(bag);
    }
}
