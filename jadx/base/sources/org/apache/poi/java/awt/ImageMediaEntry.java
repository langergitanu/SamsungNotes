package org.apache.poi.java.awt;

import java.io.Serializable;
import org.apache.poi.java.awt.image.ImageObserver;

/* JADX INFO: loaded from: classes10.dex */
class ImageMediaEntry extends MediaEntry implements ImageObserver, Serializable {
    private static final long serialVersionUID = 4739377000350280650L;
    int height;
    Image image;
    int width;

    public ImageMediaEntry(MediaTracker mediaTracker, Image image, int i, int i2, int i4) {
        super(mediaTracker, i);
        this.image = image;
        this.width = i2;
        this.height = i4;
    }

    @Override // org.apache.poi.java.awt.MediaEntry
    public Object getMedia() {
        return this.image;
    }

    @Override // org.apache.poi.java.awt.MediaEntry
    public synchronized int getStatus(boolean z, boolean z2) {
        if (z2) {
            try {
                int i = parseflags(this.tracker.target.checkImage(this.image, this.width, this.height, null));
                if (i == 0) {
                    if ((this.status & 12) != 0) {
                        setStatus(2);
                    }
                } else if (i != this.status) {
                    setStatus(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.getStatus(z, z2);
    }

    public boolean imageUpdate(Image image, int i, int i2, int i4, int i5, int i6) {
        if (this.cancelled) {
            return false;
        }
        int i7 = parseflags(i);
        if (i7 != 0 && i7 != this.status) {
            setStatus(i7);
        }
        return (this.status & 1) != 0;
    }

    public boolean matches(Image image, int i, int i2) {
        return this.image == image && this.width == i && this.height == i2;
    }

    public int parseflags(int i) {
        if ((i & 64) != 0) {
            return 4;
        }
        if ((i & 128) != 0) {
            return 2;
        }
        return (i & 48) != 0 ? 8 : 0;
    }

    @Override // org.apache.poi.java.awt.MediaEntry
    public void startLoad() {
        if (this.tracker.target.prepareImage(this.image, this.width, this.height, this)) {
            setStatus(8);
        }
    }
}
