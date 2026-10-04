package io.netty.handler.codec.compression;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2HuffmanAllocator {
    private Bzip2HuffmanAllocator() {
    }

    public static void allocateHuffmanCodeLengths(int[] iArr, int i) {
        int length = iArr.length;
        if (length != 1) {
            if (length != 2) {
                setExtendedParentPointers(iArr);
                int iFindNodesToRelocate = findNodesToRelocate(iArr, i);
                if (iArr[0] % iArr.length >= iFindNodesToRelocate) {
                    allocateNodeLengths(iArr);
                    return;
                } else {
                    allocateNodeLengthsWithRelocation(iArr, iFindNodesToRelocate, i - (32 - Integer.numberOfLeadingZeros(iFindNodesToRelocate - 1)));
                    return;
                }
            }
            iArr[1] = 1;
        }
        iArr[0] = 1;
    }

    private static void allocateNodeLengths(int[] iArr) {
        int i = 2;
        int length = iArr.length - 2;
        int i2 = 1;
        int length2 = iArr.length - 1;
        while (i > 0) {
            int iFirst = first(iArr, length - 1, 0);
            int i4 = length - iFirst;
            int i5 = i - i4;
            while (i5 > 0) {
                iArr[length2] = i2;
                i5--;
                length2--;
            }
            i = i4 << 1;
            i2++;
            length = iFirst;
        }
    }

    private static void allocateNodeLengthsWithRelocation(int[] iArr, int i, int i2) {
        int iMin;
        int length = iArr.length - 2;
        int length2 = iArr.length - 1;
        int i4 = i2 != 1 ? 1 : 2;
        int i5 = i2 == 1 ? i - 2 : i;
        int i6 = i4 << 1;
        while (i6 > 0) {
            int iFirst = length <= i ? length : first(iArr, length - 1, i);
            if (i4 >= i2) {
                iMin = Math.min(i5, 1 << (i4 - i2));
            } else if (i4 == i2 - 1) {
                if (iArr[iFirst] == length) {
                    iFirst++;
                }
                iMin = 1;
            } else {
                iMin = 0;
            }
            int i7 = (length - iFirst) + iMin;
            int i8 = i6 - i7;
            while (i8 > 0) {
                iArr[length2] = i4;
                i8--;
                length2--;
            }
            i5 -= iMin;
            i6 = i7 << 1;
            i4++;
            length = iFirst;
        }
    }

    private static int findNodesToRelocate(int[] iArr, int i) {
        int length = iArr.length - 2;
        for (int i2 = 1; i2 < i - 1 && length > 1; i2++) {
            length = first(iArr, length - 1, 0);
        }
        return length;
    }

    private static int first(int[] iArr, int i, int i2) {
        int length = iArr.length;
        int length2 = iArr.length - 2;
        int i4 = i;
        while (i4 >= i2 && iArr[i4] % length > i) {
            length2 = i4;
            i4 -= (i - i4) + 1;
        }
        int iMax = Math.max(i2 - 1, i4);
        while (length2 > iMax + 1) {
            int i5 = (iMax + length2) >>> 1;
            if (iArr[i5] % length > i) {
                length2 = i5;
            } else {
                iMax = i5;
            }
        }
        return length2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void setExtendedParentPointers(int[] iArr) {
        int i;
        int i2;
        int length = iArr.length;
        int i4 = 0;
        iArr[0] = iArr[0] + iArr[1];
        int i5 = 2;
        for (int i6 = 1; i6 < length - 1; i6++) {
            if (i5 < length) {
                int i7 = iArr[i4];
                i = iArr[i5];
                if (i7 < i) {
                    i = iArr[i4];
                    iArr[i4] = i6;
                    i4++;
                } else {
                    i5++;
                }
            }
            if (i5 >= length || (i4 < i6 && iArr[i4] < iArr[i5])) {
                i2 = i + iArr[i4];
                iArr[i4] = i6 + length;
                i4++;
            } else {
                i2 = i + iArr[i5];
                i5++;
            }
            iArr[i6] = i2;
        }
    }
}
