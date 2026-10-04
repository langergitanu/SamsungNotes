package com.samsung.scsp.framework.core.api;

import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.api.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11643g implements FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8168a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8169b;

    public /* synthetic */ C11643g(Object obj, int i) {
        this.f8168a = i;
        this.f8169b = obj;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public final Object get() {
        switch (this.f8168a) {
            case 0:
                return SCHashMap.lambda$getAsInteger$1(this.f8169b);
            case 1:
                return SCHashMap.lambda$getAsLong$0(this.f8169b);
            default:
                return SCHashMap.lambda$getAsBoolean$2(this.f8169b);
        }
    }
}
