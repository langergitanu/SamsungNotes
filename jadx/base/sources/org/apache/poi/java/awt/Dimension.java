package org.apache.poi.java.awt;

import androidx.glance.AbstractC2821a;
import java.beans.Transient;
import java.io.Serializable;
import org.apache.poi.java.awt.geom.Dimension2D;

/* JADX INFO: loaded from: classes10.dex */
public class Dimension extends Dimension2D implements Serializable {
    private static final long serialVersionUID = 4723952579491349524L;
    public int height;
    public int width;

    static {
        Toolkit.loadLibraries();
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        initIDs();
    }

    public Dimension() {
        this(0, 0);
    }

    private static native void initIDs();

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            if (this.width == dimension.width && this.height == dimension.height) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.geom.Dimension2D
    public double getHeight() {
        return this.height;
    }

    @Transient
    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    @Override // org.apache.poi.java.awt.geom.Dimension2D
    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i = this.width;
        int i2 = this.height + i;
        return (((i2 + 1) * i2) / 2) + i;
    }

    @Override // org.apache.poi.java.awt.geom.Dimension2D
    public void setSize(double d, double d2) {
        this.width = (int) Math.ceil(d);
        this.height = (int) Math.ceil(d2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[width=");
        sb.append(this.width);
        sb.append(",height=");
        return AbstractC2821a.m2223n(sb, "]", this.height);
    }

    public Dimension(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public Dimension(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }
}
