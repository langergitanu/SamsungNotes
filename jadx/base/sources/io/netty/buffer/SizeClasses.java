package io.netty.buffer;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
abstract class SizeClasses implements SizeClassesMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INDEX_IDX = 0;
    private static final int LOG2DELTA_IDX = 2;
    private static final int LOG2GROUP_IDX = 1;
    private static final int LOG2_DELTA_LOOKUP_IDX = 6;
    private static final int LOG2_MAX_LOOKUP_SIZE = 12;
    static final int LOG2_QUANTUM = 4;
    private static final int LOG2_SIZE_CLASS_GROUP = 2;
    private static final int NDELTA_IDX = 3;
    private static final int PAGESIZE_IDX = 4;
    private static final int SUBPAGE_IDX = 5;

    /* JADX INFO: renamed from: no */
    private static final byte f8856no = 0;
    private static final byte yes = 1;
    protected final int chunkSize;
    protected final int directMemoryCacheAlignment;
    final int lookupMaxSize;
    final int nPSizes;
    final int nSizes;
    final int nSubpages;
    private final int[] pageIdx2sizeTab;
    protected final int pageShifts;
    protected final int pageSize;
    private final int[] size2idxTab;
    private final int[] sizeIdx2sizeTab;
    final int smallMaxSizeIdx;

    public SizeClasses(int i, int i2, int i4, int i5) {
        char c = 5;
        int i6 = 0;
        short[][] sArr = (short[][]) Array.newInstance((Class<?>) Short.TYPE, (PoolThreadCache.log2(i4) - 5) << 2, 7);
        int i7 = 0;
        int i8 = 0;
        int iSizeOf = 0;
        while (i7 < 4) {
            short[] sArrNewSizeClass = newSizeClass(i8, 4, 4, i7, i2);
            sArr[i8] = sArrNewSizeClass;
            iSizeOf = sizeOf(sArrNewSizeClass, i5);
            i7++;
            i8++;
        }
        int i9 = 6;
        int i10 = 4;
        while (iSizeOf < i4) {
            int i11 = 1;
            while (i11 <= 4 && iSizeOf < i4) {
                short[] sArrNewSizeClass2 = newSizeClass(i8, i9, i10, i11, i2);
                sArr[i8] = sArrNewSizeClass2;
                iSizeOf = sizeOf(sArrNewSizeClass2, i5);
                i11++;
                i8++;
            }
            i9++;
            i10++;
        }
        int i12 = 0;
        int iSizeOf2 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i6 < i8) {
            short[] sArr2 = sArr[i6];
            char c2 = c;
            i13 = sArr2[4] == 1 ? i13 + 1 : i13;
            if (sArr2[c2] == 1) {
                i14++;
                i12 = i6;
            }
            if (sArr2[6] != 0) {
                iSizeOf2 = sizeOf(sArr2, i5);
            }
            i6++;
            c = c2;
        }
        this.smallMaxSizeIdx = i12;
        this.lookupMaxSize = iSizeOf2;
        this.nPSizes = i13;
        this.nSubpages = i14;
        this.nSizes = i8;
        this.pageSize = i;
        this.pageShifts = i2;
        this.chunkSize = i4;
        this.directMemoryCacheAlignment = i5;
        this.sizeIdx2sizeTab = newIdx2SizeTab(sArr, i8, i5);
        this.pageIdx2sizeTab = newPageIdx2sizeTab(sArr, i8, i13, i5);
        this.size2idxTab = newSize2idxTab(iSizeOf2, sArr);
    }

    private static int alignSizeIfNeeded(int i, int i2) {
        int i4;
        return (i2 > 0 && (i4 = (i2 + (-1)) & i) != 0) ? (i + i2) - i4 : i;
    }

    private static int calculateSize(int i, int i2, int i4) {
        return (1 << i) + (i2 << i4);
    }

    private static int[] newIdx2SizeTab(short[][] sArr, int i, int i2) {
        int[] iArr = new int[i];
        for (int i4 = 0; i4 < i; i4++) {
            iArr[i4] = sizeOf(sArr[i4], i2);
        }
        return iArr;
    }

    private static int[] newPageIdx2sizeTab(short[][] sArr, int i, int i2, int i4) {
        int[] iArr = new int[i2];
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            short[] sArr2 = sArr[i6];
            if (sArr2[4] == 1) {
                iArr[i5] = sizeOf(sArr2, i4);
                i5++;
            }
        }
        return iArr;
    }

    private static int[] newSize2idxTab(int i, short[][] sArr) {
        int[] iArr = new int[i >> 4];
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 <= i) {
            int i6 = 1 << (sArr[i4][2] - 4);
            while (i2 <= i) {
                int i7 = i6 - 1;
                if (i6 > 0) {
                    int i8 = i5 + 1;
                    iArr[i5] = i4;
                    int i9 = (i5 + 2) << 4;
                    i5 = i8;
                    i2 = i9;
                    i6 = i7;
                }
            }
            i4++;
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0004  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static short[] newSizeClass(int i, int i2, int i4, int i5, int i6) {
        short s;
        if (i4 >= i6) {
            s = 1;
        } else {
            int i7 = 1 << i6;
            int iCalculateSize = calculateSize(i2, i5, i4);
            if (iCalculateSize != (iCalculateSize / i7) * i7) {
                s = 0;
            }
        }
        int iLog2 = i5 == 0 ? 0 : PoolThreadCache.log2(i5);
        boolean z = (1 << iLog2) < i5;
        int i8 = iLog2 + i4 == i2 ? i2 + 1 : i2;
        if (i8 == i2) {
            z = true;
        }
        return new short[]{(short) i, (short) i2, (short) i4, (short) i5, s, i8 < i6 + 2 ? (short) 1 : (short) 0, (short) ((i8 < 12 || (i8 == 12 && !z)) ? i4 : 0)};
    }

    private static int normalizeSizeCompute(int i) {
        int iLog2 = PoolThreadCache.log2((i << 1) - 1);
        int i2 = (1 << (iLog2 < 7 ? 4 : iLog2 - 3)) - 1;
        return (i + i2) & (~i2);
    }

    private int pages2pageIdxCompute(int i, boolean z) {
        int i2 = i << this.pageShifts;
        if (i2 > this.chunkSize) {
            return this.nPSizes;
        }
        int iLog2 = PoolThreadCache.log2((i2 << 1) - 1);
        int i4 = this.pageShifts;
        int i5 = ((iLog2 < i4 + 2 ? 0 : iLog2 - (i4 + 2)) << 2) + (((i2 - 1) >> (iLog2 < i4 + 3 ? i4 : iLog2 - 3)) & 3);
        return (!z || this.pageIdx2sizeTab[i5] <= (i << i4)) ? i5 : i5 - 1;
    }

    private static int sizeOf(short[] sArr, int i) {
        return alignSizeIfNeeded(calculateSize(sArr[1], sArr[3], sArr[2]), i);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int normalizeSize(int i) {
        if (i == 0) {
            return this.sizeIdx2sizeTab[0];
        }
        int iAlignSizeIfNeeded = alignSizeIfNeeded(i, this.directMemoryCacheAlignment);
        return iAlignSizeIfNeeded <= this.lookupMaxSize ? this.sizeIdx2sizeTab[this.size2idxTab[(iAlignSizeIfNeeded - 1) >> 4]] : normalizeSizeCompute(iAlignSizeIfNeeded);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public long pageIdx2size(int i) {
        return this.pageIdx2sizeTab[i];
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public long pageIdx2sizeCompute(int i) {
        int i2 = i >> 2;
        int i4 = i & 3;
        long j = i2 == 0 ? 0L : (1 << (this.pageShifts + 1)) << i2;
        if (i2 == 0) {
            i2 = 1;
        }
        return j + ((long) ((i4 + 1) << ((i2 + this.pageShifts) - 1)));
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int pages2pageIdx(int i) {
        return pages2pageIdxCompute(i, false);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int pages2pageIdxFloor(int i) {
        return pages2pageIdxCompute(i, true);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int size2SizeIdx(int i) {
        if (i == 0) {
            return 0;
        }
        if (i > this.chunkSize) {
            return this.nSizes;
        }
        int iAlignSizeIfNeeded = alignSizeIfNeeded(i, this.directMemoryCacheAlignment);
        if (iAlignSizeIfNeeded <= this.lookupMaxSize) {
            return this.size2idxTab[(iAlignSizeIfNeeded - 1) >> 4];
        }
        int iLog2 = PoolThreadCache.log2((iAlignSizeIfNeeded << 1) - 1);
        return ((iLog2 >= 7 ? iLog2 - 6 : 0) << 2) + (((iAlignSizeIfNeeded - 1) >> (iLog2 >= 7 ? iLog2 - 3 : 4)) & 3);
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int sizeIdx2size(int i) {
        return this.sizeIdx2sizeTab[i];
    }

    @Override // io.netty.buffer.SizeClassesMetric
    public int sizeIdx2sizeCompute(int i) {
        int i2 = i >> 2;
        int i4 = i & 3;
        int i5 = i2 == 0 ? 0 : 32 << i2;
        if (i2 == 0) {
            i2 = 1;
        }
        return i5 + ((i4 + 1) << (i2 + 3));
    }
}
