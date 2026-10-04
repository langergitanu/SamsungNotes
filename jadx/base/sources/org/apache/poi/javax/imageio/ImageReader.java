package org.apache.poi.javax.imageio;

import com.google.android.gms.common.data.AbstractC4539a;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.javax.imageio.event.IIOReadProgressListener;
import org.apache.poi.javax.imageio.event.IIOReadUpdateListener;
import org.apache.poi.javax.imageio.event.IIOReadWarningListener;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageReader {
    protected ImageReaderSpi originatingProvider;
    protected Object input = null;
    protected boolean seekForwardOnly = false;
    protected boolean ignoreMetadata = false;
    protected int minIndex = 0;
    protected Locale[] availableLocales = null;
    protected Locale locale = null;
    protected List<IIOReadWarningListener> warningListeners = null;
    protected List<Locale> warningLocales = null;
    protected List<IIOReadProgressListener> progressListeners = null;
    protected List<IIOReadUpdateListener> updateListeners = null;
    private boolean abortFlag = false;

    public ImageReader(ImageReaderSpi imageReaderSpi) {
        this.originatingProvider = imageReaderSpi;
    }

    public static List addToList(List list, Object obj) {
        if (list == null) {
            list = new ArrayList();
        }
        list.add(obj);
        return list;
    }

    public static void checkReadParamBandSettings(ImageReadParam imageReadParam, int i, int i2) {
        int[] sourceBands;
        int[] destinationBands;
        if (imageReadParam != null) {
            sourceBands = imageReadParam.getSourceBands();
            destinationBands = imageReadParam.getDestinationBands();
        } else {
            sourceBands = null;
            destinationBands = null;
        }
        if ((sourceBands == null ? i : sourceBands.length) != (destinationBands == null ? i2 : destinationBands.length)) {
            throw new IllegalArgumentException("ImageReadParam num source & dest bands differ!");
        }
        if (sourceBands != null) {
            for (int i4 : sourceBands) {
                if (i4 >= i) {
                    throw new IllegalArgumentException("ImageReadParam source bands contains a value >= the number of source bands!");
                }
            }
        }
        if (destinationBands != null) {
            for (int i5 : destinationBands) {
                if (i5 >= i2) {
                    throw new IllegalArgumentException("ImageReadParam dest bands contains a value >= the number of dest bands!");
                }
            }
        }
    }

    public static void computeRegions(ImageReadParam imageReadParam, int i, int i2, BufferedImage bufferedImage, Rectangle rectangle, Rectangle rectangle2) {
        int sourceXSubsampling;
        int sourceYSubsampling;
        if (rectangle == null) {
            throw new IllegalArgumentException("srcRegion == null!");
        }
        if (rectangle2 == null) {
            throw new IllegalArgumentException("destRegion == null!");
        }
        rectangle.setBounds(0, 0, i, i2);
        rectangle2.setBounds(0, 0, i, i2);
        if (imageReadParam != null) {
            Rectangle sourceRegion = imageReadParam.getSourceRegion();
            if (sourceRegion != null) {
                rectangle.setBounds(rectangle.intersection(sourceRegion));
            }
            sourceXSubsampling = imageReadParam.getSourceXSubsampling();
            sourceYSubsampling = imageReadParam.getSourceYSubsampling();
            int subsamplingXOffset = imageReadParam.getSubsamplingXOffset();
            int subsamplingYOffset = imageReadParam.getSubsamplingYOffset();
            rectangle.translate(subsamplingXOffset, subsamplingYOffset);
            rectangle.width -= subsamplingXOffset;
            rectangle.height -= subsamplingYOffset;
            rectangle2.setLocation(imageReadParam.getDestinationOffset());
        } else {
            sourceXSubsampling = 1;
            sourceYSubsampling = 1;
        }
        int i4 = rectangle2.f10094x;
        if (i4 < 0) {
            int i5 = (-i4) * sourceXSubsampling;
            rectangle.f10094x += i5;
            rectangle.width -= i5;
            rectangle2.f10094x = 0;
        }
        int i6 = rectangle2.f10095y;
        if (i6 < 0) {
            int i7 = (-i6) * sourceYSubsampling;
            rectangle.f10095y += i7;
            rectangle.height -= i7;
            rectangle2.f10095y = 0;
        }
        int iM3211u = AbstractC4539a.m3211u(rectangle.width, sourceXSubsampling, 1, sourceXSubsampling);
        int iM3211u2 = AbstractC4539a.m3211u(rectangle.height, sourceYSubsampling, 1, sourceYSubsampling);
        rectangle2.width = iM3211u;
        rectangle2.height = iM3211u2;
        if (bufferedImage != null) {
            rectangle2.setBounds(rectangle2.intersection(new Rectangle(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight())));
            if (rectangle2.isEmpty()) {
                throw new IllegalArgumentException("Empty destination region!");
            }
            int width = (rectangle2.f10094x + iM3211u) - bufferedImage.getWidth();
            if (width > 0) {
                rectangle.width -= width * sourceXSubsampling;
            }
            int height = (rectangle2.f10095y + iM3211u2) - bufferedImage.getHeight();
            if (height > 0) {
                rectangle.height -= height * sourceYSubsampling;
            }
        }
        if (rectangle.isEmpty() || rectangle2.isEmpty()) {
            throw new IllegalArgumentException("Empty region!");
        }
    }

    public static BufferedImage getDestination(ImageReadParam imageReadParam, Iterator<ImageTypeSpecifier> it, int i, int i2) throws IIOException {
        ImageTypeSpecifier destinationType;
        if (it == null || !it.hasNext()) {
            throw new IllegalArgumentException("imageTypes null or empty!");
        }
        if (((long) i) * ((long) i2) > 2147483647L) {
            throw new IllegalArgumentException("width*height > Integer.MAX_VALUE!");
        }
        if (imageReadParam != null) {
            BufferedImage destination = imageReadParam.getDestination();
            if (destination != null) {
                return destination;
            }
            destinationType = imageReadParam.getDestinationType();
        } else {
            destinationType = null;
        }
        if (destinationType != null) {
            while (it.hasNext()) {
                if (it.next().equals(destinationType)) {
                }
            }
            throw new IIOException("Destination type from ImageReadParam does not match!");
        }
        ImageTypeSpecifier next = it.next();
        if (!(next instanceof ImageTypeSpecifier)) {
            throw new IllegalArgumentException("Non-ImageTypeSpecifier retrieved from imageTypes!");
        }
        destinationType = next;
        Rectangle rectangle = new Rectangle(0, 0, 0, 0);
        Rectangle rectangle2 = new Rectangle(0, 0, 0, 0);
        computeRegions(imageReadParam, i, i2, null, rectangle, rectangle2);
        return destinationType.createBufferedImage(rectangle2.f10094x + rectangle2.width, rectangle2.f10095y + rectangle2.height);
    }

    private IIOMetadata getMetadata(String str, Set set, boolean z, int i) {
        String nativeMetadataFormatName;
        if (str == null) {
            throw new IllegalArgumentException("formatName == null!");
        }
        if (set == null) {
            throw new IllegalArgumentException("nodeNames == null!");
        }
        IIOMetadata streamMetadata = z ? getStreamMetadata() : getImageMetadata(i);
        if (streamMetadata == null) {
            return null;
        }
        if ((!streamMetadata.isStandardMetadataFormatSupported() || !str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) && ((nativeMetadataFormatName = streamMetadata.getNativeMetadataFormatName()) == null || !str.equals(nativeMetadataFormatName))) {
            String[] extraMetadataFormatNames = streamMetadata.getExtraMetadataFormatNames();
            if (extraMetadataFormatNames == null) {
                return null;
            }
            for (String str2 : extraMetadataFormatNames) {
                if (!str.equals(str2)) {
                }
            }
            return null;
        }
        return streamMetadata;
    }

    public static Rectangle getSourceRegion(ImageReadParam imageReadParam, int i, int i2) {
        Rectangle rectangle = new Rectangle(0, 0, i, i2);
        if (imageReadParam != null) {
            Rectangle sourceRegion = imageReadParam.getSourceRegion();
            if (sourceRegion != null) {
                rectangle = rectangle.intersection(sourceRegion);
            }
            int subsamplingXOffset = imageReadParam.getSubsamplingXOffset();
            int subsamplingYOffset = imageReadParam.getSubsamplingYOffset();
            rectangle.f10094x += subsamplingXOffset;
            rectangle.f10095y += subsamplingYOffset;
            rectangle.width -= subsamplingXOffset;
            rectangle.height -= subsamplingYOffset;
        }
        return rectangle;
    }

    public static List removeFromList(List list, Object obj) {
        if (list == null) {
            return list;
        }
        list.remove(obj);
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    public synchronized void abort() {
        this.abortFlag = true;
    }

    public synchronized boolean abortRequested() {
        return this.abortFlag;
    }

    public void addIIOReadProgressListener(IIOReadProgressListener iIOReadProgressListener) {
        if (iIOReadProgressListener == null) {
            return;
        }
        this.progressListeners = addToList(this.progressListeners, iIOReadProgressListener);
    }

    public void addIIOReadUpdateListener(IIOReadUpdateListener iIOReadUpdateListener) {
        if (iIOReadUpdateListener == null) {
            return;
        }
        this.updateListeners = addToList(this.updateListeners, iIOReadUpdateListener);
    }

    public void addIIOReadWarningListener(IIOReadWarningListener iIOReadWarningListener) {
        if (iIOReadWarningListener == null) {
            return;
        }
        this.warningListeners = addToList(this.warningListeners, iIOReadWarningListener);
        this.warningLocales = addToList(this.warningLocales, getLocale());
    }

    public boolean canReadRaster() {
        return false;
    }

    public synchronized void clearAbortRequest() {
        this.abortFlag = false;
    }

    public float getAspectRatio(int i) {
        return getWidth(i) / getHeight(i);
    }

    public Locale[] getAvailableLocales() {
        Locale[] localeArr = this.availableLocales;
        if (localeArr == null) {
            return null;
        }
        return (Locale[]) localeArr.clone();
    }

    public ImageReadParam getDefaultReadParam() {
        return new ImageReadParam();
    }

    public String getFormatName() {
        return this.originatingProvider.getFormatNames()[0];
    }

    public abstract int getHeight(int i);

    public abstract IIOMetadata getImageMetadata(int i);

    public IIOMetadata getImageMetadata(int i, String str, Set<String> set) {
        return getMetadata(str, set, false, i);
    }

    public abstract Iterator<ImageTypeSpecifier> getImageTypes(int i);

    public Object getInput() {
        return this.input;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public int getMinIndex() {
        return this.minIndex;
    }

    public abstract int getNumImages(boolean z);

    public int getNumThumbnails(int i) {
        return 0;
    }

    public ImageReaderSpi getOriginatingProvider() {
        return this.originatingProvider;
    }

    public ImageTypeSpecifier getRawImageType(int i) {
        return getImageTypes(i).next();
    }

    public abstract IIOMetadata getStreamMetadata();

    public IIOMetadata getStreamMetadata(String str, Set<String> set) {
        return getMetadata(str, set, true, 0);
    }

    public int getThumbnailHeight(int i, int i2) {
        return readThumbnail(i, i2).getHeight();
    }

    public int getThumbnailWidth(int i, int i2) {
        return readThumbnail(i, i2).getWidth();
    }

    public int getTileGridXOffset(int i) {
        return 0;
    }

    public int getTileGridYOffset(int i) {
        return 0;
    }

    public int getTileHeight(int i) {
        return getHeight(i);
    }

    public int getTileWidth(int i) {
        return getWidth(i);
    }

    public abstract int getWidth(int i);

    public boolean hasThumbnails(int i) {
        return getNumThumbnails(i) > 0;
    }

    public boolean isIgnoringMetadata() {
        return this.ignoreMetadata;
    }

    public boolean isImageTiled(int i) {
        return false;
    }

    public boolean isRandomAccessEasy(int i) {
        return false;
    }

    public boolean isSeekForwardOnly() {
        return this.seekForwardOnly;
    }

    public void processImageComplete() {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).imageComplete(this);
        }
    }

    public void processImageProgress(float f) {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).imageProgress(this, f);
        }
    }

    public void processImageStarted(int i) {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.progressListeners.get(i2).imageStarted(this, i);
        }
    }

    public void processImageUpdate(BufferedImage bufferedImage, int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        List<IIOReadUpdateListener> list = this.updateListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.updateListeners.get(i8).imageUpdate(this, bufferedImage, i, i2, i4, i5, i6, i7, iArr);
        }
    }

    public void processPassComplete(BufferedImage bufferedImage) {
        List<IIOReadUpdateListener> list = this.updateListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.updateListeners.get(i).passComplete(this, bufferedImage);
        }
    }

    public void processPassStarted(BufferedImage bufferedImage, int i, int i2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        List<IIOReadUpdateListener> list = this.updateListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.updateListeners.get(i9).passStarted(this, bufferedImage, i, i2, i4, i5, i6, i7, i8, iArr);
        }
    }

    public void processReadAborted() {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).readAborted(this);
        }
    }

    public void processSequenceComplete() {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).sequenceComplete(this);
        }
    }

    public void processSequenceStarted(int i) {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.progressListeners.get(i2).sequenceStarted(this, i);
        }
    }

    public void processThumbnailComplete() {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).thumbnailComplete(this);
        }
    }

    public void processThumbnailPassComplete(BufferedImage bufferedImage) {
        List<IIOReadUpdateListener> list = this.updateListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.updateListeners.get(i).thumbnailPassComplete(this, bufferedImage);
        }
    }

    public void processThumbnailPassStarted(BufferedImage bufferedImage, int i, int i2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        List<IIOReadUpdateListener> list = this.updateListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.updateListeners.get(i9).thumbnailPassStarted(this, bufferedImage, i, i2, i4, i5, i6, i7, i8, iArr);
        }
    }

    public void processThumbnailProgress(float f) {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).thumbnailProgress(this, f);
        }
    }

    public void processThumbnailStarted(int i, int i2) {
        List<IIOReadProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.progressListeners.get(i4).thumbnailStarted(this, i, i2);
        }
    }

    public void processThumbnailUpdate(BufferedImage bufferedImage, int i, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        List<IIOReadUpdateListener> list = this.updateListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.updateListeners.get(i8).thumbnailUpdate(this, bufferedImage, i, i2, i4, i5, i6, i7, iArr);
        }
    }

    public void processWarningOccurred(String str) {
        List<IIOReadWarningListener> list = this.warningListeners;
        if (list == null) {
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("warning == null!");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.warningListeners.get(i).warningOccurred(this, str);
        }
    }

    public BufferedImage read(int i) {
        return read(i, null);
    }

    public abstract BufferedImage read(int i, ImageReadParam imageReadParam);

    public IIOImage readAll(int i, ImageReadParam imageReadParam) {
        ArrayList arrayList;
        if (i < getMinIndex()) {
            throw new IndexOutOfBoundsException("imageIndex < getMinIndex()!");
        }
        BufferedImage bufferedImage = read(i, imageReadParam);
        int numThumbnails = getNumThumbnails(i);
        if (numThumbnails > 0) {
            arrayList = new ArrayList();
            for (int i2 = 0; i2 < numThumbnails; i2++) {
                arrayList.add(readThumbnail(i, i2));
            }
        } else {
            arrayList = null;
        }
        return new IIOImage(bufferedImage, arrayList, getImageMetadata(i));
    }

    public RenderedImage readAsRenderedImage(int i, ImageReadParam imageReadParam) {
        return read(i, imageReadParam);
    }

    public Raster readRaster(int i, ImageReadParam imageReadParam) {
        throw new UnsupportedOperationException("readRaster not supported!");
    }

    public BufferedImage readThumbnail(int i, int i2) {
        throw new UnsupportedOperationException("Thumbnails not supported!");
    }

    public BufferedImage readTile(int i, int i2, int i4) {
        if (i2 == 0 && i4 == 0) {
            return read(i);
        }
        throw new IllegalArgumentException("Invalid tile indices");
    }

    public Raster readTileRaster(int i, int i2, int i4) {
        if (!canReadRaster()) {
            throw new UnsupportedOperationException("readTileRaster not supported!");
        }
        if (i2 == 0 && i4 == 0) {
            return readRaster(i, null);
        }
        throw new IllegalArgumentException("Invalid tile indices");
    }

    public boolean readerSupportsThumbnails() {
        return false;
    }

    public void removeAllIIOReadProgressListeners() {
        this.progressListeners = null;
    }

    public void removeAllIIOReadUpdateListeners() {
        this.updateListeners = null;
    }

    public void removeAllIIOReadWarningListeners() {
        this.warningListeners = null;
        this.warningLocales = null;
    }

    public void removeIIOReadProgressListener(IIOReadProgressListener iIOReadProgressListener) {
        List<IIOReadProgressListener> list;
        if (iIOReadProgressListener == null || (list = this.progressListeners) == null) {
            return;
        }
        this.progressListeners = removeFromList(list, iIOReadProgressListener);
    }

    public void removeIIOReadUpdateListener(IIOReadUpdateListener iIOReadUpdateListener) {
        List<IIOReadUpdateListener> list;
        if (iIOReadUpdateListener == null || (list = this.updateListeners) == null) {
            return;
        }
        this.updateListeners = removeFromList(list, iIOReadUpdateListener);
    }

    public void removeIIOReadWarningListener(IIOReadWarningListener iIOReadWarningListener) {
        List<IIOReadWarningListener> list;
        int iIndexOf;
        if (iIOReadWarningListener == null || (list = this.warningListeners) == null || (iIndexOf = list.indexOf(iIOReadWarningListener)) == -1) {
            return;
        }
        this.warningListeners.remove(iIndexOf);
        this.warningLocales.remove(iIndexOf);
        if (this.warningListeners.size() == 0) {
            this.warningListeners = null;
            this.warningLocales = null;
        }
    }

    public void reset() {
        setInput(null, false, false);
        setLocale(null);
        removeAllIIOReadUpdateListeners();
        removeAllIIOReadProgressListeners();
        removeAllIIOReadWarningListeners();
        clearAbortRequest();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if ((r5 instanceof org.apache.poi.javax.imageio.stream.ImageInputStream) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setInput(Object obj, boolean z, boolean z2) {
        if (obj != null) {
            ImageReaderSpi imageReaderSpi = this.originatingProvider;
            if (imageReaderSpi != null) {
                for (Class cls : imageReaderSpi.getInputTypes()) {
                    if (cls.isInstance(obj)) {
                        this.seekForwardOnly = z;
                        this.ignoreMetadata = z2;
                        this.minIndex = 0;
                    }
                }
                throw new IllegalArgumentException("Incorrect input type!");
            }
        }
        this.input = obj;
    }

    public void setLocale(Locale locale) {
        if (locale != null) {
            Locale[] availableLocales = getAvailableLocales();
            if (availableLocales != null) {
                for (Locale locale2 : availableLocales) {
                    if (!locale.equals(locale2)) {
                    }
                }
            }
            throw new IllegalArgumentException("Invalid locale!");
        }
        this.locale = locale;
    }

    public void processWarningOccurred(String str, String str2) {
        ResourceBundle bundle;
        List<IIOReadWarningListener> list = this.warningListeners;
        if (list == null) {
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("baseName == null!");
        }
        if (str2 != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                IIOReadWarningListener iIOReadWarningListener = this.warningListeners.get(i);
                Locale locale = this.warningLocales.get(i);
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                try {
                    try {
                        bundle = ResourceBundle.getBundle(str, locale, (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.javax.imageio.ImageReader.1
                            @Override // java.security.PrivilegedAction
                            public Object run() {
                                return Thread.currentThread().getContextClassLoader();
                            }
                        }));
                    } catch (MissingResourceException unused) {
                        throw new IllegalArgumentException("Bundle not found!");
                    }
                } catch (MissingResourceException unused2) {
                    bundle = ResourceBundle.getBundle(str, locale);
                }
                try {
                    iIOReadWarningListener.warningOccurred(this, bundle.getString(str2));
                } catch (ClassCastException unused3) {
                    throw new IllegalArgumentException("Resource is not a String!");
                } catch (MissingResourceException unused4) {
                    throw new IllegalArgumentException("Resource is missing!");
                }
            }
            return;
        }
        throw new IllegalArgumentException("keyword == null!");
    }

    public Iterator<IIOImage> readAll(Iterator<? extends ImageReadParam> it) {
        ImageReadParam imageReadParam;
        ImageReadParam next;
        ArrayList arrayList = new ArrayList();
        int minIndex = getMinIndex();
        processSequenceStarted(minIndex);
        while (true) {
            ArrayList arrayList2 = null;
            if (it == null || !it.hasNext() || (next = it.next()) == null) {
                imageReadParam = null;
            } else if (next instanceof ImageReadParam) {
                imageReadParam = next;
            } else {
                throw new IllegalArgumentException("Non-ImageReadParam supplied as part of params!");
            }
            try {
                BufferedImage bufferedImage = read(minIndex, imageReadParam);
                int numThumbnails = getNumThumbnails(minIndex);
                if (numThumbnails > 0) {
                    arrayList2 = new ArrayList();
                    for (int i = 0; i < numThumbnails; i++) {
                        arrayList2.add(readThumbnail(minIndex, i));
                    }
                }
                arrayList.add(new IIOImage(bufferedImage, arrayList2, getImageMetadata(minIndex)));
                minIndex++;
            } catch (IndexOutOfBoundsException unused) {
                processSequenceComplete();
                return arrayList.iterator();
            }
        }
    }

    public void setInput(Object obj, boolean z) {
        setInput(obj, z, false);
    }

    public void setInput(Object obj) {
        setInput(obj, false, false);
    }

    public void dispose() {
    }
}
