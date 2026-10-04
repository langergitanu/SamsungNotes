package com.vladsch.flexmark.util.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface MutableDataHolder extends DataHolder, MutableDataSetter {
    @NotNull
    MutableDataHolder clear();

    @Deprecated
    default <T> T get(@NotNull DataKey<T> dataKey) {
        return dataKey.get(this);
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    Object getOrCompute(@NotNull DataKeyBase<?> dataKeyBase, @NotNull DataValueFactory<?> dataValueFactory);

    @NotNull
    MutableDataHolder remove(@NotNull DataKeyBase<?> dataKeyBase);

    @NotNull
    <T> MutableDataHolder set(@NotNull DataKey<T> dataKey, @NotNull T t);

    @NotNull
    <T> MutableDataHolder set(@NotNull NullableDataKey<T> nullableDataKey, @Nullable T t);

    @NotNull
    MutableDataHolder setAll(@NotNull DataHolder dataHolder);

    @NotNull
    MutableDataHolder setFrom(@NotNull MutableDataSetter mutableDataSetter);

    @Override // com.vladsch.flexmark.util.data.DataHolder, com.vladsch.flexmark.util.data.MutableDataSetter
    @NotNull
    MutableDataHolder setIn(@NotNull MutableDataHolder mutableDataHolder);
}
