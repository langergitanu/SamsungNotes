package com.samsung.android.support.senl.p148nt.coedit.control;

import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.control.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9054j implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6652a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6653b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6654c;

    public /* synthetic */ RunnableC9054j(Object obj, Object obj2, int i) {
        this.f6652a = i;
        this.f6653b = obj;
        this.f6654c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6652a) {
            case 0:
                CoeditHandlerManager.CoeditTask.lambda$release$0((CoeditHandlerManager.IReleasePostAction) this.f6653b, (Runnable) this.f6654c);
                break;
            case 1:
                ((CoeditHandlerManager) this.f6653b).lambda$registerExternalSnap$6((ExternalSnapState) this.f6654c);
                break;
            default:
                ((CoeditHandlerManager) this.f6653b).lambda$requestStopSelf$9((Runnable) this.f6654c);
                break;
        }
    }
}
