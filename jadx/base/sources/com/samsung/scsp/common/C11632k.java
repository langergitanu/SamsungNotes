package com.samsung.scsp.common;

import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: renamed from: com.samsung.scsp.common.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11632k implements FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8147a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f8148b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f8149c;

    public /* synthetic */ C11632k(String str, String str2, int i) {
        this.f8147a = i;
        this.f8148b = str;
        this.f8149c = str2;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public final Object get() {
        switch (this.f8147a) {
            case 0:
                return PushConsumer.lambda$isValidSignature$3(this.f8148b, this.f8149c);
            default:
                return PushConsumer.lambda$isValidDeviceSignature$5(this.f8148b, this.f8149c);
        }
    }
}
