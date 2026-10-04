package com.vladsch.flexmark.util.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DataSet implements DataHolder {
    private static final ArrayList<DataKeyAggregator> ourDataKeyAggregators = new ArrayList<>();
    protected final HashMap<DataKeyBase<?>, Object> dataSet;

    public DataSet() {
        this(null);
    }

    @NotNull
    public static DataHolder aggregateActions(@NotNull DataHolder dataHolder, @NotNull DataHolder dataHolder2) {
        DataSet dataSet = new DataSet(dataHolder);
        dataSet.dataSet.putAll(dataHolder2.getAll());
        Iterator<DataKeyAggregator> it = ourDataKeyAggregators.iterator();
        while (it.hasNext()) {
            dataSet = it.next().aggregateActions(dataSet, dataHolder, dataHolder2).toDataSet();
        }
        return dataSet;
    }

    public static boolean invokeSetContains(@Nullable Set<Class<?>> set, @NotNull DataKeyAggregator dataKeyAggregator) {
        if (set == null) {
            return false;
        }
        return set.contains(dataKeyAggregator.getClass());
    }

    public static boolean isAggregatorRegistered(@NotNull DataKeyAggregator dataKeyAggregator) {
        Iterator<DataKeyAggregator> it = ourDataKeyAggregators.iterator();
        while (it.hasNext()) {
            if (it.next().getClass() == dataKeyAggregator.getClass()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static DataSet merge(@NotNull DataHolder... dataHolderArr) {
        DataSet dataSet = new DataSet();
        for (DataHolder dataHolder : dataHolderArr) {
            dataSet.dataSet.putAll(dataHolder.getAll());
        }
        return dataSet;
    }

    public static void registerDataKeyAggregator(@NotNull DataKeyAggregator dataKeyAggregator) {
        if (isAggregatorRegistered(dataKeyAggregator)) {
            throw new IllegalStateException("Aggregator " + dataKeyAggregator + " is already registered");
        }
        int i = 0;
        while (true) {
            ArrayList<DataKeyAggregator> arrayList = ourDataKeyAggregators;
            if (i >= arrayList.size()) {
                arrayList.add(dataKeyAggregator);
                return;
            }
            DataKeyAggregator dataKeyAggregator2 = arrayList.get(i);
            if (invokeSetContains(dataKeyAggregator2.invokeAfterSet(), dataKeyAggregator)) {
                if (!invokeSetContains(dataKeyAggregator.invokeAfterSet(), dataKeyAggregator2)) {
                    arrayList.add(i, dataKeyAggregator);
                    return;
                }
                throw new IllegalStateException("Circular invokeAfter dependencies for " + dataKeyAggregator + " and " + dataKeyAggregator2);
            }
            i++;
        }
    }

    @NotNull
    public DataHolder aggregate() {
        Iterator<DataKeyAggregator> it = ourDataKeyAggregators.iterator();
        DataHolder dataHolderAggregate = this;
        while (it.hasNext()) {
            dataHolderAggregate = it.next().aggregate(dataHolderAggregate);
        }
        return dataHolderAggregate;
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    public boolean contains(@NotNull DataKeyBase<?> dataKeyBase) {
        return this.dataSet.containsKey(dataKeyBase);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataSet) {
            return this.dataSet.equals(((DataSet) obj).dataSet);
        }
        return false;
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public Map<? extends DataKeyBase<?>, Object> getAll() {
        return this.dataSet;
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public Collection<? extends DataKeyBase<?>> getKeys() {
        return this.dataSet.keySet();
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @Nullable
    public Object getOrCompute(@NotNull DataKeyBase<?> dataKeyBase, @NotNull DataValueFactory<?> dataValueFactory) {
        return this.dataSet.containsKey(dataKeyBase) ? this.dataSet.get(dataKeyBase) : dataValueFactory.apply((DataHolder) this);
    }

    public int hashCode() {
        return this.dataSet.hashCode();
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public DataSet toDataSet() {
        return this;
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public DataSet toImmutable() {
        return this;
    }

    public String toString() {
        return "DataSet{dataSet=" + this.dataSet + "}";
    }

    public DataSet(@Nullable DataHolder dataHolder) {
        if (dataHolder == null) {
            this.dataSet = new HashMap<>();
        } else {
            this.dataSet = new HashMap<>(dataHolder.getAll());
        }
    }

    @Override // com.vladsch.flexmark.util.data.DataHolder
    @NotNull
    public MutableDataSet toMutable() {
        return new MutableDataSet(this);
    }

    @NotNull
    public static DataHolder aggregate(@Nullable DataHolder dataHolder, @Nullable DataHolder dataHolder2) {
        if (dataHolder == null && dataHolder2 == null) {
            return new DataSet();
        }
        if (dataHolder2 == null) {
            return dataHolder;
        }
        if (dataHolder == null) {
            return dataHolder2.toDataSet().aggregate().toImmutable();
        }
        return aggregateActions(dataHolder, dataHolder2).toDataSet().aggregate().toImmutable();
    }
}
