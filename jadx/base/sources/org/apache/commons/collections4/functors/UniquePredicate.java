package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class UniquePredicate<T> extends AbstractPredicate<T> implements Serializable {
    private static final long serialVersionUID = -3319417438027438040L;
    private final Set<T> iSet = new HashSet();

    public static <T> Predicate<T> uniquePredicate() {
        return new UniquePredicate();
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return this.iSet.add(t);
    }
}
