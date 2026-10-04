package com.sun.imageio.plugins.bmp;

import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.sun.imageio.plugins.common.I18N;
import com.sun.imageio.plugins.common.ImageUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Iterator;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.BandedSampleModel;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.ComponentSampleModel;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.DataBufferShort;
import org.apache.poi.java.awt.image.DataBufferUShort;
import org.apache.poi.java.awt.image.DirectColorModel;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.MultiPixelPackedSampleModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.javax.imageio.IIOImage;
import org.apache.poi.javax.imageio.ImageIO;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriteParam;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.event.IIOWriteProgressListener;
import org.apache.poi.javax.imageio.event.IIOWriteWarningListener;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.plugins.bmp.BMPImageWriteParam;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BMPImageWriter extends ImageWriter implements BMPConstants {
    private int[] bitMasks;
    private int[] bitPos;
    private byte[] bpixels;
    private int compImageSize;
    private int compressionType;
    private ByteArrayOutputStream embedded_stream;

    /* JADX INFO: renamed from: h */
    private int f8273h;
    private int[] ipixels;
    private boolean isTopDown;
    private short[] spixels;
    private ImageOutputStream stream;
    private int version;

    /* JADX INFO: renamed from: w */
    private int f8274w;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class IIOWriteProgressAdapter implements IIOWriteProgressListener {
        private IIOWriteProgressAdapter() {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOWriteProgressListener
        public void imageComplete(ImageWriter imageWriter) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOWriteProgressListener
        public void imageProgress(ImageWriter imageWriter, float f) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOWriteProgressListener
        public void imageStarted(ImageWriter imageWriter, int i) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOWriteProgressListener
        public void thumbnailComplete(ImageWriter imageWriter) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOWriteProgressListener
        public void thumbnailProgress(ImageWriter imageWriter, float f) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOWriteProgressListener
        public void thumbnailStarted(ImageWriter imageWriter, int i, int i2) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOWriteProgressListener
        public void writeAborted(ImageWriter imageWriter) {
        }
    }

    public BMPImageWriter(ImageWriterSpi imageWriterSpi) {
        super(imageWriterSpi);
        this.stream = null;
        this.embedded_stream = null;
        this.compImageSize = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01bd A[PHI: r9 r11
      0x01bd: PHI (r9v6 int) = (r9v3 int), (r9v4 int), (r9v4 int), (r9v4 int), (r9v9 int) binds: [B:62:0x01d3, B:77:0x0238, B:74:0x022b, B:75:0x022d, B:58:0x019a] A[DONT_GENERATE, DONT_INLINE]
      0x01bd: PHI (r11v9 int) = (r11v6 int), (r11v7 int), (r11v7 int), (r11v7 int), (r11v6 int) binds: [B:62:0x01d3, B:77:0x0238, B:74:0x022b, B:75:0x022d, B:58:0x019a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void encodeRLE4(byte[] bArr, int i) {
        int i2;
        char c;
        int i4;
        int i5;
        int i6;
        byte[] bArr2 = new byte[256];
        byte b = bArr[0];
        byte b5 = bArr[1];
        int i7 = 2;
        int i8 = 1;
        int i9 = 2;
        int i10 = -1;
        while (true) {
            int i11 = i - 2;
            if (i8 >= i11) {
                return;
            }
            byte b6 = bArr[i8 + 1];
            int i12 = i8 + 2;
            byte b7 = bArr[i12];
            if (b6 == b) {
                if (i10 >= 4) {
                    this.stream.writeByte(0);
                    i2 = 4;
                    int i13 = i10 - 1;
                    this.stream.writeByte(i13);
                    incCompImageSize(i7);
                    int i14 = 0;
                    while (true) {
                        i6 = i10 - 2;
                        if (i14 >= i6) {
                            break;
                        }
                        this.stream.writeByte((byte) ((bArr2[i14] << 4) | bArr2[i14 + 1]));
                        incCompImageSize(1);
                        i14 += 2;
                    }
                    if (!isEven(i13)) {
                        this.stream.writeByte(bArr2[i6] << 4);
                        incCompImageSize(1);
                    }
                    if (!isEven((int) Math.ceil(i13 / 2))) {
                        this.stream.writeByte(0);
                        incCompImageSize(1);
                    }
                } else {
                    i2 = 4;
                    if (i10 > -1) {
                        this.stream.writeByte(2);
                        this.stream.writeByte((bArr2[0] << 4) | bArr2[1]);
                        incCompImageSize(2);
                    }
                }
                if (b7 == b5) {
                    int i15 = i9 + 2;
                    c = 256;
                    if (i15 == 256) {
                        this.stream.writeByte(i9 + 1);
                        this.stream.writeByte((b << 4) | b5);
                        incCompImageSize(2);
                        if (i12 < i - 1) {
                            i8 += 3;
                            b = b5;
                            i9 = 2;
                            i10 = -1;
                            b5 = bArr[i8];
                        } else {
                            this.stream.writeByte(1);
                            this.stream.writeByte(b5 << 4);
                            incCompImageSize(2);
                            i8 = i12;
                            i9 = -1;
                            i10 = -1;
                        }
                    } else {
                        i9 = i15;
                        i8 = i12;
                        i10 = -1;
                    }
                } else {
                    c = 256;
                    this.stream.writeByte(i9 + 1);
                    this.stream.writeByte((b << 4) | b5);
                    incCompImageSize(2);
                    if (i12 < i - 1) {
                        i8 += 3;
                        b5 = bArr[i8];
                        b = b7;
                        i9 = 2;
                        i10 = -1;
                    } else {
                        this.stream.writeByte(1);
                        this.stream.writeByte(b7 << 4);
                        incCompImageSize(2);
                        i8 = i12;
                        b = b7;
                        i9 = -1;
                        i10 = -1;
                    }
                }
            } else {
                i2 = 4;
                int i16 = i7;
                c = 256;
                if (i9 > i16) {
                    this.stream.writeByte(i9);
                    this.stream.writeByte((b << 4) | b5);
                    incCompImageSize(i16);
                } else if (i10 < 0) {
                    bArr2[i10 + 1] = b;
                    bArr2[i10 + 2] = b5;
                    bArr2[i10 + 3] = b6;
                    i10 += 4;
                    bArr2[i10] = b7;
                } else if (i10 < 253) {
                    bArr2[i10 + 1] = b6;
                    i10 += 2;
                    bArr2[i10] = b7;
                } else {
                    this.stream.writeByte(0);
                    this.stream.writeByte(i10 + 1);
                    incCompImageSize(2);
                    for (int i17 = 0; i17 < i10; i17 += 2) {
                        this.stream.writeByte((byte) ((bArr2[i17] << 4) | bArr2[i17 + 1]));
                        incCompImageSize(1);
                    }
                    this.stream.writeByte(0);
                    incCompImageSize(1);
                    i10 = -1;
                }
                b = b6;
                i8 = i12;
                b5 = b7;
                i9 = 2;
            }
            if (i8 >= i11) {
                int i18 = -1;
                if (i10 != -1) {
                    if (i10 <= i18) {
                        i4 = 2;
                        this.stream.writeByte(0);
                        this.stream.writeByte(0);
                        incCompImageSize(i4);
                        i7 = i4;
                    } else {
                        if (i8 == i11) {
                            i10++;
                            i8++;
                            bArr2[i10] = bArr[i8];
                        }
                        if (i10 >= 2) {
                            this.stream.writeByte(0);
                            int i19 = i10 + 1;
                            this.stream.writeByte(i19);
                            incCompImageSize(2);
                            for (int i20 = 0; i20 < i10; i20 += 2) {
                                this.stream.writeByte((byte) ((bArr2[i20] << 4) | bArr2[i20 + 1]));
                                incCompImageSize(1);
                            }
                            if (!isEven(i19)) {
                                this.stream.writeByte(bArr2[i10] << 4);
                                incCompImageSize(1);
                            }
                            if (!isEven((int) Math.ceil(i19 / 2))) {
                                this.stream.writeByte(0);
                                incCompImageSize(1);
                            }
                        } else {
                            if (i10 == 0) {
                                i4 = 2;
                                this.stream.writeByte(1);
                                this.stream.writeByte(bArr2[0] << 4);
                                incCompImageSize(2);
                            } else if (i10 == 1) {
                                i4 = 2;
                                this.stream.writeByte(2);
                                this.stream.writeByte((bArr2[0] << 4) | bArr2[1]);
                                incCompImageSize(2);
                            }
                            this.stream.writeByte(0);
                            this.stream.writeByte(0);
                            incCompImageSize(i4);
                            i7 = i4;
                        }
                        i4 = 2;
                        this.stream.writeByte(0);
                        this.stream.writeByte(0);
                        incCompImageSize(i4);
                        i7 = i4;
                    }
                } else if (i9 >= 2) {
                    if (i8 == i11) {
                        i8++;
                        if (bArr[i8] == b) {
                            i9++;
                            this.stream.writeByte(i9);
                            this.stream.writeByte((b << 4) | b5);
                            i5 = 2;
                            incCompImageSize(2);
                        } else {
                            this.stream.writeByte(i9);
                            this.stream.writeByte((b << 4) | b5);
                            this.stream.writeByte(1);
                            this.stream.writeByte(bArr[i8] << 4);
                            byte b8 = bArr[i8];
                            incCompImageSize(i2);
                            i4 = 2;
                            this.stream.writeByte(0);
                            this.stream.writeByte(0);
                            incCompImageSize(i4);
                            i7 = i4;
                        }
                    } else {
                        this.stream.writeByte(i9);
                        this.stream.writeByte((b << 4) | b5);
                        i5 = 2;
                        incCompImageSize(2);
                    }
                    i4 = i5;
                    this.stream.writeByte(0);
                    this.stream.writeByte(0);
                    incCompImageSize(i4);
                    i7 = i4;
                } else {
                    i18 = -1;
                    if (i10 <= i18) {
                    }
                }
            } else {
                i7 = 2;
            }
        }
    }

    private void encodeRLE8(byte[] bArr, int i) {
        byte b = bArr[0];
        byte[] bArr2 = new byte[256];
        int i2 = 0;
        int i4 = 1;
        int i5 = -1;
        while (true) {
            int i6 = i - 1;
            if (i2 >= i6) {
                return;
            }
            i2++;
            byte b5 = bArr[i2];
            if (b5 == b) {
                if (i5 >= 3) {
                    this.stream.writeByte(0);
                    this.stream.writeByte(i5);
                    incCompImageSize(2);
                    for (int i7 = 0; i7 < i5; i7++) {
                        this.stream.writeByte(bArr2[i7]);
                        incCompImageSize(1);
                    }
                    if (!isEven(i5)) {
                        this.stream.writeByte(0);
                        incCompImageSize(1);
                    }
                } else if (i5 > -1) {
                    for (int i8 = 0; i8 < i5; i8++) {
                        this.stream.writeByte(1);
                        this.stream.writeByte(bArr2[i8]);
                        incCompImageSize(2);
                    }
                }
                int i9 = i4 + 1;
                if (i9 == 256) {
                    this.stream.writeByte(i4);
                    this.stream.writeByte(b);
                    incCompImageSize(2);
                    i4 = 1;
                } else {
                    i4 = i9;
                }
                i5 = -1;
            } else {
                if (i4 > 1) {
                    this.stream.writeByte(i4);
                    this.stream.writeByte(b);
                    incCompImageSize(2);
                } else if (i5 < 0) {
                    bArr2[i5 + 1] = b;
                    i5 += 2;
                    bArr2[i5] = b5;
                } else if (i5 < 254) {
                    i5++;
                    bArr2[i5] = b5;
                } else {
                    this.stream.writeByte(0);
                    this.stream.writeByte(i5 + 1);
                    incCompImageSize(2);
                    for (int i10 = 0; i10 <= i5; i10++) {
                        this.stream.writeByte(bArr2[i10]);
                        incCompImageSize(1);
                    }
                    this.stream.writeByte(0);
                    incCompImageSize(1);
                    i5 = -1;
                }
                i4 = 1;
                b = b5;
            }
            if (i2 == i6) {
                if (i5 == -1) {
                    this.stream.writeByte(i4);
                    this.stream.writeByte(b);
                    incCompImageSize(2);
                    i4 = 1;
                } else if (i5 >= 2) {
                    this.stream.writeByte(0);
                    int i11 = i5 + 1;
                    this.stream.writeByte(i11);
                    incCompImageSize(2);
                    for (int i12 = 0; i12 <= i5; i12++) {
                        this.stream.writeByte(bArr2[i12]);
                        incCompImageSize(1);
                    }
                    if (!isEven(i11)) {
                        this.stream.writeByte(0);
                        incCompImageSize(1);
                    }
                } else if (i5 > -1) {
                    for (int i13 = 0; i13 <= i5; i13++) {
                        this.stream.writeByte(1);
                        this.stream.writeByte(bArr2[i13]);
                        incCompImageSize(2);
                    }
                }
                this.stream.writeByte(0);
                this.stream.writeByte(0);
                incCompImageSize(2);
            }
        }
    }

    private int firstLowBit(int i) {
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    private synchronized void incCompImageSize(int i) {
        this.compImageSize += i;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private int roundBpp(int i) {
        if (i <= 8) {
            return 8;
        }
        if (i <= 16) {
            return 16;
        }
        return i <= 24 ? 24 : 32;
    }

    private void writeEmbedded(IIOImage iIOImage, ImageWriteParam imageWriteParam) {
        String str = this.compressionType == 4 ? "jpeg" : Constants.THUMBNAIL_PNG_EXTENSION;
        Iterator<ImageWriter> imageWritersByFormatName = ImageIO.getImageWritersByFormatName(str);
        ImageWriter next = imageWritersByFormatName.hasNext() ? imageWritersByFormatName.next() : null;
        if (next == null) {
            throw new RuntimeException(I18N.getString("BMPImageWrite5") + " " + str);
        }
        if (this.embedded_stream == null) {
            throw new RuntimeException("No stream for writing embedded image!");
        }
        next.addIIOWriteProgressListener(new IIOWriteProgressAdapter() { // from class: com.sun.imageio.plugins.bmp.BMPImageWriter.1
            @Override // com.sun.imageio.plugins.bmp.BMPImageWriter.IIOWriteProgressAdapter, org.apache.poi.javax.imageio.event.IIOWriteProgressListener
            public void imageProgress(ImageWriter imageWriter, float f) {
                BMPImageWriter.this.processImageProgress(f);
            }
        });
        next.addIIOWriteWarningListener(new IIOWriteWarningListener() { // from class: com.sun.imageio.plugins.bmp.BMPImageWriter.2
            @Override // org.apache.poi.javax.imageio.event.IIOWriteWarningListener
            public void warningOccurred(ImageWriter imageWriter, int i, String str2) {
                BMPImageWriter.this.processWarningOccurred(i, str2);
            }
        });
        next.setOutput(ImageIO.createImageOutputStream(this.embedded_stream));
        ImageWriteParam defaultWriteParam = next.getDefaultWriteParam();
        defaultWriteParam.setDestinationOffset(imageWriteParam.getDestinationOffset());
        defaultWriteParam.setSourceBands(imageWriteParam.getSourceBands());
        defaultWriteParam.setSourceRegion(imageWriteParam.getSourceRegion());
        defaultWriteParam.setSourceSubsampling(imageWriteParam.getSourceXSubsampling(), imageWriteParam.getSourceYSubsampling(), imageWriteParam.getSubsamplingXOffset(), imageWriteParam.getSubsamplingYOffset());
        next.write(null, iIOImage, defaultWriteParam);
    }

    private void writeFileHeader(int i, int i2) {
        this.stream.writeByte(66);
        this.stream.writeByte(77);
        this.stream.writeInt(i);
        this.stream.writeInt(0);
        this.stream.writeInt(i2);
    }

    private void writeInfoHeader(int i, int i2) {
        this.stream.writeInt(i);
        this.stream.writeInt(this.f8274w);
        this.stream.writeInt(this.isTopDown ? -this.f8273h : this.f8273h);
        this.stream.writeShort(1);
        this.stream.writeShort(i2);
    }

    private void writePixels(int i, int i2, int i4, int[] iArr, int i5, int i6, IndexColorModel indexColorModel) {
        if (i4 == 1) {
            int i7 = i;
            int i8 = 0;
            int i9 = 0;
            while (i8 < i2 / 8) {
                byte[] bArr = this.bpixels;
                int i10 = i7 + 7;
                int i11 = (iArr[i7 + 1] << 6) | (iArr[i7] << 7) | (iArr[i7 + 2] << 5) | (iArr[i7 + 3] << 4) | (iArr[i7 + 4] << 3) | (iArr[i7 + 5] << 2) | (iArr[i7 + 6] << 1);
                i7 += 8;
                bArr[i9] = (byte) (i11 | iArr[i10]);
                i8++;
                i9++;
            }
            int i12 = i2 % 8;
            if (i12 > 0) {
                int i13 = 0;
                int i14 = 0;
                while (i13 < i12) {
                    i14 |= iArr[i7] << (7 - i13);
                    i13++;
                    i7++;
                }
                this.bpixels[i9] = (byte) i14;
            }
            this.stream.write(this.bpixels, 0, (i2 + 7) / 8);
        } else if (i4 != 4) {
            if (i4 != 8) {
                if (i4 == 16) {
                    if (this.spixels == null) {
                        this.spixels = new short[i2 / i6];
                    }
                    int i15 = 0;
                    int i16 = 0;
                    while (i15 < i2) {
                        short[] sArr = this.spixels;
                        sArr[i16] = 0;
                        if (this.compressionType == 0) {
                            sArr[i16] = (short) (((iArr[i15] & 31) << 10) | ((iArr[i15 + 1] & 31) << 5) | (iArr[i15 + 2] & 31));
                            i15 += 3;
                        } else {
                            int i17 = 0;
                            while (i17 < i6) {
                                short[] sArr2 = this.spixels;
                                sArr2[i16] = (short) (sArr2[i16] | ((iArr[i15] << this.bitPos[i17]) & this.bitMasks[i17]));
                                i17++;
                                i15++;
                            }
                        }
                        i16++;
                    }
                    ImageOutputStream imageOutputStream = this.stream;
                    short[] sArr3 = this.spixels;
                    imageOutputStream.writeShorts(sArr3, 0, sArr3.length);
                } else if (i4 != 24) {
                    if (i4 == 32) {
                        if (this.ipixels == null) {
                            this.ipixels = new int[i2 / i6];
                        }
                        if (i6 == 3) {
                            int i18 = 0;
                            int i19 = 0;
                            while (i18 < i2) {
                                int[] iArr2 = this.ipixels;
                                iArr2[i19] = 0;
                                if (this.compressionType == 0) {
                                    iArr2[i19] = ((iArr[i18 + 2] & 255) << 16) | ((iArr[i18 + 1] & 255) << 8) | (iArr[i18] & 255);
                                    i18 += 3;
                                } else {
                                    int i20 = 0;
                                    while (i20 < i6) {
                                        int[] iArr3 = this.ipixels;
                                        iArr3[i19] = iArr3[i19] | ((iArr[i18] << this.bitPos[i20]) & this.bitMasks[i20]);
                                        i20++;
                                        i18++;
                                    }
                                }
                                i19++;
                            }
                        } else {
                            for (int i21 = 0; i21 < i2; i21++) {
                                if (indexColorModel != null) {
                                    this.ipixels[i21] = indexColorModel.getRGB(iArr[i21]);
                                } else {
                                    int[] iArr4 = this.ipixels;
                                    int i22 = iArr[i21];
                                    iArr4[i21] = i22 | (i22 << 16) | (i22 << 8);
                                }
                            }
                        }
                        ImageOutputStream imageOutputStream2 = this.stream;
                        int[] iArr5 = this.ipixels;
                        imageOutputStream2.writeInts(iArr5, 0, iArr5.length);
                    }
                } else if (i6 == 3) {
                    int i23 = i;
                    int i24 = 0;
                    for (int i25 = 0; i25 < i2; i25 += 3) {
                        byte[] bArr2 = this.bpixels;
                        bArr2[i24] = (byte) iArr[i23 + 2];
                        int i26 = i24 + 2;
                        bArr2[i24 + 1] = (byte) iArr[i23 + 1];
                        i24 += 3;
                        bArr2[i26] = (byte) iArr[i23];
                        i23 += 3;
                    }
                    this.stream.write(this.bpixels, 0, i2);
                } else {
                    int mapSize = indexColorModel.getMapSize();
                    byte[] bArr3 = new byte[mapSize];
                    byte[] bArr4 = new byte[mapSize];
                    byte[] bArr5 = new byte[mapSize];
                    indexColorModel.getReds(bArr3);
                    indexColorModel.getGreens(bArr4);
                    indexColorModel.getBlues(bArr5);
                    int i27 = i;
                    int i28 = 0;
                    for (int i29 = 0; i29 < i2; i29++) {
                        int i30 = iArr[i27];
                        byte[] bArr6 = this.bpixels;
                        bArr6[i28] = bArr5[i30];
                        int i31 = i28 + 2;
                        bArr6[i28 + 1] = bArr4[i30];
                        i28 += 3;
                        bArr6[i31] = bArr5[i30];
                        i27++;
                    }
                    this.stream.write(this.bpixels, 0, i2 * 3);
                }
            } else if (this.compressionType == 1) {
                int i32 = i;
                int i33 = 0;
                while (i33 < i2) {
                    this.bpixels[i33] = (byte) iArr[i32];
                    i33++;
                    i32++;
                }
                encodeRLE8(this.bpixels, i2);
            } else {
                int i34 = i;
                int i35 = 0;
                while (i35 < i2) {
                    this.bpixels[i35] = (byte) iArr[i34];
                    i35++;
                    i34++;
                }
                this.stream.write(this.bpixels, 0, i2);
            }
        } else if (this.compressionType == 2) {
            byte[] bArr7 = new byte[i2];
            int i36 = i;
            int i37 = 0;
            while (i37 < i2) {
                bArr7[i37] = (byte) iArr[i36];
                i37++;
                i36++;
            }
            encodeRLE4(bArr7, i2);
        } else {
            int i38 = i;
            int i39 = 0;
            int i40 = 0;
            while (i39 < i2 / 2) {
                int i41 = i38 + 1;
                int i42 = iArr[i38] << 4;
                i38 += 2;
                this.bpixels[i40] = (byte) (iArr[i41] | i42);
                i39++;
                i40++;
            }
            if (i2 % 2 == 1) {
                this.bpixels[i40] = (byte) (iArr[i38] << 4);
            }
            this.stream.write(this.bpixels, 0, (i2 + 1) / 2);
        }
        int i43 = this.compressionType;
        if (i43 == 0 || i43 == 3) {
            for (int i44 = 0; i44 < i5; i44++) {
                this.stream.writeByte(0);
            }
        }
    }

    private void writeSize(int i, int i2) {
        this.stream.skipBytes(i2);
        this.stream.writeInt(i);
    }

    public boolean canEncodeImage(int i, ColorModel colorModel, SampleModel sampleModel) {
        return canEncodeImage(i, new ImageTypeSpecifier(colorModel, sampleModel));
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public boolean canWriteRasters() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertImageMetadata(IIOMetadata iIOMetadata, ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertStreamMetadata(IIOMetadata iIOMetadata, ImageWriteParam imageWriteParam) {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultImageMetadata(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        BMPMetadata bMPMetadata = new BMPMetadata();
        bMPMetadata.bmpVersion = BMPConstants.VERSION_3;
        bMPMetadata.compression = getPreferredCompressionType(imageTypeSpecifier);
        if (imageWriteParam != null && imageWriteParam.getCompressionMode() == 2) {
            bMPMetadata.compression = BMPCompressionTypes.getType(imageWriteParam.getCompressionType());
        }
        bMPMetadata.bitsPerPixel = (short) imageTypeSpecifier.getColorModel().getPixelSize();
        return bMPMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultStreamMetadata(ImageWriteParam imageWriteParam) {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public ImageWriteParam getDefaultWriteParam() {
        return new BMPImageWriteParam();
    }

    public int getPreferredCompressionType(ColorModel colorModel, SampleModel sampleModel) {
        return getPreferredCompressionType(new ImageTypeSpecifier(colorModel, sampleModel));
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void reset() {
        super.reset();
        this.stream = null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void setOutput(Object obj) {
        super.setOutput(obj);
        if (obj == null) {
            this.stream = null;
        } else {
            if (!(obj instanceof ImageOutputStream)) {
                throw new IllegalArgumentException(I18N.getString("BMPImageWriter0"));
            }
            ImageOutputStream imageOutputStream = (ImageOutputStream) obj;
            this.stream = imageOutputStream;
            imageOutputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void write(IIOMetadata iIOMetadata, IIOImage iIOImage, ImageWriteParam imageWriteParam) throws IOException {
        SampleModel sampleModel;
        ColorModel colorModel;
        Rectangle rectangleIntersection;
        RenderedImage renderedImage;
        Raster raster;
        int[] iArr;
        int numBands;
        ColorModel colorModel2;
        boolean z;
        boolean z2;
        int i;
        int i2;
        boolean z3;
        int[] bandOffsets;
        int i4;
        int i5;
        int i6;
        int i7;
        byte[] bArr;
        byte[] bArr2;
        IndexColorModel indexColorModel;
        byte[] bArr3;
        boolean z4;
        byte[] bArr4;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        int i10;
        int i11;
        int i12;
        int i13;
        RenderedImage renderedImage2;
        IndexColorModel indexColorModel2;
        long j;
        int[] iArr2;
        int i14;
        int offset;
        int i15;
        int redMask;
        int greenMask;
        int blueMask;
        BMPImageWriter bMPImageWriter = this;
        if (bMPImageWriter.stream == null) {
            throw new IllegalStateException(I18N.getString("BMPImageWriter7"));
        }
        if (iIOImage == null) {
            throw new IllegalArgumentException(I18N.getString("BMPImageWriter8"));
        }
        bMPImageWriter.clearAbortRequest();
        bMPImageWriter.processImageStarted(0);
        ImageWriteParam defaultWriteParam = imageWriteParam == null ? bMPImageWriter.getDefaultWriteParam() : imageWriteParam;
        BMPImageWriteParam bMPImageWriteParam = (BMPImageWriteParam) defaultWriteParam;
        boolean zHasRaster = iIOImage.hasRaster();
        Rectangle sourceRegion = defaultWriteParam.getSourceRegion();
        bMPImageWriter.compImageSize = 0;
        if (zHasRaster) {
            Raster raster2 = iIOImage.getRaster();
            sampleModel = raster2.getSampleModel();
            colorModel = ImageUtil.createColorModel(null, sampleModel);
            rectangleIntersection = sourceRegion == null ? raster2.getBounds() : sourceRegion.intersection(raster2.getBounds());
            raster = raster2;
            renderedImage = null;
        } else {
            RenderedImage renderedImage3 = iIOImage.getRenderedImage();
            sampleModel = renderedImage3.getSampleModel();
            colorModel = renderedImage3.getColorModel();
            Rectangle rectangle = new Rectangle(renderedImage3.getMinX(), renderedImage3.getMinY(), renderedImage3.getWidth(), renderedImage3.getHeight());
            if (sourceRegion == null) {
                renderedImage = renderedImage3;
                rectangleIntersection = rectangle;
            } else {
                rectangleIntersection = sourceRegion.intersection(rectangle);
                renderedImage = renderedImage3;
            }
            raster = null;
        }
        IIOMetadata metadata = iIOImage.getMetadata();
        BMPMetadata bMPMetadata = (metadata == null || !(metadata instanceof BMPMetadata)) ? (BMPMetadata) bMPImageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(colorModel, sampleModel), defaultWriteParam) : (BMPMetadata) metadata;
        if (rectangleIntersection.isEmpty()) {
            throw new RuntimeException(I18N.getString("BMPImageWrite0"));
        }
        int sourceXSubsampling = defaultWriteParam.getSourceXSubsampling();
        int sourceYSubsampling = defaultWriteParam.getSourceYSubsampling();
        int subsamplingXOffset = defaultWriteParam.getSubsamplingXOffset();
        int subsamplingYOffset = defaultWriteParam.getSubsamplingYOffset();
        int dataType = sampleModel.getDataType();
        rectangleIntersection.translate(subsamplingXOffset, subsamplingYOffset);
        ImageWriteParam imageWriteParam2 = defaultWriteParam;
        int i16 = rectangleIntersection.width - subsamplingXOffset;
        rectangleIntersection.width = i16;
        int i17 = rectangleIntersection.height - subsamplingYOffset;
        rectangleIntersection.height = i17;
        int i18 = rectangleIntersection.f10094x;
        int i19 = i18 / sourceXSubsampling;
        ColorModel colorModel3 = colorModel;
        int i20 = rectangleIntersection.f10095y;
        int i21 = i20 / sourceYSubsampling;
        Raster raster3 = raster;
        bMPImageWriter.f8274w = AbstractC4539a.m3211u(i16, sourceXSubsampling, 1, sourceXSubsampling);
        bMPImageWriter.f8273h = AbstractC4539a.m3211u(i17, sourceYSubsampling, 1, sourceYSubsampling);
        int i22 = i18 % sourceXSubsampling;
        int i23 = i20 % sourceYSubsampling;
        boolean zEquals = new Rectangle(i19, i21, bMPImageWriter.f8274w, bMPImageWriter.f8273h).equals(rectangleIntersection);
        int[] sourceBands = imageWriteParam2.getSourceBands();
        int numBands2 = sampleModel.getNumBands();
        if (sourceBands != null) {
            sampleModel = sampleModel.createSubsetSampleModel(sourceBands);
            iArr = sourceBands;
            numBands = sampleModel.getNumBands();
            colorModel2 = null;
            z = false;
        } else {
            int[] iArr3 = new int[numBands2];
            for (int i24 = 0; i24 < numBands2; i24++) {
                iArr3[i24] = i24;
            }
            iArr = iArr3;
            numBands = numBands2;
            colorModel2 = colorModel3;
            z = true;
        }
        if (sampleModel instanceof ComponentSampleModel) {
            bandOffsets = ((ComponentSampleModel) sampleModel).getBandOffsets();
            i2 = 1;
            if (sampleModel instanceof BandedSampleModel) {
                z2 = zEquals;
                i = i19;
                z3 = false;
            } else {
                z3 = true;
                z2 = zEquals;
                int i25 = 0;
                while (i25 < bandOffsets.length) {
                    int i26 = i19;
                    z3 &= bandOffsets[i25] == (bandOffsets.length - i25) + (-1);
                    i25++;
                    i19 = i26;
                }
                i = i19;
            }
        } else {
            z2 = zEquals;
            i = i19;
            i2 = 1;
            if (sampleModel instanceof SinglePixelPackedSampleModel) {
                int[] bitOffsets = ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets();
                boolean z7 = true;
                int i27 = 0;
                while (i27 < bitOffsets.length - 1) {
                    int i28 = bitOffsets[i27];
                    i27++;
                    int[] iArr4 = bitOffsets;
                    z7 &= i28 > iArr4[i27];
                    bitOffsets = iArr4;
                }
                z3 = z7;
            } else {
                z3 = true;
            }
            bandOffsets = null;
        }
        if (bandOffsets == null) {
            bandOffsets = new int[numBands];
            for (int i29 = 0; i29 < numBands; i29++) {
                bandOffsets[i29] = i29;
            }
        }
        int[] iArr5 = bandOffsets;
        int[] sampleSize = sampleModel.getSampleSize();
        int dataTypeSize = bMPImageWriter.f8274w * numBands;
        boolean z8 = z2 & z3;
        int compressionMode = bMPImageWriteParam.getCompressionMode();
        int i30 = numBands;
        if (compressionMode == i2) {
            bMPImageWriter.compressionType = bMPImageWriter.getPreferredCompressionType(colorModel2, sampleModel);
        } else if (compressionMode == 2) {
            bMPImageWriter.compressionType = BMPCompressionTypes.getType(bMPImageWriteParam.getCompressionType());
        } else if (compressionMode != 3) {
            bMPImageWriter.compressionType = 0;
        } else {
            bMPImageWriter.compressionType = bMPMetadata.compression;
        }
        if (!bMPImageWriter.canEncodeImage(bMPImageWriter.compressionType, colorModel2, sampleModel)) {
            throw new IOException("Image can not be encoded with compression type " + BMPCompressionTypes.getName(bMPImageWriter.compressionType));
        }
        if (bMPImageWriter.compressionType == 3) {
            int dataTypeSize2 = DataBuffer.getDataTypeSize(sampleModel.getDataType());
            if (dataTypeSize2 == 16 || dataTypeSize2 == 32) {
                i15 = dataTypeSize2;
            } else {
                i15 = 32;
                z8 = false;
            }
            int i31 = ((bMPImageWriter.f8274w * i15) + 7) >> 3;
            byte[] bArr5 = new byte[3];
            bArr = new byte[3];
            byte[] bArr6 = new byte[3];
            byte[] bArr7 = new byte[3];
            if (i15 != 16) {
                redMask = 16711680;
                greenMask = 65280;
                blueMask = 255;
            } else {
                if (!(colorModel2 instanceof DirectColorModel)) {
                    throw new IOException("Image can not be encoded with compression type " + BMPCompressionTypes.getName(bMPImageWriter.compressionType));
                }
                DirectColorModel directColorModel = (DirectColorModel) colorModel2;
                redMask = directColorModel.getRedMask();
                greenMask = directColorModel.getGreenMask();
                blueMask = directColorModel.getBlueMask();
            }
            int i32 = redMask;
            int i33 = i15;
            int i34 = blueMask;
            ColorModel colorModel4 = colorModel2;
            bMPImageWriter.writeMaskToPalette(i32, 0, bArr5, bArr, bArr6, bArr7);
            bMPImageWriter = this;
            int i35 = greenMask;
            bMPImageWriter.writeMaskToPalette(i35, 1, bArr5, bArr, bArr6, bArr7);
            i4 = sourceYSubsampling;
            bMPImageWriter.writeMaskToPalette(i34, 2, bArr5, bArr, bArr6, bArr7);
            bArr4 = bArr5;
            if (!z8) {
                bMPImageWriter.bitMasks = new int[]{i32, i35, i34};
                bMPImageWriter.bitPos = new int[]{bMPImageWriter.firstLowBit(i32), 0, 0};
                bMPImageWriter.bitPos[1] = bMPImageWriter.firstLowBit(i35);
                bMPImageWriter.bitPos[2] = bMPImageWriter.firstLowBit(i34);
            }
            indexColorModel = colorModel4 instanceof IndexColorModel ? (IndexColorModel) colorModel4 : null;
            bArr3 = bArr7;
            i5 = i33;
            dataTypeSize = i31;
            i7 = 3;
            z4 = true;
            bArr2 = bArr6;
            i6 = i30;
        } else {
            i4 = sourceYSubsampling;
            ColorModel colorModel5 = colorModel2;
            i5 = 24;
            if (colorModel5 instanceof IndexColorModel) {
                IndexColorModel indexColorModel3 = (IndexColorModel) colorModel5;
                int mapSize = indexColorModel3.getMapSize();
                if (mapSize <= 2) {
                    dataTypeSize = (bMPImageWriter.f8274w + 7) >> 3;
                    i9 = 1;
                    z6 = true;
                    z5 = true;
                } else if (mapSize <= 16) {
                    z5 = true;
                    dataTypeSize = (bMPImageWriter.f8274w + 1) >> 1;
                    z6 = true;
                    i9 = 4;
                } else {
                    z5 = true;
                    if (mapSize <= 256) {
                        i9 = 8;
                        z6 = true;
                    } else {
                        dataTypeSize = bMPImageWriter.f8274w * 3;
                        i9 = 24;
                        z6 = false;
                        mapSize = 0;
                    }
                }
                if (z6 == z5) {
                    byte[] bArr8 = new byte[mapSize];
                    byte[] bArr9 = new byte[mapSize];
                    byte[] bArr10 = new byte[mapSize];
                    bArr3 = new byte[mapSize];
                    indexColorModel3.getAlphas(bArr3);
                    indexColorModel3.getReds(bArr8);
                    indexColorModel3.getGreens(bArr9);
                    indexColorModel3.getBlues(bArr10);
                    indexColorModel = indexColorModel3;
                    i7 = mapSize;
                    bArr4 = bArr8;
                    bArr = bArr9;
                    bArr2 = bArr10;
                    i6 = i30;
                    z4 = z6;
                } else {
                    indexColorModel = indexColorModel3;
                    z4 = z6;
                    i7 = mapSize;
                    i6 = i30;
                    bArr = null;
                    bArr2 = null;
                    bArr3 = null;
                    bArr4 = null;
                }
                i5 = i9;
            } else {
                i6 = i30;
                if (i6 == 1) {
                    int i36 = sampleSize[0];
                    i8 = ((bMPImageWriter.f8274w * i36) + 7) >> 3;
                    byte[] bArr11 = new byte[256];
                    bArr = new byte[256];
                    bArr2 = new byte[256];
                    bArr3 = new byte[256];
                    int i37 = 0;
                    for (int i38 = 256; i37 < i38; i38 = 256) {
                        byte b = (byte) i37;
                        bArr11[i37] = b;
                        bArr[i37] = b;
                        bArr2[i37] = b;
                        bArr3[i37] = -1;
                        i37++;
                    }
                    bArr4 = bArr11;
                    i5 = i36;
                    i7 = 256;
                    indexColorModel = null;
                    z4 = true;
                } else if ((sampleModel instanceof SinglePixelPackedSampleModel) && z) {
                    int i39 = 0;
                    for (int i40 : sampleModel.getSampleSize()) {
                        i39 += i40;
                    }
                    int iRoundBpp = bMPImageWriter.roundBpp(i39);
                    if (iRoundBpp != DataBuffer.getDataTypeSize(sampleModel.getDataType())) {
                        z8 = false;
                    }
                    i8 = ((bMPImageWriter.f8274w * iRoundBpp) + 7) >> 3;
                    i5 = iRoundBpp;
                    i7 = 0;
                    bArr = null;
                    bArr2 = null;
                    indexColorModel = null;
                    bArr3 = null;
                    z4 = false;
                    bArr4 = null;
                } else {
                    i7 = 0;
                    bArr = null;
                    bArr2 = null;
                    indexColorModel = null;
                    bArr3 = null;
                    z4 = false;
                    bArr4 = null;
                }
                dataTypeSize = i8;
            }
        }
        int i41 = dataTypeSize % 4;
        if (i41 != 0) {
            i41 = 4 - i41;
        }
        byte[] bArr12 = bArr;
        int i42 = i41;
        int i43 = (i7 * 4) + 54;
        byte[] bArr13 = bArr2;
        int i44 = bMPImageWriter.f8273h * (dataTypeSize + i42);
        IndexColorModel indexColorModel4 = indexColorModel;
        byte[] bArr14 = bArr3;
        int i45 = i42;
        int i46 = i6;
        long streamPosition = bMPImageWriter.stream.getStreamPosition();
        bMPImageWriter.writeFileHeader(i44 + i43, i43);
        int i47 = bMPImageWriter.compressionType;
        if (i47 == 0 || i47 == 3) {
            bMPImageWriter.isTopDown = bMPImageWriteParam.isTopDown();
        } else {
            bMPImageWriter.isTopDown = false;
        }
        bMPImageWriter.writeInfoHeader(40, i5);
        bMPImageWriter.stream.writeInt(bMPImageWriter.compressionType);
        bMPImageWriter.stream.writeInt(i44);
        bMPImageWriter.stream.writeInt(0);
        bMPImageWriter.stream.writeInt(0);
        bMPImageWriter.stream.writeInt(0);
        bMPImageWriter.stream.writeInt(i7);
        if (z4) {
            if (bMPImageWriter.compressionType == 3) {
                int i48 = 0;
                for (int i49 = 3; i48 < i49; i49 = 3) {
                    bMPImageWriter.stream.writeInt(((bArr13[i48] & 255) * 16777216) + ((bArr12[i48] & 255) * 65536) + ((bArr4[i48] & 255) * 256) + (bArr14[i48] & 255));
                    i48++;
                }
            } else {
                for (int i50 = 0; i50 < i7; i50++) {
                    bMPImageWriter.stream.writeByte(bArr13[i50]);
                    bMPImageWriter.stream.writeByte(bArr12[i50]);
                    bMPImageWriter.stream.writeByte(bArr4[i50]);
                    bMPImageWriter.stream.writeByte(bArr14[i50]);
                }
            }
        }
        int i51 = bMPImageWriter.f8274w * i46;
        int[] iArr6 = new int[i51 * sourceXSubsampling];
        bMPImageWriter.bpixels = new byte[dataTypeSize];
        int i52 = bMPImageWriter.compressionType;
        if (i52 == 4 || i52 == 5) {
            bMPImageWriter.embedded_stream = new ByteArrayOutputStream();
            bMPImageWriter.writeEmbedded(iIOImage, bMPImageWriteParam);
            bMPImageWriter.embedded_stream.flush();
            int size = bMPImageWriter.embedded_stream.size();
            long streamPosition2 = bMPImageWriter.stream.getStreamPosition();
            bMPImageWriter.stream.seek(streamPosition);
            bMPImageWriter.writeSize(i43 + size, 2);
            bMPImageWriter.stream.seek(streamPosition);
            bMPImageWriter.writeSize(size, 34);
            bMPImageWriter.stream.seek(streamPosition2);
            bMPImageWriter.stream.write(bMPImageWriter.embedded_stream.toByteArray());
            bMPImageWriter.embedded_stream = null;
            if (bMPImageWriter.abortRequested()) {
                bMPImageWriter.processWriteAborted();
                return;
            }
            bMPImageWriter.processImageComplete();
            ImageOutputStream imageOutputStream = bMPImageWriter.stream;
            imageOutputStream.flushBefore(imageOutputStream.getStreamPosition());
            return;
        }
        int i53 = iArr5[0];
        for (int i54 = 1; i54 < iArr5.length; i54++) {
            int i55 = iArr5[i54];
            if (i55 > i53) {
                i53 = i55;
            }
        }
        int i56 = i53 + 1;
        int[] iArr7 = new int[i56];
        if (z8 && z) {
            dataTypeSize /= DataBuffer.getDataTypeSize(dataType) >> 3;
        }
        int i57 = 0;
        while (i57 < bMPImageWriter.f8273h && !bMPImageWriter.abortRequested()) {
            int i58 = i21 + i57;
            int i59 = i43;
            if (!bMPImageWriter.isTopDown) {
                i58 = ((i21 + bMPImageWriter.f8273h) - i57) - 1;
            }
            int i60 = i5;
            long j2 = streamPosition;
            Rectangle rectangle2 = new Rectangle((i * sourceXSubsampling) + i22, (i58 * i4) + i23, AbstractC1974b.m1304A(bMPImageWriter.f8274w, 1, sourceXSubsampling, 1), 1);
            Raster data = !zHasRaster ? renderedImage.getData(rectangle2) : raster3;
            if (z8 && z) {
                SampleModel sampleModel2 = data.getSampleModel();
                int sampleModelTranslateX = rectangle2.f10094x - data.getSampleModelTranslateX();
                int sampleModelTranslateY = rectangle2.f10095y - data.getSampleModelTranslateY();
                if (sampleModel2 instanceof ComponentSampleModel) {
                    ComponentSampleModel componentSampleModel = (ComponentSampleModel) sampleModel2;
                    iArr2 = iArr6;
                    int offset2 = componentSampleModel.getOffset(sampleModelTranslateX, sampleModelTranslateY, 0);
                    i14 = i57;
                    for (int i61 = 1; i61 < componentSampleModel.getNumBands(); i61++) {
                        if (offset2 > componentSampleModel.getOffset(sampleModelTranslateX, sampleModelTranslateY, i61)) {
                            offset2 = componentSampleModel.getOffset(sampleModelTranslateX, sampleModelTranslateY, i61);
                        }
                    }
                    offset = offset2;
                } else {
                    iArr2 = iArr6;
                    i14 = i57;
                    offset = sampleModel2 instanceof MultiPixelPackedSampleModel ? ((MultiPixelPackedSampleModel) sampleModel2).getOffset(sampleModelTranslateX, sampleModelTranslateY) : sampleModel2 instanceof SinglePixelPackedSampleModel ? ((SinglePixelPackedSampleModel) sampleModel2).getOffset(sampleModelTranslateX, sampleModelTranslateY) : 0;
                }
                int i62 = bMPImageWriter.compressionType;
                if (i62 == 0 || i62 == 3) {
                    if (dataType == 0) {
                        bMPImageWriter.stream.write(((DataBufferByte) data.getDataBuffer()).getData(), offset, dataTypeSize);
                    } else if (dataType == 1) {
                        bMPImageWriter.stream.writeShorts(((DataBufferUShort) data.getDataBuffer()).getData(), offset, dataTypeSize);
                    } else if (dataType == 2) {
                        bMPImageWriter.stream.writeShorts(((DataBufferShort) data.getDataBuffer()).getData(), offset, dataTypeSize);
                    } else if (dataType == 3) {
                        bMPImageWriter.stream.writeInts(((DataBufferInt) data.getDataBuffer()).getData(), offset, dataTypeSize);
                    }
                    i10 = i45;
                    for (int i63 = 0; i63 < i10; i63++) {
                        bMPImageWriter.stream.writeByte(0);
                    }
                } else {
                    if (i62 == 2) {
                        byte[] bArr15 = bMPImageWriter.bpixels;
                        if (bArr15 == null || bArr15.length < i51) {
                            bMPImageWriter.bpixels = new byte[i51];
                        }
                        data.getPixels(rectangle2.f10094x, rectangle2.f10095y, rectangle2.width, rectangle2.height, iArr2);
                        for (int i64 = 0; i64 < i51; i64++) {
                            bMPImageWriter.bpixels[i64] = (byte) iArr2[i64];
                        }
                        bMPImageWriter.encodeRLE4(bMPImageWriter.bpixels, i51);
                    } else if (i62 == 1) {
                        byte[] bArr16 = bMPImageWriter.bpixels;
                        if (bArr16 == null || bArr16.length < i51) {
                            bMPImageWriter.bpixels = new byte[i51];
                        }
                        data.getPixels(rectangle2.f10094x, rectangle2.f10095y, rectangle2.width, rectangle2.height, iArr2);
                        for (int i65 = 0; i65 < i51; i65++) {
                            bMPImageWriter.bpixels[i65] = (byte) iArr2[i65];
                        }
                        bMPImageWriter.encodeRLE8(bMPImageWriter.bpixels, i51);
                    }
                    i10 = i45;
                }
                int i66 = i14;
                i12 = dataType;
                i13 = i66;
                renderedImage2 = renderedImage;
                indexColorModel2 = indexColorModel4;
                j = j2;
                i11 = i46;
            } else {
                int[] iArr8 = iArr6;
                int i67 = i57;
                i10 = i45;
                data.getPixels(rectangle2.f10094x, rectangle2.f10095y, rectangle2.width, rectangle2.height, iArr8);
                if (sourceXSubsampling != 1 || i53 != i46 - 1) {
                    int i68 = 0;
                    int i69 = 0;
                    int i70 = 0;
                    while (i68 < bMPImageWriter.f8274w) {
                        System.arraycopy(iArr8, i69, iArr7, 0, i56);
                        int i71 = i70;
                        int i72 = i46;
                        for (int i73 = 0; i73 < i72; i73++) {
                            iArr8[i71 + i73] = iArr7[iArr[i73]];
                        }
                        i68++;
                        i69 += sourceXSubsampling * i72;
                        i46 = i72;
                        i70 = i71 + i72;
                    }
                }
                i11 = i46;
                i12 = dataType;
                i13 = i67;
                renderedImage2 = renderedImage;
                indexColorModel2 = indexColorModel4;
                j = j2;
                bMPImageWriter.writePixels(0, i51, i60, iArr8, i10, i11, indexColorModel2);
                iArr2 = iArr8;
            }
            bMPImageWriter.processImageProgress((i13 / bMPImageWriter.f8273h) * 100.0f);
            int i74 = i13 + 1;
            i45 = i10;
            i46 = i11;
            indexColorModel4 = indexColorModel2;
            streamPosition = j;
            renderedImage = renderedImage2;
            dataType = i12;
            i5 = i60;
            iArr6 = iArr2;
            i57 = i74;
            i43 = i59;
        }
        int i75 = i43;
        long j3 = streamPosition;
        int i76 = bMPImageWriter.compressionType;
        if (i76 == 2 || i76 == 1) {
            bMPImageWriter.stream.writeByte(0);
            bMPImageWriter.stream.writeByte(1);
            bMPImageWriter.incCompImageSize(2);
            int i77 = bMPImageWriter.compImageSize;
            long streamPosition3 = bMPImageWriter.stream.getStreamPosition();
            bMPImageWriter.stream.seek(j3);
            bMPImageWriter.writeSize(i77 + i75, 2);
            bMPImageWriter.stream.seek(j3);
            bMPImageWriter.writeSize(i77, 34);
            bMPImageWriter.stream.seek(streamPosition3);
        }
        if (bMPImageWriter.abortRequested()) {
            bMPImageWriter.processWriteAborted();
            return;
        }
        bMPImageWriter.processImageComplete();
        ImageOutputStream imageOutputStream2 = bMPImageWriter.stream;
        imageOutputStream2.flushBefore(imageOutputStream2.getStreamPosition());
    }

    public void writeMaskToPalette(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        bArr3[i2] = (byte) ((i >> 24) & 255);
        bArr2[i2] = (byte) ((i >> 16) & 255);
        bArr[i2] = (byte) ((i >> 8) & 255);
        bArr4[i2] = (byte) (i & 255);
    }

    public boolean canEncodeImage(int i, ImageTypeSpecifier imageTypeSpecifier) {
        boolean z;
        boolean z2;
        if (!getOriginatingProvider().canEncodeImage(imageTypeSpecifier)) {
            return false;
        }
        imageTypeSpecifier.getBufferedImageType();
        int pixelSize = imageTypeSpecifier.getColorModel().getPixelSize();
        int i2 = this.compressionType;
        if (i2 == 2 && pixelSize != 4) {
            return false;
        }
        if (i2 == 1 && pixelSize != 8) {
            return false;
        }
        if (pixelSize != 16) {
            return true;
        }
        SampleModel sampleModel = imageTypeSpecifier.getSampleModel();
        if (sampleModel instanceof SinglePixelPackedSampleModel) {
            int[] sampleSize = ((SinglePixelPackedSampleModel) sampleModel).getSampleSize();
            int i4 = 0;
            z = true;
            z2 = true;
            while (i4 < sampleSize.length) {
                int i5 = sampleSize[i4];
                z &= i5 == 5;
                z2 &= i5 == 5 || (i4 == 1 && i5 == 6);
                i4++;
            }
        } else {
            z = false;
            z2 = false;
        }
        int i6 = this.compressionType;
        return (i6 == 0 && z) || (i6 == 3 && z2);
    }

    public int getPreferredCompressionType(ImageTypeSpecifier imageTypeSpecifier) {
        return imageTypeSpecifier.getBufferedImageType() == 8 ? 3 : 0;
    }
}
