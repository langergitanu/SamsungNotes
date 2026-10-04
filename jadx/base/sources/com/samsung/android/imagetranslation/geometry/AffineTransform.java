package com.samsung.android.imagetranslation.geometry;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class AffineTransform extends Matrix {
    static final double ZERO = 1.0E-10d;

    public AffineTransform(float f, float f4, float f5, float f6, float f7, float f8) {
        convert(f, f4, f5, f6, f7, f8);
    }

    public static Matrix getRotateInstance(double d) {
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToRotation(d);
        return affineTransform;
    }

    public static Matrix getTranslateInstance(float f, float f4) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f, f4);
        return matrix;
    }

    public void concatenate(Matrix matrix) {
        preConcat(matrix);
    }

    public void convert(float f, float f4, float f5, float f6, float f7, float f8) {
        setValues(new float[]{f, f4, f7, f5, f6, f8, 0.0f, 0.0f, 1.0f});
    }

    public boolean scale(double d, double d2) {
        return preScale((float) d, (float) d2);
    }

    public void setToIdentity() {
        reset();
    }

    public void setToRotation(double d) {
        float f;
        float f4;
        float fSin = (float) Math.sin(d);
        float fCos = (float) Math.cos(d);
        if (Math.abs(fCos) < 1.0E-10d) {
            f4 = fSin > 0.0f ? 1.0f : -1.0f;
            f = 0.0f;
        } else if (Math.abs(fSin) < 1.0E-10d) {
            f = fCos > 0.0f ? 1.0f : -1.0f;
            f4 = 0.0f;
        } else {
            f = fCos;
            f4 = fSin;
        }
        convert(f, -f4, f4, f, 0.0f, 0.0f);
    }

    public void setTransform(Matrix matrix) {
        set(matrix);
    }

    public PointF transform(PointF pointF, PointF pointF2) {
        if (pointF2 == null) {
            pointF2 = new PointF();
        }
        float f = pointF.x;
        float f4 = pointF.y;
        float[] fArr = new float[9];
        getValues(fArr);
        pointF2.set((fArr[1] * f4) + (fArr[0] * f) + fArr[2], (f4 * fArr[4]) + (f * fArr[3]) + fArr[5]);
        return pointF2;
    }

    public boolean translate(double d, double d2) {
        return preTranslate((float) d, (float) d2);
    }

    public AffineTransform(float[] fArr) {
        convert(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
    }

    public AffineTransform() {
    }
}
