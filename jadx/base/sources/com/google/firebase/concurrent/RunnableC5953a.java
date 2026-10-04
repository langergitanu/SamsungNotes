package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.google.firebase.concurrent.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5953a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3472a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3473b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3474c;

    public /* synthetic */ RunnableC5953a(Object obj, Object obj2, int i) {
        this.f3472a = i;
        this.f3473b = obj;
        this.f3474c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3472a) {
            case 0:
                ((CustomThreadFactory) this.f3473b).lambda$newThread$0((Runnable) this.f3474c);
                break;
            default:
                DelegatingScheduledExecutorService.lambda$schedule$3((Callable) this.f3473b, (DelegatingScheduledFuture.Completer) this.f3474c);
                break;
        }
    }
}
