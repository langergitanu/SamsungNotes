package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class IdentityPredicate implements Predicate, Serializable {
    private static final long serialVersionUID = -89901658494523293L;
    private final Object iValue;

    public IdentityPredicate(Object obj) {
        this.iValue = obj;
    }

    public static Predicate getInstance(Object obj) {
        return obj == null ? NullPredicate.INSTANCE : new IdentityPredicate(obj);
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return this.iValue == obj;
    }

    public Object getValue() {
        return this.iValue;
    }
}
