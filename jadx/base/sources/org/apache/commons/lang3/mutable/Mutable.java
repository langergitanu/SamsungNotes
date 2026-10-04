package org.apache.commons.lang3.mutable;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Mutable<T> extends Supplier<T> {
    @Override // java.util.function.Supplier
    default T get() {
        return getValue();
    }

    @Deprecated
    T getValue();

    void setValue(T t);
}
