package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableCollection;

/* JADX INFO: renamed from: com.google.common.util.concurrent.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5924h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3434a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3435b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3436c;

    public /* synthetic */ RunnableC5924h(Object obj, Object obj2, int i) {
        this.f3434a = i;
        this.f3435b = obj;
        this.f3436c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3434a) {
            case 0:
                ((AggregateFuture) this.f3435b).lambda$init$1((ImmutableCollection) this.f3436c);
                break;
            default:
                Callables.lambda$threadRenaming$3((Supplier) this.f3435b, (Runnable) this.f3436c);
                break;
        }
    }
}
