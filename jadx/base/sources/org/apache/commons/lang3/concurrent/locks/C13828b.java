package org.apache.commons.lang3.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import org.apache.commons.lang3.concurrent.locks.LockingVisitors;

/* JADX INFO: renamed from: org.apache.commons.lang3.concurrent.locks.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13828b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9813a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ReentrantLock f9814b;

    public /* synthetic */ C13828b(ReentrantLock reentrantLock, int i) {
        this.f9813a = i;
        this.f9814b = reentrantLock;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9813a) {
            case 0:
                return LockingVisitors.ReentrantLockVisitor.lambda$new$0(this.f9814b);
            case 1:
                return LockingVisitors.ReentrantLockVisitor.lambda$new$1(this.f9814b);
            case 2:
                return LockingVisitors.ReentrantLockVisitor.Builder.lambda$setLock$0(this.f9814b);
            default:
                return LockingVisitors.ReentrantLockVisitor.Builder.lambda$setLock$1(this.f9814b);
        }
    }
}
