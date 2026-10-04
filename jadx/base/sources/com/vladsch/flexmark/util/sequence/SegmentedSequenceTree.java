package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
import com.vladsch.flexmark.util.sequence.builder.tree.Segment;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTree;
import com.vladsch.flexmark.util.sequence.builder.tree.SegmentTreeRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class SegmentedSequenceTree extends SegmentedSequence {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ThreadLocal<Cache> cache;
    private final int endPos;
    private final SegmentTree segmentTree;
    private final int startIndex;
    private final int startPos;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Cache {

        @NotNull
        final CharSequence chars;
        final int indexDelta;

        @NotNull
        final Segment segment;

        public Cache(@NotNull Segment segment, @NotNull CharSequence charSequence, int i) {
            this.segment = segment;
            this.chars = charSequence;
            this.indexDelta = i - segment.getStartIndex();
        }

        public char charAt(int i) {
            return this.chars.charAt(i + this.indexDelta);
        }

        public int charIndex(int i) {
            return i + this.indexDelta;
        }
    }

    private SegmentedSequenceTree(BasedSequence basedSequence, int i, int i2, int i4, @NotNull SegmentTree segmentTree) {
        super(basedSequence, i, i2, i4);
        this.cache = new ThreadLocal<>();
        this.segmentTree = segmentTree;
        this.startIndex = 0;
        this.startPos = 0;
        this.endPos = segmentTree.size();
    }

    public static SegmentedSequenceTree create(@NotNull BasedSequence basedSequence, ISegmentBuilder<?> iSegmentBuilder) {
        SegmentedSequenceStats segmentedSequenceStats;
        SegmentTree segmentTreeBuild = SegmentTree.build(iSegmentBuilder.getSegments(), iSegmentBuilder.getText());
        if (basedSequence.anyOptions(BasedOptionsHolder.F_COLLECT_SEGMENTED_STATS) && (segmentedSequenceStats = (SegmentedSequenceStats) basedSequence.getOption(BasedOptionsHolder.SEGMENTED_STATS)) != null) {
            segmentedSequenceStats.addStats(iSegmentBuilder.noAnchorsSize(), iSegmentBuilder.length(), (segmentTreeBuild.getTreeData().length * 4) + segmentTreeBuild.getSegmentBytes().length);
        }
        return new SegmentedSequenceTree(basedSequence.getBaseSequence(), iSegmentBuilder.getStartOffset(), iSegmentBuilder.getEndOffset(), iSegmentBuilder.length(), segmentTreeBuild);
    }

    @NotNull
    private Cache getCache(int i) {
        Cache cache = this.cache.get();
        if (cache != null && !cache.segment.notInSegment(this.startIndex + i)) {
            return cache;
        }
        Segment segmentFindSegment = this.segmentTree.findSegment(i + this.startIndex, this.startPos, this.endPos, this.baseSeq, cache == null ? null : cache.segment);
        Cache cache2 = new Cache(segmentFindSegment, segmentFindSegment.getCharSequence(), this.startIndex);
        this.cache.set(cache2);
        return cache2;
    }

    @Nullable
    private Segment getCachedSegment() {
        Cache cache = this.cache.get();
        if (cache == null) {
            return null;
        }
        return cache.segment;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder) {
        SegmentTree segmentTree = this.segmentTree;
        int i = this.startIndex;
        segmentTree.addSegments(iBasedSegmentBuilder, i, i + this.length, this.startOffset, this.endOffset, this.startPos, this.endPos);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        SequenceUtils.validateIndex(i, length());
        return getCache(i).charAt(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getIndexOffset(int i) {
        if (i == this.length) {
            Cache cache = getCache(i - 1);
            CharSequence charSequence = cache.chars;
            if (charSequence instanceof BasedSequence) {
                return ((BasedSequence) charSequence).getIndexOffset(cache.charIndex(i));
            }
            return -1;
        }
        SequenceUtils.validateIndexInclusiveEnd(i, length());
        Cache cache2 = getCache(i);
        CharSequence charSequence2 = cache2.chars;
        if (charSequence2 instanceof BasedSequence) {
            return ((BasedSequence) charSequence2).getIndexOffset(cache2.charIndex(i));
        }
        return -1;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public SegmentTree getSegmentTree() {
        return this.segmentTree;
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    public BasedSequence subSequence(int i, int i2) {
        if (i == 0 && i2 == this.length) {
            return this;
        }
        SequenceUtils.validateStartEnd(i, i2, length());
        SegmentTree segmentTree = this.segmentTree;
        int i4 = this.startIndex;
        return new SegmentedSequenceTree(this.baseSeq, this.segmentTree, segmentTree.getSegmentRange(i + i4, i2 + i4, this.startPos, this.endPos, this.baseSeq, getCachedSegment()));
    }

    private SegmentedSequenceTree(BasedSequence basedSequence, @NotNull SegmentTree segmentTree, @NotNull SegmentTreeRange segmentTreeRange) {
        super(basedSequence, segmentTreeRange.startOffset, segmentTreeRange.endOffset, segmentTreeRange.length);
        this.cache = new ThreadLocal<>();
        this.segmentTree = segmentTree;
        this.startIndex = segmentTreeRange.startIndex;
        this.startPos = segmentTreeRange.startPos;
        this.endPos = segmentTreeRange.endPos;
    }
}
