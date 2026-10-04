package com.samsung.scsp.framework.core.identity;

import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.identity.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11665j implements FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8219a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ E2eeInfoSupplier f8220b;

    public /* synthetic */ C11665j(E2eeInfoSupplier e2eeInfoSupplier, int i) {
        this.f8219a = i;
        this.f8220b = e2eeInfoSupplier;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public final Object get() {
        switch (this.f8219a) {
            case 0:
                return UserIdentityImpl.lambda$checkE2eeType$4(this.f8220b);
            default:
                return UserRegisterApiImpl.lambda$makeAppPayload$1(this.f8220b);
        }
    }
}
