package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import com.google.android.material.internal.FadeThroughDrawable;

/* JADX INFO: renamed from: com.google.android.material.search.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4836b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2351a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2352b;

    public /* synthetic */ C4836b(Object obj, int i) {
        this.f2351a = i;
        this.f2352b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2351a) {
            case 0:
                ((View) this.f2352b).setAlpha(0.0f);
                break;
            case 1:
                SearchViewAnimationHelper.lambda$addDrawerArrowDrawableAnimatorIfNeeded$3((DrawerArrowDrawable) this.f2352b, valueAnimator);
                break;
            default:
                SearchViewAnimationHelper.lambda$addFadeThroughDrawableAnimatorIfNeeded$4((FadeThroughDrawable) this.f2352b, valueAnimator);
                break;
        }
    }
}
