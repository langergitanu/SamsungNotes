package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import java.beans.ConstructorProperties;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import org.apache.poi.sun.awt.AWTAccessor;
import org.apache.poi.sun.java2d.Disposer;
import org.apache.poi.sun.java2d.DisposerRecord;
import org.apache.poi.sun.security.action.GetPropertyAction;
import org.apache.poi.sun.util.logging.PlatformLogger;

/* JADX INFO: loaded from: classes10.dex */
public class Cursor implements Serializable {
    public static final int CROSSHAIR_CURSOR = 1;
    public static final int CUSTOM_CURSOR = -1;
    private static final String CursorDotPrefix = "Cursor.";
    public static final int DEFAULT_CURSOR = 0;
    private static final String DotFileSuffix = ".File";
    private static final String DotHotspotSuffix = ".HotSpot";
    private static final String DotNameSuffix = ".Name";
    public static final int E_RESIZE_CURSOR = 11;
    public static final int HAND_CURSOR = 12;
    public static final int MOVE_CURSOR = 13;
    public static final int NE_RESIZE_CURSOR = 7;
    public static final int NW_RESIZE_CURSOR = 6;
    public static final int N_RESIZE_CURSOR = 8;
    public static final int SE_RESIZE_CURSOR = 5;
    public static final int SW_RESIZE_CURSOR = 4;
    public static final int S_RESIZE_CURSOR = 9;
    public static final int TEXT_CURSOR = 2;
    public static final int WAIT_CURSOR = 3;
    public static final int W_RESIZE_CURSOR = 10;
    private static final PlatformLogger log;
    private static final long serialVersionUID = 8028237497568985504L;
    private static final String systemCustomCursorDirPrefix;
    private static Properties systemCustomCursorProperties;
    private static final String systemCustomCursorPropertiesFile;
    private transient Object anchor;
    transient CursorDisposer disposer;
    protected String name;
    private transient long pData;
    int type;

    @Deprecated
    protected static Cursor[] predefined = new Cursor[14];
    private static final Cursor[] predefinedPrivate = new Cursor[14];
    static final String[][] cursorProperties = {new String[]{"AWT.DefaultCursor", "Default Cursor"}, new String[]{"AWT.CrosshairCursor", "Crosshair Cursor"}, new String[]{"AWT.TextCursor", "Text Cursor"}, new String[]{"AWT.WaitCursor", "Wait Cursor"}, new String[]{"AWT.SWResizeCursor", "Southwest Resize Cursor"}, new String[]{"AWT.SEResizeCursor", "Southeast Resize Cursor"}, new String[]{"AWT.NWResizeCursor", "Northwest Resize Cursor"}, new String[]{"AWT.NEResizeCursor", "Northeast Resize Cursor"}, new String[]{"AWT.NResizeCursor", "North Resize Cursor"}, new String[]{"AWT.SResizeCursor", "South Resize Cursor"}, new String[]{"AWT.WResizeCursor", "West Resize Cursor"}, new String[]{"AWT.EResizeCursor", "East Resize Cursor"}, new String[]{"AWT.HandCursor", "Hand Cursor"}, new String[]{"AWT.MoveCursor", "Move Cursor"}};
    private static final Hashtable systemCustomCursors = new Hashtable(1);

    public static class CursorDisposer implements DisposerRecord {
        volatile long pData;

        public CursorDisposer(long j) {
            this.pData = j;
        }

        @Override // org.apache.poi.sun.java2d.DisposerRecord
        public void dispose() {
            if (this.pData != 0) {
                Cursor.finalizeImpl(this.pData);
            }
        }
    }

    static {
        String strInitCursorDir = initCursorDir();
        systemCustomCursorDirPrefix = strInitCursorDir;
        systemCustomCursorPropertiesFile = AbstractC0541b.m756B(strInitCursorDir, "cursors.properties");
        systemCustomCursorProperties = null;
        log = PlatformLogger.getLogger("org.apache.poi.java.awt.Cursor");
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setCursorAccessor(new AWTAccessor.CursorAccessor() { // from class: org.apache.poi.java.awt.Cursor.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.CursorAccessor
            public long getPData(Cursor cursor) {
                return cursor.pData;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.CursorAccessor
            public int getType(Cursor cursor) {
                return cursor.type;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.CursorAccessor
            public void setPData(Cursor cursor, long j) {
                cursor.pData = j;
            }
        });
    }

    @ConstructorProperties({"type"})
    public Cursor(int i) {
        this.type = 0;
        this.anchor = new Object();
        if (i < 0 || i > 13) {
            throw new IllegalArgumentException("illegal cursor type");
        }
        this.type = i;
        String[] strArr = cursorProperties[i];
        this.name = Toolkit.getProperty(strArr[0], strArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void finalizeImpl(long j);

    public static Cursor getDefaultCursor() {
        return getPredefinedCursor(0);
    }

    public static Cursor getPredefinedCursor(int i) {
        if (i < 0 || i > 13) {
            throw new IllegalArgumentException("illegal cursor type");
        }
        Cursor[] cursorArr = predefinedPrivate;
        Cursor cursor = cursorArr[i];
        if (cursor == null) {
            cursor = new Cursor(i);
            cursorArr[i] = cursor;
        }
        Cursor[] cursorArr2 = predefined;
        if (cursorArr2[i] == null) {
            cursorArr2[i] = cursor;
        }
        return cursor;
    }

    public static Cursor getSystemCustomCursor(String str) throws AWTException {
        GraphicsEnvironment.checkHeadless();
        Hashtable hashtable = systemCustomCursors;
        Cursor cursor = (Cursor) hashtable.get(str);
        if (cursor != null) {
            return cursor;
        }
        synchronized (hashtable) {
            try {
                if (systemCustomCursorProperties == null) {
                    loadSystemCustomCursorProperties();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        String strM772n = AbstractC0541b.m772n(CursorDotPrefix, str);
        String strM756B = AbstractC0541b.m756B(strM772n, DotFileSuffix);
        if (!systemCustomCursorProperties.containsKey(strM756B)) {
            PlatformLogger platformLogger = log;
            if (!platformLogger.isLoggable(400)) {
                return null;
            }
            platformLogger.finer(AbstractC0541b.m773o("Cursor.getSystemCustomCursor(", str, ") returned null"));
            return null;
        }
        final String property = systemCustomCursorProperties.getProperty(strM756B);
        final String property2 = systemCustomCursorProperties.getProperty(strM772n + DotNameSuffix);
        if (property2 == null) {
            property2 = str;
        }
        String property3 = systemCustomCursorProperties.getProperty(strM772n + DotHotspotSuffix);
        if (property3 == null) {
            throw new AWTException(AbstractC0541b.m772n("no hotspot property defined for cursor: ", str));
        }
        StringTokenizer stringTokenizer = new StringTokenizer(property3, ",");
        if (stringTokenizer.countTokens() != 2) {
            throw new AWTException(AbstractC0541b.m772n("failed to parse hotspot property for cursor: ", str));
        }
        try {
            final int i = Integer.parseInt(stringTokenizer.nextToken());
            final int i2 = Integer.parseInt(stringTokenizer.nextToken());
            try {
                Cursor cursor2 = (Cursor) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: org.apache.poi.java.awt.Cursor.2
                    @Override // java.security.PrivilegedExceptionAction
                    public Object run() {
                        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
                        return defaultToolkit.createCustomCursor(defaultToolkit.getImage(Cursor.systemCustomCursorDirPrefix + property), new Point(i, i2), property2);
                    }
                });
                if (cursor2 != null) {
                    hashtable.put(str, cursor2);
                    return cursor2;
                }
                PlatformLogger platformLogger2 = log;
                if (platformLogger2.isLoggable(400)) {
                    platformLogger2.finer(AbstractC0541b.m773o("Cursor.getSystemCustomCursor(", str, ") returned null"));
                }
                return cursor2;
            } catch (Exception e) {
                throw new AWTException("Exception: " + e.getClass() + " " + e.getMessage() + " occurred while creating cursor " + str);
            }
        } catch (NumberFormatException unused) {
            throw new AWTException(AbstractC0541b.m772n("failed to parse hotspot property for cursor: ", str));
        }
    }

    private static String initCursorDir() {
        StringBuilder sbM1324q = AbstractC1974b.m1324q((String) AccessController.doPrivileged(new GetPropertyAction("java.home")));
        String str = File.separator;
        AbstractC2821a.m2207B(sbM1324q, str, "lib", str, "images");
        return AbstractC2322a.m1626p(sbM1324q, str, "cursors", str);
    }

    private static native void initIDs();

    private static void loadSystemCustomCursorProperties() {
        synchronized (systemCustomCursors) {
            try {
                systemCustomCursorProperties = new Properties();
                try {
                    AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: org.apache.poi.java.awt.Cursor.3
                        @Override // java.security.PrivilegedExceptionAction
                        public Object run() throws Throwable {
                            FileInputStream fileInputStream;
                            Throwable th;
                            try {
                                fileInputStream = new FileInputStream(Cursor.systemCustomCursorPropertiesFile);
                                try {
                                    Cursor.systemCustomCursorProperties.load(fileInputStream);
                                    fileInputStream.close();
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                fileInputStream = null;
                                th = th3;
                            }
                        }
                    });
                } catch (Exception e) {
                    systemCustomCursorProperties = null;
                    throw new AWTException("Exception: " + e.getClass() + " " + e.getMessage() + " occurred while loading: " + systemCustomCursorPropertiesFile);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void setPData(long j) {
        this.pData = j;
        if (GraphicsEnvironment.isHeadless()) {
            return;
        }
        CursorDisposer cursorDisposer = this.disposer;
        if (cursorDisposer != null) {
            cursorDisposer.pData = j;
            return;
        }
        CursorDisposer cursorDisposer2 = new CursorDisposer(j);
        this.disposer = cursorDisposer2;
        if (this.anchor == null) {
            this.anchor = new Object();
        }
        Disposer.addRecord(this.anchor, cursorDisposer2);
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return getClass().getName() + "[" + getName() + "]";
    }

    public Cursor(String str) {
        this.anchor = new Object();
        this.type = -1;
        this.name = str;
    }
}
