package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class QuadEaseInOut implements Interpolator {
    public QuadEaseInOut() {
    }

    private float inout(float f) {
        float f4;
        float f5 = f * 2.0f;
        if (f5 < 1.0f) {
            f4 = 0.5f * f5;
        } else {
            float f6 = f5 - 1.0f;
            f4 = ((f6 - 2.0f) * f6) - 1.0f;
            f5 = -0.5f;
        }
        return f4 * f5;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return inout(f);
    }

    public QuadEaseInOut(Context context, AttributeSet attributeSet) {
    }
}
