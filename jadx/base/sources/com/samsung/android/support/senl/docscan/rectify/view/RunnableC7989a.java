package com.samsung.android.support.senl.docscan.rectify.view;

/* JADX INFO: renamed from: com.samsung.android.support.senl.docscan.rectify.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class RunnableC7989a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5894a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RectifyOverlayView f5895b;

    public /* synthetic */ RunnableC7989a(RectifyOverlayView rectifyOverlayView, int i) {
        this.f5894a = i;
        this.f5895b = rectifyOverlayView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5894a) {
            case 0:
                this.f5895b.showHandlerPreview();
                break;
            case 1:
                RectifyOverlayView.updateHandlerPreviewPosition$lambda$4(this.f5895b);
                break;
            default:
                RectifyOverlayView.showHandlerPreview$lambda$3(this.f5895b);
                break;
        }
    }
}
