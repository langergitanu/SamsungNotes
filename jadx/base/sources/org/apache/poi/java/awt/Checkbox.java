package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EventListener;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleAction;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import javax.accessibility.AccessibleValue;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.event.ItemEvent;
import org.apache.poi.java.awt.event.ItemListener;
import org.apache.poi.java.awt.peer.CheckboxPeer;

/* JADX INFO: loaded from: classes10.dex */
public class Checkbox extends Component implements ItemSelectable, Accessible {
    private static final String base = "checkbox";
    private static int nameCounter = 0;
    private static final long serialVersionUID = 7270714317450821763L;
    private int checkboxSerializedDataVersion;
    CheckboxGroup group;
    transient ItemListener itemListener;
    String label;
    boolean state;

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        nameCounter = 0;
    }

    public Checkbox() {
        this("", false, (CheckboxGroup) null);
    }

    private static native void initIDs();

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

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createCheckbox(this);
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
        synchronized (Checkbox.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean eventEnabled(AWTEvent aWTEvent) {
        return aWTEvent.f10031id == 701 ? ((this.eventMask & 512) == 0 && this.itemListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTCheckbox();
        }
        return this.accessibleContext;
    }

    public CheckboxGroup getCheckboxGroup() {
        return this.group;
    }

    public synchronized ItemListener[] getItemListeners() {
        return getListeners(ItemListener.class);
    }

    public String getLabel() {
        return this.label;
    }

    @Override // org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return cls == ItemListener.class ? (T[]) AWTEventMulticaster.getListeners(this.itemListener, cls) : (T[]) super.getListeners(cls);
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public Object[] getSelectedObjects() {
        if (this.state) {
            return new Object[]{this.label};
        }
        return null;
    }

    public boolean getState() {
        return this.state;
    }

    @Override // org.apache.poi.java.awt.Component
    public String paramString() {
        String strParamString = super.paramString();
        String str = this.label;
        if (str != null) {
            strParamString = AbstractC0541b.m757C(strParamString, ",label=", str);
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(strParamString, ",state=");
        sbM781w.append(this.state);
        return sbM781w.toString();
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

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized void removeItemListener(ItemListener itemListener) {
        if (itemListener == null) {
            return;
        }
        this.itemListener = AWTEventMulticaster.remove(this.itemListener, itemListener);
    }

    public void setCheckboxGroup(CheckboxGroup checkboxGroup) {
        CheckboxGroup checkboxGroup2;
        boolean state;
        if (this.group == checkboxGroup) {
            return;
        }
        synchronized (this) {
            try {
                checkboxGroup2 = this.group;
                state = getState();
                this.group = checkboxGroup;
                CheckboxPeer checkboxPeer = this.peer;
                if (checkboxPeer != null) {
                    checkboxPeer.setCheckboxGroup(checkboxGroup);
                }
                if (this.group != null && getState()) {
                    if (this.group.getSelectedCheckbox() != null) {
                        setState(false);
                    } else {
                        this.group.setSelectedCheckbox(this);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (checkboxGroup2 == null || !state) {
            return;
        }
        checkboxGroup2.setSelectedCheckbox(null);
    }

    public void setLabel(String str) {
        boolean z;
        synchronized (this) {
            try {
                String str2 = this.label;
                if (str == str2 || (str2 != null && str2.equals(str))) {
                    z = false;
                } else {
                    this.label = str;
                    CheckboxPeer checkboxPeer = this.peer;
                    if (checkboxPeer != null) {
                        checkboxPeer.setLabel(str);
                    }
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            invalidateIfValid();
        }
    }

    public void setState(boolean z) {
        CheckboxGroup checkboxGroup = this.group;
        if (checkboxGroup != null) {
            if (z) {
                checkboxGroup.setSelectedCheckbox(this);
            } else if (checkboxGroup.getSelectedCheckbox() == this) {
                z = true;
            }
        }
        setStateInternal(z);
    }

    public void setStateInternal(boolean z) {
        this.state = z;
        CheckboxPeer checkboxPeer = this.peer;
        if (checkboxPeer != null) {
            checkboxPeer.setState(z);
        }
    }

    public Checkbox(String str) {
        this(str, false, (CheckboxGroup) null);
    }

    public Checkbox(String str, CheckboxGroup checkboxGroup, boolean z) {
        this(str, z, checkboxGroup);
    }

    public Checkbox(String str, boolean z) {
        this(str, z, (CheckboxGroup) null);
    }

    public Checkbox(String str, boolean z, CheckboxGroup checkboxGroup) {
        this.checkboxSerializedDataVersion = 1;
        GraphicsEnvironment.checkHeadless();
        this.label = str;
        this.state = z;
        this.group = checkboxGroup;
        if (!z || checkboxGroup == null) {
            return;
        }
        checkboxGroup.setSelectedCheckbox(this);
    }

    public class AccessibleAWTCheckbox extends Component.AccessibleAWTComponent implements ItemListener, AccessibleAction, AccessibleValue {
        private static final long serialVersionUID = 7881579233144754107L;

        public AccessibleAWTCheckbox() {
            super();
            Checkbox.this.addItemListener(this);
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
            return AccessibleRole.CHECK_BOX;
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            if (Checkbox.this.getState()) {
                accessibleStateSet.add(AccessibleState.CHECKED);
            }
            return accessibleStateSet;
        }

        public Number getCurrentAccessibleValue() {
            return null;
        }

        public Number getMaximumAccessibleValue() {
            return null;
        }

        public Number getMinimumAccessibleValue() {
            return null;
        }

        public void itemStateChanged(ItemEvent itemEvent) {
            Checkbox checkbox = (Checkbox) itemEvent.getSource();
            if (Checkbox.this.accessibleContext != null) {
                if (checkbox.getState()) {
                    Checkbox.this.accessibleContext.firePropertyChange("AccessibleState", (Object) null, AccessibleState.CHECKED);
                } else {
                    Checkbox.this.accessibleContext.firePropertyChange("AccessibleState", AccessibleState.CHECKED, (Object) null);
                }
            }
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
}
