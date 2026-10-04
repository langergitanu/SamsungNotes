package org.apache.poi.java.awt;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.EventListener;
import org.apache.poi.java.awt.event.ActionEvent;
import org.apache.poi.java.awt.event.ActionListener;
import org.apache.poi.java.awt.event.AdjustmentEvent;
import org.apache.poi.java.awt.event.AdjustmentListener;
import org.apache.poi.java.awt.event.ComponentEvent;
import org.apache.poi.java.awt.event.ComponentListener;
import org.apache.poi.java.awt.event.ContainerEvent;
import org.apache.poi.java.awt.event.ContainerListener;
import org.apache.poi.java.awt.event.FocusEvent;
import org.apache.poi.java.awt.event.FocusListener;
import org.apache.poi.java.awt.event.HierarchyBoundsListener;
import org.apache.poi.java.awt.event.HierarchyEvent;
import org.apache.poi.java.awt.event.HierarchyListener;
import org.apache.poi.java.awt.event.InputMethodEvent;
import org.apache.poi.java.awt.event.InputMethodListener;
import org.apache.poi.java.awt.event.ItemEvent;
import org.apache.poi.java.awt.event.ItemListener;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.event.KeyListener;
import org.apache.poi.java.awt.event.MouseEvent;
import org.apache.poi.java.awt.event.MouseListener;
import org.apache.poi.java.awt.event.MouseMotionListener;
import org.apache.poi.java.awt.event.MouseWheelEvent;
import org.apache.poi.java.awt.event.MouseWheelListener;
import org.apache.poi.java.awt.event.TextEvent;
import org.apache.poi.java.awt.event.TextListener;
import org.apache.poi.java.awt.event.WindowEvent;
import org.apache.poi.java.awt.event.WindowFocusListener;
import org.apache.poi.java.awt.event.WindowListener;
import org.apache.poi.java.awt.event.WindowStateListener;

/* JADX INFO: loaded from: classes10.dex */
public class AWTEventMulticaster implements ComponentListener, ContainerListener, FocusListener, KeyListener, MouseListener, MouseMotionListener, WindowListener, WindowFocusListener, WindowStateListener, ActionListener, ItemListener, AdjustmentListener, TextListener, InputMethodListener, HierarchyListener, HierarchyBoundsListener, MouseWheelListener {

    /* JADX INFO: renamed from: a */
    protected final EventListener f10032a;

    /* JADX INFO: renamed from: b */
    protected final EventListener f10033b;

    public AWTEventMulticaster(EventListener eventListener, EventListener eventListener2) {
        this.f10032a = eventListener;
        this.f10033b = eventListener2;
    }

    public static ActionListener add(ActionListener actionListener, ActionListener actionListener2) {
        return addInternal(actionListener, actionListener2);
    }

    public static EventListener addInternal(EventListener eventListener, EventListener eventListener2) {
        return eventListener == null ? eventListener2 : eventListener2 == null ? eventListener : new AWTEventMulticaster(eventListener, eventListener2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int getListenerCount(EventListener eventListener, Class cls) {
        if (!(eventListener instanceof AWTEventMulticaster)) {
            return cls.isInstance(eventListener) ? 1 : 0;
        }
        AWTEventMulticaster aWTEventMulticaster = (AWTEventMulticaster) eventListener;
        return getListenerCount(aWTEventMulticaster.f10032a, cls) + getListenerCount(aWTEventMulticaster.f10033b, cls);
    }

    public static <T extends EventListener> T[] getListeners(EventListener eventListener, Class<T> cls) {
        if (cls == null) {
            throw new NullPointerException("Listener type should not be null");
        }
        T[] tArr = (T[]) ((EventListener[]) Array.newInstance((Class<?>) cls, getListenerCount(eventListener, cls)));
        populateListenerArray(tArr, eventListener, 0);
        return tArr;
    }

    private static int populateListenerArray(EventListener[] eventListenerArr, EventListener eventListener, int i) {
        if (eventListener instanceof AWTEventMulticaster) {
            AWTEventMulticaster aWTEventMulticaster = (AWTEventMulticaster) eventListener;
            return populateListenerArray(eventListenerArr, aWTEventMulticaster.f10033b, populateListenerArray(eventListenerArr, aWTEventMulticaster.f10032a, i));
        }
        if (!eventListenerArr.getClass().getComponentType().isInstance(eventListener)) {
            return i;
        }
        eventListenerArr[i] = eventListener;
        return i + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static EventListener removeInternal(EventListener eventListener, EventListener eventListener2) {
        if (eventListener == eventListener2 || eventListener == 0) {
            return null;
        }
        return eventListener instanceof AWTEventMulticaster ? ((AWTEventMulticaster) eventListener).remove(eventListener2) : eventListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void save(ObjectOutputStream objectOutputStream, String str, EventListener eventListener) throws IOException {
        if (eventListener == 0) {
            return;
        }
        if (eventListener instanceof AWTEventMulticaster) {
            ((AWTEventMulticaster) eventListener).saveInternal(objectOutputStream, str);
        } else if (eventListener instanceof Serializable) {
            objectOutputStream.writeObject(str);
            objectOutputStream.writeObject(eventListener);
        }
    }

    public void actionPerformed(ActionEvent actionEvent) {
        this.f10032a.actionPerformed(actionEvent);
        this.f10033b.actionPerformed(actionEvent);
    }

    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        this.f10032a.adjustmentValueChanged(adjustmentEvent);
        this.f10033b.adjustmentValueChanged(adjustmentEvent);
    }

    public void ancestorMoved(HierarchyEvent hierarchyEvent) {
        this.f10032a.ancestorMoved(hierarchyEvent);
        this.f10033b.ancestorMoved(hierarchyEvent);
    }

    public void ancestorResized(HierarchyEvent hierarchyEvent) {
        this.f10032a.ancestorResized(hierarchyEvent);
        this.f10033b.ancestorResized(hierarchyEvent);
    }

    public void caretPositionChanged(InputMethodEvent inputMethodEvent) {
        this.f10032a.caretPositionChanged(inputMethodEvent);
        this.f10033b.caretPositionChanged(inputMethodEvent);
    }

    public void componentAdded(ContainerEvent containerEvent) {
        this.f10032a.componentAdded(containerEvent);
        this.f10033b.componentAdded(containerEvent);
    }

    public void componentHidden(ComponentEvent componentEvent) {
        this.f10032a.componentHidden(componentEvent);
        this.f10033b.componentHidden(componentEvent);
    }

    public void componentMoved(ComponentEvent componentEvent) {
        this.f10032a.componentMoved(componentEvent);
        this.f10033b.componentMoved(componentEvent);
    }

    public void componentRemoved(ContainerEvent containerEvent) {
        this.f10032a.componentRemoved(containerEvent);
        this.f10033b.componentRemoved(containerEvent);
    }

    public void componentResized(ComponentEvent componentEvent) {
        this.f10032a.componentResized(componentEvent);
        this.f10033b.componentResized(componentEvent);
    }

    public void componentShown(ComponentEvent componentEvent) {
        this.f10032a.componentShown(componentEvent);
        this.f10033b.componentShown(componentEvent);
    }

    public void focusGained(FocusEvent focusEvent) {
        this.f10032a.focusGained(focusEvent);
        this.f10033b.focusGained(focusEvent);
    }

    public void focusLost(FocusEvent focusEvent) {
        this.f10032a.focusLost(focusEvent);
        this.f10033b.focusLost(focusEvent);
    }

    public void hierarchyChanged(HierarchyEvent hierarchyEvent) {
        this.f10032a.hierarchyChanged(hierarchyEvent);
        this.f10033b.hierarchyChanged(hierarchyEvent);
    }

    public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {
        this.f10032a.inputMethodTextChanged(inputMethodEvent);
        this.f10033b.inputMethodTextChanged(inputMethodEvent);
    }

    public void itemStateChanged(ItemEvent itemEvent) {
        this.f10032a.itemStateChanged(itemEvent);
        this.f10033b.itemStateChanged(itemEvent);
    }

    public void keyPressed(KeyEvent keyEvent) {
        this.f10032a.keyPressed(keyEvent);
        this.f10033b.keyPressed(keyEvent);
    }

    public void keyReleased(KeyEvent keyEvent) {
        this.f10032a.keyReleased(keyEvent);
        this.f10033b.keyReleased(keyEvent);
    }

    public void keyTyped(KeyEvent keyEvent) {
        this.f10032a.keyTyped(keyEvent);
        this.f10033b.keyTyped(keyEvent);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        this.f10032a.mouseClicked(mouseEvent);
        this.f10033b.mouseClicked(mouseEvent);
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        this.f10032a.mouseDragged(mouseEvent);
        this.f10033b.mouseDragged(mouseEvent);
    }

    public void mouseEntered(MouseEvent mouseEvent) {
        this.f10032a.mouseEntered(mouseEvent);
        this.f10033b.mouseEntered(mouseEvent);
    }

    public void mouseExited(MouseEvent mouseEvent) {
        this.f10032a.mouseExited(mouseEvent);
        this.f10033b.mouseExited(mouseEvent);
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        this.f10032a.mouseMoved(mouseEvent);
        this.f10033b.mouseMoved(mouseEvent);
    }

    public void mousePressed(MouseEvent mouseEvent) {
        this.f10032a.mousePressed(mouseEvent);
        this.f10033b.mousePressed(mouseEvent);
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        this.f10032a.mouseReleased(mouseEvent);
        this.f10033b.mouseReleased(mouseEvent);
    }

    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        this.f10032a.mouseWheelMoved(mouseWheelEvent);
        this.f10033b.mouseWheelMoved(mouseWheelEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventListener remove(EventListener eventListener) {
        EventListener eventListener2 = this.f10032a;
        if (eventListener == eventListener2) {
            return this.f10033b;
        }
        if (eventListener == this.f10033b) {
            return eventListener2;
        }
        EventListener eventListenerRemoveInternal = removeInternal(eventListener2, eventListener);
        EventListener eventListenerRemoveInternal2 = removeInternal(this.f10033b, eventListener);
        return (eventListenerRemoveInternal == this.f10032a && eventListenerRemoveInternal2 == this.f10033b) ? this : addInternal(eventListenerRemoveInternal, eventListenerRemoveInternal2);
    }

    public void saveInternal(ObjectOutputStream objectOutputStream, String str) throws IOException {
        Object obj = this.f10032a;
        if (obj instanceof AWTEventMulticaster) {
            ((AWTEventMulticaster) obj).saveInternal(objectOutputStream, str);
        } else if (obj instanceof Serializable) {
            objectOutputStream.writeObject(str);
            objectOutputStream.writeObject(this.f10032a);
        }
        Object obj2 = this.f10033b;
        if (obj2 instanceof AWTEventMulticaster) {
            ((AWTEventMulticaster) obj2).saveInternal(objectOutputStream, str);
        } else if (obj2 instanceof Serializable) {
            objectOutputStream.writeObject(str);
            objectOutputStream.writeObject(this.f10033b);
        }
    }

    public void textValueChanged(TextEvent textEvent) {
        this.f10032a.textValueChanged(textEvent);
        this.f10033b.textValueChanged(textEvent);
    }

    public void windowActivated(WindowEvent windowEvent) {
        this.f10032a.windowActivated(windowEvent);
        this.f10033b.windowActivated(windowEvent);
    }

    public void windowClosed(WindowEvent windowEvent) {
        this.f10032a.windowClosed(windowEvent);
        this.f10033b.windowClosed(windowEvent);
    }

    public void windowClosing(WindowEvent windowEvent) {
        this.f10032a.windowClosing(windowEvent);
        this.f10033b.windowClosing(windowEvent);
    }

    public void windowDeactivated(WindowEvent windowEvent) {
        this.f10032a.windowDeactivated(windowEvent);
        this.f10033b.windowDeactivated(windowEvent);
    }

    public void windowDeiconified(WindowEvent windowEvent) {
        this.f10032a.windowDeiconified(windowEvent);
        this.f10033b.windowDeiconified(windowEvent);
    }

    public void windowGainedFocus(WindowEvent windowEvent) {
        this.f10032a.windowGainedFocus(windowEvent);
        this.f10033b.windowGainedFocus(windowEvent);
    }

    public void windowIconified(WindowEvent windowEvent) {
        this.f10032a.windowIconified(windowEvent);
        this.f10033b.windowIconified(windowEvent);
    }

    public void windowLostFocus(WindowEvent windowEvent) {
        this.f10032a.windowLostFocus(windowEvent);
        this.f10033b.windowLostFocus(windowEvent);
    }

    public void windowOpened(WindowEvent windowEvent) {
        this.f10032a.windowOpened(windowEvent);
        this.f10033b.windowOpened(windowEvent);
    }

    public void windowStateChanged(WindowEvent windowEvent) {
        this.f10032a.windowStateChanged(windowEvent);
        this.f10033b.windowStateChanged(windowEvent);
    }

    public static AdjustmentListener add(AdjustmentListener adjustmentListener, AdjustmentListener adjustmentListener2) {
        return addInternal(adjustmentListener, adjustmentListener2);
    }

    public static ActionListener remove(ActionListener actionListener, ActionListener actionListener2) {
        return removeInternal(actionListener, actionListener2);
    }

    public static ComponentListener add(ComponentListener componentListener, ComponentListener componentListener2) {
        return addInternal(componentListener, componentListener2);
    }

    public static AdjustmentListener remove(AdjustmentListener adjustmentListener, AdjustmentListener adjustmentListener2) {
        return removeInternal(adjustmentListener, adjustmentListener2);
    }

    public static ContainerListener add(ContainerListener containerListener, ContainerListener containerListener2) {
        return addInternal(containerListener, containerListener2);
    }

    public static ComponentListener remove(ComponentListener componentListener, ComponentListener componentListener2) {
        return removeInternal(componentListener, componentListener2);
    }

    public static FocusListener add(FocusListener focusListener, FocusListener focusListener2) {
        return addInternal(focusListener, focusListener2);
    }

    public static ContainerListener remove(ContainerListener containerListener, ContainerListener containerListener2) {
        return removeInternal(containerListener, containerListener2);
    }

    public static HierarchyBoundsListener add(HierarchyBoundsListener hierarchyBoundsListener, HierarchyBoundsListener hierarchyBoundsListener2) {
        return addInternal(hierarchyBoundsListener, hierarchyBoundsListener2);
    }

    public static FocusListener remove(FocusListener focusListener, FocusListener focusListener2) {
        return removeInternal(focusListener, focusListener2);
    }

    public static HierarchyListener add(HierarchyListener hierarchyListener, HierarchyListener hierarchyListener2) {
        return addInternal(hierarchyListener, hierarchyListener2);
    }

    public static HierarchyBoundsListener remove(HierarchyBoundsListener hierarchyBoundsListener, HierarchyBoundsListener hierarchyBoundsListener2) {
        return removeInternal(hierarchyBoundsListener, hierarchyBoundsListener2);
    }

    public static InputMethodListener add(InputMethodListener inputMethodListener, InputMethodListener inputMethodListener2) {
        return addInternal(inputMethodListener, inputMethodListener2);
    }

    public static HierarchyListener remove(HierarchyListener hierarchyListener, HierarchyListener hierarchyListener2) {
        return removeInternal(hierarchyListener, hierarchyListener2);
    }

    public static ItemListener add(ItemListener itemListener, ItemListener itemListener2) {
        return addInternal(itemListener, itemListener2);
    }

    public static InputMethodListener remove(InputMethodListener inputMethodListener, InputMethodListener inputMethodListener2) {
        return removeInternal(inputMethodListener, inputMethodListener2);
    }

    public static KeyListener add(KeyListener keyListener, KeyListener keyListener2) {
        return addInternal(keyListener, keyListener2);
    }

    public static ItemListener remove(ItemListener itemListener, ItemListener itemListener2) {
        return removeInternal(itemListener, itemListener2);
    }

    public static MouseListener add(MouseListener mouseListener, MouseListener mouseListener2) {
        return addInternal(mouseListener, mouseListener2);
    }

    public static KeyListener remove(KeyListener keyListener, KeyListener keyListener2) {
        return removeInternal(keyListener, keyListener2);
    }

    public static MouseMotionListener add(MouseMotionListener mouseMotionListener, MouseMotionListener mouseMotionListener2) {
        return addInternal(mouseMotionListener, mouseMotionListener2);
    }

    public static MouseListener remove(MouseListener mouseListener, MouseListener mouseListener2) {
        return removeInternal(mouseListener, mouseListener2);
    }

    public static MouseWheelListener add(MouseWheelListener mouseWheelListener, MouseWheelListener mouseWheelListener2) {
        return addInternal(mouseWheelListener, mouseWheelListener2);
    }

    public static MouseMotionListener remove(MouseMotionListener mouseMotionListener, MouseMotionListener mouseMotionListener2) {
        return removeInternal(mouseMotionListener, mouseMotionListener2);
    }

    public static TextListener add(TextListener textListener, TextListener textListener2) {
        return addInternal(textListener, textListener2);
    }

    public static MouseWheelListener remove(MouseWheelListener mouseWheelListener, MouseWheelListener mouseWheelListener2) {
        return removeInternal(mouseWheelListener, mouseWheelListener2);
    }

    public static WindowFocusListener add(WindowFocusListener windowFocusListener, WindowFocusListener windowFocusListener2) {
        return addInternal(windowFocusListener, windowFocusListener2);
    }

    public static TextListener remove(TextListener textListener, TextListener textListener2) {
        return removeInternal(textListener, textListener2);
    }

    public static WindowListener add(WindowListener windowListener, WindowListener windowListener2) {
        return addInternal(windowListener, windowListener2);
    }

    public static WindowFocusListener remove(WindowFocusListener windowFocusListener, WindowFocusListener windowFocusListener2) {
        return removeInternal(windowFocusListener, windowFocusListener2);
    }

    public static WindowStateListener add(WindowStateListener windowStateListener, WindowStateListener windowStateListener2) {
        return addInternal(windowStateListener, windowStateListener2);
    }

    public static WindowListener remove(WindowListener windowListener, WindowListener windowListener2) {
        return removeInternal(windowListener, windowListener2);
    }

    public static WindowStateListener remove(WindowStateListener windowStateListener, WindowStateListener windowStateListener2) {
        return removeInternal(windowStateListener, windowStateListener2);
    }
}
