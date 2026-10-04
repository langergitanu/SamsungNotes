package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SineInOut80 implements Interpolator {
    private static final float[][] segments = {new float[]{0.0f, 0.0f, 0.195f}, new float[]{0.195f, 0.48f, 0.645f}, new float[]{0.645f, 0.835f, 0.885f}, new float[]{0.885f, 0.955f, 0.978f}, new float[]{0.978f, 0.9999f, 1.0f}};

    public SineInOut80() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f4 = f / 1.0f;
        float[][] fArr = segments;
        float length = fArr.length;
        int iFloor = (int) Math.floor(length * f4);
        if (iFloor >= fArr.length) {
            iFloor = fArr.length - 1;
        }
        float f5 = (f4 - ((1.0f / length) * iFloor)) * length;
        float[] fArr2 = fArr[iFloor];
        float f6 = fArr2[0];
        return ((((((fArr2[2] - f6) * f5) + ((fArr2[1] - f6) * (1.0f - f5) * 2.0f)) * f5) + f6) * 1.0f) + 0.0f;
    }

    public SineInOut80(Context context, AttributeSet attributeSet) {
    }
}
