package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.ScspException;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.identity.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11661f implements FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8211a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ScspUserIdentity f8212b;

    public /* synthetic */ C11661f(ScspUserIdentity scspUserIdentity, int i) {
        this.f8211a = i;
        this.f8212b = scspUserIdentity;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public final void run() throws ScspException {
        switch (this.f8211a) {
            case 0:
                this.f8212b.lambda$updatePush$4();
                break;
            case 1:
                this.f8212b.lambda$onRegistrationRequired$2();
                break;
            case 2:
                this.f8212b.lambda$renewToken$1();
                break;
            case 3:
                this.f8212b.lambda$updateDeviceInfo$3();
                break;
            default:
                this.f8212b.lambda$initialize$0();
                break;
        }
    }
}
