package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzca {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = zzbp.zza;
            }
        } else {
            if (!(iterable instanceof zzbz)) {
                return false;
            }
            comparator2 = ((zzbz) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
