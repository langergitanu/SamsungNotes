package com.samsung.scsp.framework.core.api;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.api.AbstractApi;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.api.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11638b implements FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8157a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Class f8158b;

    public /* synthetic */ C11638b(Class cls, int i) {
        this.f8157a = i;
        this.f8158b = cls;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public final Object get() {
        switch (this.f8157a) {
            case 0:
                return AbstractApi.JobFactory.lambda$create$0(this.f8158b);
            default:
                return this.f8158b.newInstance();
        }
    }
}
