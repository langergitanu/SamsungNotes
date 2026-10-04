package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class AnyPredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = 7429999530934647542L;

    public AnyPredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<? super T>> collection) {
        Predicate<T>[] predicateArrValidate = FunctorUtils.validate(collection);
        return predicateArrValidate.length == 0 ? FalsePredicate.falsePredicate() : predicateArrValidate.length == 1 ? predicateArrValidate[0] : new AnyPredicate(predicateArrValidate);
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.test(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> Predicate<T> anyPredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        if (predicateArr.length == 1) {
            return (Predicate<T>) predicateArr[0];
        }
        return new AnyPredicate((Predicate[]) FunctorUtils.copy(predicateArr));
    }
}
