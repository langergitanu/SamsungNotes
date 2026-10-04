package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;

    /* JADX INFO: renamed from: mT */
    private double[] f1228mT;
    private double[][] mTangent;

    /* JADX INFO: renamed from: mY */
    private double[][] f1229mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        int i = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i2 = 0; i2 < length2; i2++) {
            int i4 = 0;
            while (i4 < i) {
                int i5 = i4 + 1;
                double d = dArr[i5] - dArr[i4];
                double[] dArr5 = dArr3[i4];
                double d2 = (dArr2[i5][i2] - dArr2[i4][i2]) / d;
                dArr5[i2] = d2;
                if (i4 == 0) {
                    dArr4[i4][i2] = d2;
                } else {
                    dArr4[i4][i2] = (dArr3[i4 - 1][i2] + d2) * 0.5d;
                }
                i4 = i5;
            }
            dArr4[i][i2] = dArr3[length - 2][i2];
        }
        for (int i6 = 0; i6 < i; i6++) {
            for (int i7 = 0; i7 < length2; i7++) {
                double d3 = dArr3[i6][i7];
                if (d3 == 0.0d) {
                    dArr4[i6][i7] = 0.0d;
                    dArr4[i6 + 1][i7] = 0.0d;
                } else {
                    double d4 = dArr4[i6][i7] / d3;
                    int i8 = i6 + 1;
                    double d5 = dArr4[i8][i7] / d3;
                    double dHypot = Math.hypot(d4, d5);
                    if (dHypot > 9.0d) {
                        double d6 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i6];
                        double[] dArr7 = dArr3[i6];
                        dArr6[i7] = d4 * d6 * dArr7[i7];
                        dArr4[i8][i7] = d6 * d5 * dArr7[i7];
                    }
                }
            }
        }
        this.f1228mT = dArr;
        this.f1229mY = dArr2;
        this.mTangent = dArr4;
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i = 0;
        while (iIndexOf2 != -1) {
            dArr[i] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i++;
        }
        dArr[i] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return buildWave(Arrays.copyOf(dArr, i + 1));
    }

    private static double diff(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d2 * 6.0d;
        double d9 = 6.0d * d7 * d3;
        double d10 = (d9 + ((d8 * d4) + (((-6.0d) * d7) * d4))) - (d8 * d3);
        double d11 = 3.0d * d;
        return (d * d5) + (((((d11 * d5) * d7) + (((d11 * d6) * d7) + d10)) - (((2.0d * d) * d6) * d2)) - (((4.0d * d) * d5) * d2));
    }

    private static double interpolate(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d7 * d2;
        double d9 = 3.0d * d7;
        double d10 = d8 * 2.0d * d3;
        double d11 = ((d10 + ((d9 * d4) + (((-2.0d) * d8) * d4))) - (d9 * d3)) + d3;
        double d12 = d * d6;
        double d13 = (d12 * d8) + d11;
        double d14 = d * d5;
        return (d14 * d2) + ((((d8 * d14) + d13) - (d12 * d7)) - (((d * 2.0d) * d5) * d7));
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.f1228mT;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.f1229mY[0].length;
        if (this.mExtrapolate) {
            double d2 = dArr2[0];
            if (d <= d2) {
                getSlope(d2, this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = ((d - this.f1228mT[0]) * this.mSlopeTemp[i2]) + this.f1229mY[0][i2];
                }
                return;
            }
            int i4 = length - 1;
            double d3 = dArr2[i4];
            if (d >= d3) {
                getSlope(d3, this.mSlopeTemp);
                while (i < length2) {
                    dArr[i] = ((d - this.f1228mT[i4]) * this.mSlopeTemp[i]) + this.f1229mY[i4][i];
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr2[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    dArr[i5] = this.f1229mY[0][i5];
                }
                return;
            }
            int i6 = length - 1;
            if (d >= dArr2[i6]) {
                while (i < length2) {
                    dArr[i] = this.f1229mY[i6][i];
                    i++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d == this.f1228mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.f1229mY[i7][i8];
                }
            }
            double[] dArr3 = this.f1228mT;
            int i9 = i7 + 1;
            double d4 = dArr3[i9];
            if (d < d4) {
                double d5 = dArr3[i7];
                double d6 = d4 - d5;
                double d7 = (d - d5) / d6;
                while (i < length2) {
                    double[][] dArr4 = this.f1229mY;
                    double d8 = dArr4[i7][i];
                    double d9 = dArr4[i9][i];
                    double[][] dArr5 = this.mTangent;
                    dArr[i] = interpolate(d6, d7, d8, d9, dArr5[i7][i], dArr5[i9][i]);
                    i++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.f1228mT;
        int length = dArr2.length;
        int length2 = this.f1229mY[0].length;
        double d2 = dArr2[0];
        if (d > d2) {
            d2 = dArr2[length - 1];
            if (d < d2) {
                d2 = d;
            }
        }
        int i = 0;
        while (i < length - 1) {
            double[] dArr3 = this.f1228mT;
            int i2 = i + 1;
            double d3 = dArr3[i2];
            if (d2 <= d3) {
                double d4 = dArr3[i];
                double d5 = d3 - d4;
                double d6 = (d2 - d4) / d5;
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.f1229mY;
                    double d7 = dArr4[i][i4];
                    double d8 = dArr4[i2][i4];
                    double[][] dArr5 = this.mTangent;
                    dArr[i4] = diff(d5, d6, d7, d8, dArr5[i][i4], dArr5[i2][i4]) / d5;
                }
                return;
            }
            i = i2;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.f1228mT;
    }

    private static MonotonicCurveFit buildWave(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i = 0; i < dArr.length; i++) {
            double d2 = dArr[i];
            int i2 = i + length2;
            dArr2[i2][0] = d2;
            double d3 = ((double) i) * d;
            dArr3[i2] = d3;
            if (i > 0) {
                int i4 = (length2 * 2) + i;
                dArr2[i4][0] = d2 + 1.0d;
                dArr3[i4] = d3 + 1.0d;
                int i5 = i - 1;
                dArr2[i5][0] = (d2 - 1.0d) - d;
                dArr3[i5] = (d3 - 1.0d) - d;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        double[] dArr = this.f1228mT;
        int length = dArr.length;
        int i2 = 0;
        double d2 = dArr[0];
        if (d >= d2) {
            d2 = dArr[length - 1];
            if (d < d2) {
                d2 = d;
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f1228mT;
            int i4 = i2 + 1;
            double d3 = dArr2[i4];
            if (d2 <= d3) {
                double d4 = dArr2[i2];
                double d5 = d3 - d4;
                double[][] dArr3 = this.f1229mY;
                double d6 = dArr3[i2][i];
                double d7 = dArr3[i4][i];
                double[][] dArr4 = this.mTangent;
                return diff(d5, (d2 - d4) / d5, d6, d7, dArr4[i2][i], dArr4[i4][i]) / d5;
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.f1228mT;
        int length = dArr.length;
        int i = 0;
        int length2 = this.f1229mY[0].length;
        if (this.mExtrapolate) {
            double d2 = dArr[0];
            if (d <= d2) {
                getSlope(d2, this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (((d - this.f1228mT[0]) * this.mSlopeTemp[i2]) + this.f1229mY[0][i2]);
                }
                return;
            }
            int i4 = length - 1;
            double d3 = dArr[i4];
            if (d >= d3) {
                getSlope(d3, this.mSlopeTemp);
                while (i < length2) {
                    fArr[i] = (float) (((d - this.f1228mT[i4]) * this.mSlopeTemp[i]) + this.f1229mY[i4][i]);
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    fArr[i5] = (float) this.f1229mY[0][i5];
                }
                return;
            }
            int i6 = length - 1;
            if (d >= dArr[i6]) {
                while (i < length2) {
                    fArr[i] = (float) this.f1229mY[i6][i];
                    i++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d == this.f1228mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.f1229mY[i7][i8];
                }
            }
            double[] dArr2 = this.f1228mT;
            int i9 = i7 + 1;
            double d4 = dArr2[i9];
            if (d < d4) {
                double d5 = dArr2[i7];
                double d6 = d4 - d5;
                double d7 = (d - d5) / d6;
                while (i < length2) {
                    double[][] dArr3 = this.f1229mY;
                    double d8 = dArr3[i7][i];
                    double d9 = dArr3[i9][i];
                    double[][] dArr4 = this.mTangent;
                    fArr[i] = (float) interpolate(d6, d7, d8, d9, dArr4[i7][i], dArr4[i9][i]);
                    i++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double[] dArr = this.f1228mT;
        int length = dArr.length;
        int i2 = 0;
        if (this.mExtrapolate) {
            double d2 = dArr[0];
            if (d <= d2) {
                return (getSlope(d2, i) * (d - d2)) + this.f1229mY[0][i];
            }
            int i4 = length - 1;
            double d3 = dArr[i4];
            if (d >= d3) {
                return (getSlope(d3, i) * (d - d3)) + this.f1229mY[i4][i];
            }
        } else {
            if (d <= dArr[0]) {
                return this.f1229mY[0][i];
            }
            int i5 = length - 1;
            if (d >= dArr[i5]) {
                return this.f1229mY[i5][i];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f1228mT;
            double d4 = dArr2[i2];
            if (d == d4) {
                return this.f1229mY[i2][i];
            }
            int i6 = i2 + 1;
            double d5 = dArr2[i6];
            if (d < d5) {
                double d6 = d5 - d4;
                double d7 = (d - d4) / d6;
                double[][] dArr3 = this.f1229mY;
                double d8 = dArr3[i2][i];
                double d9 = dArr3[i6][i];
                double[][] dArr4 = this.mTangent;
                return interpolate(d6, d7, d8, d9, dArr4[i2][i], dArr4[i6][i]);
            }
            i2 = i6;
        }
        return 0.0d;
    }
}
