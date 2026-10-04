package io.netty.util.internal.shaded.org.jctools.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class UnsafeAccess {
    public static final Unsafe UNSAFE = getUnsafe();
    public static final boolean SUPPORTS_GET_AND_SET_REF = hasGetAndSetSupport();
    public static final boolean SUPPORTS_GET_AND_ADD_LONG = hasGetAndAddLongSupport();

    public static long fieldOffset(Class cls, String str) {
        try {
            return UNSAFE.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private static Unsafe getUnsafe() {
        try {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return (Unsafe) declaredField.get(null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception unused) {
            Constructor declaredConstructor = Unsafe.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return (Unsafe) declaredConstructor.newInstance(null);
        }
    }

    private static boolean hasGetAndAddLongSupport() {
        try {
            Class cls = Long.TYPE;
            Unsafe.class.getMethod("getAndAddLong", Object.class, cls, cls);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean hasGetAndSetSupport() {
        try {
            Unsafe.class.getMethod("getAndSetObject", Object.class, Long.TYPE, Object.class);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
