package com.samsung.android.support.senl.p148nt.app.lock.view.base;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.base.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8122a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6122a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbsPasswordView f6123b;

    public /* synthetic */ RunnableC8122a(AbsPasswordView absPasswordView, int i) {
        this.f6122a = i;
        this.f6123b = absPasswordView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6122a) {
            case 0:
                this.f6123b.lambda$hideProgress$2();
                break;
            case 1:
                this.f6123b.lambda$showProgress$1();
                break;
            default:
                this.f6123b.lambda$requestFocusToPasswordInput$4();
                break;
        }
    }
}
