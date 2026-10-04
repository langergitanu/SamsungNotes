package org.apache.poi.sun.awt;

import org.apache.poi.java.awt.Canvas;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.Panel;
import org.apache.poi.java.awt.Scrollbar;
import org.apache.poi.java.awt.Window;
import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.java.awt.peer.KeyboardFocusManagerPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.CausedFocusEvent;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class KeyboardFocusManagerPeerImpl implements KeyboardFocusManagerPeer {
    public static final int SNFH_FAILURE = 0;
    public static final int SNFH_SUCCESS_HANDLED = 1;
    public static final int SNFH_SUCCESS_PROCEED = 2;
    private static final PlatformLogger focusLog = PlatformLogger.getLogger("org.apache.poi.sun.awt.focus.KeyboardFocusManagerPeerImpl");
    private static AWTAccessor.KeyboardFocusManagerAccessor kfmAccessor = AWTAccessor.getKeyboardFocusManagerAccessor();

    public static boolean deliverFocus(Component component, Component component2, boolean z, boolean z2, long j, CausedFocusEvent.Cause cause, Component component3) {
        CausedFocusEvent.Cause cause2;
        if (component != null) {
            component2 = component;
        }
        if (component3 != null && component3.getPeer() == null) {
            component3 = null;
        }
        Component component4 = component3;
        if (component4 != null) {
            Component component5 = component2;
            cause2 = cause;
            CausedFocusEvent causedFocusEvent = new CausedFocusEvent(component4, 1005, false, component5, cause2);
            component4 = component4;
            component2 = component5;
            PlatformLogger platformLogger = focusLog;
            if (platformLogger.isLoggable(PlatformLogger.Level.FINER)) {
                platformLogger.finer("Posting focus event: " + causedFocusEvent);
            }
            SunToolkit.postEvent(SunToolkit.targetToAppContext(component4), causedFocusEvent);
        } else {
            cause2 = cause;
        }
        CausedFocusEvent causedFocusEvent2 = new CausedFocusEvent(component2, 1004, false, component4, cause2);
        PlatformLogger platformLogger2 = focusLog;
        if (platformLogger2.isLoggable(PlatformLogger.Level.FINER)) {
            platformLogger2.finer("Posting focus event: " + causedFocusEvent2);
        }
        SunToolkit.postEvent(SunToolkit.targetToAppContext(component2), causedFocusEvent2);
        return true;
    }

    public static boolean processSynchronousLightweightTransfer(Component component, Component component2, boolean z, boolean z2, long j) {
        return kfmAccessor.processSynchronousLightweightTransfer(component, component2, z, z2, j);
    }

    public static void removeLastFocusRequest(Component component) {
        kfmAccessor.removeLastFocusRequest(component);
    }

    public static boolean requestFocusFor(Component component, CausedFocusEvent.Cause cause) {
        return AWTAccessor.getComponentAccessor().requestFocus(component, cause);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean shouldFocusOnClick(Component component) {
        boolean zIsFocusable;
        if ((component instanceof Canvas) || (component instanceof Scrollbar)) {
            zIsFocusable = true;
        } else {
            if (!(component instanceof Panel)) {
                ComponentPeer peer = component != null ? component.getPeer() : null;
                if (peer != null) {
                    zIsFocusable = peer.isFocusable();
                }
            } else if (((Panel) component).getComponentCount() == 0) {
            }
            zIsFocusable = false;
        }
        return zIsFocusable && AWTAccessor.getComponentAccessor().canBeFocusOwner(component);
    }

    public static int shouldNativelyFocusHeavyweight(Component component, Component component2, boolean z, boolean z2, long j, CausedFocusEvent.Cause cause) {
        return kfmAccessor.shouldNativelyFocusHeavyweight(component, component2, z, z2, j, cause);
    }

    public void clearGlobalFocusOwner(Window window) {
        if (window != null) {
            Component focusOwner = window.getFocusOwner();
            PlatformLogger platformLogger = focusLog;
            if (platformLogger.isLoggable(PlatformLogger.Level.FINE)) {
                platformLogger.fine("Clearing global focus owner " + focusOwner);
            }
            if (focusOwner != null) {
                SunToolkit.postPriorityEvent(new CausedFocusEvent(focusOwner, 1005, false, (Component) null, CausedFocusEvent.Cause.CLEAR_GLOBAL_FOCUS_OWNER));
            }
        }
    }
}
