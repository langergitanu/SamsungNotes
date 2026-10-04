package androidx.core.content.res;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
final class CamUtils {
    static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    static final float[] WHITE_POINT_D65 = {95.047f, 100.0f, 108.883f};
    static final float[][] SRGB_TO_XYZ = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    private CamUtils() {
    }

    public static int intFromLStar(float f) {
        if (f < 1.0f) {
            return -16777216;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f4 = (f + 16.0f) / 116.0f;
        float f5 = f > 8.0f ? f4 * f4 * f4 : f / 903.2963f;
        float f6 = f4 * f4 * f4;
        boolean z = f6 > 0.008856452f;
        float f7 = z ? f6 : ((f4 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f6 = ((f4 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(f7 * fArr[0], f5 * fArr[1], f6 * fArr[2]);
    }

    public static float lStarFromInt(int i) {
        return lStarFromY(yFromInt(i));
    }

    public static float lStarFromY(float f) {
        float f4 = f / 100.0f;
        return f4 <= 0.008856452f ? f4 * 903.2963f : (((float) Math.cbrt(f4)) * 116.0f) - 16.0f;
    }

    public static float lerp(float f, float f4, float f5) {
        return AbstractC0000a.m29z(f4, f, f5, f);
    }

    public static float linearized(int i) {
        float f = i / 255.0f;
        return (f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static void xyzFromInt(int i, @NonNull float[] fArr) {
        float fLinearized = linearized(Color.red(i));
        float fLinearized2 = linearized(Color.green(i));
        float fLinearized3 = linearized(Color.blue(i));
        float[][] fArr2 = SRGB_TO_XYZ;
        float[] fArr3 = fArr2[0];
        fArr[0] = (fArr3[2] * fLinearized3) + (fArr3[1] * fLinearized2) + (fArr3[0] * fLinearized);
        float[] fArr4 = fArr2[1];
        fArr[1] = (fArr4[2] * fLinearized3) + (fArr4[1] * fLinearized2) + (fArr4[0] * fLinearized);
        float[] fArr5 = fArr2[2];
        fArr[2] = (fLinearized3 * fArr5[2]) + (fLinearized2 * fArr5[1]) + (fLinearized * fArr5[0]);
    }

    public static float yFromInt(int i) {
        float fLinearized = linearized(Color.red(i));
        float fLinearized2 = linearized(Color.green(i));
        float fLinearized3 = linearized(Color.blue(i));
        float[] fArr = SRGB_TO_XYZ[1];
        return (fLinearized3 * fArr[2]) + (fLinearized2 * fArr[1]) + (fLinearized * fArr[0]);
    }

    public static float yFromLStar(float f) {
        return (f > 8.0f ? (float) Math.pow((((double) f) + 16.0d) / 116.0d, 3.0d) : f / 903.2963f) * 100.0f;
    }
}
