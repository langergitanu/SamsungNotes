package org.apache.commons.beanutils;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.SystemProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MethodUtils {
    private static boolean CACHE_METHODS = true;
    private static final Class<?>[] EMPTY_CLASS_PARAMETERS = new Class[0];
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    private static final Map<MethodDescriptor, Reference<Method>> cache = Collections.synchronizedMap(new WeakHashMap());
    private static boolean loggedAccessibleWarning;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MethodDescriptor {
        private final Class<?> cls;
        private final boolean exact;
        private final int hashCode;
        private final String methodName;
        private final Class<?>[] paramTypes;

        public MethodDescriptor(Class<?> cls, String str, Class<?>[] clsArr, boolean z) {
            if (cls == null) {
                throw new IllegalArgumentException("Class cannot be null");
            }
            if (str == null) {
                throw new IllegalArgumentException("Method Name cannot be null");
            }
            clsArr = clsArr == null ? MethodUtils.EMPTY_CLASS_PARAMETERS : clsArr;
            this.cls = cls;
            this.methodName = str;
            this.paramTypes = clsArr;
            this.exact = z;
            this.hashCode = str.length();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodDescriptor)) {
                return false;
            }
            MethodDescriptor methodDescriptor = (MethodDescriptor) obj;
            return this.exact == methodDescriptor.exact && this.methodName.equals(methodDescriptor.methodName) && this.cls.equals(methodDescriptor.cls) && Arrays.equals(this.paramTypes, methodDescriptor.paramTypes);
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    @Deprecated
    public MethodUtils() {
    }

    private static void cacheMethod(MethodDescriptor methodDescriptor, Method method) {
        if (!CACHE_METHODS || method == null) {
            return;
        }
        cache.put(methodDescriptor, new WeakReference(method));
    }

    public static synchronized int clearCache() {
        int size;
        Map<MethodDescriptor, Reference<Method>> map = cache;
        size = map.size();
        map.clear();
        return size;
    }

    public static Method getAccessibleMethod(Class<?> cls, Method method) {
        boolean zEquals;
        if (method == null || !Modifier.isPublic(method.getModifiers())) {
            return null;
        }
        if (cls == null) {
            cls = method.getDeclaringClass();
            zEquals = true;
        } else {
            zEquals = cls.equals(method.getDeclaringClass());
            if (!method.getDeclaringClass().isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls.getName() + " is not assignable from " + method.getDeclaringClass().getName());
            }
        }
        if (Modifier.isPublic(cls.getModifiers())) {
            if (!zEquals && !Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                setMethodAccessible(method);
            }
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(cls, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>[] clsArr) {
        Method accessibleMethodFromInterfaceNest = null;
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (Modifier.isPublic(cls2.getModifiers())) {
                    try {
                        accessibleMethodFromInterfaceNest = cls2.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                    }
                    if (accessibleMethodFromInterfaceNest != null) {
                        return accessibleMethodFromInterfaceNest;
                    }
                    accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls2, str, clsArr);
                    if (accessibleMethodFromInterfaceNest != null) {
                        return accessibleMethodFromInterfaceNest;
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>[] clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
        }
        return null;
    }

    private static Method getCachedMethod(MethodDescriptor methodDescriptor) {
        Reference<Method> reference;
        if (!CACHE_METHODS || (reference = cache.get(methodDescriptor)) == null) {
            return null;
        }
        return reference.get();
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        String str2 = str;
        Log log = LogFactory.getLog((Class<?>) MethodUtils.class);
        if (log.isTraceEnabled()) {
            log.trace("Matching name=" + str2 + " on " + cls);
        }
        int i = 0;
        MethodDescriptor methodDescriptor = new MethodDescriptor(cls, str2, clsArr, false);
        try {
            Method cachedMethod = getCachedMethod(methodDescriptor);
            if (cachedMethod != null) {
                return cachedMethod;
            }
            Method method = cls.getMethod(str, clsArr);
            if (log.isTraceEnabled()) {
                log.trace("Found straight match: " + method);
                log.trace("isPublic:" + Modifier.isPublic(method.getModifiers()));
            }
            setMethodAccessible(method);
            cacheMethod(methodDescriptor, method);
            return method;
        } catch (NoSuchMethodException unused) {
            int length = clsArr.length;
            Method[] methods = cls.getMethods();
            int length2 = methods.length;
            Method method2 = null;
            float f = Float.MAX_VALUE;
            int i2 = 0;
            while (i2 < length2) {
                Method method3 = methods[i2];
                if (method3.getName().equals(str2)) {
                    if (log.isTraceEnabled()) {
                        log.trace("Found matching name:");
                        log.trace(method3);
                    }
                    Class<?>[] parameterTypes = method3.getParameterTypes();
                    int length3 = parameterTypes.length;
                    if (length3 == length) {
                        int i4 = i;
                        while (true) {
                            if (i4 >= length3) {
                                Method accessibleMethod = getAccessibleMethod(cls, method3);
                                if (accessibleMethod != null) {
                                    if (log.isTraceEnabled()) {
                                        log.trace(accessibleMethod + " accessible version of " + method3);
                                    }
                                    setMethodAccessible(accessibleMethod);
                                    float totalTransformationCost = getTotalTransformationCost(clsArr, accessibleMethod.getParameterTypes());
                                    if (totalTransformationCost < f) {
                                        method2 = accessibleMethod;
                                        f = totalTransformationCost;
                                    }
                                }
                                log.trace("Couldn't find accessible method.");
                            } else {
                                if (log.isTraceEnabled()) {
                                    log.trace("Param=".concat(clsArr[i4].getName()));
                                    log.trace("Method=".concat(parameterTypes[i4].getName()));
                                }
                                if (isAssignmentCompatible(parameterTypes[i4], clsArr[i4])) {
                                    i4++;
                                } else if (log.isTraceEnabled()) {
                                    log.trace(parameterTypes[i4] + " is not assignable from " + clsArr[i4]);
                                }
                            }
                        }
                    }
                }
                i2++;
                str2 = str;
                i = 0;
            }
            if (method2 != null) {
                cacheMethod(methodDescriptor, method2);
            } else {
                log.trace("No match found.");
            }
            return method2;
        }
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        Class<?> primitiveWrapper;
        float f = 0.0f;
        while (cls != null && !cls2.equals(cls)) {
            if ((cls2.isPrimitive() && (primitiveWrapper = getPrimitiveWrapper(cls2)) != null && primitiveWrapper.equals(cls)) || (cls2.isInterface() && isAssignmentCompatible(cls2, cls))) {
                f += 0.25f;
                break;
            }
            f += 1.0f;
            cls = cls.getSuperclass();
        }
        return cls == null ? f + 1.5f : f;
    }

    public static Class<?> getPrimitiveType(Class<?> cls) {
        if (Boolean.class.equals(cls)) {
            return Boolean.TYPE;
        }
        if (Float.class.equals(cls)) {
            return Float.TYPE;
        }
        if (Long.class.equals(cls)) {
            return Long.TYPE;
        }
        if (Integer.class.equals(cls)) {
            return Integer.TYPE;
        }
        if (Short.class.equals(cls)) {
            return Short.TYPE;
        }
        if (Byte.class.equals(cls)) {
            return Byte.TYPE;
        }
        if (Double.class.equals(cls)) {
            return Double.TYPE;
        }
        if (Character.class.equals(cls)) {
            return Character.TYPE;
        }
        Log log = LogFactory.getLog((Class<?>) MethodUtils.class);
        if (!log.isDebugEnabled()) {
            return null;
        }
        log.debug("Not a known primitive wrapper class: " + cls);
        return null;
    }

    public static Class<?> getPrimitiveWrapper(Class<?> cls) {
        if (Boolean.TYPE.equals(cls)) {
            return Boolean.class;
        }
        if (Float.TYPE.equals(cls)) {
            return Float.class;
        }
        if (Long.TYPE.equals(cls)) {
            return Long.class;
        }
        if (Integer.TYPE.equals(cls)) {
            return Integer.class;
        }
        if (Short.TYPE.equals(cls)) {
            return Short.class;
        }
        if (Byte.TYPE.equals(cls)) {
            return Byte.class;
        }
        if (Double.TYPE.equals(cls)) {
            return Double.class;
        }
        if (Character.TYPE.equals(cls)) {
            return Character.class;
        }
        return null;
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float objectTransformationCost = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            objectTransformationCost += getObjectTransformationCost(clsArr[i], clsArr2[i]);
        }
        return objectTransformationCost;
    }

    public static Object invokeExactMethod(Object obj, String str, Object obj2) {
        return invokeExactMethod(obj, str, toArray(obj2));
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object obj) {
        return invokeExactStaticMethod(cls, str, toArray(obj));
    }

    public static Object invokeMethod(Object obj, String str, Object obj2) {
        return invokeMethod(obj, str, toArray(obj2));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object obj) {
        return invokeStaticMethod(cls, str, toArray(obj));
    }

    public static final boolean isAssignmentCompatible(Class<?> cls, Class<?> cls2) {
        Class<?> primitiveWrapper;
        if (cls.isAssignableFrom(cls2)) {
            return true;
        }
        if (!cls.isPrimitive() || (primitiveWrapper = getPrimitiveWrapper(cls)) == null) {
            return false;
        }
        return primitiveWrapper.equals(cls2);
    }

    public static synchronized void setCacheMethods(boolean z) {
        CACHE_METHODS = z;
        if (!z) {
            clearCache();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void setMethodAccessible(Method method) {
        String property;
        try {
            if (method.isAccessible()) {
                return;
            }
            method.setAccessible(true);
        } catch (SecurityException e) {
            Log log = LogFactory.getLog((Class<?>) MethodUtils.class);
            if (!loggedAccessibleWarning) {
                try {
                    property = System.getProperty(SystemProperties.JAVA_SPECIFICATION_VERSION);
                } catch (SecurityException unused) {
                }
                if (property.charAt(0) == '1') {
                    if (property.charAt(2) == '0' || property.charAt(2) == '1' || property.charAt(2) == '2') {
                        log.warn("Current Security Manager restricts use of workarounds for reflection bugs  in pre-1.4 JVMs.");
                    } else if (property.charAt(2) == '3') {
                    }
                }
                loggedAccessibleWarning = true;
            }
            log.debug("Cannot setAccessible on method. Therefore cannot use jvm access bug workaround.", e);
        }
    }

    private static Object[] toArray(Object obj) {
        if (obj != null) {
            return new Object[]{obj};
        }
        return null;
    }

    public static Class<?> toNonPrimitiveClass(Class<?> cls) {
        Class<?> primitiveWrapper;
        return (cls.isPrimitive() && (primitiveWrapper = getPrimitiveWrapper(cls)) != null) ? primitiveWrapper : cls;
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr) {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeExactMethod(obj, str, objArr, clsArr);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr) {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeExactStaticMethod(cls, str, objArr, clsArr);
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr) {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeMethod(obj, str, objArr, clsArr);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr) {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeStaticMethod(cls, str, objArr, clsArr);
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, objArr);
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("No such accessible method: ", str, "() on object: ");
        sbM15l.append(obj.getClass().getName());
        throw new NoSuchMethodException(sbM15l.toString());
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(null, objArr);
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("No such accessible method: ", str, "() on class: ");
        sbM15l.append(cls.getName());
        throw new NoSuchMethodException(sbM15l.toString());
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(obj, objArr);
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("No such accessible method: ", str, "() on object: ");
        sbM15l.append(obj.getClass().getName());
        throw new NoSuchMethodException(sbM15l.toString());
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_PARAMETERS;
        }
        if (objArr == null) {
            objArr = EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(null, objArr);
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("No such accessible method: ", str, "() on class: ");
        sbM15l.append(cls.getName());
        throw new NoSuchMethodException(sbM15l.toString());
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?> cls2) {
        return getAccessibleMethod(cls, str, (Class<?>[]) new Class[]{cls2});
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        try {
            MethodDescriptor methodDescriptor = new MethodDescriptor(cls, str, clsArr, true);
            Method cachedMethod = getCachedMethod(methodDescriptor);
            if (cachedMethod != null) {
                return cachedMethod;
            }
            Method accessibleMethod = getAccessibleMethod(cls, cls.getMethod(str, clsArr));
            cacheMethod(methodDescriptor, accessibleMethod);
            return accessibleMethod;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method getAccessibleMethod(Method method) {
        if (method == null) {
            return null;
        }
        return getAccessibleMethod(method.getDeclaringClass(), method);
    }
}
