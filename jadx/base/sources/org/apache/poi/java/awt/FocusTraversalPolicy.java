package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
public abstract class FocusTraversalPolicy {
    public abstract Component getComponentAfter(Container container, Component component);

    public abstract Component getComponentBefore(Container container, Component component);

    public abstract Component getDefaultComponent(Container container);

    public abstract Component getFirstComponent(Container container);

    public Component getInitialComponent(Window window) {
        if (window == null) {
            throw new IllegalArgumentException("window cannot be equal to null.");
        }
        Component defaultComponent = getDefaultComponent(window);
        return (defaultComponent == null && window.isFocusableWindow()) ? window : defaultComponent;
    }

    public abstract Component getLastComponent(Container container);
}
