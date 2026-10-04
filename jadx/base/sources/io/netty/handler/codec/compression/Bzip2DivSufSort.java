package io.netty.handler.codec.compression;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.sun.imageio.plugins.jpeg.JPEG;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2DivSufSort {
    private static final int BUCKET_A_SIZE = 256;
    private static final int BUCKET_B_SIZE = 65536;
    private static final int INSERTIONSORT_THRESHOLD = 8;
    private static final int[] LOG_2_TABLE = {-1, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int SS_BLOCKSIZE = 1024;
    private static final int STACK_SIZE = 64;

    /* JADX INFO: renamed from: SA */
    private final int[] f8875SA;

    /* JADX INFO: renamed from: T */
    private final byte[] f8876T;

    /* JADX INFO: renamed from: n */
    private final int f8877n;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PartitionResult {
        final int first;
        final int last;

        public PartitionResult(int i, int i2) {
            this.first = i;
            this.last = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StackEntry {

        /* JADX INFO: renamed from: a */
        final int f8878a;

        /* JADX INFO: renamed from: b */
        final int f8879b;

        /* JADX INFO: renamed from: c */
        final int f8880c;

        /* JADX INFO: renamed from: d */
        final int f8881d;

        public StackEntry(int i, int i2, int i4, int i5) {
            this.f8878a = i;
            this.f8879b = i2;
            this.f8880c = i4;
            this.f8881d = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TRBudget {
        int budget;
        int chance;

        public TRBudget(int i, int i2) {
            this.budget = i;
            this.chance = i2;
        }

        public boolean update(int i, int i2) {
            int i4 = this.budget - i2;
            this.budget = i4;
            if (i4 <= 0) {
                int i5 = this.chance - 1;
                this.chance = i5;
                if (i5 == 0) {
                    return false;
                }
                this.budget = i4 + i;
            }
            return true;
        }
    }

    public Bzip2DivSufSort(byte[] bArr, int[] iArr, int i) {
        this.f8876T = bArr;
        this.f8875SA = iArr;
        this.f8877n = i;
    }

    private static int BUCKET_B(int i, int i2) {
        return i | (i2 << 8);
    }

    private static int BUCKET_BSTAR(int i, int i2) {
        return (i << 8) | i2;
    }

    private int constructBWT(int[] iArr, int[] iArr2) {
        byte[] bArr = this.f8876T;
        int[] iArr3 = this.f8875SA;
        int i = this.f8877n;
        int i2 = JPEG.COM;
        int i4 = 0;
        int i5 = 0;
        while (i2 >= 0) {
            int i6 = i2 + 1;
            int i7 = iArr2[BUCKET_BSTAR(i2, i6)];
            int i8 = -1;
            int i9 = 0;
            for (int i10 = iArr[i6]; i7 <= i10; i10--) {
                int i11 = iArr3[i10];
                if (i11 >= 0) {
                    int i12 = i11 - 1;
                    if (i12 < 0) {
                        i12 = i - 1;
                    }
                    int i13 = bArr[i12] & 255;
                    if (i13 <= i2) {
                        iArr3[i10] = ~i11;
                        if (i12 > 0 && (bArr[i12 - 1] & 255) > i13) {
                            i12 = ~i12;
                        }
                        if (i8 == i13) {
                            i9--;
                            iArr3[i9] = i12;
                        } else {
                            if (i8 >= 0) {
                                iArr2[BUCKET_B(i8, i2)] = i9;
                            }
                            i9 = iArr2[BUCKET_B(i13, i2)] - 1;
                            iArr3[i9] = i12;
                            i8 = i13;
                        }
                    }
                } else {
                    iArr3[i10] = ~i11;
                }
            }
            i2--;
            i4 = i9;
            i5 = i8;
        }
        int i14 = -1;
        for (int i15 = 0; i15 < i; i15++) {
            int i16 = iArr3[i15];
            if (i16 >= 0) {
                int i17 = i16 - 1;
                if (i17 < 0) {
                    i17 = i - 1;
                }
                int i18 = bArr[i17] & 255;
                if (i18 >= (bArr[i17 + 1] & 255)) {
                    if (i17 > 0 && (bArr[i17 - 1] & 255) < i18) {
                        i17 = ~i17;
                    }
                    if (i18 == i5) {
                        i4++;
                        iArr3[i4] = i17;
                    } else {
                        if (i5 != -1) {
                            iArr[i5] = i4;
                        }
                        i4 = iArr[i18] + 1;
                        iArr3[i4] = i17;
                        i5 = i18;
                    }
                }
            } else {
                i16 = ~i16;
            }
            if (i16 == 0) {
                iArr3[i15] = bArr[i - 1];
                i14 = i15;
            } else {
                iArr3[i15] = bArr[i16 - 1];
            }
        }
        return i14;
    }

    private static int getIDX(int i) {
        return i >= 0 ? i : ~i;
    }

    private void lsIntroSort(int i, int i2, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int iTrGetC;
        int i10;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int[] iArr = bzip2DivSufSort.f8875SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int iTrLog = trLog(i6 - i5);
        int i11 = i5;
        int i12 = i6;
        int i13 = 0;
        int iTrGetC2 = 0;
        while (true) {
            int i14 = i12 - i11;
            int i15 = 1;
            if (i14 <= 8) {
                if (1 < i14) {
                    bzip2DivSufSort.trInsertionSort(i, i2, i4, i11, i12);
                    bzip2DivSufSort.lsUpdateGroup(i, i11, i12);
                } else if (i14 == 1) {
                    iArr[i11] = -1;
                }
                if (i13 == 0) {
                    return;
                }
                i13--;
                StackEntry stackEntry = stackEntryArr[i13];
                i11 = stackEntry.f8878a;
                i12 = stackEntry.f8879b;
                iTrLog = stackEntry.f8880c;
            } else {
                int i16 = i12;
                int i17 = iTrLog - 1;
                if (iTrLog == 0) {
                    bzip2DivSufSort.trHeapSort(i, i2, i4, i11, i14);
                    int i18 = i16 - 1;
                    while (i11 < i18) {
                        iTrGetC2 = bzip2DivSufSort.trGetC(i, i2, i4, iArr[i18]);
                        i18--;
                        while (i11 <= i18 && bzip2DivSufSort.trGetC(i, i2, i4, iArr[i18]) == iTrGetC2) {
                            iArr[i18] = ~iArr[i18];
                            i18--;
                        }
                    }
                    bzip2DivSufSort.lsUpdateGroup(i, i11, i16);
                    if (i13 == 0) {
                        return;
                    }
                    i13--;
                    StackEntry stackEntry2 = stackEntryArr[i13];
                    int i19 = stackEntry2.f8878a;
                    int i20 = stackEntry2.f8879b;
                    iTrLog = stackEntry2.f8880c;
                    i11 = i19;
                    i12 = i20;
                } else {
                    i12 = i16;
                    swapElements(iArr, i11, iArr, bzip2DivSufSort.trPivot(i, i2, i4, i11, i12));
                    int iTrGetC3 = bzip2DivSufSort.trGetC(i, i2, i4, iArr[i11]);
                    int i21 = i11 + 1;
                    while (i21 < i12) {
                        iTrGetC2 = bzip2DivSufSort.trGetC(i, i2, i4, iArr[i21]);
                        if (iTrGetC2 != iTrGetC3) {
                            break;
                        } else {
                            i21++;
                        }
                    }
                    if (i21 >= i12 || iTrGetC2 >= iTrGetC3) {
                        i7 = -1;
                        i8 = i21;
                    } else {
                        i7 = -1;
                        i8 = i21;
                        while (true) {
                            i21++;
                            if (i21 >= i12 || (iTrGetC2 = bzip2DivSufSort.trGetC(i, i2, i4, iArr[i21])) > iTrGetC3) {
                                break;
                            } else if (iTrGetC2 == iTrGetC3) {
                                swapElements(iArr, i21, iArr, i8);
                                i8++;
                            }
                        }
                    }
                    int i22 = i12 - 1;
                    while (i21 < i22) {
                        iTrGetC2 = bzip2DivSufSort.trGetC(i, i2, i4, iArr[i22]);
                        if (iTrGetC2 != iTrGetC3) {
                            break;
                        } else {
                            i22--;
                        }
                    }
                    if (i21 < i22 && iTrGetC2 > iTrGetC3) {
                        int i23 = iTrGetC2;
                        i10 = i22;
                        while (true) {
                            i22--;
                            i9 = i15;
                            if (i21 >= i22) {
                                iTrGetC = i23;
                                break;
                            }
                            iTrGetC = bzip2DivSufSort.trGetC(i, i2, i4, iArr[i22]);
                            if (iTrGetC < iTrGetC3) {
                                break;
                            }
                            if (iTrGetC == iTrGetC3) {
                                swapElements(iArr, i22, iArr, i10);
                                i10--;
                            }
                            i23 = iTrGetC;
                            i15 = i9;
                        }
                    } else {
                        i9 = 1;
                        iTrGetC = iTrGetC2;
                        i10 = i22;
                    }
                    while (i21 < i22) {
                        swapElements(iArr, i21, iArr, i22);
                        while (true) {
                            i21++;
                            if (i21 >= i22 || (iTrGetC = bzip2DivSufSort.trGetC(i, i2, i4, iArr[i21])) > iTrGetC3) {
                                break;
                            } else if (iTrGetC == iTrGetC3) {
                                swapElements(iArr, i21, iArr, i8);
                                i8++;
                            }
                        }
                        while (true) {
                            i22--;
                            if (i21 >= i22 || (iTrGetC = bzip2DivSufSort.trGetC(i, i2, i4, iArr[i22])) < iTrGetC3) {
                                break;
                            } else if (iTrGetC == iTrGetC3) {
                                swapElements(iArr, i22, iArr, i10);
                                i10--;
                            }
                        }
                    }
                    if (i8 <= i10) {
                        int i24 = i21 - 1;
                        int i25 = i8 - i11;
                        int i26 = i21 - i8;
                        if (i25 > i26) {
                            i25 = i26;
                        }
                        int i27 = i21 - i25;
                        int i28 = i25;
                        int i29 = i11;
                        while (i28 > 0) {
                            swapElements(iArr, i29, iArr, i27);
                            i28--;
                            i29++;
                            i27++;
                        }
                        int i30 = i10 - i24;
                        int i31 = (i12 - i10) - 1;
                        if (i30 <= i31) {
                            i31 = i30;
                        }
                        int i32 = i12 - i31;
                        while (i31 > 0) {
                            swapElements(iArr, i21, iArr, i32);
                            i31--;
                            i21++;
                            i32++;
                        }
                        int i33 = i11 + i26;
                        int i34 = i12 - i30;
                        int i35 = i33 - 1;
                        for (int i36 = i11; i36 < i33; i36++) {
                            iArr[iArr[i36] + i] = i35;
                        }
                        if (i34 < i12) {
                            int i37 = i34 - 1;
                            for (int i38 = i33; i38 < i34; i38++) {
                                iArr[iArr[i38] + i] = i37;
                            }
                        }
                        if (i34 - i33 == i9) {
                            iArr[i33] = i7;
                        }
                        if (i33 - i11 <= i12 - i34) {
                            if (i11 < i33) {
                                stackEntryArr[i13] = new StackEntry(i34, i12, i17, 0);
                                bzip2DivSufSort = this;
                                i12 = i33;
                                i13++;
                                iTrGetC2 = iTrGetC;
                                iTrLog = i17;
                            } else {
                                i11 = i34;
                                iTrGetC2 = iTrGetC;
                                iTrLog = i17;
                            }
                        } else if (i34 < i12) {
                            stackEntryArr[i13] = new StackEntry(i11, i33, i17, 0);
                            i11 = i34;
                            i13++;
                            iTrGetC2 = iTrGetC;
                            iTrLog = i17;
                        } else {
                            bzip2DivSufSort = this;
                            i12 = i33;
                            iTrGetC2 = iTrGetC;
                            iTrLog = i17;
                        }
                    } else {
                        if (i13 == 0) {
                            return;
                        }
                        i13--;
                        StackEntry stackEntry3 = stackEntryArr[i13];
                        i11 = stackEntry3.f8878a;
                        i12 = stackEntry3.f8879b;
                        iTrLog = stackEntry3.f8880c;
                        iTrGetC2 = iTrGetC;
                    }
                    bzip2DivSufSort = this;
                }
            }
        }
    }

    private void lsSort(int i, int i2, int i4) {
        int i5;
        int[] iArr = this.f8875SA;
        int i6 = i4 + i;
        while (true) {
            int i7 = 0;
            if ((-i2) >= iArr[0]) {
                return;
            }
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = iArr[i9];
                if (i10 < 0) {
                    i9 -= i10;
                    i8 += i10;
                    i5 = i;
                } else {
                    if (i8 != 0) {
                        iArr[i9 + i8] = i8;
                        i8 = 0;
                    }
                    int i11 = iArr[i10 + i] + 1;
                    i5 = i;
                    lsIntroSort(i5, i6, i + i2, i9, i11);
                    i9 = i11;
                }
                if (i9 >= i2) {
                    break;
                } else {
                    i = i5;
                }
            }
            if (i8 != 0) {
                iArr[i9 + i8] = i8;
            }
            int i12 = i6 - i5;
            if (i2 < i12) {
                do {
                    int i13 = iArr[i7];
                    if (i13 < 0) {
                        i7 -= i13;
                    } else {
                        int i14 = iArr[i13 + i5] + 1;
                        while (i7 < i14) {
                            iArr[iArr[i7] + i5] = i7;
                            i7++;
                        }
                        i7 = i14;
                    }
                } while (i7 < i2);
                return;
            }
            i6 += i12;
            i = i5;
        }
    }

    private void lsUpdateGroup(int i, int i2, int i4) {
        int i5;
        int[] iArr = this.f8875SA;
        while (i2 < i4) {
            if (iArr[i2] >= 0) {
                int i6 = i2;
                do {
                    iArr[iArr[i6] + i] = i6;
                    i6++;
                    if (i6 >= i4) {
                        break;
                    }
                } while (iArr[i6] >= 0);
                iArr[i2] = i2 - i6;
                if (i4 <= i6) {
                    return;
                } else {
                    i2 = i6;
                }
            }
            int i7 = i2;
            while (true) {
                iArr[i7] = ~iArr[i7];
                i5 = i7 + 1;
                if (iArr[i5] >= 0) {
                    break;
                } else {
                    i7 = i5;
                }
            }
            do {
                iArr[iArr[i2] + i] = i5;
                i2++;
            } while (i2 <= i5);
            i2 = i7 + 2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int sortTypeBstar(int[] iArr, int[] iArr2) {
        boolean z;
        int i;
        Object[] objArr;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int[] iArr3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z2;
        int i17;
        byte[] bArr = this.f8876T;
        int[] iArr4 = this.f8875SA;
        int i18 = this.f8877n;
        int[] iArr5 = new int[256];
        int i19 = 1;
        while (true) {
            z = false;
            i = 255;
            if (i19 >= i18) {
                break;
            }
            int i20 = bArr[i19 - 1];
            int i21 = bArr[i19];
            if (i20 == i21) {
                i19++;
            } else if ((i20 & 255) > (i21 & 255)) {
                objArr = false;
            }
        }
        objArr = true;
        int i22 = i18 - 1;
        byte b = bArr[i22];
        int i23 = b & 255;
        byte b5 = bArr[0];
        int i24 = b5 & 255;
        if (i23 < i24 || (b == b5 && objArr == true)) {
            if (objArr == true) {
                int iBUCKET_B = BUCKET_B(i23, i24);
                iArr2[iBUCKET_B] = iArr2[iBUCKET_B] + 1;
                i2 = i18;
            } else {
                int iBUCKET_BSTAR = BUCKET_BSTAR(i23, i24);
                iArr2[iBUCKET_BSTAR] = iArr2[iBUCKET_BSTAR] + 1;
                i2 = i18 - 1;
                iArr4[i2] = i22;
            }
            i4 = i18 - 2;
            while (i4 >= 0) {
                int i25 = bArr[i4] & 255;
                int i26 = bArr[i4 + 1] & 255;
                if (i25 <= i26) {
                    int iBUCKET_B2 = BUCKET_B(i25, i26);
                    iArr2[iBUCKET_B2] = iArr2[iBUCKET_B2] + 1;
                    i4--;
                }
            }
        } else {
            i2 = i18;
            i4 = i22;
        }
        while (i4 >= 0) {
            while (true) {
                int i27 = bArr[i4] & 255;
                iArr[i27] = iArr[i27] + 1;
                i17 = i4 - 1;
                if (i17 < 0 || (bArr[i17] & 255) < (bArr[i4] & 255)) {
                    break;
                }
                i4 = i17;
            }
            if (i17 >= 0) {
                int iBUCKET_BSTAR2 = BUCKET_BSTAR(bArr[i17] & 255, bArr[i4] & 255);
                iArr2[iBUCKET_BSTAR2] = iArr2[iBUCKET_BSTAR2] + 1;
                i2--;
                iArr4[i2] = i17;
                i4 -= 2;
                while (i4 >= 0) {
                    int i28 = bArr[i4] & 255;
                    int i29 = bArr[i4 + 1] & 255;
                    if (i28 <= i29) {
                        int iBUCKET_B3 = BUCKET_B(i28, i29);
                        iArr2[iBUCKET_B3] = iArr2[iBUCKET_B3] + 1;
                        i4--;
                    }
                }
            } else {
                i4 = i17;
            }
        }
        int i30 = i18 - i2;
        if (i30 == 0) {
            for (int i31 = 0; i31 < i18; i31++) {
                iArr4[i31] = i31;
            }
            return 0;
        }
        int i32 = -1;
        int i33 = 0;
        int i34 = 0;
        while (i33 < 256) {
            int i35 = iArr[i33] + i32;
            iArr[i33] = i32 + i34;
            int i36 = i35 + iArr2[BUCKET_B(i33, i33)];
            int i37 = i33 + 1;
            for (int i38 = i37; i38 < 256; i38++) {
                i34 += iArr2[BUCKET_BSTAR(i33, i38)];
                iArr2[(i33 << 8) | i38] = i34;
                i36 += iArr2[BUCKET_B(i33, i38)];
            }
            i33 = i37;
            i32 = i36;
        }
        int i39 = i18 - i30;
        for (int i40 = i30 - 2; i40 >= 0; i40--) {
            int i41 = iArr4[i39 + i40];
            int iBUCKET_BSTAR3 = BUCKET_BSTAR(bArr[i41] & 255, bArr[i41 + 1] & 255);
            int i42 = iArr2[iBUCKET_BSTAR3] - 1;
            iArr2[iBUCKET_BSTAR3] = i42;
            iArr4[i42] = i40;
        }
        int i43 = iArr4[(i39 + i30) - 1];
        int iBUCKET_BSTAR4 = BUCKET_BSTAR(bArr[i43] & 255, bArr[i43 + 1] & 255);
        int i44 = iArr2[iBUCKET_BSTAR4] - 1;
        iArr2[iBUCKET_BSTAR4] = i44;
        int i45 = i30 - 1;
        iArr4[i44] = i45;
        int i46 = i18 - (i30 * 2);
        if (i46 <= 256) {
            i46 = 256;
            i5 = 0;
        } else {
            i5 = i30;
            iArr5 = iArr4;
        }
        int i47 = i30;
        int i48 = 255;
        while (i47 > 0) {
            boolean z3 = z;
            int i49 = i;
            while (i48 < i49) {
                int i50 = iArr2[BUCKET_BSTAR(i48, i49)];
                if (1 < i47 - i50) {
                    if (iArr4[i50] == i45) {
                        i16 = i48;
                        z2 = true;
                    } else {
                        i16 = i48;
                        z2 = z3;
                    }
                    int i51 = i45;
                    i10 = i5;
                    i11 = i39;
                    iArr3 = iArr5;
                    i12 = i50;
                    i13 = i51;
                    i15 = i16;
                    i14 = i30;
                    subStringSort(i11, i12, i47, iArr3, i10, i46, 2, z2, i18);
                } else {
                    int i52 = i45;
                    i10 = i5;
                    i11 = i39;
                    iArr3 = iArr5;
                    i12 = i50;
                    i13 = i52;
                    i14 = i30;
                    i15 = i48;
                }
                i49--;
                i47 = i12;
                iArr5 = iArr3;
                i30 = i14;
                i48 = i15;
                i39 = i11;
                i5 = i10;
                i45 = i13;
            }
            i48--;
            i30 = i30;
            z = z3;
            i = 255;
            i39 = i39;
            i5 = i5;
            i45 = i45;
        }
        int i53 = i30;
        int i54 = i45;
        boolean z4 = z;
        while (i45 >= 0) {
            if (iArr4[i45] >= 0) {
                int i55 = i45;
                while (true) {
                    iArr4[i53 + iArr4[i55]] = i55;
                    i9 = i55 - 1;
                    if (i9 < 0 || iArr4[i9] < 0) {
                        break;
                    }
                    i55 = i9;
                }
                iArr4[i55] = i9 - i45;
                if (i9 <= 0) {
                    break;
                }
                i45 = i9;
            }
            int i56 = i45;
            while (true) {
                int i57 = ~iArr4[i56];
                iArr4[i56] = i57;
                iArr4[i53 + i57] = i45;
                int i58 = i56 - 1;
                i8 = iArr4[i58];
                if (i8 >= 0) {
                    break;
                }
                i56 = i58;
            }
            iArr4[i8 + i53] = i45;
            i45 = i56 - 2;
        }
        trSort(i53, i53, 1);
        int i59 = bArr[i22];
        int i60 = i59 & 255;
        int i61 = bArr[z4 ? 1 : 0];
        if (i60 < (i61 & 255) || (i59 == i61 && objArr == true)) {
            if (objArr == true) {
                i6 = i53;
            } else {
                i6 = i53 - 1;
                iArr4[iArr4[i53 + i6]] = i22;
            }
            i7 = i18 - 2;
            while (i7 >= 0 && (bArr[i7] & 255) <= (bArr[i7 + 1] & 255)) {
                i7--;
            }
        } else {
            i6 = i53;
            i7 = i22;
        }
        while (i7 >= 0) {
            do {
                i7--;
                if (i7 < 0) {
                    break;
                }
            } while ((bArr[i7] & 255) >= (bArr[i7 + 1] & 255));
            if (i7 >= 0) {
                i6--;
                iArr4[iArr4[i53 + i6]] = i7;
                do {
                    i7--;
                    if (i7 >= 0) {
                    }
                } while ((bArr[i7] & 255) <= (bArr[i7 + 1] & 255));
            }
        }
        int i62 = i54;
        for (int i63 = 255; i63 >= 0; i63--) {
            for (int i64 = 255; i63 < i64; i64--) {
                int i65 = i22 - iArr2[BUCKET_B(i63, i64)];
                iArr2[BUCKET_B(i63, i64)] = i22 + 1;
                int i66 = iArr2[BUCKET_BSTAR(i63, i64)];
                i22 = i65;
                while (i66 <= i62) {
                    iArr4[i22] = iArr4[i62];
                    i22--;
                    i62--;
                }
            }
            int i67 = i22 - iArr2[BUCKET_B(i63, i63)];
            iArr2[BUCKET_B(i63, i63)] = i22 + 1;
            if (i63 < 255) {
                iArr2[BUCKET_BSTAR(i63, i63 + 1)] = i67 + 1;
            }
            i22 = iArr[i63];
        }
        return i53;
    }

    private static void ssBlockSwap(int[] iArr, int i, int[] iArr2, int i2, int i4) {
        while (i4 > 0) {
            swapElements(iArr, i, iArr2, i2);
            i4--;
            i++;
            i2++;
        }
    }

    private int ssCompare(int i, int i2, int i4) {
        int[] iArr = this.f8875SA;
        byte[] bArr = this.f8876T;
        int i5 = iArr[i + 1] + 2;
        int i6 = iArr[i2 + 1] + 2;
        int i7 = iArr[i] + i4;
        int i8 = i4 + iArr[i2];
        while (i7 < i5 && i8 < i6 && bArr[i7] == bArr[i8]) {
            i7++;
            i8++;
        }
        if (i7 >= i5) {
            return i8 < i6 ? -1 : 0;
        }
        if (i8 < i6) {
            return (bArr[i7] & 255) - (bArr[i8] & 255);
        }
        return 1;
    }

    private int ssCompareLast(int i, int i2, int i4, int i5, int i6) {
        int i7;
        byte b;
        int[] iArr = this.f8875SA;
        byte[] bArr = this.f8876T;
        int i8 = iArr[i2] + i5;
        int i9 = i5 + iArr[i4];
        int i10 = iArr[i4 + 1] + 2;
        while (i8 < i6 && i9 < i10 && bArr[i8] == bArr[i9]) {
            i8++;
            i9++;
        }
        if (i8 < i6) {
            if (i9 >= i10) {
                return 1;
            }
            i7 = bArr[i8] & 255;
            b = bArr[i9];
        } else {
            if (i9 == i10) {
                return 1;
            }
            int i11 = i8 % i6;
            int i12 = iArr[i] + 2;
            while (i11 < i12 && i9 < i10 && bArr[i11] == bArr[i9]) {
                i11++;
                i9++;
            }
            if (i11 >= i12) {
                return i9 < i10 ? -1 : 0;
            }
            if (i9 >= i10) {
                return 1;
            }
            i7 = bArr[i11] & 255;
            b = bArr[i9];
        }
        return i7 - (b & 255);
    }

    private void ssFixdown(int i, int i2, int i4, int i5, int i6) {
        int[] iArr = this.f8875SA;
        byte[] bArr = this.f8876T;
        int i7 = iArr[i4 + i5];
        int i8 = bArr[iArr[i2 + i7] + i] & 255;
        while (true) {
            int i9 = i5 * 2;
            int i10 = i9 + 1;
            if (i10 >= i6) {
                break;
            }
            int i11 = i9 + 2;
            int i12 = bArr[iArr[iArr[i4 + i10] + i2] + i] & 255;
            int i13 = bArr[iArr[iArr[i4 + i11] + i2] + i] & 255;
            if (i12 < i13) {
                i12 = i13;
            } else {
                i11 = i10;
            }
            if (i12 <= i8) {
                break;
            }
            iArr[i5 + i4] = iArr[i4 + i11];
            i5 = i11;
        }
        iArr[i4 + i5] = i7;
    }

    private void ssHeapSort(int i, int i2, int i4, int i5) {
        int i6;
        int[] iArr = this.f8875SA;
        byte[] bArr = this.f8876T;
        int i7 = i5 % 2;
        if (i7 == 0) {
            int i8 = i5 - 1;
            int i9 = (i8 / 2) + i4;
            int i10 = i4 + i8;
            if ((bArr[iArr[iArr[i9] + i2] + i] & 255) < (bArr[iArr[iArr[i10] + i2] + i] & 255)) {
                swapElements(iArr, i10, iArr, i9);
            }
            i6 = i8;
        } else {
            i6 = i5;
        }
        for (int i11 = (i6 / 2) - 1; i11 >= 0; i11--) {
            ssFixdown(i, i2, i4, i11, i6);
        }
        if (i7 == 0) {
            swapElements(iArr, i4, iArr, i4 + i6);
            ssFixdown(i, i2, i4, 0, i6);
        }
        for (int i12 = i6 - 1; i12 > 0; i12--) {
            int i13 = iArr[i4];
            int i14 = i4 + i12;
            iArr[i4] = iArr[i14];
            ssFixdown(i, i2, i4, 0, i12);
            iArr[i14] = i13;
        }
    }

    private void ssInsertionSort(int i, int i2, int i4, int i5) {
        int iSsCompare;
        int[] iArr = this.f8875SA;
        for (int i6 = i4 - 2; i2 <= i6; i6--) {
            int i7 = iArr[i6];
            int i8 = i6 + 1;
            do {
                iSsCompare = ssCompare(i + i7, iArr[i8] + i, i5);
                if (iSsCompare <= 0) {
                    break;
                }
                do {
                    iArr[i8 - 1] = iArr[i8];
                    i8++;
                    if (i8 >= i4) {
                        break;
                    }
                } while (iArr[i8] < 0);
            } while (i4 > i8);
            if (iSsCompare == 0) {
                iArr[i8] = ~iArr[i8];
            }
            iArr[i8 - 1] = i7;
        }
    }

    private static int ssLog(int i) {
        return (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int ssMedian3(int i, int i2, int i4, int i5, int i6) {
        int[] iArr = this.f8875SA;
        byte[] bArr = this.f8876T;
        int i7 = bArr[iArr[iArr[i4] + i2] + i] & 255;
        int i8 = bArr[iArr[iArr[i5] + i2] + i] & 255;
        int i9 = bArr[i + iArr[i2 + iArr[i6]]] & 255;
        if (i7 <= i8) {
            i5 = i4;
            i4 = i5;
            i8 = i7;
            i7 = i8;
        }
        return i7 > i9 ? i8 > i9 ? i5 : i6 : i4;
    }

    private int ssMedian5(int i, int i2, int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.f8875SA;
        byte[] bArr = this.f8876T;
        int i9 = bArr[iArr[iArr[i4] + i2] + i] & 255;
        int i10 = bArr[iArr[iArr[i5] + i2] + i] & 255;
        int i11 = bArr[iArr[iArr[i6] + i2] + i] & 255;
        int i12 = bArr[iArr[iArr[i7] + i2] + i] & 255;
        int i13 = bArr[i + iArr[i2 + iArr[i8]]] & 255;
        if (i10 > i11) {
            i6 = i5;
            i5 = i6;
            i11 = i10;
            i10 = i11;
        }
        if (i12 > i13) {
            i12 = i13;
            i13 = i12;
        } else {
            i8 = i7;
            i7 = i8;
        }
        if (i10 > i12) {
            int i14 = i11;
            i11 = i13;
            i13 = i14;
            int i15 = i7;
            i7 = i6;
            i6 = i15;
        } else {
            i5 = i8;
            i10 = i12;
        }
        if (i9 > i11) {
            int i16 = i6;
            i6 = i4;
            i4 = i16;
            int i17 = i11;
            i11 = i9;
            i9 = i17;
        }
        if (i9 > i10) {
            i5 = i4;
            i10 = i9;
        } else {
            i7 = i6;
            i13 = i11;
        }
        return i13 > i10 ? i5 : i7;
    }

    private void ssMerge(int i, int i2, int i4, int i5, int[] iArr, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = i7;
        int[] iArr2 = this.f8875SA;
        StackEntry[] stackEntryArr = new StackEntry[64];
        int i15 = i2;
        int i16 = i4;
        int i17 = i5;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i20 = i17 - i16;
            if (i20 <= i14) {
                if (i15 >= i16 || i16 >= i17) {
                    i9 = i;
                    i10 = i8;
                } else {
                    i10 = i8;
                    ssMergeBackward(i, iArr, i6, i15, i16, i17, i10);
                    i9 = i;
                }
                if ((i18 & 1) != 0) {
                    ssMergeCheckEqual(i9, i10, i15);
                }
                if ((i18 & 2) != 0) {
                    ssMergeCheckEqual(i9, i10, i17);
                }
                if (i19 == 0) {
                    return;
                }
                i19--;
                StackEntry stackEntry = stackEntryArr[i19];
                i15 = stackEntry.f8878a;
                i16 = stackEntry.f8879b;
                i17 = stackEntry.f8880c;
                i18 = stackEntry.f8881d;
            } else {
                int i21 = i;
                int i22 = i16 - i15;
                if (i22 <= i14) {
                    if (i15 < i16) {
                        ssMergeForward(i21, iArr, i6, i15, i16, i17, i8);
                        i21 = i21;
                    }
                    if ((i18 & 1) != 0) {
                        ssMergeCheckEqual(i21, i8, i15);
                    }
                    if ((i18 & 2) != 0) {
                        ssMergeCheckEqual(i21, i8, i17);
                    }
                    if (i19 == 0) {
                        return;
                    }
                    i19--;
                    StackEntry stackEntry2 = stackEntryArr[i19];
                    i15 = stackEntry2.f8878a;
                    i16 = stackEntry2.f8879b;
                    i17 = stackEntry2.f8880c;
                    i18 = stackEntry2.f8881d;
                } else {
                    int iMin = Math.min(i22, i20);
                    int i23 = iMin >> 1;
                    int i24 = 0;
                    while (iMin > 0) {
                        if (ssCompare(i21 + getIDX(iArr2[i16 + i24 + i23]), i21 + getIDX(iArr2[((i16 - i24) - i23) - 1]), i8) < 0) {
                            i24 += i23 + 1;
                            i23 -= (iMin & 1) ^ 1;
                        }
                        iMin = i23;
                        i23 = iMin >> 1;
                    }
                    if (i24 > 0) {
                        int i25 = i16 - i24;
                        ssBlockSwap(iArr2, i25, iArr2, i16, i24);
                        int i26 = i16 + i24;
                        if (i26 < i17) {
                            if (iArr2[i26] < 0) {
                                i11 = i16;
                                while (iArr2[i11 - 1] < 0) {
                                    i11--;
                                }
                                iArr2[i26] = ~iArr2[i26];
                            } else {
                                i11 = i16;
                            }
                            i12 = i16;
                            while (iArr2[i12] < 0) {
                                i12++;
                            }
                            i13 = 1;
                        } else {
                            i11 = i16;
                            i12 = i11;
                            i13 = 0;
                        }
                        int[] iArr3 = iArr2;
                        if (i11 - i15 <= i17 - i12) {
                            stackEntryArr[i19] = new StackEntry(i12, i26, i17, (i18 & 2) | i13);
                            i18 &= 1;
                            i14 = i7;
                            i19++;
                            i17 = i11;
                            iArr2 = iArr3;
                            i16 = i25;
                        } else {
                            if (i11 == i16 && i16 == i12) {
                                i13 <<= 1;
                            }
                            stackEntryArr[i19] = new StackEntry(i15, i25, i11, (i18 & 1) | (i13 & 2));
                            i18 = (i18 & 2) | (i13 & 1);
                            i14 = i7;
                            i19++;
                            i15 = i12;
                            iArr2 = iArr3;
                            i16 = i26;
                        }
                    } else {
                        int[] iArr4 = iArr2;
                        if ((i18 & 1) != 0) {
                            ssMergeCheckEqual(i21, i8, i15);
                        }
                        ssMergeCheckEqual(i21, i8, i16);
                        if ((i18 & 2) != 0) {
                            ssMergeCheckEqual(i21, i8, i17);
                        }
                        if (i19 == 0) {
                            return;
                        }
                        i19--;
                        StackEntry stackEntry3 = stackEntryArr[i19];
                        i15 = stackEntry3.f8878a;
                        i16 = stackEntry3.f8879b;
                        i17 = stackEntry3.f8880c;
                        i18 = stackEntry3.f8881d;
                        i14 = i7;
                        iArr2 = iArr4;
                    }
                }
            }
        }
    }

    private void ssMergeBackward(int i, int[] iArr, int i2, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr2 = this.f8875SA;
        int i19 = i6 - i5;
        ssBlockSwap(iArr, i2, iArr2, i5, i19);
        int i20 = (i2 + i19) - 1;
        int i21 = iArr[i20];
        if (i21 < 0) {
            i8 = (~i21) + i;
            i9 = 1;
        } else {
            i8 = i21 + i;
            i9 = 0;
        }
        int i22 = i5 - 1;
        int i23 = iArr2[i22];
        if (i23 < 0) {
            i9 |= 2;
            i23 = ~i23;
        }
        int i24 = i23 + i;
        int i25 = i6 - 1;
        int i26 = iArr2[i25];
        while (true) {
            int iSsCompare = ssCompare(i8, i24, i7);
            if (iSsCompare > 0) {
                if ((i9 & 1) != 0) {
                    while (true) {
                        i10 = i25 - 1;
                        iArr2[i25] = iArr[i20];
                        i11 = i20 - 1;
                        iArr[i20] = iArr2[i10];
                        if (iArr[i11] >= 0) {
                            break;
                        }
                        i20 = i11;
                        i25 = i10;
                    }
                    i9 ^= 1;
                    i20 = i11;
                    i25 = i10;
                }
                int i27 = i25 - 1;
                iArr2[i25] = iArr[i20];
                if (i20 <= i2) {
                    iArr[i20] = i26;
                    return;
                }
                int i28 = i20 - 1;
                iArr[i20] = iArr2[i27];
                int i29 = iArr[i28];
                if (i29 < 0) {
                    i9 |= 1;
                    i29 = ~i29;
                }
                int i30 = i29 + i;
                i20 = i28;
                i25 = i27;
                i8 = i30;
            } else {
                if (iSsCompare < 0) {
                    if ((i9 & 2) != 0) {
                        while (true) {
                            i17 = i25 - 1;
                            iArr2[i25] = iArr2[i22];
                            i18 = i22 - 1;
                            iArr2[i22] = iArr2[i17];
                            if (iArr2[i18] >= 0) {
                                break;
                            }
                            i22 = i18;
                            i25 = i17;
                        }
                        i9 ^= 2;
                        i22 = i18;
                        i25 = i17;
                    }
                    int i31 = i25 - 1;
                    iArr2[i25] = iArr2[i22];
                    int i32 = i22 - 1;
                    iArr2[i22] = iArr2[i31];
                    if (i32 < i4) {
                        while (i2 < i20) {
                            int i33 = i31 - 1;
                            iArr2[i31] = iArr[i20];
                            iArr[i20] = iArr2[i33];
                            i31 = i33;
                            i20--;
                        }
                        iArr2[i31] = iArr[i20];
                        iArr[i20] = i26;
                        return;
                    }
                    int i34 = iArr2[i32];
                    if (i34 < 0) {
                        i9 |= 2;
                        i34 = ~i34;
                    }
                    i12 = i31;
                    i24 = i34 + i;
                    i22 = i32;
                } else {
                    if ((i9 & 1) != 0) {
                        while (true) {
                            i15 = i25 - 1;
                            iArr2[i25] = iArr[i20];
                            i16 = i20 - 1;
                            iArr[i20] = iArr2[i15];
                            if (iArr[i16] >= 0) {
                                break;
                            }
                            i20 = i16;
                            i25 = i15;
                        }
                        i9 ^= 1;
                        i20 = i16;
                        i25 = i15;
                    }
                    int i35 = i25 - 1;
                    iArr2[i25] = ~iArr[i20];
                    if (i20 <= i2) {
                        iArr[i20] = i26;
                        return;
                    }
                    int i36 = i20 - 1;
                    iArr[i20] = iArr2[i35];
                    if ((i9 & 2) != 0) {
                        while (true) {
                            i13 = i35 - 1;
                            iArr2[i35] = iArr2[i22];
                            i14 = i22 - 1;
                            iArr2[i22] = iArr2[i13];
                            if (iArr2[i14] >= 0) {
                                break;
                            }
                            i22 = i14;
                            i35 = i13;
                        }
                        i9 ^= 2;
                        i22 = i14;
                        i35 = i13;
                    }
                    int i37 = i35 - 1;
                    iArr2[i35] = iArr2[i22];
                    int i38 = i22 - 1;
                    iArr2[i22] = iArr2[i37];
                    if (i38 < i4) {
                        while (i2 < i36) {
                            int i39 = i37 - 1;
                            iArr2[i37] = iArr[i36];
                            iArr[i36] = iArr2[i39];
                            i37 = i39;
                            i36--;
                        }
                        iArr2[i37] = iArr[i36];
                        iArr[i36] = i26;
                        return;
                    }
                    int i40 = iArr[i36];
                    if (i40 < 0) {
                        i9 |= 1;
                        i40 = ~i40;
                    }
                    int i41 = i40 + i;
                    int i42 = iArr2[i38];
                    if (i42 < 0) {
                        i9 |= 2;
                        i42 = ~i42;
                    }
                    i24 = i42 + i;
                    i8 = i41;
                    i22 = i38;
                    i12 = i37;
                    i20 = i36;
                }
                i25 = i12;
            }
        }
    }

    private void ssMergeCheckEqual(int i, int i2, int i4) {
        int[] iArr = this.f8875SA;
        if (iArr[i4] < 0 || ssCompare(getIDX(iArr[i4 - 1]) + i, i + iArr[i4], i2) != 0) {
            return;
        }
        iArr[i4] = ~iArr[i4];
    }

    private void ssMergeForward(int i, int[] iArr, int i2, int i4, int i5, int i6, int i7) {
        int i8;
        int[] iArr2 = this.f8875SA;
        int i9 = i5 - i4;
        int i10 = (i2 + i9) - 1;
        ssBlockSwap(iArr, i2, iArr2, i4, i9);
        int i11 = iArr2[i4];
        while (true) {
            int iSsCompare = ssCompare(iArr[i2] + i, iArr2[i5] + i, i7);
            if (iSsCompare < 0) {
                while (true) {
                    i8 = i4 + 1;
                    iArr2[i4] = iArr[i2];
                    if (i10 <= i2) {
                        iArr[i2] = i11;
                        return;
                    }
                    int i12 = i2 + 1;
                    iArr[i2] = iArr2[i8];
                    if (iArr[i12] >= 0) {
                        i2 = i12;
                        break;
                    } else {
                        i2 = i12;
                        i4 = i8;
                    }
                }
            } else if (iSsCompare > 0) {
                while (true) {
                    i8 = i4 + 1;
                    iArr2[i4] = iArr2[i5];
                    int i13 = i5 + 1;
                    iArr2[i5] = iArr2[i8];
                    if (i6 <= i13) {
                        while (i2 < i10) {
                            int i14 = i8 + 1;
                            iArr2[i8] = iArr[i2];
                            iArr[i2] = iArr2[i14];
                            i8 = i14;
                            i2++;
                        }
                        iArr2[i8] = iArr[i2];
                        iArr[i2] = i11;
                        return;
                    }
                    if (iArr2[i13] >= 0) {
                        i5 = i13;
                        break;
                    } else {
                        i5 = i13;
                        i4 = i8;
                    }
                }
            } else {
                iArr2[i5] = ~iArr2[i5];
                while (true) {
                    int i15 = i4 + 1;
                    iArr2[i4] = iArr[i2];
                    if (i10 <= i2) {
                        iArr[i2] = i11;
                        return;
                    }
                    int i16 = i2 + 1;
                    iArr[i2] = iArr2[i15];
                    if (iArr[i16] >= 0) {
                        while (true) {
                            int i17 = i15 + 1;
                            iArr2[i15] = iArr2[i5];
                            int i18 = i5 + 1;
                            iArr2[i5] = iArr2[i17];
                            if (i6 <= i18) {
                                while (i16 < i10) {
                                    int i19 = i17 + 1;
                                    iArr2[i17] = iArr[i16];
                                    iArr[i16] = iArr2[i19];
                                    i16++;
                                    i17 = i19;
                                }
                                iArr2[i17] = iArr[i16];
                                iArr[i16] = i11;
                                return;
                            }
                            if (iArr2[i18] >= 0) {
                                i4 = i17;
                                i2 = i16;
                                i5 = i18;
                                break;
                            }
                            i5 = i18;
                            i15 = i17;
                        }
                    } else {
                        i2 = i16;
                        i4 = i15;
                    }
                }
            }
            i4 = i8;
        }
    }

    private void ssMultiKeyIntroSort(int i, int i2, int i4, int i5) {
        int i6;
        int i7;
        byte[] bArr;
        int i8;
        StackEntry[] stackEntryArr;
        int iSsLog;
        int[] iArr = this.f8875SA;
        byte[] bArr2 = this.f8876T;
        StackEntry[] stackEntryArr2 = new StackEntry[64];
        int i9 = i5;
        int iSsLog2 = ssLog(i4 - i2);
        int i10 = 0;
        int i11 = 0;
        int i12 = i2;
        int i13 = i4;
        while (true) {
            int i14 = i13 - i12;
            if (i14 <= 8) {
                if (1 < i14) {
                    ssInsertionSort(i, i12, i13, i9);
                }
                if (i10 == 0) {
                    return;
                }
                i10--;
                StackEntry stackEntry = stackEntryArr2[i10];
                int i15 = stackEntry.f8878a;
                int i16 = stackEntry.f8879b;
                int i17 = stackEntry.f8880c;
                iSsLog2 = stackEntry.f8881d;
                i12 = i15;
                i13 = i16;
                i9 = i17;
            } else {
                int i18 = iSsLog2 - 1;
                if (iSsLog2 == 0) {
                    ssHeapSort(i9, i, i12, i14);
                }
                if (i18 < 0) {
                    int i19 = bArr2[iArr[iArr[i12] + i] + i9] & 255;
                    int iSsSubstringPartition = i12;
                    i12++;
                    while (i12 < i13) {
                        i11 = bArr2[iArr[iArr[i12] + i] + i9] & 255;
                        if (i11 != i19) {
                            if (1 < i12 - iSsSubstringPartition) {
                                break;
                            }
                            iSsSubstringPartition = i12;
                            i19 = i11;
                        }
                        i12++;
                    }
                    if ((bArr2[(iArr[iArr[iSsSubstringPartition] + i] + i9) - 1] & 255) < i19) {
                        iSsSubstringPartition = ssSubstringPartition(i, iSsSubstringPartition, i12, i9);
                    }
                    int i20 = i12 - iSsSubstringPartition;
                    int i21 = i13 - i12;
                    if (i20 <= i21) {
                        if (1 < i20) {
                            i6 = i10 + 1;
                            stackEntryArr2[i10] = new StackEntry(i12, i13, i9, -1);
                            i9++;
                            i13 = i12;
                            i12 = iSsSubstringPartition;
                            iSsLog2 = ssLog(i20);
                            i10 = i6;
                        } else {
                            iSsLog2 = -1;
                        }
                    } else if (1 < i21) {
                        i6 = i10 + 1;
                        stackEntryArr2[i10] = new StackEntry(iSsSubstringPartition, i12, i9 + 1, ssLog(i20));
                        iSsLog2 = -1;
                        i10 = i6;
                    } else {
                        i9++;
                        i13 = i12;
                        i12 = iSsSubstringPartition;
                        iSsLog2 = ssLog(i20);
                    }
                } else {
                    int iSsPivot = ssPivot(i9, i, i12, i13);
                    int i22 = bArr2[iArr[iArr[iSsPivot] + i] + i9] & 255;
                    swapElements(iArr, i12, iArr, iSsPivot);
                    int i23 = i12 + 1;
                    while (i23 < i13) {
                        i11 = bArr2[iArr[iArr[i23] + i] + i9] & 255;
                        if (i11 != i22) {
                            break;
                        } else {
                            i23++;
                        }
                    }
                    if (i23 >= i13 || i11 >= i22) {
                        i7 = i23;
                    } else {
                        i7 = i23;
                        while (true) {
                            i23++;
                            if (i23 >= i13 || (i11 = bArr2[iArr[iArr[i23] + i] + i9] & 255) > i22) {
                                break;
                            } else if (i11 == i22) {
                                swapElements(iArr, i23, iArr, i7);
                                i7++;
                            }
                        }
                    }
                    int i24 = i13 - 1;
                    while (i23 < i24) {
                        i11 = bArr2[iArr[iArr[i24] + i] + i9] & 255;
                        if (i11 != i22) {
                            break;
                        } else {
                            i24--;
                        }
                    }
                    if (i23 >= i24 || i11 <= i22) {
                        bArr = bArr2;
                        i8 = i24;
                    } else {
                        bArr = bArr2;
                        i8 = i24;
                        while (true) {
                            i24--;
                            if (i23 >= i24 || (i11 = bArr[iArr[iArr[i24] + i] + i9] & 255) < i22) {
                                break;
                            } else if (i11 == i22) {
                                swapElements(iArr, i24, iArr, i8);
                                i8--;
                            }
                        }
                    }
                    while (i23 < i24) {
                        swapElements(iArr, i23, iArr, i24);
                        while (true) {
                            i23++;
                            if (i23 >= i24 || (i11 = bArr[iArr[iArr[i23] + i] + i9] & 255) > i22) {
                                break;
                            } else if (i11 == i22) {
                                swapElements(iArr, i23, iArr, i7);
                                i7++;
                            }
                        }
                        while (true) {
                            i24--;
                            if (i23 >= i24 || (i11 = bArr[iArr[iArr[i24] + i] + i9] & 255) < i22) {
                                break;
                            } else if (i11 == i22) {
                                swapElements(iArr, i24, iArr, i8);
                                i8--;
                            }
                        }
                    }
                    if (i7 <= i8) {
                        int i25 = i23 - 1;
                        int i26 = i7 - i12;
                        int i27 = i23 - i7;
                        if (i26 > i27) {
                            i26 = i27;
                        }
                        int i28 = i8;
                        int i29 = i23 - i26;
                        stackEntryArr = stackEntryArr2;
                        int i30 = i12;
                        while (i26 > 0) {
                            swapElements(iArr, i30, iArr, i29);
                            i26--;
                            i30++;
                            i29++;
                        }
                        int i31 = i28 - i25;
                        int i32 = (i13 - i28) - 1;
                        if (i31 <= i32) {
                            i32 = i31;
                        }
                        int i33 = i13 - i32;
                        while (i32 > 0) {
                            swapElements(iArr, i23, iArr, i33);
                            i32--;
                            i23++;
                            i33++;
                        }
                        int i34 = i12 + i27;
                        int i35 = i13 - i31;
                        int iSsSubstringPartition2 = i22 <= (bArr[(iArr[iArr[i34] + i] + i9) + (-1)] & 255) ? i34 : ssSubstringPartition(i, i34, i35, i9);
                        int i36 = i34 - i12;
                        int i37 = i13 - i35;
                        if (i36 <= i37) {
                            int i38 = i35 - iSsSubstringPartition2;
                            if (i37 <= i38) {
                                int i39 = i10 + 1;
                                stackEntryArr[i10] = new StackEntry(iSsSubstringPartition2, i35, i9 + 1, ssLog(i38));
                                i10 += 2;
                                stackEntryArr[i39] = new StackEntry(i35, i13, i9, i18);
                            } else if (i36 <= i38) {
                                int i40 = i10 + 1;
                                stackEntryArr[i10] = new StackEntry(i35, i13, i9, i18);
                                i10 += 2;
                                stackEntryArr[i40] = new StackEntry(iSsSubstringPartition2, i35, i9 + 1, ssLog(i38));
                            } else {
                                int i41 = i10 + 1;
                                stackEntryArr[i10] = new StackEntry(i35, i13, i9, i18);
                                i10 += 2;
                                stackEntryArr[i41] = new StackEntry(i12, i34, i9, i18);
                                i9++;
                                iSsLog = ssLog(i38);
                                i13 = i35;
                                i12 = iSsSubstringPartition2;
                                bArr2 = bArr;
                                iSsLog2 = iSsLog;
                                stackEntryArr2 = stackEntryArr;
                            }
                            i13 = i34;
                            iSsLog2 = i18;
                        } else {
                            int i42 = i35 - iSsSubstringPartition2;
                            if (i36 <= i42) {
                                int i43 = i10 + 1;
                                stackEntryArr[i10] = new StackEntry(iSsSubstringPartition2, i35, i9 + 1, ssLog(i42));
                                i10 += 2;
                                stackEntryArr[i43] = new StackEntry(i12, i34, i9, i18);
                            } else if (i37 <= i42) {
                                int i44 = i10 + 1;
                                stackEntryArr[i10] = new StackEntry(i12, i34, i9, i18);
                                i10 += 2;
                                stackEntryArr[i44] = new StackEntry(iSsSubstringPartition2, i35, i9 + 1, ssLog(i42));
                            } else {
                                int i45 = i10 + 1;
                                stackEntryArr[i10] = new StackEntry(i12, i34, i9, i18);
                                i10 += 2;
                                stackEntryArr[i45] = new StackEntry(i35, i13, i9, i18);
                                i9++;
                                iSsLog = ssLog(i42);
                                i13 = i35;
                                i12 = iSsSubstringPartition2;
                                bArr2 = bArr;
                                iSsLog2 = iSsLog;
                                stackEntryArr2 = stackEntryArr;
                            }
                            i12 = i35;
                            iSsLog2 = i18;
                        }
                    } else {
                        stackEntryArr = stackEntryArr2;
                        if ((bArr[(iArr[iArr[i12] + i] + i9) - 1] & 255) < i22) {
                            int iSsSubstringPartition3 = ssSubstringPartition(i, i12, i13, i9);
                            i12 = iSsSubstringPartition3;
                            iSsLog2 = ssLog(i13 - iSsSubstringPartition3);
                        }
                        i9++;
                    }
                    bArr2 = bArr;
                    stackEntryArr2 = stackEntryArr;
                }
            }
        }
    }

    private int ssPivot(int i, int i2, int i4, int i5) {
        int i6 = i5 - i4;
        int i7 = (i6 / 2) + i4;
        if (i6 <= 512) {
            if (i6 <= 32) {
                return ssMedian3(i, i2, i4, i7, i5 - 1);
            }
            int i8 = i6 >> 2;
            int i9 = i5 - 1;
            return ssMedian5(i, i2, i4, i4 + i8, i7, i9 - i8, i9);
        }
        int i10 = i6 >> 3;
        int i11 = i10 << 1;
        int i12 = i5 - 1;
        return ssMedian3(i, i2, ssMedian3(i, i2, i4, i4 + i10, i4 + i11), ssMedian3(i, i2, i7 - i10, i7, i7 + i10), ssMedian3(i, i2, i12 - i11, i12 - i10, i12));
    }

    private int ssSubstringPartition(int i, int i2, int i4, int i5) {
        int i6;
        int[] iArr = this.f8875SA;
        int i7 = i2 - 1;
        while (true) {
            i7++;
            if (i7 < i4) {
                int i8 = iArr[i7];
                if (iArr[i + i8] + i5 >= iArr[i + i8 + 1] + 1) {
                    iArr[i7] = ~i8;
                }
            }
            do {
                i4--;
                if (i7 >= i4) {
                    break;
                }
                i6 = iArr[i4];
            } while (iArr[i + i6] + i5 < iArr[i6 + i + 1] + 1);
            if (i4 <= i7) {
                break;
            }
            int i9 = ~iArr[i4];
            iArr[i4] = iArr[i7];
            iArr[i7] = i9;
        }
        if (i2 < i7) {
            iArr[i2] = ~iArr[i2];
        }
        return i7;
    }

    private void subStringSort(int i, int i2, int i4, int[] iArr, int i5, int i6, int i7, boolean z, int i8) {
        int i9;
        int[] iArr2;
        int i10;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int i11 = i;
        int i12 = i7;
        int[] iArr3 = bzip2DivSufSort.f8875SA;
        int i13 = z ? i2 + 1 : i2;
        int i14 = 0;
        int i15 = i13;
        while (true) {
            int i16 = i15 + 1024;
            if (i16 >= i4) {
                break;
            }
            bzip2DivSufSort.ssMultiKeyIntroSort(i11, i15, i16, i12);
            int i17 = i4 - i16;
            if (i17 <= i6) {
                iArr2 = iArr;
                i10 = i5;
                i9 = i6;
            } else {
                i9 = i17;
                iArr2 = iArr3;
                i10 = i16;
            }
            int i18 = 1024;
            int i19 = i14;
            while (true) {
                int i20 = i15;
                if ((i19 & 1) != 0) {
                    i15 = i20 - i18;
                    bzip2DivSufSort.ssMerge(i11, i15, i20, i20 + i18, iArr2, i10, i9, i12);
                    i18 <<= 1;
                    i19 >>>= 1;
                }
            }
            i14++;
            i15 = i16;
        }
        int i21 = i6;
        bzip2DivSufSort.ssMultiKeyIntroSort(i11, i15, i4, i12);
        int i22 = i14;
        int i23 = 1024;
        int i24 = i15;
        while (i22 != 0) {
            if ((i22 & 1) != 0) {
                int i25 = i24 - i23;
                bzip2DivSufSort.ssMerge(i11, i25, i24, i4, iArr, i5, i21, i12);
                i24 = i25;
            }
            i23 <<= 1;
            i22 >>= 1;
            bzip2DivSufSort = this;
            i11 = i;
            i21 = i6;
            i12 = i7;
        }
        if (z) {
            int i26 = iArr3[i13 - 1];
            int i27 = 1;
            while (i13 < i4) {
                int i28 = iArr3[i13];
                if (i28 >= 0) {
                    int iSsCompareLast = ssCompareLast(i, i + i26, i + i28, i7, i8);
                    i27 = iSsCompareLast;
                    if (iSsCompareLast <= 0) {
                        break;
                    }
                }
                iArr3[i13 - 1] = iArr3[i13];
                i13++;
            }
            if (i27 == 0) {
                iArr3[i13] = ~iArr3[i13];
            }
            iArr3[i13 - 1] = i26;
        }
    }

    private static void swapElements(int[] iArr, int i, int[] iArr2, int i2) {
        int i4 = iArr[i];
        iArr[i] = iArr2[i2];
        iArr2[i2] = i4;
    }

    private void trCopy(int i, int i2, int i4, int i5, int i6, int i7, int i8) {
        int[] iArr = this.f8875SA;
        int i9 = i6 - 1;
        int i10 = i5 - 1;
        while (i4 <= i10) {
            int i11 = iArr[i4] - i8;
            if (i11 < 0) {
                i11 += i2 - i;
            }
            int i12 = i + i11;
            if (iArr[i12] == i9) {
                i10++;
                iArr[i10] = i11;
                iArr[i12] = i10;
            }
            i4++;
        }
        int i13 = i7 - 1;
        int i14 = i10 + 1;
        while (i14 < i6) {
            int i15 = iArr[i13] - i8;
            if (i15 < 0) {
                i15 += i2 - i;
            }
            int i16 = i + i15;
            if (iArr[i16] == i9) {
                i6--;
                iArr[i6] = i15;
                iArr[i16] = i6;
            }
            i13--;
        }
    }

    private void trFixdown(int i, int i2, int i4, int i5, int i6, int i7) {
        int[] iArr = this.f8875SA;
        int i8 = iArr[i5 + i6];
        int iTrGetC = trGetC(i, i2, i4, i8);
        while (true) {
            int i9 = i6 * 2;
            int i10 = i9 + 1;
            if (i10 >= i7) {
                break;
            }
            int i11 = i9 + 2;
            int iTrGetC2 = trGetC(i, i2, i4, iArr[i5 + i10]);
            int iTrGetC3 = trGetC(i, i2, i4, iArr[i5 + i11]);
            if (iTrGetC2 < iTrGetC3) {
                iTrGetC2 = iTrGetC3;
            } else {
                i11 = i10;
            }
            if (iTrGetC2 <= iTrGetC) {
                break;
            }
            iArr[i6 + i5] = iArr[i5 + i11];
            i6 = i11;
        }
        iArr[i5 + i6] = i8;
    }

    private int trGetC(int i, int i2, int i4, int i5) {
        int i6 = i2 + i5;
        return i6 < i4 ? this.f8875SA[i6] : this.f8875SA[(((i2 - i) + i5) % (i4 - i)) + i];
    }

    private void trHeapSort(int i, int i2, int i4, int i5, int i6) {
        int i7;
        int[] iArr = this.f8875SA;
        int i8 = i6 % 2;
        if (i8 == 0) {
            int i9 = i6 - 1;
            int i10 = (i9 / 2) + i5;
            int i11 = i5 + i9;
            if (trGetC(i, i2, i4, iArr[i10]) < trGetC(i, i2, i4, iArr[i11])) {
                swapElements(iArr, i11, iArr, i10);
            }
            i7 = i9;
        } else {
            i7 = i6;
        }
        for (int i12 = (i7 / 2) - 1; i12 >= 0; i12--) {
            trFixdown(i, i2, i4, i5, i12, i7);
        }
        if (i8 == 0) {
            swapElements(iArr, i5, iArr, i5 + i7);
            trFixdown(i, i2, i4, i5, 0, i7);
        }
        for (int i13 = i7 - 1; i13 > 0; i13--) {
            int i14 = iArr[i5];
            int i15 = i5 + i13;
            iArr[i5] = iArr[i15];
            trFixdown(i, i2, i4, i5, 0, i13);
            iArr[i15] = i14;
        }
    }

    private void trInsertionSort(int i, int i2, int i4, int i5, int i6) {
        int iTrGetC;
        int[] iArr = this.f8875SA;
        for (int i7 = i5 + 1; i7 < i6; i7++) {
            int i8 = iArr[i7];
            int i9 = i7 - 1;
            do {
                iTrGetC = trGetC(i, i2, i4, i8) - trGetC(i, i2, i4, iArr[i9]);
                if (iTrGetC >= 0) {
                    break;
                }
                do {
                    iArr[i9 + 1] = iArr[i9];
                    i9--;
                    if (i5 > i9) {
                        break;
                    }
                } while (iArr[i9] < 0);
            } while (i9 >= i5);
            if (iTrGetC == 0) {
                iArr[i9] = ~iArr[i9];
            }
            iArr[i9 + 1] = i8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:247:0x04db, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01cd, code lost:
    
        r0 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        r1 = r24;
        r19 = r11;
        r18 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04bf A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:155:0x02f6 -> B:139:0x02b4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void trIntroSort(int i, int i2, int i4, int i5, int i6, TRBudget tRBudget, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int iTrLog;
        int i12;
        int i13;
        int i14;
        StackEntry[] stackEntryArr;
        int i15;
        int i16;
        int iTrGetC;
        int i17;
        int i18;
        int iTrGetC2;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int iTrGetC3;
        Bzip2DivSufSort bzip2DivSufSort = this;
        int[] iArr = bzip2DivSufSort.f8875SA;
        StackEntry[] stackEntryArr2 = new StackEntry[64];
        int i25 = 0;
        int i26 = i2;
        int i27 = i5;
        int i28 = i6;
        int iTrLog2 = trLog(i6 - i5);
        int i29 = 0;
        int iTrGetC4 = 0;
        while (true) {
            if (iTrLog2 < 0) {
                if (iTrLog2 == -1) {
                    if (!tRBudget.update(i7, i28 - i27)) {
                        break;
                    }
                    int i30 = i26 - 1;
                    PartitionResult partitionResultTrPartition = bzip2DivSufSort.trPartition(i, i30, i4, i27, i28, i28 - 1);
                    int i31 = partitionResultTrPartition.first;
                    int i32 = partitionResultTrPartition.last;
                    if (i27 < i31 || i32 < i28) {
                        if (i31 < i28) {
                            int i33 = i31 - 1;
                            for (int i34 = i27; i34 < i31; i34++) {
                                iArr[i + iArr[i34]] = i33;
                            }
                        }
                        if (i32 < i28) {
                            int i35 = i32 - 1;
                            for (int i36 = i31; i36 < i32; i36++) {
                                iArr[i + iArr[i36]] = i35;
                            }
                        }
                        stackEntryArr2[i29] = new StackEntry(i25, i31, i32, i25);
                        int i37 = i29 + 2;
                        stackEntryArr2[i29 + 1] = new StackEntry(i30, i27, i28, -2);
                        int i38 = i31 - i27;
                        int i39 = i28 - i32;
                        if (i38 <= i39) {
                            if (1 < i38) {
                                i29 += 3;
                                stackEntryArr2[i37] = new StackEntry(i26, i32, i28, trLog(i39));
                                iTrLog = trLog(i38);
                                i28 = i31;
                                iTrLog2 = iTrLog;
                            } else if (1 < i39) {
                                i27 = i32;
                                i29 = i37;
                                iTrLog2 = trLog(i39);
                            } else {
                                if (i37 == 0) {
                                    break;
                                }
                                i29++;
                                StackEntry stackEntry = stackEntryArr2[i29];
                                i8 = stackEntry.f8878a;
                                i9 = stackEntry.f8879b;
                                i10 = stackEntry.f8880c;
                                i11 = stackEntry.f8881d;
                                iTrLog2 = i11;
                                i26 = i8;
                                i27 = i9;
                                i28 = i10;
                            }
                        } else if (1 < i39) {
                            i29 += 3;
                            stackEntryArr2[i37] = new StackEntry(i26, i27, i31, trLog(i38));
                            iTrLog2 = trLog(i39);
                            i27 = i32;
                        } else if (1 < i38) {
                            iTrLog = trLog(i38);
                            i28 = i31;
                            i29 = i37;
                            iTrLog2 = iTrLog;
                        } else {
                            if (i37 == 0) {
                                break;
                            }
                            i29++;
                            StackEntry stackEntry2 = stackEntryArr2[i29];
                            i8 = stackEntry2.f8878a;
                            i9 = stackEntry2.f8879b;
                            i10 = stackEntry2.f8880c;
                            i11 = stackEntry2.f8881d;
                            iTrLog2 = i11;
                            i26 = i8;
                            i27 = i9;
                            i28 = i10;
                        }
                    } else {
                        while (i27 < i28) {
                            iArr[i + iArr[i27]] = i27;
                            i27++;
                        }
                        if (i29 == 0) {
                            break;
                        }
                        i29--;
                        StackEntry stackEntry3 = stackEntryArr2[i29];
                        i8 = stackEntry3.f8878a;
                        i9 = stackEntry3.f8879b;
                        i10 = stackEntry3.f8880c;
                        i11 = stackEntry3.f8881d;
                        iTrLog2 = i11;
                        i26 = i8;
                        i27 = i9;
                        i28 = i10;
                    }
                    i25 = 0;
                } else if (iTrLog2 == -2) {
                    int i40 = i29 - 1;
                    StackEntry stackEntry4 = stackEntryArr2[i40];
                    trCopy(i, i4, i27, stackEntry4.f8879b, stackEntry4.f8880c, i28, i26 - i);
                    if (i40 == 0) {
                        break;
                    }
                    i29 -= 2;
                    StackEntry stackEntry5 = stackEntryArr2[i29];
                    i26 = stackEntry5.f8878a;
                    i27 = stackEntry5.f8879b;
                    i28 = stackEntry5.f8880c;
                    iTrLog2 = stackEntry5.f8881d;
                    i25 = 0;
                } else {
                    if (iArr[i27] >= 0) {
                        do {
                            iArr[i + iArr[i27]] = i27;
                            i27++;
                            if (i27 >= i28) {
                                break;
                            }
                        } while (iArr[i27] >= 0);
                    }
                    if (i27 < i28) {
                        int i41 = i27;
                        while (true) {
                            iArr[i41] = ~iArr[i41];
                            i12 = i41 + 1;
                            i13 = iArr[i12];
                            if (i13 >= 0) {
                                break;
                            } else {
                                i41 = i12;
                            }
                        }
                        iTrLog2 = iArr[i + i13] != iArr[i13 + i26] ? trLog((i12 - i27) + 1) : -1;
                        int i42 = i41 + 2;
                        if (i42 < i28) {
                            int i43 = i41 + 1;
                            for (int i44 = i27; i44 < i42; i44++) {
                                iArr[i + iArr[i44]] = i43;
                            }
                        }
                        int i45 = i28 - i42;
                        if (i42 - i27 <= i45) {
                            stackEntryArr2[i29] = new StackEntry(i26, i42, i28, -3);
                            i26++;
                            i25 = 0;
                            i29++;
                            i28 = i42;
                        } else if (1 < i45) {
                            stackEntryArr2[i29] = new StackEntry(i26 + 1, i27, i42, iTrLog2);
                            i25 = 0;
                            i29++;
                            i27 = i42;
                            iTrLog2 = -3;
                        } else {
                            i26++;
                            i25 = 0;
                            bzip2DivSufSort = this;
                            i28 = i42;
                        }
                    } else {
                        if (i29 == 0) {
                            break;
                        }
                        i29--;
                        StackEntry stackEntry6 = stackEntryArr2[i29];
                        i26 = stackEntry6.f8878a;
                        i27 = stackEntry6.f8879b;
                        i28 = stackEntry6.f8880c;
                        iTrLog2 = stackEntry6.f8881d;
                        i25 = 0;
                    }
                }
                bzip2DivSufSort = this;
            } else {
                int i46 = i28;
                int i47 = i46 - i27;
                if (i47 > 8) {
                    i16 = i26;
                    int i48 = iTrLog2 - 1;
                    if (iTrLog2 != 0) {
                        i28 = i46;
                        bzip2DivSufSort = this;
                        i14 = i;
                        swapElements(iArr, i27, iArr, bzip2DivSufSort.trPivot(i14, i16, i4, i27, i28));
                        int iTrGetC5 = bzip2DivSufSort.trGetC(i14, i16, i4, iArr[i27]);
                        int i49 = iTrLog2;
                        int i50 = i27 + 1;
                        while (i50 < i28) {
                            iTrGetC4 = bzip2DivSufSort.trGetC(i14, i16, i4, iArr[i50]);
                            if (iTrGetC4 != iTrGetC5) {
                                break;
                            } else {
                                i50++;
                            }
                        }
                        if (i50 < i28 && iTrGetC4 < iTrGetC5) {
                            int i51 = iTrGetC4;
                            i17 = i50;
                            while (true) {
                                i50++;
                                stackEntryArr = stackEntryArr2;
                                if (i50 >= i28) {
                                    iTrGetC = i51;
                                    break;
                                }
                                iTrGetC = bzip2DivSufSort.trGetC(i14, i16, i4, iArr[i50]);
                                if (iTrGetC > iTrGetC5) {
                                    break;
                                }
                                if (iTrGetC == iTrGetC5) {
                                    swapElements(iArr, i50, iArr, i17);
                                    i17++;
                                }
                                i51 = iTrGetC;
                                stackEntryArr2 = stackEntryArr;
                            }
                        } else {
                            stackEntryArr = stackEntryArr2;
                            iTrGetC = iTrGetC4;
                            i17 = i50;
                        }
                        int i52 = iTrGetC;
                        int i53 = i28 - 1;
                        while (true) {
                            i18 = i17;
                            if (i50 >= i53) {
                                iTrGetC2 = i52;
                                break;
                            }
                            iTrGetC2 = bzip2DivSufSort.trGetC(i14, i16, i4, iArr[i53]);
                            if (iTrGetC2 != iTrGetC5) {
                                break;
                            }
                            i53--;
                            i52 = iTrGetC2;
                            i17 = i18;
                        }
                        if (i50 >= i53 || iTrGetC2 <= iTrGetC5) {
                            i15 = i29;
                            i19 = i18;
                            i20 = i50;
                            i21 = iTrGetC2;
                            i22 = i53;
                            while (i20 < i53) {
                                swapElements(iArr, i20, iArr, i53);
                                while (true) {
                                    i20++;
                                    int i54 = i53;
                                    if (i20 >= i53) {
                                        break;
                                    }
                                    int iTrGetC6 = bzip2DivSufSort.trGetC(i14, i16, i4, iArr[i20]);
                                    if (iTrGetC6 > iTrGetC5) {
                                        i21 = iTrGetC6;
                                        i53 = i54;
                                        break;
                                    } else {
                                        if (iTrGetC6 == iTrGetC5) {
                                            swapElements(iArr, i20, iArr, i19);
                                            i19++;
                                        }
                                        i21 = iTrGetC6;
                                        i53 = i54;
                                    }
                                }
                                while (true) {
                                    i53--;
                                    i24 = i20;
                                    if (i20 >= i53) {
                                        break;
                                    }
                                    iTrGetC3 = bzip2DivSufSort.trGetC(i14, i16, i4, iArr[i53]);
                                    if (iTrGetC3 < iTrGetC5) {
                                        break;
                                    }
                                    if (iTrGetC3 == iTrGetC5) {
                                        swapElements(iArr, i53, iArr, i22);
                                        i22--;
                                    }
                                    i21 = iTrGetC3;
                                    i20 = i24;
                                }
                                i21 = iTrGetC3;
                                i20 = i24;
                                while (i20 < i53) {
                                }
                            }
                            if (i19 > i22) {
                                int i55 = i20 - 1;
                                int i56 = i19 - i27;
                                int i57 = i20 - i19;
                                if (i56 > i57) {
                                    i56 = i57;
                                }
                                int i58 = i20 - i56;
                                int i59 = i56;
                                int i60 = i27;
                                while (i59 > 0) {
                                    swapElements(iArr, i60, iArr, i58);
                                    i59--;
                                    i60++;
                                    i58++;
                                }
                                int i61 = i22 - i55;
                                int i62 = (i28 - i22) - 1;
                                if (i61 <= i62) {
                                    i62 = i61;
                                }
                                int i63 = i28 - i62;
                                while (i62 > 0) {
                                    swapElements(iArr, i20, iArr, i63);
                                    i62--;
                                    i20++;
                                    i63++;
                                }
                                int i64 = i27 + i57;
                                int i65 = i28 - i61;
                                int iTrLog3 = iArr[iArr[i64] + i14] != iTrGetC5 ? trLog(i65 - i64) : -1;
                                int i66 = i64 - 1;
                                for (int i67 = i27; i67 < i64; i67++) {
                                    iArr[iArr[i67] + i14] = i66;
                                }
                                if (i65 < i28) {
                                    int i68 = i65 - 1;
                                    for (int i69 = i64; i69 < i65; i69++) {
                                        iArr[iArr[i69] + i14] = i68;
                                    }
                                }
                                int i70 = i64 - i27;
                                int i71 = i28 - i65;
                                if (i70 <= i71) {
                                    int i72 = i65 - i64;
                                    if (i71 <= i72) {
                                        if (1 < i70) {
                                            stackEntryArr[i15] = new StackEntry(i16 + 1, i64, i65, iTrLog3);
                                            i23 = i15 + 2;
                                            stackEntryArr[i15 + 1] = new StackEntry(i16, i65, i28, i48);
                                            i28 = i64;
                                            i29 = i23;
                                            iTrLog2 = i48;
                                            stackEntryArr2 = stackEntryArr;
                                            iTrGetC4 = i21;
                                        } else if (1 < i71) {
                                            i29 = i15 + 1;
                                            stackEntryArr[i15] = new StackEntry(i16 + 1, i64, i65, iTrLog3);
                                            i26 = i16;
                                            i27 = i65;
                                            iTrLog2 = i48;
                                        } else if (1 < i72) {
                                            i16++;
                                            i28 = i65;
                                            i27 = i64;
                                            iTrLog2 = iTrLog3;
                                            i29 = i15;
                                            stackEntryArr2 = stackEntryArr;
                                            iTrGetC4 = i21;
                                        } else {
                                            if (i15 == 0) {
                                                return;
                                            }
                                            i29 = i15 - 1;
                                            StackEntry stackEntry7 = stackEntryArr[i29];
                                            i26 = stackEntry7.f8878a;
                                            i27 = stackEntry7.f8879b;
                                            i28 = stackEntry7.f8880c;
                                            iTrLog2 = stackEntry7.f8881d;
                                        }
                                    } else if (i70 <= i72) {
                                        if (1 < i70) {
                                            stackEntryArr[i15] = new StackEntry(i16, i65, i28, i48);
                                            stackEntryArr[i15 + 1] = new StackEntry(i16 + 1, i64, i65, iTrLog3);
                                            i26 = i16;
                                            i29 = i15 + 2;
                                            i28 = i64;
                                            iTrLog2 = i48;
                                        } else if (1 < i72) {
                                            i29 = i15 + 1;
                                            stackEntryArr[i15] = new StackEntry(i16, i65, i28, i48);
                                            i16++;
                                            i28 = i65;
                                            i27 = i64;
                                            iTrLog2 = iTrLog3;
                                            stackEntryArr2 = stackEntryArr;
                                            iTrGetC4 = i21;
                                        } else {
                                            i26 = i16;
                                            i27 = i65;
                                            iTrLog2 = i48;
                                            i29 = i15;
                                        }
                                    } else if (1 < i72) {
                                        stackEntryArr[i15] = new StackEntry(i16, i65, i28, i48);
                                        stackEntryArr[i15 + 1] = new StackEntry(i16, i27, i64, i48);
                                        i29 = i15 + 2;
                                        i27 = i64;
                                        iTrLog2 = iTrLog3;
                                        stackEntryArr2 = stackEntryArr;
                                        iTrGetC4 = i21;
                                        i25 = 0;
                                        i26 = i16 + 1;
                                        i28 = i65;
                                    } else {
                                        i29 = i15 + 1;
                                        stackEntryArr[i15] = new StackEntry(i16, i65, i28, i48);
                                        i26 = i16;
                                        i28 = i64;
                                        iTrLog2 = i48;
                                    }
                                } else {
                                    int i73 = i65 - i64;
                                    if (i70 <= i73) {
                                        if (1 < i71) {
                                            stackEntryArr[i15] = new StackEntry(i16 + 1, i64, i65, iTrLog3);
                                            i23 = i15 + 2;
                                            stackEntryArr[i15 + 1] = new StackEntry(i16, i27, i64, i48);
                                            i27 = i65;
                                            i29 = i23;
                                            iTrLog2 = i48;
                                            stackEntryArr2 = stackEntryArr;
                                            iTrGetC4 = i21;
                                        } else if (1 < i70) {
                                            i29 = i15 + 1;
                                            stackEntryArr[i15] = new StackEntry(i16 + 1, i64, i65, iTrLog3);
                                            i26 = i16;
                                            i28 = i64;
                                            iTrLog2 = i48;
                                        } else if (1 < i73) {
                                            i16++;
                                            i28 = i65;
                                            i27 = i64;
                                            iTrLog2 = iTrLog3;
                                            i29 = i15;
                                            stackEntryArr2 = stackEntryArr;
                                            iTrGetC4 = i21;
                                        } else {
                                            i29 = i15 + 1;
                                            stackEntryArr[i15] = new StackEntry(i16, i27, i28, i48);
                                            i26 = i16;
                                            iTrLog2 = i48;
                                        }
                                    } else if (i71 <= i73) {
                                        if (1 < i71) {
                                            stackEntryArr[i15] = new StackEntry(i16, i27, i64, i48);
                                            stackEntryArr[i15 + 1] = new StackEntry(i16 + 1, i64, i65, iTrLog3);
                                            i26 = i16;
                                            i29 = i15 + 2;
                                            iTrLog2 = i48;
                                            stackEntryArr2 = stackEntryArr;
                                            iTrGetC4 = i21;
                                            i25 = 0;
                                            i27 = i65;
                                        } else if (1 < i73) {
                                            i29 = i15 + 1;
                                            stackEntryArr[i15] = new StackEntry(i16, i27, i64, i48);
                                            i16++;
                                            i28 = i65;
                                            i27 = i64;
                                            iTrLog2 = iTrLog3;
                                            stackEntryArr2 = stackEntryArr;
                                            iTrGetC4 = i21;
                                        } else {
                                            i26 = i16;
                                            i28 = i64;
                                            iTrLog2 = i48;
                                            i29 = i15;
                                        }
                                    } else if (1 < i73) {
                                        stackEntryArr[i15] = new StackEntry(i16, i27, i64, i48);
                                        stackEntryArr[i15 + 1] = new StackEntry(i16, i65, i28, i48);
                                        i16++;
                                        i28 = i65;
                                        i29 = i15 + 2;
                                        i27 = i64;
                                        iTrLog2 = iTrLog3;
                                        stackEntryArr2 = stackEntryArr;
                                        iTrGetC4 = i21;
                                    } else {
                                        i29 = i15 + 1;
                                        stackEntryArr[i15] = new StackEntry(i16, i27, i64, i48);
                                        i26 = i16;
                                        i27 = i65;
                                        iTrLog2 = i48;
                                    }
                                }
                            } else {
                                if (!tRBudget.update(i7, i47)) {
                                    break;
                                }
                                i29 = i15;
                                i26 = i16 + 1;
                                iTrLog2 = i49;
                            }
                            stackEntryArr2 = stackEntryArr;
                            iTrGetC4 = i21;
                            i25 = 0;
                        } else {
                            int i74 = iTrGetC2;
                            i22 = i53;
                            while (true) {
                                i53--;
                                i24 = i50;
                                if (i50 >= i53) {
                                    iTrGetC3 = i74;
                                    break;
                                }
                                iTrGetC3 = bzip2DivSufSort.trGetC(i14, i16, i4, iArr[i53]);
                                if (iTrGetC3 < iTrGetC5) {
                                    break;
                                }
                                if (iTrGetC3 == iTrGetC5) {
                                    swapElements(iArr, i53, iArr, i22);
                                    i22--;
                                }
                                i74 = iTrGetC3;
                                i50 = i24;
                            }
                            i15 = i29;
                            i19 = i18;
                            i21 = iTrGetC3;
                            i20 = i24;
                            while (i20 < i53) {
                            }
                            if (i19 > i22) {
                            }
                            stackEntryArr2 = stackEntryArr;
                            iTrGetC4 = i21;
                            i25 = 0;
                        }
                    } else {
                        if (!tRBudget.update(i7, i47)) {
                            break;
                        }
                        bzip2DivSufSort = this;
                        bzip2DivSufSort.trHeapSort(i, i16, i4, i27, i47);
                        int i75 = i46 - 1;
                        while (i27 < i75) {
                            iTrGetC4 = bzip2DivSufSort.trGetC(i, i16, i4, iArr[i75]);
                            i75--;
                            while (i27 <= i75 && bzip2DivSufSort.trGetC(i, i16, i4, iArr[i75]) == iTrGetC4) {
                                iArr[i75] = ~iArr[i75];
                                i75--;
                            }
                        }
                        i28 = i46;
                        iTrLog2 = -3;
                    }
                    i25 = 0;
                    i26 = i16;
                } else {
                    if (!tRBudget.update(i7, i47)) {
                        break;
                    }
                    i28 = i46;
                    i16 = i26;
                    bzip2DivSufSort = this;
                    bzip2DivSufSort.trInsertionSort(i, i16, i4, i27, i28);
                    i25 = 0;
                    iTrLog2 = -3;
                    i26 = i16;
                }
            }
        }
        int i76 = i15;
        for (int i77 = 0; i77 < i76; i77++) {
            StackEntry stackEntry8 = stackEntryArr[i77];
            if (stackEntry8.f8881d == -3) {
                bzip2DivSufSort.lsUpdateGroup(i14, stackEntry8.f8879b, stackEntry8.f8880c);
            }
        }
    }

    private static int trLog(int i) {
        return ((-65536) & i) != 0 ? ((-16777216) & i) != 0 ? LOG_2_TABLE[(i >> 24) & 255] + 24 : LOG_2_TABLE[(i >> 16) & 271] : (65280 & i) != 0 ? LOG_2_TABLE[(i >> 8) & 255] + 8 : LOG_2_TABLE[i & 255];
    }

    private int trMedian3(int i, int i2, int i4, int i5, int i6, int i7) {
        int[] iArr = this.f8875SA;
        int iTrGetC = trGetC(i, i2, i4, iArr[i5]);
        int iTrGetC2 = trGetC(i, i2, i4, iArr[i6]);
        int iTrGetC3 = trGetC(i, i2, i4, iArr[i7]);
        if (iTrGetC <= iTrGetC2) {
            i6 = i5;
            i5 = i6;
            iTrGetC2 = iTrGetC;
            iTrGetC = iTrGetC2;
        }
        return iTrGetC > iTrGetC3 ? iTrGetC2 > iTrGetC3 ? i6 : i7 : i5;
    }

    private int trMedian5(int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        int[] iArr = this.f8875SA;
        int iTrGetC = trGetC(i, i2, i4, iArr[i5]);
        int iTrGetC2 = trGetC(i, i2, i4, iArr[i6]);
        int iTrGetC3 = trGetC(i, i2, i4, iArr[i7]);
        int iTrGetC4 = trGetC(i, i2, i4, iArr[i8]);
        int iTrGetC5 = trGetC(i, i2, i4, iArr[i9]);
        if (iTrGetC2 > iTrGetC3) {
            i7 = i6;
            i6 = i7;
            iTrGetC3 = iTrGetC2;
            iTrGetC2 = iTrGetC3;
        }
        if (iTrGetC4 > iTrGetC5) {
            iTrGetC4 = iTrGetC5;
            iTrGetC5 = iTrGetC4;
        } else {
            i9 = i8;
            i8 = i9;
        }
        if (iTrGetC2 > iTrGetC4) {
            int i10 = iTrGetC3;
            iTrGetC3 = iTrGetC5;
            iTrGetC5 = i10;
            int i11 = i8;
            i8 = i7;
            i7 = i11;
        } else {
            i6 = i9;
            iTrGetC2 = iTrGetC4;
        }
        if (iTrGetC > iTrGetC3) {
            int i12 = i7;
            i7 = i5;
            i5 = i12;
            int i13 = iTrGetC3;
            iTrGetC3 = iTrGetC;
            iTrGetC = i13;
        }
        if (iTrGetC > iTrGetC2) {
            i6 = i5;
            iTrGetC2 = iTrGetC;
        } else {
            i8 = i7;
            iTrGetC5 = iTrGetC3;
        }
        return iTrGetC5 > iTrGetC2 ? i6 : i8;
    }

    private PartitionResult trPartition(int i, int i2, int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int iTrGetC;
        int iTrGetC2;
        int iTrGetC3;
        int[] iArr = this.f8875SA;
        int iTrGetC4 = 0;
        int i10 = i5;
        while (i10 < i6) {
            iTrGetC4 = trGetC(i, i2, i4, iArr[i10]);
            if (iTrGetC4 != i7) {
                break;
            }
            i10++;
        }
        if (i10 >= i6 || iTrGetC4 >= i7) {
            i8 = i10;
        } else {
            i8 = i10;
            while (true) {
                i10++;
                if (i10 >= i6 || (iTrGetC4 = trGetC(i, i2, i4, iArr[i10])) > i7) {
                    break;
                }
                if (iTrGetC4 == i7) {
                    swapElements(iArr, i10, iArr, i8);
                    i8++;
                }
            }
        }
        int i11 = i6 - 1;
        while (i10 < i11) {
            iTrGetC4 = trGetC(i, i2, i4, iArr[i11]);
            if (iTrGetC4 != i7) {
                break;
            }
            i11--;
        }
        if (i10 >= i11 || iTrGetC4 <= i7) {
            i9 = i11;
        } else {
            i9 = i11;
            while (true) {
                i11--;
                if (i10 >= i11 || (iTrGetC3 = trGetC(i, i2, i4, iArr[i11])) < i7) {
                    break;
                }
                if (iTrGetC3 == i7) {
                    swapElements(iArr, i11, iArr, i9);
                    i9--;
                }
            }
        }
        while (i10 < i11) {
            swapElements(iArr, i10, iArr, i11);
            while (true) {
                i10++;
                if (i10 >= i11 || (iTrGetC2 = trGetC(i, i2, i4, iArr[i10])) > i7) {
                    break;
                }
                if (iTrGetC2 == i7) {
                    swapElements(iArr, i10, iArr, i8);
                    i8++;
                }
            }
            while (true) {
                i11--;
                if (i10 >= i11 || (iTrGetC = trGetC(i, i2, i4, iArr[i11])) < i7) {
                    break;
                }
                if (iTrGetC == i7) {
                    swapElements(iArr, i11, iArr, i9);
                    i9--;
                }
            }
        }
        if (i8 <= i9) {
            int i12 = i10 - 1;
            int i13 = i8 - i5;
            int i14 = i10 - i8;
            if (i13 > i14) {
                i13 = i14;
            }
            int i15 = i10 - i13;
            int i16 = i5;
            while (i13 > 0) {
                swapElements(iArr, i16, iArr, i15);
                i13--;
                i16++;
                i15++;
            }
            int i17 = i9 - i12;
            int i18 = (i6 - i9) - 1;
            if (i17 <= i18) {
                i18 = i17;
            }
            int i19 = i6 - i18;
            while (i18 > 0) {
                swapElements(iArr, i10, iArr, i19);
                i18--;
                i10++;
                i19++;
            }
            i5 += i14;
            i6 -= i17;
        }
        return new PartitionResult(i5, i6);
    }

    private int trPivot(int i, int i2, int i4, int i5, int i6) {
        int i7 = i6 - i5;
        int i8 = (i7 / 2) + i5;
        if (i7 <= 512) {
            if (i7 <= 32) {
                return trMedian3(i, i2, i4, i5, i8, i6 - 1);
            }
            int i9 = i7 >> 2;
            int i10 = i6 - 1;
            return trMedian5(i, i2, i4, i5, i5 + i9, i8, i10 - i9, i10);
        }
        int i11 = i7 >> 3;
        int i12 = i11 << 1;
        int i13 = i6 - 1;
        return trMedian3(i, i2, i4, trMedian3(i, i2, i4, i5, i5 + i11, i5 + i12), trMedian3(i, i2, i4, i8 - i11, i8, i8 + i11), trMedian3(i, i2, i4, i13 - i12, i13 - i11, i13));
    }

    private void trSort(int i, int i2, int i4) {
        int[] iArr = this.f8875SA;
        if ((-i2) < iArr[0]) {
            TRBudget tRBudget = new TRBudget(i2, AbstractC2322a.m1611a(trLog(i2), 2, 3, 1));
            int i5 = 0;
            do {
                int i6 = iArr[i5];
                if (i6 < 0) {
                    i5 -= i6;
                } else {
                    int i7 = iArr[i6 + i] + 1;
                    if (1 < i7 - i5) {
                        trIntroSort(i, i + i4, i + i2, i5, i7, tRBudget, i2);
                        if (tRBudget.chance == 0) {
                            if (i5 > 0) {
                                iArr[0] = -i5;
                            }
                            lsSort(i, i2, i4);
                            return;
                        }
                    }
                    i5 = i7;
                }
            } while (i5 < i2);
        }
    }

    public int bwt() {
        int[] iArr = this.f8875SA;
        byte[] bArr = this.f8876T;
        int i = this.f8877n;
        int[] iArr2 = new int[256];
        int[] iArr3 = new int[65536];
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            iArr[0] = bArr[0];
            return 0;
        }
        if (sortTypeBstar(iArr2, iArr3) > 0) {
            return constructBWT(iArr2, iArr3);
        }
        return 0;
    }
}
