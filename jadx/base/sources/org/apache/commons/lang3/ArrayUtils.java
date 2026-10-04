package org.apache.commons.lang3;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.scs.p140ai.sdkcommon.asr.C7233a;
import com.samsung.android.vexfwk.sdk.bokeheffect.C11571a;
import com.samsung.scsp.framework.core.network.C11684e;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailableIntFunction;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.stream.IntStreams;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArrayUtils {
    public static final int INDEX_NOT_FOUND = -1;
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    public static final Field[] EMPTY_FIELD_ARRAY = new Field[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    public static final Method[] EMPTY_METHOD_ARRAY = new Method[0];
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Throwable[] EMPTY_THROWABLE_ARRAY = new Throwable[0];
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    @Deprecated
    public ArrayUtils() {
    }

    public static boolean[] add(boolean[] zArr, boolean z) {
        boolean[] zArr2 = (boolean[]) copyArrayGrow1(zArr, Boolean.TYPE);
        zArr2[zArr2.length - 1] = z;
        return zArr2;
    }

    public static boolean[] addAll(boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return clone(zArr2);
        }
        if (zArr2 == null) {
            return clone(zArr);
        }
        boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
        System.arraycopy(zArr, 0, zArr3, 0, zArr.length);
        System.arraycopy(zArr2, 0, zArr3, zArr.length, zArr2.length);
        return zArr3;
    }

    public static boolean[] addFirst(boolean[] zArr, boolean z) {
        return zArr == null ? add(zArr, z) : insert(0, zArr, z);
    }

    public static <T> T arraycopy(T t, int i, int i2, int i4, Function<Integer, T> function) {
        return (T) arraycopy(t, i, function.apply(Integer.valueOf(i4)), i2, i4);
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr != null) {
            return (boolean[]) zArr.clone();
        }
        return null;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        return indexOf(zArr, z) != -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean containsAny(int[] iArr, int... iArr2) {
        return IntStreams.m14866of(iArr2).anyMatch(new C11684e(iArr, 2));
    }

    private static Object copyArrayGrow1(Object obj, Class<?> cls) {
        if (obj == null) {
            return Array.newInstance(cls, 1);
        }
        int length = Array.getLength(obj);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
        System.arraycopy(obj, 0, objNewInstance, 0, length);
        return objNewInstance;
    }

    public static <T> T get(T[] tArr, int i) {
        return (T) get(tArr, i, null);
    }

    public static <T> Class<T> getComponentType(T[] tArr) {
        return ClassUtils.getComponentType(ObjectUtils.getClass(tArr));
    }

    public static int getLength(Object obj) {
        if (obj != null) {
            return Array.getLength(obj);
        }
        return 0;
    }

    public static int hashCode(Object obj) {
        return new HashCodeBuilder().append(obj).toHashCode();
    }

    public static <K> void increment(Map<K, MutableInt> map, K k) {
        map.computeIfAbsent(k, new C13791b(3)).increment();
    }

    public static int indexOf(boolean[] zArr, boolean z) {
        return indexOf(zArr, z, 0);
    }

    public static BitSet indexesOf(boolean[] zArr, boolean z) {
        return indexesOf(zArr, z, 0);
    }

    public static boolean[] insert(int i, boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return null;
        }
        if (isEmpty(zArr2)) {
            return clone(zArr);
        }
        if (i < 0 || i > zArr.length) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
            sbM778t.append(zArr.length);
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
        boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
        System.arraycopy(zArr2, 0, zArr3, i, zArr2.length);
        if (i > 0) {
            System.arraycopy(zArr, 0, zArr3, 0, i);
        }
        if (i < zArr.length) {
            System.arraycopy(zArr, i, zArr3, zArr2.length + i, zArr.length - i);
        }
        return zArr3;
    }

    private static boolean isArrayEmpty(Object obj) {
        return getLength(obj) == 0;
    }

    public static <T> boolean isArrayIndexValid(T[] tArr, int i) {
        return i >= 0 && getLength(tArr) > i;
    }

    public static boolean isEmpty(boolean[] zArr) {
        return isArrayEmpty(zArr);
    }

    @Deprecated
    public static boolean isEquals(Object obj, Object obj2) {
        return new EqualsBuilder().append(obj, obj2).isEquals();
    }

    public static boolean isNotEmpty(boolean[] zArr) {
        return !isEmpty(zArr);
    }

    public static boolean isSameLength(boolean[] zArr, boolean[] zArr2) {
        return getLength(zArr) == getLength(zArr2);
    }

    public static boolean isSameType(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        return obj.getClass().getName().equals(obj2.getClass().getName());
    }

    public static boolean isSorted(boolean[] zArr) {
        if (getLength(zArr) < 2) {
            return true;
        }
        boolean z = zArr[0];
        int length = zArr.length;
        int i = 1;
        while (i < length) {
            boolean z2 = zArr[i];
            if (BooleanUtils.compare(z, z2) > 0) {
                return false;
            }
            i++;
            z = z2;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$add$0(Class cls, int i) {
        return Array.newInstance((Class<?>) cls, i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object[] lambda$addAll$1(Class cls, Object[] objArr, Object[] objArr2) {
        return newInstance(cls, objArr.length + objArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MutableInt lambda$increment$4(Object obj) {
        return new MutableInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$map$5(FailableFunction failableFunction, Object[] objArr, int i) {
        return failableFunction.apply(objArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float[] lambda$subarray$10(int i) {
        return new float[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int[] lambda$subarray$11(int i) {
        return new int[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long[] lambda$subarray$12(int i) {
        return new long[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ short[] lambda$subarray$13(int i) {
        return new short[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean[] lambda$subarray$6(int i) {
        return new boolean[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] lambda$subarray$7(int i) {
        return new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ char[] lambda$subarray$8(int i) {
        return new char[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ double[] lambda$subarray$9(int i) {
        return new double[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$toObject$15(boolean[] zArr, int i) {
        return zArr[i] ? Boolean.TRUE : Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Byte lambda$toObject$16(byte[] bArr, int i) {
        return Byte.valueOf(bArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Character lambda$toObject$17(char[] cArr, int i) {
        return Character.valueOf(cArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toObject$18(double[] dArr, int i) {
        return Double.valueOf(dArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Float lambda$toObject$19(float[] fArr, int i) {
        return Float.valueOf(fArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$toObject$20(int[] iArr, int i) {
        return Integer.valueOf(iArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$toObject$21(long[] jArr, int i) {
        return Long.valueOf(jArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Short lambda$toObject$22(short[] sArr, int i) {
        return Short.valueOf(sArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$toStringArray$23(String str, Object obj) {
        return Objects.toString(obj, str);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z) {
        return lastIndexOf(zArr, z, Integer.MAX_VALUE);
    }

    private static <T, R, E extends Throwable> R[] map(T[] tArr, Class<R> cls, FailableFunction<? super T, ? extends R, E> failableFunction) {
        return (R[]) ArrayFill.fill(newInstance(cls, tArr.length), (FailableIntFunction) new C13883h(failableFunction, tArr, 0));
    }

    private static int max0(int i) {
        return Math.max(0, i);
    }

    public static <T> T[] newInstance(Class<T> cls, int i) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }

    public static <T> T[] nullTo(T[] tArr, T[] tArr2) {
        return isEmpty(tArr) ? tArr2 : tArr;
    }

    public static boolean[] nullToEmpty(boolean[] zArr) {
        return isEmpty(zArr) ? EMPTY_BOOLEAN_ARRAY : zArr;
    }

    private static ThreadLocalRandom random() {
        return ThreadLocalRandom.current();
    }

    public static boolean[] remove(boolean[] zArr, int i) {
        return (boolean[]) remove((Object) zArr, i);
    }

    public static boolean[] removeAll(boolean[] zArr, int... iArr) {
        return (boolean[]) removeAll((Object) zArr, iArr);
    }

    @Deprecated
    public static boolean[] removeAllOccurences(boolean[] zArr, boolean z) {
        return (boolean[]) removeAt(zArr, indexesOf(zArr, z));
    }

    public static boolean[] removeAllOccurrences(boolean[] zArr, boolean z) {
        return (boolean[]) removeAt(zArr, indexesOf(zArr, z));
    }

    public static Object removeAt(Object obj, BitSet bitSet) {
        if (obj == null) {
            return null;
        }
        int length = getLength(obj);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), length - bitSet.cardinality());
        int iNextClearBit = 0;
        int i = 0;
        while (true) {
            int iNextSetBit = bitSet.nextSetBit(iNextClearBit);
            if (iNextSetBit == -1) {
                break;
            }
            int i2 = iNextSetBit - iNextClearBit;
            if (i2 > 0) {
                System.arraycopy(obj, iNextClearBit, objNewInstance, i, i2);
                i += i2;
            }
            iNextClearBit = bitSet.nextClearBit(iNextSetBit);
        }
        int i4 = length - iNextClearBit;
        if (i4 > 0) {
            System.arraycopy(obj, iNextClearBit, objNewInstance, i, i4);
        }
        return objNewInstance;
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z) {
        int iIndexOf = indexOf(zArr, z);
        return iIndexOf == -1 ? clone(zArr) : remove(zArr, iIndexOf);
    }

    public static boolean[] removeElements(boolean[] zArr, boolean... zArr2) {
        if (isEmpty(zArr) || isEmpty(zArr2)) {
            return clone(zArr);
        }
        HashMap map = new HashMap(2);
        for (boolean z : zArr2) {
            increment(map, Boolean.valueOf(z));
        }
        BitSet bitSet = new BitSet();
        for (int i = 0; i < zArr.length; i++) {
            boolean z2 = zArr[i];
            MutableInt mutableInt = (MutableInt) map.get(Boolean.valueOf(z2));
            if (mutableInt != null) {
                if (mutableInt.decrementAndGet() == 0) {
                    map.remove(Boolean.valueOf(z2));
                }
                bitSet.set(i);
            }
        }
        return (boolean[]) removeAt(zArr, bitSet);
    }

    public static void reverse(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        reverse(zArr, 0, zArr.length);
    }

    public static <T> T[] setAll(T[] tArr, IntFunction<? extends T> intFunction) {
        if (tArr != null && intFunction != null) {
            Arrays.setAll(tArr, intFunction);
        }
        return tArr;
    }

    public static void shift(boolean[] zArr, int i) {
        if (zArr != null) {
            shift(zArr, 0, zArr.length, i);
        }
    }

    public static void shuffle(boolean[] zArr) {
        shuffle(zArr, random());
    }

    public static boolean startsWith(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr2.length > (length = bArr.length)) {
            return false;
        }
        if (bArr2.length == length) {
            return Arrays.equals(bArr, bArr2);
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean[] subarray(boolean[] zArr, int i, int i2) {
        if (zArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, zArr.length) - iMax0;
        return iMin <= 0 ? EMPTY_BOOLEAN_ARRAY : (boolean[]) arraycopy(zArr, iMax0, 0, iMin, new C13791b(8));
    }

    public static void swap(boolean[] zArr, int i, int i2) {
        swap(zArr, i, i2, 1);
    }

    public static Map<Object, Object> toMap(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        HashMap map = new HashMap((int) (((double) objArr.length) * 1.5d));
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                map.put(entry.getKey(), entry.getValue());
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalArgumentException("Array element " + i + ", '" + obj + "', is neither of type Map.Entry nor an Array");
                }
                Object[] objArr2 = (Object[]) obj;
                if (objArr2.length < 2) {
                    throw new IllegalArgumentException("Array element " + i + ", '" + obj + "', has a length less than 2");
                }
                map.put(objArr2[0], objArr2[1]);
            }
        }
        return map;
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return zArr.length == 0 ? EMPTY_BOOLEAN_OBJECT_ARRAY : (Boolean[]) setAll(new Boolean[zArr.length], new C13831e(zArr, 3));
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        return toPrimitive(boolArr, false);
    }

    public static String toString(Object obj) {
        return toString(obj, "{}");
    }

    public static String[] toStringArray(Object[] objArr) {
        return toStringArray(objArr, "null");
    }

    public static byte[] addFirst(byte[] bArr, byte b) {
        return bArr == null ? add(bArr, b) : insert(0, bArr, b);
    }

    public static <T> T arraycopy(T t, int i, int i2, int i4, Supplier<T> supplier) {
        return (T) arraycopy(t, i, supplier.get(), i2, i4);
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public static boolean contains(byte[] bArr, byte b) {
        return indexOf(bArr, b) != -1;
    }

    public static boolean containsAny(Object[] objArr, Object... objArr2) {
        return org.apache.commons.lang3.stream.Streams.m14874of(objArr2).anyMatch(new C7233a(objArr, 11));
    }

    public static <T> T get(T[] tArr, int i, T t) {
        return isArrayIndexValid(tArr, i) ? tArr[i] : t;
    }

    public static int indexOf(boolean[] zArr, boolean z, int i) {
        if (isEmpty(zArr)) {
            return -1;
        }
        for (int iMax0 = max0(i); iMax0 < zArr.length; iMax0++) {
            if (z == zArr[iMax0]) {
                return iMax0;
            }
        }
        return -1;
    }

    public static BitSet indexesOf(boolean[] zArr, boolean z, int i) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (zArr != null) {
            while (i < zArr.length && (iIndexOf = indexOf(zArr, z, i)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static boolean isEmpty(byte[] bArr) {
        return isArrayEmpty(bArr);
    }

    public static boolean isNotEmpty(byte[] bArr) {
        return !isEmpty(bArr);
    }

    public static boolean isSameLength(byte[] bArr, byte[] bArr2) {
        return getLength(bArr) == getLength(bArr2);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z, int i) {
        if (!isEmpty(zArr) && i >= 0) {
            if (i >= zArr.length) {
                i = zArr.length - 1;
            }
            while (i >= 0) {
                if (z == zArr[i]) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static Boolean[] nullToEmpty(Boolean[] boolArr) {
        return (Boolean[]) nullTo(boolArr, EMPTY_BOOLEAN_OBJECT_ARRAY);
    }

    public static byte[] remove(byte[] bArr, int i) {
        return (byte[]) remove((Object) bArr, i);
    }

    public static byte[] removeAll(byte[] bArr, int... iArr) {
        return (byte[]) removeAll((Object) bArr, iArr);
    }

    @Deprecated
    public static byte[] removeAllOccurences(byte[] bArr, byte b) {
        return (byte[]) removeAt(bArr, indexesOf(bArr, b));
    }

    public static byte[] removeAllOccurrences(byte[] bArr, byte b) {
        return (byte[]) removeAt(bArr, indexesOf(bArr, b));
    }

    public static void reverse(boolean[] zArr, int i, int i2) {
        if (zArr == null) {
            return;
        }
        int iMin = Math.min(zArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            boolean z = zArr[iMin];
            zArr[iMin] = zArr[iMax];
            zArr[iMax] = z;
            iMin--;
        }
    }

    public static <T> T[] setAll(T[] tArr, Supplier<? extends T> supplier) {
        if (tArr != null && supplier != null) {
            for (int i = 0; i < tArr.length; i++) {
                tArr[i] = supplier.get();
            }
        }
        return tArr;
    }

    public static void shift(boolean[] zArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (zArr == null || i >= zArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, zArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(zArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 >= i6) {
                swap(zArr, iMax0, i6 + iMax0, i5);
                return;
            } else {
                swap(zArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            }
        }
    }

    public static void shuffle(boolean[] zArr, Random random) {
        for (int length = zArr.length; length > 1; length--) {
            swap(zArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static void swap(boolean[] zArr, int i, int i2, int i4) {
        if (isEmpty(zArr) || i >= zArr.length || i2 >= zArr.length) {
            return;
        }
        int iMax0 = max0(i);
        int iMax02 = max0(i2);
        int iMin = Math.min(Math.min(i4, zArr.length - iMax0), zArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            boolean z = zArr[iMax0];
            zArr[iMax0] = zArr[iMax02];
            zArr[iMax02] = z;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            Boolean bool = boolArr[i];
            zArr[i] = bool == null ? z : bool.booleanValue();
        }
        return zArr;
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : new ToStringBuilder(obj, ToStringStyle.SIMPLE_STYLE).append(obj).toString();
    }

    public static String[] toStringArray(Object[] objArr, final String str) {
        if (objArr == null) {
            return null;
        }
        return objArr.length == 0 ? EMPTY_STRING_ARRAY : (String[]) map(objArr, String.class, new FailableFunction() { // from class: org.apache.commons.lang3.f
            @Override // org.apache.commons.lang3.function.FailableFunction
            public final Object apply(Object obj) {
                return ArrayUtils.lambda$toStringArray$23(str, obj);
            }
        });
    }

    @Deprecated
    public static boolean[] add(boolean[] zArr, int i, boolean z) {
        return (boolean[]) add(zArr, i, Boolean.valueOf(z), Boolean.TYPE);
    }

    public static char[] addFirst(char[] cArr, char c) {
        return cArr == null ? add(cArr, c) : insert(0, cArr, c);
    }

    public static <T> T arraycopy(T t, int i, T t2, int i2, int i4) {
        System.arraycopy(t, i, t2, i2, i4);
        return t2;
    }

    public static char[] clone(char[] cArr) {
        if (cArr != null) {
            return (char[]) cArr.clone();
        }
        return null;
    }

    public static boolean contains(char[] cArr, char c) {
        return indexOf(cArr, c) != -1;
    }

    public static boolean isEmpty(char[] cArr) {
        return isArrayEmpty(cArr);
    }

    public static boolean isNotEmpty(char[] cArr) {
        return !isEmpty(cArr);
    }

    public static boolean isSameLength(char[] cArr, char[] cArr2) {
        return getLength(cArr) == getLength(cArr2);
    }

    public static byte[] nullToEmpty(byte[] bArr) {
        return isEmpty(bArr) ? EMPTY_BYTE_ARRAY : bArr;
    }

    public static char[] remove(char[] cArr, int i) {
        return (char[]) remove((Object) cArr, i);
    }

    public static char[] removeAll(char[] cArr, int... iArr) {
        return (char[]) removeAll((Object) cArr, iArr);
    }

    @Deprecated
    public static char[] removeAllOccurences(char[] cArr, char c) {
        return (char[]) removeAt(cArr, indexesOf(cArr, c));
    }

    public static char[] removeAllOccurrences(char[] cArr, char c) {
        return (char[]) removeAt(cArr, indexesOf(cArr, c));
    }

    public static byte[] removeElement(byte[] bArr, byte b) {
        int iIndexOf = indexOf(bArr, b);
        return iIndexOf == -1 ? clone(bArr) : remove(bArr, iIndexOf);
    }

    public static byte[] add(byte[] bArr, byte b) {
        byte[] bArr2 = (byte[]) copyArrayGrow1(bArr, Byte.TYPE);
        bArr2[bArr2.length - 1] = b;
        return bArr2;
    }

    public static double[] addFirst(double[] dArr, double d) {
        return dArr == null ? add(dArr, d) : insert(0, dArr, d);
    }

    public static double[] clone(double[] dArr) {
        if (dArr != null) {
            return (double[]) dArr.clone();
        }
        return null;
    }

    public static boolean contains(double[] dArr, double d) {
        return indexOf(dArr, d) != -1;
    }

    public static boolean isEmpty(double[] dArr) {
        return isArrayEmpty(dArr);
    }

    public static boolean isNotEmpty(double[] dArr) {
        return !isEmpty(dArr);
    }

    public static boolean isSameLength(double[] dArr, double[] dArr2) {
        return getLength(dArr) == getLength(dArr2);
    }

    public static Byte[] nullToEmpty(Byte[] bArr) {
        return (Byte[]) nullTo(bArr, EMPTY_BYTE_OBJECT_ARRAY);
    }

    public static double[] remove(double[] dArr, int i) {
        return (double[]) remove((Object) dArr, i);
    }

    public static double[] removeAll(double[] dArr, int... iArr) {
        return (double[]) removeAll((Object) dArr, iArr);
    }

    @Deprecated
    public static double[] removeAllOccurences(double[] dArr, double d) {
        return (double[]) removeAt(dArr, indexesOf(dArr, d));
    }

    public static double[] removeAllOccurrences(double[] dArr, double d) {
        return (double[]) removeAt(dArr, indexesOf(dArr, d));
    }

    public static void shuffle(byte[] bArr) {
        shuffle(bArr, (Random) random());
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        return (Byte[]) setAll(new Byte[bArr.length], new C13831e(bArr, 7));
    }

    public static float[] addFirst(float[] fArr, float f) {
        return fArr == null ? add(fArr, f) : insert(0, fArr, f);
    }

    public static float[] clone(float[] fArr) {
        if (fArr != null) {
            return (float[]) fArr.clone();
        }
        return null;
    }

    public static boolean contains(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2) != -1;
    }

    public static int indexOf(byte[] bArr, byte b) {
        return indexOf(bArr, b, 0);
    }

    public static boolean isEmpty(float[] fArr) {
        return isArrayEmpty(fArr);
    }

    public static boolean isNotEmpty(float[] fArr) {
        return !isEmpty(fArr);
    }

    public static boolean isSameLength(float[] fArr, float[] fArr2) {
        return getLength(fArr) == getLength(fArr2);
    }

    public static char[] nullToEmpty(char[] cArr) {
        return isEmpty(cArr) ? EMPTY_CHAR_ARRAY : cArr;
    }

    public static float[] remove(float[] fArr, int i) {
        return (float[]) remove((Object) fArr, i);
    }

    public static float[] removeAll(float[] fArr, int... iArr) {
        return (float[]) removeAll((Object) fArr, iArr);
    }

    @Deprecated
    public static float[] removeAllOccurences(float[] fArr, float f) {
        return (float[]) removeAt(fArr, indexesOf(fArr, f));
    }

    public static float[] removeAllOccurrences(float[] fArr, float f) {
        return (float[]) removeAt(fArr, indexesOf(fArr, f));
    }

    public static char[] removeElement(char[] cArr, char c) {
        int iIndexOf = indexOf(cArr, c);
        return iIndexOf == -1 ? clone(cArr) : remove(cArr, iIndexOf);
    }

    public static void shuffle(byte[] bArr, Random random) {
        for (int length = bArr.length; length > 1; length--) {
            swap(bArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static byte[] subarray(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, bArr.length) - iMax0;
        if (iMin <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        return (byte[]) arraycopy(bArr, iMax0, 0, iMin, new C13791b(6));
    }

    @Deprecated
    public static byte[] add(byte[] bArr, int i, byte b) {
        return (byte[]) add(bArr, i, Byte.valueOf(b), Byte.TYPE);
    }

    public static byte[] addAll(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int[] addFirst(int[] iArr, int i) {
        return iArr == null ? add(iArr, i) : insert(0, iArr, i);
    }

    public static int[] clone(int[] iArr) {
        if (iArr != null) {
            return (int[]) iArr.clone();
        }
        return null;
    }

    public static boolean contains(float[] fArr, float f) {
        return indexOf(fArr, f) != -1;
    }

    public static int indexOf(byte[] bArr, byte b, int i) {
        if (bArr == null) {
            return -1;
        }
        for (int iMax0 = max0(i); iMax0 < bArr.length; iMax0++) {
            if (b == bArr[iMax0]) {
                return iMax0;
            }
        }
        return -1;
    }

    public static BitSet indexesOf(byte[] bArr, byte b) {
        return indexesOf(bArr, b, 0);
    }

    public static boolean isEmpty(int[] iArr) {
        return isArrayEmpty(iArr);
    }

    public static boolean isNotEmpty(int[] iArr) {
        return !isEmpty(iArr);
    }

    public static boolean isSameLength(int[] iArr, int[] iArr2) {
        return getLength(iArr) == getLength(iArr2);
    }

    public static boolean isSorted(byte[] bArr) {
        if (getLength(bArr) < 2) {
            return true;
        }
        byte b = bArr[0];
        int length = bArr.length;
        int i = 1;
        while (i < length) {
            byte b5 = bArr[i];
            if (NumberUtils.compare(b, b5) > 0) {
                return false;
            }
            i++;
            b = b5;
        }
        return true;
    }

    public static int lastIndexOf(byte[] bArr, byte b) {
        return lastIndexOf(bArr, b, Integer.MAX_VALUE);
    }

    public static Character[] nullToEmpty(Character[] chArr) {
        return (Character[]) nullTo(chArr, EMPTY_CHARACTER_OBJECT_ARRAY);
    }

    public static int[] remove(int[] iArr, int i) {
        return (int[]) remove((Object) iArr, i);
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        return (int[]) removeAll((Object) iArr, iArr2);
    }

    @Deprecated
    public static int[] removeAllOccurences(int[] iArr, int i) {
        return (int[]) removeAt(iArr, indexesOf(iArr, i));
    }

    public static int[] removeAllOccurrences(int[] iArr, int i) {
        return (int[]) removeAt(iArr, indexesOf(iArr, i));
    }

    public static char[] add(char[] cArr, char c) {
        char[] cArr2 = (char[]) copyArrayGrow1(cArr, Character.TYPE);
        cArr2[cArr2.length - 1] = c;
        return cArr2;
    }

    public static long[] addFirst(long[] jArr, long j) {
        return jArr == null ? add(jArr, j) : insert(0, jArr, j);
    }

    public static long[] clone(long[] jArr) {
        if (jArr != null) {
            return (long[]) jArr.clone();
        }
        return null;
    }

    public static boolean contains(int[] iArr, int i) {
        return indexOf(iArr, i) != -1;
    }

    public static BitSet indexesOf(byte[] bArr, byte b, int i) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (bArr != null) {
            while (i < bArr.length && (iIndexOf = indexOf(bArr, b, i)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static boolean isEmpty(long[] jArr) {
        return isArrayEmpty(jArr);
    }

    public static boolean isNotEmpty(long[] jArr) {
        return !isEmpty(jArr);
    }

    public static boolean isSameLength(long[] jArr, long[] jArr2) {
        return getLength(jArr) == getLength(jArr2);
    }

    public static int lastIndexOf(byte[] bArr, byte b, int i) {
        if (bArr != null && i >= 0) {
            if (i >= bArr.length) {
                i = bArr.length - 1;
            }
            while (i >= 0) {
                if (b == bArr[i]) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        return (Class[]) nullTo(clsArr, EMPTY_CLASS_ARRAY);
    }

    public static long[] remove(long[] jArr, int i) {
        return (long[]) remove((Object) jArr, i);
    }

    public static long[] removeAll(long[] jArr, int... iArr) {
        return (long[]) removeAll((Object) jArr, iArr);
    }

    @Deprecated
    public static long[] removeAllOccurences(long[] jArr, long j) {
        return (long[]) removeAt(jArr, indexesOf(jArr, j));
    }

    public static long[] removeAllOccurrences(long[] jArr, long j) {
        return (long[]) removeAt(jArr, indexesOf(jArr, j));
    }

    public static double[] removeElement(double[] dArr, double d) {
        int iIndexOf = indexOf(dArr, d);
        return iIndexOf == -1 ? clone(dArr) : remove(dArr, iIndexOf);
    }

    public static void reverse(byte[] bArr) {
        if (bArr != null) {
            reverse(bArr, 0, bArr.length);
        }
    }

    public static void shuffle(char[] cArr) {
        shuffle(cArr, (Random) random());
    }

    public static Character[] toObject(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        return (Character[]) setAll(new Character[cArr.length], new C13831e(cArr, 1));
    }

    public static short[] addFirst(short[] sArr, short s) {
        return sArr == null ? add(sArr, s) : insert(0, sArr, s);
    }

    public static short[] clone(short[] sArr) {
        if (sArr != null) {
            return (short[]) sArr.clone();
        }
        return null;
    }

    public static boolean contains(long[] jArr, long j) {
        return indexOf(jArr, j) != -1;
    }

    public static int indexOf(char[] cArr, char c) {
        return indexOf(cArr, c, 0);
    }

    public static boolean isEmpty(Object[] objArr) {
        return isArrayEmpty(objArr);
    }

    public static boolean isNotEmpty(short[] sArr) {
        return !isEmpty(sArr);
    }

    public static boolean isSameLength(Object obj, Object obj2) {
        return getLength(obj) == getLength(obj2);
    }

    public static double[] nullToEmpty(double[] dArr) {
        return isEmpty(dArr) ? EMPTY_DOUBLE_ARRAY : dArr;
    }

    private static Object remove(Object obj, int i) {
        int length = getLength(obj);
        if (i >= 0 && i < length) {
            int i2 = length - 1;
            Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), i2);
            System.arraycopy(obj, 0, objNewInstance, 0, i);
            if (i < i2) {
                System.arraycopy(obj, i + 1, objNewInstance, i, (length - i) - 1);
            }
            return objNewInstance;
        }
        throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i, length, "Index: ", ", Length: "));
    }

    public static Object removeAll(Object obj, int... iArr) {
        int i;
        int i2;
        if (obj == null) {
            return null;
        }
        int length = getLength(obj);
        int[] iArrSort = ArraySorter.sort(clone(iArr));
        if (isNotEmpty(iArrSort)) {
            int length2 = iArrSort.length;
            int i4 = length;
            i = 0;
            while (true) {
                length2--;
                if (length2 < 0) {
                    break;
                }
                i2 = iArrSort[length2];
                if (i2 < 0 || i2 >= length) {
                    break;
                }
                if (i2 < i4) {
                    i++;
                    i4 = i2;
                }
            }
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i2, length, "Index: ", ", Length: "));
        }
        i = 0;
        int i5 = length - i;
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), i5);
        if (i < length && iArrSort != null) {
            int length3 = iArrSort.length - 1;
            while (length3 >= 0) {
                int i6 = iArrSort[length3];
                int i7 = length - i6;
                if (i7 > 1) {
                    int i8 = i7 - 1;
                    i5 -= i8;
                    System.arraycopy(obj, i6 + 1, objNewInstance, i5, i8);
                }
                length3--;
                length = i6;
            }
            if (length > 0) {
                System.arraycopy(obj, 0, objNewInstance, 0, length);
            }
        }
        return objNewInstance;
    }

    @Deprecated
    public static short[] removeAllOccurences(short[] sArr, short s) {
        return (short[]) removeAt(sArr, indexesOf(sArr, s));
    }

    public static short[] removeAllOccurrences(short[] sArr, short s) {
        return (short[]) removeAt(sArr, indexesOf(sArr, s));
    }

    public static void reverse(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return;
        }
        int iMin = Math.min(bArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            byte b = bArr[iMin];
            bArr[iMin] = bArr[iMax];
            bArr[iMax] = b;
            iMin--;
        }
    }

    public static void shuffle(char[] cArr, Random random) {
        for (int length = cArr.length; length > 1; length--) {
            swap(cArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    @Deprecated
    public static char[] add(char[] cArr, int i, char c) {
        return (char[]) add(cArr, i, Character.valueOf(c), Character.TYPE);
    }

    public static <T> T[] addFirst(T[] tArr, T t) {
        return tArr == null ? (T[]) add(tArr, t) : (T[]) insert(0, tArr, t);
    }

    public static <T> T[] clone(T[] tArr) {
        if (tArr != null) {
            return (T[]) ((Object[]) tArr.clone());
        }
        return null;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static int indexOf(char[] cArr, char c, int i) {
        if (cArr == null) {
            return -1;
        }
        for (int iMax0 = max0(i); iMax0 < cArr.length; iMax0++) {
            if (c == cArr[iMax0]) {
                return iMax0;
            }
        }
        return -1;
    }

    public static boolean isEmpty(short[] sArr) {
        return isArrayEmpty(sArr);
    }

    public static <T> boolean isNotEmpty(T[] tArr) {
        return !isEmpty(tArr);
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        return getLength(objArr) == getLength(objArr2);
    }

    public static Double[] nullToEmpty(Double[] dArr) {
        return (Double[]) nullTo(dArr, EMPTY_DOUBLE_OBJECT_ARRAY);
    }

    @Deprecated
    public static <T> T[] removeAllOccurences(T[] tArr, T t) {
        return (T[]) ((Object[]) removeAt(tArr, indexesOf(tArr, t)));
    }

    public static <T> T[] removeAllOccurrences(T[] tArr, T t) {
        return (T[]) ((Object[]) removeAt(tArr, indexesOf(tArr, t)));
    }

    public static float[] removeElement(float[] fArr, float f) {
        int iIndexOf = indexOf(fArr, f);
        return iIndexOf == -1 ? clone(fArr) : remove(fArr, iIndexOf);
    }

    public static void shift(byte[] bArr, int i) {
        if (bArr != null) {
            shift(bArr, 0, bArr.length, i);
        }
    }

    public static char[] subarray(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, cArr.length) - iMax0;
        if (iMin <= 0) {
            return EMPTY_CHAR_ARRAY;
        }
        return (char[]) arraycopy(cArr, iMax0, 0, iMin, new C13791b(9));
    }

    public static void swap(byte[] bArr, int i, int i2) {
        swap(bArr, i, i2, 1);
    }

    public static double[] add(double[] dArr, double d) {
        double[] dArr2 = (double[]) copyArrayGrow1(dArr, Double.TYPE);
        dArr2[dArr2.length - 1] = d;
        return dArr2;
    }

    public static boolean contains(short[] sArr, short s) {
        return indexOf(sArr, s) != -1;
    }

    public static boolean isSameLength(short[] sArr, short[] sArr2) {
        return getLength(sArr) == getLength(sArr2);
    }

    public static int lastIndexOf(char[] cArr, char c) {
        return lastIndexOf(cArr, c, Integer.MAX_VALUE);
    }

    public static float[] nullToEmpty(float[] fArr) {
        return isEmpty(fArr) ? EMPTY_FLOAT_ARRAY : fArr;
    }

    public static void shift(byte[] bArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (bArr == null || i >= bArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, bArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(bArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 < i6) {
                swap(bArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            } else {
                swap(bArr, iMax0, i6 + iMax0, i5);
                return;
            }
        }
    }

    public static void shuffle(double[] dArr) {
        shuffle(dArr, random());
    }

    public static void swap(byte[] bArr, int i, int i2, int i4) {
        if (isEmpty(bArr) || i >= bArr.length || i2 >= bArr.length) {
            return;
        }
        int iMax0 = max0(i);
        int iMax02 = max0(i2);
        int iMin = Math.min(Math.min(i4, bArr.length - iMax0), bArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            byte b = bArr[iMax0];
            bArr[iMax0] = bArr[iMax02];
            bArr[iMax02] = b;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        return (Double[]) setAll(new Double[dArr.length], new C13831e(dArr, 4));
    }

    public static char[] addAll(char[] cArr, char... cArr2) {
        if (cArr == null) {
            return clone(cArr2);
        }
        if (cArr2 == null) {
            return clone(cArr);
        }
        char[] cArr3 = new char[cArr.length + cArr2.length];
        System.arraycopy(cArr, 0, cArr3, 0, cArr.length);
        System.arraycopy(cArr2, 0, cArr3, cArr.length, cArr2.length);
        return cArr3;
    }

    public static int indexOf(double[] dArr, double d) {
        return indexOf(dArr, d, 0);
    }

    public static BitSet indexesOf(char[] cArr, char c) {
        return indexesOf(cArr, c, 0);
    }

    public static boolean isSorted(char[] cArr) {
        if (getLength(cArr) < 2) {
            return true;
        }
        char c = cArr[0];
        int length = cArr.length;
        int i = 1;
        while (i < length) {
            char c2 = cArr[i];
            if (CharUtils.compare(c, c2) > 0) {
                return false;
            }
            i++;
            c = c2;
        }
        return true;
    }

    public static int lastIndexOf(char[] cArr, char c, int i) {
        if (cArr != null && i >= 0) {
            if (i >= cArr.length) {
                i = cArr.length - 1;
            }
            while (i >= 0) {
                if (c == cArr[i]) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static Float[] nullToEmpty(Float[] fArr) {
        return (Float[]) nullTo(fArr, EMPTY_FLOAT_OBJECT_ARRAY);
    }

    public static int[] removeElement(int[] iArr, int i) {
        int iIndexOf = indexOf(iArr, i);
        return iIndexOf == -1 ? clone(iArr) : remove(iArr, iIndexOf);
    }

    public static void shuffle(double[] dArr, Random random) {
        for (int length = dArr.length; length > 1; length--) {
            swap(dArr, length - 1, random.nextInt(length), 1);
        }
    }

    @Deprecated
    public static double[] add(double[] dArr, int i, double d) {
        return (double[]) add(dArr, i, Double.valueOf(d), Double.TYPE);
    }

    public static int indexOf(double[] dArr, double d, double d2) {
        return indexOf(dArr, d, 0, d2);
    }

    public static BitSet indexesOf(char[] cArr, char c, int i) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (cArr != null) {
            while (i < cArr.length && (iIndexOf = indexOf(cArr, c, i)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static int[] nullToEmpty(int[] iArr) {
        return isEmpty(iArr) ? EMPTY_INT_ARRAY : iArr;
    }

    public static float[] add(float[] fArr, float f) {
        float[] fArr2 = (float[]) copyArrayGrow1(fArr, Float.TYPE);
        fArr2[fArr2.length - 1] = f;
        return fArr2;
    }

    public static int indexOf(double[] dArr, double d, int i) {
        if (isEmpty(dArr)) {
            return -1;
        }
        boolean zIsNaN = Double.isNaN(d);
        for (int iMax0 = max0(i); iMax0 < dArr.length; iMax0++) {
            double d2 = dArr[iMax0];
            if (d == d2 || (zIsNaN && Double.isNaN(d2))) {
                return iMax0;
            }
        }
        return -1;
    }

    public static Integer[] nullToEmpty(Integer[] numArr) {
        return (Integer[]) nullTo(numArr, EMPTY_INTEGER_OBJECT_ARRAY);
    }

    public static long[] removeElement(long[] jArr, long j) {
        int iIndexOf = indexOf(jArr, j);
        return iIndexOf == -1 ? clone(jArr) : remove(jArr, iIndexOf);
    }

    public static void reverse(char[] cArr) {
        if (cArr != null) {
            reverse(cArr, 0, cArr.length);
        }
    }

    public static void shuffle(float[] fArr) {
        shuffle(fArr, (Random) random());
    }

    public static double[] subarray(double[] dArr, int i, int i2) {
        if (dArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, dArr.length) - iMax0;
        if (iMin <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return (double[]) arraycopy(dArr, iMax0, 0, iMin, new C13791b(5));
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        return (Float[]) setAll(new Float[fArr.length], new C13831e(fArr, 0));
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            Byte b5 = bArr[i];
            bArr2[i] = b5 == null ? b : b5.byteValue();
        }
        return bArr2;
    }

    public static int lastIndexOf(double[] dArr, double d) {
        return lastIndexOf(dArr, d, Integer.MAX_VALUE);
    }

    public static long[] nullToEmpty(long[] jArr) {
        return isEmpty(jArr) ? EMPTY_LONG_ARRAY : jArr;
    }

    public static byte[] removeElements(byte[] bArr, byte... bArr2) {
        if (!isEmpty(bArr) && !isEmpty(bArr2)) {
            HashMap map = new HashMap(bArr2.length);
            for (byte b : bArr2) {
                increment(map, Byte.valueOf(b));
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < bArr.length; i++) {
                byte b5 = bArr[i];
                MutableInt mutableInt = (MutableInt) map.get(Byte.valueOf(b5));
                if (mutableInt != null) {
                    if (mutableInt.decrementAndGet() == 0) {
                        map.remove(Byte.valueOf(b5));
                    }
                    bitSet.set(i);
                }
            }
            return (byte[]) removeAt(bArr, bitSet);
        }
        return clone(bArr);
    }

    public static void reverse(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return;
        }
        int iMin = Math.min(cArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            char c = cArr[iMin];
            cArr[iMin] = cArr[iMax];
            cArr[iMax] = c;
            iMin--;
        }
    }

    public static void shuffle(float[] fArr, Random random) {
        for (int length = fArr.length; length > 1; length--) {
            swap(fArr, length - 1, random.nextInt(length), 1);
        }
    }

    @Deprecated
    public static float[] add(float[] fArr, int i, float f) {
        return (float[]) add(fArr, i, Float.valueOf(f), Float.TYPE);
    }

    public static int lastIndexOf(double[] dArr, double d, double d2) {
        return lastIndexOf(dArr, d, Integer.MAX_VALUE, d2);
    }

    public static Long[] nullToEmpty(Long[] lArr) {
        return (Long[]) nullTo(lArr, EMPTY_LONG_OBJECT_ARRAY);
    }

    public static short[] removeElement(short[] sArr, short s) {
        int iIndexOf = indexOf(sArr, s);
        return iIndexOf == -1 ? clone(sArr) : remove(sArr, iIndexOf);
    }

    public static int[] add(int[] iArr, int i) {
        int[] iArr2 = (int[]) copyArrayGrow1(iArr, Integer.TYPE);
        iArr2[iArr2.length - 1] = i;
        return iArr2;
    }

    public static double[] addAll(double[] dArr, double... dArr2) {
        if (dArr == null) {
            return clone(dArr2);
        }
        if (dArr2 == null) {
            return clone(dArr);
        }
        double[] dArr3 = new double[dArr.length + dArr2.length];
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr3, dArr.length, dArr2.length);
        return dArr3;
    }

    public static BitSet indexesOf(double[] dArr, double d) {
        return indexesOf(dArr, d, 0);
    }

    public static byte[] insert(int i, byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return null;
        }
        if (isEmpty(bArr2)) {
            return clone(bArr);
        }
        if (i >= 0 && i <= bArr.length) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr2, 0, bArr3, i, bArr2.length);
            if (i > 0) {
                System.arraycopy(bArr, 0, bArr3, 0, i);
            }
            if (i < bArr.length) {
                System.arraycopy(bArr, i, bArr3, bArr2.length + i, bArr.length - i);
            }
            return bArr3;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
        sbM778t.append(bArr.length);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public static boolean isSorted(double[] dArr) {
        if (getLength(dArr) < 2) {
            return true;
        }
        double d = dArr[0];
        int length = dArr.length;
        int i = 1;
        while (i < length) {
            double d2 = dArr[i];
            if (Double.compare(d, d2) > 0) {
                return false;
            }
            i++;
            d = d2;
        }
        return true;
    }

    public static int lastIndexOf(double[] dArr, double d, int i) {
        if (!isEmpty(dArr) && i >= 0) {
            if (i >= dArr.length) {
                i = dArr.length - 1;
            }
            while (i >= 0) {
                if (d == dArr[i]) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        return nullTo(objArr, EMPTY_OBJECT_ARRAY);
    }

    public static void shuffle(int[] iArr) {
        shuffle(iArr, (Random) random());
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        return (Integer[]) setAll(new Integer[iArr.length], new C13831e(iArr, 2));
    }

    public static BitSet indexesOf(double[] dArr, double d, double d2) {
        return indexesOf(dArr, d, 0, d2);
    }

    public static short[] nullToEmpty(short[] sArr) {
        return isEmpty(sArr) ? EMPTY_SHORT_ARRAY : sArr;
    }

    public static <T> T[] removeElement(T[] tArr, Object obj) {
        int iIndexOf = indexOf(tArr, obj);
        return iIndexOf == -1 ? (T[]) clone(tArr) : (T[]) remove((Object[]) tArr, iIndexOf);
    }

    public static void shift(char[] cArr, int i) {
        if (cArr != null) {
            shift(cArr, 0, cArr.length, i);
        }
    }

    public static void shuffle(int[] iArr, Random random) {
        for (int length = iArr.length; length > 1; length--) {
            swap(iArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static float[] subarray(float[] fArr, int i, int i2) {
        if (fArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, fArr.length) - iMax0;
        if (iMin <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        return (float[]) arraycopy(fArr, iMax0, 0, iMin, new C13791b(2));
    }

    public static void swap(char[] cArr, int i, int i2) {
        swap(cArr, i, i2, 1);
    }

    @Deprecated
    public static int[] add(int[] iArr, int i, int i2) {
        return (int[]) add(iArr, i, Integer.valueOf(i2), Integer.TYPE);
    }

    public static int indexOf(double[] dArr, double d, int i, double d2) {
        if (isEmpty(dArr)) {
            return -1;
        }
        double d3 = d - d2;
        double d4 = d + d2;
        for (int iMax0 = max0(i); iMax0 < dArr.length; iMax0++) {
            double d5 = dArr[iMax0];
            if (d5 >= d3 && d5 <= d4) {
                return iMax0;
            }
        }
        return -1;
    }

    public static BitSet indexesOf(double[] dArr, double d, int i) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (dArr != null) {
            while (i < dArr.length && (iIndexOf = indexOf(dArr, d, i)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static Short[] nullToEmpty(Short[] shArr) {
        return (Short[]) nullTo(shArr, EMPTY_SHORT_OBJECT_ARRAY);
    }

    public static void shift(char[] cArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (cArr == null || i >= cArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, cArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(cArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 < i6) {
                swap(cArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            } else {
                swap(cArr, iMax0, i6 + iMax0, i5);
                return;
            }
        }
    }

    public static void swap(char[] cArr, int i, int i2, int i4) {
        if (isEmpty(cArr) || i >= cArr.length || i2 >= cArr.length) {
            return;
        }
        int iMax0 = max0(i);
        int iMax02 = max0(i2);
        int iMin = Math.min(Math.min(i4, cArr.length - iMax0), cArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            char c = cArr[iMax0];
            cArr[iMax0] = cArr[iMax02];
            cArr[iMax02] = c;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    @Deprecated
    public static long[] add(long[] jArr, int i, long j) {
        return (long[]) add(jArr, i, Long.valueOf(j), Long.TYPE);
    }

    public static String[] nullToEmpty(String[] strArr) {
        return (String[]) nullTo(strArr, EMPTY_STRING_ARRAY);
    }

    public static void reverse(double[] dArr) {
        if (dArr != null) {
            reverse(dArr, 0, dArr.length);
        }
    }

    public static void shuffle(long[] jArr) {
        shuffle(jArr, (Random) random());
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        return (Long[]) setAll(new Long[jArr.length], new C13831e(jArr, 5));
    }

    public static char[] toPrimitive(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            cArr[i] = chArr[i].charValue();
        }
        return cArr;
    }

    public static long[] add(long[] jArr, long j) {
        long[] jArr2 = (long[]) copyArrayGrow1(jArr, Long.TYPE);
        jArr2[jArr2.length - 1] = j;
        return jArr2;
    }

    public static int lastIndexOf(double[] dArr, double d, int i, double d2) {
        if (!isEmpty(dArr) && i >= 0) {
            if (i >= dArr.length) {
                i = dArr.length - 1;
            }
            double d3 = d - d2;
            double d4 = d + d2;
            while (i >= 0) {
                double d5 = dArr[i];
                if (d5 >= d3 && d5 <= d4) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static <T> T[] nullToEmpty(T[] tArr, Class<T[]> cls) {
        if (cls != null) {
            return tArr == null ? cls.cast(Array.newInstance(cls.getComponentType(), 0)) : tArr;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public static void reverse(double[] dArr, int i, int i2) {
        if (dArr == null) {
            return;
        }
        int iMin = Math.min(dArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            double d = dArr[iMin];
            dArr[iMin] = dArr[iMax];
            dArr[iMax] = d;
            iMin--;
        }
    }

    public static void shuffle(long[] jArr, Random random) {
        for (int length = jArr.length; length > 1; length--) {
            swap(jArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static float[] addAll(float[] fArr, float... fArr2) {
        if (fArr == null) {
            return clone(fArr2);
        }
        if (fArr2 == null) {
            return clone(fArr);
        }
        float[] fArr3 = new float[fArr.length + fArr2.length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    public static int indexOf(float[] fArr, float f) {
        return indexOf(fArr, f, 0);
    }

    public static boolean isSorted(float[] fArr) {
        if (getLength(fArr) < 2) {
            return true;
        }
        float f = fArr[0];
        int length = fArr.length;
        int i = 1;
        while (i < length) {
            float f4 = fArr[i];
            if (Float.compare(f, f4) > 0) {
                return false;
            }
            i++;
            f = f4;
        }
        return true;
    }

    public static short[] remove(short[] sArr, int i) {
        return (short[]) remove((Object) sArr, i);
    }

    public static int[] subarray(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, iArr.length) - iMax0;
        if (iMin <= 0) {
            return EMPTY_INT_ARRAY;
        }
        return (int[]) arraycopy(iArr, iMax0, 0, iMin, new C13791b(4));
    }

    private static Object add(Object obj, int i, Object obj2, Class<?> cls) {
        if (obj == null) {
            if (i == 0) {
                Object objNewInstance = Array.newInstance(cls, 1);
                Array.set(objNewInstance, 0, obj2);
                return objNewInstance;
            }
            throw new IndexOutOfBoundsException(AbstractC0541b.m767i(i, "Index: ", ", Length: 0"));
        }
        int length = Array.getLength(obj);
        if (i <= length && i >= 0) {
            Object objArraycopy = arraycopy(obj, 0, 0, i, new C13830d(cls, length, 1));
            Array.set(objArraycopy, i, obj2);
            if (i < length) {
                System.arraycopy(obj, i, objArraycopy, i + 1, length - i);
            }
            return objArraycopy;
        }
        throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i, length, "Index: ", ", Length: "));
    }

    public static int indexOf(float[] fArr, float f, int i) {
        if (isEmpty(fArr)) {
            return -1;
        }
        boolean zIsNaN = Float.isNaN(f);
        for (int iMax0 = max0(i); iMax0 < fArr.length; iMax0++) {
            float f4 = fArr[iMax0];
            if (f == f4 || (zIsNaN && Float.isNaN(f4))) {
                return iMax0;
            }
        }
        return -1;
    }

    public static BitSet indexesOf(double[] dArr, double d, int i, double d2) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (dArr != null) {
            while (i < dArr.length && (iIndexOf = indexOf(dArr, d, i, d2)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static <T> T[] remove(T[] tArr, int i) {
        return (T[]) ((Object[]) remove((Object) tArr, i));
    }

    public static void shuffle(Object[] objArr) {
        shuffle(objArr, random());
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        return (Short[]) setAll(new Short[sArr.length], new C13831e(sArr, 6));
    }

    public static void shuffle(Object[] objArr, Random random) {
        for (int length = objArr.length; length > 1; length--) {
            swap(objArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static int lastIndexOf(float[] fArr, float f) {
        return lastIndexOf(fArr, f, Integer.MAX_VALUE);
    }

    public static char[] toPrimitive(Character[] chArr, char c) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i = 0; i < chArr.length; i++) {
            Character ch = chArr[i];
            cArr[i] = ch == null ? c : ch.charValue();
        }
        return cArr;
    }

    public static int lastIndexOf(float[] fArr, float f, int i) {
        if (!isEmpty(fArr) && i >= 0) {
            if (i >= fArr.length) {
                i = fArr.length - 1;
            }
            while (i >= 0) {
                if (f == fArr[i]) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static void reverse(float[] fArr) {
        if (fArr != null) {
            reverse(fArr, 0, fArr.length);
        }
    }

    public static void shift(double[] dArr, int i) {
        if (dArr != null) {
            shift(dArr, 0, dArr.length, i);
        }
    }

    public static void shuffle(short[] sArr) {
        shuffle(sArr, (Random) random());
    }

    public static long[] subarray(long[] jArr, int i, int i2) {
        if (jArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, jArr.length) - iMax0;
        if (iMin <= 0) {
            return EMPTY_LONG_ARRAY;
        }
        return (long[]) arraycopy(jArr, iMax0, 0, iMin, new C13791b(1));
    }

    public static void swap(double[] dArr, int i, int i2) {
        swap(dArr, i, i2, 1);
    }

    public static int[] addAll(int[] iArr, int... iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        int[] iArr3 = new int[iArr.length + iArr2.length];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static BitSet indexesOf(float[] fArr, float f) {
        return indexesOf(fArr, f, 0);
    }

    public static boolean isSorted(int[] iArr) {
        if (getLength(iArr) < 2) {
            return true;
        }
        int i = iArr[0];
        int length = iArr.length;
        int i2 = 1;
        while (i2 < length) {
            int i4 = iArr[i2];
            if (NumberUtils.compare(i, i4) > 0) {
                return false;
            }
            i2++;
            i = i4;
        }
        return true;
    }

    public static void reverse(float[] fArr, int i, int i2) {
        if (fArr == null) {
            return;
        }
        int iMin = Math.min(fArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            float f = fArr[iMin];
            fArr[iMin] = fArr[iMax];
            fArr[iMax] = f;
            iMin--;
        }
    }

    public static void shift(double[] dArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (dArr == null || i >= dArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, dArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(dArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 < i6) {
                swap(dArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            } else {
                swap(dArr, iMax0, i6 + iMax0, i5);
                return;
            }
        }
    }

    public static void shuffle(short[] sArr, Random random) {
        for (int length = sArr.length; length > 1; length--) {
            swap(sArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static void swap(double[] dArr, int i, int i2, int i4) {
        if (isEmpty(dArr) || i >= dArr.length || i2 >= dArr.length) {
            return;
        }
        int iMax0 = max0(i);
        int iMax02 = max0(i2);
        int iMin = Math.min(Math.min(i4, dArr.length - iMax0), dArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            double d = dArr[iMax0];
            dArr[iMax0] = dArr[iMax02];
            dArr[iMax02] = d;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    public static <T> T[] toArray(T... tArr) {
        return tArr;
    }

    public static int indexOf(int[] iArr, int i) {
        return indexOf(iArr, i, 0);
    }

    public static BitSet indexesOf(float[] fArr, float f, int i) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (fArr != null) {
            while (i < fArr.length && (iIndexOf = indexOf(fArr, f, i)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static short[] removeAll(short[] sArr, int... iArr) {
        return (short[]) removeAll((Object) sArr, iArr);
    }

    public static char[] removeElements(char[] cArr, char... cArr2) {
        if (!isEmpty(cArr) && !isEmpty(cArr2)) {
            HashMap map = new HashMap(cArr2.length);
            for (char c : cArr2) {
                increment(map, Character.valueOf(c));
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < cArr.length; i++) {
                char c2 = cArr[i];
                MutableInt mutableInt = (MutableInt) map.get(Character.valueOf(c2));
                if (mutableInt != null) {
                    if (mutableInt.decrementAndGet() == 0) {
                        map.remove(Character.valueOf(c2));
                    }
                    bitSet.set(i);
                }
            }
            return (char[]) removeAt(cArr, bitSet);
        }
        return clone(cArr);
    }

    public static int indexOf(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return -1;
        }
        for (int iMax0 = max0(i2); iMax0 < iArr.length; iMax0++) {
            if (i == iArr[iMax0]) {
                return iMax0;
            }
        }
        return -1;
    }

    public static <T> T[] removeAll(T[] tArr, int... iArr) {
        return (T[]) ((Object[]) removeAll((Object) tArr, iArr));
    }

    public static int lastIndexOf(int[] iArr, int i) {
        return lastIndexOf(iArr, i, Integer.MAX_VALUE);
    }

    public static short[] subarray(short[] sArr, int i, int i2) {
        if (sArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, sArr.length) - iMax0;
        if (iMin <= 0) {
            return EMPTY_SHORT_ARRAY;
        }
        return (short[]) arraycopy(sArr, iMax0, 0, iMin, new C13791b(7));
    }

    public static int indexOf(long[] jArr, long j) {
        return indexOf(jArr, j, 0);
    }

    public static int lastIndexOf(int[] iArr, int i, int i2) {
        if (iArr != null && i2 >= 0) {
            if (i2 >= iArr.length) {
                i2 = iArr.length - 1;
            }
            while (i2 >= 0) {
                if (i == iArr[i2]) {
                    return i2;
                }
                i2--;
            }
        }
        return -1;
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public static long[] addAll(long[] jArr, long... jArr2) {
        if (jArr == null) {
            return clone(jArr2);
        }
        if (jArr2 == null) {
            return clone(jArr);
        }
        long[] jArr3 = new long[jArr.length + jArr2.length];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    public static int indexOf(long[] jArr, long j, int i) {
        if (jArr == null) {
            return -1;
        }
        for (int iMax0 = max0(i); iMax0 < jArr.length; iMax0++) {
            if (j == jArr[iMax0]) {
                return iMax0;
            }
        }
        return -1;
    }

    public static BitSet indexesOf(int[] iArr, int i) {
        return indexesOf(iArr, i, 0);
    }

    public static char[] insert(int i, char[] cArr, char... cArr2) {
        if (cArr == null) {
            return null;
        }
        if (isEmpty(cArr2)) {
            return clone(cArr);
        }
        if (i >= 0 && i <= cArr.length) {
            char[] cArr3 = new char[cArr.length + cArr2.length];
            System.arraycopy(cArr2, 0, cArr3, i, cArr2.length);
            if (i > 0) {
                System.arraycopy(cArr, 0, cArr3, 0, i);
            }
            if (i < cArr.length) {
                System.arraycopy(cArr, i, cArr3, cArr2.length + i, cArr.length - i);
            }
            return cArr3;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
        sbM778t.append(cArr.length);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public static boolean isSorted(long[] jArr) {
        if (getLength(jArr) < 2) {
            return true;
        }
        long j = jArr[0];
        int length = jArr.length;
        int i = 1;
        while (i < length) {
            long j2 = jArr[i];
            if (NumberUtils.compare(j, j2) > 0) {
                return false;
            }
            i++;
            j = j2;
        }
        return true;
    }

    public static void reverse(int[] iArr) {
        if (iArr != null) {
            reverse(iArr, 0, iArr.length);
        }
    }

    public static BitSet indexesOf(int[] iArr, int i, int i2) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (iArr != null) {
            while (i2 < iArr.length && (iIndexOf = indexOf(iArr, i, i2)) != -1) {
                bitSet.set(iIndexOf);
                i2 = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static void reverse(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return;
        }
        int iMin = Math.min(iArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            int i4 = iArr[iMin];
            iArr[iMin] = iArr[iMax];
            iArr[iMax] = i4;
            iMin--;
        }
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static int lastIndexOf(long[] jArr, long j) {
        return lastIndexOf(jArr, j, Integer.MAX_VALUE);
    }

    public static void shift(float[] fArr, int i) {
        if (fArr != null) {
            shift(fArr, 0, fArr.length, i);
        }
    }

    public static <T> T[] subarray(T[] tArr, int i, int i2) {
        if (tArr == null) {
            return null;
        }
        int iMax0 = max0(i);
        int iMin = Math.min(i2, tArr.length) - iMax0;
        Class componentType = getComponentType(tArr);
        if (iMin <= 0) {
            return (T[]) newInstance(componentType, 0);
        }
        return (T[]) ((Object[]) arraycopy(tArr, iMax0, 0, iMin, new C13830d(componentType, iMin, 0)));
    }

    public static void swap(float[] fArr, int i, int i2) {
        swap(fArr, i, i2, 1);
    }

    public static int indexOf(Object[] objArr, Object obj, int i) {
        if (objArr == null) {
            return -1;
        }
        int iMax0 = max0(i);
        if (obj == null) {
            while (iMax0 < objArr.length) {
                if (objArr[iMax0] == null) {
                    return iMax0;
                }
                iMax0++;
            }
        } else {
            while (iMax0 < objArr.length) {
                if (obj.equals(objArr[iMax0])) {
                    return iMax0;
                }
                iMax0++;
            }
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j, int i) {
        if (jArr != null && i >= 0) {
            if (i >= jArr.length) {
                i = jArr.length - 1;
            }
            while (i >= 0) {
                if (j == jArr[i]) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static void shift(float[] fArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (fArr == null || i >= fArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, fArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(fArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 < i6) {
                swap(fArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            } else {
                swap(fArr, iMax0, i6 + iMax0, i5);
                return;
            }
        }
    }

    public static void swap(float[] fArr, int i, int i2, int i4) {
        if (isEmpty(fArr) || i >= fArr.length || i2 >= fArr.length) {
            return;
        }
        int iMax0 = max0(i);
        int iMax02 = max0(i2);
        int iMin = Math.min(Math.min(i4, fArr.length - iMax0), fArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            float f = fArr[iMax0];
            fArr[iMax0] = fArr[iMax02];
            fArr[iMax02] = f;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    public static double[] toPrimitive(Double[] dArr, double d) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            Double d2 = dArr[i];
            dArr2[i] = d2 == null ? d : d2.doubleValue();
        }
        return dArr2;
    }

    public static short[] addAll(short[] sArr, short... sArr2) {
        if (sArr == null) {
            return clone(sArr2);
        }
        if (sArr2 == null) {
            return clone(sArr);
        }
        short[] sArr3 = new short[sArr.length + sArr2.length];
        System.arraycopy(sArr, 0, sArr3, 0, sArr.length);
        System.arraycopy(sArr2, 0, sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static BitSet indexesOf(long[] jArr, long j) {
        return indexesOf(jArr, j, 0);
    }

    public static boolean isSorted(short[] sArr) {
        if (getLength(sArr) < 2) {
            return true;
        }
        short s = sArr[0];
        int length = sArr.length;
        int i = 1;
        while (i < length) {
            short s2 = sArr[i];
            if (NumberUtils.compare(s, s2) > 0) {
                return false;
            }
            i++;
            s = s2;
        }
        return true;
    }

    public static BitSet indexesOf(long[] jArr, long j, int i) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (jArr != null) {
            while (i < jArr.length && (iIndexOf = indexOf(jArr, j, i)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static void reverse(long[] jArr) {
        if (jArr != null) {
            reverse(jArr, 0, jArr.length);
        }
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i) {
        if (objArr != null && i >= 0) {
            if (i >= objArr.length) {
                i = objArr.length - 1;
            }
            if (obj == null) {
                while (i >= 0) {
                    if (objArr[i] == null) {
                        return i;
                    }
                    i--;
                }
            } else if (objArr.getClass().getComponentType().isInstance(obj)) {
                while (i >= 0) {
                    if (obj.equals(objArr[i])) {
                        return i;
                    }
                    i--;
                }
            }
        }
        return -1;
    }

    public static void reverse(long[] jArr, int i, int i2) {
        if (jArr == null) {
            return;
        }
        int iMin = Math.min(jArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            long j = jArr[iMin];
            jArr[iMin] = jArr[iMax];
            jArr[iMax] = j;
            iMin--;
        }
    }

    public static int indexOf(short[] sArr, short s) {
        return indexOf(sArr, s, 0);
    }

    public static int indexOf(short[] sArr, short s, int i) {
        if (sArr == null) {
            return -1;
        }
        for (int iMax0 = max0(i); iMax0 < sArr.length; iMax0++) {
            if (s == sArr[iMax0]) {
                return iMax0;
            }
        }
        return -1;
    }

    public static double[] removeElements(double[] dArr, double... dArr2) {
        if (!isEmpty(dArr) && !isEmpty(dArr2)) {
            HashMap map = new HashMap(dArr2.length);
            for (double d : dArr2) {
                increment(map, Double.valueOf(d));
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < dArr.length; i++) {
                double d2 = dArr[i];
                MutableInt mutableInt = (MutableInt) map.get(Double.valueOf(d2));
                if (mutableInt != null) {
                    if (mutableInt.decrementAndGet() == 0) {
                        map.remove(Double.valueOf(d2));
                    }
                    bitSet.set(i);
                }
            }
            return (double[]) removeAt(dArr, bitSet);
        }
        return clone(dArr);
    }

    public static <T> T[] addAll(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return (T[]) clone(tArr2);
        }
        if (tArr2 == null) {
            return (T[]) clone(tArr);
        }
        Class componentType = getComponentType(tArr);
        T[] tArr3 = (T[]) ((Object[]) arraycopy(tArr, 0, 0, tArr.length, new C11571a(componentType, 1, tArr, tArr2)));
        try {
            System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
            return tArr3;
        } catch (ArrayStoreException e) {
            Class<?> componentType2 = tArr2.getClass().getComponentType();
            if (!componentType.isAssignableFrom(componentType2)) {
                throw new IllegalArgumentException("Cannot store " + componentType2.getName() + " in an array of " + componentType.getName(), e);
            }
            throw e;
        }
    }

    public static BitSet indexesOf(Object[] objArr, Object obj) {
        return indexesOf(objArr, obj, 0);
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] tArr) {
        return isSorted(tArr, new C13882g(0));
    }

    public static void shift(int[] iArr, int i) {
        if (iArr != null) {
            shift(iArr, 0, iArr.length, i);
        }
    }

    public static void swap(int[] iArr, int i, int i2) {
        swap(iArr, i, i2, 1);
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    public static BitSet indexesOf(Object[] objArr, Object obj, int i) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (objArr != null) {
            while (i < objArr.length && (iIndexOf = indexOf(objArr, obj, i)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    public static <T> boolean isSorted(T[] tArr, Comparator<T> comparator) {
        Objects.requireNonNull(comparator, "comparator");
        if (getLength(tArr) < 2) {
            return true;
        }
        T t = tArr[0];
        int length = tArr.length;
        int i = 1;
        while (i < length) {
            T t2 = tArr[i];
            if (comparator.compare(t, t2) > 0) {
                return false;
            }
            i++;
            t = t2;
        }
        return true;
    }

    public static void shift(int[] iArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (iArr == null || i >= iArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, iArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(iArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 < i6) {
                swap(iArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            } else {
                swap(iArr, iMax0, i6 + iMax0, i5);
                return;
            }
        }
    }

    public static void swap(int[] iArr, int i, int i2, int i4) {
        if (isEmpty(iArr) || i >= iArr.length || i2 >= iArr.length) {
            return;
        }
        int iMax0 = max0(i);
        int iMax02 = max0(i2);
        int iMin = Math.min(Math.min(i4, iArr.length - iMax0), iArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            int i6 = iArr[iMax0];
            iArr[iMax0] = iArr[iMax02];
            iArr[iMax02] = i6;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    public static int lastIndexOf(short[] sArr, short s) {
        return lastIndexOf(sArr, s, Integer.MAX_VALUE);
    }

    public static void reverse(Object[] objArr) {
        if (objArr != null) {
            reverse(objArr, 0, objArr.length);
        }
    }

    public static int lastIndexOf(short[] sArr, short s, int i) {
        if (sArr != null && i >= 0) {
            if (i >= sArr.length) {
                i = sArr.length - 1;
            }
            while (i >= 0) {
                if (s == sArr[i]) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static void reverse(Object[] objArr, int i, int i2) {
        if (objArr == null) {
            return;
        }
        int iMin = Math.min(objArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            Object obj = objArr[iMin];
            objArr[iMin] = objArr[iMax];
            objArr[iMax] = obj;
            iMin--;
        }
    }

    @Deprecated
    public static short[] add(short[] sArr, int i, short s) {
        return (short[]) add(sArr, i, Short.valueOf(s), Short.TYPE);
    }

    public static BitSet indexesOf(short[] sArr, short s) {
        return indexesOf(sArr, s, 0);
    }

    public static double[] insert(int i, double[] dArr, double... dArr2) {
        if (dArr == null) {
            return null;
        }
        if (isEmpty(dArr2)) {
            return clone(dArr);
        }
        if (i >= 0 && i <= dArr.length) {
            double[] dArr3 = new double[dArr.length + dArr2.length];
            System.arraycopy(dArr2, 0, dArr3, i, dArr2.length);
            if (i > 0) {
                System.arraycopy(dArr, 0, dArr3, 0, i);
            }
            if (i < dArr.length) {
                System.arraycopy(dArr, i, dArr3, dArr2.length + i, dArr.length - i);
            }
            return dArr3;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
        sbM778t.append(dArr.length);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public static float[] toPrimitive(Float[] fArr, float f) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            Float f4 = fArr[i];
            fArr2[i] = f4 == null ? f : f4.floatValue();
        }
        return fArr2;
    }

    public static short[] add(short[] sArr, short s) {
        short[] sArr2 = (short[]) copyArrayGrow1(sArr, Short.TYPE);
        sArr2[sArr2.length - 1] = s;
        return sArr2;
    }

    public static BitSet indexesOf(short[] sArr, short s, int i) {
        int iIndexOf;
        BitSet bitSet = new BitSet();
        if (sArr != null) {
            while (i < sArr.length && (iIndexOf = indexOf(sArr, s, i)) != -1) {
                bitSet.set(iIndexOf);
                i = iIndexOf + 1;
            }
        }
        return bitSet;
    }

    @Deprecated
    public static <T> T[] add(T[] tArr, int i, T t) {
        Class componentType;
        if (tArr != null) {
            componentType = getComponentType(tArr);
        } else if (t != null) {
            componentType = ObjectUtils.getClass(t);
        } else {
            throw new IllegalArgumentException("Array and element cannot both be null");
        }
        return (T[]) ((Object[]) add(tArr, i, t, componentType));
    }

    public static void reverse(short[] sArr) {
        if (sArr != null) {
            reverse(sArr, 0, sArr.length);
        }
    }

    public static void shift(long[] jArr, int i) {
        if (jArr != null) {
            shift(jArr, 0, jArr.length, i);
        }
    }

    public static void swap(long[] jArr, int i, int i2) {
        swap(jArr, i, i2, 1);
    }

    public static void reverse(short[] sArr, int i, int i2) {
        if (sArr == null) {
            return;
        }
        int iMin = Math.min(sArr.length, i2) - 1;
        for (int iMax = Math.max(i, 0); iMin > iMax; iMax++) {
            short s = sArr[iMin];
            sArr[iMin] = sArr[iMax];
            sArr[iMax] = s;
            iMin--;
        }
    }

    public static void shift(long[] jArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (jArr == null || i >= jArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, jArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(jArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 < i6) {
                swap(jArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            } else {
                swap(jArr, iMax0, i6 + iMax0, i5);
                return;
            }
        }
    }

    public static void swap(long[] jArr, int i, int i2, int i4) {
        if (isEmpty(jArr) || i >= jArr.length || i2 >= jArr.length) {
            return;
        }
        int iMax0 = max0(i);
        int iMax02 = max0(i2);
        int iMin = Math.min(Math.min(i4, jArr.length - iMax0), jArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            long j = jArr[iMax0];
            jArr[iMax0] = jArr[iMax02];
            jArr[iMax02] = j;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static <T> T[] add(T[] tArr, T t) {
        Class<?> componentType;
        if (tArr != null) {
            componentType = tArr.getClass().getComponentType();
        } else if (t != null) {
            componentType = t.getClass();
        } else {
            throw new IllegalArgumentException("Arguments cannot both be null");
        }
        T[] tArr2 = (T[]) ((Object[]) copyArrayGrow1(tArr, componentType));
        tArr2[tArr2.length - 1] = t;
        return tArr2;
    }

    public static float[] removeElements(float[] fArr, float... fArr2) {
        if (!isEmpty(fArr) && !isEmpty(fArr2)) {
            HashMap map = new HashMap(fArr2.length);
            for (float f : fArr2) {
                increment(map, Float.valueOf(f));
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < fArr.length; i++) {
                float f4 = fArr[i];
                MutableInt mutableInt = (MutableInt) map.get(Float.valueOf(f4));
                if (mutableInt != null) {
                    if (mutableInt.decrementAndGet() == 0) {
                        map.remove(Float.valueOf(f4));
                    }
                    bitSet.set(i);
                }
            }
            return (float[]) removeAt(fArr, bitSet);
        }
        return clone(fArr);
    }

    public static void shift(Object[] objArr, int i) {
        if (objArr != null) {
            shift(objArr, 0, objArr.length, i);
        }
    }

    public static void swap(Object[] objArr, int i, int i2) {
        swap(objArr, i, i2, 1);
    }

    public static int[] toPrimitive(Integer[] numArr, int i) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            Integer num = numArr[i2];
            iArr[i2] = num == null ? i : num.intValue();
        }
        return iArr;
    }

    public static void shift(Object[] objArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (objArr == null || i >= objArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, objArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(objArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 < i6) {
                swap(objArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            } else {
                swap(objArr, iMax0, i6 + iMax0, i5);
                return;
            }
        }
    }

    public static void swap(Object[] objArr, int i, int i2, int i4) {
        if (isEmpty(objArr) || i >= objArr.length || i2 >= objArr.length) {
            return;
        }
        int iMax0 = max0(i);
        int iMax02 = max0(i2);
        int iMin = Math.min(Math.min(i4, objArr.length - iMax0), objArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            Object obj = objArr[iMax0];
            objArr[iMax0] = objArr[iMax02];
            objArr[iMax02] = obj;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    public static float[] insert(int i, float[] fArr, float... fArr2) {
        if (fArr == null) {
            return null;
        }
        if (isEmpty(fArr2)) {
            return clone(fArr);
        }
        if (i >= 0 && i <= fArr.length) {
            float[] fArr3 = new float[fArr.length + fArr2.length];
            System.arraycopy(fArr2, 0, fArr3, i, fArr2.length);
            if (i > 0) {
                System.arraycopy(fArr, 0, fArr3, 0, i);
            }
            if (i < fArr.length) {
                System.arraycopy(fArr, i, fArr3, fArr2.length + i, fArr.length - i);
            }
            return fArr3;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
        sbM778t.append(fArr.length);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static void shift(short[] sArr, int i) {
        if (sArr != null) {
            shift(sArr, 0, sArr.length, i);
        }
    }

    public static void swap(short[] sArr, int i, int i2) {
        swap(sArr, i, i2, 1);
    }

    public static int[] removeElements(int[] iArr, int... iArr2) {
        if (!isEmpty(iArr) && !isEmpty(iArr2)) {
            HashMap map = new HashMap(iArr2.length);
            for (int i : iArr2) {
                increment(map, Integer.valueOf(i));
            }
            BitSet bitSet = new BitSet();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i4 = iArr[i2];
                MutableInt mutableInt = (MutableInt) map.get(Integer.valueOf(i4));
                if (mutableInt != null) {
                    if (mutableInt.decrementAndGet() == 0) {
                        map.remove(Integer.valueOf(i4));
                    }
                    bitSet.set(i2);
                }
            }
            return (int[]) removeAt(iArr, bitSet);
        }
        return clone(iArr);
    }

    public static void shift(short[] sArr, int i, int i2, int i4) {
        int iMax0;
        int iMin;
        if (sArr == null || i >= sArr.length - 1 || i2 <= 0 || (iMin = Math.min(i2, sArr.length) - (iMax0 = max0(i))) <= 1) {
            return;
        }
        int i5 = i4 % iMin;
        if (i5 < 0) {
            i5 += iMin;
        }
        while (iMin > 1 && i5 > 0) {
            int i6 = iMin - i5;
            if (i5 > i6) {
                swap(sArr, iMax0, (iMin + iMax0) - i6, i6);
                int i7 = i5;
                i5 -= i6;
                iMin = i7;
            } else if (i5 < i6) {
                swap(sArr, iMax0, iMax0 + i6, i5);
                iMax0 += i5;
                iMin = i6;
            } else {
                swap(sArr, iMax0, i6 + iMax0, i5);
                return;
            }
        }
    }

    public static void swap(short[] sArr, int i, int i2, int i4) {
        int iMax0;
        int iMax02;
        if (isEmpty(sArr) || i >= sArr.length || i2 >= sArr.length || (iMax0 = max0(i)) == (iMax02 = max0(i2))) {
            return;
        }
        int iMin = Math.min(Math.min(i4, sArr.length - iMax0), sArr.length - iMax02);
        int i5 = 0;
        while (i5 < iMin) {
            short s = sArr[iMax0];
            sArr[iMax0] = sArr[iMax02];
            sArr[iMax02] = s;
            i5++;
            iMax0++;
            iMax02++;
        }
    }

    public static long[] toPrimitive(Long[] lArr, long j) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            Long l = lArr[i];
            jArr[i] = l == null ? j : l.longValue();
        }
        return jArr;
    }

    public static Object toPrimitive(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> clsWrapperToPrimitive = ClassUtils.wrapperToPrimitive(obj.getClass().getComponentType());
        if (Boolean.TYPE.equals(clsWrapperToPrimitive)) {
            return toPrimitive((Boolean[]) obj);
        }
        if (Character.TYPE.equals(clsWrapperToPrimitive)) {
            return toPrimitive((Character[]) obj);
        }
        if (Byte.TYPE.equals(clsWrapperToPrimitive)) {
            return toPrimitive((Byte[]) obj);
        }
        if (Integer.TYPE.equals(clsWrapperToPrimitive)) {
            return toPrimitive((Integer[]) obj);
        }
        if (Long.TYPE.equals(clsWrapperToPrimitive)) {
            return toPrimitive((Long[]) obj);
        }
        if (Short.TYPE.equals(clsWrapperToPrimitive)) {
            return toPrimitive((Short[]) obj);
        }
        if (Double.TYPE.equals(clsWrapperToPrimitive)) {
            return toPrimitive((Double[]) obj);
        }
        return Float.TYPE.equals(clsWrapperToPrimitive) ? toPrimitive((Float[]) obj) : obj;
    }

    public static int[] insert(int i, int[] iArr, int... iArr2) {
        if (iArr == null) {
            return null;
        }
        if (isEmpty(iArr2)) {
            return clone(iArr);
        }
        if (i >= 0 && i <= iArr.length) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, i, iArr2.length);
            if (i > 0) {
                System.arraycopy(iArr, 0, iArr3, 0, i);
            }
            if (i < iArr.length) {
                System.arraycopy(iArr, i, iArr3, iArr2.length + i, iArr.length - i);
            }
            return iArr3;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
        sbM778t.append(iArr.length);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public static long[] removeElements(long[] jArr, long... jArr2) {
        if (!isEmpty(jArr) && !isEmpty(jArr2)) {
            HashMap map = new HashMap(jArr2.length);
            for (long j : jArr2) {
                increment(map, Long.valueOf(j));
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < jArr.length; i++) {
                long j2 = jArr[i];
                MutableInt mutableInt = (MutableInt) map.get(Long.valueOf(j2));
                if (mutableInt != null) {
                    if (mutableInt.decrementAndGet() == 0) {
                        map.remove(Long.valueOf(j2));
                    }
                    bitSet.set(i);
                }
            }
            return (long[]) removeAt(jArr, bitSet);
        }
        return clone(jArr);
    }

    public static long[] insert(int i, long[] jArr, long... jArr2) {
        if (jArr == null) {
            return null;
        }
        if (isEmpty(jArr2)) {
            return clone(jArr);
        }
        if (i >= 0 && i <= jArr.length) {
            long[] jArr3 = new long[jArr.length + jArr2.length];
            System.arraycopy(jArr2, 0, jArr3, i, jArr2.length);
            if (i > 0) {
                System.arraycopy(jArr, 0, jArr3, 0, i);
            }
            if (i < jArr.length) {
                System.arraycopy(jArr, i, jArr3, jArr2.length + i, jArr.length - i);
            }
            return jArr3;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
        sbM778t.append(jArr.length);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    public static short[] removeElements(short[] sArr, short... sArr2) {
        if (!isEmpty(sArr) && !isEmpty(sArr2)) {
            HashMap map = new HashMap(sArr2.length);
            for (short s : sArr2) {
                increment(map, Short.valueOf(s));
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < sArr.length; i++) {
                short s2 = sArr[i];
                MutableInt mutableInt = (MutableInt) map.get(Short.valueOf(s2));
                if (mutableInt != null) {
                    if (mutableInt.decrementAndGet() == 0) {
                        map.remove(Short.valueOf(s2));
                    }
                    bitSet.set(i);
                }
            }
            return (short[]) removeAt(sArr, bitSet);
        }
        return clone(sArr);
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    public static short[] toPrimitive(Short[] shArr, short s) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i = 0; i < shArr.length; i++) {
            Short sh = shArr[i];
            sArr[i] = sh == null ? s : sh.shortValue();
        }
        return sArr;
    }

    @SafeVarargs
    public static <T> T[] removeElements(T[] tArr, T... tArr2) {
        if (!isEmpty(tArr) && !isEmpty(tArr2)) {
            HashMap map = new HashMap(tArr2.length);
            for (T t : tArr2) {
                increment(map, t);
            }
            BitSet bitSet = new BitSet();
            for (int i = 0; i < tArr.length; i++) {
                T t2 = tArr[i];
                MutableInt mutableInt = (MutableInt) map.get(t2);
                if (mutableInt != null) {
                    if (mutableInt.decrementAndGet() == 0) {
                        map.remove(t2);
                    }
                    bitSet.set(i);
                }
            }
            return (T[]) ((Object[]) removeAt(tArr, bitSet));
        }
        return (T[]) clone(tArr);
    }

    public static short[] insert(int i, short[] sArr, short... sArr2) {
        if (sArr == null) {
            return null;
        }
        if (isEmpty(sArr2)) {
            return clone(sArr);
        }
        if (i >= 0 && i <= sArr.length) {
            short[] sArr3 = new short[sArr.length + sArr2.length];
            System.arraycopy(sArr2, 0, sArr3, i, sArr2.length);
            if (i > 0) {
                System.arraycopy(sArr, 0, sArr3, 0, i);
            }
            if (i < sArr.length) {
                System.arraycopy(sArr, i, sArr3, sArr2.length + i, sArr.length - i);
            }
            return sArr3;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
        sbM778t.append(sArr.length);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }

    @SafeVarargs
    public static <T> T[] insert(int i, T[] tArr, T... tArr2) {
        if (tArr == null) {
            return null;
        }
        if (isEmpty(tArr2)) {
            return (T[]) clone(tArr);
        }
        if (i >= 0 && i <= tArr.length) {
            T[] tArr3 = (T[]) newInstance(getComponentType(tArr), tArr.length + tArr2.length);
            System.arraycopy(tArr2, 0, tArr3, i, tArr2.length);
            if (i > 0) {
                System.arraycopy(tArr, 0, tArr3, 0, i);
            }
            if (i < tArr.length) {
                System.arraycopy(tArr, i, tArr3, tArr2.length + i, tArr.length - i);
            }
            return tArr3;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "Index: ", ", Length: ");
        sbM778t.append(tArr.length);
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }
}
