package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
public class ImageCapabilities implements Cloneable {
    private boolean accelerated;

    public ImageCapabilities(boolean z) {
        this.accelerated = z;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean isAccelerated() {
        return this.accelerated;
    }

    public boolean isTrueVolatile() {
        return false;
    }
}
