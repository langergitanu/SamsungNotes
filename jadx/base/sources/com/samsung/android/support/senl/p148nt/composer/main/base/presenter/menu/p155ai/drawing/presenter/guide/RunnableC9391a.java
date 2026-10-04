package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.guide;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.guide.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9391a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6847a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiDrawingGuidePresenter f6848b;

    public /* synthetic */ RunnableC9391a(AiDrawingGuidePresenter aiDrawingGuidePresenter, int i) {
        this.f6847a = i;
        this.f6848b = aiDrawingGuidePresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6847a) {
            case 0:
                this.f6848b.lambda$dismiss$2();
                break;
            default:
                this.f6848b.lambda$dismiss$1();
                break;
        }
    }
}
