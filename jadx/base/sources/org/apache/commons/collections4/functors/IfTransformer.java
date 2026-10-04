package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IfTransformer<T, R> implements Transformer<T, R>, Serializable {
    private static final long serialVersionUID = 8069309411242014252L;
    private final Transformer<? super T, ? extends R> iFalseTransformer;
    private final Predicate<? super T> iPredicate;
    private final Transformer<? super T, ? extends R> iTrueTransformer;

    public IfTransformer(Predicate<? super T> predicate, Transformer<? super T, ? extends R> transformer, Transformer<? super T, ? extends R> transformer2) {
        this.iPredicate = predicate;
        this.iTrueTransformer = transformer;
        this.iFalseTransformer = transformer2;
    }

    public static <I, O> Transformer<I, O> ifTransformer(Predicate<? super I> predicate, Transformer<? super I, ? extends O> transformer, Transformer<? super I, ? extends O> transformer2) {
        Objects.requireNonNull(predicate, "predicate");
        Objects.requireNonNull(transformer, "trueTransformer");
        Objects.requireNonNull(transformer2, "falseTransformer");
        return new IfTransformer(predicate, transformer, transformer2);
    }

    public Transformer<? super T, ? extends R> getFalseTransformer() {
        return this.iFalseTransformer;
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }

    public Transformer<? super T, ? extends R> getTrueTransformer() {
        return this.iTrueTransformer;
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(T t) {
        return this.iPredicate.test(t) ? this.iTrueTransformer.apply(t) : this.iFalseTransformer.apply(t);
    }

    public static <T> Transformer<T, T> ifTransformer(Predicate<? super T> predicate, Transformer<? super T, ? extends T> transformer) {
        Objects.requireNonNull(predicate, "predicate");
        Objects.requireNonNull(transformer, "trueTransformer");
        return new IfTransformer(predicate, transformer, NOPTransformer.nopTransformer());
    }
}
