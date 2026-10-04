package com.vladsch.flexmark.util.collection.iteration;

import java.util.BitSet;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BitSetIterable implements ReversibleIterable<Integer> {

    @NotNull
    private final BitSet bitSet;
    private final boolean reversed;

    public BitSetIterable(@NotNull BitSet bitSet) {
        this(bitSet, false);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    public boolean isReversed() {
        return this.reversed;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIterable<Integer> reversed() {
        return new BitSetIterable(this.bitSet, !this.reversed);
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable
    @NotNull
    public ReversibleIterator<Integer> reversedIterator() {
        return new BitSetIterator(this.bitSet, !this.reversed);
    }

    public BitSetIterable(@NotNull BitSet bitSet, boolean z) {
        this.bitSet = bitSet;
        this.reversed = z;
    }

    @Override // com.vladsch.flexmark.util.collection.iteration.ReversibleIterable, java.lang.Iterable
    @NotNull
    public ReversibleIterator<Integer> iterator() {
        return new BitSetIterator(this.bitSet, this.reversed);
    }
}
