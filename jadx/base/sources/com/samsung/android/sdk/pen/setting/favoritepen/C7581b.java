package com.samsung.android.sdk.pen.setting.favoritepen;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.favoritepen.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7581b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5055a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenFavoritePenLayoutControl f5056b;

    public /* synthetic */ C7581b(SpenFavoritePenLayoutControl spenFavoritePenLayoutControl, int i) {
        this.f5055a = i;
        this.f5056b = spenFavoritePenLayoutControl;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5055a) {
            case 0:
                SpenFavoritePenLayoutControl.createAnimatorSet$lambda$0(this.f5056b, valueAnimator);
                break;
            case 1:
                SpenFavoritePenLayoutControl.createAnimatorSet$lambda$2(this.f5056b, valueAnimator);
                break;
            default:
                SpenFavoritePenLayoutControl.getListViewAnimator$lambda$4(this.f5056b, valueAnimator);
                break;
        }
    }
}
