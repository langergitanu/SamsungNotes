package org.apache.commons.collections.map;

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
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntry;
import org.apache.commons.collections.list.UnmodifiableList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ListOrderedMap extends AbstractMapDecorator implements OrderedMap, Serializable {
    private static final long serialVersionUID = 2728177751851003750L;
    protected final List insertOrder;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EntrySetView extends AbstractSet {
        private Set entrySet;
        private final List insertOrder;
        private final ListOrderedMap parent;

        public EntrySetView(ListOrderedMap listOrderedMap, List list) {
            this.parent = listOrderedMap;
            this.insertOrder = list;
        }

        private Set getEntrySet() {
            if (this.entrySet == null) {
                this.entrySet = this.parent.getMap().entrySet();
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
        public boolean containsAll(Collection collection) {
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
        public Iterator iterator() {
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
    public static class KeySetView extends AbstractSet {
        private final ListOrderedMap parent;

        public KeySetView(ListOrderedMap listOrderedMap) {
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
        public Iterator iterator() {
            return new AbstractIteratorDecorator(this, this.parent.entrySet().iterator()) { // from class: org.apache.commons.collections.map.ListOrderedMap.KeySetView.1
                private final /* synthetic */ KeySetView this$0;

                {
                    this.this$0 = this;
                }

                @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
                public Object next() {
                    return ((Map.Entry) super.next()).getKey();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListOrderedIterator extends AbstractIteratorDecorator {
        private Object last;
        private final ListOrderedMap parent;

        public ListOrderedIterator(ListOrderedMap listOrderedMap, List list) {
            super(list.iterator());
            this.last = null;
            this.parent = listOrderedMap;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Object next() {
            Object next = super.next();
            this.last = next;
            return new ListOrderedMapEntry(this.parent, next);
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.parent.getMap().remove(this.last);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListOrderedMapEntry extends AbstractMapEntry {
        private final ListOrderedMap parent;

        public ListOrderedMapEntry(ListOrderedMap listOrderedMap, Object obj) {
            super(obj, null);
            this.parent = listOrderedMap;
        }

        @Override // org.apache.commons.collections.keyvalue.AbstractKeyValue, org.apache.commons.collections.KeyValue
        public Object getValue() {
            return this.parent.get(this.key);
        }

        @Override // org.apache.commons.collections.keyvalue.AbstractMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            return this.parent.getMap().put(this.key, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ListOrderedMapIterator implements OrderedMapIterator, ResettableIterator {
        private ListIterator iterator;
        private final ListOrderedMap parent;
        private Object last = null;
        private boolean readable = false;

        public ListOrderedMapIterator(ListOrderedMap listOrderedMap) {
            this.parent = listOrderedMap;
            this.iterator = listOrderedMap.insertOrder.listIterator();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            if (this.readable) {
                return this.last;
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            if (this.readable) {
                return this.parent.get(this.last);
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public Object next() {
            Object next = this.iterator.next();
            this.last = next;
            this.readable = true;
            return next;
        }

        @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            Object objPrevious = this.iterator.previous();
            this.last = objPrevious;
            this.readable = true;
            return objPrevious;
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public void remove() {
            if (!this.readable) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            this.iterator.remove();
            this.parent.map.remove(this.last);
            this.readable = false;
        }

        @Override // org.apache.commons.collections.ResettableIterator
        public void reset() {
            this.iterator = this.parent.insertOrder.listIterator();
            this.last = null;
            this.readable = false;
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            if (this.readable) {
                return this.parent.map.put(this.last, obj);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (!this.readable) {
                return "Iterator[]";
            }
            StringBuffer stringBuffer = new StringBuffer("Iterator[");
            stringBuffer.append(getKey());
            stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ValuesView extends AbstractList {
        private final ListOrderedMap parent;

        public ValuesView(ListOrderedMap listOrderedMap) {
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
        public Object get(int i) {
            return this.parent.getValue(i);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return new AbstractIteratorDecorator(this, this.parent.entrySet().iterator()) { // from class: org.apache.commons.collections.map.ListOrderedMap.ValuesView.1
                private final /* synthetic */ ValuesView this$0;

                {
                    this.this$0 = this;
                }

                @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
                public Object next() {
                    return ((Map.Entry) this.iterator.next()).getValue();
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            return this.parent.remove(i);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            return this.parent.setValue(i, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.size();
        }
    }

    public ListOrderedMap() {
        this(new HashMap());
    }

    public static OrderedMap decorate(Map map) {
        return new ListOrderedMap(map);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    public List asList() {
        return keyList();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        getMap().clear();
        this.insertOrder.clear();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set entrySet() {
        return new EntrySetView(this, this.insertOrder);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        if (size() != 0) {
            return this.insertOrder.get(0);
        }
        throw new NoSuchElementException("Map is empty");
    }

    public Object get(int i) {
        return this.insertOrder.get(i);
    }

    public Object getValue(int i) {
        return get(this.insertOrder.get(i));
    }

    public int indexOf(Object obj) {
        return this.insertOrder.indexOf(obj);
    }

    public List keyList() {
        return UnmodifiableList.decorate(this.insertOrder);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Set keySet() {
        return new KeySetView(this);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        if (size() != 0) {
            return this.insertOrder.get(size() - 1);
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return orderedMapIterator();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        int iIndexOf = this.insertOrder.indexOf(obj);
        if (iIndexOf < 0 || iIndexOf >= size() - 1) {
            return null;
        }
        return this.insertOrder.get(iIndexOf + 1);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return new ListOrderedMapIterator(this);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        int iIndexOf = this.insertOrder.indexOf(obj);
        if (iIndexOf > 0) {
            return this.insertOrder.get(iIndexOf - 1);
        }
        return null;
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections.BidiMap
    public Object put(Object obj, Object obj2) {
        if (getMap().containsKey(obj)) {
            return getMap().put(obj, obj2);
        }
        Object objPut = getMap().put(obj, obj2);
        this.insertOrder.add(obj);
        return objPut;
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Object remove(Object obj) {
        Object objRemove = getMap().remove(obj);
        this.insertOrder.remove(obj);
        return objRemove;
    }

    public Object setValue(int i, Object obj) {
        return put(this.insertOrder.get(i), obj);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(Parse.BRACKET_LCB);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                z = false;
            } else {
                stringBuffer.append(SQLKeyword.COMMA);
            }
            if (key == this) {
                key = "(this Map)";
            }
            stringBuffer.append(key);
            stringBuffer.append('=');
            if (value == this) {
                value = "(this Map)";
            }
            stringBuffer.append(value);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public List valueList() {
        return new ValuesView(this);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Collection values() {
        return new ValuesView(this);
    }

    public ListOrderedMap(Map map) {
        super(map);
        ArrayList arrayList = new ArrayList();
        this.insertOrder = arrayList;
        arrayList.addAll(getMap().keySet());
    }

    public Object remove(int i) {
        return remove(get(i));
    }

    public Object put(int i, Object obj, Object obj2) {
        Map map = getMap();
        if (map.containsKey(obj)) {
            Object objRemove = map.remove(obj);
            int iIndexOf = this.insertOrder.indexOf(obj);
            this.insertOrder.remove(iIndexOf);
            if (iIndexOf < i) {
                i--;
            }
            this.insertOrder.add(i, obj);
            map.put(obj, obj2);
            return objRemove;
        }
        this.insertOrder.add(i, obj);
        map.put(obj, obj2);
        return null;
    }
}
