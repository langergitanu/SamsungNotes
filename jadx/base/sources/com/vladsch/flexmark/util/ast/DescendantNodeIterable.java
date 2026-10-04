package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DescendantNodeIterable implements ReversiblePeekingIterable<Node> {
    private ReversiblePeekingIterable<Node> iterable;

    public DescendantNodeIterable(@NotNull ReversiblePeekingIterable<Node> reversiblePeekingIterable) {
        if (reversiblePeekingIterable instanceof DescendantNodeIterable) {
            this.iterable = ((DescendantNodeIterable) reversiblePeekingIterable).iterable;
        } else {
            this.iterable = reversiblePeekingIterable;
        }
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    public boolean isReversed() {
        return this.iterable.isReversed();
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversiblePeekingIterable<Node> reversed() {
        return new DescendantNodeIterable(this.iterable.reversed());
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversiblePeekingIterator<Node> reversedIterator() {
        return new DescendantNodeIterator(this.iterable.reversedIterator());
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
    @NotNull
    public ReversiblePeekingIterator<Node> iterator() {
        return new DescendantNodeIterator(this.iterable.iterator());
    }
}
