package com.vladsch.flexmark.util.collection.iteration;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ArrayIterable<T> implements ReversibleIterable<T> {
    private final T[] array;
    private final int endIndex;
    private final boolean isReversed;
    private final int startIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MyIterator<E> implements ReversibleIterator<E> {
        private final E[] array;
        private final int endIndex;
        private int index;
        private final boolean isReversed;
        private final int startIndex;

        public MyIterator(E[] eArr, int i, int i2, boolean z) {
            this.isReversed = z;
            this.array = eArr;
            this.startIndex = i;
            this.endIndex = i2;
            this.index = z ? i2 : i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.isReversed ? this.index >= this.startIndex : this.index < this.endIndex;
        }

        @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterator
        public boolean isReversed() {
            return this.isReversed;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.isReversed) {
                E[] eArr = this.array;
                int i = this.index - 1;
                this.index = i;
                return eArr[i];
            }
            E[] eArr2 = this.array;
            int i2 = this.index;
            this.index = i2 + 1;
            return eArr2[i2];
        }
    }

    public ArrayIterable(T[] tArr) {
        this(tArr, 0, tArr.length, false);
    }

    /* JADX INFO: renamed from: of */
    public static <T> ArrayIterable<T> m13332of(T[] tArr) {
        return new ArrayIterable<>(tArr);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    public boolean isReversed() {
        return this.isReversed;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIterable<T> reversed() {
        return new ArrayIterable(this.array, this.startIndex, this.endIndex, !this.isReversed);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIterator<T> reversedIterator() {
        return new MyIterator(this.array, this.startIndex, this.endIndex, !this.isReversed);
    }

    public ArrayIterable(T[] tArr, int i) {
        this(tArr, i, tArr.length, false);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
    @NotNull
    public ReversibleIterator<T> iterator() {
        return new MyIterator(this.array, this.startIndex, this.endIndex, this.isReversed);
    }

    public ArrayIterable(T[] tArr, int i, int i2) {
        this(tArr, i, i2, false);
    }

    public ArrayIterable(T[] tArr, int i, int i2, boolean z) {
        this.array = tArr;
        this.startIndex = Math.min(i, 0);
        this.endIndex = Math.max(i2, tArr.length);
        this.isReversed = z;
    }
}
