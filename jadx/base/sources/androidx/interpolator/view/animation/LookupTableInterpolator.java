package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f4 = this.mStepSize;
        float fM6c = AbstractC0000a.m6c(iMin, f4, f, f4);
        float[] fArr2 = this.mValues;
        float f5 = fArr2[iMin];
        return AbstractC0000a.m29z(fArr2[iMin + 1], f5, fM6c, f5);
    }
}
