package org.apache.poi.java.awt;

import androidx.compose.runtime.AbstractC1974b;
import java.beans.ConstructorProperties;
import java.beans.Transient;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import org.apache.poi.java.awt.Container;
import org.apache.poi.java.awt.event.AdjustmentEvent;
import org.apache.poi.java.awt.event.AdjustmentListener;
import org.apache.poi.java.awt.event.MouseWheelEvent;
import org.apache.poi.java.awt.peer.ScrollPanePeer;
import org.apache.poi.sun.awt.ScrollPaneWheelScroller;
import org.apache.poi.sun.awt.SunToolkit;

/* JADX INFO: loaded from: classes10.dex */
public class ScrollPane extends Container implements Accessible {
    public static final int SCROLLBARS_ALWAYS = 1;
    public static final int SCROLLBARS_AS_NEEDED = 0;
    public static final int SCROLLBARS_NEVER = 2;
    private static final String base = "scrollpane";
    private static final boolean defaultWheelScroll = true;
    private static int nameCounter = 0;
    private static final long serialVersionUID = 7956609840827222915L;
    private ScrollPaneAdjustable hAdjustable;
    private int scrollbarDisplayPolicy;
    private ScrollPaneAdjustable vAdjustable;
    private boolean wheelScrollingEnabled;

    public class AccessibleAWTScrollPane extends Container.AccessibleAWTContainer {
        private static final long serialVersionUID = 6100703663886637L;

        public AccessibleAWTScrollPane() {
            super();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.SCROLL_PANE;
        }
    }

    public class PeerFixer implements AdjustmentListener, Serializable {
        private static final long serialVersionUID = 1043664721353696630L;
        private ScrollPane scroller;

        public PeerFixer(ScrollPane scrollPane) {
            this.scroller = scrollPane;
        }

        public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
            Adjustable adjustable = adjustmentEvent.getAdjustable();
            int value = adjustmentEvent.getValue();
            ScrollPanePeer scrollPanePeer = this.scroller.peer;
            if (scrollPanePeer != null) {
                scrollPanePeer.setValue(adjustable, value);
            }
            Component component = this.scroller.getComponent(0);
            int orientation = adjustable.getOrientation();
            if (orientation == 0) {
                component.move(-value, component.getLocation().f10093y);
            } else {
                if (orientation != 1) {
                    throw new IllegalArgumentException("Illegal adjustable orientation");
                }
                component.move(component.getLocation().f10092x, -value);
            }
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        nameCounter = 0;
    }

    public ScrollPane() {
        this(0);
    }

    private void addToPanel(Component component, Object obj, int i) throws Throwable {
        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());
        panel.add(component);
        super.addImpl(panel, obj, i);
        validate();
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        GraphicsEnvironment.checkHeadless();
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        this.scrollbarDisplayPolicy = fields.get("scrollbarDisplayPolicy", 0);
        this.hAdjustable = (ScrollPaneAdjustable) fields.get("hAdjustable", (Object) null);
        this.vAdjustable = (ScrollPaneAdjustable) fields.get("vAdjustable", (Object) null);
        this.wheelScrollingEnabled = fields.get("wheelScrollingEnabled", true);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.apache.poi.java.awt.Container
    public final void addImpl(Component component, Object obj, int i) {
        synchronized (getTreeLock()) {
            try {
                if (getComponentCount() > 0) {
                    remove(0);
                }
                if (i > 0) {
                    throw new IllegalArgumentException("position greater than 0");
                }
                if (SunToolkit.isLightweightOrUnknown(component)) {
                    addToPanel(component, obj, i);
                } else {
                    super.addImpl(component, obj, i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void addNotify() {
        int value;
        synchronized (getTreeLock()) {
            try {
                int i = 0;
                if (getComponentCount() > 0) {
                    int value2 = this.vAdjustable.getValue();
                    value = this.hAdjustable.getValue();
                    this.vAdjustable.setValue(0);
                    this.hAdjustable.setValue(0);
                    i = value2;
                } else {
                    value = 0;
                }
                if (this.peer == null) {
                    this.peer = getToolkit().createScrollPane(this);
                }
                super.addNotify();
                if (getComponentCount() > 0) {
                    this.vAdjustable.setValue(i);
                    this.hAdjustable.setValue(value);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void autoProcessMouseWheel(MouseWheelEvent mouseWheelEvent) {
        processMouseWheelEvent(mouseWheelEvent);
    }

    public Dimension calculateChildSize() {
        Dimension size = getSize();
        Insets insets = getInsets();
        int i = size.width - (insets.left * 2);
        int i2 = size.height - (insets.top * 2);
        Dimension dimension = new Dimension(getComponent(0).getPreferredSize());
        int i4 = this.scrollbarDisplayPolicy;
        boolean z = true;
        if (i4 == 0) {
            boolean z2 = dimension.height > i2;
            z = dimension.width > i;
            z = z2;
        } else if (i4 == 1) {
            z = true;
        } else {
            z = false;
        }
        int vScrollbarWidth = getVScrollbarWidth();
        int hScrollbarHeight = getHScrollbarHeight();
        if (z) {
            i -= vScrollbarWidth;
        }
        if (z) {
            i2 -= hScrollbarHeight;
        }
        if (dimension.width < i) {
            dimension.width = i;
        }
        if (dimension.height < i2) {
            dimension.height = i2;
        }
        return dimension;
    }

    @Override // org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (ScrollPane.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void doLayout() {
        layout();
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean eventTypeEnabled(int i) {
        if (i == 507 && isWheelScrollingEnabled()) {
            return true;
        }
        return super.eventTypeEnabled(i);
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTScrollPane();
        }
        return this.accessibleContext;
    }

    public Adjustable getHAdjustable() {
        return this.hAdjustable;
    }

    public int getHScrollbarHeight() {
        ScrollPanePeer scrollPanePeer;
        if (this.scrollbarDisplayPolicy == 2 || (scrollPanePeer = this.peer) == null) {
            return 0;
        }
        return scrollPanePeer.getHScrollbarHeight();
    }

    @Transient
    public Point getScrollPosition() {
        Point point;
        synchronized (getTreeLock()) {
            try {
                if (getComponentCount() == 0) {
                    throw new NullPointerException("child is null");
                }
                point = new Point(this.hAdjustable.getValue(), this.vAdjustable.getValue());
            } catch (Throwable th) {
                throw th;
            }
        }
        return point;
    }

    public int getScrollbarDisplayPolicy() {
        return this.scrollbarDisplayPolicy;
    }

    public Adjustable getVAdjustable() {
        return this.vAdjustable;
    }

    public int getVScrollbarWidth() {
        ScrollPanePeer scrollPanePeer;
        if (this.scrollbarDisplayPolicy == 2 || (scrollPanePeer = this.peer) == null) {
            return 0;
        }
        return scrollPanePeer.getVScrollbarWidth();
    }

    public Dimension getViewportSize() {
        Insets insets = getInsets();
        return new Dimension((this.width - insets.right) - insets.left, (this.height - insets.top) - insets.bottom);
    }

    public boolean isWheelScrollingEnabled() {
        return this.wheelScrollingEnabled;
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    @Deprecated
    public void layout() {
        if (getComponentCount() == 0) {
            return;
        }
        Component component = getComponent(0);
        Point scrollPosition = getScrollPosition();
        Dimension dimensionCalculateChildSize = calculateChildSize();
        getViewportSize();
        Insets insets = getInsets();
        component.reshape(insets.left - scrollPosition.f10092x, insets.top - scrollPosition.f10093y, dimensionCalculateChildSize.width, dimensionCalculateChildSize.height);
        ScrollPanePeer scrollPanePeer = this.peer;
        if (scrollPanePeer != null) {
            scrollPanePeer.childResized(dimensionCalculateChildSize.width, dimensionCalculateChildSize.height);
        }
        Dimension viewportSize = getViewportSize();
        this.hAdjustable.setSpan(0, dimensionCalculateChildSize.width, viewportSize.width);
        this.vAdjustable.setSpan(0, dimensionCalculateChildSize.height, viewportSize.height);
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public String paramString() {
        int i = this.scrollbarDisplayPolicy;
        String str = i != 0 ? i != 1 ? i != 2 ? "invalid display policy" : "never" : "always" : "as-needed";
        Point scrollPosition = getComponentCount() > 0 ? getScrollPosition() : new Point(0, 0);
        Insets insets = getInsets();
        StringBuilder sb = new StringBuilder();
        sb.append(super.paramString());
        sb.append(",ScrollPosition=(");
        sb.append(scrollPosition.f10092x);
        sb.append(",");
        sb.append(scrollPosition.f10093y);
        sb.append("),Insets=(");
        sb.append(insets.top);
        sb.append(",");
        sb.append(insets.left);
        sb.append(",");
        sb.append(insets.bottom);
        sb.append(",");
        AbstractC1974b.m1331x(sb, insets.right, "),ScrollbarDisplayPolicy=", str, ",wheelScrollingEnabled=");
        sb.append(isWheelScrollingEnabled());
        return sb.toString();
    }

    @Override // org.apache.poi.java.awt.Container
    public void printComponents(Graphics graphics) {
        if (getComponentCount() == 0) {
            return;
        }
        Component component = getComponent(0);
        Point location = component.getLocation();
        Dimension viewportSize = getViewportSize();
        Insets insets = getInsets();
        Graphics graphicsCreate = graphics.create();
        try {
            graphicsCreate.clipRect(insets.left, insets.top, viewportSize.width, viewportSize.height);
            graphicsCreate.translate(location.f10092x, location.f10093y);
            component.printAll(graphicsCreate);
        } finally {
            graphicsCreate.dispose();
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void processMouseWheelEvent(MouseWheelEvent mouseWheelEvent) {
        if (isWheelScrollingEnabled()) {
            ScrollPaneWheelScroller.handleWheelScrolling(this, mouseWheelEvent);
            mouseWheelEvent.consume();
        }
        super.processMouseWheelEvent(mouseWheelEvent);
    }

    @Override // org.apache.poi.java.awt.Container
    public final void setLayout(LayoutManager layoutManager) {
        throw new AWTError("ScrollPane controls layout");
    }

    public void setScrollPosition(int i, int i2) {
        synchronized (getTreeLock()) {
            try {
                if (getComponentCount() == 0) {
                    throw new NullPointerException("child is null");
                }
                this.hAdjustable.setValue(i);
                this.vAdjustable.setValue(i2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setWheelScrollingEnabled(boolean z) {
        this.wheelScrollingEnabled = z;
    }

    @ConstructorProperties({"scrollbarDisplayPolicy"})
    public ScrollPane(int i) {
        this.wheelScrollingEnabled = true;
        GraphicsEnvironment.checkHeadless();
        this.layoutMgr = null;
        this.width = 100;
        this.height = 100;
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException("illegal scrollbar display policy");
        }
        this.scrollbarDisplayPolicy = i;
        this.vAdjustable = new ScrollPaneAdjustable(this, new PeerFixer(this), 1);
        this.hAdjustable = new ScrollPaneAdjustable(this, new PeerFixer(this), 0);
        setWheelScrollingEnabled(true);
    }

    public void setScrollPosition(Point point) {
        setScrollPosition(point.f10092x, point.f10093y);
    }
}
