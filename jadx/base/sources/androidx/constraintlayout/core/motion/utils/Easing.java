package androidx.constraintlayout.core.motion.utils;

import androidx.compose.runtime.AbstractC1974b;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    String str = "identity";
    static Easing sDefault = new Easing();
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {"standard", ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* JADX INFO: renamed from: x1 */
        double f1218x1;

        /* JADX INFO: renamed from: x2 */
        double f1219x2;

        /* JADX INFO: renamed from: y1 */
        double f1220y1;

        /* JADX INFO: renamed from: y2 */
        double f1221y2;

        public CubicEasing(String str) {
            this.str = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f1218x1 = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i);
            this.f1220y1 = Double.parseDouble(str.substring(i, iIndexOf3).trim());
            int i2 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i2);
            this.f1219x2 = Double.parseDouble(str.substring(i2, iIndexOf4).trim());
            int i4 = iIndexOf4 + 1;
            this.f1221y2 = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        private double getDiffX(double d) {
            double d2 = 1.0d - d;
            double d3 = this.f1218x1;
            double d4 = d2 * 3.0d * d2 * d3;
            double d5 = d2 * 6.0d * d;
            double d6 = this.f1219x2;
            return AbstractC1974b.m1306C(1.0d, d6, 3.0d * d * d, AbstractC1974b.m1306C(d6, d3, d5, d4));
        }

        private double getDiffY(double d) {
            double d2 = 1.0d - d;
            double d3 = this.f1220y1;
            double d4 = d2 * 3.0d * d2 * d3;
            double d5 = d2 * 6.0d * d;
            double d6 = this.f1221y2;
            return AbstractC1974b.m1306C(1.0d, d6, 3.0d * d * d, AbstractC1974b.m1306C(d6, d3, d5, d4));
        }

        private double getX(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            double d4 = d * d * d;
            return AbstractC1974b.m1307D(this.f1219x2, d3 * d * d, this.f1218x1 * d2 * d3 * d, d4);
        }

        private double getY(double d) {
            double d2 = 1.0d - d;
            double d3 = 3.0d * d2;
            double d4 = d * d * d;
            return AbstractC1974b.m1307D(this.f1221y2, d3 * d * d, this.f1220y1 * d2 * d3 * d, d4);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > error) {
                d2 *= 0.5d;
                d3 = getX(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double x = getX(d4);
            double d5 = d3 + d2;
            double x2 = getX(d5);
            double y2 = getY(d4);
            return (((d - x) * (getY(d5) - y2)) / (x2 - x)) + y2;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d) {
            double d2 = 0.5d;
            double d3 = 0.5d;
            while (d2 > d_error) {
                d2 *= 0.5d;
                d3 = getX(d3) < d ? d3 + d2 : d3 - d2;
            }
            double d4 = d3 - d2;
            double d5 = d3 + d2;
            return (getY(d5) - getY(d4)) / (getX(d5) - getX(d4));
        }

        public void setup(double d, double d2, double d3, double d4) {
            this.f1218x1 = d;
            this.f1220y1 = d2;
            this.f1219x2 = d3;
            this.f1221y2 = d4;
        }

        public CubicEasing(double d, double d2, double d3, double d4) {
            setup(d, d2, d3, d4);
        }
    }

    public double get(double d) {
        return d;
    }
}
