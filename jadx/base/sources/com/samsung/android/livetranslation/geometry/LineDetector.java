package com.samsung.android.livetranslation.geometry;

import android.graphics.Point;
import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LineDetector {
    private LineAlgorithm mMode = LineAlgorithm.RANDOM_FOREST;

    /* JADX INFO: renamed from: com.samsung.android.livetranslation.geometry.LineDetector$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C71551 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$livetranslation$geometry$LineDetector$LineAlgorithm */
        static final /* synthetic */ int[] f4811xe50ec442;

        static {
            int[] iArr = new int[LineAlgorithm.values().length];
            f4811xe50ec442 = iArr;
            try {
                iArr[LineAlgorithm.LOGISTIC_REGRESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4811xe50ec442[LineAlgorithm.RANDOM_FOREST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4811xe50ec442[LineAlgorithm.DATA_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LineAlgorithm {
        LOGISTIC_REGRESSION,
        RANDOM_FOREST,
        DATA_SET
    }

    private boolean dataSet(Point[] pointArr, Point[] pointArr2, int i, int i2) {
        return false;
    }

    private boolean logisticRegression(Point[] pointArr, Point[] pointArr2, int i, int i2) {
        double[] dArr = {-0.18471853157439835d, -0.0031349510660258475d, 0.1794453136803585d, 0.023158140659835905d, -0.18284697975598033d, -0.0235184793319766d, 0.18588336366154318d, 0.024228456284229025d, 0.18822890144735413d, -0.06543840936111293d, -0.024772544749421054d, 0.028730626449414248d, 0.02271880842351833d, -0.02351149065570263d, -0.18391774716961576d, 0.040871512378172645d, -0.006742633478447907d, -0.004890368716609771d};
        double d = 0.0d;
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = i4 * 2;
            double d2 = dArr[i5];
            Point point = pointArr[i4];
            d = (dArr[i5 + 1] * ((double) point.y)) + (d2 * ((double) point.x)) + d;
        }
        double d3 = d;
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = i6 * 2;
            double d4 = dArr[i7 + 8];
            Point point2 = pointArr2[i6];
            d3 = (dArr[i7 + 9] * ((double) point2.y)) + (d4 * ((double) point2.x)) + d3;
        }
        return 1.0d / (Math.exp(-AbstractC1974b.m1307D(dArr[17], (double) i2, dArr[16] * ((double) i), d3)) + 1.0d) > 0.5d;
    }

    private boolean randomForest(Point[] pointArr, Point[] pointArr2, int i, int i2) {
        return false;
    }

    public boolean isSameLine(Point[] pointArr, Point[] pointArr2, int i, int i2) {
        int i4 = C71551.f4811xe50ec442[this.mMode.ordinal()];
        if (i4 == 1) {
            return logisticRegression(pointArr, pointArr2, i, i2);
        }
        if (i4 == 2) {
            return randomForest(pointArr, pointArr2, i, i2);
        }
        if (i4 != 3) {
            return false;
        }
        return dataSet(pointArr, pointArr2, i, i2);
    }
}
