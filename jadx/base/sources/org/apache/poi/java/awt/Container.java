package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.OptionalDataException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleComponent;
import javax.accessibility.AccessibleContext;
import javax.swing.JInternalFrame;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.GraphicsCallback;
import org.apache.poi.java.awt.dnd.DropTarget;
import org.apache.poi.java.awt.event.ContainerEvent;
import org.apache.poi.java.awt.event.ContainerListener;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.java.awt.peer.ContainerPeer;
import org.apache.poi.java.awt.peer.LightweightPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.CausedFocusEvent;
import org.apache.poi.sun.awt.PeerEvent;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.java2d.pipe.Region;
import org.apache.poi.sun.security.action.GetBooleanAction;
import org.apache.poi.sun.util.logging.PlatformLogger;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public class Container extends Component {
    static final boolean INCLUDE_SELF = true;
    static final boolean SEARCH_HEAVYWEIGHTS = true;
    private static boolean descendUnconditionallyWhenValidating = false;
    private static final boolean isJavaAwtSmartInvalidate;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 4613797578919906343L;
    transient ContainerListener containerListener;
    transient int descendantsCount;
    private LightweightDispatcher dispatcher;
    private transient FocusTraversalPolicy focusTraversalPolicy;
    private boolean focusTraversalPolicyProvider;
    LayoutManager layoutMgr;
    transient int listeningBoundsChildren;
    transient int listeningChildren;
    transient AppContext modalAppContext;
    transient Component modalComp;
    private transient Set printingThreads;
    private static final PlatformLogger log = PlatformLogger.getLogger("org.apache.poi.java.awt.Container");
    private static final PlatformLogger eventLog = PlatformLogger.getLogger("org.apache.poi.java.awt.event.Container");
    private static final Component[] EMPTY_ARRAY = new Component[0];
    private static final PlatformLogger mixingLog = PlatformLogger.getLogger("org.apache.poi.java.awt.mixing.Container");
    private java.util.List<Component> component = new ArrayList();
    private boolean focusCycleRoot = false;
    private transient boolean printing = false;
    transient Color preserveBackgroundColor = null;
    private transient int numOfHWComponents = 0;
    private transient int numOfLWComponents = 0;
    private int containerSerializedDataVersion = 1;

    public class AccessibleAWTContainer extends Component.AccessibleAWTComponent {
        private static final long serialVersionUID = 5081320404842566097L;
        protected ContainerListener accessibleContainerHandler;

        public class AccessibleContainerHandler implements ContainerListener {
            public AccessibleContainerHandler() {
            }

            public void componentAdded(ContainerEvent containerEvent) {
                Accessible child = containerEvent.getChild();
                if (child == null || !(child instanceof Accessible)) {
                    return;
                }
                AccessibleAWTContainer.this.firePropertyChange("AccessibleChild", null, child.getAccessibleContext());
            }

            public void componentRemoved(ContainerEvent containerEvent) {
                Accessible child = containerEvent.getChild();
                if (child == null || !(child instanceof Accessible)) {
                    return;
                }
                AccessibleAWTContainer.this.firePropertyChange("AccessibleChild", child.getAccessibleContext(), null);
            }
        }

        public AccessibleAWTContainer() {
            super();
            this.accessibleContainerHandler = null;
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
            if (this.accessibleContainerHandler == null) {
                AccessibleContainerHandler accessibleContainerHandler = new AccessibleContainerHandler();
                this.accessibleContainerHandler = accessibleContainerHandler;
                Container.this.addContainerListener(accessibleContainerHandler);
            }
            super.addPropertyChangeListener(propertyChangeListener);
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public Accessible getAccessibleAt(Point point) {
            return Container.this.getAccessibleAt(point);
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public Accessible getAccessibleChild(int i) {
            return Container.this.getAccessibleChild(i);
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public int getAccessibleChildrenCount() {
            return Container.this.getAccessibleChildrenCount();
        }
    }

    public static class DropTargetEventTargetFilter implements EventTargetFilter {
        static final EventTargetFilter FILTER = new DropTargetEventTargetFilter();

        private DropTargetEventTargetFilter() {
        }

        @Override // org.apache.poi.java.awt.Container.EventTargetFilter
        public boolean accept(Component component) {
            DropTarget dropTarget = component.getDropTarget();
            return dropTarget != null && dropTarget.isActive();
        }
    }

    public interface EventTargetFilter {
        boolean accept(Component component);
    }

    public static class MouseEventTargetFilter implements EventTargetFilter {
        static final EventTargetFilter FILTER = new MouseEventTargetFilter();

        private MouseEventTargetFilter() {
        }

        @Override // org.apache.poi.java.awt.Container.EventTargetFilter
        public boolean accept(Component component) {
            long j = component.eventMask;
            return ((32 & j) == 0 && (16 & j) == 0 && (j & 131072) == 0 && component.mouseListener == null && component.mouseMotionListener == null && component.mouseWheelListener == null) ? false : true;
        }
    }

    static {
        Class cls = Integer.TYPE;
        ObjectStreamField objectStreamField = new ObjectStreamField("ncomponents", cls);
        ObjectStreamField objectStreamField2 = new ObjectStreamField("component", Component[].class);
        ObjectStreamField objectStreamField3 = new ObjectStreamField("layoutMgr", LayoutManager.class);
        ObjectStreamField objectStreamField4 = new ObjectStreamField("dispatcher", LightweightDispatcher.class);
        ObjectStreamField objectStreamField5 = new ObjectStreamField("maxSize", Dimension.class);
        Class cls2 = Boolean.TYPE;
        serialPersistentFields = new ObjectStreamField[]{objectStreamField, objectStreamField2, objectStreamField3, objectStreamField4, objectStreamField5, new ObjectStreamField("focusCycleRoot", cls2), new ObjectStreamField("containerSerializedDataVersion", cls), new ObjectStreamField("focusTraversalPolicyProvider", cls2)};
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setContainerAccessor(new AWTAccessor.ContainerAccessor() { // from class: org.apache.poi.java.awt.Container.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.ContainerAccessor
            public void validateUnconditionally(Container container) {
                container.validateUnconditionally();
            }
        });
        isJavaAwtSmartInvalidate = ((Boolean) AccessController.doPrivileged(new GetBooleanAction("org.apache.poi.java.awt.smartInvalidate"))).booleanValue();
        descendUnconditionallyWhenValidating = false;
    }

    private void addDelicately(Component component, Container container, int i) throws Throwable {
        Component focusOwner;
        checkTreeLock();
        if (container != this) {
            if (i == -1) {
                this.component.add(component);
            } else {
                this.component.add(i, component);
            }
            component.parent = this;
            component.setGraphicsConfiguration(getGraphicsConfiguration());
            adjustListeningChildren(32768L, component.numListening(32768L));
            adjustListeningChildren(65536L, component.numListening(65536L));
            adjustDescendants(component.countHierarchyMembers());
        } else if (i < this.component.size()) {
            this.component.set(i, component);
        }
        invalidateIfValid();
        if (this.peer != null) {
            if (component.peer == null) {
                component.addNotify();
            } else {
                Container heavyweightContainer = getHeavyweightContainer();
                if (container.getHeavyweightContainer() != heavyweightContainer) {
                    heavyweightContainer.reparentChild(component);
                }
                component.updateZOrder();
                if (!component.isLightweight() && isLightweight()) {
                    component.relocateComponent();
                }
            }
        }
        if (container != this) {
            LayoutManager layoutManager = this.layoutMgr;
            if (layoutManager != null) {
                if (layoutManager instanceof LayoutManager2) {
                    ((LayoutManager2) layoutManager).addLayoutComponent(component, (Object) null);
                } else {
                    layoutManager.addLayoutComponent(null, component);
                }
            }
            if (this.containerListener != null || (this.eventMask & 2) != 0 || Toolkit.enabledOnToolkit(2L)) {
                dispatchEvent(new ContainerEvent(this, 300, component));
            }
            component.createHierarchyEvents(1400, component, this, 1L, Toolkit.enabledOnToolkit(32768L));
            if (component.isFocusOwner() && !component.canBeFocusOwnerRecursively()) {
                component.transferFocus();
            } else if ((component instanceof Container) && (focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner()) != null && isParentOf(focusOwner) && !focusOwner.canBeFocusOwnerRecursively()) {
                focusOwner.transferFocus();
            }
        } else {
            component.createHierarchyEvents(1400, component, this, 1400L, Toolkit.enabledOnToolkit(32768L));
        }
        if (this.peer != null && this.layoutMgr == null && isVisible()) {
            updateCursorImmediately();
        }
    }

    private void checkAddToSelf(Component component) {
        if (component instanceof Container) {
            for (Container container = this; container != null; container = container.parent) {
                if (container == component) {
                    throw new IllegalArgumentException("adding container's parent to itself");
                }
            }
        }
    }

    private void checkAdding(Component component, int i) {
        checkTreeLock();
        GraphicsConfiguration graphicsConfiguration = getGraphicsConfiguration();
        if (i > this.component.size() || i < 0) {
            throw new IllegalArgumentException("illegal component position");
        }
        if (component.parent == this && i == this.component.size()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "illegal component position ", " should be less then ");
            sbM778t.append(this.component.size());
            throw new IllegalArgumentException(sbM778t.toString());
        }
        checkAddToSelf(component);
        checkNotAWindow(component);
        if (getContainingWindow() != component.getContainingWindow()) {
            throw new IllegalArgumentException("component and container should be in the same top-level window");
        }
        if (graphicsConfiguration != null) {
            component.checkGD(graphicsConfiguration.getDevice().getIDstring());
        }
    }

    private void checkNotAWindow(Component component) {
        if (component instanceof Window) {
            throw new IllegalArgumentException("adding a window to a container");
        }
    }

    private Container findTraversalRoot() {
        Container focusCycleRootAncestor;
        Container currentFocusCycleRoot = KeyboardFocusManager.getCurrentKeyboardFocusManager().getCurrentFocusCycleRoot();
        if (currentFocusCycleRoot == this || (focusCycleRootAncestor = getFocusCycleRootAncestor()) == null) {
            focusCycleRootAncestor = this;
        }
        if (focusCycleRootAncestor != currentFocusCycleRoot) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().setGlobalCurrentFocusCycleRoot(focusCycleRootAncestor);
        }
        return focusCycleRootAncestor;
    }

    private int getBottommostComponentIndex() {
        checkTreeLock();
        if (getComponentCount() > 0) {
            return getComponentCount() - 1;
        }
        return -1;
    }

    private int getListenersCount(int i, boolean z) {
        checkTreeLock();
        if (z) {
            return this.descendantsCount;
        }
        switch (i) {
            case 1400:
                return this.listeningChildren;
            case 1401:
            case 1402:
                return this.listeningBoundsChildren;
            default:
                return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:5:0x0007, B:7:0x000f, B:9:0x0019, B:12:0x001f, B:20:0x0030, B:22:0x003e, B:24:0x0042, B:29:0x005c, B:27:0x0056, B:18:0x002a, B:31:0x005e, B:32:0x0061, B:36:0x006a, B:39:0x0072, B:41:0x0078, B:44:0x007b), top: B:48:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Component getMouseEventTargetImpl(int i, int i2, boolean z, EventTargetFilter eventTargetFilter, boolean z2, boolean z3) {
        synchronized (getTreeLock()) {
            for (int i4 = 0; i4 < this.component.size(); i4++) {
                try {
                    Component mouseEventTarget = this.component.get(i4);
                    if (mouseEventTarget != null && mouseEventTarget.visible) {
                        if (z2 || !(mouseEventTarget.peer instanceof LightweightPeer)) {
                            if (z2 && !(mouseEventTarget.peer instanceof LightweightPeer)) {
                                if (!mouseEventTarget.contains(i - mouseEventTarget.f10034x, i2 - mouseEventTarget.f10035y)) {
                                    continue;
                                } else if (mouseEventTarget instanceof Container) {
                                    Container container = (Container) mouseEventTarget;
                                    mouseEventTarget = container.getMouseEventTarget(i - container.f10034x, i2 - container.f10035y, z, eventTargetFilter, z3);
                                    if (mouseEventTarget != null) {
                                        return mouseEventTarget;
                                    }
                                } else if (eventTargetFilter.accept(mouseEventTarget)) {
                                    return mouseEventTarget;
                                }
                            }
                        }
                    }
                } finally {
                }
            }
            boolean z4 = (this.peer instanceof LightweightPeer) || z;
            if (contains(i, i2) && z4 && eventTargetFilter.accept(this)) {
                return this;
            }
            return null;
        }
    }

    private int getTopmostComponentIndex() {
        checkTreeLock();
        return getComponentCount() > 0 ? 0 : -1;
    }

    private static native void initIDs();

    private boolean isParentOf(Component component) {
        boolean z;
        synchronized (getTreeLock()) {
            while (component != null && component != this) {
                try {
                    if (component instanceof Window) {
                        break;
                    }
                    component = component.getParent();
                } finally {
                }
            }
            z = component == this;
        }
        return z;
    }

    private static boolean isRemoveNotifyNeeded(Component component, Container container, Container container2) {
        boolean z;
        if (container == null || component.peer == null) {
            return false;
        }
        if (container2.peer == null) {
            return true;
        }
        if ((!component.isLightweight() || (((z = component instanceof Container)) && (!z || ((Container) component).hasHeavyweightDescendants()))) && container.getHeavyweightContainer() != container2.getHeavyweightContainer()) {
            return !component.peer.isReparentSupported();
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        Component[] componentArr = (Component[]) fields.get("component", EMPTY_ARRAY);
        int i = fields.get("ncomponents", 0);
        this.component = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.component.add(componentArr[i2]);
        }
        this.layoutMgr = (LayoutManager) fields.get("layoutMgr", (Object) null);
        this.dispatcher = (LightweightDispatcher) fields.get("dispatcher", (Object) null);
        if (this.maxSize == null) {
            this.maxSize = (Dimension) fields.get("maxSize", (Object) null);
        }
        this.focusCycleRoot = fields.get("focusCycleRoot", false);
        this.containerSerializedDataVersion = fields.get("containerSerializedDataVersion", 1);
        this.focusTraversalPolicyProvider = fields.get("focusTraversalPolicyProvider", false);
        for (Component component : this.component) {
            component.parent = this;
            adjustListeningChildren(32768L, component.numListening(32768L));
            adjustListeningChildren(65536L, component.numListening(65536L));
            adjustDescendants(component.countHierarchyMembers());
        }
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                try {
                    break;
                } catch (OptionalDataException e) {
                    if (!e.eof) {
                        throw e;
                    }
                    return;
                }
            }
            if ("containerL" == ((String) object).intern()) {
                addContainerListener((ContainerListener) objectInputStream.readObject());
            } else {
                objectInputStream.readObject();
            }
        }
        Object object2 = objectInputStream.readObject();
        if (object2 instanceof FocusTraversalPolicy) {
            this.focusTraversalPolicy = (FocusTraversalPolicy) object2;
        }
    }

    private void recursiveHideHeavyweightChildren() {
        ComponentPeer peer;
        if (hasHeavyweightDescendants()) {
            for (int i = 0; i < getComponentCount(); i++) {
                Component component = getComponent(i);
                if (component.isLightweight()) {
                    if (component instanceof Container) {
                        ((Container) component).recursiveHideHeavyweightChildren();
                    }
                } else if (component.isVisible() && (peer = component.getPeer()) != null) {
                    peer.setVisible(false);
                }
            }
        }
    }

    private void recursiveRelocateHeavyweightChildren(Point point) {
        for (int i = 0; i < getComponentCount(); i++) {
            Component component = getComponent(i);
            if (!component.isLightweight()) {
                ComponentPeer peer = component.getPeer();
                if (peer != null) {
                    peer.setBounds(component.getX() + point.f10092x, component.getY() + point.f10093y, component.getWidth(), component.getHeight(), 1);
                }
            } else if (component instanceof Container) {
                Container container = (Container) component;
                if (container.hasHeavyweightDescendants()) {
                    Point point2 = new Point(point);
                    point2.translate(component.getX(), component.getY());
                    container.recursiveRelocateHeavyweightChildren(point2);
                }
            }
        }
    }

    private void recursiveShowHeavyweightChildren() {
        ComponentPeer peer;
        if (hasHeavyweightDescendants() && isVisible()) {
            for (int i = 0; i < getComponentCount(); i++) {
                Component component = getComponent(i);
                if (component.isLightweight()) {
                    if (component instanceof Container) {
                        ((Container) component).recursiveShowHeavyweightChildren();
                    }
                } else if (component.isVisible() && (peer = component.getPeer()) != null) {
                    peer.setVisible(true);
                }
            }
        }
    }

    private boolean removeDelicately(Component component, Container container, int i) throws Throwable {
        checkTreeLock();
        int componentZOrder = getComponentZOrder(component);
        boolean zIsRemoveNotifyNeeded = isRemoveNotifyNeeded(component, this, container);
        if (zIsRemoveNotifyNeeded) {
            component.removeNotify();
        }
        if (container != this) {
            LayoutManager layoutManager = this.layoutMgr;
            if (layoutManager != null) {
                layoutManager.removeLayoutComponent(component);
            }
            adjustListeningChildren(32768L, -component.numListening(32768L));
            adjustListeningChildren(65536L, -component.numListening(65536L));
            adjustDescendants(-component.countHierarchyMembers());
            component.parent = null;
            if (zIsRemoveNotifyNeeded) {
                component.setGraphicsConfiguration(null);
            }
            this.component.remove(componentZOrder);
            invalidateIfValid();
        } else {
            this.component.remove(componentZOrder);
            this.component.add(i, component);
        }
        if (component.parent == null) {
            if (this.containerListener != null || (this.eventMask & 2) != 0 || Toolkit.enabledOnToolkit(2L)) {
                dispatchEvent(new ContainerEvent(this, 301, component));
            }
            component.createHierarchyEvents(1400, component, this, 1L, Toolkit.enabledOnToolkit(32768L));
            if (this.peer != null && this.layoutMgr == null && isVisible()) {
                updateCursorImmediately();
                return zIsRemoveNotifyNeeded;
            }
        }
        return zIsRemoveNotifyNeeded;
    }

    private void reparentChild(Component component) {
        checkTreeLock();
        if (component == null) {
            return;
        }
        if (!component.isLightweight()) {
            component.getPeer().reparent(getPeer());
        } else if (component instanceof Container) {
            reparentTraverse((ContainerPeer) getPeer(), (Container) component);
        }
    }

    private void reparentTraverse(ContainerPeer containerPeer, Container container) {
        checkTreeLock();
        for (int i = 0; i < container.getComponentCount(); i++) {
            Component component = container.getComponent(i);
            if (!component.isLightweight()) {
                component.getPeer().reparent(containerPeer);
            } else if (component instanceof Container) {
                reparentTraverse(containerPeer, (Container) component);
            }
        }
    }

    private void startLWModal() {
        this.modalAppContext = AppContext.getAppContext();
        Toolkit.getEventQueue();
        long mostRecentEventTime = EventQueue.getMostRecentEventTime();
        Component mostRecentFocusOwner = Component.isInstanceOf(this, "javax.swing.JInternalFrame") ? ((JInternalFrame) this).getMostRecentFocusOwner() : null;
        if (mostRecentFocusOwner != null) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().enqueueKeyEvents(mostRecentEventTime, mostRecentFocusOwner);
        }
        synchronized (getTreeLock()) {
            try {
                final Container heavyweightContainer = getHeavyweightContainer();
                Component component = heavyweightContainer.modalComp;
                if (component != null) {
                    this.modalComp = component;
                    heavyweightContainer.modalComp = this;
                    return;
                }
                heavyweightContainer.modalComp = this;
                Runnable runnable = new Runnable() { // from class: org.apache.poi.java.awt.Container.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ((EventDispatchThread) Thread.currentThread()).pumpEventsForHierarchy(new Conditional() { // from class: org.apache.poi.java.awt.Container.3.1
                            @Override // org.apache.poi.java.awt.Conditional
                            public boolean evaluate() {
                                RunnableC139903 runnableC139903 = RunnableC139903.this;
                                return Container.this.windowClosingException == null && heavyweightContainer.modalComp != null;
                            }
                        }, Container.this);
                    }
                };
                if (EventQueue.isDispatchThread()) {
                    SequencedEvent currentSequencedEvent = KeyboardFocusManager.getCurrentKeyboardFocusManager().getCurrentSequencedEvent();
                    if (currentSequencedEvent != null) {
                        currentSequencedEvent.dispose();
                    }
                    runnable.run();
                } else {
                    synchronized (getTreeLock()) {
                        Toolkit.getEventQueue().postEvent(new PeerEvent(this, runnable, 1L));
                        while (this.windowClosingException == null && heavyweightContainer.modalComp != null) {
                            try {
                                getTreeLock().wait();
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
                RuntimeException runtimeException = this.windowClosingException;
                if (runtimeException != null) {
                    runtimeException.fillInStackTrace();
                    throw this.windowClosingException;
                }
                if (mostRecentFocusOwner != null) {
                    KeyboardFocusManager.getCurrentKeyboardFocusManager().dequeueKeyEvents(mostRecentEventTime, mostRecentFocusOwner);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void stopLWModal() {
        synchronized (getTreeLock()) {
            try {
                if (this.modalAppContext == null) {
                    EventQueue.invokeLater(new WakingRunnable());
                    getTreeLock().notifyAll();
                } else {
                    Container heavyweightContainer = getHeavyweightContainer();
                    if (heavyweightContainer != null) {
                        Component component = this.modalComp;
                        if (component != null) {
                            heavyweightContainer.modalComp = component;
                            this.modalComp = null;
                        } else {
                            heavyweightContainer.modalComp = null;
                        }
                    }
                    SunToolkit.postEvent(this.modalAppContext, new PeerEvent(this, new WakingRunnable(), 1L));
                    EventQueue.invokeLater(new WakingRunnable());
                    getTreeLock().notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("ncomponents", this.component.size());
        putFieldPutFields.put("component", getComponentsSync());
        putFieldPutFields.put("layoutMgr", this.layoutMgr);
        putFieldPutFields.put("dispatcher", this.dispatcher);
        putFieldPutFields.put("maxSize", this.maxSize);
        putFieldPutFields.put("focusCycleRoot", this.focusCycleRoot);
        putFieldPutFields.put("containerSerializedDataVersion", this.containerSerializedDataVersion);
        putFieldPutFields.put("focusTraversalPolicyProvider", this.focusTraversalPolicyProvider);
        objectOutputStream.writeFields();
        AWTEventMulticaster.save(objectOutputStream, "containerL", this.containerListener);
        objectOutputStream.writeObject(null);
        FocusTraversalPolicy focusTraversalPolicy = this.focusTraversalPolicy;
        if (focusTraversalPolicy instanceof Serializable) {
            objectOutputStream.writeObject(focusTraversalPolicy);
        } else {
            objectOutputStream.writeObject(null);
        }
    }

    public Component add(String str, Component component) throws Throwable {
        addImpl(component, str, -1);
        return component;
    }

    public synchronized void addContainerListener(ContainerListener containerListener) {
        if (containerListener == null) {
            return;
        }
        this.containerListener = AWTEventMulticaster.add(this.containerListener, containerListener);
        this.newEventsOnly = true;
    }

    public void addImpl(Component component, Object obj, int i) throws Throwable {
        Throwable th;
        synchronized (getTreeLock()) {
            try {
                try {
                    GraphicsConfiguration graphicsConfiguration = getGraphicsConfiguration();
                    if (i > this.component.size() || (i < 0 && i != -1)) {
                        throw new IllegalArgumentException("illegal component position");
                    }
                    checkAddToSelf(component);
                    checkNotAWindow(component);
                    if (graphicsConfiguration != null) {
                        try {
                            component.checkGD(graphicsConfiguration.getDevice().getIDstring());
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    Container container = component.parent;
                    if (container != null) {
                        container.remove(component);
                        if (i > this.component.size()) {
                            throw new IllegalArgumentException("illegal component position");
                        }
                    }
                    if (i == -1) {
                        this.component.add(component);
                    } else {
                        this.component.add(i, component);
                    }
                    component.parent = this;
                    component.setGraphicsConfiguration(graphicsConfiguration);
                    adjustListeningChildren(32768L, component.numListening(32768L));
                    adjustListeningChildren(65536L, component.numListening(65536L));
                    adjustDescendants(component.countHierarchyMembers());
                    invalidateIfValid();
                    if (this.peer != null) {
                        component.addNotify();
                    }
                    LayoutManager layoutManager = this.layoutMgr;
                    if (layoutManager != null) {
                        if (layoutManager instanceof LayoutManager2) {
                            ((LayoutManager2) layoutManager).addLayoutComponent(component, obj);
                        } else if (obj instanceof String) {
                            layoutManager.addLayoutComponent((String) obj, component);
                        }
                    }
                    if (this.containerListener != null || (this.eventMask & 2) != 0 || Toolkit.enabledOnToolkit(2L)) {
                        dispatchEvent(new ContainerEvent(this, 300, component));
                    }
                    component.createHierarchyEvents(1400, component, this, 1L, Toolkit.enabledOnToolkit(32768L));
                    if (this.peer != null && this.layoutMgr == null && isVisible()) {
                        updateCursorImmediately();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                super.addNotify();
                if (!(this.peer instanceof LightweightPeer)) {
                    this.dispatcher = new LightweightDispatcher(this);
                }
                for (int i = 0; i < this.component.size(); i++) {
                    this.component.get(i).addNotify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        super.addPropertyChangeListener(propertyChangeListener);
    }

    public void adjustDecendantsOnParent(int i) {
        Container container = this.parent;
        if (container != null) {
            container.adjustDescendants(i);
        }
    }

    public void adjustDescendants(int i) {
        if (i == 0) {
            return;
        }
        this.descendantsCount += i;
        adjustDecendantsOnParent(i);
    }

    public void adjustListeningChildren(long j, int i) {
        PlatformLogger platformLogger = eventLog;
        if (platformLogger.isLoggable(500) && j != 32768 && j != 65536 && j != 98304) {
            platformLogger.fine("Assertion failed");
        }
        if (i == 0) {
            return;
        }
        if ((j & 32768) != 0) {
            this.listeningChildren += i;
        }
        if ((j & 65536) != 0) {
            this.listeningBoundsChildren += i;
        }
        adjustListeningChildrenOnParent(j, i);
    }

    @Override // org.apache.poi.java.awt.Component
    public void applyComponentOrientation(ComponentOrientation componentOrientation) {
        super.applyComponentOrientation(componentOrientation);
        synchronized (getTreeLock()) {
            for (int i = 0; i < this.component.size(); i++) {
                try {
                    this.component.get(i).applyComponentOrientation(componentOrientation);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean areFocusTraversalKeysSet(int i) {
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        Set[] setArr = this.focusTraversalKeys;
        return (setArr == null || setArr[i] == null) ? false : true;
    }

    public boolean canContainFocusOwner(Component component) {
        if (!isEnabled() || !isDisplayable() || !isVisible() || !isFocusable()) {
            return false;
        }
        if (isFocusCycleRoot()) {
            FocusTraversalPolicy focusTraversalPolicy = getFocusTraversalPolicy();
            if ((focusTraversalPolicy instanceof DefaultFocusTraversalPolicy) && !((DefaultFocusTraversalPolicy) focusTraversalPolicy).accept(component)) {
                return false;
            }
        }
        synchronized (getTreeLock()) {
            try {
                Container container = this.parent;
                if (container == null) {
                    return true;
                }
                return container.canContainFocusOwner(component);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void checkGD(String str) {
        for (Component component : this.component) {
            if (component != null) {
                component.checkGD(str);
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void clearCurrentFocusCycleRootOnHide() {
        KeyboardFocusManager currentKeyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        Container currentFocusCycleRoot = currentKeyboardFocusManager.getCurrentFocusCycleRoot();
        if (currentFocusCycleRoot == this || isParentOf(currentFocusCycleRoot)) {
            currentKeyboardFocusManager.setGlobalCurrentFocusCycleRoot(null);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void clearMostRecentFocusOwnerOnHide() {
        Window containingWindow;
        boolean z;
        synchronized (getTreeLock()) {
            try {
                containingWindow = getContainingWindow();
                if (containingWindow != null) {
                    Component mostRecentFocusOwner = KeyboardFocusManager.getMostRecentFocusOwner(containingWindow);
                    z = mostRecentFocusOwner == this || isParentOf(mostRecentFocusOwner);
                    synchronized (KeyboardFocusManager.class) {
                        Component temporaryLostComponent = containingWindow.getTemporaryLostComponent();
                        if (isParentOf(temporaryLostComponent) || temporaryLostComponent == this) {
                            containingWindow.setTemporaryLostComponent(null);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            KeyboardFocusManager.setMostRecentFocusOwner(containingWindow, null);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public final boolean containsFocus() {
        return isParentOf(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
    }

    @Deprecated
    public int countComponents() {
        return this.component.size();
    }

    @Override // org.apache.poi.java.awt.Component
    public int countHierarchyMembers() {
        if (log.isLoggable(500)) {
            Iterator<Component> it = this.component.iterator();
            int iCountHierarchyMembers = 0;
            while (it.hasNext()) {
                iCountHierarchyMembers += it.next().countHierarchyMembers();
            }
            if (this.descendantsCount != iCountHierarchyMembers) {
                log.fine("Assertion (descendantsCount == sum) failed");
            }
        }
        return this.descendantsCount + 1;
    }

    public final void createChildHierarchyEvents(int i, long j, boolean z) {
        checkTreeLock();
        if (this.component.isEmpty()) {
            return;
        }
        int listenersCount = getListenersCount(i, z);
        int i2 = 0;
        while (listenersCount > 0) {
            int i4 = i;
            listenersCount -= this.component.get(i2).createHierarchyEvents(i4, this, this.parent, j, z);
            i2++;
            i = i4;
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public final int createHierarchyEvents(int i, Component component, Container container, long j, boolean z) {
        checkTreeLock();
        boolean z2 = z;
        int listenersCount = getListenersCount(i, z2);
        int i2 = 0;
        int iCreateHierarchyEvents = listenersCount;
        while (iCreateHierarchyEvents > 0) {
            iCreateHierarchyEvents -= this.component.get(i2).createHierarchyEvents(i, component, container, j, z2);
            i2++;
            z2 = z;
        }
        return listenersCount + super.createHierarchyEvents(i, component, container, j, z);
    }

    public final void decreaseComponentCount(Component component) {
        int i;
        int i2;
        synchronized (getTreeLock()) {
            try {
                if (!component.isDisplayable()) {
                    throw new IllegalStateException("Peer does not exist while invoking the decreaseComponentCount() method");
                }
                if (component instanceof Container) {
                    i = ((Container) component).numOfLWComponents;
                    i2 = ((Container) component).numOfHWComponents;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (component.isLightweight()) {
                    i++;
                } else {
                    i2++;
                }
                for (Container container = this; container != null; container = container.getContainer()) {
                    container.numOfLWComponents -= i;
                    container.numOfHWComponents -= i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public void deliverEvent(Event event) {
        Component componentAt = getComponentAt(event.f10047x, event.f10048y);
        if (componentAt == null || componentAt == this) {
            postEvent(event);
        } else {
            event.translate(-componentAt.f10034x, -componentAt.f10035y);
            componentAt.deliverEvent(event);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void dispatchEventImpl(AWTEvent aWTEvent) {
        LightweightDispatcher lightweightDispatcher = this.dispatcher;
        if (lightweightDispatcher != null && lightweightDispatcher.dispatchEvent(aWTEvent)) {
            aWTEvent.consume();
            ComponentPeer componentPeer = this.peer;
            if (componentPeer != null) {
                componentPeer.handleEvent(aWTEvent);
                return;
            }
            return;
        }
        super.dispatchEventImpl(aWTEvent);
        synchronized (getTreeLock()) {
            try {
                int id = aWTEvent.getID();
                if (id == 100) {
                    createChildHierarchyEvents(1401, 0L, Toolkit.enabledOnToolkit(65536L));
                } else if (id == 101) {
                    createChildHierarchyEvents(1402, 0L, Toolkit.enabledOnToolkit(65536L));
                }
            } finally {
            }
        }
    }

    public void dispatchEventToSelf(AWTEvent aWTEvent) {
        super.dispatchEventImpl(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.Component
    public void doLayout() {
        layout();
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean eventEnabled(AWTEvent aWTEvent) {
        int id = aWTEvent.getID();
        return (id == 300 || id == 301) ? ((this.eventMask & 2) == 0 && this.containerListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    public Component findComponentAt(int i, int i2) {
        return findComponentAt(i, i2, true);
    }

    public final Component findComponentAtImpl(int i, int i2, boolean z) {
        checkTreeLock();
        if (!contains(i, i2) || !this.visible) {
            return null;
        }
        if (!z && !this.enabled) {
            return null;
        }
        for (int i4 = 0; i4 < this.component.size(); i4++) {
            Component component = this.component.get(i4);
            if (component != null && !(component.peer instanceof LightweightPeer)) {
                Component componentFindComponentAtImpl = component instanceof Container ? ((Container) component).findComponentAtImpl(i - component.f10034x, i2 - component.f10035y, z) : component.locate(i - component.f10034x, i2 - component.f10035y);
                if (componentFindComponentAtImpl != null && componentFindComponentAtImpl.visible && (z || componentFindComponentAtImpl.enabled)) {
                    return componentFindComponentAtImpl;
                }
            }
        }
        for (int i5 = 0; i5 < this.component.size(); i5++) {
            Component component2 = this.component.get(i5);
            if (component2 != null && (component2.peer instanceof LightweightPeer)) {
                Component componentFindComponentAtImpl2 = component2 instanceof Container ? ((Container) component2).findComponentAtImpl(i - component2.f10034x, i2 - component2.f10035y, z) : component2.locate(i - component2.f10034x, i2 - component2.f10035y);
                if (componentFindComponentAtImpl2 != null && componentFindComponentAtImpl2.visible && (z || componentFindComponentAtImpl2.enabled)) {
                    return componentFindComponentAtImpl2;
                }
            }
        }
        return this;
    }

    public Accessible getAccessibleAt(Point point) {
        Component component;
        Accessible accessibleChild;
        AccessibleComponent accessibleComponent;
        synchronized (getTreeLock()) {
            try {
                int i = 0;
                if (this instanceof Accessible) {
                    AccessibleContext accessibleContext = ((Accessible) this).getAccessibleContext();
                    if (accessibleContext != null) {
                        int accessibleChildrenCount = accessibleContext.getAccessibleChildrenCount();
                        while (i < accessibleChildrenCount) {
                            accessibleChild = accessibleContext.getAccessibleChild(i);
                            if (accessibleChild != null && (accessibleContext = accessibleChild.getAccessibleContext()) != null && (accessibleComponent = accessibleContext.getAccessibleComponent()) != null && accessibleComponent.isShowing()) {
                                Point location = accessibleComponent.getLocation();
                                if (accessibleComponent.contains(new Point(point.f10092x - location.f10092x, point.f10093y - location.f10093y))) {
                                }
                            }
                            i++;
                        }
                    }
                    return (Accessible) this;
                }
                if (contains(point.f10092x, point.f10093y)) {
                    int componentCount = getComponentCount();
                    component = this;
                    while (i < componentCount) {
                        Component component2 = getComponent(i);
                        if (component2 != null && component2.isShowing()) {
                            Point location2 = component2.getLocation();
                            if (component2.contains(point.f10092x - location2.f10092x, point.f10093y - location2.f10093y)) {
                                component = component2;
                            }
                        }
                        i++;
                    }
                } else {
                    component = null;
                }
                if (!(component instanceof Accessible)) {
                    return null;
                }
                accessibleChild = (Accessible) component;
                return accessibleChild;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Accessible getAccessibleChild(int i) {
        synchronized (getTreeLock()) {
            try {
                int i2 = 0;
                for (Accessible accessible : getComponents()) {
                    if (accessible instanceof Accessible) {
                        if (i2 == i) {
                            return accessible;
                        }
                        i2++;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getAccessibleChildrenCount() {
        int i;
        synchronized (getTreeLock()) {
            try {
                i = 0;
                for (Component component : getComponents()) {
                    if (component instanceof Accessible) {
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // org.apache.poi.java.awt.Component
    public float getAlignmentX() {
        float layoutAlignmentX;
        if (!(this.layoutMgr instanceof LayoutManager2)) {
            return super.getAlignmentX();
        }
        synchronized (getTreeLock()) {
            layoutAlignmentX = ((LayoutManager2) this.layoutMgr).getLayoutAlignmentX(this);
        }
        return layoutAlignmentX;
    }

    @Override // org.apache.poi.java.awt.Component
    public float getAlignmentY() {
        float layoutAlignmentY;
        if (!(this.layoutMgr instanceof LayoutManager2)) {
            return super.getAlignmentY();
        }
        synchronized (getTreeLock()) {
            layoutAlignmentY = ((LayoutManager2) this.layoutMgr).getLayoutAlignmentY(this);
        }
        return layoutAlignmentY;
    }

    public Component getComponent(int i) {
        try {
            return this.component.get(i);
        } catch (IndexOutOfBoundsException unused) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0000a.m11h(i, "No such child: "));
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public Component getComponentAt(int i, int i2) {
        return locate(i, i2);
    }

    public int getComponentCount() {
        return countComponents();
    }

    public int getComponentZOrder(Component component) {
        if (component == null) {
            return -1;
        }
        synchronized (getTreeLock()) {
            try {
                if (component.parent != this) {
                    return -1;
                }
                return this.component.indexOf(component);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Component[] getComponents() {
        return getComponents_NoClientCode();
    }

    public Component[] getComponentsSync() {
        Component[] components;
        synchronized (getTreeLock()) {
            components = getComponents();
        }
        return components;
    }

    public final Component[] getComponents_NoClientCode() {
        return (Component[]) this.component.toArray(EMPTY_ARRAY);
    }

    public synchronized ContainerListener[] getContainerListeners() {
        return getListeners(ContainerListener.class);
    }

    public Component getDropTargetEventTarget(int i, int i2, boolean z) {
        return getMouseEventTarget(i, i2, z, DropTargetEventTargetFilter.FILTER, true);
    }

    @Override // org.apache.poi.java.awt.Component
    public Set<AWTKeyStroke> getFocusTraversalKeys(int i) {
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        return getFocusTraversalKeys_NoIDCheck(i);
    }

    public FocusTraversalPolicy getFocusTraversalPolicy() {
        if (!isFocusTraversalPolicyProvider() && !isFocusCycleRoot()) {
            return null;
        }
        FocusTraversalPolicy focusTraversalPolicy = this.focusTraversalPolicy;
        if (focusTraversalPolicy != null) {
            return focusTraversalPolicy;
        }
        Container focusCycleRootAncestor = getFocusCycleRootAncestor();
        return focusCycleRootAncestor != null ? focusCycleRootAncestor.getFocusTraversalPolicy() : KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalPolicy();
    }

    public Container getHeavyweightContainer() {
        checkTreeLock();
        ComponentPeer componentPeer = this.peer;
        return (componentPeer == null || (componentPeer instanceof LightweightPeer)) ? getNativeContainer() : this;
    }

    public Insets getInsets() {
        return insets();
    }

    public LayoutManager getLayout() {
        return this.layoutMgr;
    }

    @Override // org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return cls == ContainerListener.class ? (T[]) AWTEventMulticaster.getListeners(this.containerListener, cls) : (T[]) super.getListeners(cls);
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getMaximumSize() {
        Dimension dimension;
        Dimension dimension2 = this.maxSize;
        if (dimension2 == null || (!isMaximumSizeSet() && !isValid())) {
            synchronized (getTreeLock()) {
                try {
                    LayoutManager layoutManager = this.layoutMgr;
                    this.maxSize = layoutManager instanceof LayoutManager2 ? ((LayoutManager2) layoutManager).maximumLayoutSize(this) : super.getMaximumSize();
                    dimension = this.maxSize;
                } catch (Throwable th) {
                    throw th;
                }
            }
            dimension2 = dimension;
        }
        return dimension2 != null ? new Dimension(dimension2) : dimension2;
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getMinimumSize() {
        return minimumSize();
    }

    public Component getMouseEventTarget(int i, int i2, boolean z) {
        return getMouseEventTarget(i, i2, z, MouseEventTargetFilter.FILTER, false);
    }

    public Point getMousePosition(boolean z) {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        PointerInfo pointerInfo = (PointerInfo) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.Container.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                return MouseInfo.getPointerInfo();
            }
        });
        synchronized (getTreeLock()) {
            try {
                if (!isSameOrAncestorOf(findUnderMouseInWindow(pointerInfo), z)) {
                    return null;
                }
                return pointRelativeToComponent(pointerInfo.getLocation());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public final Region getOpaqueShape() {
        checkTreeLock();
        if (!isLightweight() || !isNonOpaqueForMixing() || !hasLightweightDescendants()) {
            return super.getOpaqueShape();
        }
        Region union = Region.EMPTY_REGION;
        for (int i = 0; i < getComponentCount(); i++) {
            Component component = getComponent(i);
            if (component.isLightweight() && component.isShowing()) {
                union = union.getUnion(component.getOpaqueShape());
            }
        }
        return union.getIntersection(getNormalShape());
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getPreferredSize() {
        return preferredSize();
    }

    @Override // org.apache.poi.java.awt.Component
    public final Container getTraversalRoot() {
        return isFocusCycleRoot() ? findTraversalRoot() : super.getTraversalRoot();
    }

    public final boolean hasHeavyweightDescendants() {
        checkTreeLock();
        return this.numOfHWComponents > 0;
    }

    public final boolean hasLightweightDescendants() {
        checkTreeLock();
        return this.numOfLWComponents > 0;
    }

    public final void increaseComponentCount(Component component) {
        int i;
        int i2;
        synchronized (getTreeLock()) {
            try {
                if (!component.isDisplayable()) {
                    throw new IllegalStateException("Peer does not exist while invoking the increaseComponentCount() method");
                }
                if (component instanceof Container) {
                    i = ((Container) component).numOfLWComponents;
                    i2 = ((Container) component).numOfHWComponents;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (component.isLightweight()) {
                    i++;
                } else {
                    i2++;
                }
                for (Container container = this; container != null; container = container.getContainer()) {
                    container.numOfLWComponents += i;
                    container.numOfHWComponents += i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void initializeFocusTraversalKeys() {
        this.focusTraversalKeys = new Set[4];
    }

    @Deprecated
    public Insets insets() {
        ContainerPeer containerPeer = this.peer;
        return containerPeer instanceof ContainerPeer ? (Insets) containerPeer.getInsets().clone() : new Insets(0, 0, 0, 0);
    }

    @Override // org.apache.poi.java.awt.Component
    public void invalidate() {
        LayoutManager layoutManager = this.layoutMgr;
        if (layoutManager instanceof LayoutManager2) {
            ((LayoutManager2) layoutManager).invalidateLayout(this);
        }
        super.invalidate();
    }

    @Override // org.apache.poi.java.awt.Component
    public void invalidateParent() {
        if (isJavaAwtSmartInvalidate && isValidateRoot()) {
            return;
        }
        super.invalidateParent();
    }

    public void invalidateTree() {
        synchronized (getTreeLock()) {
            for (int i = 0; i < this.component.size(); i++) {
                try {
                    Component component = this.component.get(i);
                    if (component instanceof Container) {
                        ((Container) component).invalidateTree();
                    } else {
                        component.invalidateIfValid();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            invalidateIfValid();
        }
    }

    public boolean isAncestorOf(Component component) {
        Container parent;
        if (component != null && (parent = component.getParent()) != null) {
            for (parent = component.getParent(); parent != null; parent = parent.getParent()) {
                if (parent == this) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFocusCycleRoot() {
        return this.focusCycleRoot;
    }

    public final boolean isFocusTraversalPolicyProvider() {
        return this.focusTraversalPolicyProvider;
    }

    public boolean isFocusTraversalPolicySet() {
        return this.focusTraversalPolicy != null;
    }

    public final boolean isRecursivelyVisibleUpToHeavyweightContainer() {
        if (!isLightweight()) {
            return true;
        }
        for (Container container = this; container != null && container.isLightweight(); container = container.getContainer()) {
            if (!container.isVisible()) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean isSameOrAncestorOf(Component component, boolean z) {
        if (this != component) {
            return z && isParentOf(component);
        }
        return true;
    }

    public boolean isValidateRoot() {
        return false;
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public void layout() {
        LayoutManager layoutManager = this.layoutMgr;
        if (layoutManager != null) {
            layoutManager.layoutContainer(this);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void lightweightPaint(Graphics graphics) {
        super.lightweightPaint(graphics);
        paintHeavyweightComponents(graphics);
    }

    @Override // org.apache.poi.java.awt.Component
    public void lightweightPrint(Graphics graphics) {
        super.lightweightPrint(graphics);
        printHeavyweightComponents(graphics);
    }

    @Override // org.apache.poi.java.awt.Component
    public void list(PrintStream printStream, int i) {
        super.list(printStream, i);
        synchronized (getTreeLock()) {
            for (int i2 = 0; i2 < this.component.size(); i2++) {
                try {
                    Component component = this.component.get(i2);
                    if (component != null) {
                        component.list(printStream, i + 1);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Component locate(int i, int i2) {
        if (!contains(i, i2)) {
            return null;
        }
        synchronized (getTreeLock()) {
            for (int i4 = 0; i4 < this.component.size(); i4++) {
                try {
                    Component component = this.component.get(i4);
                    if (component != null && !(component.peer instanceof LightweightPeer) && component.contains(i - component.f10034x, i2 - component.f10035y)) {
                        return component;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i5 = 0; i5 < this.component.size(); i5++) {
                Component component2 = this.component.get(i5);
                if (component2 != null && (component2.peer instanceof LightweightPeer) && component2.contains(i - component2.f10034x, i2 - component2.f10035y)) {
                    return component2;
                }
            }
            return this;
        }
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Dimension minimumSize() {
        Dimension dimensionMinimumLayoutSize;
        Dimension dimension = this.minSize;
        if (dimension == null || (!isMinimumSizeSet() && !isValid())) {
            synchronized (getTreeLock()) {
                try {
                    LayoutManager layoutManager = this.layoutMgr;
                    dimensionMinimumLayoutSize = layoutManager != null ? layoutManager.minimumLayoutSize(this) : super.minimumSize();
                    this.minSize = dimensionMinimumLayoutSize;
                } catch (Throwable th) {
                    throw th;
                }
            }
            dimension = dimensionMinimumLayoutSize;
        }
        return dimension != null ? new Dimension(dimension) : dimension;
    }

    @Override // org.apache.poi.java.awt.Component
    public void mixOnHiding(boolean z) {
        synchronized (getTreeLock()) {
            try {
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this + "; isLightweight=" + z);
                }
                if (z) {
                    recursiveHideHeavyweightChildren();
                }
                super.mixOnHiding(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0069 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x0007, B:6:0x0011, B:9:0x0023, B:11:0x002d, B:13:0x0033, B:15:0x0046, B:17:0x004c, B:18:0x005c, B:23:0x0067, B:21:0x0062, B:25:0x0069), top: B:28:0x0007 }] */
    @Override // org.apache.poi.java.awt.Component
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mixOnReshaping() {
        synchronized (getTreeLock()) {
            try {
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this);
                }
                boolean zIsMixingNeeded = isMixingNeeded();
                if (isLightweight() && hasHeavyweightDescendants()) {
                    Point point = new Point(getX(), getY());
                    for (Container container = getContainer(); container != null && container.isLightweight(); container = container.getContainer()) {
                        point.translate(container.getX(), container.getY());
                    }
                    recursiveRelocateHeavyweightChildren(point);
                    if (zIsMixingNeeded) {
                        recursiveApplyCurrentShape();
                        if (zIsMixingNeeded) {
                        }
                    }
                } else if (zIsMixingNeeded) {
                    super.mixOnReshaping();
                }
            } finally {
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void mixOnShowing() {
        synchronized (getTreeLock()) {
            try {
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this);
                }
                boolean zIsLightweight = isLightweight();
                if (zIsLightweight && isRecursivelyVisibleUpToHeavyweightContainer()) {
                    recursiveShowHeavyweightChildren();
                }
                if (isMixingNeeded()) {
                    if (!zIsLightweight || (zIsLightweight && hasHeavyweightDescendants())) {
                        recursiveApplyCurrentShape();
                    }
                    super.mixOnShowing();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void mixOnValidating() {
        synchronized (getTreeLock()) {
            try {
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this);
                }
                if (isMixingNeeded()) {
                    if (hasHeavyweightDescendants()) {
                        recursiveApplyCurrentShape();
                    }
                    if (isLightweight() && isNonOpaqueForMixing()) {
                        subtractAndApplyShapeBelowMe();
                    }
                    super.mixOnValidating();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void mixOnZOrderChanging(int i, int i2) {
        synchronized (getTreeLock()) {
            try {
                PlatformLogger platformLogger = mixingLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("this = " + this + "; oldZ=" + i + "; newZ=" + i2);
                }
                if (isMixingNeeded()) {
                    if (i2 < i && isLightweight() && hasHeavyweightDescendants()) {
                        recursiveApplyCurrentShape();
                    }
                    super.mixOnZOrderChanging(i, i2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public int numListening(long j) {
        int i;
        int iNumListening = super.numListening(j);
        int iNumListening2 = 0;
        if (j == 32768) {
            if (eventLog.isLoggable(500)) {
                Iterator<Component> it = this.component.iterator();
                while (it.hasNext()) {
                    iNumListening2 += it.next().numListening(j);
                }
                if (this.listeningChildren != iNumListening2) {
                    eventLog.fine("Assertion (listeningChildren == sum) failed");
                }
            }
            i = this.listeningChildren;
        } else {
            if (j != 65536) {
                PlatformLogger platformLogger = eventLog;
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("This code must never be reached");
                }
                return iNumListening;
            }
            if (eventLog.isLoggable(500)) {
                Iterator<Component> it2 = this.component.iterator();
                while (it2.hasNext()) {
                    iNumListening2 += it2.next().numListening(j);
                }
                if (this.listeningBoundsChildren != iNumListening2) {
                    eventLog.fine("Assertion (listeningBoundsChildren == sum) failed");
                }
            }
            i = this.listeningBoundsChildren;
        }
        return i + iNumListening;
    }

    @Override // org.apache.poi.java.awt.Component
    public void paint(Graphics graphics) {
        if (isShowing()) {
            synchronized (getObjectLock()) {
                try {
                    if (this.printing && this.printingThreads.contains(Thread.currentThread())) {
                        return;
                    }
                    GraphicsCallback.PaintCallback.getInstance().runComponents(getComponentsSync(), graphics, 2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void paintComponents(Graphics graphics) {
        if (isShowing()) {
            GraphicsCallback.PaintAllCallback.getInstance().runComponents(getComponentsSync(), graphics, 4);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void paintHeavyweightComponents(Graphics graphics) {
        if (isShowing()) {
            GraphicsCallback.PaintHeavyweightComponentsCallback.getInstance().runComponents(getComponentsSync(), graphics, 3);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public String paramString() {
        String strParamString = super.paramString();
        LayoutManager layoutManager = this.layoutMgr;
        if (layoutManager == null) {
            return strParamString;
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(strParamString, ",layout=");
        sbM781w.append(layoutManager.getClass().getName());
        return sbM781w.toString();
    }

    public void postProcessKeyEvent(KeyEvent keyEvent) {
        Container container = this.parent;
        if (container != null) {
            container.postProcessKeyEvent(keyEvent);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean postsOldMouseEvents() {
        return true;
    }

    public void preProcessKeyEvent(KeyEvent keyEvent) {
        Container container = this.parent;
        if (container != null) {
            container.preProcessKeyEvent(keyEvent);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Dimension preferredSize() {
        Dimension dimensionPreferredLayoutSize;
        Dimension dimension = this.prefSize;
        if (dimension == null || (!isPreferredSizeSet() && !isValid())) {
            synchronized (getTreeLock()) {
                try {
                    LayoutManager layoutManager = this.layoutMgr;
                    dimensionPreferredLayoutSize = layoutManager != null ? layoutManager.preferredLayoutSize(this) : super.preferredSize();
                    this.prefSize = dimensionPreferredLayoutSize;
                } catch (Throwable th) {
                    throw th;
                }
            }
            dimension = dimensionPreferredLayoutSize;
        }
        return dimension != null ? new Dimension(dimension) : dimension;
    }

    @Override // org.apache.poi.java.awt.Component
    public void print(Graphics graphics) {
        if (isShowing()) {
            Thread threadCurrentThread = Thread.currentThread();
            try {
                synchronized (getObjectLock()) {
                    try {
                        if (this.printingThreads == null) {
                            this.printingThreads = new HashSet();
                        }
                        this.printingThreads.add(threadCurrentThread);
                        this.printing = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                super.print(graphics);
                synchronized (getObjectLock()) {
                    this.printingThreads.remove(threadCurrentThread);
                    this.printing = !this.printingThreads.isEmpty();
                }
                GraphicsCallback.PrintCallback.getInstance().runComponents(getComponentsSync(), graphics, 2);
            } catch (Throwable th2) {
                synchronized (getObjectLock()) {
                    this.printingThreads.remove(threadCurrentThread);
                    this.printing = !this.printingThreads.isEmpty();
                    throw th2;
                }
            }
        }
    }

    public void printComponents(Graphics graphics) {
        if (isShowing()) {
            GraphicsCallback.PrintAllCallback.getInstance().runComponents(getComponentsSync(), graphics, 4);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void printHeavyweightComponents(Graphics graphics) {
        if (isShowing()) {
            GraphicsCallback.PrintHeavyweightComponentsCallback.getInstance().runComponents(getComponentsSync(), graphics, 3);
        }
    }

    public void processContainerEvent(ContainerEvent containerEvent) {
        ContainerListener containerListener = this.containerListener;
        if (containerListener != null) {
            int id = containerEvent.getID();
            if (id == 300) {
                containerListener.componentAdded(containerEvent);
            } else {
                if (id != 301) {
                    return;
                }
                containerListener.componentRemoved(containerEvent);
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
    }

    public void proxyEnableEvents(long j) {
        if (this.peer instanceof LightweightPeer) {
            Container container = this.parent;
            if (container != null) {
                container.proxyEnableEvents(j);
                return;
            }
            return;
        }
        LightweightDispatcher lightweightDispatcher = this.dispatcher;
        if (lightweightDispatcher != null) {
            lightweightDispatcher.enableEvents(j);
        }
    }

    public final void recursiveApplyCurrentShape() {
        recursiveApplyCurrentShape(getTopmostComponentIndex(), getBottommostComponentIndex());
    }

    public final void recursiveSubtractAndApplyShape(Region region) {
        recursiveSubtractAndApplyShape(region, getTopmostComponentIndex(), getBottommostComponentIndex());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[Catch: all -> 0x009b, TRY_ENTER, TryCatch #2 {all -> 0x009b, blocks: (B:5:0x0007, B:7:0x000f, B:13:0x0025, B:17:0x002f, B:24:0x0077, B:23:0x006d), top: B:46:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void remove(int i) throws Throwable {
        Throwable th;
        synchronized (getTreeLock()) {
            try {
                if (i >= 0) {
                    try {
                        if (i < this.component.size()) {
                            Component component = this.component.get(i);
                            if (this.peer != null) {
                                try {
                                    component.removeNotify();
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            LayoutManager layoutManager = this.layoutMgr;
                            if (layoutManager != null) {
                                layoutManager.removeLayoutComponent(component);
                            }
                            adjustListeningChildren(32768L, -component.numListening(32768L));
                            adjustListeningChildren(65536L, -component.numListening(65536L));
                            adjustDescendants(-component.countHierarchyMembers());
                            component.parent = null;
                            this.component.remove(i);
                            component.setGraphicsConfiguration(null);
                            invalidateIfValid();
                            if (this.containerListener != null || (this.eventMask & 2) != 0) {
                                dispatchEvent(new ContainerEvent(this, 301, component));
                            } else if (Toolkit.enabledOnToolkit(2L)) {
                            }
                            component.createHierarchyEvents(1400, component, this, 1L, Toolkit.enabledOnToolkit(32768L));
                            if (this.peer != null && this.layoutMgr == null && isVisible()) {
                                updateCursorImmediately();
                            }
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                throw new ArrayIndexOutOfBoundsException(i);
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public void removeAll() throws Throwable {
        synchronized (getTreeLock()) {
            try {
                try {
                    adjustListeningChildren(32768L, -this.listeningChildren);
                    adjustListeningChildren(65536L, -this.listeningBoundsChildren);
                    adjustDescendants(-this.descendantsCount);
                    while (!this.component.isEmpty()) {
                        Component componentRemove = this.component.remove(r0.size() - 1);
                        if (this.peer != null) {
                            componentRemove.removeNotify();
                        }
                        LayoutManager layoutManager = this.layoutMgr;
                        if (layoutManager != null) {
                            layoutManager.removeLayoutComponent(componentRemove);
                        }
                        componentRemove.parent = null;
                        componentRemove.setGraphicsConfiguration(null);
                        if (this.containerListener != null || (this.eventMask & 2) != 0 || Toolkit.enabledOnToolkit(2L)) {
                            dispatchEvent(new ContainerEvent(this, 301, componentRemove));
                        }
                        componentRemove.createHierarchyEvents(1400, componentRemove, this, 1L, Toolkit.enabledOnToolkit(32768L));
                    }
                    if (this.peer != null && this.layoutMgr == null && isVisible()) {
                        updateCursorImmediately();
                    }
                    invalidateIfValid();
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public synchronized void removeContainerListener(ContainerListener containerListener) {
        if (containerListener == null) {
            return;
        }
        this.containerListener = AWTEventMulticaster.remove(this.containerListener, containerListener);
    }

    @Override // org.apache.poi.java.awt.Component
    public void removeNotify() {
        synchronized (getTreeLock()) {
            try {
                for (int size = this.component.size() - 1; size >= 0; size--) {
                    Component component = this.component.get(size);
                    if (component != null) {
                        component.setAutoFocusTransferOnDisposal(false);
                        component.removeNotify();
                        component.setAutoFocusTransferOnDisposal(true);
                    }
                }
                if (containsFocus() && KeyboardFocusManager.isAutoFocusTransferEnabledFor(this) && !transferFocus(false)) {
                    transferFocusBackward(true);
                }
                LightweightDispatcher lightweightDispatcher = this.dispatcher;
                if (lightweightDispatcher != null) {
                    lightweightDispatcher.dispose();
                    this.dispatcher = null;
                }
                super.removeNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setComponentZOrder(Component component, int i) {
        synchronized (getTreeLock()) {
            try {
                Container container = component.parent;
                int componentZOrder = getComponentZOrder(component);
                if (container != this || i != componentZOrder) {
                    checkAdding(component, i);
                    boolean zRemoveDelicately = container != null ? container.removeDelicately(component, this, i) : false;
                    addDelicately(component, container, i);
                    if (!zRemoveDelicately && componentZOrder != -1) {
                        component.mixOnZOrderChanging(componentZOrder, i);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setFocusCycleRoot(boolean z) {
        boolean z2;
        synchronized (this) {
            z2 = this.focusCycleRoot;
            this.focusCycleRoot = z;
        }
        firePropertyChange("focusCycleRoot", z2, z);
    }

    @Override // org.apache.poi.java.awt.Component
    public void setFocusTraversalKeys(int i, Set<? extends AWTKeyStroke> set) {
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        setFocusTraversalKeys_NoIDCheck(i, set);
    }

    public void setFocusTraversalPolicy(FocusTraversalPolicy focusTraversalPolicy) {
        FocusTraversalPolicy focusTraversalPolicy2;
        synchronized (this) {
            focusTraversalPolicy2 = this.focusTraversalPolicy;
            this.focusTraversalPolicy = focusTraversalPolicy;
        }
        firePropertyChange("focusTraversalPolicy", focusTraversalPolicy2, focusTraversalPolicy);
    }

    public final void setFocusTraversalPolicyProvider(boolean z) {
        boolean z2;
        synchronized (this) {
            z2 = this.focusTraversalPolicyProvider;
            this.focusTraversalPolicyProvider = z;
        }
        firePropertyChange("focusTraversalPolicyProvider", z2, z);
    }

    @Override // org.apache.poi.java.awt.Component
    public void setFont(Font font) {
        Font font2 = getFont();
        super.setFont(font);
        Font font3 = getFont();
        if (font3 != font2) {
            if (font2 == null || !font2.equals(font3)) {
                invalidateTree();
            }
        }
    }

    public void setLayout(LayoutManager layoutManager) {
        this.layoutMgr = layoutManager;
        invalidateIfValid();
    }

    public void transferFocusDownCycle() {
        if (isFocusCycleRoot()) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().setGlobalCurrentFocusCycleRoot(this);
            Component defaultComponent = getFocusTraversalPolicy().getDefaultComponent(this);
            if (defaultComponent != null) {
                defaultComponent.requestFocus(CausedFocusEvent.Cause.TRAVERSAL_DOWN);
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void update(Graphics graphics) {
        if (isShowing()) {
            if (!(this.peer instanceof LightweightPeer)) {
                graphics.clearRect(0, 0, this.width, this.height);
            }
            paint(graphics);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean updateGraphicsData(GraphicsConfiguration graphicsConfiguration) {
        checkTreeLock();
        boolean zUpdateGraphicsData = super.updateGraphicsData(graphicsConfiguration);
        for (Component component : this.component) {
            if (component != null) {
                zUpdateGraphicsData |= component.updateGraphicsData(graphicsConfiguration);
            }
        }
        return zUpdateGraphicsData;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0034  */
    @Override // org.apache.poi.java.awt.Component
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void validate() {
        boolean zIsVisible;
        synchronized (getTreeLock()) {
            try {
                if (!isValid() || descendUnconditionallyWhenValidating) {
                    ContainerPeer containerPeer = this.peer;
                    if (containerPeer == null) {
                        zIsVisible = false;
                    } else {
                        ContainerPeer containerPeer2 = containerPeer instanceof ContainerPeer ? containerPeer : null;
                        if (containerPeer2 != null) {
                            containerPeer2.beginValidate();
                        }
                        validateTree();
                        if (containerPeer2 != null) {
                            containerPeer2.endValidate();
                            if (!descendUnconditionallyWhenValidating) {
                                zIsVisible = isVisible();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsVisible) {
            updateCursorImmediately();
        }
    }

    public void validateTree() {
        checkTreeLock();
        if (!isValid() || descendUnconditionallyWhenValidating) {
            ContainerPeer containerPeer = this.peer;
            if (containerPeer instanceof ContainerPeer) {
                containerPeer.beginLayout();
            }
            if (!isValid()) {
                doLayout();
            }
            for (int i = 0; i < this.component.size(); i++) {
                Component component = this.component.get(i);
                if (!(component instanceof Container) || (component instanceof Window) || (component.isValid() && !descendUnconditionallyWhenValidating)) {
                    component.validate();
                } else {
                    ((Container) component).validateTree();
                }
            }
            ContainerPeer containerPeer2 = this.peer;
            if (containerPeer2 instanceof ContainerPeer) {
                containerPeer2.endLayout();
            }
        }
        super.validate();
    }

    public final void validateUnconditionally() {
        boolean zIsVisible;
        synchronized (getTreeLock()) {
            try {
                descendUnconditionallyWhenValidating = true;
                validate();
                zIsVisible = this.peer instanceof ContainerPeer ? isVisible() : false;
                descendUnconditionallyWhenValidating = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsVisible) {
            updateCursorImmediately();
        }
    }

    private Component getMouseEventTarget(int i, int i2, boolean z, EventTargetFilter eventTargetFilter, boolean z2) {
        Container container;
        int i4;
        int i5;
        boolean z3;
        EventTargetFilter eventTargetFilter2;
        boolean z4;
        Component mouseEventTargetImpl;
        if (z2) {
            container = this;
            i4 = i;
            i5 = i2;
            z3 = z;
            eventTargetFilter2 = eventTargetFilter;
            z4 = z2;
            mouseEventTargetImpl = container.getMouseEventTargetImpl(i4, i5, z3, eventTargetFilter2, true, z4);
        } else {
            container = this;
            i4 = i;
            i5 = i2;
            z3 = z;
            eventTargetFilter2 = eventTargetFilter;
            z4 = z2;
            mouseEventTargetImpl = null;
        }
        return (mouseEventTargetImpl == null || mouseEventTargetImpl == container) ? container.getMouseEventTargetImpl(i4, i5, z3, eventTargetFilter2, false, z4) : mouseEventTargetImpl;
    }

    public Component add(Component component) throws Throwable {
        addImpl(component, null, -1);
        return component;
    }

    @Override // org.apache.poi.java.awt.Component
    public void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        super.addPropertyChangeListener(str, propertyChangeListener);
    }

    public final Component findComponentAt(int i, int i2, boolean z) {
        synchronized (getTreeLock()) {
            try {
                if (!isRecursivelyVisible()) {
                    return null;
                }
                return findComponentAtImpl(i, i2, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public Component getComponentAt(Point point) {
        return getComponentAt(point.f10092x, point.f10093y);
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean isFocusCycleRoot(Container container) {
        if (isFocusCycleRoot() && container == this) {
            return true;
        }
        return super.isFocusCycleRoot(container);
    }

    @Override // org.apache.poi.java.awt.Component
    public void list(PrintWriter printWriter, int i) {
        super.list(printWriter, i);
        synchronized (getTreeLock()) {
            for (int i2 = 0; i2 < this.component.size(); i2++) {
                try {
                    Component component = this.component.get(i2);
                    if (component != null) {
                        component.list(printWriter, i + 1);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void recursiveApplyCurrentShape(int i) {
        recursiveApplyCurrentShape(i, getBottommostComponentIndex());
    }

    public final void recursiveSubtractAndApplyShape(Region region, int i) {
        recursiveSubtractAndApplyShape(region, i, getBottommostComponentIndex());
    }

    public void remove(Component component) {
        int iIndexOf;
        synchronized (getTreeLock()) {
            try {
                if (component.parent == this && (iIndexOf = this.component.indexOf(component)) >= 0) {
                    remove(iIndexOf);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Component add(Component component, int i) throws Throwable {
        addImpl(component, null, i);
        return component;
    }

    public Component findComponentAt(Point point) {
        return findComponentAt(point.f10092x, point.f10093y);
    }

    public final void recursiveApplyCurrentShape(int i, int i2) {
        checkTreeLock();
        PlatformLogger platformLogger = mixingLog;
        if (platformLogger.isLoggable(500)) {
            platformLogger.fine("this = " + this + "; fromZ=" + i + "; toZ=" + i2);
        }
        if (i == -1) {
            return;
        }
        if (getLayout() == null || isValid()) {
            while (i <= i2) {
                Component component = getComponent(i);
                if (!component.isLightweight()) {
                    component.applyCurrentShape();
                }
                if (component instanceof Container) {
                    Container container = (Container) component;
                    if (container.hasHeavyweightDescendants()) {
                        container.recursiveApplyCurrentShape();
                    }
                }
                i++;
            }
        }
    }

    public final void recursiveSubtractAndApplyShape(Region region, int i, int i2) {
        checkTreeLock();
        PlatformLogger platformLogger = mixingLog;
        if (platformLogger.isLoggable(500)) {
            platformLogger.fine("this = " + this + "; shape=" + region + "; fromZ=" + i + "; toZ=" + i2);
        }
        if (i == -1 || region.isEmpty()) {
            return;
        }
        if (getLayout() == null || isValid()) {
            while (i <= i2) {
                Component component = getComponent(i);
                if (!component.isLightweight()) {
                    component.subtractAndApplyShape(region);
                } else if (component instanceof Container) {
                    Container container = (Container) component;
                    if (container.hasHeavyweightDescendants() && component.isShowing()) {
                        container.recursiveSubtractAndApplyShape(region);
                    }
                }
                i++;
            }
        }
    }

    public void add(Component component, Object obj) throws Throwable {
        addImpl(component, obj, -1);
    }

    public void add(Component component, Object obj, int i) throws Throwable {
        addImpl(component, obj, i);
    }

    public static final class WakingRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
