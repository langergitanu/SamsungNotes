package org.apache.commons.lang3;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.scs.p142ai.asr.C7690f;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.time.DurationUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ObjectUtils {
    private static final char AT_SIGN = '@';
    public static final Null NULL = new Null();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    @Deprecated
    public ObjectUtils() {
    }

    public static byte CONST(byte b) {
        return b;
    }

    public static byte CONST_BYTE(int i) {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Supplied value must be a valid byte literal between -128 and 127: [", "]"));
        }
        return (byte) i;
    }

    public static short CONST_SHORT(int i) {
        if (i < -32768 || i > 32767) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Supplied value must be a valid byte literal between -32768 and 32767: [", "]"));
        }
        return (short) i;
    }

    public static boolean allNotNull(Object... objArr) {
        return objArr != null && Stream.of(objArr).noneMatch(new C13790a(3));
    }

    public static boolean allNull(Object... objArr) {
        return !anyNotNull(objArr);
    }

    public static boolean anyNotNull(Object... objArr) {
        return firstNonNull(objArr) != null;
    }

    public static boolean anyNull(Object... objArr) {
        return !allNotNull(objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T clone(T t) {
        if (!(t instanceof Cloneable)) {
            return null;
        }
        Class<?> cls = t.getClass();
        if (!isArray(t)) {
            try {
                return (T) cls.getMethod("clone", null).invoke(t, null);
            } catch (ReflectiveOperationException e) {
                throw new CloneFailedException("Exception cloning Cloneable type ".concat(cls.getName()), e);
            }
        }
        Class<?> componentType = cls.getComponentType();
        if (!componentType.isPrimitive()) {
            return (T) ((Object[]) t).clone();
        }
        int length = Array.getLength(t);
        T t2 = (T) Array.newInstance(componentType, length);
        while (true) {
            int i = length - 1;
            if (length <= 0) {
                return t2;
            }
            Array.set(t2, i, Array.get(t, i));
            length = i;
        }
    }

    public static <T> T cloneIfPossible(T t) {
        T t2 = (T) clone(t);
        return t2 == null ? t : t2;
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2) {
        return compare(t, t2, false);
    }

    @Deprecated
    public static <T> T defaultIfNull(T t, T t2) {
        return (T) getIfNull(t, t2);
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    @SafeVarargs
    public static <T> T firstNonNull(T... tArr) {
        return org.apache.commons.lang3.stream.Streams.m14874of(tArr).filter(new C13790a(2)).findFirst().orElse(null);
    }

    public static <T> Class<T> getClass(T t) {
        if (t == null) {
            return null;
        }
        return (Class<T>) t.getClass();
    }

    @SafeVarargs
    public static <T> T getFirstNonNull(Supplier<T>... supplierArr) {
        return org.apache.commons.lang3.stream.Streams.m14874of(supplierArr).filter(new C13790a(4)).map(new C7690f(28)).filter(new C13790a(2)).findFirst().orElse(null);
    }

    public static <T> T getIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    @Deprecated
    public static int hashCode(Object obj) {
        return Objects.hashCode(obj);
    }

    public static String hashCodeHex(Object obj) {
        return Integer.toHexString(Objects.hashCode(obj));
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int iHashCode = 1;
        if (objArr != null) {
            for (Object obj : objArr) {
                iHashCode = (iHashCode * 31) + Objects.hashCode(obj);
            }
        }
        return iHashCode;
    }

    public static String identityHashCodeHex(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        Objects.requireNonNull(obj, CoeditServiceConstants.Element.NAME_OBJECT);
        appendable.append(obj.getClass().getName()).append(AT_SIGN).append(identityHashCodeHex(obj));
    }

    public static boolean isArray(Object obj) {
        return obj != null && obj.getClass().isArray();
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (isArray(obj)) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Optional) {
            return !((Optional) obj).isPresent();
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, false) > 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    @SafeVarargs
    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Objects.requireNonNull(comparator, "comparator");
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, true) < 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    @SafeVarargs
    public static <T> T mode(T... tArr) {
        if (!ArrayUtils.isNotEmpty(tArr)) {
            return null;
        }
        HashMap map = new HashMap(tArr.length);
        int i = 0;
        for (T t : tArr) {
            ArrayUtils.increment(map, t);
        }
        while (true) {
            T t2 = null;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((MutableInt) entry.getValue()).intValue();
                if (iIntValue == i) {
                    break;
                }
                if (iIntValue > i) {
                    t2 = (T) entry.getKey();
                    i = iIntValue;
                }
            }
            return t2;
        }
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !Objects.equals(obj, obj2);
    }

    public static <T> T requireNonEmpty(T t) {
        return (T) requireNonEmpty(t, CoeditServiceConstants.Element.NAME_OBJECT);
    }

    public static String toString(Object obj) {
        return Objects.toString(obj, "");
    }

    public static void wait(Object obj, Duration duration) {
        Objects.requireNonNull(obj);
        DurationUtils.accept(new C13929w(obj, 0), DurationUtils.zeroIfNull(duration));
    }

    public static char CONST(char c) {
        return c;
    }

    public static <T extends Comparable<? super T>> int compare(T t, T t2, boolean z) {
        if (t == t2) {
            return 0;
        }
        return t == null ? z ? 1 : -1 : t2 == null ? z ? -1 : 1 : t.compareTo(t2);
    }

    public static <T> T getIfNull(T t, Supplier<T> supplier) {
        return t != null ? t : (T) Suppliers.get(supplier);
    }

    public static <T> T requireNonEmpty(T t, String str) {
        Objects.requireNonNull(t, str);
        if (isEmpty(t)) {
            throw new IllegalArgumentException(str);
        }
        return t;
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        return Objects.toString(obj, str);
    }

    public static double CONST(double d) {
        return d;
    }

    public static String toString(Supplier<Object> supplier, Supplier<String> supplier2) {
        return supplier == null ? (String) Suppliers.get(supplier2) : toString(supplier.get(), supplier2);
    }

    public static float CONST(float f) {
        return f;
    }

    public static <T> String toString(T t, Supplier<String> supplier) {
        return t == null ? (String) Suppliers.get(supplier) : t.toString();
    }

    public static int CONST(int i) {
        return i;
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String strIdentityHashCodeHex = identityHashCodeHex(obj);
        StringBuilder sb = new StringBuilder(strIdentityHashCodeHex.length() + name.length() + 1);
        sb.append(name);
        sb.append(AT_SIGN);
        sb.append(strIdentityHashCodeHex);
        return sb.toString();
    }

    public static long CONST(long j) {
        return j;
    }

    public static <T> T CONST(T t) {
        return t;
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static short CONST(short s) {
        return s;
    }

    public static boolean CONST(boolean z) {
        return z;
    }

    @Deprecated
    public static void identityToString(StrBuilder strBuilder, Object obj) {
        Objects.requireNonNull(obj, CoeditServiceConstants.Element.NAME_OBJECT);
        String name = obj.getClass().getName();
        String strIdentityHashCodeHex = identityHashCodeHex(obj);
        strBuilder.ensureCapacity(strIdentityHashCodeHex.length() + AbstractC2821a.m2212c(strBuilder.length(), 1, name));
        strBuilder.append(name).append(AT_SIGN).append(strIdentityHashCodeHex);
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        Objects.requireNonNull(obj, CoeditServiceConstants.Element.NAME_OBJECT);
        String name = obj.getClass().getName();
        String strIdentityHashCodeHex = identityHashCodeHex(obj);
        stringBuffer.ensureCapacity(strIdentityHashCodeHex.length() + AbstractC2821a.m2212c(stringBuffer.length(), 1, name));
        stringBuffer.append(name);
        stringBuffer.append(AT_SIGN);
        stringBuffer.append(strIdentityHashCodeHex);
    }

    public static void identityToString(StringBuilder sb, Object obj) {
        Objects.requireNonNull(obj, CoeditServiceConstants.Element.NAME_OBJECT);
        String name = obj.getClass().getName();
        String strIdentityHashCodeHex = identityHashCodeHex(obj);
        sb.ensureCapacity(strIdentityHashCodeHex.length() + AbstractC2821a.m2212c(sb.length(), 1, name));
        sb.append(name);
        sb.append(AT_SIGN);
        sb.append(strIdentityHashCodeHex);
    }
}
