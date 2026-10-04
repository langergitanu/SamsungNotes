package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.verify.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8141f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6141a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VerifyMultiBioView f6142b;

    public /* synthetic */ RunnableC8141f(VerifyMultiBioView verifyMultiBioView, int i) {
        this.f6141a = i;
        this.f6142b = verifyMultiBioView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6141a) {
            case 0:
                this.f6142b.finishCancel();
                break;
            default:
                this.f6142b.authenticate();
                break;
        }
    }
}
