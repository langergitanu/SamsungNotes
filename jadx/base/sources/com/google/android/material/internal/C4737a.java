package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.internal.MultiViewUpdateListener;

/* JADX INFO: renamed from: com.google.android.material.internal.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4737a implements MultiViewUpdateListener.Listener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2309a;

    public /* synthetic */ C4737a(int i) {
        this.f2309a = i;
    }

    @Override // com.google.android.material.internal.MultiViewUpdateListener.Listener
    public final void onAnimationUpdate(ValueAnimator valueAnimator, View view) {
        switch (this.f2309a) {
            case 0:
                MultiViewUpdateListener.setTranslationX(valueAnimator, view);
                break;
            case 1:
                MultiViewUpdateListener.setScale(valueAnimator, view);
                break;
            case 2:
                MultiViewUpdateListener.setTranslationY(valueAnimator, view);
                break;
            default:
                MultiViewUpdateListener.setAlpha(valueAnimator, view);
                break;
        }
    }
}
