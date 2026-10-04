package com.samsung.android.support.senl.ntnl.base;

/* JADX INFO: renamed from: com.samsung.android.support.senl.ntnl.base.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC11568a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8078a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NtnlDebugger f8079b;

    public /* synthetic */ RunnableC11568a(NtnlDebugger ntnlDebugger, int i) {
        this.f8078a = i;
        this.f8079b = ntnlDebugger;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8078a) {
            case 0:
                this.f8079b.lambda$printCurrentInstancesInfo$0();
                break;
            default:
                this.f8079b.printCurrentInstancesInfo();
                break;
        }
    }
}
