package com.vladsch.flexmark.util.collection.iteration;

import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IndexedIterable<R, S, I extends ReversibleIterable<Integer>> implements ReversibleIndexedIterable<R> {

    @NotNull
    private final Indexed<S> items;

    @NotNull
    private final ReversibleIterable<Integer> iterable;

    public IndexedIterable(@NotNull Indexed<S> indexed, @NotNull I i) {
        this.items = indexed;
        this.iterable = i;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    public boolean isReversed() {
        return this.iterable.isReversed();
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIndexedIterable<R> reversed() {
        return new IndexedIterable(this.items, this.iterable.reversed());
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIndexedIterator<R> reversedIterator() {
        return new IndexedIterator(this.items, this.iterable.reversedIterator());
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
    @NotNull
    public ReversibleIndexedIterator<R> iterator() {
        return new IndexedIterator(this.items, this.iterable.iterator());
    }
}
