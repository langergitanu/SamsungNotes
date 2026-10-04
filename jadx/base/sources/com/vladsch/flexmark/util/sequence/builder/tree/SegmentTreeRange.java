package com.vladsch.flexmark.util.sequence.builder.tree;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SegmentTreeRange {
    public final int endIndex;
    public final int endOffset;
    public final int endPos;
    public final int length;
    public final int startIndex;
    public final int startOffset;
    public final int startPos;

    public SegmentTreeRange(int i, int i2, int i4, int i5, int i6, int i7) {
        this.startIndex = i;
        this.endIndex = i2;
        this.startOffset = i4;
        this.endOffset = i5;
        this.startPos = i6;
        this.endPos = i7;
        this.length = i2 - i;
    }

    public String toString() {
        int i = this.startIndex;
        int i2 = this.endIndex;
        int i4 = this.startOffset;
        int i5 = this.endOffset;
        int i6 = this.startPos;
        int i7 = this.endPos;
        int i8 = this.length;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "SegmentTreeRange{startIndex=", ", endIndex=", ", startOffset=");
        AbstractC2821a.m2235z(sbM1173s, i4, i5, ", endOffset=", ", startPos=");
        AbstractC2821a.m2235z(sbM1173s, i6, i7, ", endPos=", ", length=");
        return AbstractC2821a.m2223n(sbM1173s, "}", i8);
    }
}
