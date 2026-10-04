package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;

/* JADX INFO: renamed from: com.google.common.util.concurrent.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5922f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3428a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractScheduledService.ServiceDelegate f3429b;

    public /* synthetic */ RunnableC5922f(AbstractScheduledService.ServiceDelegate serviceDelegate, int i) {
        this.f3428a = i;
        this.f3429b = serviceDelegate;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3428a) {
            case 0:
                this.f3429b.lambda$doStart$1();
                break;
            default:
                this.f3429b.lambda$doStop$2();
                break;
        }
    }
}
