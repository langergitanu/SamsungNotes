package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* JADX INFO: renamed from: com.google.android.material.color.utilities.QuantizerWu$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C46561 {

        /* JADX INFO: renamed from: $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction */
        static final /* synthetic */ int[] f2281x8739cebf;

        static {
            int[] iArr = new int[Direction.values().length];
            f2281x8739cebf = iArr;
            try {
                iArr[Direction.RED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2281x8739cebf[Direction.GREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2281x8739cebf[Direction.BLUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CreateBoxesResult {
        int resultCount;

        public CreateBoxesResult(int i, int i2) {
            this.resultCount = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Direction {
        RED,
        GREEN,
        BLUE
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MaximizeResult {
        int cutLocation;
        double maximum;

        public MaximizeResult(int i, double d) {
            this.cutLocation = i;
            this.maximum = d;
        }
    }

    public static int bottom(Box box, Direction direction, int[] iArr) {
        int i;
        int i2;
        int i4 = C46561.f2281x8739cebf[direction.ordinal()];
        if (i4 == 1) {
            i = (-iArr[getIndex(box.f2286r0, box.f2285g1, box.f2283b1)]) + iArr[getIndex(box.f2286r0, box.f2285g1, box.f2282b0)] + iArr[getIndex(box.f2286r0, box.f2284g0, box.f2283b1)];
            i2 = iArr[getIndex(box.f2286r0, box.f2284g0, box.f2282b0)];
        } else if (i4 == 2) {
            i = (-iArr[getIndex(box.f2287r1, box.f2284g0, box.f2283b1)]) + iArr[getIndex(box.f2287r1, box.f2284g0, box.f2282b0)] + iArr[getIndex(box.f2286r0, box.f2284g0, box.f2283b1)];
            i2 = iArr[getIndex(box.f2286r0, box.f2284g0, box.f2282b0)];
        } else {
            if (i4 != 3) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i = (-iArr[getIndex(box.f2287r1, box.f2285g1, box.f2282b0)]) + iArr[getIndex(box.f2287r1, box.f2284g0, box.f2282b0)] + iArr[getIndex(box.f2286r0, box.f2285g1, box.f2282b0)];
            i2 = iArr[getIndex(box.f2286r0, box.f2284g0, box.f2282b0)];
        }
        return i - i2;
    }

    public static int getIndex(int i, int i2, int i4) {
        return (i << 10) + (i << 6) + i + (i2 << 5) + i2 + i4;
    }

    public static int top(Box box, Direction direction, int i, int[] iArr) {
        int i2;
        int i4;
        int i5 = C46561.f2281x8739cebf[direction.ordinal()];
        if (i5 == 1) {
            i2 = (iArr[getIndex(i, box.f2285g1, box.f2283b1)] - iArr[getIndex(i, box.f2285g1, box.f2282b0)]) - iArr[getIndex(i, box.f2284g0, box.f2283b1)];
            i4 = iArr[getIndex(i, box.f2284g0, box.f2282b0)];
        } else if (i5 == 2) {
            i2 = (iArr[getIndex(box.f2287r1, i, box.f2283b1)] - iArr[getIndex(box.f2287r1, i, box.f2282b0)]) - iArr[getIndex(box.f2286r0, i, box.f2283b1)];
            i4 = iArr[getIndex(box.f2286r0, i, box.f2282b0)];
        } else {
            if (i5 != 3) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i2 = (iArr[getIndex(box.f2287r1, box.f2285g1, i)] - iArr[getIndex(box.f2287r1, box.f2284g0, i)]) - iArr[getIndex(box.f2286r0, box.f2285g1, i)];
            i4 = iArr[getIndex(box.f2286r0, box.f2284g0, i)];
        }
        return i2 + i4;
    }

    public static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f2287r1, box.f2285g1, box.f2283b1)] - iArr[getIndex(box.f2287r1, box.f2285g1, box.f2282b0)]) - iArr[getIndex(box.f2287r1, box.f2284g0, box.f2283b1)]) + iArr[getIndex(box.f2287r1, box.f2284g0, box.f2282b0)]) - iArr[getIndex(box.f2286r0, box.f2285g1, box.f2283b1)]) + iArr[getIndex(box.f2286r0, box.f2285g1, box.f2282b0)]) + iArr[getIndex(box.f2286r0, box.f2284g0, box.f2283b1)]) - iArr[getIndex(box.f2286r0, box.f2284g0, box.f2282b0)];
    }

    public void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int iRedFromArgb = ColorUtils.redFromArgb(iIntValue);
            int iGreenFromArgb = ColorUtils.greenFromArgb(iIntValue);
            int iBlueFromArgb = ColorUtils.blueFromArgb(iIntValue);
            int index = getIndex((iRedFromArgb >> 3) + 1, (iGreenFromArgb >> 3) + 1, (iBlueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + iIntValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = (iRedFromArgb * iIntValue2) + iArr2[index];
            int[] iArr3 = this.momentsG;
            iArr3[index] = (iGreenFromArgb * iIntValue2) + iArr3[index];
            int[] iArr4 = this.momentsB;
            iArr4[index] = (iBlueFromArgb * iIntValue2) + iArr4[index];
            double[] dArr = this.moments;
            int i = iBlueFromArgb * iBlueFromArgb;
            dArr[index] = dArr[index] + ((double) ((i + (iGreenFromArgb * iGreenFromArgb) + (iRedFromArgb * iRedFromArgb)) * iIntValue2));
        }
    }

    public CreateBoxesResult createBoxes(int i) {
        int i2;
        this.cubes = new Box[i];
        for (int i4 = 0; i4 < i; i4++) {
            this.cubes[i4] = new Box(null);
        }
        double[] dArr = new double[i];
        Box box = this.cubes[0];
        box.f2287r1 = 32;
        box.f2285g1 = 32;
        box.f2283b1 = 32;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            if (i6 >= i) {
                i2 = i;
                break;
            }
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i5], boxArr[i6]).booleanValue()) {
                Box box2 = this.cubes[i5];
                dArr[i5] = box2.vol > 1 ? variance(box2) : 0.0d;
                Box box3 = this.cubes[i6];
                dArr[i6] = box3.vol > 1 ? variance(box3) : 0.0d;
            } else {
                dArr[i5] = 0.0d;
                i6--;
            }
            double d = dArr[0];
            int i7 = 0;
            for (int i8 = 1; i8 <= i6; i8++) {
                double d2 = dArr[i8];
                if (d2 > d) {
                    i7 = i8;
                    d = d2;
                }
            }
            if (d <= 0.0d) {
                i2 = i6 + 1;
                break;
            }
            i6++;
            i5 = i7;
        }
        return new CreateBoxesResult(i, i2);
    }

    public void createMoments() {
        int i = 1;
        while (true) {
            int i2 = 33;
            if (i >= 33) {
                return;
            }
            int[] iArr = new int[33];
            int[] iArr2 = new int[33];
            int[] iArr3 = new int[33];
            int[] iArr4 = new int[33];
            double[] dArr = new double[33];
            int i4 = 1;
            while (i4 < i2) {
                int i5 = 0;
                int i6 = 0;
                double d = 0.0d;
                int i7 = 1;
                int i8 = 0;
                int i9 = 0;
                while (i7 < i2) {
                    int index = getIndex(i, i4, i7);
                    i5 += this.weights[index];
                    i8 += this.momentsR[index];
                    i9 += this.momentsG[index];
                    i6 += this.momentsB[index];
                    d += this.moments[index];
                    iArr[i7] = iArr[i7] + i5;
                    iArr2[i7] = iArr2[i7] + i8;
                    iArr3[i7] = iArr3[i7] + i9;
                    iArr4[i7] = iArr4[i7] + i6;
                    dArr[i7] = dArr[i7] + d;
                    int index2 = getIndex(i - 1, i4, i7);
                    int i10 = i7;
                    int[] iArr5 = this.weights;
                    iArr5[index] = iArr5[index2] + iArr[i10];
                    int[] iArr6 = this.momentsR;
                    iArr6[index] = iArr6[index2] + iArr2[i10];
                    int[] iArr7 = this.momentsG;
                    iArr7[index] = iArr7[index2] + iArr3[i10];
                    int[] iArr8 = this.momentsB;
                    iArr8[index] = iArr8[index2] + iArr4[i10];
                    double[] dArr2 = this.moments;
                    dArr2[index] = dArr2[index2] + dArr[i10];
                    i7 = i10 + 1;
                    i2 = 33;
                }
                i4++;
                i2 = 33;
            }
            i++;
        }
    }

    public List<Integer> createResult(int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            Box box = this.cubes[i2];
            int iVolume = volume(box, this.weights);
            if (iVolume > 0) {
                int iVolume2 = volume(box, this.momentsR) / iVolume;
                int iVolume3 = volume(box, this.momentsG) / iVolume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / iVolume) & 255) | ((iVolume2 & 255) << 16) | (-16777216) | ((iVolume3 & 255) << 8)));
            }
        }
        return arrayList;
    }

    public Boolean cut(Box box, Box box2) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int iVolume4 = volume(box, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximizeResultMaximize = maximize(box, direction, box.f2286r0 + 1, box.f2287r1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction2 = Direction.GREEN;
        MaximizeResult maximizeResultMaximize2 = maximize(box, direction2, box.f2284g0 + 1, box.f2285g1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction3 = Direction.BLUE;
        MaximizeResult maximizeResultMaximize3 = maximize(box, direction3, box.f2282b0 + 1, box.f2283b1, iVolume, iVolume2, iVolume3, iVolume4);
        double d = maximizeResultMaximize.maximum;
        double d2 = maximizeResultMaximize2.maximum;
        double d3 = maximizeResultMaximize3.maximum;
        if (d < d2 || d < d3) {
            if (d2 >= d && d2 >= d3) {
                direction3 = direction2;
            }
        } else {
            if (maximizeResultMaximize.cutLocation < 0) {
                return Boolean.FALSE;
            }
            direction3 = direction;
        }
        box2.f2287r1 = box.f2287r1;
        box2.f2285g1 = box.f2285g1;
        box2.f2283b1 = box.f2283b1;
        int i = C46561.f2281x8739cebf[direction3.ordinal()];
        if (i == 1) {
            int i2 = maximizeResultMaximize.cutLocation;
            box.f2287r1 = i2;
            box2.f2286r0 = i2;
            box2.f2284g0 = box.f2284g0;
            box2.f2282b0 = box.f2282b0;
        } else if (i == 2) {
            int i4 = maximizeResultMaximize2.cutLocation;
            box.f2285g1 = i4;
            box2.f2286r0 = box.f2286r0;
            box2.f2284g0 = i4;
            box2.f2282b0 = box.f2282b0;
        } else if (i == 3) {
            int i5 = maximizeResultMaximize3.cutLocation;
            box.f2283b1 = i5;
            box2.f2286r0 = box.f2286r0;
            box2.f2284g0 = box.f2284g0;
            box2.f2282b0 = i5;
        }
        box.vol = (box.f2283b1 - box.f2282b0) * (box.f2285g1 - box.f2284g0) * (box.f2287r1 - box.f2286r0);
        box2.vol = (box2.f2283b1 - box2.f2282b0) * (box2.f2285g1 - box2.f2284g0) * (box2.f2287r1 - box2.f2286r0);
        return Boolean.TRUE;
    }

    public MaximizeResult maximize(Box box, Direction direction, int i, int i2, int i4, int i5, int i6, int i7) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        int iBottom = bottom(box2, direction, quantizerWu.momentsR);
        int iBottom2 = bottom(box2, direction, quantizerWu.momentsG);
        int iBottom3 = bottom(box2, direction, quantizerWu.momentsB);
        int iBottom4 = bottom(box2, direction, quantizerWu.weights);
        int i8 = -1;
        double d = 0.0d;
        int i9 = i;
        while (i9 < i2) {
            int pVar = top(box2, direction, i9, quantizerWu.momentsR) + iBottom;
            int pVar2 = top(box2, direction, i9, quantizerWu.momentsG) + iBottom2;
            int pVar3 = top(box2, direction, i9, quantizerWu.momentsB) + iBottom3;
            int pVar4 = top(box2, direction, i9, quantizerWu.weights) + iBottom4;
            if (pVar4 != 0) {
                double d2 = ((double) ((pVar3 * pVar3) + ((pVar2 * pVar2) + (pVar * pVar)))) / ((double) pVar4);
                int i10 = i4 - pVar;
                int i11 = i5 - pVar2;
                int i12 = i6 - pVar3;
                int i13 = i7 - pVar4;
                if (i13 != 0) {
                    double d3 = (((double) ((i12 * i12) + ((i11 * i11) + (i10 * i10)))) / ((double) i13)) + d2;
                    if (d3 > d) {
                        i8 = i9;
                        d = d3;
                    }
                }
            }
            i9++;
            quantizerWu = this;
            box2 = box;
        }
        return new MaximizeResult(i8, d);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i) {
        constructHistogram(new QuantizerMap().quantize(iArr, i).colorToCount);
        createMoments();
        List<Integer> listCreateResult = createResult(createBoxes(i).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : listCreateResult) {
            num.intValue();
            linkedHashMap.put(num, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    public double variance(Box box) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int i = iVolume3 * iVolume3;
        return (((((((this.moments[getIndex(box.f2287r1, box.f2285g1, box.f2283b1)] - this.moments[getIndex(box.f2287r1, box.f2285g1, box.f2282b0)]) - this.moments[getIndex(box.f2287r1, box.f2284g0, box.f2283b1)]) + this.moments[getIndex(box.f2287r1, box.f2284g0, box.f2282b0)]) - this.moments[getIndex(box.f2286r0, box.f2285g1, box.f2283b1)]) + this.moments[getIndex(box.f2286r0, box.f2285g1, box.f2282b0)]) + this.moments[getIndex(box.f2286r0, box.f2284g0, box.f2283b1)]) - this.moments[getIndex(box.f2286r0, box.f2284g0, box.f2282b0)]) - (((double) (i + ((iVolume2 * iVolume2) + (iVolume * iVolume)))) / ((double) volume(box, this.weights)));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Box {

        /* JADX INFO: renamed from: b0 */
        int f2282b0;

        /* JADX INFO: renamed from: b1 */
        int f2283b1;

        /* JADX INFO: renamed from: g0 */
        int f2284g0;

        /* JADX INFO: renamed from: g1 */
        int f2285g1;

        /* JADX INFO: renamed from: r0 */
        int f2286r0;

        /* JADX INFO: renamed from: r1 */
        int f2287r1;
        int vol;

        private Box() {
            this.f2286r0 = 0;
            this.f2287r1 = 0;
            this.f2284g0 = 0;
            this.f2285g1 = 0;
            this.f2282b0 = 0;
            this.f2283b1 = 0;
            this.vol = 0;
        }

        public /* synthetic */ Box(C46561 c46561) {
            this();
        }
    }
}
