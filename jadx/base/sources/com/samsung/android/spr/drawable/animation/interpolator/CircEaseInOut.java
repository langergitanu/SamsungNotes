package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CircEaseInOut implements Interpolator {
    public CircEaseInOut() {
    }

    private float inout(float f) {
        double dSqrt;
        double d;
        float f4 = f * 2.0f;
        if (f4 < 1.0f) {
            dSqrt = Math.sqrt(1.0f - (f4 * f4)) - 1.0d;
            d = -0.5d;
        } else {
            float f5 = f4 - 2.0f;
            dSqrt = Math.sqrt(1.0f - (f5 * f5)) + 1.0d;
            d = 0.5d;
        }
        return (float) (dSqrt * d);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return inout(f);
    }

    public CircEaseInOut(Context context, AttributeSet attributeSet) {
    }
}
