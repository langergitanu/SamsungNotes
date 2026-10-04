package com.samsung.android.sdk.pen.setting;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7564d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5045a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenFavoritePenMiniOutsideReorder f5046b;

    public /* synthetic */ C7564d(SpenFavoritePenMiniOutsideReorder spenFavoritePenMiniOutsideReorder, int i) {
        this.f5045a = i;
        this.f5046b = spenFavoritePenMiniOutsideReorder;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5045a) {
            case 0:
                SpenFavoritePenMiniOutsideReorder.onStartDrag$lambda$1(this.f5046b, valueAnimator);
                break;
            case 1:
                SpenFavoritePenMiniOutsideReorder.onStartDrag$lambda$2(this.f5046b, valueAnimator);
                break;
            case 2:
                SpenFavoritePenMiniOutsideReorder.onDropToPosition$lambda$3(this.f5046b, valueAnimator);
                break;
            case 3:
                SpenFavoritePenMiniOutsideReorder.onDropToPosition$lambda$4(this.f5046b, valueAnimator);
                break;
            case 4:
                SpenFavoritePenMiniOutsideReorder.onDropToPosition$lambda$5(this.f5046b, valueAnimator);
                break;
            default:
                SpenFavoritePenMiniOutsideReorder.onDropToPosition$lambda$6(this.f5046b, valueAnimator);
                break;
        }
    }
}
