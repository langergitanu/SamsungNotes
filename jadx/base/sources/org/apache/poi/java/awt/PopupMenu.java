package org.apache.poi.java.awt;

import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import org.apache.poi.java.awt.Menu;
import org.apache.poi.java.awt.peer.PopupMenuPeer;
import org.apache.poi.sun.awt.AWTAccessor;

/* JADX INFO: loaded from: classes10.dex */
public class PopupMenu extends Menu {
    private static final String base = "popup";
    static int nameCounter = 0;
    private static final long serialVersionUID = -4620452533522760060L;
    transient boolean isTrayIconPopup;

    public class AccessibleAWTPopupMenu extends Menu.AccessibleAWTMenu {
        private static final long serialVersionUID = -4282044795947239955L;

        public AccessibleAWTPopupMenu() {
            super();
        }

        @Override // org.apache.poi.java.awt.Menu.AccessibleAWTMenu, org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem, org.apache.poi.java.awt.MenuComponent.AccessibleAWTMenuComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.POPUP_MENU;
        }
    }

    static {
        AWTAccessor.setPopupMenuAccessor(new AWTAccessor.PopupMenuAccessor() { // from class: org.apache.poi.java.awt.PopupMenu.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.PopupMenuAccessor
            public boolean isTrayIconPopup(PopupMenu popupMenu) {
                return popupMenu.isTrayIconPopup;
            }
        });
    }

    public PopupMenu() {
        this("");
    }

    @Override // org.apache.poi.java.awt.Menu, org.apache.poi.java.awt.MenuItem
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                MenuContainer menuContainer = this.parent;
                if (menuContainer == null || (menuContainer instanceof Component)) {
                    if (this.peer == null) {
                        this.peer = Toolkit.getDefaultToolkit().createPopupMenu(this);
                    }
                    int itemCount = getItemCount();
                    for (int i = 0; i < itemCount; i++) {
                        MenuItem item = getItem(i);
                        item.parent = this;
                        item.addNotify();
                    }
                } else {
                    super.addNotify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Menu, org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public String constructComponentName() {
        String string;
        synchronized (PopupMenu.class) {
            StringBuilder sb = new StringBuilder("popup");
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Menu, org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTPopupMenu();
        }
        return this.accessibleContext;
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public MenuContainer getParent() {
        if (this.isTrayIconPopup) {
            return null;
        }
        return super.getParent();
    }

    public void show(Component component, int i, int i2) {
        MenuContainer menuContainer = this.parent;
        if (menuContainer == null) {
            throw new NullPointerException("parent is null");
        }
        if (!(menuContainer instanceof Component)) {
            throw new IllegalArgumentException("PopupMenus with non-Component parents cannot be shown");
        }
        Component component2 = (Component) menuContainer;
        if (component2 != component) {
            if (!(component2 instanceof Container)) {
                throw new IllegalArgumentException("origin not in parent's hierarchy");
            }
            if (!((Container) component2).isAncestorOf(component)) {
                throw new IllegalArgumentException("origin not in parent's hierarchy");
            }
        }
        if (component2.getPeer() == null || !component2.isShowing()) {
            throw new RuntimeException("parent not showing on screen");
        }
        if (this.peer == null) {
            addNotify();
        }
        synchronized (getTreeLock()) {
            try {
                PopupMenuPeer popupMenuPeer = this.peer;
                if (popupMenuPeer != null) {
                    popupMenuPeer.show(new Event(component, 0L, 501, i, i2, 0, 0));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PopupMenu(String str) {
        super(str);
        this.isTrayIconPopup = false;
    }
}
