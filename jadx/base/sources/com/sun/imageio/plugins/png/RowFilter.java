package com.sun.imageio.plugins.png;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RowFilter {
    private static final int abs(int i) {
        return i < 0 ? -i : i;
    }

    public static int subFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        int iAbs = 0;
        for (int i4 = i; i4 < i2 + i; i4++) {
            int i5 = (bArr[i4] & 255) - (bArr[i4 - i] & 255);
            bArr2[i4] = (byte) i5;
            iAbs += abs(i5);
        }
        return iAbs;
    }

    public static int upFilter(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        int iAbs = 0;
        for (int i4 = i; i4 < i2 + i; i4++) {
            int i5 = (bArr[i4] & 255) - (bArr2[i4] & 255);
            bArr3[i4] = (byte) i5;
            iAbs += abs(i5);
        }
        return iAbs;
    }

    public int filterRow(int i, byte[] bArr, byte[] bArr2, byte[][] bArr3, int i2, int i4) {
        int i5;
        int i6 = 0;
        if (i != 3) {
            System.arraycopy(bArr, i4, bArr3[0], i4, i2);
            return 0;
        }
        int[] iArr = new int[5];
        for (int i7 = 0; i7 < 5; i7++) {
            iArr[i7] = Integer.MAX_VALUE;
        }
        int i8 = i4;
        int i9 = 0;
        while (true) {
            i5 = i2 + i4;
            if (i8 >= i5) {
                break;
            }
            i9 += bArr[i8] & 255;
            i8++;
        }
        iArr[0] = i9;
        iArr[1] = subFilter(bArr, bArr3[1], i4, i2);
        iArr[2] = upFilter(bArr, bArr2, bArr3[2], i4, i2);
        byte[] bArr4 = bArr3[3];
        int i10 = i4;
        int iAbs = 0;
        while (i10 < i5) {
            int i11 = (bArr[i10] & 255) - (((bArr[i10 - i4] & 255) + (bArr2[i10] & 255)) / 2);
            bArr4[i10] = (byte) i11;
            iAbs += abs(i11);
            i10++;
            i6 = i6;
        }
        int i12 = i6;
        iArr[3] = iAbs;
        char c = 4;
        byte[] bArr5 = bArr3[4];
        int i13 = i4;
        int iAbs2 = i12;
        while (i13 < i5) {
            int i14 = i13 - i4;
            int iPaethPredictor = (bArr[i13] & 255) - paethPredictor(bArr[i14] & 255, bArr2[i13] & 255, bArr2[i14] & 255);
            bArr5[i13] = (byte) iPaethPredictor;
            iAbs2 += abs(iPaethPredictor);
            i13++;
            c = c;
        }
        iArr[c] = iAbs2;
        int i15 = iArr[i12];
        int i16 = i12;
        for (int i17 = 1; i17 < 5; i17++) {
            int i18 = iArr[i17];
            if (i18 < i15) {
                i16 = i17;
                i15 = i18;
            }
        }
        if (i16 == 0) {
            System.arraycopy(bArr, i4, bArr3[i12], i4, i2);
        }
        return i16;
    }

    public final int paethPredictor(int i, int i2, int i4) {
        int i5 = (i + i2) - i4;
        int iAbs = abs(i5 - i);
        int iAbs2 = abs(i5 - i2);
        int iAbs3 = abs(i5 - i4);
        return (iAbs > iAbs2 || iAbs > iAbs3) ? iAbs2 <= iAbs3 ? i2 : i4 : i;
    }
}
