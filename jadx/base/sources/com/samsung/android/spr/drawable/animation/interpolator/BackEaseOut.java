package com.samsung.android.spr.drawable.animation.interpolator;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BackEaseOut implements Interpolator {
    private float overshot;

    public BackEaseOut() {
    }

    private float out(float f, float f4) {
        if (f4 == 0.0f) {
            f4 = 1.70158f;
        }
        float f5 = f - 1.0f;
        return ((((f4 + 1.0f) * f5) + f4) * f5 * f5) + 1.0f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return out(f, this.overshot);
    }

    public BackEaseOut(float f) {
        this.overshot = f;
    }
}
