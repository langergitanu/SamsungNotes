package com.vladsch.flexmark.util.collection;

import java.util.BitSet;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IndexedItemBitSetMap<K, M> extends IndexedItemSetMapBase<K, BitSet, M> {

    @NotNull
    private final Function<M, K> computable;

    public IndexedItemBitSetMap(@NotNull Function<M, K> function) {
        this(function, 0);
    }

    @NotNull
    public Function<M, K> getComputable() {
        return this.computable;
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMapBase, com.vladsch.flexmark.util.collection.IndexedItemSetMap
    @NotNull
    public K mapKey(@NotNull M m) {
        return this.computable.apply(m);
    }

    public IndexedItemBitSetMap(@NotNull Function<M, K> function, int i) {
        super(i);
        this.computable = function;
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMapBase, com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public boolean addSetItem(@NotNull BitSet bitSet, int i) {
        boolean z = bitSet.get(i);
        bitSet.set(i);
        return z;
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMapBase, com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public boolean containsSetItem(@NotNull BitSet bitSet, int i) {
        return bitSet.get(i);
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMapBase, com.vladsch.flexmark.util.collection.IndexedItemSetMap
    @NotNull
    public BitSet newSet() {
        return new BitSet();
    }

    @Override // com.vladsch.flexmark.util.collection.IndexedItemSetMapBase, com.vladsch.flexmark.util.collection.IndexedItemSetMap
    public boolean removeSetItem(@NotNull BitSet bitSet, int i) {
        boolean z = bitSet.get(i);
        bitSet.clear(i);
        return z;
    }
}
