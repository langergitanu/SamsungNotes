package com.sun.imageio.plugins.common;

import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BitFile {
    boolean blocks;
    ImageOutputStream output;
    byte[] buffer = new byte[256];
    int index = 0;
    int bitsLeft = 8;

    public BitFile(ImageOutputStream imageOutputStream, boolean z) {
        this.output = imageOutputStream;
        this.blocks = z;
    }

    public void flush() {
        int i = this.index + (this.bitsLeft == 8 ? 0 : 1);
        if (i > 0) {
            if (this.blocks) {
                this.output.write(i);
            }
            this.output.write(this.buffer, 0, i);
            this.buffer[0] = 0;
            this.index = 0;
            this.bitsLeft = 8;
        }
    }

    public void writeBits(int i, int i2) {
        do {
            int i4 = this.index;
            if ((i4 == 254 && this.bitsLeft == 0) || i4 > 254) {
                if (this.blocks) {
                    this.output.write(255);
                }
                this.output.write(this.buffer, 0, 255);
                this.buffer[0] = 0;
                this.index = 0;
                this.bitsLeft = 8;
            }
            int i5 = this.bitsLeft;
            if (i2 <= i5) {
                if (this.blocks) {
                    byte[] bArr = this.buffer;
                    int i6 = this.index;
                    bArr[i6] = (byte) (((i & ((1 << i2) - 1)) << (8 - i5)) | bArr[i6]);
                    this.bitsLeft = i5 - i2;
                } else {
                    byte[] bArr2 = this.buffer;
                    int i7 = this.index;
                    bArr2[i7] = (byte) (((i & ((1 << i2) - 1)) << (i5 - i2)) | bArr2[i7]);
                    this.bitsLeft = i5 - i2;
                }
                i2 = 0;
            } else if (this.blocks) {
                byte[] bArr3 = this.buffer;
                int i8 = this.index;
                bArr3[i8] = (byte) (bArr3[i8] | ((((1 << i5) - 1) & i) << (8 - i5)));
                i >>= i5;
                i2 -= i5;
                int i9 = i8 + 1;
                this.index = i9;
                bArr3[i9] = 0;
                this.bitsLeft = 8;
            } else {
                byte[] bArr4 = this.buffer;
                int i10 = this.index;
                bArr4[i10] = (byte) (((i >>> (i2 - i5)) & ((1 << i5) - 1)) | bArr4[i10]);
                i2 -= i5;
                int i11 = i10 + 1;
                this.index = i11;
                bArr4[i11] = 0;
                this.bitsLeft = 8;
            }
        } while (i2 != 0);
    }
}
