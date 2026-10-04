package org.apache.poi.java.awt;

import androidx.compose.runtime.AbstractC1974b;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.peer.LabelPeer;

/* JADX INFO: loaded from: classes10.dex */
public class Label extends Component implements Accessible {
    public static final int CENTER = 1;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    private static final String base = "label";
    private static int nameCounter = 0;
    private static final long serialVersionUID = 3094126758329070636L;
    int alignment;
    String text;

    public class AccessibleAWTLabel extends Component.AccessibleAWTComponent {
        private static final long serialVersionUID = -3568967560160480438L;

        public AccessibleAWTLabel() {
            super();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public String getAccessibleName() {
            return this.accessibleName != null ? this.accessibleName : Label.this.getText() == null ? super.getAccessibleName() : Label.this.getText();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.LABEL;
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        nameCounter = 0;
    }

    public Label() {
        this("", 0);
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        GraphicsEnvironment.checkHeadless();
        objectInputStream.defaultReadObject();
    }

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createLabel(this);
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
        synchronized (Label.class) {
            StringBuilder sb = new StringBuilder("label");
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTLabel();
        }
        return this.accessibleContext;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public String getText() {
        return this.text;
    }

    @Override // org.apache.poi.java.awt.Component
    public String paramString() {
        int i = this.alignment;
        String str = i != 0 ? i != 1 ? i != 2 ? ",align=" : ",align=right" : ",align=center" : ",align=left";
        StringBuilder sb = new StringBuilder();
        AbstractC1974b.m1332y(sb, super.paramString(), str, ",text=");
        sb.append(this.text);
        return sb.toString();
    }

    public synchronized void setAlignment(int i) {
        try {
            if (i != 0 && i != 1 && i != 2) {
                throw new IllegalArgumentException("improper alignment: " + i);
            }
            this.alignment = i;
            LabelPeer labelPeer = this.peer;
            if (labelPeer != null) {
                labelPeer.setAlignment(i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setText(String str) {
        boolean z;
        synchronized (this) {
            try {
                String str2 = this.text;
                if (str == str2 || (str2 != null && str2.equals(str))) {
                    z = false;
                } else {
                    this.text = str;
                    LabelPeer labelPeer = this.peer;
                    if (labelPeer != null) {
                        labelPeer.setText(str);
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

    public Label(String str) {
        this(str, 0);
    }

    public Label(String str, int i) {
        this.alignment = 0;
        GraphicsEnvironment.checkHeadless();
        this.text = str;
        setAlignment(i);
    }
}
