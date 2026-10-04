package io.netty.handler.codec.compression;

import androidx.slidingpanelayout.widget.SlidingPaneLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2MTFAndRLE2StageEncoder {
    private int alphabetSize;
    private final int[] bwtBlock;
    private final int bwtLength;
    private final boolean[] bwtValuesPresent;
    private final char[] mtfBlock;
    private int mtfLength;
    private final int[] mtfSymbolFrequencies = new int[SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK];

    public Bzip2MTFAndRLE2StageEncoder(int[] iArr, int i, boolean[] zArr) {
        this.bwtBlock = iArr;
        this.bwtLength = i;
        this.bwtValuesPresent = zArr;
        this.mtfBlock = new char[i + 1];
    }

    public void encode() {
        char c;
        int i;
        int i2;
        int i4 = this.bwtLength;
        boolean[] zArr = this.bwtValuesPresent;
        int[] iArr = this.bwtBlock;
        char[] cArr = this.mtfBlock;
        int[] iArr2 = this.mtfSymbolFrequencies;
        byte[] bArr = new byte[256];
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            if (zArr[i6]) {
                bArr[i6] = (byte) i5;
                i5++;
            }
        }
        int i7 = i5 + 1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i4; i12++) {
            int iValueToFront = bzip2MoveToFrontTable.valueToFront(bArr[iArr[i12] & 255]);
            if (iValueToFront == 0) {
                i8++;
            } else {
                if (i8 > 0) {
                    int i13 = i8 - 1;
                    while (true) {
                        if ((i13 & 1) == 0) {
                            i2 = i9 + 1;
                            cArr[i9] = 0;
                            i10++;
                        } else {
                            i2 = i9 + 1;
                            cArr[i9] = 1;
                            i11++;
                        }
                        i9 = i2;
                        if (i13 <= 1) {
                            break;
                        } else {
                            i13 = (i13 - 2) >>> 1;
                        }
                    }
                    i8 = 0;
                }
                int i14 = iValueToFront + 1;
                cArr[i9] = (char) i14;
                iArr2[i14] = iArr2[i14] + 1;
                i9++;
            }
        }
        char c2 = 1;
        if (i8 > 0) {
            int i15 = i8 - 1;
            while (true) {
                if ((i15 & 1) == 0) {
                    i = i9 + 1;
                    cArr[i9] = 0;
                    i10++;
                } else {
                    i = i9 + 1;
                    cArr[i9] = c2;
                    i11++;
                }
                i9 = i;
                c = c2;
                if (i15 <= c) {
                    break;
                }
                i15 = (i15 - 2) >>> c;
                c2 = c;
            }
        } else {
            c = 1;
        }
        cArr[i9] = (char) i7;
        iArr2[i7] = iArr2[i7] + c;
        iArr2[0] = iArr2[0] + i10;
        iArr2[c] = iArr2[c] + i11;
        this.mtfLength = i9 + c;
        this.alphabetSize = i5 + 2;
    }

    public int mtfAlphabetSize() {
        return this.alphabetSize;
    }

    public char[] mtfBlock() {
        return this.mtfBlock;
    }

    public int mtfLength() {
        return this.mtfLength;
    }

    public int[] mtfSymbolFrequencies() {
        return this.mtfSymbolFrequencies;
    }
}
