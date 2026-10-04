package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import org.apache.poi.java.awt.Dialog;
import org.apache.poi.java.awt.datatransfer.Clipboard;
import org.apache.poi.java.awt.dnd.DragGestureEvent;
import org.apache.poi.java.awt.dnd.DragGestureListener;
import org.apache.poi.java.awt.dnd.DragGestureRecognizer;
import org.apache.poi.java.awt.dnd.DragSource;
import org.apache.poi.java.awt.dnd.peer.DragSourceContextPeer;
import org.apache.poi.java.awt.event.AWTEventListener;
import org.apache.poi.java.awt.event.AWTEventListenerProxy;
import org.apache.poi.java.awt.font.TextAttribute;
import org.apache.poi.java.awt.im.InputMethodHighlight;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.ImageObserver;
import org.apache.poi.java.awt.image.ImageProducer;
import org.apache.poi.java.awt.peer.ButtonPeer;
import org.apache.poi.java.awt.peer.CanvasPeer;
import org.apache.poi.java.awt.peer.CheckboxMenuItemPeer;
import org.apache.poi.java.awt.peer.CheckboxPeer;
import org.apache.poi.java.awt.peer.ChoicePeer;
import org.apache.poi.java.awt.peer.DesktopPeer;
import org.apache.poi.java.awt.peer.DialogPeer;
import org.apache.poi.java.awt.peer.FileDialogPeer;
import org.apache.poi.java.awt.peer.FontPeer;
import org.apache.poi.java.awt.peer.FramePeer;
import org.apache.poi.java.awt.peer.LabelPeer;
import org.apache.poi.java.awt.peer.LightweightPeer;
import org.apache.poi.java.awt.peer.ListPeer;
import org.apache.poi.java.awt.peer.MenuBarPeer;
import org.apache.poi.java.awt.peer.MenuItemPeer;
import org.apache.poi.java.awt.peer.MenuPeer;
import org.apache.poi.java.awt.peer.MouseInfoPeer;
import org.apache.poi.java.awt.peer.PanelPeer;
import org.apache.poi.java.awt.peer.PopupMenuPeer;
import org.apache.poi.java.awt.peer.ScrollPanePeer;
import org.apache.poi.java.awt.peer.ScrollbarPeer;
import org.apache.poi.java.awt.peer.TextAreaPeer;
import org.apache.poi.java.awt.peer.TextFieldPeer;
import org.apache.poi.java.awt.peer.WindowPeer;
import org.apache.poi.sun.awt.NullComponentPeer;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.security.util.SecurityConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Toolkit {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int LONG_BITS = 64;
    private static String atNames = null;
    private static volatile long enabledOnToolkitMask = 0;
    private static LightweightPeer lightweightMarker = null;
    private static boolean loaded = false;
    private static ResourceBundle platformResources;
    private static ResourceBundle resources;
    private static Toolkit toolkit;
    protected final Map<String, Object> desktopProperties = new HashMap();
    protected final PropertyChangeSupport desktopPropsSupport = createPropertyChangeSupport(this);
    private int[] calls = new int[64];
    private AWTEventListener eventListener = null;
    private WeakHashMap<AWTEventListener, SelectiveAWTEventListener> listener2SelectiveListener = new WeakHashMap<>();

    static {
        loadLibraries();
        initAssistiveTechnologies();
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        initIDs();
    }

    private static PropertyChangeSupport createPropertyChangeSupport(Toolkit toolkit2) {
        return !(toolkit2 instanceof SunToolkit) ? new PropertyChangeSupport(toolkit2) : new DesktopPropertyChangeSupport(toolkit2);
    }

    private static AWTEventListener deProxyAWTEventListener(AWTEventListener aWTEventListener) {
        if (aWTEventListener == null) {
            return null;
        }
        return aWTEventListener instanceof AWTEventListenerProxy ? ((AWTEventListenerProxy) aWTEventListener).getListener() : aWTEventListener;
    }

    public static boolean enabledOnToolkit(long j) {
        return (j & enabledOnToolkitMask) != 0;
    }

    public static synchronized Toolkit getDefaultToolkit() {
        try {
            if (toolkit == null) {
                AccessController.doPrivileged((PrivilegedAction) new 1());
                loadAssistiveTechnologies();
            }
        } catch (Throwable th) {
            throw th;
        }
        return toolkit;
    }

    public static EventQueue getEventQueue() {
        return getDefaultToolkit().getSystemEventQueueImpl();
    }

    public static Container getNativeContainer(Component component) {
        return component.getNativeContainer();
    }

    public static String getProperty(String str, String str2) {
        ResourceBundle resourceBundle = platformResources;
        if (resourceBundle != null) {
            try {
                return resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        ResourceBundle resourceBundle2 = resources;
        if (resourceBundle2 != null) {
            try {
                return resourceBundle2.getString(str);
            } catch (MissingResourceException unused2) {
            }
        }
        return str2;
    }

    private static void initAssistiveTechnologies() {
        String str = File.separator;
        new Properties();
    }

    private static native void initIDs();

    private static void loadAssistiveTechnologies() {
        Class<?> clsLoadClass;
        if (atNames != null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            StringTokenizer stringTokenizer = new StringTokenizer(atNames, " ,");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                if (systemClassLoader != null) {
                    try {
                        clsLoadClass = systemClassLoader.loadClass(strNextToken);
                    } catch (ClassNotFoundException unused) {
                        throw new AWTError(AbstractC0541b.m772n("Assistive Technology not found: ", strNextToken));
                    } catch (IllegalAccessException unused2) {
                        throw new AWTError(AbstractC0541b.m772n("Could not access Assistive Technology: ", strNextToken));
                    } catch (InstantiationException unused3) {
                        throw new AWTError(AbstractC0541b.m772n("Could not instantiate Assistive Technology: ", strNextToken));
                    } catch (Exception e) {
                        throw new AWTError("Error trying to install Assistive Technology: " + strNextToken + " " + e);
                    }
                } else {
                    clsLoadClass = Class.forName(strNextToken);
                }
                clsLoadClass.newInstance();
            }
        }
    }

    public static void loadLibraries() {
        if (loaded) {
            return;
        }
        loaded = true;
    }

    private static void setPlatformResources(ResourceBundle resourceBundle) {
        platformResources = resourceBundle;
    }

    public void addAWTEventListener(AWTEventListener aWTEventListener, long j) {
        AWTEventListener aWTEventListenerDeProxyAWTEventListener = deProxyAWTEventListener(aWTEventListener);
        if (aWTEventListenerDeProxyAWTEventListener == null) {
            return;
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.ALL_AWT_EVENTS_PERMISSION);
        }
        synchronized (this) {
            try {
                SelectiveAWTEventListener selectiveAWTEventListener = this.listener2SelectiveListener.get(aWTEventListenerDeProxyAWTEventListener);
                if (selectiveAWTEventListener == null) {
                    selectiveAWTEventListener = new SelectiveAWTEventListener(this, aWTEventListenerDeProxyAWTEventListener, j);
                    this.listener2SelectiveListener.put(aWTEventListenerDeProxyAWTEventListener, selectiveAWTEventListener);
                    this.eventListener = ToolkitEventMulticaster.add(this.eventListener, selectiveAWTEventListener);
                }
                selectiveAWTEventListener.orEventMasks(j);
                enabledOnToolkitMask |= j;
                for (int i = 0; i < 64 && j != 0; i++) {
                    if ((1 & j) != 0) {
                        int[] iArr = this.calls;
                        iArr[i] = iArr[i] + 1;
                    }
                    j >>>= 1;
                }
            } finally {
            }
        }
    }

    public void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        this.desktopPropsSupport.addPropertyChangeListener(str, propertyChangeListener);
    }

    public boolean areExtraMouseButtonsEnabled() {
        GraphicsEnvironment.checkHeadless();
        return getDefaultToolkit().areExtraMouseButtonsEnabled();
    }

    public abstract void beep();

    public abstract int checkImage(Image image, int i, int i2, ImageObserver imageObserver);

    public synchronized int countAWTEventListeners(long j) {
        int i;
        i = 0;
        while (j != 0) {
            j >>>= 1;
            i++;
        }
        return this.calls[i - 1];
    }

    public abstract ButtonPeer createButton(Button button);

    public abstract CanvasPeer createCanvas(Canvas canvas);

    public abstract CheckboxPeer createCheckbox(Checkbox checkbox);

    public abstract CheckboxMenuItemPeer createCheckboxMenuItem(CheckboxMenuItem checkboxMenuItem);

    public abstract ChoicePeer createChoice(Choice choice);

    public LightweightPeer createComponent(Component component) {
        if (lightweightMarker == null) {
            lightweightMarker = new NullComponentPeer();
        }
        return lightweightMarker;
    }

    public Cursor createCustomCursor(Image image, Point point, String str) {
        return this != getDefaultToolkit() ? getDefaultToolkit().createCustomCursor(image, point, str) : new Cursor(0);
    }

    public abstract DesktopPeer createDesktopPeer(Desktop desktop);

    public abstract DialogPeer createDialog(Dialog dialog);

    public <T extends DragGestureRecognizer> T createDragGestureRecognizer(Class<T> cls, DragSource dragSource, Component component, int i, DragGestureListener dragGestureListener) {
        return null;
    }

    public abstract DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dragGestureEvent);

    public abstract FileDialogPeer createFileDialog(FileDialog fileDialog);

    public abstract FramePeer createFrame(Frame frame);

    public abstract Image createImage(String str);

    public abstract Image createImage(URL url);

    public abstract Image createImage(ImageProducer imageProducer);

    public Image createImage(byte[] bArr) {
        return createImage(bArr, 0, bArr.length);
    }

    public abstract Image createImage(byte[] bArr, int i, int i2);

    public abstract LabelPeer createLabel(Label label);

    public abstract ListPeer createList(List list);

    public abstract MenuPeer createMenu(Menu menu);

    public abstract MenuBarPeer createMenuBar(MenuBar menuBar);

    public abstract MenuItemPeer createMenuItem(MenuItem menuItem);

    public abstract PanelPeer createPanel(Panel panel);

    public abstract PopupMenuPeer createPopupMenu(PopupMenu popupMenu);

    public abstract ScrollPanePeer createScrollPane(ScrollPane scrollPane);

    public abstract ScrollbarPeer createScrollbar(Scrollbar scrollbar);

    public abstract TextAreaPeer createTextArea(TextArea textArea);

    public abstract TextFieldPeer createTextField(TextField textField);

    public abstract WindowPeer createWindow(Window window);

    public AWTEventListener[] getAWTEventListeners() {
        AWTEventListener[] aWTEventListenerArr;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.ALL_AWT_EVENTS_PERMISSION);
        }
        synchronized (this) {
            try {
                SelectiveAWTEventListener[] listeners = ToolkitEventMulticaster.getListeners(this.eventListener, AWTEventListener.class);
                aWTEventListenerArr = new AWTEventListener[listeners.length];
                for (int i = 0; i < listeners.length; i++) {
                    SelectiveAWTEventListener selectiveAWTEventListener = listeners[i];
                    aWTEventListenerArr[i] = new AWTEventListenerProxy(selectiveAWTEventListener.getEventMask(), selectiveAWTEventListener.getListener());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aWTEventListenerArr;
    }

    public Dimension getBestCursorSize(int i, int i2) {
        GraphicsEnvironment.checkHeadless();
        return this != getDefaultToolkit() ? getDefaultToolkit().getBestCursorSize(i, i2) : new Dimension(0, 0);
    }

    public abstract ColorModel getColorModel();

    public final synchronized Object getDesktopProperty(String str) {
        try {
            if (this.desktopProperties.isEmpty()) {
                initializeDesktopProperties();
            }
            if (str.equals("awt.dynamicLayoutSupported")) {
                return getDefaultToolkit().lazilyLoadDesktopProperty(str);
            }
            Object objClone = this.desktopProperties.get(str);
            if (objClone == null && (objClone = lazilyLoadDesktopProperty(str)) != null) {
                setDesktopProperty(str, objClone);
            }
            if (objClone instanceof RenderingHints) {
                objClone = ((RenderingHints) objClone).clone();
            }
            return objClone;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public abstract String[] getFontList();

    @Deprecated
    public abstract FontMetrics getFontMetrics(Font font);

    @Deprecated
    public abstract FontPeer getFontPeer(String str, int i);

    public abstract Image getImage(String str);

    public abstract Image getImage(URL url);

    public boolean getLockingKeyState(int i) {
        GraphicsEnvironment.checkHeadless();
        if (i == 20 || i == 144 || i == 145 || i == 262) {
            throw new UnsupportedOperationException("Toolkit.getLockingKeyState");
        }
        throw new IllegalArgumentException("invalid key for Toolkit.getLockingKeyState");
    }

    public int getMaximumCursorColors() {
        GraphicsEnvironment.checkHeadless();
        if (this != getDefaultToolkit()) {
            return getDefaultToolkit().getMaximumCursorColors();
        }
        return 0;
    }

    public int getMenuShortcutKeyMask() {
        GraphicsEnvironment.checkHeadless();
        return 2;
    }

    public MouseInfoPeer getMouseInfoPeer() {
        throw new UnsupportedOperationException("Not implemented");
    }

    public abstract PrintJob getPrintJob(Frame frame, String str, Properties properties);

    public PrintJob getPrintJob(Frame frame, String str, JobAttributes jobAttributes, PageAttributes pageAttributes) {
        return this != getDefaultToolkit() ? getDefaultToolkit().getPrintJob(frame, str, jobAttributes, pageAttributes) : getPrintJob(frame, str, null);
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {
        return this.desktopPropsSupport.getPropertyChangeListeners();
    }

    public Insets getScreenInsets(GraphicsConfiguration graphicsConfiguration) {
        GraphicsEnvironment.checkHeadless();
        return this != getDefaultToolkit() ? getDefaultToolkit().getScreenInsets(graphicsConfiguration) : new Insets(0, 0, 0, 0);
    }

    public abstract int getScreenResolution();

    public abstract Dimension getScreenSize();

    public abstract Clipboard getSystemClipboard();

    public final EventQueue getSystemEventQueue() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.CHECK_AWT_EVENTQUEUE_PERMISSION);
        }
        return getSystemEventQueueImpl();
    }

    public abstract EventQueue getSystemEventQueueImpl();

    public Clipboard getSystemSelection() {
        GraphicsEnvironment.checkHeadless();
        if (this != getDefaultToolkit()) {
            return getDefaultToolkit().getSystemSelection();
        }
        GraphicsEnvironment.checkHeadless();
        return null;
    }

    public boolean isAlwaysOnTopSupported() {
        return true;
    }

    public boolean isDynamicLayoutActive() {
        GraphicsEnvironment.checkHeadless();
        if (this != getDefaultToolkit()) {
            return getDefaultToolkit().isDynamicLayoutActive();
        }
        return false;
    }

    public boolean isDynamicLayoutSet() {
        GraphicsEnvironment.checkHeadless();
        if (this != getDefaultToolkit()) {
            return getDefaultToolkit().isDynamicLayoutSet();
        }
        return false;
    }

    public boolean isFrameStateSupported(int i) {
        GraphicsEnvironment.checkHeadless();
        return this != getDefaultToolkit() ? getDefaultToolkit().isFrameStateSupported(i) : i == 0;
    }

    public abstract boolean isModalExclusionTypeSupported(Dialog.ModalExclusionType modalExclusionType);

    public abstract boolean isModalityTypeSupported(Dialog.ModalityType modalityType);

    public Object lazilyLoadDesktopProperty(String str) {
        return null;
    }

    public void loadSystemColors(int[] iArr) {
        GraphicsEnvironment.checkHeadless();
    }

    public abstract Map<TextAttribute, ?> mapInputMethodHighlight(InputMethodHighlight inputMethodHighlight);

    public void notifyAWTEventListeners(AWTEvent aWTEvent) {
        AWTEventListener aWTEventListener = this.eventListener;
        if (aWTEventListener != null) {
            aWTEventListener.eventDispatched(aWTEvent);
        }
    }

    public abstract boolean prepareImage(Image image, int i, int i2, ImageObserver imageObserver);

    public void removeAWTEventListener(AWTEventListener aWTEventListener) {
        AWTEventListener aWTEventListenerDeProxyAWTEventListener = deProxyAWTEventListener(aWTEventListener);
        if (aWTEventListener == null) {
            return;
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.ALL_AWT_EVENTS_PERMISSION);
        }
        synchronized (this) {
            try {
                AWTEventListener aWTEventListener2 = (SelectiveAWTEventListener) this.listener2SelectiveListener.get(aWTEventListenerDeProxyAWTEventListener);
                if (aWTEventListener2 != null) {
                    this.listener2SelectiveListener.remove(aWTEventListenerDeProxyAWTEventListener);
                    int[] calls = aWTEventListener2.getCalls();
                    for (int i = 0; i < 64; i++) {
                        int[] iArr = this.calls;
                        int i2 = iArr[i] - calls[i];
                        iArr[i] = i2;
                        if (i2 == 0) {
                            enabledOnToolkitMask &= ~(1 << i);
                        }
                    }
                }
                AWTEventListener aWTEventListener3 = this.eventListener;
                if (aWTEventListener2 != null) {
                    aWTEventListenerDeProxyAWTEventListener = aWTEventListener2;
                }
                this.eventListener = ToolkitEventMulticaster.remove(aWTEventListener3, aWTEventListenerDeProxyAWTEventListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removePropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        this.desktopPropsSupport.removePropertyChangeListener(str, propertyChangeListener);
    }

    public final void setDesktopProperty(String str, Object obj) {
        Object obj2;
        synchronized (this) {
            obj2 = this.desktopProperties.get(str);
            this.desktopProperties.put(str, obj);
        }
        if (obj2 == null && obj == null) {
            return;
        }
        this.desktopPropsSupport.firePropertyChange(str, obj2, obj);
    }

    public void setDynamicLayout(boolean z) {
        GraphicsEnvironment.checkHeadless();
        if (this != getDefaultToolkit()) {
            getDefaultToolkit().setDynamicLayout(z);
        }
    }

    public void setLockingKeyState(int i, boolean z) {
        GraphicsEnvironment.checkHeadless();
        if (i != 20 && i != 144 && i != 145 && i != 262) {
            throw new IllegalArgumentException("invalid key for Toolkit.setLockingKeyState");
        }
        throw new UnsupportedOperationException("Toolkit.setLockingKeyState");
    }

    public abstract void sync();

    public PropertyChangeListener[] getPropertyChangeListeners(String str) {
        return this.desktopPropsSupport.getPropertyChangeListeners(str);
    }

    public AWTEventListener[] getAWTEventListeners(long j) {
        AWTEventListener[] aWTEventListenerArr;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.ALL_AWT_EVENTS_PERMISSION);
        }
        synchronized (this) {
            try {
                SelectiveAWTEventListener[] listeners = ToolkitEventMulticaster.getListeners(this.eventListener, AWTEventListener.class);
                ArrayList arrayList = new ArrayList(listeners.length);
                for (SelectiveAWTEventListener selectiveAWTEventListener : listeners) {
                    if ((selectiveAWTEventListener.getEventMask() & j) == j) {
                        arrayList.add(new AWTEventListenerProxy(selectiveAWTEventListener.getEventMask(), selectiveAWTEventListener.getListener()));
                    }
                }
                aWTEventListenerArr = (AWTEventListener[]) arrayList.toArray(new AWTEventListener[0]);
            } catch (Throwable th) {
                throw th;
            }
        }
        return aWTEventListenerArr;
    }

    public void initializeDesktopProperties() {
    }
}
