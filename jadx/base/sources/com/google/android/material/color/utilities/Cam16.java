package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Cam16 {
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;

    /* JADX INFO: renamed from: j */
    private final double f2272j;
    private final double jstar;

    /* JADX INFO: renamed from: m */
    private final double f2273m;

    /* JADX INFO: renamed from: q */
    private final double f2274q;

    /* JADX INFO: renamed from: s */
    private final double f2275s;
    private final double[] tempArray = {0.0d, 0.0d, 0.0d};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    private Cam16(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.hue = d;
        this.chroma = d2;
        this.f2272j = d3;
        this.f2274q = d4;
        this.f2273m = d5;
        this.f2275s = d6;
        this.jstar = d7;
        this.astar = d8;
        this.bstar = d9;
    }

    public static Cam16 fromInt(int i) {
        return fromIntInViewingConditions(i, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int i, ViewingConditions viewingConditions) {
        double dLinearized = ColorUtils.linearized((16711680 & i) >> 16);
        double dLinearized2 = ColorUtils.linearized((65280 & i) >> 8);
        double dLinearized3 = ColorUtils.linearized(i & 255);
        return fromXyzInViewingConditions((0.18051042d * dLinearized3) + (0.35762064d * dLinearized2) + (0.41233895d * dLinearized), (0.0722d * dLinearized3) + (0.7152d * dLinearized2) + (0.2126d * dLinearized), (dLinearized3 * 0.95034478d) + (dLinearized2 * 0.11916382d) + (dLinearized * 0.01932141d), viewingConditions);
    }

    public static Cam16 fromJch(double d, double d2, double d3) {
        return fromJchInViewingConditions(d, d2, d3, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double d4 = d / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (viewingConditions.getAw() + 4.0d) * Math.sqrt(d4) * (4.0d / viewingConditions.getC());
        double flRoot2 = viewingConditions.getFlRoot() * d2;
        double dSqrt = Math.sqrt((viewingConditions.getC() * (d2 / Math.sqrt(d4))) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double radians = Math.toRadians(d3);
        double d5 = (1.7000000000000002d * d) / ((0.007d * d) + 1.0d);
        double dLog1p = Math.log1p(0.0228d * flRoot2) * 43.859649122807014d;
        return new Cam16(d3, d2, d, flRoot, flRoot2, dSqrt, d5, Math.cos(radians) * dLog1p, Math.sin(radians) * dLog1p);
    }

    public static Cam16 fromUcs(double d, double d2, double d3) {
        return fromUcsInViewingConditions(d, d2, d3, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double dExpm1 = (Math.expm1(Math.hypot(d2, d3) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double dAtan2 = Math.atan2(d3, d2) * 57.29577951308232d;
        if (dAtan2 < 0.0d) {
            dAtan2 += 360.0d;
        }
        return fromJchInViewingConditions(d / (1.0d - ((d - 100.0d) * 0.007d)), dExpm1, dAtan2, viewingConditions);
    }

    public static Cam16 fromXyzInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double[][] dArr = XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d4 = (dArr2[2] * d3) + (dArr2[1] * d2) + (dArr2[0] * d);
        double[] dArr3 = dArr[1];
        double d5 = (dArr3[2] * d3) + (dArr3[1] * d2) + (dArr3[0] * d);
        double[] dArr4 = dArr[2];
        double d6 = (dArr4[2] * d3) + (dArr4[1] * d2) + (dArr4[0] * d);
        double d7 = viewingConditions.getRgbD()[0] * d4;
        double d8 = viewingConditions.getRgbD()[1] * d5;
        double d9 = viewingConditions.getRgbD()[2] * d6;
        double dPow = Math.pow((Math.abs(d7) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dPow2 = Math.pow((Math.abs(d8) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dPow3 = Math.pow((Math.abs(d9) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dSignum = ((Math.signum(d7) * 400.0d) * dPow) / (dPow + 27.13d);
        double dSignum2 = ((Math.signum(d8) * 400.0d) * dPow2) / (dPow2 + 27.13d);
        double dSignum3 = ((Math.signum(d9) * 400.0d) * dPow3) / (dPow3 + 27.13d);
        double d10 = ((((-12.0d) * dSignum2) + (dSignum * 11.0d)) + dSignum3) / 11.0d;
        double dM1333z = AbstractC1974b.m1333z(dSignum3, 2.0d, dSignum + dSignum2, 9.0d);
        double d11 = dSignum2 * 20.0d;
        double dM1308a = AbstractC1974b.m1308a(dSignum3, 21.0d, (dSignum * 20.0d) + d11, 20.0d);
        double d12 = (((dSignum * 40.0d) + d11) + dSignum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(dM1333z, d10));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d13 = degrees;
        double radians = Math.toRadians(d13);
        double dPow4 = Math.pow((viewingConditions.getNbb() * d12) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
        double d14 = dPow4 / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (viewingConditions.getAw() + 4.0d) * Math.sqrt(d14) * (4.0d / viewingConditions.getC());
        double dPow5 = Math.pow((Math.hypot(d10, dM1333z) * (viewingConditions.getNcb() * (viewingConditions.getNc() * (((Math.cos(Math.toRadians(d13 < 20.14d ? d13 + 360.0d : d13) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d)))) / (dM1308a + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        double dSqrt = Math.sqrt(d14) * dPow5;
        double flRoot2 = viewingConditions.getFlRoot() * dSqrt;
        double dSqrt2 = Math.sqrt((viewingConditions.getC() * dPow5) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double d15 = (1.7000000000000002d * dPow4) / ((0.007d * dPow4) + 1.0d);
        double dLog1p = Math.log1p(0.0228d * flRoot2) * 43.859649122807014d;
        return new Cam16(d13, dSqrt, dPow4, flRoot, flRoot2, dSqrt2, d15, Math.cos(radians) * dLog1p, Math.sin(radians) * dLog1p);
    }

    public double distance(Cam16 cam16) {
        double jstar = getJstar() - cam16.getJstar();
        double astar = getAstar() - cam16.getAstar();
        double bstar = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((bstar * bstar) + (astar * astar) + (jstar * jstar)), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.f2272j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.f2273m;
    }

    public double getQ() {
        return this.f2274q;
    }

    public double getS() {
        return this.f2275s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public int viewed(ViewingConditions viewingConditions) {
        double[] dArrXyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(dArrXyzInViewingConditions[0], dArrXyzInViewingConditions[1], dArrXyzInViewingConditions[2]);
    }

    public double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double dPow = Math.pow(((getChroma() == 0.0d || getJ() == 0.0d) ? 0.0d : getChroma() / Math.sqrt(getJ() / 100.0d)) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double dCos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d;
        double dPow2 = Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()) * viewingConditions.getAw();
        double ncb = viewingConditions.getNcb() * viewingConditions.getNc() * dCos * 3846.153846153846d;
        double nbb = dPow2 / viewingConditions.getNbb();
        double dSin = Math.sin(radians);
        double dCos2 = Math.cos(radians);
        double d = (((0.305d + nbb) * 23.0d) * dPow) / (((dPow * 108.0d) * dSin) + (((11.0d * dPow) * dCos2) + (ncb * 23.0d)));
        double d2 = dCos2 * d;
        double d3 = d * dSin;
        double d4 = nbb * 460.0d;
        double dM1308a = AbstractC1974b.m1308a(d3, 288.0d, (451.0d * d2) + d4, 1403.0d);
        double dM1333z = AbstractC1974b.m1333z(d3, 261.0d, d4 - (891.0d * d2), 1403.0d);
        double dM1333z2 = AbstractC1974b.m1333z(d3, 6300.0d, d4 - (d2 * 220.0d), 1403.0d);
        double dPow3 = Math.pow(Math.max(0.0d, (Math.abs(dM1308a) * 27.13d) / (400.0d - Math.abs(dM1308a))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(dM1308a);
        double dPow4 = Math.pow(Math.max(0.0d, (Math.abs(dM1333z) * 27.13d) / (400.0d - Math.abs(dM1333z))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(dM1333z);
        double dPow5 = Math.pow(Math.max(0.0d, (Math.abs(dM1333z2) * 27.13d) / (400.0d - Math.abs(dM1333z2))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(dM1333z2);
        double d5 = dPow3 / viewingConditions.getRgbD()[0];
        double d6 = dPow4 / viewingConditions.getRgbD()[1];
        double d7 = dPow5 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d8 = (dArr3[2] * d7) + (dArr3[1] * d6) + (dArr3[0] * d5);
        double[] dArr4 = dArr2[1];
        double d9 = (dArr4[2] * d7) + (dArr4[1] * d6) + (dArr4[0] * d5);
        double[] dArr5 = dArr2[2];
        double d10 = (d7 * dArr5[2]) + (d6 * dArr5[1]) + (d5 * dArr5[0]);
        if (dArr == null) {
            return new double[]{d8, d9, d10};
        }
        dArr[0] = d8;
        dArr[1] = d9;
        dArr[2] = d10;
        return dArr;
    }
}
