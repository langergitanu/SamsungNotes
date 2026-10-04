package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EmptyOrderedMapIterator<K, V> extends AbstractEmptyMapIterator<K, V> implements OrderedMapIterator<K, V> {
    public static final OrderedMapIterator INSTANCE = new EmptyOrderedMapIterator();

    public static <K, V> OrderedMapIterator<K, V> emptyOrderedMapIterator() {
        return INSTANCE;
    }
}
