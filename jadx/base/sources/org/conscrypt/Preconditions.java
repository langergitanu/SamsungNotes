package org.conscrypt;

import androidx.collection.AbstractC0622a;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class Preconditions {
    private Preconditions() {
    }

    private static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return str + " (" + i + ") must not be negative";
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "negative size: "));
        }
        return str + " (" + i + ") must not be greater than size (" + i2 + ")";
    }

    private static String badPositionIndexes(int i, int i2, int i4) {
        return (i < 0 || i > i4) ? badPositionIndex(i, i4, "start index") : (i2 < 0 || i2 > i4) ? badPositionIndex(i2, i4, "end index") : AbstractC0622a.m1164j(i2, i, "end index (", ") must not be less than start index (", ")");
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void checkPositionIndexes(int i, int i2, int i4) {
        if (i < 0 || i2 < i || i2 > i4) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i, i2, i4));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }
}
