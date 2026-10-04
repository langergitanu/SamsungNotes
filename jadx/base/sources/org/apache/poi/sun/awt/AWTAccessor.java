package org.apache.poi.sun.awt;

import java.io.File;
import java.security.AccessControlContext;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.accessibility.AccessibleContext;
import org.apache.poi.java.awt.AWTEvent;
import org.apache.poi.java.awt.CheckboxMenuItem;
import org.apache.poi.java.awt.Color;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.Container;
import org.apache.poi.java.awt.Cursor;
import org.apache.poi.java.awt.DefaultKeyboardFocusManager;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.EventQueue;
import org.apache.poi.java.awt.FileDialog;
import org.apache.poi.java.awt.Font;
import org.apache.poi.java.awt.Frame;
import org.apache.poi.java.awt.GraphicsConfiguration;
import org.apache.poi.java.awt.KeyboardFocusManager;
import org.apache.poi.java.awt.Menu;
import org.apache.poi.java.awt.MenuBar;
import org.apache.poi.java.awt.MenuComponent;
import org.apache.poi.java.awt.MenuContainer;
import org.apache.poi.java.awt.MenuItem;
import org.apache.poi.java.awt.MenuShortcut;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.PopupMenu;
import org.apache.poi.java.awt.Rectangle;
import org.apache.poi.java.awt.ScrollPaneAdjustable;
import org.apache.poi.java.awt.Shape;
import org.apache.poi.java.awt.SystemColor;
import org.apache.poi.java.awt.SystemTray;
import org.apache.poi.java.awt.Toolkit;
import org.apache.poi.java.awt.TrayIcon;
import org.apache.poi.java.awt.Window;
import org.apache.poi.java.awt.event.InputEvent;
import org.apache.poi.java.awt.event.InvocationEvent;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.java.awt.event.MouseEvent;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.java.awt.peer.MenuComponentPeer;
import org.apache.poi.sun.awt.CausedFocusEvent;
import org.apache.poi.sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class AWTAccessor {
    private static AccessibleContextAccessor accessibleContextAccessor;
    private static AWTEventAccessor awtEventAccessor;
    private static CheckboxMenuItemAccessor checkboxMenuItemAccessor;
    private static ClientPropertyKeyAccessor clientPropertyKeyAccessor;
    private static ComponentAccessor componentAccessor;
    private static ContainerAccessor containerAccessor;
    private static CursorAccessor cursorAccessor;
    private static DefaultKeyboardFocusManagerAccessor defaultKeyboardFocusManagerAccessor;
    private static EventQueueAccessor eventQueueAccessor;
    private static FileDialogAccessor fileDialogAccessor;
    private static FrameAccessor frameAccessor;
    private static InputEventAccessor inputEventAccessor;
    private static InvocationEventAccessor invocationEventAccessor;
    private static KeyEventAccessor keyEventAccessor;
    private static KeyboardFocusManagerAccessor kfmAccessor;
    private static MenuAccessor menuAccessor;
    private static MenuBarAccessor menuBarAccessor;
    private static MenuComponentAccessor menuComponentAccessor;
    private static MenuItemAccessor menuItemAccessor;
    private static MouseEventAccessor mouseEventAccessor;
    private static PopupMenuAccessor popupMenuAccessor;
    private static ScrollPaneAdjustableAccessor scrollPaneAdjustableAccessor;
    private static SequencedEventAccessor sequencedEventAccessor;
    private static SystemColorAccessor systemColorAccessor;
    private static SystemTrayAccessor systemTrayAccessor;
    private static ToolkitAccessor toolkitAccessor;
    private static TrayIconAccessor trayIconAccessor;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static WindowAccessor windowAccessor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AWTEventAccessor {
        AccessControlContext getAccessControlContext(AWTEvent aWTEvent);

        byte[] getBData(AWTEvent aWTEvent);

        boolean isSystemGenerated(AWTEvent aWTEvent);

        void setBData(AWTEvent aWTEvent, byte[] bArr);

        void setPosted(AWTEvent aWTEvent);

        void setSystemGenerated(AWTEvent aWTEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface AccessibleContextAccessor {
        AppContext getAppContext(AccessibleContext accessibleContext);

        void setAppContext(AccessibleContext accessibleContext, AppContext appContext);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CheckboxMenuItemAccessor {
        boolean getState(CheckboxMenuItem checkboxMenuItem);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ClientPropertyKeyAccessor {
        Object getJComponent_TRANSFER_HANDLER();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentAccessor {
        boolean canBeFocusOwner(Component component);

        AccessControlContext getAccessControlContext(Component component);

        AppContext getAppContext(Component component);

        Color getBackground(Component component);

        boolean getBackgroundEraseDisabled(Component component);

        Rectangle getBounds(Component component);

        Cursor getCursor(Component component);

        Font getFont(Component component);

        Color getForeground(Component component);

        int getHeight(Component component);

        boolean getIgnoreRepaint(Component component);

        Point getLocation(Component component);

        Container getParent(Component component);

        ComponentPeer getPeer(Component component);

        int getWidth(Component component);

        int getX(Component component);

        int getY(Component component);

        boolean isDisplayable(Component component);

        boolean isEnabled(Component component);

        boolean isLightweight(Component component);

        boolean isVisible(Component component);

        void processEvent(Component component, AWTEvent aWTEvent);

        boolean requestFocus(Component component, CausedFocusEvent.Cause cause);

        void revalidateSynchronously(Component component);

        void setAppContext(Component component, AppContext appContext);

        void setBackground(Component component, Color color);

        void setBackgroundEraseDisabled(Component component, boolean z);

        void setGraphicsConfiguration(Component component, GraphicsConfiguration graphicsConfiguration);

        void setLocation(Component component, int i, int i2);

        void setMixingCutoutShape(Component component, Shape shape);

        void setParent(Component component, Container container);

        void setPeer(Component component, ComponentPeer componentPeer);

        void setRequestFocusController(RequestFocusController requestFocusController);

        void setSize(Component component, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ContainerAccessor {
        Component findComponentAt(Container container, int i, int i2, boolean z);

        void validateUnconditionally(Container container);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CursorAccessor {
        long getPData(Cursor cursor);

        int getType(Cursor cursor);

        void setPData(Cursor cursor, long j);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DefaultKeyboardFocusManagerAccessor {
        void consumeNextKeyTyped(DefaultKeyboardFocusManager defaultKeyboardFocusManager, KeyEvent keyEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EventQueueAccessor {
        Thread getDispatchThread(EventQueue eventQueue);

        long getMostRecentEventTime(EventQueue eventQueue);

        void invokeAndWait(Object obj, Runnable runnable);

        boolean isDispatchThreadImpl(EventQueue eventQueue);

        boolean noEvents(EventQueue eventQueue);

        void removeSourceEvents(EventQueue eventQueue, Object obj, boolean z);

        void setFwDispatcher(EventQueue eventQueue, FwDispatcher fwDispatcher);

        void wakeup(EventQueue eventQueue, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FileDialogAccessor {
        boolean isMultipleMode(FileDialog fileDialog);

        void setDirectory(FileDialog fileDialog, String str);

        void setFile(FileDialog fileDialog, String str);

        void setFiles(FileDialog fileDialog, File[] fileArr);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface FrameAccessor {
        int getExtendedState(Frame frame);

        Rectangle getMaximizedBounds(Frame frame);

        void setExtendedState(Frame frame, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InputEventAccessor {
        int[] getButtonDownMasks();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InvocationEventAccessor {
        void dispose(InvocationEvent invocationEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KeyEventAccessor {
        Component getOriginalSource(KeyEvent keyEvent);

        void setExtendedKeyCode(KeyEvent keyEvent, long j);

        void setPrimaryLevelUnicode(KeyEvent keyEvent, long j);

        void setRawCode(KeyEvent keyEvent, long j);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KeyboardFocusManagerAccessor {
        Container getCurrentFocusCycleRoot();

        KeyboardFocusManager getCurrentKeyboardFocusManager(AppContext appContext);

        boolean processSynchronousLightweightTransfer(Component component, Component component2, boolean z, boolean z2, long j);

        void removeLastFocusRequest(Component component);

        void setMostRecentFocusOwner(Window window, Component component);

        int shouldNativelyFocusHeavyweight(Component component, Component component2, boolean z, boolean z2, long j, CausedFocusEvent.Cause cause);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MenuAccessor {
        Vector getItems(Menu menu);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MenuBarAccessor {
        Menu getHelpMenu(MenuBar menuBar);

        Vector getMenus(MenuBar menuBar);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MenuComponentAccessor {
        AppContext getAppContext(MenuComponent menuComponent);

        Font getFont_NoClientCode(MenuComponent menuComponent);

        MenuContainer getParent(MenuComponent menuComponent);

        <T extends MenuComponentPeer> T getPeer(MenuComponent menuComponent);

        void setAppContext(MenuComponent menuComponent, AppContext appContext);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MenuItemAccessor {
        String getActionCommandImpl(MenuItem menuItem);

        String getLabel(MenuItem menuItem);

        MenuShortcut getShortcut(MenuItem menuItem);

        boolean isEnabled(MenuItem menuItem);

        boolean isItemEnabled(MenuItem menuItem);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MouseEventAccessor {
        boolean isCausedByTouchEvent(MouseEvent mouseEvent);

        void setCausedByTouchEvent(MouseEvent mouseEvent, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PopupMenuAccessor {
        boolean isTrayIconPopup(PopupMenu popupMenu);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ScrollPaneAdjustableAccessor {
        void setTypedValue(ScrollPaneAdjustable scrollPaneAdjustable, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SequencedEventAccessor {
        AWTEvent getNested(AWTEvent aWTEvent);

        boolean isSequencedEvent(AWTEvent aWTEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SystemColorAccessor {
        void updateSystemColors();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SystemTrayAccessor {
        void firePropertyChange(SystemTray systemTray, String str, Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ToolkitAccessor {
        void setPlatformResources(ResourceBundle resourceBundle);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrayIconAccessor {
        void addNotify(TrayIcon trayIcon);

        void removeNotify(TrayIcon trayIcon);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface WindowAccessor {
        Point2D calculateSecurityWarningPosition(Window window, double d, double d2, double d3, double d4);

        float getOpacity(Window window);

        Window[] getOwnedWindows(Window window);

        Dimension getSecurityWarningSize(Window window);

        Shape getShape(Window window);

        boolean isAutoRequestFocus(Window window);

        boolean isTrayIconWindow(Window window);

        void setLWRequestStatus(Window window, boolean z);

        void setOpacity(Window window, float f);

        void setOpaque(Window window, boolean z);

        void setSecurityWarningPosition(Window window, Point2D point2D, float f, float f4);

        void setSecurityWarningSize(Window window, int i, int i2);

        void setShape(Window window, Shape shape);

        void setTrayIconWindow(Window window, boolean z);

        void updateWindow(Window window);
    }

    private AWTAccessor() {
    }

    public static AWTEventAccessor getAWTEventAccessor() {
        if (awtEventAccessor == null) {
            unsafe.ensureClassInitialized(AWTEvent.class);
        }
        return awtEventAccessor;
    }

    public static AccessibleContextAccessor getAccessibleContextAccessor() {
        if (accessibleContextAccessor == null) {
            unsafe.ensureClassInitialized(AccessibleContext.class);
        }
        return accessibleContextAccessor;
    }

    public static CheckboxMenuItemAccessor getCheckboxMenuItemAccessor() {
        if (checkboxMenuItemAccessor == null) {
            unsafe.ensureClassInitialized(CheckboxMenuItemAccessor.class);
        }
        return checkboxMenuItemAccessor;
    }

    public static ClientPropertyKeyAccessor getClientPropertyKeyAccessor() {
        if (clientPropertyKeyAccessor == null) {
            unsafe.ensureClassInitialized(ClientPropertyKeyAccessor.class);
        }
        return clientPropertyKeyAccessor;
    }

    public static ComponentAccessor getComponentAccessor() {
        if (componentAccessor == null) {
            unsafe.ensureClassInitialized(Component.class);
        }
        return componentAccessor;
    }

    public static ContainerAccessor getContainerAccessor() {
        if (containerAccessor == null) {
            unsafe.ensureClassInitialized(Container.class);
        }
        return containerAccessor;
    }

    public static CursorAccessor getCursorAccessor() {
        if (cursorAccessor == null) {
            unsafe.ensureClassInitialized(CursorAccessor.class);
        }
        return cursorAccessor;
    }

    public static DefaultKeyboardFocusManagerAccessor getDefaultKeyboardFocusManagerAccessor() {
        if (defaultKeyboardFocusManagerAccessor == null) {
            unsafe.ensureClassInitialized(DefaultKeyboardFocusManagerAccessor.class);
        }
        return defaultKeyboardFocusManagerAccessor;
    }

    public static EventQueueAccessor getEventQueueAccessor() {
        if (eventQueueAccessor == null) {
            unsafe.ensureClassInitialized(EventQueue.class);
        }
        return eventQueueAccessor;
    }

    public static FileDialogAccessor getFileDialogAccessor() {
        if (fileDialogAccessor == null) {
            unsafe.ensureClassInitialized(FileDialog.class);
        }
        return fileDialogAccessor;
    }

    public static FrameAccessor getFrameAccessor() {
        if (frameAccessor == null) {
            unsafe.ensureClassInitialized(Frame.class);
        }
        return frameAccessor;
    }

    public static InputEventAccessor getInputEventAccessor() {
        if (inputEventAccessor == null) {
            unsafe.ensureClassInitialized(InputEvent.class);
        }
        return inputEventAccessor;
    }

    public static InvocationEventAccessor getInvocationEventAccessor() {
        return invocationEventAccessor;
    }

    public static KeyEventAccessor getKeyEventAccessor() {
        if (keyEventAccessor == null) {
            unsafe.ensureClassInitialized(KeyEventAccessor.class);
        }
        return keyEventAccessor;
    }

    public static KeyboardFocusManagerAccessor getKeyboardFocusManagerAccessor() {
        if (kfmAccessor == null) {
            unsafe.ensureClassInitialized(KeyboardFocusManager.class);
        }
        return kfmAccessor;
    }

    public static MenuAccessor getMenuAccessor() {
        if (menuAccessor == null) {
            unsafe.ensureClassInitialized(MenuAccessor.class);
        }
        return menuAccessor;
    }

    public static MenuBarAccessor getMenuBarAccessor() {
        if (menuBarAccessor == null) {
            unsafe.ensureClassInitialized(MenuBarAccessor.class);
        }
        return menuBarAccessor;
    }

    public static MenuComponentAccessor getMenuComponentAccessor() {
        if (menuComponentAccessor == null) {
            unsafe.ensureClassInitialized(MenuComponent.class);
        }
        return menuComponentAccessor;
    }

    public static MenuItemAccessor getMenuItemAccessor() {
        if (menuItemAccessor == null) {
            unsafe.ensureClassInitialized(MenuItemAccessor.class);
        }
        return menuItemAccessor;
    }

    public static MouseEventAccessor getMouseEventAccessor() {
        if (mouseEventAccessor == null) {
            unsafe.ensureClassInitialized(MouseEvent.class);
        }
        return mouseEventAccessor;
    }

    public static PopupMenuAccessor getPopupMenuAccessor() {
        if (popupMenuAccessor == null) {
            unsafe.ensureClassInitialized(PopupMenu.class);
        }
        return popupMenuAccessor;
    }

    public static ScrollPaneAdjustableAccessor getScrollPaneAdjustableAccessor() {
        if (scrollPaneAdjustableAccessor == null) {
            unsafe.ensureClassInitialized(ScrollPaneAdjustable.class);
        }
        return scrollPaneAdjustableAccessor;
    }

    public static SequencedEventAccessor getSequencedEventAccessor() {
        return sequencedEventAccessor;
    }

    public static SystemColorAccessor getSystemColorAccessor() {
        if (systemColorAccessor == null) {
            unsafe.ensureClassInitialized(SystemColor.class);
        }
        return systemColorAccessor;
    }

    public static SystemTrayAccessor getSystemTrayAccessor() {
        if (systemTrayAccessor == null) {
            unsafe.ensureClassInitialized(SystemTrayAccessor.class);
        }
        return systemTrayAccessor;
    }

    public static ToolkitAccessor getToolkitAccessor() {
        if (toolkitAccessor == null) {
            unsafe.ensureClassInitialized(Toolkit.class);
        }
        return toolkitAccessor;
    }

    public static TrayIconAccessor getTrayIconAccessor() {
        if (trayIconAccessor == null) {
            unsafe.ensureClassInitialized(TrayIconAccessor.class);
        }
        return trayIconAccessor;
    }

    public static WindowAccessor getWindowAccessor() {
        if (windowAccessor == null) {
            unsafe.ensureClassInitialized(Window.class);
        }
        return windowAccessor;
    }

    public static void setAWTEventAccessor(AWTEventAccessor aWTEventAccessor) {
        awtEventAccessor = aWTEventAccessor;
    }

    public static void setAccessibleContextAccessor(AccessibleContextAccessor accessibleContextAccessor2) {
        accessibleContextAccessor = accessibleContextAccessor2;
    }

    public static void setCheckboxMenuItemAccessor(CheckboxMenuItemAccessor checkboxMenuItemAccessor2) {
        checkboxMenuItemAccessor = checkboxMenuItemAccessor2;
    }

    public static void setClientPropertyKeyAccessor(ClientPropertyKeyAccessor clientPropertyKeyAccessor2) {
        clientPropertyKeyAccessor = clientPropertyKeyAccessor2;
    }

    public static void setComponentAccessor(ComponentAccessor componentAccessor2) {
        componentAccessor = componentAccessor2;
    }

    public static void setContainerAccessor(ContainerAccessor containerAccessor2) {
        containerAccessor = containerAccessor2;
    }

    public static void setCursorAccessor(CursorAccessor cursorAccessor2) {
        cursorAccessor = cursorAccessor2;
    }

    public static void setDefaultKeyboardFocusManagerAccessor(DefaultKeyboardFocusManagerAccessor defaultKeyboardFocusManagerAccessor2) {
        defaultKeyboardFocusManagerAccessor = defaultKeyboardFocusManagerAccessor2;
    }

    public static void setEventQueueAccessor(EventQueueAccessor eventQueueAccessor2) {
        eventQueueAccessor = eventQueueAccessor2;
    }

    public static void setFileDialogAccessor(FileDialogAccessor fileDialogAccessor2) {
        fileDialogAccessor = fileDialogAccessor2;
    }

    public static void setFrameAccessor(FrameAccessor frameAccessor2) {
        frameAccessor = frameAccessor2;
    }

    public static void setInputEventAccessor(InputEventAccessor inputEventAccessor2) {
        inputEventAccessor = inputEventAccessor2;
    }

    public static void setInvocationEventAccessor(InvocationEventAccessor invocationEventAccessor2) {
        invocationEventAccessor = invocationEventAccessor2;
    }

    public static void setKeyEventAccessor(KeyEventAccessor keyEventAccessor2) {
        keyEventAccessor = keyEventAccessor2;
    }

    public static void setKeyboardFocusManagerAccessor(KeyboardFocusManagerAccessor keyboardFocusManagerAccessor) {
        kfmAccessor = keyboardFocusManagerAccessor;
    }

    public static void setMenuAccessor(MenuAccessor menuAccessor2) {
        menuAccessor = menuAccessor2;
    }

    public static void setMenuBarAccessor(MenuBarAccessor menuBarAccessor2) {
        menuBarAccessor = menuBarAccessor2;
    }

    public static void setMenuComponentAccessor(MenuComponentAccessor menuComponentAccessor2) {
        menuComponentAccessor = menuComponentAccessor2;
    }

    public static void setMenuItemAccessor(MenuItemAccessor menuItemAccessor2) {
        menuItemAccessor = menuItemAccessor2;
    }

    public static void setMouseEventAccessor(MouseEventAccessor mouseEventAccessor2) {
        mouseEventAccessor = mouseEventAccessor2;
    }

    public static void setPopupMenuAccessor(PopupMenuAccessor popupMenuAccessor2) {
        popupMenuAccessor = popupMenuAccessor2;
    }

    public static void setScrollPaneAdjustableAccessor(ScrollPaneAdjustableAccessor scrollPaneAdjustableAccessor2) {
        scrollPaneAdjustableAccessor = scrollPaneAdjustableAccessor2;
    }

    public static void setSequencedEventAccessor(SequencedEventAccessor sequencedEventAccessor2) {
        sequencedEventAccessor = sequencedEventAccessor2;
    }

    public static void setSystemColorAccessor(SystemColorAccessor systemColorAccessor2) {
        systemColorAccessor = systemColorAccessor2;
    }

    public static void setSystemTrayAccessor(SystemTrayAccessor systemTrayAccessor2) {
        systemTrayAccessor = systemTrayAccessor2;
    }

    public static void setToolkitAccessor(ToolkitAccessor toolkitAccessor2) {
        toolkitAccessor = toolkitAccessor2;
    }

    public static void setTrayIconAccessor(TrayIconAccessor trayIconAccessor2) {
        trayIconAccessor = trayIconAccessor2;
    }

    public static void setWindowAccessor(WindowAccessor windowAccessor2) {
        windowAccessor = windowAccessor2;
    }
}
