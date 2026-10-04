package org.junit.internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class Classes {
    @Deprecated
    public Classes() {
    }

    public static Class<?> getClass(String str) {
        return getClass(str, Classes.class);
    }

    public static Class<?> getClass(String str, Class<?> cls) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = cls.getClassLoader();
        }
        return Class.forName(str, true, contextClassLoader);
    }
}
