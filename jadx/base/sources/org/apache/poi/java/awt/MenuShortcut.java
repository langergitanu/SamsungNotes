package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Serializable;
import org.apache.poi.java.awt.event.KeyEvent;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes10.dex */
public class MenuShortcut implements Serializable {
    private static final long serialVersionUID = 143448358473180225L;
    int key;
    boolean usesShift;

    public MenuShortcut(int i) {
        this(i, false);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MenuShortcut) {
            return equals((MenuShortcut) obj);
        }
        return false;
    }

    public int getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.usesShift ? ~this.key : this.key;
    }

    public String paramString() {
        String str = "key=" + this.key;
        return usesShiftModifier() ? AbstractC0541b.m756B(str, ",usesShiftModifier") : str;
    }

    public String toString() {
        int menuShortcutKeyMask = !GraphicsEnvironment.isHeadless() ? Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() : 0;
        if (usesShiftModifier()) {
            menuShortcutKeyMask |= 1;
        }
        return KeyEvent.getKeyModifiersText(menuShortcutKeyMask) + Marker.ANY_NON_NULL_MARKER + KeyEvent.getKeyText(this.key);
    }

    public boolean usesShiftModifier() {
        return this.usesShift;
    }

    public MenuShortcut(int i, boolean z) {
        this.key = i;
        this.usesShift = z;
    }

    public boolean equals(MenuShortcut menuShortcut) {
        return menuShortcut != null && menuShortcut.getKey() == this.key && menuShortcut.usesShiftModifier() == this.usesShift;
    }
}
