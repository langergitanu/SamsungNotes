package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
public interface MenuContainer {
    Font getFont();

    @Deprecated
    boolean postEvent(Event event);

    void remove(MenuComponent menuComponent);
}
