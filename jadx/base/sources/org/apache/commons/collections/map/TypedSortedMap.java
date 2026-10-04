package org.apache.commons.collections.map;

import java.util.SortedMap;
import org.apache.commons.collections.functors.InstanceofPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TypedSortedMap {
    public static SortedMap decorate(SortedMap sortedMap, Class cls, Class cls2) {
        return new PredicatedSortedMap(sortedMap, InstanceofPredicate.getInstance(cls), InstanceofPredicate.getInstance(cls2));
    }
}
