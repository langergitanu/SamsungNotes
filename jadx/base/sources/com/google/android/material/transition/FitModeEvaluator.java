package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
interface FitModeEvaluator {
    void applyMask(RectF rectF, float f, FitModeResult fitModeResult);

    FitModeResult evaluate(float f, float f4, float f5, float f6, float f7, float f8, float f9);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
