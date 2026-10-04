package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicateTransformer<T> implements Transformer<T, Boolean>, Serializable {
    private static final long serialVersionUID = 5278818408044349346L;
    private final Predicate<? super T> iPredicate;

    public PredicateTransformer(Predicate<? super T> predicate) {
        this.iPredicate = predicate;
    }

    public static <T> Transformer<T, Boolean> predicateTransformer(Predicate<? super T> predicate) {
        if (predicate != null) {
            return new PredicateTransformer(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.collections4.Transformer
    public Boolean transform(T t) {
        return Boolean.valueOf(this.iPredicate.test(t));
    }
}
