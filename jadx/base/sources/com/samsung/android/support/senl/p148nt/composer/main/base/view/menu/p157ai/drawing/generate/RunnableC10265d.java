package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10265d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7154a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiDrawingPopup f7155b;

    public /* synthetic */ RunnableC10265d(AiDrawingPopup aiDrawingPopup, int i) {
        this.f7154a = i;
        this.f7155b = aiDrawingPopup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7154a) {
            case 0:
                this.f7155b.updateRequestLayoutVisibility();
                break;
            case 1:
                this.f7155b.lambda$dismiss$1();
                break;
            case 2:
                this.f7155b.lambda$new$0();
                break;
            default:
                this.f7155b.lambda$onInvalidated$2();
                break;
        }
    }
}
