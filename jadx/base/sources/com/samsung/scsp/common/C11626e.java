package com.samsung.scsp.common;

import com.samsung.scsp.common.JournalFactory;
import com.samsung.scsp.error.FaultBarrier;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.scsp.common.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11626e implements FaultBarrier.ThrowableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8136a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8137b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8138c;

    public /* synthetic */ C11626e(Object obj, Object obj2, int i) {
        this.f8136a = i;
        this.f8137b = obj;
        this.f8138c = obj2;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableRunnable
    public final void run() {
        switch (this.f8136a) {
            case 0:
                ((JournalFactory.JournalBase) this.f8137b).lambda$apply$1((Consumer) this.f8138c);
                break;
            default:
                ((PushConsumer) this.f8137b).lambda$executeSyncPushExecutor$6((PushVo) this.f8138c);
                break;
        }
    }
}
