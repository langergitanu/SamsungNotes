package io.netty.util.internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ClassInitializerUtil {
    private ClassInitializerUtil() {
    }

    private static void tryLoadClass(ClassLoader classLoader, String str) {
        try {
            Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException | SecurityException unused) {
        }
    }

    public static void tryLoadClasses(Class<?> cls, Class<?>... clsArr) {
        ClassLoader classLoader = PlatformDependent.getClassLoader(cls);
        for (Class<?> cls2 : clsArr) {
            tryLoadClass(classLoader, cls2.getName());
        }
    }
}
