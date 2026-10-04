package com.samsung.android.spr.drawable.animation.interpolator;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BackEaseInOut implements Interpolator {
    private float overshot;

    public BackEaseInOut() {
    }

    private float inout(float f, float f4) {
        float f5;
        if (f4 == 0.0f) {
            f4 = 1.70158f;
        }
        float f6 = f * 2.0f;
        if (f6 < 1.0f) {
            float f7 = (float) (((double) f4) * 1.525d);
            f5 = (((1.0f + f7) * f6) - f7) * f6 * f6;
        } else {
            float f8 = f6 - 2.0f;
            float f9 = (float) (((double) f4) * 1.525d);
            f5 = ((((1.0f + f9) * f8) + f9) * f8 * f8) + 2.0f;
        }
        return f5 * 0.5f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return inout(f, this.overshot);
    }

    public BackEaseInOut(float f) {
        this.overshot = f;
    }
}
