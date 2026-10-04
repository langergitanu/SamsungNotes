package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.guide;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10271a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7160a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiDrawingGuide f7161b;

    public /* synthetic */ RunnableC10271a(AiDrawingGuide aiDrawingGuide, int i) {
        this.f7160a = i;
        this.f7161b = aiDrawingGuide;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7160a) {
            case 0:
                this.f7161b.lambda$updateGuideLayout$3();
                break;
            default:
                this.f7161b.lambda$showContainer$2();
                break;
        }
    }
}
