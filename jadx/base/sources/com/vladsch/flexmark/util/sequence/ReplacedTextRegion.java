package com.vladsch.flexmark.util.sequence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ReplacedTextRegion {
    private final Range base;
    private final Range original;
    private final Range replaced;

    public ReplacedTextRegion(Range range, Range range2, Range range3) {
        this.base = range;
        this.original = range2;
        this.replaced = range3;
    }

    public boolean containsBaseIndex(int i) {
        return this.base.contains(i);
    }

    public boolean containsOriginalIndex(int i) {
        return this.original.contains(i);
    }

    public boolean containsReplacedIndex(int i) {
        return this.replaced.contains(i);
    }

    public Range getBaseRange() {
        return this.base;
    }

    public Range getOriginalRange() {
        return this.original;
    }

    public Range getReplacedRange() {
        return this.replaced;
    }
}
