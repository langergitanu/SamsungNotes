package org.apache.poi.java.awt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EventListener;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleAction;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleValue;
import org.apache.poi.java.awt.MenuItem;
import org.apache.poi.java.awt.event.ItemEvent;
import org.apache.poi.java.awt.event.ItemListener;
import org.apache.poi.java.awt.peer.CheckboxMenuItemPeer;
import org.apache.poi.sun.awt.AWTAccessor;

/* JADX INFO: loaded from: classes10.dex */
public class CheckboxMenuItem extends MenuItem implements ItemSelectable, Accessible {
    private static final String base = "chkmenuitem";
    private static int nameCounter = 0;
    private static final long serialVersionUID = 6190621106981774043L;
    private int checkboxMenuItemSerializedDataVersion;
    transient ItemListener itemListener;
    boolean state;

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setCheckboxMenuItemAccessor(new AWTAccessor.CheckboxMenuItemAccessor() { // from class: org.apache.poi.java.awt.CheckboxMenuItem.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.CheckboxMenuItemAccessor
            public boolean getState(CheckboxMenuItem checkboxMenuItem) {
                return checkboxMenuItem.state;
            }
        });
        nameCounter = 0;
    }

    public CheckboxMenuItem() {
        this("", false);
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            }
            if ("itemL" == ((String) object).intern()) {
                addItemListener((ItemListener) objectInputStream.readObject());
            } else {
                objectInputStream.readObject();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        AWTEventMulticaster.save(objectOutputStream, "itemL", this.itemListener);
        objectOutputStream.writeObject(null);
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized void addItemListener(ItemListener itemListener) {
        if (itemListener == null) {
            return;
        }
        this.itemListener = AWTEventMulticaster.add(this.itemListener, itemListener);
        this.newEventsOnly = true;
    }

    @Override // org.apache.poi.java.awt.MenuItem
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = Toolkit.getDefaultToolkit().createCheckboxMenuItem(this);
                }
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public String constructComponentName() {
        String string;
        synchronized (CheckboxMenuItem.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.MenuItem
    public void doMenuEvent(long j, int i) {
        setState(!this.state);
        Toolkit.getEventQueue().postEvent(new ItemEvent(this, 701, getLabel(), this.state ? 1 : 2));
    }

    @Override // org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public boolean eventEnabled(AWTEvent aWTEvent) {
        return aWTEvent.f10031id == 701 ? ((this.eventMask & 512) == 0 && this.itemListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTCheckboxMenuItem();
        }
        return this.accessibleContext;
    }

    public synchronized ItemListener[] getItemListeners() {
        return getListeners(ItemListener.class);
    }

    @Override // org.apache.poi.java.awt.MenuItem
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return cls == ItemListener.class ? (T[]) AWTEventMulticaster.getListeners(this.itemListener, cls) : (T[]) super.getListeners(cls);
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized Object[] getSelectedObjects() {
        if (!this.state) {
            return null;
        }
        return new Object[]{this.label};
    }

    public boolean getState() {
        return this.state;
    }

    @Override // org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public String paramString() {
        return super.paramString() + ",state=" + this.state;
    }

    @Override // org.apache.poi.java.awt.MenuItem, org.apache.poi.java.awt.MenuComponent
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
    }

    public void processItemEvent(ItemEvent itemEvent) {
        ItemListener itemListener = this.itemListener;
        if (itemListener != null) {
            itemListener.itemStateChanged(itemEvent);
        }
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized void removeItemListener(ItemListener itemListener) {
        if (itemListener == null) {
            return;
        }
        this.itemListener = AWTEventMulticaster.remove(this.itemListener, itemListener);
    }

    public synchronized void setState(boolean z) {
        this.state = z;
        CheckboxMenuItemPeer checkboxMenuItemPeer = this.peer;
        if (checkboxMenuItemPeer != null) {
            checkboxMenuItemPeer.setState(z);
        }
    }

    public CheckboxMenuItem(String str) {
        this(str, false);
    }

    public CheckboxMenuItem(String str, boolean z) {
        super(str);
        this.checkboxMenuItemSerializedDataVersion = 1;
        this.state = z;
    }

    public class AccessibleAWTCheckboxMenuItem extends MenuItem.AccessibleAWTMenuItem implements AccessibleAction, AccessibleValue {
        private static final long serialVersionUID = -1122642964303476L;

        public AccessibleAWTCheckboxMenuItem() {
            super();
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public boolean doAccessibleAction(int i) {
            return false;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public int getAccessibleActionCount() {
            return 0;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public String getAccessibleActionDescription(int i) {
            return null;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem, org.apache.poi.java.awt.MenuComponent.AccessibleAWTMenuComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.CHECK_BOX;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public Number getCurrentAccessibleValue() {
            return null;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public Number getMaximumAccessibleValue() {
            return null;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public Number getMinimumAccessibleValue() {
            return null;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public boolean setCurrentAccessibleValue(Number number) {
            return false;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public AccessibleAction getAccessibleAction() {
            return this;
        }

        @Override // org.apache.poi.java.awt.MenuItem.AccessibleAWTMenuItem
        public AccessibleValue getAccessibleValue() {
            return this;
        }
    }
}
