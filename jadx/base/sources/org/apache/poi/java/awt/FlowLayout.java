package org.apache.poi.java.awt;

import androidx.compose.runtime.AbstractC1974b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public class FlowLayout implements LayoutManager, Serializable {
    public static final int CENTER = 1;
    public static final int LEADING = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int TRAILING = 4;
    private static final int currentSerialVersion = 1;
    private static final long serialVersionUID = -7262534875583282631L;
    int align;
    private boolean alignOnBaseline;
    int hgap;
    int newAlign;
    private int serialVersionOnStream;
    int vgap;

    public FlowLayout() {
        this(1, 5, 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int moveComponents(Container container, int i, int i2, int i4, int i5, int i6, int i7, boolean z, boolean z2, int[] iArr, int[] iArr2) {
        int i8;
        int i9;
        int iMax;
        int i10;
        int i11;
        int i12;
        int i13 = this.newAlign;
        int iMax2 = 0;
        if (i13 != 0) {
            if (i13 == 1) {
                i9 = (i4 / 2) + i;
            } else if (i13 != 2) {
                i9 = i13 != 4 ? i : i + i4;
            } else {
                i8 = z ? i4 : 0;
            }
            if (z2) {
                iMax = i5;
                i10 = 0;
            } else {
                int iMax3 = 0;
                int iMax4 = 0;
                for (int i14 = i6; i14 < i7; i14++) {
                    Component component = container.getComponent(i14);
                    if (component.visible) {
                        int i15 = iArr[i14];
                        if (i15 >= 0) {
                            iMax2 = Math.max(iMax2, i15);
                            iMax3 = Math.max(iMax3, iArr2[i14]);
                        } else {
                            iMax4 = Math.max(component.getHeight(), iMax4);
                        }
                    }
                }
                iMax = Math.max(iMax2 + iMax3, iMax4);
                int i16 = ((iMax - iMax2) - iMax3) / 2;
                i10 = iMax2;
                iMax2 = i16;
            }
            int i17 = i9;
            for (i11 = i6; i11 < i7; i11++) {
                Component component2 = container.getComponent(i11);
                if (component2.isVisible()) {
                    int iM7d = (!z2 || (i12 = iArr[i11]) < 0) ? AbstractC0000a.m7d(iMax, component2.height, 2, i2) : ((i2 + iMax2) + i10) - i12;
                    if (z) {
                        component2.setLocation(i17, iM7d);
                    } else {
                        component2.setLocation((container.width - i17) - component2.width, iM7d);
                    }
                    i17 = component2.width + this.hgap + i17;
                }
            }
            return iMax;
        }
        if (z) {
        }
        i9 = i8 + i;
        if (z2) {
        }
        int i172 = i9;
        while (i11 < i7) {
        }
        return iMax;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            setAlignment(this.align);
        }
        this.serialVersionOnStream = 1;
    }

    public boolean getAlignOnBaseline() {
        return this.alignOnBaseline;
    }

    public int getAlignment() {
        return this.newAlign;
    }

    public int getHgap() {
        return this.hgap;
    }

    public int getVgap() {
        return this.vgap;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void layoutContainer(Container container) {
        int[] iArr;
        int[] iArr2;
        int i;
        Container container2 = container;
        synchronized (container2.getTreeLock()) {
            try {
                Insets insets = container2.getInsets();
                int i2 = container2.width - ((this.hgap * 2) + (insets.left + insets.right));
                int componentCount = container2.getComponentCount();
                int i4 = insets.top + this.vgap;
                boolean zIsLeftToRight = container2.getComponentOrientation().isLeftToRight();
                boolean alignOnBaseline = getAlignOnBaseline();
                if (alignOnBaseline) {
                    iArr = new int[componentCount];
                    iArr2 = new int[componentCount];
                } else {
                    iArr = null;
                    iArr2 = null;
                }
                int iMax = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = i4;
                int i8 = 0;
                while (i6 < componentCount) {
                    Component component = container2.getComponent(i6);
                    if (component.isVisible()) {
                        i = componentCount;
                        Dimension preferredSize = component.getPreferredSize();
                        int i9 = i8;
                        component.setSize(preferredSize.width, preferredSize.height);
                        if (alignOnBaseline) {
                            int baseline = component.getBaseline(preferredSize.width, preferredSize.height);
                            if (baseline >= 0) {
                                iArr[i6] = baseline;
                                iArr2[i6] = preferredSize.height - baseline;
                            } else {
                                iArr[i6] = -1;
                            }
                        }
                        if (i9 == 0 || i9 + preferredSize.width <= i2) {
                            i8 = (i9 > 0 ? i9 + this.hgap : i9) + preferredSize.width;
                            iMax = Math.max(iMax, preferredSize.height);
                        } else {
                            int iMoveComponents = moveComponents(container, this.hgap + insets.left, i7, i2 - i9, iMax, i5, i6, zIsLeftToRight, alignOnBaseline, iArr, iArr2);
                            int i10 = preferredSize.width;
                            int i11 = this.vgap + iMoveComponents + i7;
                            iMax = preferredSize.height;
                            i7 = i11;
                            i5 = i6;
                            i8 = i10;
                        }
                    } else {
                        i = componentCount;
                    }
                    i6++;
                    container2 = container;
                    componentCount = i;
                }
                moveComponents(container, insets.left + this.hgap, i7, i2 - i8, iMax, i5, componentCount, zIsLeftToRight, alignOnBaseline, iArr, iArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension minimumLayoutSize(Container container) {
        Dimension dimension;
        int baseline;
        synchronized (container.getTreeLock()) {
            try {
                boolean alignOnBaseline = getAlignOnBaseline();
                dimension = new Dimension(0, 0);
                int componentCount = container.getComponentCount();
                boolean z = true;
                int iMax = 0;
                int iMax2 = 0;
                for (int i = 0; i < componentCount; i++) {
                    Component component = container.getComponent(i);
                    if (component.visible) {
                        Dimension minimumSize = component.getMinimumSize();
                        dimension.height = Math.max(dimension.height, minimumSize.height);
                        if (z) {
                            z = false;
                        } else {
                            dimension.width += this.hgap;
                        }
                        dimension.width += minimumSize.width;
                        if (alignOnBaseline && (baseline = component.getBaseline(minimumSize.width, minimumSize.height)) >= 0) {
                            iMax = Math.max(iMax, baseline);
                            iMax2 = Math.max(iMax2, dimension.height - baseline);
                        }
                    }
                }
                if (alignOnBaseline) {
                    dimension.height = Math.max(iMax + iMax2, dimension.height);
                }
                Insets insets = container.getInsets();
                dimension.width = AbstractC1974b.m1310c(this.hgap, 2, insets.left + insets.right, dimension.width);
                dimension.height = AbstractC1974b.m1310c(this.vgap, 2, insets.top + insets.bottom, dimension.height);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimension;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension preferredLayoutSize(Container container) {
        Dimension dimension;
        int baseline;
        synchronized (container.getTreeLock()) {
            try {
                dimension = new Dimension(0, 0);
                int componentCount = container.getComponentCount();
                boolean alignOnBaseline = getAlignOnBaseline();
                boolean z = true;
                int iMax = 0;
                int iMax2 = 0;
                for (int i = 0; i < componentCount; i++) {
                    Component component = container.getComponent(i);
                    if (component.isVisible()) {
                        Dimension preferredSize = component.getPreferredSize();
                        dimension.height = Math.max(dimension.height, preferredSize.height);
                        if (z) {
                            z = false;
                        } else {
                            dimension.width += this.hgap;
                        }
                        dimension.width += preferredSize.width;
                        if (alignOnBaseline && (baseline = component.getBaseline(preferredSize.width, preferredSize.height)) >= 0) {
                            iMax = Math.max(iMax, baseline);
                            iMax2 = Math.max(iMax2, preferredSize.height - baseline);
                        }
                    }
                }
                if (alignOnBaseline) {
                    dimension.height = Math.max(iMax + iMax2, dimension.height);
                }
                Insets insets = container.getInsets();
                dimension.width = AbstractC1974b.m1310c(this.hgap, 2, insets.left + insets.right, dimension.width);
                dimension.height = AbstractC1974b.m1310c(this.vgap, 2, insets.top + insets.bottom, dimension.height);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimension;
    }

    public void setAlignOnBaseline(boolean z) {
        this.alignOnBaseline = z;
    }

    public void setAlignment(int i) {
        int i2;
        this.newAlign = i;
        if (i == 3) {
            i2 = 0;
        } else {
            if (i != 4) {
                this.align = i;
                return;
            }
            i2 = 2;
        }
        this.align = i2;
    }

    public void setHgap(int i) {
        this.hgap = i;
    }

    public void setVgap(int i) {
        this.vgap = i;
    }

    public String toString() {
        int i = this.align;
        return getClass().getName() + "[hgap=" + this.hgap + ",vgap=" + this.vgap + (i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : ",align=trailing" : ",align=leading" : ",align=right" : ",align=center" : ",align=left") + "]";
    }

    public FlowLayout(int i) {
        this(i, 5, 5);
    }

    public FlowLayout(int i, int i2, int i4) {
        this.serialVersionOnStream = 1;
        this.hgap = i2;
        this.vgap = i4;
        setAlignment(i);
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void removeLayoutComponent(Component component) {
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void addLayoutComponent(String str, Component component) {
    }
}
