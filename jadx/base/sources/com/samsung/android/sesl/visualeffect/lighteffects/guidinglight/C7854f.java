package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.animation.ValueAnimator;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleAnimation;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7854f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5288a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5289b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f5290c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ float f5291d;

    public /* synthetic */ C7854f(float f, float f4, int i, Object obj) {
        this.f5288a = i;
        this.f5289b = obj;
        this.f5290c = f;
        this.f5291d = f4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5288a) {
            case 0:
                AnimationManager.createNowBarAnimation$lambda$13((AnimationManager) this.f5289b, this.f5290c, this.f5291d, valueAnimator);
                break;
            case 1:
                AnimationManager.createNowBarAnimation$lambda$16((AnimationManager) this.f5289b, this.f5290c, this.f5291d, valueAnimator);
                break;
            case 2:
                AnimationManager.createNowBarAnimation$lambda$19((AnimationManager) this.f5289b, this.f5290c, this.f5291d, valueAnimator);
                break;
            case 3:
                AnimationManager.createSizeAnimation$lambda$2((AnimationManager) this.f5289b, this.f5290c, this.f5291d, valueAnimator);
                break;
            case 4:
                AnimationManager.createSizeAnimation$lambda$5((AnimationManager) this.f5289b, this.f5290c, this.f5291d, valueAnimator);
                break;
            default:
                RippleAnimation.play$lambda$2((RippleAnimation) this.f5289b, this.f5290c, this.f5291d, valueAnimator);
                break;
        }
    }
}
