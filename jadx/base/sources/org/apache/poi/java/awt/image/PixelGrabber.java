package org.apache.poi.java.awt.image;

import java.util.Hashtable;
import org.apache.poi.java.awt.Image;

/* JADX INFO: loaded from: classes10.dex */
public class PixelGrabber implements ImageConsumer {
    private static final int DONEBITS = 112;
    private static final int GRABBEDBITS = 48;
    byte[] bytePixels;
    int dstH;
    int dstOff;
    int dstScan;
    int dstW;
    int dstX;
    int dstY;
    private int flags;
    private boolean grabbing;
    ColorModel imageModel;
    int[] intPixels;
    ImageProducer producer;

    public PixelGrabber(Image image, int i, int i2, int i4, int i5, boolean z) {
        this.producer = image.getSource();
        this.dstX = i;
        this.dstY = i2;
        this.dstW = i4;
        this.dstH = i5;
        if (z) {
            this.imageModel = ColorModel.getRGBdefault();
        }
    }

    private void convertToRGB() {
        int i = this.dstW * this.dstH;
        int[] iArr = new int[i];
        if (this.bytePixels != null) {
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = this.imageModel.getRGB(this.bytePixels[i2] & 255);
            }
        } else if (this.intPixels != null) {
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.imageModel.getRGB(this.intPixels[i4]);
            }
        }
        this.bytePixels = null;
        this.intPixels = iArr;
        this.dstScan = this.dstW;
        this.dstOff = 0;
        this.imageModel = ColorModel.getRGBdefault();
    }

    public synchronized void abortGrabbing() {
        imageComplete(4);
    }

    public synchronized ColorModel getColorModel() {
        return this.imageModel;
    }

    public synchronized int getHeight() {
        int i;
        i = this.dstH;
        if (i < 0) {
            i = -1;
        }
        return i;
    }

    public synchronized Object getPixels() {
        Object obj;
        obj = this.bytePixels;
        if (obj == null) {
            obj = this.intPixels;
        }
        return obj;
    }

    public synchronized int getStatus() {
        return this.flags;
    }

    public synchronized int getWidth() {
        int i;
        i = this.dstW;
        if (i < 0) {
            i = -1;
        }
        return i;
    }

    public boolean grabPixels() {
        return grabPixels(0L);
    }

    public synchronized void imageComplete(int i) {
        try {
            this.grabbing = false;
            if (i == 2) {
                this.flags |= 16;
            } else if (i == 3) {
                this.flags |= 32;
            } else if (i != 4) {
                this.flags |= 192;
            } else {
                this.flags |= 128;
            }
            this.producer.removeConsumer(this);
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setDimensions(int i, int i2) {
        if (this.dstW < 0) {
            this.dstW = i - this.dstX;
        }
        if (this.dstH < 0) {
            this.dstH = i2 - this.dstY;
        }
        if (this.dstW <= 0 || this.dstH <= 0) {
            imageComplete(3);
        } else if (this.intPixels == null && this.imageModel == ColorModel.getRGBdefault()) {
            int i4 = this.dstW;
            this.intPixels = new int[this.dstH * i4];
            this.dstScan = i4;
            this.dstOff = 0;
        }
        this.flags |= 3;
    }

    public void setPixels(int i, int i2, int i4, int i5, ColorModel colorModel, byte[] bArr, int i6, int i7) {
        int i8 = this.dstY;
        if (i2 < i8) {
            int i9 = i8 - i2;
            if (i9 >= i5) {
                return;
            }
            i6 += i7 * i9;
            i2 += i9;
            i5 -= i9;
        }
        int i10 = i2 + i5;
        int i11 = this.dstH;
        if (i10 <= i8 + i11 || (i5 = (i8 + i11) - i2) > 0) {
            int i12 = this.dstX;
            if (i < i12) {
                int i13 = i12 - i;
                if (i13 >= i4) {
                    return;
                }
                i6 += i13;
                i += i13;
                i4 -= i13;
            }
            int i14 = i + i4;
            int i15 = this.dstW;
            if (i14 <= i12 + i15 || (i4 = (i12 + i15) - i) > 0) {
                int i16 = (i - i12) + ((i2 - i8) * this.dstScan) + this.dstOff;
                if (this.intPixels == null) {
                    if (this.bytePixels == null) {
                        this.bytePixels = new byte[i11 * i15];
                        this.dstScan = i15;
                        this.dstOff = 0;
                        this.imageModel = colorModel;
                    } else if (this.imageModel != colorModel) {
                        convertToRGB();
                    }
                    if (this.bytePixels != null) {
                        for (int i17 = i5; i17 > 0; i17--) {
                            System.arraycopy(bArr, i6, this.bytePixels, i16, i4);
                            i6 += i7;
                            i16 += this.dstScan;
                        }
                    }
                }
                if (this.intPixels != null) {
                    int i18 = this.dstScan - i4;
                    int i19 = i7 - i4;
                    while (i5 > 0) {
                        int i20 = i4;
                        while (i20 > 0) {
                            this.intPixels[i16] = colorModel.getRGB(bArr[i6] & 255);
                            i20--;
                            i16++;
                            i6++;
                        }
                        i6 += i19;
                        i16 += i18;
                        i5--;
                    }
                }
                this.flags |= 8;
            }
        }
    }

    public synchronized void startGrabbing() {
        int i = this.flags;
        if ((i & 112) != 0) {
            return;
        }
        if (!this.grabbing) {
            this.grabbing = true;
            this.flags = i & (-129);
            this.producer.startProduction(this);
        }
    }

    public synchronized int status() {
        return this.flags;
    }

    public PixelGrabber(Image image, int i, int i2, int i4, int i5, int[] iArr, int i6, int i7) {
        this(image.getSource(), i, i2, i4, i5, iArr, i6, i7);
    }

    public synchronized boolean grabPixels(long j) {
        try {
            int i = this.flags;
            if ((i & 112) != 0) {
                return (i & 48) != 0;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() + j;
            if (!this.grabbing) {
                this.grabbing = true;
                this.flags &= -129;
                this.producer.startProduction(this);
            }
            while (this.grabbing) {
                long j2 = 0;
                if (j != 0) {
                    long jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis();
                    if (jCurrentTimeMillis2 <= 0) {
                        break;
                    }
                    j2 = jCurrentTimeMillis2;
                }
                wait(j2);
            }
            return (this.flags & 48) != 0;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setPixels(int i, int i2, int i4, int i5, ColorModel colorModel, int[] iArr, int i6, int i7) {
        int i8 = this.dstY;
        if (i2 < i8) {
            int i9 = i8 - i2;
            if (i9 >= i5) {
                return;
            }
            i6 += i7 * i9;
            i2 += i9;
            i5 -= i9;
        }
        int i10 = i2 + i5;
        int i11 = this.dstH;
        if (i10 <= i8 + i11 || (i5 = (i8 + i11) - i2) > 0) {
            int i12 = this.dstX;
            if (i < i12) {
                int i13 = i12 - i;
                if (i13 >= i4) {
                    return;
                }
                i6 += i13;
                i += i13;
                i4 -= i13;
            }
            int i14 = i + i4;
            int i15 = this.dstW;
            if (i14 <= i12 + i15 || (i4 = (i12 + i15) - i) > 0) {
                if (this.intPixels == null) {
                    if (this.bytePixels == null) {
                        this.intPixels = new int[i11 * i15];
                        this.dstScan = i15;
                        this.dstOff = 0;
                        this.imageModel = colorModel;
                    } else {
                        convertToRGB();
                    }
                }
                int i16 = (i - this.dstX) + ((i2 - this.dstY) * this.dstScan) + this.dstOff;
                ColorModel colorModel2 = this.imageModel;
                if (colorModel2 == colorModel) {
                    while (i5 > 0) {
                        System.arraycopy(iArr, i6, this.intPixels, i16, i4);
                        i6 += i7;
                        i16 += this.dstScan;
                        i5--;
                    }
                } else {
                    if (colorModel2 != ColorModel.getRGBdefault()) {
                        convertToRGB();
                    }
                    int i17 = this.dstScan - i4;
                    int i18 = i7 - i4;
                    while (i5 > 0) {
                        int i19 = i4;
                        while (i19 > 0) {
                            this.intPixels[i16] = colorModel.getRGB(iArr[i6]);
                            i19--;
                            i16++;
                            i6++;
                        }
                        i6 += i18;
                        i16 += i17;
                        i5--;
                    }
                }
                this.flags |= 8;
            }
        }
    }

    public PixelGrabber(ImageProducer imageProducer, int i, int i2, int i4, int i5, int[] iArr, int i6, int i7) {
        this.producer = imageProducer;
        this.dstX = i;
        this.dstY = i2;
        this.dstW = i4;
        this.dstH = i5;
        this.dstOff = i6;
        this.dstScan = i7;
        this.intPixels = iArr;
        this.imageModel = ColorModel.getRGBdefault();
    }

    public void setColorModel(ColorModel colorModel) {
    }

    public void setHints(int i) {
    }

    public void setProperties(Hashtable<?, ?> hashtable) {
    }
}
