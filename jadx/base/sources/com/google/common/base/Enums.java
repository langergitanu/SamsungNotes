package com.google.common.base;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class Enums {

    @GwtIncompatible
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = new WeakHashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @GwtIncompatible
    public static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        public StringConverter(Class<T> cls) {
            this.enumClass = (Class) Preconditions.checkNotNull(cls);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StringConverter) {
                return this.enumClass.equals(((StringConverter) obj).enumClass);
            }
            return false;
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            return AbstractC2322a.m1618h(this.enumClass, new StringBuilder("Enums.stringConverter("), ".class)");
        }

        @Override // com.google.common.base.Converter
        public String doBackward(T t) {
            return t.name();
        }

        @Override // com.google.common.base.Converter
        public T doForward(String str) {
            return (T) Enum.valueOf(this.enumClass, str);
        }
    }

    private Enums() {
    }

    @GwtIncompatible
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> mapPopulateCache;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map = enumConstantCache;
        synchronized (map) {
            try {
                mapPopulateCache = map.get(cls);
                if (mapPopulateCache == null) {
                    mapPopulateCache = populateCache(cls);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mapPopulateCache;
    }

    @GwtIncompatible
    public static Field getField(Enum<?> r12) {
        try {
            return r12.getDeclaringClass().getDeclaredField(r12.name());
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> cls, String str) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(str);
        return Platform.getEnumIfPresent(cls, str);
    }

    @GwtIncompatible
    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> cls) {
        HashMap map = new HashMap();
        for (Enum r2 : EnumSet.allOf(cls)) {
            map.put(r2.name(), new WeakReference(r2));
        }
        enumConstantCache.put(cls, map);
        return map;
    }

    @GwtIncompatible
    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> cls) {
        return new StringConverter(cls);
    }
}
