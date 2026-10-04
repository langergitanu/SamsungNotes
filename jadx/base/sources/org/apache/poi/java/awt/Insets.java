package org.apache.poi.java.awt;

import androidx.glance.AbstractC2821a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class Insets implements Cloneable, Serializable {
    private static final long serialVersionUID = -2272572637695466749L;
    public int bottom;
    public int left;
    public int right;
    public int top;

    static {
        Toolkit.loadLibraries();
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        initIDs();
    }

    public Insets(int i, int i2, int i4, int i5) {
        this.top = i;
        this.left = i2;
        this.bottom = i4;
        this.right = i5;
    }

    private static native void initIDs();

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Insets) {
            Insets insets = (Insets) obj;
            if (this.top == insets.top && this.left == insets.left && this.bottom == insets.bottom && this.right == insets.right) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.left;
        int i2 = this.bottom + i;
        int i4 = this.right;
        int i5 = this.top;
        int i6 = i4 + i5;
        int i7 = (((i2 + 1) * i2) / 2) + i;
        int i8 = (((i6 + 1) * i6) / 2) + i5;
        int i9 = i7 + i8;
        return (((i9 + 1) * i9) / 2) + i8;
    }

    public void set(int i, int i2, int i4, int i5) {
        this.top = i;
        this.left = i2;
        this.bottom = i4;
        this.right = i5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[top=");
        sb.append(this.top);
        sb.append(",left=");
        sb.append(this.left);
        sb.append(",bottom=");
        sb.append(this.bottom);
        sb.append(",right=");
        return AbstractC2821a.m2223n(sb, "]", this.right);
    }
}
