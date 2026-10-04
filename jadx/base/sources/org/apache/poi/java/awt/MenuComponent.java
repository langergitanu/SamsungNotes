package org.apache.poi.java.awt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.util.Locale;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleComponent;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleSelection;
import javax.accessibility.AccessibleStateSet;
import org.apache.poi.java.awt.event.FocusListener;
import org.apache.poi.java.awt.peer.MenuComponentPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MenuComponent implements Serializable {
    static final String actionListenerK = "actionL";
    static final String itemListenerK = "itemL";
    private static final long serialVersionUID = -4536902356223894379L;
    transient AppContext appContext;
    Font font;
    private String name;
    transient MenuContainer parent;
    transient MenuComponentPeer peer;
    private boolean nameExplicitlySet = false;
    boolean newEventsOnly = false;
    private volatile transient AccessControlContext acc = AccessController.getContext();
    AccessibleContext accessibleContext = null;

    public abstract class AccessibleAWTMenuComponent extends AccessibleContext implements Serializable, AccessibleComponent, AccessibleSelection {
        private static final long serialVersionUID = -4269533416223798698L;

        public AccessibleAWTMenuComponent() {
        }

        public boolean contains(Point point) {
            return false;
        }

        public Accessible getAccessibleAt(Point point) {
            return null;
        }

        public Accessible getAccessibleChild(int i) {
            return null;
        }

        public int getAccessibleChildrenCount() {
            return 0;
        }

        public String getAccessibleDescription() {
            return this.accessibleDescription;
        }

        public int getAccessibleIndexInParent() {
            return MenuComponent.this.getAccessibleIndexInParent();
        }

        public String getAccessibleName() {
            return this.accessibleName;
        }

        public Accessible getAccessibleParent() {
            if (this.accessibleParent != null) {
                return this.accessibleParent;
            }
            Accessible parent = MenuComponent.this.getParent();
            if (parent instanceof Accessible) {
                return parent;
            }
            return null;
        }

        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.AWT_COMPONENT;
        }

        public Accessible getAccessibleSelection(int i) {
            return null;
        }

        public int getAccessibleSelectionCount() {
            return 0;
        }

        public AccessibleStateSet getAccessibleStateSet() {
            return MenuComponent.this.getAccessibleStateSet();
        }

        public Color getBackground() {
            return null;
        }

        public Rectangle getBounds() {
            return null;
        }

        public Cursor getCursor() {
            return null;
        }

        public Font getFont() {
            return MenuComponent.this.getFont();
        }

        public FontMetrics getFontMetrics(Font font) {
            return null;
        }

        public Color getForeground() {
            return null;
        }

        public Locale getLocale() {
            MenuContainer parent = MenuComponent.this.getParent();
            return parent instanceof Component ? ((Component) parent).getLocale() : Locale.getDefault();
        }

        public Point getLocation() {
            return null;
        }

        public Point getLocationOnScreen() {
            return null;
        }

        public Dimension getSize() {
            return null;
        }

        public boolean isAccessibleChildSelected(int i) {
            return false;
        }

        public boolean isEnabled() {
            return true;
        }

        public boolean isFocusTraversable() {
            return true;
        }

        public boolean isShowing() {
            return true;
        }

        public boolean isVisible() {
            return true;
        }

        public void setFont(Font font) {
            MenuComponent.this.setFont(font);
        }

        public AccessibleSelection getAccessibleSelection() {
            return this;
        }

        public void clearAccessibleSelection() {
        }

        public AccessibleComponent getAccessibleComponent() {
            return this;
        }

        public void requestFocus() {
        }

        public void selectAllAccessibleSelection() {
        }

        public void addAccessibleSelection(int i) {
        }

        public void addFocusListener(FocusListener focusListener) {
        }

        public void removeAccessibleSelection(int i) {
        }

        public void removeFocusListener(FocusListener focusListener) {
        }

        public void setBackground(Color color) {
        }

        public void setBounds(Rectangle rectangle) {
        }

        public void setCursor(Cursor cursor) {
        }

        public void setEnabled(boolean z) {
        }

        public void setForeground(Color color) {
        }

        public void setLocation(Point point) {
        }

        public void setSize(Dimension dimension) {
        }

        public void setVisible(boolean z) {
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setMenuComponentAccessor(new AWTAccessor.MenuComponentAccessor() { // from class: org.apache.poi.java.awt.MenuComponent.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuComponentAccessor
            public AppContext getAppContext(MenuComponent menuComponent) {
                return menuComponent.appContext;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuComponentAccessor
            public Font getFont_NoClientCode(MenuComponent menuComponent) {
                return menuComponent.getFont_NoClientCode();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuComponentAccessor
            public MenuContainer getParent(MenuComponent menuComponent) {
                return menuComponent.parent;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.MenuComponentAccessor
            public void setAppContext(MenuComponent menuComponent, AppContext appContext) {
                menuComponent.appContext = appContext;
            }
        });
    }

    public MenuComponent() {
        GraphicsEnvironment.checkHeadless();
        this.appContext = AppContext.getAppContext();
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        GraphicsEnvironment.checkHeadless();
        this.acc = AccessController.getContext();
        objectInputStream.defaultReadObject();
        this.appContext = AppContext.getAppContext();
    }

    public String constructComponentName() {
        return null;
    }

    public final void dispatchEvent(AWTEvent aWTEvent) {
        dispatchEventImpl(aWTEvent);
    }

    public void dispatchEventImpl(AWTEvent aWTEvent) {
        Object obj;
        EventQueue.setCurrentEventAndMostRecentTime(aWTEvent);
        Toolkit.getDefaultToolkit().notifyAWTEventListeners(aWTEvent);
        if (this.newEventsOnly || ((obj = this.parent) != null && (obj instanceof MenuComponent) && ((MenuComponent) obj).newEventsOnly)) {
            if (eventEnabled(aWTEvent)) {
                processEvent(aWTEvent);
            }
        } else {
            Event eventConvertToOld = aWTEvent.convertToOld();
            if (eventConvertToOld != null) {
                postEvent(eventConvertToOld);
            }
        }
    }

    public boolean eventEnabled(AWTEvent aWTEvent) {
        return false;
    }

    public final AccessControlContext getAccessControlContext() {
        if (this.acc != null) {
            return this.acc;
        }
        throw new SecurityException("MenuComponent is missing AccessControlContext");
    }

    public int getAccessibleChildIndex(MenuComponent menuComponent) {
        return -1;
    }

    public AccessibleContext getAccessibleContext() {
        return this.accessibleContext;
    }

    public int getAccessibleIndexInParent() {
        Object obj = this.parent;
        if (obj instanceof MenuComponent) {
            return ((MenuComponent) obj).getAccessibleChildIndex(this);
        }
        return -1;
    }

    public AccessibleStateSet getAccessibleStateSet() {
        return new AccessibleStateSet();
    }

    public Font getFont() {
        Font font = this.font;
        if (font != null) {
            return font;
        }
        MenuContainer menuContainer = this.parent;
        if (menuContainer != null) {
            return menuContainer.getFont();
        }
        return null;
    }

    public final Font getFont_NoClientCode() {
        Object obj;
        Font font = this.font;
        return (font == null && (obj = this.parent) != null) ? obj instanceof Component ? ((Component) obj).getFont_NoClientCode() : obj instanceof MenuComponent ? ((MenuComponent) obj).getFont_NoClientCode() : font : font;
    }

    public String getName() {
        if (this.name == null && !this.nameExplicitlySet) {
            synchronized (this) {
                try {
                    if (this.name == null && !this.nameExplicitlySet) {
                        this.name = constructComponentName();
                    }
                } finally {
                }
            }
        }
        return this.name;
    }

    public MenuContainer getParent() {
        return getParent_NoClientCode();
    }

    public final MenuContainer getParent_NoClientCode() {
        return this.parent;
    }

    @Deprecated
    public MenuComponentPeer getPeer() {
        return this.peer;
    }

    public final Object getTreeLock() {
        return Component.LOCK;
    }

    public String paramString() {
        String name = getName();
        return name != null ? name : "";
    }

    @Deprecated
    public boolean postEvent(Event event) {
        MenuContainer menuContainer = this.parent;
        if (menuContainer == null) {
            return false;
        }
        menuContainer.postEvent(event);
        return false;
    }

    public void removeNotify() {
        synchronized (getTreeLock()) {
            try {
                MenuComponentPeer menuComponentPeer = this.peer;
                if (menuComponentPeer != null) {
                    Toolkit.getEventQueue().removeSourceEvents(this, true);
                    this.peer = null;
                    menuComponentPeer.dispose();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setFont(Font font) {
        this.font = font;
        MenuComponentPeer menuComponentPeer = this.peer;
        if (menuComponentPeer != null) {
            menuComponentPeer.setFont(font);
        }
    }

    public void setName(String str) {
        synchronized (this) {
            this.name = str;
            this.nameExplicitlySet = true;
        }
    }

    public String toString() {
        return getClass().getName() + "[" + paramString() + "]";
    }

    public void processEvent(AWTEvent aWTEvent) {
    }
}
