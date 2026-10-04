package com.vladsch.flexmark.util.collection.iteration;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IndexedItemIterable<R> implements ReversibleIndexedIterable<R> {

    @NotNull
    private final Indexed<R> items;
    private final boolean reversed;

    public IndexedItemIterable(@NotNull Indexed<R> indexed) {
        this(indexed, false);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    public boolean isReversed() {
        return this.reversed;
    }

    public IndexedItemIterable(@NotNull Indexed<R> indexed, boolean z) {
        this.items = indexed;
        this.reversed = z;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIndexedIterable<R> reversed() {
        return new IndexedItemIterable(this.items, !this.reversed);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIndexedIterator<R> reversedIterator() {
        return new IndexedItemIterator(this.items, !this.reversed);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
    @NotNull
    public ReversibleIndexedIterator<R> iterator() {
        return new IndexedItemIterator(this.items, this.reversed);
    }
}
