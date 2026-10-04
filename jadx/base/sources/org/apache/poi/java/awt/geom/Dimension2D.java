package org.apache.poi.java.awt.geom;

/* JADX INFO: loaded from: classes10.dex */
public abstract class Dimension2D implements Cloneable {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public abstract double getHeight();

    public abstract double getWidth();

    public abstract void setSize(double d, double d2);

    public void setSize(Dimension2D dimension2D) {
        setSize(dimension2D.getWidth(), dimension2D.getHeight());
    }
}
