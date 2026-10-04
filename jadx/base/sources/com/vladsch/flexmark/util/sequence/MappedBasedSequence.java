package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import com.vladsch.flexmark.util.sequence.mappers.CharMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class MappedBasedSequence extends BasedSequenceImpl implements MappedSequence<BasedSequence>, ReplacedBasedSequence {
    private final BasedSequence baseSeq;
    private final CharMapper mapper;

    private MappedBasedSequence(BasedSequence basedSequence, CharMapper charMapper) {
        super(0);
        this.baseSeq = basedSequence;
        this.mapper = charMapper;
    }

    @NotNull
    public static BasedSequence mappedOf(@NotNull BasedSequence basedSequence, @NotNull CharMapper charMapper) {
        return new MappedBasedSequence(basedSequence, charMapper);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder) {
        BasedUtils.generateSegments(iBasedSegmentBuilder, this);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean allOptions(int i) {
        return getBaseSequence().allOptions(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean anyOptions(int i) {
        return getBaseSequence().anyOptions(i);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.mapper.map(this.baseSeq.charAt(i));
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Object getBase() {
        return this.baseSeq.getBase();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence getBaseSequence() {
        return this.baseSeq.getBaseSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.MappedSequence
    @NotNull
    public CharMapper getCharMapper() {
        return this.mapper;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getEndOffset() {
        return this.baseSeq.getEndOffset();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getIndexOffset(int i) {
        if (this.baseSeq.charAt(i) == charAt(i)) {
            return this.baseSeq.getIndexOffset(i);
        }
        return -1;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public <T> T getOption(DataKeyBase<T> dataKeyBase) {
        return (T) getBaseSequence().getOption(dataKeyBase);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public int getOptionFlags() {
        return getBaseSequence().getOptionFlags();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    @Nullable
    public DataHolder getOptions() {
        return getBaseSequence().getOptions();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Range getSourceRange() {
        return this.baseSeq.getSourceRange();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getStartOffset() {
        return this.baseSeq.getStartOffset();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.baseSeq.length();
    }

    @Override // com.vladsch.flexmark.util.sequence.MappedSequence
    @NotNull
    public BasedSequence getCharSequence() {
        return this.baseSeq;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public BasedSequence sequenceOf(@Nullable CharSequence charSequence, int i, int i2) {
        return charSequence instanceof MappedBasedSequence ? (i == 0 && i2 == charSequence.length()) ? (BasedSequence) charSequence : ((BasedSequence) charSequence).subSequence(i, i2).toMapped(this.mapper) : new MappedBasedSequence(this.baseSeq.sequenceOf(charSequence, i, i2), this.mapper);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.IRichSequence
    @NotNull
    public BasedSequence toMapped(CharMapper charMapper) {
        return charMapper == CharMapper.IDENTITY ? this : new MappedBasedSequence(this.baseSeq, this.mapper.andThen(charMapper));
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    public BasedSequence subSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, length());
        return (i == 0 && i2 == this.baseSeq.length()) ? this : new MappedBasedSequence(this.baseSeq.subSequence(i, i2), this.mapper);
    }
}
