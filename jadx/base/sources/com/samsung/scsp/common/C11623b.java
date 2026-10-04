package com.samsung.scsp.common;

import com.samsung.scsp.common.ContextFactory;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.scsp.common.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11623b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8131a;

    public /* synthetic */ C11623b(int i) {
        this.f8131a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8131a) {
            case 0:
                return ContextFactory.ContextHolder.lambda$new$0();
            case 1:
                return ContextFactory.ContextHolder.lambda$new$1();
            default:
                return PushConsumer.lambda$new$0();
        }
    }
}
