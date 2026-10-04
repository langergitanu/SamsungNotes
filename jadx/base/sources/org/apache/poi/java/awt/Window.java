package org.apache.poi.java.awt;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.RootPaneContainer;
import org.apache.poi.java.awt.Container;
import org.apache.poi.java.awt.Dialog;
import org.apache.poi.java.awt.GraphicsDevice;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.event.MouseWheelEvent;
import org.apache.poi.java.awt.event.WindowEvent;
import org.apache.poi.java.awt.event.WindowFocusListener;
import org.apache.poi.java.awt.event.WindowListener;
import org.apache.poi.java.awt.event.WindowStateListener;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Path2D;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.im.InputContext;
import org.apache.poi.java.awt.image.BufferStrategy;
import org.apache.poi.java.awt.peer.WindowPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.CausedFocusEvent;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.awt.util.IdentityArrayList;
import org.apache.poi.sun.java2d.Disposer;
import org.apache.poi.sun.java2d.DisposerRecord;
import org.apache.poi.sun.java2d.pipe.Region;
import org.apache.poi.sun.security.action.GetPropertyAction;
import org.apache.poi.sun.security.util.SecurityConstants;
import org.apache.poi.sun.util.logging.PlatformLogger;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public class Window extends Container implements Accessible {
    static final int OPENED = 1;
    private static final String base = "win";
    private static final AtomicBoolean beforeFirstWindowShown;
    private static final boolean locationByPlatformProp;
    private static final long serialVersionUID = 4497834738069338734L;
    static boolean systemSyncLWRequests = false;
    private boolean alwaysOnTop;
    transient Object anchor;
    private volatile boolean autoRequestFocus;
    transient boolean beforeFirstShow;
    private transient boolean disposing;
    private FocusManager focusMgr;
    private boolean focusableWindowState;
    transient java.util.List<Image> icons;
    transient InputContext inputContext;
    private transient Object inputContextLock;
    transient boolean isInShow;
    transient boolean isTrayIconWindow;
    private boolean locationByPlatform;
    transient Dialog modalBlocker;
    Dialog.ModalExclusionType modalExclusionType;
    private float opacity;
    transient Vector<WeakReference<Window>> ownedWindowList;
    private transient float securityWarningAlignmentX;
    private transient float securityWarningAlignmentY;
    private volatile transient int securityWarningHeight;
    private transient double securityWarningPointX;
    private transient double securityWarningPointY;
    private volatile transient int securityWarningWidth;
    private Shape shape;
    transient boolean showWithParent;
    int state;
    boolean syncLWRequests;
    private transient Component temporaryLostComponent;
    private Type type;
    String warningString;
    private transient WeakReference<Window> weakThis;
    transient WindowFocusListener windowFocusListener;
    transient WindowListener windowListener;
    private int windowSerializedDataVersion;
    transient WindowStateListener windowStateListener;
    private static final IdentityArrayList<Window> allWindows = new IdentityArrayList<>();
    private static int nameCounter = 0;
    private static final PlatformLogger log = PlatformLogger.getLogger("org.apache.poi.java.awt.Window");

    public class AccessibleAWTWindow extends Container.AccessibleAWTContainer {
        private static final long serialVersionUID = 4215068635060671780L;

        public AccessibleAWTWindow() {
            super();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.WINDOW;
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            if (Window.this.getFocusOwner() != null) {
                accessibleStateSet.add(AccessibleState.ACTIVE);
            }
            return accessibleStateSet;
        }
    }

    public enum Type {
        NORMAL,
        UTILITY,
        POPUP
    }

    public static class WindowDisposerRecord implements DisposerRecord {
        final WeakReference<AppContext> context;
        final WeakReference<Window> owner;
        final WeakReference weakThis;

        public WindowDisposerRecord(AppContext appContext, Window window) {
            this.owner = new WeakReference<>(window.getOwner());
            this.weakThis = window.weakThis;
            this.context = new WeakReference<>(appContext);
        }

        @Override // org.apache.poi.sun.java2d.DisposerRecord
        public void dispose() {
            Window window = this.owner.get();
            if (window != null) {
                window.removeOwnedWindow(this.weakThis);
            }
            AppContext appContext = this.context.get();
            if (appContext != null) {
                Window.removeFromWindowList(appContext, this.weakThis);
            }
        }
    }

    static {
        boolean z = false;
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        String str = (String) AccessController.doPrivileged(new GetPropertyAction("org.apache.poi.java.awt.syncLWRequests"));
        systemSyncLWRequests = str != null && str.equals("true");
        String str2 = (String) AccessController.doPrivileged(new GetPropertyAction("org.apache.poi.java.awt.Window.locationByPlatform"));
        if (str2 != null && str2.equals("true")) {
            z = true;
        }
        locationByPlatformProp = z;
        beforeFirstWindowShown = new AtomicBoolean(true);
        AWTAccessor.setWindowAccessor(new AWTAccessor.WindowAccessor() { // from class: org.apache.poi.java.awt.Window.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public Point2D calculateSecurityWarningPosition(Window window, double d, double d2, double d3, double d4) {
                return window.calculateSecurityWarningPosition(d, d2, d3, d4);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public float getOpacity(Window window) {
                return window.opacity;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public Dimension getSecurityWarningSize(Window window) {
                return new Dimension(window.securityWarningWidth, window.securityWarningHeight);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public Shape getShape(Window window) {
                return window.getShape();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public boolean isAutoRequestFocus(Window window) {
                return window.autoRequestFocus;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public boolean isTrayIconWindow(Window window) {
                return window.isTrayIconWindow;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public void setLWRequestStatus(Window window, boolean z2) {
                window.syncLWRequests = z2;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public void setOpacity(Window window, float f) {
                window.setOpacity(f);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public void setOpaque(Window window, boolean z2) {
                Color background = window.getBackground();
                if (background == null) {
                    background = new Color(0, 0, 0, 0);
                }
                window.setBackground(new Color(background.getRed(), background.getGreen(), background.getBlue(), z2 ? 255 : 0));
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public void setSecurityWarningPosition(Window window, Point2D point2D, float f, float f4) {
                window.securityWarningPointX = point2D.getX();
                window.securityWarningPointY = point2D.getY();
                window.securityWarningAlignmentX = f;
                window.securityWarningAlignmentY = f4;
                synchronized (window.getTreeLock()) {
                    try {
                        WindowPeer peer = window.getPeer();
                        if (peer != null) {
                            peer.repositionSecurityWarning();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public void setSecurityWarningSize(Window window, int i, int i2) {
                window.securityWarningWidth = i;
                window.securityWarningHeight = i2;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public void setShape(Window window, Shape shape) {
                window.setShape(shape);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public void setTrayIconWindow(Window window, boolean z2) {
                window.isTrayIconWindow = z2;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.WindowAccessor
            public void updateWindow(Window window) {
                window.updateWindow();
            }
        });
    }

    public Window() {
        this.syncLWRequests = false;
        this.beforeFirstShow = true;
        this.disposing = false;
        this.ownedWindowList = new Vector<>();
        this.inputContextLock = new Object();
        this.focusableWindowState = true;
        this.autoRequestFocus = true;
        this.isInShow = false;
        this.opacity = 1.0f;
        this.shape = null;
        this.isTrayIconWindow = false;
        this.securityWarningWidth = 0;
        this.securityWarningHeight = 0;
        this.securityWarningPointX = 2.0d;
        this.securityWarningPointY = 0.0d;
        this.securityWarningAlignmentX = 1.0f;
        this.securityWarningAlignmentY = 0.0f;
        this.anchor = new Object();
        this.type = Type.NORMAL;
        this.windowSerializedDataVersion = 2;
        this.locationByPlatform = locationByPlatformProp;
        GraphicsEnvironment.checkHeadless();
        init(null);
    }

    private void addToWindowList() {
        synchronized (Window.class) {
            try {
                Vector vector = (Vector) this.appContext.get(Window.class);
                if (vector == null) {
                    vector = new Vector();
                    this.appContext.put(Window.class, vector);
                }
                vector.add(this.weakThis);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point2D calculateSecurityWarningPosition(double d, double d2, double d3, double d4) {
        double d5 = (((double) this.securityWarningAlignmentX) * d3) + d + this.securityWarningPointX;
        double d6 = (((double) this.securityWarningAlignmentY) * d4) + d2 + this.securityWarningPointY;
        double dLimit = limit(d5, (d - ((double) this.securityWarningWidth)) - 2.0d, d + d3 + 2.0d);
        double dLimit2 = limit(d6, (d2 - ((double) this.securityWarningHeight)) - 2.0d, d2 + d4 + 2.0d);
        GraphicsConfiguration graphicsConfiguration_NoClientCode = getGraphicsConfiguration_NoClientCode();
        Rectangle bounds = graphicsConfiguration_NoClientCode.getBounds();
        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(graphicsConfiguration_NoClientCode);
        int i = bounds.f10094x;
        double dLimit3 = limit(dLimit, screenInsets.left + i, ((i + bounds.width) - screenInsets.right) - this.securityWarningWidth);
        int i2 = bounds.f10095y;
        return new Point2D.Double(dLimit3, limit(dLimit2, screenInsets.top + i2, ((i2 + bounds.height) - screenInsets.bottom) - this.securityWarningHeight));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[Catch: OptionalDataException -> 0x0098, TryCatch #0 {OptionalDataException -> 0x0098, blocks: (B:22:0x005d, B:24:0x0063, B:26:0x006d, B:27:0x0077, B:28:0x007b, B:30:0x0088, B:32:0x008c, B:33:0x0093), top: B:37:0x005d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void deserializeResources(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Object object;
        Component component;
        this.ownedWindowList = new Vector<>();
        if (this.windowSerializedDataVersion < 2) {
            FocusManager focusManager = this.focusMgr;
            if (focusManager != null && (component = focusManager.focusOwner) != null) {
                KeyboardFocusManager.setMostRecentFocusOwner(this, component);
            }
            this.focusableWindowState = true;
        }
        while (true) {
            Object object2 = objectInputStream.readObject();
            if (object2 == null) {
                while (true) {
                    try {
                    } catch (OptionalDataException unused) {
                        return;
                    }
                }
                object = objectInputStream.readObject();
                this.icons = new ArrayList();
                while (object != null) {
                    if (object instanceof Image) {
                        this.icons.add((Image) object);
                    }
                    object = objectInputStream.readObject();
                }
            }
            String strIntern = ((String) object2).intern();
            if ("windowL" == strIntern) {
                addWindowListener((WindowListener) objectInputStream.readObject());
            } else if ("windowFocusL" == strIntern) {
                addWindowFocusListener((WindowFocusListener) objectInputStream.readObject());
            } else if ("windowStateL" == strIntern) {
                addWindowStateListener((WindowStateListener) objectInputStream.readObject());
            } else {
                objectInputStream.readObject();
            }
        }
        Object object3 = objectInputStream.readObject();
        if (object3 == null) {
            object = objectInputStream.readObject();
            this.icons = new ArrayList();
            while (object != null) {
            }
        } else if ("ownedL" == ((String) object3).intern()) {
            connectOwnedWindow((Window) objectInputStream.readObject());
        } else {
            objectInputStream.readObject();
        }
    }

    public static IdentityArrayList<Window> getAllUnblockedWindows() {
        IdentityArrayList<Window> identityArrayList;
        synchronized (allWindows) {
            try {
                identityArrayList = new IdentityArrayList<>();
                int i = 0;
                while (true) {
                    IdentityArrayList<Window> identityArrayList2 = allWindows;
                    if (i < identityArrayList2.size()) {
                        Window window = (Window) identityArrayList2.get(i);
                        if (!window.isModalBlocked()) {
                            identityArrayList.add(window);
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return identityArrayList;
    }

    public static IdentityArrayList<Window> getAllWindows() {
        IdentityArrayList<Window> identityArrayList;
        IdentityArrayList<Window> identityArrayList2 = allWindows;
        synchronized (identityArrayList2) {
            identityArrayList = new IdentityArrayList<>();
            identityArrayList.addAll(identityArrayList2);
        }
        return identityArrayList;
    }

    public static Window[] getOwnerlessWindows() {
        Window[] windows = getWindows();
        int i = 0;
        for (Window window : windows) {
            if (window.getOwner() == null) {
                i++;
            }
        }
        Window[] windowArr = new Window[i];
        int i2 = 0;
        for (Window window2 : windows) {
            if (window2.getOwner() == null) {
                windowArr[i2] = window2;
                i2++;
            }
        }
        return windowArr;
    }

    public static Window[] getWindows() {
        return getWindows(AppContext.getAppContext());
    }

    private void init(GraphicsConfiguration graphicsConfiguration) {
        GraphicsEnvironment.checkHeadless();
        this.syncLWRequests = systemSyncLWRequests;
        this.weakThis = new WeakReference<>(this);
        addToWindowList();
        setWarningString();
        this.cursor = Cursor.getPredefinedCursor(0);
        this.visible = false;
        GraphicsConfiguration graphicsConfigurationInitGC = initGC(graphicsConfiguration);
        if (graphicsConfigurationInitGC.getDevice().getType() != 0) {
            throw new IllegalArgumentException("not a screen device");
        }
        setLayout(new BorderLayout());
        Rectangle bounds = graphicsConfigurationInitGC.getBounds();
        Insets screenInsets = getToolkit().getScreenInsets(graphicsConfigurationInitGC);
        int x = getX() + bounds.f10094x + screenInsets.left;
        int y2 = getY() + bounds.f10095y + screenInsets.top;
        if (x != this.f10034x || y2 != this.f10035y) {
            setLocation(x, y2);
            setLocationByPlatform(locationByPlatformProp);
        }
        this.modalExclusionType = Dialog.ModalExclusionType.NO_EXCLUDE;
        SunToolkit.checkAndSetPolicy(this);
    }

    private void initDeserializedWindow() {
        setWarningString();
        this.inputContextLock = new Object();
        this.visible = false;
        this.weakThis = new WeakReference<>(this);
        Object obj = new Object();
        this.anchor = obj;
        Disposer.addRecord(obj, new WindowDisposerRecord(this.appContext, this));
        addToWindowList();
        initGC(null);
    }

    private GraphicsConfiguration initGC(GraphicsConfiguration graphicsConfiguration) {
        GraphicsEnvironment.checkHeadless();
        if (graphicsConfiguration == null) {
            graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        }
        setGraphicsConfiguration(graphicsConfiguration);
        return graphicsConfiguration;
    }

    private static native void initIDs();

    private static double limit(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }

    private void ownedInit(Window window) {
        this.parent = window;
        if (window != null) {
            window.addOwnedWindow(this.weakThis);
        }
        Disposer.addRecord(this.anchor, new WindowDisposerRecord(this.appContext, this));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        GraphicsEnvironment.checkHeadless();
        initDeserializedWindow();
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        this.syncLWRequests = fields.get("syncLWRequests", systemSyncLWRequests);
        this.state = fields.get("state", 0);
        this.focusableWindowState = fields.get("focusableWindowState", true);
        this.windowSerializedDataVersion = fields.get("windowSerializedDataVersion", 1);
        this.locationByPlatform = fields.get("locationByPlatform", locationByPlatformProp);
        this.focusMgr = (FocusManager) fields.get("focusMgr", (Object) null);
        setModalExclusionType((Dialog.ModalExclusionType) fields.get("modalExclusionType", Dialog.ModalExclusionType.NO_EXCLUDE));
        boolean z = fields.get("alwaysOnTop", false);
        if (z) {
            setAlwaysOnTop(z);
        }
        this.shape = (Shape) fields.get(VMetaDataKey.META_KEY_SHAPE, (Object) null);
        this.opacity = fields.get("opacity", 1.0f);
        this.securityWarningWidth = 0;
        this.securityWarningHeight = 0;
        this.securityWarningPointX = 2.0d;
        this.securityWarningPointY = 0.0d;
        this.securityWarningAlignmentX = 1.0f;
        this.securityWarningAlignmentY = 0.0f;
        deserializeResources(objectInputStream);
    }

    private void removeFromWindowList() {
        removeFromWindowList(this.appContext, this.weakThis);
    }

    private static void setLayersOpaque(Component component, boolean z) {
        if (SunToolkit.isInstanceOf(component, "javax.swing.RootPaneContainer")) {
            JRootPane rootPane = ((RootPaneContainer) component).getRootPane();
            JLayeredPane layeredPane = rootPane.getLayeredPane();
            JComponent contentPane = rootPane.getContentPane();
            JComponent jComponent = contentPane instanceof JComponent ? contentPane : null;
            layeredPane.setOpaque(z);
            rootPane.setOpaque(z);
            if (jComponent != null) {
                jComponent.setOpaque(z);
                if (jComponent.getComponentCount() > 0) {
                    Component component2 = jComponent.getComponent(0);
                    if (component2 instanceof RootPaneContainer) {
                        setLayersOpaque(component2, z);
                    }
                }
            }
        }
    }

    private void setWarningString() {
        this.warningString = null;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null || securityManager.checkTopLevelWindow(this)) {
            return;
        }
        this.warningString = (String) AccessController.doPrivileged(new GetPropertyAction("awt.appletWarning", "Java Applet Window"));
    }

    public static void updateChildFocusableWindowState(Window window) {
        if (window.getPeer() != null && window.isShowing()) {
            window.getPeer().updateFocusableWindowState();
        }
        for (int i = 0; i < window.ownedWindowList.size(); i++) {
            Window window2 = window.ownedWindowList.elementAt(i).get();
            if (window2 != null) {
                updateChildFocusableWindowState(window2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindow() {
        synchronized (getTreeLock()) {
            try {
                WindowPeer peer = getPeer();
                if (peer != null) {
                    peer.updateWindow();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this) {
            FocusManager focusManager = new FocusManager();
            this.focusMgr = focusManager;
            focusManager.focusRoot = this;
            focusManager.focusOwner = getMostRecentFocusOwner();
            objectOutputStream.defaultWriteObject();
            this.focusMgr = null;
            AWTEventMulticaster.save(objectOutputStream, "windowL", this.windowListener);
            AWTEventMulticaster.save(objectOutputStream, "windowFocusL", this.windowFocusListener);
            AWTEventMulticaster.save(objectOutputStream, "windowStateL", this.windowStateListener);
        }
        objectOutputStream.writeObject(null);
        synchronized (this.ownedWindowList) {
            for (int i = 0; i < this.ownedWindowList.size(); i++) {
                try {
                    Window window = this.ownedWindowList.elementAt(i).get();
                    if (window != null) {
                        objectOutputStream.writeObject("ownedL");
                        objectOutputStream.writeObject(window);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        objectOutputStream.writeObject(null);
        java.util.List<Image> list = this.icons;
        if (list != null) {
            for (Image image : list) {
                if (image instanceof Serializable) {
                    objectOutputStream.writeObject(image);
                }
            }
        }
        objectOutputStream.writeObject(null);
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                Container container = this.parent;
                if (container != null && container.getPeer() == null) {
                    container.addNotify();
                }
                if (this.peer == null) {
                    this.peer = getToolkit().createWindow(this);
                }
                IdentityArrayList<Window> identityArrayList = allWindows;
                synchronized (identityArrayList) {
                    identityArrayList.add(this);
                }
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addOwnedWindow(WeakReference weakReference) {
        if (weakReference != null) {
            synchronized (this.ownedWindowList) {
                try {
                    if (!this.ownedWindowList.contains(weakReference)) {
                        this.ownedWindowList.addElement(weakReference);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        super.addPropertyChangeListener(propertyChangeListener);
    }

    public synchronized void addWindowFocusListener(WindowFocusListener windowFocusListener) {
        if (windowFocusListener == null) {
            return;
        }
        this.windowFocusListener = AWTEventMulticaster.add(this.windowFocusListener, windowFocusListener);
        this.newEventsOnly = true;
    }

    public synchronized void addWindowListener(WindowListener windowListener) {
        if (windowListener == null) {
            return;
        }
        this.newEventsOnly = true;
        this.windowListener = AWTEventMulticaster.add(this.windowListener, windowListener);
    }

    public synchronized void addWindowStateListener(WindowStateListener windowStateListener) {
        if (windowStateListener == null) {
            return;
        }
        this.windowStateListener = AWTEventMulticaster.add(this.windowStateListener, windowStateListener);
        this.newEventsOnly = true;
    }

    @Deprecated
    public void applyResourceBundle(String str) {
        applyResourceBundle(ResourceBundle.getBundle(str));
    }

    @Override // org.apache.poi.java.awt.Container
    public boolean canContainFocusOwner(Component component) {
        return super.canContainFocusOwner(component) && isFocusableWindow();
    }

    public final void closeSplashScreen() {
        if (!this.isTrayIconWindow && beforeFirstWindowShown.getAndSet(false)) {
            SunToolkit.closeSplashScreen();
            SplashScreen.markClosed();
        }
    }

    public void connectOwnedWindow(Window window) {
        window.parent = this;
        addOwnedWindow(window.weakThis);
    }

    @Override // org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (Window.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Override // org.apache.poi.java.awt.Component
    public void createBufferStrategy(int i) {
        super.createBufferStrategy(i);
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void dispatchEventImpl(AWTEvent aWTEvent) {
        if (aWTEvent.getID() == 101) {
            invalidate();
            validate();
        }
        super.dispatchEventImpl(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean dispatchMouseWheelToAncestor(MouseWheelEvent mouseWheelEvent) {
        return false;
    }

    public void dispose() {
        doDispose();
    }

    public void disposeImpl() {
        dispose();
        if (getPeer() != null) {
            doDispose();
        }
    }

    public void doDispose() {
        PrintStream printStream;
        String str;
        Runnable runnable = new Runnable() { // from class: org.apache.poi.java.awt.Window.1DisposeAction
            @Override // java.lang.Runnable
            public void run() {
                int size;
                Object[] objArr;
                Window.this.disposing = true;
                try {
                    GraphicsDevice device = Window.this.getGraphicsConfiguration().getDevice();
                    if (device.getFullScreenWindow() == Window.this) {
                        device.setFullScreenWindow(null);
                    }
                    synchronized (Window.this.ownedWindowList) {
                        size = Window.this.ownedWindowList.size();
                        objArr = new Object[size];
                        Window.this.ownedWindowList.copyInto(objArr);
                    }
                    for (int i = 0; i < size; i++) {
                        Window window = (Window) ((WeakReference) objArr[i]).get();
                        if (window != null) {
                            window.disposeImpl();
                        }
                    }
                    Window.this.hide();
                    Window window2 = Window.this;
                    window2.beforeFirstShow = true;
                    window2.removeNotify();
                    synchronized (Window.this.inputContextLock) {
                        try {
                            InputContext inputContext = Window.this.inputContext;
                            if (inputContext != null) {
                                inputContext.dispose();
                                Window.this.inputContext = null;
                            }
                        } finally {
                        }
                    }
                    Window.this.clearCurrentFocusCycleRootOnHide();
                    Window.this.disposing = false;
                } catch (Throwable th) {
                    Window.this.disposing = false;
                    throw th;
                }
            }
        };
        if (EventQueue.isDispatchThread()) {
            runnable.run();
        } else {
            try {
                EventQueue.invokeAndWait(this, runnable);
            } catch (InterruptedException e) {
                e = e;
                printStream = System.err;
                str = "Disposal was interrupted:";
                printStream.println(str);
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e = e2;
                printStream = System.err;
                str = "Exception during disposal:";
                printStream.println(str);
                e.printStackTrace();
            }
        }
        postWindowEvent(202);
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public boolean eventEnabled(AWTEvent aWTEvent) {
        switch (aWTEvent.f10031id) {
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
                return ((this.eventMask & 64) == 0 && this.windowListener == null) ? false : true;
            case 207:
            case JPEG.RST0 /* 208 */:
                return ((this.eventMask & 524288) == 0 && this.windowFocusListener == null) ? false : true;
            case JPEG.RST1 /* 209 */:
                return ((this.eventMask & 262144) == 0 && this.windowStateListener == null) ? false : true;
            default:
                return super.eventEnabled(aWTEvent);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTWindow();
        }
        return this.accessibleContext;
    }

    @Override // org.apache.poi.java.awt.Component
    public Color getBackground() {
        return super.getBackground();
    }

    @Override // org.apache.poi.java.awt.Component
    public BufferStrategy getBufferStrategy() {
        return super.getBufferStrategy();
    }

    @Override // org.apache.poi.java.awt.Component
    public final Container getContainer() {
        return null;
    }

    public Window getDocumentRoot() {
        Window owner;
        synchronized (getTreeLock()) {
            owner = this;
            while (owner.getOwner() != null) {
                try {
                    owner = owner.getOwner();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return owner;
    }

    @Override // org.apache.poi.java.awt.Component
    public final Container getFocusCycleRootAncestor() {
        return null;
    }

    public Component getFocusOwner() {
        if (isFocused()) {
            return KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        }
        return null;
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public Set<AWTKeyStroke> getFocusTraversalKeys(int i) {
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        Set<AWTKeyStroke>[] setArr = this.focusTraversalKeys;
        Set<AWTKeyStroke> set = setArr != null ? setArr[i] : null;
        return set != null ? set : KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalKeys(i);
    }

    public boolean getFocusableWindowState() {
        return this.focusableWindowState;
    }

    public java.util.List<Image> getIconImages() {
        java.util.List<Image> list = this.icons;
        return (list == null || list.size() == 0) ? new ArrayList() : new ArrayList(list);
    }

    @Override // org.apache.poi.java.awt.Component
    public InputContext getInputContext() {
        synchronized (this.inputContextLock) {
            try {
                if (this.inputContext == null) {
                    this.inputContext = InputContext.getInstance();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.inputContext;
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        WindowFocusListener windowFocusListener;
        if (cls == WindowFocusListener.class) {
            windowFocusListener = this.windowFocusListener;
        } else if (cls == WindowStateListener.class) {
            windowFocusListener = this.windowStateListener;
        } else {
            if (cls != WindowListener.class) {
                return (T[]) super.getListeners(cls);
            }
            windowFocusListener = this.windowListener;
        }
        return (T[]) AWTEventMulticaster.getListeners(windowFocusListener, cls);
    }

    @Override // org.apache.poi.java.awt.Component
    public Locale getLocale() {
        Locale locale = this.locale;
        return locale == null ? Locale.getDefault() : locale;
    }

    @Override // org.apache.poi.java.awt.Component
    public final Point getLocationOnWindow() {
        return new Point(0, 0);
    }

    public Dialog getModalBlocker() {
        return this.modalBlocker;
    }

    public Dialog.ModalExclusionType getModalExclusionType() {
        return this.modalExclusionType;
    }

    public Component getMostRecentFocusOwner() {
        if (isFocused()) {
            return getFocusOwner();
        }
        Component mostRecentFocusOwner = KeyboardFocusManager.getMostRecentFocusOwner(this);
        if (mostRecentFocusOwner != null) {
            return mostRecentFocusOwner;
        }
        if (isFocusableWindow()) {
            return getFocusTraversalPolicy().getInitialComponent(this);
        }
        return null;
    }

    public float getOpacity() {
        float f;
        synchronized (getTreeLock()) {
            f = this.opacity;
        }
        return f;
    }

    public Window[] getOwnedWindows() {
        return getOwnedWindows_NoClientCode();
    }

    public final Window[] getOwnedWindows_NoClientCode() {
        Window[] windowArr;
        synchronized (this.ownedWindowList) {
            try {
                int size = this.ownedWindowList.size();
                windowArr = new Window[size];
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    Window window = this.ownedWindowList.elementAt(i2).get();
                    windowArr[i] = window;
                    if (window != null) {
                        i++;
                    }
                }
                if (size != i) {
                    windowArr = (Window[]) Arrays.copyOf(windowArr, i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return windowArr;
    }

    public Window getOwner() {
        return getOwner_NoClientCode();
    }

    public final Window getOwner_NoClientCode() {
        return (Window) this.parent;
    }

    public Shape getShape() {
        Path2D.Float r12;
        synchronized (getTreeLock()) {
            Shape shape = this.shape;
            r12 = shape == null ? null : new Path2D.Float(shape);
        }
        return r12;
    }

    public Component getTemporaryLostComponent() {
        return this.temporaryLostComponent;
    }

    @Override // org.apache.poi.java.awt.Component
    public Toolkit getToolkit() {
        return Toolkit.getDefaultToolkit();
    }

    public Type getType() {
        Type type;
        synchronized (getObjectLock()) {
            type = this.type;
        }
        return type;
    }

    public final String getWarningString() {
        return this.warningString;
    }

    public synchronized WindowFocusListener[] getWindowFocusListeners() {
        return getListeners(WindowFocusListener.class);
    }

    public synchronized WindowListener[] getWindowListeners() {
        return getListeners(WindowListener.class);
    }

    public synchronized WindowStateListener[] getWindowStateListeners() {
        return getListeners(WindowStateListener.class);
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public void hide() {
        synchronized (this.ownedWindowList) {
            for (int i = 0; i < this.ownedWindowList.size(); i++) {
                try {
                    Window window = this.ownedWindowList.elementAt(i).get();
                    if (window != null && window.visible) {
                        window.hide();
                        window.showWithParent = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (isModalBlocked()) {
            this.modalBlocker.unblockWindow(this);
        }
        super.hide();
    }

    public boolean isActive() {
        return KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow() == this;
    }

    public final boolean isAlwaysOnTop() {
        return this.alwaysOnTop;
    }

    public boolean isAlwaysOnTopSupported() {
        return Toolkit.getDefaultToolkit().isAlwaysOnTopSupported();
    }

    public boolean isAutoRequestFocus() {
        return this.autoRequestFocus;
    }

    public boolean isDisposing() {
        return this.disposing;
    }

    @Override // org.apache.poi.java.awt.Container
    public final boolean isFocusCycleRoot() {
        return true;
    }

    public final boolean isFocusableWindow() {
        if (!getFocusableWindowState()) {
            return false;
        }
        if ((this instanceof Frame) || (this instanceof Dialog)) {
            return true;
        }
        if (getFocusTraversalPolicy().getDefaultComponent(this) == null) {
            return false;
        }
        for (Window owner = getOwner(); owner != null; owner = owner.getOwner()) {
            if ((owner instanceof Frame) || (owner instanceof Dialog)) {
                return owner.isShowing();
            }
        }
        return false;
    }

    public boolean isFocused() {
        return KeyboardFocusManager.getCurrentKeyboardFocusManager().getGlobalFocusedWindow() == this;
    }

    public boolean isLocationByPlatform() {
        boolean z;
        synchronized (getTreeLock()) {
            z = this.locationByPlatform;
        }
        return z;
    }

    public boolean isModalBlocked() {
        return this.modalBlocker != null;
    }

    public boolean isModalExcluded(Dialog.ModalExclusionType modalExclusionType) {
        Dialog.ModalExclusionType modalExclusionType2 = this.modalExclusionType;
        if (modalExclusionType2 != null && modalExclusionType2.compareTo(modalExclusionType) >= 0) {
            return true;
        }
        Window owner_NoClientCode = getOwner_NoClientCode();
        return owner_NoClientCode != null && owner_NoClientCode.isModalExcluded(modalExclusionType);
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean isOpaque() {
        Color background = getBackground();
        return background == null || background.getAlpha() == 255;
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean isRecursivelyVisible() {
        return this.visible;
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean isShowing() {
        return this.visible;
    }

    @Override // org.apache.poi.java.awt.Container
    public boolean isValidateRoot() {
        return true;
    }

    public void pack() {
        Container container = this.parent;
        if (container != null && container.getPeer() == null) {
            container.addNotify();
        }
        if (this.peer == null) {
            addNotify();
        }
        Dimension preferredSize = getPreferredSize();
        if (this.peer != null) {
            setClientSize(preferredSize.width, preferredSize.height);
        }
        if (this.beforeFirstShow) {
            this.isPacked = true;
        }
        validateUnconditionally();
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void paint(Graphics graphics) {
        if (!isOpaque()) {
            Graphics graphicsCreate = graphics.create();
            try {
                if (graphicsCreate instanceof Graphics2D) {
                    graphicsCreate.setColor(getBackground());
                    ((Graphics2D) graphicsCreate).setComposite(AlphaComposite.getInstance(2));
                    graphicsCreate.fillRect(0, 0, getWidth(), getHeight());
                }
            } finally {
                graphicsCreate.dispose();
            }
        }
        super.paint(graphics);
    }

    @Override // org.apache.poi.java.awt.Component, org.apache.poi.java.awt.MenuContainer
    @Deprecated
    public boolean postEvent(Event event) {
        if (!handleEvent(event)) {
            return false;
        }
        event.consume();
        return true;
    }

    public synchronized void postWindowEvent(int i) {
        try {
            if (this.windowListener != null || (this.eventMask & 64) != 0 || Toolkit.enabledOnToolkit(64L)) {
                Toolkit.getEventQueue().postEvent(new WindowEvent(this, i));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.Container
    public void preProcessKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.isActionKey() && keyEvent.getKeyCode() == 112 && keyEvent.isControlDown() && keyEvent.isShiftDown() && keyEvent.getID() == 401) {
            list(System.out, 0);
        }
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
    }

    public void processWindowEvent(WindowEvent windowEvent) {
        WindowListener windowListener = this.windowListener;
        if (windowListener != null) {
            switch (windowEvent.getID()) {
                case 200:
                    windowListener.windowOpened(windowEvent);
                    break;
                case 201:
                    windowListener.windowClosing(windowEvent);
                    break;
                case 202:
                    windowListener.windowClosed(windowEvent);
                    break;
                case 203:
                    windowListener.windowIconified(windowEvent);
                    break;
                case 204:
                    windowListener.windowDeiconified(windowEvent);
                    break;
                case 205:
                    windowListener.windowActivated(windowEvent);
                    break;
                case 206:
                    windowListener.windowDeactivated(windowEvent);
                    break;
            }
        }
    }

    public void processWindowFocusEvent(WindowEvent windowEvent) {
        WindowFocusListener windowFocusListener = this.windowFocusListener;
        if (windowFocusListener != null) {
            int id = windowEvent.getID();
            if (id == 207) {
                windowFocusListener.windowGainedFocus(windowEvent);
            } else {
                if (id != 208) {
                    return;
                }
                windowFocusListener.windowLostFocus(windowEvent);
            }
        }
    }

    public void processWindowStateEvent(WindowEvent windowEvent) {
        WindowStateListener windowStateListener = this.windowStateListener;
        if (windowStateListener == null || windowEvent.getID() != 209) {
            return;
        }
        windowStateListener.windowStateChanged(windowEvent);
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void removeNotify() {
        synchronized (getTreeLock()) {
            IdentityArrayList<Window> identityArrayList = allWindows;
            synchronized (identityArrayList) {
                identityArrayList.remove(this);
            }
            super.removeNotify();
        }
    }

    public void removeOwnedWindow(WeakReference weakReference) {
        if (weakReference != null) {
            this.ownedWindowList.removeElement(weakReference);
        }
    }

    public synchronized void removeWindowFocusListener(WindowFocusListener windowFocusListener) {
        if (windowFocusListener == null) {
            return;
        }
        this.windowFocusListener = AWTEventMulticaster.remove(this.windowFocusListener, windowFocusListener);
    }

    public synchronized void removeWindowListener(WindowListener windowListener) {
        if (windowListener == null) {
            return;
        }
        this.windowListener = AWTEventMulticaster.remove(this.windowListener, windowListener);
    }

    public synchronized void removeWindowStateListener(WindowStateListener windowStateListener) {
        if (windowStateListener == null) {
            return;
        }
        this.windowStateListener = AWTEventMulticaster.remove(this.windowStateListener, windowStateListener);
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public void reshape(int i, int i2, int i4, int i5) {
        if (isMinimumSizeSet()) {
            Dimension minimumSize = getMinimumSize();
            int i6 = minimumSize.width;
            if (i4 < i6) {
                i4 = i6;
            }
            int i7 = minimumSize.height;
            if (i5 < i7) {
                i5 = i7;
            }
        }
        super.reshape(i, i2, i4, i5);
    }

    public final void setAlwaysOnTop(boolean z) {
        boolean z2;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.SET_WINDOW_ALWAYS_ON_TOP_PERMISSION);
        }
        synchronized (this) {
            z2 = this.alwaysOnTop;
            this.alwaysOnTop = z;
        }
        if (z2 != z) {
            if (isAlwaysOnTopSupported()) {
                WindowPeer windowPeer = this.peer;
                synchronized (getTreeLock()) {
                    if (windowPeer != null) {
                        try {
                            windowPeer.updateAlwaysOnTopState();
                        } finally {
                        }
                    }
                }
            }
            firePropertyChange("alwaysOnTop", z2, z);
        }
    }

    public void setAutoRequestFocus(boolean z) {
        this.autoRequestFocus = z;
    }

    @Override // org.apache.poi.java.awt.Component
    public void setBackground(Color color) {
        Color background = getBackground();
        super.setBackground(color);
        if (background == null || !background.equals(color)) {
            int alpha = background != null ? background.getAlpha() : 255;
            int alpha2 = color != null ? color.getAlpha() : 255;
            if (alpha == 255 && alpha2 < 255) {
                GraphicsConfiguration graphicsConfiguration = getGraphicsConfiguration();
                GraphicsDevice device = graphicsConfiguration.getDevice();
                if (graphicsConfiguration.getDevice().getFullScreenWindow() == this) {
                    throw new IllegalComponentStateException("Making full-screen window non opaque is not supported.");
                }
                if (!graphicsConfiguration.isTranslucencyCapable()) {
                    GraphicsConfiguration translucencyCapableGC = device.getTranslucencyCapableGC();
                    if (translucencyCapableGC == null) {
                        throw new UnsupportedOperationException("PERPIXEL_TRANSLUCENT translucency is not supported");
                    }
                    setGraphicsConfiguration(translucencyCapableGC);
                }
                setLayersOpaque(this, false);
            } else if (alpha < 255 && alpha2 == 255) {
                setLayersOpaque(this, true);
            }
            WindowPeer peer = getPeer();
            if (peer != null) {
                peer.setOpaque(alpha2 == 255);
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void setBounds(int i, int i2, int i4, int i5) {
        synchronized (getTreeLock()) {
            try {
                if (getBoundsOp() == 1 || getBoundsOp() == 3) {
                    this.locationByPlatform = false;
                }
                super.setBounds(i, i2, i4, i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setClientSize(int i, int i2) {
        synchronized (getTreeLock()) {
            setBoundsOp(4);
            setBounds(this.f10034x, this.f10035y, i, i2);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void setCursor(Cursor cursor) {
        if (cursor == null) {
            cursor = Cursor.getPredefinedCursor(0);
        }
        super.setCursor(cursor);
    }

    public void setFocusableWindowState(boolean z) {
        boolean z2;
        synchronized (this) {
            z2 = this.focusableWindowState;
            this.focusableWindowState = z;
        }
        WindowPeer windowPeer = this.peer;
        if (windowPeer != null) {
            windowPeer.updateFocusableWindowState();
        }
        firePropertyChange("focusableWindowState", z2, z);
        if (z2 && !z && isFocused()) {
            for (Window owner = getOwner(); owner != null; owner = owner.getOwner()) {
                Component mostRecentFocusOwner = KeyboardFocusManager.getMostRecentFocusOwner(owner);
                if (mostRecentFocusOwner != null && mostRecentFocusOwner.requestFocus(false, CausedFocusEvent.Cause.ACTIVATION)) {
                    return;
                }
            }
            KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void setGraphicsConfiguration(GraphicsConfiguration graphicsConfiguration) {
        if (graphicsConfiguration == null) {
            graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        }
        synchronized (getTreeLock()) {
            try {
                super.setGraphicsConfiguration(graphicsConfiguration);
                PlatformLogger platformLogger = log;
                if (platformLogger.isLoggable(400)) {
                    platformLogger.finer("+ Window.setGraphicsConfiguration(): new GC is \n+ " + getGraphicsConfiguration_NoClientCode() + "\n+ this is " + this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setIconImage(Image image) {
        ArrayList arrayList = new ArrayList();
        if (image != null) {
            arrayList.add(image);
        }
        setIconImages(arrayList);
    }

    public synchronized void setIconImages(java.util.List<? extends Image> list) {
        try {
            this.icons = list == null ? new ArrayList() : new ArrayList(list);
            WindowPeer windowPeer = this.peer;
            if (windowPeer != null) {
                windowPeer.updateIconImages();
            }
            firePropertyChange("iconImage", (Object) null, (Object) null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void setLocation(int i, int i2) {
        super.setLocation(i, i2);
    }

    public void setLocationByPlatform(boolean z) {
        synchronized (getTreeLock()) {
            if (z) {
                try {
                    if (isShowing()) {
                        throw new IllegalComponentStateException("The window is showing on screen.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.locationByPlatform = z;
        }
    }

    public void setLocationRelativeTo(Component component) {
        int iM7d;
        Rectangle bounds;
        int iM7d2;
        getGraphicsConfiguration_NoClientCode().getBounds();
        Dimension size = getSize();
        Window containingWindow = SunToolkit.getContainingWindow(component);
        if (component == null || containingWindow == null) {
            GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Rectangle bounds2 = localGraphicsEnvironment.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
            Point centerPoint = localGraphicsEnvironment.getCenterPoint();
            int i = centerPoint.f10092x - (size.width / 2);
            iM7d = centerPoint.f10093y - (size.height / 2);
            bounds = bounds2;
            iM7d2 = i;
        } else if (component.isShowing()) {
            Rectangle bounds3 = containingWindow.getGraphicsConfiguration().getBounds();
            Dimension size2 = component.getSize();
            Point locationOnScreen = component.getLocationOnScreen();
            int i2 = locationOnScreen.f10092x;
            int i4 = size2.width;
            int i5 = size.width;
            int iM7d3 = AbstractC0000a.m7d(i4, i5, 2, i2);
            int i6 = locationOnScreen.f10093y;
            int i7 = size2.height;
            int i8 = size.height;
            int iM7d4 = AbstractC0000a.m7d(i7, i8, 2, i6);
            int i9 = iM7d4 + i8;
            int i10 = bounds3.f10095y;
            int i11 = bounds3.height;
            if (i9 > i10 + i11) {
                int i12 = (i10 + i11) - i8;
                iM7d = i12;
                bounds = bounds3;
                iM7d2 = (i4 / 2) + (i2 - bounds3.f10094x) < bounds3.width / 2 ? i2 + i4 : i2 - i5;
            } else {
                iM7d = iM7d4;
                bounds = bounds3;
                iM7d2 = iM7d3;
            }
        } else {
            bounds = containingWindow.getGraphicsConfiguration().getBounds();
            iM7d2 = AbstractC0000a.m7d(bounds.width, size.width, 2, bounds.f10094x);
            iM7d = AbstractC0000a.m7d(bounds.height, size.height, 2, bounds.f10095y);
        }
        int i13 = size.height;
        int i14 = iM7d + i13;
        int i15 = bounds.f10095y;
        int i16 = bounds.height;
        if (i14 > i15 + i16) {
            iM7d = (i16 + i15) - i13;
        }
        if (iM7d >= i15) {
            i15 = iM7d;
        }
        int i17 = size.width;
        int i18 = iM7d2 + i17;
        int i19 = bounds.f10094x;
        int i20 = bounds.width;
        if (i18 > i19 + i20) {
            iM7d2 = (i20 + i19) - i17;
        }
        if (iM7d2 >= i19) {
            i19 = iM7d2;
        }
        setLocation(i19, i15);
    }

    @Override // org.apache.poi.java.awt.Component
    public void setMinimumSize(Dimension dimension) {
        synchronized (getTreeLock()) {
            try {
                super.setMinimumSize(dimension);
                Dimension size = getSize();
                if (isMinimumSizeSet()) {
                    int i = size.width;
                    int i2 = dimension.width;
                    if (i < i2 || size.height < dimension.height) {
                        setSize(Math.max(this.width, i2), Math.max(this.height, dimension.height));
                    }
                }
                WindowPeer windowPeer = this.peer;
                if (windowPeer != null) {
                    windowPeer.updateMinimumSize();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setModalBlocked(Dialog dialog, boolean z, boolean z2) {
        WindowPeer windowPeer;
        this.modalBlocker = z ? dialog : null;
        if (!z2 || (windowPeer = this.peer) == null) {
            return;
        }
        windowPeer.setModalBlocked(dialog, z);
    }

    public void setModalExclusionType(Dialog.ModalExclusionType modalExclusionType) {
        SecurityManager securityManager;
        if (modalExclusionType == null) {
            modalExclusionType = Dialog.ModalExclusionType.NO_EXCLUDE;
        }
        if (!Toolkit.getDefaultToolkit().isModalExclusionTypeSupported(modalExclusionType)) {
            modalExclusionType = Dialog.ModalExclusionType.NO_EXCLUDE;
        }
        if (this.modalExclusionType == modalExclusionType) {
            return;
        }
        if (modalExclusionType == Dialog.ModalExclusionType.TOOLKIT_EXCLUDE && (securityManager = System.getSecurityManager()) != null) {
            securityManager.checkPermission(SecurityConstants.AWT.TOOLKIT_MODALITY_PERMISSION);
        }
        this.modalExclusionType = modalExclusionType;
    }

    public void setOpacity(float f) {
        synchronized (getTreeLock()) {
            try {
                if (f < 0.0f || f > 1.0f) {
                    throw new IllegalArgumentException("The value of opacity should be in the range [0.0f .. 1.0f].");
                }
                if (f < 1.0f) {
                    GraphicsConfiguration graphicsConfiguration = getGraphicsConfiguration();
                    GraphicsDevice device = graphicsConfiguration.getDevice();
                    if (graphicsConfiguration.getDevice().getFullScreenWindow() == this) {
                        throw new IllegalComponentStateException("Setting opacity for full-screen window is not supported.");
                    }
                    if (!device.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)) {
                        throw new UnsupportedOperationException("TRANSLUCENT translucency is not supported.");
                    }
                }
                this.opacity = f;
                WindowPeer peer = getPeer();
                if (peer != null) {
                    peer.setOpacity(f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setShape(Shape shape) {
        synchronized (getTreeLock()) {
            if (shape != null) {
                try {
                    GraphicsConfiguration graphicsConfiguration = getGraphicsConfiguration();
                    GraphicsDevice device = graphicsConfiguration.getDevice();
                    if (graphicsConfiguration.getDevice().getFullScreenWindow() == this) {
                        throw new IllegalComponentStateException("Setting shape for full-screen window is not supported.");
                    }
                    if (!device.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT)) {
                        throw new UnsupportedOperationException("PERPIXEL_TRANSPARENT translucency is not supported.");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Region region = null;
            this.shape = shape == null ? null : new Path2D.Float(shape);
            WindowPeer peer = getPeer();
            if (peer != null) {
                if (shape != null) {
                    region = Region.getInstance(shape, (AffineTransform) null);
                }
                peer.applyShape(region);
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void setSize(int i, int i2) {
        super.setSize(i, i2);
    }

    public Component setTemporaryLostComponent(Component component) {
        Component component2 = this.temporaryLostComponent;
        if (component == null || component.canBeFocusOwner()) {
            this.temporaryLostComponent = component;
            return component2;
        }
        this.temporaryLostComponent = null;
        return component2;
    }

    public void setType(Type type) {
        if (type == null) {
            throw new IllegalArgumentException("type should not be null.");
        }
        synchronized (getTreeLock()) {
            if (isDisplayable()) {
                throw new IllegalComponentStateException("The window is displayable.");
            }
            synchronized (getObjectLock()) {
                this.type = type;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void setVisible(boolean z) {
        super.setVisible(z);
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public void show() throws Throwable {
        if (this.peer == null) {
            addNotify();
        }
        validateUnconditionally();
        this.isInShow = true;
        if (this.visible) {
            toFront();
        } else {
            this.beforeFirstShow = false;
            closeSplashScreen();
            Dialog.checkShouldBeBlocked(this);
            super.show();
            this.locationByPlatform = false;
            for (int i = 0; i < this.ownedWindowList.size(); i++) {
                Window window = this.ownedWindowList.elementAt(i).get();
                if (window != null && window.showWithParent) {
                    window.show();
                    window.showWithParent = false;
                }
            }
            if (isModalBlocked()) {
                this.modalBlocker.toFront_NoClientCode();
            } else {
                updateChildrenBlocking();
            }
            if ((this instanceof Frame) || (this instanceof Dialog)) {
                updateChildFocusableWindowState(this);
            }
        }
        this.isInShow = false;
        if ((this.state & 1) == 0) {
            postWindowEvent(200);
            this.state = 1 | this.state;
        }
    }

    public void toBack() {
        toBack_NoClientCode();
    }

    public final void toBack_NoClientCode() {
        WindowPeer windowPeer;
        if (isAlwaysOnTop()) {
            try {
                setAlwaysOnTop(false);
            } catch (SecurityException unused) {
            }
        }
        if (!this.visible || (windowPeer = this.peer) == null) {
            return;
        }
        windowPeer.toBack();
    }

    public void toFront() {
        toFront_NoClientCode();
    }

    public final void toFront_NoClientCode() {
        if (this.visible) {
            WindowPeer windowPeer = this.peer;
            if (windowPeer != null) {
                windowPeer.toFront();
            }
            if (isModalBlocked()) {
                this.modalBlocker.toFront_NoClientCode();
            }
        }
    }

    public void updateChildrenBlocking() {
        Vector vector = new Vector();
        for (Window window : getOwnedWindows()) {
            vector.add(window);
        }
        for (int i = 0; i < vector.size(); i++) {
            Window window2 = (Window) vector.get(i);
            if (window2.isVisible()) {
                if (window2.isModalBlocked()) {
                    window2.getModalBlocker().unblockWindow(window2);
                }
                Dialog.checkShouldBeBlocked(window2);
                for (Window window3 : window2.getOwnedWindows()) {
                    vector.add(window3);
                }
            }
        }
    }

    public Window(Frame frame) {
        this(frame == null ? null : frame.getGraphicsConfiguration());
        ownedInit(frame);
    }

    private static Window[] getWindows(AppContext appContext) {
        Window[] windowArr;
        synchronized (Window.class) {
            try {
                Vector vector = (Vector) appContext.get(Window.class);
                if (vector != null) {
                    int size = vector.size();
                    windowArr = new Window[size];
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        Window window = (Window) ((WeakReference) vector.get(i2)).get();
                        if (window != null) {
                            windowArr[i] = window;
                            i++;
                        }
                    }
                    if (size != i) {
                        windowArr = (Window[]) Arrays.copyOf(windowArr, i);
                    }
                } else {
                    windowArr = new Window[0];
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return windowArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeFromWindowList(AppContext appContext, WeakReference weakReference) {
        synchronized (Window.class) {
            try {
                Vector vector = (Vector) appContext.get(Window.class);
                if (vector != null) {
                    vector.remove(weakReference);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        super.addPropertyChangeListener(str, propertyChangeListener);
    }

    @Deprecated
    public void applyResourceBundle(ResourceBundle resourceBundle) {
        applyComponentOrientation(ComponentOrientation.getOrientation(resourceBundle));
    }

    @Override // org.apache.poi.java.awt.Component
    public void createBufferStrategy(int i, BufferCapabilities bufferCapabilities) {
        super.createBufferStrategy(i, bufferCapabilities);
    }

    @Override // org.apache.poi.java.awt.Component
    public void setBounds(Rectangle rectangle) {
        setBounds(rectangle.f10094x, rectangle.f10095y, rectangle.width, rectangle.height);
    }

    @Override // org.apache.poi.java.awt.Component
    public void setLocation(Point point) {
        super.setLocation(point);
    }

    @Override // org.apache.poi.java.awt.Component
    public void setSize(Dimension dimension) {
        super.setSize(dimension);
    }

    public Window(GraphicsConfiguration graphicsConfiguration) {
        this.syncLWRequests = false;
        this.beforeFirstShow = true;
        this.disposing = false;
        this.ownedWindowList = new Vector<>();
        this.inputContextLock = new Object();
        this.focusableWindowState = true;
        this.autoRequestFocus = true;
        this.isInShow = false;
        this.opacity = 1.0f;
        this.shape = null;
        this.isTrayIconWindow = false;
        this.securityWarningWidth = 0;
        this.securityWarningHeight = 0;
        this.securityWarningPointX = 2.0d;
        this.securityWarningPointY = 0.0d;
        this.securityWarningAlignmentX = 1.0f;
        this.securityWarningAlignmentY = 0.0f;
        this.anchor = new Object();
        this.type = Type.NORMAL;
        this.windowSerializedDataVersion = 2;
        this.locationByPlatform = locationByPlatformProp;
        init(graphicsConfiguration);
    }

    public Window(Window window) {
        this(window == null ? null : window.getGraphicsConfiguration());
        ownedInit(window);
    }

    public Window(Window window, GraphicsConfiguration graphicsConfiguration) {
        this(graphicsConfiguration);
        ownedInit(window);
    }

    @Override // org.apache.poi.java.awt.Component
    public final void applyCurrentShape() {
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public final void clearMostRecentFocusOwnerOnHide() {
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public final void mixOnReshaping() {
    }

    @Override // org.apache.poi.java.awt.Component
    public void updateZOrder() {
    }

    @Override // org.apache.poi.java.awt.Container
    public void adjustDecendantsOnParent(int i) {
    }

    @Override // org.apache.poi.java.awt.Component
    public final void applyCompoundShape(Region region) {
    }

    public void deliverMouseWheelToAncestor(MouseWheelEvent mouseWheelEvent) {
    }

    @Override // org.apache.poi.java.awt.Container
    public void postProcessKeyEvent(KeyEvent keyEvent) {
    }

    @Override // org.apache.poi.java.awt.Container
    public final void setFocusCycleRoot(boolean z) {
    }

    @Override // org.apache.poi.java.awt.Component
    public void adjustListeningChildrenOnParent(long j, int i) {
    }
}
