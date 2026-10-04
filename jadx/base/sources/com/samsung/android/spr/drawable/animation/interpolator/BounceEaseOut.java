package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BounceEaseOut implements Interpolator {
    public BounceEaseOut() {
    }

    private float out(float f) {
        double d = f;
        if (d < 0.36363636363636365d) {
            return 7.5625f * f * f;
        }
        if (d < 0.7272727272727273d) {
            float f4 = (float) (d - 0.5454545454545454d);
            return AbstractC0622a.m1154D(f4, 7.5625f, f4, 0.75f);
        }
        if (d < 0.9090909090909091d) {
            float f5 = (float) (d - 0.8181818181818182d);
            return AbstractC0622a.m1154D(f5, 7.5625f, f5, 0.9375f);
        }
        float f6 = (float) (d - 0.9545454545454546d);
        return AbstractC0622a.m1154D(f6, 7.5625f, f6, 0.984375f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return out(f);
    }

    public BounceEaseOut(Context context, AttributeSet attributeSet) {
    }
}
