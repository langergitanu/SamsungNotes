package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.collection.AbstractC0622a;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.DoubleCompanionObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;

    /* JADX INFO: renamed from: mJ */
    private final float f1272mJ;
    private final float mJstar;

    /* JADX INFO: renamed from: mM */
    private final float f1273mM;

    /* JADX INFO: renamed from: mQ */
    private final float f1274mQ;

    /* JADX INFO: renamed from: mS */
    private final float f1275mS;

    public CamColor(float f, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this.mHue = f;
        this.mChroma = f4;
        this.f1272mJ = f5;
        this.f1274mQ = f6;
        this.f1273mM = f7;
        this.f1275mS = f8;
        this.mJstar = f9;
        this.mAstar = f10;
        this.mBstar = f11;
    }

    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, m705to = 360.0d) float f, @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float f4, @FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2) float f5) {
        float f6 = 100.0f;
        float f7 = 1000.0f;
        float f8 = 0.0f;
        CamColor camColor = null;
        float f9 = 1000.0f;
        while (Math.abs(f8 - f6) > 0.01f) {
            float fM1155a = AbstractC0622a.m1155a(f6, f8, 2.0f, f8);
            int iViewedInSrgb = fromJch(fM1155a, f4, f).viewedInSrgb();
            float fLStarFromInt = CamUtils.lStarFromInt(iViewedInSrgb);
            float fAbs = Math.abs(f5 - fLStarFromInt);
            if (fAbs < 0.2f) {
                CamColor camColorFromColor = fromColor(iViewedInSrgb);
                float fDistance = camColorFromColor.distance(fromJch(camColorFromColor.getJ(), camColorFromColor.getChroma(), f));
                if (fDistance <= 1.0f) {
                    camColor = camColorFromColor;
                    f7 = fAbs;
                    f9 = fDistance;
                }
            }
            if (f7 == 0.0f && f9 == 0.0f) {
                return camColor;
            }
            if (fLStarFromInt < f5) {
                f8 = fM1155a;
            } else {
                f6 = fM1155a;
            }
        }
        return camColor;
    }

    @NonNull
    public static CamColor fromColor(@ColorInt int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void fromColorInViewingConditions(@ColorInt int i, @NonNull ViewingConditions viewingConditions, @Nullable @Size(7) float[] fArr, @NonNull @Size(3) float[] fArr2) {
        CamUtils.xyzFromInt(i, fArr2);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f4 = fArr4[0] * f;
        float f5 = fArr2[1];
        float f6 = (fArr4[1] * f5) + f4;
        float f7 = fArr2[2];
        float f8 = (fArr4[2] * f7) + f6;
        float[] fArr5 = fArr3[1];
        float f9 = (fArr5[2] * f7) + (fArr5[1] * f5) + (fArr5[0] * f);
        float[] fArr6 = fArr3[2];
        float f10 = (f7 * fArr6[2]) + (f5 * fArr6[1]) + (f * fArr6[0]);
        float f11 = viewingConditions.getRgbD()[0] * f8;
        float f12 = viewingConditions.getRgbD()[1] * f9;
        float f13 = viewingConditions.getRgbD()[2] * f10;
        float fPow = (float) Math.pow(((double) (Math.abs(f11) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f12) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f13) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f11) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f12) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f13) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum3;
        float f14 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d)) / 11.0f;
        float f15 = ((float) (((double) (fSignum + fSignum2)) - (d * 2.0d))) / 9.0f;
        float f16 = fSignum2 * 20.0f;
        float f17 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f16)) / 20.0f;
        float f18 = (((fSignum * 40.0f) + f16) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f15, f14)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f19 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f18 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(fPow4 / 100.0f)) * viewingConditions.getFlRoot();
        float fSqrt = ((float) Math.sqrt(((double) fPow4) / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) fAtan2) < 20.14d ? fAtan2 + 360.0f : fAtan2)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f15 * f15) + (f14 * f14)))) / (f17 + 0.305f), 0.9d));
        float flRoot = viewingConditions.getFlRoot() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r6 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f20 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
        double d2 = f19;
        float fCos = ((float) Math.cos(d2)) * fLog;
        float fSin = fLog * ((float) Math.sin(d2));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = aw;
            fArr[2] = flRoot;
            fArr[3] = fSqrt2;
            fArr[4] = f20;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2) float f, @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float f4, @FloatRange(from = 0.0d, m705to = 360.0d) float f5) {
        return fromJchInFrame(f, f4, f5, ViewingConditions.DEFAULT);
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2) float f, @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float f4, @FloatRange(from = 0.0d, m705to = 360.0d) float f5, ViewingConditions viewingConditions) {
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(((double) f) / 100.0d)) * viewingConditions.getFlRoot();
        float flRoot = viewingConditions.getFlRoot() * f4;
        float fSqrt = ((float) Math.sqrt(((f4 / ((float) Math.sqrt(r4))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f6 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float fLog = ((float) Math.log((((double) flRoot) * 0.0228d) + 1.0d)) * 43.85965f;
        double d = (3.1415927f * f5) / 180.0f;
        return new CamColor(f5, f4, f, aw, flRoot, fSqrt, f6, ((float) Math.cos(d)) * fLog, fLog * ((float) Math.sin(d)));
    }

    public static void getM3HCTfromColor(@ColorInt int i, @NonNull @Size(3) float[] fArr) {
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, null, fArr);
        fArr[2] = CamUtils.lStarFromInt(i);
    }

    public static int toColor(@FloatRange(from = 0.0d, m705to = 360.0d) float f, @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float f4, @FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2) float f5) {
        return toColor(f, f4, f5, ViewingConditions.DEFAULT);
    }

    public float distance(@NonNull CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((bStar * bStar) + (aStar * aStar) + (jStar * jStar)), 0.63d) * 1.41d);
    }

    @FloatRange(from = DoubleCompanionObject.NEGATIVE_INFINITY, fromInclusive = false, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getAStar() {
        return this.mAstar;
    }

    @FloatRange(from = DoubleCompanionObject.NEGATIVE_INFINITY, fromInclusive = false, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getBStar() {
        return this.mBstar;
    }

    @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getChroma() {
        return this.mChroma;
    }

    @FloatRange(from = 0.0d, m705to = 360.0d, toInclusive = false)
    public float getHue() {
        return this.mHue;
    }

    @FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2)
    public float getJ() {
        return this.f1272mJ;
    }

    @FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2)
    public float getJStar() {
        return this.mJstar;
    }

    @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getM() {
        return this.f1273mM;
    }

    @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getQ() {
        return this.f1274mQ;
    }

    @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getS() {
        return this.f1275mS;
    }

    @ColorInt
    public int viewed(@NonNull ViewingConditions viewingConditions) {
        float fPow = (float) Math.pow(((double) ((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) viewingConditions.getC())) / ((double) viewingConditions.getZ())));
        float nc = fCos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float fSin = (float) Math.sin(hue);
        float fCos2 = (float) Math.cos(hue);
        float fM1154D = (((0.305f + nbb) * 23.0f) * fPow) / (((fPow * 108.0f) * fSin) + AbstractC0622a.m1154D(fPow, 11.0f, fCos2, nc * 23.0f));
        float f = fCos2 * fM1154D;
        float f4 = fM1154D * fSin;
        float f5 = nbb * 460.0f;
        float fM6c = AbstractC0000a.m6c(f4, 261.0f, f5 - (891.0f * f), 1403.0f);
        float fM6c2 = AbstractC0000a.m6c(f4, 6300.0f, f5 - (f * 220.0f), 1403.0f);
        float fl = (100.0f / viewingConditions.getFl()) * Math.signum(((288.0f * f4) + ((451.0f * f) + f5)) / 1403.0f) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r1)) * 27.13d) / (400.0d - ((double) Math.abs(r1)))), 2.380952380952381d));
        float fl2 = (100.0f / viewingConditions.getFl()) * Math.signum(fM6c) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(fM6c)) * 27.13d) / (400.0d - ((double) Math.abs(fM6c)))), 2.380952380952381d));
        float fl3 = (100.0f / viewingConditions.getFl()) * Math.signum(fM6c2) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(fM6c2)) * 27.13d) / (400.0d - ((double) Math.abs(fM6c2)))), 2.380952380952381d));
        float f6 = fl / viewingConditions.getRgbD()[0];
        float f7 = fl2 / viewingConditions.getRgbD()[1];
        float f8 = fl3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f9 = (fArr2[2] * f8) + (fArr2[1] * f7) + (fArr2[0] * f6);
        float[] fArr3 = fArr[1];
        float f10 = (fArr3[2] * f8) + (fArr3[1] * f7) + (fArr3[0] * f6);
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor(f9, f10, (f8 * fArr4[2]) + (f7 * fArr4[1]) + (f6 * fArr4[0]));
    }

    @ColorInt
    public int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    @ColorInt
    public static int toColor(@FloatRange(from = 0.0d, m705to = 360.0d) float f, @FloatRange(from = 0.0d, m705to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float f4, @FloatRange(from = 0.0d, m705to = MotionTokens.DurationShort2) float f5, @NonNull ViewingConditions viewingConditions) {
        if (f4 < 1.0d || Math.round(f5) <= 0.0d || Math.round(f5) >= 100.0d) {
            return CamUtils.intFromLStar(f5);
        }
        float fMin = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        CamColor camColor = null;
        boolean z = true;
        float f6 = 0.0f;
        float fM1155a = f4;
        while (Math.abs(f6 - f4) >= 0.4f) {
            CamColor camColorFindCamByJ = findCamByJ(fMin, fM1155a, f5);
            if (!z) {
                if (camColorFindCamByJ == null) {
                    f4 = fM1155a;
                } else {
                    f6 = fM1155a;
                    camColor = camColorFindCamByJ;
                }
                fM1155a = AbstractC0622a.m1155a(f4, f6, 2.0f, f6);
            } else {
                if (camColorFindCamByJ != null) {
                    return camColorFindCamByJ.viewed(viewingConditions);
                }
                fM1155a = AbstractC0622a.m1155a(f4, f6, 2.0f, f6);
                z = false;
            }
        }
        return camColor == null ? CamUtils.intFromLStar(f5) : camColor.viewed(viewingConditions);
    }
}
