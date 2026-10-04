package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10506e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7220a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TitleViewShowHideAnimator f7221b;

    public /* synthetic */ C10506e(TitleViewShowHideAnimator titleViewShowHideAnimator, int i) {
        this.f7220a = i;
        this.f7221b = titleViewShowHideAnimator;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f7220a) {
            case 0:
                this.f7221b.lambda$getShowAlphaAnimator$1(valueAnimator);
                break;
            case 1:
                this.f7221b.lambda$getShowAlphaAnimator$2(valueAnimator);
                break;
            case 2:
                this.f7221b.lambda$getHideAlphaAnimator$3(valueAnimator);
                break;
            default:
                this.f7221b.lambda$getHideAlphaAnimator$4(valueAnimator);
                break;
        }
    }
}
