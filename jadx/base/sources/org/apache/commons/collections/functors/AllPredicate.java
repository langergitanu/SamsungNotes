package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class AllPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -3094696765038308799L;
    private final Predicate[] iPredicates;

    public AllPredicate(Predicate[] predicateArr) {
        this.iPredicates = predicateArr;
    }

    public static Predicate getInstance(Predicate[] predicateArr) {
        FunctorUtils.validate(predicateArr);
        return predicateArr.length == 0 ? TruePredicate.INSTANCE : predicateArr.length == 1 ? predicateArr[0] : new AllPredicate(FunctorUtils.copy(predicateArr));
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        int i = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i >= predicateArr.length) {
                return true;
            }
            if (!predicateArr[i].evaluate(obj)) {
                return false;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public static Predicate getInstance(Collection collection) {
        Predicate[] predicateArrValidate = FunctorUtils.validate(collection);
        if (predicateArrValidate.length == 0) {
            return TruePredicate.INSTANCE;
        }
        if (predicateArrValidate.length == 1) {
            return predicateArrValidate[0];
        }
        return new AllPredicate(predicateArrValidate);
    }
}
