package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class SubSequence extends BasedSequenceImpl {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @NotNull
    private final SubSequence baseSeq;

    @NotNull
    private final CharSequence charSequence;
    private final int endOffset;
    private final int startOffset;

    private SubSequence(@NotNull CharSequence charSequence) {
        super(charSequence instanceof String ? charSequence.hashCode() : 0);
        this.baseSeq = this;
        this.charSequence = charSequence;
        this.startOffset = 0;
        this.endOffset = charSequence.length();
    }

    public static BasedSequence create(@Nullable CharSequence charSequence) {
        return charSequence == null ? BasedSequence.NULL : charSequence instanceof BasedSequence ? (BasedSequence) charSequence : new SubSequence(charSequence);
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static BasedSequence m13466of(@Nullable CharSequence charSequence) {
        return BasedSequence.m13437of(charSequence);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder) {
        iBasedSegmentBuilder.append(this.startOffset, this.endOffset);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean allOptions(int i) {
        CharSequence charSequence = this.charSequence;
        return (charSequence instanceof BasedOptionsHolder) && ((BasedOptionsHolder) charSequence).allOptions(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean anyOptions(int i) {
        CharSequence charSequence = this.charSequence;
        return (charSequence instanceof BasedOptionsHolder) && ((BasedOptionsHolder) charSequence).anyOptions(i);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        SequenceUtils.validateIndex(i, length());
        char cCharAt = this.charSequence.charAt(i + this.startOffset);
        if (cCharAt == 0) {
            return (char) 65533;
        }
        return cCharAt;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getEndOffset() {
        return this.endOffset;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getIndexOffset(int i) {
        SequenceUtils.validateIndexInclusiveEnd(i, length());
        return this.startOffset + i;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public <T> T getOption(@NotNull DataKeyBase<T> dataKeyBase) {
        CharSequence charSequence = this.charSequence;
        return charSequence instanceof BasedOptionsHolder ? (T) ((BasedOptionsHolder) charSequence).getOption(dataKeyBase) : dataKeyBase.get(null);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public int getOptionFlags() {
        CharSequence charSequence = this.charSequence;
        if (charSequence instanceof BasedOptionsHolder) {
            return ((BasedOptionsHolder) charSequence).getOptionFlags();
        }
        return 0;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    @Nullable
    public DataHolder getOptions() {
        CharSequence charSequence = this.charSequence;
        if (charSequence instanceof BasedOptionsHolder) {
            return ((BasedOptionsHolder) charSequence).getOptions();
        }
        return null;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Range getSourceRange() {
        return Range.m13451of(this.startOffset, this.endOffset);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getStartOffset() {
        return this.startOffset;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.endOffset - this.startOffset;
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static BasedSequence m13467of(@Nullable CharSequence charSequence, int i) {
        return BasedSequence.m13437of(charSequence).subSequence(i, charSequence == null ? 0 : charSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public SubSequence baseSubSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, this.baseSeq.length());
        if (i == this.startOffset && i2 == this.endOffset) {
            return this;
        }
        SubSequence subSequence = this.baseSeq;
        return subSequence != this ? subSequence.baseSubSequence(i, i2) : new SubSequence(this, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public CharSequence getBase() {
        return this.charSequence;
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public SubSequence getBaseSequence() {
        return this.baseSeq;
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static BasedSequence m13468of(@Nullable CharSequence charSequence, int i, int i2) {
        return BasedSequence.m13437of(charSequence).subSequence(i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    public SubSequence subSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, length());
        int i4 = this.startOffset;
        return baseSubSequence(i + i4, i4 + i2);
    }

    private SubSequence(@NotNull SubSequence subSequence, int i, int i2) {
        super(0);
        this.baseSeq = subSequence;
        this.charSequence = subSequence.charSequence;
        this.startOffset = i;
        this.endOffset = i2;
    }
}
