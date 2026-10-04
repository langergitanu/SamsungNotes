package org.apache.poi.java.awt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import org.apache.poi.java.awt.TextComponent;
import org.apache.poi.java.awt.peer.TextAreaPeer;

/* JADX INFO: loaded from: classes10.dex */
public class TextArea extends TextComponent {
    public static final int SCROLLBARS_BOTH = 0;
    public static final int SCROLLBARS_HORIZONTAL_ONLY = 2;
    public static final int SCROLLBARS_NONE = 3;
    public static final int SCROLLBARS_VERTICAL_ONLY = 1;
    private static Set backwardTraversalKeys = null;
    private static final String base = "text";
    private static Set forwardTraversalKeys = null;
    private static int nameCounter = 0;
    private static final long serialVersionUID = 3692302836626095722L;
    int columns;
    int rows;
    private int scrollbarVisibility;
    private int textAreaSerializedDataVersion;

    public class AccessibleAWTTextArea extends TextComponent.AccessibleAWTTextComponent {
        private static final long serialVersionUID = 3472827823632144419L;

        public AccessibleAWTTextArea() {
            super();
        }

        @Override // org.apache.poi.java.awt.TextComponent.AccessibleAWTTextComponent, org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            accessibleStateSet.add(AccessibleState.MULTI_LINE);
            return accessibleStateSet;
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        forwardTraversalKeys = KeyboardFocusManager.initFocusTraversalKeysSet("ctrl TAB", new HashSet());
        backwardTraversalKeys = KeyboardFocusManager.initFocusTraversalKeysSet("ctrl shift TAB", new HashSet());
    }

    public TextArea() {
        this("", 0, 0, 0);
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.columns < 0) {
            this.columns = 0;
        }
        if (this.rows < 0) {
            this.rows = 0;
        }
        int i = this.scrollbarVisibility;
        if (i < 0 || i > 3) {
            this.scrollbarVisibility = 0;
        }
        if (this.textAreaSerializedDataVersion < 2) {
            setFocusTraversalKeys(0, forwardTraversalKeys);
            setFocusTraversalKeys(1, backwardTraversalKeys);
        }
    }

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createTextArea(this);
                }
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void append(String str) {
        appendText(str);
    }

    @Deprecated
    public synchronized void appendText(String str) {
        try {
            if (this.peer != null) {
                insertText(str, getText().length());
            } else {
                this.text += str;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (TextArea.class) {
            StringBuilder sb = new StringBuilder("text");
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTTextArea();
        }
        return this.accessibleContext;
    }

    public int getColumns() {
        return this.columns;
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getMinimumSize() {
        return minimumSize();
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getPreferredSize() {
        return preferredSize();
    }

    public int getRows() {
        return this.rows;
    }

    public int getScrollbarVisibility() {
        return this.scrollbarVisibility;
    }

    public void insert(String str, int i) {
        insertText(str, i);
    }

    @Deprecated
    public synchronized void insertText(String str, int i) {
        try {
            TextAreaPeer textAreaPeer = this.peer;
            if (textAreaPeer != null) {
                textAreaPeer.insert(str, i);
            } else {
                this.text = this.text.substring(0, i) + str + this.text.substring(i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Dimension minimumSize() {
        Dimension dimensionMinimumSize;
        int i;
        synchronized (getTreeLock()) {
            try {
                int i2 = this.rows;
                dimensionMinimumSize = (i2 <= 0 || (i = this.columns) <= 0) ? super.minimumSize() : minimumSize(i2, i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimensionMinimumSize;
    }

    @Override // org.apache.poi.java.awt.TextComponent, org.apache.poi.java.awt.Component
    public String paramString() {
        int i = this.scrollbarVisibility;
        return super.paramString() + ",rows=" + this.rows + ",columns=" + this.columns + ",scrollbarVisibility=" + (i != 0 ? i != 1 ? i != 2 ? i != 3 ? "invalid display policy" : "none" : "horizontal-only" : "vertical-only" : "both");
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Dimension preferredSize() {
        Dimension dimensionPreferredSize;
        int i;
        synchronized (getTreeLock()) {
            try {
                int i2 = this.rows;
                dimensionPreferredSize = (i2 <= 0 || (i = this.columns) <= 0) ? super.preferredSize() : preferredSize(i2, i);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimensionPreferredSize;
    }

    public void replaceRange(String str, int i, int i2) {
        replaceText(str, i, i2);
    }

    @Deprecated
    public synchronized void replaceText(String str, int i, int i2) {
        try {
            TextAreaPeer textAreaPeer = this.peer;
            if (textAreaPeer != null) {
                textAreaPeer.replaceRange(str, i, i2);
            } else {
                this.text = this.text.substring(0, i) + str + this.text.substring(i2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setColumns(int i) {
        int i2 = this.columns;
        if (i < 0) {
            throw new IllegalArgumentException("columns less than zero.");
        }
        if (i != i2) {
            this.columns = i;
            invalidate();
        }
    }

    public void setRows(int i) {
        int i2 = this.rows;
        if (i < 0) {
            throw new IllegalArgumentException("rows less than zero.");
        }
        if (i != i2) {
            this.rows = i;
            invalidate();
        }
    }

    public TextArea(int i, int i2) {
        this("", i, i2, 0);
    }

    public Dimension getMinimumSize(int i, int i2) {
        return minimumSize(i, i2);
    }

    public Dimension getPreferredSize(int i, int i2) {
        return preferredSize(i, i2);
    }

    @Deprecated
    public Dimension minimumSize(int i, int i2) {
        Dimension minimumSize;
        synchronized (getTreeLock()) {
            try {
                TextAreaPeer textAreaPeer = this.peer;
                minimumSize = textAreaPeer != null ? textAreaPeer.getMinimumSize(i, i2) : super.minimumSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return minimumSize;
    }

    @Deprecated
    public Dimension preferredSize(int i, int i2) {
        Dimension preferredSize;
        synchronized (getTreeLock()) {
            try {
                TextAreaPeer textAreaPeer = this.peer;
                preferredSize = textAreaPeer != null ? textAreaPeer.getPreferredSize(i, i2) : super.preferredSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return preferredSize;
    }

    public TextArea(String str) {
        this(str, 0, 0, 0);
    }

    public TextArea(String str, int i, int i2) {
        this(str, i, i2, 0);
    }

    public TextArea(String str, int i, int i2, int i4) {
        super(str);
        this.textAreaSerializedDataVersion = 2;
        this.rows = i < 0 ? 0 : i;
        this.columns = i2 < 0 ? 0 : i2;
        if (i4 < 0 || i4 > 3) {
            this.scrollbarVisibility = 0;
        } else {
            this.scrollbarVisibility = i4;
        }
        setFocusTraversalKeys(0, forwardTraversalKeys);
        setFocusTraversalKeys(1, backwardTraversalKeys);
    }
}
