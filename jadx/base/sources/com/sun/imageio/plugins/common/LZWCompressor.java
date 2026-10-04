package com.sun.imageio.plugins.common;

import java.io.PrintStream;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LZWCompressor {

    /* JADX INFO: renamed from: bf */
    BitFile f8275bf;
    int clearCode;
    int codeSize;
    int endOfInfo;
    int limit;
    LZWStringTable lzss;
    int numBits;
    short prefix;
    boolean tiffFudge;

    public LZWCompressor(ImageOutputStream imageOutputStream, int i, boolean z) {
        this.f8275bf = new BitFile(imageOutputStream, !z);
        this.codeSize = i;
        this.tiffFudge = z;
        int i2 = 1 << i;
        this.clearCode = i2;
        this.endOfInfo = i2 + 1;
        int i4 = i + 1;
        this.numBits = i4;
        int i5 = 1 << i4;
        this.limit = i5 - 1;
        if (z) {
            this.limit = i5 - 2;
        }
        this.prefix = (short) -1;
        LZWStringTable lZWStringTable = new LZWStringTable();
        this.lzss = lZWStringTable;
        lZWStringTable.clearTable(i);
        this.f8275bf.writeBits(this.clearCode, this.numBits);
    }

    public void compress(byte[] bArr, int i, int i2) {
        int i4 = i2 + i;
        while (i < i4) {
            byte b = bArr[i];
            short sFindCharString = this.lzss.findCharString(this.prefix, b);
            if (sFindCharString != -1) {
                this.prefix = sFindCharString;
            } else {
                this.f8275bf.writeBits(this.prefix, this.numBits);
                if (this.lzss.addCharString(this.prefix, b) > this.limit) {
                    int i5 = this.numBits;
                    if (i5 == 12) {
                        this.f8275bf.writeBits(this.clearCode, i5);
                        this.lzss.clearTable(this.codeSize);
                        this.numBits = this.codeSize + 1;
                    } else {
                        this.numBits = i5 + 1;
                    }
                    int i6 = 1 << this.numBits;
                    this.limit = i6 - 1;
                    if (this.tiffFudge) {
                        this.limit = i6 - 2;
                    }
                }
                this.prefix = (short) (b & 255);
            }
            i++;
        }
    }

    public void dump(PrintStream printStream) {
        this.lzss.dump(printStream);
    }

    public void flush() {
        short s = this.prefix;
        if (s != -1) {
            this.f8275bf.writeBits(s, this.numBits);
        }
        this.f8275bf.writeBits(this.endOfInfo, this.numBits);
        this.f8275bf.flush();
    }
}
