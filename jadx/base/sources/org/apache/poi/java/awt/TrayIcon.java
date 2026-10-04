package org.apache.poi.java.awt;

import java.security.AccessControlContext;
import java.security.AccessController;
import org.apache.poi.java.awt.event.ActionEvent;
import org.apache.poi.java.awt.event.ActionListener;
import org.apache.poi.java.awt.event.MouseEvent;
import org.apache.poi.java.awt.event.MouseListener;
import org.apache.poi.java.awt.event.MouseMotionListener;
import org.apache.poi.java.awt.peer.TrayIconPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.SunToolkit;

/* JADX INFO: loaded from: classes10.dex */
public class TrayIcon {
    private final AccessControlContext acc;
    private String actionCommand;
    transient ActionListener actionListener;
    private boolean autosize;

    /* JADX INFO: renamed from: id */
    private int f10103id;
    private Image image;
    transient MouseListener mouseListener;
    transient MouseMotionListener mouseMotionListener;
    private transient TrayIconPeer peer;
    private PopupMenu popup;
    private String tooltip;

    public enum MessageType {
        ERROR,
        WARNING,
        INFO,
        NONE
    }

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setTrayIconAccessor(new AWTAccessor.TrayIconAccessor() { // from class: org.apache.poi.java.awt.TrayIcon.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.TrayIconAccessor
            public void addNotify(TrayIcon trayIcon) {
                trayIcon.addNotify();
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.TrayIconAccessor
            public void removeNotify(TrayIcon trayIcon) {
                trayIcon.removeNotify();
            }
        });
    }

    private TrayIcon() {
        this.acc = AccessController.getContext();
        SystemTray.checkSystemTrayAllowed();
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        if (!SystemTray.isSupported()) {
            throw new UnsupportedOperationException();
        }
        SunToolkit.insertTargetMapping(this, AppContext.getAppContext());
    }

    private static native void initIDs();

    public synchronized void addActionListener(ActionListener actionListener) {
        if (actionListener == null) {
            return;
        }
        this.actionListener = AWTEventMulticaster.add(this.actionListener, actionListener);
    }

    public synchronized void addMouseListener(MouseListener mouseListener) {
        if (mouseListener == null) {
            return;
        }
        this.mouseListener = AWTEventMulticaster.add(this.mouseListener, mouseListener);
    }

    public synchronized void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        if (mouseMotionListener == null) {
            return;
        }
        this.mouseMotionListener = AWTEventMulticaster.add(this.mouseMotionListener, mouseMotionListener);
    }

    public void addNotify() {
        synchronized (this) {
            try {
                if (this.peer == null && (Toolkit.getDefaultToolkit() instanceof SunToolkit)) {
                    this.peer = ((SunToolkit) Toolkit.getDefaultToolkit()).createTrayIcon(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.peer.setToolTip(this.tooltip);
    }

    public void dispatchEvent(AWTEvent aWTEvent) {
        EventQueue.setCurrentEventAndMostRecentTime(aWTEvent);
        Toolkit.getDefaultToolkit().notifyAWTEventListeners(aWTEvent);
        processEvent(aWTEvent);
    }

    public void displayMessage(String str, String str2, MessageType messageType) {
        if (str == null && str2 == null) {
            throw new NullPointerException("displaying the message with both caption and text being null");
        }
        TrayIconPeer trayIconPeer = this.peer;
        if (trayIconPeer != null) {
            trayIconPeer.displayMessage(str, str2, messageType.name());
        }
    }

    public final AccessControlContext getAccessControlContext() {
        AccessControlContext accessControlContext = this.acc;
        if (accessControlContext != null) {
            return accessControlContext;
        }
        throw new SecurityException("TrayIcon is missing AccessControlContext");
    }

    public String getActionCommand() {
        return this.actionCommand;
    }

    public synchronized ActionListener[] getActionListeners() {
        return AWTEventMulticaster.getListeners(this.actionListener, ActionListener.class);
    }

    public int getID() {
        return this.f10103id;
    }

    public Image getImage() {
        return this.image;
    }

    public synchronized MouseListener[] getMouseListeners() {
        return AWTEventMulticaster.getListeners(this.mouseListener, MouseListener.class);
    }

    public synchronized MouseMotionListener[] getMouseMotionListeners() {
        return AWTEventMulticaster.getListeners(this.mouseMotionListener, MouseMotionListener.class);
    }

    public PopupMenu getPopupMenu() {
        return this.popup;
    }

    public Dimension getSize() {
        return SystemTray.getSystemTray().getTrayIconSize();
    }

    public String getToolTip() {
        return this.tooltip;
    }

    public boolean isImageAutoSize() {
        return this.autosize;
    }

    public void processActionEvent(ActionEvent actionEvent) {
        ActionListener actionListener = this.actionListener;
        if (actionListener != null) {
            actionListener.actionPerformed(actionEvent);
        }
    }

    public void processMouseEvent(MouseEvent mouseEvent) {
        MouseListener mouseListener = this.mouseListener;
        if (mouseListener != null) {
            switch (mouseEvent.getID()) {
                case 500:
                    mouseListener.mouseClicked(mouseEvent);
                    break;
                case 501:
                    mouseListener.mousePressed(mouseEvent);
                    break;
                case 502:
                    mouseListener.mouseReleased(mouseEvent);
                    break;
            }
        }
    }

    public void processMouseMotionEvent(MouseEvent mouseEvent) {
        MouseMotionListener mouseMotionListener = this.mouseMotionListener;
        if (mouseMotionListener == null || mouseEvent.getID() != 503) {
            return;
        }
        mouseMotionListener.mouseMoved(mouseEvent);
    }

    public synchronized void removeActionListener(ActionListener actionListener) {
        if (actionListener == null) {
            return;
        }
        this.actionListener = AWTEventMulticaster.remove(this.actionListener, actionListener);
    }

    public synchronized void removeMouseListener(MouseListener mouseListener) {
        if (mouseListener == null) {
            return;
        }
        this.mouseListener = AWTEventMulticaster.remove(this.mouseListener, mouseListener);
    }

    public synchronized void removeMouseMotionListener(MouseMotionListener mouseMotionListener) {
        if (mouseMotionListener == null) {
            return;
        }
        this.mouseMotionListener = AWTEventMulticaster.remove(this.mouseMotionListener, mouseMotionListener);
    }

    public void removeNotify() {
        TrayIconPeer trayIconPeer;
        synchronized (this) {
            trayIconPeer = this.peer;
            this.peer = null;
        }
        if (trayIconPeer != null) {
            trayIconPeer.dispose();
        }
    }

    public void setActionCommand(String str) {
        this.actionCommand = str;
    }

    public void setID(int i) {
        this.f10103id = i;
    }

    public void setImage(Image image) {
        if (image == null) {
            throw new NullPointerException("setting null Image");
        }
        this.image = image;
        TrayIconPeer trayIconPeer = this.peer;
        if (trayIconPeer != null) {
            trayIconPeer.updateImage();
        }
    }

    public void setImageAutoSize(boolean z) {
        this.autosize = z;
        TrayIconPeer trayIconPeer = this.peer;
        if (trayIconPeer != null) {
            trayIconPeer.updateImage();
        }
    }

    public void setPopupMenu(PopupMenu popupMenu) {
        if (popupMenu == this.popup) {
            return;
        }
        synchronized (TrayIcon.class) {
            if (popupMenu != null) {
                try {
                    if (popupMenu.isTrayIconPopup) {
                        throw new IllegalArgumentException("the PopupMenu is already set for another TrayIcon");
                    }
                    popupMenu.isTrayIconPopup = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            PopupMenu popupMenu2 = this.popup;
            if (popupMenu2 != null) {
                popupMenu2.isTrayIconPopup = false;
            }
            this.popup = popupMenu;
        }
    }

    public void setToolTip(String str) {
        this.tooltip = str;
        TrayIconPeer trayIconPeer = this.peer;
        if (trayIconPeer != null) {
            trayIconPeer.setToolTip(str);
        }
    }

    public TrayIcon(Image image) {
        this();
        if (image == null) {
            throw new IllegalArgumentException("creating TrayIcon with null Image");
        }
        setImage(image);
    }

    public TrayIcon(Image image, String str) {
        this(image);
        setToolTip(str);
    }

    public TrayIcon(Image image, String str, PopupMenu popupMenu) {
        this(image, str);
        setPopupMenu(popupMenu);
    }

    public void processEvent(AWTEvent aWTEvent) {
    }
}
