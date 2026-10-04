package com.google.android.material.transition;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    public FitModeResult(float f, float f4, float f5, float f6, float f7, float f8) {
        this.startScale = f;
        this.endScale = f4;
        this.currentStartWidth = f5;
        this.currentStartHeight = f6;
        this.currentEndWidth = f7;
        this.currentEndHeight = f8;
    }
}
