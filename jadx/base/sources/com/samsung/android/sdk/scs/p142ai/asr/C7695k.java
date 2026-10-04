package com.samsung.android.sdk.scs.p142ai.asr;

import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.asr.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7695k implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5148a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5149b;

    public /* synthetic */ C7695k(Object obj, int i) {
        this.f5148a = i;
        this.f5149b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5148a) {
            case 0:
                ((RemoteServiceExecutor) this.f5149b).deInitWhenIdle((Runnable) obj);
                break;
            default:
                ((ArrayList) this.f5149b).add((String) obj);
                break;
        }
    }
}
