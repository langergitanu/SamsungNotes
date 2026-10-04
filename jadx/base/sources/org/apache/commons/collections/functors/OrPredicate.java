package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class OrPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -8791518325735182855L;
    private final Predicate iPredicate1;
    private final Predicate iPredicate2;

    public OrPredicate(Predicate predicate, Predicate predicate2) {
        this.iPredicate1 = predicate;
        this.iPredicate2 = predicate2;
    }

    public static Predicate getInstance(Predicate predicate, Predicate predicate2) {
        if (predicate == null || predicate2 == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        return new OrPredicate(predicate, predicate2);
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return this.iPredicate1.evaluate(obj) || this.iPredicate2.evaluate(obj);
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate1, this.iPredicate2};
    }
}
