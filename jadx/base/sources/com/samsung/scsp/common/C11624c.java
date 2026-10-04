package com.samsung.scsp.common;

import com.samsung.scsp.error.FaultBarrier;
import java.io.IOException;

/* JADX INFO: renamed from: com.samsung.scsp.common.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11624c implements FaultBarrier.ThrowableRunnable, FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PushVo f8132a;

    public /* synthetic */ C11624c(PushVo pushVo) {
        this.f8132a = pushVo;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        return PushVoFactory.lambda$create$0(this.f8132a);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() throws IOException {
        DeviceHealthCheckPushExecutorImpl.lambda$accept$1(this.f8132a);
    }
}
