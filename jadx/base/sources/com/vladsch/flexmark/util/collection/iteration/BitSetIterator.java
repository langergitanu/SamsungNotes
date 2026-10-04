package com.vladsch.flexmark.util.collection.iteration;

import java.util.BitSet;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BitSetIterator implements ReversibleIterator<Integer> {

    @NotNull
    private final BitSet bitSet;
    private int last;
    private int next;
    private final boolean reversed;

    public BitSetIterator(@NotNull BitSet bitSet) {
        this(bitSet, false);
    }

    @Override // java.util.Iterator
    public void forEachRemaining(@NotNull Consumer<? super Integer> consumer) {
        while (hasNext()) {
            consumer.accept(next());
        }
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
    public void remove() {
        int i = this.last;
        if (i == -1) {
            throw new NoSuchElementException();
        }
        this.bitSet.clear(i);
    }

    public BitSetIterator(@NotNull BitSet bitSet, boolean z) {
        this.bitSet = bitSet;
        this.reversed = z;
        this.next = z ? bitSet.previousSetBit(bitSet.length()) : bitSet.nextSetBit(0);
        this.last = -1;
    }

    @Override // java.util.Iterator
    public Integer next() {
        int i = this.next;
        int iNextSetBit = -1;
        if (i == -1) {
            throw new NoSuchElementException();
        }
        this.last = i;
        if (!this.reversed) {
            iNextSetBit = this.bitSet.nextSetBit(i + 1);
        } else if (i != 0) {
            iNextSetBit = this.bitSet.previousSetBit(i - 1);
        }
        this.next = iNextSetBit;
        return Integer.valueOf(this.last);
    }
}
