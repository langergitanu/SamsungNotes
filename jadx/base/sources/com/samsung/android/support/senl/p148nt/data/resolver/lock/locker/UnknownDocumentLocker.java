package com.samsung.android.support.senl.p148nt.data.resolver.lock.locker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UnknownDocumentLocker implements DocumentLocker {
    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public int getLockType() {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public boolean lock() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.resolver.lock.locker.DocumentLocker
    public boolean unlock() {
        return false;
    }
}
