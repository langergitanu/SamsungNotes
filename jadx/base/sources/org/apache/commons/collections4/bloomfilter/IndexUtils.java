package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class IndexUtils {
    static final int MAX_ARRAY_SIZE = 2147483639;

    private IndexUtils() {
    }

    public static int[] ensureCapacityForAdd(int[] iArr, int i) {
        return i >= iArr.length ? Arrays.copyOf(iArr, (int) Math.min(2147483639L, Math.max(((long) iArr.length) * 2, i + 1))) : iArr;
    }
}
