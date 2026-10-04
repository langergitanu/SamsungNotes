package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.collection.iteration.ArrayIterable;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.sequence.builder.ISegmentBuilder;
import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class SegmentedSequence extends BasedSequenceImpl implements ReplacedBasedSequence {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected final BasedSequence baseSeq;
    protected final int endOffset;
    protected final int length;
    protected final int startOffset;

    public SegmentedSequence(BasedSequence basedSequence, int i, int i2, int i4) {
        super(0);
        if (i < 0 && i2 < 0) {
            i = 0;
            i2 = 0;
        }
        this.baseSeq = basedSequence;
        this.startOffset = i;
        this.endOffset = i2;
        this.length = i4;
    }

    public static BasedSequence create(BasedSequence basedSequence, @NotNull Iterable<? extends BasedSequence> iterable) {
        return create(basedSequence.getBuilder().addAll(iterable));
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static BasedSequence m13461of(BasedSequence basedSequence, @NotNull Iterable<? extends BasedSequence> iterable) {
        return create(basedSequence, iterable);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public final boolean allOptions(int i) {
        return getBaseSequence().allOptions(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public final boolean anyOptions(int i) {
        return getBaseSequence().anyOptions(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence baseSubSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, this.baseSeq.length());
        return this.baseSeq.baseSubSequence(i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final Object getBase() {
        return this.baseSeq.getBase();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final BasedSequence getBaseSequence() {
        return this.baseSeq;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public final int getEndOffset() {
        return this.endOffset;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public final <T> T getOption(DataKeyBase<T> dataKeyBase) {
        return (T) getBaseSequence().getOption(dataKeyBase);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public final int getOptionFlags() {
        return getBaseSequence().getOptionFlags();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    @Nullable
    public final DataHolder getOptions() {
        return getBaseSequence().getOptions();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public final Range getSourceRange() {
        return Range.m13451of(getStartOffset(), getEndOffset());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public final int getStartOffset() {
        return this.startOffset;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.length;
    }

    public static BasedSequence create(BasedSequence... basedSequenceArr) {
        return basedSequenceArr.length == 0 ? BasedSequence.NULL : create(basedSequenceArr[0], new ArrayIterable(basedSequenceArr));
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static BasedSequence m13462of(BasedSequence... basedSequenceArr) {
        return create(basedSequenceArr);
    }

    public static BasedSequence create(SequenceBuilder sequenceBuilder) {
        BasedSequence singleBasedSequence = sequenceBuilder.getSingleBasedSequence();
        if (singleBasedSequence != null) {
            return singleBasedSequence;
        }
        if (!sequenceBuilder.isEmpty()) {
            BasedSequence baseSequence = sequenceBuilder.getBaseSequence();
            if (baseSequence.anyOptions(BasedOptionsHolder.F_FULL_SEGMENTED_SEQUENCES)) {
                return SegmentedSequenceFull.create(baseSequence, (ISegmentBuilder<?>) sequenceBuilder.getSegmentBuilder());
            }
            if (baseSequence.anyOptions(BasedOptionsHolder.F_TREE_SEGMENTED_SEQUENCES)) {
                return SegmentedSequenceTree.create(baseSequence, (ISegmentBuilder<?>) sequenceBuilder.getSegmentBuilder());
            }
            return SegmentedSequenceTree.create(baseSequence, (ISegmentBuilder<?>) sequenceBuilder.getSegmentBuilder());
        }
        return BasedSequence.NULL;
    }
}
