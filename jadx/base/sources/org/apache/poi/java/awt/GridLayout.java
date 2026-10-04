package org.apache.poi.java.awt;

import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class GridLayout implements LayoutManager, Serializable {
    private static final long serialVersionUID = -7411804673224730901L;
    int cols;
    int hgap;
    int rows;
    int vgap;

    public GridLayout() {
        this(1, 0, 0, 0);
    }

    public int getColumns() {
        return this.cols;
    }

    public int getHgap() {
        return this.hgap;
    }

    public int getRows() {
        return this.rows;
    }

    public int getVgap() {
        return this.vgap;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void layoutContainer(Container container) {
        synchronized (container.getTreeLock()) {
            try {
                Insets insets = container.getInsets();
                int componentCount = container.getComponentCount();
                int iM3211u = this.rows;
                int iM3211u2 = this.cols;
                boolean zIsLeftToRight = container.getComponentOrientation().isLeftToRight();
                if (componentCount == 0) {
                    return;
                }
                if (iM3211u > 0) {
                    iM3211u2 = AbstractC4539a.m3211u(componentCount, iM3211u, 1, iM3211u);
                } else {
                    iM3211u = AbstractC4539a.m3211u(componentCount, iM3211u2, 1, iM3211u2);
                }
                int i = (iM3211u2 - 1) * this.hgap;
                int i2 = container.width;
                int i4 = insets.left;
                int i5 = insets.right;
                int i6 = i2 - (i4 + i5);
                int i7 = (i6 - i) / iM3211u2;
                int i8 = (i6 - ((i7 * iM3211u2) + i)) / 2;
                int i9 = (iM3211u - 1) * this.vgap;
                int i10 = container.height - (insets.top + insets.bottom);
                int i11 = (i10 - i9) / iM3211u;
                int i12 = (i10 - ((i11 * iM3211u) + i9)) / 2;
                if (zIsLeftToRight) {
                    int i13 = i4 + i8;
                    int i14 = 0;
                    while (i14 < iM3211u2) {
                        int i15 = insets.top + i12;
                        int i16 = 0;
                        while (i16 < iM3211u) {
                            int i17 = (i16 * iM3211u2) + i14;
                            if (i17 < componentCount) {
                                container.getComponent(i17).setBounds(i13, i15, i7, i11);
                            }
                            i16++;
                            i15 += this.vgap + i11;
                        }
                        i14++;
                        i13 += this.hgap + i7;
                    }
                } else {
                    int i18 = ((i2 - i5) - i7) - i8;
                    int i19 = 0;
                    while (i19 < iM3211u2) {
                        int i20 = insets.top + i12;
                        int i21 = 0;
                        while (i21 < iM3211u) {
                            int i22 = (i21 * iM3211u2) + i19;
                            if (i22 < componentCount) {
                                container.getComponent(i22).setBounds(i18, i20, i7, i11);
                            }
                            i21++;
                            i20 += this.vgap + i11;
                        }
                        i19++;
                        i18 -= this.hgap + i7;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension minimumLayoutSize(Container container) {
        Dimension dimension;
        synchronized (container.getTreeLock()) {
            try {
                Insets insets = container.getInsets();
                int componentCount = container.getComponentCount();
                int iM3211u = this.rows;
                int iM3211u2 = this.cols;
                if (iM3211u > 0) {
                    iM3211u2 = AbstractC4539a.m3211u(componentCount, iM3211u, 1, iM3211u);
                } else {
                    iM3211u = AbstractC4539a.m3211u(componentCount, iM3211u2, 1, iM3211u2);
                }
                int i = 0;
                int i2 = 0;
                for (int i4 = 0; i4 < componentCount; i4++) {
                    Dimension minimumSize = container.getComponent(i4).getMinimumSize();
                    int i5 = minimumSize.width;
                    if (i < i5) {
                        i = i5;
                    }
                    int i6 = minimumSize.height;
                    if (i2 < i6) {
                        i2 = i6;
                    }
                }
                dimension = new Dimension(((iM3211u2 - 1) * this.hgap) + (i * iM3211u2) + insets.left + insets.right, ((iM3211u - 1) * this.vgap) + (i2 * iM3211u) + insets.top + insets.bottom);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimension;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension preferredLayoutSize(Container container) {
        Dimension dimension;
        synchronized (container.getTreeLock()) {
            try {
                Insets insets = container.getInsets();
                int componentCount = container.getComponentCount();
                int iM3211u = this.rows;
                int iM3211u2 = this.cols;
                if (iM3211u > 0) {
                    iM3211u2 = AbstractC4539a.m3211u(componentCount, iM3211u, 1, iM3211u);
                } else {
                    iM3211u = AbstractC4539a.m3211u(componentCount, iM3211u2, 1, iM3211u2);
                }
                int i = 0;
                int i2 = 0;
                for (int i4 = 0; i4 < componentCount; i4++) {
                    Dimension preferredSize = container.getComponent(i4).getPreferredSize();
                    int i5 = preferredSize.width;
                    if (i < i5) {
                        i = i5;
                    }
                    int i6 = preferredSize.height;
                    if (i2 < i6) {
                        i2 = i6;
                    }
                }
                dimension = new Dimension(((iM3211u2 - 1) * this.hgap) + (i * iM3211u2) + insets.left + insets.right, ((iM3211u - 1) * this.vgap) + (i2 * iM3211u) + insets.top + insets.bottom);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimension;
    }

    public void setColumns(int i) {
        if (i == 0 && this.rows == 0) {
            throw new IllegalArgumentException("rows and cols cannot both be zero");
        }
        this.cols = i;
    }

    public void setHgap(int i) {
        this.hgap = i;
    }

    public void setRows(int i) {
        if (i == 0 && this.cols == 0) {
            throw new IllegalArgumentException("rows and cols cannot both be zero");
        }
        this.rows = i;
    }

    public void setVgap(int i) {
        this.vgap = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[hgap=");
        sb.append(this.hgap);
        sb.append(",vgap=");
        sb.append(this.vgap);
        sb.append(",rows=");
        sb.append(this.rows);
        sb.append(",cols=");
        return AbstractC2821a.m2223n(sb, "]", this.cols);
    }

    public GridLayout(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public GridLayout(int i, int i2, int i4, int i5) {
        if (i == 0 && i2 == 0) {
            throw new IllegalArgumentException("rows and cols cannot both be zero");
        }
        this.rows = i;
        this.cols = i2;
        this.hgap = i4;
        this.vgap = i5;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void removeLayoutComponent(Component component) {
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void addLayoutComponent(String str, Component component) {
    }
}
