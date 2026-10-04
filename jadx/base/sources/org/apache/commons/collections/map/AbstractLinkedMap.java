package org.apache.commons.collections.map;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.EmptyOrderedIterator;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections.map.AbstractHashedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AbstractLinkedMap extends AbstractHashedMap implements OrderedMap {
    protected transient LinkEntry header;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EntrySetIterator extends LinkIterator {
        public EntrySetIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Object next() {
            return super.nextEntry();
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public Object previous() {
            return super.previousEntry();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KeySetIterator extends EntrySetIterator {
        public KeySetIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // org.apache.commons.collections.map.AbstractLinkedMap.EntrySetIterator, java.util.Iterator
        public Object next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections.map.AbstractLinkedMap.EntrySetIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            return super.previousEntry().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkEntry extends AbstractHashedMap.HashEntry {
        protected LinkEntry after;
        protected LinkEntry before;

        public LinkEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
            super(hashEntry, i, obj, obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class LinkIterator implements OrderedIterator, ResettableIterator {
        protected int expectedModCount;
        protected LinkEntry last;
        protected LinkEntry next;
        protected final AbstractLinkedMap parent;

        public LinkIterator(AbstractLinkedMap abstractLinkedMap) {
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.header.after;
            this.expectedModCount = abstractLinkedMap.modCount;
        }

        public LinkEntry currentEntry() {
            return this.last;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return this.next.before != this.parent.header;
        }

        public LinkEntry nextEntry() {
            AbstractLinkedMap abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry linkEntry = this.next;
            if (linkEntry == abstractLinkedMap.header) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.last = linkEntry;
            this.next = linkEntry.after;
            return linkEntry;
        }

        public LinkEntry previousEntry() {
            AbstractLinkedMap abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            LinkEntry linkEntry = this.next.before;
            if (linkEntry == abstractLinkedMap.header) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.next = linkEntry;
            this.last = linkEntry;
            return linkEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            LinkEntry linkEntry = this.last;
            if (linkEntry == null) {
                throw new IllegalStateException("remove() can only be called once after next()");
            }
            AbstractLinkedMap abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            abstractLinkedMap.remove(linkEntry.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
        }

        @Override // org.apache.commons.collections.ResettableIterator
        public void reset() {
            this.last = null;
            this.next = this.parent.header.after;
        }

        public String toString() {
            if (this.last == null) {
                return "Iterator[]";
            }
            StringBuffer stringBuffer = new StringBuffer("Iterator[");
            stringBuffer.append(this.last.getKey());
            stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            stringBuffer.append(this.last.getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkMapIterator extends LinkIterator implements OrderedMapIterator {
        public LinkMapIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            LinkEntry linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            LinkEntry linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // java.util.Iterator, org.apache.commons.collections.MapIterator
        public Object next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public Object previous() {
            return super.previousEntry().getKey();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            LinkEntry linkEntryCurrentEntry = currentEntry();
            if (linkEntryCurrentEntry != null) {
                return linkEntryCurrentEntry.setValue(obj);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ValuesIterator extends LinkIterator {
        public ValuesIterator(AbstractLinkedMap abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Object next() {
            return super.nextEntry().getValue();
        }

        @Override // org.apache.commons.collections.OrderedIterator
        public Object previous() {
            return super.previousEntry().getValue();
        }
    }

    public AbstractLinkedMap() {
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void addEntry(AbstractHashedMap.HashEntry hashEntry, int i) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        LinkEntry linkEntry2 = this.header;
        linkEntry.after = linkEntry2;
        linkEntry.before = linkEntry2.before;
        linkEntry2.before.after = linkEntry;
        linkEntry2.before = linkEntry;
        this.data[i] = hashEntry;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        LinkEntry linkEntry = this.header;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkEntry linkEntry = this.header;
            do {
                linkEntry = linkEntry.after;
                if (linkEntry == this.header) {
                    return false;
                }
            } while (linkEntry.getValue() != null);
            return true;
        }
        LinkEntry linkEntry2 = this.header;
        do {
            linkEntry2 = linkEntry2.after;
            if (linkEntry2 == this.header) {
                return false;
            }
        } while (!isEqualValue(obj, linkEntry2.getValue()));
        return true;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return new LinkEntry(hashEntry, i, obj, obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public Iterator createEntrySetIterator() {
        return size() == 0 ? EmptyOrderedIterator.INSTANCE : new EntrySetIterator(this);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public Iterator createKeySetIterator() {
        return size() == 0 ? EmptyOrderedIterator.INSTANCE : new KeySetIterator(this);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public Iterator createValuesIterator() {
        return size() == 0 ? EmptyOrderedIterator.INSTANCE : new ValuesIterator(this);
    }

    public LinkEntry entryAfter(LinkEntry linkEntry) {
        return linkEntry.after;
    }

    public LinkEntry entryBefore(LinkEntry linkEntry) {
        return linkEntry.before;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        if (this.size != 0) {
            return this.header.after.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    public LinkEntry getEntry(int i) {
        if (i < 0) {
            StringBuffer stringBuffer = new StringBuffer("Index ");
            stringBuffer.append(i);
            stringBuffer.append(" is less than zero");
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        int i2 = this.size;
        if (i >= i2) {
            StringBuffer stringBuffer2 = new StringBuffer("Index ");
            stringBuffer2.append(i);
            stringBuffer2.append(" is invalid for size ");
            stringBuffer2.append(this.size);
            throw new IndexOutOfBoundsException(stringBuffer2.toString());
        }
        if (i >= i2 / 2) {
            LinkEntry linkEntry = this.header;
            while (i2 > i) {
                linkEntry = linkEntry.before;
                i2--;
            }
            return linkEntry;
        }
        LinkEntry linkEntry2 = this.header.after;
        for (int i4 = 0; i4 < i; i4++) {
            linkEntry2 = linkEntry2.after;
        }
        return linkEntry2;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void init() {
        LinkEntry linkEntry = (LinkEntry) createEntry(null, -1, null, null);
        this.header = linkEntry;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        if (this.size != 0) {
            return this.header.before.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return this.size == 0 ? EmptyOrderedMapIterator.INSTANCE : new LinkMapIterator(this);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        LinkEntry linkEntry;
        LinkEntry linkEntry2 = (LinkEntry) getEntry(obj);
        if (linkEntry2 == null || (linkEntry = linkEntry2.after) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return this.size == 0 ? EmptyOrderedMapIterator.INSTANCE : new LinkMapIterator(this);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        LinkEntry linkEntry;
        LinkEntry linkEntry2 = (LinkEntry) getEntry(obj);
        if (linkEntry2 == null || (linkEntry = linkEntry2.before) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void removeEntry(AbstractHashedMap.HashEntry hashEntry, int i, AbstractHashedMap.HashEntry hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        LinkEntry linkEntry2 = linkEntry.before;
        linkEntry2.after = linkEntry.after;
        linkEntry.after.before = linkEntry2;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i, hashEntry2);
    }

    public AbstractLinkedMap(int i, float f, int i2) {
        super(i, f, i2);
    }

    public AbstractLinkedMap(int i) {
        super(i);
    }

    public AbstractLinkedMap(int i, float f) {
        super(i, f);
    }

    public AbstractLinkedMap(Map map) {
        super(map);
    }
}
