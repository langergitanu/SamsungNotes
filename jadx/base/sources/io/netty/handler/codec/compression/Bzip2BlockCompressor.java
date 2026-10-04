package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.util.ByteProcessor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class Bzip2BlockCompressor {
    private final byte[] block;
    private int blockLength;
    private final int blockLengthLimit;
    private final int[] bwtBlock;
    private int rleLength;
    private final Bzip2BitWriter writer;
    private final ByteProcessor writeProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.Bzip2BlockCompressor.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            return Bzip2BlockCompressor.this.write(b);
        }
    };
    private final Crc32 crc = new Crc32();
    private final boolean[] blockValuesPresent = new boolean[256];
    private int rleCurrentValue = -1;

    public Bzip2BlockCompressor(Bzip2BitWriter bzip2BitWriter, int i) {
        this.writer = bzip2BitWriter;
        int i2 = i + 1;
        this.block = new byte[i2];
        this.bwtBlock = new int[i2];
        this.blockLengthLimit = i - 6;
    }

    private void writeRun(int i, int i2) {
        int i4 = this.blockLength;
        byte[] bArr = this.block;
        this.blockValuesPresent[i] = true;
        this.crc.updateCRC(i, i2);
        byte b = (byte) i;
        if (i2 == 1) {
            bArr[i4] = b;
            this.blockLength = i4 + 1;
            return;
        }
        if (i2 == 2) {
            bArr[i4] = b;
            bArr[i4 + 1] = b;
            this.blockLength = i4 + 2;
        } else {
            if (i2 == 3) {
                bArr[i4] = b;
                bArr[i4 + 1] = b;
                bArr[i4 + 2] = b;
                this.blockLength = i4 + 3;
                return;
            }
            int i5 = i2 - 4;
            this.blockValuesPresent[i5] = true;
            bArr[i4] = b;
            bArr[i4 + 1] = b;
            bArr[i4 + 2] = b;
            bArr[i4 + 3] = b;
            bArr[i4 + 4] = (byte) i5;
            this.blockLength = i4 + 5;
        }
    }

    private void writeSymbolMap(ByteBuf byteBuf) {
        Bzip2BitWriter bzip2BitWriter = this.writer;
        boolean[] zArr = this.blockValuesPresent;
        boolean[] zArr2 = new boolean[16];
        for (int i = 0; i < 16; i++) {
            int i2 = i << 4;
            int i4 = 0;
            while (true) {
                if (i4 >= 16) {
                    break;
                }
                if (zArr[i2]) {
                    zArr2[i] = true;
                    break;
                } else {
                    i4++;
                    i2++;
                }
            }
        }
        for (int i5 = 0; i5 < 16; i5++) {
            bzip2BitWriter.writeBoolean(byteBuf, zArr2[i5]);
        }
        for (int i6 = 0; i6 < 16; i6++) {
            if (zArr2[i6]) {
                int i7 = i6 << 4;
                int i8 = 0;
                while (i8 < 16) {
                    bzip2BitWriter.writeBoolean(byteBuf, zArr[i7]);
                    i8++;
                    i7++;
                }
            }
        }
    }

    public int availableSize() {
        int i = this.blockLength;
        return i == 0 ? this.blockLengthLimit + 2 : (this.blockLengthLimit - i) + 1;
    }

    public void close(ByteBuf byteBuf) {
        int i = this.rleLength;
        if (i > 0) {
            writeRun(this.rleCurrentValue & 255, i);
        }
        byte[] bArr = this.block;
        int i2 = this.blockLength;
        bArr[i2] = bArr[0];
        int iBwt = new Bzip2DivSufSort(bArr, this.bwtBlock, i2).bwt();
        Bzip2BitWriter bzip2BitWriter = this.writer;
        bzip2BitWriter.writeBits(byteBuf, 24, 3227993L);
        bzip2BitWriter.writeBits(byteBuf, 24, 2511705L);
        bzip2BitWriter.writeInt(byteBuf, this.crc.getCRC());
        bzip2BitWriter.writeBoolean(byteBuf, false);
        bzip2BitWriter.writeBits(byteBuf, 24, iBwt);
        writeSymbolMap(byteBuf);
        Bzip2MTFAndRLE2StageEncoder bzip2MTFAndRLE2StageEncoder = new Bzip2MTFAndRLE2StageEncoder(this.bwtBlock, this.blockLength, this.blockValuesPresent);
        bzip2MTFAndRLE2StageEncoder.encode();
        new Bzip2HuffmanStageEncoder(bzip2BitWriter, bzip2MTFAndRLE2StageEncoder.mtfBlock(), bzip2MTFAndRLE2StageEncoder.mtfLength(), bzip2MTFAndRLE2StageEncoder.mtfAlphabetSize(), bzip2MTFAndRLE2StageEncoder.mtfSymbolFrequencies()).encode(byteBuf);
    }

    public int crc() {
        return this.crc.getCRC();
    }

    public boolean isEmpty() {
        return this.blockLength == 0 && this.rleLength == 0;
    }

    public boolean isFull() {
        return this.blockLength > this.blockLengthLimit;
    }

    public boolean write(int i) {
        if (this.blockLength > this.blockLengthLimit) {
            return false;
        }
        int i2 = this.rleCurrentValue;
        int i4 = this.rleLength;
        if (i4 == 0) {
            this.rleCurrentValue = i;
            this.rleLength = 1;
        } else if (i2 != i) {
            writeRun(i2 & 255, i4);
            this.rleCurrentValue = i;
            this.rleLength = 1;
        } else if (i4 == 254) {
            writeRun(i2 & 255, 255);
            this.rleLength = 0;
        } else {
            this.rleLength = i4 + 1;
        }
        return true;
    }

    public int write(ByteBuf byteBuf, int i, int i2) {
        int iForEachByte = byteBuf.forEachByte(i, i2, this.writeProcessor);
        return iForEachByte == -1 ? i2 : iForEachByte - i;
    }
}
