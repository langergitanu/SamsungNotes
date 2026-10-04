package org.apache.poi.java.awt;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import org.apache.poi.java.awt.event.FocusEvent;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.event.WindowEvent;
import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.java.awt.peer.LightweightPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.CausedFocusEvent;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
public class DefaultKeyboardFocusManager extends KeyboardFocusManager {
    private boolean consumeNextKeyTyped;
    private int inSendMessage;
    private static final PlatformLogger focusLog = PlatformLogger.getLogger("org.apache.poi.java.awt.focus.DefaultKeyboardFocusManager");
    private static final WeakReference<Window> NULL_WINDOW_WR = new WeakReference<>(null);
    private static final WeakReference<Component> NULL_COMPONENT_WR = new WeakReference<>(null);
    private WeakReference<Window> realOppositeWindowWR = NULL_WINDOW_WR;
    private WeakReference<Component> realOppositeComponentWR = NULL_COMPONENT_WR;
    private LinkedList enqueuedKeyEvents = new LinkedList();
    private LinkedList typeAheadMarkers = new LinkedList();

    public static class DefaultKeyboardFocusManagerSentEvent extends SentEvent {
        private static final long serialVersionUID = -2924743257508701758L;

        public DefaultKeyboardFocusManagerSentEvent(AWTEvent aWTEvent, AppContext appContext) {
            super(aWTEvent, appContext);
        }

        @Override // org.apache.poi.java.awt.SentEvent, org.apache.poi.java.awt.ActiveEvent
        public final void dispatch() {
            KeyboardFocusManager currentKeyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            DefaultKeyboardFocusManager defaultKeyboardFocusManager = currentKeyboardFocusManager instanceof DefaultKeyboardFocusManager ? (DefaultKeyboardFocusManager) currentKeyboardFocusManager : null;
            if (defaultKeyboardFocusManager != null) {
                synchronized (defaultKeyboardFocusManager) {
                    DefaultKeyboardFocusManager.access$108(defaultKeyboardFocusManager);
                }
            }
            super.dispatch();
            if (defaultKeyboardFocusManager != null) {
                synchronized (defaultKeyboardFocusManager) {
                    DefaultKeyboardFocusManager.access$110(defaultKeyboardFocusManager);
                }
            }
        }
    }

    public static class TypeAheadMarker {
        long after;
        Component untilFocused;

        public TypeAheadMarker(long j, Component component) {
            this.after = j;
            this.untilFocused = component;
        }

        public String toString() {
            return ">>> Marker after " + this.after + " on " + this.untilFocused;
        }
    }

    static {
        AWTAccessor.setDefaultKeyboardFocusManagerAccessor(new AWTAccessor.DefaultKeyboardFocusManagerAccessor() { // from class: org.apache.poi.java.awt.DefaultKeyboardFocusManager.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.DefaultKeyboardFocusManagerAccessor
            public void consumeNextKeyTyped(DefaultKeyboardFocusManager defaultKeyboardFocusManager, KeyEvent keyEvent) {
                defaultKeyboardFocusManager.consumeNextKeyTyped(keyEvent);
            }
        });
    }

    public static /* synthetic */ int access$108(DefaultKeyboardFocusManager defaultKeyboardFocusManager) {
        int i = defaultKeyboardFocusManager.inSendMessage;
        defaultKeyboardFocusManager.inSendMessage = i + 1;
        return i;
    }

    public static /* synthetic */ int access$110(DefaultKeyboardFocusManager defaultKeyboardFocusManager) {
        int i = defaultKeyboardFocusManager.inSendMessage;
        defaultKeyboardFocusManager.inSendMessage = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void consumeNextKeyTyped(KeyEvent keyEvent) {
        this.consumeNextKeyTyped = true;
    }

    private boolean consumeProcessedKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getID() != 400 || !this.consumeNextKeyTyped) {
            return false;
        }
        keyEvent.consume();
        this.consumeNextKeyTyped = false;
        return true;
    }

    private void consumeTraversalKey(KeyEvent keyEvent) {
        keyEvent.consume();
        this.consumeNextKeyTyped = keyEvent.getID() == 401 && !keyEvent.isActionKey();
    }

    private boolean doRestoreFocus(Component component, Component component2, boolean z) {
        if (component != component2 && component.isShowing() && component.canBeFocusOwner() && component.requestFocus(false, CausedFocusEvent.Cause.ROLLBACK)) {
            return true;
        }
        Component nextFocusCandidate = component.getNextFocusCandidate();
        if (nextFocusCandidate != null && nextFocusCandidate != component2 && nextFocusCandidate.requestFocusInWindow(CausedFocusEvent.Cause.ROLLBACK)) {
            return true;
        }
        if (!z) {
            return false;
        }
        clearGlobalFocusOwner();
        return true;
    }

    private Window getOwningFrameDialog(Window window) {
        while (window != null && !(window instanceof Frame) && !(window instanceof Dialog)) {
            window = (Window) window.getParent();
        }
        return window;
    }

    private boolean hasMarker(Component component) {
        Iterator it = this.typeAheadMarkers.iterator();
        while (it.hasNext()) {
            if (((TypeAheadMarker) it.next()).untilFocused == component) {
                return true;
            }
        }
        return false;
    }

    private boolean preDispatchKeyEvent(KeyEvent keyEvent) {
        ComponentPeer peer;
        if (keyEvent.isPosted) {
            Component focusOwner = getFocusOwner();
            if (focusOwner == null) {
                focusOwner = getFocusedWindow();
            }
            keyEvent.setSource(focusOwner);
        }
        if (keyEvent.getSource() == null) {
            return true;
        }
        EventQueue.setCurrentEventAndMostRecentTime(keyEvent);
        if (KeyboardFocusManager.isProxyActive(keyEvent)) {
            Container nativeContainer = ((Component) keyEvent.getSource()).getNativeContainer();
            if (nativeContainer != null && (peer = nativeContainer.getPeer()) != null) {
                peer.handleEvent(keyEvent);
                keyEvent.consume();
            }
            return true;
        }
        java.util.List<KeyEventDispatcher> keyEventDispatchers = getKeyEventDispatchers();
        if (keyEventDispatchers != null) {
            Iterator<KeyEventDispatcher> it = keyEventDispatchers.iterator();
            while (it.hasNext()) {
                if (it.next().dispatchKeyEvent(keyEvent)) {
                    return true;
                }
            }
        }
        return dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pumpApprovedKeyEvents() {
        KeyEvent keyEvent;
        do {
            synchronized (this) {
                try {
                    keyEvent = null;
                    if (this.enqueuedKeyEvents.size() != 0) {
                        KeyEvent keyEvent2 = (KeyEvent) this.enqueuedKeyEvents.getFirst();
                        if (this.typeAheadMarkers.size() != 0) {
                            if (keyEvent2.getWhen() <= ((TypeAheadMarker) this.typeAheadMarkers.getFirst()).after) {
                                keyEvent = keyEvent2;
                            }
                            if (keyEvent != null) {
                                focusLog.finer("Pumping approved event {0}", new Object[]{keyEvent});
                                this.enqueuedKeyEvents.removeFirst();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (keyEvent != null) {
                preDispatchKeyEvent(keyEvent);
            }
        } while (keyEvent != null);
    }

    private void purgeStampedEvents(long j, long j2) {
        if (j < 0) {
            return;
        }
        Iterator it = this.enqueuedKeyEvents.iterator();
        while (it.hasNext()) {
            long when = ((KeyEvent) it.next()).getWhen();
            if (j < when && (j2 < 0 || when <= j2)) {
                it.remove();
            }
            if (j2 >= 0 && when > j2) {
                return;
            }
        }
    }

    private void restoreFocus(FocusEvent focusEvent, Window window) {
        Component component = this.realOppositeComponentWR.get();
        Component component2 = focusEvent.getComponent();
        if (window == null || !restoreFocus(window, component2, false)) {
            if (component == null || !doRestoreFocus(component, component2, false)) {
                if (focusEvent.getOppositeComponent() == null || !doRestoreFocus(focusEvent.getOppositeComponent(), component2, false)) {
                    clearGlobalFocusOwner();
                }
            }
        }
    }

    public static boolean sendMessage(Component component, AWTEvent aWTEvent) {
        aWTEvent.isPosted = true;
        AppContext appContext = AppContext.getAppContext();
        final AppContext appContext2 = component.appContext;
        final DefaultKeyboardFocusManagerSentEvent defaultKeyboardFocusManagerSentEvent = new DefaultKeyboardFocusManagerSentEvent(aWTEvent, appContext);
        if (appContext == appContext2) {
            defaultKeyboardFocusManagerSentEvent.dispatch();
        } else {
            if (appContext2.isDisposed()) {
                return false;
            }
            SunToolkit.postEvent(appContext2, defaultKeyboardFocusManagerSentEvent);
            if (EventQueue.isDispatchThread()) {
                ((EventDispatchThread) Thread.currentThread()).pumpEvents(1007, new Conditional() { // from class: org.apache.poi.java.awt.DefaultKeyboardFocusManager.2
                    @Override // org.apache.poi.java.awt.Conditional
                    public boolean evaluate() {
                        return (defaultKeyboardFocusManagerSentEvent.dispatched || appContext2.isDisposed()) ? false : true;
                    }
                });
            } else {
                synchronized (defaultKeyboardFocusManagerSentEvent) {
                    while (!defaultKeyboardFocusManagerSentEvent.dispatched && !appContext2.isDisposed()) {
                        try {
                            defaultKeyboardFocusManagerSentEvent.wait(1000L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
        return defaultKeyboardFocusManagerSentEvent.dispatched;
    }

    private boolean typeAheadAssertions(Component component, AWTEvent aWTEvent) {
        pumpApprovedKeyEvents();
        int id = aWTEvent.getID();
        if (id != 1004) {
            switch (id) {
                case 400:
                case 401:
                case 402:
                    KeyEvent keyEvent = (KeyEvent) aWTEvent;
                    synchronized (this) {
                        try {
                            if (aWTEvent.isPosted && this.typeAheadMarkers.size() != 0) {
                                TypeAheadMarker typeAheadMarker = (TypeAheadMarker) this.typeAheadMarkers.getFirst();
                                if (keyEvent.getWhen() > typeAheadMarker.after) {
                                    focusLog.finer("Storing event {0} because of marker {1}", new Object[]{keyEvent, typeAheadMarker});
                                    this.enqueuedKeyEvents.addLast(keyEvent);
                                    return true;
                                }
                            }
                            return preDispatchKeyEvent(keyEvent);
                        } finally {
                        }
                    }
                default:
                    redispatchEvent(component, aWTEvent);
                    return true;
            }
        }
        PlatformLogger platformLogger = focusLog;
        platformLogger.finest("Markers before FOCUS_GAINED on {0}", new Object[]{component});
        dumpMarkers();
        synchronized (this) {
            try {
                if (hasMarker(component)) {
                    Iterator it = this.typeAheadMarkers.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        if (((TypeAheadMarker) it.next()).untilFocused == component) {
                            z = true;
                        } else if (z) {
                        }
                        it.remove();
                    }
                } else {
                    platformLogger.finer("Event without marker {0}", new Object[]{aWTEvent});
                }
            } finally {
            }
        }
        focusLog.finest("Markers after FOCUS_GAINED");
        dumpMarkers();
        redispatchEvent(component, aWTEvent);
        pumpApprovedKeyEvents();
        return true;
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    public void clearMarkers() {
        synchronized (this) {
            this.typeAheadMarkers.clear();
        }
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    public synchronized void dequeueKeyEvents(long j, Component component) {
        if (component == null) {
            return;
        }
        try {
            focusLog.finer("Dequeue at {0} for {1}", new Object[]{Long.valueOf(j), component});
            LinkedList linkedList = this.typeAheadMarkers;
            ListIterator listIterator = linkedList.listIterator(j >= 0 ? linkedList.size() : 0);
            if (j < 0) {
                while (listIterator.hasNext()) {
                    if (((TypeAheadMarker) listIterator.next()).untilFocused == component) {
                        listIterator.remove();
                        return;
                    }
                }
            } else {
                while (listIterator.hasPrevious()) {
                    TypeAheadMarker typeAheadMarker = (TypeAheadMarker) listIterator.previous();
                    if (typeAheadMarker.untilFocused == component && typeAheadMarker.after == j) {
                        listIterator.remove();
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r6 == r12) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (r9 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        if (r6 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if ((r6 instanceof org.apache.poi.java.awt.Window) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        r6 = r6.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        if (r6 != r12) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        if (r9 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        if (r3 >= 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        r3 = r5.after;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        r0.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
    
        if (r3 < 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0023, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0031 -> B:12:0x0020). Please report as a decompilation issue!!! */
    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void discardKeyEvents(Component component) {
        TypeAheadMarker typeAheadMarker;
        if (component == null) {
            return;
        }
        try {
            Iterator it = this.typeAheadMarkers.iterator();
            while (true) {
                long j = -1;
                while (it.hasNext()) {
                    typeAheadMarker = (TypeAheadMarker) it.next();
                    Component parent = typeAheadMarker.untilFocused;
                }
                purgeStampedEvents(j, -1L);
                return;
                purgeStampedEvents(j, typeAheadMarker.after);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x0214, code lost:
    
        if (getGlobalPermanentFocusOwner() != null) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0105  */
    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchEvent(AWTEvent aWTEvent) {
        long j;
        Component temporaryLostComponent;
        Component temporaryLostComponent2;
        PlatformLogger platformLogger = focusLog;
        platformLogger.isLoggable(500);
        int id = aWTEvent.getID();
        if (id == 1004) {
            CausedFocusEvent causedFocusEvent = (FocusEvent) aWTEvent;
            CausedFocusEvent.Cause cause = causedFocusEvent instanceof CausedFocusEvent ? causedFocusEvent.getCause() : CausedFocusEvent.Cause.UNKNOWN;
            Component globalFocusOwner = getGlobalFocusOwner();
            Component component = causedFocusEvent.getComponent();
            if (globalFocusOwner == component) {
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("Skipping {0} because focus owner is the same", new Object[]{aWTEvent});
                }
                dequeueKeyEvents(-1L, component);
            } else {
                if (globalFocusOwner != null) {
                    j = -1;
                    if (!sendMessage(globalFocusOwner, new CausedFocusEvent(globalFocusOwner, 1005, causedFocusEvent.isTemporary(), component, cause))) {
                        setGlobalFocusOwner(null);
                        if (!causedFocusEvent.isTemporary()) {
                            setGlobalPermanentFocusOwner(null);
                        }
                    }
                } else {
                    j = -1;
                }
                Window containingWindow = SunToolkit.getContainingWindow(component);
                Window globalFocusedWindow = getGlobalFocusedWindow();
                if (containingWindow != null && containingWindow != globalFocusedWindow) {
                    sendMessage(containingWindow, new WindowEvent(containingWindow, 207, globalFocusedWindow));
                    if (containingWindow != getGlobalFocusedWindow()) {
                        dequeueKeyEvents(j, component);
                    }
                } else if (component.isFocusable() && component.isShowing() && (component.isEnabled() || cause.equals(CausedFocusEvent.Cause.UNKNOWN))) {
                    setGlobalFocusOwner(component);
                    if (component == getGlobalFocusOwner()) {
                        if (!causedFocusEvent.isTemporary()) {
                            setGlobalPermanentFocusOwner(component);
                            if (component != getGlobalPermanentFocusOwner()) {
                                dequeueKeyEvents(j, component);
                                if (KeyboardFocusManager.isAutoFocusTransferEnabled()) {
                                }
                            }
                        }
                        setNativeFocusOwner(KeyboardFocusManager.getHeavyweight(component));
                        Component component2 = this.realOppositeComponentWR.get();
                        if (component2 != null && component2 != causedFocusEvent.getOppositeComponent()) {
                            CausedFocusEvent causedFocusEvent2 = new CausedFocusEvent(component, 1004, causedFocusEvent.isTemporary(), component2, cause);
                            component = component;
                            causedFocusEvent2.isPosted = true;
                            causedFocusEvent = causedFocusEvent2;
                        }
                        return typeAheadAssertions(component, causedFocusEvent);
                    }
                    dequeueKeyEvents(j, component);
                    if (KeyboardFocusManager.isAutoFocusTransferEnabled()) {
                    }
                } else {
                    dequeueKeyEvents(j, component);
                    if (KeyboardFocusManager.isAutoFocusTransferEnabled()) {
                        if (containingWindow == null) {
                            restoreFocus((FocusEvent) causedFocusEvent, globalFocusedWindow);
                        } else {
                            restoreFocus((FocusEvent) causedFocusEvent, containingWindow);
                        }
                    }
                }
            }
        } else if (id != 1005) {
            switch (id) {
                case 205:
                    WindowEvent windowEvent = (WindowEvent) aWTEvent;
                    Window globalActiveWindow = getGlobalActiveWindow();
                    Window window = windowEvent.getWindow();
                    if (globalActiveWindow != window) {
                        if (globalActiveWindow == null) {
                            setGlobalActiveWindow(window);
                            if (window == getGlobalActiveWindow()) {
                                return typeAheadAssertions(window, windowEvent);
                            }
                        } else {
                            if (!sendMessage(globalActiveWindow, new WindowEvent(globalActiveWindow, 206, window))) {
                                setGlobalActiveWindow(null);
                            }
                            if (getGlobalActiveWindow() == null) {
                            }
                        }
                    }
                    break;
                case 206:
                    WindowEvent windowEvent2 = (WindowEvent) aWTEvent;
                    Window globalActiveWindow2 = getGlobalActiveWindow();
                    if (globalActiveWindow2 != null && globalActiveWindow2 == aWTEvent.getSource()) {
                        setGlobalActiveWindow(null);
                        if (getGlobalActiveWindow() == null) {
                            windowEvent2.setSource(globalActiveWindow2);
                            return typeAheadAssertions(globalActiveWindow2, windowEvent2);
                        }
                    }
                    break;
                case 207:
                    WindowEvent windowEvent3 = (WindowEvent) aWTEvent;
                    Window globalFocusedWindow2 = getGlobalFocusedWindow();
                    Window window2 = windowEvent3.getWindow();
                    if (window2 != globalFocusedWindow2) {
                        if (window2.isFocusableWindow() && window2.isVisible() && window2.isDisplayable()) {
                            if (globalFocusedWindow2 != null && !sendMessage(globalFocusedWindow2, new WindowEvent(globalFocusedWindow2, JPEG.RST0, window2))) {
                                setGlobalFocusOwner(null);
                                setGlobalFocusedWindow(null);
                            }
                            Window owningFrameDialog = getOwningFrameDialog(window2);
                            Window globalActiveWindow3 = getGlobalActiveWindow();
                            if (owningFrameDialog != globalActiveWindow3) {
                                sendMessage(owningFrameDialog, new WindowEvent(owningFrameDialog, 205, globalActiveWindow3));
                                if (owningFrameDialog == getGlobalActiveWindow()) {
                                    setGlobalFocusedWindow(window2);
                                    if (window2 == getGlobalFocusedWindow()) {
                                        if (this.inSendMessage == 0) {
                                            Component mostRecentFocusOwner = KeyboardFocusManager.getMostRecentFocusOwner(window2);
                                            if (mostRecentFocusOwner == null && window2.isFocusableWindow()) {
                                                mostRecentFocusOwner = window2.getFocusTraversalPolicy().getInitialComponent(window2);
                                            }
                                            synchronized (KeyboardFocusManager.class) {
                                                temporaryLostComponent = window2.setTemporaryLostComponent(null);
                                                break;
                                            }
                                            if (platformLogger.isLoggable(400)) {
                                                platformLogger.finer("tempLost {0}, toFocus {1}", new Object[]{temporaryLostComponent, mostRecentFocusOwner});
                                            }
                                            if (temporaryLostComponent != null) {
                                                temporaryLostComponent.requestFocusInWindow(CausedFocusEvent.Cause.ACTIVATION);
                                            }
                                            if (mostRecentFocusOwner != null && mostRecentFocusOwner != temporaryLostComponent) {
                                                mostRecentFocusOwner.requestFocusInWindow(CausedFocusEvent.Cause.ACTIVATION);
                                            }
                                        }
                                        Window window3 = this.realOppositeWindowWR.get();
                                        if (window3 != windowEvent3.getOppositeWindow()) {
                                            windowEvent3 = new WindowEvent(window2, 207, window3);
                                        }
                                        return typeAheadAssertions(window2, windowEvent3);
                                    }
                                }
                            }
                        }
                        restoreFocus(windowEvent3);
                    }
                    break;
                case JPEG.RST0 /* 208 */:
                    WindowEvent windowEvent4 = (WindowEvent) aWTEvent;
                    Window globalFocusedWindow3 = getGlobalFocusedWindow();
                    Window window4 = windowEvent4.getWindow();
                    Window globalActiveWindow4 = getGlobalActiveWindow();
                    Window oppositeWindow = windowEvent4.getOppositeWindow();
                    if (platformLogger.isLoggable(500)) {
                        platformLogger.fine("Active {0}, Current focused {1}, losing focus {2} opposite {3}", new Object[]{globalActiveWindow4, globalFocusedWindow3, window4, oppositeWindow});
                    }
                    if (globalFocusedWindow3 != null && (this.inSendMessage != 0 || window4 != globalActiveWindow4 || oppositeWindow != globalFocusedWindow3)) {
                        Component globalFocusOwner2 = getGlobalFocusOwner();
                        if (globalFocusOwner2 != null) {
                            if (oppositeWindow != null) {
                                temporaryLostComponent2 = oppositeWindow.getTemporaryLostComponent();
                                if (temporaryLostComponent2 == null) {
                                    temporaryLostComponent2 = oppositeWindow.getMostRecentFocusOwner();
                                }
                            } else {
                                temporaryLostComponent2 = null;
                            }
                            sendMessage(globalFocusOwner2, new CausedFocusEvent(globalFocusOwner2, 1005, true, temporaryLostComponent2 == null ? oppositeWindow : temporaryLostComponent2, CausedFocusEvent.Cause.ACTIVATION));
                        }
                        setGlobalFocusedWindow(null);
                        if (getGlobalFocusedWindow() != null) {
                            restoreFocus(globalFocusedWindow3, null, true);
                            break;
                        } else {
                            windowEvent4.setSource(globalFocusedWindow3);
                            this.realOppositeWindowWR = oppositeWindow != null ? new WeakReference<>(globalFocusedWindow3) : NULL_WINDOW_WR;
                            typeAheadAssertions(globalFocusedWindow3, windowEvent4);
                            if (oppositeWindow == null) {
                                sendMessage(globalActiveWindow4, new WindowEvent(globalActiveWindow4, 206, (Window) null));
                                if (getGlobalActiveWindow() != null) {
                                }
                            }
                        }
                    }
                    break;
                default:
                    switch (id) {
                        case 400:
                        case 401:
                        case 402:
                            return typeAheadAssertions(null, aWTEvent);
                        default:
                            return false;
                    }
            }
        } else {
            FocusEvent focusEvent = (FocusEvent) aWTEvent;
            Component globalFocusOwner3 = getGlobalFocusOwner();
            if (globalFocusOwner3 == null) {
                if (platformLogger.isLoggable(500)) {
                    platformLogger.fine("Skipping {0} because focus owner is null", new Object[]{aWTEvent});
                }
            } else if (globalFocusOwner3 != focusEvent.getOppositeComponent()) {
                setGlobalFocusOwner(null);
                if (getGlobalFocusOwner() == null) {
                    if (focusEvent.isTemporary()) {
                        Window containingWindow2 = globalFocusOwner3.getContainingWindow();
                        if (containingWindow2 != null) {
                            containingWindow2.setTemporaryLostComponent(globalFocusOwner3);
                        }
                    } else {
                        setGlobalPermanentFocusOwner(null);
                    }
                    setNativeFocusOwner(null);
                    focusEvent.setSource(globalFocusOwner3);
                    this.realOppositeComponentWR = focusEvent.getOppositeComponent() != null ? new WeakReference<>(globalFocusOwner3) : NULL_COMPONENT_WR;
                    return typeAheadAssertions(globalFocusOwner3, focusEvent);
                }
                restoreFocus(globalFocusOwner3, true);
            } else if (platformLogger.isLoggable(500)) {
                platformLogger.fine("Skipping {0} because current focus owner is equal to opposite", new Object[]{aWTEvent});
            }
        }
        return true;
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager, org.apache.poi.java.awt.KeyEventDispatcher
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Container nativeContainer;
        Component component;
        Component focusOwner = keyEvent.isPosted ? getFocusOwner() : keyEvent.getComponent();
        if (focusOwner != null && focusOwner.isShowing() && focusOwner.canBeFocusOwner() && !keyEvent.isConsumed() && (component = keyEvent.getComponent()) != null && component.isEnabled()) {
            redispatchEvent(component, keyEvent);
        }
        java.util.List<KeyEventPostProcessor> keyEventPostProcessors = getKeyEventPostProcessors();
        boolean zPostProcessKeyEvent = false;
        if (keyEventPostProcessors != null) {
            Iterator<KeyEventPostProcessor> it = keyEventPostProcessors.iterator();
            while (!zPostProcessKeyEvent && it.hasNext()) {
                zPostProcessKeyEvent = it.next().postProcessKeyEvent(keyEvent);
            }
        }
        if (!zPostProcessKeyEvent) {
            postProcessKeyEvent(keyEvent);
        }
        Component component2 = keyEvent.getComponent();
        ComponentPeer peer = component2.getPeer();
        if ((peer == null || (peer instanceof LightweightPeer)) && (nativeContainer = component2.getNativeContainer()) != null) {
            peer = nativeContainer.getPeer();
        }
        if (peer == null) {
            return true;
        }
        peer.handleEvent(keyEvent);
        return true;
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    public void downFocusCycle(Container container) {
        if (container == null || !container.isFocusCycleRoot()) {
            return;
        }
        container.transferFocusDownCycle();
    }

    public void dumpMarkers() {
        PlatformLogger platformLogger = focusLog;
        if (platformLogger.isLoggable(300)) {
            platformLogger.finest(">>> Markers dump, time: {0}", new Object[]{Long.valueOf(System.currentTimeMillis())});
            synchronized (this) {
                try {
                    if (this.typeAheadMarkers.size() != 0) {
                        Iterator it = this.typeAheadMarkers.iterator();
                        while (it.hasNext()) {
                            focusLog.finest("    {0}", new Object[]{(TypeAheadMarker) it.next()});
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    public synchronized void enqueueKeyEvents(long j, Component component) {
        if (component == null) {
            return;
        }
        try {
            focusLog.finer("Enqueue at {0} for {1}", new Object[]{Long.valueOf(j), component});
            int size = this.typeAheadMarkers.size();
            ListIterator listIterator = this.typeAheadMarkers.listIterator(size);
            while (true) {
                if (size <= 0) {
                    size = 0;
                    break;
                } else if (((TypeAheadMarker) listIterator.previous()).after <= j) {
                    break;
                } else {
                    size--;
                }
            }
            this.typeAheadMarkers.add(size, new TypeAheadMarker(j, component));
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    public void focusNextComponent(Component component) {
        if (component != null) {
            component.transferFocus();
        }
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    public void focusPreviousComponent(Component component) {
        if (component != null) {
            component.transferFocusBackward();
        }
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager, org.apache.poi.java.awt.KeyEventPostProcessor
    public boolean postProcessKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.isConsumed()) {
            return true;
        }
        Component component = keyEvent.getComponent();
        if (!(component instanceof Container)) {
            component = component.getParent();
        }
        Container container = (Container) component;
        if (container == null) {
            return true;
        }
        container.postProcessKeyEvent(keyEvent);
        return true;
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    public void processKeyEvent(Component component, KeyEvent keyEvent) {
        if (consumeProcessedKeyEvent(keyEvent) || keyEvent.getID() == 400 || !component.getFocusTraversalKeysEnabled() || keyEvent.isConsumed()) {
            return;
        }
        AWTKeyStroke aWTKeyStrokeForEvent = AWTKeyStroke.getAWTKeyStrokeForEvent(keyEvent);
        AWTKeyStroke aWTKeyStroke = AWTKeyStroke.getAWTKeyStroke(aWTKeyStrokeForEvent.getKeyCode(), aWTKeyStrokeForEvent.getModifiers(), !aWTKeyStrokeForEvent.isOnKeyRelease());
        Set<AWTKeyStroke> focusTraversalKeys = component.getFocusTraversalKeys(0);
        boolean zContains = focusTraversalKeys.contains(aWTKeyStrokeForEvent);
        boolean zContains2 = focusTraversalKeys.contains(aWTKeyStroke);
        if (zContains || zContains2) {
            consumeTraversalKey(keyEvent);
            if (zContains) {
                focusNextComponent(component);
                return;
            }
            return;
        }
        if (keyEvent.getID() == 401) {
            this.consumeNextKeyTyped = false;
        }
        Set<AWTKeyStroke> focusTraversalKeys2 = component.getFocusTraversalKeys(1);
        boolean zContains3 = focusTraversalKeys2.contains(aWTKeyStrokeForEvent);
        boolean zContains4 = focusTraversalKeys2.contains(aWTKeyStroke);
        if (zContains3 || zContains4) {
            consumeTraversalKey(keyEvent);
            if (zContains3) {
                focusPreviousComponent(component);
                return;
            }
            return;
        }
        Set<AWTKeyStroke> focusTraversalKeys3 = component.getFocusTraversalKeys(2);
        boolean zContains5 = focusTraversalKeys3.contains(aWTKeyStrokeForEvent);
        boolean zContains6 = focusTraversalKeys3.contains(aWTKeyStroke);
        if (zContains5 || zContains6) {
            consumeTraversalKey(keyEvent);
            if (zContains5) {
                upFocusCycle(component);
                return;
            }
            return;
        }
        if (component instanceof Container) {
            Container container = (Container) component;
            if (container.isFocusCycleRoot()) {
                Set<AWTKeyStroke> focusTraversalKeys4 = component.getFocusTraversalKeys(3);
                boolean zContains7 = focusTraversalKeys4.contains(aWTKeyStrokeForEvent);
                boolean zContains8 = focusTraversalKeys4.contains(aWTKeyStroke);
                if (zContains7 || zContains8) {
                    consumeTraversalKey(keyEvent);
                    if (zContains7) {
                        downFocusCycle(container);
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.java.awt.KeyboardFocusManager
    public void upFocusCycle(Component component) {
        if (component != null) {
            component.transferFocusUpCycle();
        }
    }

    private void restoreFocus(WindowEvent windowEvent) {
        Window window = this.realOppositeWindowWR.get();
        if (window == null || !restoreFocus(window, null, false)) {
            if (windowEvent.getOppositeWindow() == null || !restoreFocus(windowEvent.getOppositeWindow(), null, false)) {
                clearGlobalFocusOwner();
            }
        }
    }

    private boolean restoreFocus(Component component, boolean z) {
        return doRestoreFocus(component, null, z);
    }

    private boolean restoreFocus(Window window, Component component, boolean z) {
        Component mostRecentFocusOwner = KeyboardFocusManager.getMostRecentFocusOwner(window);
        if (mostRecentFocusOwner != null && mostRecentFocusOwner != component && doRestoreFocus(mostRecentFocusOwner, component, false)) {
            return true;
        }
        if (!z) {
            return false;
        }
        clearGlobalFocusOwner();
        return true;
    }
}
