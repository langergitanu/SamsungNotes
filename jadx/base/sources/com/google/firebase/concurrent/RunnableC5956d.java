package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* JADX INFO: renamed from: com.google.firebase.concurrent.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5956d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3483a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DelegatingScheduledExecutorService f3484b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Runnable f3485c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f3486d;

    public /* synthetic */ RunnableC5956d(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.f3483a = i;
        this.f3484b = delegatingScheduledExecutorService;
        this.f3485c = runnable;
        this.f3486d = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3483a) {
            case 0:
                this.f3484b.lambda$scheduleWithFixedDelay$10(this.f3485c, this.f3486d);
                break;
            case 1:
                this.f3484b.lambda$scheduleAtFixedRate$7(this.f3485c, this.f3486d);
                break;
            default:
                this.f3484b.lambda$schedule$1(this.f3485c, this.f3486d);
                break;
        }
    }
}
