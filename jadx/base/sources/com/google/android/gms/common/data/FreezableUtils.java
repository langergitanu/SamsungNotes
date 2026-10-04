package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.handwriting.HwrLanguageID;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        HwrLanguageID.C72663.AnonymousClass6 anonymousClass6 = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            anonymousClass6.add(arrayList.get(i).freeze());
        }
        return anonymousClass6;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        HwrLanguageID.C72663.AnonymousClass6 anonymousClass6 = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            anonymousClass6.add(it.next().freeze());
        }
        return anonymousClass6;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        HwrLanguageID.C72663.AnonymousClass6 anonymousClass6 = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            anonymousClass6.add(e.freeze());
        }
        return anonymousClass6;
    }
}
