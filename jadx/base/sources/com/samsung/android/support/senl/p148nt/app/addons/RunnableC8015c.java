package com.samsung.android.support.senl.p148nt.app.addons;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.addons.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8015c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6063a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AddonsProgressController f6064b;

    public /* synthetic */ RunnableC8015c(AddonsProgressController addonsProgressController, int i) {
        this.f6063a = i;
        this.f6064b = addonsProgressController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6063a) {
            case 0:
                AddonsProgressController.hideProgress$lambda$4(this.f6064b);
                break;
            default:
                AddonsProgressController.showProgress$lambda$2(this.f6064b);
                break;
        }
    }
}
