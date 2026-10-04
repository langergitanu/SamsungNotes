package org.conscrypt;

import androidx.collection.AbstractC0622a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class ArrayUtils {
    private ArrayUtils() {
    }

    public static void checkOffsetAndCount(int i, int i2, int i4) {
        if ((i2 | i4) < 0 || i2 > i || i - i2 < i4) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "length=", "; regionStart=", "; regionLength=");
            sbM1173s.append(i4);
            throw new ArrayIndexOutOfBoundsException(sbM1173s.toString());
        }
    }
}
