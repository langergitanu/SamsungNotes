package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static float deriveDimension(int i, float f, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i, f, displayMetrics);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i, float f, DisplayMetrics displayMetrics) {
        float f4;
        float f5;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i, f, displayMetrics);
        }
        if (i == 0) {
            return f;
        }
        if (i == 1) {
            float f6 = displayMetrics.density;
            if (f6 == 0.0f) {
                return 0.0f;
            }
            return f / f6;
        }
        if (i == 2) {
            float f7 = displayMetrics.scaledDensity;
            if (f7 == 0.0f) {
                return 0.0f;
            }
            return f / f7;
        }
        if (i == 3) {
            float f8 = displayMetrics.xdpi;
            if (f8 == 0.0f) {
                return 0.0f;
            }
            f4 = f / f8;
            f5 = INCHES_PER_PT;
        } else {
            if (i == 4) {
                float f9 = displayMetrics.xdpi;
                if (f9 == 0.0f) {
                    return 0.0f;
                }
                return f / f9;
            }
            if (i != 5) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Invalid unitToConvertTo "));
            }
            float f10 = displayMetrics.xdpi;
            if (f10 == 0.0f) {
                return 0.0f;
            }
            f4 = f / f10;
            f5 = INCHES_PER_MM;
        }
        return f4 / f5;
    }

    public static float dpToPx(float f, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i) {
        return i & 15;
    }

    public static float pxToDp(float f, DisplayMetrics displayMetrics) {
        return deriveDimension(1, f, displayMetrics);
    }

    public static float pxToSp(float f, DisplayMetrics displayMetrics) {
        return deriveDimension(2, f, displayMetrics);
    }

    public static float spToPx(float f, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f, displayMetrics);
    }
}
