package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ComparableComparator<E extends Comparable<? super E>> implements Comparator<E>, Serializable {
    public static final ComparableComparator INSTANCE = new ComparableComparator();
    private static final long serialVersionUID = -291439688585137865L;

    public static <E extends Comparable<? super E>> ComparableComparator<E> comparableComparator() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this != obj) {
            return obj != null && obj.getClass().equals(getClass());
        }
        return true;
    }

    public int hashCode() {
        return 1769708912;
    }

    @Override // java.util.Comparator
    public int compare(E e, E e2) {
        return e.compareTo(e2);
    }
}
