package com.google.android.material.chip;

import android.animation.ValueAnimator;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightEffect;

/* JADX INFO: renamed from: com.google.android.material.chip.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4643k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2266a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2267b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f2268c;

    public /* synthetic */ C4643k(Object obj, float f, int i) {
        this.f2266a = i;
        this.f2267b = obj;
        this.f2268c = f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2266a) {
            case 0:
                ((SeslPeoplePicker) this.f2267b).lambda$startHidingAnimation$5(this.f2268c, valueAnimator);
                break;
            case 1:
                ((SeslPeoplePicker) this.f2267b).lambda$startShowingAnimation$4(this.f2268c, valueAnimator);
                break;
            default:
                ProcessingLightEffect.stopEffectWithAnimation$lambda$0((ProcessingLightEffect) this.f2267b, this.f2268c, valueAnimator);
                break;
        }
    }
}
