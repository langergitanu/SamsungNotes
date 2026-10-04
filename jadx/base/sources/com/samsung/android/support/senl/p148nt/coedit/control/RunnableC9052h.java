package com.samsung.android.support.senl.p148nt.coedit.control;

import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.common.CoeditControlCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.common.SnapControlCallback;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.control.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9052h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6642a = 1;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CoeditHandlerManager.CoeditTask f6643b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f6644c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f6645d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f6646e;

    public /* synthetic */ RunnableC9052h(CoeditHandlerManager.CoeditTask coeditTask, CoeditHandlerManager.IReleasePostAction iReleasePostAction, Runnable runnable, String str) {
        this.f6643b = coeditTask;
        this.f6645d = iReleasePostAction;
        this.f6646e = runnable;
        this.f6644c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6642a) {
            case 0:
                this.f6643b.lambda$internalSnapRestart$4(this.f6644c, (SnapControlCallback) this.f6645d, (CoeditControlCallback) this.f6646e);
                break;
            default:
                this.f6643b.lambda$release$2((CoeditHandlerManager.IReleasePostAction) this.f6645d, (Runnable) this.f6646e, this.f6644c);
                break;
        }
    }

    public /* synthetic */ RunnableC9052h(CoeditHandlerManager.CoeditTask coeditTask, String str, SnapControlCallback snapControlCallback, CoeditControlCallback coeditControlCallback) {
        this.f6643b = coeditTask;
        this.f6644c = str;
        this.f6645d = snapControlCallback;
        this.f6646e = coeditControlCallback;
    }
}
