package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class BorderLayout implements LayoutManager2, Serializable {
    public static final String AFTER_LAST_LINE = "Last";
    public static final String AFTER_LINE_ENDS = "After";
    public static final String BEFORE_FIRST_LINE = "First";
    public static final String BEFORE_LINE_BEGINS = "Before";
    public static final String CENTER = "Center";
    public static final String EAST = "East";
    public static final String LINE_END = "After";
    public static final String LINE_START = "Before";
    public static final String NORTH = "North";
    public static final String PAGE_END = "Last";
    public static final String PAGE_START = "First";
    public static final String SOUTH = "South";
    public static final String WEST = "West";
    private static final long serialVersionUID = -8658291919501921765L;
    Component center;
    Component east;
    Component firstItem;
    Component firstLine;
    int hgap;
    Component lastItem;
    Component lastLine;
    Component north;
    Component south;
    int vgap;
    Component west;

    public BorderLayout() {
        this(0, 0);
    }

    private Component getChild(String str, boolean z) {
        Component component;
        if (str == NORTH) {
            component = this.firstLine;
            if (component == null) {
                component = this.north;
            }
        } else if (str == SOUTH) {
            component = this.lastLine;
            if (component == null) {
                component = this.south;
            }
        } else if (str == WEST) {
            component = z ? this.firstItem : this.lastItem;
            if (component == null) {
                component = this.west;
            }
        } else if (str == EAST) {
            component = z ? this.lastItem : this.firstItem;
            if (component == null) {
                component = this.east;
            }
        } else {
            component = str == CENTER ? this.center : null;
        }
        if (component == null || component.visible) {
            return component;
        }
        return null;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    @Deprecated
    public void addLayoutComponent(String str, Component component) {
        synchronized (component.getTreeLock()) {
            if (str == null) {
                str = CENTER;
            }
            try {
                if (CENTER.equals(str)) {
                    this.center = component;
                } else if (NORTH.equals(str)) {
                    this.north = component;
                } else if (SOUTH.equals(str)) {
                    this.south = component;
                } else if (EAST.equals(str)) {
                    this.east = component;
                } else if (WEST.equals(str)) {
                    this.west = component;
                } else if ("First".equals(str)) {
                    this.firstLine = component;
                } else if ("Last".equals(str)) {
                    this.lastLine = component;
                } else if ("Before".equals(str)) {
                    this.firstItem = component;
                } else {
                    if (!"After".equals(str)) {
                        throw new IllegalArgumentException("cannot add to layout: unknown constraint: ".concat(str));
                    }
                    this.lastItem = component;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object getConstraints(Component component) {
        if (component == null) {
            return null;
        }
        if (component == this.center) {
            return CENTER;
        }
        if (component == this.north) {
            return NORTH;
        }
        if (component == this.south) {
            return SOUTH;
        }
        if (component == this.west) {
            return WEST;
        }
        if (component == this.east) {
            return EAST;
        }
        if (component == this.firstLine) {
            return "First";
        }
        if (component == this.lastLine) {
            return "Last";
        }
        if (component == this.firstItem) {
            return "Before";
        }
        if (component == this.lastItem) {
            return "After";
        }
        return null;
    }

    public int getHgap() {
        return this.hgap;
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public float getLayoutAlignmentX(Container container) {
        return 0.5f;
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public float getLayoutAlignmentY(Container container) {
        return 0.5f;
    }

    public Component getLayoutComponent(Object obj) {
        if (CENTER.equals(obj)) {
            return this.center;
        }
        if (NORTH.equals(obj)) {
            return this.north;
        }
        if (SOUTH.equals(obj)) {
            return this.south;
        }
        if (WEST.equals(obj)) {
            return this.west;
        }
        if (EAST.equals(obj)) {
            return this.east;
        }
        if ("First".equals(obj)) {
            return this.firstLine;
        }
        if ("Last".equals(obj)) {
            return this.lastLine;
        }
        if ("Before".equals(obj)) {
            return this.firstItem;
        }
        if ("After".equals(obj)) {
            return this.lastItem;
        }
        throw new IllegalArgumentException(AbstractC0541b.m769k(obj, "cannot get component: unknown constraint: "));
    }

    public int getVgap() {
        return this.vgap;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void layoutContainer(Container container) {
        synchronized (container.getTreeLock()) {
            try {
                Insets insets = container.getInsets();
                int i = insets.top;
                int i2 = container.height - insets.bottom;
                int i4 = insets.left;
                int i5 = container.width - insets.right;
                boolean zIsLeftToRight = container.getComponentOrientation().isLeftToRight();
                Component child = getChild(NORTH, zIsLeftToRight);
                if (child != null) {
                    int i6 = i5 - i4;
                    child.setSize(i6, child.height);
                    Dimension preferredSize = child.getPreferredSize();
                    child.setBounds(i4, i, i6, preferredSize.height);
                    i += preferredSize.height + this.vgap;
                }
                Component child2 = getChild(SOUTH, zIsLeftToRight);
                if (child2 != null) {
                    int i7 = i5 - i4;
                    child2.setSize(i7, child2.height);
                    Dimension preferredSize2 = child2.getPreferredSize();
                    int i8 = preferredSize2.height;
                    child2.setBounds(i4, i2 - i8, i7, i8);
                    i2 -= preferredSize2.height + this.vgap;
                }
                Component child3 = getChild(EAST, zIsLeftToRight);
                if (child3 != null) {
                    int i9 = i2 - i;
                    child3.setSize(child3.width, i9);
                    Dimension preferredSize3 = child3.getPreferredSize();
                    int i10 = preferredSize3.width;
                    child3.setBounds(i5 - i10, i, i10, i9);
                    i5 -= preferredSize3.width + this.hgap;
                }
                Component child4 = getChild(WEST, zIsLeftToRight);
                if (child4 != null) {
                    int i11 = i2 - i;
                    child4.setSize(child4.width, i11);
                    Dimension preferredSize4 = child4.getPreferredSize();
                    child4.setBounds(i4, i, preferredSize4.width, i11);
                    i4 += preferredSize4.width + this.hgap;
                }
                Component child5 = getChild(CENTER, zIsLeftToRight);
                if (child5 != null) {
                    child5.setBounds(i4, i, i5 - i4, i2 - i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public Dimension maximumLayoutSize(Container container) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension minimumLayoutSize(Container container) {
        Dimension dimension;
        synchronized (container.getTreeLock()) {
            try {
                dimension = new Dimension(0, 0);
                boolean zIsLeftToRight = container.getComponentOrientation().isLeftToRight();
                Component child = getChild(EAST, zIsLeftToRight);
                if (child != null) {
                    Dimension minimumSize = child.getMinimumSize();
                    dimension.width = minimumSize.width + this.hgap + dimension.width;
                    dimension.height = Math.max(minimumSize.height, dimension.height);
                }
                Component child2 = getChild(WEST, zIsLeftToRight);
                if (child2 != null) {
                    Dimension minimumSize2 = child2.getMinimumSize();
                    dimension.width = minimumSize2.width + this.hgap + dimension.width;
                    dimension.height = Math.max(minimumSize2.height, dimension.height);
                }
                Component child3 = getChild(CENTER, zIsLeftToRight);
                if (child3 != null) {
                    Dimension minimumSize3 = child3.getMinimumSize();
                    dimension.width += minimumSize3.width;
                    dimension.height = Math.max(minimumSize3.height, dimension.height);
                }
                Component child4 = getChild(NORTH, zIsLeftToRight);
                if (child4 != null) {
                    Dimension minimumSize4 = child4.getMinimumSize();
                    dimension.width = Math.max(minimumSize4.width, dimension.width);
                    dimension.height = minimumSize4.height + this.vgap + dimension.height;
                }
                Component child5 = getChild(SOUTH, zIsLeftToRight);
                if (child5 != null) {
                    Dimension minimumSize5 = child5.getMinimumSize();
                    dimension.width = Math.max(minimumSize5.width, dimension.width);
                    dimension.height = minimumSize5.height + this.vgap + dimension.height;
                }
                Insets insets = container.getInsets();
                dimension.width = insets.left + insets.right + dimension.width;
                dimension.height = insets.top + insets.bottom + dimension.height;
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
                dimension = new Dimension(0, 0);
                boolean zIsLeftToRight = container.getComponentOrientation().isLeftToRight();
                Component child = getChild(EAST, zIsLeftToRight);
                if (child != null) {
                    Dimension preferredSize = child.getPreferredSize();
                    dimension.width = preferredSize.width + this.hgap + dimension.width;
                    dimension.height = Math.max(preferredSize.height, dimension.height);
                }
                Component child2 = getChild(WEST, zIsLeftToRight);
                if (child2 != null) {
                    Dimension preferredSize2 = child2.getPreferredSize();
                    dimension.width = preferredSize2.width + this.hgap + dimension.width;
                    dimension.height = Math.max(preferredSize2.height, dimension.height);
                }
                Component child3 = getChild(CENTER, zIsLeftToRight);
                if (child3 != null) {
                    Dimension preferredSize3 = child3.getPreferredSize();
                    dimension.width += preferredSize3.width;
                    dimension.height = Math.max(preferredSize3.height, dimension.height);
                }
                Component child4 = getChild(NORTH, zIsLeftToRight);
                if (child4 != null) {
                    Dimension preferredSize4 = child4.getPreferredSize();
                    dimension.width = Math.max(preferredSize4.width, dimension.width);
                    dimension.height = preferredSize4.height + this.vgap + dimension.height;
                }
                Component child5 = getChild(SOUTH, zIsLeftToRight);
                if (child5 != null) {
                    Dimension preferredSize5 = child5.getPreferredSize();
                    dimension.width = Math.max(preferredSize5.width, dimension.width);
                    dimension.height = preferredSize5.height + this.vgap + dimension.height;
                }
                Insets insets = container.getInsets();
                dimension.width = insets.left + insets.right + dimension.width;
                dimension.height = insets.top + insets.bottom + dimension.height;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimension;
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void removeLayoutComponent(Component component) {
        synchronized (component.getTreeLock()) {
            try {
                if (component == this.center) {
                    this.center = null;
                } else if (component == this.north) {
                    this.north = null;
                } else if (component == this.south) {
                    this.south = null;
                } else if (component == this.east) {
                    this.east = null;
                } else if (component == this.west) {
                    this.west = null;
                }
                if (component == this.firstLine) {
                    this.firstLine = null;
                } else if (component == this.lastLine) {
                    this.lastLine = null;
                } else if (component == this.firstItem) {
                    this.firstItem = null;
                } else if (component == this.lastItem) {
                    this.lastItem = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setHgap(int i) {
        this.hgap = i;
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
        return AbstractC2821a.m2223n(sb, "]", this.vgap);
    }

    public BorderLayout(int i, int i2) {
        this.hgap = i;
        this.vgap = i2;
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public void addLayoutComponent(Component component, Object obj) {
        synchronized (component.getTreeLock()) {
            if (obj != null) {
                try {
                    if (!(obj instanceof String)) {
                        throw new IllegalArgumentException("cannot add to layout: constraint must be a string (or null)");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            addLayoutComponent((String) obj, component);
        }
    }

    public Component getLayoutComponent(Container container, Object obj) {
        boolean zIsLeftToRight = container.getComponentOrientation().isLeftToRight();
        if (NORTH.equals(obj)) {
            Component component = this.firstLine;
            return component != null ? component : this.north;
        }
        if (SOUTH.equals(obj)) {
            Component component2 = this.lastLine;
            return component2 != null ? component2 : this.south;
        }
        if (WEST.equals(obj)) {
            Component component3 = zIsLeftToRight ? this.firstItem : this.lastItem;
            return component3 == null ? this.west : component3;
        }
        if (EAST.equals(obj)) {
            Component component4 = zIsLeftToRight ? this.lastItem : this.firstItem;
            return component4 == null ? this.east : component4;
        }
        if (CENTER.equals(obj)) {
            return this.center;
        }
        throw new IllegalArgumentException(AbstractC0541b.m769k(obj, "cannot get component: invalid constraint: "));
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public void invalidateLayout(Container container) {
    }
}
