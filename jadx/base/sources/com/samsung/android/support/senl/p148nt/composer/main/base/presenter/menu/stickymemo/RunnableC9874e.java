package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9874e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7033a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StickyMemoManager f7034b;

    public /* synthetic */ RunnableC9874e(StickyMemoManager stickyMemoManager, int i) {
        this.f7033a = i;
        this.f7034b = stickyMemoManager;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        switch (this.f7033a) {
            case 0:
                StickyMemoManager.addStickyMemo$lambda$7(this.f7034b);
                break;
            default:
                StickyMemoManager.releaseHidingWork$lambda$18(this.f7034b);
                break;
        }
    }
}
