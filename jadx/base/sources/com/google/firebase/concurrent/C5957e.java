package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.firebase.concurrent.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5957e implements DelegatingScheduledFuture.Resolver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3487a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DelegatingScheduledExecutorService f3488b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Runnable f3489c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ long f3490d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ long f3491e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ TimeUnit f3492f;

    public /* synthetic */ C5957e(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Runnable runnable, long j, long j2, TimeUnit timeUnit, int i) {
        this.f3487a = i;
        this.f3488b = delegatingScheduledExecutorService;
        this.f3489c = runnable;
        this.f3490d = j;
        this.f3491e = j2;
        this.f3492f = timeUnit;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public final ScheduledFuture addCompleter(DelegatingScheduledFuture.Completer completer) {
        switch (this.f3487a) {
            case 0:
                return this.f3488b.lambda$scheduleAtFixedRate$8(this.f3489c, this.f3490d, this.f3491e, this.f3492f, completer);
            default:
                return this.f3488b.lambda$scheduleWithFixedDelay$11(this.f3489c, this.f3490d, this.f3491e, this.f3492f, completer);
        }
    }
}
