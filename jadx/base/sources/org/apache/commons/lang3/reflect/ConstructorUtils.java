package org.apache.commons.lang3.reflect;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.lang.reflect.Constructor;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConstructorUtils {
    @Deprecated
    public ConstructorUtils() {
    }

    public static <T> Constructor<T> getAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        Objects.requireNonNull(cls, MarketingConstants.INTENT_CLASS);
        try {
            return getAccessibleConstructor(cls.getConstructor(clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        Constructor<T> accessibleConstructor;
        Objects.requireNonNull(cls, MarketingConstants.INTENT_CLASS);
        try {
            return (Constructor) MemberUtils.setAccessibleWorkaround(cls.getConstructor(clsArr));
        } catch (NoSuchMethodException unused) {
            Constructor<T> constructor = null;
            for (Constructor<?> constructor2 : cls.getConstructors()) {
                if (MemberUtils.isMatchingConstructor(constructor2, clsArr) && (accessibleConstructor = getAccessibleConstructor(constructor2)) != null) {
                    MemberUtils.setAccessibleWorkaround(accessibleConstructor);
                    if (constructor == null || MemberUtils.compareConstructorFit(accessibleConstructor, constructor, clsArr) < 0) {
                        constructor = accessibleConstructor;
                    }
                }
            }
            return constructor;
        }
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return (T) invokeConstructor(cls, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static <T> T invokeExactConstructor(Class<T> cls, Object... objArr) {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return (T) invokeExactConstructor(cls, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    private static boolean isAccessible(Class<?> cls) {
        while (cls != null) {
            if (!ClassUtils.isPublic(cls)) {
                return false;
            }
            cls = cls.getEnclosingClass();
        }
        return true;
    }

    public static <T> Constructor<T> getAccessibleConstructor(Constructor<T> constructor) {
        Objects.requireNonNull(constructor, "ctor");
        if (MemberUtils.isAccessible(constructor) && isAccessible(constructor.getDeclaringClass())) {
            return constructor;
        }
        return null;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, ArrayUtils.nullToEmpty(clsArr));
        if (matchingAccessibleConstructor != null) {
            if (matchingAccessibleConstructor.isVarArgs()) {
                objArrNullToEmpty = MethodUtils.getVarArgs(objArrNullToEmpty, matchingAccessibleConstructor.getParameterTypes());
            }
            return (T) matchingAccessibleConstructor.newInstance(objArrNullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible constructor on object: ".concat(cls.getName()));
    }

    public static <T> T invokeExactConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Constructor accessibleConstructor = getAccessibleConstructor(cls, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleConstructor != null) {
            return (T) accessibleConstructor.newInstance(objArrNullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible constructor on object: ".concat(cls.getName()));
    }
}
