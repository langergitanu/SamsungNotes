package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
public final class Quantiles {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Scale {
        private final int scale;

        public ScaleAndIndex index(int i) {
            return new ScaleAndIndex(this.scale, i);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone());
        }

        private Scale(int i) {
            Preconditions.checkArgument(i > 0, "Quantile scale must be positive");
            this.scale = i;
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.index) * ((long) (dArr.length - 1));
            int iDivide = (int) LongMath.divide(length, this.scale, RoundingMode.DOWN);
            int i = (int) (length - (((long) iDivide) * ((long) this.scale)));
            Quantiles.selectInPlace(iDivide, dArr, 0, dArr.length - 1);
            if (i == 0) {
                return dArr[iDivide];
            }
            int i2 = iDivide + 1;
            Quantiles.selectInPlace(i2, dArr, i2, dArr.length - 1);
            return Quantiles.interpolate(dArr[iDivide], dArr[i2], i, this.scale);
        }

        private ScaleAndIndex(int i, int i2) {
            Quantiles.checkIndex(i2, i);
            this.scale = i;
            this.index = i2;
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            int i = 0;
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (i < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i]), Double.valueOf(Double.NaN));
                    i++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i2 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr6 = this.indexes;
                if (i2 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i2]) * ((long) (dArr.length - 1));
                int iDivide = (int) LongMath.divide(length2, this.scale, RoundingMode.DOWN);
                int i5 = (int) (length2 - (((long) iDivide) * ((long) this.scale)));
                iArr3[i2] = iDivide;
                iArr4[i2] = i5;
                iArr5[i4] = iDivide;
                int i6 = i4 + 1;
                if (i5 != 0) {
                    iArr5[i6] = iDivide + 1;
                    i4 += 2;
                } else {
                    i4 = i6;
                }
                i2++;
            }
            Arrays.sort(iArr5, 0, i4);
            Quantiles.selectAllInPlace(iArr5, 0, i4 - 1, dArr, 0, dArr.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr7 = this.indexes;
                if (i >= iArr7.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i7 = iArr3[i];
                int i8 = iArr4[i];
                if (i8 == 0) {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i]), Double.valueOf(dArr[i7]));
                } else {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i]), Double.valueOf(Quantiles.interpolate(dArr[i7], dArr[i7 + 1], i8, this.scale)));
                }
                i++;
            }
        }

        private ScaleAndIndexes(int i, int[] iArr) {
            for (int i2 : iArr) {
                Quantiles.checkIndex(i2, i);
            }
            Preconditions.checkArgument(iArr.length > 0, "Indexes must be a non empty array");
            this.scale = i;
            this.indexes = iArr;
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkIndex(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "Quantile indexes must be between 0 and the scale, which is "));
        }
    }

    private static int chooseNextSelection(int[] iArr, int i, int i2, int i4, int i5) {
        if (i == i2) {
            return i;
        }
        int i6 = i4 + i5;
        int i7 = i6 >>> 1;
        while (i2 > i + 1) {
            int i8 = (i + i2) >>> 1;
            int i9 = iArr[i8];
            if (i9 > i7) {
                i2 = i8;
            } else {
                if (i9 >= i7) {
                    return i8;
                }
                i = i8;
            }
        }
        return (i6 - iArr[i]) - iArr[i2] > 0 ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsNaN(double... dArr) {
        for (double d : dArr) {
            if (Double.isNaN(d)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double interpolate(double d, double d2, double d3, double d4) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d2 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return (((d2 - d) * d3) / d4) + d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = iArr[i];
        }
        return dArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = jArr[i];
        }
        return dArr;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    private static void movePivotToStartOfSlice(double[] dArr, int i, int i2) {
        int i4 = (i + i2) >>> 1;
        double d = dArr[i2];
        double d2 = dArr[i4];
        boolean z = d < d2;
        double d3 = dArr[i];
        boolean z2 = d2 < d3;
        boolean z3 = d < d3;
        if (z == z2) {
            swap(dArr, i4, i);
        } else if (z != z3) {
            swap(dArr, i, i2);
        }
    }

    private static int partition(double[] dArr, int i, int i2) {
        movePivotToStartOfSlice(dArr, i, i2);
        double d = dArr[i];
        int i4 = i2;
        while (i2 > i) {
            if (dArr[i2] > d) {
                swap(dArr, i4, i2);
                i4--;
            }
            i2--;
        }
        swap(dArr, i, i4);
        return i4;
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int i) {
        return new Scale(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectAllInPlace(int[] iArr, int i, int i2, double[] dArr, int i4, int i5) {
        int iChooseNextSelection = chooseNextSelection(iArr, i, i2, i4, i5);
        int i6 = iArr[iChooseNextSelection];
        selectInPlace(i6, dArr, i4, i5);
        int i7 = iChooseNextSelection - 1;
        while (i7 >= i && iArr[i7] == i6) {
            i7--;
        }
        if (i7 >= i) {
            selectAllInPlace(iArr, i, i7, dArr, i4, i6 - 1);
        }
        int i8 = iChooseNextSelection + 1;
        while (i8 <= i2 && iArr[i8] == i6) {
            i8++;
        }
        if (i8 <= i2) {
            selectAllInPlace(iArr, i8, i2, dArr, i6 + 1, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void selectInPlace(int i, double[] dArr, int i2, int i4) {
        if (i != i2) {
            while (i4 > i2) {
                int iPartition = partition(dArr, i2, i4);
                if (iPartition >= i) {
                    i4 = iPartition - 1;
                }
                if (iPartition <= i) {
                    i2 = iPartition + 1;
                }
            }
            return;
        }
        int i5 = i2;
        for (int i6 = i2 + 1; i6 <= i4; i6++) {
            if (dArr[i5] > dArr[i6]) {
                i5 = i6;
            }
        }
        if (i5 != i2) {
            swap(dArr, i5, i2);
        }
    }

    private static void swap(double[] dArr, int i, int i2) {
        double d = dArr[i];
        dArr[i] = dArr[i2];
        dArr[i2] = d;
    }
}
