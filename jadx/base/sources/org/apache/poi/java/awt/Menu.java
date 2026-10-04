package org.apache.poi.java.awt;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import org.apache.poi.java.awt.MenuItem;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.peer.MenuPeer;
import org.apache.poi.sun.awt.AWTAccessor;

/* JADX INFO: loaded from: classes10.dex */
public class Menu extends MenuItem implements MenuContainer, Accessible {
    private static final String base = "menu";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -8809584163345499784L;
    boolean isHelpMenu;
    Vector items;
    private int menuSerializedDataVersion;
    boolean tearOff;

    public class AccessibleAWTMenu extends MenuItem.AccessibleAWTMenuItem {
        private static final long serialVersionUID = 5228160894980069094L;

        public AccessibleAWTMenu() {
            super();
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem, org.apache.poi.java.awt.MenuComponent.AccessibleAWTMenuComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.MENU;
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setMenuAccessor(new AWTAccessor.MenuAccessor() { // from class: org.apache.poi.java.awt.Menu.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuAccessor
            public Vector getItems(Menu menu) {
                return menu.items;
            }
        });
        nameCounter = 0;
    }

    public Menu() {
        this("", false);
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        for (int i = 0; i < this.items.size(); i++) {
            ((MenuItem) this.items.elementAt(i)).parent = this;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public MenuItem add(MenuItem menuItem) {
        synchronized (getTreeLock()) {
            try {
                MenuContainer menuContainer = menuItem.parent;
                if (menuContainer != null) {
                    menuContainer.remove(menuItem);
                }
                this.items.addElement(menuItem);
                menuItem.parent = this;
                MenuPeer menuPeer = this.peer;
                if (menuPeer != null) {
                    menuItem.addNotify();
                    menuPeer.addItem(menuItem);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return menuItem;
    }

    @Override // org.apache.poi.java.awt.MenuItem
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = Toolkit.getDefaultToolkit().createMenu(this);
                }
                int itemCount = getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    MenuItem item = getItem(i);
                    item.parent = this;
                    item.addNotify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addSeparator() {
        add(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
    }

    @Override // org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public String constructComponentName() {
        String string;
        synchronized (Menu.class) {
            StringBuilder sb = new StringBuilder("menu");
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Deprecated
    public int countItems() {
        return countItemsImpl();
    }

    public final int countItemsImpl() {
        return this.items.size();
    }

    @Override // org.apache.poi.java.awt.MenuItem
    public void deleteShortcut(MenuShortcut menuShortcut) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            getItem(i).deleteShortcut(menuShortcut);
        }
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public int getAccessibleChildIndex(MenuComponent menuComponent) {
        return this.items.indexOf(menuComponent);
    }

    @Override // org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTMenu();
        }
        return this.accessibleContext;
    }

    public MenuItem getItem(int i) {
        return getItemImpl(i);
    }

    public int getItemCount() {
        return countItems();
    }

    public final MenuItem getItemImpl(int i) {
        return (MenuItem) this.items.elementAt(i);
    }

    @Override // org.apache.poi.java.awt.MenuItem
    public MenuItem getShortcutMenuItem(MenuShortcut menuShortcut) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            MenuItem shortcutMenuItem = getItem(i).getShortcutMenuItem(menuShortcut);
            if (shortcutMenuItem != null) {
                return shortcutMenuItem;
            }
        }
        return null;
    }

    @Override // org.apache.poi.java.awt.MenuItem
    public boolean handleShortcut(KeyEvent keyEvent) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (getItem(i).handleShortcut(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public void insert(String str, int i) {
        insert(new MenuItem(str), i);
    }

    public void insertSeparator(int i) {
        synchronized (getTreeLock()) {
            try {
                if (i < 0) {
                    throw new IllegalArgumentException("index less than zero.");
                }
                int itemCount = getItemCount();
                Vector vector = new Vector();
                for (int i2 = i; i2 < itemCount; i2++) {
                    vector.addElement(getItem(i));
                    remove(i);
                }
                addSeparator();
                for (int i4 = 0; i4 < vector.size(); i4++) {
                    add((MenuItem) vector.elementAt(i4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isTearOff() {
        return this.tearOff;
    }

    @Override // org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public String paramString() {
        return AbstractC0622a.m1170p(super.paramString(), ",tearOff=" + this.tearOff + ",isHelpMenu=" + this.isHelpMenu, new StringBuilder());
    }

    public void remove(int i) {
        synchronized (getTreeLock()) {
            try {
                MenuItem item = getItem(i);
                this.items.removeElementAt(i);
                MenuPeer menuPeer = this.peer;
                if (menuPeer != null) {
                    item.removeNotify();
                    item.parent = null;
                    menuPeer.delItem(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeAll() {
        synchronized (getTreeLock()) {
            try {
                for (int itemCount = getItemCount() - 1; itemCount >= 0; itemCount--) {
                    remove(itemCount);
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
                int itemCount = getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    getItem(i).removeNotify();
                }
                super.removeNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized Enumeration shortcuts() {
        Vector vector;
        try {
            vector = new Vector();
            int itemCount = getItemCount();
            for (int i = 0; i < itemCount; i++) {
                MenuItem item = getItem(i);
                if (item instanceof Menu) {
                    Enumeration enumerationShortcuts = ((Menu) item).shortcuts();
                    while (enumerationShortcuts.hasMoreElements()) {
                        vector.addElement(enumerationShortcuts.nextElement());
                    }
                } else {
                    MenuShortcut shortcut = item.getShortcut();
                    if (shortcut != null) {
                        vector.addElement(shortcut);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return vector.elements();
    }

    public Menu(String str) {
        this(str, false);
    }

    public void add(String str) {
        add(new MenuItem(str));
    }

    public void insert(MenuItem menuItem, int i) {
        synchronized (getTreeLock()) {
            try {
                if (i < 0) {
                    throw new IllegalArgumentException("index less than zero.");
                }
                int itemCount = getItemCount();
                Vector vector = new Vector();
                for (int i2 = i; i2 < itemCount; i2++) {
                    vector.addElement(getItem(i));
                    remove(i);
                }
                add(menuItem);
                for (int i4 = 0; i4 < vector.size(); i4++) {
                    add((MenuItem) vector.elementAt(i4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.MenuContainer
    public void remove(MenuComponent menuComponent) {
        synchronized (getTreeLock()) {
            try {
                int iIndexOf = this.items.indexOf(menuComponent);
                if (iIndexOf >= 0) {
                    remove(iIndexOf);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Menu(String str, boolean z) {
        super(str);
        this.items = new Vector();
        this.menuSerializedDataVersion = 1;
        this.tearOff = z;
    }
}
