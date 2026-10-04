package org.apache.commons.lang3.concurrent.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.lang3.concurrent.locks.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13827a implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9811a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ReadWriteLock f9812b;

    public /* synthetic */ C13827a(ReadWriteLock readWriteLock, int i) {
        this.f9811a = i;
        this.f9812b = readWriteLock;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9811a) {
            case 0:
                return this.f9812b.readLock();
            default:
                return this.f9812b.writeLock();
        }
    }
}
