package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NodeIterable implements ReversiblePeekingIterable<Node> {
    public static final ReversiblePeekingIterable<Node> EMPTY = new ReversiblePeekingIterable<Node>() { // from class: com.vladsch.flexmark.util.ast.NodeIterable.1
        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Node> consumer) {
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
        public boolean isReversed() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
        @NotNull
        public ReversiblePeekingIterable<Node> reversed() {
            return this;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
        @NotNull
        public ReversiblePeekingIterator<Node> reversedIterator() {
            return NodeIterator.EMPTY;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
        @NotNull
        public ReversiblePeekingIterator<Node> iterator() {
            return NodeIterator.EMPTY;
        }
    };
    final Node firstNode;
    final Node lastNode;
    final boolean reversed;

    public NodeIterable(Node node, Node node2, boolean z) {
        this.firstNode = node;
        this.lastNode = node2;
        this.reversed = z;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super Node> consumer) {
        ReversiblePeekingIterator<Node> it = iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    public boolean isReversed() {
        return this.reversed;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversiblePeekingIterable<Node> reversed() {
        return new NodeIterable(this.firstNode, this.lastNode, !this.reversed);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversiblePeekingIterator<Node> reversedIterator() {
        return new NodeIterator(this.firstNode, this.lastNode, !this.reversed);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterable, com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
    @NotNull
    public ReversiblePeekingIterator<Node> iterator() {
        return new NodeIterator(this.firstNode, this.lastNode, this.reversed);
    }
}
