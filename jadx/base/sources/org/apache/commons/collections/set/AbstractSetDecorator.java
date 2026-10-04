package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractSetDecorator extends AbstractCollectionDecorator implements Set {
    public AbstractSetDecorator() {
    }

    public Set getSet() {
        return (Set) getCollection();
    }

    public AbstractSetDecorator(Set set) {
        super(set);
    }
}
