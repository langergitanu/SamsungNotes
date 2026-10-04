package com.samsung.android.support.senl.p148nt.data.database.core.query.common;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SplitTaskExecutor<Input, Output> {
    private final Function<List<Input>, List<Output>> mFunction;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CountFunction<I> {
        int apply(I i);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SplitPredicate<I> {
        boolean test(I i);
    }

    public SplitTaskExecutor(@NonNull Function<List<Input>, List<Output>> function) {
        this.mFunction = function;
    }

    public static <T> boolean getBoolean(@NonNull SplitPredicate<List<T>> splitPredicate, @NonNull Collection<T> collection) {
        List arrayList = new ArrayList(collection);
        while (!arrayList.isEmpty()) {
            int iMin = Math.min(500, arrayList.size());
            if (splitPredicate.test(arrayList.subList(0, iMin))) {
                return true;
            }
            arrayList = arrayList.subList(iMin, arrayList.size());
        }
        return false;
    }

    public static <T> int getInt(@NonNull CountFunction<Collection<T>> countFunction, @NonNull Collection<T> collection) {
        List arrayList = new ArrayList(collection);
        int iApply = 0;
        while (!arrayList.isEmpty()) {
            int iMin = Math.min(500, arrayList.size());
            iApply += countFunction.apply(arrayList.subList(0, iMin));
            arrayList = arrayList.subList(iMin, arrayList.size());
        }
        return iApply;
    }

    @NonNull
    public List<Output> execute(@NonNull Collection<Input> collection) {
        List arrayList = new ArrayList(collection);
        ArrayList arrayList2 = new ArrayList();
        while (!arrayList.isEmpty()) {
            int iMin = Math.min(500, arrayList.size());
            List<Output> listMo22196apply = this.mFunction.mo22196apply(arrayList.subList(0, iMin));
            if (listMo22196apply != null) {
                arrayList2.addAll(listMo22196apply);
            }
            arrayList = arrayList.subList(iMin, arrayList.size());
        }
        return arrayList2;
    }
}
