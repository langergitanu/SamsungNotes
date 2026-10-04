package com.sun.imageio.plugins.jpeg;

import com.google.android.gms.common.data.AbstractC4539a;
import com.sun.imageio.plugins.jpeg.DHTMarkerSegment;
import com.sun.imageio.plugins.jpeg.DQTMarkerSegment;
import com.sun.imageio.plugins.jpeg.JPEG;
import com.sun.imageio.plugins.jpeg.SOFMarkerSegment;
import com.sun.imageio.plugins.jpeg.SOSMarkerSegment;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.color.ICC_ColorSpace;
import org.apache.poi.java.awt.color.ICC_Profile;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorConvertOp;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.DataBufferByte;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.WritableRaster;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.IIOImage;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriteParam;
import org.apache.poi.javax.imageio.ImageWriter;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGQTable;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.apache.poi.sun.java2d.Disposer;
import org.apache.poi.sun.java2d.DisposerRecord;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEGImageWriter extends ImageWriter {
    private static final int MAX_WARNING = 15;
    protected static final int WARNING_DEST_IGNORED = 0;
    protected static final int WARNING_DEST_METADATA_ADOBE_MISMATCH = 4;
    protected static final int WARNING_DEST_METADATA_COMP_MISMATCH = 2;
    protected static final int WARNING_DEST_METADATA_JFIF_MISMATCH = 3;
    protected static final int WARNING_FORCING_JFIF = 11;
    protected static final int WARNING_IGNORING_THUMBS = 10;
    protected static final int WARNING_ILLEGAL_THUMBNAIL = 9;
    protected static final int WARNING_IMAGE_METADATA_ADOBE_MISMATCH = 6;
    protected static final int WARNING_IMAGE_METADATA_JFIF_MISMATCH = 5;
    protected static final int WARNING_METADATA_ADJUSTED_FOR_THUMB = 13;
    protected static final int WARNING_METADATA_NOT_JPEG_FOR_RASTER = 7;
    protected static final int WARNING_NO_BANDS_ON_INDEXED = 8;
    protected static final int WARNING_NO_GRAY_THUMB_AS_INDEXED = 15;
    protected static final int WARNING_NO_RGB_THUMB_AS_INDEXED = 14;
    protected static final int WARNING_STREAM_METADATA_IGNORED = 1;
    protected static final int WARNING_THUMB_CLIPPED = 12;
    static final Dimension[] preferredThumbSizes;
    private CallBackLock cbLock;
    private ColorConvertOp convertOp;
    private boolean convertTosRGB;
    private WritableRaster converted;
    private int currentImage;
    private boolean debug;
    private DisposerRecord disposerRecord;
    private Object disposerReferent;
    private boolean forceJFIF;
    private ICC_Profile iccProfile;
    private boolean ignoreAdobe;
    private boolean ignoreJFIF;
    private IndexColorModel indexCM;
    private boolean indexed;
    private ImageOutputStream ios;
    private boolean isAlphaPremultiplied;
    private JPEGMetadata metadata;
    private int newAdobeTransform;
    private int numScans;
    private WritableRaster raster;
    private boolean sequencePrepared;
    private int sourceHeight;
    private int sourceWidth;
    private int sourceXOffset;
    private int sourceYOffset;
    private int[] srcBands;
    private ColorModel srcCM;
    private Raster srcRas;
    private JPEGHuffmanTable[] streamACHuffmanTables;
    private JPEGHuffmanTable[] streamDCHuffmanTables;
    private JPEGQTable[] streamQTables;
    private long structPointer;
    private int theLockCount;
    private Thread theThread;
    private List thumbnails;
    private boolean writeAdobe;
    private boolean writeDefaultJFIF;

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
                throw new IllegalStateException("Access to the writer is not allowed");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class JPEGWriterDisposerRecord implements DisposerRecord {
        private long pData;

        public JPEGWriterDisposerRecord(long j) {
            this.pData = j;
        }

        @Override // org.apache.poi.sun.java2d.DisposerRecord
        public synchronized void dispose() {
            long j = this.pData;
            if (j != 0) {
                JPEGImageWriter.disposeWriter(j);
                this.pData = 0L;
            }
        }
    }

    static {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: com.sun.imageio.plugins.jpeg.JPEGImageWriter.1
            @Override // java.security.PrivilegedAction
            public Void run() {
                System.loadLibrary("jpeg");
                return null;
            }
        });
        initWriterIDs(JPEGQTable.class, JPEGHuffmanTable.class);
        preferredThumbSizes = new Dimension[]{new Dimension(1, 1), new Dimension(255, 255)};
    }

    public JPEGImageWriter(ImageWriterSpi imageWriterSpi) {
        super(imageWriterSpi);
        this.debug = false;
        this.structPointer = 0L;
        this.ios = null;
        this.srcRas = null;
        this.raster = null;
        this.indexed = false;
        this.indexCM = null;
        this.convertTosRGB = false;
        this.converted = null;
        this.isAlphaPremultiplied = false;
        this.srcCM = null;
        this.thumbnails = null;
        this.iccProfile = null;
        this.sourceXOffset = 0;
        this.sourceYOffset = 0;
        this.sourceWidth = 0;
        this.srcBands = null;
        this.sourceHeight = 0;
        this.currentImage = 0;
        this.convertOp = null;
        this.streamQTables = null;
        this.streamDCHuffmanTables = null;
        this.streamACHuffmanTables = null;
        this.ignoreJFIF = false;
        this.forceJFIF = false;
        this.ignoreAdobe = false;
        this.newAdobeTransform = -1;
        this.writeDefaultJFIF = false;
        this.writeAdobe = false;
        this.metadata = null;
        this.sequencePrepared = false;
        this.numScans = 0;
        this.disposerReferent = new Object();
        this.theThread = null;
        this.theLockCount = 0;
        this.cbLock = new CallBackLock();
        long jInitJPEGImageWriter = initJPEGImageWriter();
        this.structPointer = jInitJPEGImageWriter;
        JPEGWriterDisposerRecord jPEGWriterDisposerRecord = new JPEGWriterDisposerRecord(jInitJPEGImageWriter);
        this.disposerRecord = jPEGWriterDisposerRecord;
        Disposer.addRecord(this.disposerReferent, jPEGWriterDisposerRecord);
    }

    private native void abortWrite(long j);

    private void checkAdobe(AdobeMarkerSegment adobeMarkerSegment, ImageTypeSpecifier imageTypeSpecifier, boolean z) {
        int iTransformForType;
        if (adobeMarkerSegment == null || adobeMarkerSegment.transform == (iTransformForType = JPEG.transformForType(imageTypeSpecifier, z))) {
            return;
        }
        warningOccurred(z ? 6 : 4);
        if (iTransformForType == -1) {
            this.ignoreAdobe = true;
        } else {
            this.newAdobeTransform = iTransformForType;
        }
    }

    private void checkJFIF(JFIFMarkerSegment jFIFMarkerSegment, ImageTypeSpecifier imageTypeSpecifier, boolean z) {
        if (jFIFMarkerSegment == null || JPEG.isJFIFcompliant(imageTypeSpecifier, z)) {
            return;
        }
        this.ignoreJFIF = true;
        warningOccurred(z ? 5 : 3);
    }

    private void checkSOFBands(SOFMarkerSegment sOFMarkerSegment, int i) throws IIOException {
        if (sOFMarkerSegment != null && sOFMarkerSegment.componentSpecs.length != i) {
            throw new IIOException("Metadata components != number of destination bands");
        }
    }

    private synchronized void clearThreadLock() {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.theThread;
        if (thread == null || thread != threadCurrentThread) {
            throw new IllegalStateException("Attempt to clear thread lock form wrong thread. Locked thread: " + this.theThread + "; current thread: " + threadCurrentThread);
        }
        int i = this.theLockCount - 1;
        this.theLockCount = i;
        if (i == 0) {
            this.theThread = null;
        }
    }

    private JPEGHuffmanTable[] collectHTablesFromMetadata(JPEGMetadata jPEGMetadata, boolean z) throws IIOException {
        ArrayList arrayList = new ArrayList();
        Iterator it = jPEGMetadata.markerSequence.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MarkerSegment markerSegment = (MarkerSegment) it.next();
            if (markerSegment instanceof DHTMarkerSegment) {
                DHTMarkerSegment dHTMarkerSegment = (DHTMarkerSegment) markerSegment;
                for (int i = 0; i < dHTMarkerSegment.tables.size(); i++) {
                    DHTMarkerSegment.Htable htable = (DHTMarkerSegment.Htable) dHTMarkerSegment.tables.get(i);
                    if (htable.tableClass == (!z)) {
                        arrayList.add(htable);
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        DHTMarkerSegment.Htable[] htableArr = new DHTMarkerSegment.Htable[arrayList.size()];
        arrayList.toArray(htableArr);
        int size = arrayList.size();
        JPEGHuffmanTable[] jPEGHuffmanTableArr = new JPEGHuffmanTable[size];
        for (int i2 = 0; i2 < size; i2++) {
            jPEGHuffmanTableArr[i2] = null;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (htableArr[i4].tableID == i2) {
                    if (jPEGHuffmanTableArr[i2] != null) {
                        throw new IIOException("Metadata has duplicate Htables!");
                    }
                    DHTMarkerSegment.Htable htable2 = htableArr[i4];
                    jPEGHuffmanTableArr[i2] = new JPEGHuffmanTable(htable2.numCodes, htable2.values);
                }
            }
        }
        return jPEGHuffmanTableArr;
    }

    private JPEGQTable[] collectQTablesFromMetadata(JPEGMetadata jPEGMetadata) {
        ArrayList arrayList = new ArrayList();
        for (MarkerSegment markerSegment : jPEGMetadata.markerSequence) {
            if (markerSegment instanceof DQTMarkerSegment) {
                arrayList.addAll(((DQTMarkerSegment) markerSegment).tables);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        int size = arrayList.size();
        JPEGQTable[] jPEGQTableArr = new JPEGQTable[size];
        for (int i = 0; i < size; i++) {
            jPEGQTableArr[i] = new JPEGQTable(((DQTMarkerSegment.Qtable) arrayList.get(i)).data);
        }
        return jPEGQTableArr;
    }

    private int[] collectScans(JPEGMetadata jPEGMetadata, SOFMarkerSegment sOFMarkerSegment) {
        int i;
        ArrayList arrayList = new ArrayList();
        for (MarkerSegment markerSegment : jPEGMetadata.markerSequence) {
            if (markerSegment instanceof SOSMarkerSegment) {
                arrayList.add(markerSegment);
            }
        }
        this.numScans = 0;
        if (arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        this.numScans = size;
        int[] iArr = new int[size * 9];
        int i2 = 0;
        int i4 = 0;
        while (i2 < this.numScans) {
            SOSMarkerSegment sOSMarkerSegment = (SOSMarkerSegment) arrayList.get(i2);
            int i5 = i4 + 1;
            iArr[i4] = sOSMarkerSegment.componentSpecs.length;
            for (int i6 = 0; i6 < 4; i6++) {
                SOSMarkerSegment.ScanComponentSpec[] scanComponentSpecArr = sOSMarkerSegment.componentSpecs;
                if (i6 < scanComponentSpecArr.length) {
                    int i7 = scanComponentSpecArr[i6].componentSelector;
                    int i8 = 0;
                    while (true) {
                        SOFMarkerSegment.ComponentSpec[] componentSpecArr = sOFMarkerSegment.componentSpecs;
                        if (i8 >= componentSpecArr.length) {
                            break;
                        }
                        if (i7 == componentSpecArr[i8].componentId) {
                            i = i5 + 1;
                            iArr[i5] = i8;
                            break;
                        }
                        i8++;
                    }
                } else {
                    i = i5 + 1;
                    iArr[i5] = 0;
                }
                i5 = i;
            }
            iArr[i5] = sOSMarkerSegment.startSpectralSelection;
            iArr[i5 + 1] = sOSMarkerSegment.endSpectralSelection;
            iArr[i5 + 2] = sOSMarkerSegment.approxHigh;
            iArr[i5 + 3] = sOSMarkerSegment.approxLow;
            i2++;
            i4 = i5 + 4;
        }
        return iArr;
    }

    private IIOMetadata convertImageMetadataOnThread(IIOMetadata iIOMetadata, ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        Node asTree;
        if (iIOMetadata instanceof JPEGMetadata) {
            if (((JPEGMetadata) iIOMetadata).isStream) {
                return null;
            }
            return iIOMetadata;
        }
        if (iIOMetadata.isStandardMetadataFormatSupported() && (asTree = iIOMetadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName)) != null) {
            JPEGMetadata jPEGMetadata = new JPEGMetadata(imageTypeSpecifier, imageWriteParam, this);
            try {
                jPEGMetadata.setFromTree(IIOMetadataFormatImpl.standardMetadataFormatName, asTree);
                return jPEGMetadata;
            } catch (IIOInvalidTreeException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void disposeWriter(long j);

    private int getDefaultDestCSType(ImageTypeSpecifier imageTypeSpecifier) {
        return getDefaultDestCSType(imageTypeSpecifier.getColorModel());
    }

    private int getDestCSType(ImageTypeSpecifier imageTypeSpecifier) {
        ColorModel colorModel = imageTypeSpecifier.getColorModel();
        boolean zHasAlpha = colorModel.hasAlpha();
        int type = colorModel.getColorSpace().getType();
        if (type == 3) {
            return zHasAlpha ? 7 : 3;
        }
        if (type == 9) {
            return 4;
        }
        if (type != 13) {
            return type != 5 ? type != 6 ? 0 : 1 : zHasAlpha ? 6 : 2;
        }
        JPEG.JCS.getYCC();
        return 4;
    }

    private int getSrcCSType(ImageTypeSpecifier imageTypeSpecifier) {
        return getSrcCSType(imageTypeSpecifier.getColorModel());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void grabPixels(int i) {
        Raster rasterCreateChild;
        if (this.indexed) {
            rasterCreateChild = this.indexCM.convertToIntDiscrete(this.srcRas.createChild(this.sourceXOffset, this.sourceYOffset + i, this.sourceWidth, 1, 0, 0, new int[]{0}), this.indexCM.getTransparency() != 1).getRaster();
        } else {
            rasterCreateChild = this.srcRas.createChild(this.sourceXOffset, this.sourceYOffset + i, this.sourceWidth, 1, 0, 0, this.srcBands);
        }
        Raster raster = rasterCreateChild;
        if (this.convertTosRGB) {
            if (this.debug) {
                System.out.println("Converting to sRGB");
            }
            WritableRaster writableRasterFilter = this.convertOp.filter(rasterCreateChild, this.converted);
            this.converted = writableRasterFilter;
            raster = writableRasterFilter;
        }
        Raster raster2 = raster;
        Raster rasterCreateChild2 = raster2;
        if (this.isAlphaPremultiplied) {
            WritableRaster writableRasterCreateCompatibleWritableRaster = raster2.createCompatibleWritableRaster();
            writableRasterCreateCompatibleWritableRaster.setPixels(raster2.getMinX(), raster2.getMinY(), raster2.getWidth(), raster2.getHeight(), raster2.getPixels(raster2.getMinX(), raster2.getMinY(), raster2.getWidth(), raster2.getHeight(), (int[]) null));
            this.srcCM.coerceData(writableRasterCreateCompatibleWritableRaster, false);
            rasterCreateChild2 = writableRasterCreateCompatibleWritableRaster.createChild(writableRasterCreateCompatibleWritableRaster.getMinX(), writableRasterCreateCompatibleWritableRaster.getMinY(), writableRasterCreateCompatibleWritableRaster.getWidth(), writableRasterCreateCompatibleWritableRaster.getHeight(), 0, 0, this.srcBands);
        }
        this.raster.setRect(rasterCreateChild2);
        if (i <= 7 || i % 8 != 0) {
            return;
        }
        this.cbLock.lock();
        try {
            processImageProgress((i / this.sourceHeight) * 100.0f);
        } finally {
            this.cbLock.unlock();
        }
    }

    private native long initJPEGImageWriter();

    private static native void initWriterIDs(Class cls, Class cls2);

    private boolean isSubsampled(SOFMarkerSegment.ComponentSpec[] componentSpecArr) {
        SOFMarkerSegment.ComponentSpec componentSpec = componentSpecArr[0];
        int i = componentSpec.HsamplingFactor;
        int i2 = componentSpec.VsamplingFactor;
        for (int i4 = 1; i4 < componentSpecArr.length; i4++) {
            int i5 = componentSpecArr[i4].HsamplingFactor;
            if (i5 != i || i5 != i) {
                return true;
            }
        }
        return false;
    }

    private boolean jfifOK(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam, IIOMetadata iIOMetadata, IIOMetadata iIOMetadata2) {
        if (imageTypeSpecifier != null && !JPEG.isJFIFcompliant(imageTypeSpecifier, true)) {
            return false;
        }
        if (iIOMetadata2 != null) {
            if ((iIOMetadata2 instanceof JPEGMetadata ? (JPEGMetadata) iIOMetadata2 : (JPEGMetadata) convertImageMetadata(iIOMetadata2, imageTypeSpecifier, imageWriteParam)).findMarkerSegment(JFIFMarkerSegment.class, true) == null) {
                return false;
            }
        }
        return true;
    }

    private void prepareWriteSequenceOnThread(IIOMetadata iIOMetadata) throws IIOException {
        JPEGImageWriter jPEGImageWriter;
        if (this.ios == null) {
            throw new IllegalStateException("Output has not been set!");
        }
        if (iIOMetadata == null) {
            jPEGImageWriter = this;
        } else {
            if (!(iIOMetadata instanceof JPEGMetadata)) {
                throw new IIOException("Stream metadata must be JPEG metadata");
            }
            JPEGMetadata jPEGMetadata = (JPEGMetadata) iIOMetadata;
            if (!jPEGMetadata.isStream) {
                throw new IllegalArgumentException("Invalid stream metadata object.");
            }
            if (this.currentImage != 0) {
                throw new IIOException("JPEG Stream metadata must precede all images");
            }
            if (this.sequencePrepared) {
                throw new IIOException("Stream metadata already written!");
            }
            this.streamQTables = collectQTablesFromMetadata(jPEGMetadata);
            if (this.debug) {
                System.out.println("after collecting from stream metadata, streamQTables.length is " + this.streamQTables.length);
            }
            if (this.streamQTables == null) {
                this.streamQTables = JPEG.getDefaultQTables();
            }
            JPEGHuffmanTable[] jPEGHuffmanTableArrCollectHTablesFromMetadata = collectHTablesFromMetadata(jPEGMetadata, true);
            this.streamDCHuffmanTables = jPEGHuffmanTableArrCollectHTablesFromMetadata;
            if (jPEGHuffmanTableArrCollectHTablesFromMetadata == null) {
                this.streamDCHuffmanTables = JPEG.getDefaultHuffmanTables(true);
            }
            JPEGHuffmanTable[] jPEGHuffmanTableArrCollectHTablesFromMetadata2 = collectHTablesFromMetadata(jPEGMetadata, false);
            this.streamACHuffmanTables = jPEGHuffmanTableArrCollectHTablesFromMetadata2;
            if (jPEGHuffmanTableArrCollectHTablesFromMetadata2 == null) {
                this.streamACHuffmanTables = JPEG.getDefaultHuffmanTables(false);
            }
            jPEGImageWriter = this;
            jPEGImageWriter.writeTables(this.structPointer, this.streamQTables, this.streamDCHuffmanTables, this.streamACHuffmanTables);
        }
        jPEGImageWriter.sequencePrepared = true;
    }

    private void resetInternalState() {
        resetWriter(this.structPointer);
        this.srcRas = null;
        this.raster = null;
        this.convertTosRGB = false;
        this.currentImage = 0;
        this.numScans = 0;
        this.metadata = null;
    }

    private native void resetWriter(long j);

    private native void setDest(long j);

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

    private native boolean writeImage(long j, byte[] bArr, int i, int i2, int i4, int[] iArr, int i5, int i6, int i7, int i8, int i9, JPEGQTable[] jPEGQTableArr, boolean z, JPEGHuffmanTable[] jPEGHuffmanTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr2, boolean z2, boolean z3, boolean z4, int i10, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, boolean z5, int i11);

    private void writeMetadata() {
        JPEGMetadata jPEGMetadata = this.metadata;
        if (jPEGMetadata != null) {
            jPEGMetadata.writeToStream(this.ios, this.ignoreJFIF, this.forceJFIF, this.thumbnails, this.iccProfile, this.ignoreAdobe, this.newAdobeTransform, this);
            return;
        }
        if (this.writeDefaultJFIF) {
            JFIFMarkerSegment.writeDefaultJFIF(this.ios, this.thumbnails, this.iccProfile, this);
        }
        if (this.writeAdobe) {
            AdobeMarkerSegment.writeAdobeSegment(this.ios, this.newAdobeTransform);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0622 A[LOOP:3: B:345:0x0620->B:346:0x0622, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x070d A[Catch: all -> 0x0711, TRY_ENTER, TryCatch #0 {all -> 0x0711, blocks: (B:366:0x070d, B:370:0x0716, B:369:0x0713), top: B:382:0x070b }] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0713 A[Catch: all -> 0x0711, TryCatch #0 {all -> 0x0711, blocks: (B:366:0x070d, B:370:0x0716, B:369:0x0713), top: B:382:0x070b }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeOnThread(IIOMetadata iIOMetadata, IIOImage iIOImage, ImageWriteParam imageWriteParam) throws IIOException {
        RenderedImage renderedImage;
        ColorModel colorModel;
        ColorSpace colorSpace;
        int i;
        int[] sampleSize;
        int[] iArr;
        int i2;
        ImageTypeSpecifier destinationType;
        boolean z;
        char c;
        ColorModel colorModel2;
        int subsamplingXOffset;
        int subsamplingYOffset;
        int progressiveMode;
        boolean optimizeHuffmanTables;
        int sourceXSubsampling;
        int sourceYSubsampling;
        JPEGImageWriteParam jPEGImageWriteParam;
        JPEGQTable[] jPEGQTableArr;
        IIOMetadata metadata;
        boolean z2;
        JPEGMetadata jPEGMetadata;
        boolean z3;
        SOFMarkerSegment sOFMarkerSegment;
        JFIFMarkerSegment jFIFMarkerSegment;
        AdobeMarkerSegment adobeMarkerSegment;
        JPEGQTable[] jPEGQTableArr2;
        int srcCSType;
        int iDencodedCSType;
        JPEGMetadata jPEGMetadata2;
        int i4;
        boolean z4;
        int[] iArr2;
        JPEGHuffmanTable[] jPEGHuffmanTableArr;
        JPEGMetadata jPEGMetadata3;
        Object obj;
        Object obj2;
        boolean z5;
        boolean z6;
        int i5;
        JPEGQTable[] jPEGQTableArr3;
        JPEGHuffmanTable[] jPEGHuffmanTableArr2;
        JPEGHuffmanTable[] jPEGHuffmanTableArr3;
        int i6;
        boolean zWriteImage;
        JPEGHuffmanTable[] defaultHuffmanTables;
        JPEGHuffmanTable[] defaultHuffmanTables2;
        JPEGQTable[] defaultQTables;
        int[] iArrCollectScans;
        int[] sourceBands;
        if (this.ios == null) {
            throw new IllegalStateException("Output has not been set!");
        }
        if (iIOImage == null) {
            throw new IllegalArgumentException("image is null!");
        }
        if (iIOMetadata != null) {
            warningOccurred(1);
        }
        boolean zHasRaster = iIOImage.hasRaster();
        if (zHasRaster) {
            this.srcRas = iIOImage.getRaster();
            renderedImage = null;
        } else {
            renderedImage = iIOImage.getRenderedImage();
            if (renderedImage instanceof BufferedImage) {
                this.srcRas = ((BufferedImage) renderedImage).getRaster();
            } else if (renderedImage.getNumXTiles() == 1 && renderedImage.getNumYTiles() == 1) {
                Raster tile = renderedImage.getTile(renderedImage.getMinTileX(), renderedImage.getMinTileY());
                this.srcRas = tile;
                if (tile.getWidth() != renderedImage.getWidth() || this.srcRas.getHeight() != renderedImage.getHeight()) {
                    Raster raster = this.srcRas;
                    this.srcRas = raster.createChild(raster.getMinX(), this.srcRas.getMinY(), renderedImage.getWidth(), renderedImage.getHeight(), this.srcRas.getMinX(), this.srcRas.getMinY(), null);
                }
            } else {
                this.srcRas = renderedImage.getData();
            }
        }
        int numBands = this.srcRas.getNumBands();
        this.indexed = false;
        this.indexCM = null;
        this.isAlphaPremultiplied = false;
        this.srcCM = null;
        if (zHasRaster) {
            colorModel = null;
            colorSpace = null;
        } else {
            colorModel = renderedImage.getColorModel();
            if (colorModel != null) {
                colorSpace = colorModel.getColorSpace();
                if (colorModel instanceof IndexColorModel) {
                    this.indexed = true;
                    this.indexCM = (IndexColorModel) colorModel;
                    numBands = colorModel.getNumComponents();
                }
                if (colorModel.isAlphaPremultiplied()) {
                    this.isAlphaPremultiplied = true;
                    this.srcCM = colorModel;
                }
            } else {
                colorSpace = null;
            }
        }
        this.srcBands = JPEG.bandOffsets[numBands - 1];
        if (imageWriteParam == null || (sourceBands = imageWriteParam.getSourceBands()) == null) {
            i = numBands;
        } else if (this.indexed) {
            warningOccurred(8);
            i = numBands;
        } else {
            this.srcBands = sourceBands;
            int length = sourceBands.length;
            if (length > numBands) {
                throw new IIOException("ImageWriteParam specifies too many source bands");
            }
            i = length;
        }
        boolean z7 = i != numBands;
        boolean z8 = (zHasRaster || z7) ? false : true;
        try {
            try {
                if (!this.indexed) {
                    sampleSize = this.srcRas.getSampleModel().getSampleSize();
                    if (z7) {
                        iArr = new int[i];
                        for (int i7 = 0; i7 < i; i7++) {
                            iArr[i7] = sampleSize[this.srcBands[i7]];
                        }
                    }
                    for (i2 = 0; i2 < iArr.length; i2++) {
                        int i8 = iArr[i2];
                        if (i8 <= 0 || i8 > 8) {
                            throw new IIOException("Illegal band size: should be 0 < size <= 8");
                        }
                        if (this.indexed) {
                            iArr[i2] = 8;
                        }
                    }
                    if (this.debug) {
                        System.out.println("numSrcBands is " + numBands);
                        System.out.println("numBandsUsed is " + i);
                        System.out.println("usingBandSubset is " + z7);
                        System.out.println("fullImage is " + z8);
                        System.out.print("Band sizes:");
                        for (int i9 = 0; i9 < iArr.length; i9++) {
                            System.out.print(" " + iArr[i9]);
                        }
                        System.out.println();
                    }
                    if (imageWriteParam == null) {
                        destinationType = imageWriteParam.getDestinationType();
                        if (z8 && destinationType != null) {
                            warningOccurred(0);
                            destinationType = null;
                        }
                    } else {
                        destinationType = null;
                    }
                    this.sourceXOffset = this.srcRas.getMinX();
                    this.sourceYOffset = this.srcRas.getMinY();
                    int width = this.srcRas.getWidth();
                    int height = this.srcRas.getHeight();
                    this.sourceWidth = width;
                    this.sourceHeight = height;
                    if (imageWriteParam == null) {
                        Rectangle sourceRegion = imageWriteParam.getSourceRegion();
                        if (sourceRegion != null) {
                            c = 0;
                            z = zHasRaster;
                            colorModel2 = colorModel;
                            Rectangle rectangleIntersection = sourceRegion.intersection(new Rectangle(this.sourceXOffset, this.sourceYOffset, this.sourceWidth, this.sourceHeight));
                            this.sourceXOffset = rectangleIntersection.f10094x;
                            this.sourceYOffset = rectangleIntersection.f10095y;
                            this.sourceWidth = rectangleIntersection.width;
                            this.sourceHeight = rectangleIntersection.height;
                        } else {
                            z = zHasRaster;
                            c = 0;
                            colorModel2 = colorModel;
                        }
                        int i10 = this.sourceWidth;
                        int i11 = this.sourceXOffset;
                        if (i10 + i11 > width) {
                            this.sourceWidth = width - i11;
                        }
                        int i12 = this.sourceHeight;
                        int i13 = this.sourceYOffset;
                        if (i12 + i13 > height) {
                            this.sourceHeight = height - i13;
                        }
                        sourceXSubsampling = imageWriteParam.getSourceXSubsampling();
                        sourceYSubsampling = imageWriteParam.getSourceYSubsampling();
                        subsamplingXOffset = imageWriteParam.getSubsamplingXOffset();
                        subsamplingYOffset = imageWriteParam.getSubsamplingYOffset();
                        int compressionMode = imageWriteParam.getCompressionMode();
                        if (compressionMode == 0) {
                            throw new IIOException("JPEG compression cannot be disabled");
                        }
                        if (compressionMode == 1) {
                            JPEGQTable[] jPEGQTableArr4 = new JPEGQTable[2];
                            jPEGQTableArr4[c] = JPEGQTable.K1Div2Luminance;
                            jPEGQTableArr4[1] = JPEGQTable.K2Div2Chrominance;
                            jPEGQTableArr = jPEGQTableArr4;
                        } else if (compressionMode != 2) {
                            jPEGQTableArr = null;
                        } else {
                            float fConvertToLinearQuality = JPEG.convertToLinearQuality(imageWriteParam.getCompressionQuality());
                            jPEGQTableArr = new JPEGQTable[2];
                            jPEGQTableArr[c] = JPEGQTable.K1Luminance.getScaledInstance(fConvertToLinearQuality, true);
                            jPEGQTableArr[1] = JPEGQTable.K2Chrominance.getScaledInstance(fConvertToLinearQuality, true);
                        }
                        progressiveMode = imageWriteParam.getProgressiveMode();
                        if (imageWriteParam instanceof JPEGImageWriteParam) {
                            jPEGImageWriteParam = (JPEGImageWriteParam) imageWriteParam;
                            optimizeHuffmanTables = jPEGImageWriteParam.getOptimizeHuffmanTables();
                        } else {
                            optimizeHuffmanTables = c;
                            jPEGImageWriteParam = null;
                        }
                    } else {
                        z = zHasRaster;
                        c = 0;
                        colorModel2 = colorModel;
                        subsamplingXOffset = 0;
                        subsamplingYOffset = 0;
                        progressiveMode = 0;
                        optimizeHuffmanTables = 0;
                        sourceXSubsampling = 1;
                        sourceYSubsampling = 1;
                        jPEGImageWriteParam = null;
                        jPEGQTableArr = null;
                    }
                    metadata = iIOImage.getMetadata();
                    int i14 = subsamplingXOffset;
                    if (metadata != null) {
                        if (metadata instanceof JPEGMetadata) {
                            this.metadata = (JPEGMetadata) metadata;
                            if (this.debug) {
                                System.out.println("We have metadata, and it's JPEG metadata");
                            }
                        } else if (z) {
                            warningOccurred(7);
                        } else {
                            this.metadata = (JPEGMetadata) convertImageMetadata(metadata, destinationType == null ? new ImageTypeSpecifier(renderedImage) : destinationType, imageWriteParam);
                        }
                        z2 = c;
                        this.ignoreJFIF = z2;
                        this.ignoreAdobe = z2;
                        this.newAdobeTransform = -1;
                        this.writeDefaultJFIF = z2;
                        this.writeAdobe = z2;
                        jPEGMetadata = this.metadata;
                        int i15 = subsamplingYOffset;
                        JPEGImageWriteParam jPEGImageWriteParam2 = jPEGImageWriteParam;
                        if (jPEGMetadata != null) {
                            JFIFMarkerSegment jFIFMarkerSegment2 = (JFIFMarkerSegment) jPEGMetadata.findMarkerSegment(JFIFMarkerSegment.class, true);
                            z3 = z8;
                            AdobeMarkerSegment adobeMarkerSegment2 = (AdobeMarkerSegment) this.metadata.findMarkerSegment(AdobeMarkerSegment.class, true);
                            sOFMarkerSegment = (SOFMarkerSegment) this.metadata.findMarkerSegment(SOFMarkerSegment.class, true);
                            adobeMarkerSegment = adobeMarkerSegment2;
                            jFIFMarkerSegment = jFIFMarkerSegment2;
                        } else {
                            z3 = z8;
                            sOFMarkerSegment = null;
                            jFIFMarkerSegment = null;
                            adobeMarkerSegment = null;
                        }
                        jPEGQTableArr2 = jPEGQTableArr;
                        this.iccProfile = null;
                        int[] iArr3 = iArr;
                        this.convertTosRGB = false;
                        this.converted = null;
                        if (destinationType == null) {
                            if (this.metadata == null) {
                                if (z3) {
                                    JPEGMetadata jPEGMetadata4 = new JPEGMetadata(new ImageTypeSpecifier(renderedImage), imageWriteParam, this);
                                    this.metadata = jPEGMetadata4;
                                    if (jPEGMetadata4.findMarkerSegment(JFIFMarkerSegment.class, true) != null) {
                                        ColorSpace colorSpace2 = renderedImage.getColorModel().getColorSpace();
                                        if (JPEG.isNonStandardICC(colorSpace2)) {
                                            this.iccProfile = ((ICC_ColorSpace) colorSpace2).getProfile();
                                        }
                                    }
                                    srcCSType = getSrcCSType(renderedImage);
                                    iDencodedCSType = getDefaultDestCSType(renderedImage);
                                }
                                srcCSType = 0;
                            } else {
                                checkSOFBands(sOFMarkerSegment, i);
                                if (z3) {
                                    new ImageTypeSpecifier(renderedImage);
                                    srcCSType = getSrcCSType(renderedImage);
                                    if (colorModel2 != null) {
                                        boolean zHasAlpha = colorModel2.hasAlpha();
                                        int type = colorSpace.getType();
                                        int i16 = 6;
                                        if (type != 5) {
                                            if (type == 6) {
                                                if (zHasAlpha) {
                                                    if (jFIFMarkerSegment != null) {
                                                        this.ignoreJFIF = true;
                                                        warningOccurred(5);
                                                    }
                                                    iDencodedCSType = 0;
                                                } else {
                                                    iDencodedCSType = 1;
                                                }
                                                if (adobeMarkerSegment != null && adobeMarkerSegment.transform != 0) {
                                                    this.newAdobeTransform = 0;
                                                    warningOccurred(6);
                                                }
                                            } else if (type == 13 && colorSpace == JPEG.JCS.getYCC()) {
                                                if (zHasAlpha) {
                                                    if (jFIFMarkerSegment != null) {
                                                        this.ignoreJFIF = true;
                                                        warningOccurred(5);
                                                    } else if (adobeMarkerSegment != null && adobeMarkerSegment.transform != 0) {
                                                        this.newAdobeTransform = 0;
                                                        warningOccurred(6);
                                                    }
                                                    iDencodedCSType = 10;
                                                } else if (jFIFMarkerSegment != null) {
                                                    this.convertTosRGB = true;
                                                    this.convertOp = new ColorConvertOp(colorSpace, JPEG.JCS.sRGB, null);
                                                    iDencodedCSType = 3;
                                                } else {
                                                    if (adobeMarkerSegment != null && adobeMarkerSegment.transform != 1) {
                                                        this.newAdobeTransform = 1;
                                                        warningOccurred(6);
                                                    }
                                                    iDencodedCSType = 5;
                                                }
                                            }
                                        } else if (zHasAlpha) {
                                            if (jFIFMarkerSegment != null) {
                                                this.ignoreJFIF = true;
                                                warningOccurred(5);
                                            }
                                            if (adobeMarkerSegment == null) {
                                                int iDencodedCSType2 = sOFMarkerSegment.getIDencodedCSType();
                                                if (iDencodedCSType2 != 0) {
                                                    i16 = iDencodedCSType2;
                                                } else if (isSubsampled(sOFMarkerSegment.componentSpecs)) {
                                                    i16 = 7;
                                                }
                                            } else if (adobeMarkerSegment.transform != 0) {
                                                this.newAdobeTransform = 0;
                                                warningOccurred(6);
                                            }
                                            iDencodedCSType = i16;
                                        } else {
                                            if (jFIFMarkerSegment != null) {
                                                if (JPEG.isNonStandardICC(colorSpace) || ((colorSpace instanceof ICC_ColorSpace) && jFIFMarkerSegment.iccSegment != null)) {
                                                    this.iccProfile = ((ICC_ColorSpace) colorSpace).getProfile();
                                                }
                                            } else if (adobeMarkerSegment != null) {
                                                int i17 = adobeMarkerSegment.transform;
                                                if (i17 != 0) {
                                                    if (i17 != 1) {
                                                        warningOccurred(6);
                                                        this.newAdobeTransform = 0;
                                                    }
                                                }
                                                iDencodedCSType = 2;
                                            } else {
                                                iDencodedCSType = sOFMarkerSegment.getIDencodedCSType();
                                                if (iDencodedCSType == 0) {
                                                    if (!isSubsampled(sOFMarkerSegment.componentSpecs)) {
                                                        iDencodedCSType = 2;
                                                    }
                                                }
                                            }
                                            iDencodedCSType = 3;
                                        }
                                    }
                                } else {
                                    srcCSType = 0;
                                }
                            }
                            iDencodedCSType = 0;
                        } else {
                            if (i != destinationType.getNumBands()) {
                                throw new IIOException("Number of source bands != number of destination bands");
                            }
                            ColorSpace colorSpace3 = destinationType.getColorModel().getColorSpace();
                            if (this.metadata != null) {
                                checkSOFBands(sOFMarkerSegment, i);
                                checkJFIF(jFIFMarkerSegment, destinationType, false);
                                if (jFIFMarkerSegment != null && !this.ignoreJFIF && JPEG.isNonStandardICC(colorSpace3)) {
                                    this.iccProfile = ((ICC_ColorSpace) colorSpace3).getProfile();
                                }
                                checkAdobe(adobeMarkerSegment, destinationType, false);
                            } else {
                                if (JPEG.isJFIFcompliant(destinationType, false)) {
                                    this.writeDefaultJFIF = true;
                                    if (JPEG.isNonStandardICC(colorSpace3)) {
                                        this.iccProfile = ((ICC_ColorSpace) colorSpace3).getProfile();
                                    }
                                } else {
                                    int iTransformForType = JPEG.transformForType(destinationType, false);
                                    if (iTransformForType != -1) {
                                        this.writeAdobe = true;
                                        this.newAdobeTransform = iTransformForType;
                                    }
                                }
                                this.metadata = new JPEGMetadata(destinationType, null, this);
                            }
                            srcCSType = getSrcCSType(destinationType);
                            iDencodedCSType = getDefaultDestCSType(destinationType);
                        }
                        jPEGMetadata2 = this.metadata;
                        if (jPEGMetadata2 != null) {
                            if (sOFMarkerSegment == null) {
                                sOFMarkerSegment = (SOFMarkerSegment) jPEGMetadata2.findMarkerSegment(SOFMarkerSegment.class, true);
                            }
                            if (sOFMarkerSegment == null || sOFMarkerSegment.tag != 194) {
                                z4 = false;
                            } else if (progressiveMode == 3) {
                                iArrCollectScans = collectScans(this.metadata, sOFMarkerSegment);
                                z4 = true;
                                if (jFIFMarkerSegment == null) {
                                    jFIFMarkerSegment = (JFIFMarkerSegment) this.metadata.findMarkerSegment(JFIFMarkerSegment.class, true);
                                }
                                i4 = i15;
                                iArr2 = iArrCollectScans;
                            } else {
                                this.numScans = 0;
                                z4 = true;
                            }
                            iArrCollectScans = null;
                            if (jFIFMarkerSegment == null) {
                            }
                            i4 = i15;
                            iArr2 = iArrCollectScans;
                        } else {
                            i4 = i15;
                            z4 = false;
                            iArr2 = null;
                        }
                        this.thumbnails = iIOImage.getThumbnails();
                        int numThumbnails = iIOImage.getNumThumbnails();
                        this.forceJFIF = false;
                        if (this.writeDefaultJFIF) {
                            jPEGHuffmanTableArr = null;
                        } else if (this.metadata == null) {
                            jPEGHuffmanTableArr = null;
                            this.thumbnails = null;
                            if (numThumbnails != 0) {
                                warningOccurred(10);
                            }
                        } else {
                            jPEGHuffmanTableArr = null;
                            if (z3) {
                                if (jFIFMarkerSegment == null) {
                                    if (iDencodedCSType != 1 && iDencodedCSType != 3) {
                                        this.thumbnails = null;
                                        if (numThumbnails != 0) {
                                            warningOccurred(10);
                                        }
                                    } else if (numThumbnails != 0) {
                                        this.forceJFIF = true;
                                        warningOccurred(11);
                                    }
                                }
                            } else if (jFIFMarkerSegment == null) {
                                this.thumbnails = null;
                                if (numThumbnails != 0) {
                                    warningOccurred(10);
                                }
                            }
                        }
                        jPEGMetadata3 = this.metadata;
                        boolean z9 = jPEGMetadata3 != null || this.writeDefaultJFIF || this.writeAdobe;
                        if (jPEGMetadata3 != null) {
                            DQTMarkerSegment dQTMarkerSegment = (DQTMarkerSegment) jPEGMetadata3.findMarkerSegment(DQTMarkerSegment.class, true);
                            DHTMarkerSegment dHTMarkerSegment = (DHTMarkerSegment) this.metadata.findMarkerSegment(DHTMarkerSegment.class, true);
                            DRIMarkerSegment dRIMarkerSegment = (DRIMarkerSegment) this.metadata.findMarkerSegment(DRIMarkerSegment.class, true);
                            int i18 = dRIMarkerSegment != null ? dRIMarkerSegment.restartInterval : 0;
                            boolean z10 = dQTMarkerSegment != null;
                            i5 = i18;
                            z6 = dHTMarkerSegment != null;
                            obj2 = dHTMarkerSegment;
                            obj = dQTMarkerSegment;
                            z5 = z10;
                        } else {
                            obj = jPEGHuffmanTableArr;
                            obj2 = obj;
                            z5 = true;
                            z6 = true;
                            i5 = 0;
                        }
                        if (jPEGQTableArr2 == null) {
                            if (obj != null) {
                                defaultQTables = collectQTablesFromMetadata(this.metadata);
                            } else {
                                defaultQTables = this.streamQTables;
                                if (defaultQTables == null) {
                                    defaultQTables = (jPEGImageWriteParam2 == null || !jPEGImageWriteParam2.areTablesSet()) ? JPEG.getDefaultQTables() : jPEGImageWriteParam2.getQTables();
                                }
                            }
                            jPEGQTableArr3 = defaultQTables;
                        } else {
                            jPEGQTableArr3 = jPEGQTableArr2;
                        }
                        if (optimizeHuffmanTables == 0) {
                            if (obj2 == null || z4) {
                                defaultHuffmanTables = this.streamDCHuffmanTables;
                                if (defaultHuffmanTables != null) {
                                    defaultHuffmanTables2 = this.streamACHuffmanTables;
                                } else if (jPEGImageWriteParam2 == null || !jPEGImageWriteParam2.areTablesSet()) {
                                    defaultHuffmanTables = JPEG.getDefaultHuffmanTables(true);
                                    defaultHuffmanTables2 = JPEG.getDefaultHuffmanTables(false);
                                } else {
                                    defaultHuffmanTables = jPEGImageWriteParam2.getDCHuffmanTables();
                                    defaultHuffmanTables2 = jPEGImageWriteParam2.getACHuffmanTables();
                                }
                            } else {
                                defaultHuffmanTables = collectHTablesFromMetadata(this.metadata, true);
                                defaultHuffmanTables2 = collectHTablesFromMetadata(this.metadata, false);
                            }
                            jPEGHuffmanTableArr2 = defaultHuffmanTables;
                            jPEGHuffmanTableArr3 = defaultHuffmanTables2;
                        } else {
                            jPEGHuffmanTableArr2 = jPEGHuffmanTableArr;
                            jPEGHuffmanTableArr3 = jPEGHuffmanTableArr2;
                        }
                        int[] iArr4 = new int[i];
                        int[] iArr5 = new int[i];
                        int[] iArr6 = new int[i];
                        int[] iArr7 = new int[i];
                        i6 = 0;
                        while (i6 < i) {
                            int i19 = i6 + 1;
                            iArr4[i6] = i19;
                            iArr5[i6] = 1;
                            iArr6[i6] = 1;
                            iArr7[i6] = 0;
                            i6 = i19;
                        }
                        if (sOFMarkerSegment != null) {
                            int i20 = 0;
                            while (i20 < i) {
                                int[] iArr8 = iArr4;
                                if (!this.forceJFIF) {
                                    iArr8[i20] = sOFMarkerSegment.componentSpecs[i20].componentId;
                                }
                                SOFMarkerSegment.ComponentSpec componentSpec = sOFMarkerSegment.componentSpecs[i20];
                                iArr5[i20] = componentSpec.HsamplingFactor;
                                iArr6[i20] = componentSpec.VsamplingFactor;
                                iArr7[i20] = componentSpec.QtableSelector;
                                i20++;
                                z5 = z5;
                                iArr4 = iArr8;
                            }
                        }
                        int[] iArr9 = iArr4;
                        boolean z11 = z5;
                        this.sourceXOffset += i14;
                        int i21 = this.sourceWidth - i14;
                        this.sourceWidth = i21;
                        this.sourceYOffset += i4;
                        int i22 = this.sourceHeight - i4;
                        this.sourceHeight = i22;
                        int iM3211u = AbstractC4539a.m3211u(i21, sourceXSubsampling, 1, sourceXSubsampling);
                        int iM3211u2 = AbstractC4539a.m3211u(i22, sourceYSubsampling, 1, sourceYSubsampling);
                        int i23 = i21 * i;
                        int i24 = progressiveMode;
                        DataBufferByte dataBufferByte = new DataBufferByte(i23);
                        this.raster = Raster.createInterleavedRaster(dataBufferByte, this.sourceWidth, 1, i23, i, JPEG.bandOffsets[i - 1], (Point) null);
                        clearAbortRequest();
                        this.cbLock.lock();
                        processImageStarted(this.currentImage);
                        this.cbLock.unlock();
                        if (this.debug) {
                            System.out.println("inCsType: " + srcCSType);
                            System.out.println("outCsType: " + iDencodedCSType);
                        }
                        zWriteImage = writeImage(this.structPointer, dataBufferByte.getData(), srcCSType, iDencodedCSType, i, iArr3, this.sourceWidth, iM3211u, iM3211u2, sourceXSubsampling, sourceYSubsampling, jPEGQTableArr3, z11, jPEGHuffmanTableArr2, jPEGHuffmanTableArr3, z6, optimizeHuffmanTables, i24 != 0, this.numScans, iArr2, iArr9, iArr5, iArr6, iArr7, z9, i5);
                        this.cbLock.lock();
                        if (zWriteImage) {
                            processWriteAborted();
                        } else {
                            processImageComplete();
                        }
                        this.ios.flush();
                        this.cbLock.unlock();
                        this.currentImage++;
                        return;
                    }
                    z2 = c;
                    this.ignoreJFIF = z2;
                    this.ignoreAdobe = z2;
                    this.newAdobeTransform = -1;
                    this.writeDefaultJFIF = z2;
                    this.writeAdobe = z2;
                    jPEGMetadata = this.metadata;
                    int i152 = subsamplingYOffset;
                    JPEGImageWriteParam jPEGImageWriteParam22 = jPEGImageWriteParam;
                    if (jPEGMetadata != null) {
                    }
                    jPEGQTableArr2 = jPEGQTableArr;
                    this.iccProfile = null;
                    int[] iArr32 = iArr;
                    this.convertTosRGB = false;
                    this.converted = null;
                    if (destinationType == null) {
                    }
                    jPEGMetadata2 = this.metadata;
                    if (jPEGMetadata2 != null) {
                    }
                    this.thumbnails = iIOImage.getThumbnails();
                    int numThumbnails2 = iIOImage.getNumThumbnails();
                    this.forceJFIF = false;
                    if (this.writeDefaultJFIF) {
                    }
                    jPEGMetadata3 = this.metadata;
                    if (jPEGMetadata3 != null) {
                    }
                    if (jPEGMetadata3 != null) {
                    }
                    if (jPEGQTableArr2 == null) {
                    }
                    if (optimizeHuffmanTables == 0) {
                    }
                    int[] iArr42 = new int[i];
                    int[] iArr52 = new int[i];
                    int[] iArr62 = new int[i];
                    int[] iArr72 = new int[i];
                    i6 = 0;
                    while (i6 < i) {
                    }
                    if (sOFMarkerSegment != null) {
                    }
                    int[] iArr92 = iArr42;
                    boolean z112 = z5;
                    this.sourceXOffset += i14;
                    int i212 = this.sourceWidth - i14;
                    this.sourceWidth = i212;
                    this.sourceYOffset += i4;
                    int i222 = this.sourceHeight - i4;
                    this.sourceHeight = i222;
                    int iM3211u3 = AbstractC4539a.m3211u(i212, sourceXSubsampling, 1, sourceXSubsampling);
                    int iM3211u22 = AbstractC4539a.m3211u(i222, sourceYSubsampling, 1, sourceYSubsampling);
                    int i232 = i212 * i;
                    int i242 = progressiveMode;
                    DataBufferByte dataBufferByte2 = new DataBufferByte(i232);
                    this.raster = Raster.createInterleavedRaster(dataBufferByte2, this.sourceWidth, 1, i232, i, JPEG.bandOffsets[i - 1], (Point) null);
                    clearAbortRequest();
                    this.cbLock.lock();
                    processImageStarted(this.currentImage);
                    this.cbLock.unlock();
                    if (this.debug) {
                    }
                    zWriteImage = writeImage(this.structPointer, dataBufferByte2.getData(), srcCSType, iDencodedCSType, i, iArr32, this.sourceWidth, iM3211u3, iM3211u22, sourceXSubsampling, sourceYSubsampling, jPEGQTableArr3, z112, jPEGHuffmanTableArr2, jPEGHuffmanTableArr3, z6, optimizeHuffmanTables, i242 != 0, this.numScans, iArr2, iArr92, iArr52, iArr62, iArr72, z9, i5);
                    this.cbLock.lock();
                    if (zWriteImage) {
                    }
                    this.ios.flush();
                    this.cbLock.unlock();
                    this.currentImage++;
                    return;
                }
                int[] sampleSize2 = this.srcRas.getSampleModel().getSampleSize();
                sampleSize = new int[numBands];
                for (int i25 = 0; i25 < numBands; i25++) {
                    sampleSize[i25] = sampleSize2[0];
                }
                if (zWriteImage) {
                }
                this.ios.flush();
                this.cbLock.unlock();
                this.currentImage++;
                return;
            } catch (Throwable th) {
                throw th;
            }
            processImageStarted(this.currentImage);
            this.cbLock.unlock();
            if (this.debug) {
            }
            zWriteImage = writeImage(this.structPointer, dataBufferByte2.getData(), srcCSType, iDencodedCSType, i, iArr32, this.sourceWidth, iM3211u3, iM3211u22, sourceXSubsampling, sourceYSubsampling, jPEGQTableArr3, z112, jPEGHuffmanTableArr2, jPEGHuffmanTableArr3, z6, optimizeHuffmanTables, i242 != 0, this.numScans, iArr2, iArr92, iArr52, iArr62, iArr72, z9, i5);
            this.cbLock.lock();
        } finally {
            this.cbLock.unlock();
        }
        iArr = sampleSize;
        while (i2 < iArr.length) {
        }
        if (this.debug) {
        }
        if (imageWriteParam == null) {
        }
        this.sourceXOffset = this.srcRas.getMinX();
        this.sourceYOffset = this.srcRas.getMinY();
        int width2 = this.srcRas.getWidth();
        int height2 = this.srcRas.getHeight();
        this.sourceWidth = width2;
        this.sourceHeight = height2;
        if (imageWriteParam == null) {
        }
        metadata = iIOImage.getMetadata();
        int i142 = subsamplingXOffset;
        if (metadata != null) {
        }
        z2 = c;
        this.ignoreJFIF = z2;
        this.ignoreAdobe = z2;
        this.newAdobeTransform = -1;
        this.writeDefaultJFIF = z2;
        this.writeAdobe = z2;
        jPEGMetadata = this.metadata;
        int i1522 = subsamplingYOffset;
        JPEGImageWriteParam jPEGImageWriteParam222 = jPEGImageWriteParam;
        if (jPEGMetadata != null) {
        }
        jPEGQTableArr2 = jPEGQTableArr;
        this.iccProfile = null;
        int[] iArr322 = iArr;
        this.convertTosRGB = false;
        this.converted = null;
        if (destinationType == null) {
        }
        jPEGMetadata2 = this.metadata;
        if (jPEGMetadata2 != null) {
        }
        this.thumbnails = iIOImage.getThumbnails();
        int numThumbnails22 = iIOImage.getNumThumbnails();
        this.forceJFIF = false;
        if (this.writeDefaultJFIF) {
        }
        jPEGMetadata3 = this.metadata;
        if (jPEGMetadata3 != null) {
        }
        if (jPEGMetadata3 != null) {
        }
        if (jPEGQTableArr2 == null) {
        }
        if (optimizeHuffmanTables == 0) {
        }
        int[] iArr422 = new int[i];
        int[] iArr522 = new int[i];
        int[] iArr622 = new int[i];
        int[] iArr722 = new int[i];
        i6 = 0;
        while (i6 < i) {
        }
        if (sOFMarkerSegment != null) {
        }
        int[] iArr922 = iArr422;
        boolean z1122 = z5;
        this.sourceXOffset += i142;
        int i2122 = this.sourceWidth - i142;
        this.sourceWidth = i2122;
        this.sourceYOffset += i4;
        int i2222 = this.sourceHeight - i4;
        this.sourceHeight = i2222;
        int iM3211u32 = AbstractC4539a.m3211u(i2122, sourceXSubsampling, 1, sourceXSubsampling);
        int iM3211u222 = AbstractC4539a.m3211u(i2222, sourceYSubsampling, 1, sourceYSubsampling);
        int i2322 = i2122 * i;
        int i2422 = progressiveMode;
        DataBufferByte dataBufferByte22 = new DataBufferByte(i2322);
        this.raster = Raster.createInterleavedRaster(dataBufferByte22, this.sourceWidth, 1, i2322, i, JPEG.bandOffsets[i - 1], (Point) null);
        clearAbortRequest();
        this.cbLock.lock();
    }

    private void writeOutputData(byte[] bArr, int i, int i2) {
        this.cbLock.lock();
        try {
            this.ios.write(bArr, i, i2);
        } finally {
            this.cbLock.unlock();
        }
    }

    private native void writeTables(long j, JPEGQTable[] jPEGQTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr2);

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public synchronized void abort() {
        setThreadLock();
        try {
            super.abort();
            abortWrite(this.structPointer);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public boolean canWriteRasters() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public boolean canWriteSequence() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public synchronized void clearAbortRequest() {
        setThreadLock();
        try {
            this.cbLock.check();
            if (abortRequested()) {
                super.clearAbortRequest();
                resetWriter(this.structPointer);
                setDest(this.structPointer);
            }
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertImageMetadata(IIOMetadata iIOMetadata, ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        setThreadLock();
        try {
            return convertImageMetadataOnThread(iIOMetadata, imageTypeSpecifier, imageWriteParam);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter, org.apache.poi.javax.imageio.ImageTranscoder
    public IIOMetadata convertStreamMetadata(IIOMetadata iIOMetadata, ImageWriteParam imageWriteParam) {
        if ((iIOMetadata instanceof JPEGMetadata) && ((JPEGMetadata) iIOMetadata).isStream) {
            return iIOMetadata;
        }
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
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

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void endWriteSequence() {
        setThreadLock();
        try {
            this.cbLock.check();
            if (!this.sequencePrepared) {
                throw new IllegalStateException("sequencePrepared not called!");
            }
            this.sequencePrepared = false;
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultImageMetadata(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam) {
        setThreadLock();
        try {
            return new JPEGMetadata(imageTypeSpecifier, imageWriteParam, this);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public IIOMetadata getDefaultStreamMetadata(ImageWriteParam imageWriteParam) {
        setThreadLock();
        try {
            return new JPEGMetadata(imageWriteParam, this);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public ImageWriteParam getDefaultWriteParam() {
        return new JPEGImageWriteParam(null);
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public int getNumThumbnailsSupported(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam, IIOMetadata iIOMetadata, IIOMetadata iIOMetadata2) {
        return jfifOK(imageTypeSpecifier, imageWriteParam, iIOMetadata, iIOMetadata2) ? Integer.MAX_VALUE : 0;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public Dimension[] getPreferredThumbnailSizes(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam, IIOMetadata iIOMetadata, IIOMetadata iIOMetadata2) {
        if (jfifOK(imageTypeSpecifier, imageWriteParam, iIOMetadata, iIOMetadata2)) {
            return (Dimension[]) preferredThumbSizes.clone();
        }
        return null;
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void prepareWriteSequence(IIOMetadata iIOMetadata) {
        setThreadLock();
        try {
            this.cbLock.check();
            prepareWriteSequenceOnThread(iIOMetadata);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void reset() {
        setThreadLock();
        try {
            this.cbLock.check();
            super.reset();
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void setOutput(Object obj) {
        setThreadLock();
        try {
            this.cbLock.check();
            super.setOutput(obj);
            resetInternalState();
            this.ios = (ImageOutputStream) obj;
            setDest(this.structPointer);
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
            if (i < 0 || i > 15) {
                throw new InternalError("Invalid warning index");
            }
            processWarningOccurred(this.currentImage, "com.sun.imageio.plugins.jpeg.JPEGImageWriterResources", Integer.toString(i));
        } finally {
            this.cbLock.unlock();
        }
    }

    public void warningWithMessage(String str) {
        this.cbLock.lock();
        try {
            processWarningOccurred(this.currentImage, str);
        } finally {
            this.cbLock.unlock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void write(IIOMetadata iIOMetadata, IIOImage iIOImage, ImageWriteParam imageWriteParam) {
        setThreadLock();
        try {
            this.cbLock.check();
            writeOnThread(iIOMetadata, iIOImage, imageWriteParam);
        } finally {
            clearThreadLock();
        }
    }

    @Override // org.apache.poi.javax.imageio.ImageWriter
    public void writeToSequence(IIOImage iIOImage, ImageWriteParam imageWriteParam) {
        setThreadLock();
        try {
            this.cbLock.check();
            if (!this.sequencePrepared) {
                throw new IllegalStateException("sequencePrepared not called!");
            }
            write(null, iIOImage, imageWriteParam);
        } finally {
            clearThreadLock();
        }
    }

    private int getDefaultDestCSType(RenderedImage renderedImage) {
        return getDefaultDestCSType(renderedImage.getColorModel());
    }

    private int getSrcCSType(RenderedImage renderedImage) {
        return getSrcCSType(renderedImage.getColorModel());
    }

    private int getDefaultDestCSType(ColorModel colorModel) {
        if (colorModel == null) {
            return 0;
        }
        boolean zHasAlpha = colorModel.hasAlpha();
        int type = colorModel.getColorSpace().getType();
        if (type == 3) {
            return zHasAlpha ? 7 : 3;
        }
        if (type == 9) {
            return 11;
        }
        if (type != 13) {
            return type != 5 ? type != 6 ? 0 : 1 : zHasAlpha ? 7 : 3;
        }
        JPEG.JCS.getYCC();
        return 11;
    }

    private int getSrcCSType(ColorModel colorModel) {
        if (colorModel == null) {
            return 0;
        }
        boolean zHasAlpha = colorModel.hasAlpha();
        int type = colorModel.getColorSpace().getType();
        if (type == 3) {
            return zHasAlpha ? 7 : 3;
        }
        if (type == 9) {
            return 4;
        }
        if (type != 13) {
            return type != 5 ? type != 6 ? 0 : 1 : zHasAlpha ? 6 : 2;
        }
        JPEG.JCS.getYCC();
        return 4;
    }
}
