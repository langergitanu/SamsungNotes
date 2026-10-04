package opennlp.tools.p217ml;

import java.util.List;
import opennlp.tools.p217ml.model.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArrayMath {
    public static int argmax(double[] dArr) {
        if (dArr == null || dArr.length == 0) {
            throw new IllegalArgumentException("Vector x is null or empty");
        }
        int i = 0;
        for (int i2 = 1; i2 < dArr.length; i2++) {
            if (dArr[i] < dArr[i2]) {
                i = i2;
            }
        }
        return i;
    }

    public static double innerProduct(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null || dArr.length != dArr2.length) {
            return Double.NaN;
        }
        double d = 0.0d;
        for (int i = 0; i < dArr.length; i++) {
            d += dArr[i] * dArr2[i];
        }
        return d;
    }

    public static double invL2norm(double[] dArr) {
        return 1.0d / l2norm(dArr);
    }

    public static double l1norm(double[] dArr) {
        double dAbs = 0.0d;
        for (double d : dArr) {
            dAbs += StrictMath.abs(d);
        }
        return dAbs;
    }

    public static double l2norm(double[] dArr) {
        return StrictMath.sqrt(innerProduct(dArr, dArr));
    }

    public static double logSumOfExps(double[] dArr) {
        double dMax = max(dArr);
        double dExp = 0.0d;
        for (double d : dArr) {
            if (d != Double.NEGATIVE_INFINITY) {
                dExp = StrictMath.exp(d - dMax) + dExp;
            }
        }
        return StrictMath.log(dExp) + dMax;
    }

    public static double max(double[] dArr) {
        return dArr[argmax(dArr)];
    }

    public static void sumFeatures(Context[] contextArr, float[] fArr, double[] dArr) {
        for (int i = 0; i < contextArr.length; i++) {
            Context context = contextArr[i];
            if (context != null) {
                int[] outcomes = context.getOutcomes();
                double[] parameters = context.getParameters();
                double d = fArr != null ? fArr[i] : 1.0d;
                for (int i2 = 0; i2 < outcomes.length; i2++) {
                    int i4 = outcomes[i2];
                    dArr[i4] = (parameters[i2] * d) + dArr[i4];
                }
            }
        }
    }

    public static double[] toDoubleArray(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public static int[] toIntArray(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
