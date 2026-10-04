package org.apache.poi.java.awt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EventListener;
import java.util.Vector;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleAction;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.event.ItemEvent;
import org.apache.poi.java.awt.event.ItemListener;
import org.apache.poi.java.awt.peer.ChoicePeer;

/* JADX INFO: loaded from: classes10.dex */
public class Choice extends Component implements ItemSelectable, Accessible {
    private static final String base = "choice";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -4075310674757313071L;
    transient ItemListener itemListener;
    Vector pItems;
    int selectedIndex = -1;
    private int choiceSerializedDataVersion = 1;

    public Choice() {
        GraphicsEnvironment.checkHeadless();
        this.pItems = new Vector();
    }

    private void insertNoInvalidate(String str, int i) {
        if (str == null) {
            throw new NullPointerException("cannot add null item to Choice");
        }
        this.pItems.insertElementAt(str, i);
        ChoicePeer choicePeer = this.peer;
        if (choicePeer != null) {
            choicePeer.add(str, i);
        }
        int i2 = this.selectedIndex;
        if (i2 < 0 || i2 >= i) {
            select(0);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        GraphicsEnvironment.checkHeadless();
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

    private void removeNoInvalidate(int i) {
        this.pItems.removeElementAt(i);
        ChoicePeer choicePeer = this.peer;
        if (choicePeer != null) {
            choicePeer.remove(i);
        }
        if (this.pItems.size() == 0) {
            this.selectedIndex = -1;
            return;
        }
        int i2 = this.selectedIndex;
        if (i2 == i) {
            select(0);
        } else if (i2 > i) {
            select(i2 - 1);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        AWTEventMulticaster.save(objectOutputStream, "itemL", this.itemListener);
        objectOutputStream.writeObject(null);
    }

    public void add(String str) {
        addItem(str);
    }

    public void addItem(String str) {
        synchronized (this) {
            insertNoInvalidate(str, this.pItems.size());
        }
        invalidateIfValid();
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized void addItemListener(ItemListener itemListener) {
        if (itemListener == null) {
            return;
        }
        this.itemListener = AWTEventMulticaster.add(this.itemListener, itemListener);
        this.newEventsOnly = true;
    }

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createChoice(this);
                }
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (Choice.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Deprecated
    public int countItems() {
        return this.pItems.size();
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean eventEnabled(AWTEvent aWTEvent) {
        return aWTEvent.f10031id == 701 ? ((this.eventMask & 512) == 0 && this.itemListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTChoice();
        }
        return this.accessibleContext;
    }

    public String getItem(int i) {
        return getItemImpl(i);
    }

    public int getItemCount() {
        return countItems();
    }

    public final String getItemImpl(int i) {
        return (String) this.pItems.elementAt(i);
    }

    public synchronized ItemListener[] getItemListeners() {
        return getListeners(ItemListener.class);
    }

    @Override // org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return cls == ItemListener.class ? (T[]) AWTEventMulticaster.getListeners(this.itemListener, cls) : (T[]) super.getListeners(cls);
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public synchronized String getSelectedItem() {
        int i;
        i = this.selectedIndex;
        return i >= 0 ? getItem(i) : null;
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized Object[] getSelectedObjects() {
        int i = this.selectedIndex;
        if (i < 0) {
            return null;
        }
        return new Object[]{getItem(i)};
    }

    public void insert(String str, int i) {
        synchronized (this) {
            if (i < 0) {
                throw new IllegalArgumentException("index less than zero.");
            }
            insertNoInvalidate(str, Math.min(i, this.pItems.size()));
        }
        invalidateIfValid();
    }

    @Override // org.apache.poi.java.awt.Component
    public String paramString() {
        return super.paramString() + ",current=" + getSelectedItem();
    }

    @Override // org.apache.poi.java.awt.Component
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
    }

    public void processItemEvent(ItemEvent itemEvent) {
        ItemListener itemListener = this.itemListener;
        if (itemListener != null) {
            itemListener.itemStateChanged(itemEvent);
        }
    }

    public void remove(int i) {
        synchronized (this) {
            removeNoInvalidate(i);
        }
        invalidateIfValid();
    }

    public void removeAll() {
        synchronized (this) {
            try {
                ChoicePeer choicePeer = this.peer;
                if (choicePeer != null) {
                    choicePeer.removeAll();
                }
                this.pItems.removeAllElements();
                this.selectedIndex = -1;
            } catch (Throwable th) {
                throw th;
            }
        }
        invalidateIfValid();
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized void removeItemListener(ItemListener itemListener) {
        if (itemListener == null) {
            return;
        }
        this.itemListener = AWTEventMulticaster.remove(this.itemListener, itemListener);
    }

    public synchronized void select(int i) {
        if (i >= this.pItems.size() || i < 0) {
            throw new IllegalArgumentException("illegal Choice item position: " + i);
        }
        if (this.pItems.size() > 0) {
            this.selectedIndex = i;
            ChoicePeer choicePeer = this.peer;
            if (choicePeer != null) {
                choicePeer.select(i);
            }
        }
    }

    public void remove(String str) {
        synchronized (this) {
            int iIndexOf = this.pItems.indexOf(str);
            if (iIndexOf < 0) {
                throw new IllegalArgumentException("item " + str + " not found in choice");
            }
            removeNoInvalidate(iIndexOf);
        }
        invalidateIfValid();
    }

    public synchronized void select(String str) {
        int iIndexOf = this.pItems.indexOf(str);
        if (iIndexOf >= 0) {
            select(iIndexOf);
        }
    }

    public class AccessibleAWTChoice extends Component.AccessibleAWTComponent implements AccessibleAction {
        private static final long serialVersionUID = 7175603582428509322L;

        public AccessibleAWTChoice() {
            super();
        }

        public boolean doAccessibleAction(int i) {
            return false;
        }

        public int getAccessibleActionCount() {
            return 0;
        }

        public String getAccessibleActionDescription(int i) {
            return null;
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.COMBO_BOX;
        }

        public AccessibleAction getAccessibleAction() {
            return this;
        }
    }
}
