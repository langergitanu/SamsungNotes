package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CircEaseIn implements Interpolator {
    public CircEaseIn() {
    }

    /* JADX INFO: renamed from: in */
    private float m7079in(float f) {
        return (float) (-(Math.sqrt(1.0f - (f * f)) - 1.0d));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return m7079in(f);
    }

    public CircEaseIn(Context context, AttributeSet attributeSet) {
    }
}
