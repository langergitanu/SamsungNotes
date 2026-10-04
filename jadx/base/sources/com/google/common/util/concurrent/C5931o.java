package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: renamed from: com.google.common.util.concurrent.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5931o implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3451a;

    public /* synthetic */ C5931o(int i) {
        this.f3451a = i;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f3451a) {
            case 0:
                return new Striped.WeakSafeReadWriteLock();
            case 1:
                return new Striped.PaddedLock();
            case 2:
                return Striped.lambda$lazyWeakLock$0();
            default:
                return new ReentrantReadWriteLock();
        }
    }
}
