package org.apache.commons.collections4.keyvalue;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MultiKey<K> implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;
    private transient int hashCode;
    private final K[] keys;

    public MultiKey(K k, K k2) {
        this(newArray(k, k2), false);
    }

    private void calculateHashCode(Object[] objArr) {
        int iHashCode = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                iHashCode ^= obj.hashCode();
            }
        }
        this.hashCode = iHashCode;
    }

    private static <T> Class<? extends T> getClass(T t) {
        return t == null ? Object.class : (Class<? extends T>) t.getClass();
    }

    @SafeVarargs
    private static <T> Class<? extends T> getComponentType(T... tArr) {
        if (tArr != null) {
            Class cls = tArr.length > 0 ? getClass(tArr[0]) : Object.class;
            int i = 1;
            while (i < tArr.length) {
                Class<? extends T> cls2 = getClass(tArr[i]);
                if (cls == cls2) {
                    i++;
                    cls = cls2;
                }
            }
            return cls;
        }
        return Object.class;
    }

    private static <T> T[] newArray(T t, T t2) {
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) getComponentType(t, t2), 2));
        tArr[0] = t;
        tArr[1] = t2;
        return tArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiKey) {
            return Arrays.equals(this.keys, ((MultiKey) obj).keys);
        }
        return false;
    }

    public K getKey(int i) {
        return this.keys[i];
    }

    public K[] getKeys() {
        return (K[]) ((Object[]) this.keys.clone());
    }

    public int hashCode() {
        return this.hashCode;
    }

    public Object readResolve() {
        calculateHashCode(this.keys);
        return this;
    }

    public int size() {
        return this.keys.length;
    }

    public String toString() {
        return "MultiKey" + Arrays.toString(this.keys);
    }

    public MultiKey(K k, K k2, K k3) {
        this(newArray(k, k2, k3), false);
    }

    public MultiKey(K k, K k2, K k3, K k4) {
        this(newArray(k, k2, k3, k4), false);
    }

    public MultiKey(K k, K k2, K k3, K k4, K k5) {
        this(newArray(k, k2, k3, k4, k5), false);
    }

    private static <T> T[] newArray(T t, T t2, T t5) {
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) getComponentType(t, t2, t5), 3));
        tArr[0] = t;
        tArr[1] = t2;
        tArr[2] = t5;
        return tArr;
    }

    public MultiKey(K[] kArr) {
        this((Object[]) kArr, true);
    }

    public MultiKey(K[] kArr, boolean z) {
        Objects.requireNonNull(kArr, "keys");
        this.keys = z ? (K[]) ((Object[]) kArr.clone()) : kArr;
        calculateHashCode(kArr);
    }

    private static <T> T[] newArray(T t, T t2, T t5, T t6) {
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) getComponentType(t, t2, t5, t6), 4));
        tArr[0] = t;
        tArr[1] = t2;
        tArr[2] = t5;
        tArr[3] = t6;
        return tArr;
    }

    private static <T> T[] newArray(T t, T t2, T t5, T t6, T t7) {
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) getComponentType(t, t2, t5, t6, t7), 5));
        tArr[0] = t;
        tArr[1] = t2;
        tArr[2] = t5;
        tArr[3] = t6;
        tArr[4] = t7;
        return tArr;
    }
}
