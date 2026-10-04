package com.samsung.scsp.common;

import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: renamed from: com.samsung.scsp.common.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11631j implements FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8146a;

    public /* synthetic */ C11631j(int i) {
        this.f8146a = i;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public final Object get() {
        switch (this.f8146a) {
            case 0:
                return PushConsumer.lambda$isValidSignature$2();
            default:
                return PushConsumer.lambda$isValidDeviceSignature$4();
        }
    }
}
