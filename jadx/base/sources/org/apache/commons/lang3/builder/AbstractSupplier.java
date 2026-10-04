package org.apache.commons.lang3.builder;

import java.lang.Throwable;
import org.apache.commons.lang3.builder.AbstractSupplier;
import org.apache.commons.lang3.function.FailableSupplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractSupplier<T, B extends AbstractSupplier<T, B, E>, E extends Throwable> implements FailableSupplier<T, E> {
    public B asThis() {
        return this;
    }
}
