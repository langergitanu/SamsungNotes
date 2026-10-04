package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.set.UnmodifiableSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class UnmodifiableSortedMap extends AbstractSortedMapDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = 5805344239827376360L;

    private UnmodifiableSortedMap(SortedMap sortedMap) {
        super(sortedMap);
    }

    public static SortedMap decorate(SortedMap sortedMap) {
        return sortedMap instanceof Unmodifiable ? sortedMap : new UnmodifiableSortedMap(sortedMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public Comparator comparator() {
        return getSortedMap().comparator();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set entrySet() {
        return UnmodifiableEntrySet.decorate(super.entrySet());
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public Object firstKey() {
        return getSortedMap().firstKey();
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return new UnmodifiableSortedMap(getSortedMap().headMap(obj));
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set keySet() {
        return UnmodifiableSet.decorate(super.keySet());
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections.BidiMap
    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return new UnmodifiableSortedMap(getSortedMap().subMap(obj, obj2));
    }

    @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return new UnmodifiableSortedMap(getSortedMap().tailMap(obj));
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Collection values() {
        return UnmodifiableCollection.decorate(super.values());
    }
}
