package com.samsung.android.sesl.outerGlow;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.samsung.android.sesl.outerGlow.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7840b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5256a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AGSLShaderBase f5257b;

    public /* synthetic */ C7840b(AGSLShaderBase aGSLShaderBase, int i) {
        this.f5256a = i;
        this.f5257b = aGSLShaderBase;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5256a) {
            case 0:
                AGSLShaderBase.startInitAnimation$lambda$9$lambda$6(this.f5257b, valueAnimator);
                break;
            default:
                AGSLShaderBase.startSlowDownAnimation$lambda$12$lambda$10(this.f5257b, valueAnimator);
                break;
        }
    }
}
