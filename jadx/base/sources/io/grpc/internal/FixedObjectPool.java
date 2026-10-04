package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class FixedObjectPool<T> implements ObjectPool<T> {
    private final T object;

    public FixedObjectPool(T t) {
        this.object = (T) Preconditions.checkNotNull(t, CoeditServiceConstants.Element.NAME_OBJECT);
    }

    @Override // io.grpc.internal.ObjectPool
    public T getObject() {
        return this.object;
    }

    @Override // io.grpc.internal.ObjectPool
    public T returnObject(Object obj) {
        return null;
    }
}
