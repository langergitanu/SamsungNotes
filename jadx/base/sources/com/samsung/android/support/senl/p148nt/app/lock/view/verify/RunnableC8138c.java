package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.verify.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8138c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6133a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VerifyIrisViewUnderQ f6134b;

    public /* synthetic */ RunnableC8138c(VerifyIrisViewUnderQ verifyIrisViewUnderQ, int i) {
        this.f6133a = i;
        this.f6134b = verifyIrisViewUnderQ;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6133a) {
            case 0:
                this.f6134b.authenticate();
                break;
            default:
                this.f6134b.finishCancel();
                break;
        }
    }
}
