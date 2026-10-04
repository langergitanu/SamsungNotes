package com.samsung.android.support.senl.p148nt.app.main.livesharing;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.livesharing.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8327a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6169a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LiveSharingActivity f6170b;

    public /* synthetic */ RunnableC8327a(LiveSharingActivity liveSharingActivity, int i) {
        this.f6169a = i;
        this.f6170b = liveSharingActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6169a) {
            case 0:
                this.f6170b.lambda$showToast$2();
                break;
            default:
                this.f6170b.lambda$importErrorHandler$1();
                break;
        }
    }
}
