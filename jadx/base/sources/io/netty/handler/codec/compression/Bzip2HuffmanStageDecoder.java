package io.netty.handler.codec.compression;

import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2HuffmanStageDecoder {
    final int alphabetSize;
    private final int[][] codeBases;
    private final int[][] codeLimits;
    private final int[][] codeSymbols;
    int currentAlpha;
    int currentGroup;
    int currentSelector;
    private int currentTable;
    private final int[] minimumLengths;
    boolean modifyLength;
    private final Bzip2BitReader reader;
    byte[] selectors;
    final byte[][] tableCodeLengths;
    final int totalTables;
    private int groupIndex = -1;
    private int groupPosition = -1;
    final Bzip2MoveToFrontTable tableMTF = new Bzip2MoveToFrontTable();
    int currentLength = -1;

    public Bzip2HuffmanStageDecoder(Bzip2BitReader bzip2BitReader, int i, int i2) {
        this.reader = bzip2BitReader;
        this.totalTables = i;
        this.alphabetSize = i2;
        this.minimumLengths = new int[i];
        Class cls = Integer.TYPE;
        this.codeBases = (int[][]) Array.newInstance((Class<?>) cls, i, 25);
        this.codeLimits = (int[][]) Array.newInstance((Class<?>) cls, i, 24);
        this.codeSymbols = (int[][]) Array.newInstance((Class<?>) cls, i, SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK);
        this.tableCodeLengths = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK);
    }

    public void createHuffmanDecodingTables() {
        int i = this.alphabetSize;
        int i2 = 0;
        while (true) {
            byte[][] bArr = this.tableCodeLengths;
            if (i2 >= bArr.length) {
                this.currentTable = this.selectors[0];
                return;
            }
            int[] iArr = this.codeBases[i2];
            int[] iArr2 = this.codeLimits[i2];
            int[] iArr3 = this.codeSymbols[i2];
            byte[] bArr2 = bArr[i2];
            int iMin = 23;
            int iMax = 0;
            for (int i4 = 0; i4 < i; i4++) {
                byte b = bArr2[i4];
                iMax = Math.max((int) b, iMax);
                iMin = Math.min((int) b, iMin);
            }
            this.minimumLengths[i2] = iMin;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = bArr2[i5] + 1;
                iArr[i6] = iArr[i6] + 1;
            }
            int i7 = iArr[0];
            for (int i8 = 1; i8 < 25; i8++) {
                i7 += iArr[i8];
                iArr[i8] = i7;
            }
            int i9 = 0;
            int i10 = iMin;
            while (i10 <= iMax) {
                int i11 = i10 + 1;
                int i12 = iArr[i11];
                int i13 = iArr[i10];
                int i14 = (i12 - i13) + i9;
                iArr[i10] = i9 - i13;
                iArr2[i10] = i14 - 1;
                i9 = i14 << 1;
                i10 = i11;
            }
            int i15 = 0;
            while (iMin <= iMax) {
                for (int i16 = 0; i16 < i; i16++) {
                    if (bArr2[i16] == iMin) {
                        iArr3[i15] = i16;
                        i15++;
                    }
                }
                iMin++;
            }
            i2++;
        }
    }

    public int nextSymbol() {
        int i = this.groupPosition + 1;
        this.groupPosition = i;
        if (i % 50 == 0) {
            int i2 = this.groupIndex + 1;
            this.groupIndex = i2;
            byte[] bArr = this.selectors;
            if (i2 == bArr.length) {
                throw new DecompressionException("error decoding block");
            }
            this.currentTable = bArr[i2] & 255;
        }
        Bzip2BitReader bzip2BitReader = this.reader;
        int i4 = this.currentTable;
        int[] iArr = this.codeLimits[i4];
        int[] iArr2 = this.codeBases[i4];
        int[] iArr3 = this.codeSymbols[i4];
        int i5 = this.minimumLengths[i4];
        int bits = bzip2BitReader.readBits(i5);
        while (i5 <= 23) {
            if (bits <= iArr[i5]) {
                return iArr3[bits - iArr2[i5]];
            }
            bits = (bits << 1) | bzip2BitReader.readBits(1);
            i5++;
        }
        throw new DecompressionException("a valid code was not recognised");
    }
}
