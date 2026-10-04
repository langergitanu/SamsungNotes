package org.apache.poi.sun.awt.image;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.poi.java.awt.GraphicsConfiguration;
import org.apache.poi.java.awt.GraphicsEnvironment;
import org.apache.poi.java.awt.Image;
import org.apache.poi.java.awt.ImageCapabilities;
import org.apache.poi.sun.java2d.SurfaceData;
import org.apache.poi.sun.java2d.SurfaceDataProxy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class SurfaceManager {
    private static ImageAccessor imgaccessor;
    private ConcurrentHashMap<Object, Object> cacheMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FlushableCacheData {
        boolean flush(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ImageAccessor {
        public abstract SurfaceManager getSurfaceManager(Image image);

        public abstract void setSurfaceManager(Image image, SurfaceManager surfaceManager);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ImageCapabilitiesGc extends ImageCapabilities {

        /* JADX INFO: renamed from: gc */
        GraphicsConfiguration f10163gc;

        public ImageCapabilitiesGc(GraphicsConfiguration graphicsConfiguration) {
            super(false);
            this.f10163gc = graphicsConfiguration;
        }

        @Override // org.apache.poi.java.awt.ImageCapabilities
        public boolean isAccelerated() {
            Object proxyKey;
            SurfaceDataProxy surfaceDataProxy;
            Object defaultConfiguration = this.f10163gc;
            if (defaultConfiguration == null) {
                defaultConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            }
            return (defaultConfiguration instanceof ProxiedGraphicsConfig) && (proxyKey = ((ProxiedGraphicsConfig) defaultConfiguration).getProxyKey()) != null && (surfaceDataProxy = (SurfaceDataProxy) SurfaceManager.this.getCacheData(proxyKey)) != null && surfaceDataProxy.isAccelerated();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ProxiedGraphicsConfig {
        Object getProxyKey();
    }

    public static int getImageScale(Image image) {
        return 1;
    }

    public static SurfaceManager getManager(Image image) {
        throw null;
    }

    public static void setImageAccessor(ImageAccessor imageAccessor) {
        if (imgaccessor != null) {
            throw new InternalError("Attempt to set ImageAccessor twice");
        }
        imgaccessor = imageAccessor;
    }

    public static void setManager(Image image, SurfaceManager surfaceManager) {
        imgaccessor.setSurfaceManager(image, surfaceManager);
    }

    public synchronized void flush() {
        flush(false);
    }

    public Object getCacheData(Object obj) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = this.cacheMap;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(obj);
    }

    public ImageCapabilities getCapabilities(GraphicsConfiguration graphicsConfiguration) {
        return new ImageCapabilitiesGc(graphicsConfiguration);
    }

    public abstract SurfaceData getPrimarySurfaceData();

    public abstract SurfaceData restoreContents();

    public void setAccelerationPriority(float f) {
        if (f == 0.0f) {
            flush(true);
        }
    }

    public void setCacheData(Object obj, Object obj2) {
        if (this.cacheMap == null) {
            synchronized (this) {
                try {
                    if (this.cacheMap == null) {
                        this.cacheMap = new ConcurrentHashMap<>(2);
                    }
                } finally {
                }
            }
        }
        this.cacheMap.put(obj, obj2);
    }

    public synchronized void flush(boolean z) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = this.cacheMap;
        if (concurrentHashMap != null) {
            Iterator<Object> it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof FlushableCacheData) && ((FlushableCacheData) next).flush(z)) {
                    it.remove();
                }
            }
        }
    }

    public void acceleratedSurfaceLost() {
    }
}
