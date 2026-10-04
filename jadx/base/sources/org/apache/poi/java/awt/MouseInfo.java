package org.apache.poi.java.awt;

import org.apache.poi.sun.security.util.SecurityConstants;

/* JADX INFO: loaded from: classes10.dex */
public class MouseInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private MouseInfo() {
    }

    private static boolean areScreenDevicesIndependent(GraphicsDevice[] graphicsDeviceArr) {
        for (GraphicsDevice graphicsDevice : graphicsDeviceArr) {
            Rectangle bounds = graphicsDevice.getDefaultConfiguration().getBounds();
            if (bounds.f10094x != 0 || bounds.f10095y != 0) {
                return false;
            }
        }
        return true;
    }

    public static int getNumberOfButtons() {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        Object desktopProperty = Toolkit.getDefaultToolkit().getDesktopProperty("awt.mouse.numButtons");
        if (desktopProperty instanceof Integer) {
            return ((Integer) desktopProperty).intValue();
        }
        return 0;
    }

    public static PointerInfo getPointerInfo() {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityConstants.AWT.WATCH_MOUSE_PERMISSION);
        }
        Point point = new Point(0, 0);
        int iFillPointWithCoords = Toolkit.getDefaultToolkit().getMouseInfoPeer().fillPointWithCoords(point);
        GraphicsDevice[] screenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        if (areScreenDevicesIndependent(screenDevices)) {
            return new PointerInfo(screenDevices[iFillPointWithCoords], point);
        }
        PointerInfo pointerInfo = null;
        for (int i = 0; i < screenDevices.length; i++) {
            if (screenDevices[i].getDefaultConfiguration().getBounds().contains(point)) {
                pointerInfo = new PointerInfo(screenDevices[i], point);
            }
        }
        return pointerInfo;
    }
}
