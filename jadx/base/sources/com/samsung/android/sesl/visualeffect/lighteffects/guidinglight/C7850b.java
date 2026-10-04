package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7850b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5275a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AnimationManager f5276b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f5277c;

    public /* synthetic */ C7850b(AnimationManager animationManager, float f, int i) {
        this.f5275a = i;
        this.f5276b = animationManager;
        this.f5277c = f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5275a) {
            case 0:
                AnimationManager.createLuminanceAnimation$lambda$10(this.f5276b, this.f5277c, valueAnimator);
                break;
            case 1:
                AnimationManager.createSizeAnimation$lambda$8(this.f5276b, this.f5277c, valueAnimator);
                break;
            default:
                AnimationManager.hideByLuminance$lambda$22(this.f5276b, this.f5277c, valueAnimator);
                break;
        }
    }
}
