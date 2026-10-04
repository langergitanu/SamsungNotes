package org.apache.poi.java.awt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EventListener;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import javax.accessibility.AccessibleValue;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.event.AdjustmentEvent;
import org.apache.poi.java.awt.event.AdjustmentListener;
import org.apache.poi.java.awt.peer.ScrollbarPeer;

/* JADX INFO: loaded from: classes10.dex */
public class Scrollbar extends Component implements Adjustable, Accessible {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private static final String base = "scrollbar";
    private static int nameCounter = 0;
    private static final long serialVersionUID = 8451667562882310543L;
    transient AdjustmentListener adjustmentListener;
    transient boolean isAdjusting;
    int lineIncrement;
    int maximum;
    int minimum;
    int orientation;
    int pageIncrement;
    private int scrollbarSerializedDataVersion;
    int value;
    int visibleAmount;

    static {
        Toolkit.loadLibraries();
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        initIDs();
    }

    public Scrollbar() {
        this(1, 0, 10, 0, 100);
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
            if ("adjustmentL" == ((String) object).intern()) {
                addAdjustmentListener((AdjustmentListener) objectInputStream.readObject());
            } else {
                objectInputStream.readObject();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        AWTEventMulticaster.save(objectOutputStream, "adjustmentL", this.adjustmentListener);
        objectOutputStream.writeObject(null);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public synchronized void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        if (adjustmentListener == null) {
            return;
        }
        this.adjustmentListener = AWTEventMulticaster.add(this.adjustmentListener, adjustmentListener);
        this.newEventsOnly = true;
    }

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createScrollbar(this);
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
        synchronized (Scrollbar.class) {
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
        return aWTEvent.f10031id == 601 ? ((this.eventMask & 256) == 0 && this.adjustmentListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTScrollBar();
        }
        return this.accessibleContext;
    }

    public synchronized AdjustmentListener[] getAdjustmentListeners() {
        return getListeners(AdjustmentListener.class);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getBlockIncrement() {
        return getPageIncrement();
    }

    @Deprecated
    public int getLineIncrement() {
        return this.lineIncrement;
    }

    @Override // org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return cls == AdjustmentListener.class ? (T[]) AWTEventMulticaster.getListeners(this.adjustmentListener, cls) : (T[]) super.getListeners(cls);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getMaximum() {
        return this.maximum;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getMinimum() {
        return this.minimum;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getOrientation() {
        return this.orientation;
    }

    @Deprecated
    public int getPageIncrement() {
        return this.pageIncrement;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getUnitIncrement() {
        return getLineIncrement();
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getValue() {
        return this.value;
    }

    public boolean getValueIsAdjusting() {
        return this.isAdjusting;
    }

    @Deprecated
    public int getVisible() {
        return this.visibleAmount;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getVisibleAmount() {
        return getVisible();
    }

    @Override // org.apache.poi.java.awt.Component
    public String paramString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.paramString());
        sb.append(",val=");
        sb.append(this.value);
        sb.append(",vis=");
        sb.append(this.visibleAmount);
        sb.append(",min=");
        sb.append(this.minimum);
        sb.append(",max=");
        sb.append(this.maximum);
        sb.append(this.orientation == 1 ? ",vert" : ",horz");
        sb.append(",isAdjusting=");
        sb.append(this.isAdjusting);
        return sb.toString();
    }

    public void processAdjustmentEvent(AdjustmentEvent adjustmentEvent) {
        AdjustmentListener adjustmentListener = this.adjustmentListener;
        if (adjustmentListener != null) {
            adjustmentListener.adjustmentValueChanged(adjustmentEvent);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public synchronized void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
        if (adjustmentListener == null) {
            return;
        }
        this.adjustmentListener = AWTEventMulticaster.remove(this.adjustmentListener, adjustmentListener);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setBlockIncrement(int i) {
        setPageIncrement(i);
    }

    @Deprecated
    public synchronized void setLineIncrement(int i) {
        if (i < 1) {
            i = 1;
        }
        if (this.lineIncrement == i) {
            return;
        }
        this.lineIncrement = i;
        ScrollbarPeer scrollbarPeer = this.peer;
        if (scrollbarPeer != null) {
            scrollbarPeer.setLineIncrement(i);
        }
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setMaximum(int i) {
        if (i == Integer.MIN_VALUE) {
            i = -2147483647;
        }
        if (this.minimum >= i) {
            this.minimum = i - 1;
        }
        setValues(this.value, this.visibleAmount, this.minimum, i);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setMinimum(int i) {
        setValues(this.value, this.visibleAmount, i, this.maximum);
    }

    public void setOrientation(int i) {
        synchronized (getTreeLock()) {
            try {
                if (i == this.orientation) {
                    return;
                }
                if (i != 0 && i != 1) {
                    throw new IllegalArgumentException("illegal scrollbar orientation");
                }
                this.orientation = i;
                if (this.peer != null) {
                    removeNotify();
                    addNotify();
                    invalidate();
                }
                AccessibleContext accessibleContext = this.accessibleContext;
                if (accessibleContext != null) {
                    accessibleContext.firePropertyChange("AccessibleState", i == 1 ? AccessibleState.HORIZONTAL : AccessibleState.VERTICAL, i == 1 ? AccessibleState.VERTICAL : AccessibleState.HORIZONTAL);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public synchronized void setPageIncrement(int i) {
        if (i < 1) {
            i = 1;
        }
        if (this.pageIncrement == i) {
            return;
        }
        this.pageIncrement = i;
        ScrollbarPeer scrollbarPeer = this.peer;
        if (scrollbarPeer != null) {
            scrollbarPeer.setPageIncrement(i);
        }
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setUnitIncrement(int i) {
        setLineIncrement(i);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setValue(int i) {
        setValues(i, this.visibleAmount, this.minimum, this.maximum);
    }

    public void setValueIsAdjusting(boolean z) {
        boolean z2;
        AccessibleContext accessibleContext;
        synchronized (this) {
            z2 = this.isAdjusting;
            this.isAdjusting = z;
        }
        if (z2 == z || (accessibleContext = this.accessibleContext) == null) {
            return;
        }
        accessibleContext.firePropertyChange("AccessibleState", z2 ? AccessibleState.BUSY : null, z ? AccessibleState.BUSY : null);
    }

    public void setValues(int i, int i2, int i4, int i5) {
        int i6;
        AccessibleContext accessibleContext;
        synchronized (this) {
            if (i4 == Integer.MAX_VALUE) {
                i4 = 2147483646;
            }
            if (i5 <= i4) {
                i5 = i4 + 1;
            }
            long j = ((long) i5) - ((long) i4);
            if (j > 2147483647L) {
                i5 = ((int) 2147483647L) + i4;
                j = 2147483647L;
            }
            int i7 = (int) j;
            if (i2 > i7) {
                i2 = i7;
            }
            if (i2 < 1) {
                i2 = 1;
            }
            if (i < i4) {
                i = i4;
            }
            int i8 = i5 - i2;
            if (i > i8) {
                i = i8;
            }
            try {
                i6 = this.value;
                this.value = i;
                this.visibleAmount = i2;
                this.minimum = i4;
                this.maximum = i5;
                ScrollbarPeer scrollbarPeer = this.peer;
                if (scrollbarPeer != null) {
                    scrollbarPeer.setValues(i, i2, i4, i5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i6 == i || (accessibleContext = this.accessibleContext) == null) {
            return;
        }
        accessibleContext.firePropertyChange("AccessibleValue", Integer.valueOf(i6), Integer.valueOf(i));
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setVisibleAmount(int i) {
        setValues(this.value, i, this.minimum, this.maximum);
    }

    public Scrollbar(int i) {
        this(i, 0, 10, 0, 100);
    }

    public Scrollbar(int i, int i2, int i4, int i5, int i6) {
        this.lineIncrement = 1;
        this.pageIncrement = 10;
        this.scrollbarSerializedDataVersion = 1;
        GraphicsEnvironment.checkHeadless();
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("illegal scrollbar orientation");
        }
        this.orientation = i;
        setValues(i2, i4, i5, i6);
    }

    public class AccessibleAWTScrollBar extends Component.AccessibleAWTComponent implements AccessibleValue {
        private static final long serialVersionUID = -344337268523697807L;

        public AccessibleAWTScrollBar() {
            super();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.SCROLL_BAR;
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            if (Scrollbar.this.getValueIsAdjusting()) {
                accessibleStateSet.add(AccessibleState.BUSY);
            }
            accessibleStateSet.add(Scrollbar.this.getOrientation() == 1 ? AccessibleState.VERTICAL : AccessibleState.HORIZONTAL);
            return accessibleStateSet;
        }

        public Number getCurrentAccessibleValue() {
            return Integer.valueOf(Scrollbar.this.getValue());
        }

        public Number getMaximumAccessibleValue() {
            return Integer.valueOf(Scrollbar.this.getMaximum());
        }

        public Number getMinimumAccessibleValue() {
            return Integer.valueOf(Scrollbar.this.getMinimum());
        }

        public boolean setCurrentAccessibleValue(Number number) {
            if (!(number instanceof Integer)) {
                return false;
            }
            Scrollbar.this.setValue(number.intValue());
            return true;
        }

        public AccessibleValue getAccessibleValue() {
            return this;
        }
    }
}
