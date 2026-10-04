package com.vladsch.flexmark.util.collection.iteration;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Reverse<T> implements ReversibleIterable<T> {
    private final boolean isReversed;

    @NotNull
    private final List<T> list;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReversedListIterator<T> implements ReversibleIterator<T> {
        private int index;
        private final boolean isReversed;

        @NotNull
        private final List<T> list;

        public ReversedListIterator(@NotNull List<T> list, boolean z) {
            this.list = list;
            this.isReversed = z;
            if (z) {
                this.index = list.size() != 0 ? list.size() - 1 : -1;
            } else {
                this.index = list.size() != 0 ? 0 : -1;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index != -1;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterator
        public boolean isReversed() {
            return this.isReversed;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = this.list.get(this.index);
            int i = this.index;
            if (i != -1) {
                if (this.isReversed) {
                    this.index = i - 1;
                    return t;
                }
                if (i == this.list.size() - 1) {
                    this.index = -1;
                    return t;
                }
                this.index++;
            }
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    public Reverse(@NotNull List<T> list) {
        this(list, true);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    public boolean isReversed() {
        return this.isReversed;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIterable<T> reversed() {
        return new Reverse(this.list, !this.isReversed);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIterator<T> reversedIterator() {
        return new ReversedListIterator(this.list, !this.isReversed);
    }

    public Reverse(@NotNull List<T> list, boolean z) {
        this.list = list;
        this.isReversed = z;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
    @NotNull
    public ReversibleIterator<T> iterator() {
        return new ReversedListIterator(this.list, this.isReversed);
    }
}
