package org.apache.commons.lang3;

import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.adobe.internal.xmp.XMPConst;
import com.google.android.gms.common.data.AbstractC4539a;
import com.opencsv.bean.C6617b;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import opennlp.tools.tokenize.TokenizerME;
import org.apache.commons.collections4.map.C13771a;
import p001A.AbstractC0000a;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ClassUtils {
    private static final Map<String, String> ABBREVIATION_MAP;
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    private static final int MAX_DIMENSIONS = 255;
    private static final Map<String, Class<?>> NAME_PRIMITIVE_MAP;
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    private static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPER_MAP;
    private static final Map<String, String> REVERSE_ABBREVIATION_MAP;
    private static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE_MAP;
    private static final Comparator<Class<?>> COMPARATOR = new C13882g(1);
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Interfaces {
        INCLUDE,
        EXCLUDE
    }

    static {
        HashMap map = new HashMap();
        NAME_PRIMITIVE_MAP = map;
        Class cls = Boolean.TYPE;
        map.put(cls.getName(), cls);
        Class cls2 = Byte.TYPE;
        map.put(cls2.getName(), cls2);
        Class cls3 = Character.TYPE;
        map.put(cls3.getName(), cls3);
        Class cls4 = Double.TYPE;
        map.put(cls4.getName(), cls4);
        Class cls5 = Float.TYPE;
        map.put(cls5.getName(), cls5);
        Class cls6 = Integer.TYPE;
        map.put(cls6.getName(), cls6);
        Class cls7 = Long.TYPE;
        map.put(cls7.getName(), cls7);
        Class cls8 = Short.TYPE;
        map.put(cls8.getName(), cls8);
        Class cls9 = Void.TYPE;
        map.put(cls9.getName(), cls9);
        HashMap map2 = new HashMap();
        PRIMITIVE_WRAPPER_MAP = map2;
        map2.put(cls, Boolean.class);
        map2.put(cls2, Byte.class);
        map2.put(cls3, Character.class);
        map2.put(cls8, Short.class);
        map2.put(cls6, Integer.class);
        map2.put(cls7, Long.class);
        map2.put(cls4, Double.class);
        map2.put(cls5, Float.class);
        map2.put(cls9, cls9);
        WRAPPER_PRIMITIVE_MAP = new HashMap();
        map2.forEach(new C13886k(0));
        HashMap map3 = new HashMap();
        map3.put(cls6.getName(), "I");
        map3.put(cls.getName(), "Z");
        map3.put(cls5.getName(), TokenizerME.NO_SPLIT);
        map3.put(cls7.getName(), "J");
        map3.put(cls8.getName(), "S");
        map3.put(cls2.getName(), "B");
        map3.put(cls4.getName(), DiagMonUtil.AGREE_TYPE_DIAGNOSTIC);
        map3.put(cls3.getName(), FeedbackDetailConstants.PREFIX_CLIENT_ERROR);
        ABBREVIATION_MAP = Collections.unmodifiableMap(map3);
        REVERSE_ABBREVIATION_MAP = Collections.unmodifiableMap((Map) map3.entrySet().stream().collect(Collectors.toMap(new C13791b(10), new C6617b(7))));
    }

    @Deprecated
    public ClassUtils() {
    }

    public static Comparator<Class<?>> comparator() {
        return COMPARATOR;
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        list.forEach(new C13771a(arrayList, 1));
        return arrayList;
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        if (list == null) {
            return null;
        }
        return (List) list.stream().map(new C13791b(11)).collect(Collectors.toList());
    }

    public static String getAbbreviatedName(Class<?> cls, int i) {
        return cls == null ? "" : getAbbreviatedName(cls.getName(), i);
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        return arrayList;
    }

    public static String getCanonicalName(Class<?> cls) {
        return getCanonicalName(cls, "");
    }

    public static Class<?> getClass(ClassLoader classLoader, String str) {
        return getClass(classLoader, str, true);
    }

    public static <T> Class<T> getComponentType(Class<T[]> cls) {
        if (cls == null) {
            return null;
        }
        return (Class<T>) cls.getComponentType();
    }

    public static String getName(Class<?> cls) {
        return getName(cls, "");
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        return cls == null ? "" : getPackageCanonicalName(cls.getName());
    }

    public static String getPackageName(Class<?> cls) {
        return cls == null ? "" : getPackageName(cls.getName());
    }

    public static Class<?> getPrimitiveClass(String str) {
        return NAME_PRIMITIVE_MAP.get(str);
    }

    public static Method getPublicMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (isPublic(method.getDeclaringClass())) {
            return method;
        }
        ArrayList<Class> arrayList = new ArrayList(getAllInterfaces(cls));
        arrayList.addAll(getAllSuperclasses(cls));
        for (Class cls2 : arrayList) {
            if (isPublic(cls2)) {
                try {
                    Method method2 = cls2.getMethod(str, clsArr);
                    if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                        return method2;
                    }
                } catch (NoSuchMethodException unused) {
                    continue;
                }
            }
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("Can't find a public method for ", str, " ");
        sbM15l.append(ArrayUtils.toString(clsArr));
        throw new NoSuchMethodException(sbM15l.toString());
    }

    public static String getShortCanonicalName(Class<?> cls) {
        return cls == null ? "" : getShortCanonicalName(cls.getCanonicalName());
    }

    public static String getShortClassName(Class<?> cls) {
        return cls == null ? "" : getShortClassName(cls.getName());
    }

    public static String getSimpleName(Class<?> cls) {
        return getSimpleName(cls, "");
    }

    public static Iterable<Class<?>> hierarchy(Class<?> cls) {
        return hierarchy(cls, Interfaces.EXCLUDE);
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        return isAssignable(cls, cls2, true);
    }

    public static boolean isInnerClass(Class<?> cls) {
        return (cls == null || cls.getEnclosingClass() == null) ? false : true;
    }

    public static boolean isPrimitiveOrWrapper(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.isPrimitive() || isPrimitiveWrapper(cls);
    }

    public static boolean isPrimitiveWrapper(Class<?> cls) {
        return WRAPPER_PRIMITIVE_MAP.containsKey(cls);
    }

    public static boolean isPublic(Class<?> cls) {
        return Modifier.isPublic(cls.getModifiers());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertClassNamesToClasses$3(List list, String str) {
        try {
            list.add(Class.forName(str));
        } catch (Exception unused) {
            list.add(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$convertClassesToClassNames$2(Class cls) {
        return getName((Class<?>) cls, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$hierarchy$4(Class cls) {
        final AtomicReference atomicReference = new AtomicReference(cls);
        return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return atomicReference.get() != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Class<?> next() {
                return (Class) atomicReference.getAndUpdate(new C13889n());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$hierarchy$5(Iterable iterable) {
        final HashSet hashSet = new HashSet();
        final Iterator it = iterable.iterator();
        return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.2
            Iterator<Class<?>> interfaces = Collections.emptyIterator();

            private void walkInterfaces(Set<Class<?>> set, Class<?> cls) {
                for (Class<?> cls2 : cls.getInterfaces()) {
                    if (!hashSet.contains(cls2)) {
                        set.add(cls2);
                    }
                    walkInterfaces(set, cls2);
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.interfaces.hasNext() || it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Class<?> next() {
                if (this.interfaces.hasNext()) {
                    Class<?> next = this.interfaces.next();
                    hashSet.add(next);
                    return next;
                }
                Class<?> cls = (Class) it.next();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                walkInterfaces(linkedHashSet, cls);
                this.interfaces = linkedHashSet.iterator();
                return cls;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$primitivesToWrappers$6(Class[] clsArr, int i) {
        return primitiveToWrapper(clsArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(Class cls, Class cls2) {
        return Objects.compare(getName((Class<?>) cls), getName((Class<?>) cls2), new C0016a(20));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(Class cls, Class cls2) {
        if (cls.equals(cls2)) {
            return;
        }
        WRAPPER_PRIMITIVE_MAP.put(cls2, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$toClass$7(Object[] objArr, int i) {
        Object obj = objArr[i];
        if (obj == null) {
            return null;
        }
        return obj.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$wrappersToPrimitives$8(Class[] clsArr, int i) {
        return wrapperToPrimitive(clsArr[i]);
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : PRIMITIVE_WRAPPER_MAP.get(cls);
    }

    public static Class<?>[] primitivesToWrappers(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        Arrays.setAll(clsArr2, new C13888m(clsArr, 1));
        return clsArr2;
    }

    private static String toCanonicalName(String str) {
        String strDeleteWhitespace = StringUtils.deleteWhitespace(str);
        Objects.requireNonNull(strDeleteWhitespace, SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME);
        if (!strDeleteWhitespace.endsWith(XMPConst.ARRAY_ITEM_NAME)) {
            return strDeleteWhitespace;
        }
        StringBuilder sb = new StringBuilder();
        while (strDeleteWhitespace.endsWith(XMPConst.ARRAY_ITEM_NAME)) {
            strDeleteWhitespace = strDeleteWhitespace.substring(0, strDeleteWhitespace.length() - 2);
            sb.append("[");
        }
        String str2 = ABBREVIATION_MAP.get(strDeleteWhitespace);
        if (str2 != null) {
            sb.append(str2);
        } else {
            AbstractC1974b.m1332y(sb, "L", strDeleteWhitespace, ";");
        }
        return sb.toString();
    }

    public static Class<?>[] toClass(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        Arrays.setAll(clsArr, new C13831e(objArr, 8));
        return clsArr;
    }

    private static boolean useFull(int i, int i2, int i4, int i5) {
        return i2 >= i4 || (i + i4) - i2 <= i5;
    }

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        return WRAPPER_PRIMITIVE_MAP.get(cls);
    }

    public static Class<?>[] wrappersToPrimitives(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        Arrays.setAll(clsArr2, new C13888m(clsArr, 0));
        return clsArr2;
    }

    public static String getCanonicalName(Class<?> cls, String str) {
        String canonicalName;
        return (cls == null || (canonicalName = cls.getCanonicalName()) == null) ? str : canonicalName;
    }

    public static Class<?> getClass(ClassLoader classLoader, String str, boolean z) throws ClassNotFoundException {
        int iLastIndexOf;
        do {
            try {
                Class<?> primitiveClass = getPrimitiveClass(str);
                if (primitiveClass == null) {
                    primitiveClass = Class.forName(toCanonicalName(str), z, classLoader);
                }
                return primitiveClass;
            } catch (ClassNotFoundException unused) {
                iLastIndexOf = str.lastIndexOf(46);
                if (iLastIndexOf != -1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.substring(0, iLastIndexOf));
                    sb.append('$');
                    str = AbstractC4539a.m3198h(sb, str, iLastIndexOf + 1);
                }
            }
        } while (iLastIndexOf != -1);
        throw new ClassNotFoundException(str);
    }

    public static String getName(Class<?> cls, String str) {
        return cls == null ? str : cls.getName();
    }

    public static String getShortCanonicalName(Object obj, String str) {
        return obj == null ? str : getShortCanonicalName(obj.getClass().getCanonicalName());
    }

    public static String getSimpleName(Class<?> cls, String str) {
        return cls == null ? str : cls.getSimpleName();
    }

    public static Iterable<Class<?>> hierarchy(final Class<?> cls, Interfaces interfaces) {
        final int i = 0;
        final Iterable<Class<?>> iterable = new Iterable() { // from class: org.apache.commons.lang3.l
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                switch (i) {
                    case 0:
                        return ClassUtils.lambda$hierarchy$4((Class) cls);
                    default:
                        return ClassUtils.lambda$hierarchy$5((C13887l) cls);
                }
            }
        };
        if (interfaces != Interfaces.INCLUDE) {
            return iterable;
        }
        final int i2 = 1;
        return new Iterable() { // from class: org.apache.commons.lang3.l
            @Override // java.lang.Iterable
            public final Iterator iterator() {
                switch (i2) {
                    case 0:
                        return ClassUtils.lambda$hierarchy$4((Class) iterable);
                    default:
                        return ClassUtils.lambda$hierarchy$5((C13887l) iterable);
                }
            }
        };
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        Class cls3 = Integer.TYPE;
        boolean zEquals = cls3.equals(cls);
        Class cls4 = Long.TYPE;
        Class cls5 = Double.TYPE;
        Class cls6 = Float.TYPE;
        if (zEquals) {
            return cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
        }
        if (cls4.equals(cls)) {
            return cls6.equals(cls2) || cls5.equals(cls2);
        }
        if (Boolean.TYPE.equals(cls) || cls5.equals(cls)) {
            return false;
        }
        if (cls6.equals(cls)) {
            return cls5.equals(cls2);
        }
        if (!Character.TYPE.equals(cls)) {
            Class cls7 = Short.TYPE;
            if (!cls7.equals(cls)) {
                if (Byte.TYPE.equals(cls)) {
                    return cls7.equals(cls2) || cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
                }
                return false;
            }
        }
        return cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
    }

    public static String getAbbreviatedName(String str, int i) {
        char c;
        if (i <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        if (str == null) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i2 = 0;
        int i4 = 0;
        while (i2 < charArray.length) {
            int i5 = i4;
            while (i2 < charArray.length && (c = charArray[i2]) != '.') {
                i2++;
                charArray[i5] = c;
                i5++;
            }
            int i6 = i4 + 1;
            if (!useFull(i5, i2, charArray.length, i) && i6 <= i5) {
                i5 = i6;
            }
            if (i2 < charArray.length) {
                i4 = i5 + 1;
                charArray[i5] = charArray[i2];
                i2++;
            } else {
                i4 = i5;
            }
        }
        return new String(charArray, 0, i4);
    }

    public static String getCanonicalName(Object obj) {
        return getCanonicalName(obj, "");
    }

    public static String getName(Object obj) {
        return getName(obj, "");
    }

    public static String getPackageCanonicalName(Object obj, String str) {
        return obj == null ? str : getPackageCanonicalName(obj.getClass().getName());
    }

    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass());
    }

    public static String getShortCanonicalName(String str) {
        return getShortClassName(getCanonicalName(str));
    }

    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass());
    }

    public static String getSimpleName(Object obj) {
        return getSimpleName(obj, "");
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static String getCanonicalName(Object obj, String str) {
        String canonicalName;
        return (obj == null || (canonicalName = obj.getClass().getCanonicalName()) == null) ? str : canonicalName;
    }

    public static String getName(Object obj, String str) {
        return obj == null ? str : obj.getClass().getName();
    }

    public static String getPackageCanonicalName(String str) {
        return getPackageName(getCanonicalName(str));
    }

    public static String getPackageName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        while (str.charAt(0) == '[') {
            str = str.substring(1);
        }
        if (str.charAt(0) == 'L' && AbstractC0000a.m4a(1, str) == ';') {
            str = str.substring(1);
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : str.substring(0, iLastIndexOf);
    }

    public static String getShortClassName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append(XMPConst.ARRAY_ITEM_NAME);
            }
            if (str.charAt(0) == 'L' && AbstractC0000a.m4a(1, str) == ';') {
                str = AbstractC2322a.m1614d(1, 1, str);
            }
            Map<String, String> map = REVERSE_ABBREVIATION_MAP;
            if (map.containsKey(str)) {
                str = map.get(str);
            }
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iIndexOf = str.indexOf(36, iLastIndexOf != -1 ? iLastIndexOf + 1 : 0);
        String strSubstring = str.substring(iLastIndexOf + 1);
        if (iIndexOf != -1) {
            strSubstring = strSubstring.replace('$', '.');
        }
        return strSubstring + ((Object) sb);
    }

    public static String getSimpleName(Object obj, String str) {
        return obj == null ? str : obj.getClass().getSimpleName();
    }

    private static String getCanonicalName(String str) {
        String strDeleteWhitespace = StringUtils.deleteWhitespace(str);
        if (strDeleteWhitespace == null) {
            return null;
        }
        int i = 0;
        while (strDeleteWhitespace.charAt(i) == '[') {
            i++;
            if (i > 255) {
                throw new IllegalArgumentException(String.format("Maximum array dimension %d exceeded", 255));
            }
        }
        if (i < 1) {
            return strDeleteWhitespace;
        }
        String strSubstring = strDeleteWhitespace.substring(i);
        if (strSubstring.startsWith("L")) {
            strSubstring = strSubstring.substring(1, strSubstring.endsWith(";") ? strSubstring.length() - 1 : strSubstring.length());
        } else if (!strSubstring.isEmpty()) {
            strSubstring = REVERSE_ABBREVIATION_MAP.get(strSubstring.substring(0, 1));
        }
        StringBuilder sb = new StringBuilder((i * 2) + strSubstring.length());
        sb.append(strSubstring);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(XMPConst.ARRAY_ITEM_NAME);
        }
        return sb.toString();
    }

    public static Class<?> getClass(String str) {
        return getClass(str, true);
    }

    public static Class<?> getClass(String str, boolean z) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.class.getClassLoader();
        }
        return getClass(contextClassLoader, str, z);
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>... clsArr2) {
        return isAssignable(clsArr, clsArr2, true);
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!ArrayUtils.isSameLength((Object[]) clsArr, (Object[]) clsArr2)) {
            return false;
        }
        Class<?>[] clsArrNullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Class<?>[] clsArrNullToEmpty2 = ArrayUtils.nullToEmpty(clsArr2);
        for (int i = 0; i < clsArrNullToEmpty.length; i++) {
            if (!isAssignable(clsArrNullToEmpty[i], clsArrNullToEmpty2[i], z)) {
                return false;
            }
        }
        return true;
    }
}
