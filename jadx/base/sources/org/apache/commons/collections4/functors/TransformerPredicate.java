package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TransformerPredicate<T> extends AbstractPredicate<T> implements Serializable {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer<? super T, Boolean> iTransformer;

    public TransformerPredicate(Transformer<? super T, Boolean> transformer) {
        this.iTransformer = transformer;
    }

    public static <T> Predicate<T> transformerPredicate(Transformer<? super T, Boolean> transformer) {
        Objects.requireNonNull(transformer, "transformer");
        return new TransformerPredicate(transformer);
    }

    public Transformer<? super T, Boolean> getTransformer() {
        return this.iTransformer;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        Boolean boolApply = this.iTransformer.apply(t);
        if (boolApply != null) {
            return boolApply.booleanValue();
        }
        throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
    }
}
