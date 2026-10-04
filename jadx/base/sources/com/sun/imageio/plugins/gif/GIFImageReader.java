package com.sun.imageio.plugins.gif;

import com.google.android.gms.common.data.AbstractC4539a;
import com.sun.imageio.plugins.common.ReaderUtil;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.MultiPixelPackedSampleModel;
import org.apache.poi.java.awt.image.PixelInterleavedSampleModel;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.ImageReadParam;
import org.apache.poi.javax.imageio.ImageReader;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class GIFImageReader extends ImageReader {
    int bitPos;
    byte[] block;
    int blockLength;
    int clearCode;
    int currIndex;
    boolean decodeThisRow;
    int destY;
    Point destinationOffset;
    Rectangle destinationRegion;
    int eofCode;
    private byte[] fallbackColorTable;
    boolean gotHeader;
    int height;
    GIFImageMetadata imageMetadata;
    int imageMetadataLength;
    List imageStartPosition;
    int initCodeSize;
    int interlacePass;
    boolean lastBlockFound;
    int next32Bits;
    int nextByte;
    int numImages;
    byte[] rowBuf;
    int rowsDone;
    int sourceMaxProgressivePass;
    int sourceMinProgressivePass;
    Rectangle sourceRegion;
    int sourceXSubsampling;
    int sourceYSubsampling;
    ImageInputStream stream;
    GIFStreamMetadata streamMetadata;
    int streamX;
    int streamY;
    BufferedImage theImage;
    WritableRaster theTile;
    int updateMinY;
    int updateYStep;
    int width;
    static final int[] interlaceIncrement = {8, 8, 4, 2, -1};
    static final int[] interlaceOffset = {0, 4, 2, 1, -1};
    private static byte[] defaultPalette = null;

    public GIFImageReader(ImageReaderSpi imageReaderSpi) {
        super(imageReaderSpi);
        this.stream = null;
        this.gotHeader = false;
        this.streamMetadata = null;
        this.currIndex = -1;
        this.imageMetadata = null;
        this.imageStartPosition = new ArrayList();
        this.numImages = -1;
        this.block = new byte[255];
        this.blockLength = 0;
        this.bitPos = 0;
        this.nextByte = 0;
        this.next32Bits = 0;
        this.lastBlockFound = false;
        this.theImage = null;
        this.theTile = null;
        this.width = -1;
        this.height = -1;
        this.streamX = -1;
        this.streamY = -1;
        this.rowsDone = 0;
        this.interlacePass = 0;
        this.fallbackColorTable = null;
        this.decodeThisRow = true;
        this.destY = 0;
    }

    private void checkIndex(int i) {
        if (i < this.minIndex) {
            throw new IndexOutOfBoundsException("imageIndex < minIndex!");
        }
        if (this.seekForwardOnly) {
            this.minIndex = i;
        }
    }

    private void computeDecodeThisRow() {
        int i;
        Rectangle rectangle;
        int i2;
        int i4 = this.destY;
        Rectangle rectangle2 = this.destinationRegion;
        this.decodeThisRow = i4 < rectangle2.f10095y + rectangle2.height && (i = this.streamY) >= (i2 = (rectangle = this.sourceRegion).f10095y) && i < rectangle.height + i2 && (i - i2) % this.sourceYSubsampling == 0;
    }

    private byte[] concatenateBlocks() {
        byte[] bArr = new byte[0];
        while (true) {
            int unsignedByte = this.stream.readUnsignedByte();
            if (unsignedByte == 0) {
                return bArr;
            }
            byte[] bArr2 = new byte[bArr.length + unsignedByte];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.stream.readFully(bArr2, bArr.length, unsignedByte);
            bArr = bArr2;
        }
    }

    private int copyData(byte[] bArr, int i, byte[] bArr2) {
        int length = bArr2.length;
        int length2 = bArr.length - i;
        if (length > length2) {
            length = length2;
        }
        System.arraycopy(bArr, i, bArr2, 0, length);
        return i + length;
    }

    private ImageTypeSpecifier createIndexed(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int i2;
        IndexColorModel indexColorModel;
        GIFImageMetadata gIFImageMetadata = this.imageMetadata;
        if (gIFImageMetadata.transparentColorFlag) {
            indexColorModel = new IndexColorModel(i, bArr.length, bArr, bArr2, bArr3, Math.min(gIFImageMetadata.transparentColorIndex, bArr.length - 1));
            i2 = i;
        } else {
            i2 = i;
            indexColorModel = new IndexColorModel(i2, bArr.length, bArr, bArr2, bArr3);
        }
        return new ImageTypeSpecifier(indexColorModel, i2 == 8 ? new PixelInterleavedSampleModel(0, 1, 1, 1, 1, new int[]{0}) : new MultiPixelPackedSampleModel(0, 1, 1, i2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getCode(int i, int i2) {
        int i4 = this.bitPos;
        if (i4 + i > 32) {
            return this.eofCode;
        }
        int i5 = i2 & (this.next32Bits >> i4);
        this.bitPos = i4 + i;
        while (true) {
            int i6 = this.bitPos;
            if (i6 < 8 || this.lastBlockFound) {
                break;
            }
            this.next32Bits >>>= 8;
            this.bitPos = i6 - 8;
            if (this.nextByte >= this.blockLength) {
                int unsignedByte = this.stream.readUnsignedByte();
                this.blockLength = unsignedByte;
                if (unsignedByte == 0) {
                    this.lastBlockFound = true;
                    return i5;
                }
                int i7 = 0;
                while (unsignedByte > 0) {
                    int i8 = this.stream.read(this.block, i7, unsignedByte);
                    i7 += i8;
                    unsignedByte -= i8;
                }
                this.nextByte = 0;
            }
            int i9 = this.next32Bits;
            byte[] bArr = this.block;
            int i10 = this.nextByte;
            this.nextByte = i10 + 1;
            this.next32Bits = i9 | (bArr[i10] << 24);
        }
    }

    private static synchronized byte[] getDefaultPalette() {
        try {
            if (defaultPalette == null) {
                IndexColorModel indexColorModel = (IndexColorModel) new BufferedImage(1, 1, 13).getColorModel();
                int mapSize = indexColorModel.getMapSize();
                byte[] bArr = new byte[mapSize];
                byte[] bArr2 = new byte[mapSize];
                byte[] bArr3 = new byte[mapSize];
                indexColorModel.getReds(bArr);
                indexColorModel.getGreens(bArr2);
                indexColorModel.getBlues(bArr3);
                defaultPalette = new byte[mapSize * 3];
                for (int i = 0; i < mapSize; i++) {
                    byte[] bArr4 = defaultPalette;
                    int i2 = i * 3;
                    bArr4[i2] = bArr[i];
                    bArr4[i2 + 1] = bArr2[i];
                    bArr4[i2 + 2] = bArr3[i];
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return defaultPalette;
    }

    private void initNext32Bits() {
        byte[] bArr = this.block;
        int i = bArr[0] & 255;
        this.next32Bits = i;
        int i2 = i | ((bArr[1] & 255) << 8);
        this.next32Bits = i2;
        int i4 = i2 | ((bArr[2] & 255) << 16);
        this.next32Bits = i4;
        this.next32Bits = (bArr[3] << 24) | i4;
        this.nextByte = 4;
    }

    private int locateImage(int i) throws IIOException {
        readHeader();
        try {
            int iMin = Math.min(i, this.imageStartPosition.size() - 1);
            this.stream.seek(((Long) this.imageStartPosition.get(iMin)).longValue());
            while (iMin < i) {
                if (!skipImage()) {
                    return iMin - 1;
                }
                this.imageStartPosition.add(new Long(this.stream.getStreamPosition()));
                iMin++;
            }
            if (this.currIndex != i) {
                this.imageMetadata = null;
            }
            this.currIndex = i;
            return i;
        } catch (IOException e) {
            throw new IIOException("Couldn't seek!", e);
        }
    }

    private void outputPixels(byte[] bArr, int i) {
        int i2 = this.interlacePass;
        if (i2 < this.sourceMinProgressivePass || i2 > this.sourceMaxProgressivePass) {
            return;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = this.streamX;
            int i6 = this.sourceRegion.f10094x;
            if (i5 >= i6) {
                this.rowBuf[i5 - i6] = bArr[i4];
            }
            int i7 = i5 + 1;
            this.streamX = i7;
            if (i7 == this.width) {
                int i8 = this.rowsDone + 1;
                this.rowsDone = i8;
                processImageProgress((i8 * 100.0f) / this.height);
                if (this.decodeThisRow) {
                    outputRow();
                }
                this.streamX = 0;
                if (this.imageMetadata.interlaceFlag) {
                    int i9 = this.streamY + interlaceIncrement[this.interlacePass];
                    this.streamY = i9;
                    if (i9 >= this.height) {
                        if (this.updateListeners != null) {
                            processPassComplete(this.theImage);
                        }
                        int i10 = this.interlacePass + 1;
                        this.interlacePass = i10;
                        if (i10 > this.sourceMaxProgressivePass) {
                            return;
                        }
                        this.streamY = interlaceOffset[i10];
                        startPass(i10);
                    }
                } else {
                    this.streamY++;
                }
                this.destY = ((this.streamY - this.sourceRegion.f10095y) / this.sourceYSubsampling) + this.destinationRegion.f10095y;
                computeDecodeThisRow();
            }
        }
    }

    private void outputRow() {
        int iMin = Math.min(this.sourceRegion.width, this.destinationRegion.width * this.sourceXSubsampling);
        int i = this.destinationRegion.f10094x;
        if (this.sourceXSubsampling == 1) {
            this.theTile.setDataElements(i, this.destY, iMin, 1, this.rowBuf);
        } else {
            int i2 = 0;
            while (i2 < iMin) {
                this.theTile.setSample(i, this.destY, 0, this.rowBuf[i2] & 255);
                i2 += this.sourceXSubsampling;
                i++;
            }
        }
        int i4 = i;
        if (this.updateListeners != null) {
            processImageUpdate(this.theImage, i4, this.destY, iMin, 1, 1, this.updateYStep, new int[]{0});
        }
    }

    private void readHeader() throws IIOException {
        if (this.gotHeader) {
            return;
        }
        if (this.stream == null) {
            throw new IllegalStateException("Input not set!");
        }
        this.streamMetadata = new GIFStreamMetadata();
        try {
            this.stream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
            byte[] bArr = new byte[6];
            this.stream.readFully(bArr);
            StringBuffer stringBuffer = new StringBuffer(3);
            stringBuffer.append((char) bArr[3]);
            stringBuffer.append((char) bArr[4]);
            stringBuffer.append((char) bArr[5]);
            this.streamMetadata.version = stringBuffer.toString();
            this.streamMetadata.logicalScreenWidth = this.stream.readUnsignedShort();
            this.streamMetadata.logicalScreenHeight = this.stream.readUnsignedShort();
            int unsignedByte = this.stream.readUnsignedByte();
            boolean z = (unsignedByte & 128) != 0;
            GIFStreamMetadata gIFStreamMetadata = this.streamMetadata;
            gIFStreamMetadata.colorResolution = ((unsignedByte >> 4) & 7) + 1;
            gIFStreamMetadata.sortFlag = (unsignedByte & 8) != 0;
            int i = 1 << ((unsignedByte & 7) + 1);
            gIFStreamMetadata.backgroundColorIndex = this.stream.readUnsignedByte();
            this.streamMetadata.pixelAspectRatio = this.stream.readUnsignedByte();
            if (z) {
                byte[] bArr2 = new byte[i * 3];
                this.streamMetadata.globalColorTable = bArr2;
                this.stream.readFully(bArr2);
            } else {
                this.streamMetadata.globalColorTable = null;
            }
            this.imageStartPosition.add(Long.valueOf(this.stream.getStreamPosition()));
            this.gotHeader = true;
        } catch (IOException e) {
            throw new IIOException("I/O error reading header!", e);
        }
    }

    private void readMetadata() throws IIOException {
        int unsignedByte;
        if (this.stream == null) {
            throw new IllegalStateException("Input not set!");
        }
        try {
            this.imageMetadata = new GIFImageMetadata();
            long streamPosition = this.stream.getStreamPosition();
            while (true) {
                int unsignedByte2 = this.stream.readUnsignedByte();
                if (unsignedByte2 == 44) {
                    this.imageMetadata.imageLeftPosition = this.stream.readUnsignedShort();
                    this.imageMetadata.imageTopPosition = this.stream.readUnsignedShort();
                    this.imageMetadata.imageWidth = this.stream.readUnsignedShort();
                    this.imageMetadata.imageHeight = this.stream.readUnsignedShort();
                    int unsignedByte3 = this.stream.readUnsignedByte();
                    boolean z = (unsignedByte3 & 128) != 0;
                    GIFImageMetadata gIFImageMetadata = this.imageMetadata;
                    gIFImageMetadata.interlaceFlag = (unsignedByte3 & 64) != 0;
                    gIFImageMetadata.sortFlag = (unsignedByte3 & 32) != 0;
                    int i = 1 << ((unsignedByte3 & 7) + 1);
                    if (z) {
                        byte[] bArr = new byte[i * 3];
                        gIFImageMetadata.localColorTable = bArr;
                        this.stream.readFully(bArr);
                    } else {
                        gIFImageMetadata.localColorTable = null;
                    }
                    this.imageMetadataLength = (int) (this.stream.getStreamPosition() - streamPosition);
                    return;
                }
                if (unsignedByte2 != 33) {
                    if (unsignedByte2 == 59) {
                        throw new IndexOutOfBoundsException("Attempt to read past end of image sequence!");
                    }
                    throw new IIOException("Unexpected block type " + unsignedByte2 + "!");
                }
                int unsignedByte4 = this.stream.readUnsignedByte();
                if (unsignedByte4 == 249) {
                    this.stream.readUnsignedByte();
                    int unsignedByte5 = this.stream.readUnsignedByte();
                    GIFImageMetadata gIFImageMetadata2 = this.imageMetadata;
                    gIFImageMetadata2.disposalMethod = 3 & (unsignedByte5 >> 2);
                    gIFImageMetadata2.userInputFlag = (unsignedByte5 & 2) != 0;
                    gIFImageMetadata2.transparentColorFlag = (unsignedByte5 & 1) != 0;
                    gIFImageMetadata2.delayTime = this.stream.readUnsignedShort();
                    this.imageMetadata.transparentColorIndex = this.stream.readUnsignedByte();
                    this.stream.readUnsignedByte();
                } else if (unsignedByte4 == 1) {
                    this.stream.readUnsignedByte();
                    GIFImageMetadata gIFImageMetadata3 = this.imageMetadata;
                    gIFImageMetadata3.hasPlainTextExtension = true;
                    gIFImageMetadata3.textGridLeft = this.stream.readUnsignedShort();
                    this.imageMetadata.textGridTop = this.stream.readUnsignedShort();
                    this.imageMetadata.textGridWidth = this.stream.readUnsignedShort();
                    this.imageMetadata.textGridHeight = this.stream.readUnsignedShort();
                    this.imageMetadata.characterCellWidth = this.stream.readUnsignedByte();
                    this.imageMetadata.characterCellHeight = this.stream.readUnsignedByte();
                    this.imageMetadata.textForegroundColor = this.stream.readUnsignedByte();
                    this.imageMetadata.textBackgroundColor = this.stream.readUnsignedByte();
                    this.imageMetadata.text = concatenateBlocks();
                } else if (unsignedByte4 == 254) {
                    byte[] bArrConcatenateBlocks = concatenateBlocks();
                    GIFImageMetadata gIFImageMetadata4 = this.imageMetadata;
                    if (gIFImageMetadata4.comments == null) {
                        gIFImageMetadata4.comments = new ArrayList();
                    }
                    this.imageMetadata.comments.add(bArrConcatenateBlocks);
                } else if (unsignedByte4 == 255) {
                    int unsignedByte6 = this.stream.readUnsignedByte();
                    byte[] bArr2 = new byte[8];
                    byte[] bArr3 = new byte[3];
                    byte[] bArr4 = new byte[unsignedByte6];
                    this.stream.readFully(bArr4);
                    int iCopyData = copyData(bArr4, copyData(bArr4, 0, bArr2), bArr3);
                    byte[] bArrConcatenateBlocks2 = concatenateBlocks();
                    if (iCopyData < unsignedByte6) {
                        int i2 = unsignedByte6 - iCopyData;
                        byte[] bArr5 = new byte[bArrConcatenateBlocks2.length + i2];
                        System.arraycopy(bArr4, iCopyData, bArr5, 0, i2);
                        System.arraycopy(bArrConcatenateBlocks2, 0, bArr5, i2, bArrConcatenateBlocks2.length);
                        bArrConcatenateBlocks2 = bArr5;
                    }
                    GIFImageMetadata gIFImageMetadata5 = this.imageMetadata;
                    if (gIFImageMetadata5.applicationIDs == null) {
                        gIFImageMetadata5.applicationIDs = new ArrayList();
                        this.imageMetadata.authenticationCodes = new ArrayList();
                        this.imageMetadata.applicationData = new ArrayList();
                    }
                    this.imageMetadata.applicationIDs.add(bArr2);
                    this.imageMetadata.authenticationCodes.add(bArr3);
                    this.imageMetadata.applicationData.add(bArrConcatenateBlocks2);
                } else {
                    do {
                        unsignedByte = this.stream.readUnsignedByte();
                        this.stream.skipBytes(unsignedByte);
                    } while (unsignedByte > 0);
                }
            }
        } catch (IIOException e) {
            throw e;
        } catch (IOException e2) {
            throw new IIOException("I/O error reading image metadata!", e2);
        }
    }

    private void resetStreamSettings() {
        this.gotHeader = false;
        this.streamMetadata = null;
        this.currIndex = -1;
        this.imageMetadata = null;
        this.imageStartPosition = new ArrayList();
        this.numImages = -1;
        this.blockLength = 0;
        this.bitPos = 0;
        this.nextByte = 0;
        this.next32Bits = 0;
        this.lastBlockFound = false;
        this.theImage = null;
        this.theTile = null;
        this.width = -1;
        this.height = -1;
        this.streamX = -1;
        this.streamY = -1;
        this.rowsDone = 0;
        this.interlacePass = 0;
        this.fallbackColorTable = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        r4.stream.skipBytes(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r1 = r4.stream.readUnsignedByte();
        r4.stream.skipBytes(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        if (r1 > 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r4.stream.skipBytes(8);
        r1 = r4.stream.readUnsignedByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((r1 & 128) == 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        r4.stream.skipBytes((1 << ((r1 & 7) + 1)) * 3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean skipImage() throws IIOException {
        int unsignedByte;
        int unsignedByte2;
        while (true) {
            try {
                int unsignedByte3 = this.stream.readUnsignedByte();
                if (unsignedByte3 == 44) {
                    break;
                }
                if (unsignedByte3 == 59) {
                    return false;
                }
                if (unsignedByte3 == 33) {
                    this.stream.readUnsignedByte();
                    do {
                        unsignedByte = this.stream.readUnsignedByte();
                        this.stream.skipBytes(unsignedByte);
                    } while (unsignedByte > 0);
                } else {
                    if (unsignedByte3 == 0) {
                        return false;
                    }
                    do {
                        unsignedByte2 = this.stream.readUnsignedByte();
                        this.stream.skipBytes(unsignedByte2);
                    } while (unsignedByte2 > 0);
                }
            } catch (EOFException unused) {
                return false;
            } catch (IOException e) {
                throw new IIOException("I/O error locating image!", e);
            }
        }
    }

    private void startPass(int i) {
        if (this.updateListeners == null || !this.imageMetadata.interlaceFlag) {
            return;
        }
        int[] iArr = interlaceOffset;
        int i2 = this.interlacePass;
        int i4 = iArr[i2];
        int i5 = interlaceIncrement[i2];
        Rectangle rectangle = this.sourceRegion;
        Point point = this.destinationOffset;
        Rectangle rectangle2 = this.destinationRegion;
        int i6 = rectangle2.f10094x;
        int i7 = rectangle2.f10095y;
        int i8 = rectangle2.width;
        int i9 = rectangle2.height;
        int[] iArrComputeUpdatedPixels = ReaderUtil.computeUpdatedPixels(rectangle, point, i6, i7, (i6 + i8) - 1, (i7 + i9) - 1, this.sourceXSubsampling, this.sourceYSubsampling, 0, i4, i8, AbstractC4539a.m3211u(i9, i5, 1, i5), 1, i5);
        int i10 = iArrComputeUpdatedPixels[1];
        this.updateMinY = i10;
        int i11 = iArrComputeUpdatedPixels[5];
        this.updateYStep = i11;
        processPassStarted(this.theImage, this.interlacePass, this.sourceMinProgressivePass, this.sourceMaxProgressivePass, 0, i10, 1, i11, new int[]{0});
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public ImageReadParam getDefaultReadParam() {
        return new ImageReadParam();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getHeight(int i) throws IIOException {
        checkIndex(i);
        if (locateImage(i) != i) {
            throw new IndexOutOfBoundsException();
        }
        readMetadata();
        return this.imageMetadata.imageHeight;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getImageMetadata(int i) throws IIOException {
        checkIndex(i);
        if (locateImage(i) != i) {
            throw new IndexOutOfBoundsException("Bad image index!");
        }
        readMetadata();
        return this.imageMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public Iterator getImageTypes(int i) throws IIOException {
        checkIndex(i);
        if (locateImage(i) != i) {
            throw new IndexOutOfBoundsException();
        }
        readMetadata();
        ArrayList arrayList = new ArrayList(1);
        byte[] bArr = this.imageMetadata.localColorTable;
        if (bArr != null) {
            this.fallbackColorTable = bArr;
        } else {
            bArr = this.streamMetadata.globalColorTable;
        }
        if (bArr == null) {
            if (this.fallbackColorTable == null) {
                processWarningOccurred("Use default color table.");
                this.fallbackColorTable = getDefaultPalette();
            }
            bArr = this.fallbackColorTable;
        }
        int length = bArr.length / 3;
        int i2 = 2;
        if (length == 2) {
            i2 = 1;
        } else if (length != 4) {
            i2 = 8;
            if (length == 8 || length == 16) {
                i2 = 4;
            }
        }
        int i4 = 1 << i2;
        byte[] bArr2 = new byte[i4];
        byte[] bArr3 = new byte[i4];
        byte[] bArr4 = new byte[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            bArr2[i6] = bArr[i5];
            int i7 = i5 + 2;
            bArr3[i6] = bArr[i5 + 1];
            i5 += 3;
            bArr4[i6] = bArr[i7];
        }
        arrayList.add(createIndexed(bArr2, bArr3, bArr4, i2));
        return arrayList.iterator();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getNumImages(boolean z) {
        if (this.stream == null) {
            throw new IllegalStateException("Input not set!");
        }
        if (this.seekForwardOnly && z) {
            throw new IllegalStateException("seekForwardOnly and allowSearch can't both be true!");
        }
        int i = this.numImages;
        if (i > 0) {
            return i;
        }
        if (z) {
            this.numImages = locateImage(Integer.MAX_VALUE) + 1;
        }
        return this.numImages;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public IIOMetadata getStreamMetadata() throws IIOException {
        readHeader();
        return this.streamMetadata;
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public int getWidth(int i) throws IIOException {
        checkIndex(i);
        if (locateImage(i) != i) {
            throw new IndexOutOfBoundsException();
        }
        readMetadata();
        return this.imageMetadata.imageWidth;
    }

    public void initializeStringTable(int[] iArr, byte[] bArr, byte[] bArr2, int[] iArr2) {
        int i = 1 << this.initCodeSize;
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = -1;
            byte b = (byte) i2;
            bArr[i2] = b;
            bArr2[i2] = b;
            iArr2[i2] = 1;
        }
        while (i < 4096) {
            iArr[i] = -1;
            iArr2[i] = 1;
            i++;
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public BufferedImage read(int i, ImageReadParam imageReadParam) throws IIOException {
        int i2;
        if (this.stream == null) {
            throw new IllegalStateException("Input not set!");
        }
        checkIndex(i);
        if (locateImage(i) != i) {
            throw new IndexOutOfBoundsException("imageIndex out of bounds!");
        }
        clearAbortRequest();
        readMetadata();
        ImageReadParam defaultReadParam = imageReadParam == null ? getDefaultReadParam() : imageReadParam;
        Iterator imageTypes = getImageTypes(i);
        GIFImageMetadata gIFImageMetadata = this.imageMetadata;
        BufferedImage destination = ImageReader.getDestination(defaultReadParam, imageTypes, gIFImageMetadata.imageWidth, gIFImageMetadata.imageHeight);
        this.theImage = destination;
        int i4 = 0;
        this.theTile = destination.getWritableTile(0, 0);
        GIFImageMetadata gIFImageMetadata2 = this.imageMetadata;
        this.width = gIFImageMetadata2.imageWidth;
        this.height = gIFImageMetadata2.imageHeight;
        this.streamX = 0;
        this.streamY = 0;
        this.rowsDone = 0;
        this.interlacePass = 0;
        this.sourceRegion = new Rectangle(0, 0, 0, 0);
        Rectangle rectangle = new Rectangle(0, 0, 0, 0);
        this.destinationRegion = rectangle;
        ImageReader.computeRegions(defaultReadParam, this.width, this.height, this.theImage, this.sourceRegion, rectangle);
        Rectangle rectangle2 = this.destinationRegion;
        this.destinationOffset = new Point(rectangle2.f10094x, rectangle2.f10095y);
        this.sourceXSubsampling = defaultReadParam.getSourceXSubsampling();
        this.sourceYSubsampling = defaultReadParam.getSourceYSubsampling();
        this.sourceMinProgressivePass = Math.max(defaultReadParam.getSourceMinProgressivePass(), 0);
        this.sourceMaxProgressivePass = Math.min(defaultReadParam.getSourceMaxProgressivePass(), 3);
        this.destY = ((this.streamY - this.sourceRegion.f10095y) / this.sourceYSubsampling) + this.destinationRegion.f10095y;
        computeDecodeThisRow();
        processImageStarted(i);
        startPass(0);
        this.rowBuf = new byte[this.width];
        try {
            this.initCodeSize = this.stream.readUnsignedByte();
            int unsignedByte = this.stream.readUnsignedByte();
            this.blockLength = unsignedByte;
            int i5 = 0;
            while (unsignedByte > 0) {
                int i6 = this.stream.read(this.block, i5, unsignedByte);
                unsignedByte -= i6;
                i5 += i6;
            }
            this.bitPos = 0;
            this.nextByte = 0;
            this.lastBlockFound = false;
            this.interlacePass = 0;
            initNext32Bits();
            int i7 = 1 << this.initCodeSize;
            this.clearCode = i7;
            this.eofCode = i7 + 1;
            int[] iArr = new int[4096];
            byte[] bArr = new byte[4096];
            byte[] bArr2 = new byte[4096];
            int[] iArr2 = new int[4096];
            byte[] bArr3 = new byte[4096];
            initializeStringTable(iArr, bArr, bArr2, iArr2);
            int i8 = this.initCodeSize;
            int i9 = (1 << i8) + 2;
            int i10 = i8 + 1;
            int i11 = (1 << i10) - 1;
            while (!abortRequested()) {
                int code = getCode(i10, i11);
                if (code == this.clearCode) {
                    initializeStringTable(iArr, bArr, bArr2, iArr2);
                    int i12 = this.initCodeSize;
                    int i13 = (1 << i12) + 2;
                    i10 = i12 + 1;
                    int i14 = (1 << i10) - 1;
                    int code2 = getCode(i10, i14);
                    if (code2 == this.eofCode) {
                        processImageComplete();
                        return this.theImage;
                    }
                    i9 = i13;
                    i4 = code2;
                    i11 = i14;
                } else {
                    if (code == this.eofCode) {
                        processImageComplete();
                        return this.theImage;
                    }
                    if (code < i9) {
                        i2 = code;
                    } else {
                        if (code != i9) {
                            processWarningOccurred("Out-of-sequence code!");
                        }
                        i2 = i4;
                    }
                    iArr[i9] = i4;
                    bArr[i9] = bArr2[i2];
                    bArr2[i9] = bArr2[i4];
                    iArr2[i9] = iArr2[i4] + 1;
                    i9++;
                    if (i9 == (1 << i10) && i9 < 4096) {
                        i10++;
                        i11 = (1 << i10) - 1;
                    }
                    i4 = code;
                }
                int i15 = iArr2[i4];
                int i16 = i4;
                for (int i17 = i15 - 1; i17 >= 0; i17--) {
                    bArr3[i17] = bArr[i16];
                    i16 = iArr[i16];
                }
                outputPixels(bArr3, i15);
            }
            processReadAborted();
            return this.theImage;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IIOException("I/O error reading image!", e);
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void reset() {
        super.reset();
        resetStreamSettings();
    }

    @Override // org.apache.poi.javax.imageio.ImageReader
    public void setInput(Object obj, boolean z, boolean z2) {
        super.setInput(obj, z, z2);
        if (obj == null) {
            this.stream = null;
        } else {
            if (!(obj instanceof ImageInputStream)) {
                throw new IllegalArgumentException("input not an ImageInputStream!");
            }
            this.stream = (ImageInputStream) obj;
        }
        resetStreamSettings();
    }
}
