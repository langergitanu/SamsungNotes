package org.apache.poi.sun.awt;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.SocketPermission;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.lang3.SystemProperties;
import org.apache.poi.java.awt.AWTEvent;
import org.apache.poi.java.awt.Button;
import org.apache.poi.java.awt.Canvas;
import org.apache.poi.java.awt.Checkbox;
import org.apache.poi.java.awt.CheckboxMenuItem;
import org.apache.poi.java.awt.Choice;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.Container;
import org.apache.poi.java.awt.DefaultKeyboardFocusManager;
import org.apache.poi.java.awt.Dialog;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.EventQueue;
import org.apache.poi.java.awt.FileDialog;
import org.apache.poi.java.awt.FocusTraversalPolicy;
import org.apache.poi.java.awt.Font;
import org.apache.poi.java.awt.FontMetrics;
import org.apache.poi.java.awt.Frame;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.GraphicsConfiguration;
import org.apache.poi.java.awt.GraphicsDevice;
import org.apache.poi.java.awt.GraphicsEnvironment;
import org.apache.poi.java.awt.Image;
import org.apache.poi.java.awt.KeyboardFocusManager;
import org.apache.poi.java.awt.Label;
import org.apache.poi.java.awt.Menu;
import org.apache.poi.java.awt.MenuBar;
import org.apache.poi.java.awt.MenuComponent;
import org.apache.poi.java.awt.MenuItem;
import org.apache.poi.java.awt.Panel;
import org.apache.poi.java.awt.PopupMenu;
import org.apache.poi.java.awt.RenderingHints;
import org.apache.poi.java.awt.Robot;
import org.apache.poi.java.awt.ScrollPane;
import org.apache.poi.java.awt.Scrollbar;
import org.apache.poi.java.awt.SystemTray;
import org.apache.poi.java.awt.TextArea;
import org.apache.poi.java.awt.TextField;
import org.apache.poi.java.awt.Toolkit;
import org.apache.poi.java.awt.TrayIcon;
import org.apache.poi.java.awt.Window;
import org.apache.poi.java.awt.dnd.DragGestureEvent;
import org.apache.poi.java.awt.dnd.peer.DragSourceContextPeer;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.event.WindowEvent;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.DataBufferInt;
import org.apache.poi.java.awt.image.ImageObserver;
import org.apache.poi.java.awt.image.ImageProducer;
import org.apache.poi.java.awt.peer.ButtonPeer;
import org.apache.poi.java.awt.peer.CanvasPeer;
import org.apache.poi.java.awt.peer.CheckboxMenuItemPeer;
import org.apache.poi.java.awt.peer.CheckboxPeer;
import org.apache.poi.java.awt.peer.ChoicePeer;
import org.apache.poi.java.awt.peer.DialogPeer;
import org.apache.poi.java.awt.peer.FileDialogPeer;
import org.apache.poi.java.awt.peer.FontPeer;
import org.apache.poi.java.awt.peer.FramePeer;
import org.apache.poi.java.awt.peer.KeyboardFocusManagerPeer;
import org.apache.poi.java.awt.peer.LabelPeer;
import org.apache.poi.java.awt.peer.ListPeer;
import org.apache.poi.java.awt.peer.MenuBarPeer;
import org.apache.poi.java.awt.peer.MenuItemPeer;
import org.apache.poi.java.awt.peer.MenuPeer;
import org.apache.poi.java.awt.peer.MouseInfoPeer;
import org.apache.poi.java.awt.peer.PanelPeer;
import org.apache.poi.java.awt.peer.PopupMenuPeer;
import org.apache.poi.java.awt.peer.RobotPeer;
import org.apache.poi.java.awt.peer.ScrollPanePeer;
import org.apache.poi.java.awt.peer.ScrollbarPeer;
import org.apache.poi.java.awt.peer.SystemTrayPeer;
import org.apache.poi.java.awt.peer.TextAreaPeer;
import org.apache.poi.java.awt.peer.TextFieldPeer;
import org.apache.poi.java.awt.peer.TrayIconPeer;
import org.apache.poi.java.awt.peer.WindowPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.im.InputContext;
import org.apache.poi.sun.awt.im.SimpleInputMethodWindow;
import org.apache.poi.sun.awt.image.ByteArrayImageSource;
import org.apache.poi.sun.awt.image.FileImageSource;
import org.apache.poi.sun.awt.image.MultiResolutionToolkitImage;
import org.apache.poi.sun.awt.image.ToolkitImage;
import org.apache.poi.sun.awt.image.URLImageSource;
import org.apache.poi.sun.misc.SoftCache;
import org.apache.poi.sun.security.action.GetBooleanAction;
import org.apache.poi.sun.security.action.GetPropertyAction;
import org.apache.poi.sun.security.util.SecurityConstants;
import org.apache.poi.sun.util.logging.PlatformLogger;
import sun.font.FontDesignMetrics;
import sun.net.util.URLUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class SunToolkit extends Toolkit implements WindowClosingSupport, WindowClosingListener, ComponentFactory, InputMethodSupport, KeyboardFocusManagerPeerProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReentrantLock AWT_LOCK;
    private static final Condition AWT_LOCK_COND;
    private static final Object DEACTIVATION_TIMES_MAP_KEY;
    private static Dialog.ModalExclusionType DEFAULT_MODAL_EXCLUSION_TYPE = null;
    public static final int DEFAULT_WAIT_TIME = 10000;
    public static final String DESKTOPFONTHINTS = "awt.font.desktophints";
    public static final int GRAB_EVENT_MASK = Integer.MIN_VALUE;
    public static final int MAX_BUTTONS_SUPPORTED = 20;
    private static final int MAX_ITERS = 20;
    private static final int MINIMAL_EDELAY = 0;
    private static final int MIN_ITERS = 0;
    private static final String POST_EVENT_QUEUE_KEY = "PostEventQueue";
    private static final Map<Object, AppContext> appContextMap;
    private static boolean checkedSystemAAFontSettings;
    private static RenderingHints desktopFontHints;
    static final SoftCache fileImgCache;
    private static boolean lastExtraCondition;
    private static DefaultMouseInfoPeer mPeer;
    protected static int numberOfButtons;
    private static Locale startupLocale;
    private static Boolean sunAwtDisableMixing;
    private static boolean touchKeyboardAutoShowIsEnabled;
    static final SoftCache urlImgCache;
    private static boolean useSystemAAFontSettings;
    private transient WindowClosingListener windowClosingListener = null;
    private ModalityListenerList modalityListeners = new ModalityListenerList();
    private boolean eventDispatched = false;
    private boolean queueEmpty = false;
    private final Object waitLock = "Wait Lock";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IllegalThreadException extends RuntimeException {
        public IllegalThreadException(String str) {
            super(str);
        }

        public IllegalThreadException() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InfiniteLoop extends RuntimeException {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ModalityListenerList implements ModalityListener {
        Vector<ModalityListener> listeners = new Vector<>();

        public void add(ModalityListener modalityListener) {
            this.listeners.addElement(modalityListener);
        }

        public void modalityPopped(ModalityEvent modalityEvent) {
            Iterator<ModalityListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().modalityPopped(modalityEvent);
            }
        }

        public void modalityPushed(ModalityEvent modalityEvent) {
            Iterator<ModalityListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().modalityPushed(modalityEvent);
            }
        }

        public void remove(ModalityListener modalityListener) {
            this.listeners.removeElement(modalityListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OperationTimedOut extends RuntimeException {
        public OperationTimedOut(String str) {
            super(str);
        }

        public OperationTimedOut() {
        }
    }

    static {
        if (((Boolean) AccessController.doPrivileged(new GetBooleanAction("org.apache.poi.sun.awt.nativedebug"))).booleanValue()) {
            DebugSettings.init();
        }
        touchKeyboardAutoShowIsEnabled = Boolean.valueOf((String) AccessController.doPrivileged(new GetPropertyAction("awt.touchKeyboardAutoShowIsEnabled", "true"))).booleanValue();
        numberOfButtons = 0;
        ReentrantLock reentrantLock = new ReentrantLock();
        AWT_LOCK = reentrantLock;
        AWT_LOCK_COND = reentrantLock.newCondition();
        appContextMap = Collections.synchronizedMap(new WeakHashMap());
        fileImgCache = new SoftCache();
        urlImgCache = new SoftCache();
        startupLocale = null;
        mPeer = null;
        DEFAULT_MODAL_EXCLUSION_TYPE = null;
        lastExtraCondition = true;
        sunAwtDisableMixing = null;
        DEACTIVATION_TIMES_MAP_KEY = new Object();
    }

    public static final void awtLock() {
        AWT_LOCK.lock();
    }

    public static final void awtLockNotify() {
        AWT_LOCK_COND.signal();
    }

    public static final void awtLockNotifyAll() {
        AWT_LOCK_COND.signalAll();
    }

    public static final void awtLockWait() throws InterruptedException {
        AWT_LOCK_COND.await();
    }

    public static final boolean awtTryLock() {
        return AWT_LOCK.tryLock();
    }

    public static final void awtUnlock() {
        AWT_LOCK.unlock();
    }

    public static void checkAndSetPolicy(Container container) {
        container.setFocusTraversalPolicy(KeyboardFocusManager.getCurrentKeyboardFocusManager().getDefaultFocusTraversalPolicy());
    }

    private static void checkPermissions(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(str);
        }
    }

    private int checkResolutionVariant(Image image, int i, int i2, ImageObserver imageObserver) {
        ToolkitImage resolutionVariant = getResolutionVariant(image);
        int rVSize = getRVSize(i);
        int rVSize2 = getRVSize(i2);
        if (resolutionVariant == null || resolutionVariant.hasError()) {
            return 65535;
        }
        return checkImage(resolutionVariant, rVSize, rVSize2, MultiResolutionToolkitImage.getResolutionVariantObserver(image, imageObserver, i, i2, rVSize, rVSize2, true));
    }

    public static native void closeSplashScreen();

    public static synchronized void consumeNextKeyTyped(KeyEvent keyEvent) {
        try {
            AWTAccessor.getDefaultKeyboardFocusManagerAccessor().consumeNextKeyTyped((DefaultKeyboardFocusManager) KeyboardFocusManager.getCurrentKeyboardFocusManager(), keyEvent);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static Image createImageWithResolutionVariant(Image image, Image image2) {
        return new MultiResolutionToolkitImage(image, image2);
    }

    private static FocusTraversalPolicy createLayoutPolicy() {
        try {
            return (FocusTraversalPolicy) Class.forName("javax.swing.LayoutFocusTraversalPolicy").newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    public static AppContext createNewAppContext() {
        return createNewAppContext(Thread.currentThread().getThreadGroup());
    }

    private void disableBackgroundEraseImpl(Component component) {
        AWTAccessor.getComponentAccessor().setBackgroundEraseDisabled(component, true);
    }

    public static void dumpPeers(PlatformLogger platformLogger) {
        AWTAutoShutdown.getInstance().dumpPeers(platformLogger);
    }

    public static void executeOnEDTAndWait(Object obj, Runnable runnable) throws InvocationTargetException {
        if (EventQueue.isDispatchThread()) {
            throw new Error("Cannot call executeOnEDTAndWait from any event dispatcher thread");
        }
        Object obj2 = new Object() { // from class: org.apache.poi.sun.awt.SunToolkit.1AWTInvocationLock
        };
        PeerEvent peerEvent = new PeerEvent(obj, runnable, obj2, true, 1L);
        synchronized (obj2) {
            try {
                executeOnEventHandlerThread(peerEvent);
                while (!peerEvent.isDispatched()) {
                    obj2.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Throwable throwable = peerEvent.getThrowable();
        if (throwable != null) {
            throw new InvocationTargetException(throwable);
        }
    }

    public static void executeOnEventHandlerThread(Object obj, Runnable runnable) {
        executeOnEventHandlerThread(new PeerEvent(obj, runnable, 1L));
    }

    private void fireDesktopFontPropertyChanges() {
        setDesktopProperty(DESKTOPFONTHINTS, getDesktopFontHints());
    }

    public static void flushPendingEvents() {
        flushPendingEvents(AppContext.getAppContext());
    }

    private static AppContext getAppContext(Object obj) {
        if (obj instanceof Component) {
            return AWTAccessor.getComponentAccessor().getAppContext((Component) obj);
        }
        if (obj instanceof MenuComponent) {
            return AWTAccessor.getMenuComponentAccessor().getAppContext((MenuComponent) obj);
        }
        return null;
    }

    public static Window getContainingWindow(Component component) {
        while (component != null && !(component instanceof Window)) {
            component = component.getParent();
        }
        return (Window) component;
    }

    private static RenderingHints getDesktopAAHintsByName(String str) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        Object obj = lowerCase.equals("on") ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : lowerCase.equals("gasp") ? RenderingHints.VALUE_TEXT_ANTIALIAS_GASP : (lowerCase.equals("lcd") || lowerCase.equals("lcd_hrgb")) ? RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB : lowerCase.equals("lcd_hbgr") ? RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR : lowerCase.equals("lcd_vrgb") ? RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB : lowerCase.equals("lcd_vbgr") ? RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR : null;
        if (obj == null) {
            return null;
        }
        RenderingHints renderingHints = new RenderingHints(null);
        renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, obj);
        return renderingHints;
    }

    public static RenderingHints getDesktopFontHints() {
        if (useSystemAAFontSettings()) {
            Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            if (defaultToolkit instanceof SunToolkit) {
                return ((SunToolkit) defaultToolkit).getDesktopAAHints();
            }
            return null;
        }
        RenderingHints renderingHints = desktopFontHints;
        if (renderingHints != null) {
            return (RenderingHints) renderingHints.clone();
        }
        return null;
    }

    public static Component getHeavyweightComponent(Component component) {
        while (component != null && AWTAccessor.getComponentAccessor().isLightweight(component)) {
            component = AWTAccessor.getComponentAccessor().getParent(component);
        }
        return component;
    }

    public static Image getImageFromHash(Toolkit toolkit, URL url) {
        Image imageCreateImage;
        checkPermissions(url);
        SoftCache softCache = urlImgCache;
        synchronized (softCache) {
            String string = url.toString();
            imageCreateImage = (Image) softCache.get(string);
            if (imageCreateImage == null) {
                try {
                    imageCreateImage = toolkit.createImage((ImageProducer) new URLImageSource(url));
                    softCache.put(string, imageCreateImage);
                } catch (Exception unused) {
                }
            }
        }
        return imageCreateImage;
    }

    public static LightweightFrame getLightweightFrame(Component component) {
        while (component != null) {
            if (component instanceof LightweightFrame) {
                return (LightweightFrame) component;
            }
            if (component instanceof Window) {
                return null;
            }
            component = component.getParent();
        }
        return null;
    }

    public static Container getNativeContainer(Component component) {
        return Toolkit.getNativeContainer(component);
    }

    private static int getRVSize(int i) {
        if (i == -1) {
            return -1;
        }
        return i * 2;
    }

    private static ToolkitImage getResolutionVariant(Image image) {
        return null;
    }

    public static DataBufferInt getScaledIconData(List<Image> list, int i, int i2) {
        BufferedImage scaledIconImage = getScaledIconImage(list, i, i2);
        if (scaledIconImage == null) {
            return null;
        }
        return (DataBufferInt) scaledIconImage.getRaster().getDataBuffer();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc A[EDGE_INSN: B:58:0x00cc->B:34:0x00cc BREAK  A[LOOP:0: B:7:0x0017->B:59:0x0017], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BufferedImage getScaledIconImage(List<Image> list, int i, int i2) {
        BufferedImage bufferedImage;
        int i4;
        int i5;
        Iterator<Image> it;
        double d;
        double d2;
        double d3;
        BufferedImage bufferedImage2 = null;
        if (i == 0 || i2 == 0) {
            return null;
        }
        Iterator<Image> it2 = list.iterator();
        int i6 = 0;
        Image image = null;
        double d4 = 3.0d;
        int i7 = 0;
        while (true) {
            if (!it2.hasNext()) {
                bufferedImage = bufferedImage2;
                i4 = i6;
                i5 = i7;
                break;
            }
            Image next = it2.next();
            if (next != null) {
                try {
                    int width = next.getWidth(bufferedImage2);
                    int height = next.getHeight(bufferedImage2);
                    if (width <= 0 || height <= 0) {
                        bufferedImage = bufferedImage2;
                        it = it2;
                        i4 = i6;
                        i5 = i7;
                    } else {
                        double d5 = i;
                        double d6 = width;
                        bufferedImage = bufferedImage2;
                        it = it2;
                        i4 = i6;
                        i5 = i7;
                        double d7 = i2;
                        double d8 = height;
                        double dMin = Math.min(d5 / d6, d7 / d8);
                        if (dMin < 2.0d) {
                            if (dMin >= 1.0d) {
                                d2 = 0.0d;
                            } else if (dMin >= 0.75d) {
                                width = (width * 3) / 4;
                                height = (height * 3) / 4;
                                d2 = 0.3d;
                            } else if (dMin >= 0.6666d) {
                                width = (width * 2) / 3;
                                height = (height * 2) / 3;
                                d2 = 0.33d;
                            } else {
                                double dCeil = Math.ceil(1.0d / dMin);
                                d = 1.0d / dCeil;
                                width = (int) Math.round(d6 / dCeil);
                                height = (int) Math.round(d8 / dCeil);
                            }
                            d3 = ((d7 - ((double) height)) / d7) + ((d5 - ((double) width)) / d5) + d2;
                            if (d3 < d4) {
                                d4 = d3;
                                image = next;
                                i4 = width;
                                i5 = height;
                            }
                            if (d3 == 0.0d) {
                                break;
                            }
                        } else {
                            double dFloor = Math.floor(dMin);
                            int i8 = (int) dFloor;
                            width *= i8;
                            height *= i8;
                            d = 0.5d / dFloor;
                        }
                        d2 = 1.0d - d;
                        d3 = ((d7 - ((double) height)) / d7) + ((d5 - ((double) width)) / d5) + d2;
                        if (d3 < d4) {
                        }
                        if (d3 == 0.0d) {
                        }
                    }
                    i6 = i4;
                    i7 = i5;
                    it2 = it;
                    bufferedImage2 = bufferedImage;
                } catch (Exception unused) {
                    it2 = it2;
                    bufferedImage2 = bufferedImage2;
                    i6 = i6;
                    i7 = i7;
                }
            }
            it2 = it2;
            bufferedImage2 = bufferedImage2;
            i6 = i6;
            i7 = i7;
        }
        Image image2 = image;
        int i9 = i4;
        int i10 = i5;
        if (image2 == null) {
            return bufferedImage;
        }
        BufferedImage bufferedImage3 = new BufferedImage(i, i2, 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage3.createGraphics();
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        try {
            graphics2DCreateGraphics.drawImage(image2, (i - i9) / 2, (i2 - i10) / 2, i9, i10, null);
            return bufferedImage3;
        } finally {
            graphics2DCreateGraphics.dispose();
        }
    }

    public static Locale getStartupLocale() {
        if (startupLocale == null) {
            String str = (String) AccessController.doPrivileged(new GetPropertyAction(SystemProperties.USER_LANGUAGE, "en"));
            String str2 = (String) AccessController.doPrivileged(new GetPropertyAction(SystemProperties.USER_REGION));
            String strSubstring = "";
            if (str2 != null) {
                int iIndexOf = str2.indexOf(95);
                if (iIndexOf >= 0) {
                    String strSubstring2 = str2.substring(0, iIndexOf);
                    strSubstring = str2.substring(iIndexOf + 1);
                    str2 = strSubstring2;
                }
            } else {
                str2 = (String) AccessController.doPrivileged(new GetPropertyAction(SystemProperties.USER_COUNTRY, ""));
                strSubstring = (String) AccessController.doPrivileged(new GetPropertyAction(SystemProperties.USER_VARIANT, ""));
            }
            startupLocale = new Locale(str, str2, strSubstring);
        }
        return startupLocale;
    }

    public static synchronized boolean getSunAwtDisableMixing() {
        try {
            if (sunAwtDisableMixing == null) {
                sunAwtDisableMixing = (Boolean) AccessController.doPrivileged(new GetBooleanAction("org.apache.poi.sun.awt.disableMixing"));
            }
        } catch (Throwable th) {
            throw th;
        }
        return sunAwtDisableMixing.booleanValue();
    }

    public static boolean getSunAwtErasebackgroundonresize() {
        return ((Boolean) AccessController.doPrivileged(new GetBooleanAction("org.apache.poi.sun.awt.erasebackgroundonresize"))).booleanValue();
    }

    public static boolean getSunAwtNoerasebackground() {
        return ((Boolean) AccessController.doPrivileged(new GetBooleanAction("org.apache.poi.sun.awt.noerasebackground"))).booleanValue();
    }

    public static EventQueue getSystemEventQueueImplPP() {
        return getSystemEventQueueImplPP(AppContext.getAppContext());
    }

    public static boolean imageCached(String str) {
        return fileImgCache.containsKey(str);
    }

    public static boolean imageExists(String str) {
        if (str == null) {
            return false;
        }
        checkPermissions(str);
        return AbstractC2322a.m1607A(str);
    }

    private static void initEQ(AppContext appContext) {
        EventQueue eventQueue;
        String property = System.getProperty("AWT.EventQueueClass", "org.apache.poi.java.awt.EventQueue");
        try {
            eventQueue = (EventQueue) Class.forName(property).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed loading " + property + ": " + e);
            eventQueue = new EventQueue();
        }
        appContext.put(AppContext.EVENT_QUEUE_KEY, eventQueue);
        appContext.put(POST_EVENT_QUEUE_KEY, new PostEventQueue(eventQueue));
    }

    public static void insertTargetMapping(Object obj, AppContext appContext) {
        if (setAppContext(obj, appContext)) {
            return;
        }
        appContextMap.put(obj, appContext);
    }

    public static void invokeLaterOnAppContext(AppContext appContext, Runnable runnable) {
        postEvent(appContext, new PeerEvent(Toolkit.getDefaultToolkit(), runnable, 1L));
    }

    public static final boolean isAWTLockHeldByCurrentThread() {
        return AWT_LOCK.isHeldByCurrentThread();
    }

    public static boolean isContainingTopLevelOpaque(Component component) {
        Window containingWindow = getContainingWindow(component);
        return containingWindow != null && containingWindow.isOpaque();
    }

    public static boolean isContainingTopLevelTranslucent(Component component) {
        Window containingWindow = getContainingWindow(component);
        return containingWindow != null && containingWindow.getOpacity() < 1.0f;
    }

    public static boolean isDispatchThreadForAppContext(Object obj) {
        return AWTAccessor.getEventQueueAccessor().isDispatchThreadImpl((EventQueue) targetToAppContext(obj).get(AppContext.EVENT_QUEUE_KEY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEQEmpty() {
        return AWTAccessor.getEventQueueAccessor().noEvents(getSystemEventQueueImpl());
    }

    public static boolean isInstanceOf(Object obj, String str) {
        if (obj == null || str == null) {
            return false;
        }
        return isInstanceOf(obj.getClass(), str);
    }

    public static boolean isLightweightOrUnknown(Component component) {
        if (component.isLightweight() || !(Toolkit.getDefaultToolkit() instanceof SunToolkit)) {
            return true;
        }
        return ((component instanceof Button) || (component instanceof Canvas) || (component instanceof Checkbox) || (component instanceof Choice) || (component instanceof Label) || (component instanceof org.apache.poi.java.awt.List) || (component instanceof Panel) || (component instanceof Scrollbar) || (component instanceof ScrollPane) || (component instanceof TextArea) || (component instanceof TextField) || (component instanceof Window)) ? false : true;
    }

    public static boolean isModalExcluded(Window window) {
        if (DEFAULT_MODAL_EXCLUSION_TYPE == null) {
            DEFAULT_MODAL_EXCLUSION_TYPE = Dialog.ModalExclusionType.APPLICATION_EXCLUDE;
        }
        return window.getModalExclusionType().compareTo(DEFAULT_MODAL_EXCLUSION_TYPE) >= 0;
    }

    public static boolean isModalExcludedSupported() {
        return Toolkit.getDefaultToolkit().isModalExclusionTypeSupported(DEFAULT_MODAL_EXCLUSION_TYPE);
    }

    public static boolean isSystemGenerated(AWTEvent aWTEvent) {
        return AWTAccessor.getAWTEventAccessor().isSystemGenerated(aWTEvent);
    }

    public static boolean isTouchKeyboardAutoShowEnabled() {
        return touchKeyboardAutoShowIsEnabled;
    }

    public static boolean needsXEmbed() {
        if ("true".equals((String) AccessController.doPrivileged(new GetPropertyAction("org.apache.poi.sun.awt.noxembed", "false")))) {
            return false;
        }
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        if (defaultToolkit instanceof SunToolkit) {
            return ((SunToolkit) defaultToolkit).needsXEmbedImpl();
        }
        return false;
    }

    public static void postEvent(AppContext appContext, AWTEvent aWTEvent) {
        aWTEvent.getClass();
        AWTAccessor.SequencedEventAccessor sequencedEventAccessor = AWTAccessor.getSequencedEventAccessor();
        if (sequencedEventAccessor != null && sequencedEventAccessor.isSequencedEvent(aWTEvent)) {
            sequencedEventAccessor.getNested(aWTEvent).getID();
        }
        setSystemGenerated(aWTEvent);
        AppContext appContextTargetToAppContext = targetToAppContext(aWTEvent.getSource());
        if (appContextTargetToAppContext != null && !appContextTargetToAppContext.equals(appContext)) {
            throw new RuntimeException("Event posted on wrong app context : " + aWTEvent);
        }
        PostEventQueue postEventQueue = (PostEventQueue) appContext.get(POST_EVENT_QUEUE_KEY);
        if (postEventQueue != null) {
            postEventQueue.postEvent(aWTEvent);
        }
    }

    public static void postPriorityEvent(final AWTEvent aWTEvent) {
        postEvent(targetToAppContext(aWTEvent.getSource()), new PeerEvent(Toolkit.getDefaultToolkit(), new Runnable() { // from class: org.apache.poi.sun.awt.SunToolkit.1
            @Override // java.lang.Runnable
            public void run() {
                AWTAccessor.getAWTEventAccessor().setPosted(aWTEvent);
                ((Component) aWTEvent.getSource()).dispatchEvent(aWTEvent);
            }
        }, 2L));
    }

    private boolean prepareResolutionVariant(Image image, int i, int i2, ImageObserver imageObserver) {
        ToolkitImage resolutionVariant = getResolutionVariant(image);
        int rVSize = getRVSize(i);
        int rVSize2 = getRVSize(i2);
        return resolutionVariant == null || resolutionVariant.hasError() || prepareImage(resolutionVariant, rVSize, rVSize2, MultiResolutionToolkitImage.getResolutionVariantObserver(image, imageObserver, i, i2, rVSize, rVSize2, true));
    }

    public static void setAAFontSettingsCondition(boolean z) {
        if (z != lastExtraCondition) {
            lastExtraCondition = z;
            if (checkedSystemAAFontSettings) {
                checkedSystemAAFontSettings = false;
                Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
                if (defaultToolkit instanceof SunToolkit) {
                    ((SunToolkit) defaultToolkit).fireDesktopFontPropertyChanges();
                }
            }
        }
    }

    private static boolean setAppContext(Object obj, AppContext appContext) {
        if (obj instanceof Component) {
            AWTAccessor.getComponentAccessor().setAppContext((Component) obj, appContext);
            return true;
        }
        if (!(obj instanceof MenuComponent)) {
            return false;
        }
        AWTAccessor.getMenuComponentAccessor().setAppContext((MenuComponent) obj, appContext);
        return true;
    }

    public static void setLWRequestStatus(Window window, boolean z) {
        AWTAccessor.getWindowAccessor().setLWRequestStatus(window, z);
    }

    public static void setModalExcluded(Window window) {
        if (DEFAULT_MODAL_EXCLUSION_TYPE == null) {
            DEFAULT_MODAL_EXCLUSION_TYPE = Dialog.ModalExclusionType.APPLICATION_EXCLUDE;
        }
        window.setModalExclusionType(DEFAULT_MODAL_EXCLUSION_TYPE);
    }

    public static void setSystemGenerated(AWTEvent aWTEvent) {
        AWTAccessor.getAWTEventAccessor().setSystemGenerated(aWTEvent);
    }

    public static void targetCreatedPeer(Object obj, Object obj2) {
        if (obj == null || obj2 == null || GraphicsEnvironment.isHeadless()) {
            return;
        }
        AWTAutoShutdown.getInstance().registerPeer(obj, obj2);
    }

    public static void targetDisposedPeer(Object obj, Object obj2) {
        if (obj == null || obj2 == null || GraphicsEnvironment.isHeadless()) {
            return;
        }
        AWTAutoShutdown.getInstance().unregisterPeer(obj, obj2);
    }

    public static AppContext targetToAppContext(Object obj) {
        if (obj == null) {
            return null;
        }
        AppContext appContext = getAppContext(obj);
        return appContext == null ? appContextMap.get(obj) : appContext;
    }

    public static Object targetToPeer(Object obj) {
        if (obj == null || GraphicsEnvironment.isHeadless()) {
            return null;
        }
        return AWTAutoShutdown.getInstance().getPeer(obj);
    }

    private static boolean useSystemAAFontSettings() {
        if (!checkedSystemAAFontSettings) {
            useSystemAAFontSettings = true;
            String str = Toolkit.getDefaultToolkit() instanceof SunToolkit ? (String) AccessController.doPrivileged(new GetPropertyAction("awt.useSystemAAFontSettings")) : null;
            if (str != null) {
                boolean zBooleanValue = Boolean.valueOf(str).booleanValue();
                useSystemAAFontSettings = zBooleanValue;
                if (!zBooleanValue) {
                    desktopFontHints = getDesktopAAHintsByName(str);
                }
            }
            if (useSystemAAFontSettings) {
                useSystemAAFontSettings = lastExtraCondition;
            }
            checkedSystemAAFontSettings = true;
        }
        return useSystemAAFontSettings;
    }

    public static void wakeupEventQueue(EventQueue eventQueue, boolean z) {
        AWTAccessor.getEventQueueAccessor().wakeup(eventQueue, z);
    }

    public void addModalityListener(ModalityListener modalityListener) {
        this.modalityListeners.add(modalityListener);
    }

    public boolean canPopupOverlapTaskBar() {
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(SecurityConstants.AWT.SET_WINDOW_ALWAYS_ON_TOP_PERMISSION);
            }
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public int checkImage(Image image, int i, int i2, ImageObserver imageObserver) {
        return 32;
    }

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract ButtonPeer createButton(Button button);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public CanvasPeer createCanvas(Canvas canvas) {
        return createComponent(canvas);
    }

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract CheckboxPeer createCheckbox(Checkbox checkbox);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract CheckboxMenuItemPeer createCheckboxMenuItem(CheckboxMenuItem checkboxMenuItem);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract ChoicePeer createChoice(Choice choice);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract DialogPeer createDialog(Dialog dialog);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dragGestureEvent);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract FileDialogPeer createFileDialog(FileDialog fileDialog);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract FramePeer createFrame(Frame frame);

    @Override // org.apache.poi.java.awt.Toolkit
    public Image createImage(String str) {
        checkPermissions(str);
        return createImage((ImageProducer) new FileImageSource(str));
    }

    @Override // org.apache.poi.sun.awt.InputMethodSupport
    public Window createInputMethodWindow(String str, InputContext inputContext) {
        return new SimpleInputMethodWindow(str, inputContext);
    }

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract LabelPeer createLabel(Label label);

    public abstract FramePeer createLightweightFrame(LightweightFrame lightweightFrame);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract ListPeer createList(org.apache.poi.java.awt.List list);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract MenuPeer createMenu(Menu menu);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract MenuBarPeer createMenuBar(MenuBar menuBar);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract MenuItemPeer createMenuItem(MenuItem menuItem);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public PanelPeer createPanel(Panel panel) {
        return createComponent(panel);
    }

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract PopupMenuPeer createPopupMenu(PopupMenu popupMenu);

    @Override // org.apache.poi.sun.awt.ComponentFactory
    public abstract RobotPeer createRobot(Robot robot, GraphicsDevice graphicsDevice);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract ScrollPanePeer createScrollPane(ScrollPane scrollPane);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract ScrollbarPeer createScrollbar(Scrollbar scrollbar);

    public abstract SystemTrayPeer createSystemTray(SystemTray systemTray);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract TextAreaPeer createTextArea(TextArea textArea);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract TextFieldPeer createTextField(TextField textField);

    public abstract TrayIconPeer createTrayIcon(TrayIcon trayIcon);

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract WindowPeer createWindow(Window window);

    public void disableBackgroundErase(Canvas canvas) {
        disableBackgroundEraseImpl(canvas);
    }

    @Override // org.apache.poi.sun.awt.InputMethodSupport
    public boolean enableInputMethodsForTextComponent() {
        return false;
    }

    @Override // org.apache.poi.sun.awt.InputMethodSupport
    public Locale getDefaultKeyboardLocale() {
        return getStartupLocale();
    }

    public RenderingHints getDesktopAAHints() {
        return null;
    }

    public int getFocusAcceleratorKeyMask() {
        return 8;
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public String[] getFontList() {
        return new String[]{Font.DIALOG, Font.SANS_SERIF, Font.SERIF, Font.MONOSPACED, Font.DIALOG_INPUT};
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public FontMetrics getFontMetrics(Font font) {
        return FontDesignMetrics.getMetrics(font);
    }

    @Override // org.apache.poi.java.awt.Toolkit, org.apache.poi.sun.awt.ComponentFactory
    public abstract FontPeer getFontPeer(String str, int i);

    @Override // org.apache.poi.java.awt.Toolkit
    public Image getImage(String str) {
        return getImageFromHash(this, str);
    }

    public Image getImageWithResolutionVariant(String str, String str2) {
        Image imageCreateImageWithResolutionVariant;
        SoftCache softCache = fileImgCache;
        synchronized (softCache) {
            imageCreateImageWithResolutionVariant = createImageWithResolutionVariant(getImageFromHash(this, str), getImageFromHash(this, str2));
            softCache.put(str, imageCreateImageWithResolutionVariant);
        }
        return imageCreateImageWithResolutionVariant;
    }

    @Override // org.apache.poi.sun.awt.KeyboardFocusManagerPeerProvider
    public abstract KeyboardFocusManagerPeer getKeyboardFocusManagerPeer();

    @Override // org.apache.poi.java.awt.Toolkit
    public synchronized MouseInfoPeer getMouseInfoPeer() {
        try {
            if (mPeer == null) {
                mPeer = new DefaultMouseInfoPeer();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mPeer;
    }

    public int getNumberOfButtons() {
        return 3;
    }

    public abstract int getScreenHeight();

    @Override // org.apache.poi.java.awt.Toolkit
    public Dimension getScreenSize() {
        return new Dimension(getScreenWidth(), getScreenHeight());
    }

    public abstract int getScreenWidth();

    @Override // org.apache.poi.java.awt.Toolkit
    public EventQueue getSystemEventQueueImpl() {
        return getSystemEventQueueImplPP();
    }

    @Override // org.apache.poi.sun.awt.WindowClosingSupport
    public WindowClosingListener getWindowClosingListener() {
        return this.windowClosingListener;
    }

    public synchronized long getWindowDeactivationTime(Window window) {
        WeakHashMap weakHashMap = (WeakHashMap) getAppContext(window).get(DEACTIVATION_TIMES_MAP_KEY);
        long jLongValue = -1;
        if (weakHashMap == null) {
            return -1L;
        }
        Long l = (Long) weakHashMap.get(window);
        if (l != null) {
            jLongValue = l.longValue();
        }
        return jLongValue;
    }

    public abstract void grab(Window window);

    public abstract boolean isDesktopSupported();

    public boolean isModalExcludedSupportedImpl() {
        return false;
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public boolean isModalExclusionTypeSupported(Dialog.ModalExclusionType modalExclusionType) {
        return modalExclusionType == Dialog.ModalExclusionType.NO_EXCLUDE;
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public boolean isModalityTypeSupported(Dialog.ModalityType modalityType) {
        return modalityType == Dialog.ModalityType.MODELESS || modalityType == Dialog.ModalityType.APPLICATION_MODAL;
    }

    public boolean isNativeGTKAvailable() {
        return false;
    }

    public boolean isPrintableCharacterModifiersMask(int i) {
        return (i & 8) == (i & 2);
    }

    public boolean isSwingBackbufferTranslucencySupported() {
        return false;
    }

    public boolean isTranslucencyCapable(GraphicsConfiguration graphicsConfiguration) {
        return false;
    }

    public abstract boolean isTraySupported();

    public boolean isWindowOpacitySupported() {
        return false;
    }

    public boolean isWindowShapingSupported() {
        return false;
    }

    public boolean isWindowTranslucencySupported() {
        return false;
    }

    public final boolean isXEmbedServerRequested() {
        return ((Boolean) AccessController.doPrivileged(new GetBooleanAction("org.apache.poi.sun.awt.xembedserver"))).booleanValue();
    }

    public boolean needUpdateWindow() {
        return false;
    }

    public boolean needsXEmbedImpl() {
        return false;
    }

    public final void notifyModalityChange(int i, Dialog dialog) {
        new ModalityEvent(dialog, this.modalityListeners, i).dispatch();
    }

    public void notifyModalityPopped(Dialog dialog) {
        notifyModalityChange(1301, dialog);
    }

    public void notifyModalityPushed(Dialog dialog) {
        notifyModalityChange(1300, dialog);
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public boolean prepareImage(Image image, int i, int i2, ImageObserver imageObserver) {
        return true;
    }

    public void realSync() {
        realSync(10000L);
    }

    public void removeModalityListener(ModalityListener modalityListener) {
        this.modalityListeners.remove(modalityListener);
    }

    @Override // org.apache.poi.sun.awt.WindowClosingSupport
    public void setWindowClosingListener(WindowClosingListener windowClosingListener) {
        this.windowClosingListener = windowClosingListener;
    }

    public synchronized void setWindowDeactivationTime(Window window, long j) {
        try {
            AppContext appContext = getAppContext(window);
            Object obj = DEACTIVATION_TIMES_MAP_KEY;
            WeakHashMap weakHashMap = (WeakHashMap) appContext.get(obj);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                appContext.put(obj, weakHashMap);
            }
            weakHashMap.put(window, Long.valueOf(j));
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract boolean syncNativeQueue(long j);

    public abstract void ungrab(Window window);

    public boolean useBufferPerWindow() {
        return false;
    }

    public final boolean waitForIdle(final long j) throws Throwable {
        boolean z;
        flushPendingEvents();
        boolean zIsEQEmpty = isEQEmpty();
        this.queueEmpty = false;
        this.eventDispatched = false;
        synchronized (this.waitLock) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                postEvent(AppContext.getAppContext(), new PeerEvent(getSystemEventQueueImpl(), null, 4L) { // from class: org.apache.poi.sun.awt.SunToolkit.3
                    public void dispatch() {
                        for (int i = 0; SunToolkit.this.syncNativeQueue(j) && i < 20; i++) {
                        }
                        SunToolkit.flushPendingEvents();
                        synchronized (SunToolkit.this.waitLock) {
                            SunToolkit sunToolkit = SunToolkit.this;
                            sunToolkit.queueEmpty = sunToolkit.isEQEmpty();
                            SunToolkit.this.eventDispatched = true;
                            SunToolkit.this.waitLock.notifyAll();
                        }
                    }
                });
                while (!this.eventDispatched) {
                    try {
                        this.waitLock.wait();
                    } catch (InterruptedException unused) {
                        return false;
                    }
                }
                try {
                    Thread.sleep(0L);
                    flushPendingEvents();
                    synchronized (this.waitLock) {
                        try {
                            z = (this.queueEmpty && isEQEmpty() && zIsEQEmpty) ? false : true;
                        } finally {
                        }
                    }
                    return z;
                } catch (InterruptedException unused2) {
                    throw new RuntimeException("Interrupted");
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Override // org.apache.poi.sun.awt.WindowClosingListener
    public RuntimeException windowClosingDelivered(WindowEvent windowEvent) {
        WindowClosingListener windowClosingListener = this.windowClosingListener;
        if (windowClosingListener != null) {
            return windowClosingListener.windowClosingDelivered(windowEvent);
        }
        return null;
    }

    @Override // org.apache.poi.sun.awt.WindowClosingListener
    public RuntimeException windowClosingNotify(WindowEvent windowEvent) {
        WindowClosingListener windowClosingListener = this.windowClosingListener;
        if (windowClosingListener != null) {
            return windowClosingListener.windowClosingNotify(windowEvent);
        }
        return null;
    }

    public static final void awtLockWait(long j) throws InterruptedException {
        AWT_LOCK_COND.await(j, TimeUnit.MILLISECONDS);
    }

    public static void executeOnEventHandlerThread(Object obj, Runnable runnable, final long j) {
        executeOnEventHandlerThread(new PeerEvent(obj, runnable, 1L) { // from class: org.apache.poi.sun.awt.SunToolkit.2
            public long getWhen() {
                return j;
            }
        });
    }

    public static EventQueue getSystemEventQueueImplPP(AppContext appContext) {
        return (EventQueue) appContext.get(AppContext.EVENT_QUEUE_KEY);
    }

    public static boolean imageCached(URL url) {
        return urlImgCache.containsKey(url.toString());
    }

    private static boolean isInstanceOf(Class<?> cls, String str) {
        if (cls == null) {
            return false;
        }
        if (cls.getName().equals(str)) {
            return true;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (cls2.getName().equals(str)) {
                return true;
            }
        }
        return isInstanceOf((Class<?>) cls.getSuperclass(), str);
    }

    public void disableBackgroundErase(Component component) {
        disableBackgroundEraseImpl(component);
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public Image getImage(URL url) {
        return getImageFromHash(this, url);
    }

    public void realSync(long j) {
        if (EventQueue.isDispatchThread()) {
            throw new IllegalThreadException("The SunToolkit.realSync() method cannot be used on the event dispatch thread (EDT).");
        }
        int i = 0;
        do {
            sync();
            int i2 = 0;
            while (syncNativeQueue(j) && i2 < 20) {
                i2++;
            }
            if (i2 >= 20) {
                throw new InfiniteLoop();
            }
            int i4 = 0;
            while (waitForIdle(j) && i4 < 20) {
                i4++;
            }
            if (i4 >= 20) {
                throw new InfiniteLoop();
            }
            i++;
            if (!syncNativeQueue(j) && !waitForIdle(j)) {
                return;
            }
        } while (i < 20);
    }

    private static void checkPermissions(URL url) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            try {
                Permission connectPermission = URLUtil.getConnectPermission(url);
                if (connectPermission != null) {
                    try {
                        securityManager.checkPermission(connectPermission);
                    } catch (SecurityException e) {
                        if ((connectPermission instanceof FilePermission) && connectPermission.getActions().indexOf("read") != -1) {
                            securityManager.checkRead(connectPermission.getName());
                        } else {
                            if ((connectPermission instanceof SocketPermission) && connectPermission.getActions().indexOf("connect") != -1) {
                                securityManager.checkConnect(url.getHost(), url.getPort());
                                return;
                            }
                            throw e;
                        }
                    }
                }
            } catch (IOException unused) {
                securityManager.checkConnect(url.getHost(), url.getPort());
            }
        }
    }

    public static final AppContext createNewAppContext(ThreadGroup threadGroup) {
        AppContext appContext = new AppContext(threadGroup);
        initEQ(appContext);
        return appContext;
    }

    public static void executeOnEventHandlerThread(PeerEvent peerEvent) {
        postEvent(targetToAppContext(peerEvent.getSource()), peerEvent);
    }

    public static void flushPendingEvents(AppContext appContext) {
        PostEventQueue postEventQueue = (PostEventQueue) appContext.get(POST_EVENT_QUEUE_KEY);
        if (postEventQueue != null) {
            postEventQueue.flush();
        }
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public Image createImage(URL url) {
        checkPermissions(url);
        return createImage((ImageProducer) new URLImageSource(url));
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public Image createImage(byte[] bArr, int i, int i2) {
        return createImage((ImageProducer) new ByteArrayImageSource(bArr, i, i2));
    }

    public static boolean imageExists(URL url) {
        if (url != null) {
            checkPermissions(url);
            try {
                InputStream inputStreamOpenStream = url.openStream();
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // org.apache.poi.java.awt.Toolkit
    public Image createImage(ImageProducer imageProducer) {
        return new ToolkitImage(imageProducer);
    }

    public Image getImageWithResolutionVariant(URL url, URL url2) {
        Image imageCreateImageWithResolutionVariant;
        SoftCache softCache = urlImgCache;
        synchronized (softCache) {
            imageCreateImageWithResolutionVariant = createImageWithResolutionVariant(getImageFromHash(this, url), getImageFromHash(this, url2));
            softCache.put(url.toString(), imageCreateImageWithResolutionVariant);
        }
        return imageCreateImageWithResolutionVariant;
    }

    public static Image getImageFromHash(Toolkit toolkit, String str) {
        Image imageCreateImage;
        checkPermissions(str);
        SoftCache softCache = fileImgCache;
        synchronized (softCache) {
            imageCreateImage = (Image) softCache.get(str);
            if (imageCreateImage == null) {
                try {
                    imageCreateImage = toolkit.createImage((ImageProducer) new FileImageSource(str));
                    softCache.put(str, imageCreateImage);
                } catch (Exception unused) {
                }
            }
        }
        return imageCreateImage;
    }

    public void showOrHideTouchKeyboard(Component component, AWTEvent aWTEvent) {
    }
}
