package com.vladsch.flexmark.util.collection.iteration;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface ReversibleIterable<E> extends Iterable<E> {
    boolean isReversed();

    @Override // java.lang.Iterable
    @NotNull
    ReversibleIterator<E> iterator();

    @NotNull
    ReversibleIterable<E> reversed();

    @NotNull
    ReversibleIterator<E> reversedIterator();
}
