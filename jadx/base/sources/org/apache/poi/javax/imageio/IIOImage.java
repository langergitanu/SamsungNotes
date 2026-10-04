package org.apache.poi.javax.imageio;

import java.util.List;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IIOImage {
    protected RenderedImage image;
    protected IIOMetadata metadata;
    protected Raster raster;
    protected List<? extends BufferedImage> thumbnails;

    public IIOImage(RenderedImage renderedImage, List<? extends BufferedImage> list, IIOMetadata iIOMetadata) {
        this.thumbnails = null;
        if (renderedImage == null) {
            throw new IllegalArgumentException("image == null!");
        }
        this.image = renderedImage;
        this.raster = null;
        this.thumbnails = list;
        this.metadata = iIOMetadata;
    }

    public IIOMetadata getMetadata() {
        return this.metadata;
    }

    public int getNumThumbnails() {
        List<? extends BufferedImage> list = this.thumbnails;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Raster getRaster() {
        Raster raster;
        synchronized (this) {
            raster = this.raster;
        }
        return raster;
    }

    public RenderedImage getRenderedImage() {
        RenderedImage renderedImage;
        synchronized (this) {
            renderedImage = this.image;
        }
        return renderedImage;
    }

    public BufferedImage getThumbnail(int i) {
        List<? extends BufferedImage> list = this.thumbnails;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException("No thumbnails available!");
    }

    public List<? extends BufferedImage> getThumbnails() {
        return this.thumbnails;
    }

    public boolean hasRaster() {
        boolean z;
        synchronized (this) {
            z = this.raster != null;
        }
        return z;
    }

    public void setMetadata(IIOMetadata iIOMetadata) {
        this.metadata = iIOMetadata;
    }

    public void setRaster(Raster raster) {
        synchronized (this) {
            try {
                if (raster == null) {
                    throw new IllegalArgumentException("raster == null!");
                }
                this.raster = raster;
                this.image = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setRenderedImage(RenderedImage renderedImage) {
        synchronized (this) {
            try {
                if (renderedImage == null) {
                    throw new IllegalArgumentException("image == null!");
                }
                this.image = renderedImage;
                this.raster = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setThumbnails(List<? extends BufferedImage> list) {
        this.thumbnails = list;
    }

    public IIOImage(Raster raster, List<? extends BufferedImage> list, IIOMetadata iIOMetadata) {
        this.thumbnails = null;
        if (raster != null) {
            this.raster = raster;
            this.image = null;
            this.thumbnails = list;
            this.metadata = iIOMetadata;
            return;
        }
        throw new IllegalArgumentException("raster == null!");
    }
}
