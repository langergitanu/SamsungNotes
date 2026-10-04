package com.vladsch.flexmark.util.collection;

import com.vladsch.flexmark.util.collection.iteration.BitSetIterable;
import com.vladsch.flexmark.util.collection.iteration.IndexedIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ClassificationBag<K, V> {

    @NotNull
    final IndexedItemBitSetMap<K, V> bag;

    @Nullable
    final CollectionHost<V> host;

    @NotNull
    private final OrderedSet<V> items;

    public ClassificationBag(Function<V, K> function) {
        this(0, function);
    }

    public boolean add(@Nullable V v) {
        return this.items.add(v);
    }

    @SafeVarargs
    @NotNull
    public final BitSet categoriesBitSet(@NotNull K... kArr) {
        BitSet bitSet = new BitSet();
        for (K k : kArr) {
            BitSet bitSet2 = this.bag.get(k);
            if (bitSet2 != null) {
                bitSet.or(bitSet2);
            }
        }
        return bitSet;
    }

    public void clear() {
        this.items.clear();
    }

    public boolean contains(@Nullable V v) {
        return this.items.contains(v);
    }

    public boolean containsCategory(@Nullable K k) {
        BitSet bitSet = this.bag.get(k);
        return (bitSet == null || bitSet.isEmpty()) ? false : true;
    }

    public int getCategoryCount(@Nullable K k) {
        BitSet bitSet = this.bag.get(k);
        if (bitSet == null) {
            return 0;
        }
        return bitSet.cardinality();
    }

    @SafeVarargs
    @NotNull
    public final <X> ReversibleIterable<X> getCategoryItems(@NotNull Class<? extends X> cls, @NotNull K... kArr) {
        return new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), new BitSetIterable(categoriesBitSet(kArr), false));
    }

    @SafeVarargs
    @NotNull
    public final <X> ReversibleIterable<X> getCategoryItemsReversed(@NotNull Class<? extends X> cls, @NotNull K... kArr) {
        return new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), new BitSetIterable(categoriesBitSet(kArr), true));
    }

    @NotNull
    public Map<K, BitSet> getCategoryMap() {
        return this.bag;
    }

    @Nullable
    public BitSet getCategorySet(@Nullable K k) {
        return this.bag.get(k);
    }

    @NotNull
    public OrderedSet<V> getItems() {
        return this.items;
    }

    public int getModificationCount() {
        return this.items.getModificationCount();
    }

    public boolean remove(@Nullable V v) {
        return this.items.remove(v);
    }

    public ClassificationBag(@NotNull Function<V, K> function, @Nullable CollectionHost<V> collectionHost) {
        this(0, function, collectionHost);
    }

    @NotNull
    public final <X> ReversibleIterable<X> getCategoryItems(@NotNull Class<? extends X> cls, @NotNull Collection<? extends K> collection) {
        return new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), new BitSetIterable(categoriesBitSet(collection), false));
    }

    @NotNull
    public final <X> ReversibleIterable<X> getCategoryItemsReversed(@NotNull Class<? extends X> cls, @NotNull Collection<? extends K> collection) {
        return new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), new BitSetIterable(categoriesBitSet(collection), true));
    }

    public boolean remove(int i) {
        return this.items.removeIndex(i);
    }

    public ClassificationBag(int i, @NotNull Function<V, K> function) {
        this(i, function, null);
    }

    @NotNull
    public final <X> ReversibleIterable<X> getCategoryItems(@NotNull Class<? extends X> cls, @NotNull BitSet bitSet) {
        return new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), new BitSetIterable(bitSet, false));
    }

    @NotNull
    public final <X> ReversibleIterable<X> getCategoryItemsReversed(@NotNull Class<? extends X> cls, @NotNull BitSet bitSet) {
        return new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), new BitSetIterable(bitSet, true));
    }

    public ClassificationBag(int i, @NotNull Function<V, K> function, @Nullable CollectionHost<V> collectionHost) {
        this.host = collectionHost;
        this.items = new OrderedSet<>(i, new CollectionHost<V>() { // from class: com.vladsch.flexmark.util.collection.ClassificationBag.1
            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void adding(int i2, @Nullable V v, @Nullable Object obj) {
                CollectionHost<V> collectionHost2 = ClassificationBag.this.host;
                if (collectionHost2 != null && !collectionHost2.skipHostUpdate()) {
                    ClassificationBag.this.host.adding(i2, v, obj);
                }
                if (v != null) {
                    ClassificationBag.this.bag.addItem(v, i2);
                }
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void addingNulls(int i2) {
                CollectionHost<V> collectionHost2 = ClassificationBag.this.host;
                if (collectionHost2 == null || collectionHost2.skipHostUpdate()) {
                    return;
                }
                ClassificationBag.this.host.addingNulls(i2);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void clearing() {
                CollectionHost<V> collectionHost2 = ClassificationBag.this.host;
                if (collectionHost2 != null && !collectionHost2.skipHostUpdate()) {
                    ClassificationBag.this.host.clearing();
                }
                ClassificationBag.this.bag.clear();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public int getIteratorModificationCount() {
                return ClassificationBag.this.getModificationCount();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public Object removing(int i2, @Nullable V v) {
                CollectionHost<V> collectionHost2 = ClassificationBag.this.host;
                if (collectionHost2 != null && !collectionHost2.skipHostUpdate()) {
                    ClassificationBag.this.host.removing(i2, v);
                }
                if (v == null) {
                    return null;
                }
                ClassificationBag.this.bag.removeItem(v, i2);
                return null;
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public boolean skipHostUpdate() {
                return false;
            }
        });
        this.bag = new IndexedItemBitSetMap<>(function);
    }

    @NotNull
    public final BitSet categoriesBitSet(@NotNull Collection<? extends K> collection) {
        BitSet bitSet = new BitSet();
        Iterator<? extends K> it = collection.iterator();
        while (it.hasNext()) {
            BitSet bitSet2 = this.bag.get(it.next());
            if (bitSet2 != null) {
                bitSet.or(bitSet2);
            }
        }
        return bitSet;
    }
}
