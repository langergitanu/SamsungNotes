package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EventListener;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleAction;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleValue;
import org.apache.poi.java.awt.MenuComponent;
import org.apache.poi.java.awt.event.ActionEvent;
import org.apache.poi.java.awt.event.ActionListener;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.peer.MenuItemPeer;
import org.apache.poi.sun.awt.AWTAccessor;

/* JADX INFO: loaded from: classes10.dex */
public class MenuItem extends MenuComponent implements Accessible {
    private static final String base = "menuitem";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -21757335363267194L;
    String actionCommand;
    transient ActionListener actionListener;
    boolean enabled;
    long eventMask;
    String label;
    private int menuItemSerializedDataVersion;
    private MenuShortcut shortcut;

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setMenuItemAccessor(new AWTAccessor.MenuItemAccessor() { // from class: org.apache.poi.java.awt.MenuItem.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuItemAccessor
            public String getActionCommandImpl(MenuItem menuItem) {
                return menuItem.getActionCommandImpl();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuItemAccessor
            public String getLabel(MenuItem menuItem) {
                return menuItem.label;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuItemAccessor
            public MenuShortcut getShortcut(MenuItem menuItem) {
                return menuItem.shortcut;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuItemAccessor
            public boolean isEnabled(MenuItem menuItem) {
                return menuItem.enabled;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuItemAccessor
            public boolean isItemEnabled(MenuItem menuItem) {
                return menuItem.isItemEnabled();
            }
        });
        nameCounter = 0;
    }

    public MenuItem() {
        this("", null);
    }

    private static native void initIDs();

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isItemEnabled() {
        if (!isEnabled()) {
            return false;
        }
        MenuContainer parent_NoClientCode = getParent_NoClientCode();
        while (parent_NoClientCode instanceof Menu) {
            Menu menu = (Menu) parent_NoClientCode;
            if (!menu.isEnabled()) {
                return false;
            }
            parent_NoClientCode = menu.getParent_NoClientCode();
            if (parent_NoClientCode == null) {
                return true;
            }
        }
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            }
            if ("actionL" == ((String) object).intern()) {
                addActionListener((ActionListener) objectInputStream.readObject());
            } else {
                objectInputStream.readObject();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        AWTEventMulticaster.save(objectOutputStream, "actionL", this.actionListener);
        objectOutputStream.writeObject(null);
    }

    public synchronized void addActionListener(ActionListener actionListener) {
        if (actionListener == null) {
            return;
        }
        this.actionListener = AWTEventMulticaster.add(this.actionListener, actionListener);
        this.newEventsOnly = true;
    }

    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = Toolkit.getDefaultToolkit().createMenuItem(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public String constructComponentName() {
        String string;
        synchronized (MenuItem.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    public void deleteShortcut() {
        this.shortcut = null;
        MenuItemPeer menuItemPeer = this.peer;
        if (menuItemPeer != null) {
            menuItemPeer.setLabel(this.label);
        }
    }

    @Deprecated
    public synchronized void disable() {
        this.enabled = false;
        MenuItemPeer menuItemPeer = this.peer;
        if (menuItemPeer != null) {
            menuItemPeer.setEnabled(false);
        }
    }

    public final void disableEvents(long j) {
        this.eventMask = (~j) & this.eventMask;
    }

    public void doMenuEvent(long j, int i) {
        Toolkit.getEventQueue().postEvent(new ActionEvent(this, 1001, getActionCommand(), j, i));
    }

    @Deprecated
    public synchronized void enable() {
        this.enabled = true;
        MenuItemPeer menuItemPeer = this.peer;
        if (menuItemPeer != null) {
            menuItemPeer.setEnabled(true);
        }
    }

    public final void enableEvents(long j) {
        this.eventMask = j | this.eventMask;
        this.newEventsOnly = true;
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public boolean eventEnabled(AWTEvent aWTEvent) {
        return aWTEvent.f10031id == 1001 ? ((this.eventMask & 128) == 0 && this.actionListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTMenuItem();
        }
        return this.accessibleContext;
    }

    public String getActionCommand() {
        return getActionCommandImpl();
    }

    public final String getActionCommandImpl() {
        String str = this.actionCommand;
        return str == null ? this.label : str;
    }

    public synchronized ActionListener[] getActionListeners() {
        return getListeners(ActionListener.class);
    }

    public String getLabel() {
        return this.label;
    }

    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return (T[]) AWTEventMulticaster.getListeners(cls == ActionListener.class ? this.actionListener : null, cls);
    }

    public MenuShortcut getShortcut() {
        return this.shortcut;
    }

    public MenuItem getShortcutMenuItem(MenuShortcut menuShortcut) {
        if (menuShortcut.equals(this.shortcut)) {
            return this;
        }
        return null;
    }

    public boolean handleShortcut(KeyEvent keyEvent) {
        MenuShortcut menuShortcut = new MenuShortcut(keyEvent.getKeyCode(), (keyEvent.getModifiers() & 1) > 0);
        MenuShortcut menuShortcut2 = new MenuShortcut(keyEvent.getExtendedKeyCode(), (keyEvent.getModifiers() & 1) > 0);
        if ((!menuShortcut.equals(this.shortcut) && !menuShortcut2.equals(this.shortcut)) || !isItemEnabled()) {
            return false;
        }
        if (keyEvent.getID() == 401) {
            doMenuEvent(keyEvent.getWhen(), keyEvent.getModifiers());
        }
        return true;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public String paramString() {
        String string = ",label=" + this.label;
        if (this.shortcut != null) {
            StringBuilder sbM781w = AbstractC0541b.m781w(string, ",shortcut=");
            sbM781w.append(this.shortcut);
            string = sbM781w.toString();
        }
        return AbstractC0622a.m1170p(super.paramString(), string, new StringBuilder());
    }

    public void processActionEvent(ActionEvent actionEvent) {
        ActionListener actionListener = this.actionListener;
        if (actionListener != null) {
            actionListener.actionPerformed(actionEvent);
        }
    }

    public synchronized void removeActionListener(ActionListener actionListener) {
        if (actionListener == null) {
            return;
        }
        this.actionListener = AWTEventMulticaster.remove(this.actionListener, actionListener);
    }

    public void setActionCommand(String str) {
        this.actionCommand = str;
    }

    public synchronized void setEnabled(boolean z) {
        enable(z);
    }

    public synchronized void setLabel(String str) {
        this.label = str;
        MenuItemPeer menuItemPeer = this.peer;
        if (menuItemPeer != null) {
            menuItemPeer.setLabel(str);
        }
    }

    public void setShortcut(MenuShortcut menuShortcut) {
        this.shortcut = menuShortcut;
        MenuItemPeer menuItemPeer = this.peer;
        if (menuItemPeer != null) {
            menuItemPeer.setLabel(this.label);
        }
    }

    public MenuItem(String str) {
        this(str, null);
    }

    public void deleteShortcut(MenuShortcut menuShortcut) {
        if (menuShortcut.equals(this.shortcut)) {
            this.shortcut = null;
            MenuItemPeer menuItemPeer = this.peer;
            if (menuItemPeer != null) {
                menuItemPeer.setLabel(this.label);
            }
        }
    }

    @Deprecated
    public void enable(boolean z) {
        if (z) {
            enable();
        } else {
            disable();
        }
    }

    public MenuItem(String str, MenuShortcut menuShortcut) {
        this.enabled = true;
        this.menuItemSerializedDataVersion = 1;
        this.label = str;
        this.shortcut = menuShortcut;
    }

    public class AccessibleAWTMenuItem extends MenuComponent.AccessibleAWTMenuComponent implements AccessibleAction, AccessibleValue {
        private static final long serialVersionUID = -217847831945965825L;

        public AccessibleAWTMenuItem() {
            super();
        }

        public boolean doAccessibleAction(int i) {
            if (i != 0) {
                return false;
            }
            EventQueue eventQueue = Toolkit.getEventQueue();
            MenuItem menuItem = MenuItem.this;
            eventQueue.postEvent(new ActionEvent(menuItem, 1001, menuItem.getActionCommand(), EventQueue.getMostRecentEventTime(), 0));
            return true;
        }

        public int getAccessibleActionCount() {
            return 1;
        }

        public String getAccessibleActionDescription(int i) {
            if (i == 0) {
                return "click";
            }
            return null;
        }

        @Override // org.apache.poi.java.awt.MenuComponent.AccessibleAWTMenuComponent
        public String getAccessibleName() {
            return this.accessibleName != null ? this.accessibleName : MenuItem.this.getLabel() == null ? super.getAccessibleName() : MenuItem.this.getLabel();
        }

        @Override // org.apache.poi.java.awt.MenuComponent.AccessibleAWTMenuComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.MENU_ITEM;
        }

        public Number getCurrentAccessibleValue() {
            return 0;
        }

        public Number getMaximumAccessibleValue() {
            return 0;
        }

        public Number getMinimumAccessibleValue() {
            return 0;
        }

        public boolean setCurrentAccessibleValue(Number number) {
            return false;
        }

        public AccessibleAction getAccessibleAction() {
            return this;
        }

        public AccessibleValue getAccessibleValue() {
            return this;
        }
    }

    @Override // org.apache.poi.java.awt.MenuComponent
    public void processEvent(AWTEvent aWTEvent) {
    }
}
