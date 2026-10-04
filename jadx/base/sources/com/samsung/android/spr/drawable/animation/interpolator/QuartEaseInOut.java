package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class QuartEaseInOut implements Interpolator {
    public QuartEaseInOut() {
    }

    private float inout(float f) {
        float f4 = f * 2.0f;
        if (f4 < 1.0f) {
            return 0.5f * f4 * f4 * f4 * f4;
        }
        float f5 = f4 - 2.0f;
        return ((((f5 * f5) * f5) * f5) - 2.0f) * (-0.5f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return inout(f);
    }

    public QuartEaseInOut(Context context, AttributeSet attributeSet) {
    }
}
