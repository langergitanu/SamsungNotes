package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IteratorChain<E> implements Iterator<E> {
    private Iterator<? extends E> currentIterator;
    private boolean isLocked;
    private final Queue<Iterator<? extends E>> iteratorQueue = new LinkedList();
    private Iterator<? extends E> lastUsedIterator;

    public IteratorChain() {
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
        }
    }

    private void lockChain() {
        if (this.isLocked) {
            return;
        }
        this.isLocked = true;
    }

    public void addIterator(Iterator<? extends E> it) {
        checkLocked();
        Queue<Iterator<? extends E>> queue = this.iteratorQueue;
        Objects.requireNonNull(it, "iterator");
        queue.add(it);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        lockChain();
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.hasNext();
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    @Override // java.util.Iterator
    public E next() {
        lockChain();
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        lockChain();
        if (this.currentIterator == null) {
            updateCurrentIterator();
        }
        this.lastUsedIterator.remove();
    }

    public int size() {
        return this.iteratorQueue.size();
    }

    public void updateCurrentIterator() {
        if (this.currentIterator == null) {
            if (this.iteratorQueue.isEmpty()) {
                this.currentIterator = EmptyIterator.emptyIterator();
            } else {
                this.currentIterator = this.iteratorQueue.remove();
            }
            this.lastUsedIterator = this.currentIterator;
        }
        while (!this.currentIterator.hasNext() && !this.iteratorQueue.isEmpty()) {
            this.currentIterator = this.iteratorQueue.remove();
        }
    }

    public IteratorChain(Collection<? extends Iterator<? extends E>> collection) {
        Iterator<? extends Iterator<? extends E>> it = collection.iterator();
        while (it.hasNext()) {
            addIterator(it.next());
        }
    }

    public IteratorChain(Iterator<? extends E> it) {
        addIterator(it);
    }

    public IteratorChain(Iterator<? extends E>... itArr) {
        for (Iterator<? extends E> it : itArr) {
            addIterator(it);
        }
    }

    public IteratorChain(Iterator<? extends E> it, Iterator<? extends E> it2) {
        addIterator(it);
        addIterator(it2);
    }
}
