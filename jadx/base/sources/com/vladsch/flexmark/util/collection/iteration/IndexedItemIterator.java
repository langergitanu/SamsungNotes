package com.vladsch.flexmark.util.collection.iteration;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IndexedItemIterator<R> implements ReversibleIndexedIterator<R> {
    private final Indexed<R> items;
    private int last;
    private int modificationCount;
    private int next;
    private final boolean reversed;

    public IndexedItemIterator(@NotNull Indexed<R> indexed) {
        this(indexed, false);
    }

    @Override // java.util.Iterator
    public void forEachRemaining(@NotNull Consumer<? super R> consumer) {
        while (hasNext()) {
            consumer.accept(next());
        }
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator
    public int getIndex() {
        int i = this.last;
        if (i >= 0) {
            return i;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.next != -1;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterator
    public boolean isReversed() {
        return this.reversed;
    }

    @Override // java.util.Iterator
    @NotNull
    public R next() {
        if (this.modificationCount != this.items.modificationCount()) {
            throw new ConcurrentModificationException();
        }
        int i = this.next;
        int i2 = -1;
        if (i == -1) {
            throw new NoSuchElementException();
        }
        this.last = i;
        if (this.reversed) {
            if (i > 0) {
                i2 = i - 1;
            }
        } else if (i != this.items.size() - 1) {
            i2 = this.next + 1;
        }
        this.next = i2;
        return this.items.get(this.last);
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.last == -1) {
            throw new NoSuchElementException();
        }
        if (this.modificationCount != this.items.modificationCount()) {
            throw new ConcurrentModificationException();
        }
        this.items.removeAt(this.last);
        this.last = -1;
        this.modificationCount = this.items.modificationCount();
    }

    public IndexedItemIterator(@NotNull Indexed<R> indexed, boolean z) {
        this.items = indexed;
        this.reversed = z;
        int size = z ? indexed.size() - 1 : 0;
        this.next = size;
        if (size >= indexed.size()) {
            this.next = -1;
        }
        this.last = -1;
        this.modificationCount = indexed.modificationCount();
    }
}
