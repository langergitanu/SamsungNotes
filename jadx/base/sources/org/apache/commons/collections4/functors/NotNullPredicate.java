package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class NotNullPredicate<T> extends AbstractPredicate<T> implements Serializable {
    public static final Predicate INSTANCE = new NotNullPredicate();
    private static final long serialVersionUID = 7533784454832764388L;

    private NotNullPredicate() {
    }

    public static <T> Predicate<T> notNullPredicate() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(T t) {
        return t != null;
    }
}
