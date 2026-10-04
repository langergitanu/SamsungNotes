package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class NodeIterator implements ReversiblePeekingIterator<Node> {
    public static final ReversiblePeekingIterator<Node> EMPTY = new ReversiblePeekingIterator<Node>() { // from class: com.vladsch.flexmark.util.ast.NodeIterator.1
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterator
        public boolean isReversed() {
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator
        @Nullable
        public Node peek() {
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
        }

        @Override // java.util.Iterator
        public Node next() {
            throw new NoSuchElementException();
        }
    };
    final Node firstNode;
    final Node lastNode;
    Node node;
    Node result;
    final boolean reversed;

    public NodeIterator(Node node) {
        this(node, null, false);
    }

    @Override // java.util.Iterator
    public void forEachRemaining(Consumer<? super Node> consumer) {
        consumer.getClass();
        while (hasNext()) {
            consumer.accept(next());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.node != null;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterator
    public boolean isReversed() {
        return this.reversed;
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

    public NodeIterator(Node node, boolean z) {
        this(node, null, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    @Override // java.util.Iterator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Node next() {
        this.result = null;
        Node node = this.node;
        if (node == null) {
            throw new NoSuchElementException();
        }
        this.result = node;
        Node previous = this.reversed ? node.getPrevious() : node.getNext();
        this.node = previous;
        if (previous != null) {
            if (this.result == (this.reversed ? this.firstNode : this.lastNode)) {
                this.node = null;
            }
        }
        return this.result;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator
    @Nullable
    public Node peek() {
        Node node = this.node;
        if (node != null) {
            return node;
        }
        return null;
    }

    public NodeIterator(Node node, Node node2) {
        this(node, node2, false);
    }

    public NodeIterator(Node node, Node node2, boolean z) {
        node.getClass();
        this.firstNode = node;
        this.lastNode = node2;
        this.reversed = z;
        this.node = z ? node2 : node;
    }
}
