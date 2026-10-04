package com.vladsch.flexmark.util.sequence.builder.tree;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.misc.DelimitedBuilder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.BasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.Seg;
import com.vladsch.flexmark.util.sequence.builder.tree.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SegmentTree {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int F_ANCHOR_FLAGS = -536870912;
    public static final int MAX_VALUE = 536870911;
    protected final byte[] segmentBytes;
    protected final int[] treeData;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SegmentTreeData {

        @NotNull
        public final byte[] segmentBytes;

        @Nullable
        public final int[] startIndices;

        @NotNull
        public final int[] treeData;

        public SegmentTreeData(@NotNull int[] iArr, @NotNull byte[] bArr, @Nullable int[] iArr2) {
            this.treeData = iArr;
            this.segmentBytes = bArr;
            this.startIndices = iArr2;
        }
    }

    public SegmentTree(int[] iArr, byte[] bArr) {
        this.treeData = iArr;
        this.segmentBytes = bArr;
    }

    @NotNull
    public static SegmentTree build(@NotNull Iterable<Seg> iterable, @NotNull CharSequence charSequence) {
        SegmentTreeData segmentTreeDataBuildTreeData = buildTreeData(iterable, charSequence, true);
        return new SegmentTree(segmentTreeDataBuildTreeData.treeData, segmentTreeDataBuildTreeData.segmentBytes);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SegmentTreeData buildTreeData(@NotNull Iterable<Seg> iterable, @NotNull CharSequence charSequence, boolean z) {
        int i = 0;
        int segByteLength = 0;
        int end = 0;
        for (Seg seg : iterable) {
            Segment.SegType segType = Segment.getSegType(seg, charSequence);
            segByteLength += Segment.getSegByteLength(segType, seg.getSegStart(), seg.length());
            if (z) {
                if (segType != Segment.SegType.ANCHOR) {
                    i++;
                }
            } else if (segType == Segment.SegType.BASE || segType == Segment.SegType.ANCHOR) {
            }
            end = seg.getEnd();
        }
        int[] iArr = new int[i * 2];
        byte[] bArr = new byte[segByteLength];
        int[] iArr2 = z ? null : new int[i];
        int[] iArr3 = z ? null : new int[2];
        int i2 = 0;
        int i4 = 0;
        int length = 0;
        int i5 = 0;
        int i6 = -1;
        for (Seg seg2 : iterable) {
            int iAddSegBytes = Segment.addSegBytes(bArr, i2, seg2, charSequence);
            Segment.SegType segTypeFromTypeMask = Segment.SegType.fromTypeMask(bArr[i2]);
            if (!z) {
                iArr2[i4] = length;
                if (i5 > 0 && seg2.getStart() >= 0) {
                    for (int i7 = 0; i7 < i5; i7++) {
                        iArr[iArr3[i7] << 1] = seg2.getStart();
                    }
                    i5 = 0;
                }
                length += seg2.length();
                if (segTypeFromTypeMask == Segment.SegType.BASE || segTypeFromTypeMask == Segment.SegType.ANCHOR) {
                    setTreeData(i4, iArr, seg2.getEnd(), i2, 0);
                    iArr3[i5] = i4;
                    i4++;
                    i5++;
                }
                i2 = iAddSegBytes;
            } else if (segTypeFromTypeMask == Segment.SegType.ANCHOR) {
                i6 = i2;
            } else {
                length += seg2.length();
                setTreeData(i4, iArr, length, i2, i6 == -1 ? 0 : i2 - i6);
                i4++;
                i6 = -1;
            }
            i2 = iAddSegBytes;
        }
        if (!z) {
            for (int i8 = 0; i8 < i5; i8++) {
                iArr[iArr3[i8] << 1] = end;
            }
        }
        return new SegmentTreeData(iArr, bArr, iArr2);
    }

    public static int getAnchorOffset(int i) {
        return (i & F_ANCHOR_FLAGS) >>> 29;
    }

    public static int getByteOffset(int i) {
        int i2 = i & MAX_VALUE;
        if (i2 == 536870911) {
            return -1;
        }
        return i2;
    }

    @NotNull
    public static CharSequence getCharSequence(@NotNull Segment segment, int i, int i2, int i4, int i5) {
        int i6 = segment.pos;
        return (i6 == i4 && i6 + 1 == i5) ? segment.getCharSequence().subSequence(i - segment.getStartIndex(), i2 - segment.getStartIndex()) : i6 == i4 ? segment.getCharSequence().subSequence(i - segment.getStartIndex(), segment.length()) : i6 + 1 == i5 ? segment.getCharSequence().subSequence(0, i2 - segment.getStartIndex()) : segment.getCharSequence();
    }

    public static void setTreeData(int i, int[] iArr, int i2, int i4, int i5) {
        int i6 = i << 1;
        iArr[i6] = i2;
        iArr[i6 + 1] = (i5 == 0 ? 0 : i5 << 29) | i4;
    }

    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder, @NotNull SegmentTreeRange segmentTreeRange) {
        addSegments(iBasedSegmentBuilder, segmentTreeRange.startIndex, segmentTreeRange.endIndex, segmentTreeRange.startOffset, segmentTreeRange.endOffset, segmentTreeRange.startPos, segmentTreeRange.endPos);
    }

    public int aggrLength(int i) {
        if (i < 0) {
            return 0;
        }
        return this.treeData[i << 1];
    }

    public int byteOffset(int i) {
        return getByteOffset(this.treeData[(i << 1) + 1]);
    }

    public int byteOffsetData(int i) {
        return this.treeData[(i << 1) + 1];
    }

    @Nullable
    public Segment findSegment(int i, @NotNull BasedSequence basedSequence, @Nullable Segment segment) {
        return findSegment(i, 0, size(), basedSequence, segment);
    }

    @Nullable
    public SegmentTreePos findSegmentPos(int i) {
        return findSegmentPos(i, this.treeData, 0, size());
    }

    @Nullable
    public Segment getPrevAnchor(int i, @NotNull BasedSequence basedSequence) {
        return getPrevAnchor(i, this.treeData, this.segmentBytes, basedSequence);
    }

    @NotNull
    public Segment getSegment(int i, int i2, int i4, @NotNull BasedSequence basedSequence) {
        return Segment.getSegment(this.segmentBytes, i, i2, i4, basedSequence);
    }

    public byte[] getSegmentBytes() {
        return this.segmentBytes;
    }

    @NotNull
    public SegmentOffsetTree getSegmentOffsetTree(@NotNull BasedSequence basedSequence) {
        int length = this.segmentBytes.length;
        int byteLength = 0;
        int i = 0;
        int endOffset = 0;
        while (byteLength < length) {
            Segment segment = Segment.getSegment(this.segmentBytes, byteLength, i, 0, basedSequence);
            byteLength += segment.getByteLength();
            if (segment.isBase()) {
                i++;
                endOffset = segment.getEndOffset();
            }
        }
        int[] iArr = new int[i * 2];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[2];
        int byteLength2 = 0;
        int length2 = 0;
        int i2 = 0;
        int i4 = 0;
        while (byteLength2 < length) {
            Segment segment2 = Segment.getSegment(this.segmentBytes, byteLength2, i, length2, basedSequence);
            if (i2 > 0 && segment2.getStartOffset() >= 0) {
                for (int i5 = 0; i5 < i2; i5++) {
                    iArr[iArr3[i5] << 1] = segment2.getStartOffset();
                }
                i2 = 0;
            }
            if (segment2.isBase()) {
                setTreeData(i4, iArr, segment2.getEndOffset(), byteLength2, 0);
                iArr3[i2] = i4;
                iArr2[i4] = length2;
                i4++;
                i2++;
            }
            byteLength2 += segment2.getByteLength();
            length2 += segment2.length();
        }
        for (int i6 = 0; i6 < i2; i6++) {
            iArr[iArr3[i6] << 1] = endOffset;
        }
        return new SegmentOffsetTree(iArr, this.segmentBytes, iArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d8 A[PHI: r11
      0x00d8: PHI (r11v8 int) = (r11v7 int), (r11v23 int), (r11v23 int), (r11v24 int) binds: [B:52:0x00ba, B:56:0x00d2, B:58:0x00d5, B:59:0x00d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0116  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SegmentTreeRange getSegmentRange(int i, int i2, int i4, int i5, @NotNull BasedSequence basedSequence, @Nullable Segment segment) {
        BasedSequence basedSequence2;
        int i6;
        Segment segmentFindSegment;
        SegmentTree segmentTree;
        Segment segment2;
        Segment segmentFindSegment2;
        int textStartOffset;
        int i7;
        int i8;
        int i9;
        Segment segment3;
        Segment segmentFindSegment3;
        Segment segmentFindSegment4;
        if (i == i2) {
            if (segment == null || segment.notInSegment(i)) {
                i8 = i4;
                i9 = i5;
                basedSequence2 = basedSequence;
                segment3 = segment;
                segmentFindSegment3 = findSegment(i, i8, i9, basedSequence2, segment3);
                i6 = i;
            } else {
                i8 = i4;
                i9 = i5;
                basedSequence2 = basedSequence;
                segment3 = segment;
                i6 = i;
                segmentFindSegment3 = segment3;
            }
            if (segmentFindSegment3 == null) {
                if (segment3 == null || segment3.notInSegment(i6 - 1)) {
                    segmentTree = this;
                    segmentFindSegment4 = segmentTree.findSegment(i6 - 1, i8, i9, basedSequence2, segment3);
                } else {
                    segmentTree = this;
                    segmentFindSegment4 = segment3;
                }
                if (!segmentFindSegment4.notInSegment(i6) || segmentFindSegment4.pos + 1 >= size()) {
                    segmentFindSegment3 = segmentFindSegment4;
                } else {
                    segmentFindSegment3 = getSegment(segmentFindSegment4.pos + 1, basedSequence2);
                    if (segmentFindSegment3.notInSegment(i6)) {
                    }
                }
                textStartOffset = segment2.isText() ? getTextStartOffset(segment2, basedSequence2) : (segment2.getStartOffset() + i6) - segment2.getStartIndex();
                int textEndOffset = segmentFindSegment2.isText() ? getTextEndOffset(segmentFindSegment2, basedSequence2) : (segmentFindSegment2.getStartOffset() + i2) - segmentFindSegment2.getStartIndex();
                if (textStartOffset >= 0) {
                    i7 = textStartOffset;
                } else if (segment2.pos + 1 < size()) {
                    textStartOffset = getSegment(segment2.pos + 1, basedSequence2).getStartOffset();
                    if (textStartOffset > textEndOffset && textEndOffset != -1) {
                        textStartOffset = textEndOffset;
                    }
                    i7 = textStartOffset;
                } else {
                    i7 = textEndOffset;
                }
                int i10 = textEndOffset < i7 ? i7 : textEndOffset;
                if (i7 > basedSequence2.length()) {
                    throw new IllegalStateException(String.format("startOffset:%d > baseSeq.length: %d", Integer.valueOf(i7), Integer.valueOf(basedSequence2.length())));
                }
                if (i10 <= basedSequence2.length()) {
                    return new SegmentTreeRange(i6, i2, i7, i10, segment2.pos, segmentFindSegment2.pos + 1);
                }
                throw new IllegalStateException(String.format("endOffset:%d > baseSeq.length: %d", Integer.valueOf(i10), Integer.valueOf(basedSequence2.length())));
            }
            segmentTree = this;
            segmentFindSegment2 = segmentFindSegment3;
            segment2 = segmentFindSegment2;
        } else {
            basedSequence2 = basedSequence;
            i6 = i;
            if (segment == null || segment.notInSegment(i6)) {
                segmentFindSegment = findSegment(i6, i4, i5, basedSequence2, segment);
                i6 = i6;
            } else {
                segmentFindSegment = segment;
            }
            int i11 = i2 - 1;
            if (!segmentFindSegment.notInSegment(i11)) {
                segmentFindSegment2 = segmentFindSegment;
                segment2 = segmentFindSegment2;
            } else if (segment == null || segment.notInSegment(i11)) {
                segmentTree = this;
                segment2 = segmentFindSegment;
                segmentFindSegment2 = segmentTree.findSegment(i11, i4, i5, basedSequence2, segment2);
            } else {
                segmentFindSegment2 = segment;
                segment2 = segmentFindSegment;
            }
            if (segment2.isText()) {
            }
            if (segmentFindSegment2.isText()) {
            }
            if (textStartOffset >= 0) {
            }
            if (textEndOffset < i7) {
            }
            if (i7 > basedSequence2.length()) {
            }
        }
        if (segment2.isText()) {
        }
        if (segmentFindSegment2.isText()) {
        }
        if (textStartOffset >= 0) {
        }
        if (textEndOffset < i7) {
        }
        if (i7 > basedSequence2.length()) {
        }
    }

    public int getTextEndOffset(Segment segment, @NotNull BasedSequence basedSequence) {
        if (segment.pos + 1 >= size()) {
            return -1;
        }
        Segment segment2 = getSegment(segment.pos + 1, basedSequence);
        if (segment2.isBase()) {
            return segment2.getStartOffset();
        }
        return -1;
    }

    public int getTextStartOffset(Segment segment, @NotNull BasedSequence basedSequence) {
        int i;
        Segment prevAnchor = getPrevAnchor(segment.pos, basedSequence);
        if (prevAnchor == null && (i = segment.pos) > 0) {
            prevAnchor = getSegment(i - 1, basedSequence);
        }
        if (prevAnchor == null || !prevAnchor.isBase()) {
            return -1;
        }
        return prevAnchor.getEndOffset();
    }

    public int[] getTreeData() {
        return this.treeData;
    }

    public boolean hasPreviousAnchor(int i) {
        return getAnchorOffset(this.treeData[(i << 1) + 1]) > 0;
    }

    public int previousAnchorOffset(int i) {
        int iByteOffsetData = byteOffsetData(i);
        return getByteOffset(iByteOffsetData) - getAnchorOffset(iByteOffsetData);
    }

    public int size() {
        return this.treeData.length / 2;
    }

    @NotNull
    public String toString(@NotNull BasedSequence basedSequence) {
        DelimitedBuilder delimitedBuilder = new DelimitedBuilder(SQLKeyword.COMMA);
        delimitedBuilder.append(getClass().getSimpleName()).append("{aggr: {");
        int size = size();
        for (int i = 0; i < size; i++) {
            delimitedBuilder.append("[").append(aggrLength(i)).append(SQLKeyword.COMMA).append(byteOffset(i)).append(":");
            if (hasPreviousAnchor(i)) {
                delimitedBuilder.append(SQLKeyword.COMMA).append(previousAnchorOffset(i)).append(":");
            }
            delimitedBuilder.append("]").mark();
        }
        delimitedBuilder.unmark().append(" }, seg: { ");
        int byteLength = 0;
        while (true) {
            byte[] bArr = this.segmentBytes;
            if (byteLength >= bArr.length) {
                delimitedBuilder.unmark().append(" } }");
                return delimitedBuilder.toString();
            }
            Segment segment = Segment.getSegment(bArr, byteLength, 0, 0, basedSequence);
            delimitedBuilder.append(byteLength).append(":").append(segment).mark();
            byteLength += segment.getByteLength();
        }
    }

    public static int aggrLength(int i, int[] iArr) {
        if (i < 0) {
            return 0;
        }
        return iArr[i << 1];
    }

    public static int byteOffset(int i, int[] iArr) {
        return getByteOffset(byteOffsetData(i, iArr));
    }

    public static int byteOffsetData(int i, int[] iArr) {
        return iArr[(i << 1) + 1];
    }

    @Nullable
    public static Segment getPrevAnchor(int i, int[] iArr, byte[] bArr, @NotNull BasedSequence basedSequence) {
        int iByteOffsetData = byteOffsetData(i, iArr);
        int anchorOffset = getAnchorOffset(iByteOffsetData);
        if (anchorOffset > 0) {
            return Segment.getSegment(bArr, getByteOffset(iByteOffsetData) - anchorOffset, -1, 0, basedSequence);
        }
        return null;
    }

    public static boolean hasPreviousAnchor(int i, int[] iArr) {
        return getAnchorOffset(iArr[(i << 1) + 1]) > 0;
    }

    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder, int i, int i2, int i4, int i5, int i6, int i7) {
        int i8;
        Segment prevAnchor;
        if (i4 != -1) {
            iBasedSegmentBuilder.appendAnchor(i4);
        }
        BasedSequence baseSequence = iBasedSegmentBuilder.getBaseSequence();
        for (int i9 = i6; i9 < i7; i9++) {
            Segment segment = getSegment(i9, baseSequence);
            if (segment.isText() && (prevAnchor = getPrevAnchor(i9, baseSequence)) != null) {
                iBasedSegmentBuilder.appendAnchor(prevAnchor.getStartOffset());
            }
            CharSequence charSequence = getCharSequence(segment, i, i2, i6, i7);
            if (segment.isText()) {
                iBasedSegmentBuilder.append(charSequence);
                int byteLength = segment.getByteLength() + segment.byteOffset;
                if (byteLength < this.segmentBytes.length && ((i8 = i9 + 1) >= size() || byteLength != byteOffset(i8))) {
                    Segment segment2 = Segment.getSegment(this.segmentBytes, byteLength, 0, 0, baseSequence);
                    if (segment2.isAnchor()) {
                        iBasedSegmentBuilder.appendAnchor(segment2.getStartOffset());
                    }
                }
            } else {
                BasedSequence basedSequence = (BasedSequence) charSequence;
                i4 = Math.max(i4, basedSequence.getEndOffset());
                iBasedSegmentBuilder.append(basedSequence.getStartOffset(), basedSequence.getEndOffset());
            }
        }
        if (i5 != -1) {
            iBasedSegmentBuilder.appendAnchor(Math.max(i4, i5));
        }
    }

    @Nullable
    public Segment findSegment(int i, int i2, int i4, @NotNull BasedSequence basedSequence, @Nullable Segment segment) {
        int i5;
        if (segment != null) {
            if (i >= segment.getStartIndex()) {
                int endIndex = segment.getEndIndex();
                int i6 = segment.pos;
                if (i6 + 1 >= i4) {
                    return null;
                }
                if (i < aggrLength(i6 + 1)) {
                    return Segment.getSegment(this.segmentBytes, byteOffset(segment.pos + 1), segment.pos + 1, endIndex, basedSequence);
                }
                i2 = segment.pos + 2;
            } else {
                int i7 = segment.pos;
                if (i7 == i2) {
                    return null;
                }
                int iAggrLength = aggrLength(i7 - 2);
                if (i >= iAggrLength) {
                    return Segment.getSegment(this.segmentBytes, byteOffset(segment.pos - 1), segment.pos - 1, iAggrLength, basedSequence);
                }
                i4 = segment.pos - 1;
            }
        }
        if (i2 < 0 || i2 >= size()) {
            int i8 = i4;
            i5 = i2;
            i2 = i8;
        } else if (i < aggrLength(i2)) {
            int iAggrLength2 = aggrLength(i2 - 1);
            if (i >= iAggrLength2) {
                return Segment.getSegment(this.segmentBytes, byteOffset(i2), i2, iAggrLength2, basedSequence);
            }
            i5 = i2;
        } else {
            i2++;
            int i82 = i4;
            i5 = i2;
            i2 = i82;
        }
        int i9 = i2 - 1;
        if (i9 >= i5) {
            int iAggrLength3 = aggrLength(i2 - 2);
            if (i >= iAggrLength3) {
                if (i >= aggrLength(i9)) {
                    return null;
                }
                return Segment.getSegment(this.segmentBytes, byteOffset(i9), i9, iAggrLength3, basedSequence);
            }
            i2 = i9;
        }
        SegmentTreePos segmentTreePosFindSegmentPos = findSegmentPos(i, i5, i2);
        if (segmentTreePosFindSegmentPos != null) {
            return Segment.getSegment(this.segmentBytes, byteOffset(segmentTreePosFindSegmentPos.pos), segmentTreePosFindSegmentPos.pos, segmentTreePosFindSegmentPos.startIndex, basedSequence);
        }
        return null;
    }

    @Nullable
    public SegmentTreePos findSegmentPos(int i, int i2, int i4) {
        return findSegmentPos(i, this.treeData, i2, i4);
    }

    @NotNull
    public Segment getSegment(int i, @NotNull BasedSequence basedSequence) {
        return Segment.getSegment(this.segmentBytes, byteOffset(i), i, aggrLength(i - 1), basedSequence);
    }

    @NotNull
    public static SegmentTree build(@NotNull BasedSegmentBuilder basedSegmentBuilder) {
        SegmentTreeData segmentTreeDataBuildTreeData = buildTreeData(basedSegmentBuilder.getSegments(), basedSegmentBuilder.getText(), true);
        return new SegmentTree(segmentTreeDataBuildTreeData.treeData, segmentTreeDataBuildTreeData.segmentBytes);
    }

    @Nullable
    public static SegmentTreePos findSegmentPos(int i, int[] iArr, int i2, int i4) {
        int i5 = 0;
        if (i == 0 && i2 == 0) {
            return new SegmentTreePos(0, 0, 0);
        }
        while (i2 < i4) {
            int i6 = (i2 + i4) >> 1;
            i5++;
            if (i >= aggrLength(i6, iArr)) {
                i2 = i6 + 1;
            } else {
                int iAggrLength = aggrLength(i6 - 1, iArr);
                if (i >= iAggrLength) {
                    return new SegmentTreePos(i6, iAggrLength, i5);
                }
                i4 = i6;
            }
        }
        return null;
    }

    @NotNull
    public static Segment getSegment(int i, int[] iArr, byte[] bArr, @NotNull BasedSequence basedSequence) {
        return Segment.getSegment(bArr, byteOffset(i, iArr), i, aggrLength(i, iArr), basedSequence);
    }

    public static int previousAnchorOffset(int i, int[] iArr) {
        int iByteOffsetData = byteOffsetData(i, iArr);
        return getByteOffset(iByteOffsetData) - getAnchorOffset(iByteOffsetData);
    }

    @NotNull
    public String toString() {
        return toString(BasedSequence.NULL);
    }

    @Nullable
    public static Segment findSegment(int i, int[] iArr, int i2, int i4, byte[] bArr, @NotNull BasedSequence basedSequence) {
        SegmentTreePos segmentTreePosFindSegmentPos = findSegmentPos(i, iArr, i2, i4);
        if (segmentTreePosFindSegmentPos != null) {
            return Segment.getSegment(bArr, byteOffset(segmentTreePosFindSegmentPos.pos, iArr), segmentTreePosFindSegmentPos.pos, segmentTreePosFindSegmentPos.startIndex, basedSequence);
        }
        return null;
    }
}
