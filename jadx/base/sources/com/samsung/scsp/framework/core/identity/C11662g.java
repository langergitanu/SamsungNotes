package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.identity.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11662g implements FaultBarrier.ThrowableRunnable, FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8213a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ UserIdentityImpl f8214b;

    public /* synthetic */ C11662g(UserIdentityImpl userIdentityImpl, int i) {
        this.f8213a = i;
        this.f8214b = userIdentityImpl;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        return this.f8214b.getToken();
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        switch (this.f8213a) {
            case 0:
                this.f8214b.onUnauthenticatedForSA();
                break;
            default:
                this.f8214b.checkUpdate();
                break;
        }
    }
}
