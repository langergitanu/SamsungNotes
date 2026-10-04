package androidx.constraintlayout.core.motion.utils;

import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double eps;

    /* JADX INFO: renamed from: mS */
    double f1230mS;

    /* JADX INFO: renamed from: mT */
    double f1231mT;

    public Schlick(String str) {
        this.str = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.f1230mS = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i = iIndexOf2 + 1;
        this.f1231mT = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    private double dfunc(double d) {
        double d2;
        double dM1306C;
        double d3 = this.f1231mT;
        if (d < d3) {
            double d4 = this.f1230mS;
            d2 = d4 * d3 * d3;
            dM1306C = (((d3 - d) * d4) + d) * AbstractC1974b.m1306C(d3, d, d4, d);
        } else {
            double d5 = this.f1230mS;
            d2 = (d3 - 1.0d) * (d3 - 1.0d) * d5;
            dM1306C = ((((d3 - d) * (-d5)) - d) + 1.0d) * ((((d3 - d) * (-d5)) - d) + 1.0d);
        }
        return d2 / dM1306C;
    }

    private double func(double d) {
        double d2 = this.f1231mT;
        if (d < d2) {
            return (d2 * d) / (((d2 - d) * this.f1230mS) + d);
        }
        return ((d - 1.0d) * (1.0d - d2)) / ((1.0d - d) - ((d2 - d) * this.f1230mS));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d) {
        return func(d);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d) {
        return dfunc(d);
    }
}
