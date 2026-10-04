package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p207n1.C13534a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class FutureC6876c implements Future {

    /* JADX INFO: renamed from: a */
    public final CompletableFuture f4395a = new CompletableFuture();

    /* JADX INFO: renamed from: a */
    public final void m5070a(C13534a c13534a) {
        this.f4395a.complete(c13534a);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.f4395a.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f4395a.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f4395a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f4395a.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.f4395a.get(j, timeUnit);
    }
}
