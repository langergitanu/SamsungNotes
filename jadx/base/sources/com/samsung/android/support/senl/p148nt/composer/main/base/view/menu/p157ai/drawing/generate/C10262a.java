package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10262a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7149a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FrameLayout f7150b;

    public /* synthetic */ C10262a(FrameLayout frameLayout, int i) {
        this.f7149a = i;
        this.f7150b = frameLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f7149a) {
            case 0:
                ((AiDrawingContentFrame) this.f7150b).lambda$startGradientAnimation$0(valueAnimator);
                break;
            default:
                ((AiDrawingContentLayout) this.f7150b).lambda$updateCloseBtn$0(valueAnimator);
                break;
        }
    }
}
