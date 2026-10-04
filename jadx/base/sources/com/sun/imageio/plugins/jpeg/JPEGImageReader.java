package com.sun.imageio.plugins.jpeg;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.color.CMMException;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.color.ICC_ColorSpace;
import org.apache.poi.java.awt.color.ICC_Profile;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorConvertOp;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.ImageReadParam;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGImageReadParam;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGQTable;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.stream.ImageInputStream;
import org.apache.poi.sun.java2d.Disposer;
import org.apache.poi.sun.java2d.DisposerRecord;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEGImageReader extends ImageReader {
    private static final int MAX_WARNING = 2;
    private static final int MIN_ESTIMATED_PASSES = 10;
    private static final int UNKNOWN = -1;
    protected static final int WARNING_IGNORE_INVALID_ICC = 2;
    protected static final int WARNING_NO_EOI = 0;
    protected static final int WARNING_NO_JFIF_IN_THUMB = 1;
    private JPEGHuffmanTable[] abbrevACHuffmanTables;
    private JPEGHuffmanTable[] abbrevDCHuffmanTables;
    private JPEGQTable[] abbrevQTables;
    private DataBufferByte buffer;
    private CallBackLock cbLock;
    private int colorSpaceCode;
    private ColorConvertOp convert;
    private int currentImage;
    private boolean debug;
    private Rectangle destROI;
    private int[] destinationBands;
    private DisposerRecord disposerRecord;
    private Object disposerReferent;
    private boolean haveSeeked;
    private int height;
    private ColorSpace iccCS;
    private ImageInputStream iis;
    private BufferedImage image;
    private JPEGMetadata imageMetadata;
    private int imageMetadataIndex;
    private List imagePositions;
    private int knownPassCount;
    private int maxProgressivePass;
    private int minProgressivePass;
    private int numComponents;
    private int numImages;
    private int outColorSpaceCode;
    private int pass;
    private float percentToDate;
    private float previousPassPercentage;
    private int progInterval;
    private WritableRaster raster;
    private JPEGMetadata streamMetadata;
    private long structPointer;
    private boolean tablesOnlyChecked;
    private WritableRaster target;
    private int theLockCount;
    private Thread theThread;
    private int width;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CallBackLock {
        private State lockState = State.Unlocked;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public enum State {
            Unlocked,
            Locked
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lock() {
            this.lockState = State.Locked;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void unlock() {
            this.lockState = State.Unlocked;
        }

        public void check() {
            if (this.lockState != State.Unlocked) {
                throw new IllegalStateException("Access to the reader is not allowed");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class JPEGReaderDisposerRecord implements DisposerRecord {
        private long pData;

        public JPEGReaderDisposerRecord(long j) {
            this.pData = j;
        }

        @Override // org.apache.poi.sun.java2d.DisposerRecord
        public synchronized void dispose() {
            long j = this.pData;
            if (j != 0) {
                JPEGImageReader.disposeReader(j);
                this.pData = 0L;
            }
        }
    }

    static {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: com.sun.imageio.plugins.jpeg.JPEGImageReader.1
            @Override // java.security.PrivilegedAction
            public Void run() {
                System.loadLibrary("jpeg");
                return null;
            }
        });
        initReaderIDs(ImageInputStream.class, JPEGQTable.class, JPEGHuffmanTable.class);
    }

    public JPEGImageReader(ImageReaderSpi imageReaderSpi) {
        super(imageReaderSpi);
        this.debug = false;
        this.structPointer = 0L;
        this.iis = null;
        this.imagePositions = null;
        this.numImages = 0;
        this.currentImage = -1;
        this.iccCS = null;
        this.convert = null;
        this.image = null;
        this.raster = null;
        this.target = null;
        this.buffer = null;
        this.destROI = null;
        this.destinationBands = null;
        this.streamMetadata = null;
        this.imageMetadata = null;
        this.imageMetadataIndex = -1;
        this.haveSeeked = false;
        this.abbrevQTables = null;
        this.abbrevDCHuffmanTables = null;
        this.abbrevACHuffmanTables = null;
        this.minProgressivePass = 0;
        this.maxProgressivePass = Integer.MAX_VALUE;
        this.knownPassCount = -1;
        this.pass = 0;
        this.percentToDate = 0.0f;
        this.previousPassPercentage = 0.0f;
        this.progInterval = 0;
        this.tablesOnlyChecked = false;
        this.disposerReferent = new Object();
        this.theThread = null;
        this.theLockCount = 0;
        this.cbLock = new CallBackLock();
        long jInitJPEGImageReader = initJPEGImageReader();
        this.structPointer = jInitJPEGImageReader;
        JPEGReaderDisposerRecord jPEGReaderDisposerRecord = new JPEGReaderDisposerRecord(jInitJPEGImageReader);
        this.disposerRecord = jPEGReaderDisposerRecord;
        Disposer.addRecord(this.disposerReferent, jPEGReaderDisposerRecord);
    }

    private native void abortRead(long j);

    private void acceptPixels(int i, boolean z) {
        ColorConvertOp colorConvertOp = this.convert;
        if (colorConvertOp != null) {
            WritableRaster writableRaster = this.raster;
            colorConvertOp.filter(writableRaster, writableRaster);
        }
        WritableRaster writableRaster2 = this.target;
        Rectangle rectangle = this.destROI;
        writableRaster2.setRect(rectangle.f10094x, rectangle.f10095y + i, this.raster);
        this.cbLock.lock();
        try {
            BufferedImage bufferedImage = this.image;
            Rectangle rectangle2 = this.destROI;
            processImageUpdate(bufferedImage, rectangle2.f10094x, rectangle2.f10095y + i, this.raster.getWidth(), 1, 1, 1, this.destinationBands);
            if (i > 0 && i % this.progInterval == 0) {
                int height = this.target.getHeight() - 1;
                float f = i / height;
                if (z) {
                    int i2 = this.knownPassCount;
                    if (i2 != -1) {
                        processImageProgress(((this.pass + f) * 100.0f) / i2);
                    } else {
                        if (this.maxProgressivePass != Integer.MAX_VALUE) {
                            processImageProgress(((this.pass + f) * 100.0f) / ((r5 - this.minProgressivePass) + 1));
                        } else {
                            int iMax = Math.max(2, 10 - this.pass);
                            int i4 = (this.pass + iMax) - 1;
                            int iMax2 = Math.max((height / 20) * i4, i4);
                            this.progInterval = iMax2;
                            if (i % iMax2 == 0) {
                                float f4 = this.previousPassPercentage;
                                this.percentToDate = (((1.0f - f4) * f) / iMax) + f4;
                                if (this.debug) {
                                    System.out.print("pass= " + this.pass);
                                    System.out.print(", y= " + i);
                                    System.out.print(", progInt= " + this.progInterval);
                                    System.out.print(", % of pass: " + f);
                                    System.out.print(", rem. passes: " + iMax);
                                    System.out.print(", prev%: " + this.previousPassPercentage);
                                    System.out.print(", %ToDate: " + this.percentToDate);
                                    System.out.print(" ");
                                }
                                processImageProgress(this.percentToDate * 100.0f);
                            }
                        }
                    }
                } else {
                    processImageProgress(f * 100.0f);
                }
            }
            this.cbLock.unlock();
        } catch (Throwable th) {
            this.cbLock.unlock();
            throw th;
        }
    }

    private void checkColorConversion(BufferedImage bufferedImage, ImageReadParam imageReadParam) throws IIOException {
        if (imageReadParam == null || (imageReadParam.getSourceBands() == null && imageReadParam.getDestinationBands() == null)) {
            ColorModel colorModel = bufferedImage.getColorModel();
            if (colorModel instanceof IndexColorModel) {
                throw new IIOException("IndexColorModel not supported");
            }
            ColorSpace colorSpace = colorModel.getColorSpace();
            int type = colorSpace.getType();
            this.convert = null;
            int i = this.outColorSpaceCode;
            if (i == 1) {
                if (type != 5) {
                    if (type != 6) {
                        throw new IIOException("Incompatible color conversion");
                    }
                    return;
                } else {
                    setOutColorSpace(this.structPointer, 2);
                    this.outColorSpaceCode = 2;
                    this.numComponents = 3;
                    return;
                }
            }
            if (i == 2) {
                if (type == 6) {
                    if (this.colorSpaceCode == 3) {
                        setOutColorSpace(this.structPointer, 1);
                        this.outColorSpaceCode = 1;
                        this.numComponents = 1;
                        return;
                    }
                    return;
                }
                if (this.iccCS != null && colorModel.getNumComponents() == this.numComponents && colorSpace != this.iccCS) {
                    this.convert = new ColorConvertOp(this.iccCS, colorSpace, null);
                    return;
                }
                if (this.iccCS == null && !colorSpace.isCS_sRGB() && colorModel.getNumComponents() == this.numComponents) {
                    this.convert = new ColorConvertOp(JPEG.JCS.sRGB, colorSpace, null);
                    return;
                } else {
                    if (type != 5) {
                        throw new IIOException("Incompatible color conversion");
                    }
                    return;
                }
            }
            if (i == 5) {
                ColorSpace ycc = JPEG.JCS.getYCC();
                if (ycc == null) {
                    throw new IIOException("Incompatible color conversion");
                }
                if (colorSpace == ycc || colorModel.getNumComponents() != this.numComponents) {
                    return;
                }
                this.convert = new ColorConvertOp(ycc, colorSpace, null);
                return;
            }
            if (i == 6) {
                if (type != 5 || colorModel.getNumComponents() != this.numComponents) {
                    throw new IIOException("Incompatible color conversion");
                }
            } else {
                if (i != 10) {
                    throw new IIOException("Incompatible color conversion");
                }
                ColorSpace ycc2 = JPEG.JCS.getYCC();
                if (ycc2 == null || colorSpace != ycc2 || colorModel.getNumComponents() != this.numComponents) {
                    throw new IIOException("Incompatible color conversion");
                }
            }
        }
    }

    private void checkTablesOnly() {
        if (this.debug) {
            System.out.println("Checking for tables-only image");
        }
        long streamPosition = this.iis.getStreamPosition();
        if (this.debug) {
            System.out.println("saved pos is " + streamPosition);
            System.out.println("length is " + this.iis.length());
        }
        if (readNativeHeader(true)) {
            if (this.debug) {
                System.out.println("tables-only image found");
                long streamPosition2 = this.iis.getStreamPosition();
                System.out.println("pos after return from native is " + streamPosition2);
            }
            if (!this.ignoreMetadata) {
                this.iis.seek(streamPosition);
                this.haveSeeked = true;
                this.streamMetadata = new JPEGMetadata(true, false, this.iis, this);
                long streamPosition3 = this.iis.getStreamPosition();
                if (this.debug) {
                    System.out.println("pos after constructing stream metadata is " + streamPosition3);
                }
            }
            if (hasNextImage()) {
                this.imagePositions.add(new Long(this.iis.getStreamPosition()));
            }
        } else {
            this.imagePositions.add(new Long(streamPosition));
            this.currentImage = 0;
        }
        if (this.seekForwardOnly) {
            this.iis.flushBefore(((Long) AbstractC0000a.m10g(this.imagePositions, 1)).longValue());
        }
        this.tablesOnlyChecked = true;
    }

    private synchronized void clearThreadLock() {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.theThread;
        if (thread == null || thread != threadCurrentThread) {
            throw new IllegalStateException("Attempt to clear thread lock  form wrong thread. Locked thread: " + this.theThread + "; current thread: " + threadCurrentThread);
        }
        int i = this.theLockCount - 1;
        this.theLockCount = i;
        if (i == 0) {
            this.theThread = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void disposeReader(long j);

    private ImageTypeProducer getImageType(int i) {
        if (i <= 0 || i >= 12) {
            return null;
        }
        return ImageTypeProducer.getTypeProducer(i);
    }

    private Iterator getImageTypesOnThread(int i) {
        if (this.currentImage != i) {
            this.cbLock.check();
            readHeader(i, true);
        }
        ImageTypeProducer imageType = getImageType(this.colorSpaceCode);
        ArrayList arrayList = new ArrayList(1);
        int i2 = this.colorSpaceCode;
        if (i2 == 1) {
            arrayList.add(imageType);
            arrayList.add(getImageType(2));
        } else if (i2 == 2) {
            arrayList.add(imageType);
            arrayList.add(getImageType(1));
            arrayList.add(getImageType(5));
        } else if (i2 == 3) {
            arrayList.add(getImageType(2));
            if (this.iccCS != null) {
                arrayList.add(new ImageTypeProducer() { // from class: com.sun.imageio.plugins.jpeg.JPEGImageReader.2
                    @Override // com.sun.imageio.plugins.jpeg.ImageTypeProducer
                    public ImageTypeSpecifier produce() {
                        return ImageTypeSpecifier.createInterleaved(JPEGImageReader.this.iccCS, JPEG.bOffsRGB, 0, false, false);
                    }
                });
            }
            arrayList.add(getImageType(1));
            arrayList.add(getImageType(5));
        } else if (i2 != 5) {
            if (i2 == 6) {
                arrayList.add(imageType);
            } else if (i2 == 7) {
                arrayList.add(getImageType(6));
            } else if (i2 == 10 && imageType != null) {
                arrayList.add(imageType);
            }
        } else if (imageType != null) {
            arrayList.add(imageType);
            arrayList.add(getImageType(2));
        }
        return new ImageTypeIterator(arrayList.iterator());
    }

    private int getNumImagesOnThread(boolean z) {
        int i = this.numImages;
        if (i != 0) {
            return i;
        }
        if (this.iis == null) {
            throw new IllegalStateException("Input not set");
        }
        if (!z) {
            return -1;
        }
        if (this.seekForwardOnly) {
            throw new IllegalStateException("seekForwardOnly and allowSearch can't both be true!");
        }
        if (!this.tablesOnlyChecked) {
            checkTablesOnly();
        }
        this.iis.mark();
        boolean zScanForFF = false;
        gotoImage(0);
        JPEGBuffer jPEGBuffer = new JPEGBuffer(this.iis);
        jPEGBuffer.loadBuf(0);
        while (!zScanForFF) {
            zScanForFF = jPEGBuffer.scanForFF(this);
            byte[] bArr = jPEGBuffer.buf;
            int i2 = jPEGBuffer.bufPtr;
            int i4 = bArr[i2] & 255;
            if (i4 != 0) {
                switch (i4) {
                    case JPEG.RST0 /* 208 */:
                    case JPEG.RST1 /* 209 */:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                    case JPEG.RST7 /* 215 */:
                    case JPEG.EOI /* 217 */:
                        break;
                    case JPEG.SOI /* 216 */:
                        this.numImages++;
                        break;
                    default:
                        jPEGBuffer.bufAvail--;
                        jPEGBuffer.bufPtr = i2 + 1;
                        jPEGBuffer.loadBuf(2);
                        byte[] bArr2 = jPEGBuffer.buf;
                        int i5 = jPEGBuffer.bufPtr;
                        int i6 = i5 + 1;
                        jPEGBuffer.bufPtr = i6;
                        int i7 = (bArr2[i5] & 255) << 8;
                        jPEGBuffer.bufPtr = i5 + 2;
                        int i8 = (bArr2[i6] & 255) | i7;
                        jPEGBuffer.bufAvail -= 2;
                        jPEGBuffer.skipData(i8 - 2);
                        continue;
                }
            }
            jPEGBuffer.bufAvail--;
            jPEGBuffer.bufPtr = i2 + 1;
        }
        this.iis.reset();
        return this.numImages;
    }

    private void gotoImage(int i) {
        if (this.iis == null) {
            throw new IllegalStateException("Input not set");
        }
        if (i < this.minIndex) {
            throw new IndexOutOfBoundsException();
        }
        if (!this.tablesOnlyChecked) {
            checkTablesOnly();
        }
        if (i < this.imagePositions.size()) {
            this.iis.seek(((Long) this.imagePositions.get(i)).longValue());
        } else {
            this.iis.seek(((Long) AbstractC0000a.m10g(this.imagePositions, 1)).longValue());
            skipImage();
            for (int size = this.imagePositions.size(); size <= i; size++) {
                if (!hasNextImage()) {
                    throw new IndexOutOfBoundsException();
                }
                Long l = new Long(this.iis.getStreamPosition());
                this.imagePositions.add(l);
                if (this.seekForwardOnly) {
                    this.iis.flushBefore(l.longValue());
                }
                if (size < i) {
                    skipImage();
                }
            }
        }
        if (this.seekForwardOnly) {
            this.minIndex = i;
        }
        this.haveSeeked = true;
    }

    private boolean hasNextImage() {
        if (this.debug) {
            System.out.print("hasNextImage called; returning ");
        }
        this.iis.mark();
        int i = this.iis.read();
        boolean z = false;
        while (i != -1) {
            if (z && i == 216) {
                this.iis.reset();
                if (this.debug) {
                    System.out.println("true");
                }
                return true;
            }
            z = i == 255;
            i = this.iis.read();
        }
        this.iis.reset();
        if (this.debug) {
            System.out.println("false");
        }
        return false;
    }

    private native long initJPEGImageReader();

    private void initProgressData() {
        this.knownPassCount = -1;
        this.pass = 0;
        this.percentToDate = 0.0f;
        this.previousPassPercentage = 0.0f;
        this.progInterval = 0;
    }

    private static native void initReaderIDs(Class cls, Class cls2, Class cls3);

    private void passComplete() {
        this.cbLock.lock();
        try {
            processPassComplete(this.image);
        } finally {
            this.cbLock.unlock();
        }
    }

    private void passStarted(int i) throws Throwable {
        JPEGImageReader jPEGImageReader;
        this.cbLock.lock();
        try {
            this.pass = i;
            this.previousPassPercentage = this.percentToDate;
            jPEGImageReader = this;
            try {
                jPEGImageReader.processPassStarted(this.image, i, this.minProgressivePass, this.maxProgressivePass, 0, 0, 1, 1, this.destinationBands);
                jPEGImageReader.cbLock.unlock();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                jPEGImageReader.cbLock.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            jPEGImageReader = this;
        }
    }

    private void pushBack(int i) {
        if (this.debug) {
            System.out.println("pushing back " + i + " bytes");
        }
        this.cbLock.lock();
        try {
            ImageInputStream imageInputStream = this.iis;
            imageInputStream.seek(imageInputStream.getStreamPosition() - ((long) i));
        } finally {
            this.cbLock.unlock();
        }
    }

    private void readHeader(int i, boolean z) {
        gotoImage(i);
        readNativeHeader(z);
        this.currentImage = i;
    }

    private native boolean readImage(int i, long j, byte[] bArr, int i2, int[] iArr, int[] iArr2, int i4, int i5, int i6, int i7, int i8, int i9, JPEGQTable[] jPEGQTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr2, int i10, int i11, boolean z);

    private native boolean readImageHeader(long j, boolean z, boolean z2);

    private int readInputData(byte[] bArr, int i, int i2) {
        this.cbLock.lock();
        try {
            return this.iis.read(bArr, i, i2);
        } finally {
            this.cbLock.unlock();
        }
    }

    private Raster readInternal(int i, ImageReadParam imageReadParam, boolean z) throws IIOException {
        int numBands;
        WritableRaster writableRaster;
        int i2;
        int i4;
        int i5;
        readHeader(i, false);
        if (z) {
            setOutColorSpace(this.structPointer, this.colorSpaceCode);
            this.image = null;
            numBands = 0;
            writableRaster = null;
        } else {
            Iterator imageTypes = getImageTypes(i);
            if (!imageTypes.hasNext()) {
                throw new IIOException("Unsupported Image Type");
            }
            BufferedImage destination = ImageReader.getDestination(imageReadParam, imageTypes, this.width, this.height);
            this.image = destination;
            WritableRaster raster = destination.getRaster();
            numBands = this.image.getSampleModel().getNumBands();
            checkColorConversion(this.image, imageReadParam);
            ImageReader.checkReadParamBandSettings(imageReadParam, this.numComponents, numBands);
            writableRaster = raster;
        }
        int[][] iArr = JPEG.bandOffsets;
        int i6 = this.numComponents;
        int[] iArr2 = iArr[i6 - 1];
        int length = z ? i6 : numBands;
        this.destinationBands = null;
        Rectangle rectangle = new Rectangle(0, 0, 0, 0);
        Rectangle rectangle2 = new Rectangle(0, 0, 0, 0);
        this.destROI = rectangle2;
        ImageReader.computeRegions(imageReadParam, this.width, this.height, this.image, rectangle, rectangle2);
        this.minProgressivePass = 0;
        this.maxProgressivePass = Integer.MAX_VALUE;
        if (imageReadParam != null) {
            int sourceXSubsampling = imageReadParam.getSourceXSubsampling();
            int sourceYSubsampling = imageReadParam.getSourceYSubsampling();
            int[] sourceBands = imageReadParam.getSourceBands();
            if (sourceBands != null) {
                length = sourceBands.length;
                iArr2 = sourceBands;
            }
            if (!z) {
                this.destinationBands = imageReadParam.getDestinationBands();
            }
            this.minProgressivePass = imageReadParam.getSourceMinProgressivePass();
            this.maxProgressivePass = imageReadParam.getSourceMaxProgressivePass();
            if (imageReadParam instanceof JPEGImageReadParam) {
                JPEGImageReadParam jPEGImageReadParam = (JPEGImageReadParam) imageReadParam;
                if (jPEGImageReadParam.areTablesSet()) {
                    this.abbrevQTables = jPEGImageReadParam.getQTables();
                    this.abbrevDCHuffmanTables = jPEGImageReadParam.getDCHuffmanTables();
                    this.abbrevACHuffmanTables = jPEGImageReadParam.getACHuffmanTables();
                }
            }
            i2 = sourceXSubsampling;
            i4 = sourceYSubsampling;
        } else {
            i2 = 1;
            i4 = 1;
        }
        int i7 = length;
        int i8 = this.destROI.width * i7;
        DataBufferByte dataBufferByte = new DataBufferByte(i8);
        this.buffer = dataBufferByte;
        int[] iArr3 = iArr[i7 - 1];
        this.raster = Raster.createInterleavedRaster(dataBufferByte, this.destROI.width, 1, i8, i7, iArr3, (Point) null);
        if (z) {
            Rectangle rectangle3 = this.destROI;
            i5 = i7;
            this.target = Raster.createInterleavedRaster(0, rectangle3.width, rectangle3.height, i8, i7, iArr3, (Point) null);
        } else {
            i5 = i7;
            this.target = writableRaster;
        }
        int[] sampleSize = this.target.getSampleModel().getSampleSize();
        for (int i9 : sampleSize) {
            if (i9 <= 0 || i9 > 8) {
                throw new IIOException("Illegal band size: should be 0 < size <= 8");
            }
        }
        boolean z2 = (this.updateListeners == null && this.progressListeners == null) ? false : true;
        initProgressData();
        if (i == this.imageMetadataIndex) {
            this.knownPassCount = 0;
            Iterator it = this.imageMetadata.markerSequence.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof SOSMarkerSegment) {
                    this.knownPassCount++;
                }
            }
        }
        int iMax = Math.max((this.target.getHeight() - 1) / 20, 1);
        this.progInterval = iMax;
        int i10 = this.knownPassCount;
        if (i10 > 0) {
            this.progInterval = iMax * i10;
        } else {
            int i11 = this.maxProgressivePass;
            if (i11 != Integer.MAX_VALUE) {
                this.progInterval = ((i11 - this.minProgressivePass) + 1) * iMax;
            }
        }
        if (this.debug) {
            System.out.println("**** Read Data *****");
            System.out.println("numRasterBands is " + i5);
            System.out.print("srcBands:");
            for (int i12 = 0; i12 < iArr2.length; i12++) {
                System.out.print(" " + iArr2[i12]);
            }
            System.out.println();
            System.out.println("destination bands is " + this.destinationBands);
            if (this.destinationBands != null) {
                for (int i13 = 0; i13 < this.destinationBands.length; i13++) {
                    System.out.print(" " + this.destinationBands[i13]);
                }
                System.out.println();
            }
            System.out.println("sourceROI is " + rectangle);
            System.out.println("destROI is " + this.destROI);
            System.out.println("periodX is " + i2);
            System.out.println("periodY is " + i4);
            System.out.println("minProgressivePass is " + this.minProgressivePass);
            System.out.println("maxProgressivePass is " + this.maxProgressivePass);
            System.out.println("callbackUpdates is " + z2);
        }
        processImageStarted(this.currentImage);
        if (readImage(i, this.structPointer, this.buffer.getData(), i5, iArr2, sampleSize, rectangle.f10094x, rectangle.f10095y, rectangle.width, rectangle.height, i2, i4, this.abbrevQTables, this.abbrevDCHuffmanTables, this.abbrevACHuffmanTables, this.minProgressivePass, this.maxProgressivePass, z2)) {
            processReadAborted();
        } else {
            processImageComplete();
        }
        return this.target;
    }

    private boolean readNativeHeader(boolean z) {
        boolean imageHeader = readImageHeader(this.structPointer, this.haveSeeked, z);
        this.haveSeeked = false;
        return imageHeader;
    }

    private void resetInternalState() {
        resetReader(this.structPointer);
        this.numImages = 0;
        this.imagePositions = new ArrayList();
        this.currentImage = -1;
        this.image = null;
        this.raster = null;
        this.target = null;
        this.buffer = null;
        this.destROI = null;
        this.destinationBands = null;
        this.streamMetadata = null;
        this.imageMetadata = null;
        this.imageMetadataIndex = -1;
        this.haveSeeked = false;
        this.tablesOnlyChecked = false;
        this.iccCS = null;
        initProgressData();
    }

    private native void resetLibraryState(long j);

    private native void resetReader(long j);

    private void setImageData(int i, int i2, int i4, int i5, int i6, byte[] bArr) {
        this.width = i;
        this.height = i2;
        this.colorSpaceCode = i4;
        this.outColorSpaceCode = i5;
        this.numComponents = i6;
        if (bArr == null) {
            this.iccCS = null;
            return;
        }
        try {
            ICC_Profile iCC_Profile = ICC_Profile.getInstance(bArr);
            byte[] data = iCC_Profile.getData();
            ColorSpace colorSpace = this.iccCS;
            ICC_Profile profile = colorSpace instanceof ICC_ColorSpace ? ((ICC_ColorSpace) colorSpace).getProfile() : null;
            byte[] data2 = profile != null ? profile.getData() : null;
            if (data2 == null || !Arrays.equals(data2, data)) {
                ICC_ColorSpace iCC_ColorSpace = new ICC_ColorSpace(iCC_Profile);
                this.iccCS = iCC_ColorSpace;
                try {
                    iCC_ColorSpace.fromRGB(new float[]{1.0f, 0.0f, 0.0f});
                } catch (CMMException unused) {
                    this.iccCS = null;
                    this.cbLock.lock();
                    try {
                        warningOccurred(2);
                    } finally {
                        this.cbLock.unlock();
                    }
                }
            }
        } catch (IllegalArgumentException unused2) {
            this.iccCS = null;
            warningOccurred(2);
        }
    }

    private native void setOutColorSpace(long j, int i);

    private native void setSource(long j);

    private synchronized void setThreadLock() {
        try {
            Thread threadCurrentThread = Thread.currentThread();
            Thread thread = this.theThread;
            if (thread == null) {
                this.theThread = threadCurrentThread;
                this.theLockCount = 1;
            } else {
                if (thread != threadCurrentThread) {
                    throw new IllegalStateException("Attempt to use instance of " + this + " locked on thread " + this.theThread + " from thread " + threadCurrentThread);
                }
                this.theLockCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void skipImage() {
        if (this.debug) {
            System.out.println("skipImage called");
        }
        int i = this.iis.read();
        boolean z = false;
        while (i != -1) {
            if (z && i == 217) {
                return;
            }
            z = i == 255;
            i = this.iis.read();
        }
        throw new IndexOutOfBoundsException();
    }

    private long skipInputBytes(long j) {
        this.cbLock.lock();
        try {
            return this.iis.skipBytes(j);
        } finally {
            this.cbLock.unlock();
        }
    }

    private void skipPastImage(int i) {
        this.cbLock.lock();
        try {
            gotoImage(i);
            skipImage();
        } catch (IOException | IndexOutOfBoundsException unused) {
        } catch (Throwable th) {
            this.cbLock.unlock();
            throw th;
        }
        this.cbLock.unlock();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void abort() {
        setThreadLock();
        try {
            super.abort();
            abortRead(this.structPointer);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public boolean canReadRaster() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void dispose() {
        setThreadLock();
        try {
            this.cbLock.check();
            if (this.structPointer != 0) {
                this.disposerRecord.dispose();
                this.structPointer = 0L;
            }
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public ImageReadParam getDefaultReadParam() {
        return new JPEGImageReadParam();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getHeight(int i) {
        setThreadLock();
        try {
            if (this.currentImage != i) {
                this.cbLock.check();
                readHeader(i, true);
            }
            int i2 = this.height;
            clearThreadLock();
            return i2;
        } catch (Throwable th) {
            clearThreadLock();
            throw th;
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getImageMetadata(int i) {
        JPEGMetadata jPEGMetadata;
        setThreadLock();
        try {
            if (this.imageMetadataIndex == i && (jPEGMetadata = this.imageMetadata) != null) {
                return jPEGMetadata;
            }
            this.cbLock.check();
            gotoImage(i);
            JPEGMetadata jPEGMetadata2 = new JPEGMetadata(false, false, this.iis, this);
            this.imageMetadata = jPEGMetadata2;
            this.imageMetadataIndex = i;
            return jPEGMetadata2;
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public Iterator getImageTypes(int i) {
        setThreadLock();
        try {
            return getImageTypesOnThread(i);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getNumImages(boolean z) {
        setThreadLock();
        try {
            this.cbLock.check();
            return getNumImagesOnThread(z);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getNumThumbnails(int i) {
        setThreadLock();
        try {
            this.cbLock.check();
            getImageMetadata(i);
            JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) this.imageMetadata.findMarkerSegment(JFIFMarkerSegment.class, true);
            int size = 0;
            if (jFIFMarkerSegment != null) {
                size = (jFIFMarkerSegment.thumb == null ? 0 : 1) + jFIFMarkerSegment.extSegments.size();
            }
            return size;
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public ImageTypeSpecifier getRawImageType(int i) {
        setThreadLock();
        try {
            if (this.currentImage != i) {
                this.cbLock.check();
                readHeader(i, true);
            }
            ImageTypeSpecifier type = getImageType(this.colorSpaceCode).getType();
            clearThreadLock();
            return type;
        } catch (Throwable th) {
            clearThreadLock();
            throw th;
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getStreamMetadata() {
        setThreadLock();
        try {
            if (!this.tablesOnlyChecked) {
                this.cbLock.check();
                checkTablesOnly();
            }
            JPEGMetadata jPEGMetadata = this.streamMetadata;
            clearThreadLock();
            return jPEGMetadata;
        } catch (Throwable th) {
            clearThreadLock();
            throw th;
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getThumbnailHeight(int i, int i2) {
        setThreadLock();
        try {
            this.cbLock.check();
            if (i2 < 0 || i2 >= getNumThumbnails(i)) {
                throw new IndexOutOfBoundsException("No such thumbnail");
            }
            return ((JFIFMarkerSegment) this.imageMetadata.findMarkerSegment(JFIFMarkerSegment.class, true)).getThumbnailHeight(i2);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getThumbnailWidth(int i, int i2) {
        setThreadLock();
        try {
            this.cbLock.check();
            if (i2 < 0 || i2 >= getNumThumbnails(i)) {
                throw new IndexOutOfBoundsException("No such thumbnail");
            }
            return ((JFIFMarkerSegment) this.imageMetadata.findMarkerSegment(JFIFMarkerSegment.class, true)).getThumbnailWidth(i2);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getWidth(int i) {
        setThreadLock();
        try {
            if (this.currentImage != i) {
                this.cbLock.check();
                readHeader(i, true);
            }
            int i2 = this.width;
            clearThreadLock();
            return i2;
        } catch (Throwable th) {
            clearThreadLock();
            throw th;
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public BufferedImage read(int i, ImageReadParam imageReadParam) {
        setThreadLock();
        try {
            this.cbLock.check();
            try {
                readInternal(i, imageReadParam, false);
                BufferedImage bufferedImage = this.image;
                this.image = null;
                return bufferedImage;
            } catch (IOException e) {
                resetLibraryState(this.structPointer);
                throw e;
            } catch (RuntimeException e2) {
                resetLibraryState(this.structPointer);
                throw e2;
            }
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public Raster readRaster(int i, ImageReadParam imageReadParam) {
        Point destinationOffset;
        setThreadLock();
        try {
            try {
                this.cbLock.check();
                if (imageReadParam != null) {
                    destinationOffset = imageReadParam.getDestinationOffset();
                    imageReadParam.setDestinationOffset(new Point(0, 0));
                } else {
                    destinationOffset = null;
                }
                Raster internal = readInternal(i, imageReadParam, true);
                if (destinationOffset != null) {
                    this.target = this.target.createWritableTranslatedChild(destinationOffset.f10092x, destinationOffset.f10093y);
                }
                clearThreadLock();
                return internal;
            } catch (IOException e) {
                resetLibraryState(this.structPointer);
                throw e;
            } catch (RuntimeException e2) {
                resetLibraryState(this.structPointer);
                throw e2;
            }
        } catch (Throwable th) {
            clearThreadLock();
            throw th;
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public BufferedImage readThumbnail(int i, int i2) {
        setThreadLock();
        try {
            this.cbLock.check();
            if (i2 < 0 || i2 >= getNumThumbnails(i)) {
                throw new IndexOutOfBoundsException("No such thumbnail");
            }
            return ((JFIFMarkerSegment) this.imageMetadata.findMarkerSegment(JFIFMarkerSegment.class, true)).getThumbnail(this.iis, i2, this);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public boolean readerSupportsThumbnails() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void reset() {
        setThreadLock();
        try {
            this.cbLock.check();
            super.reset();
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void setInput(Object obj, boolean z, boolean z2) {
        setThreadLock();
        try {
            this.cbLock.check();
            super.setInput(obj, z, z2);
            this.ignoreMetadata = z2;
            resetInternalState();
            this.iis = (ImageInputStream) obj;
            setSource(this.structPointer);
        } finally {
            clearThreadLock();
        }
    }

    public void thumbnailComplete() {
        this.cbLock.lock();
        try {
            processThumbnailComplete();
        } finally {
            this.cbLock.unlock();
        }
    }

    public void thumbnailProgress(float f) {
        this.cbLock.lock();
        try {
            processThumbnailProgress(f);
        } finally {
            this.cbLock.unlock();
        }
    }

    public void thumbnailStarted(int i) {
        this.cbLock.lock();
        try {
            processThumbnailStarted(this.currentImage, i);
        } finally {
            this.cbLock.unlock();
        }
    }

    public void warningOccurred(int i) {
        this.cbLock.lock();
        try {
            if (i < 0 || i > 2) {
                throw new InternalError("Invalid warning index");
            }
            processWarningOccurred("com.sun.imageio.plugins.jpeg.JPEGImageReaderResources", Integer.toString(i));
        } finally {
            this.cbLock.unlock();
        }
    }

    public void warningWithMessage(String str) {
        this.cbLock.lock();
        try {
            processWarningOccurred(str);
        } finally {
            this.cbLock.unlock();
        }
    }
}
