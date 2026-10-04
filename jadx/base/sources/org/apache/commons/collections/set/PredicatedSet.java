package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.collection.PredicatedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicatedSet extends PredicatedCollection implements Set {
    private static final long serialVersionUID = -684521469108685117L;

    public PredicatedSet(Set set, Predicate predicate) {
        super(set, predicate);
    }

    public static Set decorate(Set set, Predicate predicate) {
        return new PredicatedSet(set, predicate);
    }

    public Set getSet() {
        return (Set) getCollection();
    }
}
