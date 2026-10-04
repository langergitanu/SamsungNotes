package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class BooleanComparator implements Comparator, Serializable {
    private static final long serialVersionUID = 1830042991606340609L;
    private boolean trueFirst;
    private static final BooleanComparator TRUE_FIRST = new BooleanComparator(true);
    private static final BooleanComparator FALSE_FIRST = new BooleanComparator(false);

    public BooleanComparator() {
        this(false);
    }

    public static BooleanComparator getBooleanComparator(boolean z) {
        return z ? TRUE_FIRST : FALSE_FIRST;
    }

    public static BooleanComparator getFalseFirstComparator() {
        return FALSE_FIRST;
    }

    public static BooleanComparator getTrueFirstComparator() {
        return TRUE_FIRST;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return compare((Boolean) obj, (Boolean) obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BooleanComparator) && this.trueFirst == ((BooleanComparator) obj).trueFirst;
        }
        return true;
    }

    public int hashCode() {
        return this.trueFirst ? -478003966 : 478003966;
    }

    public boolean sortsTrueFirst() {
        return this.trueFirst;
    }

    public BooleanComparator(boolean z) {
        this.trueFirst = z;
    }

    public int compare(Boolean bool, Boolean bool2) {
        boolean zBooleanValue = bool.booleanValue();
        if (bool2.booleanValue() ^ zBooleanValue) {
            return zBooleanValue ^ this.trueFirst ? 1 : -1;
        }
        return 0;
    }
}
