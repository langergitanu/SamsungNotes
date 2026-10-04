package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class QuartEaseOut implements Interpolator {
    public QuartEaseOut() {
    }

    private float out(float f) {
        float f4 = f - 1.0f;
        return -((((f4 * f4) * f4) * f4) - 1.0f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return out(f);
    }

    public QuartEaseOut(Context context, AttributeSet attributeSet) {
    }
}
