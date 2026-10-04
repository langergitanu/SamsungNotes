package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class NotPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -2654603322338049674L;
    private final Predicate iPredicate;

    public NotPredicate(Predicate predicate) {
        this.iPredicate = predicate;
    }

    public static Predicate getInstance(Predicate predicate) {
        if (predicate != null) {
            return new NotPredicate(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return !this.iPredicate.evaluate(obj);
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
