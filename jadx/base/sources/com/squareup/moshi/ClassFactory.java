package com.squareup.moshi;

import com.squareup.moshi.internal.Util;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class ClassFactory<T> {
    public static <T> ClassFactory<T> get(final Class<?> cls) {
        try {
            try {
                try {
                    try {
                        final Constructor<?> declaredConstructor = cls.getDeclaredConstructor(null);
                        declaredConstructor.setAccessible(true);
                        return new ClassFactory<T>() { // from class: com.squareup.moshi.ClassFactory.1
                            @Override // com.squareup.moshi.ClassFactory
                            public T newInstance() {
                                return (T) declaredConstructor.newInstance(null);
                            }

                            public String toString() {
                                return cls.getName();
                            }
                        };
                    } catch (Exception unused) {
                        throw new IllegalArgumentException("cannot construct instances of ".concat(cls.getName()));
                    }
                } catch (NoSuchMethodException unused2) {
                    Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls2.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    final Object obj = declaredField.get(null);
                    final Method method = cls2.getMethod("allocateInstance", Class.class);
                    return new ClassFactory<T>() { // from class: com.squareup.moshi.ClassFactory.2
                        @Override // com.squareup.moshi.ClassFactory
                        public T newInstance() {
                            return (T) method.invoke(obj, cls);
                        }

                        public String toString() {
                            return cls.getName();
                        }
                    };
                }
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused3) {
                Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod.setAccessible(true);
                final int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                declaredMethod2.setAccessible(true);
                return new ClassFactory<T>() { // from class: com.squareup.moshi.ClassFactory.3
                    @Override // com.squareup.moshi.ClassFactory
                    public T newInstance() {
                        return (T) declaredMethod2.invoke(null, cls, Integer.valueOf(iIntValue));
                    }

                    public String toString() {
                        return cls.getName();
                    }
                };
            } catch (IllegalAccessException unused4) {
                throw new AssertionError();
            }
        } catch (IllegalAccessException unused5) {
            throw new AssertionError();
        } catch (NoSuchMethodException unused6) {
            final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            declaredMethod3.setAccessible(true);
            return new ClassFactory<T>() { // from class: com.squareup.moshi.ClassFactory.4
                @Override // com.squareup.moshi.ClassFactory
                public T newInstance() {
                    return (T) declaredMethod3.invoke(null, cls, Object.class);
                }

                public String toString() {
                    return cls.getName();
                }
            };
        } catch (InvocationTargetException e) {
            throw Util.rethrowCause(e);
        }
    }

    public abstract T newInstance();
}
