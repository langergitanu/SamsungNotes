package com.vladsch.flexmark.util.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class IndexedItemSetMapBase<K, S, M> implements IndexedItemSetMap<K, S, M> {
    protected final HashMap<K, S> bag;

    public IndexedItemSetMapBase() {
        this(0);
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public boolean addItem(@NotNull M m, int i) {
        K kMapKey = mapKey(m);
        S sNewSet = this.bag.get(kMapKey);
        if (sNewSet == null) {
            sNewSet = newSet();
            this.bag.put(kMapKey, sNewSet);
        }
        return addSetItem(sNewSet, i);
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public abstract boolean addSetItem(@NotNull S s, int i);

    @Override // java.util.Map
    public void clear() {
        this.bag.clear();
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public boolean containsItem(@NotNull M m, int i) {
        S s = this.bag.get(mapKey(m));
        return s != null && containsSetItem(s, i);
    }

    @Override // java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return this.bag.containsKey(obj);
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public abstract boolean containsSetItem(@NotNull S s, int i);

    @Override // java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return this.bag.containsValue(obj);
    }

    @Override // java.util.Map
    @NotNull
    public Set<Map.Entry<K, S>> entrySet() {
        return this.bag.entrySet();
    }

    @Override // java.util.Map
    @Nullable
    public S get(@Nullable Object obj) {
        return this.bag.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    @Override // java.util.Map
    @NotNull
    public Set<K> keySet() {
        return this.bag.keySet();
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMap
    @NotNull
    public abstract K mapKey(@NotNull M m);

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMap
    @NotNull
    public abstract S newSet();

    @Override // java.util.Map
    @Nullable
    public S put(@NotNull K k, @NotNull S s) {
        return this.bag.put(k, s);
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends S> map) {
        this.bag.putAll(map);
    }

    @Override // java.util.Map
    @Nullable
    public S remove(@Nullable Object obj) {
        return this.bag.remove(obj);
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public boolean removeItem(@NotNull M m, int i) {
        S s = this.bag.get(mapKey(m));
        return s != null && removeSetItem(s, i);
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public abstract boolean removeSetItem(@NotNull S s, int i);

    @Override // java.util.Map
    public int size() {
        return this.bag.size();
    }

    @Override // java.util.Map
    @NotNull
    public Collection<S> values() {
        return this.bag.values();
    }

    public IndexedItemSetMapBase(int i) {
        this.bag = new HashMap<>();
    }
}
