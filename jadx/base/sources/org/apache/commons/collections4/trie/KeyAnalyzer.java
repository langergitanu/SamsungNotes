package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class KeyAnalyzer<K> implements Comparator<K>, Serializable {
    public static final int EQUAL_BIT_KEY = -2;
    public static final int NULL_BIT_KEY = -1;
    public static final int OUT_OF_BOUNDS_BIT_KEY = -3;
    private static final long serialVersionUID = -20497563720380683L;

    public static boolean isEqualBitKey(int i) {
        return i == -2;
    }

    public static boolean isNullBitKey(int i) {
        return i == -1;
    }

    public static boolean isOutOfBoundsIndex(int i) {
        return i == -3;
    }

    public static boolean isValidBitIndex(int i) {
        return i >= 0;
    }

    public abstract int bitIndex(K k, int i, int i2, K k2, int i4, int i5);

    public abstract int bitsPerElement();

    @Override // java.util.Comparator
    public int compare(K k, K k2) {
        if (k == null) {
            return k2 == null ? 0 : -1;
        }
        if (k2 == null) {
            return 1;
        }
        return ((Comparable) k).compareTo(k2);
    }

    public abstract boolean isBitSet(K k, int i, int i2);

    public abstract boolean isPrefix(K k, int i, int i2, K k2);

    public abstract int lengthInBits(K k);
}
