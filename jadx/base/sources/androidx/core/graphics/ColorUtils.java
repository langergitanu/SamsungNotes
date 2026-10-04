package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.content.res.CamColor;
import java.util.Objects;
import kotlin.jvm.internal.DoubleCompanionObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Color compositeColors(Color color, Color color2) {
            if (!Objects.equals(color.getModel(), color2.getModel())) {
                throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
            }
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float fAlpha = color.alpha();
            float fAlpha2 = (1.0f - fAlpha) * color2.alpha();
            int componentCount = color2.getComponentCount() - 1;
            float f = fAlpha + fAlpha2;
            components2[componentCount] = f;
            if (f > 0.0f) {
                fAlpha /= f;
                fAlpha2 /= f;
            }
            for (int i = 0; i < componentCount; i++) {
                components2[i] = (components2[i] * fAlpha2) + (components[i] * fAlpha);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float fAbs = (1.0f - Math.abs((f5 * 2.0f) - 1.0f)) * f4;
        float f6 = f5 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f) / 60) {
            case 0:
                iRound = Math.round((fAbs + f6) * 255.0f);
                iRound2 = Math.round((fAbs2 + f6) * 255.0f);
                iRound3 = Math.round(f6 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f6) * 255.0f);
                iRound2 = Math.round((fAbs + f6) * 255.0f);
                iRound3 = Math.round(f6 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f6 * 255.0f);
                iRound2 = Math.round((fAbs + f6) * 255.0f);
                iRound3 = Math.round((fAbs2 + f6) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f6 * 255.0f);
                iRound2 = Math.round((fAbs2 + f6) * 255.0f);
                iRound3 = Math.round((fAbs + f6) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f6) * 255.0f);
                iRound2 = Math.round(f6 * 255.0f);
                iRound3 = Math.round((fAbs + f6) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f6) * 255.0f);
                iRound2 = Math.round(f6 * 255.0f);
                iRound3 = Math.round((fAbs2 + f6) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(constrain(iRound, 0, 255), constrain(iRound2, 0, 255), constrain(iRound3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, m705to = 100.0d) double d, @FloatRange(from = -128.0d, m705to = 127.0d) double d2, @FloatRange(from = -128.0d, m705to = 127.0d) double d3) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d2, d3, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, m705to = 100.0d) double d, @FloatRange(from = -128.0d, m705to = 127.0d) double d2, @FloatRange(from = -128.0d, m705to = 127.0d) double d3, @NonNull double[] dArr) {
        double d4 = (d + 16.0d) / 116.0d;
        double d5 = (d2 / 500.0d) + d4;
        double d6 = d4 - (d3 / 200.0d);
        double dPow = Math.pow(d5, 3.0d);
        if (dPow <= XYZ_EPSILON) {
            dPow = ((d5 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double dPow2 = d > 7.9996247999999985d ? Math.pow(d4, 3.0d) : d / XYZ_KAPPA;
        double dPow3 = Math.pow(d6, 3.0d);
        if (dPow3 <= XYZ_EPSILON) {
            dPow3 = ((d6 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = dPow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = dPow2 * 100.0d;
        dArr[2] = dPow3 * XYZ_WHITE_REFERENCE_Z;
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, m705to = 360.0d, toInclusive = false) float f, @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float f4, @FloatRange(from = 0.0d, m705to = 100.0d) float f5) {
        return CamColor.toColor(f, f4, f5);
    }

    public static void RGBToHSL(@IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i2, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i4, @NonNull float[] fArr) {
        float fM1155a;
        float fAbs;
        float f = i / 255.0f;
        float f4 = i2 / 255.0f;
        float f5 = i4 / 255.0f;
        float fMax = Math.max(f, Math.max(f4, f5));
        float fMin = Math.min(f, Math.min(f4, f5));
        float f6 = fMax - fMin;
        float f7 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            fM1155a = 0.0f;
            fAbs = 0.0f;
        } else {
            fM1155a = fMax == f ? ((f4 - f5) / f6) % 6.0f : fMax == f4 ? AbstractC0622a.m1155a(f5, f, f6, 2.0f) : AbstractC0622a.m1155a(f, f4, f6, 4.0f);
            fAbs = f6 / (1.0f - Math.abs((2.0f * f7) - 1.0f));
        }
        float f8 = (fM1155a * 60.0f) % 360.0f;
        if (f8 < 0.0f) {
            f8 += 360.0f;
        }
        fArr[0] = constrain(f8, 0.0f, 360.0f);
        fArr[1] = constrain(fAbs, 0.0f, 1.0f);
        fArr[2] = constrain(f7, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i2, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i4, @NonNull double[] dArr) {
        RGBToXYZ(i, i2, i4, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i2, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i4, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = ((double) i) / 255.0d;
        double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d2 = ((double) i2) / 255.0d;
        double dPow2 = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = ((double) i4) / 255.0d;
        double dPow3 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
        dArr[1] = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, m705to = XYZ_WHITE_REFERENCE_X) double d, @FloatRange(from = 0.0d, m705to = 100.0d) double d2, @FloatRange(from = 0.0d, m705to = XYZ_WHITE_REFERENCE_Z) double d3) {
        double dM1308a = AbstractC1974b.m1308a(d3, -0.4986d, ((-1.5372d) * d2) + (3.2406d * d), 100.0d);
        double dM1308a2 = AbstractC1974b.m1308a(d3, 0.0415d, (1.8758d * d2) + ((-0.9689d) * d), 100.0d);
        double dM1308a3 = AbstractC1974b.m1308a(d3, 1.057d, ((-0.204d) * d2) + (0.0557d * d), 100.0d);
        return Color.rgb(constrain((int) Math.round((dM1308a > 0.0031308d ? (Math.pow(dM1308a, 0.4166666666666667d) * 1.055d) - 0.055d : dM1308a * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((dM1308a2 > 0.0031308d ? (Math.pow(dM1308a2, 0.4166666666666667d) * 1.055d) - 0.055d : dM1308a2 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((dM1308a3 > 0.0031308d ? (Math.pow(dM1308a3, 0.4166666666666667d) * 1.055d) - 0.055d : dM1308a3 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, m705to = XYZ_WHITE_REFERENCE_X) double d, @FloatRange(from = 0.0d, m705to = 100.0d) double d2, @FloatRange(from = 0.0d, m705to = XYZ_WHITE_REFERENCE_Z) double d3, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double dPivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
        double dPivotXyzComponent2 = pivotXyzComponent(d2 / 100.0d);
        double dPivotXyzComponent3 = pivotXyzComponent(d3 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = Math.max(0.0d, (116.0d * dPivotXyzComponent2) - 16.0d);
        dArr[1] = (dPivotXyzComponent - dPivotXyzComponent2) * 500.0d;
        dArr[2] = (dPivotXyzComponent2 - dPivotXyzComponent3) * 200.0d;
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i, @ColorInt int i2, @FloatRange(from = 0.0d, m705to = 1.0d) float f) {
        float f4 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i2) * f) + (Color.alpha(i) * f4)), (int) ((Color.red(i2) * f) + (Color.red(i) * f4)), (int) ((Color.green(i2) * f) + (Color.green(i) * f4)), (int) ((Color.blue(i2) * f) + (Color.blue(i) * f4)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, m705to = 1.0d) float f, @NonNull float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f4 = 1.0f - f;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
        fArr3[1] = (fArr2[1] * f) + (fArr[1] * f4);
        fArr3[2] = (fArr2[2] * f) + (fArr[2] * f4);
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, m705to = 1.0d) double d, @NonNull double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d2 = 1.0d - d;
        dArr3[0] = (dArr2[0] * d) + (dArr[0] * d2);
        dArr3[1] = (dArr2[1] * d) + (dArr[1] * d2);
        dArr3[2] = (dArr2[2] * d) + (dArr[2] * d2);
    }

    public static double calculateContrast(@ColorInt int i, @ColorInt int i2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException(AbstractC1974b.m1316i(i2, new StringBuilder("background can not be translucent: #")));
        }
        if (Color.alpha(i) < 255) {
            i = compositeColors(i, i2);
        }
        double dCalculateLuminance = calculateLuminance(i) + 0.05d;
        double dCalculateLuminance2 = calculateLuminance(i2) + 0.05d;
        return Math.max(dCalculateLuminance, dCalculateLuminance2) / Math.min(dCalculateLuminance, dCalculateLuminance2);
    }

    @FloatRange(from = 0.0d, m705to = 1.0d)
    public static double calculateLuminance(@ColorInt int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / 100.0d;
    }

    public static int calculateMinimumAlpha(@ColorInt int i, @ColorInt int i2, float f) {
        int i4 = 255;
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException(AbstractC1974b.m1316i(i2, new StringBuilder("background can not be translucent: #")));
        }
        double d = f;
        if (calculateContrast(setAlphaComponent(i, 255), i2) < d) {
            return -1;
        }
        int i5 = 0;
        for (int i6 = 0; i6 <= 10 && i4 - i5 > 1; i6++) {
            int i7 = (i5 + i4) / 2;
            if (calculateContrast(setAlphaComponent(i, i7), i2) < d) {
                i5 = i7;
            } else {
                i4 = i7;
            }
        }
        return i4;
    }

    @VisibleForTesting
    public static float circularInterpolate(float f, float f4, float f5) {
        if (Math.abs(f4 - f) > 180.0f) {
            if (f4 > f) {
                f += 360.0f;
            } else {
                f4 += 360.0f;
            }
        }
        return (((f4 - f) * f5) + f) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static void colorToLAB(@ColorInt int i, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void colorToM3HCT(@ColorInt int i, @NonNull @Size(3) float[] fArr) {
        CamColor.getM3HCTfromColor(i, fArr);
    }

    public static void colorToXYZ(@ColorInt int i, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i) * (255 - i2)) / 255);
    }

    public static int compositeColors(@ColorInt int i, @ColorInt int i2) {
        int iAlpha = Color.alpha(i2);
        int iAlpha2 = Color.alpha(i);
        int iCompositeAlpha = compositeAlpha(iAlpha2, iAlpha);
        return Color.argb(iCompositeAlpha, compositeComponent(Color.red(i), iAlpha2, Color.red(i2), iAlpha, iCompositeAlpha), compositeComponent(Color.green(i), iAlpha2, Color.green(i2), iAlpha, iCompositeAlpha), compositeComponent(Color.blue(i), iAlpha2, Color.blue(i2), iAlpha, iCompositeAlpha));
    }

    private static int compositeComponent(int i, int i2, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return AbstractC1974b.m1304A(255, i2, i4 * i5, (i * 255) * i2) / (i6 * 255);
    }

    private static float constrain(float f, float f4, float f5) {
        return f < f4 ? f4 : Math.min(f, f5);
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[2] - dArr2[2], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[0] - dArr2[0], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? Math.pow(d, 0.3333333333333333d) : AbstractC1974b.m1308a(d, XYZ_KAPPA, 16.0d, 116.0d);
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }

    private static int constrain(int i, int i2, int i4) {
        return i < i2 ? i2 : Math.min(i, i4);
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        return Api26Impl.compositeColors(color, color2);
    }
}
