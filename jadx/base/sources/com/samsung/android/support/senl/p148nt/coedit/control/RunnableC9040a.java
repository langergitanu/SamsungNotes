package com.samsung.android.support.senl.p148nt.coedit.control;

import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.control.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9040a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6609a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6610b;

    public /* synthetic */ RunnableC9040a(Object obj, int i) {
        this.f6609a = i;
        this.f6610b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6609a) {
            case 0:
                ((CoeditHandlerManager) this.f6610b).lambda$checkWaitingExternalSnap$8();
                break;
            case 1:
                ((CoeditHandlerManager) this.f6610b).lambda$checkCoeditWithComposerRunningState$5();
                break;
            case 2:
                ((CoeditHandlerManager) this.f6610b).lambda$clearWaitingExternalSnap$10();
                break;
            default:
                CoeditHandlerManager.CoeditTask.lambda$release$1((CoeditHandlerManager.IReleasePostAction) this.f6610b);
                break;
        }
    }
}
