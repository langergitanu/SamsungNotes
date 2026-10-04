package com.vladsch.flexmark.util.sequence.builder;

import androidx.appcompat.widget.AbstractC0541b;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.PositionAnchor;
import com.vladsch.flexmark.util.sequence.Range;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class BasedSegmentBuilder extends SegmentBuilderBase<BasedSegmentBuilder> implements IBasedSegmentBuilder<BasedSegmentBuilder> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @NotNull
    final BasedSequence baseSeq;

    @NotNull
    final SegmentOptimizer optimizer;

    public BasedSegmentBuilder(@NotNull BasedSequence basedSequence) {
        this(basedSequence, new CharRecoveryOptimizer(PositionAnchor.CURRENT));
    }

    @NotNull
    public static BasedSegmentBuilder emptyBuilder(@NotNull BasedSequence basedSequence) {
        return new BasedSegmentBuilder(basedSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder
    @NotNull
    public BasedSequence getBaseSequence() {
        return this.baseSeq;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.SegmentBuilderBase
    public Object[] handleOverlap(@NotNull Object[] objArr) {
        Range range = (Range) objArr[0];
        CharSequence charSequence = (CharSequence) objArr[1];
        Range range2 = (Range) objArr[2];
        Range rangeM13451of = Range.NULL;
        if (range2.getEnd() > range.getStart()) {
            if (range2.getStart() <= range.getStart()) {
                Range rangeM13451of2 = Range.m13451of(range2.getStart(), Math.min(range2.getEnd(), range.getEnd()));
                if (range.getEnd() < range2.getEnd()) {
                    rangeM13451of = Range.m13451of(range.getEnd(), range2.getEnd());
                }
                range2 = rangeM13451of2;
            } else if (range2.getEnd() > range.getEnd()) {
                Range rangeWithEnd = range2.withEnd(range.getEnd());
                Range rangeWithStart = range2.withStart(range.getEnd());
                range2 = rangeWithEnd;
                rangeM13451of = rangeWithStart;
            }
        }
        range2.getSpan();
        if (charSequence.length() == 0) {
            objArr[1] = this.baseSeq.subSequence(range2.getStart(), range2.getEnd()).toString();
        } else {
            objArr[1] = AbstractC0541b.m756B(charSequence.toString(), this.baseSeq.subSequence(range2.getStart(), range2.getEnd()).toString());
        }
        objArr[2] = rangeM13451of;
        return objArr;
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.SegmentBuilderBase
    public Object[] optimizeText(@NotNull Object[] objArr) {
        return this.optimizer.apply((CharSequence) this.baseSeq, objArr);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder
    @NotNull
    public String toStringChars() {
        return super.toString(this.baseSeq);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder
    @NotNull
    public String toStringWithRanges() {
        return super.toStringWithRanges(this.baseSeq);
    }

    @Override // com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder
    @NotNull
    public String toStringWithRangesVisibleWhitespace() {
        return super.toStringWithRangesVisibleWhitespace(this.baseSeq);
    }

    public BasedSegmentBuilder(@NotNull BasedSequence basedSequence, @NotNull SegmentOptimizer segmentOptimizer) {
        this.baseSeq = basedSequence.getBaseSequence();
        this.optimizer = segmentOptimizer;
    }

    @NotNull
    public static BasedSegmentBuilder emptyBuilder(@NotNull BasedSequence basedSequence, int i) {
        return new BasedSegmentBuilder(basedSequence, i);
    }

    @NotNull
    public static BasedSegmentBuilder emptyBuilder(@NotNull BasedSequence basedSequence, @NotNull SegmentOptimizer segmentOptimizer) {
        return new BasedSegmentBuilder(basedSequence, segmentOptimizer);
    }

    @NotNull
    public static BasedSegmentBuilder emptyBuilder(@NotNull BasedSequence basedSequence, @NotNull SegmentOptimizer segmentOptimizer, int i) {
        return new BasedSegmentBuilder(basedSequence, segmentOptimizer, i);
    }

    public BasedSegmentBuilder(@NotNull BasedSequence basedSequence, int i) {
        this(basedSequence, new CharRecoveryOptimizer(PositionAnchor.CURRENT), i);
    }

    public BasedSegmentBuilder(@NotNull BasedSequence basedSequence, @NotNull SegmentOptimizer segmentOptimizer, int i) {
        super(i);
        this.baseSeq = basedSequence.getBaseSequence();
        this.optimizer = segmentOptimizer;
    }
}
