package org.apache.poi.java.awt;

import java.util.Hashtable;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.VolatileImage;
import org.apache.poi.sun.awt.image.SunVolatileImage;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public abstract class GraphicsConfiguration {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static BufferCapabilities defaultBufferCaps;
    private static ImageCapabilities defaultImageCaps;

    public static class DefaultBufferCapabilities extends BufferCapabilities {
        public DefaultBufferCapabilities(ImageCapabilities imageCapabilities) {
            super(imageCapabilities, imageCapabilities, null);
        }
    }

    public BufferedImage createCompatibleImage(int i, int i2) {
        ColorModel colorModel = getColorModel();
        return new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(i, i2), colorModel.isAlphaPremultiplied(), (Hashtable<?, ?>) null);
    }

    public VolatileImage createCompatibleVolatileImage(int i, int i2) {
        try {
            return createCompatibleVolatileImage(i, i2, null, 1);
        } catch (AWTException unused) {
            return null;
        }
    }

    public abstract Rectangle getBounds();

    public BufferCapabilities getBufferCapabilities() {
        if (defaultBufferCaps == null) {
            defaultBufferCaps = new DefaultBufferCapabilities(getImageCapabilities());
        }
        return defaultBufferCaps;
    }

    public abstract ColorModel getColorModel();

    public abstract ColorModel getColorModel(int i);

    public abstract AffineTransform getDefaultTransform();

    public abstract GraphicsDevice getDevice();

    public ImageCapabilities getImageCapabilities() {
        if (defaultImageCaps == null) {
            defaultImageCaps = new ImageCapabilities(false);
        }
        return defaultImageCaps;
    }

    public abstract AffineTransform getNormalizingTransform();

    public boolean isTranslucencyCapable() {
        return false;
    }

    public BufferedImage createCompatibleImage(int i, int i2, int i4) {
        if (getColorModel().getTransparency() == i4) {
            return createCompatibleImage(i, i2);
        }
        ColorModel colorModel = getColorModel(i4);
        if (colorModel != null) {
            return new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(i, i2), colorModel.isAlphaPremultiplied(), (Hashtable<?, ?>) null);
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i4, "Unknown transparency: "));
    }

    public VolatileImage createCompatibleVolatileImage(int i, int i2, int i4) {
        try {
            return createCompatibleVolatileImage(i, i2, null, i4);
        } catch (AWTException unused) {
            return null;
        }
    }

    public VolatileImage createCompatibleVolatileImage(int i, int i2, ImageCapabilities imageCapabilities) {
        return createCompatibleVolatileImage(i, i2, imageCapabilities, 1);
    }

    public VolatileImage createCompatibleVolatileImage(int i, int i2, ImageCapabilities imageCapabilities, int i4) throws AWTException {
        SunVolatileImage sunVolatileImage = new SunVolatileImage(this, i, i2, i4, imageCapabilities);
        if (imageCapabilities == null || !imageCapabilities.isAccelerated() || sunVolatileImage.getCapabilities().isAccelerated()) {
            return sunVolatileImage;
        }
        throw new AWTException("Supplied image capabilities could not be met by this graphics configuration.");
    }
}
