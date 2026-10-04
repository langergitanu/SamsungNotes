package com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7896c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5390a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TurbulenceNoiseView f5391b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f5392c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ TurbulenceNoiseAnimationConfig f5393d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ float f5394e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ float f5395f;

    public /* synthetic */ C7896c(TurbulenceNoiseView turbulenceNoiseView, float f, TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig, float f4, float f5, int i) {
        this.f5390a = i;
        this.f5391b = turbulenceNoiseView;
        this.f5392c = f;
        this.f5393d = turbulenceNoiseAnimationConfig;
        this.f5394e = f4;
        this.f5395f = f5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5390a) {
            case 0:
                TurbulenceNoiseView.play$lambda$2(this.f5391b, this.f5392c, this.f5393d, this.f5394e, this.f5395f, valueAnimator);
                break;
            default:
                TurbulenceNoiseView.playEaseOut$lambda$4(this.f5391b, this.f5392c, this.f5393d, this.f5394e, this.f5395f, valueAnimator);
                break;
        }
    }
}
