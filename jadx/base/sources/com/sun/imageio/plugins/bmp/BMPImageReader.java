package com.sun.imageio.plugins.bmp;

import androidx.compose.runtime.AbstractC1974b;
import androidx.core.view.MotionEventCompat;
import com.sun.imageio.plugins.common.I18N;
import com.sun.imageio.plugins.common.ImageUtil;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.apache.commons.lang3.SystemProperties;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.color.ICC_ColorSpace;
import org.apache.poi.java.awt.color.ICC_Profile;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.ComponentSampleModel;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.DataBufferUShort;
import org.apache.poi.java.awt.image.DirectColorModel;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.MultiPixelPackedSampleModel;
import org.apache.poi.java.awt.image.PixelInterleavedSampleModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.ImageIO;
import org.apache.poi.javax.imageio.ImageReadParam;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.event.IIOReadProgressListener;
import org.apache.poi.javax.imageio.event.IIOReadUpdateListener;
import org.apache.poi.javax.imageio.event.IIOReadWarningListener;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.stream.ImageInputStream;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BMPImageReader extends ImageReader implements BMPConstants {
    private static final int VERSION_2_1_BIT = 0;
    private static final int VERSION_2_24_BIT = 3;
    private static final int VERSION_2_4_BIT = 1;
    private static final int VERSION_2_8_BIT = 2;
    private static final int VERSION_3_1_BIT = 4;
    private static final int VERSION_3_24_BIT = 7;
    private static final int VERSION_3_4_BIT = 5;
    private static final int VERSION_3_8_BIT = 6;
    private static final int VERSION_3_NT_16_BIT = 8;
    private static final int VERSION_3_NT_32_BIT = 9;
    private static final int VERSION_3_XP_EMBEDDED = 16;
    private static final int VERSION_4_16_BIT = 13;
    private static final int VERSION_4_1_BIT = 10;
    private static final int VERSION_4_24_BIT = 14;
    private static final int VERSION_4_32_BIT = 15;
    private static final int VERSION_4_4_BIT = 11;
    private static final int VERSION_4_8_BIT = 12;
    private static final int VERSION_4_XP_EMBEDDED = 17;
    private static final int VERSION_5_XP_EMBEDDED = 18;
    private static Boolean isLinkedProfileDisabled;
    private static Boolean isWindowsPlatform;
    private int alphaMask;

    /* JADX INFO: renamed from: bi */
    private BufferedImage f8272bi;
    private long bitmapFileSize;
    private long bitmapOffset;
    private int bitsPerPixel;
    private int blueMask;
    private ColorModel colorModel;
    private long compression;
    private int[] destBands;
    private Rectangle destinationRegion;
    private boolean gotHeader;
    private int greenMask;
    private int height;
    private ImageInputStream iis;
    private long imageSize;
    private int imageType;
    private boolean isBottomUp;
    private BMPMetadata metadata;
    private boolean noTransform;
    private int numBands;
    private ColorModel originalColorModel;
    private SampleModel originalSampleModel;
    private byte[] palette;
    private int redMask;
    private SampleModel sampleModel;
    private int scaleX;
    private int scaleY;
    private boolean seleBand;
    private int[] sourceBands;
    private Rectangle sourceRegion;
    private int width;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EmbeddedProgressAdapter implements IIOReadProgressListener {
        private EmbeddedProgressAdapter() {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void imageComplete(ImageReader imageReader) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void imageProgress(ImageReader imageReader, float f) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void imageStarted(ImageReader imageReader, int i) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void readAborted(ImageReader imageReader) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void sequenceComplete(ImageReader imageReader) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void sequenceStarted(ImageReader imageReader, int i) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void thumbnailComplete(ImageReader imageReader) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void thumbnailProgress(ImageReader imageReader, float f) {
        }

        @Override // org.apache.poi.javax.imageio.event.IIOReadProgressListener
        public void thumbnailStarted(ImageReader imageReader, int i, int i2) {
        }
    }

    public BMPImageReader(ImageReaderSpi imageReaderSpi) {
        super(imageReaderSpi);
        this.iis = null;
        this.gotHeader = false;
        this.noTransform = true;
        this.seleBand = false;
    }

    private void checkIndex(int i) {
        if (i != 0) {
            throw new IndexOutOfBoundsException(I18N.getString("BMPImageReader0"));
        }
    }

    private void decodeRLE4(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i4;
        int i5;
        int i6;
        byte[] bArr3 = new byte[this.width];
        int i7 = this.isBottomUp ? this.height - 1 : 0;
        int scanlineStride = ((MultiPixelPackedSampleModel) this.sampleModel).getScanlineStride();
        int i8 = i7;
        int i9 = 0;
        int iM1310c = 0;
        boolean z = false;
        int i10 = 0;
        while (i9 != i) {
            int i11 = i9 + 1;
            int i12 = bArr[i9] & 255;
            if (i12 == 0) {
                int i13 = i9 + 2;
                int i14 = bArr[i11] & 255;
                if (i14 == 0) {
                    Rectangle rectangle = this.sourceRegion;
                    int i15 = rectangle.f10095y;
                    if (i8 < i15 || i8 >= rectangle.height + i15) {
                        i4 = i8;
                    } else {
                        if (this.noTransform) {
                            int i16 = ((this.width + 1) >> 1) * i8;
                            int i17 = 0;
                            int i18 = 0;
                            while (true) {
                                i5 = this.width;
                                if (i17 >= (i5 >> 1)) {
                                    break;
                                }
                                int i19 = i18 + 1;
                                int i20 = bArr3[i18] << 4;
                                i18 += 2;
                                bArr2[i16] = (byte) (i20 | bArr3[i19]);
                                i17++;
                                i16++;
                            }
                            if ((i5 & 1) == 1) {
                                bArr2[i16] = (byte) (bArr2[i16] | (bArr3[i5 - 1] << 4));
                            }
                            processImageUpdate(this.f8272bi, 0, i8, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                            i4 = i8;
                        } else {
                            i4 = i8;
                            int i21 = this.scaleY;
                            if ((i4 - i15) % i21 == 0) {
                                int i22 = (i4 - i15) / i21;
                                Rectangle rectangle2 = this.destinationRegion;
                                int i23 = i22 + rectangle2.f10095y;
                                int i24 = rectangle2.f10094x;
                                int i25 = (i23 * scanlineStride) + (i24 >> 1);
                                int i26 = (1 - (i24 & 1)) << 2;
                                int i27 = rectangle.f10094x;
                                while (true) {
                                    Rectangle rectangle3 = this.sourceRegion;
                                    if (i27 >= rectangle3.f10094x + rectangle3.width) {
                                        break;
                                    }
                                    bArr2[i25] = (byte) (bArr2[i25] | (bArr3[i27] << i26));
                                    int i28 = i26 + 4;
                                    if (i28 == 4) {
                                        i25++;
                                    }
                                    i26 = i28 & 7;
                                    i27 += this.scaleX;
                                }
                                processImageUpdate(this.f8272bi, 0, i23, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                            }
                        }
                        i10++;
                    }
                    processImageProgress((i10 * 100.0f) / this.destinationRegion.height);
                    i8 = i4 + (this.isBottomUp ? -1 : 1);
                    if (abortRequested()) {
                        z = true;
                    }
                    iM1310c = 0;
                } else if (i14 == 1) {
                    z = true;
                } else if (i14 != 2) {
                    byte b = bArr[i9 + 1];
                    int i29 = b & 255;
                    int i30 = 0;
                    while (i30 < i29) {
                        int i31 = iM1310c + 1;
                        if ((i30 & 1) == 0) {
                            i6 = (bArr[i13] & CtapException.ERR_VENDOR_FIRST) >> 4;
                        } else {
                            int i32 = i13 + 1;
                            int i33 = bArr[i13] & 15;
                            i13 = i32;
                            i6 = i33;
                        }
                        bArr3[iM1310c] = (byte) i6;
                        i30++;
                        iM1310c = i31;
                    }
                    if ((b & 1) == 1) {
                        i13++;
                    }
                    if ((((int) Math.ceil(i29 / 2)) & 1) == 1) {
                        i13++;
                    }
                } else {
                    int i34 = i9 + 3;
                    iM1310c = AbstractC1974b.m1310c(bArr[i34] & 255, this.width, bArr[i13] & 255, iM1310c);
                    i13 = i34;
                }
                i9 = i13;
            } else {
                int i35 = i8;
                int i36 = bArr[i11];
                int[] iArr = {(i36 & 240) >> 4, i36 & 15};
                int i37 = 0;
                while (i37 < i12 && iM1310c < this.width) {
                    bArr3[iM1310c] = (byte) iArr[i37 & 1];
                    i37++;
                    iM1310c++;
                }
                i9 += 2;
                i8 = i35;
            }
            if (z) {
                return;
            }
        }
    }

    private void decodeRLE8(int i, int i2, byte[] bArr, byte[] bArr2) {
        int i4;
        int i5 = this.width;
        int i6 = this.height;
        byte[] bArr3 = new byte[i5 * i6];
        int i7 = this.isBottomUp ? i6 - 1 : 0;
        int scanlineStride = ((ComponentSampleModel) this.sampleModel).getScanlineStride();
        int i8 = i7;
        int i9 = 0;
        int iM1310c = 0;
        boolean z = false;
        int i10 = 0;
        while (i9 != i) {
            int i11 = i9 + 1;
            int i12 = bArr[i9] & 255;
            if (i12 == 0) {
                int i13 = i9 + 2;
                int i14 = bArr[i11] & 255;
                if (i14 == 0) {
                    Rectangle rectangle = this.sourceRegion;
                    int i15 = rectangle.f10095y;
                    if (i8 < i15 || i8 >= rectangle.height + i15) {
                        i4 = i8;
                    } else {
                        if (this.noTransform) {
                            int i16 = this.width * i8;
                            int i17 = 0;
                            while (i17 < this.width) {
                                bArr2[i16] = bArr3[i17];
                                i17++;
                                i16++;
                            }
                            processImageUpdate(this.f8272bi, 0, i8, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                            i4 = i8;
                        } else {
                            i4 = i8;
                            int i18 = this.scaleY;
                            if ((i4 - i15) % i18 == 0) {
                                int i19 = (i4 - i15) / i18;
                                Rectangle rectangle2 = this.destinationRegion;
                                int i20 = i19 + rectangle2.f10095y;
                                int i21 = (i20 * scanlineStride) + rectangle2.f10094x;
                                int i22 = rectangle.f10094x;
                                while (true) {
                                    Rectangle rectangle3 = this.sourceRegion;
                                    if (i22 >= rectangle3.f10094x + rectangle3.width) {
                                        break;
                                    }
                                    bArr2[i21] = bArr3[i22];
                                    i22 += this.scaleX;
                                    i21++;
                                }
                                processImageUpdate(this.f8272bi, 0, i20, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                            }
                        }
                        i10++;
                    }
                    processImageProgress((i10 * 100.0f) / this.destinationRegion.height);
                    i8 = i4 + (this.isBottomUp ? -1 : 1);
                    if (abortRequested()) {
                        z = true;
                    }
                    iM1310c = 0;
                } else if (i14 == 1) {
                    z = true;
                } else if (i14 != 2) {
                    byte b = bArr[i9 + 1];
                    int i23 = b & 255;
                    int i24 = 0;
                    while (i24 < i23) {
                        bArr3[iM1310c] = (byte) (bArr[i13] & 255);
                        i24++;
                        iM1310c++;
                        i13++;
                    }
                    if ((b & 1) == 1) {
                        i13++;
                    }
                } else {
                    int i25 = i9 + 3;
                    iM1310c = AbstractC1974b.m1310c(bArr[i25] & 255, this.width, bArr[i13] & 255, iM1310c);
                    i13 = i25;
                }
                i9 = i13;
            } else {
                int i26 = i8;
                int i27 = 0;
                while (i27 < i12) {
                    bArr3[iM1310c] = (byte) (bArr[i11] & 255);
                    i27++;
                    iM1310c++;
                }
                i9 += 2;
                i8 = i26;
            }
            if (z) {
                return;
            }
        }
    }

    private static boolean isLinkedProfileAllowed() {
        if (isLinkedProfileDisabled == null) {
            isLinkedProfileDisabled = (Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: com.sun.imageio.plugins.bmp.BMPImageReader.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public Boolean run() {
                    return Boolean.valueOf(Boolean.getBoolean("sun.imageio.plugins.bmp.disableLinkedProfiles"));
                }
            });
        }
        return !isLinkedProfileDisabled.booleanValue();
    }

    private static boolean isUncOrDevicePath(byte[] bArr) {
        byte b;
        byte b5;
        byte b6;
        if (isWindowsPlatform == null) {
            isWindowsPlatform = (Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: com.sun.imageio.plugins.bmp.BMPImageReader.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public Boolean run() {
                    String property = System.getProperty(SystemProperties.OS_NAME);
                    return Boolean.valueOf(property != null && property.toLowerCase().startsWith("win"));
                }
            });
        }
        if (!isWindowsPlatform.booleanValue()) {
            return false;
        }
        if (bArr[0] == 47) {
            bArr[0] = 92;
        }
        if (bArr[1] == 47) {
            bArr[1] = 92;
        }
        if (bArr[3] == 47) {
            bArr[3] = 92;
        }
        if (bArr[0] == 92 && bArr[1] == 92) {
            return (bArr[2] == 63 && bArr[3] == 92 && (((b = bArr[4]) != 85 && b != 117) || (((b5 = bArr[5]) != 78 && b5 != 110) || ((b6 = bArr[6]) != 67 && b6 != 99)))) ? false : true;
        }
        return false;
    }

    private void read16Bit(short[] sArr) {
        int i = this.width;
        int i2 = (i * 2) % 4;
        if (i2 != 0) {
            i2 = 4 - i2;
        }
        int i4 = i2;
        int i5 = (i4 / 2) + i;
        if (this.noTransform) {
            int i6 = this.isBottomUp ? (this.height - 1) * i : 0;
            int i7 = 0;
            while (i7 < this.height && !abortRequested()) {
                this.iis.readFully(sArr, i6, this.width);
                this.iis.skipBytes(i4);
                int i8 = i6 + (this.isBottomUp ? -this.width : this.width);
                processImageUpdate(this.f8272bi, 0, i7, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                processImageProgress((i7 * 100.0f) / this.destinationRegion.height);
                i7++;
                i6 = i8;
            }
            return;
        }
        short[] sArr2 = new short[i5];
        int scanlineStride = ((SinglePixelPackedSampleModel) this.sampleModel).getScanlineStride();
        if (this.isBottomUp) {
            this.iis.skipBytes((((this.height - 1) - (((this.destinationRegion.height - 1) * this.scaleY) + this.sourceRegion.f10095y)) * i5) << 1);
        } else {
            this.iis.skipBytes((this.sourceRegion.f10095y * i5) << 1);
        }
        int i9 = ((this.scaleY - 1) * i5) << 1;
        Rectangle rectangle = this.destinationRegion;
        int iM1304A = rectangle.f10095y * scanlineStride;
        if (this.isBottomUp) {
            iM1304A = AbstractC1974b.m1304A(rectangle.height, 1, scanlineStride, iM1304A);
        }
        int i10 = iM1304A + rectangle.f10094x;
        int i11 = this.sourceRegion.f10095y;
        int i12 = 0;
        while (i12 < this.destinationRegion.height && !abortRequested()) {
            this.iis.readFully(sArr2, 0, i5);
            int i13 = this.sourceRegion.f10094x;
            int i14 = 0;
            while (i14 < this.destinationRegion.width) {
                sArr[i10 + i14] = sArr2[i13];
                i14++;
                i13 += this.scaleX;
            }
            int i15 = i10 + (this.isBottomUp ? -scanlineStride : scanlineStride);
            this.iis.skipBytes(i9);
            processImageUpdate(this.f8272bi, 0, i12, this.destinationRegion.width, 1, 1, 1, new int[]{0});
            processImageProgress((i12 * 100.0f) / this.destinationRegion.height);
            i12++;
            i10 = i15;
        }
    }

    private void read1Bit(byte[] bArr) {
        Rectangle rectangle;
        int i;
        int i2 = (this.width + 7) / 8;
        int i4 = i2 % 4;
        if (i4 != 0) {
            i4 = 4 - i4;
        }
        int i5 = i4;
        int i6 = i2 + i5;
        int i7 = 1;
        if (this.noTransform) {
            int i8 = this.isBottomUp ? (this.height - 1) * i2 : 0;
            int i9 = 0;
            while (i9 < this.height && !abortRequested()) {
                this.iis.readFully(bArr, i8, i2);
                this.iis.skipBytes(i5);
                int i10 = i8 + (this.isBottomUp ? -i2 : i2);
                processImageUpdate(this.f8272bi, 0, i9, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                processImageProgress((i9 * 100.0f) / this.destinationRegion.height);
                i9++;
                i8 = i10;
            }
            return;
        }
        byte[] bArr2 = new byte[i6];
        int scanlineStride = ((MultiPixelPackedSampleModel) this.sampleModel).getScanlineStride();
        if (this.isBottomUp) {
            this.iis.skipBytes(((this.height - 1) - (((this.destinationRegion.height - 1) * this.scaleY) + this.sourceRegion.f10095y)) * i6);
        } else {
            this.iis.skipBytes(this.sourceRegion.f10095y * i6);
        }
        int i11 = (this.scaleY - 1) * i6;
        Rectangle rectangle2 = this.destinationRegion;
        int i12 = rectangle2.width;
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[i12];
        int i13 = rectangle2.f10094x;
        int i14 = this.sourceRegion.f10094x;
        int i15 = 0;
        while (true) {
            rectangle = this.destinationRegion;
            i = i7;
            if (i13 >= rectangle.f10094x + rectangle.width) {
                break;
            }
            iArr3[i15] = i14 >> 3;
            iArr[i15] = 7 - (i14 & 7);
            iArr4[i15] = i13 >> 3;
            iArr2[i15] = 7 - (i13 & 7);
            i13++;
            i15++;
            i14 += this.scaleX;
            i7 = i;
        }
        int iM1304A = rectangle.f10095y * scanlineStride;
        if (this.isBottomUp) {
            iM1304A = AbstractC1974b.m1304A(rectangle.height, i, scanlineStride, iM1304A);
        }
        int i16 = this.sourceRegion.f10095y;
        int[] iArr5 = iArr4;
        int i17 = 0;
        while (i17 < this.destinationRegion.height && !abortRequested()) {
            this.iis.read(bArr2, 0, i6);
            for (int i18 = 0; i18 < this.destinationRegion.width; i18++) {
                int i19 = (bArr2[iArr3[i18]] >> iArr[i18]) & 1;
                int i20 = iArr5[i18] + iM1304A;
                bArr[i20] = (byte) ((i19 << iArr2[i18]) | bArr[i20]);
            }
            int i21 = iM1304A + (this.isBottomUp ? -scanlineStride : scanlineStride);
            this.iis.skipBytes(i11);
            processImageUpdate(this.f8272bi, 0, i17, this.destinationRegion.width, 1, 1, 1, new int[]{0});
            processImageProgress((i17 * 100.0f) / this.destinationRegion.height);
            i17++;
            iM1304A = i21;
            iArr5 = iArr5;
            iArr = iArr;
            i11 = i11;
            iArr2 = iArr2;
            iArr3 = iArr3;
        }
    }

    private void read24Bit(byte[] bArr) {
        int i = this.width;
        int i2 = (i * 3) % 4;
        if (i2 != 0) {
            i2 = 4 - i2;
        }
        int i4 = i2;
        int i5 = i * 3;
        int i6 = i5 + i4;
        if (this.noTransform) {
            int i7 = this.isBottomUp ? (this.height - 1) * i * 3 : 0;
            int i8 = 0;
            while (i8 < this.height && !abortRequested()) {
                this.iis.readFully(bArr, i7, i5);
                this.iis.skipBytes(i4);
                int i9 = i7 + (this.isBottomUp ? -i5 : i5);
                processImageUpdate(this.f8272bi, 0, i8, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                processImageProgress((i8 * 100.0f) / this.destinationRegion.height);
                i8++;
                i7 = i9;
            }
            return;
        }
        byte[] bArr2 = new byte[i6];
        int scanlineStride = ((ComponentSampleModel) this.sampleModel).getScanlineStride();
        if (this.isBottomUp) {
            this.iis.skipBytes(((this.height - 1) - (((this.destinationRegion.height - 1) * this.scaleY) + this.sourceRegion.f10095y)) * i6);
        } else {
            this.iis.skipBytes(this.sourceRegion.f10095y * i6);
        }
        int i10 = (this.scaleY - 1) * i6;
        Rectangle rectangle = this.destinationRegion;
        int iM1304A = rectangle.f10095y * scanlineStride;
        if (this.isBottomUp) {
            iM1304A = AbstractC1974b.m1304A(rectangle.height, 1, scanlineStride, iM1304A);
        }
        int i11 = (rectangle.f10094x * 3) + iM1304A;
        int i12 = this.sourceRegion.f10095y;
        int i13 = 0;
        while (i13 < this.destinationRegion.height && !abortRequested()) {
            this.iis.read(bArr2, 0, i6);
            int i14 = this.sourceRegion.f10094x * 3;
            int i15 = 0;
            while (i15 < this.destinationRegion.width) {
                int i16 = (i15 * 3) + i11;
                int i17 = 0;
                while (true) {
                    int[] iArr = this.destBands;
                    if (i17 < iArr.length) {
                        bArr[iArr[i17] + i16] = bArr2[this.sourceBands[i17] + i14];
                        i17++;
                    }
                }
                i15++;
                i14 += this.scaleX * 3;
            }
            int i18 = i11 + (this.isBottomUp ? -scanlineStride : scanlineStride);
            this.iis.skipBytes(i10);
            processImageUpdate(this.f8272bi, 0, i13, this.destinationRegion.width, 1, 1, 1, new int[]{0});
            processImageProgress((i13 * 100.0f) / this.destinationRegion.height);
            i13++;
            i11 = i18;
        }
    }

    private void read32Bit(int[] iArr) {
        if (this.noTransform) {
            int i = this.isBottomUp ? (this.height - 1) * this.width : 0;
            int i2 = 0;
            while (i2 < this.height && !abortRequested()) {
                this.iis.readFully(iArr, i, this.width);
                int i4 = i + (this.isBottomUp ? -this.width : this.width);
                processImageUpdate(this.f8272bi, 0, i2, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                processImageProgress((i2 * 100.0f) / this.destinationRegion.height);
                i2++;
                i = i4;
            }
            return;
        }
        int[] iArr2 = new int[this.width];
        int scanlineStride = ((SinglePixelPackedSampleModel) this.sampleModel).getScanlineStride();
        if (this.isBottomUp) {
            this.iis.skipBytes((((this.height - 1) - (((this.destinationRegion.height - 1) * this.scaleY) + this.sourceRegion.f10095y)) * this.width) << 2);
        } else {
            this.iis.skipBytes((this.width * this.sourceRegion.f10095y) << 2);
        }
        int i5 = ((this.scaleY - 1) * this.width) << 2;
        Rectangle rectangle = this.destinationRegion;
        int iM1304A = rectangle.f10095y * scanlineStride;
        if (this.isBottomUp) {
            iM1304A = AbstractC1974b.m1304A(rectangle.height, 1, scanlineStride, iM1304A);
        }
        int i6 = iM1304A + rectangle.f10094x;
        int i7 = this.sourceRegion.f10095y;
        int i8 = 0;
        while (i8 < this.destinationRegion.height && !abortRequested()) {
            this.iis.readFully(iArr2, 0, this.width);
            int i9 = this.sourceRegion.f10094x;
            int i10 = 0;
            while (i10 < this.destinationRegion.width) {
                iArr[i6 + i10] = iArr2[i9];
                i10++;
                i9 += this.scaleX;
            }
            int i11 = i6 + (this.isBottomUp ? -scanlineStride : scanlineStride);
            this.iis.skipBytes(i5);
            int i12 = i8;
            processImageUpdate(this.f8272bi, 0, i12, this.destinationRegion.width, 1, 1, 1, new int[]{0});
            processImageProgress((i12 * 100.0f) / this.destinationRegion.height);
            i8 = i12 + 1;
            i6 = i11;
        }
    }

    private void read4Bit(byte[] bArr) {
        Rectangle rectangle;
        int i;
        int i2 = 1;
        int i4 = (this.width + 1) / 2;
        int i5 = i4 % 4;
        if (i5 != 0) {
            i5 = 4 - i5;
        }
        int i6 = i5;
        int i7 = i4 + i6;
        if (this.noTransform) {
            int i8 = this.isBottomUp ? (this.height - 1) * i4 : 0;
            int i9 = 0;
            while (i9 < this.height && !abortRequested()) {
                this.iis.readFully(bArr, i8, i4);
                this.iis.skipBytes(i6);
                int i10 = i8 + (this.isBottomUp ? -i4 : i4);
                processImageUpdate(this.f8272bi, 0, i9, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                processImageProgress((i9 * 100.0f) / this.destinationRegion.height);
                i9++;
                i8 = i10;
            }
            return;
        }
        byte[] bArr2 = new byte[i7];
        int scanlineStride = ((MultiPixelPackedSampleModel) this.sampleModel).getScanlineStride();
        if (this.isBottomUp) {
            this.iis.skipBytes(((this.height - 1) - (((this.destinationRegion.height - 1) * this.scaleY) + this.sourceRegion.f10095y)) * i7);
        } else {
            this.iis.skipBytes(this.sourceRegion.f10095y * i7);
        }
        int i11 = (this.scaleY - 1) * i7;
        Rectangle rectangle2 = this.destinationRegion;
        int i12 = rectangle2.width;
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[i12];
        int i13 = rectangle2.f10094x;
        int i14 = this.sourceRegion.f10094x;
        int i15 = 0;
        while (true) {
            rectangle = this.destinationRegion;
            i = i2;
            if (i13 >= rectangle.f10094x + rectangle.width) {
                break;
            }
            iArr3[i15] = i14 >> 1;
            iArr[i15] = (1 - (i14 & 1)) << 2;
            iArr4[i15] = i13 >> 1;
            iArr2[i15] = (1 - (i13 & 1)) << 2;
            i13++;
            i15++;
            i14 += this.scaleX;
            i2 = i;
        }
        int iM1304A = rectangle.f10095y * scanlineStride;
        if (this.isBottomUp) {
            iM1304A = AbstractC1974b.m1304A(rectangle.height, i, scanlineStride, iM1304A);
        }
        int i16 = this.sourceRegion.f10095y;
        int[] iArr5 = iArr4;
        int i17 = 0;
        while (i17 < this.destinationRegion.height && !abortRequested()) {
            this.iis.read(bArr2, 0, i7);
            for (int i18 = 0; i18 < this.destinationRegion.width; i18++) {
                int i19 = (bArr2[iArr3[i18]] >> iArr[i18]) & 15;
                int i20 = iArr5[i18] + iM1304A;
                bArr[i20] = (byte) ((i19 << iArr2[i18]) | bArr[i20]);
            }
            int i21 = iM1304A + (this.isBottomUp ? -scanlineStride : scanlineStride);
            this.iis.skipBytes(i11);
            processImageUpdate(this.f8272bi, 0, i17, this.destinationRegion.width, 1, 1, 1, new int[]{0});
            processImageProgress((i17 * 100.0f) / this.destinationRegion.height);
            i17++;
            iM1304A = i21;
            iArr = iArr;
            iArr5 = iArr5;
            iArr2 = iArr2;
            iArr3 = iArr3;
        }
    }

    private void read8Bit(byte[] bArr) {
        int i = this.width;
        int i2 = i % 4;
        if (i2 != 0) {
            i2 = 4 - i2;
        }
        int i4 = i2;
        int i5 = i + i4;
        if (this.noTransform) {
            int i6 = this.isBottomUp ? (this.height - 1) * i : 0;
            int i7 = 0;
            while (i7 < this.height && !abortRequested()) {
                this.iis.readFully(bArr, i6, this.width);
                this.iis.skipBytes(i4);
                int i8 = i6 + (this.isBottomUp ? -this.width : this.width);
                processImageUpdate(this.f8272bi, 0, i7, this.destinationRegion.width, 1, 1, 1, new int[]{0});
                processImageProgress((i7 * 100.0f) / this.destinationRegion.height);
                i7++;
                i6 = i8;
            }
            return;
        }
        byte[] bArr2 = new byte[i5];
        int scanlineStride = ((ComponentSampleModel) this.sampleModel).getScanlineStride();
        if (this.isBottomUp) {
            this.iis.skipBytes(((this.height - 1) - (((this.destinationRegion.height - 1) * this.scaleY) + this.sourceRegion.f10095y)) * i5);
        } else {
            this.iis.skipBytes(this.sourceRegion.f10095y * i5);
        }
        int i9 = (this.scaleY - 1) * i5;
        Rectangle rectangle = this.destinationRegion;
        int iM1304A = rectangle.f10095y * scanlineStride;
        if (this.isBottomUp) {
            iM1304A = AbstractC1974b.m1304A(rectangle.height, 1, scanlineStride, iM1304A);
        }
        int i10 = iM1304A + rectangle.f10094x;
        int i11 = this.sourceRegion.f10095y;
        int i12 = 0;
        while (i12 < this.destinationRegion.height && !abortRequested()) {
            this.iis.read(bArr2, 0, i5);
            int i13 = this.sourceRegion.f10094x;
            int i14 = 0;
            while (i14 < this.destinationRegion.width) {
                bArr[i10 + i14] = bArr2[i13];
                i14++;
                i13 += this.scaleX;
            }
            int i15 = i10 + (this.isBottomUp ? -scanlineStride : scanlineStride);
            this.iis.skipBytes(i9);
            processImageUpdate(this.f8272bi, 0, i12, this.destinationRegion.width, 1, 1, 1, new int[]{0});
            processImageProgress((i12 * 100.0f) / this.destinationRegion.height);
            i12++;
            i10 = i15;
        }
    }

    private BufferedImage readEmbedded(int i, BufferedImage bufferedImage, ImageReadParam imageReadParam) throws IOException {
        String str;
        if (i == 4) {
            str = "JPEG";
        } else {
            if (i != 5) {
                throw new IOException(AbstractC0000a.m11h(i, "Unexpected compression type: "));
            }
            str = "PNG";
        }
        ImageReader next = ImageIO.getImageReadersByFormatName(str).next();
        if (next == null) {
            throw new RuntimeException(I18N.getString("BMPImageReader4") + " " + str);
        }
        byte[] bArr = new byte[(int) this.imageSize];
        this.iis.read(bArr);
        next.setInput(ImageIO.createImageInputStream(new ByteArrayInputStream(bArr)));
        if (bufferedImage == null) {
            ImageTypeSpecifier next2 = next.getImageTypes(0).next();
            Rectangle rectangle = this.destinationRegion;
            bufferedImage = next2.createBufferedImage(rectangle.f10094x + rectangle.width, rectangle.f10095y + rectangle.height);
        }
        next.addIIOReadProgressListener(new EmbeddedProgressAdapter() { // from class: com.sun.imageio.plugins.bmp.BMPImageReader.1
            @Override // com.sun.imageio.plugins.bmp.BMPImageReader.EmbeddedProgressAdapter, org.apache.poi.javax.imageio.event.IIOReadProgressListener
            public void imageProgress(ImageReader imageReader, float f) {
                BMPImageReader.this.processImageProgress(f);
            }
        });
        next.addIIOReadUpdateListener(new IIOReadUpdateListener() { // from class: com.sun.imageio.plugins.bmp.BMPImageReader.2
            @Override // org.apache.poi.javax.imageio.event.IIOReadUpdateListener
            public void imageUpdate(ImageReader imageReader, BufferedImage bufferedImage2, int i2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
                BMPImageReader.this.processImageUpdate(bufferedImage2, i2, i4, i5, i6, i7, i8, iArr);
            }

            @Override // org.apache.poi.javax.imageio.event.IIOReadUpdateListener
            public void passComplete(ImageReader imageReader, BufferedImage bufferedImage2) {
                BMPImageReader.this.processPassComplete(bufferedImage2);
            }

            @Override // org.apache.poi.javax.imageio.event.IIOReadUpdateListener
            public void passStarted(ImageReader imageReader, BufferedImage bufferedImage2, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
                BMPImageReader.this.processPassStarted(bufferedImage2, i2, i4, i5, i6, i7, i8, i9, iArr);
            }

            @Override // org.apache.poi.javax.imageio.event.IIOReadUpdateListener
            public void thumbnailPassComplete(ImageReader imageReader, BufferedImage bufferedImage2) {
            }

            @Override // org.apache.poi.javax.imageio.event.IIOReadUpdateListener
            public void thumbnailPassStarted(ImageReader imageReader, BufferedImage bufferedImage2, int i2, int i4, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
            }

            @Override // org.apache.poi.javax.imageio.event.IIOReadUpdateListener
            public void thumbnailUpdate(ImageReader imageReader, BufferedImage bufferedImage2, int i2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
            }
        });
        next.addIIOReadWarningListener(new IIOReadWarningListener() { // from class: com.sun.imageio.plugins.bmp.BMPImageReader.3
            @Override // org.apache.poi.javax.imageio.event.IIOReadWarningListener
            public void warningOccurred(ImageReader imageReader, String str2) {
                BMPImageReader.this.processWarningOccurred(str2);
            }
        });
        ImageReadParam defaultReadParam = next.getDefaultReadParam();
        defaultReadParam.setDestination(bufferedImage);
        defaultReadParam.setDestinationBands(imageReadParam.getDestinationBands());
        defaultReadParam.setDestinationOffset(imageReadParam.getDestinationOffset());
        defaultReadParam.setSourceBands(imageReadParam.getSourceBands());
        defaultReadParam.setSourceRegion(imageReadParam.getSourceRegion());
        defaultReadParam.setSourceSubsampling(imageReadParam.getSourceXSubsampling(), imageReadParam.getSourceYSubsampling(), imageReadParam.getSubsamplingXOffset(), imageReadParam.getSubsamplingYOffset());
        next.read(0, defaultReadParam);
        return bufferedImage;
    }

    private void readRLE4(byte[] bArr) {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        int i2 = this.width % 4;
        int i4 = i2 != 0 ? 4 - i2 : 0;
        byte[] bArr2 = new byte[i];
        this.iis.readFully(bArr2, 0, i);
        decodeRLE4(i, i4, bArr2, bArr);
    }

    private void readRLE8(byte[] bArr) {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        int i2 = this.width % 4;
        int i4 = i2 != 0 ? 4 - i2 : 0;
        byte[] bArr2 = new byte[i];
        this.iis.readFully(bArr2, 0, i);
        decodeRLE8(i, i4, bArr2, bArr);
    }

    private void resetHeaderInfo() {
        this.gotHeader = false;
        this.f8272bi = null;
        this.originalSampleModel = null;
        this.sampleModel = null;
        this.originalColorModel = null;
        this.colorModel = null;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public boolean canReadRaster() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public ImageReadParam getDefaultReadParam() {
        return new ImageReadParam();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getHeight(int i) throws IIOException {
        checkIndex(i);
        try {
            readHeader();
            return this.height;
        } catch (IllegalArgumentException e) {
            throw new IIOException(I18N.getString("BMPImageReader6"), e);
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getImageMetadata(int i) throws IIOException {
        checkIndex(i);
        if (this.metadata == null) {
            try {
                readHeader();
            } catch (IllegalArgumentException e) {
                throw new IIOException(I18N.getString("BMPImageReader6"), e);
            }
        }
        return this.metadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public Iterator getImageTypes(int i) throws IIOException {
        checkIndex(i);
        try {
            readHeader();
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new ImageTypeSpecifier(this.originalColorModel, this.originalSampleModel));
            return arrayList.iterator();
        } catch (IllegalArgumentException e) {
            throw new IIOException(I18N.getString("BMPImageReader6"), e);
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getNumImages(boolean z) {
        if (this.iis == null) {
            throw new IllegalStateException(I18N.getString("GetNumImages0"));
        }
        if (this.seekForwardOnly && z) {
            throw new IllegalStateException(I18N.getString("GetNumImages1"));
        }
        return 1;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getStreamMetadata() {
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getWidth(int i) throws IIOException {
        checkIndex(i);
        try {
            readHeader();
            return this.width;
        } catch (IllegalArgumentException e) {
            throw new IIOException(I18N.getString("BMPImageReader6"), e);
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public boolean isRandomAccessEasy(int i) throws IIOException {
        checkIndex(i);
        try {
            readHeader();
            return this.metadata.compression == 0;
        } catch (IllegalArgumentException e) {
            throw new IIOException(I18N.getString("BMPImageReader6"), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f6  */
    @Override // org.apache.poi.javax.imageio.ImageReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BufferedImage read(int i, ImageReadParam imageReadParam) throws IIOException {
        WritableRaster writableTile;
        short[] data;
        int[] data2;
        int i2;
        if (this.iis == null) {
            throw new IllegalStateException(I18N.getString("BMPImageReader5"));
        }
        checkIndex(i);
        clearAbortRequest();
        processImageStarted(i);
        if (imageReadParam == null) {
            imageReadParam = getDefaultReadParam();
        }
        ImageReadParam imageReadParam2 = imageReadParam;
        try {
            readHeader();
            this.sourceRegion = new Rectangle(0, 0, 0, 0);
            this.destinationRegion = new Rectangle(0, 0, 0, 0);
            ImageReader.computeRegions(imageReadParam2, this.width, this.height, imageReadParam2.getDestination(), this.sourceRegion, this.destinationRegion);
            this.scaleX = imageReadParam2.getSourceXSubsampling();
            this.scaleY = imageReadParam2.getSourceYSubsampling();
            this.sourceBands = imageReadParam2.getSourceBands();
            int[] destinationBands = imageReadParam2.getDestinationBands();
            this.destBands = destinationBands;
            this.seleBand = (this.sourceBands == null || destinationBands == null) ? false : true;
            this.noTransform = this.destinationRegion.equals(new Rectangle(0, 0, this.width, this.height)) || this.seleBand;
            if (!this.seleBand) {
                int i4 = this.numBands;
                this.sourceBands = new int[i4];
                this.destBands = new int[i4];
                for (int i5 = 0; i5 < this.numBands; i5++) {
                    int[] iArr = this.destBands;
                    this.sourceBands[i5] = i5;
                    iArr[i5] = i5;
                }
            }
            BufferedImage destination = imageReadParam2.getDestination();
            this.f8272bi = destination;
            byte[] data3 = null;
            if (destination == null) {
                SampleModel sampleModel = this.sampleModel;
                if (sampleModel == null || this.colorModel == null) {
                    writableTile = null;
                } else {
                    Rectangle rectangle = this.destinationRegion;
                    SampleModel sampleModelCreateCompatibleSampleModel = sampleModel.createCompatibleSampleModel(rectangle.f10094x + rectangle.width, rectangle.f10095y + rectangle.height);
                    this.sampleModel = sampleModelCreateCompatibleSampleModel;
                    if (this.seleBand) {
                        this.sampleModel = sampleModelCreateCompatibleSampleModel.createSubsetSampleModel(this.sourceBands);
                    }
                    writableTile = Raster.createWritableRaster(this.sampleModel, new Point());
                    this.f8272bi = new BufferedImage(this.colorModel, writableTile, false, (Hashtable<?, ?>) null);
                }
            } else {
                writableTile = destination.getWritableTile(0, 0);
                this.sampleModel = this.f8272bi.getSampleModel();
                this.colorModel = this.f8272bi.getColorModel();
                this.noTransform &= this.destinationRegion.equals(writableTile.getBounds());
            }
            SampleModel sampleModel2 = this.sampleModel;
            if (sampleModel2 == null) {
                data = null;
                data2 = null;
            } else if (sampleModel2.getDataType() == 0) {
                data2 = null;
                data3 = ((DataBufferByte) writableTile.getDataBuffer()).getData();
                data = null;
            } else if (this.sampleModel.getDataType() == 1) {
                data = ((DataBufferUShort) writableTile.getDataBuffer()).getData();
                data2 = null;
            } else if (this.sampleModel.getDataType() == 3) {
                data2 = ((DataBufferInt) writableTile.getDataBuffer()).getData();
                data = null;
            }
            switch (this.imageType) {
                case 0:
                    read1Bit(data3);
                    if (abortRequested()) {
                        processImageComplete();
                    } else {
                        processReadAborted();
                    }
                    return this.f8272bi;
                case 1:
                    read4Bit(data3);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 2:
                    read8Bit(data3);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 3:
                    read24Bit(data3);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 4:
                    read1Bit(data3);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 5:
                    int i6 = (int) this.compression;
                    if (i6 == 0) {
                        read4Bit(data3);
                    } else {
                        if (i6 != 2) {
                            throw new IIOException(I18N.getString("BMPImageReader1"));
                        }
                        readRLE4(data3);
                    }
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 6:
                    int i7 = (int) this.compression;
                    if (i7 == 0) {
                        read8Bit(data3);
                    } else {
                        if (i7 != 1) {
                            throw new IIOException(I18N.getString("BMPImageReader1"));
                        }
                        readRLE8(data3);
                    }
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 7:
                    read24Bit(data3);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 8:
                    read16Bit(data);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 9:
                    read32Bit(data2);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 10:
                    read1Bit(data3);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 11:
                    int i8 = (int) this.compression;
                    if (i8 == 0) {
                        read4Bit(data3);
                    } else {
                        if (i8 != 2) {
                            throw new IIOException(I18N.getString("BMPImageReader1"));
                        }
                        readRLE4(data3);
                    }
                    i2 = (int) this.compression;
                    if (i2 != 0) {
                        read8Bit(data3);
                    } else {
                        if (i2 != 1) {
                            throw new IIOException(I18N.getString("BMPImageReader1"));
                        }
                        readRLE8(data3);
                    }
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 12:
                    i2 = (int) this.compression;
                    if (i2 != 0) {
                    }
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 13:
                    read16Bit(data);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 14:
                    read24Bit(data3);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 15:
                    read32Bit(data2);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                case 16:
                case 17:
                case 18:
                    this.f8272bi = readEmbedded((int) this.compression, this.f8272bi, imageReadParam2);
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
                default:
                    if (abortRequested()) {
                    }
                    return this.f8272bi;
            }
        } catch (IllegalArgumentException e) {
            throw new IIOException(I18N.getString("BMPImageReader6"), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x042b A[Catch: Exception -> 0x0435, TRY_LEAVE, TryCatch #0 {Exception -> 0x0435, blocks: (B:139:0x0406, B:141:0x040d, B:143:0x0413, B:145:0x0419, B:146:0x042b), top: B:227:0x0406 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05ba A[LOOP:3: B:212:0x05b8->B:213:0x05ba, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x05ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void readHeader() throws IIOException {
        long j;
        int i;
        long j2;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        long j3;
        int i8;
        ColorSpace colorSpace;
        int i9;
        byte[] bArr;
        int i10;
        int i11;
        int i12;
        long j5;
        int i13;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        int i14;
        int[] iArr;
        if (this.gotHeader) {
            return;
        }
        if (this.iis == null) {
            throw new IllegalStateException("Input source not set!");
        }
        this.metadata = new BMPMetadata();
        this.iis.mark();
        byte[] bArr7 = new byte[2];
        this.iis.read(bArr7);
        if (bArr7[0] != 66 || bArr7[1] != 77) {
            throw new IllegalArgumentException(I18N.getString("BMPImageReader1"));
        }
        this.bitmapFileSize = this.iis.readUnsignedInt();
        this.iis.skipBytes(4);
        this.bitmapOffset = this.iis.readUnsignedInt();
        long unsignedInt = this.iis.readUnsignedInt();
        if (unsignedInt == 12) {
            this.width = this.iis.readShort();
            this.height = this.iis.readShort();
        } else {
            this.width = this.iis.readInt();
            this.height = this.iis.readInt();
        }
        BMPMetadata bMPMetadata = this.metadata;
        bMPMetadata.width = this.width;
        bMPMetadata.height = this.height;
        this.iis.readUnsignedShort();
        int unsignedShort = this.iis.readUnsignedShort();
        this.bitsPerPixel = unsignedShort;
        BMPMetadata bMPMetadata2 = this.metadata;
        bMPMetadata2.bitsPerPixel = (short) unsignedShort;
        this.numBands = 3;
        if (unsignedInt == 12) {
            bMPMetadata2.bmpVersion = BMPConstants.VERSION_2;
            if (unsignedShort == 1) {
                this.imageType = 0;
            } else if (unsignedShort == 4) {
                this.imageType = 1;
            } else if (unsignedShort == 8) {
                this.imageType = 2;
            } else if (unsignedShort == 24) {
                this.imageType = 3;
            }
            int i15 = (int) (((this.bitmapOffset - 14) - unsignedInt) / 3);
            int i16 = i15 * 3;
            byte[] bArr8 = new byte[i16];
            this.palette = bArr8;
            this.iis.readFully(bArr8, 0, i16);
            BMPMetadata bMPMetadata3 = this.metadata;
            bMPMetadata3.palette = this.palette;
            bMPMetadata3.paletteSize = i15;
            j = unsignedInt;
        } else {
            this.compression = this.iis.readUnsignedInt();
            this.imageSize = this.iis.readUnsignedInt();
            long j6 = this.iis.readInt();
            long j7 = this.iis.readInt();
            long unsignedInt2 = this.iis.readUnsignedInt();
            j = unsignedInt;
            long unsignedInt3 = this.iis.readUnsignedInt();
            BMPMetadata bMPMetadata4 = this.metadata;
            long j8 = this.compression;
            bMPMetadata4.compression = (int) j8;
            bMPMetadata4.xPixelsPerMeter = (int) j6;
            bMPMetadata4.yPixelsPerMeter = (int) j7;
            int i17 = (int) unsignedInt2;
            bMPMetadata4.colorsUsed = i17;
            bMPMetadata4.colorsImportant = (int) unsignedInt3;
            if (j != 40) {
                if (j != 108 && j != 124) {
                    throw new IIOException(I18N.getString("BMPImageReader3"));
                }
                if (j == 108) {
                    bMPMetadata4.bmpVersion = BMPConstants.VERSION_4;
                } else if (j == 124) {
                    bMPMetadata4.bmpVersion = BMPConstants.VERSION_5;
                }
                this.redMask = (int) this.iis.readUnsignedInt();
                this.greenMask = (int) this.iis.readUnsignedInt();
                this.blueMask = (int) this.iis.readUnsignedInt();
                this.alphaMask = (int) this.iis.readUnsignedInt();
                long unsignedInt4 = this.iis.readUnsignedInt();
                int i18 = this.iis.readInt();
                int i19 = this.iis.readInt();
                int i20 = this.iis.readInt();
                int i21 = this.iis.readInt();
                int i22 = this.iis.readInt();
                i = 2;
                int i23 = this.iis.readInt();
                int i24 = this.iis.readInt();
                int i25 = this.iis.readInt();
                int i26 = this.iis.readInt();
                long unsignedInt5 = this.iis.readUnsignedInt();
                long unsignedInt6 = this.iis.readUnsignedInt();
                long unsignedInt7 = this.iis.readUnsignedInt();
                int i27 = (j > 124L ? 1 : (j == 124L ? 0 : -1));
                if (i27 == 0) {
                    i2 = i27;
                    j2 = unsignedInt7;
                    this.metadata.intent = this.iis.readInt();
                    int i28 = this.iis.readInt();
                    i4 = this.iis.readInt();
                    i5 = i28;
                    this.iis.skipBytes(4);
                } else {
                    j2 = unsignedInt7;
                    i2 = i27;
                    i4 = 0;
                    i5 = 0;
                }
                BMPMetadata bMPMetadata5 = this.metadata;
                bMPMetadata5.colorSpace = (int) unsignedInt4;
                if (unsignedInt4 == 0) {
                    bMPMetadata5.redX = i18;
                    bMPMetadata5.redY = i19;
                    bMPMetadata5.redZ = i20;
                    bMPMetadata5.greenX = i21;
                    bMPMetadata5.greenY = i22;
                    bMPMetadata5.greenZ = i23;
                    bMPMetadata5.blueX = i24;
                    bMPMetadata5.blueY = i25;
                    bMPMetadata5.blueZ = i26;
                    bMPMetadata5.gammaRed = (int) unsignedInt5;
                    bMPMetadata5.gammaGreen = (int) unsignedInt6;
                    bMPMetadata5.gammaBlue = (int) j2;
                }
                int i29 = (int) (((this.bitmapOffset - 14) - j) / 4);
                int i30 = i29 * 4;
                byte[] bArr9 = new byte[i30];
                this.palette = bArr9;
                this.iis.readFully(bArr9, 0, i30);
                BMPMetadata bMPMetadata6 = this.metadata;
                bMPMetadata6.palette = this.palette;
                bMPMetadata6.paletteSize = i29;
                long j9 = this.compression;
                int i31 = (int) j9;
                if (i31 != 4 && i31 != 5) {
                    int i32 = this.bitsPerPixel;
                    if (i32 == 1) {
                        this.imageType = 10;
                    } else if (i32 == 4) {
                        this.imageType = 11;
                    } else if (i32 == 8) {
                        this.imageType = 12;
                    } else if (i32 == 16) {
                        this.imageType = 13;
                        if (((int) j9) == 0) {
                            this.redMask = 31744;
                            this.greenMask = 992;
                            this.blueMask = 31;
                        }
                    } else if (i32 == 24) {
                        this.imageType = 14;
                    } else if (i32 == 32) {
                        this.imageType = 15;
                        if (((int) j9) == 0) {
                            this.redMask = 16711680;
                            this.greenMask = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                            this.blueMask = 255;
                        }
                    }
                    bMPMetadata6.redMask = this.redMask;
                    bMPMetadata6.greenMask = this.greenMask;
                    bMPMetadata6.blueMask = this.blueMask;
                    bMPMetadata6.alphaMask = this.alphaMask;
                } else if (j == 108) {
                    this.imageType = 17;
                } else if (i2 == 0) {
                    this.imageType = 18;
                }
                i6 = i5;
                i8 = this.height;
                if (i8 <= 0) {
                    this.isBottomUp = true;
                } else {
                    this.isBottomUp = false;
                    this.height = Math.abs(i8);
                }
                colorSpace = ColorSpace.getInstance(1000);
                i9 = this.metadata.colorSpace;
                if (i9 != 3 || i9 == 4) {
                    this.iis.mark();
                    this.iis.skipBytes(((long) i6) - j);
                    bArr = new byte[i4];
                    this.iis.readFully(bArr, 0, i4);
                    this.iis.reset();
                    try {
                        colorSpace = (this.metadata.colorSpace == 3 || !isLinkedProfileAllowed() || isUncOrDevicePath(bArr)) ? new ICC_ColorSpace(ICC_Profile.getInstance(bArr)) : new ICC_ColorSpace(ICC_Profile.getInstance(new String(bArr, "windows-1252")));
                    } catch (Exception unused) {
                        colorSpace = ColorSpace.getInstance(1000);
                    }
                }
                ColorSpace colorSpace2 = colorSpace;
                i10 = this.bitsPerPixel;
                if (i10 == 0) {
                    long j10 = this.compression;
                    if (j10 == 4 || j10 == 5) {
                        this.colorModel = null;
                        this.sampleModel = null;
                    } else {
                        int i33 = 1;
                        if (i10 == 1) {
                            this.numBands = i33;
                            if (i10 != 8) {
                                int[] iArr2 = new int[i33];
                                int i34 = 0;
                                while (true) {
                                    int i35 = this.numBands;
                                    if (i34 >= i35) {
                                        break;
                                    }
                                    iArr2[i34] = (i35 - 1) - i34;
                                    i34++;
                                }
                                int i36 = this.width;
                                int i37 = this.height;
                                int i38 = this.numBands;
                                this.sampleModel = new PixelInterleavedSampleModel(0, i36, i37, i38, i38 * i36, iArr2);
                                i11 = 0;
                            } else {
                                i11 = 0;
                                this.sampleModel = new MultiPixelPackedSampleModel(0, this.width, this.height, this.bitsPerPixel);
                            }
                            i12 = this.imageType;
                            if (i12 != 0 || i12 == 1 || i12 == i) {
                                long length = this.palette.length / 3;
                                j5 = length <= 256 ? length : 256L;
                                i13 = (int) j5;
                                bArr2 = new byte[i13];
                                bArr3 = new byte[i13];
                                byte[] bArr10 = new byte[i13];
                                while (i11 < i13) {
                                    int i39 = i11 * 3;
                                    byte[] bArr11 = this.palette;
                                    bArr10[i11] = bArr11[i39];
                                    bArr3[i11] = bArr11[i39 + 1];
                                    bArr2[i11] = bArr11[i39 + 2];
                                    i11++;
                                }
                                bArr4 = bArr10;
                            } else {
                                long length2 = this.palette.length / 4;
                                j5 = length2 <= 256 ? length2 : 256L;
                                int i40 = (int) j5;
                                bArr2 = new byte[i40];
                                bArr3 = new byte[i40];
                                byte[] bArr12 = new byte[i40];
                                while (i11 < j5) {
                                    int i41 = i11 * 4;
                                    byte[] bArr13 = this.palette;
                                    bArr12[i11] = bArr13[i41];
                                    bArr3[i11] = bArr13[i41 + 1];
                                    bArr2[i11] = bArr13[i41 + 2];
                                    i11++;
                                }
                                bArr4 = bArr12;
                            }
                            bArr5 = bArr2;
                            bArr6 = bArr3;
                            if (ImageUtil.isIndicesForGrayscale(bArr5, bArr6, bArr4)) {
                                this.colorModel = new IndexColorModel(this.bitsPerPixel, (int) j5, bArr5, bArr6, bArr4);
                            } else {
                                this.colorModel = ImageUtil.createColorModel(null, this.sampleModel);
                            }
                        } else if (i10 == 4 || i10 == 8) {
                            i33 = 1;
                            this.numBands = i33;
                            if (i10 != 8) {
                            }
                            i12 = this.imageType;
                            if (i12 != 0) {
                                long length3 = this.palette.length / 3;
                                if (length3 <= 256) {
                                }
                                i13 = (int) j5;
                                bArr2 = new byte[i13];
                                bArr3 = new byte[i13];
                                byte[] bArr102 = new byte[i13];
                                while (i11 < i13) {
                                }
                                bArr4 = bArr102;
                                bArr5 = bArr2;
                                bArr6 = bArr3;
                                if (ImageUtil.isIndicesForGrayscale(bArr5, bArr6, bArr4)) {
                                }
                            }
                        } else if (i10 == 16) {
                            this.numBands = 3;
                            this.sampleModel = new SinglePixelPackedSampleModel(1, this.width, this.height, new int[]{this.redMask, this.greenMask, this.blueMask});
                            this.colorModel = new DirectColorModel(colorSpace2, 16, this.redMask, this.greenMask, this.blueMask, 0, false, 1);
                        } else if (i10 == 32) {
                            int i42 = this.alphaMask;
                            int i43 = i42 == 0 ? 3 : 4;
                            this.numBands = i43;
                            if (i43 == 3) {
                                iArr = new int[3];
                                iArr[0] = this.redMask;
                                iArr[1] = this.greenMask;
                                iArr[i] = this.blueMask;
                                i14 = 3;
                            } else {
                                int[] iArr3 = new int[4];
                                iArr3[0] = this.redMask;
                                iArr3[1] = this.greenMask;
                                iArr3[i] = this.blueMask;
                                i14 = 3;
                                iArr3[3] = i42;
                                iArr = iArr3;
                            }
                            this.sampleModel = new SinglePixelPackedSampleModel(i14, this.width, this.height, iArr);
                            this.colorModel = new DirectColorModel(colorSpace2, 32, this.redMask, this.greenMask, this.blueMask, this.alphaMask, false, 3);
                        } else {
                            this.numBands = 3;
                            int[] iArr4 = new int[3];
                            int i44 = 0;
                            while (true) {
                                int i45 = this.numBands;
                                if (i44 >= i45) {
                                    break;
                                }
                                iArr4[i44] = (i45 - 1) - i44;
                                i44++;
                            }
                            int i46 = this.width;
                            int i47 = this.height;
                            int i48 = this.numBands;
                            PixelInterleavedSampleModel pixelInterleavedSampleModel = new PixelInterleavedSampleModel(0, i46, i47, i48, i48 * i46, iArr4);
                            this.sampleModel = pixelInterleavedSampleModel;
                            this.colorModel = ImageUtil.createColorModel(colorSpace2, pixelInterleavedSampleModel);
                        }
                    }
                }
                this.originalSampleModel = this.sampleModel;
                this.originalColorModel = this.colorModel;
                this.iis.reset();
                this.iis.skipBytes(this.bitmapOffset);
                this.gotHeader = true;
            }
            int i49 = (int) j8;
            if (i49 != 0) {
                j3 = 14;
                if (i49 == 1 || i49 == 2) {
                    i7 = 5;
                } else if (i49 == 3) {
                    int i50 = this.bitsPerPixel;
                    if (i50 == 16) {
                        this.imageType = 8;
                    } else if (i50 == 32) {
                        this.imageType = 9;
                    }
                    this.redMask = (int) this.iis.readUnsignedInt();
                    this.greenMask = (int) this.iis.readUnsignedInt();
                    int unsignedInt8 = (int) this.iis.readUnsignedInt();
                    this.blueMask = unsignedInt8;
                    BMPMetadata bMPMetadata7 = this.metadata;
                    bMPMetadata7.redMask = this.redMask;
                    bMPMetadata7.greenMask = this.greenMask;
                    bMPMetadata7.blueMask = unsignedInt8;
                    if (unsignedInt2 != 0) {
                        int i51 = i17 * 4;
                        byte[] bArr14 = new byte[i51];
                        this.palette = bArr14;
                        this.iis.readFully(bArr14, 0, i51);
                        BMPMetadata bMPMetadata8 = this.metadata;
                        bMPMetadata8.palette = this.palette;
                        bMPMetadata8.paletteSize = i17;
                    }
                    this.metadata.bmpVersion = BMPConstants.VERSION_3_NT;
                } else {
                    if (i49 != 4 && i49 != 5) {
                        throw new IIOException(I18N.getString("BMPImageReader2"));
                    }
                    bMPMetadata4.bmpVersion = BMPConstants.VERSION_3;
                    this.imageType = 16;
                }
            } else {
                i7 = 5;
                j3 = 14;
            }
            long j11 = this.bitmapOffset;
            if (j11 < j + j3) {
                throw new IIOException(I18N.getString("BMPImageReader7"));
            }
            int i52 = (int) (((j11 - j3) - j) / 4);
            int i53 = i52 * 4;
            byte[] bArr15 = new byte[i53];
            this.palette = bArr15;
            this.iis.readFully(bArr15, 0, i53);
            BMPMetadata bMPMetadata9 = this.metadata;
            bMPMetadata9.palette = this.palette;
            bMPMetadata9.paletteSize = i52;
            int i54 = this.bitsPerPixel;
            if (i54 == 1) {
                this.imageType = 4;
            } else if (i54 == 4) {
                this.imageType = i7;
            } else if (i54 == 8) {
                this.imageType = 6;
            } else if (i54 == 24) {
                this.imageType = 7;
            } else if (i54 == 16) {
                this.imageType = 8;
                this.redMask = 31744;
                this.greenMask = 992;
                this.blueMask = 31;
                bMPMetadata9.redMask = 31744;
                bMPMetadata9.greenMask = 992;
                bMPMetadata9.blueMask = 31;
            } else if (i54 == 32) {
                this.imageType = 9;
                this.redMask = 16711680;
                this.greenMask = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                this.blueMask = 255;
                bMPMetadata9.redMask = 16711680;
                bMPMetadata9.greenMask = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
                bMPMetadata9.blueMask = 255;
            }
            bMPMetadata9.bmpVersion = BMPConstants.VERSION_3;
        }
        i = 2;
        i6 = 0;
        i4 = 0;
        i8 = this.height;
        if (i8 <= 0) {
        }
        colorSpace = ColorSpace.getInstance(1000);
        i9 = this.metadata.colorSpace;
        if (i9 != 3) {
            this.iis.mark();
            this.iis.skipBytes(((long) i6) - j);
            bArr = new byte[i4];
            this.iis.readFully(bArr, 0, i4);
            this.iis.reset();
            if (this.metadata.colorSpace == 3) {
            }
        }
        ColorSpace colorSpace22 = colorSpace;
        i10 = this.bitsPerPixel;
        if (i10 == 0) {
        }
        this.originalSampleModel = this.sampleModel;
        this.originalColorModel = this.colorModel;
        this.iis.reset();
        this.iis.skipBytes(this.bitmapOffset);
        this.gotHeader = true;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public Raster readRaster(int i, ImageReadParam imageReadParam) {
        return read(i, imageReadParam).getData();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void reset() {
        super.reset();
        this.iis = null;
        resetHeaderInfo();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void setInput(Object obj, boolean z, boolean z2) {
        super.setInput(obj, z, z2);
        ImageInputStream imageInputStream = (ImageInputStream) obj;
        this.iis = imageInputStream;
        if (imageInputStream != null) {
            imageInputStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        }
        resetHeaderInfo();
    }
}
