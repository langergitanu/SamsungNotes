package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.google.android.material.textfield.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4915c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2401a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ EndIconDelegate f2402b;

    public /* synthetic */ C4915c(EndIconDelegate endIconDelegate, int i) {
        this.f2401a = i;
        this.f2402b = endIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2401a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f2402b).lambda$getAlphaAnimator$3(valueAnimator);
                break;
            case 1:
                ((ClearTextEndIconDelegate) this.f2402b).lambda$getScaleAnimator$4(valueAnimator);
                break;
            default:
                ((DropdownMenuEndIconDelegate) this.f2402b).lambda$getAlphaAnimator$6(valueAnimator);
                break;
        }
    }
}
