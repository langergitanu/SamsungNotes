package com.vladsch.flexmark.util.sequence.builder.tree;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class SegmentTreePos {
    public final int iterations;
    public final int pos;
    public final int startIndex;

    public SegmentTreePos(int i, int i2, int i4) {
        this.pos = i;
        this.startIndex = i2;
        this.iterations = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SegmentTreePos)) {
            return false;
        }
        SegmentTreePos segmentTreePos = (SegmentTreePos) obj;
        return this.pos == segmentTreePos.pos && this.startIndex == segmentTreePos.startIndex;
    }

    public int hashCode() {
        return (this.pos * 31) + this.startIndex;
    }

    public String toString() {
        int i = this.pos;
        int i2 = this.startIndex;
        return AbstractC2821a.m2223n(AbstractC0622a.m1173s(i, i2, Parse.BRACKET_LCB, ", s: ", ", i: "), "}", this.iterations);
    }
}
