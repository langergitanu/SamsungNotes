package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ComparatorChain implements Comparator, Serializable {
    private static final long serialVersionUID = -721644942746081630L;
    protected List comparatorChain;
    protected boolean isLocked;
    protected BitSet orderingBits;

    public ComparatorChain() {
        this(new ArrayList(), new BitSet());
    }

    private void checkChainIntegrity() {
        if (this.comparatorChain.size() == 0) {
            throw new UnsupportedOperationException("ComparatorChains must contain at least one Comparator");
        }
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("Comparator ordering cannot be changed after the first comparison is performed");
        }
    }

    public void addComparator(Comparator comparator) {
        addComparator(comparator, false);
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (!this.isLocked) {
            checkChainIntegrity();
            this.isLocked = true;
        }
        Iterator it = this.comparatorChain.iterator();
        int i = 0;
        while (it.hasNext()) {
            int iCompare = ((Comparator) it.next()).compare(obj, obj2);
            if (iCompare != 0) {
                if (!this.orderingBits.get(i)) {
                    return iCompare;
                }
                if (Integer.MIN_VALUE == iCompare) {
                    return Integer.MAX_VALUE;
                }
                return iCompare * (-1);
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
            BitSet bitSet = this.orderingBits;
            if (bitSet != null ? bitSet.equals(comparatorChain.orderingBits) : comparatorChain.orderingBits == null) {
                List list = this.comparatorChain;
                List list2 = comparatorChain.comparatorChain;
                if (list != null ? list.equals(list2) : list2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        List list = this.comparatorChain;
        int iHashCode = list != null ? list.hashCode() : 0;
        BitSet bitSet = this.orderingBits;
        return bitSet != null ? iHashCode ^ bitSet.hashCode() : iHashCode;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setComparator(int i, Comparator comparator) {
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

    public ComparatorChain(Comparator comparator) {
        this(comparator, false);
    }

    public void addComparator(Comparator comparator, boolean z) {
        checkLocked();
        this.comparatorChain.add(comparator);
        if (z) {
            this.orderingBits.set(this.comparatorChain.size() - 1);
        }
    }

    public void setComparator(int i, Comparator comparator, boolean z) {
        checkLocked();
        this.comparatorChain.set(i, comparator);
        if (z) {
            this.orderingBits.set(i);
        } else {
            this.orderingBits.clear(i);
        }
    }

    public ComparatorChain(Comparator comparator, boolean z) {
        this.comparatorChain = null;
        this.orderingBits = null;
        this.isLocked = false;
        ArrayList arrayList = new ArrayList();
        this.comparatorChain = arrayList;
        arrayList.add(comparator);
        BitSet bitSet = new BitSet(1);
        this.orderingBits = bitSet;
        if (z) {
            bitSet.set(0);
        }
    }

    public ComparatorChain(List list) {
        this(list, new BitSet(list.size()));
    }

    public ComparatorChain(List list, BitSet bitSet) {
        this.isLocked = false;
        this.comparatorChain = list;
        this.orderingBits = bitSet;
    }
}
