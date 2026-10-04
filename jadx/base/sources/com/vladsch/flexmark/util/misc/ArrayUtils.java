package com.vladsch.flexmark.util.misc;

import com.samsung.scsp.common.C11629h;
import java.lang.reflect.Array;
import java.util.BitSet;
import java.util.function.Predicate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ArrayUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @SafeVarargs
    public static <T> T[] append(Class<T> cls, T[] tArr, T... tArr2) {
        if (tArr2.length <= 0) {
            return tArr;
        }
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static <T> boolean contained(T t, T[] tArr) {
        return indexOf(t, tArr) != -1;
    }

    public static <T> T firstOf(T[] tArr, Predicate<? super T> predicate) {
        return (T) firstOf(tArr, 0, tArr.length, predicate);
    }

    public static <T> int indexOf(T t, T[] tArr) {
        return indexOf(t, tArr, 0, tArr.length);
    }

    public static <T> int lastIndexOf(T t, T[] tArr) {
        return lastIndexOf(t, tArr, 0, tArr.length);
    }

    public static <T> T lastOf(T[] tArr, Predicate<? super T> predicate) {
        return (T) lastOf(tArr, 0, tArr.length, predicate);
    }

    public static int[] toArray(@NotNull BitSet bitSet) {
        int iCardinality = bitSet.cardinality();
        int[] iArr = new int[iCardinality];
        int length = bitSet.length();
        while (length >= 0) {
            length = bitSet.previousSetBit(length - 1);
            if (length < 0) {
                break;
            }
            iCardinality--;
            iArr[iCardinality] = length;
        }
        return iArr;
    }

    public static boolean contained(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static <T> T firstOf(T[] tArr, int i, Predicate<? super T> predicate) {
        return (T) firstOf(tArr, i, tArr.length, predicate);
    }

    public static <T> int indexOf(T t, T[] tArr, int i) {
        return indexOf(t, tArr, i, tArr.length);
    }

    public static <T> int lastIndexOf(T t, T[] tArr, int i) {
        return lastIndexOf(t, tArr, 0, i);
    }

    public static <T> T lastOf(T[] tArr, int i, Predicate<? super T> predicate) {
        return (T) lastOf(tArr, 0, i, predicate);
    }

    @Nullable
    public static <T> T firstOf(T[] tArr, int i, int i2, Predicate<? super T> predicate) {
        int iIndexOf = indexOf(tArr, i, i2, predicate);
        if (iIndexOf == -1) {
            return null;
        }
        return tArr[iIndexOf];
    }

    public static <T> int indexOf(T t, T[] tArr, int i, int i2) {
        return indexOf(tArr, i, i2, new C11629h(t, 1));
    }

    public static <T> int lastIndexOf(T t, T[] tArr, int i, int i2) {
        return lastIndexOf(tArr, i, i2, new C11629h(t, 2));
    }

    public static <T> T lastOf(T[] tArr, int i, int i2, Predicate<? super T> predicate) {
        int iLastIndexOf = lastIndexOf(tArr, i, i2, predicate);
        if (iLastIndexOf == -1) {
            return null;
        }
        return tArr[iLastIndexOf];
    }

    public static <T> int indexOf(T[] tArr, Predicate<? super T> predicate) {
        return indexOf(tArr, 0, tArr.length, predicate);
    }

    public static <T> int lastIndexOf(T[] tArr, Predicate<? super T> predicate) {
        return lastIndexOf(tArr, 0, tArr.length, predicate);
    }

    public static <T> int indexOf(T[] tArr, int i, Predicate<? super T> predicate) {
        return indexOf(tArr, i, tArr.length, predicate);
    }

    public static <T> int lastIndexOf(T[] tArr, int i, Predicate<? super T> predicate) {
        return lastIndexOf(tArr, 0, i, predicate);
    }

    public static <T> int indexOf(T[] tArr, int i, int i2, Predicate<? super T> predicate) {
        int length = tArr.length;
        if (i2 <= 0) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 > length) {
            i2 = length;
        }
        if (i >= i2) {
            return -1;
        }
        while (i < i2) {
            if (predicate.test(tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> int lastIndexOf(T[] tArr, int i, int i2, Predicate<? super T> predicate) {
        int length = tArr.length;
        if (i2 < 0) {
            return -1;
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 >= length) {
            i2 = length - 1;
        }
        if (i >= i2) {
            return -1;
        }
        while (i2 >= i) {
            if (predicate.test(tArr[i2])) {
                return i2;
            }
            i2--;
        }
        return -1;
    }
}
