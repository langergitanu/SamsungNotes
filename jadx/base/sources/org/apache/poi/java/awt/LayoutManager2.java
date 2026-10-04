package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
public interface LayoutManager2 extends LayoutManager {
    void addLayoutComponent(Component component, Object obj);

    float getLayoutAlignmentX(Container container);

    float getLayoutAlignmentY(Container container);

    void invalidateLayout(Container container);

    Dimension maximumLayoutSize(Container container);
}
