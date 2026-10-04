package org.apache.poi.java.awt;

import java.lang.reflect.Field;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.EventObject;
import org.apache.poi.java.awt.event.ActionEvent;
import org.apache.poi.java.awt.event.AdjustmentEvent;
import org.apache.poi.java.awt.event.InputEvent;
import org.apache.poi.java.awt.event.ItemEvent;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.event.MouseEvent;
import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.java.awt.peer.LightweightPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AWTEvent extends EventObject {
    public static final long ACTION_EVENT_MASK = 128;
    public static final long ADJUSTMENT_EVENT_MASK = 256;
    public static final long COMPONENT_EVENT_MASK = 1;
    public static final long CONTAINER_EVENT_MASK = 2;
    public static final long FOCUS_EVENT_MASK = 4;
    public static final long HIERARCHY_BOUNDS_EVENT_MASK = 65536;
    public static final long HIERARCHY_EVENT_MASK = 32768;
    static final long INPUT_METHODS_ENABLED_MASK = 4096;
    public static final long INPUT_METHOD_EVENT_MASK = 2048;
    public static final long INVOCATION_EVENT_MASK = 16384;
    public static final long ITEM_EVENT_MASK = 512;
    public static final long KEY_EVENT_MASK = 8;
    public static final long MOUSE_EVENT_MASK = 16;
    public static final long MOUSE_MOTION_EVENT_MASK = 32;
    public static final long MOUSE_WHEEL_EVENT_MASK = 131072;
    public static final long PAINT_EVENT_MASK = 8192;
    public static final int RESERVED_ID_MAX = 1999;
    public static final long TEXT_EVENT_MASK = 1024;
    public static final long WINDOW_EVENT_MASK = 64;
    public static final long WINDOW_FOCUS_EVENT_MASK = 524288;
    public static final long WINDOW_STATE_EVENT_MASK = 262144;
    private static final long serialVersionUID = -1825314779160409405L;
    private volatile transient AccessControlContext acc;
    private byte[] bdata;
    protected boolean consumed;
    transient boolean focusManagerIsDispatching;

    /* JADX INFO: renamed from: id */
    protected int f10031id;
    transient boolean isPosted;
    private transient boolean isSystemGenerated;
    private static final PlatformLogger log = PlatformLogger.getLogger("org.apache.poi.java.awt.AWTEvent");
    private static Field inputEvent_CanAccessSystemClipboard_Field = null;

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setAWTEventAccessor(new AWTAccessor.AWTEventAccessor() { // from class: org.apache.poi.java.awt.AWTEvent.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.AWTEventAccessor
            public AccessControlContext getAccessControlContext(AWTEvent aWTEvent) {
                return aWTEvent.getAccessControlContext();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.AWTEventAccessor
            public byte[] getBData(AWTEvent aWTEvent) {
                return aWTEvent.bdata;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.AWTEventAccessor
            public boolean isSystemGenerated(AWTEvent aWTEvent) {
                return aWTEvent.isSystemGenerated;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.AWTEventAccessor
            public void setBData(AWTEvent aWTEvent, byte[] bArr) {
                aWTEvent.bdata = bArr;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.AWTEventAccessor
            public void setPosted(AWTEvent aWTEvent) {
                aWTEvent.isPosted = true;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.AWTEventAccessor
            public void setSystemGenerated(AWTEvent aWTEvent) {
                aWTEvent.isSystemGenerated = true;
            }
        });
    }

    public AWTEvent(Object obj, int i) {
        super(obj);
        this.consumed = false;
        this.acc = AccessController.getContext();
        this.focusManagerIsDispatching = false;
        this.f10031id = i;
        if (i == 601 || i == 701 || i == 900 || i == 1001) {
            this.consumed = true;
        }
    }

    private static synchronized Field get_InputEvent_CanAccessSystemClipboard() {
        try {
            if (inputEvent_CanAccessSystemClipboard_Field == null) {
                inputEvent_CanAccessSystemClipboard_Field = (Field) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.AWTEvent.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        PlatformLogger platformLogger;
                        String str;
                        try {
                            Field declaredField = InputEvent.class.getDeclaredField("canAccessSystemClipboard");
                            declaredField.setAccessible(true);
                            return declaredField;
                        } catch (NoSuchFieldException e) {
                            e = e;
                            if (!AWTEvent.log.isLoggable(500)) {
                                return null;
                            }
                            platformLogger = AWTEvent.log;
                            str = "AWTEvent.get_InputEvent_CanAccessSystemClipboard() got NoSuchFieldException ";
                            platformLogger.fine(str, e);
                            return null;
                        } catch (SecurityException e2) {
                            e = e2;
                            if (!AWTEvent.log.isLoggable(500)) {
                                return null;
                            }
                            platformLogger = AWTEvent.log;
                            str = "AWTEvent.get_InputEvent_CanAccessSystemClipboard() got SecurityException ";
                            platformLogger.fine(str, e);
                            return null;
                        }
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
        return inputEvent_CanAccessSystemClipboard_Field;
    }

    private static native void initIDs();

    private native void nativeSetSource(ComponentPeer componentPeer);

    public void consume() {
        int i = this.f10031id;
        if (i != 401 && i != 402 && i != 1100 && i != 1101) {
            switch (i) {
            }
            return;
        }
        this.consumed = true;
    }

    public Event convertToOld() {
        Object objValueOf;
        Object source = getSource();
        int i = this.f10031id;
        if (i != 100) {
            if (i != 201) {
                int i2 = 601;
                if (i == 601) {
                    AdjustmentEvent adjustmentEvent = (AdjustmentEvent) this;
                    int adjustmentType = adjustmentEvent.getAdjustmentType();
                    if (adjustmentType == 1) {
                        i2 = 602;
                    } else if (adjustmentType != 2) {
                        if (adjustmentType == 3) {
                            i2 = 603;
                        } else if (adjustmentType == 4) {
                            i2 = 604;
                        } else {
                            if (adjustmentType != 5) {
                                return null;
                            }
                            i2 = adjustmentEvent.getValueIsAdjusting() ? 605 : 607;
                        }
                    }
                    return new Event(source, i2, Integer.valueOf(adjustmentEvent.getValue()));
                }
                int i4 = 1001;
                if (i == 701) {
                    ItemEvent itemEvent = (ItemEvent) this;
                    if (!(source instanceof List)) {
                        if (!(source instanceof Choice)) {
                            objValueOf = Boolean.valueOf(itemEvent.getStateChange() == 1);
                        }
                        return new Event(source, i4, objValueOf);
                    }
                    i4 = itemEvent.getStateChange() == 1 ? 701 : 702;
                    objValueOf = itemEvent.getItem();
                    return new Event(source, i4, objValueOf);
                }
                if (i == 1001) {
                    ActionEvent actionEvent = (ActionEvent) this;
                    return new Event(source, 0L, i, 0, 0, 0, actionEvent.getModifiers(), source instanceof Button ? ((Button) source).getLabel() : source instanceof MenuItem ? ((MenuItem) source).getLabel() : actionEvent.getActionCommand());
                }
                if (i != 203 && i != 204) {
                    if (i == 401 || i == 402) {
                        KeyEvent keyEvent = (KeyEvent) this;
                        if (keyEvent.isActionKey()) {
                            i = this.f10031id == 401 ? 403 : 404;
                        }
                        int keyCode = keyEvent.getKeyCode();
                        if (keyCode == 16 || keyCode == 17 || keyCode == 18) {
                            return null;
                        }
                        return new Event(source, keyEvent.getWhen(), i, 0, 0, Event.getOldEventKey(keyEvent), keyEvent.getModifiers() & (-17));
                    }
                    if (i == 1004) {
                        return new Event(source, 1004, null);
                    }
                    if (i == 1005) {
                        return new Event(source, 1005, null);
                    }
                    switch (i) {
                        case 501:
                        case 502:
                        case 503:
                        case 504:
                        case 505:
                        case 506:
                            MouseEvent mouseEvent = (MouseEvent) this;
                            Event event = new Event(source, mouseEvent.getWhen(), i, mouseEvent.getX(), mouseEvent.getY(), 0, mouseEvent.getModifiers() & (-17));
                            event.clickCount = mouseEvent.getClickCount();
                            return event;
                    }
                }
            }
            return new Event(source, i, null);
        }
        if ((source instanceof Frame) || (source instanceof Dialog)) {
            Point location = ((Component) source).getLocation();
            return new Event(source, 0L, 205, location.f10092x, location.f10093y, 0, 0);
        }
        return null;
    }

    public void copyPrivateDataInto(AWTEvent aWTEvent) {
        aWTEvent.bdata = this.bdata;
        aWTEvent.isSystemGenerated = this.isSystemGenerated;
    }

    public final AccessControlContext getAccessControlContext() {
        if (this.acc != null) {
            return this.acc;
        }
        throw new SecurityException("AWTEvent is missing AccessControlContext");
    }

    public int getID() {
        return this.f10031id;
    }

    public boolean isConsumed() {
        return this.consumed;
    }

    public String paramString() {
        return "";
    }

    public void setSource(Object obj) {
        Component component;
        ComponentPeer componentPeer;
        if (((EventObject) this).source == obj) {
            return;
        }
        if (obj instanceof Component) {
            component = (Component) obj;
            while (component != null) {
                ComponentPeer componentPeer2 = component.peer;
                if (componentPeer2 == null || !(componentPeer2 instanceof LightweightPeer)) {
                    break;
                } else {
                    component = component.parent;
                }
            }
        } else {
            component = null;
        }
        synchronized (this) {
            try {
                ((EventObject) this).source = obj;
                if (component != null && (componentPeer = component.peer) != null) {
                    nativeSetSource(componentPeer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.EventObject
    public String toString() {
        Object obj = ((EventObject) this).source;
        Object name = obj instanceof Component ? ((Component) obj).getName() : obj instanceof MenuComponent ? ((MenuComponent) obj).getName() : null;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[");
        sb.append(paramString());
        sb.append("] on ");
        if (name == null) {
            name = ((EventObject) this).source;
        }
        sb.append(name);
        return sb.toString();
    }

    public AWTEvent(Event event) {
        this(event.target, event.f10046id);
    }

    public void dispatched() {
    }
}
