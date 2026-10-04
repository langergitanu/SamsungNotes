package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.AccessController;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.SinglePixelPackedSampleModel;
import org.apache.poi.sun.awt.image.SunWritableRaster;
import org.apache.poi.sun.security.action.LoadLibraryAction;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
public final class SplashScreen {
    private static final PlatformLogger log = PlatformLogger.getLogger("org.apache.poi.java.awt.SplashScreen");
    private static SplashScreen theInstance = null;
    private static boolean wasClosed = false;
    private BufferedImage image;
    private URL imageURL;
    private final long splashPtr;

    public SplashScreen(long j) {
        this.splashPtr = j;
    }

    private static native void _close(long j);

    private static native Rectangle _getBounds(long j);

    private static native String _getImageFileName(long j);

    private static native String _getImageJarName(long j);

    private static native long _getInstance();

    private static native boolean _isVisible(long j);

    private static native boolean _setImageData(long j, byte[] bArr);

    private static native void _update(long j, int[] iArr, int i, int i2, int i4, int i5, int i6);

    private void checkVisible() {
        if (!isVisible()) {
            throw new IllegalStateException("no splash screen available");
        }
    }

    public static SplashScreen getSplashScreen() {
        SplashScreen splashScreen;
        synchronized (SplashScreen.class) {
            try {
                if (GraphicsEnvironment.isHeadless()) {
                    throw new HeadlessException();
                }
                if (!wasClosed && theInstance == null) {
                    AccessController.doPrivileged(new LoadLibraryAction("splashscreen"));
                    long j_getInstance = _getInstance();
                    if (j_getInstance != 0 && _isVisible(j_getInstance)) {
                        theInstance = new SplashScreen(j_getInstance);
                    }
                }
                splashScreen = theInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return splashScreen;
    }

    public static void markClosed() {
        synchronized (SplashScreen.class) {
            wasClosed = true;
            theInstance = null;
        }
    }

    public void close() {
        synchronized (SplashScreen.class) {
            checkVisible();
            _close(this.splashPtr);
            this.image = null;
            markClosed();
        }
    }

    public Graphics2D createGraphics() {
        Graphics2D graphics2DCreateGraphics;
        synchronized (SplashScreen.class) {
            try {
                if (this.image == null) {
                    Dimension size = getSize();
                    this.image = new BufferedImage(size.width, size.height, 2);
                }
                graphics2DCreateGraphics = this.image.createGraphics();
            } catch (Throwable th) {
                throw th;
            }
        }
        return graphics2DCreateGraphics;
    }

    public Rectangle getBounds() {
        Rectangle rectangle_getBounds;
        synchronized (SplashScreen.class) {
            checkVisible();
            rectangle_getBounds = _getBounds(this.splashPtr);
        }
        return rectangle_getBounds;
    }

    public URL getImageURL() {
        URL url;
        synchronized (SplashScreen.class) {
            try {
                checkVisible();
                if (this.imageURL == null) {
                    try {
                        String str_getImageFileName = _getImageFileName(this.splashPtr);
                        String str_getImageJarName = _getImageJarName(this.splashPtr);
                        if (str_getImageFileName != null) {
                            if (str_getImageJarName != null) {
                                this.imageURL = new URL("jar:" + new File(str_getImageJarName).toURL().toString() + "!/" + str_getImageFileName);
                            } else {
                                this.imageURL = new File(str_getImageFileName).toURL();
                            }
                        }
                    } catch (MalformedURLException e) {
                        PlatformLogger platformLogger = log;
                        if (platformLogger.isLoggable(500)) {
                            platformLogger.fine("MalformedURLException caught in the getImageURL() method", e);
                        }
                    }
                }
                url = this.imageURL;
            } catch (Throwable th) {
                throw th;
            }
        }
        return url;
    }

    public Dimension getSize() {
        return getBounds().getSize();
    }

    public boolean isVisible() {
        boolean z;
        synchronized (SplashScreen.class) {
            try {
                z = !wasClosed && _isVisible(this.splashPtr);
            } finally {
            }
        }
        return z;
    }

    public void setImageURL(URL url) throws IOException {
        checkVisible();
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        uRLConnectionOpenConnection.connect();
        int contentLength = uRLConnectionOpenConnection.getContentLength();
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        byte[] bArr = new byte[contentLength];
        int i = 0;
        while (true) {
            int iAvailable = inputStream.available();
            if (iAvailable <= 0) {
                iAvailable = 1;
            }
            int i2 = i + iAvailable;
            if (i2 > contentLength) {
                int i4 = i * 2;
                if (i2 <= i4) {
                    i2 = i4;
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                bArr = bArr2;
                contentLength = i2;
            }
            int i5 = inputStream.read(bArr, i, iAvailable);
            if (i5 < 0) {
                break;
            } else {
                i += i5;
            }
        }
        synchronized (SplashScreen.class) {
            try {
                checkVisible();
                if (!_setImageData(this.splashPtr, bArr)) {
                    throw new IOException("Bad image format or i/o error when loading image");
                }
                this.imageURL = url;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void update() {
        BufferedImage bufferedImage;
        synchronized (SplashScreen.class) {
            checkVisible();
            bufferedImage = this.image;
        }
        if (bufferedImage == null) {
            throw new IllegalStateException("no overlay image available");
        }
        DataBuffer dataBuffer = bufferedImage.getRaster().getDataBuffer();
        if (!(dataBuffer instanceof DataBufferInt)) {
            throw new AssertionError("Overlay image DataBuffer is of invalid type == ".concat(dataBuffer.getClass().getName()));
        }
        int numBanks = dataBuffer.getNumBanks();
        if (numBanks != 1) {
            throw new AssertionError(AbstractC0541b.m767i(numBanks, "Invalid number of banks ==", " in overlay image DataBuffer"));
        }
        if (!(bufferedImage.getSampleModel() instanceof SinglePixelPackedSampleModel)) {
            throw new AssertionError("Overlay image has invalid sample model == ".concat(bufferedImage.getSampleModel().getClass().getName()));
        }
        int scanlineStride = ((SinglePixelPackedSampleModel) bufferedImage.getSampleModel()).getScanlineStride();
        Rectangle bounds = bufferedImage.getRaster().getBounds();
        int[] iArrStealData = SunWritableRaster.stealData((DataBufferInt) dataBuffer, 0);
        synchronized (SplashScreen.class) {
            checkVisible();
            _update(this.splashPtr, iArrStealData, bounds.f10094x, bounds.f10095y, bounds.width, bounds.height, scanlineStride);
        }
    }
}
