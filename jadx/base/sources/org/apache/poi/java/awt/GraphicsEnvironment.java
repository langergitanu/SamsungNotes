package org.apache.poi.java.awt;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import org.apache.commons.lang3.SystemProperties;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.sun.java2d.SunGraphicsEnvironment;
import sun.font.FontManagerFactory;

/* JADX INFO: loaded from: classes10.dex */
public abstract class GraphicsEnvironment {
    private static Boolean defaultHeadless;
    private static Boolean headless;
    private static GraphicsEnvironment localEnv;

    public static void checkHeadless() {
        if (isHeadless()) {
            throw new HeadlessException();
        }
    }

    private static GraphicsEnvironment createGE() {
        throw null;
    }

    public static String getHeadlessMessage() {
        if (headless == null) {
            getHeadlessProperty();
        }
        if (defaultHeadless != Boolean.TRUE) {
            return null;
        }
        return "\nNo X11 DISPLAY variable was set, but this program performed an operation which requires it.";
    }

    private static boolean getHeadlessProperty() {
        if (headless == null) {
            AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.GraphicsEnvironment.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    Boolean bool;
                    Boolean boolValueOf;
                    String property = System.getProperty("org.apache.poi.java.awt.headless");
                    if (property == null) {
                        if (System.getProperty("javaplugin.version") != null) {
                            boolValueOf = Boolean.FALSE;
                        } else {
                            String property2 = System.getProperty(SystemProperties.OS_NAME);
                            if (property2.contains("OS X") && "org.apache.poi.sun.awt.HToolkit".equals(System.getProperty(SystemProperties.AWT_TOOLKIT))) {
                                boolValueOf = Boolean.TRUE;
                            } else {
                                boolValueOf = Boolean.valueOf(("Linux".equals(property2) || "SunOS".equals(property2) || "FreeBSD".equals(property2) || "NetBSD".equals(property2) || "OpenBSD".equals(property2)) && System.getenv("DISPLAY") == null);
                            }
                        }
                        bool = GraphicsEnvironment.defaultHeadless = boolValueOf;
                    } else {
                        bool = property.equals("true") ? Boolean.TRUE : Boolean.FALSE;
                    }
                    Boolean unused = GraphicsEnvironment.headless = bool;
                    return null;
                }
            });
        }
        return headless.booleanValue();
    }

    public static synchronized GraphicsEnvironment getLocalGraphicsEnvironment() {
        try {
            if (localEnv == null) {
                localEnv = createGE();
            }
        } catch (Throwable th) {
            throw th;
        }
        return localEnv;
    }

    public static boolean isHeadless() {
        return getHeadlessProperty();
    }

    public abstract Graphics2D createGraphics(BufferedImage bufferedImage);

    public abstract Font[] getAllFonts();

    public abstract String[] getAvailableFontFamilyNames();

    public abstract String[] getAvailableFontFamilyNames(Locale locale);

    public Point getCenterPoint() {
        Rectangle usableBounds = SunGraphicsEnvironment.getUsableBounds(getDefaultScreenDevice());
        return new Point((usableBounds.width / 2) + usableBounds.f10094x, (usableBounds.height / 2) + usableBounds.f10095y);
    }

    public abstract GraphicsDevice getDefaultScreenDevice();

    public Rectangle getMaximumWindowBounds() {
        return SunGraphicsEnvironment.getUsableBounds(getDefaultScreenDevice());
    }

    public abstract GraphicsDevice[] getScreenDevices();

    public boolean isHeadlessInstance() {
        return getHeadlessProperty();
    }

    public void preferLocaleFonts() {
        FontManagerFactory.getInstance().preferLocaleFonts();
    }

    public void preferProportionalFonts() {
        FontManagerFactory.getInstance().preferProportionalFonts();
    }

    public boolean registerFont(Font font) {
        if (font != null) {
            return FontManagerFactory.getInstance().registerFont(font);
        }
        throw new NullPointerException("font cannot be null.");
    }
}
