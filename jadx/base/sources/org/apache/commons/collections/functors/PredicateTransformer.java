package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicateTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = 5278818408044349346L;
    private final Predicate iPredicate;

    public PredicateTransformer(Predicate predicate) {
        this.iPredicate = predicate;
    }

    public static Transformer getInstance(Predicate predicate) {
        if (predicate != null) {
            return new PredicateTransformer(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public Predicate getPredicate() {
        return this.iPredicate;
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        return this.iPredicate.evaluate(obj) ? Boolean.TRUE : Boolean.FALSE;
    }
}
