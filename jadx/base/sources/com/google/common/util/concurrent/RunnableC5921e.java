package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;

/* JADX INFO: renamed from: com.google.common.util.concurrent.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC5921e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3426a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractIdleService.DelegateService f3427b;

    public /* synthetic */ RunnableC5921e(AbstractIdleService.DelegateService delegateService, int i) {
        this.f3426a = i;
        this.f3427b = delegateService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3426a) {
            case 0:
                this.f3427b.lambda$doStop$1();
                break;
            default:
                this.f3427b.lambda$doStart$0();
                break;
        }
    }
}
