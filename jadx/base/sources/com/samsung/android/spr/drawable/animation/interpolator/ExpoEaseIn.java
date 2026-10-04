package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ExpoEaseIn implements Interpolator {
    public ExpoEaseIn() {
    }

    /* JADX INFO: renamed from: in */
    private float m7082in(float f) {
        return (float) (f == 0.0f ? 0.0d : Math.pow(2.0d, (f - 1.0f) * 10.0f));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return m7082in(f);
    }

    public ExpoEaseIn(Context context, AttributeSet attributeSet) {
    }
}
