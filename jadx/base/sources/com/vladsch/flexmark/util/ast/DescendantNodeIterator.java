package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import java.util.Stack;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DescendantNodeIterator implements ReversiblePeekingIterator<Node> {
    private final boolean isReversed;

    @NotNull
    private ReversiblePeekingIterator<Node> iterator;

    @Nullable
    private Stack<ReversiblePeekingIterator<Node>> iteratorStack;
    private Node result;

    public DescendantNodeIterator(@NotNull ReversiblePeekingIterator<Node> reversiblePeekingIterator) {
        this.isReversed = reversiblePeekingIterator.isReversed();
        this.iterator = reversiblePeekingIterator instanceof DescendantNodeIterator ? ((DescendantNodeIterator) reversiblePeekingIterator).iterator : reversiblePeekingIterator;
        this.iteratorStack = null;
        this.result = null;
    }

    @Override // java.util.Iterator
    public void forEachRemaining(@NotNull Consumer<? super Node> consumer) {
        while (hasNext()) {
            consumer.accept(next());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterator
    public boolean isReversed() {
        return this.isReversed;
    }

    @Override // java.util.Iterator
    public void remove() {
        Node node = this.result;
        if (node == null) {
            throw new IllegalStateException("Either next() was not called yet or the node was removed");
        }
        node.unlink();
        this.result = null;
    }

    @Override // java.util.Iterator
    @NotNull
    public Node next() {
        Node next = this.iterator.next();
        this.result = next;
        if (next.getFirstChild() != null) {
            if (this.iterator.hasNext()) {
                if (this.iteratorStack == null) {
                    this.iteratorStack = new Stack<>();
                }
                this.iteratorStack.push(this.iterator);
            }
            this.iterator = this.isReversed ? this.result.getReversedChildIterator() : this.result.getChildIterator();
        } else {
            Stack<ReversiblePeekingIterator<Node>> stack = this.iteratorStack;
            if (stack != null && !stack.isEmpty() && !this.iterator.hasNext()) {
                this.iterator = this.iteratorStack.pop();
            }
        }
        return this.result;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator
    @Nullable
    public Node peek() {
        return this.iterator.peek();
    }
}
