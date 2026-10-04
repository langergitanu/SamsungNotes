package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractPredicate<T> implements Predicate<T> {
    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t) {
        return test(t);
    }
}
