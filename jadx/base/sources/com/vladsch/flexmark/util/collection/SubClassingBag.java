package com.vladsch.flexmark.util.collection;

import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SubClassingBag<T> {

    @NotNull
    private final ClassificationBag<Class<?>, T> items;

    @NotNull
    private final HashMap<Class<?>, BitSet> subClassMap = new HashMap<>();

    public SubClassingBag(@NotNull ClassificationBag<Class<?>, T> classificationBag, HashMap<Class<?>, List<Class<?>>> map) {
        this.items = classificationBag;
        for (Class<?> cls : map.keySet()) {
            BitSet bitSetCategoriesBitSet = this.items.categoriesBitSet(map.get(cls));
            if (!bitSetCategoriesBitSet.isEmpty()) {
                this.subClassMap.put(cls, bitSetCategoriesBitSet);
            }
        }
    }

    public boolean contains(@Nullable T t) {
        return this.items.contains(t);
    }

    public boolean containsType(@Nullable Class<?> cls) {
        return this.items.containsCategory(cls);
    }

    @NotNull
    public OrderedSet<T> getItems() {
        return this.items.getItems();
    }

    public int getTypeCount(@Nullable Class<?> cls) {
        BitSet bitSet = this.subClassMap.get(cls);
        if (bitSet == null) {
            return 0;
        }
        return bitSet.cardinality();
    }

    public BitSet getTypeSet(@Nullable Class<?> cls) {
        return this.subClassMap.get(cls);
    }

    @NotNull
    public final <X> ReversibleIterable<X> itemsOfType(@NotNull Class<X> cls, @NotNull Class<?>... clsArr) {
        return this.items.getCategoryItems(cls, typeBitSet((Class<?>) cls, clsArr));
    }

    @NotNull
    public final <X> ReversibleIterable<X> reversedItemsOfType(@NotNull Class<X> cls, @NotNull Class<?>... clsArr) {
        return this.items.getCategoryItemsReversed(cls, typeBitSet((Class<?>) cls, clsArr));
    }

    @NotNull
    public final BitSet typeBitSet(@NotNull Class<?> cls, @NotNull Class<?>... clsArr) {
        BitSet bitSet = new BitSet();
        for (Class<?> cls2 : clsArr) {
            if (cls.isAssignableFrom(cls2) && this.subClassMap.containsKey(cls2)) {
                bitSet.or(this.subClassMap.get(cls2));
            }
        }
        return bitSet;
    }

    @NotNull
    public final <X> ReversibleIterable<X> itemsOfType(@NotNull Class<X> cls, @NotNull Collection<Class<?>> collection) {
        return this.items.getCategoryItems(cls, typeBitSet((Class<?>) cls, collection));
    }

    @NotNull
    public final <X> ReversibleIterable<X> reversedItemsOfType(@NotNull Class<X> cls, @NotNull Collection<Class<?>> collection) {
        return this.items.getCategoryItemsReversed(cls, typeBitSet((Class<?>) cls, collection));
    }

    @NotNull
    public final BitSet typeBitSet(@NotNull Class<?> cls, @NotNull Collection<Class<?>> collection) {
        BitSet bitSet = new BitSet();
        for (Class<?> cls2 : collection) {
            if (cls.isAssignableFrom(cls2) && this.subClassMap.containsKey(cls2)) {
                bitSet.or(this.subClassMap.get(cls2));
            }
        }
        return bitSet;
    }
}
