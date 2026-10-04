package org.apache.commons.collections4;

import java.util.Comparator;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SortedBidiMap<K, V> extends OrderedBidiMap<K, V>, SortedMap<K, V> {
    @Override // org.apache.commons.collections4.OrderedBidiMap, org.apache.commons.collections4.BidiMap
    SortedBidiMap<V, K> inverseBidiMap();

    Comparator<? super V> valueComparator();
}
