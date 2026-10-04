package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9343c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6810a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiDrawingManager f6811b;

    public /* synthetic */ RunnableC9343c(AiDrawingManager aiDrawingManager, int i) {
        this.f6810a = i;
        this.f6811b = aiDrawingManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6810a) {
            case 0:
                this.f6811b.lambda$dismissPopup$5();
                break;
            default:
                this.f6811b.lambda$startCreateImage$2();
                break;
        }
    }
}
