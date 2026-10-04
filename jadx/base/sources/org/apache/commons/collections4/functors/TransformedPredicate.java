package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TransformedPredicate<T> extends AbstractPredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -5596090919668315834L;
    private final Predicate<? super T> iPredicate;
    private final Transformer<? super T, ? extends T> iTransformer;

    public TransformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        this.iTransformer = transformer;
        this.iPredicate = predicate;
    }

    public static <T> Predicate<T> transformedPredicate(Transformer<? super T, ? extends T> transformer, Predicate<? super T> predicate) {
        Objects.requireNonNull(transformer, "transformer");
        Objects.requireNonNull(predicate, "predicate");
        return new TransformedPredicate(transformer, predicate);
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }

    public Transformer<? super T, ? extends T> getTransformer() {
        return this.iTransformer;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return this.iPredicate.test(this.iTransformer.apply(t));
    }
}
