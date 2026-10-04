package com.samsung.android.spr.drawable.animation.interpolator;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BackEaseIn implements Interpolator {
    private float overshot;

    public BackEaseIn() {
    }

    /* JADX INFO: renamed from: in */
    private float m7076in(float f, float f4) {
        if (f4 == 0.0f) {
            f4 = 1.70158f;
        }
        return (((1.0f + f4) * f) - f4) * f * f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return m7076in(f, this.overshot);
    }

    public BackEaseIn(float f) {
        this.overshot = f;
    }
}
