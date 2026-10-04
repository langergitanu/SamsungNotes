package org.apache.poi.java.awt;

import java.io.File;
import java.io.FilePermission;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.poi.java.awt.peer.DesktopPeer;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.DesktopBrowse;
import org.apache.poi.sun.awt.SunToolkit;

/* JADX INFO: loaded from: classes10.dex */
public class Desktop {
    private DesktopPeer peer = Toolkit.getDefaultToolkit().createDesktopPeer(this);

    public enum Action {
        OPEN,
        EDIT,
        PRINT,
        MAIL,
        BROWSE
    }

    private Desktop() {
    }

    private void checkAWTPermission() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new AWTPermission("showWindowWithoutWarningBanner"));
        }
    }

    private void checkActionSupport(Action action) {
        if (isSupported(action)) {
            return;
        }
        throw new UnsupportedOperationException("The " + action.name() + " action is not supported on the current platform!");
    }

    private void checkExec() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new FilePermission("<<ALL FILES>>", "execute"));
        }
    }

    private static void checkFileValidation(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (file.exists()) {
            file.canRead();
            return;
        }
        throw new IllegalArgumentException("The file: " + file.getPath() + " doesn't exist.");
    }

    public static synchronized Desktop getDesktop() {
        Desktop desktop;
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        if (!isDesktopSupported()) {
            throw new UnsupportedOperationException("Desktop API is not supported on the current platform");
        }
        AppContext appContext = AppContext.getAppContext();
        desktop = (Desktop) appContext.get(Desktop.class);
        if (desktop == null) {
            desktop = new Desktop();
            appContext.put(Desktop.class, desktop);
        }
        return desktop;
    }

    public static boolean isDesktopSupported() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        if (defaultToolkit instanceof SunToolkit) {
            return ((SunToolkit) defaultToolkit).isDesktopSupported();
        }
        return false;
    }

    public void browse(URI uri) {
        try {
            checkAWTPermission();
            checkExec();
            e = null;
        } catch (SecurityException e) {
            e = e;
        }
        checkActionSupport(Action.BROWSE);
        uri.getClass();
        if (e == null) {
            this.peer.browse(uri);
            return;
        }
        try {
            URL url = uri.toURL();
            DesktopBrowse desktopBrowse = DesktopBrowse.getInstance();
            if (desktopBrowse == null) {
                throw e;
            }
            desktopBrowse.browse(url);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException("Unable to convert URI to URL", e2);
        }
    }

    public void edit(File file) {
        checkAWTPermission();
        checkExec();
        checkActionSupport(Action.EDIT);
        file.canWrite();
        checkFileValidation(file);
        this.peer.edit(file);
    }

    public boolean isSupported(Action action) {
        return this.peer.isSupported(action);
    }

    public void mail() {
        checkAWTPermission();
        checkExec();
        checkActionSupport(Action.MAIL);
        try {
            this.peer.mail(new URI("mailto:?"));
        } catch (URISyntaxException unused) {
        }
    }

    public void open(File file) {
        checkAWTPermission();
        checkExec();
        checkActionSupport(Action.OPEN);
        checkFileValidation(file);
        this.peer.open(file);
    }

    public void print(File file) {
        checkExec();
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPrintJobAccess();
        }
        checkActionSupport(Action.PRINT);
        checkFileValidation(file);
        this.peer.print(file);
    }

    public void mail(URI uri) {
        checkAWTPermission();
        checkExec();
        checkActionSupport(Action.MAIL);
        uri.getClass();
        if (!"mailto".equalsIgnoreCase(uri.getScheme())) {
            throw new IllegalArgumentException("URI scheme is not \"mailto\"");
        }
        this.peer.mail(uri);
    }
}
