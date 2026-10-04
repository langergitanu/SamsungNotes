package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.path;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilBitmap;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VDrawLinePath {
    public static float mEx;
    public static float mEy;
    public static float mSx;
    public static float mSy;

    public static Path createPath(RectF rectF, float f, float f4, boolean z, boolean z2) {
        float f5;
        float f6;
        float f7;
        Path path = new Path();
        float fWidth = rectF.width() - f;
        float fHeight = rectF.height() - f;
        path.moveTo(f, f);
        path.lineTo(fWidth, fHeight);
        if (z) {
            f5 = f4;
            drawFixedSizeArrow(path, fWidth, fHeight, f, f, 30.0f, f5, true);
            f6 = fWidth;
            f7 = f;
        } else {
            f5 = f4;
            f6 = fWidth;
            f7 = f;
        }
        if (z2) {
            drawFixedSizeArrow(path, f7, f7, f6, fHeight, 30.0f, f5, false);
        }
        return path;
    }

    public static void drawFixedSizeArrow(Path path, float f, float f4, float f5, float f6, float f7, float f8, boolean z) {
        double dAtan2 = Math.atan2(f6 - f4, f5 - f);
        double d = f5;
        double d2 = (3.0f * f8) + 20.0f;
        double radians = Math.toRadians(f7) + dAtan2;
        float fCos = (float) (d - (Math.cos(radians) * d2));
        double d3 = f6;
        float fSin = (float) (d3 - (Math.sin(radians) * d2));
        double radians2 = Math.toRadians(-f7) + dAtan2;
        float fCos2 = (float) (d - (Math.cos(radians2) * d2));
        float fSin2 = (float) (d3 - (Math.sin(radians2) * d2));
        path.moveTo(f5, f6);
        path.lineTo(fCos, fSin);
        path.moveTo(f5, f6);
        path.lineTo(fCos2, fSin2);
    }

    public static void drawVariableSizeArrow(Path path, float f, float f4, float f5, float f6, float f7, float f8, boolean z) {
        if (path == null) {
            return;
        }
        float f9 = (float) (((double) f5) + 0.5d);
        float f10 = (float) (((double) f6) + 0.5d);
        double d = (float) (((double) ((f7 == 0.0f ? 30.0f : f7) / 180.0f)) * 3.141592653589793d);
        double d2 = (float) (((double) (f5 - f)) * (-0.1d));
        double d3 = (float) (((double) (f6 - f4)) * (-0.1d));
        float fCos = (float) ((Math.cos(d) * d2) - (Math.sin(d) * d3));
        float fM2210a = (float) AbstractC2821a.m2210a(d, d3, Math.sin(d) * d2);
        float fM5b = (float) AbstractC0000a.m5b(d, d3, Math.cos(d) * d2);
        float fM2210a2 = (float) (((double) (((float) AbstractC2821a.m2210a(d, d3, (-Math.sin(d)) * d2)) + f6)) + 0.5d);
        path.moveTo(f9, f10);
        path.lineTo((float) (((double) (fCos + f5)) + 0.5d), (float) (((double) (fM2210a + f6)) + 0.5d));
        path.moveTo(f9, f10);
        path.lineTo((float) (((double) (fM5b + f5)) + 0.5d), fM2210a2);
    }

    public static Bitmap makeLineBitmap(float f, float f4, float f5, float f6, float f7, float f8, int i, boolean z, boolean z2) {
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15 = 2.0f * f7;
        int iAbs = (int) (Math.abs(f - f5) + f15);
        int iAbs2 = (int) (Math.abs(f4 - f6) + f15);
        if (f == f5) {
            if (f4 < f6) {
                f13 = iAbs2 - f7;
                f11 = f7;
                f14 = f11;
                f12 = f14;
            } else {
                f12 = iAbs2 - f7;
                f11 = f7;
                f13 = f11;
                f14 = f13;
            }
        } else if (f4 != f6) {
            if (f < f5) {
                f10 = iAbs - f7;
                f9 = f7;
            } else {
                f9 = iAbs - f7;
                f10 = f7;
            }
            if (f4 < f6) {
                f11 = f9;
                f13 = iAbs2 - f7;
                f12 = f7;
            } else {
                f11 = f9;
                f12 = iAbs2 - f7;
                f13 = f7;
            }
            f14 = f10;
        } else if (f < f5) {
            f14 = iAbs - f7;
            f11 = f7;
            f13 = f11;
            f12 = f13;
        } else {
            f11 = iAbs - f7;
            f13 = f7;
            f14 = f13;
            f12 = f14;
        }
        Picture picture = new Picture();
        Canvas canvasBeginRecording = picture.beginRecording(iAbs, iAbs2);
        Path path = new Path();
        path.moveTo(f11, f12);
        path.lineTo(f14, f13);
        if (z) {
            float f16 = f14;
            float f17 = f11;
            drawFixedSizeArrow(path, f16, f13, f17, f12, 30.0f, f8, true);
            f14 = f16;
            f11 = f17;
        }
        if (z2) {
            drawFixedSizeArrow(path, f11, f12, f14, f13, 30.0f, f8, false);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f8);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeMiter(1.0f);
        paint.setColor(i);
        canvasBeginRecording.drawPath(path, paint);
        picture.endRecording();
        return VUtilBitmap.toBitmap(new PictureDrawable(picture));
    }
}
