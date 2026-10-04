package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ExpoEaseInOut implements Interpolator {
    public ExpoEaseInOut() {
    }

    private float inout(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return (float) ((f * 2.0f < 1.0f ? Math.pow(2.0d, (r7 - 1.0f) * 10.0f) : (-Math.pow(2.0d, (r7 - 1.0f) * (-10.0f))) + 2.0d) * 0.5d);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return inout(f);
    }

    public ExpoEaseInOut(Context context, AttributeSet attributeSet) {
    }
}
