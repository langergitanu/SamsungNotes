package com.opencsv.bean.comparator;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.apache.commons.collections4.comparators.ComparableComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.apache.commons.collections4.comparators.FixedOrderComparator;
import org.apache.commons.collections4.comparators.NullComparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class LiteralComparator<T extends Comparable<T>> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: c */
    private Comparator<T> f3676c;

    public LiteralComparator(T[] tArr) {
        FixedOrderComparator fixedOrderComparator = new FixedOrderComparator(tArr == null ? Collections.EMPTY_LIST : Arrays.asList(tArr));
        fixedOrderComparator.setUnknownObjectBehavior(FixedOrderComparator.UnknownObjectBehavior.AFTER);
        this.f3676c = new ComparatorChain(Arrays.asList(fixedOrderComparator, new NullComparator(false), new ComparableComparator()));
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return this.f3676c.compare(t, t2);
    }
}
