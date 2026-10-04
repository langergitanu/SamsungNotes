package org.apache.commons.lang3.reflect;

import androidx.compose.runtime.AbstractC1974b;
import androidx.window.embedding.C4015c;
import com.opencsv.bean.C6618c;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.C9478c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.exception.C13833a;
import org.apache.commons.lang3.exception.C13834b;
import p001A.AbstractC0000a;
import p074R1.C0230b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MethodUtils {
    private static final Comparator<Method> METHOD_BY_SIGNATURE = Comparator.comparing(new C13833a(3));

    @Deprecated
    public MethodUtils() {
    }

    private static int distance(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (!ClassUtils.isAssignable(clsArr, clsArr2, true)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            Class<?> cls = clsArr[i2];
            Class<?> cls2 = clsArr2[i2];
            if (cls != null && !cls.equals(cls2)) {
                i = (!ClassUtils.isAssignable(cls, cls2, true) || ClassUtils.isAssignable(cls, cls2, false)) ? i + 2 : i + 1;
            }
        }
        return i;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        return getAccessibleMethod(getMethodObject(cls, str, clsArr));
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (ClassUtils.isPublic(cls2)) {
                    try {
                        return cls2.getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(cls2, str, clsArr);
                        if (accessibleMethodFromInterfaceNest != null) {
                            return accessibleMethodFromInterfaceNest;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (ClassUtils.isPublic(superclass)) {
                return getMethodObject(superclass, str, clsArr);
            }
        }
        return null;
    }

    private static List<Class<?>> getAllSuperclassesAndInterfaces(Class<?> cls) {
        int i;
        Class<?> cls2;
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Class<?>> allSuperclasses = ClassUtils.getAllSuperclasses(cls);
        List<Class<?>> allInterfaces = ClassUtils.getAllInterfaces(cls);
        int i2 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= allInterfaces.size() && i4 >= allSuperclasses.size()) {
                return arrayList;
            }
            if (i2 >= allInterfaces.size() || (i4 < allSuperclasses.size() && i4 < i2)) {
                i = i2;
                cls2 = allSuperclasses.get(i4);
                i4++;
            } else {
                i = i2 + 1;
                cls2 = allInterfaces.get(i2);
            }
            arrayList.add(cls2);
            i2 = i;
        }
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls, boolean z, boolean z2) {
        Objects.requireNonNull(method, "method");
        Objects.requireNonNull(cls, "annotationCls");
        if (!z2 && !MemberUtils.isAccessible(method)) {
            return null;
        }
        A a = (A) method.getAnnotation(cls);
        if (a == null && z) {
            for (Class<?> cls2 : getAllSuperclassesAndInterfaces(method.getDeclaringClass())) {
                Method matchingMethod = z2 ? getMatchingMethod(cls2, method.getName(), method.getParameterTypes()) : getMatchingAccessibleMethod(cls2, method.getName(), method.getParameterTypes());
                if (matchingMethod != null && (a = (A) matchingMethod.getAnnotation(cls)) != null) {
                    break;
                }
            }
        }
        return a;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method methodObject = getMethodObject(cls, str, clsArr);
        if (methodObject != null) {
            return (Method) MemberUtils.setAccessibleWorkaround(methodObject);
        }
        List list = (List) Stream.of((Object[]) cls.getMethods()).filter(new C4015c(str, clsArr, 2)).collect(Collectors.toList());
        list.sort(METHOD_BY_SIGNATURE);
        Iterator it = list.iterator();
        Method method = null;
        while (it.hasNext()) {
            Method accessibleMethod = getAccessibleMethod((Method) it.next());
            if (accessibleMethod != null && (method == null || MemberUtils.compareMethodFit(accessibleMethod, method, clsArr) < 0)) {
                method = accessibleMethod;
            }
        }
        if (method != null) {
            MemberUtils.setAccessibleWorkaround(method);
        }
        if (method != null && method.isVarArgs() && method.getParameterTypes().length > 0 && clsArr.length > 0) {
            String name = ClassUtils.primitiveToWrapper(method.getParameterTypes()[r3.length - 1].getComponentType()).getName();
            Class<?> cls2 = clsArr[clsArr.length - 1];
            String name2 = cls2 == null ? null : cls2.getName();
            String name3 = (cls2 == null || cls2.getSuperclass() == null) ? null : cls2.getSuperclass().getName();
            if (name2 != null && name3 != null && !name.equals(name2) && !name.equals(name3)) {
                return null;
            }
        }
        return method;
    }

    public static Method getMatchingMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Objects.requireNonNull(cls, MarketingConstants.INTENT_CLASS);
        Validate.notEmpty(str, "methodName", new Object[0]);
        List<Method> list = (List) Stream.of((Object[]) cls.getDeclaredMethods()).filter(new C9478c(str, 8)).collect(Collectors.toList());
        Stream streamFilter = getAllSuperclassesAndInterfaces(cls).stream().map(new C13833a(5)).flatMap(new C13833a(6)).filter(new C9478c(str, 9));
        Objects.requireNonNull(list);
        streamFilter.forEach(new C13834b(list, 4));
        for (Method method : list) {
            if (Arrays.deepEquals(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        TreeMap treeMap = new TreeMap();
        list.stream().filter(new C7233a(clsArr, 16)).forEach(new C6618c(clsArr, treeMap, 14));
        if (treeMap.isEmpty()) {
            return null;
        }
        List list2 = (List) treeMap.values().iterator().next();
        if (list2.size() == 1 || !Objects.equals(((Method) list2.get(0)).getDeclaringClass(), ((Method) list2.get(1)).getDeclaringClass())) {
            return (Method) list2.get(0);
        }
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        sbM1324q.append((String) Stream.of((Object[]) clsArr).map(new C13833a(2)).collect(Collectors.joining(",", "(", ")")));
        throw new IllegalStateException(String.format("Found multiple candidates for method %s on class %s : %s", sbM1324q.toString(), cls.getName(), list2.stream().map(new C13833a(3)).collect(Collectors.joining(",", "[", "]"))));
    }

    public static Method getMethodObject(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsListWithAnnotation(cls, cls2, false, false);
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return getMethodsWithAnnotation(cls, cls2, false, false);
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        Objects.requireNonNull(method, "method");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(method);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        Iterator<Class<?>> it = ClassUtils.hierarchy(declaringClass, interfaces).iterator();
        it.next();
        while (it.hasNext()) {
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(it.next(), method.getName(), parameterTypes);
            if (matchingAccessibleMethod != null) {
                if (!Arrays.equals(matchingAccessibleMethod.getParameterTypes(), parameterTypes)) {
                    Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, matchingAccessibleMethod.getDeclaringClass());
                    int i = 0;
                    while (true) {
                        if (i >= parameterTypes.length) {
                            linkedHashSet.add(matchingAccessibleMethod);
                            break;
                        }
                        if (!TypeUtils.equals(TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i]), TypeUtils.unrollVariables(typeArguments, matchingAccessibleMethod.getGenericParameterTypes()[i]))) {
                            break;
                        }
                        i++;
                    }
                } else {
                    linkedHashSet.add(matchingAccessibleMethod);
                }
            }
        }
        return linkedHashSet;
    }

    public static Object[] getVarArgs(Object[] objArr, Class<?>[] clsArr) {
        if (objArr.length == clsArr.length && (objArr[objArr.length - 1] == null || objArr[objArr.length - 1].getClass().equals(clsArr[clsArr.length - 1]))) {
            return objArr;
        }
        Object[] objArr2 = (Object[]) ArrayUtils.arraycopy(objArr, 0, 0, clsArr.length - 1, new C0230b(clsArr, 8));
        final Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
        final int length = (objArr.length - clsArr.length) + 1;
        Object objArraycopy = ArrayUtils.arraycopy(objArr, clsArr.length - 1, 0, length, (Function<Integer, Object[]>) new Function() { // from class: org.apache.commons.lang3.reflect.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return MethodUtils.lambda$getVarArgs$9(componentType, length, (Integer) obj);
            }
        });
        if (componentType.isPrimitive()) {
            objArraycopy = ArrayUtils.toPrimitive(objArraycopy);
        }
        objArr2[clsArr.length - 1] = objArraycopy;
        return objArr2;
    }

    public static Object invokeExactMethod(Object obj, String str) {
        return invokeExactMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactStaticMethod(cls, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z, String str) {
        return invokeMethod(obj, z, str, ArrayUtils.EMPTY_OBJECT_ARRAY, null);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMatchingAccessibleMethod$0(String str, Class[] clsArr, Method method) {
        return method.getName().equals(str) && MemberUtils.isMatchingMethod(method, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMatchingMethod$1(String str, Method method) {
        return method.getName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMatchingMethod$2(String str, Method method) {
        return method.getName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMatchingMethod$3(Class[] clsArr, Method method) {
        return ClassUtils.isAssignable((Class<?>[]) clsArr, method.getParameterTypes(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getMatchingMethod$4(Integer num) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMatchingMethod$5(Class[] clsArr, TreeMap treeMap, Method method) {
        ((List) treeMap.computeIfAbsent(Integer.valueOf(distance(clsArr, method.getParameterTypes())), new C13833a(4))).add(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getMethodsListWithAnnotation$6(Class cls, Method method) {
        return method.isAnnotationPresent(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getMethodsListWithAnnotation$7(boolean z, Class cls, List list, Class cls2) {
        Stream streamFilter = Stream.of((Object[]) (z ? cls2.getDeclaredMethods() : cls2.getMethods())).filter(new C13895a(cls, 1));
        Objects.requireNonNull(list);
        streamFilter.forEachOrdered(new C13834b(list, 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object[] lambda$getVarArgs$8(Class[] clsArr) {
        return new Object[clsArr.length];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getVarArgs$9(Class cls, int i, Integer num) {
        return Array.newInstance(ClassUtils.primitiveToWrapper(cls), i);
    }

    private static Object[] toVarArgs(Method method, Object[] objArr) {
        return method.isVarArgs() ? getVarArgs(objArr, method.getParameterTypes()) : objArr;
    }

    public static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (ClassUtils.isPublic(declaringClass)) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    public static List<Method> getMethodsListWithAnnotation(Class<?> cls, final Class<? extends Annotation> cls2, boolean z, final boolean z2) {
        Objects.requireNonNull(cls, MarketingConstants.INTENT_CLASS);
        Objects.requireNonNull(cls2, "annotationCls");
        List allSuperclassesAndInterfaces = z ? getAllSuperclassesAndInterfaces(cls) : new ArrayList();
        allSuperclassesAndInterfaces.add(0, cls);
        final ArrayList arrayList = new ArrayList();
        allSuperclassesAndInterfaces.forEach(new Consumer() { // from class: org.apache.commons.lang3.reflect.c
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MethodUtils.lambda$getMethodsListWithAnnotation$7(z2, cls2, arrayList, (Class) obj);
            }
        });
        return arrayList;
    }

    public static Method[] getMethodsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2, boolean z, boolean z2) {
        return (Method[]) getMethodsListWithAnnotation(cls, cls2, z, z2).toArray(ArrayUtils.EMPTY_METHOD_ARRAY);
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactMethod(obj, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object... objArr) {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, z, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(null, objArrNullToEmpty);
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("No such accessible method: ", str, "() on class: ");
        sbM15l.append(cls.getName());
        throw new NoSuchMethodException(sbM15l.toString());
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(null, toVarArgs(matchingAccessibleMethod, objArrNullToEmpty));
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("No such accessible method: ", str, "() on class: ");
        sbM15l.append(cls.getName());
        throw new NoSuchMethodException(sbM15l.toString());
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        Objects.requireNonNull(obj, CoeditServiceConstants.Element.NAME_OBJECT);
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Class<?> cls = obj.getClass();
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArrNullToEmpty);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, objArrNullToEmpty);
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("No such accessible method: ", str, "() on object: ");
        sbM15l.append(cls.getName());
        throw new NoSuchMethodException(sbM15l.toString());
    }

    public static Object invokeMethod(Object obj, boolean z, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException {
        Method matchingAccessibleMethod;
        String str2;
        Objects.requireNonNull(obj, CoeditServiceConstants.Element.NAME_OBJECT);
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Class<?> cls = obj.getClass();
        if (z) {
            matchingAccessibleMethod = getMatchingMethod(cls, str, clsArrNullToEmpty);
            if (matchingAccessibleMethod != null && !matchingAccessibleMethod.isAccessible()) {
                matchingAccessibleMethod.setAccessible(true);
            }
            str2 = "No such method: ";
        } else {
            matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, clsArrNullToEmpty);
            str2 = "No such accessible method: ";
        }
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(obj, toVarArgs(matchingAccessibleMethod, objArrNullToEmpty));
        }
        throw new NoSuchMethodException(str2 + str + "() on object: " + cls.getName());
    }

    public static Object invokeMethod(Object obj, String str) {
        return invokeMethod(obj, str, ArrayUtils.EMPTY_OBJECT_ARRAY, (Class<?>[]) null);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        Object[] objArrNullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, str, objArrNullToEmpty, ClassUtils.toClass(objArrNullToEmpty));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        return invokeMethod(obj, false, str, objArr, clsArr);
    }
}
