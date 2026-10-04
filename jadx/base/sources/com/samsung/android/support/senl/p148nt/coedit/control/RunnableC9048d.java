package com.samsung.android.support.senl.p148nt.coedit.control;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.control.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9048d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6623a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CoeditHandlerManager f6624b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f6625c;

    public /* synthetic */ RunnableC9048d(CoeditHandlerManager coeditHandlerManager, String str, int i) {
        this.f6623a = i;
        this.f6624b = coeditHandlerManager;
        this.f6625c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6623a) {
            case 0:
                this.f6624b.lambda$unregisterRunningStateListener$4(this.f6625c);
                break;
            default:
                this.f6624b.lambda$unregisterExternalSnap$7(this.f6625c);
                break;
        }
    }
}
