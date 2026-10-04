package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.util.ported.Predicate;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface INameValueStorage<T> {
    void clear();

    @Nullable
    T get(@NonNull String str);

    @NonNull
    Map<String, T> getAll();

    Iterator<Map.Entry<String, T>> getAllFilteredByKey(Predicate<String> predicate);

    @NonNull
    Set<String> keySet();

    void put(@NonNull String str, @Nullable T t);

    void remove(@NonNull String str);
}
