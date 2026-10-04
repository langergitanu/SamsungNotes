package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;

/* JADX INFO: renamed from: com.google.firebase.concurrent.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5955c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3480a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Runnable f3481b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ DelegatingScheduledFuture.Completer f3482c;

    public /* synthetic */ RunnableC5955c(Runnable runnable, DelegatingScheduledFuture.Completer completer, int i) {
        this.f3480a = i;
        this.f3481b = runnable;
        this.f3482c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        switch (this.f3480a) {
            case 0:
                DelegatingScheduledExecutorService.lambda$scheduleWithFixedDelay$9(this.f3481b, this.f3482c);
                break;
            case 1:
                DelegatingScheduledExecutorService.lambda$schedule$0(this.f3481b, this.f3482c);
                break;
            default:
                DelegatingScheduledExecutorService.lambda$scheduleAtFixedRate$6(this.f3481b, this.f3482c);
                break;
        }
    }
}
