package com.samsung.scsp.pam.kps.lite;

import com.samsung.scsp.common.Holder;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.api.ApiContext;
import com.samsung.scsp.framework.core.listeners.ListenersHolder;

/* JADX INFO: renamed from: com.samsung.scsp.pam.kps.lite.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11690a implements FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8252a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8253b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8254c;

    public /* synthetic */ C11690a(Object obj, Object obj2, int i) {
        this.f8252a = i;
        this.f8253b = obj;
        this.f8254c = obj2;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public final void run() throws InterruptedException {
        switch (this.f8252a) {
            case 0:
                JoinRequestImpl.lambda$sendHasServiceKey$0((ApiContext) this.f8253b, (ListenersHolder) this.f8254c);
                break;
            default:
                ScspKpsLite.lambda$requestKeySync$3((Thread) this.f8253b, (Holder) this.f8254c);
                break;
        }
    }
}
