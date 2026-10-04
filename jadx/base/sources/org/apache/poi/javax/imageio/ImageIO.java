package org.apache.poi.javax.imageio;

import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.javax.imageio.spi.IIORegistry;
import org.apache.poi.javax.imageio.spi.ImageInputStreamSpi;
import org.apache.poi.javax.imageio.spi.ImageOutputStreamSpi;
import org.apache.poi.javax.imageio.spi.ImageReaderSpi;
import org.apache.poi.javax.imageio.spi.ImageReaderWriterSpi;
import org.apache.poi.javax.imageio.spi.ImageTranscoderSpi;
import org.apache.poi.javax.imageio.spi.ImageWriterSpi;
import org.apache.poi.javax.imageio.spi.ServiceRegistry;
import org.apache.poi.javax.imageio.stream.ImageInputStream;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.security.action.GetPropertyAction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ImageIO {
    private static Method readerFileSuffixesMethod;
    private static Method readerFormatNamesMethod;
    private static Method readerMIMETypesMethod;
    private static final IIORegistry theRegistry = IIORegistry.getDefaultInstance();
    private static Method writerFileSuffixesMethod;
    private static Method writerFormatNamesMethod;
    private static Method writerMIMETypesMethod;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CacheInfo {
        boolean useCache = true;
        File cacheDirectory = null;
        Boolean hasPermission = null;

        public File getCacheDirectory() {
            return this.cacheDirectory;
        }

        public Boolean getHasPermission() {
            return this.hasPermission;
        }

        public boolean getUseCache() {
            return this.useCache;
        }

        public void setCacheDirectory(File file) {
            this.cacheDirectory = file;
        }

        public void setHasPermission(Boolean bool) {
            this.hasPermission = bool;
        }

        public void setUseCache(boolean z) {
            this.useCache = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CanDecodeInputFilter implements ServiceRegistry.Filter {
        Object input;

        public CanDecodeInputFilter(Object obj) {
            this.input = obj;
        }

        @Override // org.apache.poi.javax.imageio.spi.ServiceRegistry.Filter
        public boolean filter(Object obj) {
            try {
                ImageReaderSpi imageReaderSpi = (ImageReaderSpi) obj;
                Object obj2 = this.input;
                ImageInputStream imageInputStream = obj2 instanceof ImageInputStream ? (ImageInputStream) obj2 : null;
                if (imageInputStream != null) {
                    imageInputStream.mark();
                }
                boolean zCanDecodeInput = imageReaderSpi.canDecodeInput(this.input);
                if (imageInputStream != null) {
                    imageInputStream.reset();
                }
                return zCanDecodeInput;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CanEncodeImageAndFormatFilter implements ServiceRegistry.Filter {
        String formatName;
        ImageTypeSpecifier type;

        public CanEncodeImageAndFormatFilter(ImageTypeSpecifier imageTypeSpecifier, String str) {
            this.type = imageTypeSpecifier;
            this.formatName = str;
        }

        @Override // org.apache.poi.javax.imageio.spi.ServiceRegistry.Filter
        public boolean filter(Object obj) {
            ImageWriterSpi imageWriterSpi = (ImageWriterSpi) obj;
            return Arrays.asList(imageWriterSpi.getFormatNames()).contains(this.formatName) && imageWriterSpi.canEncodeImage(this.type);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ContainsFilter implements ServiceRegistry.Filter {
        Method method;
        String name;

        public ContainsFilter(Method method, String str) {
            this.method = method;
            this.name = str;
        }

        @Override // org.apache.poi.javax.imageio.spi.ServiceRegistry.Filter
        public boolean filter(Object obj) {
            try {
                return ImageIO.contains((String[]) this.method.invoke(obj, null), this.name);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImageReaderIterator implements Iterator<ImageReader> {
        public Iterator iter;

        public ImageReaderIterator(Iterator it) {
            this.iter = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public ImageReader next() {
            ImageReaderSpi imageReaderSpi;
            try {
                imageReaderSpi = (ImageReaderSpi) this.iter.next();
                try {
                    return imageReaderSpi.createReaderInstance();
                } catch (IOException unused) {
                    ImageIO.theRegistry.deregisterServiceProvider(imageReaderSpi, ImageReaderSpi.class);
                    return null;
                }
            } catch (IOException unused2) {
                imageReaderSpi = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImageTranscoderIterator implements Iterator<ImageTranscoder> {
        public Iterator iter;

        public ImageTranscoderIterator(Iterator it) {
            this.iter = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public ImageTranscoder next() {
            return ((ImageTranscoderSpi) this.iter.next()).createTranscoderInstance();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImageWriterIterator implements Iterator<ImageWriter> {
        public Iterator iter;

        public ImageWriterIterator(Iterator it) {
            this.iter = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iter.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public ImageWriter next() {
            ImageWriterSpi imageWriterSpi;
            try {
                imageWriterSpi = (ImageWriterSpi) this.iter.next();
                try {
                    return imageWriterSpi.createWriterInstance();
                } catch (IOException unused) {
                    ImageIO.theRegistry.deregisterServiceProvider(imageWriterSpi, ImageWriterSpi.class);
                    return null;
                }
            } catch (IOException unused2) {
                imageWriterSpi = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SpiInfo {
        FORMAT_NAMES { // from class: org.apache.poi.javax.imageio.ImageIO.SpiInfo.1
            @Override // org.apache.poi.javax.imageio.ImageIO.SpiInfo
            public String[] info(ImageReaderWriterSpi imageReaderWriterSpi) {
                return imageReaderWriterSpi.getFormatNames();
            }
        },
        MIME_TYPES { // from class: org.apache.poi.javax.imageio.ImageIO.SpiInfo.2
            @Override // org.apache.poi.javax.imageio.ImageIO.SpiInfo
            public String[] info(ImageReaderWriterSpi imageReaderWriterSpi) {
                return imageReaderWriterSpi.getMIMETypes();
            }
        },
        FILE_SUFFIXES { // from class: org.apache.poi.javax.imageio.ImageIO.SpiInfo.3
            @Override // org.apache.poi.javax.imageio.ImageIO.SpiInfo
            public String[] info(ImageReaderWriterSpi imageReaderWriterSpi) {
                return imageReaderWriterSpi.getFileSuffixes();
            }
        };

        public abstract String[] info(ImageReaderWriterSpi imageReaderWriterSpi);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TranscoderFilter implements ServiceRegistry.Filter {
        String readerSpiName;
        String writerSpiName;

        public TranscoderFilter(ImageReaderSpi imageReaderSpi, ImageWriterSpi imageWriterSpi) {
            this.readerSpiName = imageReaderSpi.getClass().getName();
            this.writerSpiName = imageWriterSpi.getClass().getName();
        }

        @Override // org.apache.poi.javax.imageio.spi.ServiceRegistry.Filter
        public boolean filter(Object obj) {
            ImageTranscoderSpi imageTranscoderSpi = (ImageTranscoderSpi) obj;
            return imageTranscoderSpi.getReaderServiceProviderName().equals(this.readerSpiName) && imageTranscoderSpi.getWriterServiceProviderName().equals(this.writerSpiName);
        }
    }

    static {
        try {
            readerFormatNamesMethod = ImageReaderSpi.class.getMethod("getFormatNames", null);
            readerFileSuffixesMethod = ImageReaderSpi.class.getMethod("getFileSuffixes", null);
            readerMIMETypesMethod = ImageReaderSpi.class.getMethod("getMIMETypes", null);
            writerFormatNamesMethod = ImageWriterSpi.class.getMethod("getFormatNames", null);
            writerFileSuffixesMethod = ImageWriterSpi.class.getMethod("getFileSuffixes", null);
            writerMIMETypesMethod = ImageWriterSpi.class.getMethod("getMIMETypes", null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private ImageIO() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean contains(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static ImageInputStream createImageInputStream(Object obj) throws IIOException {
        if (obj == null) {
            throw new IllegalArgumentException("input == null!");
        }
        try {
            Iterator serviceProviders = theRegistry.getServiceProviders(ImageInputStreamSpi.class, true);
            boolean z = getUseCache() && hasCachePermission();
            while (serviceProviders.hasNext()) {
                ImageInputStreamSpi imageInputStreamSpi = (ImageInputStreamSpi) serviceProviders.next();
                if (imageInputStreamSpi.getInputClass().isInstance(obj)) {
                    try {
                        return imageInputStreamSpi.createInputStreamInstance(obj, z, getCacheDirectory());
                    } catch (IOException e) {
                        throw new IIOException("Can't create cache file!", e);
                    }
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        return null;
    }

    public static ImageOutputStream createImageOutputStream(Object obj) throws IIOException {
        if (obj == null) {
            throw new IllegalArgumentException("output == null!");
        }
        try {
            Iterator serviceProviders = theRegistry.getServiceProviders(ImageOutputStreamSpi.class, true);
            boolean z = getUseCache() && hasCachePermission();
            while (serviceProviders.hasNext()) {
                ImageOutputStreamSpi imageOutputStreamSpi = (ImageOutputStreamSpi) serviceProviders.next();
                if (imageOutputStreamSpi.getOutputClass().isInstance(obj)) {
                    try {
                        return imageOutputStreamSpi.createOutputStreamInstance(obj, z, getCacheDirectory());
                    } catch (IOException e) {
                        throw new IIOException("Can't create cache file!", e);
                    }
                }
            }
        } catch (IllegalArgumentException unused) {
        }
        return null;
    }

    private static boolean doWrite(RenderedImage renderedImage, ImageWriter imageWriter, ImageOutputStream imageOutputStream) {
        if (imageWriter == null) {
            return false;
        }
        imageWriter.setOutput(imageOutputStream);
        try {
            imageWriter.write(renderedImage);
            imageWriter.dispose();
            imageOutputStream.flush();
            return true;
        } catch (Throwable th) {
            imageWriter.dispose();
            imageOutputStream.flush();
            throw th;
        }
    }

    public static File getCacheDirectory() {
        return getCacheInfo().getCacheDirectory();
    }

    private static synchronized CacheInfo getCacheInfo() {
        CacheInfo cacheInfo;
        AppContext appContext = AppContext.getAppContext();
        cacheInfo = (CacheInfo) appContext.get(CacheInfo.class);
        if (cacheInfo == null) {
            cacheInfo = new CacheInfo();
            appContext.put(CacheInfo.class, cacheInfo);
        }
        return cacheInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ImageReader getImageReader(ImageWriter imageWriter) {
        if (imageWriter == null) {
            throw new IllegalArgumentException("writer == null!");
        }
        ImageWriterSpi originatingProvider = imageWriter.getOriginatingProvider();
        if (originatingProvider == null) {
            try {
                Iterator serviceProviders = theRegistry.getServiceProviders(ImageWriterSpi.class, false);
                while (true) {
                    if (!serviceProviders.hasNext()) {
                        break;
                    }
                    ImageWriterSpi imageWriterSpi = (ImageWriterSpi) serviceProviders.next();
                    if (imageWriterSpi.isOwnWriter(imageWriter)) {
                        originatingProvider = imageWriterSpi;
                        break;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        String[] imageReaderSpiNames = originatingProvider.getImageReaderSpiNames();
        if (imageReaderSpiNames == null) {
            return null;
        }
        try {
            ImageReaderSpi imageReaderSpi = (ImageReaderSpi) theRegistry.getServiceProviderByClass(Class.forName(imageReaderSpiNames[0], true, ClassLoader.getSystemClassLoader()));
            if (imageReaderSpi == null) {
                return null;
            }
            try {
                return imageReaderSpi.createReaderInstance();
            } catch (IOException unused2) {
                theRegistry.deregisterServiceProvider(imageReaderSpi, ImageReaderSpi.class);
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
        return null;
    }

    public static Iterator<ImageReader> getImageReaders(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("input == null!");
        }
        try {
            return new ImageReaderIterator(theRegistry.getServiceProviders(ImageReaderSpi.class, new CanDecodeInputFilter(obj), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    public static Iterator<ImageReader> getImageReadersByFormatName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("formatName == null!");
        }
        try {
            return new ImageReaderIterator(theRegistry.getServiceProviders(ImageReaderSpi.class, new ContainsFilter(readerFormatNamesMethod, str), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    public static Iterator<ImageReader> getImageReadersByMIMEType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("MIMEType == null!");
        }
        try {
            return new ImageReaderIterator(theRegistry.getServiceProviders(ImageReaderSpi.class, new ContainsFilter(readerMIMETypesMethod, str), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    public static Iterator<ImageReader> getImageReadersBySuffix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("fileSuffix == null!");
        }
        try {
            return new ImageReaderIterator(theRegistry.getServiceProviders(ImageReaderSpi.class, new ContainsFilter(readerFileSuffixesMethod, str), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    public static Iterator<ImageTranscoder> getImageTranscoders(ImageReader imageReader, ImageWriter imageWriter) {
        if (imageReader == null) {
            throw new IllegalArgumentException("reader == null!");
        }
        if (imageWriter == null) {
            throw new IllegalArgumentException("writer == null!");
        }
        try {
            return new ImageTranscoderIterator(theRegistry.getServiceProviders(ImageTranscoderSpi.class, new TranscoderFilter(imageReader.getOriginatingProvider(), imageWriter.getOriginatingProvider()), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r0 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ImageWriter getImageWriter(ImageReader imageReader) {
        if (imageReader == null) {
            throw new IllegalArgumentException("reader == null!");
        }
        ImageReaderSpi originatingProvider = imageReader.getOriginatingProvider();
        if (originatingProvider == null) {
            try {
                Iterator serviceProviders = theRegistry.getServiceProviders(ImageReaderSpi.class, false);
                while (true) {
                    if (!serviceProviders.hasNext()) {
                        break;
                    }
                    ImageReaderSpi imageReaderSpi = (ImageReaderSpi) serviceProviders.next();
                    if (imageReaderSpi.isOwnReader(imageReader)) {
                        originatingProvider = imageReaderSpi;
                        break;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        String[] imageWriterSpiNames = originatingProvider.getImageWriterSpiNames();
        if (imageWriterSpiNames == null) {
            return null;
        }
        try {
            ImageWriterSpi imageWriterSpi = (ImageWriterSpi) theRegistry.getServiceProviderByClass(Class.forName(imageWriterSpiNames[0], true, ClassLoader.getSystemClassLoader()));
            if (imageWriterSpi == null) {
                return null;
            }
            try {
                return imageWriterSpi.createWriterInstance();
            } catch (IOException unused2) {
                theRegistry.deregisterServiceProvider(imageWriterSpi, ImageWriterSpi.class);
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
        return null;
    }

    public static Iterator<ImageWriter> getImageWriters(ImageTypeSpecifier imageTypeSpecifier, String str) {
        if (imageTypeSpecifier == null) {
            throw new IllegalArgumentException("type == null!");
        }
        if (str == null) {
            throw new IllegalArgumentException("formatName == null!");
        }
        try {
            return new ImageWriterIterator(theRegistry.getServiceProviders(ImageWriterSpi.class, new CanEncodeImageAndFormatFilter(imageTypeSpecifier, str), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    public static Iterator<ImageWriter> getImageWritersByFormatName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("formatName == null!");
        }
        try {
            return new ImageWriterIterator(theRegistry.getServiceProviders(ImageWriterSpi.class, new ContainsFilter(writerFormatNamesMethod, str), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    public static Iterator<ImageWriter> getImageWritersByMIMEType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("MIMEType == null!");
        }
        try {
            return new ImageWriterIterator(theRegistry.getServiceProviders(ImageWriterSpi.class, new ContainsFilter(writerMIMETypesMethod, str), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    public static Iterator<ImageWriter> getImageWritersBySuffix(String str) {
        if (str == null) {
            throw new IllegalArgumentException("fileSuffix == null!");
        }
        try {
            return new ImageWriterIterator(theRegistry.getServiceProviders(ImageWriterSpi.class, new ContainsFilter(writerFileSuffixesMethod, str), true));
        } catch (IllegalArgumentException unused) {
            return Collections.emptyIterator();
        }
    }

    public static String[] getReaderFileSuffixes() {
        return getReaderWriterInfo(ImageReaderSpi.class, SpiInfo.FILE_SUFFIXES);
    }

    public static String[] getReaderFormatNames() {
        return getReaderWriterInfo(ImageReaderSpi.class, SpiInfo.FORMAT_NAMES);
    }

    public static String[] getReaderMIMETypes() {
        return getReaderWriterInfo(ImageReaderSpi.class, SpiInfo.MIME_TYPES);
    }

    private static <S extends ImageReaderWriterSpi> String[] getReaderWriterInfo(Class<S> cls, SpiInfo spiInfo) {
        try {
            Iterator serviceProviders = theRegistry.getServiceProviders(cls, true);
            HashSet hashSet = new HashSet();
            while (serviceProviders.hasNext()) {
                Collections.addAll(hashSet, spiInfo.info((ImageReaderWriterSpi) serviceProviders.next()));
            }
            return (String[]) hashSet.toArray(new String[hashSet.size()]);
        } catch (IllegalArgumentException unused) {
            return new String[0];
        }
    }

    private static String getTempDir() {
        return (String) AccessController.doPrivileged(new GetPropertyAction("java.io.tmpdir"));
    }

    public static boolean getUseCache() {
        return getCacheInfo().getUseCache();
    }

    private static ImageWriter getWriter(RenderedImage renderedImage, String str) {
        Iterator<ImageWriter> imageWriters = getImageWriters(ImageTypeSpecifier.createFromRenderedImage(renderedImage), str);
        if (imageWriters.hasNext()) {
            return imageWriters.next();
        }
        return null;
    }

    public static String[] getWriterFileSuffixes() {
        return getReaderWriterInfo(ImageWriterSpi.class, SpiInfo.FILE_SUFFIXES);
    }

    public static String[] getWriterFormatNames() {
        return getReaderWriterInfo(ImageWriterSpi.class, SpiInfo.FORMAT_NAMES);
    }

    public static String[] getWriterMIMETypes() {
        return getReaderWriterInfo(ImageWriterSpi.class, SpiInfo.MIME_TYPES);
    }

    private static boolean hasCachePermission() {
        String tempDir;
        Boolean hasPermission = getCacheInfo().getHasPermission();
        if (hasPermission != null) {
            return hasPermission.booleanValue();
        }
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                File cacheDirectory = getCacheDirectory();
                if (cacheDirectory == null) {
                    tempDir = getTempDir();
                    if (tempDir != null) {
                        if (tempDir.isEmpty()) {
                        }
                    }
                    getCacheInfo().setHasPermission(Boolean.FALSE);
                    return false;
                }
                tempDir = cacheDirectory.getPath();
                String str = File.separator;
                if (!tempDir.endsWith(str)) {
                    tempDir = tempDir + str;
                }
                securityManager.checkPermission(new FilePermission(tempDir + "*", "read, write, delete"));
            }
            getCacheInfo().setHasPermission(Boolean.TRUE);
            return true;
        } catch (SecurityException unused) {
            getCacheInfo().setHasPermission(Boolean.FALSE);
            return false;
        }
    }

    public static BufferedImage read(File file) throws IIOException {
        if (file == null) {
            throw new IllegalArgumentException("input == null!");
        }
        if (!file.canRead()) {
            throw new IIOException("Can't read input file!");
        }
        ImageInputStream imageInputStreamCreateImageInputStream = createImageInputStream(file);
        if (imageInputStreamCreateImageInputStream == null) {
            throw new IIOException("Can't create an ImageInputStream!");
        }
        BufferedImage bufferedImage = read(imageInputStreamCreateImageInputStream);
        if (bufferedImage == null) {
            imageInputStreamCreateImageInputStream.close();
        }
        return bufferedImage;
    }

    public static void scanForPlugins() {
        theRegistry.registerApplicationClasspathSpis();
    }

    public static void setCacheDirectory(File file) {
        if (file != null && !file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory!");
        }
        getCacheInfo().setCacheDirectory(file);
        getCacheInfo().setHasPermission(null);
    }

    public static void setUseCache(boolean z) {
        getCacheInfo().setUseCache(z);
    }

    public static boolean write(RenderedImage renderedImage, String str, ImageOutputStream imageOutputStream) {
        if (renderedImage == null) {
            throw new IllegalArgumentException("im == null!");
        }
        if (str == null) {
            throw new IllegalArgumentException("formatName == null!");
        }
        if (imageOutputStream != null) {
            return doWrite(renderedImage, getWriter(renderedImage, str), imageOutputStream);
        }
        throw new IllegalArgumentException("output == null!");
    }

    public static boolean write(RenderedImage renderedImage, String str, File file) throws IIOException {
        if (file != null) {
            ImageWriter writer = getWriter(renderedImage, str);
            if (writer == null) {
                return false;
            }
            try {
                file.delete();
                ImageOutputStream imageOutputStreamCreateImageOutputStream = createImageOutputStream(file);
                try {
                    return doWrite(renderedImage, writer, imageOutputStreamCreateImageOutputStream);
                } finally {
                    imageOutputStreamCreateImageOutputStream.close();
                }
            } catch (IOException e) {
                throw new IIOException("Can't create output stream!", e);
            }
        }
        throw new IllegalArgumentException("output == null!");
    }

    public static BufferedImage read(InputStream inputStream) throws IIOException {
        if (inputStream != null) {
            ImageInputStream imageInputStreamCreateImageInputStream = createImageInputStream(inputStream);
            BufferedImage bufferedImage = read(imageInputStreamCreateImageInputStream);
            if (bufferedImage == null) {
                imageInputStreamCreateImageInputStream.close();
            }
            return bufferedImage;
        }
        throw new IllegalArgumentException("input == null!");
    }

    public static BufferedImage read(URL url) throws IOException {
        if (url != null) {
            try {
                InputStream inputStreamOpenStream = url.openStream();
                ImageInputStream imageInputStreamCreateImageInputStream = createImageInputStream(inputStreamOpenStream);
                try {
                    BufferedImage bufferedImage = read(imageInputStreamCreateImageInputStream);
                    if (bufferedImage == null) {
                        imageInputStreamCreateImageInputStream.close();
                    }
                    return bufferedImage;
                } finally {
                    inputStreamOpenStream.close();
                }
            } catch (IOException e) {
                throw new IIOException("Can't get input stream from URL!", e);
            }
        }
        throw new IllegalArgumentException("input == null!");
    }

    public static boolean write(RenderedImage renderedImage, String str, OutputStream outputStream) throws IIOException {
        if (outputStream != null) {
            try {
                ImageOutputStream imageOutputStreamCreateImageOutputStream = createImageOutputStream(outputStream);
                try {
                    return doWrite(renderedImage, getWriter(renderedImage, str), imageOutputStreamCreateImageOutputStream);
                } finally {
                    imageOutputStreamCreateImageOutputStream.close();
                }
            } catch (IOException e) {
                throw new IIOException("Can't create output stream!", e);
            }
        }
        throw new IllegalArgumentException("output == null!");
    }

    public static BufferedImage read(ImageInputStream imageInputStream) {
        if (imageInputStream != null) {
            Iterator<ImageReader> imageReaders = getImageReaders(imageInputStream);
            if (!imageReaders.hasNext()) {
                return null;
            }
            ImageReader next = imageReaders.next();
            ImageReadParam defaultReadParam = next.getDefaultReadParam();
            next.setInput(imageInputStream, true, true);
            try {
                return next.read(0, defaultReadParam);
            } finally {
                next.dispose();
                imageInputStream.close();
            }
        }
        throw new IllegalArgumentException("stream == null!");
    }
}
