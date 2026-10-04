package com.vladsch.flexmark.util.collection.iteration;

import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class IndexedIterator<R, S, I extends ReversibleIterator<Integer>> implements ReversibleIndexedIterator<R> {
    private final Indexed<S> items;
    private final I iterator;
    private int lastIndex = -1;
    private int modificationCount;

    public IndexedIterator(@NotNull Indexed<S> indexed, @NotNull I i) {
        this.items = indexed;
        this.iterator = i;
        this.modificationCount = indexed.modificationCount();
    }

    @Override // java.util.Iterator
    public void forEachRemaining(@NotNull Consumer<? super R> consumer) {
        while (hasNext()) {
            consumer.accept(next());
        }
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator
    public int getIndex() {
        int i = this.lastIndex;
        if (i >= 0) {
            return i;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterator
    public boolean isReversed() {
        return this.iterator.isReversed();
    }

    @Override // java.util.Iterator
    @NotNull
    public R next() {
        if (this.modificationCount != this.items.modificationCount()) {
            throw new ConcurrentModificationException();
        }
        int iIntValue = ((Integer) this.iterator.next()).intValue();
        this.lastIndex = iIntValue;
        return this.items.get(iIntValue);
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.lastIndex == -1) {
            throw new NoSuchElementException();
        }
        if (this.modificationCount != this.items.modificationCount()) {
            throw new ConcurrentModificationException();
        }
        this.items.removeAt(this.lastIndex);
        this.lastIndex = -1;
        this.modificationCount = this.items.modificationCount();
    }
}
