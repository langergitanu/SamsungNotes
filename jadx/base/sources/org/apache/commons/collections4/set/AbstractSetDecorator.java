package org.apache.commons.collections4.set;

import java.util.Set;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractSetDecorator<E> extends AbstractCollectionDecorator<E> implements Set<E> {
    private static final long serialVersionUID = -4678668309576958546L;

    public AbstractSetDecorator() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return decorated().hashCode();
    }

    public AbstractSetDecorator(Set<E> set) {
        super(set);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public Set<E> decorated() {
        return (Set) super.decorated();
    }
}
