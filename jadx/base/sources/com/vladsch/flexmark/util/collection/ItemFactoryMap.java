package com.vladsch.flexmark.util.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ItemFactoryMap<I, P> implements Map<Function<P, I>, I> {
    protected final HashMap<Function<P, I>, I> itemMap;

    @NotNull
    protected final P param;

    public ItemFactoryMap(@NotNull P p) {
        this(p, 0);
    }

    @Override // java.util.Map
    public void clear() {
        this.itemMap.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return this.itemMap.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return this.itemMap.containsValue(obj);
    }

    @Override // java.util.Map
    @NotNull
    public Set<Map.Entry<Function<P, I>, I>> entrySet() {
        return this.itemMap.entrySet();
    }

    @Override // java.util.Map
    @Nullable
    public I get(@Nullable Object obj) {
        if (obj instanceof Function) {
            return getItem((Function) obj);
        }
        return null;
    }

    public I getItem(Function<P, I> function) {
        I i = this.itemMap.get(function);
        if (i != null) {
            return i;
        }
        I iApply = function.apply(this.param);
        this.itemMap.put(function, iApply);
        return iApply;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.itemMap.isEmpty();
    }

    @Override // java.util.Map
    @NotNull
    public Set<Function<P, I>> keySet() {
        return this.itemMap.keySet();
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends Function<P, I>, ? extends I> map) {
        this.itemMap.putAll(map);
    }

    @Override // java.util.Map
    @Nullable
    public I remove(@Nullable Object obj) {
        return this.itemMap.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.itemMap.size();
    }

    @Override // java.util.Map
    @NotNull
    public Collection<I> values() {
        return this.itemMap.values();
    }

    public ItemFactoryMap(@NotNull P p, int i) {
        this.itemMap = new HashMap<>(i);
        this.param = p;
    }

    @Override // java.util.Map
    @Nullable
    public I put(@NotNull Function<P, I> function, @NotNull I i) {
        return this.itemMap.put(function, i);
    }
}
