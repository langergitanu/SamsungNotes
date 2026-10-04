package io.netty.handler.codec.compression;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2BlockDecompressor {
    private final int blockCRC;
    private final boolean blockRandomised;
    private final byte[] bwtBlock;
    private int bwtBlockLength;
    private int bwtBytesDecoded;
    private int bwtCurrentMergedPointer;
    private int[] bwtMergedPointers;
    private final int bwtStartPointer;
    int huffmanEndOfBlockSymbol;
    int huffmanInUse16;
    private int mtfValue;
    private int randomIndex;
    private final Bzip2BitReader reader;
    private int repeatCount;
    private int rleAccumulator;
    private int rleRepeat;
    private final Crc32 crc = new Crc32();
    final byte[] huffmanSymbolMap = new byte[256];
    private final int[] bwtByteCounts = new int[256];
    private int rleLastDecodedByte = -1;
    private int randomCount = Bzip2Rand.rNums(0) - 1;
    private final Bzip2MoveToFrontTable symbolMTF = new Bzip2MoveToFrontTable();
    private int repeatIncrement = 1;

    public Bzip2BlockDecompressor(int i, int i2, boolean z, int i4, Bzip2BitReader bzip2BitReader) {
        this.bwtBlock = new byte[i];
        this.blockCRC = i2;
        this.blockRandomised = z;
        this.bwtStartPointer = i4;
        this.reader = bzip2BitReader;
    }

    private int decodeNextBWTByte() {
        int i = this.bwtCurrentMergedPointer;
        int i2 = i & 255;
        this.bwtCurrentMergedPointer = this.bwtMergedPointers[i >>> 8];
        if (this.blockRandomised) {
            int i4 = this.randomCount - 1;
            this.randomCount = i4;
            if (i4 == 0) {
                i2 ^= 1;
                int i5 = (this.randomIndex + 1) % 512;
                this.randomIndex = i5;
                this.randomCount = Bzip2Rand.rNums(i5);
            }
        }
        this.bwtBytesDecoded++;
        return i2;
    }

    private void initialiseInverseBWT() {
        int i = this.bwtStartPointer;
        byte[] bArr = this.bwtBlock;
        int i2 = this.bwtBlockLength;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[256];
        if (i < 0 || i >= i2) {
            throw new DecompressionException("start pointer invalid");
        }
        System.arraycopy(this.bwtByteCounts, 0, iArr2, 1, 255);
        for (int i4 = 2; i4 <= 255; i4++) {
            iArr2[i4] = iArr2[i4] + iArr2[i4 - 1];
        }
        for (int i5 = 0; i5 < this.bwtBlockLength; i5++) {
            int i6 = bArr[i5] & 255;
            int i7 = iArr2[i6];
            iArr2[i6] = i7 + 1;
            iArr[i7] = (i5 << 8) + i6;
        }
        this.bwtMergedPointers = iArr;
        this.bwtCurrentMergedPointer = iArr[i];
    }

    public int blockLength() {
        return this.bwtBlockLength;
    }

    public int checkCRC() {
        int crc = this.crc.getCRC();
        if (this.blockCRC == crc) {
            return crc;
        }
        throw new DecompressionException("block CRC error");
    }

    public boolean decodeHuffmanData(Bzip2HuffmanStageDecoder bzip2HuffmanStageDecoder) {
        Bzip2BitReader bzip2BitReader = this.reader;
        byte[] bArr = this.bwtBlock;
        byte[] bArr2 = this.huffmanSymbolMap;
        int length = bArr.length;
        int i = this.huffmanEndOfBlockSymbol;
        int[] iArr = this.bwtByteCounts;
        Bzip2MoveToFrontTable bzip2MoveToFrontTable = this.symbolMTF;
        int i2 = this.bwtBlockLength;
        int i4 = this.repeatCount;
        int i5 = this.repeatIncrement;
        int iIndexToFront = this.mtfValue;
        while (bzip2BitReader.hasReadableBits(23)) {
            int iNextSymbol = bzip2HuffmanStageDecoder.nextSymbol();
            if (iNextSymbol == 0) {
                i4 += i5;
                i5 <<= 1;
            } else if (iNextSymbol == 1) {
                i5 <<= 1;
                i4 += i5;
            } else {
                if (i4 > 0) {
                    if (i2 + i4 > length) {
                        throw new DecompressionException("block exceeds declared block size");
                    }
                    byte b = bArr2[iIndexToFront];
                    int i6 = b & 255;
                    iArr[i6] = iArr[i6] + i4;
                    while (true) {
                        i4--;
                        if (i4 < 0) {
                            break;
                        }
                        bArr[i2] = b;
                        i2++;
                    }
                    i4 = 0;
                    i5 = 1;
                }
                if (iNextSymbol == i) {
                    if (i2 > 900000) {
                        throw new DecompressionException(AbstractC0541b.m767i(i2, "block length exceeds max block length: ", " > 900000"));
                    }
                    this.bwtBlockLength = i2;
                    initialiseInverseBWT();
                    return true;
                }
                if (i2 >= length) {
                    throw new DecompressionException("block exceeds declared block size");
                }
                iIndexToFront = bzip2MoveToFrontTable.indexToFront(iNextSymbol - 1) & 255;
                byte b5 = bArr2[iIndexToFront];
                int i7 = b5 & 255;
                iArr[i7] = iArr[i7] + 1;
                bArr[i2] = b5;
                i2++;
            }
        }
        this.bwtBlockLength = i2;
        this.repeatCount = i4;
        this.repeatIncrement = i5;
        this.mtfValue = iIndexToFront;
        return false;
    }

    public int read() {
        while (true) {
            int i = this.rleRepeat;
            if (i >= 1) {
                this.rleRepeat = i - 1;
                return this.rleLastDecodedByte;
            }
            if (this.bwtBytesDecoded == this.bwtBlockLength) {
                return -1;
            }
            int iDecodeNextBWTByte = decodeNextBWTByte();
            if (iDecodeNextBWTByte != this.rleLastDecodedByte) {
                this.rleLastDecodedByte = iDecodeNextBWTByte;
                this.rleRepeat = 1;
                this.rleAccumulator = 1;
                this.crc.updateCRC(iDecodeNextBWTByte);
            } else {
                int i2 = this.rleAccumulator + 1;
                this.rleAccumulator = i2;
                if (i2 == 4) {
                    int iDecodeNextBWTByte2 = decodeNextBWTByte() + 1;
                    this.rleRepeat = iDecodeNextBWTByte2;
                    this.rleAccumulator = 0;
                    this.crc.updateCRC(iDecodeNextBWTByte, iDecodeNextBWTByte2);
                } else {
                    this.rleRepeat = 1;
                    this.crc.updateCRC(iDecodeNextBWTByte);
                }
            }
        }
    }
}
