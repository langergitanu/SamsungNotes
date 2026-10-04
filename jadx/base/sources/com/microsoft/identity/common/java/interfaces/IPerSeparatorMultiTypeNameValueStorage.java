package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.util.ported.Predicate;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IPerSeparatorMultiTypeNameValueStorage<T> {
    void clear(@NonNull T t);

    @NonNull
    Map<String, String> getAll(@NonNull T t);

    Iterator<Map.Entry<String, String>> getAllFilteredByKey(@NonNull T t, @NonNull Predicate<String> predicate);

    long getLong(@NonNull T t, @NonNull String str);

    @Nullable
    String getString(@NonNull T t, @NonNull String str);

    @NonNull
    Set<String> keySet(@NonNull T t);

    void putLong(@NonNull T t, @NonNull String str, long j);

    void putString(@NonNull T t, @NonNull String str, @Nullable String str2);

    void remove(@NonNull T t, @NonNull String str);
}
