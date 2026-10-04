package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SineEaseInOut implements Interpolator {
    public SineEaseInOut() {
    }

    private float inout(float f) {
        return (float) ((Math.cos(((double) f) * 3.141592653589793d) - 1.0d) * (-0.5d));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return inout(f);
    }

    public SineEaseInOut(Context context, AttributeSet attributeSet) {
    }
}
