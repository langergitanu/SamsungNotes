package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

/* JADX INFO: renamed from: com.google.common.util.concurrent.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5923g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3430a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f3431b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3432c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f3433d;

    public /* synthetic */ RunnableC5923g(Object obj, Object obj2, int i, int i2) {
        this.f3430a = i2;
        this.f3432c = obj;
        this.f3433d = obj2;
        this.f3431b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3430a) {
            case 0:
                ((AggregateFuture) this.f3432c).lambda$init$0((ListenableFuture) this.f3433d, this.f3431b);
                break;
            default:
                Futures.InCompletionOrderState.access$600((Futures.InCompletionOrderState) this.f3432c, (ImmutableList) this.f3433d, this.f3431b);
                break;
        }
    }
}
