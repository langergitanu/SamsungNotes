package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class IdentityPredicate<T> extends AbstractPredicate<T> implements Serializable {
    private static final long serialVersionUID = -89901658494523293L;
    private final T iValue;

    public IdentityPredicate(T t) {
        this.iValue = t;
    }

    public static <T> Predicate<T> identityPredicate(T t) {
        return t == null ? NullPredicate.nullPredicate() : new IdentityPredicate(t);
    }

    public T getValue() {
        return this.iValue;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return this.iValue == t;
    }
}
