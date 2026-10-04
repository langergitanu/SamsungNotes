package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
final class ViewingConditions {
    static final ViewingConditions DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((((double) CamUtils.yFromLStar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float mAw;

    /* JADX INFO: renamed from: mC */
    private final float f1276mC;
    private final float mFl;
    private final float mFlRoot;

    /* JADX INFO: renamed from: mN */
    private final float f1277mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;

    /* JADX INFO: renamed from: mZ */
    private final float f1278mZ;

    private ViewingConditions(float f, float f4, float f5, float f6, float f7, float f8, float[] fArr, float f9, float f10, float f11) {
        this.f1277mN = f;
        this.mAw = f4;
        this.mNbb = f5;
        this.mNcb = f6;
        this.f1276mC = f7;
        this.mNc = f8;
        this.mRgbD = fArr;
        this.mFl = f9;
        this.mFlRoot = f10;
        this.f1278mZ = f11;
    }

    @NonNull
    public static ViewingConditions make(@NonNull float[] fArr, float f, float f4, float f5, boolean z) {
        float[][] fArr2 = CamUtils.XYZ_TO_CAM16RGB;
        float f6 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f7 = fArr3[0] * f6;
        float f8 = fArr[1];
        float f9 = (fArr3[1] * f8) + f7;
        float f10 = fArr[2];
        float f11 = (fArr3[2] * f10) + f9;
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[2] * f10) + (fArr4[1] * f8) + (fArr4[0] * f6);
        float[] fArr5 = fArr2[2];
        float f13 = (f10 * fArr5[2]) + (f8 * fArr5[1]) + (f6 * fArr5[0]);
        float f14 = (f5 / 10.0f) + 0.8f;
        float fLerp = ((double) f14) >= 0.9d ? CamUtils.lerp(0.59f, 0.69f, (f14 - 0.9f) * 10.0f) : CamUtils.lerp(0.525f, 0.59f, (f14 - 0.8f) * 10.0f);
        float fM1309b = z ? 1.0f : AbstractC1974b.m1309b((float) Math.exp(((-f) - 42.0f) / 92.0f), 0.2777778f, 1.0f, f14);
        double d = fM1309b;
        if (d > 1.0d) {
            fM1309b = 1.0f;
        } else if (d < 0.0d) {
            fM1309b = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f11) * fM1309b) + 1.0f) - fM1309b, (((100.0f / f12) * fM1309b) + 1.0f) - fM1309b, (((100.0f / f13) * fM1309b) + 1.0f) - fM1309b};
        float f15 = 1.0f / ((5.0f * f) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        float fCbrt = (0.1f * f17 * f17 * ((float) Math.cbrt(((double) f) * 5.0d))) + (f16 * f);
        float fYFromLStar = CamUtils.yFromLStar(f4) / fArr[1];
        double d2 = fYFromLStar;
        float fSqrt = ((float) Math.sqrt(d2)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f11)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f12)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f13)) / 100.0d, 0.42d)};
        float f18 = fArr7[0];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[1];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr7[2];
        float[] fArr8 = {f19, f21, (400.0f * f22) / (f22 + 27.13f)};
        return new ViewingConditions(fYFromLStar, AbstractC0622a.m1152B(fArr8[2], 0.05f, (fArr8[0] * 2.0f) + fArr8[1], fPow), fPow, fPow, fLerp, f14, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public float getAw() {
        return this.mAw;
    }

    public float getC() {
        return this.f1276mC;
    }

    public float getFl() {
        return this.mFl;
    }

    public float getFlRoot() {
        return this.mFlRoot;
    }

    public float getN() {
        return this.f1277mN;
    }

    public float getNbb() {
        return this.mNbb;
    }

    public float getNc() {
        return this.mNc;
    }

    public float getNcb() {
        return this.mNcb;
    }

    @NonNull
    public float[] getRgbD() {
        return this.mRgbD;
    }

    public float getZ() {
        return this.f1278mZ;
    }
}
