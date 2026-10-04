package org.brotli.dec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Huffman {
    static final int HUFFMAN_MAX_TABLE_SIZE = 1080;
    private static final int MAX_LENGTH = 15;

    public static void buildHuffmanTable(int[] iArr, int i, int i2, int[] iArr2, int i4) {
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int nextKey = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr2[i5];
            iArr4[i6] = iArr4[i6] + 1;
        }
        iArr5[1] = 0;
        int i7 = 1;
        while (i7 < 15) {
            int i8 = i7 + 1;
            iArr5[i8] = iArr5[i7] + iArr4[i7];
            i7 = i8;
        }
        for (int i9 = 0; i9 < i4; i9++) {
            int i10 = iArr2[i9];
            if (i10 != 0) {
                int i11 = iArr5[i10];
                iArr5[i10] = i11 + 1;
                iArr3[i11] = i9;
            }
        }
        int i12 = 1 << i2;
        if (iArr5[15] == 1) {
            for (int i13 = 0; i13 < i12; i13++) {
                iArr[i + i13] = iArr3[0];
            }
            return;
        }
        int i14 = 2;
        int i15 = 2;
        int i16 = 0;
        int i17 = 1;
        while (i17 <= i2) {
            while (iArr4[i17] > 0) {
                replicateValue(iArr, i + nextKey, i15, i12, iArr3[i16] | (i17 << 16));
                nextKey = getNextKey(nextKey, i17);
                iArr4[i17] = iArr4[i17] - 1;
                i16++;
            }
            i17++;
            i15 <<= 1;
        }
        int i18 = i12 - 1;
        int i19 = i2 + 1;
        int i20 = -1;
        int i21 = i;
        while (i19 <= 15) {
            while (iArr4[i19] > 0) {
                int i22 = nextKey & i18;
                if (i22 != i20) {
                    i21 += i12;
                    int iNextTableBitSize = nextTableBitSize(iArr4, i19, i2);
                    iArr[i + i22] = ((iNextTableBitSize + i2) << 16) | ((i21 - i) - i22);
                    i12 = 1 << iNextTableBitSize;
                    i20 = i22;
                }
                replicateValue(iArr, (nextKey >> i2) + i21, i14, i12, ((i19 - i2) << 16) | iArr3[i16]);
                nextKey = getNextKey(nextKey, i19);
                iArr4[i19] = iArr4[i19] - 1;
                i16++;
            }
            i19++;
            i14 <<= 1;
        }
    }

    private static int getNextKey(int i, int i2) {
        int i4 = 1 << (i2 - 1);
        while ((i & i4) != 0) {
            i4 >>= 1;
        }
        return (i & (i4 - 1)) + i4;
    }

    private static int nextTableBitSize(int[] iArr, int i, int i2) {
        int i4;
        int i5 = 1 << (i - i2);
        while (i < 15 && (i4 = i5 - iArr[i]) > 0) {
            i++;
            i5 = i4 << 1;
        }
        return i - i2;
    }

    private static void replicateValue(int[] iArr, int i, int i2, int i4, int i5) {
        do {
            i4 -= i2;
            iArr[i + i4] = i5;
        } while (i4 > 0);
    }
}
