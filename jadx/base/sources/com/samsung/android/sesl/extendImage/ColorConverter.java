package com.samsung.android.sesl.extendImage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ColorConverter {
    private static final double REF_X = 0.95047d;
    private static final double REF_Y = 1.0d;
    private static final double REF_Z = 1.08883d;
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;

    public static float acuteAngle(float f, float f4) {
        float fAbs = Math.abs(f - f4);
        return fAbs > 180.0f ? 360.0f - fAbs : fAbs;
    }

    public static double atanApprox(double d) {
        double dAbs = Math.abs(d);
        if (dAbs > 1.0d) {
            return Math.copySign(1.5707963267948966d, d) - atanApprox(1.0d / d);
        }
        return (0.7853981633974483d * d) - (((dAbs * 0.0663d) + 0.2447d) * ((dAbs - 1.0d) * d));
    }

    public static float fastAngleDeg(double d, double d2) {
        double dAtanApprox;
        double d3;
        double dAtanApprox2;
        if (Math.abs(d) < 1.0E-9d && Math.abs(d2) < 1.0E-9d) {
            return 0.0f;
        }
        if (Math.abs(d) < 1.0E-9d) {
            return d2 > 0.0d ? 90.0f : 270.0f;
        }
        if (Math.abs(d2) < 1.0E-9d) {
            return d > 0.0d ? 0.0f : 180.0f;
        }
        if (d > 0.0d) {
            dAtanApprox2 = atanApprox(d2 / d);
        } else {
            if (d2 >= 0.0d) {
                dAtanApprox = atanApprox(d2 / d);
                d3 = 3.141592653589793d;
            } else {
                dAtanApprox = atanApprox(d2 / d);
                d3 = -3.141592653589793d;
            }
            dAtanApprox2 = dAtanApprox + d3;
        }
        double degrees = Math.toDegrees(dAtanApprox2);
        if (degrees < 0.0d) {
            degrees += 360.0d;
        }
        return (float) degrees;
    }

    public static Bitmap getDebugColorGrid(int[] iArr) {
        float f = Resources.getSystem().getDisplayMetrics().density;
        int iMax = Math.max(20, Math.round(80.0f * f));
        int iMax2 = Math.max(16, Math.round(40.0f * f));
        int iMax3 = Math.max(1, Math.round(4.0f * f));
        int length = iArr.length;
        int i = (length + 11) / 12;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((iMax3 * 13) + (iMax * 12), ((i + 1) * iMax3) + (iMax2 * i), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(VUtilString.DKGRAY);
        Paint paint = new Paint(1);
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(Math.max(1.0f, f));
        Paint paint3 = new Paint(1);
        paint3.setTypeface(Typeface.MONOSPACE);
        paint3.setTextAlign(Paint.Align.LEFT);
        paint3.setTextSize(Math.min(iMax2, iMax) * 0.3f);
        Rect rect = new Rect();
        int i2 = 0;
        while (i2 < length) {
            RectF rectF = new RectF(((iMax + iMax3) * (i2 % 12)) + iMax3, ((iMax2 + iMax3) * (i2 / 12)) + iMax3, r15 + iMax, r14 + iMax2);
            int i4 = iArr[i2];
            paint.setColor(i4);
            float fMin = Math.min(iMax, iMax2) * 0.2f;
            canvas.drawRoundRect(rectF, fMin, fMin, paint);
            paint2.setColor(855638016);
            canvas.drawRoundRect(rectF, fMin, fMin, paint2);
            String str = String.format("#%08X", Integer.valueOf(i4));
            int i5 = iMax2;
            int i6 = iMax3;
            paint3.setColor((((i4 >>> 24) & 255) < 160 || (((double) (i4 & 255)) * 0.114d) + ((((double) ((i4 >>> 8) & 255)) * 0.587d) + (((double) ((i4 >>> 16) & 255)) * 0.299d)) < 140.0d) ? -1 : -16777216);
            paint3.getTextBounds(str, 0, str.length(), rect);
            float f4 = iMax * 0.9f;
            if (rect.width() > f4) {
                paint3.setTextSize(paint3.getTextSize() * (f4 / rect.width()));
                paint3.getTextBounds(str, 0, str.length(), rect);
            }
            float fCenterX = (rectF.centerX() - (rect.width() / 2.0f)) - rect.left;
            Paint.FontMetrics fontMetrics = paint3.getFontMetrics();
            canvas.drawText(str, fCenterX, (((fontMetrics.descent - fontMetrics.ascent) / 2.0f) - fontMetrics.descent) + rectF.centerY(), paint3);
            i2++;
            iMax2 = i5;
            iMax3 = i6;
        }
        return bitmapCreateBitmap;
    }

    public static double[] getLABFastRGB(int i) {
        return getLABFastRGB((i >>> 16) & 255, (i >>> 8) & 255, i & 255);
    }

    public static double getLABSaturation(double d, double d2) {
        return Math.sqrt((d2 * d2) + (d * d)) / 128.0d;
    }

    public static int getRGBFromLAB(double[] dArr) {
        return getRGBFromLAB(dArr[0], dArr[1], dArr[2]);
    }

    public static String toHexString(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            AbstractC1974b.m1330w(i, "[", "] #", sb);
            sb.append(Integer.toHexString(iArr[i]));
        }
        return sb.toString();
    }

    @NonNull
    public static double[] getLABFastRGB(int i, int i2, int i4) {
        double dM1308a;
        double d = ((double) i) / 255.0d;
        double d2 = ((double) i2) / 255.0d;
        double d3 = ((double) i4) / 255.0d;
        double dPow = d > 0.04045d ? Math.pow((d + 0.055d) / 1.055d, 2.4d) : d / 12.92d;
        double dPow2 = d2 > 0.04045d ? Math.pow((d2 + 0.055d) / 1.055d, 2.4d) : d2 / 12.92d;
        double dPow3 = d3 > 0.04045d ? Math.pow((d3 + 0.055d) / 1.055d, 2.4d) : d3 / 12.92d;
        double d4 = ((0.1804375d * dPow3) + ((0.3575761d * dPow2) + (0.4124564d * dPow))) / REF_X;
        double d5 = ((0.072175d * dPow3) + ((0.7151522d * dPow2) + (0.2126729d * dPow))) / 1.0d;
        double d6 = ((dPow3 * 0.9503041d) + ((dPow2 * 0.119192d) + (dPow * 0.0193339d))) / REF_Z;
        double d7 = d5 <= 0.9999d ? d5 : 1.0d;
        double d8 = XYZ_KAPPA;
        double d9 = 16.0d;
        if (d4 > XYZ_EPSILON) {
            dM1308a = Math.cbrt(d4);
        } else {
            dM1308a = AbstractC1974b.m1308a(d4, XYZ_KAPPA, 16.0d, 116.0d);
            d9 = 16.0d;
            d8 = 903.3d;
        }
        double dCbrt = d7 > XYZ_EPSILON ? Math.cbrt(d7) : AbstractC1974b.m1308a(d7, d8, d9, 116.0d);
        return new double[]{(116.0d * dCbrt) - d9, (dM1308a - dCbrt) * 500.0d, (dCbrt - (d6 > XYZ_EPSILON ? Math.cbrt(d6) : AbstractC1974b.m1308a(d6, d8, d9, 116.0d))) * 200.0d};
    }

    public static int getRGBFromLAB(double d, double d2, double d3) {
        double d4 = (d + 16.0d) / 116.0d;
        double d5 = (d2 / 500.0d) + d4;
        double d6 = d4 - (d3 / 200.0d);
        double d7 = d5 * d5 * d5;
        double d8 = d4 * d4 * d4;
        double d9 = d6 * d6 * d6;
        if (d7 <= XYZ_EPSILON) {
            d7 = ((d5 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        if (d <= 8.0d) {
            d8 = d / XYZ_KAPPA;
        }
        if (d9 <= XYZ_EPSILON) {
            d9 = ((d6 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double d10 = d7 * REF_X;
        double d11 = d8 * 1.0d;
        double d12 = d9 * REF_Z;
        double d13 = ((-0.4985314d) * d12) + ((-1.5371385d) * d11) + (3.2404542d * d10);
        double d14 = (0.041556d * d12) + (1.8760108d * d11) + ((-0.969266d) * d10);
        double d15 = (d12 * 1.0572252d) + (d11 * (-0.2040259d)) + (d10 * 0.0556434d);
        return ((int) ((Math.max(0.0d, Math.min(1.0d, d15 > 0.0031308d ? (Math.pow(d15, 0.4166666666666667d) * 1.055d) - 0.055d : d15 * 12.92d)) * 255.0d) + 0.5d)) | (((int) ((Math.max(0.0d, Math.min(1.0d, d13 > 0.0031308d ? (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d : d13 * 12.92d)) * 255.0d) + 0.5d)) << 16) | (-16777216) | (((int) ((Math.max(0.0d, Math.min(1.0d, d14 > 0.0031308d ? (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d : d14 * 12.92d)) * 255.0d) + 0.5d)) << 8);
    }
}
