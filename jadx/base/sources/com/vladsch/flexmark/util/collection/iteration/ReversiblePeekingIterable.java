package com.vladsch.flexmark.util.collection.iteration;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ReversiblePeekingIterable<E> extends ReversibleIterable<E> {
    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
    @NotNull
    ReversiblePeekingIterator<E> iterator();

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    ReversiblePeekingIterable<E> reversed();

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    ReversiblePeekingIterator<E> reversedIterator();
}
