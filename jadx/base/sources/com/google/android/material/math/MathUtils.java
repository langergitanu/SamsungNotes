package com.google.android.material.math;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float f, float f4, float f5, float f6) {
        return (float) Math.hypot(f5 - f, f6 - f4);
    }

    public static float distanceToFurthestCorner(float f, float f4, float f5, float f6, float f7, float f8) {
        return max(dist(f, f4, f5, f6), dist(f, f4, f7, f6), dist(f, f4, f7, f8), dist(f, f4, f5, f8));
    }

    public static float floorMod(float f, int i) {
        float f4 = i;
        int i2 = (int) (f / f4);
        if (Math.signum(f) * f4 < 0.0f && i2 * i != f) {
            i2--;
        }
        return f - (i2 * i);
    }

    public static boolean geq(float f, float f4, float f5) {
        return f + f5 >= f4;
    }

    public static float lerp(float f, float f4, float f5) {
        return (f5 * f4) + ((1.0f - f5) * f);
    }

    private static float max(float f, float f4, float f5, float f6) {
        return (f <= f4 || f <= f5 || f <= f6) ? (f4 <= f5 || f4 <= f6) ? f5 > f6 ? f5 : f6 : f4 : f;
    }

    public static int floorMod(int i, int i2) {
        int i4 = i / i2;
        if ((i ^ i2) < 0 && i4 * i2 != i) {
            i4--;
        }
        return i - (i4 * i2);
    }
}
