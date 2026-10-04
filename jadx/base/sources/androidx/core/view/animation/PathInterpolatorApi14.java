package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;

    /* JADX INFO: renamed from: mX */
    private final float[] f1328mX;

    /* JADX INFO: renamed from: mY */
    private final float[] f1329mY;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = (int) (length / 0.002f);
        int i2 = i + 1;
        this.f1328mX = new float[i2];
        this.f1329mY = new float[i2];
        float[] fArr = new float[2];
        for (int i4 = 0; i4 < i2; i4++) {
            pathMeasure.getPosTan((i4 * length) / i, fArr, null);
            this.f1328mX[i4] = fArr[0];
            this.f1329mY[i4] = fArr[1];
        }
    }

    private static Path createCubic(float f, float f4, float f5, float f6) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f4, f5, f6, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f4, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f1328mX.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f1328mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f1328mX;
        float f4 = fArr[length];
        float f5 = fArr[i];
        float f6 = f4 - f5;
        if (f6 == 0.0f) {
            return this.f1329mY[i];
        }
        float f7 = (f - f5) / f6;
        float[] fArr2 = this.f1329mY;
        float f8 = fArr2[i];
        return AbstractC0000a.m29z(fArr2[length], f8, f7, f8);
    }

    public PathInterpolatorApi14(float f, float f4) {
        this(createQuad(f, f4));
    }

    public PathInterpolatorApi14(float f, float f4, float f5, float f6) {
        this(createCubic(f, f4, f5, f6));
    }
}
