package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class AllPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -3094696765038308799L;

    public AllPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public static <T> Predicate<T> allPredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate[] predicateArrValidate = FunctorUtils.validate(collection);
        return predicateArrValidate.length == 0 ? TruePredicate.truePredicate() : predicateArrValidate.length == 1 ? (Predicate) FunctorUtils.coerce(predicateArrValidate[0]) : new AllPredicate(predicateArrValidate);
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }

    public static <T> Predicate<T> allPredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return TruePredicate.truePredicate();
        }
        if (predicateArr.length == 1) {
            return (Predicate) FunctorUtils.coerce(predicateArr[0]);
        }
        return new AllPredicate((Predicate[]) FunctorUtils.copy(predicateArr));
    }
}
