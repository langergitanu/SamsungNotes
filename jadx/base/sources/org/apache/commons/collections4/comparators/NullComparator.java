package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.ComparatorUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NullComparator<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = -5820772575483504339L;
    private final Comparator<? super E> nonNullComparator;
    private final boolean nullsAreHigh;

    public NullComparator() {
        this(ComparatorUtils.NATURAL_COMPARATOR, true);
    }

    @Override // java.util.Comparator
    public int compare(E e, E e2) {
        if (e == e2) {
            return 0;
        }
        return e == null ? this.nullsAreHigh ? 1 : -1 : e2 == null ? this.nullsAreHigh ? -1 : 1 : this.nonNullComparator.compare(e, e2);
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

    public NullComparator(boolean z) {
        this(ComparatorUtils.NATURAL_COMPARATOR, z);
    }

    public NullComparator(Comparator<? super E> comparator) {
        this(comparator, true);
    }

    public NullComparator(Comparator<? super E> comparator, boolean z) {
        Objects.requireNonNull(comparator, "nonNullComparator");
        this.nonNullComparator = comparator;
        this.nullsAreHigh = z;
    }
}
