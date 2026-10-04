package com.samsung.android.sesl.visualeffect;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7844a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5261a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RevealImageEffectView f5262b;

    public /* synthetic */ C7844a(RevealImageEffectView revealImageEffectView, int i) {
        this.f5261a = i;
        this.f5262b = revealImageEffectView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5261a) {
            case 0:
                RevealImageEffectView.startCircularAnimation$lambda$4$lambda$1(this.f5262b, valueAnimator);
                break;
            default:
                RevealImageEffectView.startRoundRectAnimation$lambda$9$lambda$6(this.f5262b, valueAnimator);
                break;
        }
    }
}
