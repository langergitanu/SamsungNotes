package com.samsung.android.support.senl.p148nt.app.account;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.account.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8006a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6056a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ GUIDManager f6057b;

    public /* synthetic */ RunnableC8006a(GUIDManager gUIDManager, int i) {
        this.f6056a = i;
        this.f6057b = gUIDManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6056a) {
            case 0:
                this.f6057b.lambda$showOverlayProgress$3();
                break;
            case 1:
                this.f6057b.lambda$hideOverlayProgress$4();
                break;
            case 2:
                this.f6057b.lambda$requestAndWaitGuidReceived$0();
                break;
            default:
                this.f6057b.lambda$requestAndWaitGuidReceived$1();
                break;
        }
    }
}
