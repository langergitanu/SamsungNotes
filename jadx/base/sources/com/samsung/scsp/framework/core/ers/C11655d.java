package com.samsung.scsp.framework.core.ers;

import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.network.HttpRequest;
import com.samsung.scsp.framework.core.network.Network;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.ers.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11655d implements FaultBarrier.ThrowableSupplier, Network.StreamListener, FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Object f8195a;

    public /* synthetic */ C11655d(Object obj) {
        this.f8195a = obj;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        return ErsImpl.lambda$getMaxAge$5((List) this.f8195a);
    }

    @Override // com.samsung.scsp.framework.core.network.Network.StreamListener
    public void onStream(HttpRequest httpRequest, Map map, InputStream inputStream) {
        ((ErsImpl) this.f8195a).lambda$execute$4(httpRequest, map, inputStream);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() throws InterruptedException {
        ((Thread) this.f8195a).join();
    }
}
