package org.apache.commons.collections4.comparators;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FixedOrderComparator<T> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 82794675842863201L;
    private int counter;
    private boolean isLocked;
    private final Map<T, Integer> map = new HashMap();
    private UnknownObjectBehavior unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum UnknownObjectBehavior {
        BEFORE,
        AFTER,
        EXCEPTION
    }

    public FixedOrderComparator() {
    }

    public boolean add(T t) {
        checkLocked();
        Map<T, Integer> map = this.map;
        int i = this.counter;
        this.counter = i + 1;
        return map.put(t, Integer.valueOf(i)) == null;
    }

    public boolean addAsEqual(T t, T t2) {
        checkLocked();
        Integer num = this.map.get(t);
        if (num != null) {
            return this.map.put(t2, num) == null;
        }
        throw new IllegalArgumentException(t + " not known to " + this);
    }

    public void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        this.isLocked = true;
        Integer num = this.map.get(t);
        Integer num2 = this.map.get(t2);
        if (num != null && num2 != null) {
            return num.compareTo(num2);
        }
        int iOrdinal = this.unknownObjectBehavior.ordinal();
        if (iOrdinal == 0) {
            if (num == null) {
                return num2 == null ? 0 : -1;
            }
            return 1;
        }
        if (iOrdinal == 1) {
            if (num == null) {
                return num2 == null ? 0 : 1;
            }
            return -1;
        }
        if (iOrdinal == 2) {
            if (num != null) {
                t = t2;
            }
            throw new IllegalArgumentException(AbstractC0541b.m769k(t, "Attempting to compare unknown object "));
        }
        throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.unknownObjectBehavior);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FixedOrderComparator fixedOrderComparator = (FixedOrderComparator) obj;
        return this.counter == fixedOrderComparator.counter && this.isLocked == fixedOrderComparator.isLocked && Objects.equals(this.map, fixedOrderComparator.map) && this.unknownObjectBehavior == fixedOrderComparator.unknownObjectBehavior;
    }

    public UnknownObjectBehavior getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.counter), Boolean.valueOf(this.isLocked), this.map, this.unknownObjectBehavior);
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setUnknownObjectBehavior(UnknownObjectBehavior unknownObjectBehavior) {
        checkLocked();
        Objects.requireNonNull(unknownObjectBehavior, "unknownObjectBehavior");
        this.unknownObjectBehavior = unknownObjectBehavior;
    }

    public FixedOrderComparator(List<T> list) {
        Objects.requireNonNull(list, "items");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public FixedOrderComparator(T... tArr) {
        Objects.requireNonNull(tArr, "items");
        for (T t : tArr) {
            add(t);
        }
    }
}
