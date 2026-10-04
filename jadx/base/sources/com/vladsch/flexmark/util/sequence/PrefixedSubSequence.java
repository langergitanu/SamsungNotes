package com.vladsch.flexmark.util.sequence;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKeyBase;
import com.vladsch.flexmark.util.sequence.builder.IBasedSegmentBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class PrefixedSubSequence extends BasedSequenceImpl implements ReplacedBasedSequence {
    private final BasedSequence base;
    private final CharSequence prefix;

    private PrefixedSubSequence(CharSequence charSequence, BasedSequence basedSequence, int i, int i2) {
        super(0);
        this.prefix = charSequence;
        this.base = basedSequence.subSequence(i, i2);
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static PrefixedSubSequence m13448of(CharSequence charSequence, BasedSequence basedSequence) {
        return prefixOf(charSequence, basedSequence);
    }

    public static PrefixedSubSequence prefixOf(CharSequence charSequence, BasedSequence basedSequence) {
        return prefixOf(charSequence, basedSequence, 0, basedSequence.length());
    }

    public static PrefixedSubSequence repeatOf(CharSequence charSequence, int i, BasedSequence basedSequence) {
        return prefixOf(RepeatedSequence.repeatOf(charSequence, i).toString(), basedSequence, 0, basedSequence.length());
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    public void addSegments(@NotNull IBasedSegmentBuilder<?> iBasedSegmentBuilder) {
        if (this.prefix.length() != 0) {
            iBasedSegmentBuilder.append(this.base.getStartOffset(), this.base.getStartOffset());
            iBasedSegmentBuilder.append(this.prefix.toString());
        }
        this.base.addSegments(iBasedSegmentBuilder);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean allOptions(int i) {
        return getBaseSequence().allOptions(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedOptionsHolder
    public boolean anyOptions(int i) {
        return getBaseSequence().anyOptions(i);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequenceImpl, com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence baseSubSequence(int i, int i2) {
        return this.base.baseSubSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        SequenceUtils.validateIndex(i, length());
        int length = this.prefix.length();
        return i < length ? this.prefix.charAt(i) : this.base.charAt(i - length);
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public Object getBase() {
        return this.base.getBase();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    @NotNull
    public BasedSequence getBaseSequence() {
        return this.base.getBaseSequence();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getEndOffset() {
        return this.base.getEndOffset();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getIndexOffset(int i) {
        SequenceUtils.validateIndexInclusiveEnd(i, length());
        if (i < this.prefix.length()) {
            return -1;
        }
        return this.base.getIndexOffset(i - this.prefix.length());
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
        return this.base.getSourceRange();
    }

    @Override // com.vladsch.flexmark.util.sequence.BasedSequence
    public int getStartOffset() {
        return this.base.getStartOffset();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.base.length() + this.prefix.length();
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequenceBase, java.lang.CharSequence
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.prefix);
        this.base.appendTo(sb);
        return sb.toString();
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static PrefixedSubSequence m13449of(CharSequence charSequence, BasedSequence basedSequence, int i) {
        return prefixOf(charSequence, basedSequence, i);
    }

    public static PrefixedSubSequence prefixOf(CharSequence charSequence, BasedSequence basedSequence, int i) {
        return prefixOf(charSequence, basedSequence, i, basedSequence.length());
    }

    public static PrefixedSubSequence repeatOf(char c, int i, BasedSequence basedSequence) {
        return prefixOf(RepeatedSequence.repeatOf(c, i), basedSequence, 0, basedSequence.length());
    }

    @Deprecated
    /* JADX INFO: renamed from: of */
    public static PrefixedSubSequence m13450of(CharSequence charSequence, BasedSequence basedSequence, int i, int i2) {
        return prefixOf(charSequence, basedSequence, i, i2);
    }

    public static PrefixedSubSequence prefixOf(CharSequence charSequence, BasedSequence basedSequence, int i, int i2) {
        return new PrefixedSubSequence(charSequence, basedSequence, i, i2);
    }

    @Override // com.vladsch.flexmark.util.sequence.IRichSequence, java.lang.CharSequence
    @NotNull
    public BasedSequence subSequence(int i, int i2) {
        SequenceUtils.validateStartEnd(i, i2, length());
        int length = this.prefix.length();
        if (i >= length) {
            return this.base.subSequence(i - length, i2 - length);
        }
        if (i2 <= length) {
            return new PrefixedSubSequence(this.prefix.subSequence(i, i2), this.base.subSequence(0, 0), 0, 0);
        }
        return new PrefixedSubSequence(this.prefix.subSequence(i, length), this.base, 0, i2 - length);
    }
}
