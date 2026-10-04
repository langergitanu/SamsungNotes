package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VUtilMath {
    public static double degreeToRadian(float f) {
        return (((double) f) * 3.141592653589793d) / 180.0d;
    }

    public static double getPointDistance(double d, double d2, double d3, double d4) {
        double d5 = d - d3;
        double d6 = d2 - d4;
        return Math.sqrt((d6 * d6) + (d5 * d5));
    }

    public static double getThreePointDegree(double d, double d2, double d3, double d4, double d5, double d6, boolean z, float f, boolean z2) {
        double dRadianToDegree = radianToDegree(Math.acos(((Math.pow(getPointDistance(d3, d4, d5, d6), 2.0d) + Math.pow(getPointDistance(d, d2, d3, d4), 2.0d)) - Math.pow(getPointDistance(d, d2, d5, d6), 2.0d)) / ((getPointDistance(d, d2, d3, d4) * 2.0d) * getPointDistance(d3, d4, d5, d6))));
        if (!z2) {
            float f4 = -f;
            double dCos = (Math.cos(degreeToRadian(f4)) * (d6 - d4)) + (Math.sin(degreeToRadian(f4)) * (d5 - d3));
            if (!z) {
                return 0.0d > dCos ? -dRadianToDegree : dRadianToDegree - 360.0d;
            }
            if (0.0d > dCos) {
                return 360.0d - dRadianToDegree;
            }
        } else if (d4 >= d6) {
            return 360.0d - dRadianToDegree;
        }
        return dRadianToDegree;
    }

    public static double radianToDegree(double d) {
        return (d * 180.0d) / 3.141592653589793d;
    }
}
