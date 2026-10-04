package org.apache.poi.java.awt;

import org.apache.poi.java.awt.image.AreaAveragingScaleFilter;
import org.apache.poi.java.awt.image.FilteredImageSource;
import org.apache.poi.java.awt.image.ImageObserver;
import org.apache.poi.java.awt.image.ImageProducer;
import org.apache.poi.java.awt.image.ReplicateScaleFilter;
import org.apache.poi.sun.awt.image.SurfaceManager;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Image {
    public static final int SCALE_AREA_AVERAGING = 16;
    public static final int SCALE_DEFAULT = 1;
    public static final int SCALE_FAST = 2;
    public static final int SCALE_REPLICATE = 8;
    public static final int SCALE_SMOOTH = 4;
    protected float accelerationPriority = 0.5f;
    SurfaceManager surfaceManager;
    private static ImageCapabilities defaultImageCaps = new ImageCapabilities(false);
    public static final Object UndefinedProperty = new Object();

    static {
        SurfaceManager.setImageAccessor(new SurfaceManager.ImageAccessor() { // from class: org.apache.poi.java.awt.Image.1
            @Override // org.apache.poi.sun.awt.image.SurfaceManager.ImageAccessor
            public SurfaceManager getSurfaceManager(Image image) {
                return image.surfaceManager;
            }

            @Override // org.apache.poi.sun.awt.image.SurfaceManager.ImageAccessor
            public void setSurfaceManager(Image image, SurfaceManager surfaceManager) {
                image.surfaceManager = surfaceManager;
            }
        });
    }

    public void flush() {
        SurfaceManager surfaceManager = this.surfaceManager;
        if (surfaceManager != null) {
            surfaceManager.flush();
        }
    }

    public float getAccelerationPriority() {
        return this.accelerationPriority;
    }

    public ImageCapabilities getCapabilities(GraphicsConfiguration graphicsConfiguration) {
        SurfaceManager surfaceManager = this.surfaceManager;
        return surfaceManager != null ? surfaceManager.getCapabilities(graphicsConfiguration) : defaultImageCaps;
    }

    public abstract Graphics getGraphics();

    public abstract int getHeight(ImageObserver imageObserver);

    public abstract Object getProperty(String str, ImageObserver imageObserver);

    public Image getScaledInstance(int i, int i2, int i4) {
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(getSource(), (i4 & 20) != 0 ? new AreaAveragingScaleFilter(i, i2) : new ReplicateScaleFilter(i, i2)));
    }

    public abstract ImageProducer getSource();

    public abstract int getWidth(ImageObserver imageObserver);

    public void setAccelerationPriority(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Priority must be a value between 0 and 1, inclusive");
        }
        this.accelerationPriority = f;
        SurfaceManager surfaceManager = this.surfaceManager;
        if (surfaceManager != null) {
            surfaceManager.setAccelerationPriority(f);
        }
    }
}
