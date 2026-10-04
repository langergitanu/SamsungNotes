package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import org.apache.poi.java.awt.event.FocusEvent;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.peer.KeyboardFocusManagerPeer;
import org.apache.poi.java.awt.peer.LightweightPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.CausedFocusEvent;
import org.apache.poi.sun.awt.KeyboardFocusManagerPeerProvider;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
public abstract class KeyboardFocusManager implements KeyEventDispatcher, KeyEventPostProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BACKWARD_TRAVERSAL_KEYS = 1;
    public static final int DOWN_CYCLE_TRAVERSAL_KEYS = 3;
    public static final int FORWARD_TRAVERSAL_KEYS = 0;
    static final int SNFH_FAILURE = 0;
    static final int SNFH_SUCCESS_HANDLED = 1;
    static final int SNFH_SUCCESS_PROCEED = 2;
    static final int TRAVERSAL_KEY_LENGTH = 4;
    public static final int UP_CYCLE_TRAVERSAL_KEYS = 2;
    private static Window activeWindow = null;
    private static boolean allowSyncFocusRequests = false;
    private static boolean clearingCurrentLightweightRequests = false;
    private static Container currentFocusCycleRoot = null;
    private static LinkedList<LightweightFocusRequest> currentLightweightRequests = null;
    private static final String[] defaultFocusTraversalKeyPropertyNames;
    private static final AWTKeyStroke[][] defaultFocusTraversalKeyStrokes;
    private static volatile boolean disableRestoreFocus = false;
    private static final PlatformLogger focusLog = PlatformLogger.getLogger("org.apache.poi.java.awt.focus.KeyboardFocusManager");
    private static Component focusOwner = null;
    private static Window focusedWindow = null;
    private static LinkedList<HeavyweightFocusRequest> heavyweightRequests = null;
    private static final PlatformLogger log;
    private static Map mostRecentFocusOwners = null;
    private static Component newFocusOwner = null;
    private static final String notPrivileged = "this KeyboardFocusManager is not installed in the current thread's context";
    private static Component permanentFocusOwner;
    static Field proxyActive;
    private static AWTPermission replaceKeyboardFocusManagerPermission;
    private PropertyChangeSupport changeSupport;
    private LinkedList keyEventDispatchers;
    private LinkedList keyEventPostProcessors;
    transient KeyboardFocusManagerPeer peer;
    private VetoableChangeSupport vetoableSupport;
    private FocusTraversalPolicy defaultPolicy = new DefaultFocusTraversalPolicy();
    private Set[] defaultFocusTraversalKeys = new Set[4];
    transient SequencedEvent currentSequencedEvent = null;

    public static final class HeavyweightFocusRequest {
        static final HeavyweightFocusRequest CLEAR_GLOBAL_FOCUS_OWNER = new HeavyweightFocusRequest();
        final Component heavyweight;
        final LinkedList<LightweightFocusRequest> lightweightRequests;

        private HeavyweightFocusRequest() {
            this.heavyweight = null;
            this.lightweightRequests = null;
        }

        public boolean addLightweightRequest(Component component, boolean z, CausedFocusEvent.Cause cause) {
            if (KeyboardFocusManager.log.isLoggable(500)) {
                if (this == CLEAR_GLOBAL_FOCUS_OWNER) {
                    KeyboardFocusManager.log.fine("Assertion (this != HeavyweightFocusRequest.CLEAR_GLOBAL_FOCUS_OWNER) failed");
                }
                if (component == null) {
                    KeyboardFocusManager.log.fine("Assertion (descendant != null) failed");
                }
            }
            if (component == (this.lightweightRequests.size() > 0 ? this.lightweightRequests.getLast().component : null)) {
                return false;
            }
            this.lightweightRequests.add(new LightweightFocusRequest(component, z, cause));
            return true;
        }

        public LightweightFocusRequest getFirstLightweightRequest() {
            if (this == CLEAR_GLOBAL_FOCUS_OWNER) {
                return null;
            }
            return this.lightweightRequests.getFirst();
        }

        public String toString() {
            String strM756B;
            String str = "HeavyweightFocusRequest[heavweight=" + this.heavyweight + ",lightweightRequests=";
            if (this.lightweightRequests == null) {
                strM756B = str + ((Object) null);
            } else {
                String strM756B2 = AbstractC0541b.m756B(str, "[");
                boolean z = true;
                for (LightweightFocusRequest lightweightFocusRequest : this.lightweightRequests) {
                    if (z) {
                        z = false;
                    } else {
                        strM756B2 = AbstractC0541b.m756B(strM756B2, ",");
                    }
                    strM756B2 = strM756B2 + lightweightFocusRequest;
                }
                strM756B = AbstractC0541b.m756B(strM756B2, "]");
            }
            return AbstractC0541b.m756B(strM756B, "]");
        }

        public HeavyweightFocusRequest(Component component, Component component2, boolean z, CausedFocusEvent.Cause cause) {
            if (KeyboardFocusManager.log.isLoggable(500) && component == null) {
                KeyboardFocusManager.log.fine("Assertion (heavyweight != null) failed");
            }
            this.heavyweight = component;
            this.lightweightRequests = new LinkedList<>();
            addLightweightRequest(component2, z, cause);
        }
    }

    public static final class LightweightFocusRequest {
        final CausedFocusEvent.Cause cause;
        final Component component;
        final boolean temporary;

        public LightweightFocusRequest(Component component, boolean z, CausedFocusEvent.Cause cause) {
            this.component = component;
            this.temporary = z;
            this.cause = cause;
        }

        public String toString() {
            return "LightweightFocusRequest[component=" + this.component + ",temporary=" + this.temporary + ", cause=" + this.cause + "]";
        }
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setKeyboardFocusManagerAccessor(new AWTAccessor.KeyboardFocusManagerAccessor() { // from class: org.apache.poi.java.awt.KeyboardFocusManager.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.KeyboardFocusManagerAccessor
            public Container getCurrentFocusCycleRoot() {
                return KeyboardFocusManager.currentFocusCycleRoot;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.KeyboardFocusManagerAccessor
            public KeyboardFocusManager getCurrentKeyboardFocusManager(AppContext appContext) {
                return KeyboardFocusManager.getCurrentKeyboardFocusManager(appContext);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.KeyboardFocusManagerAccessor
            public boolean processSynchronousLightweightTransfer(Component component, Component component2, boolean z, boolean z2, long j) {
                return KeyboardFocusManager.processSynchronousLightweightTransfer(component, component2, z, z2, j);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.KeyboardFocusManagerAccessor
            public void removeLastFocusRequest(Component component) {
                KeyboardFocusManager.removeLastFocusRequest(component);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.KeyboardFocusManagerAccessor
            public void setMostRecentFocusOwner(Window window, Component component) {
                KeyboardFocusManager.setMostRecentFocusOwner(window, component);
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.KeyboardFocusManagerAccessor
            public int shouldNativelyFocusHeavyweight(Component component, Component component2, boolean z, boolean z2, long j, CausedFocusEvent.Cause cause) {
                return KeyboardFocusManager.shouldNativelyFocusHeavyweight(component, component2, z, z2, j, cause);
            }
        });
        log = PlatformLogger.getLogger("org.apache.poi.java.awt.KeyboardFocusManager");
        defaultFocusTraversalKeyPropertyNames = new String[]{"forwardDefaultFocusTraversalKeys", "backwardDefaultFocusTraversalKeys", "upCycleDefaultFocusTraversalKeys", "downCycleDefaultFocusTraversalKeys"};
        defaultFocusTraversalKeyStrokes = new AWTKeyStroke[][]{new AWTKeyStroke[]{AWTKeyStroke.getAWTKeyStroke(9, 0, false), AWTKeyStroke.getAWTKeyStroke(9, 130, false)}, new AWTKeyStroke[]{AWTKeyStroke.getAWTKeyStroke(9, 65, false), AWTKeyStroke.getAWTKeyStroke(9, JPEG.SOF3, false)}, new AWTKeyStroke[0], new AWTKeyStroke[0]};
        mostRecentFocusOwners = new WeakHashMap();
        heavyweightRequests = new LinkedList<>();
        allowSyncFocusRequests = true;
        newFocusOwner = null;
    }

    public KeyboardFocusManager() {
        for (int i = 0; i < 4; i++) {
            HashSet hashSet = new HashSet();
            int i2 = 0;
            while (true) {
                AWTKeyStroke[] aWTKeyStrokeArr = defaultFocusTraversalKeyStrokes[i];
                if (i2 >= aWTKeyStrokeArr.length) {
                    break;
                }
                hashSet.add(aWTKeyStrokeArr[i2]);
                i2++;
            }
            this.defaultFocusTraversalKeys[i] = hashSet.isEmpty() ? Collections.EMPTY_SET : Collections.unmodifiableSet(hashSet);
        }
        initPeer();
    }

    private void _clearGlobalFocusOwner() {
        this.peer.clearGlobalFocusOwner(markClearGlobalFocusOwner());
    }

    private void checkKFMSecurity() {
        if (this != getCurrentKeyboardFocusManager()) {
            checkReplaceKFMPermission();
        }
    }

    private static void checkReplaceKFMPermission() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            if (replaceKeyboardFocusManagerPermission == null) {
                replaceKeyboardFocusManagerPermission = new AWTPermission("replaceKeyboardFocusManager");
            }
            securityManager.checkPermission(replaceKeyboardFocusManagerPermission);
        }
    }

    public static void clearMostRecentFocusOwner(Component component) {
        Container parent;
        if (component == null) {
            return;
        }
        synchronized (component.getTreeLock()) {
            try {
                parent = component.getParent();
                while (parent != null && !(parent instanceof Window)) {
                    parent = parent.getParent();
                }
            } finally {
            }
        }
        synchronized (KeyboardFocusManager.class) {
            if (parent != null) {
                try {
                    if (getMostRecentFocusOwner((Window) parent) == component) {
                        setMostRecentFocusOwner((Window) parent, null);
                    }
                } finally {
                }
            }
            if (parent != null) {
                Window window = (Window) parent;
                if (window.getTemporaryLostComponent() == component) {
                    window.setTemporaryLostComponent(null);
                }
            }
        }
    }

    private static Throwable dispatchAndCatchException(Throwable th, Component component, FocusEvent focusEvent) {
        try {
            component.dispatchEvent(focusEvent);
            e = null;
        } catch (Error e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        }
        if (e == null) {
            return th;
        }
        if (th != null) {
            handleException(th);
        }
        return e;
    }

    private static boolean focusedWindowChanged(Component component, Component component2) {
        Window containingWindow = SunToolkit.getContainingWindow(component);
        Window containingWindow2 = SunToolkit.getContainingWindow(component2);
        return (containingWindow == null && containingWindow2 == null) || containingWindow == null || containingWindow2 == null || containingWindow != containingWindow2;
    }

    public static KeyboardFocusManager getCurrentKeyboardFocusManager() {
        return getCurrentKeyboardFocusManager(AppContext.getAppContext());
    }

    private static HeavyweightFocusRequest getFirstHWRequest() {
        HeavyweightFocusRequest first;
        synchronized (heavyweightRequests) {
            try {
                first = heavyweightRequests.size() > 0 ? heavyweightRequests.getFirst() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return first;
    }

    public static Component getHeavyweight(Component component) {
        if (component == null || component.getPeer() == null) {
            return null;
        }
        return component.getPeer() instanceof LightweightPeer ? component.getNativeContainer() : component;
    }

    private static HeavyweightFocusRequest getLastHWRequest() {
        HeavyweightFocusRequest last;
        synchronized (heavyweightRequests) {
            try {
                last = heavyweightRequests.size() > 0 ? heavyweightRequests.getLast() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return last;
    }

    public static synchronized Component getMostRecentFocusOwner(Window window) {
        WeakReference weakReference;
        weakReference = (WeakReference) mostRecentFocusOwners.get(window);
        return weakReference == null ? null : (Component) weakReference.get();
    }

    private static void handleException(Throwable th) {
        th.printStackTrace();
    }

    public static Set initFocusTraversalKeysSet(String str, Set set) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            set.add(AWTKeyStroke.getAWTKeyStroke(stringTokenizer.nextToken()));
        }
        return set.isEmpty() ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
    }

    private static native void initIDs();

    private void initPeer() {
        this.peer = ((KeyboardFocusManagerPeerProvider) Toolkit.getDefaultToolkit()).getKeyboardFocusManagerPeer();
    }

    public static boolean isAutoFocusTransferEnabled() {
        boolean z;
        synchronized (heavyweightRequests) {
            try {
                z = heavyweightRequests.size() == 0 && !disableRestoreFocus && currentLightweightRequests == null;
            } finally {
            }
        }
        return z;
    }

    public static boolean isAutoFocusTransferEnabledFor(Component component) {
        return isAutoFocusTransferEnabled() && component.isAutoFocusTransferOnDisposal();
    }

    public static boolean isProxyActive(KeyEvent keyEvent) {
        if (GraphicsEnvironment.isHeadless()) {
            return false;
        }
        return isProxyActiveImpl(keyEvent);
    }

    private static boolean isProxyActiveImpl(KeyEvent keyEvent) {
        if (proxyActive == null) {
            proxyActive = (Field) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.KeyboardFocusManager.3
                static final /* synthetic */ boolean $assertionsDisabled = false;

                @Override // java.security.PrivilegedAction
                public Object run() {
                    Field declaredField = null;
                    try {
                        declaredField = KeyEvent.class.getDeclaredField("isProxyActive");
                        if (declaredField != null) {
                            declaredField.setAccessible(true);
                        }
                    } catch (NoSuchFieldException unused) {
                    }
                    return declaredField;
                }
            });
        }
        try {
            return proxyActive.getBoolean(keyEvent);
        } catch (IllegalAccessException unused) {
            return false;
        }
    }

    private static boolean isTemporary(Component component, Component component2) {
        Window containingWindow = SunToolkit.getContainingWindow(component);
        Window containingWindow2 = SunToolkit.getContainingWindow(component2);
        if (containingWindow == null && containingWindow2 == null) {
            return false;
        }
        if (containingWindow == null) {
            return true;
        }
        return (containingWindow2 == null || containingWindow == containingWindow2) ? false : true;
    }

    public static Window markClearGlobalFocusOwner() {
        Container nativeFocusedWindow = getCurrentKeyboardFocusManager().getNativeFocusedWindow();
        synchronized (heavyweightRequests) {
            try {
                HeavyweightFocusRequest lastHWRequest = getLastHWRequest();
                HeavyweightFocusRequest heavyweightFocusRequest = HeavyweightFocusRequest.CLEAR_GLOBAL_FOCUS_OWNER;
                if (lastHWRequest == heavyweightFocusRequest) {
                    return null;
                }
                heavyweightRequests.add(heavyweightFocusRequest);
                if (lastHWRequest != null) {
                    nativeFocusedWindow = SunToolkit.getContainingWindow(lastHWRequest.heavyweight);
                }
                while (nativeFocusedWindow != null && !(nativeFocusedWindow instanceof Frame) && !(nativeFocusedWindow instanceof Dialog)) {
                    nativeFocusedWindow = nativeFocusedWindow.getParent_NoClientCode();
                }
                return (Window) nativeFocusedWindow;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void processCurrentLightweightRequests() {
        KeyboardFocusManager currentKeyboardFocusManager = getCurrentKeyboardFocusManager();
        Component globalFocusOwner = currentKeyboardFocusManager.getGlobalFocusOwner();
        if (globalFocusOwner == null || globalFocusOwner.appContext == AppContext.getAppContext()) {
            synchronized (heavyweightRequests) {
                if (currentLightweightRequests != null) {
                    clearingCurrentLightweightRequests = true;
                    disableRestoreFocus = true;
                    LinkedList<LightweightFocusRequest> linkedList = currentLightweightRequests;
                    allowSyncFocusRequests = linkedList.size() < 2;
                    currentLightweightRequests = null;
                    try {
                        Iterator<LightweightFocusRequest> it = linkedList.iterator();
                        Throwable thDispatchAndCatchException = null;
                        Component component = null;
                        while (it.hasNext()) {
                            Component globalFocusOwner2 = currentKeyboardFocusManager.getGlobalFocusOwner();
                            LightweightFocusRequest next = it.next();
                            if (!it.hasNext()) {
                                disableRestoreFocus = false;
                            }
                            CausedFocusEvent causedFocusEvent = globalFocusOwner2 != null ? new CausedFocusEvent(globalFocusOwner2, 1005, next.temporary, next.component, next.cause) : null;
                            CausedFocusEvent causedFocusEvent2 = new CausedFocusEvent(next.component, 1004, next.temporary, globalFocusOwner2 == null ? component : globalFocusOwner2, next.cause);
                            if (globalFocusOwner2 != null) {
                                causedFocusEvent.isPosted = true;
                                thDispatchAndCatchException = dispatchAndCatchException(thDispatchAndCatchException, globalFocusOwner2, causedFocusEvent);
                            }
                            causedFocusEvent2.isPosted = true;
                            thDispatchAndCatchException = dispatchAndCatchException(thDispatchAndCatchException, next.component, causedFocusEvent2);
                            Component globalFocusOwner3 = currentKeyboardFocusManager.getGlobalFocusOwner();
                            Component component2 = next.component;
                            if (globalFocusOwner3 == component2) {
                                component = component2;
                            }
                        }
                        clearingCurrentLightweightRequests = false;
                        disableRestoreFocus = false;
                        allowSyncFocusRequests = true;
                        if (thDispatchAndCatchException instanceof RuntimeException) {
                            throw ((RuntimeException) thDispatchAndCatchException);
                        }
                        if (thDispatchAndCatchException instanceof Error) {
                            throw ((Error) thDispatchAndCatchException);
                        }
                    } catch (Throwable th) {
                        clearingCurrentLightweightRequests = false;
                        disableRestoreFocus = false;
                        allowSyncFocusRequests = true;
                        throw th;
                    }
                }
            }
        }
    }

    public static boolean processSynchronousLightweightTransfer(Component component, Component component2, boolean z, boolean z2, long j) {
        FocusEvent focusEvent;
        FocusEvent focusEvent2;
        Window containingWindow = SunToolkit.getContainingWindow(component);
        boolean z3 = false;
        if (containingWindow == null || !containingWindow.syncLWRequests) {
            return false;
        }
        if (component2 == null) {
            component2 = component;
        }
        KeyboardFocusManager currentKeyboardFocusManager = getCurrentKeyboardFocusManager(SunToolkit.targetToAppContext(component2));
        Component globalFocusOwner = currentKeyboardFocusManager.getGlobalFocusOwner();
        synchronized (heavyweightRequests) {
            try {
                Throwable thDispatchAndCatchException = null;
                boolean z4 = true;
                if (getLastHWRequest() != null || component != currentKeyboardFocusManager.getNativeFocusOwner() || !allowSyncFocusRequests) {
                    focusEvent = null;
                    focusEvent2 = null;
                } else {
                    if (component2 == globalFocusOwner) {
                        return true;
                    }
                    currentKeyboardFocusManager.enqueueKeyEvents(j, component2);
                    heavyweightRequests.add(new HeavyweightFocusRequest(component, component2, z, CausedFocusEvent.Cause.UNKNOWN));
                    focusEvent = globalFocusOwner != null ? new FocusEvent(globalFocusOwner, 1005, z, component2) : null;
                    focusEvent2 = new FocusEvent(component2, 1004, z, globalFocusOwner);
                }
                boolean z5 = clearingCurrentLightweightRequests;
                try {
                    clearingCurrentLightweightRequests = false;
                    synchronized (Component.LOCK) {
                        if (focusEvent != null && globalFocusOwner != null) {
                            try {
                                focusEvent.isPosted = true;
                                thDispatchAndCatchException = dispatchAndCatchException(null, globalFocusOwner, focusEvent);
                                z3 = true;
                            } finally {
                            }
                        }
                        if (focusEvent2 == null || component2 == null) {
                            z4 = z3;
                        } else {
                            focusEvent2.isPosted = true;
                            thDispatchAndCatchException = dispatchAndCatchException(thDispatchAndCatchException, component2, focusEvent2);
                        }
                    }
                    clearingCurrentLightweightRequests = z5;
                    if (thDispatchAndCatchException instanceof RuntimeException) {
                        throw ((RuntimeException) thDispatchAndCatchException);
                    }
                    if (thDispatchAndCatchException instanceof Error) {
                        throw ((Error) thDispatchAndCatchException);
                    }
                    return z4;
                } catch (Throwable th) {
                    clearingCurrentLightweightRequests = z5;
                    throw th;
                }
            } finally {
            }
        }
    }

    public static boolean removeFirstRequest() {
        boolean z;
        KeyboardFocusManager currentKeyboardFocusManager = getCurrentKeyboardFocusManager();
        synchronized (heavyweightRequests) {
            try {
                HeavyweightFocusRequest firstHWRequest = getFirstHWRequest();
                if (firstHWRequest != null) {
                    heavyweightRequests.removeFirst();
                    LinkedList<LightweightFocusRequest> linkedList = firstHWRequest.lightweightRequests;
                    if (linkedList != null) {
                        Iterator<LightweightFocusRequest> it = linkedList.iterator();
                        while (it.hasNext()) {
                            currentKeyboardFocusManager.dequeueKeyEvents(-1L, it.next().component);
                        }
                    }
                }
                if (heavyweightRequests.size() == 0) {
                    currentKeyboardFocusManager.clearMarkers();
                }
                z = heavyweightRequests.size() > 0;
            } finally {
            }
        }
        return z;
    }

    public static void removeLastFocusRequest(Component component) {
        PlatformLogger platformLogger = log;
        if (platformLogger.isLoggable(500) && component == null) {
            platformLogger.fine("Assertion (heavyweight != null) failed");
        }
        KeyboardFocusManager currentKeyboardFocusManager = getCurrentKeyboardFocusManager();
        synchronized (heavyweightRequests) {
            try {
                HeavyweightFocusRequest lastHWRequest = getLastHWRequest();
                if (lastHWRequest != null && lastHWRequest.heavyweight == component) {
                    heavyweightRequests.removeLast();
                }
                if (heavyweightRequests.size() == 0) {
                    currentKeyboardFocusManager.clearMarkers();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static AWTEvent retargetFocusEvent(AWTEvent aWTEvent) {
        throw null;
    }

    public static FocusEvent retargetFocusGained(FocusEvent focusEvent) {
        Component globalFocusOwner = getCurrentKeyboardFocusManager().getGlobalFocusOwner();
        Component component = focusEvent.getComponent();
        Component oppositeComponent = focusEvent.getOppositeComponent();
        Component heavyweight = getHeavyweight(component);
        synchronized (heavyweightRequests) {
            try {
                HeavyweightFocusRequest firstHWRequest = getFirstHWRequest();
                if (firstHWRequest != HeavyweightFocusRequest.CLEAR_GLOBAL_FOCUS_OWNER) {
                    if (component != null && heavyweight == null && firstHWRequest != null && component == firstHWRequest.getFirstLightweightRequest().component) {
                        component = firstHWRequest.heavyweight;
                        heavyweight = component;
                    }
                    if (firstHWRequest != null && heavyweight == firstHWRequest.heavyweight) {
                        heavyweightRequests.removeFirst();
                        LightweightFocusRequest lightweightFocusRequestRemoveFirst = firstHWRequest.lightweightRequests.removeFirst();
                        Component component2 = lightweightFocusRequestRemoveFirst.component;
                        if (globalFocusOwner != null) {
                            newFocusOwner = component2;
                        }
                        boolean z = (oppositeComponent == null || isTemporary(component2, oppositeComponent)) ? false : lightweightFocusRequestRemoveFirst.temporary;
                        if (firstHWRequest.lightweightRequests.size() > 0) {
                            currentLightweightRequests = firstHWRequest.lightweightRequests;
                            EventQueue.invokeLater(new Runnable() { // from class: org.apache.poi.java.awt.KeyboardFocusManager.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    KeyboardFocusManager.processCurrentLightweightRequests();
                                }
                            });
                        }
                        return new CausedFocusEvent(component2, 1004, z, oppositeComponent, lightweightFocusRequestRemoveFirst.cause);
                    }
                    if (globalFocusOwner != null && globalFocusOwner.getContainingWindow() == component && (firstHWRequest == null || component != firstHWRequest.heavyweight)) {
                        return new CausedFocusEvent(globalFocusOwner, 1004, false, (Component) null, CausedFocusEvent.Cause.ACTIVATION);
                    }
                }
                return retargetUnexpectedFocusEvent(focusEvent);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static FocusEvent retargetFocusLost(FocusEvent focusEvent) {
        throw null;
    }

    public static FocusEvent retargetUnexpectedFocusEvent(FocusEvent focusEvent) {
        synchronized (heavyweightRequests) {
            try {
                if (removeFirstRequest()) {
                    return retargetFocusEvent(focusEvent);
                }
                Component component = focusEvent.getComponent();
                Component oppositeComponent = focusEvent.getOppositeComponent();
                return new CausedFocusEvent(component, focusEvent.getID(), focusEvent.getID() == 1005 && (oppositeComponent == null || isTemporary(oppositeComponent, component)), oppositeComponent, CausedFocusEvent.Cause.NATIVE_SYSTEM);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setCurrentKeyboardFocusManager(KeyboardFocusManager keyboardFocusManager) {
        KeyboardFocusManager currentKeyboardFocusManager;
        checkReplaceKFMPermission();
        synchronized (KeyboardFocusManager.class) {
            try {
                AppContext appContext = AppContext.getAppContext();
                if (keyboardFocusManager != null) {
                    currentKeyboardFocusManager = getCurrentKeyboardFocusManager(appContext);
                    appContext.put(KeyboardFocusManager.class, keyboardFocusManager);
                } else {
                    currentKeyboardFocusManager = getCurrentKeyboardFocusManager(appContext);
                    appContext.remove(KeyboardFocusManager.class);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (currentKeyboardFocusManager != null) {
            currentKeyboardFocusManager.firePropertyChange("managingFocus", Boolean.TRUE, Boolean.FALSE);
        }
        if (keyboardFocusManager != null) {
            keyboardFocusManager.firePropertyChange("managingFocus", Boolean.FALSE, Boolean.TRUE);
        }
    }

    public static void setMostRecentFocusOwner(Component component) {
        Component component2 = component;
        while (component2 != null && !(component2 instanceof Window)) {
            component2 = component2.parent;
        }
        if (component2 != null) {
            setMostRecentFocusOwner((Window) component2, component);
        }
    }

    public static int shouldNativelyFocusHeavyweight(Component component, Component component2, boolean z, boolean z2, long j, CausedFocusEvent.Cause cause) {
        String str;
        String str2;
        String str3;
        Component component3;
        Component component4;
        PlatformLogger platformLogger = log;
        if (platformLogger.isLoggable(500)) {
            if (component == null) {
                platformLogger.fine("Assertion (heavyweight != null) failed");
            }
            if (j == 0) {
                platformLogger.fine("Assertion (time != 0) failed");
            }
        }
        Component component5 = component2 == null ? component : component2;
        KeyboardFocusManager currentKeyboardFocusManager = getCurrentKeyboardFocusManager(SunToolkit.targetToAppContext(component5));
        KeyboardFocusManager currentKeyboardFocusManager2 = getCurrentKeyboardFocusManager();
        Component globalFocusOwner = currentKeyboardFocusManager2.getGlobalFocusOwner();
        Component nativeFocusOwner = currentKeyboardFocusManager2.getNativeFocusOwner();
        Component nativeFocusedWindow = currentKeyboardFocusManager2.getNativeFocusedWindow();
        PlatformLogger platformLogger2 = focusLog;
        if (platformLogger2.isLoggable(400)) {
            str = "5. SNFH_PROCEED for ";
            platformLogger2.finer("SNFH for {0} in {1}", new Object[]{String.valueOf(component5), String.valueOf(component)});
        } else {
            str = "5. SNFH_PROCEED for ";
        }
        if (platformLogger2.isLoggable(300)) {
            platformLogger2.finest("0. Current focus owner {0}", new Object[]{String.valueOf(globalFocusOwner)});
            platformLogger2.finest("0. Native focus owner {0}", new Object[]{String.valueOf(nativeFocusOwner)});
            platformLogger2.finest("0. Native focused window {0}", new Object[]{String.valueOf(nativeFocusedWindow)});
        }
        synchronized (heavyweightRequests) {
            try {
                HeavyweightFocusRequest lastHWRequest = getLastHWRequest();
                if (platformLogger2.isLoggable(300)) {
                    str2 = "4. SNFH_FAILURE for ";
                    platformLogger2.finest("Request {0}", new Object[]{String.valueOf(lastHWRequest)});
                } else {
                    str2 = "4. SNFH_FAILURE for ";
                }
                int i = 1;
                if (lastHWRequest == null && component == nativeFocusOwner && component.getContainingWindow() == nativeFocusedWindow) {
                    if (component5 == globalFocusOwner) {
                        if (platformLogger2.isLoggable(300)) {
                            platformLogger2.finest("1. SNFH_FAILURE for {0}", new Object[]{String.valueOf(component5)});
                        }
                        return 0;
                    }
                    currentKeyboardFocusManager.enqueueKeyEvents(j, component5);
                    heavyweightRequests.add(new HeavyweightFocusRequest(component, component5, z, cause));
                    if (globalFocusOwner != null) {
                        Component component6 = component5;
                        CausedFocusEvent causedFocusEvent = new CausedFocusEvent(globalFocusOwner, 1005, z, component6, cause);
                        component4 = globalFocusOwner;
                        component3 = component6;
                        SunToolkit.postEvent(component4.appContext, causedFocusEvent);
                    } else {
                        component3 = component5;
                        component4 = globalFocusOwner;
                    }
                    Component component7 = component3;
                    SunToolkit.postEvent(component7.appContext, new CausedFocusEvent(component3, 1004, z, component4, cause));
                    if (platformLogger2.isLoggable(300)) {
                        platformLogger2.finest("2. SNFH_HANDLED for {0}", new Object[]{String.valueOf(component7)});
                    }
                    return i;
                }
                Component component8 = component5;
                if (lastHWRequest == null || lastHWRequest.heavyweight != component) {
                    i = 2;
                    if (!z2) {
                        if (lastHWRequest == HeavyweightFocusRequest.CLEAR_GLOBAL_FOCUS_OWNER) {
                            int size = heavyweightRequests.size();
                            lastHWRequest = size >= 2 ? heavyweightRequests.get(size - 2) : null;
                        }
                        if (lastHWRequest != null) {
                            nativeFocusedWindow = lastHWRequest.heavyweight;
                        }
                        if (focusedWindowChanged(component, nativeFocusedWindow)) {
                            if (platformLogger2.isLoggable(300)) {
                                platformLogger2.finest(str2 + component8);
                            }
                            return 0;
                        }
                    }
                    currentKeyboardFocusManager.enqueueKeyEvents(j, component8);
                    heavyweightRequests.add(new HeavyweightFocusRequest(component, component8, z, cause));
                    if (platformLogger2.isLoggable(300)) {
                        str3 = str + component8;
                        platformLogger2.finest(str3);
                    }
                } else {
                    if (lastHWRequest.addLightweightRequest(component8, z, cause)) {
                        currentKeyboardFocusManager.enqueueKeyEvents(j, component8);
                    }
                    if (platformLogger2.isLoggable(300)) {
                        str3 = "3. SNFH_HANDLED for lightweight" + component8 + " in " + component;
                        platformLogger2.finest(str3);
                    }
                }
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addKeyEventDispatcher(KeyEventDispatcher keyEventDispatcher) {
        if (keyEventDispatcher != null) {
            synchronized (this) {
                try {
                    if (this.keyEventDispatchers == null) {
                        this.keyEventDispatchers = new LinkedList();
                    }
                    this.keyEventDispatchers.add(keyEventDispatcher);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void addKeyEventPostProcessor(KeyEventPostProcessor keyEventPostProcessor) {
        if (keyEventPostProcessor != null) {
            synchronized (this) {
                try {
                    if (this.keyEventPostProcessors == null) {
                        this.keyEventPostProcessors = new LinkedList();
                    }
                    this.keyEventPostProcessors.add(keyEventPostProcessor);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            synchronized (this) {
                try {
                    if (this.changeSupport == null) {
                        this.changeSupport = new PropertyChangeSupport(this);
                    }
                    this.changeSupport.addPropertyChangeListener(propertyChangeListener);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void addVetoableChangeListener(VetoableChangeListener vetoableChangeListener) {
        if (vetoableChangeListener != null) {
            synchronized (this) {
                try {
                    if (this.vetoableSupport == null) {
                        this.vetoableSupport = new VetoableChangeSupport(this);
                    }
                    this.vetoableSupport.addVetoableChangeListener(vetoableChangeListener);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void clearGlobalFocusOwner() {
        synchronized (KeyboardFocusManager.class) {
            checkKFMSecurity();
        }
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        Toolkit.getDefaultToolkit();
        _clearGlobalFocusOwner();
    }

    public abstract void dequeueKeyEvents(long j, Component component);

    public abstract void discardKeyEvents(Component component);

    public abstract boolean dispatchEvent(AWTEvent aWTEvent);

    @Override // org.apache.poi.java.awt.KeyEventDispatcher
    public abstract boolean dispatchKeyEvent(KeyEvent keyEvent);

    public final void downFocusCycle() {
        Component focusOwner2 = getFocusOwner();
        if (focusOwner2 instanceof Container) {
            downFocusCycle((Container) focusOwner2);
        }
    }

    public abstract void downFocusCycle(Container container);

    public void dumpRequests() {
        System.err.println(">>> Requests dump, time: " + System.currentTimeMillis());
        synchronized (heavyweightRequests) {
            try {
                for (HeavyweightFocusRequest heavyweightFocusRequest : heavyweightRequests) {
                    System.err.println(">>> Req: " + heavyweightFocusRequest);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        System.err.println("");
    }

    public abstract void enqueueKeyEvents(long j, Component component);

    public void firePropertyChange(String str, Object obj, Object obj2) {
        PropertyChangeSupport propertyChangeSupport;
        if (obj == obj2 || (propertyChangeSupport = this.changeSupport) == null) {
            return;
        }
        propertyChangeSupport.firePropertyChange(str, obj, obj2);
    }

    public void fireVetoableChange(String str, Object obj, Object obj2) {
        VetoableChangeSupport vetoableChangeSupport;
        if (obj == obj2 || (vetoableChangeSupport = this.vetoableSupport) == null) {
            return;
        }
        vetoableChangeSupport.fireVetoableChange(str, obj, obj2);
    }

    public final void focusNextComponent() {
        Component focusOwner2 = getFocusOwner();
        if (focusOwner2 != null) {
            focusNextComponent(focusOwner2);
        }
    }

    public abstract void focusNextComponent(Component component);

    public final void focusPreviousComponent() {
        Component focusOwner2 = getFocusOwner();
        if (focusOwner2 != null) {
            focusPreviousComponent(focusOwner2);
        }
    }

    public abstract void focusPreviousComponent(Component component);

    public Window getActiveWindow() {
        Window window;
        synchronized (KeyboardFocusManager.class) {
            try {
                Window window2 = activeWindow;
                window = null;
                if (window2 != null && window2.appContext == AppContext.getAppContext()) {
                    window = activeWindow;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return window;
    }

    public Container getCurrentFocusCycleRoot() {
        Container container;
        synchronized (KeyboardFocusManager.class) {
            try {
                Container container2 = currentFocusCycleRoot;
                container = null;
                if (container2 != null && container2.appContext == AppContext.getAppContext()) {
                    container = currentFocusCycleRoot;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return container;
    }

    public final SequencedEvent getCurrentSequencedEvent() {
        SequencedEvent sequencedEvent;
        synchronized (SequencedEvent.class) {
            sequencedEvent = this.currentSequencedEvent;
        }
        return sequencedEvent;
    }

    public Component getCurrentWaitingRequest(Component component) {
        LightweightFocusRequest first;
        synchronized (heavyweightRequests) {
            try {
                HeavyweightFocusRequest firstHWRequest = getFirstHWRequest();
                if (firstHWRequest == null || firstHWRequest.heavyweight != component || (first = firstHWRequest.lightweightRequests.getFirst()) == null) {
                    return null;
                }
                return first.component;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set<AWTKeyStroke> getDefaultFocusTraversalKeys(int i) {
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        return this.defaultFocusTraversalKeys[i];
    }

    public synchronized FocusTraversalPolicy getDefaultFocusTraversalPolicy() {
        return this.defaultPolicy;
    }

    public Component getFocusOwner() {
        Component component;
        synchronized (KeyboardFocusManager.class) {
            try {
                Component component2 = focusOwner;
                component = null;
                if (component2 != null && component2.appContext == AppContext.getAppContext()) {
                    component = focusOwner;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return component;
    }

    public Window getFocusedWindow() {
        Window window;
        synchronized (KeyboardFocusManager.class) {
            try {
                Window window2 = focusedWindow;
                window = null;
                if (window2 != null && window2.appContext == AppContext.getAppContext()) {
                    window = focusedWindow;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return window;
    }

    public Window getGlobalActiveWindow() {
        Window window;
        synchronized (KeyboardFocusManager.class) {
            checkKFMSecurity();
            window = activeWindow;
        }
        return window;
    }

    public Container getGlobalCurrentFocusCycleRoot() {
        Container container;
        synchronized (KeyboardFocusManager.class) {
            checkKFMSecurity();
            container = currentFocusCycleRoot;
        }
        return container;
    }

    public Component getGlobalFocusOwner() {
        Component component;
        synchronized (KeyboardFocusManager.class) {
            checkKFMSecurity();
            component = focusOwner;
        }
        return component;
    }

    public Window getGlobalFocusedWindow() {
        Window window;
        synchronized (KeyboardFocusManager.class) {
            checkKFMSecurity();
            window = focusedWindow;
        }
        return window;
    }

    public Component getGlobalPermanentFocusOwner() {
        Component component;
        synchronized (KeyboardFocusManager.class) {
            checkKFMSecurity();
            component = permanentFocusOwner;
        }
        return component;
    }

    public synchronized java.util.List<KeyEventDispatcher> getKeyEventDispatchers() {
        LinkedList linkedList;
        linkedList = this.keyEventDispatchers;
        return linkedList != null ? (java.util.List) linkedList.clone() : null;
    }

    public java.util.List<KeyEventPostProcessor> getKeyEventPostProcessors() {
        LinkedList linkedList = this.keyEventPostProcessors;
        if (linkedList != null) {
            return (java.util.List) linkedList.clone();
        }
        return null;
    }

    public Component getNativeFocusOwner() {
        return this.peer.getCurrentFocusOwner();
    }

    public Window getNativeFocusedWindow() {
        return this.peer.getCurrentFocusedWindow();
    }

    public Component getPermanentFocusOwner() {
        Component component;
        synchronized (KeyboardFocusManager.class) {
            try {
                Component component2 = permanentFocusOwner;
                component = null;
                if (component2 != null && component2.appContext == AppContext.getAppContext()) {
                    component = permanentFocusOwner;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return component;
    }

    public synchronized PropertyChangeListener[] getPropertyChangeListeners() {
        try {
            if (this.changeSupport == null) {
                this.changeSupport = new PropertyChangeSupport(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.changeSupport.getPropertyChangeListeners();
    }

    public synchronized VetoableChangeListener[] getVetoableChangeListeners() {
        try {
            if (this.vetoableSupport == null) {
                this.vetoableSupport = new VetoableChangeSupport(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.vetoableSupport.getVetoableChangeListeners();
    }

    public abstract boolean postProcessKeyEvent(KeyEvent keyEvent);

    public abstract void processKeyEvent(Component component, KeyEvent keyEvent);

    public final void redispatchEvent(Component component, AWTEvent aWTEvent) {
        aWTEvent.focusManagerIsDispatching = true;
        component.dispatchEvent(aWTEvent);
        aWTEvent.focusManagerIsDispatching = false;
    }

    public void removeKeyEventDispatcher(KeyEventDispatcher keyEventDispatcher) {
        if (keyEventDispatcher != null) {
            synchronized (this) {
                try {
                    LinkedList linkedList = this.keyEventDispatchers;
                    if (linkedList != null) {
                        linkedList.remove(keyEventDispatcher);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void removeKeyEventPostProcessor(KeyEventPostProcessor keyEventPostProcessor) {
        if (keyEventPostProcessor != null) {
            synchronized (this) {
                try {
                    LinkedList linkedList = this.keyEventPostProcessors;
                    if (linkedList != null) {
                        linkedList.remove(keyEventPostProcessor);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            synchronized (this) {
                try {
                    PropertyChangeSupport propertyChangeSupport = this.changeSupport;
                    if (propertyChangeSupport != null) {
                        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void removeVetoableChangeListener(VetoableChangeListener vetoableChangeListener) {
        if (vetoableChangeListener != null) {
            synchronized (this) {
                try {
                    VetoableChangeSupport vetoableChangeSupport = this.vetoableSupport;
                    if (vetoableChangeSupport != null) {
                        vetoableChangeSupport.removeVetoableChangeListener(vetoableChangeListener);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void setCurrentSequencedEvent(SequencedEvent sequencedEvent) {
        synchronized (SequencedEvent.class) {
            this.currentSequencedEvent = sequencedEvent;
        }
    }

    public void setDefaultFocusTraversalKeys(int i, Set<? extends AWTKeyStroke> set) {
        Set set2;
        if (i < 0 || i >= 4) {
            throw new IllegalArgumentException("invalid focus traversal key identifier");
        }
        if (set == null) {
            throw new IllegalArgumentException("cannot set null Set of default focus traversal keys");
        }
        synchronized (this) {
            try {
                for (AWTKeyStroke aWTKeyStroke : set) {
                    if (aWTKeyStroke == null) {
                        throw new IllegalArgumentException("cannot set null focus traversal key");
                    }
                    if (!(aWTKeyStroke instanceof AWTKeyStroke)) {
                        throw new IllegalArgumentException("object is expected to be AWTKeyStroke");
                    }
                    AWTKeyStroke aWTKeyStroke2 = aWTKeyStroke;
                    if (aWTKeyStroke2.getKeyChar() != 65535) {
                        throw new IllegalArgumentException("focus traversal keys cannot map to KEY_TYPED events");
                    }
                    for (int i2 = 0; i2 < 4; i2++) {
                        if (i2 != i && this.defaultFocusTraversalKeys[i2].contains(aWTKeyStroke2)) {
                            throw new IllegalArgumentException("focus traversal keys must be unique for a Component");
                        }
                    }
                }
                Set[] setArr = this.defaultFocusTraversalKeys;
                set2 = setArr[i];
                setArr[i] = Collections.unmodifiableSet(new HashSet(set));
            } catch (Throwable th) {
                throw th;
            }
        }
        firePropertyChange(defaultFocusTraversalKeyPropertyNames[i], set2, set);
    }

    public void setDefaultFocusTraversalPolicy(FocusTraversalPolicy focusTraversalPolicy) {
        FocusTraversalPolicy focusTraversalPolicy2;
        if (focusTraversalPolicy == null) {
            throw new IllegalArgumentException("default focus traversal policy cannot be null");
        }
        synchronized (this) {
            focusTraversalPolicy2 = this.defaultPolicy;
            this.defaultPolicy = focusTraversalPolicy;
        }
        firePropertyChange("defaultFocusTraversalPolicy", focusTraversalPolicy2, focusTraversalPolicy);
    }

    public void setGlobalActiveWindow(Window window) {
        Window activeWindow2;
        synchronized (KeyboardFocusManager.class) {
            checkKFMSecurity();
            activeWindow2 = getActiveWindow();
            PlatformLogger platformLogger = focusLog;
            if (platformLogger.isLoggable(400)) {
                platformLogger.finer("Setting global active window to " + window + ", old active " + activeWindow2);
            }
            try {
                fireVetoableChange("activeWindow", activeWindow2, window);
                activeWindow = window;
            } catch (PropertyVetoException unused) {
                return;
            }
        }
        firePropertyChange("activeWindow", activeWindow2, window);
    }

    public void setGlobalCurrentFocusCycleRoot(Container container) {
        Container currentFocusCycleRoot2;
        synchronized (KeyboardFocusManager.class) {
            checkKFMSecurity();
            currentFocusCycleRoot2 = getCurrentFocusCycleRoot();
            currentFocusCycleRoot = container;
        }
        firePropertyChange("currentFocusCycleRoot", currentFocusCycleRoot2, container);
    }

    public void setGlobalFocusOwner(Component component) {
        Component focusOwner2;
        boolean z;
        Component component2;
        if (component == null || component.isFocusable()) {
            synchronized (KeyboardFocusManager.class) {
                try {
                    checkKFMSecurity();
                    focusOwner2 = getFocusOwner();
                    try {
                        fireVetoableChange("focusOwner", focusOwner2, component);
                        focusOwner = component;
                        if (component != null && (getCurrentFocusCycleRoot() == null || !component.isFocusCycleRoot(getCurrentFocusCycleRoot()))) {
                            Container focusCycleRootAncestor = component.getFocusCycleRootAncestor();
                            if (focusCycleRootAncestor == null && (component instanceof Window)) {
                                focusCycleRootAncestor = (Container) component;
                            }
                            if (focusCycleRootAncestor != null) {
                                setGlobalCurrentFocusCycleRoot(focusCycleRootAncestor);
                            }
                        }
                    } catch (PropertyVetoException unused) {
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = true;
            component2 = focusOwner2;
        } else {
            component2 = null;
            z = false;
        }
        if (z) {
            firePropertyChange("focusOwner", component2, component);
        }
    }

    public void setGlobalFocusedWindow(Window window) {
        Window focusedWindow2;
        boolean z;
        Window window2;
        if (window == null || window.isFocusableWindow()) {
            synchronized (KeyboardFocusManager.class) {
                checkKFMSecurity();
                focusedWindow2 = getFocusedWindow();
                try {
                    fireVetoableChange("focusedWindow", focusedWindow2, window);
                    focusedWindow = window;
                } catch (PropertyVetoException unused) {
                    return;
                }
            }
            z = true;
            window2 = focusedWindow2;
        } else {
            window2 = null;
            z = false;
        }
        if (z) {
            firePropertyChange("focusedWindow", window2, window);
        }
    }

    public void setGlobalPermanentFocusOwner(Component component) {
        Component permanentFocusOwner2;
        boolean z;
        Component component2;
        if (component == null || component.isFocusable()) {
            synchronized (KeyboardFocusManager.class) {
                checkKFMSecurity();
                permanentFocusOwner2 = getPermanentFocusOwner();
                try {
                    fireVetoableChange("permanentFocusOwner", permanentFocusOwner2, component);
                    permanentFocusOwner = component;
                    setMostRecentFocusOwner(component);
                } catch (PropertyVetoException unused) {
                    return;
                }
            }
            z = true;
            component2 = permanentFocusOwner2;
        } else {
            component2 = null;
            z = false;
        }
        if (z) {
            firePropertyChange("permanentFocusOwner", component2, component);
        }
    }

    public void setNativeFocusOwner(Component component) {
        PlatformLogger platformLogger = focusLog;
        if (platformLogger.isLoggable(300)) {
            platformLogger.finest("Calling peer {0} setCurrentFocusOwner for {1}", new Object[]{String.valueOf(this.peer), String.valueOf(component)});
        }
        this.peer.setCurrentFocusOwner(component);
    }

    public final void upFocusCycle() {
        Component focusOwner2 = getFocusOwner();
        if (focusOwner2 != null) {
            upFocusCycle(focusOwner2);
        }
    }

    public abstract void upFocusCycle(Component component);

    public static synchronized KeyboardFocusManager getCurrentKeyboardFocusManager(AppContext appContext) {
        KeyboardFocusManager defaultKeyboardFocusManager;
        defaultKeyboardFocusManager = (KeyboardFocusManager) appContext.get(KeyboardFocusManager.class);
        if (defaultKeyboardFocusManager == null) {
            defaultKeyboardFocusManager = new DefaultKeyboardFocusManager();
            appContext.put(KeyboardFocusManager.class, defaultKeyboardFocusManager);
        }
        return defaultKeyboardFocusManager;
    }

    public static synchronized void setMostRecentFocusOwner(Window window, Component component) {
        WeakReference weakReference;
        if (component != null) {
            try {
                weakReference = new WeakReference(component);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            weakReference = null;
        }
        mostRecentFocusOwners.put(window, weakReference);
    }

    public void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            synchronized (this) {
                try {
                    if (this.changeSupport == null) {
                        this.changeSupport = new PropertyChangeSupport(this);
                    }
                    this.changeSupport.addPropertyChangeListener(str, propertyChangeListener);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void addVetoableChangeListener(String str, VetoableChangeListener vetoableChangeListener) {
        if (vetoableChangeListener != null) {
            synchronized (this) {
                try {
                    if (this.vetoableSupport == null) {
                        this.vetoableSupport = new VetoableChangeSupport(this);
                    }
                    this.vetoableSupport.addVetoableChangeListener(str, vetoableChangeListener);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public synchronized PropertyChangeListener[] getPropertyChangeListeners(String str) {
        try {
            if (this.changeSupport == null) {
                this.changeSupport = new PropertyChangeSupport(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.changeSupport.getPropertyChangeListeners(str);
    }

    public synchronized VetoableChangeListener[] getVetoableChangeListeners(String str) {
        try {
            if (this.vetoableSupport == null) {
                this.vetoableSupport = new VetoableChangeSupport(this);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.vetoableSupport.getVetoableChangeListeners(str);
    }

    public void removePropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            synchronized (this) {
                try {
                    PropertyChangeSupport propertyChangeSupport = this.changeSupport;
                    if (propertyChangeSupport != null) {
                        propertyChangeSupport.removePropertyChangeListener(str, propertyChangeListener);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void removeVetoableChangeListener(String str, VetoableChangeListener vetoableChangeListener) {
        if (vetoableChangeListener != null) {
            synchronized (this) {
                try {
                    VetoableChangeSupport vetoableChangeSupport = this.vetoableSupport;
                    if (vetoableChangeSupport != null) {
                        vetoableChangeSupport.removeVetoableChangeListener(str, vetoableChangeListener);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void clearMarkers() {
    }
}
