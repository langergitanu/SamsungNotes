package org.apache.commons.collections4.map;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import opennlp.tools.parser.Parse;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ListOrderedMap<K, V> extends AbstractMapDecorator<K, V> implements OrderedMap<K, V>, Serializable {
    private static final long serialVersionUID = 2728177751851003750L;
    private final List<K> insertOrder;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EntrySetView<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private Set<Map.Entry<K, V>> entrySet;
        private final List<K> insertOrder;
        private final ListOrderedMap<K, V> parent;

        public EntrySetView(ListOrderedMap<K, V> listOrderedMap, List<K> list) {
            this.parent = listOrderedMap;
            this.insertOrder = list;
        }

        private Set<Map.Entry<K, V>> getEntrySet() {
            if (this.entrySet == null) {
                this.entrySet = this.parent.decorated().entrySet();
            }
            return this.entrySet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return getEntrySet().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return getEntrySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return getEntrySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return getEntrySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.parent.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new ListOrderedIterator(this.parent, this.insertOrder);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !getEntrySet().contains(obj)) {
                return false;
            }
            this.parent.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return getEntrySet().toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KeySetView<K> extends AbstractSet<K> {
        private final ListOrderedMap<K, Object> parent;

        public KeySetView(ListOrderedMap<K, ?> listOrderedMap) {
            this.parent = listOrderedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new AbstractUntypedIteratorDecorator<Map.Entry<K, Object>, K>(this.parent.entrySet().iterator()) { // from class: org.apache.commons.collections4.map.ListOrderedMap.KeySetView.1
                @Override // java.util.Iterator
                public K next() {
                    return getIterator().next().getKey();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListOrderedIterator<K, V> extends AbstractUntypedIteratorDecorator<K, Map.Entry<K, V>> {
        private K last;
        private final ListOrderedMap<K, V> parent;

        public ListOrderedIterator(ListOrderedMap<K, V> listOrderedMap, List<K> list) {
            super(list.iterator());
            this.parent = listOrderedMap;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.parent.decorated().remove(this.last);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            K next = getIterator().next();
            this.last = next;
            return new ListOrderedMapEntry(this.parent, next);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListOrderedMapEntry<K, V> extends AbstractMapEntry<K, V> {
        private final ListOrderedMap<K, V> parent;

        public ListOrderedMapEntry(ListOrderedMap<K, V> listOrderedMap, K k) {
            super(k, null);
            this.parent = listOrderedMap;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractKeyValue, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.parent.get(getKey());
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
        public V setValue(V v) {
            return this.parent.decorated().put(getKey(), v);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListOrderedMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private ListIterator<K> iterator;
        private K last;
        private final ListOrderedMap<K, V> parent;
        private boolean readable;

        public ListOrderedMapIterator(ListOrderedMap<K, V> listOrderedMap) {
            this.parent = listOrderedMap;
            this.iterator = ((ListOrderedMap) listOrderedMap).insertOrder.listIterator();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (this.readable) {
                return this.last;
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.readable) {
                return this.parent.get(this.last);
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            K next = this.iterator.next();
            this.last = next;
            this.readable = true;
            return next;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            K kPrevious = this.iterator.previous();
            this.last = kPrevious;
            this.readable = true;
            return kPrevious;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            if (!this.readable) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.iterator.remove();
            this.parent.map.remove(this.last);
            this.readable = false;
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.iterator = ((ListOrderedMap) this.parent).insertOrder.listIterator();
            this.last = null;
            this.readable = false;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            if (this.readable) {
                return this.parent.map.put(this.last, v);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (!this.readable) {
                return "Iterator[]";
            }
            StringBuilder sb = new StringBuilder("Iterator[");
            sb.append(getKey());
            sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            return AbstractC1974b.m1320m(sb, getValue(), "]");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ValuesView<V> extends AbstractList<V> {
        private final ListOrderedMap<Object, V> parent;

        public ValuesView(ListOrderedMap<?, V> listOrderedMap) {
            this.parent = listOrderedMap;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public V get(int i) {
            return this.parent.getValue(i);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<V> iterator() {
            return new AbstractUntypedIteratorDecorator<Map.Entry<Object, V>, V>(this.parent.entrySet().iterator()) { // from class: org.apache.commons.collections4.map.ListOrderedMap.ValuesView.1
                @Override // java.util.Iterator
                public V next() {
                    return getIterator().next().getValue();
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public V remove(int i) {
            return this.parent.remove(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public V set(int i, V v) {
            return this.parent.setValue(i, v);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.size();
        }
    }

    public ListOrderedMap() {
        this(new HashMap());
    }

    public static <K, V> ListOrderedMap<K, V> listOrderedMap(Map<K, V> map) {
        return new ListOrderedMap<>(map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    public List<K> asList() {
        return keyList();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        decorated().clear();
        this.insertOrder.clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySetView(this, this.insertOrder);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (isEmpty()) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.insertOrder.get(0);
    }

    public K get(int i) {
        return this.insertOrder.get(i);
    }

    public V getValue(int i) {
        return get(this.insertOrder.get(i));
    }

    public int indexOf(Object obj) {
        return this.insertOrder.indexOf(obj);
    }

    public List<K> keyList() {
        return UnmodifiableList.unmodifiableList(this.insertOrder);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return new KeySetView(this);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (isEmpty()) {
            throw new NoSuchElementException("Map is empty");
        }
        return this.insertOrder.get(size() - 1);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object obj) {
        int iIndexOf = this.insertOrder.indexOf(obj);
        if (iIndexOf < 0 || iIndexOf >= size() - 1) {
            return null;
        }
        return this.insertOrder.get(iIndexOf + 1);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object obj) {
        int iIndexOf = this.insertOrder.indexOf(obj);
        if (iIndexOf > 0) {
            return this.insertOrder.get(iIndexOf - 1);
        }
        return null;
    }

    public V put(int i, K k, V v) {
        if (i < 0 || i > this.insertOrder.size()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Size: ");
            sbM778t.append(this.insertOrder.size());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        Map<K, V> mapDecorated = decorated();
        if (!mapDecorated.containsKey(k)) {
            this.insertOrder.add(i, k);
            mapDecorated.put(k, v);
            return null;
        }
        V vRemove = mapDecorated.remove(k);
        int iIndexOf = this.insertOrder.indexOf(k);
        this.insertOrder.remove(iIndexOf);
        if (iIndexOf < i) {
            i--;
        }
        this.insertOrder.add(i, k);
        mapDecorated.put(k, v);
        return vRemove;
    }

    public void putAll(int i, Map<? extends K, ? extends V> map) {
        if (i < 0 || i > this.insertOrder.size()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Size: ");
            sbM778t.append(this.insertOrder.size());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            boolean zContainsKey = containsKey(entry.getKey());
            put(i, entry.getKey(), entry.getValue());
            if (zContainsKey) {
                i = indexOf(entry.getKey());
            }
            i++;
        }
    }

    public V remove(int i) {
        return remove(get(i));
    }

    public V setValue(int i, V v) {
        return put(this.insertOrder.get(i), v);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(Parse.BRACKET_LCB);
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                z = false;
            } else {
                sb.append(SQLKeyword.COMMA);
            }
            if (key == this) {
                key = "(this Map)";
            }
            sb.append(key);
            sb.append('=');
            if (value == this) {
                value = "(this Map)";
            }
            sb.append(value);
        }
        sb.append('}');
        return sb.toString();
    }

    public List<V> valueList() {
        return new ValuesView(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return new ValuesView(this);
    }

    public ListOrderedMap(Map<K, V> map) {
        super(map);
        ArrayList arrayList = new ArrayList();
        this.insertOrder = arrayList;
        arrayList.addAll(decorated().keySet());
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new ListOrderedMapIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        if (!decorated().containsKey(obj)) {
            return null;
        }
        V vRemove = decorated().remove(obj);
        this.insertOrder.remove(obj);
        return vRemove;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        if (decorated().containsKey(k)) {
            return decorated().put(k, v);
        }
        V vPut = decorated().put(k, v);
        this.insertOrder.add(k);
        return vPut;
    }
}
