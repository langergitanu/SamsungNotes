package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ComparatorChain<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = -721644942746081630L;
    private final List<Comparator<E>> comparatorChain;
    private boolean isLocked;
    private final BitSet orderingBits;

    public ComparatorChain() {
        this(new ArrayList(), new BitSet());
    }

    private void checkChainIntegrity() {
        if (this.comparatorChain.isEmpty()) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    public void addComparator(Comparator<E> comparator) {
        addComparator(comparator, false);
    }

    @Override // java.util.Comparator
    public int compare(E e, E e2) {
        if (!this.isLocked) {
            checkChainIntegrity();
            this.isLocked = true;
        }
        Iterator<Comparator<E>> it = this.comparatorChain.iterator();
        int i = 0;
        while (it.hasNext()) {
            int iCompare = it.next().compare(e, e2);
            if (iCompare != 0) {
                return this.orderingBits.get(i) ? iCompare > 0 ? -1 : 1 : iCompare;
            }
            i++;
        }
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            ComparatorChain comparatorChain = (ComparatorChain) obj;
            if (Objects.equals(this.orderingBits, comparatorChain.orderingBits) && Objects.equals(this.comparatorChain, comparatorChain.comparatorChain)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        List<Comparator<E>> list = this.comparatorChain;
        int iHashCode = list != null ? list.hashCode() : 0;
        BitSet bitSet = this.orderingBits;
        return bitSet != null ? iHashCode ^ bitSet.hashCode() : iHashCode;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setComparator(int i, Comparator<E> comparator) {
        setComparator(i, comparator, false);
    }

    public void setForwardSort(int i) {
        checkLocked();
        this.orderingBits.clear(i);
    }

    public void setReverseSort(int i) {
        checkLocked();
        this.orderingBits.set(i);
    }

    public int size() {
        return this.comparatorChain.size();
    }

    public ComparatorChain(Comparator<E> comparator) {
        this((Comparator) comparator, false);
    }

    public void addComparator(Comparator<E> comparator, boolean z) {
        checkLocked();
        this.comparatorChain.add(comparator);
        if (z) {
            this.orderingBits.set(this.comparatorChain.size() - 1);
        }
    }

    public void setComparator(int i, Comparator<E> comparator, boolean z) {
        checkLocked();
        this.comparatorChain.set(i, comparator);
        if (z) {
            this.orderingBits.set(i);
        } else {
            this.orderingBits.clear(i);
        }
    }

    public ComparatorChain(Comparator<E> comparator, boolean z) {
        ArrayList arrayList = new ArrayList(1);
        this.comparatorChain = arrayList;
        arrayList.add(comparator);
        BitSet bitSet = new BitSet(1);
        this.orderingBits = bitSet;
        if (z) {
            bitSet.set(0);
        }
    }

    public ComparatorChain(List<Comparator<E>> list) {
        this(list, new BitSet(list.size()));
    }

    public ComparatorChain(List<Comparator<E>> list, BitSet bitSet) {
        this.comparatorChain = list;
        this.orderingBits = bitSet;
    }
}
