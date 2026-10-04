package com.samsung.scsp.framework.core.decorator;

import com.samsung.scsp.error.FaultBarrier;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.decorator.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11648a implements FaultBarrier.ThrowableSupplier, FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractDecorator f8177a;

    public /* synthetic */ C11648a(AbstractDecorator abstractDecorator) {
        this.f8177a = abstractDecorator;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        return this.f8177a.lambda$new$0();
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() {
        this.f8177a.downloadPlatformConfiguration();
    }
}
