package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class OnePredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -8125389089924745785L;
    private final Predicate[] iPredicates;

    public OnePredicate(Predicate[] predicateArr) {
        this.iPredicates = predicateArr;
    }

    public static Predicate getInstance(Predicate[] predicateArr) {
        FunctorUtils.validate(predicateArr);
        return predicateArr.length == 0 ? FalsePredicate.INSTANCE : predicateArr.length == 1 ? predicateArr[0] : new OnePredicate(FunctorUtils.copy(predicateArr));
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        int i = 0;
        boolean z = false;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i >= predicateArr.length) {
                return z;
            }
            if (predicateArr[i].evaluate(obj)) {
                if (z) {
                    return false;
                }
                z = true;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public static Predicate getInstance(Collection collection) {
        return new OnePredicate(FunctorUtils.validate(collection));
    }
}
