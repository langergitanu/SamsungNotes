package com.google.common.collect;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
final class CollectPreconditions {
    public static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException(AbstractC0541b.m769k(obj2, "null key in entry: null="));
        }
        if (obj2 == null) {
            throw new NullPointerException(AbstractC0622a.m1165k(obj, "null value in entry: ", "=null"));
        }
    }

    @CanIgnoreReturnValue
    public static int checkNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(AbstractC2821a.m2218i(i, str, " cannot be negative but was: "));
    }

    public static void checkPositive(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(AbstractC2821a.m2218i(i, str, " must be positive but was: "));
        }
    }

    public static void checkRemove(boolean z) {
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
    }

    @CanIgnoreReturnValue
    public static long checkNonnegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j);
    }
}
