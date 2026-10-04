package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.generate.AiDrawingRequestPresenter;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7853e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5285a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ float f5286b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5287c;

    public /* synthetic */ RunnableC7853e(Object obj, float f, int i) {
        this.f5285a = i;
        this.f5287c = obj;
        this.f5286b = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5285a) {
            case 0:
                AnimationManager.createSizeAnimation$lambda$9((AnimationManager) this.f5287c, this.f5286b);
                break;
            default:
                ((AiDrawingRequestPresenter) this.f5287c).lambda$updatePreferredDisplayMode$4(this.f5286b);
                break;
        }
    }
}
