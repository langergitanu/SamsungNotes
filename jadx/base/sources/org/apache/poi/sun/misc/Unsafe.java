package org.apache.poi.sun.misc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Unsafe {
    private static final Unsafe THE_ONE;
    private static final Unsafe theUnsafe;

    static {
        Unsafe unsafe = new Unsafe();
        THE_ONE = unsafe;
        theUnsafe = unsafe;
    }

    private Unsafe() {
    }

    private static native int arrayBaseOffset0(Class cls);

    private static native int arrayIndexScale0(Class cls);

    public static Unsafe getUnsafe() {
        return theUnsafe;
    }

    private static native long objectFieldOffset0(Field field);

    public native Object allocateInstance(Class<?> cls);

    public int arrayBaseOffset(Class cls) {
        if (cls.isArray()) {
            return arrayBaseOffset0(cls);
        }
        throw new IllegalArgumentException("valid for array classes only");
    }

    public int arrayIndexScale(Class cls) {
        if (cls.isArray()) {
            return arrayIndexScale0(cls);
        }
        throw new IllegalArgumentException("valid for array classes only");
    }

    public native boolean compareAndSwapInt(Object obj, long j, int i, int i2);

    public native boolean compareAndSwapLong(Object obj, long j, long j2, long j3);

    public native boolean compareAndSwapObject(Object obj, long j, Object obj2, Object obj3);

    public native void ensureClassInitialized(Class<?> cls);

    public native int getInt(Object obj, long j);

    public native int getIntVolatile(Object obj, long j);

    public native long getLong(Object obj, long j);

    public native long getLongVolatile(Object obj, long j);

    public native Object getObject(Object obj, long j);

    public native Object getObjectVolatile(Object obj, long j);

    public long objectFieldOffset(Field field) {
        if (Modifier.isStatic(field.getModifiers())) {
            throw new IllegalArgumentException("valid for instance fields only");
        }
        return objectFieldOffset0(field);
    }

    public native void putInt(Object obj, long j, int i);

    public native void putIntVolatile(Object obj, long j, int i);

    public native void putLong(Object obj, long j, long j2);

    public native void putLongVolatile(Object obj, long j, long j2);

    public native void putObject(Object obj, long j, Object obj2);

    public native void putObjectVolatile(Object obj, long j, Object obj2);

    public native void putOrderedInt(Object obj, long j, int i);

    public native void putOrderedLong(Object obj, long j, long j2);

    public native void putOrderedObject(Object obj, long j, Object obj2);
}
