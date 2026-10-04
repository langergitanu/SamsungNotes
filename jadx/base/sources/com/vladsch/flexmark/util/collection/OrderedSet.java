package com.vladsch.flexmark.util.collection;

import androidx.collection.AbstractC0622a;
import com.vladsch.flexmark.util.collection.iteration.BitSetIterable;
import com.vladsch.flexmark.util.collection.iteration.BitSetIterator;
import com.vladsch.flexmark.util.collection.iteration.Indexed;
import com.vladsch.flexmark.util.collection.iteration.IndexedIterable;
import com.vladsch.flexmark.util.collection.iteration.IndexedIterator;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OrderedSet<E> implements Set<E>, Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    private Indexed<E> allowConcurrentModsIndexedProxy;

    @Nullable
    private final CollectionHost<E> host;

    @Nullable
    private Indexed<E> indexedProxy;

    @NotNull
    private final HashMap<E, Integer> keyMap;
    private int modificationCount;

    @NotNull
    private final BitSet validIndices;

    @NotNull
    final ArrayList<E> valueList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class IndexedProxy implements Indexed<E> {
        private final boolean allowConcurrentMods;

        public IndexedProxy(boolean z) {
            this.allowConcurrentMods = z;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public E get(int i) {
            return (E) OrderedSet.this.getValue(i);
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public int modificationCount() {
            if (this.allowConcurrentMods) {
                return 0;
            }
            return OrderedSet.this.getIteratorModificationCount();
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public void removeAt(int i) {
            OrderedSet.this.removeIndexHosted(i);
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public void set(int i, E e) {
            OrderedSet.this.setValueAt(i, e, null);
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
        public int size() {
            return OrderedSet.this.valueList.size();
        }
    }

    public OrderedSet() {
        this(0);
    }

    public static <T1> T1 ifNull(T1 t1, T1 t12) {
        return t1 == null ? t12 : t1;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(@Nullable E e) {
        return add(e, null);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        boolean[] zArr = {false};
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            if (add(it.next())) {
                zArr[0] = true;
            }
        }
        return zArr[0];
    }

    public void addNull() {
        addNulls(this.valueList.size());
    }

    public void addNulls(int i) {
        CollectionHost<E> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.addingNulls(i);
        }
        this.modificationCount++;
        while (this.valueList.size() <= i) {
            this.valueList.add(null);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        CollectionHost<E> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.clearing();
        }
        this.modificationCount++;
        this.keyMap.clear();
        this.valueList.clear();
        this.validIndices.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.keyMap.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@NotNull Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!this.keyMap.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public BitSet differenceBitSet(@NotNull Iterable<? extends E> iterable) {
        return differenceBitSet(iterable.iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrderedSet orderedSet = (OrderedSet) obj;
        if (size() != orderedSet.size()) {
            return false;
        }
        ReversibleIndexedIterator<E> it = orderedSet.iterator();
        ReversibleIndexedIterator<E> it2 = iterator();
        while (it2.hasNext()) {
            if (!it2.next().equals(it.next())) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public Indexed<E> getConcurrentModsIndexedProxy() {
        Indexed<E> indexed = this.allowConcurrentModsIndexedProxy;
        if (indexed != null) {
            return indexed;
        }
        IndexedProxy indexedProxy = new IndexedProxy(true);
        this.allowConcurrentModsIndexedProxy = indexedProxy;
        return indexedProxy;
    }

    @NotNull
    public Indexed<E> getIndexedProxy() {
        Indexed<E> indexed = this.indexedProxy;
        if (indexed != null) {
            return indexed;
        }
        IndexedProxy indexedProxy = new IndexedProxy(false);
        this.indexedProxy = indexedProxy;
        return indexedProxy;
    }

    public int getIteratorModificationCount() {
        CollectionHost<E> collectionHost = this.host;
        return collectionHost != null ? collectionHost.getIteratorModificationCount() : this.modificationCount;
    }

    public int getModificationCount() {
        return this.modificationCount;
    }

    @NotNull
    public BitSet getValidIndices() {
        return this.validIndices;
    }

    @Nullable
    public E getValue(int i) {
        validateIndex(i);
        return this.valueList.get(i);
    }

    @NotNull
    public List<E> getValueList() {
        return this.valueList;
    }

    @Nullable
    public E getValueOrNull(int i) {
        if (isValidIndex(i)) {
            return this.valueList.get(i);
        }
        return null;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.validIndices.hashCode() + ((this.valueList.hashCode() + (this.keyMap.hashCode() * 31)) * 31);
    }

    public boolean inHostUpdate() {
        CollectionHost<E> collectionHost = this.host;
        return collectionHost != null && collectionHost.skipHostUpdate();
    }

    @NotNull
    public BitSet indexBitSet(@NotNull Iterable<? extends E> iterable) {
        BitSet bitSet = new BitSet();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            int iIndexOf = indexOf(it.next());
            if (iIndexOf != -1) {
                bitSet.set(iIndexOf);
            }
        }
        return bitSet;
    }

    @NotNull
    public ReversibleIterable<Integer> indexIterable() {
        return new BitSetIterable(this.validIndices);
    }

    @NotNull
    public ReversibleIterator<Integer> indexIterator() {
        return new BitSetIterator(this.validIndices);
    }

    public int indexOf(@Nullable Object obj) {
        return ((Integer) ifNull(this.keyMap.get(obj), -1)).intValue();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.keyMap.isEmpty();
    }

    public boolean isSparse() {
        return this.validIndices.nextClearBit(0) < this.valueList.size();
    }

    public boolean isValidIndex(int i) {
        return i >= 0 && i < this.valueList.size() && this.validIndices.get(i);
    }

    @NotNull
    public ReversibleIterable<E> iterable() {
        return new IndexedIterable(getIndexedProxy(), indexIterable());
    }

    @NotNull
    public BitSet keyDifferenceBitSet(@NotNull Iterable<? extends Map.Entry<? extends E, ?>> iterable) {
        return keyDifferenceBitSet(iterable.iterator());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return removeHosted(obj) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@NotNull Collection<?> collection) {
        boolean z = false;
        for (Object obj : collection) {
            if (this.keyMap.containsKey(obj) && remove(obj)) {
                z = true;
            }
        }
        return z;
    }

    @Nullable
    public Object removeHosted(@Nullable Object obj) {
        Integer num = this.keyMap.get(obj);
        if (num == null) {
            return null;
        }
        return removeIndexHosted(num.intValue());
    }

    public boolean removeIndex(int i) {
        return removeIndexHosted(i) != null;
    }

    public Object removeIndexHosted(int i) {
        validateIndex(i);
        E e = this.valueList.get(i);
        CollectionHost<E> collectionHost = this.host;
        Object objRemoving = (collectionHost == null || collectionHost.skipHostUpdate()) ? e : this.host.removing(i, e);
        this.modificationCount++;
        this.keyMap.remove(e);
        if (this.keyMap.size() != 0) {
            if (this.host == null && i == this.valueList.size() - 1) {
                this.valueList.remove(i);
            }
            this.validIndices.clear(i);
            return objRemoving;
        }
        CollectionHost<E> collectionHost2 = this.host;
        if (collectionHost2 != null && !collectionHost2.skipHostUpdate()) {
            this.host.clearing();
        }
        this.valueList.clear();
        this.validIndices.clear();
        return objRemoving;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@NotNull Collection<?> collection) {
        BitSet bitSet = new BitSet(this.valueList.size());
        boolean z = false;
        bitSet.set(0, this.valueList.size());
        bitSet.and(this.validIndices);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            int iIndexOf = indexOf(it.next());
            if (iIndexOf != -1) {
                bitSet.clear(iIndexOf);
            }
        }
        int size = this.valueList.size();
        if (size == 0) {
            return false;
        }
        while (true) {
            int i = size - 1;
            if (size <= 0 || (size = bitSet.previousSetBit(i)) == -1) {
                break;
            }
            remove(this.valueList.get(size));
            z = true;
        }
        return z;
    }

    @NotNull
    public ReversibleIterable<Integer> reversedIndexIterable() {
        return new BitSetIterable(this.validIndices, true);
    }

    @NotNull
    public ReversibleIterator<Integer> reversedIndexIterator() {
        return new BitSetIterator(this.validIndices, true);
    }

    @NotNull
    public ReversibleIterable<E> reversedIterable() {
        return new IndexedIterable(getIndexedProxy(), reversedIndexIterable());
    }

    @NotNull
    public ReversibleIndexedIterator<E> reversedIterator() {
        return new IndexedIterator(getIndexedProxy(), reversedIndexIterator());
    }

    public boolean setValueAt(int i, @Nullable E e, @Nullable Object obj) {
        int iIndexOf = indexOf(e);
        if (iIndexOf != -1) {
            if (i == iIndexOf) {
                return false;
            }
            throw new IllegalStateException("Trying to add existing element " + e + "[" + iIndexOf + "] at index " + i);
        }
        if (i < this.valueList.size()) {
            if (this.validIndices.get(i)) {
                throw new IllegalStateException("Trying to add new element " + e + " at index " + i + ", already occupied by " + this.valueList.get(i));
            }
        } else if (i > this.valueList.size()) {
            addNulls(i - 1);
        }
        CollectionHost<E> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.adding(i, e, obj);
        }
        this.keyMap.put(e, Integer.valueOf(i));
        this.valueList.set(i, e);
        this.validIndices.set(i);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.keyMap.size();
    }

    @Override // java.util.Set, java.util.Collection
    @NotNull
    public Object[] toArray() {
        Object[] objArr = new Object[this.keyMap.size()];
        int i = -1;
        int i2 = -1;
        while (true) {
            i++;
            if (i >= this.valueList.size()) {
                return objArr;
            }
            if (this.validIndices.get(i)) {
                i2++;
                objArr[i2] = this.valueList.get(i);
            }
        }
    }

    public void validateIndex(int i) {
        if (isValidIndex(i)) {
            return;
        }
        int size = this.valueList.size();
        boolean z = this.validIndices.get(i);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, size, "Index ", " is not valid, size=", " validIndices[");
        sbM1173s.append(i);
        sbM1173s.append("]=");
        sbM1173s.append(z);
        throw new IndexOutOfBoundsException(sbM1173s.toString());
    }

    @NotNull
    public BitSet valueDifferenceBitSet(@NotNull Iterable<? extends Map.Entry<?, ? extends E>> iterable) {
        return valueDifferenceBitSet(iterable.iterator());
    }

    @NotNull
    public List<E> values() {
        if (!isSparse()) {
            return this.valueList;
        }
        ArrayList arrayList = new ArrayList();
        ReversibleIterator<E> it = iterable().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public OrderedSet(int i) {
        this(i, null);
    }

    public boolean add(@Nullable E e, @Nullable Object obj) {
        if (this.keyMap.containsKey(e)) {
            return false;
        }
        int size = this.valueList.size();
        CollectionHost<E> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.adding(size, e, obj);
        }
        this.modificationCount++;
        this.keyMap.put(e, Integer.valueOf(size));
        this.valueList.add(e);
        this.validIndices.set(size);
        return true;
    }

    @NotNull
    public BitSet differenceBitSet(@NotNull Iterator<? extends E> it) {
        BitSet bitSet = new BitSet();
        int i = 0;
        while (it.hasNext()) {
            int iIndexOf = indexOf(it.next());
            if (iIndexOf != i) {
                bitSet.set(iIndexOf);
            }
            i++;
        }
        return bitSet;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public ReversibleIndexedIterator<E> iterator() {
        return new IndexedIterator(getIndexedProxy(), indexIterator());
    }

    @NotNull
    public BitSet keyDifferenceBitSet(@NotNull Iterator<? extends Map.Entry<? extends E, ?>> it) {
        BitSet bitSet = new BitSet();
        int i = 0;
        while (it.hasNext()) {
            int iIndexOf = indexOf(it.next().getKey());
            if (iIndexOf != i) {
                bitSet.set(iIndexOf);
            }
            i++;
        }
        return bitSet;
    }

    @NotNull
    public BitSet valueDifferenceBitSet(@NotNull Iterator<? extends Map.Entry<?, ? extends E>> it) {
        BitSet bitSet = new BitSet();
        int i = 0;
        while (it.hasNext()) {
            int iIndexOf = indexOf(it.next().getValue());
            if (iIndexOf != i) {
                bitSet.set(iIndexOf);
            }
            i++;
        }
        return bitSet;
    }

    public OrderedSet(@NotNull CollectionHost<E> collectionHost) {
        this(0, collectionHost);
    }

    public OrderedSet(int i, @Nullable CollectionHost<E> collectionHost) {
        this.keyMap = new HashMap<>(i);
        this.valueList = new ArrayList<>(i);
        this.validIndices = new BitSet();
        this.host = collectionHost;
        this.modificationCount = Integer.MIN_VALUE;
        this.indexedProxy = null;
        this.allowConcurrentModsIndexedProxy = null;
    }

    @Override // java.util.Set, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        if (tArr.length < this.keyMap.size()) {
            tArr = tArr.getClass() == Object[].class ? (T[]) new Object[this.keyMap.size()] : (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.keyMap.size()));
        }
        int i = -1;
        int i2 = -1;
        while (true) {
            i++;
            if (i >= this.valueList.size()) {
                break;
            }
            if (this.validIndices.get(i)) {
                i2++;
                tArr[i2] = this.valueList.get(i);
            }
        }
        int i4 = i2 + 1;
        if (tArr.length > i4) {
            tArr[i4] = null;
        }
        return tArr;
    }
}
