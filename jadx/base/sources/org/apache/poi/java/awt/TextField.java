package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EventListener;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import org.apache.poi.java.awt.TextComponent;
import org.apache.poi.java.awt.event.ActionEvent;
import org.apache.poi.java.awt.event.ActionListener;
import org.apache.poi.java.awt.peer.TextFieldPeer;

/* JADX INFO: loaded from: classes10.dex */
public class TextField extends TextComponent {
    private static final String base = "textfield";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -2966288784432217853L;
    transient ActionListener actionListener;
    int columns;
    char echoChar;
    private int textFieldSerializedDataVersion;

    public class AccessibleAWTTextField extends TextComponent.AccessibleAWTTextComponent {
        private static final long serialVersionUID = 6219164359235943158L;

        public AccessibleAWTTextField() {
            super();
        }

        @Override // org.apache.poi.java.awt.TextComponent.AccessibleAWTTextComponent, org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            accessibleStateSet.add(AccessibleState.SINGLE_LINE);
            return accessibleStateSet;
        }
    }

    static {
        Toolkit.loadLibraries();
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        initIDs();
    }

    public TextField() {
        this("", 0);
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.columns < 0) {
            this.columns = 0;
        }
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

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createTextField(this);
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
        synchronized (TextField.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    public boolean echoCharIsSet() {
        return this.echoChar != 0;
    }

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public boolean eventEnabled(AWTEvent aWTEvent) {
        return aWTEvent.f10031id == 1001 ? ((this.eventMask & 128) == 0 && this.actionListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTTextField();
        }
        return this.accessibleContext;
    }

    public synchronized ActionListener[] getActionListeners() {
        return getListeners(ActionListener.class);
    }

    public int getColumns() {
        return this.columns;
    }

    public char getEchoChar() {
        return this.echoChar;
    }

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return cls == ActionListener.class ? (T[]) AWTEventMulticaster.getListeners(this.actionListener, cls) : (T[]) super.getListeners(cls);
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getMinimumSize() {
        return minimumSize();
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getPreferredSize() {
        return preferredSize();
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Dimension minimumSize() {
        Dimension dimensionMinimumSize;
        synchronized (getTreeLock()) {
            try {
                int i = this.columns;
                dimensionMinimumSize = i > 0 ? minimumSize(i) : super.minimumSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimensionMinimumSize;
    }

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public String paramString() {
        String strParamString = super.paramString();
        if (this.echoChar == 0) {
            return strParamString;
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(strParamString, ",echo=");
        sbM781w.append(this.echoChar);
        return sbM781w.toString();
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Dimension preferredSize() {
        Dimension dimensionPreferredSize;
        synchronized (getTreeLock()) {
            try {
                int i = this.columns;
                dimensionPreferredSize = i > 0 ? preferredSize(i) : super.preferredSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimensionPreferredSize;
    }

    public void processActionEvent(ActionEvent actionEvent) {
        ActionListener actionListener = this.actionListener;
        if (actionListener != null) {
            actionListener.actionPerformed(actionEvent);
        }
    }

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
    }

    public synchronized void removeActionListener(ActionListener actionListener) {
        if (actionListener == null) {
            return;
        }
        this.actionListener = AWTEventMulticaster.remove(this.actionListener, actionListener);
    }

    public void setColumns(int i) {
        int i2;
        synchronized (this) {
            try {
                i2 = this.columns;
                if (i < 0) {
                    throw new IllegalArgumentException("columns less than zero.");
                }
                if (i != i2) {
                    this.columns = i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i != i2) {
            invalidate();
        }
    }

    public void setEchoChar(char c) {
        setEchoCharacter(c);
    }

    @Deprecated
    public synchronized void setEchoCharacter(char c) {
        if (this.echoChar != c) {
            this.echoChar = c;
            TextFieldPeer textFieldPeer = this.peer;
            if (textFieldPeer != null) {
                textFieldPeer.setEchoChar(c);
            }
        }
    }

    @Override // org.apache.poi.java.awt.TextComponent
    public void setText(String str) {
        super.setText(str);
        invalidateIfValid();
    }

    public TextField(int i) {
        this("", i);
    }

    public Dimension getMinimumSize(int i) {
        return minimumSize(i);
    }

    public Dimension getPreferredSize(int i) {
        return preferredSize(i);
    }

    @Deprecated
    public Dimension minimumSize(int i) {
        Dimension minimumSize;
        synchronized (getTreeLock()) {
            try {
                TextFieldPeer textFieldPeer = this.peer;
                minimumSize = textFieldPeer != null ? textFieldPeer.getMinimumSize(i) : super.minimumSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return minimumSize;
    }

    @Deprecated
    public Dimension preferredSize(int i) {
        Dimension preferredSize;
        synchronized (getTreeLock()) {
            try {
                TextFieldPeer textFieldPeer = this.peer;
                preferredSize = textFieldPeer != null ? textFieldPeer.getPreferredSize(i) : super.preferredSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return preferredSize;
    }

    public TextField(String str) {
        this(str, str != null ? str.length() : 0);
    }

    public TextField(String str, int i) {
        super(str);
        this.textFieldSerializedDataVersion = 1;
        this.columns = i < 0 ? 0 : i;
    }
}
