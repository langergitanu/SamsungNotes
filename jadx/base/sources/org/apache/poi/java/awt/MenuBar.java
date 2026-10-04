package org.apache.poi.java.awt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import org.apache.poi.java.awt.MenuComponent;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.peer.MenuBarPeer;
import org.apache.poi.sun.awt.AWTAccessor;

/* JADX INFO: loaded from: classes10.dex */
public class MenuBar extends MenuComponent implements MenuContainer, Accessible {
    private static final String base = "menubar";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -4930327919388951260L;
    Menu helpMenu;
    Vector menus = new Vector();
    private int menuBarSerializedDataVersion = 1;

    public class AccessibleAWTMenuBar extends MenuComponent.AccessibleAWTMenuComponent {
        private static final long serialVersionUID = -8577604491830083815L;

        public AccessibleAWTMenuBar() {
            super();
        }

        @Override // org.apache.poi.java.awt.MenuComponent.AccessibleAWTMenuComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.MENU_BAR;
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setMenuBarAccessor(new AWTAccessor.MenuBarAccessor() { // from class: org.apache.poi.java.awt.MenuBar.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuBarAccessor
            public Menu getHelpMenu(MenuBar menuBar) {
                return menuBar.helpMenu;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuBarAccessor
            public Vector getMenus(MenuBar menuBar) {
                return menuBar.menus;
            }
        });
        nameCounter = 0;
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        for (int i = 0; i < this.menus.size(); i++) {
            ((Menu) this.menus.elementAt(i)).parent = this;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public Menu add(Menu menu) {
        synchronized (getTreeLock()) {
            try {
                MenuContainer menuContainer = menu.parent;
                if (menuContainer != null) {
                    menuContainer.remove(menu);
                }
                this.menus.addElement(menu);
                menu.parent = this;
                MenuBarPeer menuBarPeer = this.peer;
                if (menuBarPeer != null) {
                    if (menu.peer == null) {
                        menu.addNotify();
                    }
                    menuBarPeer.addMenu(menu);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return menu;
    }

    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = Toolkit.getDefaultToolkit().createMenuBar(this);
                }
                int menuCount = getMenuCount();
                for (int i = 0; i < menuCount; i++) {
                    getMenu(i).addNotify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public String constructComponentName() {
        String string;
        synchronized (MenuBar.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Deprecated
    public int countMenus() {
        return getMenuCountImpl();
    }

    public void deleteShortcut(MenuShortcut menuShortcut) {
        int menuCount = getMenuCount();
        for (int i = 0; i < menuCount; i++) {
            getMenu(i).deleteShortcut(menuShortcut);
        }
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public int getAccessibleChildIndex(MenuComponent menuComponent) {
        return this.menus.indexOf(menuComponent);
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTMenuBar();
        }
        return this.accessibleContext;
    }

    public Menu getHelpMenu() {
        return this.helpMenu;
    }

    public Menu getMenu(int i) {
        return getMenuImpl(i);
    }

    public int getMenuCount() {
        return countMenus();
    }

    public final int getMenuCountImpl() {
        return this.menus.size();
    }

    public final Menu getMenuImpl(int i) {
        return (Menu) this.menus.elementAt(i);
    }

    public MenuItem getShortcutMenuItem(MenuShortcut menuShortcut) {
        int menuCount = getMenuCount();
        for (int i = 0; i < menuCount; i++) {
            MenuItem shortcutMenuItem = getMenu(i).getShortcutMenuItem(menuShortcut);
            if (shortcutMenuItem != null) {
                return shortcutMenuItem;
            }
        }
        return null;
    }

    public boolean handleShortcut(KeyEvent keyEvent) {
        int id = keyEvent.getID();
        if ((id != 401 && id != 402) || (Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() & keyEvent.getModifiers()) == 0) {
            return false;
        }
        int menuCount = getMenuCount();
        for (int i = 0; i < menuCount; i++) {
            if (getMenu(i).handleShortcut(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public void remove(int i) {
        synchronized (getTreeLock()) {
            try {
                Menu menu = getMenu(i);
                this.menus.removeElementAt(i);
                MenuBarPeer menuBarPeer = this.peer;
                if (menuBarPeer != null) {
                    menu.removeNotify();
                    menu.parent = null;
                    menuBarPeer.delMenu(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public void removeNotify() {
        synchronized (getTreeLock()) {
            try {
                int menuCount = getMenuCount();
                for (int i = 0; i < menuCount; i++) {
                    getMenu(i).removeNotify();
                }
                super.removeNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setHelpMenu(Menu menu) {
        synchronized (getTreeLock()) {
            try {
                Menu menu2 = this.helpMenu;
                if (menu2 != menu) {
                    if (menu2 != null) {
                        remove(menu2);
                    }
                    if (menu.parent != this) {
                        add(menu);
                    }
                    this.helpMenu = menu;
                    menu.isHelpMenu = true;
                    menu.parent = this;
                    MenuBarPeer menuBarPeer = this.peer;
                    if (menuBarPeer != null) {
                        if (menu.peer == null) {
                            menu.addNotify();
                        }
                        menuBarPeer.addHelpMenu(menu);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized Enumeration<MenuShortcut> shortcuts() {
        Vector vector;
        try {
            vector = new Vector();
            int menuCount = getMenuCount();
            for (int i = 0; i < menuCount; i++) {
                Enumeration enumerationShortcuts = getMenu(i).shortcuts();
                while (enumerationShortcuts.hasMoreElements()) {
                    vector.addElement(enumerationShortcuts.nextElement());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return vector.elements();
    }

    @Override // org.apache.poi.java.awt.MenuContainer
    public void remove(MenuComponent menuComponent) {
        synchronized (getTreeLock()) {
            try {
                int iIndexOf = this.menus.indexOf(menuComponent);
                if (iIndexOf >= 0) {
                    remove(iIndexOf);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
