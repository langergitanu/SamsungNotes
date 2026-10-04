package org.apache.poi.java.awt;

import java.io.Serializable;
import org.apache.poi.java.awt.event.AdjustmentEvent;
import org.apache.poi.java.awt.event.AdjustmentListener;
import org.apache.poi.java.awt.peer.ScrollPanePeer;
import org.apache.poi.sun.awt.AWTAccessor;

/* JADX INFO: loaded from: classes10.dex */
public class ScrollPaneAdjustable implements Adjustable, Serializable {
    private static final String SCROLLPANE_ONLY = "Can be set by scrollpane only";
    private static final long serialVersionUID = -3359745691033257079L;
    private AdjustmentListener adjustmentListener;
    private transient boolean isAdjusting;
    private int maximum;
    private int minimum;
    private int orientation;

    /* JADX INFO: renamed from: sp */
    private ScrollPane f10096sp;
    private int value;
    private int visibleAmount;
    private int unitIncrement = 1;
    private int blockIncrement = 1;

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setScrollPaneAdjustableAccessor(new AWTAccessor.ScrollPaneAdjustableAccessor() { // from class: org.apache.poi.java.awt.ScrollPaneAdjustable.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.ScrollPaneAdjustableAccessor
            public void setTypedValue(ScrollPaneAdjustable scrollPaneAdjustable, int i, int i2) {
                scrollPaneAdjustable.setTypedValue(i, i2);
            }
        });
    }

    public ScrollPaneAdjustable(ScrollPane scrollPane, AdjustmentListener adjustmentListener, int i) {
        this.f10096sp = scrollPane;
        this.orientation = i;
        addAdjustmentListener(adjustmentListener);
    }

    private static native void initIDs();

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypedValue(int i, int i2) {
        int iMin = Math.min(Math.max(i, this.minimum), this.maximum - this.visibleAmount);
        if (iMin != this.value) {
            this.value = iMin;
            this.adjustmentListener.adjustmentValueChanged(new AdjustmentEvent(this, 601, i2, this.value, this.isAdjusting));
        }
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public synchronized void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        if (adjustmentListener == null) {
            return;
        }
        this.adjustmentListener = AWTEventMulticaster.add(this.adjustmentListener, adjustmentListener);
    }

    public synchronized AdjustmentListener[] getAdjustmentListeners() {
        return AWTEventMulticaster.getListeners(this.adjustmentListener, AdjustmentListener.class);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getBlockIncrement() {
        return this.blockIncrement;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getMaximum() {
        return this.maximum;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getMinimum() {
        return 0;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getOrientation() {
        return this.orientation;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getUnitIncrement() {
        return this.unitIncrement;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getValue() {
        return this.value;
    }

    public boolean getValueIsAdjusting() {
        return this.isAdjusting;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public int getVisibleAmount() {
        return this.visibleAmount;
    }

    public String paramString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.orientation == 1 ? "vertical," : "horizontal,");
        sb.append("[0..");
        sb.append(this.maximum);
        sb.append("],val=");
        sb.append(this.value);
        sb.append(",vis=");
        sb.append(this.visibleAmount);
        sb.append(",unit=");
        sb.append(this.unitIncrement);
        sb.append(",block=");
        sb.append(this.blockIncrement);
        sb.append(",isAdjusting=");
        sb.append(this.isAdjusting);
        return sb.toString();
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public synchronized void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
        if (adjustmentListener == null) {
            return;
        }
        this.adjustmentListener = AWTEventMulticaster.remove(this.adjustmentListener, adjustmentListener);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public synchronized void setBlockIncrement(int i) {
        this.blockIncrement = i;
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setMaximum(int i) {
        throw new AWTError(SCROLLPANE_ONLY);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setMinimum(int i) {
        throw new AWTError(SCROLLPANE_ONLY);
    }

    public void setSpan(int i, int i2, int i4) {
        this.minimum = i;
        int iMax = Math.max(i2, i + 1);
        this.maximum = iMax;
        int iMin = Math.min(i4, iMax - this.minimum);
        this.visibleAmount = iMin;
        this.visibleAmount = Math.max(iMin, 1);
        this.blockIncrement = Math.max((int) (((double) i4) * 0.9d), 1);
        setValue(this.value);
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public synchronized void setUnitIncrement(int i) {
        if (i != this.unitIncrement) {
            this.unitIncrement = i;
            ScrollPanePeer scrollPanePeer = this.f10096sp.peer;
            if (scrollPanePeer != null) {
                scrollPanePeer.setUnitIncrement(this, i);
            }
        }
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setValue(int i) {
        setTypedValue(i, 5);
    }

    public void setValueIsAdjusting(boolean z) {
        if (this.isAdjusting != z) {
            this.isAdjusting = z;
            this.adjustmentListener.adjustmentValueChanged(new AdjustmentEvent(this, 601, 5, this.value, z));
        }
    }

    @Override // org.apache.poi.java.awt.Adjustable
    public void setVisibleAmount(int i) {
        throw new AWTError(SCROLLPANE_ONLY);
    }

    public String toString() {
        return getClass().getName() + "[" + paramString() + "]";
    }
}
