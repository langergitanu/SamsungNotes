package com.vladsch.flexmark.util.data;

import java.util.Collection;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface DataHolder extends MutableDataSetter {
    public static final DataHolder NULL = new DataSet();

    boolean contains(@NotNull DataKeyBase<?> dataKeyBase);

    @Deprecated
    @Nullable
    default <T> T get(@NotNull DataKey<T> dataKey) {
        return dataKey.get(this);
    }

    @NotNull
    Map<? extends DataKeyBase<?>, Object> getAll();

    @NotNull
    Collection<? extends DataKeyBase<?>> getKeys();

    Object getOrCompute(@NotNull DataKeyBase<?> dataKeyBase, @NotNull DataValueFactory<?> dataValueFactory);

    @Override // com.vladsch.flexmark.util.data.MutableDataSetter
    @NotNull
    default MutableDataHolder setIn(@NotNull MutableDataHolder mutableDataHolder) {
        return mutableDataHolder.setAll(this);
    }

    @NotNull
    default DataSet toDataSet() {
        return this instanceof DataSet ? (DataSet) this : this instanceof MutableDataHolder ? new MutableDataSet(this) : new DataSet(this);
    }

    @NotNull
    DataHolder toImmutable();

    @NotNull
    MutableDataHolder toMutable();
}
