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
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.event.ActionEvent;
import org.apache.poi.java.awt.event.ActionListener;
import org.apache.poi.java.awt.peer.ButtonPeer;

/* JADX INFO: loaded from: classes10.dex */
public class Button extends Component implements Accessible {
    private static final String base = "button";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -8774683716313001058L;
    String actionCommand;
    transient ActionListener actionListener;
    private int buttonSerializedDataVersion;
    String label;

    static {
        Toolkit.loadLibraries();
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        initIDs();
    }

    public Button() {
        this("");
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

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createButton(this);
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
        synchronized (Button.class) {
            StringBuilder sb = new StringBuilder("button");
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean eventEnabled(AWTEvent aWTEvent) {
        return aWTEvent.f10031id == 1001 ? ((this.eventMask & 128) == 0 && this.actionListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTButton();
        }
        return this.accessibleContext;
    }

    public String getActionCommand() {
        String str = this.actionCommand;
        return str == null ? this.label : str;
    }

    public synchronized ActionListener[] getActionListeners() {
        return getListeners(ActionListener.class);
    }

    public String getLabel() {
        return this.label;
    }

    @Override // org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return cls == ActionListener.class ? (T[]) AWTEventMulticaster.getListeners(this.actionListener, cls) : (T[]) super.getListeners(cls);
    }

    @Override // org.apache.poi.java.awt.Component
    public String paramString() {
        return super.paramString() + ",label=" + this.label;
    }

    public void processActionEvent(ActionEvent actionEvent) {
        ActionListener actionListener = this.actionListener;
        if (actionListener != null) {
            actionListener.actionPerformed(actionEvent);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
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

    public void setLabel(String str) {
        boolean z;
        synchronized (this) {
            try {
                String str2 = this.label;
                if (str == str2 || (str2 != null && str2.equals(str))) {
                    z = false;
                } else {
                    this.label = str;
                    ButtonPeer buttonPeer = this.peer;
                    if (buttonPeer != null) {
                        buttonPeer.setLabel(str);
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

    public Button(String str) {
        this.buttonSerializedDataVersion = 1;
        GraphicsEnvironment.checkHeadless();
        this.label = str;
    }

    public class AccessibleAWTButton extends Component.AccessibleAWTComponent implements AccessibleAction, AccessibleValue {
        private static final long serialVersionUID = -5932203980244017102L;

        public AccessibleAWTButton() {
            super();
        }

        public boolean doAccessibleAction(int i) {
            if (i != 0) {
                return false;
            }
            EventQueue eventQueue = Toolkit.getEventQueue();
            Button button = Button.this;
            eventQueue.postEvent(new ActionEvent(button, 1001, button.getActionCommand()));
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

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public String getAccessibleName() {
            return this.accessibleName != null ? this.accessibleName : Button.this.getLabel() == null ? super.getAccessibleName() : Button.this.getLabel();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.PUSH_BUTTON;
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
}
