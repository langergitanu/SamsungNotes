package org.apache.poi.java.awt;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.apache.poi.java.awt.event.AWTEventListener;
import org.apache.poi.java.awt.event.MouseEvent;
import org.apache.poi.java.awt.event.MouseWheelEvent;
import org.apache.poi.sun.awt.dnd.SunDropTargetEvent;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
class LightweightDispatcher implements Serializable, AWTEventListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int LWD_MOUSE_DRAGGED_OVER = 1500;
    private static final long MOUSE_MASK = 131120;
    private static final long PROXY_EVENT_MASK = 131132;
    private static final PlatformLogger eventLog = PlatformLogger.getLogger("org.apache.poi.java.awt.event.LightweightDispatcher");
    private static final long serialVersionUID = 5184291520170872969L;
    private Component focus;
    private Container nativeContainer;
    private Cursor nativeCursor;
    private transient Component targetLastEntered;
    private transient boolean isMouseInNativeContainer = false;
    private transient Component mouseEventTarget = null;
    private long eventMask = 0;

    /* JADX INFO: renamed from: org.apache.poi.java.awt.LightweightDispatcher$3 */
    public class RunnableC140223 implements Runnable {
        final /* synthetic */ MouseEvent val$mouseEvent;
        final /* synthetic */ Point val$ptSrcOrigin;

        public RunnableC140223(MouseEvent mouseEvent, Point point) {
            this.val$mouseEvent = mouseEvent;
            this.val$ptSrcOrigin = point;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LightweightDispatcher.this.nativeContainer.isShowing()) {
                Point locationOnScreen = LightweightDispatcher.this.nativeContainer.getLocationOnScreen();
                MouseEvent mouseEvent = this.val$mouseEvent;
                Point point = this.val$ptSrcOrigin;
                mouseEvent.translatePoint(point.f10092x - locationOnScreen.f10092x, point.f10093y - locationOnScreen.f10093y);
                LightweightDispatcher.this.trackMouseEnterExit(LightweightDispatcher.this.nativeContainer.getMouseEventTarget(this.val$mouseEvent.getX(), this.val$mouseEvent.getY(), true), this.val$mouseEvent);
            }
        }
    }

    public LightweightDispatcher(Container container) {
        this.nativeContainer = container;
    }

    private boolean isMouseGrab(MouseEvent mouseEvent) {
        int modifiersEx = mouseEvent.getModifiersEx();
        if (mouseEvent.getID() == 501 || mouseEvent.getID() == 502) {
            int button = mouseEvent.getButton();
            if (button == 1) {
                modifiersEx ^= 1024;
            } else if (button == 2) {
                modifiersEx ^= 2048;
            } else if (button == 3) {
                modifiersEx ^= 4096;
            }
        }
        return (modifiersEx & 7168) != 0;
    }

    private boolean processDropTargetEvent(SunDropTargetEvent sunDropTargetEvent) {
        int id = sunDropTargetEvent.getID();
        int x = sunDropTargetEvent.getX();
        int y2 = sunDropTargetEvent.getY();
        if (!this.nativeContainer.contains(x, y2)) {
            Dimension size = this.nativeContainer.getSize();
            int i = size.width;
            if (i <= x) {
                x = i - 1;
            } else if (x < 0) {
                x = 0;
            }
            int i2 = size.height;
            if (i2 <= y2) {
                y2 = i2 - 1;
            } else if (y2 < 0) {
                y2 = 0;
            }
        }
        Component dropTargetEventTarget = this.nativeContainer.getDropTargetEventTarget(x, y2, true);
        trackMouseEnterExit(dropTargetEventTarget, sunDropTargetEvent);
        if (dropTargetEventTarget != this.nativeContainer && dropTargetEventTarget != null && id != 504 && id != 505) {
            retargetMouseEvent(dropTargetEventTarget, id, sunDropTargetEvent);
            sunDropTargetEvent.consume();
        }
        return sunDropTargetEvent.isConsumed();
    }

    private boolean processMouseEvent(MouseEvent mouseEvent) {
        int id = mouseEvent.getID();
        Component mouseEventTarget = this.nativeContainer.getMouseEventTarget(mouseEvent.getX(), mouseEvent.getY(), true);
        trackMouseEnterExit(mouseEventTarget, mouseEvent);
        if (!isMouseGrab(mouseEvent) && id != 500) {
            this.mouseEventTarget = mouseEventTarget != this.nativeContainer ? mouseEventTarget : null;
        }
        Component component = this.mouseEventTarget;
        if (component != null) {
            switch (id) {
                case 500:
                    if (mouseEventTarget == component) {
                        retargetMouseEvent(mouseEventTarget, id, mouseEvent);
                    }
                    break;
                case 501:
                case 502:
                case 503:
                    retargetMouseEvent(component, id, mouseEvent);
                    break;
                case 506:
                    if (isMouseGrab(mouseEvent)) {
                        mouseEventTarget = this.mouseEventTarget;
                        retargetMouseEvent(mouseEventTarget, id, mouseEvent);
                    }
                    break;
                case 507:
                    PlatformLogger platformLogger = eventLog;
                    if (platformLogger.isLoggable(300) && mouseEventTarget != null) {
                        platformLogger.finest("retargeting mouse wheel to " + mouseEventTarget.getName() + SQLKeyword.COMMA + mouseEventTarget.getClass());
                    }
                    retargetMouseEvent(mouseEventTarget, id, mouseEvent);
                    break;
            }
            if (id != 507) {
                mouseEvent.consume();
            }
        }
        return mouseEvent.isConsumed();
    }

    private void startListeningForOtherDrags() {
        AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.LightweightDispatcher.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                LightweightDispatcher.this.nativeContainer.getToolkit().addAWTEventListener(LightweightDispatcher.this, 48L);
                return null;
            }
        });
    }

    private void stopListeningForOtherDrags() {
        AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.LightweightDispatcher.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                LightweightDispatcher.this.nativeContainer.getToolkit().removeAWTEventListener(LightweightDispatcher.this);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackMouseEnterExit(Component component, MouseEvent mouseEvent) {
        int id = mouseEvent.getID();
        if ((mouseEvent instanceof SunDropTargetEvent) && id == 504 && this.isMouseInNativeContainer) {
            this.targetLastEntered = null;
        } else if (id != 505 && id != 506 && id != 1500 && !this.isMouseInNativeContainer) {
            this.isMouseInNativeContainer = true;
            startListeningForOtherDrags();
        } else if (id == 505) {
            this.isMouseInNativeContainer = false;
            stopListeningForOtherDrags();
        }
        if (!this.isMouseInNativeContainer) {
            component = null;
        }
        Component component2 = this.targetLastEntered;
        if (component2 == component) {
            return;
        }
        if (component2 != null) {
            retargetMouseEvent(component2, 505, mouseEvent);
        }
        if (id == 505) {
            mouseEvent.consume();
        }
        if (component != null) {
            retargetMouseEvent(component, 504, mouseEvent);
        }
        if (id == 504) {
            mouseEvent.consume();
        }
        this.targetLastEntered = component;
    }

    public boolean dispatchEvent(AWTEvent aWTEvent) {
        if (aWTEvent.getID() == 503) {
            this.nativeContainer.updateCursorImmediately();
        }
        return false;
    }

    public void dispose() {
        stopListeningForOtherDrags();
        this.mouseEventTarget = null;
    }

    public void enableEvents(long j) {
        this.eventMask = j | this.eventMask;
    }

    public void retargetMouseEvent(Component component, int i, MouseEvent mouseEvent) {
        MouseEvent mouseEvent2;
        SunDropTargetEvent mouseEvent3;
        Component component2;
        int i2;
        if (component != null) {
            int x = mouseEvent.getX();
            int y2 = mouseEvent.getY();
            Component parent = component;
            while (parent != null && parent != this.nativeContainer) {
                x -= parent.f10034x;
                y2 -= parent.f10035y;
                parent = parent.getParent();
            }
            if (parent != null) {
                if (mouseEvent instanceof SunDropTargetEvent) {
                    component2 = component;
                    i2 = i;
                    mouseEvent3 = new SunDropTargetEvent(component2, i2, x, y2, ((SunDropTargetEvent) mouseEvent).getDispatcher());
                    mouseEvent2 = mouseEvent;
                } else if (i == 507) {
                    int i4 = x;
                    MouseWheelEvent mouseWheelEvent = (MouseWheelEvent) mouseEvent;
                    component2 = component;
                    mouseEvent2 = mouseEvent;
                    mouseEvent3 = new MouseWheelEvent(component2, i, mouseEvent.getWhen(), mouseEvent.getModifiers() | mouseEvent.getModifiersEx(), i4, y2, mouseEvent.getXOnScreen(), mouseEvent.getYOnScreen(), mouseEvent.getClickCount(), mouseEvent.isPopupTrigger(), mouseWheelEvent.getScrollType(), mouseWheelEvent.getScrollAmount(), mouseWheelEvent.getWheelRotation(), mouseWheelEvent.getPreciseWheelRotation());
                    i2 = i;
                } else {
                    mouseEvent2 = mouseEvent;
                    component2 = component;
                    i2 = i;
                    mouseEvent3 = new MouseEvent(component2, i2, mouseEvent2.getWhen(), mouseEvent2.getModifiersEx() | mouseEvent2.getModifiers(), x, y2, mouseEvent2.getXOnScreen(), mouseEvent2.getYOnScreen(), mouseEvent2.getClickCount(), mouseEvent2.isPopupTrigger(), mouseEvent2.getButton());
                }
                mouseEvent2.copyPrivateDataInto(mouseEvent3);
                Container container = this.nativeContainer;
                if (component2 == container) {
                    ((Container) component2).dispatchEventToSelf(mouseEvent3);
                } else {
                    Component component3 = container.modalComp;
                    if (component3 == null || ((Container) component3).isAncestorOf(component2)) {
                        component2.dispatchEvent(mouseEvent3);
                    } else {
                        mouseEvent2.consume();
                    }
                }
                if (i2 == 507 && mouseEvent3.isConsumed()) {
                    mouseEvent2.consume();
                }
            }
        }
    }

    public void eventDispatched(AWTEvent aWTEvent) {
    }
}
