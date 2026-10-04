package com.vladsch.flexmark.util.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MutableScopedDataSet extends MutableDataSet {
    protected final DataHolder parent;

    public MutableScopedDataSet(DataHolder dataHolder) {
        this.parent = dataHolder;
    }

    @Override // com.vladsch.flexmark.util.data.DataSet, com.vladsch.flexmark.util.data.DataHolder
    public boolean contains(@NotNull DataKeyBase<?> dataKeyBase) {
        if (super.contains(dataKeyBase)) {
            return true;
        }
        DataHolder dataHolder = this.parent;
        return dataHolder != null && dataHolder.contains(dataKeyBase);
    }

    @Override // com.vladsch.flexmark.util.data.DataSet, com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public Map<? extends DataKeyBase<?>, Object> getAll() {
        if (this.parent == null) {
            return super.getAll();
        }
        HashMap map = new HashMap(super.getAll());
        for (DataKeyBase<?> dataKeyBase : this.parent.getKeys()) {
            if (!contains(dataKeyBase)) {
                map.put(dataKeyBase, dataKeyBase.get(this.parent));
            }
        }
        return map;
    }

    @Override // com.vladsch.flexmark.util.data.DataSet, com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public Collection<? extends DataKeyBase<?>> getKeys() {
        if (this.parent == null) {
            return super.getKeys();
        }
        ArrayList arrayList = new ArrayList(super.getKeys());
        for (DataKeyBase<?> dataKeyBase : this.parent.getKeys()) {
            if (!contains(dataKeyBase)) {
                arrayList.add(dataKeyBase);
            }
        }
        return arrayList;
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataSet, com.vladsch.flexmark.util.data.DataSet, com.vladsch.flexmark.util.data.DataHolder
    @Nullable
    public Object getOrCompute(@NotNull DataKeyBase<?> dataKeyBase, @NotNull DataValueFactory<?> dataValueFactory) {
        return (this.parent == null || super.contains(dataKeyBase) || !this.parent.contains(dataKeyBase)) ? super.getOrCompute(dataKeyBase, dataValueFactory) : this.parent.getOrCompute(dataKeyBase, dataValueFactory);
    }

    public DataHolder getParent() {
        return this.parent;
    }

    public MutableScopedDataSet(DataHolder dataHolder, MutableDataHolder mutableDataHolder) {
        super(mutableDataHolder);
        this.parent = dataHolder;
    }
}
