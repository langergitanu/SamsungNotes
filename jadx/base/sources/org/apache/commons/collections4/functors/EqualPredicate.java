package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class EqualPredicate<T> extends AbstractPredicate<T> implements Serializable {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Equator<T> equator;
    private final T test;

    public EqualPredicate(T t) {
        this(t, null);
    }

    public static <T> Predicate<T> equalPredicate(T t) {
        return t == null ? NullPredicate.nullPredicate() : new EqualPredicate(t);
    }

    public Object getValue() {
        return this.test;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        Equator<T> equator = this.equator;
        return equator != null ? equator.equate(this.test, t) : Objects.equals(this.test, t);
    }

    public EqualPredicate(T t, Equator<T> equator) {
        this.test = t;
        this.equator = equator;
    }

    public static <T> Predicate<T> equalPredicate(T t, Equator<T> equator) {
        if (t == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t, equator);
    }
}
