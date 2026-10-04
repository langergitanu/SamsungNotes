package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9899b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7057a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ HwToolbarPresenter f7058b;

    public /* synthetic */ RunnableC9899b(HwToolbarPresenter hwToolbarPresenter, int i) {
        this.f7057a = i;
        this.f7058b = hwToolbarPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7057a) {
            case 0:
                this.f7058b.lambda$changeWritingMode$2();
                break;
            case 1:
                this.f7058b.lambda$showCleanUpAndCTT$3();
                break;
            default:
                this.f7058b.lambda$changeWritingMode$1();
                break;
        }
    }
}
