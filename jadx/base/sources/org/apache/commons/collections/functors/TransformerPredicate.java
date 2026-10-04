package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TransformerPredicate implements Predicate, Serializable {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer iTransformer;

    public TransformerPredicate(Transformer transformer) {
        this.iTransformer = transformer;
    }

    public static Predicate getInstance(Transformer transformer) {
        if (transformer != null) {
            return new TransformerPredicate(transformer);
        }
        throw new IllegalArgumentException("The transformer to call must not be null");
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        Object objTransform = this.iTransformer.transform(obj);
        if (objTransform instanceof Boolean) {
            return ((Boolean) objTransform).booleanValue();
        }
        throw new FunctorException("Transformer must return an instanceof Boolean, it was a ".concat(objTransform == null ? "null object" : objTransform.getClass().getName()));
    }

    public Transformer getTransformer() {
        return this.iTransformer;
    }
}
