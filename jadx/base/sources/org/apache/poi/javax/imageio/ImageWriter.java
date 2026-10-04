package org.apache.poi.javax.imageio;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.javax.imageio.event.IIOWriteProgressListener;
import org.apache.poi.javax.imageio.event.IIOWriteWarningListener;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ImageWriter implements ImageTranscoder {
    protected ImageWriterSpi originatingProvider;
    protected Object output = null;
    protected Locale[] availableLocales = null;
    protected Locale locale = null;
    protected List<IIOWriteWarningListener> warningListeners = null;
    protected List<Locale> warningLocales = null;
    protected List<IIOWriteProgressListener> progressListeners = null;
    private boolean abortFlag = false;

    public ImageWriter(ImageWriterSpi imageWriterSpi) {
        this.originatingProvider = imageWriterSpi;
    }

    private void unsupported() {
        if (getOutput() != null) {
            throw new UnsupportedOperationException("Unsupported write variant!");
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public synchronized void abort() {
        this.abortFlag = true;
    }

    public synchronized boolean abortRequested() {
        return this.abortFlag;
    }

    public void addIIOWriteProgressListener(IIOWriteProgressListener iIOWriteProgressListener) {
        if (iIOWriteProgressListener == null) {
            return;
        }
        this.progressListeners = ImageReader.addToList(this.progressListeners, iIOWriteProgressListener);
    }

    public void addIIOWriteWarningListener(IIOWriteWarningListener iIOWriteWarningListener) {
        if (iIOWriteWarningListener == null) {
            return;
        }
        this.warningListeners = ImageReader.addToList(this.warningListeners, iIOWriteWarningListener);
        this.warningLocales = ImageReader.addToList(this.warningLocales, getLocale());
    }

    public boolean canInsertEmpty(int i) {
        if (getOutput() != null) {
            return false;
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public boolean canInsertImage(int i) {
        if (getOutput() != null) {
            return false;
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public boolean canRemoveImage(int i) {
        if (getOutput() != null) {
            return false;
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public boolean canReplaceImageMetadata(int i) {
        if (getOutput() != null) {
            return false;
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public boolean canReplacePixels(int i) {
        if (getOutput() != null) {
            return false;
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public boolean canReplaceStreamMetadata() {
        if (getOutput() != null) {
            return false;
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public boolean canWriteEmpty() {
        if (getOutput() != null) {
            return false;
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public boolean canWriteRasters() {
        return false;
    }

    public boolean canWriteSequence() {
        return false;
    }

    public synchronized void clearAbortRequest() {
        this.abortFlag = false;
    }

    @Override // org.apache.poi.javax.imageio.ImageTranscoder
    public abstract IIOMetadata convertImageMetadata(IIOMetadata iIOMetadata, ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam);

    @Override // org.apache.poi.javax.imageio.ImageTranscoder
    public abstract IIOMetadata convertStreamMetadata(IIOMetadata iIOMetadata, ImageWriteParam imageWriteParam);

    public void endInsertEmpty() {
        unsupported();
    }

    public void endReplacePixels() {
        unsupported();
    }

    public void endWriteEmpty() {
        if (getOutput() != null) {
            throw new IllegalStateException("No call to prepareWriteEmpty!");
        }
        throw new IllegalStateException("getOutput() == null!");
    }

    public void endWriteSequence() {
        unsupported();
    }

    public Locale[] getAvailableLocales() {
        Locale[] localeArr = this.availableLocales;
        if (localeArr == null) {
            return null;
        }
        return (Locale[]) localeArr.clone();
    }

    public abstract IIOMetadata getDefaultImageMetadata(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam);

    public abstract IIOMetadata getDefaultStreamMetadata(ImageWriteParam imageWriteParam);

    public ImageWriteParam getDefaultWriteParam() {
        return new ImageWriteParam(getLocale());
    }

    public Locale getLocale() {
        return this.locale;
    }

    public int getNumThumbnailsSupported(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam, IIOMetadata iIOMetadata, IIOMetadata iIOMetadata2) {
        return 0;
    }

    public ImageWriterSpi getOriginatingProvider() {
        return this.originatingProvider;
    }

    public Object getOutput() {
        return this.output;
    }

    public Dimension[] getPreferredThumbnailSizes(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam, IIOMetadata iIOMetadata, IIOMetadata iIOMetadata2) {
        return null;
    }

    public void prepareInsertEmpty(int i, ImageTypeSpecifier imageTypeSpecifier, int i2, int i4, IIOMetadata iIOMetadata, List<? extends BufferedImage> list, ImageWriteParam imageWriteParam) {
        unsupported();
    }

    public void prepareReplacePixels(int i, Rectangle rectangle) {
        unsupported();
    }

    public void prepareWriteEmpty(IIOMetadata iIOMetadata, ImageTypeSpecifier imageTypeSpecifier, int i, int i2, IIOMetadata iIOMetadata2, List<? extends BufferedImage> list, ImageWriteParam imageWriteParam) {
        unsupported();
    }

    public void prepareWriteSequence(IIOMetadata iIOMetadata) {
        unsupported();
    }

    public void processImageComplete() {
        List<IIOWriteProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).imageComplete(this);
        }
    }

    public void processImageProgress(float f) {
        List<IIOWriteProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).imageProgress(this, f);
        }
    }

    public void processImageStarted(int i) {
        List<IIOWriteProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.progressListeners.get(i2).imageStarted(this, i);
        }
    }

    public void processThumbnailComplete() {
        List<IIOWriteProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).thumbnailComplete(this);
        }
    }

    public void processThumbnailProgress(float f) {
        List<IIOWriteProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).thumbnailProgress(this, f);
        }
    }

    public void processThumbnailStarted(int i, int i2) {
        List<IIOWriteProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.progressListeners.get(i4).thumbnailStarted(this, i, i2);
        }
    }

    public void processWarningOccurred(int i, String str) {
        List<IIOWriteWarningListener> list = this.warningListeners;
        if (list == null) {
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("warning == null!");
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.warningListeners.get(i2).warningOccurred(this, i, str);
        }
    }

    public void processWriteAborted() {
        List<IIOWriteProgressListener> list = this.progressListeners;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.progressListeners.get(i).writeAborted(this);
        }
    }

    public void removeAllIIOWriteProgressListeners() {
        this.progressListeners = null;
    }

    public void removeAllIIOWriteWarningListeners() {
        this.warningListeners = null;
        this.warningLocales = null;
    }

    public void removeIIOWriteProgressListener(IIOWriteProgressListener iIOWriteProgressListener) {
        List<IIOWriteProgressListener> list;
        if (iIOWriteProgressListener == null || (list = this.progressListeners) == null) {
            return;
        }
        this.progressListeners = ImageReader.removeFromList(list, iIOWriteProgressListener);
    }

    public void removeIIOWriteWarningListener(IIOWriteWarningListener iIOWriteWarningListener) {
        List<IIOWriteWarningListener> list;
        int iIndexOf;
        if (iIOWriteWarningListener == null || (list = this.warningListeners) == null || (iIndexOf = list.indexOf(iIOWriteWarningListener)) == -1) {
            return;
        }
        this.warningListeners.remove(iIndexOf);
        this.warningLocales.remove(iIndexOf);
        if (this.warningListeners.size() == 0) {
            this.warningListeners = null;
            this.warningLocales = null;
        }
    }

    public void removeImage(int i) {
        unsupported();
    }

    public void replaceImageMetadata(int i, IIOMetadata iIOMetadata) {
        unsupported();
    }

    public void replacePixels(RenderedImage renderedImage, ImageWriteParam imageWriteParam) {
        unsupported();
    }

    public void replaceStreamMetadata(IIOMetadata iIOMetadata) {
        unsupported();
    }

    public void reset() {
        setOutput(null);
        setLocale(null);
        removeAllIIOWriteWarningListeners();
        removeAllIIOWriteProgressListeners();
        clearAbortRequest();
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

    public void setOutput(Object obj) {
        ImageWriterSpi originatingProvider;
        if (obj != null && (originatingProvider = getOriginatingProvider()) != null) {
            for (Class cls : originatingProvider.getOutputTypes()) {
                if (!cls.isInstance(obj)) {
                }
            }
            throw new IllegalArgumentException("Illegal output type!");
        }
        this.output = obj;
    }

    public void write(IIOImage iIOImage) {
        write(null, iIOImage, null);
    }

    public abstract void write(IIOMetadata iIOMetadata, IIOImage iIOImage, ImageWriteParam imageWriteParam);

    public void writeInsert(int i, IIOImage iIOImage, ImageWriteParam imageWriteParam) {
        unsupported();
    }

    public void writeToSequence(IIOImage iIOImage, ImageWriteParam imageWriteParam) {
        unsupported();
    }

    public void replacePixels(Raster raster, ImageWriteParam imageWriteParam) {
        unsupported();
    }

    public void write(RenderedImage renderedImage) {
        write(null, new IIOImage(renderedImage, (List<? extends BufferedImage>) null, (IIOMetadata) null), null);
    }

    public void processWarningOccurred(int i, String str, String str2) {
        ResourceBundle bundle;
        List<IIOWriteWarningListener> list = this.warningListeners;
        if (list == null) {
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("baseName == null!");
        }
        if (str2 != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                IIOWriteWarningListener iIOWriteWarningListener = this.warningListeners.get(i2);
                Locale locale = this.warningLocales.get(i2);
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                try {
                    try {
                        bundle = ResourceBundle.getBundle(str, locale, (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.javax.imageio.ImageWriter.1
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
                    iIOWriteWarningListener.warningOccurred(this, i, bundle.getString(str2));
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

    public void dispose() {
    }
}
