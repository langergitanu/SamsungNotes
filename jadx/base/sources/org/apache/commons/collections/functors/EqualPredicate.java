package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class EqualPredicate implements Predicate, Serializable {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Object iValue;

    public EqualPredicate(Object obj) {
        this.iValue = obj;
    }

    public static Predicate getInstance(Object obj) {
        return obj == null ? NullPredicate.INSTANCE : new EqualPredicate(obj);
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return this.iValue.equals(obj);
    }

    public Object getValue() {
        return this.iValue;
    }
}
