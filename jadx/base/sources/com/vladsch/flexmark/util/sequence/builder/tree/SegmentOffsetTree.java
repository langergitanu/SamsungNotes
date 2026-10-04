package com.vladsch.flexmark.util.sequence.builder.tree;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.misc.DelimitedBuilder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.BasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.Seg;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SegmentOffsetTree extends SegmentTree {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @NotNull
    protected final int[] startIndices;

    public SegmentOffsetTree(@NotNull int[] iArr, @NotNull byte[] bArr, @NotNull int[] iArr2) {
        super(iArr, bArr);
        this.startIndices = iArr2;
    }

    @NotNull
    public static SegmentOffsetTree build(@NotNull Iterable<Seg> iterable, @NotNull CharSequence charSequence) {
        SegmentTree.SegmentTreeData segmentTreeDataBuildTreeData = SegmentTree.buildTreeData(iterable, charSequence, false);
        return new SegmentOffsetTree(segmentTreeDataBuildTreeData.treeData, segmentTreeDataBuildTreeData.segmentBytes, segmentTreeDataBuildTreeData.startIndices);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder, @NotNull SegmentTreeRange segmentTreeRange) {
        throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    public int aggrLength(int i) {
        return super.aggrLength(i);
    }

    public int endOffset(int i) {
        return super.aggrLength(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    @Nullable
    public Segment findSegment(int i, @NotNull BasedSequence basedSequence, @Nullable Segment segment) {
        throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
    }

    @Nullable
    public Segment findSegmentByOffset(int i, @NotNull BasedSequence basedSequence, @Nullable Segment segment) {
        SegmentTreePos segmentTreePosFindSegmentPos = super.findSegmentPos(i, 0, size());
        if (segmentTreePosFindSegmentPos == null) {
            return null;
        }
        byte[] bArr = this.segmentBytes;
        int iByteOffset = byteOffset(segmentTreePosFindSegmentPos.pos);
        int i2 = segmentTreePosFindSegmentPos.pos;
        return Segment.getSegment(bArr, iByteOffset, i2, this.startIndices[i2], basedSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    @Nullable
    public SegmentTreePos findSegmentPos(int i) {
        throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
    }

    @Nullable
    public SegmentTreePos findSegmentPosByOffset(int i) {
        return SegmentTree.findSegmentPos(i, this.treeData, 0, size());
    }

    @Nullable
    public Segment getNextText(@NotNull Segment segment, @NotNull BasedSequence basedSequence) {
        if (segment.getByteLength() + segment.getByteOffset() >= this.segmentBytes.length) {
            return null;
        }
        Segment segment2 = getSegment(segment.getByteLength() + segment.getByteOffset(), -1, segment.getEndIndex(), basedSequence);
        if (segment2.isText()) {
            return segment2;
        }
        return null;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    @Nullable
    public Segment getPrevAnchor(int i, @NotNull BasedSequence basedSequence) {
        throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
    }

    @Nullable
    public Segment getPreviousText(@NotNull Segment segment, @NotNull BasedSequence basedSequence) {
        if (segment.getPos() != 0) {
            return getNextText(getSegment(segment.getPos() - 1, basedSequence), basedSequence);
        }
        if (segment.getStartIndex() <= 0) {
            return null;
        }
        Segment segment2 = getSegment(0, -1, 0, basedSequence);
        if (segment2.isText()) {
            return segment2;
        }
        return null;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @NotNull
    public Segment getSegment(int i, @NotNull BasedSequence basedSequence) {
        return Segment.getSegment(this.segmentBytes, byteOffset(i), i, this.startIndices[i], basedSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    @NotNull
    public SegmentTreeRange getSegmentRange(int i, int i2, int i4, int i5, @NotNull BasedSequence basedSequence, @Nullable Segment segment) {
        return super.getSegmentRange(i, i2, i4, i5, basedSequence, segment);
    }

    public int getStartIndex(int i) {
        if (i < 0) {
            return 0;
        }
        int[] iArr = this.startIndices;
        return i >= iArr.length ? iArr[iArr.length - 1] : iArr[i];
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    public boolean hasPreviousAnchor(int i) {
        return false;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    public int previousAnchorOffset(int i) {
        return 0;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @NotNull
    public String toString(@NotNull BasedSequence basedSequence) {
        DelimitedBuilder delimitedBuilder = new DelimitedBuilder(SQLKeyword.COMMA);
        delimitedBuilder.append(getClass().getSimpleName()).append("{aggr: {");
        int size = size();
        for (int i = 0; i < size; i++) {
            delimitedBuilder.append("[").append(aggrLength(i)).append(SQLKeyword.COMMA).append(byteOffset(i)).append(":");
            delimitedBuilder.append(", :").append(this.startIndices[i]);
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

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder, int i, int i2, int i4, int i5, int i6, int i7) {
        throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    @Nullable
    public Segment findSegment(int i, int i2, int i4, @NotNull BasedSequence basedSequence, @Nullable Segment segment) {
        throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree
    @Deprecated
    @Nullable
    public SegmentTreePos findSegmentPos(int i, int i2, int i4) {
        throw new IllegalStateException("Method in SegmentOffsetTree should not be used");
    }

    @NotNull
    public static SegmentOffsetTree build(@NotNull BasedSegmentBuilder basedSegmentBuilder) {
        SegmentTree.SegmentTreeData segmentTreeDataBuildTreeData = SegmentTree.buildTreeData(basedSegmentBuilder.getSegments(), basedSegmentBuilder.getText(), true);
        return new SegmentTree(segmentTreeDataBuildTreeData.treeData, segmentTreeDataBuildTreeData.segmentBytes).getSegmentOffsetTree(basedSegmentBuilder.getBaseSequence());
    }

    @NotNull
    public static SegmentOffsetTree build(@NotNull BasedSequence basedSequence) {
        return basedSequence.getSegmentTree().getSegmentOffsetTree(basedSequence);
    }
}
