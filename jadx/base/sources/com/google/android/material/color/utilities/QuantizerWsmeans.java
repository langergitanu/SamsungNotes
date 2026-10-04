package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Distance implements Comparable<Distance> {
        int index = -1;
        double distance = -1.0d;

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i) {
        char c;
        double[] dArr;
        double[] dArr2;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr3 = new double[iArr.length][];
        int[] iArr3 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i2 = 0;
        int i4 = 0;
        while (true) {
            c = 1;
            if (i2 >= iArr.length) {
                break;
            }
            int i5 = iArr[i2];
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i5));
            if (num == null) {
                dArr3[i4] = pointProviderLab.fromInt(i5);
                iArr3[i4] = i5;
                i4++;
                linkedHashMap.put(Integer.valueOf(i5), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i5), Integer.valueOf(num.intValue() + 1));
            }
            i2++;
        }
        int[] iArr4 = new int[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            iArr4[i6] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr3[i6]))).intValue();
        }
        int iMin = Math.min(i, i4);
        if (iArr2.length != 0) {
            iMin = Math.min(iMin, iArr2.length);
        }
        double[][] dArr4 = new double[iMin][];
        int i7 = 0;
        for (int i8 = 0; i8 < iArr2.length; i8++) {
            dArr4[i8] = pointProviderLab.fromInt(iArr2[i8]);
            i7++;
        }
        int i9 = iMin - i7;
        if (i9 > 0) {
            for (int i10 = 0; i10 < i9; i10++) {
            }
        }
        int[] iArr5 = new int[i4];
        for (int i11 = 0; i11 < i4; i11++) {
            iArr5[i11] = random.nextInt(iMin);
        }
        int[][] iArr6 = new int[iMin][];
        for (int i12 = 0; i12 < iMin; i12++) {
            iArr6[i12] = new int[iMin];
        }
        Distance[][] distanceArr = new Distance[iMin][];
        for (int i13 = 0; i13 < iMin; i13++) {
            distanceArr[i13] = new Distance[iMin];
            for (int i14 = 0; i14 < iMin; i14++) {
                distanceArr[i13][i14] = new Distance();
            }
        }
        int[] iArr7 = new int[iMin];
        int i15 = 0;
        while (i15 < 10) {
            int i16 = 0;
            while (i16 < iMin) {
                int i17 = i16 + 1;
                int i18 = i17;
                while (i18 < iMin) {
                    int[] iArr8 = iArr4;
                    double dDistance = pointProviderLab.distance(dArr4[i16], dArr4[i18]);
                    Distance distance = distanceArr[i18][i16];
                    distance.distance = dDistance;
                    distance.index = i16;
                    Distance distance2 = distanceArr[i16][i18];
                    distance2.distance = dDistance;
                    distance2.index = i18;
                    i18++;
                    iArr4 = iArr8;
                    iArr5 = iArr5;
                    c = c;
                }
                int[] iArr9 = iArr4;
                int[] iArr10 = iArr5;
                char c2 = c;
                Arrays.sort(distanceArr[i16]);
                for (int i19 = 0; i19 < iMin; i19++) {
                    iArr6[i16][i19] = distanceArr[i16][i19].index;
                }
                iArr4 = iArr9;
                iArr5 = iArr10;
                i16 = i17;
                c = c2;
            }
            int[] iArr11 = iArr4;
            int[] iArr12 = iArr5;
            char c4 = c;
            int i20 = 0;
            int i21 = 0;
            while (i20 < i4) {
                double[] dArr5 = dArr3[i20];
                int i22 = iArr12[i20];
                double dDistance2 = pointProviderLab.distance(dArr5, dArr4[i22]);
                int i23 = i20;
                double d = dDistance2;
                int i24 = -1;
                int i25 = 0;
                while (i25 < iMin) {
                    int i26 = i21;
                    int[][] iArr13 = iArr6;
                    if (distanceArr[i22][i25].distance < 4.0d * dDistance2) {
                        double dDistance3 = pointProviderLab.distance(dArr5, dArr4[i25]);
                        if (dDistance3 < d) {
                            d = dDistance3;
                            i24 = i25;
                        }
                    }
                    i25++;
                    iArr6 = iArr13;
                    i21 = i26;
                }
                int i27 = i21;
                int[][] iArr14 = iArr6;
                if (i24 == -1 || Math.abs(Math.sqrt(d) - Math.sqrt(dDistance2)) <= 3.0d) {
                    i21 = i27;
                } else {
                    i21 = i27 + 1;
                    iArr12[i23] = i24;
                }
                i20 = i23 + 1;
                iArr6 = iArr14;
            }
            int[][] iArr15 = iArr6;
            if (i21 == 0 && i15 != 0) {
                break;
            }
            double[] dArr6 = new double[iMin];
            double[] dArr7 = new double[iMin];
            double[] dArr8 = new double[iMin];
            boolean z = false;
            Arrays.fill(iArr7, 0);
            int i28 = 0;
            while (i28 < i4) {
                int i29 = iArr12[i28];
                double[] dArr9 = dArr3[i28];
                boolean z2 = z;
                int i30 = iArr11[i28];
                iArr7[i29] = iArr7[i29] + i30;
                double d2 = i30;
                dArr6[i29] = (dArr9[z2 ? 1 : 0] * d2) + dArr6[i29];
                dArr7[i29] = (dArr9[c4] * d2) + dArr7[i29];
                dArr8[i29] = (dArr9[2] * d2) + dArr8[i29];
                i28++;
                z = false;
            }
            int i31 = 0;
            while (i31 < iMin) {
                int i32 = iArr7[i31];
                if (i32 == 0) {
                    dArr4[i31] = new double[]{0.0d, 0.0d, 0.0d};
                    dArr = dArr6;
                    dArr2 = dArr7;
                } else {
                    double d3 = dArr6[i31];
                    dArr = dArr6;
                    dArr2 = dArr7;
                    double d4 = i32;
                    double d5 = d3 / d4;
                    double d6 = dArr2[i31] / d4;
                    double d7 = dArr8[i31] / d4;
                    double[] dArr10 = dArr4[i31];
                    dArr10[0] = d5;
                    dArr10[c4] = d6;
                    dArr10[2] = d7;
                }
                i31++;
                dArr6 = dArr;
                dArr7 = dArr2;
            }
            i15++;
            iArr4 = iArr11;
            iArr5 = iArr12;
            c = c4;
            iArr6 = iArr15;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i33 = 0; i33 < iMin; i33++) {
            int i34 = iArr7[i33];
            if (i34 != 0) {
                int i35 = pointProviderLab.toInt(dArr4[i33]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i35))) {
                    linkedHashMap2.put(Integer.valueOf(i35), Integer.valueOf(i34));
                }
            }
        }
        return linkedHashMap2;
    }
}
