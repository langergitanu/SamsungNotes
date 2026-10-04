package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
public interface LayoutManager {
    void addLayoutComponent(String str, Component component);

    void layoutContainer(Container container);

    Dimension minimumLayoutSize(Container container);

    Dimension preferredLayoutSize(Container container);

    void removeLayoutComponent(Component component);
}
