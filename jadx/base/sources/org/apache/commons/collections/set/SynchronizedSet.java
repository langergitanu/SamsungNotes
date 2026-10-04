package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.collection.SynchronizedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SynchronizedSet extends SynchronizedCollection implements Set {
    private static final long serialVersionUID = -8304417378626543635L;

    public SynchronizedSet(Set set) {
        super(set);
    }

    public static Set decorate(Set set) {
        return new SynchronizedSet(set);
    }

    public Set getSet() {
        return (Set) this.collection;
    }

    public SynchronizedSet(Set set, Object obj) {
        super(set, obj);
    }
}
