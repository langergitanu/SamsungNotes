package org.apache.commons.collections.bidimap;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.SortedBidiMap;
import org.apache.commons.collections.map.AbstractSortedMapDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DualTreeBidiMap extends AbstractDualBidiMap implements SortedBidiMap, Serializable {
    private static final long serialVersionUID = 721969328361809L;
    protected final Comparator comparator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BidiOrderedMapIterator implements OrderedMapIterator, ResettableIterator {
        protected ListIterator iterator;
        private Map.Entry last = null;
        protected final AbstractDualBidiMap parent;

        public BidiOrderedMapIterator(AbstractDualBidiMap abstractDualBidiMap) {
            this.parent = abstractDualBidiMap;
            this.iterator = new ArrayList(abstractDualBidiMap.entrySet()).listIterator();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            Map.Entry entry = this.last;
            if (entry != null) {
                return entry.getKey();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            Map.Entry entry = this.last;
            if (entry != null) {
                return entry.getValue();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
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
            Map.Entry entry = (Map.Entry) this.iterator.next();
            this.last = entry;
            return entry.getKey();
        }

        @Override // org.apache.commons.collections.OrderedMapIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            Map.Entry entry = (Map.Entry) this.iterator.previous();
            this.last = entry;
            return entry.getKey();
        }

        @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            this.parent.remove(this.last.getKey());
            this.last = null;
        }

        @Override // org.apache.commons.collections.ResettableIterator
        public void reset() {
            this.iterator = new ArrayList(this.parent.entrySet()).listIterator();
            this.last = null;
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            if (this.last == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            }
            if (!this.parent.maps[1].containsKey(obj) || this.parent.maps[1].get(obj) == this.last.getKey()) {
                return this.parent.put(this.last.getKey(), obj);
            }
            throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
        }

        public String toString() {
            if (this.last == null) {
                return "MapIterator[]";
            }
            StringBuffer stringBuffer = new StringBuffer("MapIterator[");
            stringBuffer.append(getKey());
            stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewMap extends AbstractSortedMapDecorator {
        final DualTreeBidiMap bidi;

        public ViewMap(DualTreeBidiMap dualTreeBidiMap, SortedMap sortedMap) {
            super((SortedMap) dualTreeBidiMap.createBidiMap(sortedMap, dualTreeBidiMap.maps[1], dualTreeBidiMap.inverseBidiMap));
            this.bidi = (DualTreeBidiMap) this.map;
        }

        @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
        public void clear() {
            Iterator it = keySet().iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
        public boolean containsValue(Object obj) {
            return this.bidi.maps[0].containsValue(obj);
        }

        @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return new ViewMap(this.bidi, super.headMap(obj));
        }

        @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return new ViewMap(this.bidi, super.subMap(obj, obj2));
        }

        @Override // org.apache.commons.collections.map.AbstractSortedMapDecorator, java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return new ViewMap(this.bidi, super.tailMap(obj));
        }
    }

    public DualTreeBidiMap() {
        super(new TreeMap(), new TreeMap());
        this.comparator = null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.maps[0] = new TreeMap(this.comparator);
        this.maps[1] = new TreeMap(this.comparator);
        putAll((Map) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.maps[0]);
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return ((SortedMap) this.maps[0]).comparator();
    }

    @Override // org.apache.commons.collections.bidimap.AbstractDualBidiMap
    public BidiMap createBidiMap(Map map, Map map2, BidiMap bidiMap) {
        return new DualTreeBidiMap(map, map2, bidiMap);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        return ((SortedMap) this.maps[0]).firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).headMap(obj));
    }

    @Override // org.apache.commons.collections.OrderedBidiMap
    public OrderedBidiMap inverseOrderedBidiMap() {
        return (OrderedBidiMap) inverseBidiMap();
    }

    @Override // org.apache.commons.collections.SortedBidiMap
    public SortedBidiMap inverseSortedBidiMap() {
        return (SortedBidiMap) inverseBidiMap();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        return ((SortedMap) this.maps[0]).lastKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        if (isEmpty()) {
            return null;
        }
        Map map = this.maps[0];
        if (map instanceof OrderedMap) {
            return ((OrderedMap) map).nextKey(obj);
        }
        Iterator it = ((SortedMap) map).tailMap(obj).keySet().iterator();
        it.next();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return new BidiOrderedMapIterator(this);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        if (isEmpty()) {
            return null;
        }
        Map map = this.maps[0];
        if (map instanceof OrderedMap) {
            return ((OrderedMap) map).previousKey(obj);
        }
        SortedMap sortedMapHeadMap = ((SortedMap) map).headMap(obj);
        if (sortedMapHeadMap.isEmpty()) {
            return null;
        }
        return sortedMapHeadMap.lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).subMap(obj, obj2));
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return new ViewMap(this, ((SortedMap) this.maps[0]).tailMap(obj));
    }

    public DualTreeBidiMap(Map map) {
        super(new TreeMap(), new TreeMap());
        putAll(map);
        this.comparator = null;
    }

    public DualTreeBidiMap(Comparator comparator) {
        super(new TreeMap(comparator), new TreeMap(comparator));
        this.comparator = comparator;
    }

    public DualTreeBidiMap(Map map, Map map2, BidiMap bidiMap) {
        super(map, map2, bidiMap);
        this.comparator = ((SortedMap) map).comparator();
    }
}
