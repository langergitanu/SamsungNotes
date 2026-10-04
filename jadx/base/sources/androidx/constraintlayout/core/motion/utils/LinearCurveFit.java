package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;

    /* JADX INFO: renamed from: mT */
    private double[] f1226mT;
    private double mTotalLength;

    /* JADX INFO: renamed from: mY */
    private double[][] f1227mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        this.f1226mT = dArr;
        this.f1227mY = dArr2;
        if (length2 <= 2) {
            return;
        }
        int i = 0;
        double d = 0.0d;
        while (true) {
            double d2 = d;
            if (i >= dArr.length) {
                this.mTotalLength = 0.0d;
                return;
            }
            double d3 = dArr2[i][0];
            if (i > 0) {
                Math.hypot(d3 - d, d3 - d2);
            }
            i++;
            d = d3;
        }
    }

    private double getLength2D(double d) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.f1226mT;
        int length = dArr.length;
        if (d <= dArr[0]) {
            return 0.0d;
        }
        int i = length - 1;
        if (d >= dArr[i]) {
            return this.mTotalLength;
        }
        double dHypot = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        while (i2 < i) {
            double[] dArr2 = this.f1227mY[i2];
            double d4 = dArr2[0];
            double d5 = dArr2[1];
            if (i2 > 0) {
                dHypot += Math.hypot(d4 - d2, d5 - d3);
            }
            double[] dArr3 = this.f1226mT;
            double d6 = dArr3[i2];
            if (d == d6) {
                return dHypot;
            }
            int i4 = i2 + 1;
            double d7 = dArr3[i4];
            if (d < d7) {
                double d8 = (d - d6) / (d7 - d6);
                double[][] dArr4 = this.f1227mY;
                double[] dArr5 = dArr4[i2];
                double d9 = dArr5[0];
                double[] dArr6 = dArr4[i4];
                double d10 = dArr6[0];
                double d11 = 1.0d - d8;
                return Math.hypot(d5 - ((dArr6[1] * d8) + (dArr5[1] * d11)), d4 - ((d10 * d8) + (d9 * d11))) + dHypot;
            }
            i2 = i4;
            d2 = d4;
            d3 = d5;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.f1226mT;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.f1227mY[0].length;
        if (this.mExtrapolate) {
            double d2 = dArr2[0];
            if (d <= d2) {
                getSlope(d2, this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = ((d - this.f1226mT[0]) * this.mSlopeTemp[i2]) + this.f1227mY[0][i2];
                }
                return;
            }
            int i4 = length - 1;
            double d3 = dArr2[i4];
            if (d >= d3) {
                getSlope(d3, this.mSlopeTemp);
                while (i < length2) {
                    dArr[i] = ((d - this.f1226mT[i4]) * this.mSlopeTemp[i]) + this.f1227mY[i4][i];
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr2[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    dArr[i5] = this.f1227mY[0][i5];
                }
                return;
            }
            int i6 = length - 1;
            if (d >= dArr2[i6]) {
                while (i < length2) {
                    dArr[i] = this.f1227mY[i6][i];
                    i++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d == this.f1226mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.f1227mY[i7][i8];
                }
            }
            double[] dArr3 = this.f1226mT;
            int i9 = i7 + 1;
            double d4 = dArr3[i9];
            if (d < d4) {
                double d5 = dArr3[i7];
                double d6 = (d - d5) / (d4 - d5);
                while (i < length2) {
                    double[][] dArr4 = this.f1227mY;
                    dArr[i] = (dArr4[i9][i] * d6) + ((1.0d - d6) * dArr4[i7][i]);
                    i++;
                }
                return;
            }
            i7 = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r4
      0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.f1226mT;
        int length = dArr2.length;
        int length2 = this.f1227mY[0].length;
        double d2 = dArr2[0];
        if (d <= d2) {
            d = d2;
        } else {
            d2 = dArr2[length - 1];
            if (d >= d2) {
            }
        }
        int i = 0;
        while (i < length - 1) {
            double[] dArr3 = this.f1226mT;
            int i2 = i + 1;
            double d3 = dArr3[i2];
            if (d <= d3) {
                double d4 = d3 - dArr3[i];
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.f1227mY;
                    dArr[i4] = (dArr4[i2][i4] - dArr4[i][i4]) / d4;
                }
                return;
            }
            i = i2;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.f1226mT;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a A[PHI: r3
      0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double getSlope(double d, int i) {
        double[] dArr = this.f1226mT;
        int length = dArr.length;
        int i2 = 0;
        double d2 = dArr[0];
        if (d < d2) {
            d = d2;
        } else {
            d2 = dArr[length - 1];
            if (d >= d2) {
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f1226mT;
            int i4 = i2 + 1;
            double d3 = dArr2[i4];
            if (d <= d3) {
                double d4 = d3 - dArr2[i2];
                double[][] dArr3 = this.f1227mY;
                return (dArr3[i4][i] - dArr3[i2][i]) / d4;
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.f1226mT;
        int length = dArr.length;
        int i = 0;
        int length2 = this.f1227mY[0].length;
        if (this.mExtrapolate) {
            double d2 = dArr[0];
            if (d <= d2) {
                getSlope(d2, this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (((d - this.f1226mT[0]) * this.mSlopeTemp[i2]) + this.f1227mY[0][i2]);
                }
                return;
            }
            int i4 = length - 1;
            double d3 = dArr[i4];
            if (d >= d3) {
                getSlope(d3, this.mSlopeTemp);
                while (i < length2) {
                    fArr[i] = (float) (((d - this.f1226mT[i4]) * this.mSlopeTemp[i]) + this.f1227mY[i4][i]);
                    i++;
                }
                return;
            }
        } else {
            if (d <= dArr[0]) {
                for (int i5 = 0; i5 < length2; i5++) {
                    fArr[i5] = (float) this.f1227mY[0][i5];
                }
                return;
            }
            int i6 = length - 1;
            if (d >= dArr[i6]) {
                while (i < length2) {
                    fArr[i] = (float) this.f1227mY[i6][i];
                    i++;
                }
                return;
            }
        }
        int i7 = 0;
        while (i7 < length - 1) {
            if (d == this.f1226mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.f1227mY[i7][i8];
                }
            }
            double[] dArr2 = this.f1226mT;
            int i9 = i7 + 1;
            double d4 = dArr2[i9];
            if (d < d4) {
                double d5 = dArr2[i7];
                double d6 = (d - d5) / (d4 - d5);
                while (i < length2) {
                    double[][] dArr3 = this.f1227mY;
                    fArr[i] = (float) ((dArr3[i9][i] * d6) + ((1.0d - d6) * dArr3[i7][i]));
                    i++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double d2;
        double d3;
        double slope;
        double[] dArr = this.f1226mT;
        int length = dArr.length;
        int i2 = 0;
        if (this.mExtrapolate) {
            double d4 = dArr[0];
            if (d <= d4) {
                d2 = this.f1227mY[0][i];
                d3 = d - d4;
                slope = getSlope(d4, i);
            } else {
                int i4 = length - 1;
                double d5 = dArr[i4];
                if (d >= d5) {
                    d2 = this.f1227mY[i4][i];
                    d3 = d - d5;
                    slope = getSlope(d5, i);
                }
            }
            return (slope * d3) + d2;
        }
        if (d <= dArr[0]) {
            return this.f1227mY[0][i];
        }
        int i5 = length - 1;
        if (d >= dArr[i5]) {
            return this.f1227mY[i5][i];
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f1226mT;
            double d6 = dArr2[i2];
            if (d == d6) {
                return this.f1227mY[i2][i];
            }
            int i6 = i2 + 1;
            double d7 = dArr2[i6];
            if (d < d7) {
                double d8 = (d - d6) / (d7 - d6);
                double[][] dArr3 = this.f1227mY;
                return (dArr3[i6][i] * d8) + ((1.0d - d8) * dArr3[i2][i]);
            }
            i2 = i6;
        }
        return 0.0d;
    }
}
