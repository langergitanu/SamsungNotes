package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TransformedPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -5596090919668315834L;
    private final Predicate iPredicate;
    private final Transformer iTransformer;

    public TransformedPredicate(Transformer transformer, Predicate predicate) {
        this.iTransformer = transformer;
        this.iPredicate = predicate;
    }

    public static Predicate getInstance(Transformer transformer, Predicate predicate) {
        if (transformer == null) {
            throw new IllegalArgumentException("The transformer to call must not be null");
        }
        if (predicate != null) {
            return new TransformedPredicate(transformer, predicate);
        }
        throw new IllegalArgumentException("The predicate to call must not be null");
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return this.iPredicate.evaluate(this.iTransformer.transform(obj));
    }

    @Override // org.apache.commons.collections.functors.PredicateDecorator
    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }

    public Transformer getTransformer() {
        return this.iTransformer;
    }
}
