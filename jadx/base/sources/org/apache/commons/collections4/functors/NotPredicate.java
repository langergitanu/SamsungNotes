package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class NotPredicate<T> extends AbstractPredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -2654603322338049674L;
    private final Predicate<? super T> iPredicate;

    public NotPredicate(Predicate<? super T> predicate) {
        this.iPredicate = predicate;
    }

    public static <T> Predicate<T> notPredicate(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate");
        return new NotPredicate(predicate);
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return !this.iPredicate.test(t);
    }
}
