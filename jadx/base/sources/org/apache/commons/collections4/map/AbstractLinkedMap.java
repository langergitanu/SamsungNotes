package org.apache.commons.collections4.map;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.map.AbstractHashedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractLinkedMap<K, V> extends AbstractHashedMap<K, V> implements OrderedMap<K, V> {
    transient LinkEntry<K, V> header;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EntrySetIterator<K, V> extends LinkIterator<K, V> implements OrderedIterator<Map.Entry<K, V>>, ResettableIterator<Map.Entry<K, V>> {
        public EntrySetIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<K, V> previous() {
            return super.previousEntry();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KeySetIterator<K> extends LinkIterator<K, Object> implements OrderedIterator<K>, ResettableIterator<K> {
        public KeySetIterator(AbstractLinkedMap<K, ?> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected LinkEntry<K, V> after;
        protected LinkEntry<K, V> before;

        public LinkEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, Object obj, V v) {
            super(hashEntry, i, obj, v);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class LinkIterator<K, V> {
        protected int expectedModCount;
        protected LinkEntry<K, V> last;
        protected LinkEntry<K, V> next;
        protected final AbstractLinkedMap<K, V> parent;

        public LinkIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            Objects.requireNonNull(abstractLinkedMap);
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.header.after;
            this.expectedModCount = abstractLinkedMap.modCount;
        }

        public LinkEntry<K, V> currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        public boolean hasPrevious() {
            return this.next.before != this.parent.header;
        }

        public LinkEntry<K, V> nextEntry() {
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry<K, V> linkEntry = this.next;
            if (linkEntry == abstractLinkedMap.header) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.last = linkEntry;
            this.next = linkEntry.after;
            return linkEntry;
        }

        public LinkEntry<K, V> previousEntry() {
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry<K, V> linkEntry = this.next.before;
            if (linkEntry == abstractLinkedMap.header) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.next = linkEntry;
            this.last = linkEntry;
            return linkEntry;
        }

        public void remove() {
            LinkEntry<K, V> linkEntry = this.last;
            if (linkEntry == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            abstractLinkedMap.remove(linkEntry.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
        }

        public void reset() {
            this.last = null;
            this.next = this.parent.header.after;
        }

        public String toString() {
            if (this.last == null) {
                return "Iterator[]";
            }
            return "Iterator[" + this.last.getKey() + MarketingConstants.REFERRER_DELIMITER_U003D + this.last.getValue() + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkMapIterator<K, V> extends LinkIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        public LinkMapIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            LinkEntry<K, V> linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.setValue(v);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ValuesIterator<V> extends LinkIterator<Object, V> implements OrderedIterator<V>, ResettableIterator<V> {
        public ValuesIterator(AbstractLinkedMap<?, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public V previous() {
            return super.previousEntry().getValue();
        }
    }

    public AbstractLinkedMap() {
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void addEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i) {
        LinkEntry<K, V> linkEntry = (LinkEntry) hashEntry;
        LinkEntry<K, V> linkEntry2 = this.header;
        linkEntry.after = linkEntry2;
        linkEntry.before = linkEntry2.before;
        linkEntry2.before.after = linkEntry;
        linkEntry2.before = linkEntry;
        this.data[i] = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        super.clear();
        LinkEntry<K, V> linkEntry = this.header;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkEntry<K, V> linkEntry = this.header;
            do {
                linkEntry = linkEntry.after;
                if (linkEntry == this.header) {
                    return false;
                }
            } while (linkEntry.getValue() != null);
            return true;
        }
        LinkEntry<K, V> linkEntry2 = this.header;
        do {
            linkEntry2 = linkEntry2.after;
            if (linkEntry2 == this.header) {
                return false;
            }
        } while (!isEqualValue(obj, linkEntry2.getValue()));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return createEntry((AbstractHashedMap.HashEntry<Object, Object>) hashEntry, i, obj, obj2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        return isEmpty() ? EmptyOrderedIterator.emptyOrderedIterator() : new EntrySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<K> createKeySetIterator() {
        return isEmpty() ? EmptyOrderedIterator.emptyOrderedIterator() : new KeySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<V> createValuesIterator() {
        return isEmpty() ? EmptyOrderedIterator.emptyOrderedIterator() : new ValuesIterator(this);
    }

    public LinkEntry<K, V> entryAfter(LinkEntry<K, V> linkEntry) {
        return linkEntry.after;
    }

    public LinkEntry<K, V> entryBefore(LinkEntry<K, V> linkEntry) {
        return linkEntry.before;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.size != 0) {
            return this.header.after.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void init() {
        LinkEntry<K, V> linkEntryCreateEntry = createEntry((AbstractHashedMap.HashEntry) null, -1, (Object) null, (Object) null);
        this.header = linkEntryCreateEntry;
        linkEntryCreateEntry.after = linkEntryCreateEntry;
        linkEntryCreateEntry.before = linkEntryCreateEntry;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.size != 0) {
            return this.header.before.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object obj) {
        LinkEntry<K, V> linkEntry;
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || (linkEntry = entry.after) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object obj) {
        LinkEntry<K, V> linkEntry;
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || (linkEntry = entry.before) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void removeEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, AbstractHashedMap.HashEntry<K, V> hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        LinkEntry<K, V> linkEntry2 = linkEntry.before;
        linkEntry2.after = linkEntry.after;
        linkEntry.after.before = linkEntry2;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i, hashEntry2);
    }

    public AbstractLinkedMap(int i) {
        super(i);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new LinkEntry<>(hashEntry, i, convertKey(k), v);
    }

    public LinkEntry<K, V> getEntry(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC0541b.m767i(i, "Index ", " is less than zero"));
        }
        int i2 = this.size;
        if (i >= i2) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index ", " is invalid for size ");
            sbM778t.append(this.size);
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        if (i >= i2 / 2) {
            LinkEntry<K, V> linkEntry = this.header;
            while (i2 > i) {
                linkEntry = linkEntry.before;
                i2--;
            }
            return linkEntry;
        }
        LinkEntry<K, V> linkEntry2 = this.header.after;
        for (int i4 = 0; i4 < i; i4++) {
            linkEntry2 = linkEntry2.after;
        }
        return linkEntry2;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return this.size == 0 ? EmptyOrderedMapIterator.emptyOrderedMapIterator() : new LinkMapIterator(this);
    }

    public AbstractLinkedMap(int i, float f) {
        super(i, f);
    }

    public AbstractLinkedMap(int i, float f, int i2) {
        super(i, f, i2);
    }

    public AbstractLinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> getEntry(Object obj) {
        return (LinkEntry) super.getEntry(obj);
    }
}
