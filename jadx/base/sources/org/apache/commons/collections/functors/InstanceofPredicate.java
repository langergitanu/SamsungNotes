package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class InstanceofPredicate implements Predicate, Serializable {
    private static final long serialVersionUID = -6682656911025165584L;
    private final Class iType;

    public InstanceofPredicate(Class cls) {
        this.iType = cls;
    }

    public static Predicate getInstance(Class cls) {
        if (cls != null) {
            return new InstanceofPredicate(cls);
        }
        throw new IllegalArgumentException("The type to check instanceof must not be null");
    }

    @Override // org.apache.commons.collections.Predicate
    public boolean evaluate(Object obj) {
        return this.iType.isInstance(obj);
    }

    public Class getType() {
        return this.iType;
    }
}
