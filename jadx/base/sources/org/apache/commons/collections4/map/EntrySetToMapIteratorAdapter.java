package org.apache.commons.collections4.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EntrySetToMapIteratorAdapter<K, V> implements MapIterator<K, V>, ResettableIterator<K> {
    transient Map.Entry<K, V> entry;
    final Set<Map.Entry<K, V>> entrySet;
    transient Iterator<Map.Entry<K, V>> iterator;

    public EntrySetToMapIteratorAdapter(Set<Map.Entry<K, V>> set) {
        this.entrySet = set;
        reset();
    }

    public synchronized Map.Entry<K, V> current() {
        Map.Entry<K, V> entry;
        entry = this.entry;
        if (entry == null) {
            throw new IllegalStateException();
        }
        return entry;
    }

    @Override // org.apache.commons.collections4.MapIterator
    public K getKey() {
        return current().getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V getValue() {
        return current().getValue();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public K next() {
        this.entry = this.iterator.next();
        return getKey();
    }

    @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
        this.entry = null;
    }

    public synchronized void reset() {
        this.iterator = this.entrySet.iterator();
    }

    @Override // org.apache.commons.collections4.MapIterator
    public V setValue(V v) {
        return current().setValue(v);
    }
}
