package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NullComparator implements Comparator, Serializable {
    private static final long serialVersionUID = -5820772575483504339L;
    private Comparator nonNullComparator;
    private boolean nullsAreHigh;

    public NullComparator() {
        this(ComparableComparator.getInstance(), true);
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        return obj == null ? this.nullsAreHigh ? 1 : -1 : obj2 == null ? this.nullsAreHigh ? -1 : 1 : this.nonNullComparator.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        NullComparator nullComparator = (NullComparator) obj;
        return this.nullsAreHigh == nullComparator.nullsAreHigh && this.nonNullComparator.equals(nullComparator.nonNullComparator);
    }

    public int hashCode() {
        return this.nonNullComparator.hashCode() * (this.nullsAreHigh ? -1 : 1);
    }

    public NullComparator(Comparator comparator) {
        this(comparator, true);
    }

    public NullComparator(boolean z) {
        this(ComparableComparator.getInstance(), z);
    }

    public NullComparator(Comparator comparator, boolean z) {
        this.nonNullComparator = comparator;
        this.nullsAreHigh = z;
        if (comparator == null) {
            throw new NullPointerException("null nonNullComparator");
        }
    }
}
