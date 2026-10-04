package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.firebase.concurrent.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5954b implements DelegatingScheduledFuture.Resolver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3475a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DelegatingScheduledExecutorService f3476b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ long f3477c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ TimeUnit f3478d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f3479e;

    public /* synthetic */ C5954b(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Object obj, long j, TimeUnit timeUnit, int i) {
        this.f3475a = i;
        this.f3476b = delegatingScheduledExecutorService;
        this.f3479e = obj;
        this.f3477c = j;
        this.f3478d = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        switch (this.f3475a) {
            case 0:
                return this.f3476b.lambda$schedule$2((Runnable) this.f3479e, this.f3477c, this.f3478d, completer);
            default:
                return this.f3476b.lambda$schedule$5((Callable) this.f3479e, this.f3477c, this.f3478d, completer);
        }
    }
}
