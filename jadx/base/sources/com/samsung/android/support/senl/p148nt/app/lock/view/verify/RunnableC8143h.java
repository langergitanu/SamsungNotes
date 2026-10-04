package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.verify.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8143h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6145a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VerifyPasswordView f6146b;

    public /* synthetic */ RunnableC8143h(VerifyPasswordView verifyPasswordView, int i) {
        this.f6145a = i;
        this.f6146b = verifyPasswordView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6145a) {
            case 0:
                this.f6146b.lambda$showProgress$2();
                break;
            default:
                this.f6146b.lambda$hideProgress$3();
                break;
        }
    }
}
