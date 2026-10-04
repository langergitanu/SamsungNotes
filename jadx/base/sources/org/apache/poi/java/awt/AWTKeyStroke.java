package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import kotlin.jvm.internal.CharCompanionObject;
import org.apache.poi.java.awt.event.KeyEvent;
import org.apache.poi.sun.awt.AppContext;

/* JADX INFO: loaded from: classes10.dex */
public class AWTKeyStroke implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Object APP_CONTEXT_CACHE_KEY = new Object();
    private static AWTKeyStroke APP_CONTEXT_KEYSTROKE_KEY = new AWTKeyStroke();
    private static Map modifierKeywords = null;
    static final long serialVersionUID = -6430539691155161871L;
    private static VKCollection vks;
    private char keyChar;
    private int keyCode;
    private int modifiers;
    private boolean onKeyRelease;

    static {
        Toolkit.loadLibraries();
    }

    public AWTKeyStroke() {
        this.keyChar = CharCompanionObject.MAX_VALUE;
        this.keyCode = 0;
    }

    public static AWTKeyStroke getAWTKeyStroke(char c) {
        return getCachedStroke(c, 0, 0, false);
    }

    private static Class getAWTKeyStrokeClass() {
        AppContext appContext = AppContext.getAppContext();
        Class cls = (Class) appContext.get(AWTKeyStroke.class);
        if (cls != null) {
            return cls;
        }
        appContext.put(AWTKeyStroke.class, AWTKeyStroke.class);
        return AWTKeyStroke.class;
    }

    public static AWTKeyStroke getAWTKeyStrokeForEvent(KeyEvent keyEvent) {
        int id = keyEvent.getID();
        switch (id) {
            case 400:
                return getCachedStroke(keyEvent.getKeyChar(), 0, keyEvent.getModifiers(), false);
            case 401:
            case 402:
                return getCachedStroke(CharCompanionObject.MAX_VALUE, keyEvent.getKeyCode(), keyEvent.getModifiers(), id == 402);
            default:
                return null;
        }
    }

    private static synchronized AWTKeyStroke getCachedStroke(char c, int i, int i2, boolean z) {
        AWTKeyStroke aWTKeyStroke;
        AppContext appContext = AppContext.getAppContext();
        Map map = (Map) appContext.get(APP_CONTEXT_CACHE_KEY);
        aWTKeyStroke = (AWTKeyStroke) appContext.get(APP_CONTEXT_KEYSTROKE_KEY);
        if (map == null) {
            map = new HashMap();
            appContext.put(APP_CONTEXT_CACHE_KEY, map);
        }
        if (aWTKeyStroke == null) {
            try {
                AWTKeyStroke aWTKeyStroke2 = (AWTKeyStroke) getCtor(getAWTKeyStrokeClass()).newInstance(null);
                try {
                    appContext.put(APP_CONTEXT_KEYSTROKE_KEY, aWTKeyStroke2);
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                }
                aWTKeyStroke = aWTKeyStroke2;
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused2) {
            }
        }
        aWTKeyStroke.keyChar = c;
        aWTKeyStroke.keyCode = i;
        aWTKeyStroke.modifiers = mapNewModifiers(mapOldModifiers(i2));
        aWTKeyStroke.onKeyRelease = z;
        AWTKeyStroke aWTKeyStroke3 = (AWTKeyStroke) map.get(aWTKeyStroke);
        if (aWTKeyStroke3 == null) {
            map.put(aWTKeyStroke, aWTKeyStroke);
            appContext.remove(APP_CONTEXT_KEYSTROKE_KEY);
        } else {
            aWTKeyStroke = aWTKeyStroke3;
        }
        return aWTKeyStroke;
    }

    private static Constructor getCtor(final Class cls) {
        return (Constructor) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.java.awt.AWTKeyStroke.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    Constructor declaredConstructor = cls.getDeclaredConstructor(null);
                    if (declaredConstructor != null) {
                        declaredConstructor.setAccessible(true);
                    }
                    return declaredConstructor;
                } catch (NoSuchMethodException | SecurityException unused) {
                    return null;
                }
            }
        });
    }

    public static String getModifiersText(int i) {
        StringBuilder sb = new StringBuilder();
        if ((i & 64) != 0) {
            sb.append("shift ");
        }
        if ((i & 128) != 0) {
            sb.append("ctrl ");
        }
        if ((i & 256) != 0) {
            sb.append("meta ");
        }
        if ((i & 512) != 0) {
            sb.append("alt ");
        }
        if ((i & 8192) != 0) {
            sb.append("altGraph ");
        }
        if ((i & 1024) != 0) {
            sb.append("button1 ");
        }
        if ((i & 2048) != 0) {
            sb.append("button2 ");
        }
        if ((i & 4096) != 0) {
            sb.append("button3 ");
        }
        return sb.toString();
    }

    private static VKCollection getVKCollection() {
        if (vks == null) {
            vks = new VKCollection();
        }
        return vks;
    }

    public static String getVKText(int i) {
        VKCollection vKCollection = getVKCollection();
        Integer numValueOf = Integer.valueOf(i);
        String strFindName = vKCollection.findName(numValueOf);
        if (strFindName != null) {
            return strFindName.substring(3);
        }
        Field[] declaredFields = KeyEvent.class.getDeclaredFields();
        for (int i2 = 0; i2 < declaredFields.length; i2++) {
            try {
                if (declaredFields[i2].getModifiers() == 25 && declaredFields[i2].getType() == Integer.TYPE && declaredFields[i2].getName().startsWith("VK_") && declaredFields[i2].getInt(KeyEvent.class) == i) {
                    String name = declaredFields[i2].getName();
                    vKCollection.put(name, numValueOf);
                    return name.substring(3);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "UNKNOWN";
    }

    private static int getVKValue(String str) {
        VKCollection vKCollection = getVKCollection();
        Integer numFindCode = vKCollection.findCode(str);
        if (numFindCode == null) {
            try {
                numFindCode = Integer.valueOf(KeyEvent.class.getField(str).getInt(KeyEvent.class));
                vKCollection.put(str, numFindCode);
            } catch (IllegalAccessException unused) {
                throw new IllegalArgumentException("String formatted incorrectly");
            } catch (NoSuchFieldException unused2) {
                throw new IllegalArgumentException("String formatted incorrectly");
            }
        }
        return numFindCode.intValue();
    }

    private static int mapNewModifiers(int i) {
        if ((i & 64) != 0) {
            i |= 1;
        }
        if ((i & 512) != 0) {
            i |= 8;
        }
        if ((i & 8192) != 0) {
            i |= 32;
        }
        if ((i & 128) != 0) {
            i |= 2;
        }
        return (i & 256) != 0 ? i | 4 : i;
    }

    private static int mapOldModifiers(int i) {
        if ((i & 1) != 0) {
            i |= 64;
        }
        if ((i & 8) != 0) {
            i |= 512;
        }
        if ((i & 32) != 0) {
            i |= 8192;
        }
        if ((i & 2) != 0) {
            i |= 128;
        }
        if ((i & 4) != 0) {
            i |= 256;
        }
        return i & 16320;
    }

    public static void registerSubclass(Class<?> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("subclass cannot be null");
        }
        AppContext appContext = AppContext.getAppContext();
        synchronized (AWTKeyStroke.class) {
            try {
                Class cls2 = (Class) appContext.get(AWTKeyStroke.class);
                if (cls2 == null || !cls2.equals(cls)) {
                    if (!AWTKeyStroke.class.isAssignableFrom(cls)) {
                        throw new ClassCastException("subclass is not derived from AWTKeyStroke");
                    }
                    Constructor ctor = getCtor(cls);
                    if (ctor == null) {
                        throw new IllegalArgumentException("subclass could not be instantiated");
                    }
                    try {
                        if (((AWTKeyStroke) ctor.newInstance(null)) == null) {
                            throw new IllegalArgumentException("subclass could not be instantiated");
                        }
                        synchronized (AWTKeyStroke.class) {
                            appContext.put(AWTKeyStroke.class, cls);
                            appContext.remove(APP_CONTEXT_CACHE_KEY);
                            appContext.remove(APP_CONTEXT_KEYSTROKE_KEY);
                        }
                    } catch (ExceptionInInitializerError unused) {
                        throw new IllegalArgumentException("subclass could not be instantiated");
                    } catch (IllegalAccessException unused2) {
                        throw new IllegalArgumentException("subclass could not be instantiated");
                    } catch (InstantiationException unused3) {
                        throw new IllegalArgumentException("subclass could not be instantiated");
                    } catch (NoSuchMethodError unused4) {
                        throw new IllegalArgumentException("subclass could not be instantiated");
                    } catch (InvocationTargetException unused5) {
                        throw new IllegalArgumentException("subclass could not be instantiated");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AWTKeyStroke) {
            AWTKeyStroke aWTKeyStroke = (AWTKeyStroke) obj;
            if (aWTKeyStroke.keyChar == this.keyChar && aWTKeyStroke.keyCode == this.keyCode && aWTKeyStroke.onKeyRelease == this.onKeyRelease && aWTKeyStroke.modifiers == this.modifiers) {
                return true;
            }
        }
        return false;
    }

    public final char getKeyChar() {
        return this.keyChar;
    }

    public final int getKeyCode() {
        return this.keyCode;
    }

    public final int getKeyEventType() {
        if (this.keyCode == 0) {
            return 400;
        }
        return this.onKeyRelease ? 402 : 401;
    }

    public final int getModifiers() {
        return this.modifiers;
    }

    public int hashCode() {
        return ((this.modifiers + 1) * (this.keyCode + 1) * 2 * (this.keyChar + 1)) + (this.onKeyRelease ? 1 : 2);
    }

    public final boolean isOnKeyRelease() {
        return this.onKeyRelease;
    }

    public Object readResolve() {
        synchronized (AWTKeyStroke.class) {
            try {
                if (!getClass().equals(getAWTKeyStrokeClass())) {
                    return this;
                }
                return getCachedStroke(this.keyChar, this.keyCode, this.modifiers, this.onKeyRelease);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        StringBuilder sb;
        if (this.keyCode == 0) {
            sb = new StringBuilder();
            sb.append(getModifiersText(this.modifiers));
            sb.append("typed ");
            sb.append(this.keyChar);
        } else {
            sb = new StringBuilder();
            sb.append(getModifiersText(this.modifiers));
            sb.append(this.onKeyRelease ? "released" : "pressed");
            sb.append(" ");
            sb.append(getVKText(this.keyCode));
        }
        return sb.toString();
    }

    public AWTKeyStroke(char c, int i, int i2, boolean z) {
        this.keyChar = c;
        this.keyCode = i;
        this.modifiers = i2;
        this.onKeyRelease = z;
    }

    public static AWTKeyStroke getAWTKeyStroke(int i, int i2) {
        return getCachedStroke(CharCompanionObject.MAX_VALUE, i, i2, false);
    }

    public static AWTKeyStroke getAWTKeyStroke(int i, int i2, boolean z) {
        return getCachedStroke(CharCompanionObject.MAX_VALUE, i, i2, z);
    }

    public static AWTKeyStroke getAWTKeyStroke(Character ch, int i) {
        if (ch != null) {
            return getCachedStroke(ch.charValue(), 0, i, false);
        }
        throw new IllegalArgumentException("keyChar cannot be null");
    }

    public static AWTKeyStroke getAWTKeyStroke(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
        synchronized (AWTKeyStroke.class) {
            try {
                if (modifierKeywords == null) {
                    HashMap map = new HashMap(8, 1.0f);
                    map.put("shift", 65);
                    map.put("control", 130);
                    map.put("ctrl", 130);
                    map.put("meta", 260);
                    map.put("alt", 520);
                    map.put("altGraph", 8224);
                    map.put("button1", 1024);
                    map.put("button2", 2048);
                    map.put("button3", 4096);
                    modifierKeywords = Collections.synchronizedMap(map);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int iCountTokens = stringTokenizer.countTokens();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int iIntValue = 0;
        for (int i = 1; i <= iCountTokens; i++) {
            String strNextToken = stringTokenizer.nextToken();
            if (z) {
                if (strNextToken.length() == 1 && i == iCountTokens) {
                    return getCachedStroke(strNextToken.charAt(0), 0, iIntValue, false);
                }
                throw new IllegalArgumentException("String formatted incorrectly");
            }
            if (z2 || z3 || i == iCountTokens) {
                if (i == iCountTokens) {
                    return getCachedStroke(CharCompanionObject.MAX_VALUE, getVKValue(AbstractC0541b.m772n("VK_", strNextToken)), iIntValue, z3);
                }
                throw new IllegalArgumentException("String formatted incorrectly");
            }
            if (strNextToken.equals("released")) {
                z3 = true;
            } else if (strNextToken.equals("pressed")) {
                z2 = true;
            } else if (strNextToken.equals("typed")) {
                z = true;
            } else {
                Integer num = (Integer) modifierKeywords.get(strNextToken);
                if (num == null) {
                    throw new IllegalArgumentException("String formatted incorrectly");
                }
                iIntValue |= num.intValue();
            }
        }
        throw new IllegalArgumentException("String formatted incorrectly");
    }
}
