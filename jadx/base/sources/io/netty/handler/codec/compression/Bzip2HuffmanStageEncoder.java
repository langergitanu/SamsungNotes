package io.netty.handler.codec.compression;

import androidx.core.app.FrameMetricsAggregator;
import io.netty.buffer.ByteBuf;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2HuffmanStageEncoder {
    private static final int HUFFMAN_HIGH_SYMBOL_COST = 15;
    private final int[][] huffmanCodeLengths;
    private final int[][] huffmanMergedCodeSymbols;
    private final int mtfAlphabetSize;
    private final char[] mtfBlock;
    private final int mtfLength;
    private final int[] mtfSymbolFrequencies;
    private final byte[] selectors;
    private final Bzip2BitWriter writer;

    public Bzip2HuffmanStageEncoder(Bzip2BitWriter bzip2BitWriter, char[] cArr, int i, int i2, int[] iArr) {
        this.writer = bzip2BitWriter;
        this.mtfBlock = cArr;
        this.mtfLength = i;
        this.mtfAlphabetSize = i2;
        this.mtfSymbolFrequencies = iArr;
        int iSelectTableCount = selectTableCount(i);
        Class cls = Integer.TYPE;
        this.huffmanCodeLengths = (int[][]) Array.newInstance((Class<?>) cls, iSelectTableCount, i2);
        this.huffmanMergedCodeSymbols = (int[][]) Array.newInstance((Class<?>) cls, iSelectTableCount, i2);
        this.selectors = new byte[(i + 49) / 50];
    }

    private void assignHuffmanCodeSymbols() {
        int[][] iArr = this.huffmanMergedCodeSymbols;
        int[][] iArr2 = this.huffmanCodeLengths;
        int i = this.mtfAlphabetSize;
        int length = iArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            int[] iArr3 = iArr2[i2];
            int i4 = 32;
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                int i7 = iArr3[i6];
                if (i7 > i5) {
                    i5 = i7;
                }
                if (i7 < i4) {
                    i4 = i7;
                }
            }
            int i8 = 0;
            while (i4 <= i5) {
                for (int i9 = 0; i9 < i; i9++) {
                    if ((iArr2[i2][i9] & 255) == i4) {
                        iArr[i2][i9] = (i4 << 24) | i8;
                        i8++;
                    }
                }
                i8 <<= 1;
                i4++;
            }
        }
    }

    private static void generateHuffmanCodeLengths(int i, int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[i];
        int[] iArr4 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr3[i2] = (iArr[i2] << 9) | i2;
        }
        Arrays.sort(iArr3);
        for (int i4 = 0; i4 < i; i4++) {
            iArr4[i4] = iArr3[i4] >>> 9;
        }
        Bzip2HuffmanAllocator.allocateHuffmanCodeLengths(iArr4, 20);
        for (int i5 = 0; i5 < i; i5++) {
            iArr2[iArr3[i5] & FrameMetricsAggregator.EVERY_DURATION] = iArr4[i5];
        }
    }

    private void generateHuffmanOptimisationSeeds() {
        int[][] iArr = this.huffmanCodeLengths;
        int[] iArr2 = this.mtfSymbolFrequencies;
        int i = this.mtfAlphabetSize;
        int length = iArr.length;
        int i2 = this.mtfLength;
        int i4 = -1;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = length - i5;
            int i7 = i2 / i6;
            int i8 = i4 + 1;
            int i9 = 0;
            while (i9 < i7 && i4 < i - 1) {
                i4++;
                i9 += iArr2[i4];
            }
            if (i4 > i8 && i5 != 0 && i5 != length - 1 && (i6 & 1) == 0) {
                i9 -= iArr2[i4];
                i4--;
            }
            int[] iArr3 = iArr[i5];
            for (int i10 = 0; i10 < i; i10++) {
                if (i10 < i8 || i10 > i4) {
                    iArr3[i10] = 15;
                }
            }
            i2 -= i9;
        }
    }

    private void optimiseSelectorsAndHuffmanTables(boolean z) {
        char[] cArr = this.mtfBlock;
        byte[] bArr = this.selectors;
        int[][] iArr = this.huffmanCodeLengths;
        int i = this.mtfLength;
        int i2 = this.mtfAlphabetSize;
        int length = iArr.length;
        byte b = 1;
        byte b5 = 0;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, i2);
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            int iMin = Math.min(i4 + 50, i);
            int i6 = iMin - 1;
            int[] iArr3 = new int[length];
            int i7 = i4;
            while (i7 <= i6) {
                char c = cArr[i7];
                byte b6 = b;
                for (int i8 = b5; i8 < length; i8++) {
                    iArr3[i8] = iArr3[i8] + iArr[i8][c];
                }
                i7++;
                b = b6;
            }
            byte b7 = b;
            int i9 = iArr3[b5];
            byte b8 = b5;
            for (byte b9 = b7; b9 < length; b9 = (byte) (b9 + 1)) {
                int i10 = iArr3[b9];
                if (i10 < i9) {
                    i9 = i10;
                    b8 = b9;
                }
            }
            int[] iArr4 = iArr2[b8];
            while (i4 <= i6) {
                char c2 = cArr[i4];
                iArr4[c2] = iArr4[c2] + 1;
                i4++;
            }
            if (z) {
                bArr[i5] = b8;
                i5++;
            }
            i4 = iMin;
            b = b7;
            b5 = 0;
        }
        for (int i11 = 0; i11 < length; i11++) {
            generateHuffmanCodeLengths(i2, iArr2[i11], iArr[i11]);
        }
    }

    private static int selectTableCount(int i) {
        if (i >= 2400) {
            return 6;
        }
        if (i >= 1200) {
            return 5;
        }
        if (i >= 600) {
            return 4;
        }
        return i >= 200 ? 3 : 2;
    }

    private void writeBlockData(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        int[][] iArr = this.huffmanMergedCodeSymbols;
        byte[] bArr = this.selectors;
        int i = this.mtfLength;
        int i2 = 0;
        int i4 = 0;
        while (i2 < i) {
            int iMin = Math.min(i2 + 50, i) - 1;
            int i5 = i4 + 1;
            int[] iArr2 = iArr[bArr[i4]];
            while (i2 <= iMin) {
                int i6 = i2 + 1;
                int i7 = iArr2[this.mtfBlock[i2]];
                bzip2BitWriter.writeBits(byteBuf, i7 >>> 24, i7);
                i2 = i6;
            }
            i4 = i5;
        }
    }

    private void writeSelectorsAndHuffmanTables(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        byte[] bArr = this.selectors;
        int length = bArr.length;
        int[][] iArr = this.huffmanCodeLengths;
        int length2 = iArr.length;
        int i = this.mtfAlphabetSize;
        long j = length2;
        int i2 = 3;
        bzip2BitWriter.writeBits(byteBuf, 3, j);
        bzip2BitWriter.writeBits(byteBuf, 15, length);
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = new Bzip2MoveToFrontTable();
        for (byte b : bArr) {
            bzip2BitWriter.writeUnary(byteBuf, bzip2MoveToFrontTable.valueToFront(b));
        }
        int length3 = iArr.length;
        int i4 = 0;
        while (i4 < length3) {
            int[] iArr2 = iArr[i4];
            int i5 = iArr2[0];
            bzip2BitWriter.writeBits(byteBuf, 5, i5);
            int i6 = 0;
            while (i6 < i) {
                int i7 = iArr2[i6];
                int i8 = i5 < i7 ? 2 : i2;
                int iAbs = Math.abs(i7 - i5);
                while (true) {
                    int i9 = iAbs - 1;
                    if (iAbs > 0) {
                        bzip2BitWriter.writeBits(byteBuf, 2, i8);
                        i = i;
                        iAbs = i9;
                    }
                }
                bzip2BitWriter.writeBoolean(byteBuf, false);
                i6++;
                i5 = i7;
                i2 = 3;
            }
            i4++;
            i2 = 3;
        }
    }

    public void encode(ByteBuf byteBuf) {
        generateHuffmanOptimisationSeeds();
        int i = 3;
        while (i >= 0) {
            optimiseSelectorsAndHuffmanTables(i == 0);
            i--;
        }
        assignHuffmanCodeSymbols();
        writeSelectorsAndHuffmanTables(byteBuf);
        writeBlockData(byteBuf);
    }
}
