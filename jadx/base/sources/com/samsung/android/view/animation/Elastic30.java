package com.samsung.android.view.animation;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Elastic30 implements Interpolator {
    private float amplitude = 1.0f;
    private float period = 0.9f;

    private float out(float f, float f4, float f5) {
        float fAsin;
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f5 == 0.0f) {
            f5 = 0.3f;
        }
        if (f4 == 0.0f || f4 < 1.0f) {
            fAsin = f5 / 4.0f;
            f4 = 1.0f;
        } else {
            fAsin = (float) (Math.asin(1.0f / f4) * (((double) f5) / 6.283185307179586d));
        }
        return (float) ((Math.sin((((double) (f - fAsin)) * 6.283185307179586d) / ((double) f5)) * Math.pow(2.0d, (-10.0f) * f) * ((double) f4)) + 1.0d);
    }

    public float getAmplitude() {
        return this.amplitude;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return out(f, this.amplitude, this.period);
    }

    public float getPeriod() {
        return this.period;
    }
}
