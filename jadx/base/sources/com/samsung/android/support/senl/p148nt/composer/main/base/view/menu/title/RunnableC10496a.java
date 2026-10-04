package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10496a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7210a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DetailsViewManager f7211b;

    public /* synthetic */ RunnableC10496a(DetailsViewManager detailsViewManager, int i) {
        this.f7210a = i;
        this.f7211b = detailsViewManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7210a) {
            case 0:
                this.f7211b.lambda$init$0();
                break;
            default:
                this.f7211b.lambda$init$1();
                break;
        }
    }
}
