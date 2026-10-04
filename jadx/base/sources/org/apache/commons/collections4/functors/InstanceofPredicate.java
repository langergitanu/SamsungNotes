package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class InstanceofPredicate extends AbstractPredicate<Object> implements Serializable {
    private static final long serialVersionUID = -6682656911025165584L;
    private final Class<?> iType;

    public InstanceofPredicate(Class<?> cls) {
        this.iType = cls;
    }

    public static Predicate<Object> instanceOfPredicate(Class<?> cls) {
        Objects.requireNonNull(cls, "type");
        return new InstanceofPredicate(cls);
    }

    public Class<?> getType() {
        return this.iType;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(Object obj) {
        return this.iType.isInstance(obj);
    }
}
