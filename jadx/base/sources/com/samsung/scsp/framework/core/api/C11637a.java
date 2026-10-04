package com.samsung.scsp.framework.core.api;

import com.samsung.scsp.error.FaultBarrier;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;

/* JADX INFO: renamed from: com.samsung.scsp.framework.core.api.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11637a implements FaultBarrier.ThrowableRunnable, FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8155a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8156b;

    public /* synthetic */ C11637a(Object obj, int i) {
        this.f8155a = i;
        this.f8156b = obj;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        return AbstractApiControl.lambda$new$0((Constructor) this.f8156b);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public void run() throws IOException {
        switch (this.f8155a) {
            case 0:
                ((AbstractApi) this.f8156b).lambda$new$0();
                break;
            case 1:
            default:
                ((Response) this.f8156b).lambda$toString$0();
                break;
            case 2:
                ((OutputStream) this.f8156b).close();
                break;
        }
    }
}
