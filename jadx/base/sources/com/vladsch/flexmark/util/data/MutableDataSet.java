package com.vladsch.flexmark.util.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MutableDataSet extends DataSet implements MutableDataHolder {
    public MutableDataSet() {
    }

    public static MutableDataSet merge(DataHolder... dataHolderArr) {
        MutableDataSet mutableDataSet = new MutableDataSet();
        for (DataHolder dataHolder : dataHolderArr) {
            if (dataHolder != null) {
                mutableDataSet.dataSet.putAll(dataHolder.getAll());
            }
        }
        return mutableDataSet;
    }

    @Override // com.vladsch.flexmark.util.data.DataSet, com.vladsch.flexmark.util.data.DataHolder
    @Nullable
    public Object getOrCompute(@NotNull DataKeyBase<?> dataKeyBase, @NotNull DataValueFactory<?> dataValueFactory) {
        if (this.dataSet.containsKey(dataKeyBase)) {
            return this.dataSet.get(dataKeyBase);
        }
        Object objApply = dataValueFactory.apply((DataHolder) this);
        this.dataSet.put(dataKeyBase, objApply);
        return objApply;
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public /* bridge */ /* synthetic */ MutableDataHolder remove(@NotNull DataKeyBase dataKeyBase) {
        return remove((DataKeyBase<?>) dataKeyBase);
    }

    @NotNull
    public /* bridge */ /* synthetic */ MutableDataHolder set(@NotNull DataKey dataKey, @NotNull Object obj) {
        return set((DataKey<Object>) dataKey, obj);
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder, com.vladsch.flexmark.util.data.MutableDataSetter
    @NotNull
    public MutableDataHolder setIn(@NotNull MutableDataHolder mutableDataHolder) {
        mutableDataHolder.setAll(this);
        return mutableDataHolder;
    }

    @Override // com.vladsch.flexmark.util.data.DataSet, com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public MutableDataSet toDataSet() {
        return this;
    }

    @Override // com.vladsch.flexmark.util.data.DataSet, com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public MutableDataSet toMutable() {
        return this;
    }

    public MutableDataSet(@Nullable DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public MutableDataSet clear() {
        this.dataSet.clear();
        return this;
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public MutableDataSet remove(@NotNull DataKeyBase<?> dataKeyBase) {
        this.dataSet.remove(dataKeyBase);
        return this;
    }

    @NotNull
    public /* bridge */ /* synthetic */ MutableDataHolder set(@NotNull NullableDataKey nullableDataKey, @Nullable Object obj) {
        return set((NullableDataKey<Object>) nullableDataKey, obj);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public MutableDataSet setAll(@NotNull DataHolder dataHolder) {
        this.dataSet.putAll(dataHolder.getAll());
        return this;
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataHolder
    @NotNull
    public MutableDataSet setFrom(@NotNull MutableDataSetter mutableDataSetter) {
        mutableDataSetter.setIn(this);
        return this;
    }

    @Override // com.vladsch.flexmark.util.data.DataSet, com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public DataSet toImmutable() {
        return new DataSet(this);
    }

    @NotNull
    public <T> MutableDataSet set(@NotNull DataKey<T> dataKey, @NotNull T t) {
        return set((DataKeyBase) dataKey, (Object) t);
    }

    @NotNull
    public <T> MutableDataSet set(@NotNull NullableDataKey<T> nullableDataKey, @Nullable T t) {
        return set((DataKeyBase) nullableDataKey, (Object) t);
    }

    private <T> MutableDataSet set(@NotNull DataKeyBase<T> dataKeyBase, T t) {
        this.dataSet.put(dataKeyBase, t);
        return this;
    }
}
