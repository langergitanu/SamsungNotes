package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.collections4.ComparatorUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ReverseComparator<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = 2858887242028539265L;
    private final Comparator<? super E> comparator;

    public ReverseComparator() {
        this(null);
    }

    @Override // java.util.Comparator
    public int compare(E e, E e2) {
        return this.comparator.compare(e2, e);
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

    public ReverseComparator(Comparator<? super E> comparator) {
        this.comparator = comparator == null ? ComparatorUtils.NATURAL_COMPARATOR : comparator;
    }
}
