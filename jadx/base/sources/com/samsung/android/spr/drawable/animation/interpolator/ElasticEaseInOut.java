package com.samsung.android.spr.drawable.animation.interpolator;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ElasticEaseInOut implements Interpolator {
    private float amplitude;
    private float period;

    public ElasticEaseInOut() {
    }

    private float inout(float f, float f4, float f5) {
        float fAsin;
        double dSin;
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f5 == 0.0f) {
            f5 = 0.45000002f;
        }
        if (f4 == 0.0f || f4 < 1.0f) {
            fAsin = f5 / 4.0f;
            f4 = 1.0f;
        } else {
            fAsin = (float) (Math.asin(1.0f / f4) * (((double) f5) / 6.283185307179586d));
        }
        float f6 = f * 2.0f;
        if (f6 < 1.0f) {
            dSin = Math.sin((((double) ((f6 - 1.0f) - fAsin)) * 6.283185307179586d) / ((double) f5)) * Math.pow(2.0d, 10.0f * r12) * ((double) f4) * (-0.5d);
        } else {
            dSin = (Math.sin((((double) ((f6 - 1.0f) - fAsin)) * 6.283185307179586d) / ((double) f5)) * Math.pow(2.0d, (-10.0f) * r12) * ((double) f4) * 0.5d) + 1.0d;
        }
        return (float) dSin;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return inout(f, this.amplitude, this.period);
    }

    public ElasticEaseInOut(float f, float f4) {
        this.amplitude = f;
        this.period = f4;
    }
}
