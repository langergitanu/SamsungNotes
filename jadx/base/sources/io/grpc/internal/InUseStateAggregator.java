package io.grpc.internal;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@NotThreadSafe
public abstract class InUseStateAggregator<T> {
    private final Set<T> inUseObjects = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean anyObjectInUse(Object... objArr) {
        for (Object obj : objArr) {
            if (this.inUseObjects.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void handleInUse();

    public abstract void handleNotInUse();

    public final boolean isInUse() {
        return !this.inUseObjects.isEmpty();
    }

    public final void updateObjectInUse(T t, boolean z) {
        int size = this.inUseObjects.size();
        if (z) {
            this.inUseObjects.add(t);
            if (size == 0) {
                handleInUse();
                return;
            }
            return;
        }
        if (this.inUseObjects.remove(t) && size == 1) {
            handleNotInUse();
        }
    }
}
