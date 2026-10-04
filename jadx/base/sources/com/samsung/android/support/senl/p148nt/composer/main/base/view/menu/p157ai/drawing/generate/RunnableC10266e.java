package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10266e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7156a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FrameLayout f7157b;

    public /* synthetic */ RunnableC10266e(FrameLayout frameLayout, int i) {
        this.f7156a = i;
        this.f7157b = frameLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7156a) {
            case 0:
                ((AiDrawingRequestLayout) this.f7157b).lambda$updateThemeContainer$3();
                break;
            case 1:
                ((AiDrawingRequestLayout) this.f7157b).lambda$show$2();
                break;
            default:
                ((AiDrawingContentLayout) this.f7157b).lambda$updateCloseBtn$1();
                break;
        }
    }
}
