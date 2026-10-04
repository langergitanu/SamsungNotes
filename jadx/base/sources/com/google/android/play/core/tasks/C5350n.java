package com.google.android.play.core.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.play.core.tasks.n */
/* JADX INFO: loaded from: classes5.dex */
final class C5350n implements OnSuccessListener, OnFailureListener {

    /* JADX INFO: renamed from: a */
    private final CountDownLatch f3245a = new CountDownLatch(1);

    private C5350n() {
    }

    /* JADX INFO: renamed from: a */
    public final void m4209a() throws InterruptedException {
        this.f3245a.await();
    }

    @Override // com.google.android.play.core.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f3245a.countDown();
    }

    @Override // com.google.android.play.core.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.f3245a.countDown();
    }

    public /* synthetic */ C5350n(byte[] bArr) {
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4210a(long j, TimeUnit timeUnit) {
        return this.f3245a.await(j, timeUnit);
    }
}
