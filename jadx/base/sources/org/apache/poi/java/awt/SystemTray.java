package org.apache.poi.java.awt;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Vector;
import org.apache.poi.java.awt.peer.SystemTrayPeer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.SunToolkit;
import org.apache.poi.sun.security.util.SecurityConstants;

/* JADX INFO: loaded from: classes10.dex */
public class SystemTray {
    private static final TrayIcon[] EMPTY_TRAY_ARRAY = new TrayIcon[0];
    private static SystemTray systemTray;
    private int currentIconID = 0;
    private transient SystemTrayPeer peer;

    static {
        AWTAccessor.setSystemTrayAccessor(new AWTAccessor.SystemTrayAccessor() { // from class: org.apache.poi.java.awt.SystemTray.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.SystemTrayAccessor
            public void firePropertyChange(SystemTray systemTray2, String str, Object obj, Object obj2) {
                systemTray2.firePropertyChange(str, obj, obj2);
            }
        });
    }

    private SystemTray() {
        addNotify();
    }

    public static void checkSystemTrayAllowed() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.ACCESS_SYSTEM_TRAY_PERMISSION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void firePropertyChange(String str, Object obj, Object obj2) {
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            getCurrentChangeSupport().firePropertyChange(str, obj, obj2);
        }
    }

    private synchronized PropertyChangeSupport getCurrentChangeSupport() {
        PropertyChangeSupport propertyChangeSupport;
        propertyChangeSupport = (PropertyChangeSupport) AppContext.getAppContext().get(SystemTray.class);
        if (propertyChangeSupport == null) {
            propertyChangeSupport = new PropertyChangeSupport(this);
            AppContext.getAppContext().put(SystemTray.class, propertyChangeSupport);
        }
        return propertyChangeSupport;
    }

    public static SystemTray getSystemTray() {
        checkSystemTrayAllowed();
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        initializeSystemTrayIfNeeded();
        if (isSupported()) {
            return systemTray;
        }
        throw new UnsupportedOperationException("The system tray is not supported on the current platform.");
    }

    private static void initializeSystemTrayIfNeeded() {
        synchronized (SystemTray.class) {
            try {
                if (systemTray == null) {
                    systemTray = new SystemTray();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isSupported() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        if (!(defaultToolkit instanceof SunToolkit)) {
            return false;
        }
        initializeSystemTrayIfNeeded();
        return ((SunToolkit) defaultToolkit).isTraySupported();
    }

    public void add(TrayIcon trayIcon) throws AWTException {
        TrayIcon[] trayIcons;
        Vector vector;
        TrayIcon[] trayIcons2;
        if (trayIcon == null) {
            throw new NullPointerException("adding null TrayIcon");
        }
        synchronized (this) {
            try {
                trayIcons = systemTray.getTrayIcons();
                vector = (Vector) AppContext.getAppContext().get(TrayIcon.class);
                if (vector == null) {
                    vector = new Vector(3);
                    AppContext.getAppContext().put(TrayIcon.class, vector);
                } else if (vector.contains(trayIcon)) {
                    throw new IllegalArgumentException("adding TrayIcon that is already added");
                }
                vector.add(trayIcon);
                trayIcons2 = systemTray.getTrayIcons();
                int i = this.currentIconID + 1;
                this.currentIconID = i;
                trayIcon.setID(i);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            trayIcon.addNotify();
            firePropertyChange("trayIcons", trayIcons, trayIcons2);
        } catch (AWTException e) {
            vector.remove(trayIcon);
            throw e;
        }
    }

    public synchronized void addNotify() {
        if (this.peer == null && (Toolkit.getDefaultToolkit() instanceof SunToolkit)) {
            this.peer = ((SunToolkit) Toolkit.getDefaultToolkit()).createSystemTray(this);
        }
    }

    public synchronized void addPropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener == null) {
            return;
        }
        getCurrentChangeSupport().addPropertyChangeListener(str, propertyChangeListener);
    }

    public synchronized PropertyChangeListener[] getPropertyChangeListeners(String str) {
        return getCurrentChangeSupport().getPropertyChangeListeners(str);
    }

    public Dimension getTrayIconSize() {
        return this.peer.getTrayIconSize();
    }

    public TrayIcon[] getTrayIcons() {
        Vector vector = (Vector) AppContext.getAppContext().get(TrayIcon.class);
        return vector != null ? (TrayIcon[]) vector.toArray(new TrayIcon[vector.size()]) : EMPTY_TRAY_ARRAY;
    }

    public void remove(TrayIcon trayIcon) {
        if (trayIcon == null) {
            return;
        }
        synchronized (this) {
            TrayIcon[] trayIcons = systemTray.getTrayIcons();
            Vector vector = (Vector) AppContext.getAppContext().get(TrayIcon.class);
            if (vector != null && vector.remove(trayIcon)) {
                trayIcon.removeNotify();
                firePropertyChange("trayIcons", trayIcons, systemTray.getTrayIcons());
            }
        }
    }

    public synchronized void removePropertyChangeListener(String str, PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener == null) {
            return;
        }
        getCurrentChangeSupport().removePropertyChangeListener(str, propertyChangeListener);
    }
}
