package com.vladsch.flexmark.util.sequence.builder.tree;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BasedOffsetTracker {

    @Nullable
    private Segment lastSegment;

    @NotNull
    protected final SegmentOffsetTree segmentOffsetTree;

    @NotNull
    protected final BasedSequence sequence;

    public BasedOffsetTracker(@NotNull BasedSequence basedSequence, @NotNull SegmentTree segmentTree) {
        this.sequence = basedSequence;
        this.segmentOffsetTree = segmentTree.getSegmentOffsetTree(basedSequence.getBaseSequence());
    }

    @NotNull
    public static BasedOffsetTracker create(@NotNull BasedSequence basedSequence) {
        return new BasedOffsetTracker(basedSequence, basedSequence.getSegmentTree());
    }

    @NotNull
    public OffsetInfo getOffsetInfo(int i, boolean z) {
        int endIndex;
        int endIndex2;
        int startIndex;
        int endIndex3;
        int i2 = z ? i : i + 1;
        if (i2 <= this.sequence.getStartOffset()) {
            return new OffsetInfo(-1, i, true, 0);
        }
        if (i >= this.sequence.getEndOffset()) {
            return new OffsetInfo(this.segmentOffsetTree.size(), i, true, this.sequence.length());
        }
        Segment segmentFindSegmentByOffset = this.segmentOffsetTree.findSegmentByOffset(i, this.sequence.getBaseSequence(), this.lastSegment);
        if (segmentFindSegmentByOffset == null) {
            if (i < this.segmentOffsetTree.getSegment(0, this.sequence).getStartOffset()) {
                return new OffsetInfo(-1, i, true, 0);
            }
            SegmentOffsetTree segmentOffsetTree = this.segmentOffsetTree;
            if (i >= segmentOffsetTree.getSegment(segmentOffsetTree.size() - 1, this.sequence).getEndOffset()) {
                return new OffsetInfo(this.segmentOffsetTree.size(), i, true, this.sequence.length());
            }
            throw new IllegalStateException("Unexpected");
        }
        this.lastSegment = segmentFindSegmentByOffset;
        if (i2 > segmentFindSegmentByOffset.getStartOffset() && i < segmentFindSegmentByOffset.getEndOffset()) {
            return new OffsetInfo(segmentFindSegmentByOffset.getPos(), i, z, (segmentFindSegmentByOffset.getStartIndex() + i) - segmentFindSegmentByOffset.getStartOffset(), (segmentFindSegmentByOffset.getStartIndex() + i2) - segmentFindSegmentByOffset.getStartOffset());
        }
        if (i2 <= segmentFindSegmentByOffset.getStartOffset()) {
            Segment previousText = this.segmentOffsetTree.getPreviousText(segmentFindSegmentByOffset, this.sequence);
            if (previousText != null) {
                int startIndex2 = previousText.getStartIndex();
                endIndex3 = previousText.getEndIndex();
                startIndex = startIndex2;
            } else {
                startIndex = segmentFindSegmentByOffset.getStartIndex();
                endIndex3 = startIndex;
            }
            return new OffsetInfo(segmentFindSegmentByOffset.getPos() - 1, i, true, startIndex, endIndex3);
        }
        if (i < segmentFindSegmentByOffset.getEndOffset()) {
            throw new IllegalStateException(String.format("Unexpected offset: [%d, %d), seg: %s, not inside nor at start nor at end", Integer.valueOf(i), Integer.valueOf(i2), segmentFindSegmentByOffset.toString()));
        }
        Segment nextText = this.segmentOffsetTree.getNextText(segmentFindSegmentByOffset, this.sequence);
        if (nextText != null) {
            int startIndex3 = nextText.getStartIndex();
            endIndex2 = nextText.getEndIndex();
            endIndex = startIndex3;
        } else {
            endIndex = segmentFindSegmentByOffset.getEndIndex();
            endIndex2 = endIndex;
        }
        return new OffsetInfo(segmentFindSegmentByOffset.getPos() + 1, i, true, endIndex, endIndex2);
    }

    @NotNull
    public SegmentOffsetTree getSegmentOffsetTree() {
        return this.segmentOffsetTree;
    }

    @NotNull
    public BasedSequence getSequence() {
        return this.sequence;
    }

    public int size() {
        return this.segmentOffsetTree.size();
    }

    public String toString() {
        return "BasedOffsetTracker{tree=" + this.segmentOffsetTree + "}";
    }

    @NotNull
    public static BasedOffsetTracker create(@NotNull BasedSequence basedSequence, @NotNull SegmentOffsetTree segmentOffsetTree) {
        return new BasedOffsetTracker(basedSequence, segmentOffsetTree);
    }

    public BasedOffsetTracker(@NotNull BasedSequence basedSequence, @NotNull SegmentOffsetTree segmentOffsetTree) {
        this.sequence = basedSequence;
        this.segmentOffsetTree = segmentOffsetTree;
    }
}
