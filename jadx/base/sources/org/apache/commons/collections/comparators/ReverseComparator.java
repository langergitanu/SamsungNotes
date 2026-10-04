package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ReverseComparator implements Comparator, Serializable {
    private static final long serialVersionUID = 2858887242028539265L;
    private Comparator comparator;

    public ReverseComparator() {
        this(null);
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.comparator.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            return this.comparator.equals(((ReverseComparator) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode() ^ 175311160;
    }

    public ReverseComparator(Comparator comparator) {
        if (comparator != null) {
            this.comparator = comparator;
        } else {
            this.comparator = ComparableComparator.getInstance();
        }
    }
}
