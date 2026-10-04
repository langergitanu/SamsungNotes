package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.common.util.concurrent.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ExecutorC5917a implements Executor {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3420a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Service f3421b;

    public /* synthetic */ ExecutorC5917a(Service service, int i) {
        this.f3420a = i;
        this.f3421b = service;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f3420a) {
            case 0:
                ((AbstractExecutionThreadService) this.f3421b).lambda$executor$0(runnable);
                break;
            default:
                ((AbstractIdleService) this.f3421b).lambda$executor$0(runnable);
                break;
        }
    }
}
